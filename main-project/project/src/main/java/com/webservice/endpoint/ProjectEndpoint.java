package com.webservice.endpoint;

import com.webservices.commands.GetProjectRequest;
import com.webservices.commands.GetProjectResponse;
import com.webservices.datarepository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ProjectEndpoint {

	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

	private ProjectRepository projRepository;

	@Autowired
	public ProjectEndpoint(ProjectRepository projRepository) {
		this.projRepository = projRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProjectRequest")
	@ResponsePayload
	public GetProjectResponse getProject(@RequestPayload GetProjectRequest request) {
		
		GetProjectResponse response = new GetProjectResponse();
		
		response.setProject(projRepository.findById(request.getIdProject()));

		return response;
	}
}
