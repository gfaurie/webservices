package com.webservices.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.webservices.datamodel.User;
import com.webservices.datarepository.UserRepository;
import com.webservices.exception.ObjectNotFoundException;

@Component
@RestController
public class UserRest /*extends WebServiceGatewaySupport*/ {
	
	@Autowired
	private UserRepository userRepository;
	
	public UserRest() {
		
	}
	
	//@PostMapping("/users")
	/*public getUserResponse getUser(@RequestBody Player player) {
    	getUserRequest request = new getUserRequest();
        request.setName(country);
        request.setName(country);

        getUserResponse response = (getUserResponse) getWebServiceTemplate()
          .marshalSendAndReceive(request);
        
        if (NonNull(response)) {
        	response.setPassword("");
        }
        return response;
    }*/
}
