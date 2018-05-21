package project.main;

import java.sql.SQLException;
import java.util.Properties;

import org.gjt.mm.mysql.Driver;

import com.mysql.jdbc.Connection;

import project.model.ConnectDB;
import project.ui.*;;

public class QuanLyKH {
	static ConnectDB conn = new ConnectDB();
	
	public static void main(String[] args) {

		LayoutKH myUI = new LayoutKH("Quản Lý ATM");
		myUI.showWindow();
		conn.getConnect("localhost", "ffse1703001", "huong","12345");
				
				if(conn!=null)
				{
				System.out.println("Kết nối MYSQL thành công");
				}
				else
				{
				System.out.println("Kết nối MYSQL thất bại");
				}
}

}
