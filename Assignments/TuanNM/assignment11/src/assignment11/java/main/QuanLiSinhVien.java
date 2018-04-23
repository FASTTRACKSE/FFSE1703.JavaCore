package assignment11.java.main;

import java.sql.Connection;

import java.sql.SQLException;
import assignment11.java.connect.Connect;
import assignment11.java.model.SinhVien;

import assignment11.java.ui.SinhVien2;


import org.gjt.mm.mysql.Driver;

public class QuanLiSinhVien {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinhVien2 myUI = new SinhVien2("Quản Lí Sinh Viên");
		myUI.showWindow();
		Connection conn= Connect.getConnect("localhost", "Java", "tuan18081999","tuan123");
				if(conn!=null)
				{
				System.out.println("Kết nối MYSQL thành công");
				}
				else
				{
				System.out.println("Kết nối MYSQL thất bại");
				}
	}

}
