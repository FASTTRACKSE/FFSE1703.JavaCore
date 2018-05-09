package ffse1702.edu.vn.model;

import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;

public class ConnectData {
	public static Connection getConnect(String strServer,String strDatabase,String strUser,String strPwd)
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

}
