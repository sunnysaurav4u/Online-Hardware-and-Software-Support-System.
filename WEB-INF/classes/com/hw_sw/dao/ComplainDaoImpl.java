package com.hw_sw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.hw_sw.utility.DBUtil;

import beanPack.ComplainBean;
import beanPack.CustomerBean;

public class ComplainDaoImpl implements ComplainDao{
	
	Connection conn;
	PreparedStatement ps;
	
	public ComplainDaoImpl() {
		conn = DBUtil.getConnect();
	}

	
	
	@Override
	public int registerComplain(ComplainBean cBean) {
		int complainId=0;
		try {
			ps=conn.prepareStatement("insert into complain(complainName,complainDetail,complainType,customerId) values(?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, cBean.getComplainName());
			ps.setString(2, cBean.getComplainDetail());
			ps.setString(3, cBean.getComplainType());
			ps.setInt(4, cBean.getCustomerId());
			
			if(ps.executeUpdate()>0){

				ResultSet rs= ps.getGeneratedKeys();
				if(rs.next())
					complainId=rs.getInt(1);

			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return complainId;
	}

	
	
	@Override
	public boolean answerComplain(int complainId, String complainAnswer) {
		boolean flag=false;
		try {
			ps=conn.prepareStatement("update complain set complainAnswer=?,complainStatus=? where complainId=?");
			ps.setString(1, complainAnswer);
			ps.setString(2, "Done");
			ps.setInt(3, complainId);
			int z=ps.executeUpdate();
			if(z > 0)
				flag=true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	
	
	@Override
	public String checkComplainStatus(int complainId) {
		String status=null;
		try {
			ps=conn.prepareStatement("select complainStatus from complain where complainId=?");
			ps.setInt(1, complainId);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
				status=rs.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return status;
	}

	
	
	@Override
	public String assignComplainToEngg(int complainId, int enggId) {
		try {
			ps=conn.prepareStatement("insert into complainAssign values(?,?,?)");
			ps.setInt(1, complainId);
			ps.setInt(2, enggId);
			ps.setString(3, "processing");
			
			int i = ps.executeUpdate();
			
			if(i>0) {
				ps=conn.prepareStatement("update complain set complainStatus=? where complainId=?");
				ps.setString(1, "processing");
				ps.setInt(2, complainId);
				ps.executeUpdate();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	
	
	@Override
	public ComplainBean getComplain(int complainId) {
		ComplainBean cBean=null;
		
		try {
			ps=conn.prepareStatement("select * from complain where complainId=?");
			ps.setInt(1, complainId);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				cBean = new ComplainBean(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cBean;
	}

	
	
	@Override
	public ArrayList<ComplainBean> getAllComplainDetais() {
		ArrayList<ComplainBean> clist=new ArrayList<ComplainBean>();
		
		try {
			
			ps=conn.prepareStatement("select * from complain");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				
				ComplainBean cBean=new ComplainBean(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7));
				clist.add(cBean);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return clist;
	}



	@Override
	public ArrayList<ComplainBean> getComplainPerCustomer(int customerId) {
		ArrayList<ComplainBean> clist=new ArrayList<ComplainBean>();
		
		try {
			
			ps=conn.prepareStatement("select * from complain where customerId=? ");
			ps.setInt(1, customerId);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				
				ComplainBean cBean=new ComplainBean(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7));
				clist.add(cBean);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return clist;
	}



	@Override
	public ArrayList<ComplainBean> getComplainEnggId(int enggId) {
		ArrayList<ComplainBean> clist=new ArrayList<ComplainBean>();
		
		try {
			
			ps=conn.prepareStatement("select complainId from complainassign where enggId=? ");
			ps.setInt(1, enggId);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				
				int complainId=rs.getInt(1);
				ComplainBean cBean = getComplain(complainId);
				clist.add(cBean);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return clist;
	}

}
