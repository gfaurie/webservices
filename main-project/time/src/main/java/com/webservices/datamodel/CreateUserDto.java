package com.webservices.datamodel;

public class CreateUserDto {

	private String username;
	private String password;
	private String fisrtName;
	private String lastName;
	private boolean isManager;
	
	public CreateUserDto() {

	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFisrtName() {
		return fisrtName;
	}
	
	public void setFisrtName(String fisrtName) {
		this.fisrtName = fisrtName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public boolean getIsManager() {
		return isManager;
	}
	
	public void setIsManager(boolean isManager) {
		this.isManager = isManager;
	}
	
	
}
