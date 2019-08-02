package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

import models.*;
import java.util.*;

public class CheckoutServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		User user = (User)session.getAttribute("user");
		//ArrayList<Integer> cart = (ArrayList)session.getAttribute("cart");

		int grandTotal = Integer.parseInt(request.getParameter("grand_total"));

		String[] proIds = request.getParameterValues("pro_id");
		String[] qts = request.getParameterValues("qt");

		Cart cart = new Cart(user,proIds.length,(float)grandTotal);
		cart.saveCart();

		if(cart.getCartId()!=null){
			CartItem.saveCartItems(cart.getCartId(),proIds,qts);
		}else{
		
		}	
		
		RequestDispatcher view = request.getRequestDispatcher("register_login.jsp");
		view.forward(request,response);
	}
}
