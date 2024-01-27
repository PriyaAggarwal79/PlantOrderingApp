package com.plant.service;

import com.plant.entity.Customer;

public interface CustomerService {

	public boolean addCustomerDetails(Customer c);
	public boolean deleteCustomerDetails(String customerId);
	public boolean updateCustomerDetails(Customer c);
	public Customer getDetailsByEmail(String custEmailId);
	public Customer getDetailsById(String customerId);
	
}
