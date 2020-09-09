package com.training.shubham.stockmarketwebapp.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.shubham.stockmarketwebapp.entity.IpoDetailsEntity;

@Repository
public interface IpoDetailsRepository extends JpaRepository<IpoDetailsEntity, Long>{

	public List<IpoDetailsEntity> findByCompanyName(String companyName);

	public void deleteByCompanyName(String companyName);

}
