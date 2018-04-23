package quanlisinhvien.main;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import quanlisinhvien.connect.*;
import quanlisinhvien.ui.*;

public class QuanLiSinhVien {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuanLi myUI = new QuanLi("Quan Li Sinh Vien");
		myUI.showWindow();
		Connection conn = GetConnect.getConnect("localhost", "admin", "admin", "admin");
		if (conn != null) {
			JOptionPane.showMessageDialog(null, "Kết nối MYSQL thành công");
		} else {
			JOptionPane.showMessageDialog(null, "Kết nối MYSQL thất bại");
		}
	}
}
