package com.webservices.datamodel;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(value = "time_per_project_and_month")
public class TimePerProjectAndMonth {
	
	@Id
    @Column(value = "id_time_per_project_and_month")
    private long idTimePerProjectAndMonth;
    
	@Column(value = "id_project")
    private long idProject;
	
    @Column(value = "nb_hour")
    private int nbHour;

	public long getIdTimePerProjectAndMonth() {
		return idTimePerProjectAndMonth;
	}

	public void setIdTimePerProjectAndMonth(long idTimePerProjectAndMonth) {
		this.idTimePerProjectAndMonth = idTimePerProjectAndMonth;
	}

	public long getIdProject() {
		return idProject;
	}

	public void setIdProject(long idProject) {
		this.idProject = idProject;
	}

	public int getNbHour() {
		return nbHour;
	}

	public void setNbHour(int nbHour) {
		this.nbHour = nbHour;
	}
}
