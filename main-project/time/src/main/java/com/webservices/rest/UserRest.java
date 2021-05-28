package com.webservices.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.webservices.commands.GetUserRequest;
import com.webservices.commands.GetUserResponse;
import com.webservices.datamodel.CreateUserDto;
import com.webservices.datamodel.User;
import com.webservices.datamodel.UserAuthentificationDto;
import com.webservices.exception.ObjectNotFoundException;

@RestController
public class UserRest extends WebServiceGatewaySupport {
	
	
	public UserRest() {
		this.setDefaultUri("http://localhost:8080/ws");
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setPackagesToScan("com.webservices.commands");
		this.setMarshaller(marshaller);
		this.setUnmarshaller(marshaller);
	}
	
	@PostMapping("/users/authentification")
	public User getUser(@RequestBody UserAuthentificationDto userDto) {
    	GetUserRequest request = new GetUserRequest();
    	request.setIdUser(1);
        request.setLogin(userDto.getLogin());
        request.setPwd(userDto.getPassword());

        GetUserResponse response = (GetUserResponse) getWebServiceTemplate()
          .marshalSendAndReceive(request);
        
        if (response != null) {
        	User user = response.getUser().orElseThrow(() -> 
        		new ObjectNotFoundException("user", 1L));
        	user.setPwd("");
        	return user;
        }
        
        return null;
    }
	
	@PostMapping("/users/create")
	public User createUser(@RequestBody CreateUserDto userDto) {
    	GetUserRequest request = new GetUserRequest();
        request.setLogin(userDto.getUsername());
        request.setPwd(userDto.getPassword());
        request.setName(userDto.getFisrtName());
        request.setLName(userDto.getLastName());
        request.setIsMgr(userDto.getIsManager());

        GetUserResponse response = (GetUserResponse) getWebServiceTemplate()
          .marshalSendAndReceive(request);
        
        if (response != null) {
        	User user = response.getUser().orElseThrow(() -> 
        		new ObjectNotFoundException("user", 1L));
        	user.setPwd("");
        	return user;
        }
        
        return null;
    }
}
