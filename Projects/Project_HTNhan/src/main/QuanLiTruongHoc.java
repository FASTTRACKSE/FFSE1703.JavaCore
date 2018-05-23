package main;

import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.mysql.jdbc.Connection;

import model.GetConnectDB;
import ui.LoginUI;

public class QuanLiTruongHoc {

	public static void main(String[] args) {
		Connection conn = GetConnectDB.getConnect("localhost", "QuanLiTruongHoc", "admin", "admin");
		if (conn != null) {
			System.out.println("Kết nối MYSQL thành công");
		} else {
			System.out.println("Kết nối MYSQL thất bại");
		}
		
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI myUI = new LoginUI ("Quản Lí Trường Học");
					myUI.showWindow();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
