package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

import models.User;

public class UpdateUserNameServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");

		String userName = request.getParameter("unm");
		String result = "no";

		if(user.updateUserName(userName)){
			result = "yes";
			user.setUserName(userName);
		}		
		
		response.getWriter().write(result);
	}
}
