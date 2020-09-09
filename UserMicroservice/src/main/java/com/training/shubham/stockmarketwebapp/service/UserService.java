package com.training.shubham.stockmarketwebapp.service;

import com.training.shubham.stockmarketwebapp.dto.UserRequestModel;
import com.training.shubham.stockmarketwebapp.dto.UserResponseModel;


public interface UserService {

	public UserResponseModel getUserByUserName(String userName);

	public UserResponseModel createNewUser(UserRequestModel userRequestModel);

}
