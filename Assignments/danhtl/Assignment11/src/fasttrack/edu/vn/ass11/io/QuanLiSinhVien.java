package fasttrack.edu.vn.ass11.io;

import java.sql.Connection;

import fasttrack.edu.vn.ass11.ui.MyQuanLiSinhVien;

public class QuanLiSinhVien {
	public static void main(String[] args) {
		MyQuanLiSinhVien myUI = new MyQuanLiSinhVien("Quản Lý Sinh Viên");
		myUI.showWindow();
		
	}

	public static Connection getConnect(String string, String string2, String string3, String string4) {
		// TODO Auto-generated method stub
		return null;
	}
}