package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import models.*;

import java.util.*;

public class StreamPicServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		
		User user = (User)session.getAttribute("user");
		Product product = (Product)session.getAttribute("product");

		String nextPage = "register_login.jsp";
		String picPath = request.getParameter("picPath");
		if(user!=null){
			InputStream is = getServletContext().getResourceAsStream("/WEB-INF/uploads/"+picPath);	
			ServletOutputStream os = response.getOutputStream();

			byte[] x = new byte[1024];
			
			int count = 0;
			while((count=is.read(x))!=-1){
				os.write(x);
			}

			os.flush();
			os.close();
		}		

		//request.getRequestDispatcher(nextPage).forward(request,response);
	}
}