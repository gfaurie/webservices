package com.webservices.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webservices.datamodel.AddTimeDto;
import com.webservices.datamodel.Month;
import com.webservices.datamodel.TimePerProjectAndMonth;
import com.webservices.datarepository.MonthRepository;
import com.webservices.datarepository.TimePerProjectAndMonthRepository;
import com.webservices.exception.ObjectNotFoundException;

@RestController
public class TimePerProjectAndMonthRest {

	@Autowired
	private TimePerProjectAndMonthRepository timeRepository;
	
	@Autowired
	private MonthRepository monthRepository;
	
	public TimePerProjectAndMonthRest() {
		
	}
	
	@DeleteMapping("/times/{id}")
	public Boolean deleteTime(@PathVariable Long id) {
		TimePerProjectAndMonth time = this.timeRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("time", id));
		
		this.monthRepository.findAll().forEach(month -> {
			if(month.getTimePerProjectAndMonths().contains(time)) {
				month.getTimePerProjectAndMonths().remove(time);
				this.monthRepository.save(month);
			}	
		});
		
		this.timeRepository.deleteById(id);
		return true;
	}
	
	@PostMapping("/times")
	public TimePerProjectAndMonth addTime(@RequestBody AddTimeDto timeDto) {
		TimePerProjectAndMonth time = new TimePerProjectAndMonth();
		
		time.setIdProject(timeDto.getIdProject());
		time.setNbHour(timeDto.getNbHour());
		
		Month month = this.monthRepository.findById((long)timeDto.getIdMonth()).orElseThrow(() -> 
			new ObjectNotFoundException("month", (long) timeDto.getIdMonth()));
		
		// First save month with time added
		month.addTimePerProjectAndMonth(time);
		this.monthRepository.save(month);
		
		return this.timeRepository.save(time);
	}
	
	@PutMapping("/times/{id}")
	public TimePerProjectAndMonth updateTime(@PathVariable Long id, @RequestBody AddTimeDto timeDto) {
		TimePerProjectAndMonth time = this.timeRepository.findById(id).orElseThrow(() 
				-> new ObjectNotFoundException("time", id));
		
		time.setIdProject(timeDto.getIdProject());
		time.setNbHour(timeDto.getNbHour());
		
		return this.timeRepository.save(time);
	}
}
