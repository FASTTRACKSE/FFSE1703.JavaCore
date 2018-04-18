import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.jdbc.Driver;

public class Connect {
	public static void main(String[] args) {

		Connection conn = getConnect("localhost", "admin", "minhad", "minh");
		if (conn != null) {
			System.out.println("Kết nối MYSQL thành công");
		} else {
			System.out.println("Kết nối MYSQL thất bại");
		}
		
		
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("select * from FFSE1702063_user");
			while (result.next()) {
				System.out.println(result.getString("username"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		try{
			Statement statement=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet result=statement.executeQuery("select * from FFSE1702063_user");
			while(result.next()){
				System.out.println(result.getString("fullname"));
				}
			} catch(Exception e) {
				e.printStackTrace();
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
			conn = (Connection) driver.connect(strConnect, pro);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return conn;
	}
}
