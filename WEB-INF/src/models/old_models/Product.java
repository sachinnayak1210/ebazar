package models;

import java.sql.*;

public class Product
{
	private Integer productId;
	private String product;
	private User user;
	private Date addedOn;
	private Integer quantity;
	public Integer mrp;
	private Integer gst;
	private Integer discount;
	private Category category;
	private String desciption;
	private Integer rating;
	private Integer quantityLeft;

	public void setProductId(Integer productId){
		this.productId = productId;
	}

	public Integer getProductId(){
		return productId;
	}

	public void setProduct(String product){
		this.product = product;
	}

	public String getProduct(){
		return product;
	}

	public void setUser(User user){
		this.user = user;
	}

	public User getUser(){
		return user;
	}

	public void setAddedOn(Date addedOn){
		this.addedOn = addedon;
	}

	public Date getAddedOn(){
		return addedon;
	}

	public void setQuantity(Integer quantity){
		this.quantity = quantity;
	}

	public Integer getQuantity(){
		return quantity;
	}

	public void setMrp(Integer mrp){
		this.mrp = mrp;
	}

	public Integer getMrp(){
		return mrp;
	}

	public void setGst(Integer gst){
		this.gst = gst;
	}

	public Integer getGst(){
		return gst;
	}

	public void setDiscount(Integer discount){
		this.discount = discount;
	}

	public Integer getDiscount(){
		return discount;
	}

	public void setCategory(Category category){
		this.category = category;
	}

	public Category getCategory(){
		return category;
	}

	public void setDescription(String description){
		this.description  = description;
	}

	public String getDescription(){
		return description;
	}

	public void setRating(Integer rating){
		this.rating = rating;
	}

	public Integer getRating(){
		return rating;
	}

	public void setQuantityLeft(Integer rating){
		this.quantityLeft = quantityLeft;
	}

	public Integer getQuantityLeft(){
		return quanitityLeft;
	}


}