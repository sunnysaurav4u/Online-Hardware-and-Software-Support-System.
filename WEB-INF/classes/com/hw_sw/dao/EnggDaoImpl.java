package com.hw_sw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.hw_sw.utility.DBUtil;

import beanPack.EnggBean;

public class EnggDaoImpl implements EnggDao {

	Connection conn = null;
	PreparedStatement ps;
	//private String enggPassword;
	//private String enggMobile;

	public EnggDaoImpl() {
		conn = DBUtil.getConnect();
	}

	@Override
	public int addEngg(EnggBean ebean) {
		int id = 0;

		try {
			PreparedStatement ps = conn.prepareStatement("insert into engg(enggName,enggMail,enggMobile,enggPassword) values(?,?,?,?)",Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, ebean.getenggName() );
			ps.setString(2,ebean.getenggMail());
			ps.setString(3,ebean.getenggMobile());
			ps.setString(4, ebean.getEnggPassword());
			
			int x=ps.executeUpdate();
			if(x>0){
				ResultSet rs=ps.getGeneratedKeys();
				
				if(rs.next())
					id=rs.getInt(1);
					
			}


		}// try
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// catch

		return id;
	}// addEngg();




	@Override
	public EnggBean getEnggDetails(int enggId) {
		EnggBean ebean = null;

		try {
			PreparedStatement ps = conn.prepareStatement("select * from engg where enggId=?");

			ps.setInt(1, enggId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				/*
				 * int eid=rs.getInt(1); String ename=rs.getString(2); int
				 * esal=rs.getInt(3);
				 * 
				 * ebean=new EmpBean(eid, ename, esal);
				 */

				ebean = new EnggBean(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ebean;
	}



	@Override
	public ArrayList<EnggBean> getAllEngineerDetails() {
		ArrayList<EnggBean> elist = new ArrayList<EnggBean>();

		try {
			PreparedStatement ps = conn.prepareStatement("select * from engg");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int enggId=rs.getInt(1);
				String enggName=rs.getString(2);
				String enggMail=rs.getString(3);
				String enggPassword=rs.getString(4);
				String enggMobile=rs.getString(5);


				EnggBean ebean = new EnggBean(enggId, enggName, enggMail,enggPassword, enggMobile);

				elist.add(ebean);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return elist;
	}

	@Override
	public boolean removeEngg(int enggId) {
		boolean flag=false;

		try {
			PreparedStatement ps=conn.prepareStatement("delete from engg where enggId=?");
			ps.setInt(1,enggId);
			int x = ps.executeUpdate();

			if (x > 0)
				flag = true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flag;
	}



	@Override
	public boolean updateEngg(EnggBean ebean) {
		boolean flag=false;
		if(ebean!=null){
		try {
			int id=ebean.getenggId();
			String pass =ebean.getEnggPassword();
			String mobile=ebean.getenggMobile();
			
		
			
			PreparedStatement ps=conn.prepareStatement("update engg set enggPassword=?, enggMobile=? where enggId="+id);
			ps.setString(1, pass);
			ps.setString(2, mobile);
			
			
			int x = ps.executeUpdate();

			if (x > 0){
				
				//request.getSession().setAttribute("eng_list", ebean);
				flag = true;
			}
				

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			flag=true;
		}
		return flag;
	}

	@Override
	public boolean validateEngg(String enggMail, String enggPassword) {
		try {
			ps = conn.prepareStatement("select enggPassword from engg where enggMail=?");
			ps.setString(1, enggMail);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				if(rs.getString(1).equals(enggPassword))
					return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public int idByEnggMail(String enggMail) {
		try {
			ps=conn.prepareStatement("select enggId from engg where enggMail=?");
			ps.setString(1, enggMail);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				return rs.getInt(1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public boolean assignComplainToEngg(int complainId, String enggMail) {
		try {
			
			int id=idByEnggMail(enggMail);
			
			PreparedStatement ps1=conn.prepareStatement("insert into complainassign values(?,?)");
			ps1.setInt(1, complainId);
			ps1.setInt(2, id);
			
			int r = ps1.executeUpdate();
			
			ps1=conn.prepareStatement("update complain set complainStatus='Processing' where complainId=?");
			ps1.setInt(1, complainId);
			
			int s = ps1.executeUpdate();
			
			if(r>0 && s>0)
				return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

}
