package models;

import java.sql.*;

public class Category
{
	private Integer categoryId;
	private String category;
	private Integer product;

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