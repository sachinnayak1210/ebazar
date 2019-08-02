package models;

import java.sql.*;


public class City
{
	private Integer cityId;
	private String city;
	private State state;

	public void setCityId(Integer cityId){
		this.cityId = cityId;
	}

	public Integer getCityId(){
		return cityId;
	}

	public void setCity(String city){
		this.city = city;
	}

	public String getcity(){
		return city;
	}

	public void setState(State state){
		this.state = state;
	}

	public State getState(){
		return state;
	}



}