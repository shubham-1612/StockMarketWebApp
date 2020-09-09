package com.training.shubham.stockmarketwebapp.controller;

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

import com.training.shubham.stockmarketwebapp.dto.IpoDetailsDto;
import com.training.shubham.stockmarketwebapp.service.IpoDetailsService;

@RestController
@RequestMapping("/ipo")
public class IpoDetailsController {

	@Autowired
	private IpoDetailsService ipoDetailsService;

	public IpoDetailsController(IpoDetailsService ipoDetailsService) {
		super();
		this.ipoDetailsService = ipoDetailsService;
	}
	
	@GetMapping("/companyName")
	public ResponseEntity<IpoDetailsDto> getIpoDetailsByName(@PathVariable("companyName") String companyName){
		return new ResponseEntity<IpoDetailsDto>(ipoDetailsService.getIpoDetailsByName(companyName), HttpStatus.FOUND);
	}
	
	@PostMapping("/")
	public ResponseEntity<IpoDetailsDto> addIpoDetailsByName(@RequestBody IpoDetailsDto ipoDetailsDto){
		ipoDetailsService.addIpoDetailsByName(ipoDetailsDto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/{companyName}")
	public ResponseEntity<IpoDetailsDto> updateIpoDetailsByCode(@RequestBody IpoDetailsDto ipoDetailsDto, @PathVariable("companyName") String companyName){
		ipoDetailsService.updateIpoDetailsByName(companyName, ipoDetailsDto);
		return new ResponseEntity<IpoDetailsDto>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{companyName}")
	public ResponseEntity<IpoDetailsDto> deleteIpoDetailsByName(@PathVariable("companyName") String companyName){
		ipoDetailsService.deleteIpoDetailsByName(companyName);
		return new ResponseEntity<IpoDetailsDto>(HttpStatus.OK);
	}
}
