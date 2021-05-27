package com.webservices.datamodel;

public class AddTimeDto {
	private int idProject;
	private int idMonth; 
	private int nbHour;
	
	public AddTimeDto() {
		
	}
	
	public int getIdProject() {
		return idProject;
	}
	public void setIdProject(int idProject) {
		this.idProject = idProject;
	}
	public int getIdMonth() {
		return idMonth;
	}
	public void setIdMonth(int idMonth) {
		this.idMonth = idMonth;
	}
	public int getNbHour() {
		return nbHour;
	}
	public void setNbHour(int nbHour) {
		this.nbHour = nbHour;
	}
}
