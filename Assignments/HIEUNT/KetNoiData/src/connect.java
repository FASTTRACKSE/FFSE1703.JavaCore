import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.Statement;

public class connect {



	public static void main(String[] args) {
		layDuLieu();

				
				
				
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
	catch(SQLException ex)
	{
	ex.printStackTrace();
	}
	return conn;
	}
	public static void layDuLieu() {
		Connection conn= getConnect("localhost", "QuanLySinhVien", "QuanLySinhVien","QuanLySinhVien");
		if(conn!=null)
		{
		System.out.println("Kết nối MYSQL thành công");
		}
		else
		{
		System.out.println("Kết nối MYSQL thất bại");
		}
		try {
			Statement statement=(Statement) conn.createStatement();
			ResultSet result=statement.executeQuery("SELECT * FROM `QuanLySinhVien`");
			while(result.next())
			{
			System.out.println("♥♥♥--------------------------------♥♥♥");
			System.out.println("       STT  TÊN	  TUỔI  LỚP");
			System.out.println("♥♥♥--------------------------------♥♥♥");
			System.out.println("	"+result.getString("STT")+"   "+result.getString("TÊN")+"   "+result.getString("TUỔI")+"	"+result.getString("LỚP"));
			}
			} catch (Exception e) {
			e.printStackTrace();
			}
	}


	

}
