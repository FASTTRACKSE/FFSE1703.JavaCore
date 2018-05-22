package model;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;;

public class LoginSQL {
	final static Connection conn = GetConnectDB.getConnect("localhost", "QuanLiTruongHoc", "admin", "admin");
	public static boolean checkLogin(String username, String password) {
		try {
			String sql = "select * from user where username = ? and password = ?";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, username);
			stm.setString(2, password);
			ResultSet result = stm.executeQuery();
			if (!result.next()) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
