package models;

import java.sql.*;

public class CartItem
{
	private Integer cartItemId;
	private Cart cart;
	private Product product;
	private Integer quantity;

	public static void saveCartItems(Integer cartId,String[] proIds,String[] qts){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eshop?user=root&password=krishna");

			String q = "insert into cart_items (cart_id,product_id,quantity) value (?,?,?)";
			PreparedStatement ps = con.prepareStatement(q);
			ps.setInt(1,cartId);

			for(int i=0;i<proIds.length;i++){
				ps.setInt(2,Integer.parseInt(proIds[i]));
				ps.setInt(3,Integer.parseInt(qts[i]));

				ps.executeUpdate();
			}

			con.close();
		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}
	}

	public void setCartItemId(Integer cartItemId){
		this.cartItemId = cartItemId;
	}

	public Integer getCartItemId(){
		return cartItemId;
	}

	public void setCart(Cart cart){
		this.cart = cart;
	}

	public Cart getCart(){
		return cart;
	}

	public void setProduct(Product product){
		this.product = product;
	}

	public Product getProduct(){
		return product;
	}

	public void setQuantity(Integer quantity){
		this.quantity = quantity;
	}

	public Integer getQuantity(){
		return quantity;
	}
}