package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

import java.util.*;

import models.User;

public class DeleteProductPicServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		User user = (User)session.getAttribute("user");

		String msg = "session_out";

		if(user!=null){
			int index = Integer.parseInt(request.getParameter("index"));

			ArrayList<String> productPics = (ArrayList)session.getAttribute("product_pics");

			String realPath = getServletContext().getRealPath("/WEB-INF/uploads/"+productPics.get(index));

			File f = new File(realPath);
			f.delete();

			productPics.set(index,null);	

			msg = "success";
		}

		response.getWriter().write(msg);
	}
}
