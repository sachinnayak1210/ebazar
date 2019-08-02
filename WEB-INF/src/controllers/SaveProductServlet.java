package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

import models.*;

public class SaveProductServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		User user = (User)session.getAttribute("user");
		
		String nextPage = "sell_form.jsp";
		
		if(user!=null){
			String productTitle = request.getParameter("product_name");
			String categoryId = request.getParameter("category_id");
			String quantity = request.getParameter("quantity");
			String mrp = request.getParameter("mrp");
			String gst = request.getParameter("gst");
			String discount = request.getParameter("discount");
			String description = request.getParameter("description");
			
			//##### validation ######

			
			//##### deligate to model class ######
			Product product = new Product(productTitle,user,Integer.parseInt(quantity),Integer.parseInt(mrp),Integer.parseInt(gst),Integer.parseInt(discount),new Category(Integer.parseInt(categoryId)),description);
			if(product.saveProduct()){
				String realPath = getServletContext().getRealPath("/WEB-INF/uploads/"+user.getEmail());
				File file = new File(realPath,productTitle);
				file.mkdir();
				session.setAttribute("product",product);

				ArrayList<String> productPics = new ArrayList<String>();
				session.setAttribute("product_pics",productPics);

				nextPage = "product_pic_upload_form.jsp";
			}

		}else{
			nextPage = "login.jsp";
		}
		
		request.getRequestDispatcher(nextPage).forward(request,response);
	}
}