package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

import java.util.*;

import models.*;

public class ProductPicServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		String proId = request.getParameter("pro_id");	

		InputStream is = null;
		ArrayList<String> productPicPaths = null;
		if(proId!=null){
			int productId = Integer.parseInt(proId);		
			productPicPaths = ProductPic.collectProductPics(productId,false); 
			is = getServletContext().getResourceAsStream("/WEB-INF/uploads/"+productPicPaths.get(0));
		}else{
			String picPath = request.getParameter("pic_path");
			is = getServletContext().getResourceAsStream("/WEB-INF/uploads/"+picPath);
		}		

		ServletOutputStream sos = response.getOutputStream();
		byte[] arr = new byte[1024];

		int c = 0;

		while((c=is.read(arr))!=-1){
			sos.write(arr);
		}

		sos.flush();
		sos.close();		
	}
}
