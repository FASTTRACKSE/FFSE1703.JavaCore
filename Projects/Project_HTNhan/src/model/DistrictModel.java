package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DistrictModel {
	private String districtid,name ;
	private static ArrayList<DistrictModel> arrDistrict = new ArrayList<>();
	final static Connection conn = GetConnectDB.getConnect("localhost", "QuanLiTruongHoc", "admin", "admin");
	public DistrictModel() {
		// TODO Auto-generated constructor stub
	}
	public DistrictModel(String districtid,String name) {
		this.districtid = districtid;
		this.name = name;
	}
	public String getDistrictid() {
		return districtid;
	}
	public void setDistrictid(String districtid) {
		this.districtid = districtid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<DistrictModel> selectDistrict(String provinceId) {
		try {
			arrDistrict.clear();
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("select * from district where provinceid = '" + provinceId + "'");
			while (result.next()) {
				districtid = result.getString("districtid");
				name = result.getString("name");
				arrDistrict.add(new DistrictModel(districtid,name));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return arrDistrict;

	}
	public String toString () {
		return this.name;
	}
}
