package ketnoisql;

import java.sql.SQLException;
import java.util.Properties;

import org.gjt.mm.mysql.Driver;

import com.mysql.jdbc.Connection;

public class ketnoisql {
	public static void main(String[] args) {
		Connection conn= getConnect("localhost", "ffse1703", "BINiPad1999", "Whattf2014");
		if(conn!=null){
			System.out.println("KếtnốiMYSQL thànhcông");
		} else {
			System.out.println("KếtnốiMYSQL thấtbại");}
	}
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
		catch(SQLException ex){
			ex.printStackTrace();
			}
		return conn;
			}
}