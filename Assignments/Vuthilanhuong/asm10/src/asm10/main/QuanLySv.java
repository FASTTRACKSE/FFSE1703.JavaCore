package asm10.main;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.gjt.mm.mysql.Driver;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import asm10.ui.*;
public class QuanLySv {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			Layout myUI = new Layout("Chương trình quản lý sinh viên");
			myUI.showWindow();
			Connection conn= getConnect("localhost", "sinhvien", "huong",
					"12345");
					if(conn!=null)
					{
					System.out.println("Kết nối MYSQL thành công");
					}
					else
					{
					System.out.println("Kết nối MYSQL thất bại");
					}
	}
	public static Connection getConnect(String strServer,String strDatabase,
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
}
