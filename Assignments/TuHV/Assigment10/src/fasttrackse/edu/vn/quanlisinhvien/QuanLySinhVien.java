package fasttrackse.edu.vn.quanlisinhvien;
import java.sql.SQLException;
import java.util.Properties;

import org.gjt.mm.mysql.Driver;

import com.mysql.jdbc.Connection;

import fasttrackse.edu.vn.quanlisinhvien.ui.*;


public class QuanLySinhVien {
	public static void main(String[] args) {
		MyQuanLySinhVienUI myUI = new MyQuanLySinhVienUI("Quan Ly Sinh Vien");
		myUI.showWindow();
		Connection conn= getConnect("localhost", "sinhviendb", "tu",
				"123456");
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
