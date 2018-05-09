package fasttrackse.edu.vn.ass11.ui;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.gjt.mm.mysql.Driver;

public class QuanLySinhVienslq {
	public static Connection getConnect(String strServer, String strDatabase, String strUser, String strPwd) {
		Connection conn = null;
		String strConnect = "jdbc:mysql://" + strServer + "/" + strDatabase;
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
