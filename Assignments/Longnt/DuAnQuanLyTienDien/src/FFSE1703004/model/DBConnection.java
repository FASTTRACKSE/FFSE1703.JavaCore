package FFSE1703004.model;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import org.gjt.mm.mysql.Driver;

import com.mysql.jdbc.PreparedStatement;


public class DBConnection {
//	static Connection conn = ketnoi("localhost", "ffse1703004_java", "admin", "123");
	static Connection conn= ketnoi("localhost", "ffse1703004_java", "thanhlong123",
			"123456");
	public static void main(String[] args) {
				if(conn!=null)
				{
				System.out.println("Kết nối MYSQL thành công");
				}
				
				else
				{
				System.out.println("Kết nối MYSQL thất bại");
				}

	}

	public static Connection ketnoi(String strServer,String strDatabase,
			String strUser,String strPwd)
			{
			Connection conn=null;
			String strConnect="jdbc:mysql://"+strServer+"/"+strDatabase;
			Properties pro=new Properties();
			pro.put("user", strUser);
			pro.put("password", strPwd);
			try
			{
			com.mysql.jdbc.Driver driver=new Driver();
			conn=(Connection) driver.connect(strConnect, pro);
			}
			catch(SQLException ex)
			{
			ex.printStackTrace();
			}
			return conn;
			}
	public static boolean checkLogin(String username, String password) {
		try {
			String sql = "select * from Users where username = ? and password = ?";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
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

	public static boolean checkConnection() {
		if (conn != null) {
			return true;
		} else {
			return false;
		}
	}

	public static ResultSet getBienLai(String text) {
		// TODO Auto-generated method stub
		return null;
	}
}
