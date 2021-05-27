package com.webservices.datarepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.webservices.datamodel.Project;

@Component
public interface ProjectRepository extends CrudRepository<Project, Long>{
	
}
