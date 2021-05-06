package com.webservices.datarepository;

import org.springframework.data.repository.CrudRepository;

import com.webservices.datamodel.Month;

public interface MonthRepository extends CrudRepository<Month, Long>{

}
