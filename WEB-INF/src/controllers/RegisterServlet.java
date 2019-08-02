package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import java.util.regex.*;
import java.util.*;
import utils.*;

import models.User;

public class RegisterServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		//Handle Request
		HttpSession session = request.getSession();
				
		String userName = request.getParameter("user_name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String rePassword = request.getParameter("repassword");

		//validation
		boolean flag = true;
		String msg = "";
		
		/*
		int uNLen = userName.trim().length();
		if(uNLen<2||uNLen>50){
			flag = false;
			msg = msg + "<div>Invalid User Name...</div>";
		}

		String pw = password.trim();
		Pattern p = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{8,10}");
		Matcher m = p.matcher(pw);
		if(!m.matches()){
			flag = false;
			msg = msg + "Minimum eight and maximum 10 characters, at least one uppercase letter, one lowercase letter, one number and one special character";
		}

		String em = email.trim();
		Pattern p1 = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?");
		Matcher m2 = p1.matcher(em);
		if(!m2.matches()){
			flag = false;
			msg = msg + "Must be a valid email";
		}*/
		/*
		int emLen = email.trim().length();
		if(emLen<7||emLen>60){
			flag = false;
			msg = msg + "<div>Invalid Email...</div>";
		}*/
		
		/*
		int pwLen = password.trim().length();
		if(pwLen<6||pwLen>12){
			flag = false;
			msg = msg + "<div>Invalid Password...</div>";
		}*/
		
		/*
		if(!password.equals(rePassword)){
			flag = false;
			msg = msg + "<div>Password and Repassword must match...</div>";
		}*/

		
		if(flag){
			//Deligate request to model class User
			long verfCode = new Random().nextLong();
			verfCode = verfCode<0?verfCode*(-1):verfCode;
			String actCode = Long.toString(verfCode);
			User user = new User(userName,email,password,actCode);
			if(user.registerUser()){
				String realPath = getServletContext().getRealPath("/WEB-INF/uploads");
				System.out.println("#########"+realPath);
				File file = new File(realPath,email);
				file.mkdir();
				//String verfMsg = EmailFormats.getEmailVerificationMessage(userName,email,actCode);
				//EmailSender.sendEmail(email,verfMsg);
				request.setAttribute("msg_suc","Registered Successfully... We sent you a verfication email. Please check your inbox.");
			}else{
				request.setAttribute("msg_err","Duplicate Email...");
			}
		}else{
			request.setAttribute("msg_err",msg);
		}		
		
		//Forward Request to Jsp Page
		RequestDispatcher view = request.getRequestDispatcher("register_login.jsp");
		view.forward(request,response);
	}
}