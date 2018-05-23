package fasttrackse.edu.vn.project4.main;

import java.sql.Connection;

import fasttrackse.edu.vn.project4.model.Connect;
import fasttrackse.edu.vn.project4.ui.MyQuanLyDiemUI;


public class QuanLyDiem {
public static void main(String[] args) {
		
	MyQuanLyDiemUI myUI = new MyQuanLyDiemUI("Quản Lý Trường Học.");
		myUI.showWindow();
		Connection conn = Connect.getConnect("localhost", "project4", "viettu", "12345");
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
