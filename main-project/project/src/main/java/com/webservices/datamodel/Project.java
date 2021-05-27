package com.webservices.datamodel;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(value = "project")
public class Project {
	
    @Id
    @Column(value = "id_project")
    int id_Project;

    @Column(value = "time")
    int time;
    
    @Column(value = "description")
    String description;

	public int getIdProject() {
		return id_Project;
	}

	public void setIdProject(int idProject) {
		this.id_Project = idProject;
	}

	public int getTime() {
		return time;
	}

	public void setLogin(int time) {
		this.time = time;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
