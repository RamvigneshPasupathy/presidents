package com.zoho.dao;

import java.util.List;

import com.zoho.model.Country;

public interface CountryDAO {
	
	public void addCountry(Country country);
	public void updatePresident(Country country);
	public List<Country> listPresidents();
	public Country getCountryById(int id);
	public void removeCountry(int id);
	
}
