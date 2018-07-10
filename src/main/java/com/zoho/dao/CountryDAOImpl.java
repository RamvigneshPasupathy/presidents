package com.zoho.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.zoho.model.Country;

@Repository
public class CountryDAOImpl implements CountryDAO {
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	public void addCountry(Country country) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(country);
		System.out.println("Country added successfully. Details: " + country);
	}

	public void updatePresident(Country country) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(country);
		System.out.println("President updated successfully. Details: " + country);
	}

	@SuppressWarnings("unchecked")
	public List<Country> listPresidents() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Country> list = session.createQuery("from Country").list();
		System.out.println("---- Country List ----");
		for(Country country : list){
			System.out.println(country);
		}
		return list;
	}

	public Country getCountryById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Country country = (Country) session.load(Country.class, new Integer(id));
		System.out.println("Country loaded successfully. Details: " + country);
		return country;
	}

	public void removeCountry(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Country country = (Country) session.load(Country.class, new Integer(id));
		if(null != country){
			session.delete(country);
		}
		System.out.println("Country deleted successfully. Details: " + country);
	}


}