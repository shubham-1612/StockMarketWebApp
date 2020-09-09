package com.training.shubham.stockmarketwebapp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.shubham.stockmarketwebapp.dto.CompanyDto;
import com.training.shubham.stockmarketwebapp.dto.SectorDto;
import com.training.shubham.stockmarketwebapp.entity.SectorEntity;
import com.training.shubham.stockmarketwebapp.repo.SectorRepository;

@Service
public class SectorServiceImpl implements SectorService {

	@Autowired
	private SectorRepository sectorRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public SectorServiceImpl(SectorRepository sectorRepository) {
		super();
		this.sectorRepository = sectorRepository;
	}

	@Override
	@Transactional
	public SectorDto getSectorById(Long sectorId) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper.map(sectorRepository.findById(sectorId), SectorDto.class);
	}

	@Override
	@Transactional
	public List<CompanyDto> getCompaniesBySectorId(Long sectorId) {
		// To be fetched from another Company Microservice
		return null;
	}

	@Override
	@Transactional
	public void addSector(SectorDto sectorDto) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		sectorRepository.save(modelMapper.map(sectorDto, SectorEntity.class));
	}

}
