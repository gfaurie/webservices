package com.webservices.datamodel;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class SaveMonthDto {

	private Integer idMonth;
    
    private int idUser;

    private int nbHour;
    
    private Date startDate;

    private Date endDate;
    
    private int isLocked;
    
	private Set<TimePerProjectAndMonth> timePerProjectAndMonths = new HashSet<>();
	
	public SaveMonthDto() {
		
	}

	public SaveMonthDto(Month month) {
		idMonth = month.getIdMonth();
		idUser = month.getIdUser();
		startDate = month.getStartDate();
		endDate = month.getEndDate();
		nbHour = month.getNbHour();
		isLocked = month.getIsLocked();
		timePerProjectAndMonths.addAll(month.getTimePerProjectAndMonths());
	}
	
	public Integer getIdMonth() {
		return idMonth;
	}

	public void setIdMonth(Integer idMonth) {
		this.idMonth = idMonth;
	}
	
	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getNbHour() {
		return nbHour;
	}

	public void setNbHour(int nbHour) {
		this.nbHour = nbHour;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getIsLocked() {
		return isLocked;
	}

	public void setIsLocked(int isLocked) {
		this.isLocked = isLocked;
	}

	public Set<TimePerProjectAndMonth> getTimePerProjectAndMonths() {
		return timePerProjectAndMonths;
	}

	public void addTimePerProjectAndMonths(TimePerProjectAndMonth timePerProjectAndMonths) {
		this.timePerProjectAndMonths.add(timePerProjectAndMonths);
	}
}
