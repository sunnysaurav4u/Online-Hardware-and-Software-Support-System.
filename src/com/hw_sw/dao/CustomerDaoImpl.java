package com.hw_sw.dao;

//import java.sql.Connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.hw_sw.utility.DBUtil;	 
import beanPack.ComplainBean;
import beanPack.CustomerBean;

public class CustomerDaoImpl implements CustomerDao {

	Connection conn;
	PreparedStatement ps;

	public CustomerDaoImpl() {
		conn=DBUtil.getConnect();
	}

	@Override
	public int addCustomer(CustomerBean customBean) {
		int customerId=0;

		try {
			PreparedStatement ps=conn.prepareStatement("insert into customer(customerName,customerUserName,customerMobile,customerCity,customerPass) values(?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, customBean.getCustomerName());
			ps.setString(2, customBean.getCustomerUserName());
			ps.setString(3, customBean.getCustomerMobile());
			ps.setString(4, customBean.getCustomerCity());
			ps.setString(5, customBean.getCustomerPassword());

			if(ps.executeUpdate()>0){

				ResultSet rs= ps.getGeneratedKeys();
				if(rs.next())
					customerId=rs.getInt(1);

			}


		} catch (SQLException e) {

			e.printStackTrace();

		}

		return customerId;

	}

	@Override
	public boolean removeCustomerById(int customerId) {
		
		try {
			ps=conn.prepareStatement("delete from customer where customerId=?");
			ps.setInt(1, customerId);
			
			if(ps.executeUpdate()>0)
				return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public CustomerBean viewCustomerById(int customerId) {
		
		CustomerBean customBean=null;
		
		try {
			ps=conn.prepareStatement("select * from customer where customerId=?");
			ps.setInt(1, customerId);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				customBean = new CustomerBean();
				customBean.setCustomerId(rs.getInt(1)); 
				customBean.setCustomerName(rs.getString(2));
				customBean.setCustomerMail(rs.getString(3)); 
				customBean.setCustomerMobile(rs.getString(4)); 
				customBean.setCustomerCity(rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customBean;
	}

	@Override
	public ArrayList<ComplainBean> getComplainByCustomerId(int customerId) {
		
		ArrayList<ComplainBean> alist = new ArrayList<ComplainBean>();
		
		try {
			//ps=conn.prepareStatement("select complainId,complainName,complainDetail,complainType,complainStatus,complainAnswer from complain,customer where complain.customerId=customer.customerId and complain.customerId=?");
			ps=conn.prepareStatement("select complainId from complain where customerId=?");
			ps.setInt(1, customerId);
			
			ResultSet rs = ps.executeQuery();
			ComplainDao complain=new ComplainDaoImpl();
			while(rs.next()){
				int complainId = rs.getInt(1);
				alist.add(complain.getComplain(complainId));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alist;
	}

	@Override
	public boolean updateCustomer(CustomerBean customBean) {
		try {
			ps=conn.prepareStatement("update customer set customerMobile=?,customerCity=? where customerId=?");
			ps.setString(1, customBean.getCustomerMobile());
			ps.setString(2, customBean.getCustomerCity());
			ps.setInt(3, customBean.getCustomerId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ArrayList<CustomerBean> getAllCustomer() {
		
		ArrayList<CustomerBean> clist=new ArrayList<CustomerBean>();
		
		try {
			
			ps=conn.prepareStatement("select * from customer");
			
			ResultSet rs=ps.executeQuery();
			CustomerBean customBean=new CustomerBean();
			
			while(rs.next()){
				
				customBean.setCustomerId(rs.getInt(1)); 
				customBean.setCustomerName(rs.getString(2));
				customBean.setCustomerMail(rs.getString(3)); 
				customBean.setCustomerMobile(rs.getString(4)); 
				customBean.setCustomerCity(rs.getString(5));
				clist.add(customBean);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return clist;
	}

	@Override
	public boolean validateCustomer(String customerUserName, String customerPass) {
		try {
			ps = conn.prepareStatement("select customerPass from customer where customerUserName=?");
			ps.setString(1, customerUserName);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				if(rs.getString(1).equals(customerPass))
					return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public int idByCustomerName(String customerUserName) {
		try {
			ps=conn.prepareStatement("select customerId from customer where customerUserName=?");
			ps.setString(1, customerUserName);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				return rs.getInt(1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}


}
