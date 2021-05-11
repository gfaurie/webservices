package com.webservices.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.webservices.datamodel.Month;
import com.webservices.datarepository.MonthRepository;
import com.webservices.exception.ObjectNotFoundException;

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
	
	@GetMapping("/months/{id}")
	public Month getMonth(@PathVariable Long id) {	
		return this.monthRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("month", id));
	}
}
