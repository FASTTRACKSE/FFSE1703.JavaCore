package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class QuanLiTruongHocUI extends JFrame {
	public QuanLiTruongHocUI() {
		super();
	}
	public QuanLiTruongHocUI(String title) {
		super(title);
		addControls();
	}
	public void addControls() {
		Container con=getContentPane();
		//
		JPanel header = new JPanel();
		JLabel lblheader = new JLabel("QUẢN LÍ TRƯỜNG HỌC");
		lblheader.setFont(new Font("Serif", Font.BOLD, 30));
		header.add(lblheader);
		con.add(header, BorderLayout.NORTH);
		//
		JTabbedPane myTabled = new JTabbedPane();
		QuanLiSinhVienUI quanLiSinhVienUI = new QuanLiSinhVienUI();
		myTabled.add("Quản Lí Sinh Viên",quanLiSinhVienUI);	
		QuanLiMonHocUI quanLiMonHocUI = new QuanLiMonHocUI();
		myTabled.add("Quản Lí Môn Học",quanLiMonHocUI);	
		QuanLiLopHocUI quanLiLopHocUI = new QuanLiLopHocUI();
		myTabled.add("Quản Lí Lớp Học", quanLiLopHocUI);
		QuanLiDiemHocUI quanLiDiemHocUI= new QuanLiDiemHocUI();
		myTabled.add("Quản Lí Điểm Học", quanLiDiemHocUI);
		ThongKeSinhVienUI thongKeSinhVienUi= new ThongKeSinhVienUI();
		myTabled.add("Thống Kê Sinh Viên", thongKeSinhVienUi);
		ThongKeLopHocUI thongKeLopHocUi= new ThongKeLopHocUI();
		myTabled.add("Thống Kê Sinh Viên", thongKeLopHocUi);
		
		con.add(myTabled);
		
	}
	public void showWindow() {
		this.setSize(1000, 700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
}
