package models;

import java.sql.*;

import org.jasypt.util.password.StrongPasswordEncryptor;

public class User{
	//######## Properties ###################
	private Integer userId;
	private String userName;
	private String email;
	private String password;
	private String contact;
	private String address;
	private City city;
	private String aadharNumber;
	private String profilePic;
	private Status status;
	private UserType userType;
	private String verificationCode;

	//######## Constructors #################
	public User(){
		
	}

	public User(String userName,String email,String password,String verificationCode){
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.verificationCode = verificationCode;
	}

	public User(String email,String password){
		super();
		this.email = email;
		this.password = password;
	}

	//######## Other Methods ################
	public boolean updateProfilePic(String profilePic){
		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eshop?user=root&password=krishna");
			
			String query = "update users set profile_pic=? where email=?";
			PreparedStatement pst = con.prepareStatement(query);

			pst.setString(1,profilePic);
			pst.setString(2,email);

			int res = pst.executeUpdate();

			if(res==1){
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



	public static boolean verifyUser(String email,String verificationCode){
		boolean flag = false;
		
		try{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eshop?user=root&password=krishna");
	
	String query = "update users set status_id=? where email=? and verification_code=? and status_id=?";
	PreparedStatement ps = con.prepareStatement(query);


	ps.setInt(1,Status.ACTIVE);
	ps.setString(2,email);
	ps.setString(3,verificationCode);
	ps.setInt(4,Status.INACTIVE);

	int res = ps.executeUpdate();
			if(res==1){
				flag = true;
			}

			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}	

		return flag;
	}


	public boolean loginUser(){
		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eshop?user=root&password=krishna");
			
			String q1 = "select password,user_id,user_name,contact,address,aadhar_number,";
			String q2 = "profile_pic from users where email=?";

			PreparedStatement pst = con.prepareStatement(q1+q2);
			pst.setString(1,email);

			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				String encPass = rs.getString(1);
				
				StrongPasswordEncryptor spe = new StrongPasswordEncryptor();
				if(spe.checkPassword(password,encPass)){
					userId = rs.getInt(2);
					userName = rs.getString(3);
					contact = rs.getString(4);
					address = rs.getString(5);
					aadharNumber = rs.getString(6);
					profilePic = rs.getString(7);
					
					flag = true;
				}
			}

			con.close();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}

		return flag;
	}


	public boolean registerUser(){
		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eshop?user=root&password=krishna");
			
			String query = "insert into users (user_name,email,password,verification_code) value (?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);

			pst.setString(1,userName);
			pst.setString(2,email);
			StrongPasswordEncryptor spe = new StrongPasswordEncryptor();
			String encPass = spe.encryptPassword(password);
			pst.setString(3,encPass);
		
			pst.setString(4,verificationCode);
			
			int res = pst.executeUpdate();
			if(res==1){
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
//getter setter methods
	public void setUserName(String userName){
		this.userName = userName;
	}

	public String getUserName(){
		return userName;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setContact(String contact){
		this.contact = contact;
	}

	public String getContact(){
		return 	contact;
	}

	public void setAddress(String address){
		this.address = address;
	}

	public String getAddress(){
		return address;
	}

	public void setCity(City city){
		this.city = city;
	}

	public City getCity(){
		return city;
	}

	public void setAadharNumber(String aadharNumber){
		this.aadharNumber = aadharNumber;
	}

	public String getAadharNumber(){
		return aadharNumber;
	}

	public void setProfilePic(String profilePic){
		this.profilePic = profilePic;
	}

	public String getProfilePic(){
		return profilePic;
	}

	public void setStatus(Status Status){
		this.status = status;
	}

	public Status getStatus(){
		return status;
	}
	public void setUserType(UserType userType){
		this.userType = userType;
	}

	public UserType getUserType(){
		return userType;
	}

	public void setVerificationCode(String verificationCode){
		this.verificationCode = verificationCode;
	}

	public String geVerificationCode(){
		return verificationCode;
	}

}