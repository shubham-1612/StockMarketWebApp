package com.training.shubham.stockmarketwebapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.shubham.stockmarketwebapp.entity.StockPriceEntity;

@Repository
public interface StockPriceRepository extends JpaRepository<StockPriceEntity, Long> {

}
