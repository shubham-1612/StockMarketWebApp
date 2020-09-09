package com.training.shubham.stockmarketwebapp.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.shubham.stockmarketwebapp.dto.IpoDetailsDto;
import com.training.shubham.stockmarketwebapp.entity.IpoDetailsEntity;
import com.training.shubham.stockmarketwebapp.repo.IpoDetailsRepository;

@Service
public class IpoDetailsServiceImpl implements IpoDetailsService {

	@Autowired
	private IpoDetailsRepository ipoDetailsRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public IpoDetailsServiceImpl(IpoDetailsRepository ipoDetailsRepository, ModelMapper modelMapper) {
		super();
		this.ipoDetailsRepository = ipoDetailsRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	@Transactional
	public IpoDetailsDto getIpoDetailsByName(String companyName) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper.map(ipoDetailsRepository.findByCompanyName(companyName), IpoDetailsDto.class);
	}

	@Override
	@Transactional
	public void addIpoDetailsByName(IpoDetailsDto ipoDetailsDto) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		ipoDetailsRepository.save(modelMapper.map(ipoDetailsDto, IpoDetailsEntity.class));
	}

	@Override
	@Transactional
	public void updateIpoDetailsByName(String companyName, IpoDetailsDto ipoDetailsDto) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		ipoDetailsRepository.save(modelMapper.map(ipoDetailsDto, IpoDetailsEntity.class));
	}

	@Override
	@Transactional
	public void deleteIpoDetailsByName(String companyName) {
		ipoDetailsRepository.deleteByCompanyName(companyName);
	}

}
