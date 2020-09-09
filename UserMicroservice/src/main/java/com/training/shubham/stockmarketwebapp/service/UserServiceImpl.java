package com.training.shubham.stockmarketwebapp.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.shubham.stockmarketwebapp.dto.UserRequestModel;
import com.training.shubham.stockmarketwebapp.dto.UserResponseModel;
import com.training.shubham.stockmarketwebapp.entity.UserEntity;
import com.training.shubham.stockmarketwebapp.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
		super();
		this.userRepository = userRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	@Transactional
	public UserResponseModel getUserByUserName(String userName) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper.map(userRepository.findByUserName(userName), UserResponseModel.class);
	}

	@Override
	@Transactional
	public UserResponseModel createNewUser(UserRequestModel userRequestModel) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity user = modelMapper.map(userRequestModel, UserEntity.class);
		userRepository.save(user);
		return modelMapper.map(userRequestModel, UserResponseModel.class);
	}
	
}
