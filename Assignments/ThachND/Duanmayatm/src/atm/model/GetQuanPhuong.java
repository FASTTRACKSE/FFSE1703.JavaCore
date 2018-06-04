package atm.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import  java.sql.Statement;

public class GetQuanPhuong {
	
	static Connection conn=  GetDatabase.getConnect();
	
	public static ArrayList<String> getQuan(){
		ArrayList<String> arrDiaChi = new ArrayList<String>();
		try {
			String sql = "select name, maqh from quan";
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				arrDiaChi.add(rs.getString("name"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return arrDiaChi;
	}
	public static ArrayList<String> getPhuong(int id){
		ArrayList<String> arrDiaChi = new ArrayList<String>();
		try {
			String sql = "select name, maqh from phuong where maqh = " + id;
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				arrDiaChi.add(rs.getString("name"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return arrDiaChi;
	}
}
	
