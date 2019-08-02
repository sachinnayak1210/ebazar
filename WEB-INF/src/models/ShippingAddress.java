package models;

import java.sql.*;

public class ShippingAddress
{
	private Integer shippingAddressId;
	private User userId;
	private String housePlotFlatNo;
	private String streetLane;
	private String landmark;
	private City cityId;
	private String pincode;

	public void setShippingAddressId(Integer shiipingAddressId){
		this.shippingAddressId = shippingAddressId;
	}

	public Integer getShippingAddressId(){
		return shippingAddressId;
	}

	public void setHousePlotFlatNo(String HouseplotFlatNo){
		this.housePlotFlatNo = housePlotFlatNo;
	}

	public String getHousePlotFlatNo(){
		return housePlotFlatNo;
	}

	public void setStreetLane(String streetLane){
		this.streetLane = streetLane;
	}

	public String getStreetLane(){
		return streetLane;
	}

	public void setLandmark(String landmark){
		this.landmark = landmark;
	}

	public String landmark(){
		return landmark;
	}

	public void setCityId(City cityId){
		this.cityId = cityId;
	}

	public City getCityId(){
		return cityId;
	}

	public void setPincode(String pincode){
		this.pincode = pincode;
	}

	public String getPincode(){
		return pincode;
	}
}