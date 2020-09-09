package com.training.shubham.stockmarketwebapp.dto;

public class UserAuthenticationResponseModel {
	
	private String jwt;

	public UserAuthenticationResponseModel() {
		
	}

	public UserAuthenticationResponseModel(String jwt) {
		super();
		this.jwt = jwt;
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	
}
