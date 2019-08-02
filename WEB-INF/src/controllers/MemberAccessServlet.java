package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class MemberAccessServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		RequestDispatcher view = request.getRequestDispatcher("register_login.jsp");
		view.forward(request,response);
	}
}
