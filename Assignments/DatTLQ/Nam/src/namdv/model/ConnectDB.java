package namdv.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.gjt.mm.mysql.Driver;

public class ConnectDB {

	private String strServer = "localhost";
	private String strDatabase = "Java";
	private String strUser = "ttien96";
	private String strPwd = "zxcv1234";

	public Connection getConnect() {
		Connection conn = null;
		String strConnect = "jdbc:mysql://" + strServer + "/" + strDatabase
				+ "?useUnicode=true&characterEncoding=utf-8";
		Properties pro = new Properties();
		pro.put("user", strUser);
		pro.put("password", strPwd);
		try {
			com.mysql.jdbc.Driver driver = new Driver();
			conn = (Connection) driver.connect(strConnect, pro);
		} catch (SQLException ex) {
			System.err.println("Kết nối Database thất bại!");
			// ex.printStackTrace();
		}
		return conn;
	}
}