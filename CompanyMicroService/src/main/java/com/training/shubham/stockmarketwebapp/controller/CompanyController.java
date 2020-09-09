package com.training.shubham.stockmarketwebapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.shubham.stockmarketwebapp.dto.CompanyDto;
import com.training.shubham.stockmarketwebapp.service.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	public CompanyController(CompanyService companyService) {
		super();
		this.companyService = companyService;
	}
	
	@GetMapping("/allcompanies")
	public ResponseEntity<List<CompanyDto>> getAllCompanies(){
		return new ResponseEntity<List<CompanyDto>>(companyService.getAllCompanies(), HttpStatus.OK);
	}
	
	@GetMapping("/{companyId}")
	public ResponseEntity<CompanyDto> getCompanyById(@PathVariable("companyId") Long companyId){
		return new ResponseEntity<CompanyDto>(companyService.getCompanyById(companyId), HttpStatus.FOUND);
	}
	
	@PostMapping("/")
	public ResponseEntity<CompanyDto> addCompany(@RequestBody CompanyDto company){
		return new ResponseEntity<>(companyService.addCompany(company), HttpStatus.CREATED);
	}
	
	@PutMapping("/{companyId}")
	public ResponseEntity<CompanyDto> updateCompany(@RequestBody CompanyDto company, @PathVariable("companyId") Long companyId){
		return new ResponseEntity<>(companyService.updateCompany(companyId, company), HttpStatus.OK);
	}
	
	@DeleteMapping("/{companyId}")
	public ResponseEntity<CompanyDto> deleteCompany(@PathVariable("companyId") Long companyId){
		companyService.deleteCompany(companyId); 
		return new ResponseEntity<CompanyDto>(HttpStatus.OK);
	}
	
}
