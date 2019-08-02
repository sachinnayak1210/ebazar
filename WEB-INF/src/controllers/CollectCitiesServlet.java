package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.*;
import models.City;
import org.json.*;

public class CollectCitiesServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		int stateId = Integer.parseInt(request.getParameter("state_id"));

		ArrayList<City> cities = City.collectCities(stateId);
		
		JSONArray ja = new JSONArray();
		int i = 0;
		for(City city : cities){
			JSONObject jo = new JSONObject();
			jo.put("cityid",city.getCityId());
			jo.put("citynm",city.getCity());

			ja.put(i++,jo);
		}

		response.getWriter().write(ja.toString());
	}
}
