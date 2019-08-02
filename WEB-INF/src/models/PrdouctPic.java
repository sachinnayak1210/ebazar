package models;

import java.sql.*;

public class ProductPic
{
	private Integer productPidId;
	private Product productId;
	private String picPath;
	private Status statusId;

	public void setProductPicId(Integer productPicId){
		this.productPicid = productPicId;
	}

	public Integer getProductPicId(){
		return productPicId;
	}

	public void setProductId(Product productId){
		this.productId = productId;
	}

	public Product getProductId(){
		return productId;
	}

	public void setpicPath(String picPath){
		this.PicPath = picPath;
	}

	public String getPicPath(){
		return picPath;
	}

	public void setStatusId(Status statusId){
		this.statusId = statusId;
	}

	public Status getStatusId(){
		return statusID;
	}

}