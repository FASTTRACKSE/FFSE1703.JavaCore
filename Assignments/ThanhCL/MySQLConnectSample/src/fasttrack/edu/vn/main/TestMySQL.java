package fasttrack.edu.vn.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.jdbc.Driver;

public class TestMySQL {

	public static void main(String[] args) {
		try {
			String strConn = "jdbc:mysql://localhost/appjavacuatoi??useUnicode=true&characterEncoding=UTF-8";
			Properties pro = new Properties();
			pro.put("user", "appjavacuatoi");// root là account mặc lúc ta cài đặt XAMP
			pro.put("password", "appjavacuatoi");
			Driver driver = new Driver();
			Connection conn = driver.connect(strConn, pro);
			if (conn != null)
				System.out.println("Kết nối tới CSDL dbtaisan thành công");
			else
				System.err.println("Kết nối tới CSDL dbtaisan thất bại");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
