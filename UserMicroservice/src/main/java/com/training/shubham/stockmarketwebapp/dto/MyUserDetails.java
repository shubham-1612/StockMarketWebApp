package com.training.shubham.stockmarketwebapp.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.training.shubham.stockmarketwebapp.entity.UserEntity;

public class MyUserDetails implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6560630123740322450L;
	private String username;
	private String password;
	private boolean active;
	private boolean confirmed;
	private List<GrantedAuthority> authorities = new ArrayList<>();
	
	public MyUserDetails(UserEntity user) {
		this.username = user.getUserName();
		this.password = user.getPassword();
		this.active = true;
		this.authorities = Arrays.asList(new SimpleGrantedAuthority(user.getUserType()));
		this.confirmed = user.isConfirmed();
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return confirmed;
	}

}
