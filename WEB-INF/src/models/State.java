package models;

import java.sql.*;
import java.util.*;

public class State
{
	private Integer stateId;
	private String state;

	public State(){
	
	}

	public State(Integer stateId,String state){
		this.stateId = stateId;
		this.state = state;
	}

	public static ArrayList<State> collectStates(){
		ArrayList<State> states = new ArrayList<State>();
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eshop?user=root&password=krishna");
			
			String query = "select state_id,state from states where country_id=101 order by state";
			PreparedStatement p = con.prepareStatement(query);
			ResultSet rs = p.executeQuery();

			while(rs.next()){
				states.add(new State(rs.getInt(1),rs.getString(2)));
			}

			con.close();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}	

		return states;
	}

	public void setStateId(Integer stateId){
		this.stateId = stateId;
	}
	public Integer getStateId(){
		return stateId;
	}

	public void setState(String state){
		this.state = state;
	}

	public String getState(){
		return state;
	}
}