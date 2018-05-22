package model;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

import connector.GetConnect;

public class QuanLiSinhVien_Model {
	private String maSv, hoTen, diaChi, Phuong, quanHuyen, tinhThanh, dienThoai, email, maLop;
	
	public QuanLiSinhVien_Model() {
		//
	}
	
	public QuanLiSinhVien_Model(String maSv, String hoTen, String diaChi, String Phuong, String quanHuyen, String tinhThanh, String dienThoai, String email, String maLop) {
		this.maSv = maSv;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.Phuong = Phuong;
		this.quanHuyen = quanHuyen;
		this.tinhThanh = tinhThanh;
		this.dienThoai = dienThoai;
		this.email = email;
		this.maLop = maLop;
		
	}
	
	public QuanLiSinhVien_Model(String maSv, String hoTen) {
		this.maSv = maSv;
		this.hoTen = hoTen;
	}

	public String getMaSV() {
		return maSv;
	}

	public void setMaSV(String maSV) {
		this.maSv = maSV;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getPhuong() {
		return Phuong;
	}

	public void setPhuong(String Phuong) {
		this.Phuong = Phuong;
	}

	public String getQuanHuyen() {
		return quanHuyen;
	}

	public void setQuanHuyen(String quanHuyen) {
		this.quanHuyen = quanHuyen;
	}

	public String getTinhThanh() {
		return tinhThanh;
	}

	public void setTinhThanh(String tinhThanh) {
		this.tinhThanh = tinhThanh;
	}

	public String getDienThoai() {
		return dienThoai;
	}

	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMaLop() {
		return maLop;
	}

	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}
	
	
	
//	public ArrayList<QuanLiSinhVien_Model> selectWhere(String maSv){
//		try {
//			Statement statement = conn.createStatement();
//			ResultSet result=statement.executeQuery("select * from Sinh_Vien where Masv = '"+ maSv + "'");
//			while(result.next())
//			{
//				String maSV = result.getString("Masv");
//				String hoTen = result.getString("Hoten");
//				String diachi = result.getString("Diachi");
//				String phuong = result.getString("Phuong");
//				String quanHuyen = result.getString("Quanhuyen");
//				String tinhThanh = result.getString("Tinhthanh");
//				String dienThoai = result.getString("Dienthoai");
//				String email = result.getString("Email");
//				String maLop = result.getString("Malop");
//				arrSvWhere.add(new QuanLiSinhVien_Model(maSV, hoTen, diachi, phuong, quanHuyen, tinhThanh, dienThoai, email, maLop));
//			}
//			} catch (Exception e) {
//			e.printStackTrace();
//			}
//		return arrSvWhere;
//	}
	
	@Override
	public String toString() {
		return this.maSv;
	}
}
