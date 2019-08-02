package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

import models.User;

public class UpdatePasswordServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");

		String oldPass = request.getParameter("opass");
		String newPass = request.getParameter("npass");
		String rePass = request.getParameter("repass");
		
		String result = "no";

		//validation
		
		///////////////////
		if(user.checkPassword(oldPass)){
			if(user.updatePassword(newPass)){
				result = "yes";
			}
		}
		
		response.getWriter().write(result);
	}
}
