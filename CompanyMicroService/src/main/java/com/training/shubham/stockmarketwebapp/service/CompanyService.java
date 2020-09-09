package com.training.shubham.stockmarketwebapp.service;

import java.util.List;

import com.training.shubham.stockmarketwebapp.dto.CompanyDto;

public interface CompanyService {

	public List<CompanyDto> getAllCompanies();

	public CompanyDto getCompanyById(Long companyId);
	
	public CompanyDto getCompanyByName(String companyName);

	public CompanyDto addCompany(CompanyDto company);

	public CompanyDto updateCompany(Long companyId, CompanyDto company);

	public void deleteCompany(Long companyId);
	
}
