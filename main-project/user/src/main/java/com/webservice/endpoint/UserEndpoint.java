package com.webservice.endpoint;

import com.webservices.commands.GetUserRequest;
import com.webservices.commands.GetUserResponse;
import com.webservices.datarepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UserEndpoint {

	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

	private UserRepository userRepository;

	@Autowired
	public UserEndpoint(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserRequest")
	@ResponsePayload
	public GetUserResponse getUser(@RequestPayload GetUserRequest request) {
		
		GetUserResponse response = new GetUserResponse();
		
		response.setUser(userRepository.findById(request.getIdUser()));

		return response;
	}
}
