package fasttrackse.edu.connect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.gjt.mm.mysql.Driver;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DBConnection{

	public static void main(String[] args) {
		Connection conn= ketnoi("localhost", "ffse1703", "thanhlong123",
				"123456");
				if(conn!=null)
				{
				System.out.println("Kết nối MYSQL thành công");
				try {
					Statement statement= (Statement )conn.createStatement();
					ResultSet result=statement.executeQuery
					("select * from sinhvien");
					while(result.next())
					{
				    System.out.println(result.getString("masv"));
					System.out.print(result.getString("tensv"));
					System.out.println(result.getString("tuoisv"));
					System.out.println(result.getString("lop"));
					}
					} catch (Exception e) {
					e.printStackTrace();
					}
				    }
				else
				{
				System.out.println("Kết nối MYSQL thất bại");
				}

	}
	public static Connection ketnoi(String strServer,String strDatabase,
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
