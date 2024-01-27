package com.plant.service;

public interface LoginService {

	public boolean customerLogin(String username, String password);
	public boolean adminLogin(String username, String password);
	
	public boolean forgetCustPassword(String username, String customerId, String newPassword);
	public boolean forgetAdminPassword(String username, String adminId, String newPassword);
	
}
