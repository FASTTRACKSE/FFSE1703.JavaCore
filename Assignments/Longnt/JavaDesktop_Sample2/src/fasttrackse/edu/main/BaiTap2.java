package fasttrackse.edu.main;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import fasttrackse.edu.connect.*;
import fasttrackse.edu.model.QuanLy;

public class BaiTap2 {
	static Connection conn= DBConnection.ketnoi("localhost", "ffse1703", "thanhlong123",
			"123456");
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuanLy myUI = new QuanLy("Quan ly Sinh Vien");
		myUI.showWindow();
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

}
