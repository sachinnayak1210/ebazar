package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import models.User;

public class VerificationServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		String nextPage = "register_login.jsp";

		String email = request.getParameter("email");
		String verfCode = request.getParameter("verification_code");

		if(User.verifyUser(email,verfCode)){
			request.setAttribute("msg_suc","Email Verification Successfull");
		}else{
			request.setAttribute("msg_err","Email Verification failed");
		}

		RequestDispatcher view = request.getRequestDispatcher(nextPage);
		view.forward(request,response);
	}
}