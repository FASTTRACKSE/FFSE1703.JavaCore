package model;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import connector.GetConnect;

public class TinhThanh {
	private String name, provinceId;
	private String selectProvinceId;
	private PreparedStatement ps;
	

	public TinhThanh() {
		//
	}

	public TinhThanh(String provinceId, String name) {
		this.name = name;
		this.provinceId = provinceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	
//	public String selectProvinceId(String name) {
//		try {
//
//			String sql = "select * from Tinh_thanh where name = '" + name + "'";
//			ps = (PreparedStatement) conn.prepareStatement(sql);
//			// Statement statement=conn.createStatement();
//			ResultSet result = ps.executeQuery();
//			while (result.next()) {
//				this.selectProvinceId = result.getString("provinceid");
//			}
//
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//		return selectProvinceId;
//
//	}

	@Override
	public String toString() {
		return this.name;
	}

}
