package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.*;

import models.*;

public class SaveProductPicsServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		User user = (User)session.getAttribute("user");

		String nextPage = "register_login.jsp";

		if(user!=null){
			ArrayList<String> productPics = (ArrayList)session.getAttribute("product_pics");
			Product product = (Product)session.getAttribute("product");

			ProductPic.saveProductPics(productPics,product.getProductId());

			nextPage = "dashboard.do";
		}
	
		RequestDispatcher view = request.getRequestDispatcher(nextPage);
		view.forward(request,response);
	}
}
