package com.webservices.rest;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webservices.datamodel.Month;
import com.webservices.datamodel.SaveMonthDto;
import com.webservices.datarepository.MonthRepository;
import com.webservices.exception.ObjectNotFoundException;

@RestController
public class MonthRest {

	@Autowired
	private MonthRepository monthRepository;
	
	public MonthRest() {
		
	}
	
	@GetMapping("/months/user/{id}")
	public List<Month> allMonthsByUser(@PathVariable Long id) {	
		List<Month> months = new ArrayList<>();
		this.monthRepository.findAll().forEach(month -> {
			if (month.getIdUser() == id) {
				months.add(month);
			}
		});
		
		return months;
	}
	
	@GetMapping("/months/{date}/user/{id}")
	public Month getMonthByUser(@PathVariable Date date, @PathVariable Long id) {	
		List<Month> months = new ArrayList<>();
		this.monthRepository.findAll().forEach(month -> {
			if (month.getIdUser() == id && 
					(date.after(month.getStartDate()) && date.before(month.getEndDate()))) {
				months.add(month);
			}
		});
		
		if (months.size() != 1) {
			throw new ObjectNotFoundException("month", 0L);
		}
		
		return months.get(0);
	}
	
	@PostMapping("/months/user")
	public SaveMonthDto saveMonthByUserId (@RequestBody SaveMonthDto monthDto) {
		Month monthToSave = new Month();
		if (monthDto.getIdMonth() != null) {
			monthToSave = this.monthRepository.findById(monthDto.getIdMonth().longValue())
					.orElseThrow(() -> new ObjectNotFoundException("month", monthDto.getIdMonth().longValue()));
		}
			
		monthToSave.setIdUser(monthDto.getIdUser());
		monthToSave.setStartDate(monthDto.getStartDate());
		monthToSave.setEndDate(monthDto.getEndDate());
		monthToSave.setNbHour(monthDto.getNbHour());
		monthToSave.setIsLocked(monthDto.getIsLocked());
		
		monthToSave = this.monthRepository.save(monthToSave);
		return new SaveMonthDto(monthToSave);
	}
}
