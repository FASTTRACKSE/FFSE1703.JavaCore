package ffse1702050.edu.vn.connectData;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;


import com.mysql.jdbc.Driver;

public class ConnectData {
	public static void main(String[] args) {

		Connection conn = (Connection) getConnect("localhost", "Lp4", "Lp4", "12345");
		if (conn != null) {
			System.out.println("Kết nối MYSQL thành công");
		} else {
			System.out.println("Kết nối MYSQL thất bại");
		}
	}
	
	public static Connection getConnect(String strServer, String strDatabase, String strUser, String strPwd) {
		Connection conn = null;
		String strConnect = "jdbc:mysql://" + strServer + "/" + strDatabase + "?useUnicode=true&characterEncoding=utf-8";
		Properties pro = new Properties();
		pro.put("user", strUser);
		pro.put("password", strPwd);
		try {
			com.mysql.jdbc.Driver driver = new Driver();
			conn = (Connection) driver.connect(strConnect, pro);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return conn;
	}
}