package models;

import java.sql.*;
import java.util.*;

public class Product{
	//################# Properties #########################
	private Integer productId;
	private String product;
	private User user;
	private Timestamp addedOn;
	private Integer quantity;
	public Integer mrp;
	private Integer gst;
	private Integer discount;
	private Category category;
	private String description;
	private Float rating;
	private Integer quantityLeft;
	

	//################# Constructors #########################
	public Product(Integer productId){
		this.productId = productId;
	}

	public Product(Integer productId,String product,Integer mrp,Integer discount){
		this.productId = productId;
		this.product = product;
		this.mrp = mrp;
		this.discount = discount;
	}
	
	public Product(Integer productId,String product,Timestamp addedOn,Integer quantity,Integer mrp,Integer gst,Integer discount,Category category,String description,Float rating,Integer quantityLeft,User user){
		this.productId = productId;
		this.product = product;
		this.addedOn = addedOn;
		this.quantity = quantity;
		this.mrp = mrp;
		this.gst = gst;
		this.discount = discount;
		this.category = category;
		this.description = description;
		this.rating = rating;
		this.quantityLeft = quantityLeft;
		this.user = user;
	}

	public Product(String product,User user,Integer quantity,Integer mrp,Integer gst,Integer discount,Category category,String description){
		this.product = product;
		this.user = user;
		this.quantity = quantity;
		this.mrp = mrp;
		this.gst = gst;
		this.discount = discount;
		this.category = category;
		this.description = description;
	}



	//################# Other Mothods #########################
	public static ArrayList<Product> collectProducts(ArrayList<Integer> cart){
		ArrayList<Product> products = new ArrayList<Product>();
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eshop?user=root&password=krishna");
			
			String in = "";
			Iterator<Integer> itr = cart.iterator();
			while(itr.hasNext()){
				in = in + itr.next()+",";
			}

			in = in.substring(0,in.length()-1);

			String q1 = "select product_id,product,mrp,discount ";
			String q2 = " from products where product_id in ("+in+")";
			PreparedStatement pst = con.prepareStatement(q1+q2);			
			
			ResultSet rs = pst.executeQuery();		
			
			while(rs.next()){
				products.add(new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4)));
			}

			con.close();
		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}
		
		return products;	
	}


	public void getProductDetails(){
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eshop?user=root&password=krishna");
			
			String q1 = "select product,added_on,quantity,mrp,gst,discount,";
			String q2 = "category_id,description,rating,qt_left,p.user_id,user_name,email from products as p inner join users as u where";
			String q3 = " product_id=? and p.user_id=u.user_id";
			PreparedStatement pst = con.prepareStatement(q1+q2+q3);

			pst.setInt(1,productId);

			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				product = rs.getString(1);
				addedOn = rs.getTimestamp(2);
				quantity = rs.getInt(3);
				mrp = rs.getInt(4);
				gst = rs.getInt(5);
				discount = rs.getInt(6);
				category = new Category(rs.getInt(7));
				description = rs.getString(8);
				rating = rs.getFloat(9);
				quantityLeft = rs.getInt(10);

				user = new User(rs.getInt(11),rs.getString(12),rs.getString(13));
			}

			con.close();
		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}	
	}


	
	public static ArrayList<ProductSub_> searchProduct(String input){
		ArrayList<ProductSub_> productTitles = new ArrayList<ProductSub_>();

		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eshop?user=root&password=krishna");
			
			String query = "select product_id,product from products where product like '%"+input+"%'";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				productTitles.add(new ProductSub_(rs.getInt(1),rs.getString(2)));
			}

			con.close();
		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}
		
		return productTitles;
	}

	public static ArrayList<Product> collectProducts(User user){
		ArrayList<Product> products = new ArrayList<Product>();
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eshop?user=root&password=krishna");
			
			String q1 = "select product_id,product,added_on,quantity,mrp,gst,discount,";
			String q2 = "category_id,description,rating,qt_left from products where";
			String q3 = " user_id=? order by added_on desc";
			PreparedStatement pst = con.prepareStatement(q1+q2+q3);

			pst.setInt(1,user.getUserId());

			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				products.add(new Product(rs.getInt(1),rs.getString(2),rs.getTimestamp(3),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),new Category(rs.getInt(8)),rs.getString(9),rs.getFloat(10),rs.getInt(11),user));
			}

			con.close();
		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}
		
		return products;	
	}


	public boolean saveProduct(){
		boolean flag = false;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eshop?user=root&password=krishna");
		
			String query = "insert into products (product,user_id,quantity,mrp,gst,discount,category_id,description,qt_left) value (?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			
			pst.setString(1,product);
			pst.setInt(2,user.getUserId());
			pst.setInt(3,quantity);
			pst.setInt(4,mrp);
			pst.setInt(5,gst);
			pst.setInt(6,discount);
			pst.setInt(7,category.getCategoryId());
			pst.setString(8,description);
			pst.setInt(9,quantity);

			int res = pst.executeUpdate();
			if(res==1){
				ResultSet rs = pst.getGeneratedKeys();

				if(rs.next()){
					productId = rs.getInt(1);
				}

				flag = true;
			}

			con.close();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}

		return flag;
	}



	//################# Getter-Setters #########################
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

	public void setAddedOn(Timestamp addedOn){
		this.addedOn = addedOn;
	}

	public Timestamp getAddedOn(){
		return addedOn;
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

	public void setRating(Float rating){
		this.rating = rating;
	}

	public Float getRating(){
		return rating;
	}

	public void setQuantityLeft(Integer quantityLeft){
		this.quantityLeft = quantityLeft;
	}

	public Integer getQuantityLeft(){
		return quantityLeft;
	}


}