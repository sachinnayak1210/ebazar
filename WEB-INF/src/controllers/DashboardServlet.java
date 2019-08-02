package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import models.*;

import java.util.*;

public class DashboardServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		User user = (User)session.getAttribute("user");
		
		String nextPage = "register_login.jsp";

		if(user!=null){
			ArrayList<Product> products = Product.collectProducts(user);	
			request.setAttribute("products",products);

			nextPage = "dashboard.jsp";
		}
		
		
		RequestDispatcher view = request.getRequestDispatcher(nextPage);
		view.forward(request,response);
	}
}
