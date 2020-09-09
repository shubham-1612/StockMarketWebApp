package com.training.shubham.stockmarketwebapp.service;

import com.training.shubham.stockmarketwebapp.dto.IpoDetailsDto;

public interface IpoDetailsService {

	public IpoDetailsDto getIpoDetailsByName(String companyName);

	public void addIpoDetailsByName(IpoDetailsDto ipoDetailsDto);

	public void updateIpoDetailsByName(String companyName, IpoDetailsDto ipoDetailsDto);

	public void deleteIpoDetailsByName(String companyName);

}
