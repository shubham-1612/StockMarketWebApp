package com.training.shubham.stockmarketwebapp.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "company_table")
public class CompanyEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "company_id")
	private Long companyId;
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "company_code")
	private String companyCode;
	
	@Column(name = "company_ceo")
	private String companyCeo;
	
	@ElementCollection
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "company_id", nullable = false)
	private Set<Director> directors = new HashSet<>();
	
	@ElementCollection
	private Set<String> listedInStockExchanges = new HashSet<>();
	
	@Column(name = "sector_name")
	private String sectorName;
	
	private float turnover;
	
	private String about;
	
	public CompanyEntity() {
		
	}

	public CompanyEntity(String companyName, String companyCode, String companyCeo, Set<Director> directors,
			Set<String> listedInStockExchanges, String sectorName, float turnover, String about) {
		super();
		this.companyName = companyName;
		this.companyCode = companyCode;
		this.companyCeo = companyCeo;
		this.directors = directors;
		this.listedInStockExchanges = listedInStockExchanges;
		this.sectorName = sectorName;
		this.turnover = turnover;
		this.about = about;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getCompanyCeo() {
		return companyCeo;
	}

	public void setCompanyCeo(String companyCeo) {
		this.companyCeo = companyCeo;
	}

	public Set<Director> getDirectors() {
		return directors;
	}

	public void setDirectors(Set<Director> directors) {
		this.directors = directors;
	}

	public Set<String> getListedInStockExchanges() {
		return listedInStockExchanges;
	}

	public void setListedInStockExchanges(Set<String> listedInStockExchanges) {
		this.listedInStockExchanges = listedInStockExchanges;
	}

	public String getSectorName() {
		return sectorName;
	}

	public void setSectorId(String sectorName) {
		this.sectorName = sectorName;
	}

	public float getTurnover() {
		return turnover;
	}

	public void setTurnover(float turnover) {
		this.turnover = turnover;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}
	
}
