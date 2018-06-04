package atm.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.gjt.mm.mysql.Driver;

public class GetDatabase {
		public static Connection getConnect()
		{
		Connection conn = null;
		String strConnect ="jdbc:mysql://"+"localhost"+"/"+"ffse1703011_atm"+"?useUnicode=true&characterEncoding=utf-8";
		Properties pro = new Properties();
		pro.put("user", "thachnd123");
		pro.put("password", "123456");
		try
		{
		com.mysql.jdbc.Driver driver=new Driver();
		conn = driver.connect(strConnect, pro);
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
		return conn;
		}

}
