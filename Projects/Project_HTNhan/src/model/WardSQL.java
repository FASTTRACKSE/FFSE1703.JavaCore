package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class WardSQL {
	private static ArrayList<WardModel> arrWard = new ArrayList<>();
	final static Connection conn = GetConnectDB.getConnect("localhost", "QuanLiTruongHoc", "admin", "admin");

	public WardSQL() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<WardModel> selectWard(String districtId) {
		try {
			arrWard.clear();
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("select * from ward where districtid = '" + districtId + "'");
			while (result.next()) {
				String name = result.getString("name");
				arrWard.add(new WardModel(name));
				// arrWard.add(ward);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return arrWard;

	}
}
