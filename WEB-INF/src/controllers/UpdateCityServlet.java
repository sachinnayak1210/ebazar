package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

import models.*;

public class UpdateCityServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		String result = "three";

		if(user!=null){
			int cityId = Integer.parseInt(request.getParameter("city_id"));	
				
			if(user.updateCity(cityId)){
				result = "one";
				user.setCity(new City(cityId));
			}else{
				result = "two";
			}
		}
		
		response.getWriter().write(result);
	}
}
