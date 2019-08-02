package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import models.User;

public class ShowSellFormServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		String nextPage = "register_login.jsp";

		User user = (User)session.getAttribute("user");
		
		if(user!=null){
			nextPage = "sell_form.jsp";
		}
		

		request.getRequestDispatcher(nextPage).forward(request,response);
	}
}