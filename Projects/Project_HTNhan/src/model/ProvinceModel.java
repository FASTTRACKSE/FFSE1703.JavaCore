package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ProvinceModel {
	private static ArrayList<ProvinceModel> arrProvince = new ArrayList<>();
	private String provinceid,name;
	final static Connection conn = GetConnectDB.getConnect("localhost", "QuanLiTruongHoc", "admin", "admin");
	public ProvinceModel() {
		// TODO Auto-generated constructor stub
	}
	public ProvinceModel(String provinceid,String name) {
		this.provinceid = provinceid;
		this.name = name;
	}
	public String getProvinceid() {
		return provinceid;
	}
	public void setProvinceid(String provinceid) {
		this.provinceid = provinceid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<ProvinceModel> selectProvince() {

		try {
			arrProvince.clear();
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("select * from province");
			while (result.next()) {
				provinceid = result.getString("provinceid");
				name = result.getString("name");
				arrProvince.add(new ProvinceModel(provinceid,name));

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return arrProvince;
	}
	public String toString() {
		return this.name;
	}
}
