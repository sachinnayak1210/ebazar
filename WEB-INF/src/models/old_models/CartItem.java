package models;

import java.sql.*;

public class CartItem
{
	private Integer cartItemID;
	private Cart cartId;
	private Product productId;
	private Integer quantity;

	public void setCartItemId(Integer cartItemId){
		this.cartItemId = cartItemId;
	}

	public Integer getCartItemId(){
		return cartItemId;
	}

	public void setCartId(Cart cartId){
		this.cartId = cartId;
	}

	public Cart getCartId(){
		return cartId;
	}

	public void setProductId(Product productId){
		this.productId = productId;
	}

	public Product getProduct(){
		return productId;
	}

	public void setQuantity(Integer quantity){
		this.quantity = quantity;
	}

	public Integer getQuantity(){
		return quantity;
	}
}