package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

import java.util.*;
import models.*;

public class AddToCartServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		User user = (User)session.getAttribute("user");
		
		ArrayList<Integer> cart = (ArrayList)session.getAttribute("cart");
		
		if(cart==null){
			cart = new ArrayList<Integer>();
			session.setAttribute("cart",cart);
		}

		int proId = Integer.parseInt(request.getParameter("pro_id"));
		cart.add(proId);
		
		response.getWriter().write(Integer.toString(cart.size()));
	}
}
