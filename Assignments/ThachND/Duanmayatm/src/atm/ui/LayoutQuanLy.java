package atm.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import atm.main.*;
public class LayoutQuanLy extends JFrame {
	
	
		public LayoutQuanLy(String Window) {
			super(Window);
			addControls();
			
		}
		public void addControls() {
			Container con = getContentPane();
			JTabbedPane myTab = new JTabbedPane();
			JPanel pnMain = new JPanel();
			pnMain.setLayout(new BorderLayout());
			LayoutKhachHang tabLayoutKhachHang = new LayoutKhachHang();
			LayoutAtm tabLayoutAtm = new LayoutAtm();
			LayoutThongKeKhachHang tabLayoutThongKeKhachHang = new LayoutThongKeKhachHang();
			LayoutGiaoDichKhachHang tabLayoutGiaoDichKhachHang = new LayoutGiaoDichKhachHang();
			LayoutTinhTrangMay tabLayoutTinhTrangMay = new LayoutTinhTrangMay();
			LayoutThongKeMayAtm tabLayoutThongkeMayAtm = new LayoutThongKeMayAtm();
			LayoutRutTien  tabLayoutRutTien = new LayoutRutTien();
			
			myTab.add("Quản Lý Khách Hàng", tabLayoutKhachHang);
			myTab.add("Quản Lý Máy ATM", tabLayoutAtm);
			myTab.add("Thống Kê Khách Hàng", tabLayoutThongKeKhachHang);
			myTab.add("Giao Dich Khách Hàng", tabLayoutGiaoDichKhachHang);
			myTab.add("Tình Trạng Máy ATM", tabLayoutTinhTrangMay);
			myTab.add("Thống Kê Máy Atm", tabLayoutThongkeMayAtm);
			myTab.add("Rút Tiền", tabLayoutRutTien );
			
			pnMain.add(myTab);
			con.add(pnMain);
		}
		
		public void showWindow() {
			this.setSize(1200,750);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setLocationRelativeTo(null);
			this.setVisible(true);
		}
}

