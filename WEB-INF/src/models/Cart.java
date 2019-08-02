package models;

import java.sql.*;

public class Cart{
	private Integer cartId;
	private User user;
	private Date cartDate;
	private Integer items;
	private Float cartAmount;
	private Status status;

	public Cart(){
	
	}

	public Cart(User user,Integer items,Float cartAmount){
		this.user = user;
		this.items = items;
		this.cartAmount = cartAmount;
	}

	public void saveCart(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eshop?user=root&password=krishna");
			
			String q = "insert into carts (user_id,items,cart_amount) value (?,?,?)";
			PreparedStatement ps = con.prepareStatement(q,Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1,user.getUserId());
			ps.setInt(2,items);
			ps.setFloat(3,cartAmount);

			int res = ps.executeUpdate();

			if(res==1){
				ResultSet rs = ps.getGeneratedKeys();

				if(rs.next()){
					cartId = rs.getInt(1);
				}
			}
 
			con.close();
		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}
	}

	public void setCartId(Integer cartId){
		this.cartId = cartId;
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