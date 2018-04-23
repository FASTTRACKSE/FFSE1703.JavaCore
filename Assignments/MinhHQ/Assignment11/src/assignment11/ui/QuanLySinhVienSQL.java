package assignment11.ui;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Driver;

public class QuanLySinhVienSQL{
	
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

	
//	public static void main(String[] args) {
//
//		Connection conn = getConnect("localhost", "minhad", "minhad", "minh");
//		if (conn != null) {
//			System.out.println("Kết nối MYSQL thành công");
//		} else {
//			System.out.println("Kết nối MYSQL thất bại");
//		}
	
//		try {
//			Statement statement = conn.createStatement();
//			ResultSet result = statement.executeQuery("select * from quanlysinhvien");
//			while (result.next()) {
//				String maSV = result.getString("maSV");
//				String tenSV = result.getString("tenSV");
//				String tuoiSV = result.getString("tuoiSV");
//				String lopSV = result.getString("lopSV");
//				
//				System.out.println(maSV + tenSV + tuoiSV + lopSV);
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

//		try{
//			Statement statement=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
//			ResultSet result=statement.executeQuery("select * from quanlysinhvien");
//			while(result.next()){
//				System.out.println(result.getString("lopSV"));
//				}
//			} catch(Exception e) {
//				e.printStackTrace();
//		}
//	}
	
	


	
}
	
