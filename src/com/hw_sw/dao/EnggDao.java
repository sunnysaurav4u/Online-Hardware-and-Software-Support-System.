package com.hw_sw.dao;

import java.util.ArrayList;

import beanPack.EnggBean;

public interface EnggDao {


	public int addEngg(EnggBean ebean);
	public boolean validateEngg(String enggMail,String enggPassword);
	public EnggBean getEnggDetails(int enggId);
	public ArrayList<EnggBean> getAllEngineerDetails();
	//public ArrayList<complainBean> getComplainByEnggId(int enggId);
	public boolean removeEngg(int enggId);
	public boolean updateEngg(EnggBean ebean);
	public int idByEnggMail(String enggMail);
	public boolean assignComplainToEngg(int complainId,String enggMail);
	public int getAssignedEngg(int complainId);

}
