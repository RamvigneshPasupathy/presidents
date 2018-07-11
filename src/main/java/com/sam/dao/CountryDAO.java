package com.sam.dao;

import java.util.List;

import com.sam.bean.Country;

public interface CountryDAO {
	
	public void addCountry(Country country);
	public void updatePresident(Country country);
	public List<Country> listPresidents();
	public Country getCountryById(int id);
	public void removeCountry(int id);
	
}
