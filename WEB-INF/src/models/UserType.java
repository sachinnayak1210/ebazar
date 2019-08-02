package models;

import java.sql.*;

public class UserType
{
	private Integer userTypeId;
	private String userType;

	public void setUserTypeId(Integer userTypeId){
		this.userTypeId = userTypeId;
	}

	public Integer getUserTypeId(){
		return userTypeId;
	}

	public void setUserType(String userType){
		this.userType = userType;
	}

	public String getuserType(){
		return userType;
	}


}