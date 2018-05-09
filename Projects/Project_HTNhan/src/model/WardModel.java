package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class WardModel {
	private String name;
	private static ArrayList<WardModel> arrWard = new ArrayList<>();
	final static Connection conn = GetConnectDB.getConnect("localhost", "QuanLiTruongHoc", "admin", "admin");
	public WardModel() {
		// TODO Auto-generated constructor stub
	}
	public WardModel(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public ArrayList<WardModel> selectWard(String districtId) {
		try {
			arrWard.clear();
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("select * from ward where districtid = '" + districtId + "'");
			while (result.next()) {
				name = result.getString("name");
				arrWard.add(new WardModel(name));
				//arrWard.add(ward);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return arrWard;

	}
	public String toString() {
		return this.name;
	}
}
