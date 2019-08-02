package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.FileItem;

import java.util.*;

import models.*;

public class ProductPicUploadServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		User user = (User)session.getAttribute("user");
		ArrayList<String> productPics = (ArrayList)session.getAttribute("product_pics");
		
		if(ServletFileUpload.isMultipartContent(request)){
			DiskFileItemFactory	factory = new DiskFileItemFactory();
			ServletFileUpload sfu = new ServletFileUpload(factory);

			List<FileItem> fileItems = null;
			try{
				fileItems = sfu.parseRequest(request);
			}catch(FileUploadException e){
				e.printStackTrace();
			}
			
			Iterator<FileItem> itr = fileItems.iterator();
			while(itr.hasNext()){
				FileItem fileItem = itr.next();

				if(!fileItem.isFormField()){
					Product product = (Product)session.getAttribute("product");
					String picFolder = getServletContext().getRealPath("/WEB-INF/uploads/"+user.getEmail()+"/"+product.getProduct());
					File file = new File(picFolder,fileItem.getName());
					
					try{
						fileItem.write(file);
						
						productPics.add(user.getEmail()+"/"+product.getProduct()+"/"+fileItem.getName());
					}catch (Exception e){
						e.printStackTrace();
					}					
				}
			}

		}else{
			
		}	

		request.getRequestDispatcher("product_pic_upload_form.jsp").forward(request,response);
	}
}