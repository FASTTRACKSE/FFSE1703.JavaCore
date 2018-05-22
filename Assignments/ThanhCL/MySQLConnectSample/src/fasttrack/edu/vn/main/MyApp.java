package fasttrack.edu.vn.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.jdbc.Driver;

public class MyApp {

	public static void main(String[] args) {
		java.sql.Connection conn = getConnect("localhost", "qlsv2018", "qlsv2018", "qlsv2018");
		if (conn != null) {
			System.out.println("Kết nối MYSQL thành công");

			try {
				Statement statement = (Statement) conn.createStatement();
				String myQuery = "SELECT * FROM lms_users";
				ResultSet result = statement.executeQuery(myQuery);
				while (result.next()) {
					System.out.println(result.getInt(10));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			System.out.println("Kết nối MYSQL thất bại");
		}
	}

	public static Connection getConnect(String strServer, String strDatabase, String strUser, String strPwd) {
		Connection conn = null;
		String strConnect = "jdbc:mysql://" + strServer + "/" + strDatabase;
		Properties pro = new Properties();
		pro.put("user", strUser);
		pro.put("password", strPwd);
		try {
			com.mysql.jdbc.Driver driver = new Driver();
			conn = driver.connect(strConnect, pro);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return conn;
	}

}
