package com.training.shubham.stockmarketwebapp.service;

import org.springframework.web.multipart.MultipartFile;

public interface StockPriceService {

	void save(MultipartFile file);

}
