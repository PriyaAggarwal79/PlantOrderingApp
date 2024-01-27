package com.plant.entity;

public class Customer {

	private String customerId;
	private String customerName;
	private String custEmailId;
	private Long custPhnNo;
	private String homeAddress;
	private String pincode;
	private String dropAddress;
	private String password;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String customerId, String customerName, String custEmailId, Long custPhnNo, String homeAddress,
			String pincode, String dropAddress, String password) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.custEmailId = custEmailId;
		this.custPhnNo = custPhnNo;
		this.homeAddress = homeAddress;
		this.pincode = pincode;
		this.dropAddress = dropAddress;
		this.password = password;
	}

	@Override
	public String toString() {
		return "\nCustomer Id=" + customerId + "\nCustomerName=" + customerName + "\nEmailId=" + custEmailId
				+ "\nMobile No.=" + custPhnNo + "\nHome Address=" + homeAddress + "\nArea-Pincode=" + pincode
				+ "\nDropAddress=" + dropAddress + "Password=" + password + "\n";
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustEmailId() {
		return custEmailId;
	}

	public void setCustEmailId(String custEmailId) {
		this.custEmailId = custEmailId;
	}

	public Long getCustPhnNo() {
		return custPhnNo;
	}

	public void setCustPhnNo(Long custPhnNo) {
		this.custPhnNo = custPhnNo;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getDropAddress() {
		return dropAddress;
	}

	public void setDropAddress(String dropAddress) {
		this.dropAddress = dropAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
