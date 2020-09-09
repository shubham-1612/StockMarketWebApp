package com.training.shubham.stockmarketwebapp.dto;

import java.util.Date;

public class IpoDetailsDto {

	private Long id;
	
	private String companyName;

	private String stockExchangeName;
	
	private float pricePerShare;
	
	private long totalNumberOfShares;
	
	private Date openDateTime;

	public IpoDetailsDto() {
		super();
	}

	public IpoDetailsDto(Long id, String companyName, String stockExchangeName, float pricePerShare,
			long totalNumberOfShares, Date openDateTime) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.stockExchangeName = stockExchangeName;
		this.pricePerShare = pricePerShare;
		this.totalNumberOfShares = totalNumberOfShares;
		this.openDateTime = openDateTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getStockExchangeName() {
		return stockExchangeName;
	}

	public void setStockExchangeName(String stockExchangeName) {
		this.stockExchangeName = stockExchangeName;
	}

	public float getPricePerShare() {
		return pricePerShare;
	}

	public void setPricePerShare(float pricePerShare) {
		this.pricePerShare = pricePerShare;
	}

	public long getTotalNumberOfShares() {
		return totalNumberOfShares;
	}

	public void setTotalNumberOfShares(long totalNumberOfShares) {
		this.totalNumberOfShares = totalNumberOfShares;
	}

	public Date getOpenDateTime() {
		return openDateTime;
	}

	public void setOpenDateTime(Date openDateTime) {
		this.openDateTime = openDateTime;
	}
	
}
