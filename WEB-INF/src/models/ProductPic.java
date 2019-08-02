package models;

import java.sql.*;
import java.util.*;

public class ProductPic
{
	private Integer productPicId;
	private Product product;
	private String picPath;
	private Status statusId;

	public ProductPic(){
	
	}

	public ProductPic(Product product){
		this.product = product;
	}
	
	//boolean flag -> true, says collect all images, or only one image
	public static ArrayList<String> collectProductPics(Integer productId,boolean flag){
		ArrayList<String> productPicPaths = new ArrayList<String>();

		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eshop?user=root&password=krishna");
			
			String q1 = "select pic_path from product_pics where product_id=?";
			String q2 = " limit 1";
			PreparedStatement ps = con.prepareStatement(q1+(flag?"":q2));

			ps.setInt(1,productId);
			
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				productPicPaths.add(rs.getString(1));
			}			

			con.close();
		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}

		return productPicPaths;
	}

	/*
	public void getPic(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eshop?user=root&password=krishna");
			
			String query = "select pic_path from product_pics where product_id=? limit 1";
			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1,product.getProductId());
			
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				picPath = rs.getString(1);
			}			

			con.close();
		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}
	}*/

	public static void saveProductPics(ArrayList<String> productPics,Integer productId){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eshop?user=root&password=krishna");
			
			String query = "insert into product_pics (product_id,pic_path) value (?,?)";
			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1,productId);

			for(String str : productPics){
				if(str!=null){
					ps.setString(2,str);
					ps.executeUpdate();
				}				
			}

			con.close();
		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}
	}

	public void setProductPicId(Integer productPicId){
		this.productPicId = productPicId;
	}

	public Integer getProductPicId(){
		return productPicId;
	}

	public void setProduct(Product product){
		this.product = product;
	}

	public Product getProduct(){
		return product;
	}

	public void setpicPath(String picPath){
		this.picPath = picPath;
	}

	public String getPicPath(){
		return picPath;
	}

	public void setStatusId(Status statusId){
		this.statusId = statusId;
	}

	public Status getStatusId(){
		return statusId;
	}

}