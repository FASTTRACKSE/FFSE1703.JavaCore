package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class QuanLiLopHocModel {
	private String maLop,tenLop,namHoc;
	final Connection conn = GetConnectDB.getConnect("localhost", "QuanLiTruongHoc", "admin", "admin");
	private static ArrayList<QuanLiLopHocModel> arrMaLop = new ArrayList<>();
	public QuanLiLopHocModel() {
		// TODO Auto-generated constructor stub
	}
	public QuanLiLopHocModel(String maLop,String tenLop,String namHoc) {
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
	public ArrayList<QuanLiLopHocModel> selectLop() {
		try {
			arrMaLop.clear();
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("select MaLop from QLLopHoc");
			while (result.next()) {
				maLop = result.getString("MaLop");
				arrMaLop.add(new QuanLiLopHocModel(maLop,tenLop,namHoc));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return arrMaLop;
	}
	public String toString () {
		return this.maLop;
	}
}
