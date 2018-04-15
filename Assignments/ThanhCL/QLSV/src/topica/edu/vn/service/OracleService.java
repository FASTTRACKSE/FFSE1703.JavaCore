package topica.edu.vn.service;

import java.sql.Connection;
import java.sql.DriverManager;

public class OracleService {
	protected Connection conn;
	public OracleService()
	{
		try
		{
			String strConn="jdbc:oracle:thin:@localhost:1521/xe";
			conn=DriverManager.getConnection(strConn, "admin","#Hoilamgi1");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
