package models;

import java.sql.Date;

public class Cart{
	private Integer cartId;
	private User user;
	private Date cartDate;
	private Integer items;
	private Float cartAmount;
	private Status status;

		public void setCartId(Integer cartId){
			this.cartId = cart_id;
		}

		public Integer getCartId(){
			return cartId;
		}

		public void setUser(User user){
			this.user = user;
		}

		public User getUser(){
			return user;
		}

		public void setCartDate(Date cartDate){
			this.cartDate = cartDate;
		}

		public Date getCartDate(){
			return cartDate;
		}

		public void setItems(Integer items){
			this.items = items;
		}

		public Integer getItems(){
			return items;
		}

		public void setCartAmount(Float cartAmount){
			this.cartAmount = cartAmount;
		}

		public Float getCartAmount(){
			return cartAmount;
		}
		
		public void setStatus(Status status){
			this.status = status;
		}

		public Status getStatus(){
			return status;
		}
}