package project.main;

import java.awt.EventQueue;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import project.model.ConnectDB;
import project.ui.*;;

public class QuanLyKH {
	static ConnectDB conn = new ConnectDB();
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LayoutKH myUI = new LayoutKH("Quản Lý ATM");
					myUI.showWindow();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
