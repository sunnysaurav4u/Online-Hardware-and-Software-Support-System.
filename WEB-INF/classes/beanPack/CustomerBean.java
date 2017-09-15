package beanPack;

import java.io.Serializable;

public class CustomerBean implements Serializable{
	
	private int customerId;
	private String customerName;
	private String customerPassword;
	private String customerMail;
	private String customerMobile;
	private String customerCity;
	
	public CustomerBean() {
		
	}
	
	

	public CustomerBean( int customerId,String customerName, String customerMail, String customerMobile,String customerCity,String customerPassword) {
		super();
		this.customerId=customerId;
		this.customerName = customerName;
		this.customerMail = customerMail;
		this.customerMobile = customerMobile;
		this.customerCity = customerCity;
		this.customerPassword = customerPassword;
	}



	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerUserName() {
		return customerMail;
	}

	public void setCustomerMail(String customerMail) {
		this.customerMail = customerMail;
	}

	public String getCustomerMobile() {
		return customerMobile;
	}

	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}

	public String getCustomerCity() {
		return customerCity;
	}

	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}



	public String getCustomerPassword() {
		return customerPassword;
	}



	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	
	

}
