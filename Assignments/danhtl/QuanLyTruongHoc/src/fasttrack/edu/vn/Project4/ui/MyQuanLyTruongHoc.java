package fasttrack.edu.vn.Project4.ui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import fasttrack.edu.vn.Project4.model.Connect;
import fasttrack.edu.vn.Project4.model.QuanLyDiem;
import fasttrack.edu.vn.Project4.model.QuanLyMonHoc;
import fasttrack.edu.vn.Project4.model.QuanLyMonLop;
import fasttrack.edu.vn.Project4.model.SinhVien;;

@SuppressWarnings("serial")
public class MyQuanLyTruongHoc extends JFrame {


	private Button sv = new Button("QUẢN LÝ SINH VIÊN");
	private Button diem = new Button("QUẢN LÝ ĐIỂM");
	private Button lop = new Button("QUẢN LÝ LỚP HỌC");
	private Button mon = new Button("QUẢN LÝ MÔN HỌC");
	private Button monlop = new Button("MÔN HỌC CỦA LỚP");
	private Button thongke = new Button("THỐNG KÊ BÁO CÁO");

	CardLayout card = new CardLayout();
	JPanel pnsv = new JPanel();

	QuanLySinhVienUI sinhvienUI;
	QuanLyLopHocUI lophocUI;
	QuanLyMonHocUI monhocUI;
	QuanLyMonHocChoLopUI monhoclopUI;
	QuanLyDiemUI diemUI;
	QuanLyThongKeUI ThongKeUI;
	
	public MyQuanLyTruongHoc(String tieude) {
		super(tieude);
		
		addControls();
		addEvent();
	}

	public void addControls() {
		Container con = getContentPane();

		pnsv.setLayout(card);

		JPanel pnBorder = new JPanel();
		pnBorder.setLayout(new BorderLayout());
		// tieu de
		JPanel tieude = new JPanel();
		JLabel lbl = new JLabel("Chương Trình Quản Lý Trường Học");
		Font font = new Font("Arial", Font.BOLD, 24);
		lbl.setFont(font);
		tieude.setBackground(Color.RED);
		tieude.add(lbl);
		pnBorder.add(tieude, BorderLayout.NORTH);
		// chucnang
		JPanel pnchucnang = new JPanel();
		pnchucnang.setLayout(new BoxLayout(pnchucnang, BoxLayout.Y_AXIS));

		pnchucnang.add(lop);
		pnchucnang.add(sv);
		pnchucnang.add(mon);
		pnchucnang.add(monlop);
		pnchucnang.add(diem);
		pnchucnang.add(thongke);
		pnBorder.add(pnchucnang, BorderLayout.WEST);

		lophocUI = new QuanLyLopHocUI();
		pnsv.add(lophocUI,"1");
		
		pnBorder.add(pnsv);
		con.add(pnBorder);
		setVisible(true);
	}
	
	public void addEvent() {

		
		lop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				lophocUI = new QuanLyLopHocUI();
				pnsv.add(lophocUI,"1");
				card.show(pnsv, "1");
			}
		});
		sv.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				sinhvienUI = new QuanLySinhVienUI();
				pnsv.add(sinhvienUI,"2");
				card.show(pnsv, "2");
			}
		});
		mon.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				monhocUI = new QuanLyMonHocUI();
				pnsv.add(monhocUI, "3");
				card.show(pnsv, "3");
			}
		});

		monlop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				monhoclopUI = new QuanLyMonHocChoLopUI();
				pnsv.add(monhoclopUI, "4");
				card.show(pnsv, "4");
			}
		});

		diem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				diemUI = new QuanLyDiemUI();
				pnsv.add(diemUI, "5");
				card.show(pnsv, "5");
			}
		});
		
		thongke.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				ThongKeUI = new QuanLyThongKeUI();
				pnsv.add(ThongKeUI, "6");
				card.show(pnsv, "6");
			}
		});
	}
	
	public void showWindow() {
		this.setSize(1350, 700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
