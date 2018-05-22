package ui;

import java.awt.BorderLayout;

import java.awt.Container;
import java.awt.Font;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class QuanLiTruongHocUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTabbedPane myTabled;
	private QuanLiSinhVienUI quanLiSinhVienUI;
	private QuanLiMonHocUI quanLiMonHocUI;
	private QuanLiLopHocUI quanLiLopHocUI;
	private QuanLiDiemHocUI quanLiDiemHocUI;
	private ThongKeSinhVienUI thongKeSinhVienUi;
	private ThongKeLopHocUI thongKeLopHocUi;

	public QuanLiTruongHocUI() {
		super();
	}

	public QuanLiTruongHocUI(String title) {
		super(title);
		addControls();
		addEvents();
	}

	public void addControls() {
		Container con = getContentPane();
		//
		JPanel header = new JPanel();
		ImageIcon logo = new ImageIcon(getClass().getResource("/image/ff.png"));
		JLabel lblheader = new JLabel(logo);

		lblheader.setFont(new Font("Serif", Font.BOLD, 30));
		header.add(lblheader);
		con.add(header, BorderLayout.NORTH);
		//
		myTabled = new JTabbedPane();
		quanLiSinhVienUI = new QuanLiSinhVienUI();
		myTabled.add("Quản Lí Sinh Viên", quanLiSinhVienUI);
		quanLiMonHocUI = new QuanLiMonHocUI();
		myTabled.add("Quản Lí Môn Học", quanLiMonHocUI);
		quanLiLopHocUI = new QuanLiLopHocUI();
		myTabled.add("Quản Lí Lớp Học", quanLiLopHocUI);
		quanLiDiemHocUI = new QuanLiDiemHocUI();
		myTabled.add("Quản Lí Điểm Học", quanLiDiemHocUI);
		thongKeLopHocUi = new ThongKeLopHocUI();
		myTabled.add("Thống Kê Lớp Học", thongKeLopHocUi);
		thongKeSinhVienUi = new ThongKeSinhVienUI();
		myTabled.add("Thống Kê Sinh Viên", thongKeSinhVienUi);

		con.add(myTabled);

	}

	private void addEvents() {
		myTabled.addChangeListener(new SelectedTab());
	}

	public void showWindow() {
		this.setSize(1200, 700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

	private class SelectedTab implements ChangeListener {
		@Override
		public void stateChanged(ChangeEvent e) {
			int choose = myTabled.getSelectedIndex();
			switch (choose) {
			case 0:
				// quanLiSinhVienUI = new QuanLiSinhVienUI();
				// myTabled.setComponentAt(0, quanLiSinhVienUI);
				quanLiSinhVienUI.cboLop();
				break;
			case 1:
				// quanLiMonHocUI = new QuanLiMonHocUI();
				// myTabled.setComponentAt(1, quanLiMonHocUI);
				// break;
			case 2:
				// quanLiLopHocUI = new QuanLiLopHocUI();
				// myTabled.setComponentAt(2, quanLiLopHocUI);
				quanLiLopHocUI.cboMon();
				break;
			case 3:
				// quanLiDiemHocUI = new QuanLiDiemHocUI();
				// myTabled.setComponentAt(3, quanLiDiemHocUI);
				break;
			case 4:
				// thongKeLopHocUi = new ThongKeLopHocUI();
				// myTabled.setComponentAt(4, thongKeLopHocUi);
				thongKeLopHocUi.cboNam();
				break;
			case 5:
				// thongKeSinhVienUi = new ThongKeSinhVienUI();
				// myTabled.setComponentAt(5, thongKeSinhVienUi);
				thongKeSinhVienUi.cboNam();
				break;
			}
		}
	}
}
