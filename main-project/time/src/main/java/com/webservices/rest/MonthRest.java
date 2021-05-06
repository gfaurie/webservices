package com.webservices.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webservices.datamodel.Month;
import com.webservices.datarepository.MonthRepository;

@RestController
public class MonthRest {

	@Autowired
	private MonthRepository monthRepository;
	
	public MonthRest() {
		
	}
	
	@GetMapping("/months")
	public Iterable<Month> allMonths() {	
		return this.monthRepository.findAll();
	}
}
