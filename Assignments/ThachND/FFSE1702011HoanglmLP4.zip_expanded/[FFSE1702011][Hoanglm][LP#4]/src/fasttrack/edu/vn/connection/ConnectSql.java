package fasttrack.edu.vn.connection;

import java.sql.SQLException;
import java.util.Properties;
import java.sql.*;
import com.mysql.*;
import java.util.*;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;

public class ConnectSql {
		public static Connection getConnect(String strServer, String strDatabase, String strUser, String strPwd) {
			Connection conn = null;
			String strConnect="jdbc:mysql://" + strServer + "/" + strDatabase + "?useUnicode=true&characterEncoding=utf-8";
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
		
		public static void main(String[] args) {
			Connection conn = getConnect("localhost", "ffse1702011", "ffse1702011", "123456");
			if(conn!=null) {
				System.out.print("Kết nối MySQL thành công");
			} else {
				System.out.print("Kết nối MySQL thất bại");
			}
		}
}