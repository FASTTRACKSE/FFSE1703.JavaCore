package model;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import connector.GetConnect;
import ui.QuanLiLopHoc;

public class QuanLiLopHoc_Model {
	private String maLop, tenLop, namHoc;
	final Connection conn= (new GetConnect()).getConnect("localhost", "Quan_li_truong_hoc", "phamquy481", "a0163763123");
	ArrayList<QuanLiLopHoc_Model> arrLop = new ArrayList<>();
	public QuanLiLopHoc_Model() {
		//
	}
	
	public QuanLiLopHoc_Model(String maLop, String tenLop, String namHoc) {
		this.maLop = maLop;
		this.tenLop = tenLop;
		this.namHoc = namHoc;
	}

	public String getMaLop() {
		return maLop;
	}

	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}

	public String getTenLop() {
		return tenLop;
	}

	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}

	public String getNamHoc() {
		return namHoc;
	}

	public void setNamHoc(String namHoc) {
		this.namHoc = namHoc;
	}
	
	public ArrayList<QuanLiLopHoc_Model> sellectAllLop(){
		//arrLop.clear();
		try {
			String sql = "select * from Lop";
			Statement statement=conn.createStatement();
			ResultSet result=statement.executeQuery(sql);
			while(result.next())
			{
				 String maLop = result.getString("Malop");
				 String tenLop = result.getString("Tenlop");
				 String namHoc = result.getString("Namhoc");
				 arrLop.add(new QuanLiLopHoc_Model(maLop, tenLop, namHoc));
			}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		return arrLop;
	}

	
	
	
	@Override
	public String toString() {
		return this.maLop;
	}
	
}
