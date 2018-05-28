package main;
import java.awt.EventQueue;
import java.util.ArrayList;


import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.mysql.jdbc.Connection;
import connector.GetConnect;
import ui.*;

public class Main {
	public static void main(String[] args) {
//		try {
//			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
//				| UnsupportedLookAndFeelException e) {
//		}
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
		
//		QuanLi myUI = new QuanLi("Quản lí trường học");
//		myUI.showWindown();
		
		Login login = new Login("Đăng nhập");
		login.showWindown();
		
	}

}
