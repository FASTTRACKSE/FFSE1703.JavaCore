package namdv.main;

import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import namdv.ui.LoginUI;
import namdv.ui.QuanLyThuVienUI;

public class MyApp {
	public static QuanLyThuVienUI mainFrame;
	public static LoginUI loginFrame;

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginFrame = new LoginUI("Đăng nhập hệ thống");
					loginFrame.showWindow();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
