package sinhvien.main;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import org.gjt.mm.mysql.Driver;

import com.mysql.jdbc.Statement;

import sinhvien.ui.*;
public class QuanLy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WindowLayout myUi = new WindowLayout("Window");
		myUi.showWindow();
		Connection conn= getConnect("localhost", "ffse1703011", "thachnd", "123456");
			if(conn!=null)
			{
				System.out.println("KếtnốiMYSQL thànhcông");
				try
				{
					Statement statement = (Statement) conn.createStatement();
					ResultSet result=statement.executeQuery("select * from NguoiDung");
					while(result.next())
					{
						System.out.println(result.getString("HoTen"));
						}
					} catch(Exception e) {
						e.printStackTrace();
				}
			}
			else
			{
				System.out.println("KếtnốiMYSQL thấtbại");
			}
		}
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
	

