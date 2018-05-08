package ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.ConnectException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class QuanLi extends JFrame {
	public QuanLi() {
		super();
	}
	
	public QuanLi(String title) {
		super(title);
		addControls();
	}
	
	public void addControls() {
		Container con = getContentPane();

		JPanel boxMain = new JPanel();
		boxMain.setLayout(new BoxLayout(boxMain, BoxLayout.X_AXIS ));
		

		
		JTabbedPane myTab = new JTabbedPane();
		QuanLiSinhVien tabQuanLiSinhVien = new QuanLiSinhVien();
		QuanLiMonHoc tabQuanLiMonHoc = new QuanLiMonHoc();
		QuanLiLopHoc tabQuanLiLopHoc = new QuanLiLopHoc();
		QuanLiDiem tabQuanLiDiem = new QuanLiDiem();
		ThongKeLopHoc tabThongKeLopHoc = new ThongKeLopHoc();
		ThongKeSinhVien tabThongKeSinhVien = new ThongKeSinhVien();
		
		myTab.add("Quản lí sinh viên", tabQuanLiSinhVien);
		myTab.add("Quản lí môn học", tabQuanLiMonHoc);
		myTab.add("Quản lí lớp học", tabQuanLiLopHoc);
		myTab.add("Quản lí điểm", tabQuanLiDiem);
		myTab.add("Thống kê lớp học", tabThongKeLopHoc);
		myTab.add("Thống kê sinh viên", tabThongKeSinhVien);
		boxMain.add(myTab);
		
		con.add(boxMain);
	}
	
	public void showWindown() {
		this.setSize(1100,900);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}
}
