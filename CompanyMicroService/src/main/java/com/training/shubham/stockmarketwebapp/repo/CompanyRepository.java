package com.training.shubham.stockmarketwebapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.shubham.stockmarketwebapp.entity.CompanyEntity;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, Long> {

	CompanyEntity findByCompanyName(String companyName);

}
