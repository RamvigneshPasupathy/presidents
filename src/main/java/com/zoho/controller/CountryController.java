package com.zoho.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zoho.model.Country;
import com.zoho.service.CountryService;

@Controller
public class CountryController {

	private CountryService countryService;

	@Autowired(required = true)
	@Qualifier(value = "countryService")
	public void setcountryService(CountryService countryService) {
		this.countryService = countryService;
	}

	@RequestMapping(value = "/home")
	public String goHome() {
		return "redirect:/presidents";
	}

	@RequestMapping(value = "/presidents", method = RequestMethod.GET)
	public String listPresidents(Model model) {
		model.addAttribute("country", new Country());
		model.addAttribute("presidentsList", this.countryService.listPresidents());
		return "home";
	}

	@RequestMapping(value = "/country/upsert", method = RequestMethod.POST)
	public String addCountry(@ModelAttribute("country") Country country) {
		if (country.getId() == 0) {
			this.countryService.addCountry(country);
		} else {
			this.countryService.updatePresident(country);
		}
		return "redirect:/presidents";
	}

	@RequestMapping("/remove/{id}")
	public String removeCountry(@PathVariable("id") int id) {
		this.countryService.removeCountry(id);
		return "redirect:/presidents";
	}

	@RequestMapping("/edit/{id}")
	public String updatePresident(@PathVariable("id") int id, Model model) {
		model.addAttribute("country", this.countryService.getCountryById(id));
		model.addAttribute("presidentsList", this.countryService.listPresidents());
		return "home";
	}

}
