package com.webservices.datarepository;

import org.springframework.data.repository.CrudRepository;
import com.webservices.datamodel.User;

public interface UserRepository extends CrudRepository<User, Long>{

}
