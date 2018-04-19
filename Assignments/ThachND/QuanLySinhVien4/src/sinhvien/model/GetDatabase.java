package sinhvien.model;


import java.sql.SQLException;
import java.util.Properties;

import java.sql.Connection;
import com.mysql.jdbc.Statement;

import org.gjt.mm.mysql.Driver;

public class GetDatabase {
	public static Connection getConnect (String strServer, String strDatabase, String strUser, String strPwd)
	{
	Connection conn = null;
	String strConnect ="jdbc:mysql://"+strServer+"/"+strDatabase;
	Properties pro = new Properties();
	pro.put("user", strUser);
	pro.put("password", strPwd);
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

