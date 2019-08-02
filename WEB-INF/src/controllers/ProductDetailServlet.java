package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

import java.util.*;

import models.*;

public class ProductDetailServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		

		int productId = Integer.parseInt(request.getParameter("pro_id"));
		
		Product product = new Product(productId);
		product.getProductDetails();

		ArrayList<String> productPicPaths = ProductPic.collectProductPics(productId,true);

		request.setAttribute("product",product);		
		request.setAttribute("product_pic_paths",productPicPaths);		
		
		RequestDispatcher view = request.getRequestDispatcher("product_details.jsp");
		view.forward(request,response);
	}
}
