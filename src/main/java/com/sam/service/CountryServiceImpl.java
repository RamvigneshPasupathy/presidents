package com.sam.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sam.bean.Country;
import com.sam.dao.CountryDAO;

@Service
public class CountryServiceImpl implements CountryService {
	
	private CountryDAO countryDAO;

	public void setCountryDAO(CountryDAO countryDAO) {
		this.countryDAO = countryDAO;
	}

	@Transactional
	public void addCountry(Country country) {
		this.countryDAO.addCountry(country);
	}

	@Transactional
	public void updatePresident(Country country) {
		this.countryDAO.updatePresident(country);
		
	}

	@Transactional
	public List<Country> listPresidents() {
		return this.countryDAO.listPresidents();
	}

	@Transactional
	public Country getCountryById(int id) {
		return countryDAO.getCountryById(id);
	}

	@Transactional
	public void removeCountry(int id) {
		this.countryDAO.removeCountry(id);
	}

}
