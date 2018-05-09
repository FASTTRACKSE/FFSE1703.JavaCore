package main;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import connector.GetConnect;
import ui.*;

public class Main {
	public static void main(String[] args) {
		QuanLi myUI = new QuanLi("Quản lí trường học");
		myUI.showWindown();
//		Connection conn= GetConnect.getConnect("localhost", "Quan_li_truong_hoc", "admin", "123456");
//		
//		if(conn!=null)
//		{
//		System.out.println("Kết nối MYSQL thành công");
//		}
//		else
//		{
//		System.out.println("Kết nối MYSQL thất bại");
//		}
	}

}
