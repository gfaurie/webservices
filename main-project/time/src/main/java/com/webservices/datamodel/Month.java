package com.webservices.datamodel;

import java.sql.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(value = "month")
public class Month {
	
    @Id
    @Column(value = "id_month")
    int idMonth;

    @Column(value = "id_user")
    String idUser;
    
    @Column(value = "nb_hour")
    int nbHour;
    
    @Column(value = "start_date")
    Date startDate;

    @Column(value = "end_date")
    Date endDate;
    
    @Column(value = "is_locked")
    int isLocked;

	public int getIdMonth() {
		return idMonth;
	}

	public void setIdMonth(int idMonth) {
		this.idMonth = idMonth;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
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
}
