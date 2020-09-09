package com.training.shubham.stockmarketwebapp.dto;

public class UserRequestModel {

	private Long id;

	private String userName;
	
	private String password;
	
	private String userType;
	 
	private String email;
	
	private String mobileNumber;
	
	private boolean confirmed;

	public UserRequestModel() {
		super();
	}

	public UserRequestModel(Long id, String userName, String password, String userType, String email,
			String mobileNumber, boolean confirmed) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.userType = userType;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.confirmed = confirmed;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public boolean isConfirmed() {
		return confirmed;
	}

	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}
	
	
}
