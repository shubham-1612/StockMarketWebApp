package com.training.shubham.stockmarketwebapp.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.shubham.stockmarketwebapp.dto.StockExchangeDto;
import com.training.shubham.stockmarketwebapp.entity.StockExchangeEntity;
import com.training.shubham.stockmarketwebapp.repo.StockExchangeRepository;

@Service
public class StockExchangeServiceImpl implements StockExchangeService {

	@Autowired
	private StockExchangeRepository stockExchangeRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	public StockExchangeServiceImpl(StockExchangeRepository stockExchangeRepository, ModelMapper modelMapper) {
		super();
		this.stockExchangeRepository = stockExchangeRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	@Transactional
	public StockExchangeDto getStockExchangeById(Long stockExchangeId) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper.map(stockExchangeRepository.findById(stockExchangeId), StockExchangeDto.class);
	}

	@Override
	@Transactional
	public StockExchangeDto getStockExchangeByName(String stockExchangeName) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper.map(stockExchangeRepository.findByStockExchangeName(stockExchangeName), StockExchangeDto.class);
	}

	@Override
	@Transactional
	public void addStockExchange(StockExchangeDto stockExchangeDto) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		stockExchangeRepository.save(modelMapper.map(stockExchangeDto, StockExchangeEntity.class));
	}
	
	
}
