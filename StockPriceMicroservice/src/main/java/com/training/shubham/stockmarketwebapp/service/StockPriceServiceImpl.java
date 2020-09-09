package com.training.shubham.stockmarketwebapp.service;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.training.shubham.stockmarketwebapp.entity.StockPriceEntity;
import com.training.shubham.stockmarketwebapp.repo.StockPriceRepository;

@Service
public class StockPriceServiceImpl implements StockPriceService {

	@Autowired
	private StockPriceRepository stockPriceRepository;
	
	public StockPriceServiceImpl(StockPriceRepository stockPriceRepository) {
		super();
		this.stockPriceRepository = stockPriceRepository;
	}

	@Override
	@Transactional
	public void save(MultipartFile file) throws RuntimeException{
		try {
			List<StockPriceEntity> stockPriceList = ExcelHelper.excelToStockPriceEntity(file.getInputStream());
			stockPriceRepository.saveAll(stockPriceList);
		} catch (IOException e) {
			throw new RuntimeException("fail to store excel data: " + e.getMessage());
		}
	}

}
