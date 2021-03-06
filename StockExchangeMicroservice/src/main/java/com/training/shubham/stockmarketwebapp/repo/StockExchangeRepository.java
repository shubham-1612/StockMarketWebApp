package com.training.shubham.stockmarketwebapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.shubham.stockmarketwebapp.entity.StockExchangeEntity;

@Repository
public interface StockExchangeRepository extends JpaRepository<StockExchangeEntity, Long> {

	public StockExchangeEntity findByStockExchangeName(String stockExchangeName);
	
}
