package com.training.shubham.stockmarketwebapp.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "ipo_details")
public class IpoDetailsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "stock_exchange_name")
	private String stockExchangeName;
	
	@Column(name = "price")
	private float pricePerShare;
	
	@Column(name = "number_of_shares")
	private long totalNumberOfShares;
	
	@Column(name = "open_date_time")
	private Date openDateTime;
	
	@Column(name = "remarks")
	private String remarks;

	public IpoDetailsEntity() {
		super();
	}

	public IpoDetailsEntity(String companyName, String stockExchangeName, float pricePerShare,
			long totalNumberOfShares, Date openDateTime) {
		super();
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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	} 
}
