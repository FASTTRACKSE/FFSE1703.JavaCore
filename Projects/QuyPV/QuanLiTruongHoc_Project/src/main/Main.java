package main;
import java.util.ArrayList;


import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.mysql.jdbc.Connection;
import connector.GetConnect;
import ui.*;

public class Main {
	public static void main(String[] args) {
//		QuanLi myUI = new QuanLi("Quản lí trường học");
//		myUI.showWindown();
		
		Login login = new Login("Đăng nhập");
		login.showWindown();
		
	}

}
