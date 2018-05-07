package main;

import com.mysql.jdbc.Connection;

import model.GetConnectDB;
import ui.QuanLiTruongHocUI;

public class QuanLiTruongHoc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuanLiTruongHocUI myUI = new QuanLiTruongHocUI ("Quản Lí Trường Học");
		myUI.showWindow();
		Connection conn = GetConnectDB.getConnect("localhost", "QuanLiTruongHoc", "admin", "admin");
		if (conn != null) {
			System.out.println("Kết nối MYSQL thành công");
		} else {
			System.out.println("Kết nối MYSQL thất bại");
		}
	}

}
