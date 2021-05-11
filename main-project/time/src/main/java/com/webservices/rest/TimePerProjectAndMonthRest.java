package com.webservices.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.webservices.datamodel.TimePerProjectAndMonth;
import com.webservices.datarepository.TimePerProjectAndMonthRepository;
import com.webservices.exception.ObjectNotFoundException;

@RestController
public class TimePerProjectAndMonthRest {

	@Autowired
	private TimePerProjectAndMonthRepository timePerProjectPerMonthRepository;
	
	public TimePerProjectAndMonthRest() {
		
	}
	
	@GetMapping("/times")
	public Iterable<TimePerProjectAndMonth> allTimes() {	
		return this.timePerProjectPerMonthRepository.findAll();
	}
	
	@GetMapping("/times/{id}")
	public TimePerProjectAndMonth getTime(@PathVariable Long id) {
		return this.timePerProjectPerMonthRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("time", id));
	}
}
