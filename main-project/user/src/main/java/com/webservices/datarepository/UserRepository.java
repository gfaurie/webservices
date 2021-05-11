package com.webservices.datarepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import com.webservices.datamodel.User;

@Component
public interface UserRepository extends CrudRepository<User, Long>{
	
}
