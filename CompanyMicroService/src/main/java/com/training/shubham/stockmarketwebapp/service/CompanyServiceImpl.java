package com.training.shubham.stockmarketwebapp.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.shubham.stockmarketwebapp.controller.SectorServiceClient;
import com.training.shubham.stockmarketwebapp.controller.StockExchangeServiceClient;
import com.training.shubham.stockmarketwebapp.dto.CompanyDto;
import com.training.shubham.stockmarketwebapp.entity.CompanyEntity;
import com.training.shubham.stockmarketwebapp.repo.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private SectorServiceClient sectorServiceClient;
	
	@Autowired
	private StockExchangeServiceClient stockExchangeServiceClient;
	
	@Autowired
	private ModelMapper modelMapper;

	public CompanyServiceImpl(CompanyRepository companyRepository, ModelMapper modelMapper) {
		super();
		this.companyRepository = companyRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	@Transactional
	public List<CompanyDto> getAllCompanies() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		List<CompanyDto> allCompanies = companyRepository.findAll().stream().map(c -> modelMapper.map(c, CompanyDto.class)).collect(Collectors.toList());
		return allCompanies;
	}

	@Override
	@Transactional
	public CompanyDto getCompanyById(Long companyId) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper.map(companyRepository.findById(companyId), CompanyDto.class);
	}
	
	@Override
	@Transactional
	public CompanyDto getCompanyByName(String companyName) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper.map(companyRepository.findByCompanyName(companyName), CompanyDto.class);
	}

	@Override
	@Transactional
	public CompanyDto addCompany(CompanyDto company) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		companyRepository.save(modelMapper.map(company, CompanyEntity.class));
		return company;
	}

	@Override
	@Transactional
	public CompanyDto updateCompany(Long companyId, CompanyDto company) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		companyRepository.save(modelMapper.map(company, CompanyEntity.class));
		return company;
	}

	@Override
	@Transactional
	public void deleteCompany(Long companyId) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		companyRepository.deleteById(companyId);
	}
}
