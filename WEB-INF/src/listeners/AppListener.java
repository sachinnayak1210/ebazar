package listeners;

import javax.servlet.*;

import java.util.*;
import models.*;

public class AppListener implements ServletContextListener{
	public void contextInitialized(ServletContextEvent e){
		ArrayList<State> states = State.collectStates();
		e.getServletContext().setAttribute("states",states);

		ArrayList<Category> categories = Category.collectCategories();
		e.getServletContext().setAttribute("categories",categories);	
	}

	public void contextDestroyed(ServletContextEvent e){
		
	}
}