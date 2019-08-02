package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import java.util.List;

import models.User;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;

public class PicUploadServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		
		User user = (User)session.getAttribute("user");
		
		String nextPage = "register_login.jsp";

		if(user!=null){
			if(ServletFileUpload.isMultipartContent(request)){
				DiskFileItemFactory dfif = new DiskFileItemFactory();
				ServletFileUpload sfu = new ServletFileUpload(dfif);
				
				List<FileItem> list = null;
				try{
					list = sfu.parseRequest(request);
				}catch(FileUploadException e){
					e.printStackTrace();
				}

				FileItem fi	= list.get(0);

				String fileName = fi.getName();

				String realPath = getServletContext().getRealPath("/WEB-INF/uploads/"+user.getEmail());
				System.out.println(realPath);

				File file = new File(realPath,fileName);

				try{
					fi.write(file);
					if(user.updateProfilePic(fileName)){
						user.setProfilePic(fileName);
					}

					nextPage = "profile.jsp";
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}

		request.getRequestDispatcher(nextPage).forward(request,response);
	} 
}
