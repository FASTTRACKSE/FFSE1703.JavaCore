package ffse1703020.qltv.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;



import com.mysql.jdbc.Driver;

public class ConnectDB {

	public static Connection getConnect() {
		Connection conn = null;
		String strConnect = "jdbc:mysql://" + "localhost" + "/" + "ffse1703020_qltv" + "?useUnicode=true&characterEncoding=utf-8";
		Properties pro = new Properties();
		pro.put("user", "tuan");
		pro.put("password", "12345");
		try {
			com.mysql.jdbc.Driver driver = new Driver();
			conn = (Connection) driver.connect(strConnect, pro);
		} catch (SQLException ex) {
			System.err.println("Kết nối Database thất bại!");
//			ex.printStackTrace();
		}
		return conn;
}
}
