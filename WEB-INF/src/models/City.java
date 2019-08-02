package models;

import java.sql.*;
import java.util.*;

public class City
{
	private Integer cityId;
	private String city;
	private State state;

	public City(Integer cityId){
		this.cityId = cityId;
	}

	public City(Integer cityId,String city){
		this.cityId = cityId;
		this.city = city;
	}


	public static ArrayList<City> collectCities(int stateId){
		ArrayList<City> cities = new ArrayList<City>();
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eshop?user=root&password=krishna");
			
			String query = "select city_id,city from cities where state_id=? order by city";
			PreparedStatement p = con.prepareStatement(query);
			p.setInt(1,stateId);
			ResultSet rs = p.executeQuery();

			while(rs.next()){
				cities.add(new City(rs.getInt(1),rs.getString(2)));
			}

			con.close();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}	

		return cities;
	}


	public void setCityId(Integer cityId){
		this.cityId = cityId;
	}

	public Integer getCityId(){
		return cityId;
	}

	public void setCity(String city){
		this.city = city;
	}

	public String getCity(){
		return city;
	}

	public void setState(State state){
		this.state = state;
	}

	public State getState(){
		return state;
	}



}