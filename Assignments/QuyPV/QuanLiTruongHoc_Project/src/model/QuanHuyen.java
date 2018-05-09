package model;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import connector.GetConnect;

public class QuanHuyen {
	private String name, districId;
	private String selectDistrictId;
	private PreparedStatement ps;
	final Connection conn= (new GetConnect()).getConnect("localhost", "Quan_li_truong_hoc", "phamquy481", "a0163763123");
	ArrayList<QuanHuyen> arrQuanHuyen = new ArrayList<>();
	public QuanHuyen() {
		//
	}
	
	public QuanHuyen(String name, String districtId) {
		this.name = name;
		this.districId = districtId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDistricId() {
		return districId;
	}

	public void setDistricId(String districId) {
		this.districId = districId;
	}

	
	public ArrayList<QuanHuyen> selectQuanHuyen(String provinceId){
		arrQuanHuyen.clear();
		try {
			String sql = "select * from Quan_huyen where provinceid =" + "'"+ provinceId +"'";
			//Statement statement=conn.createStatement();
			Statement statement=conn.createStatement();
			ResultSet result=statement.executeQuery(sql);
//			ps = (PreparedStatement) conn.prepareStatement(sql);
//			ResultSet result=ps.executeQuery();
			while(result.next())
			{
				 String name = result.getString("name");
				 String districtId = result.getString("districtid");
				 arrQuanHuyen.add(new QuanHuyen(name, districtId));
				 //System.out.println(nameQuanHuyen);
			}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		return arrQuanHuyen;
	}
	
//	public String selectDistrictId(String nameQuanHuyen) {
//		try {
//			
//			String sql = "select * from Quan_huyen where name = '"+nameQuanHuyen+"'";
//			ps = (PreparedStatement) conn.prepareStatement(sql);
//			ResultSet result=ps.executeQuery();
//			while(result.next())
//			{
//				this.selectDistrictId = result.getString("districtid");
//				
//			}
//			} catch (Exception ex) {
//				ex.printStackTrace();
//			}	
//		
//		return selectDistrictId;
//	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
}
