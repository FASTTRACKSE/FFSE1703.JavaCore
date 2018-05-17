package ffse1703020.qltv.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.JOptionPane;

import org.gjt.mm.mysql.Driver;

public class ConnectDB {

	private String strServer = "localhost";
	private String strDatabase = "ffse1703020_qltv";
	private String strUser = "admin1703";
	private String strPwd = "admin1703";

	public Connection getConnect() {
		Connection conn = null;
		String strConnect="jdbc:mysql://"+strServer+"/"+strDatabase;
		Properties pro = new Properties();
		pro.put("user", strUser);
		pro.put("password", strPwd);
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
