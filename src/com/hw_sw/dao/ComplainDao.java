package com.hw_sw.dao;

import java.util.ArrayList;

import beanPack.ComplainBean;

public interface ComplainDao {

	public ArrayList<ComplainBean> getComplainPerCustomer(int customerId);
	public int registerComplain(ComplainBean cBean);
	public  boolean answerComplain(int complainId,String complainAnswer);
	public String checkComplainStatus(int complainId);
	public String assignComplainToEngg(int complainId,int engineerId);
	public ComplainBean getComplain(int complainId);
	public ArrayList<ComplainBean> getAllComplainDetais();
	public ArrayList<ComplainBean> getComplainEnggId(int enggId);
	
}
