package ffse1703020.qltv.main;

import java.awt.EventQueue;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import ffse1703020.qltv.ui.LoginUi;
import ffse1703020.qltv.ui.QuanLiThuVienUI;


public class MyApp {
	public static QuanLiThuVienUI mainFrame;
	public static LoginUi loginFrame;

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginFrame = new LoginUi("Đăng nhập hệ thống");
					loginFrame.showWindow();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}