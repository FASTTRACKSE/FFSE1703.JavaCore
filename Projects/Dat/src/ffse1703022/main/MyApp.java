package ffse1703022.main;

import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


import ffse1703022.ui.QuanLiTienDien;

public class MyApp {

	public static QuanLiTienDien mainFrame;
	

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainFrame=new QuanLiTienDien("Quản Lí Tiền Điện");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
