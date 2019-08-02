package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

import java.util.*;
import models.*;

import org.json.*;

public class SearchServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		
		String input = request.getParameter("input");

		ArrayList<ProductSub_> productTitles = Product.searchProduct(input);
		
		JSONArray ja = new JSONArray();
		
		Iterator<ProductSub_> itr = productTitles.iterator();
		int i = 0;
		while(itr.hasNext()){
			ProductSub_ proSub = itr.next();

			JSONObject jo = new JSONObject();
			try{
				jo.put("pro_id",proSub.getProductId());
				jo.put("pro_title",proSub.getProduct());

				ja.put(i++,jo);
			}catch(JSONException e){
				e.printStackTrace();
			}	
		}		

		response.getWriter().write(ja.toString());
	}
}
