package com.webservices.datamodel;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

@Table(value = "month")
public class Month {
	
    @Id
    @Column(value = "id_month")
    private int idMonth;
    
    @Column(value = "id_user")
    private int idUser;
    
    @Column(value = "nb_hour")
    private int nbHour;
    
    @Column(value = "start_date")
    private Date startDate;

    @Column(value = "end_date")
    private Date endDate;
    
    @Column(value = "is_locked")
    private int isLocked;
    
    @MappedCollection(keyColumn = "id_month", idColumn = "id_month")
	private Set<TimePerProjectAndMonth> timePerProjectAndMonths = new HashSet<>();

	public int getIdMonth() {
		return idMonth;
	}

	public void setIdMonth(int idMonth) {
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

	public void addTimePerProjectAndMonth(TimePerProjectAndMonth timePerProjectAndMonth) {
		this.timePerProjectAndMonths.add(timePerProjectAndMonth);
	}	
	
	
}
