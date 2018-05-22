package model;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import connector.GetConnect;

public class ThongKeLopHocStatement {
	final Connection conn= (new GetConnect()).getConnect("localhost", "Quan_li_truong_hoc", "phamquy481", "a0163763123");
	
	ArrayList<String> arrNamHoc = new ArrayList<>();
	ArrayList<QuanLiLopHoc_Model> arrDanhSachLop = new ArrayList<>();
	
	public ArrayList<String> sellectNamHoc(){
		arrNamHoc.clear();
		try {
			String sql = "select distinct Namhoc from Lop";
			Statement statement=conn.createStatement();
			ResultSet result=statement.executeQuery(sql);
			while(result.next())
			{
				 String namHoc = result.getString("Namhoc");
				
				 arrNamHoc.add(namHoc);
			}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		return arrNamHoc;
	}
	
	
}
