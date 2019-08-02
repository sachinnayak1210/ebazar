package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.*;

import models.*;

public class ShowCartServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		User user = (User)session.getAttribute("user");

		String nextPage = "register_login.jsp";

		if(user!=null){
			ArrayList<Integer> cart = (ArrayList)session.getAttribute("cart");
			ArrayList<Product> products = Product.collectProducts(cart);
			request.setAttribute("cart_records",products);
			nextPage = "show_cart.jsp";
		}
		
		RequestDispatcher view = request.getRequestDispatcher(nextPage);
		view.forward(request,response);
	}
}
