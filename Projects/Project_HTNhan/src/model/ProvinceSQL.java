package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ProvinceSQL {
	private ArrayList<ProvinceModel> arrProvince = new ArrayList<>();
	final  Connection conn = GetConnectDB.getConnect("localhost", "QuanLiTruongHoc", "admin", "admin");


	public ArrayList<ProvinceModel> selectProvince() {

		try {
			arrProvince.clear();
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("select * from province");
			while (result.next()) {
				String name = result.getString("name");
				String provinceid = result.getString("provinceid");
				ProvinceModel item = new ProvinceModel(provinceid, name);
				arrProvince.add(item);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return arrProvince;
	}
}
