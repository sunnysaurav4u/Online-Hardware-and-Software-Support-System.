package com.hw_sw.dao;

import java.util.ArrayList;

import beanPack.ComplainBean;
import beanPack.CustomerBean;

public interface CustomerDao {

	public int addCustomer(CustomerBean customBean);
	public boolean validateCustomer(String customerMail,String customerPass);
	public boolean removeCustomerById(int customerId);
	public CustomerBean viewCustomerById(int customerId);
	public ArrayList<ComplainBean> getComplainByCustomerId(int customerId);
	public boolean updateCustomer(CustomerBean customBean);
	public ArrayList<CustomerBean> getAllCustomer();
	public int idByCustomerName(String customerUserName);
	
}
