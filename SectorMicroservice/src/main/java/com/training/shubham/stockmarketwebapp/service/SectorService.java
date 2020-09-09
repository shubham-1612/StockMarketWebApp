package com.training.shubham.stockmarketwebapp.service;

import java.util.List;

import com.training.shubham.stockmarketwebapp.dto.CompanyDto;
import com.training.shubham.stockmarketwebapp.dto.SectorDto;


public interface SectorService {

	public SectorDto getSectorById(Long sectorId);

	public List<CompanyDto> getCompaniesBySectorId(Long sectorId);

	public void addSector(SectorDto sectorDto);

}
