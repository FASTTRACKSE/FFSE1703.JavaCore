package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DistrictSQL {
	private static ArrayList<DistrictModel> arrDistrict = new ArrayList<>();
	final static Connection conn = GetConnectDB.getConnect("localhost", "QuanLiTruongHoc", "admin", "admin");
	public DistrictSQL() {
		// TODO Auto-generated constructor stub
	}
	public ArrayList<DistrictModel> selectDistrict(String provinceId) {
		try {
			arrDistrict.clear();
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("select * from district where provinceid = '" + provinceId + "'");
			while (result.next()) {
				String districtid = result.getString("districtid");
				String name = result.getString("name");
				arrDistrict.add(new DistrictModel(districtid,name));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return arrDistrict;

	}
}
