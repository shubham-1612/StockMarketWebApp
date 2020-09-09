package com.training.shubham.stockmarketwebapp.service;

import com.training.shubham.stockmarketwebapp.dto.StockExchangeDto;


public interface StockExchangeService {

	public StockExchangeDto getStockExchangeById(Long stockExchangeId);

	public StockExchangeDto getStockExchangeByName(String stockExchangeName);

	void addStockExchange(StockExchangeDto stockExchangeDto);

}
