package Assignment_list.assignment10.main;

import Assignment_list.assignment10.ui.*;
import Assignment_list.assignment10.model.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import org.gjt.mm.mysql.Driver;

import com.mysql.jdbc.Connection;
public class QuanLySinhVien {
	
	public static void main(String[] args) {		
		MyLayout myUI = new MyLayout("Quản Lý Sinh Viên.");
		myUI.showWindow();
		GetDatabase conn=new GetDatabase();		
			if(conn.getConnect("localhost", "sinhvien", "root",
					"12345")!=null)
			{
			System.out.println("Kết nối MYSQL thành công");
			}
			else
			{
			System.out.println("Kết nối MYSQL thất bại");
			}
	}
	
}
