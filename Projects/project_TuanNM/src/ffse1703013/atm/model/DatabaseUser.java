package ffse1703013.atm.model;

import java.sql.Connection;
import java.sql.ResultSet;

import com.mysql.jdbc.PreparedStatement;

public class DatabaseUser {
	final static Connection conn = ConnectDatabase.getConnect("localhost", "FFSE1703013_ATM", "tuan18081999",
			"tuan123");

	public static boolean checkLogin(String userName, String pass) {
		try {
			String sql = "select * from User where username = ? and pass = ?";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1, userName);
			stm.setString(2, pass);
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

	public static boolean checkLoginGD(String soThe, String maPin) {
		try {
			String sql = "select * from khachhang where soThe = ? and maPin = ?";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1, soThe);
			stm.setString(2, maPin);
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
