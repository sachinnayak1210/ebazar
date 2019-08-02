package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import models.User;

public class LoginServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		String nextPage = "register_login.jsp";

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		User user = new User(email,password);
		if(user.loginUser()){
			user.setPassword(null);
			session.setAttribute("user",user);
			//nextPage = "profile.jsp";
			nextPage = "dashboard.jsp";
		}

		RequestDispatcher view = request.getRequestDispatcher(nextPage);
		view.forward(request,response);
	}
}