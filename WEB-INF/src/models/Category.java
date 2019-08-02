package models;

import java.sql.*;
import java.util.*;

public class Category
{
	private Integer categoryId;
	private String category;
	private Integer product;

	public Category(){
	
	}

	public Category(Integer categoryId,String category){
		this.categoryId = categoryId;
		this.category = category;
	}

	public Category(Integer categoryId){
		this.categoryId = categoryId;
	}


	public static ArrayList<Category> collectCategories(){
		ArrayList<Category> categories = new ArrayList<Category>();
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eshop?user=root&password=krishna");
			
			String query = "select category_id,category from categories";
			PreparedStatement p = con.prepareStatement(query);
			ResultSet rs = p.executeQuery();

			while(rs.next()){
				categories.add(new Category(rs.getInt(1),rs.getString(2)));
			}

			con.close();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}	

		return categories;
	}

	public void setCategoryId(Integer categoryId){
		this.categoryId = categoryId;
	}

	public Integer getCategoryId(){
		return categoryId;
	}

	public void setCategory(String category){
		this.category = category;
	}

	public String getCategory(){
		return category;
	}

	public void setProduct(Integer product){
		this.product = product;
	}

	public Integer getProduct(){
		return product;
	}



}