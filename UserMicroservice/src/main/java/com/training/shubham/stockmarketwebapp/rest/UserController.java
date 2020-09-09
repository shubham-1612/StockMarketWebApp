package com.training.shubham.stockmarketwebapp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.shubham.stockmarketwebapp.config.JwtUtil;
import com.training.shubham.stockmarketwebapp.dto.UserAuthenticationRequestModel;
import com.training.shubham.stockmarketwebapp.dto.UserAuthenticationResponseModel;
import com.training.shubham.stockmarketwebapp.dto.UserRequestModel;
import com.training.shubham.stockmarketwebapp.dto.UserResponseModel;
import com.training.shubham.stockmarketwebapp.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtil jwtTokenUtil;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("/{userName}")
	public ResponseEntity<UserResponseModel> getUserByUserName(@PathVariable("userName") String userName){
		return new ResponseEntity<UserResponseModel>(userService.getUserByUserName(userName), HttpStatus.FOUND);
	}
	
	@PostMapping("/")
	public ResponseEntity<UserResponseModel> createNewUser(@RequestBody UserRequestModel userRequestModel){
		return new ResponseEntity<UserResponseModel>(userService.createNewUser(userRequestModel), HttpStatus.CREATED);
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<UserAuthenticationResponseModel> createAuthenticationToken(@RequestBody UserAuthenticationRequestModel userAuthenticationRequestModel) throws Exception{
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userAuthenticationRequestModel.getUsername(), userAuthenticationRequestModel.getPassword()));
		}
		catch(BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(userAuthenticationRequestModel.getUsername());
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new UserAuthenticationResponseModel(jwt));
	}
}	
