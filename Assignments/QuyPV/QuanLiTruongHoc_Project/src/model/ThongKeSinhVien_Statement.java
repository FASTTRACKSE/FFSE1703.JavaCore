package model;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import connector.GetConnect;

public class ThongKeSinhVien_Statement {
	final Connection conn= (new GetConnect()).getConnect("localhost", "Quan_li_truong_hoc", "phamquy481", "a0163763123");
	ArrayList<String> arrNamHoc = new ArrayList<>();
	ArrayList<QuanLiLopHoc_Model> arrLop = new ArrayList<>();
	ArrayList<PhanMon_Model> arrPhanMon = new ArrayList<>(); 
	ArrayList<QuanLiSinhVien_Model> arrThongTinSv = new ArrayList<>();
	ArrayList<QuanLiDiem_Model> arrDiemSv = new ArrayList<>();
	String diemSv;
	
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
	
	public ArrayList<QuanLiLopHoc_Model> sellectAllLop() {
		arrLop.clear();
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
	
	public ArrayList<PhanMon_Model> sellectPhanMon(String ma){
		arrPhanMon.clear();
		try {
			String sql = "select * from Phan_mon where Malop ='" + ma + "'";
			Statement statement=conn.createStatement();
			ResultSet result=statement.executeQuery(sql);
			while(result.next())
			{
				 String maLop = result.getString("Malop");
				 String maMon = result.getString("Mamon");
				 arrPhanMon.add(new PhanMon_Model(maLop, maMon));
			}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		return arrPhanMon;
	}
	
	public ArrayList<QuanLiSinhVien_Model> sellectThongTinSv(String maLop){
		arrThongTinSv.clear();
		try {
			String sql = "select Masv, Hoten from Sinh_vien where Malop ='" + maLop + "'";
			Statement statement=conn.createStatement();
			ResultSet result=statement.executeQuery(sql);
			while(result.next())
			{
				 String maSv = result.getString("Masv");
				 String hoTen = result.getString("Hoten");
				 arrThongTinSv.add(new QuanLiSinhVien_Model(maSv, hoTen));
			}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		
		return arrThongTinSv;
	}
	
	public String diemSv(String maSv, String maMon) {
		diemSv = null;
		try {
			String sql = "select Diem from Diem where Masv ='" + maSv + "'" + "and Mamon = '" + maMon + "'";
			Statement statement=conn.createStatement();
			ResultSet result=statement.executeQuery(sql);
			while(result.next())
			{
				 String diem = result.getString("Diem");
				 diemSv = diem;
				 
			}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		
		return diemSv;
	}
	
	public ArrayList<QuanLiDiem_Model> sellectDiemSv (String maSv){
		arrDiemSv.clear();
		try {
			String sql = "select Diem from Diem where Masv = '" + maSv + "'";
			Statement statement = conn.createStatement();
			ResultSet result=statement.executeQuery(sql);
			while(result.next())
			{
				String diem = result.getString("Diem");
				arrDiemSv.add(new QuanLiDiem_Model(diem));
			}
			} catch (Exception e) {
			e.printStackTrace();
			}
		return arrDiemSv;
	}
	
}
