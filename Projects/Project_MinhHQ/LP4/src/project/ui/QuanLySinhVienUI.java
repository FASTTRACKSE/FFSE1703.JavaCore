package project.ui;

import project.connect.Connect;
import project.model.*;

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

public class QuanLySinhVienUI extends JFrame {

	private Button Lop = new Button("Quản lý Lớp Học");
	private Button SV = new Button("Quản lý Sinh Viên");
	private Button MH = new Button("Quản lý Môn Học");
	private Button Diem = new Button("Nhập Điểm");
	private Button Thongke = new Button("Thống kê");

	private JTextField MaSV = new JTextField();
	private JTextField TenSV = new JTextField();
	private JTextField Diachi = new JTextField();
	private JTextField Email = new JTextField();
	private JTextField SDT = new JTextField();
	
	private JTextField MaLH = new JTextField();
	private JTextField TenLH = new JTextField();
	private JTextField NamHoc = new JTextField();
	
	private JTextField MaMH = new JTextField();
	private JTextField TenMH = new JTextField();
	private JTextField Tinchi = new JTextField();
	private JTextField Time = new JTextField();

	private ArrayList<SinhVien> arrSV = new ArrayList<SinhVien>();
	private ArrayList<LopHoc> arrLH = new ArrayList<LopHoc>();
	private String[] lop = { "Tất Cả", "FFSE1701", "FFSE1702", "FFSE1703", "FFSE1704" };
	private String[] nam = { "2018", "2017", "2016", "2015", "2014" };

	private JButton themSV = new JButton("Thêm");
	private JButton xoaSV = new JButton("Xóa");
	private JButton suaSV = new JButton("Sửa");
	private JButton nhapSV = new JButton("Nhập");

	private JButton themMH = new JButton("Thêm");
	private JButton xoaMH = new JButton("Xóa");
	private JButton suaMH = new JButton("Sửa");
	private JButton nhapMH = new JButton("Nhập");

	private JButton them_LopHoc = new JButton("Thêm");
	private JButton xoa_LopHoc = new JButton("Xóa");
	private JButton sua_LopHoc = new JButton("Sửa");
	private JButton nhap_LopHoc = new JButton("Nhập");
	
	private JButton themND = new JButton("Thêm");
	private JButton xoaND = new JButton("Xóa");
	private JButton suaND = new JButton("Sửa");
	private JButton nhapND = new JButton("Nhập");

	private JComboBox select_SinhVien;
	private JComboBox select_MonHoc;
	private JComboBox select_NhapDiem;
	private JComboBox tp = new JComboBox();
	private JComboBox quan = new JComboBox();
	private JComboBox phuong = new JComboBox();
	private JComboBox namhoc = new JComboBox();

	private DefaultTableModel dm_LopHoc;
	private JTable table_LopHoc;
	private JScrollPane sp_LopHoc;
	
	private DefaultTableModel dm_MonHoc_lop;
	private JTable table_MonHoc_lop;
	private JScrollPane sp_MonHoc_lop;
	
	private DefaultTableModel dm_SinhVien;
	private JTable table_SinhVien;
	private JScrollPane sp_SinhVien;
	
	private DefaultTableModel dm_MonHoc;
	private JTable table_MonHoc;
	private JScrollPane sp_MonHoc;
	
	private DefaultTableModel dm_NhapDiem;
	private JTable table_NhapDiem;
	private JScrollPane sp_NhapDiem;
	
	private JPanel SinhVien = new JPanel();
	private JPanel LopHoc = new JPanel();
	private JPanel MonHoc = new JPanel();
	private JPanel NhapDiem = new JPanel();

	public QuanLySinhVienUI(String tieude) {
		super(tieude);
		tinh();
		quan();
		huyen();
		addControls();
		addEvent();
	}

	public void addControls() {
		Container con = getContentPane();

		JPanel ttSV = new JPanel();
		ttSV.setLayout(new CardLayout());

		JPanel Main = new JPanel();
		Main.setLayout(new BorderLayout());
		// Title của chương trình
		JPanel Title = new JPanel();
		JLabel lbl = new JLabel("Chương trình quản lý trường học");
		Font font = new Font("Arial", Font.BOLD, 24);
		lbl.setFont(font);
		Title.add(lbl);
		Main.add(Title, BorderLayout.NORTH);
		// Button menu
		JPanel Luachon = new JPanel();
		Luachon.setLayout(new BoxLayout(Luachon, BoxLayout.Y_AXIS));
		Luachon.add(Lop);
		Luachon.add(SV);
		Luachon.add(MH);
		Luachon.add(Diem);
		Luachon.add(Thongke);
		Main.add(Luachon, BorderLayout.WEST);

		// Quản lý lớp học

		LopHoc.setLayout(new BoxLayout(LopHoc, BoxLayout.Y_AXIS));

		JPanel pnButton_LopHoc = new JPanel();
		pnButton_LopHoc.setLayout(new FlowLayout());
		pnButton_LopHoc.add(them_LopHoc);
		pnButton_LopHoc.add(sua_LopHoc);
		pnButton_LopHoc.add(xoa_LopHoc);
		pnButton_LopHoc.add(nhap_LopHoc);
		LopHoc.add(pnButton_LopHoc);

		JPanel pnLopHoc = new JPanel();
		pnLopHoc.setLayout(new BoxLayout(pnLopHoc, BoxLayout.Y_AXIS));

		JPanel nhapMaLH = new JPanel();
		JLabel lblNhapmaLH = new JLabel("Mã lớp học: ");
		MaLH = new JTextField(19);
		nhapMaLH.add(lblNhapmaLH);
		nhapMaLH.add(MaLH);
		pnLopHoc.add(nhapMaLH);

		JPanel nhapTenLH = new JPanel();
		JLabel lblNhapTenLH = new JLabel("Tên lớp học:");
		TenLH = new JTextField(19);
		nhapTenLH.add(lblNhapTenLH);
		nhapTenLH.add(TenLH);
		pnLopHoc.add(nhapTenLH);

		JPanel nhapNamHoc = new JPanel();
		JLabel txtnhapNamHoc = new JLabel("Năm học:      ");
		NamHoc = new JTextField(19);
		nhapNamHoc.add(txtnhapNamHoc);
		nhapNamHoc.add(NamHoc);
		pnLopHoc.add(nhapNamHoc);

		LopHoc.add(pnLopHoc);

		JPanel chonNamHoc = new JPanel();
		chonNamHoc.setLayout(new FlowLayout());
		JLabel txtNamHoc = new JLabel("Năm học: ");
		namhoc = new JComboBox(nam);
		chonNamHoc.add(txtNamHoc);
		chonNamHoc.add(namhoc);

		LopHoc.add(chonNamHoc);

		JPanel Table_LopHoc = new JPanel();
		Table_LopHoc.setLayout(new BorderLayout());
		Border border_LopHoc = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle_LopHoc = BorderFactory.createTitledBorder(border_LopHoc, "Danh sách");
		Table_LopHoc.setBorder(borderTitle_LopHoc);

		dm_LopHoc = new DefaultTableModel();

		dm_LopHoc.addColumn("Mã lớp học");
		dm_LopHoc.addColumn("Tên lớp học");
		dm_LopHoc.addColumn("Năm học");

		 Connection conn = Connect.getConnect("localhost", "minhad", "minhad",
		 "minh");
		 try {
		 Statement statement = conn.createStatement();
		 ResultSet result = statement.executeQuery("SELECT * FROM lophoc");
		 while (result.next()) {
		 arrLH.add(new LopHoc(result.getString("MaLop"), result.getString("TenLop"),
		 result.getString("NamHoc")));
		 }
		 } catch (Exception e) {
		 e.printStackTrace();
		 }
		
		 for (LopHoc x : arrLH) {
		 String[] row = { x.getMaLop(), x.getTenLop(), x.getNamHoc()};
		 dm_LopHoc.addRow(row);
		 }
		
		table_LopHoc = new JTable(dm_LopHoc);
		table_LopHoc.setLayout(new BorderLayout());
		sp_LopHoc = new JScrollPane(table_LopHoc);
		JScrollPane sc_LopHoc = new JScrollPane(sp_LopHoc, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc_LopHoc.setPreferredSize(new Dimension(470, 180));
		Table_LopHoc.add(sc_LopHoc, BorderLayout.CENTER);
		LopHoc.add(Table_LopHoc);

		// Thông tin Sinh Viên
		SinhVien.setLayout(new BoxLayout(SinhVien, BoxLayout.Y_AXIS));

		JPanel pnButton_SinhVien = new JPanel();
		pnButton_SinhVien.setLayout(new FlowLayout());
		pnButton_SinhVien.add(themSV);
		pnButton_SinhVien.add(suaSV);
		pnButton_SinhVien.add(xoaSV);
		pnButton_SinhVien.add(nhapSV);
		SinhVien.add(pnButton_SinhVien);

		JPanel pnLeft_SinhVien = new JPanel();
		pnLeft_SinhVien.setLayout(new BoxLayout(pnLeft_SinhVien, BoxLayout.Y_AXIS));

		JPanel chonlop_SinhVien = new JPanel();
		chonlop_SinhVien.setLayout(new FlowLayout());
		JLabel txtlop_SinhVien = new JLabel("Chọn lớp: ");
		select_SinhVien = new JComboBox(lop);
		chonlop_SinhVien.add(txtlop_SinhVien);
		chonlop_SinhVien.add(select_SinhVien);
		pnLeft_SinhVien.add(chonlop_SinhVien);

		JPanel nhapMaSV = new JPanel();
		nhapMaSV.setLayout(new FlowLayout());
		JLabel lblNhapMaSV = new JLabel("Mã sinh viên:");
		MaSV = new JTextField(12);
		nhapMaSV.add(lblNhapMaSV);
		nhapMaSV.add(MaSV);
		pnLeft_SinhVien.add(nhapMaSV);

		JPanel nhapTen = new JPanel();
		nhapTen.setLayout(new FlowLayout());
		JLabel lblNhapTen = new JLabel("Tên sinh viên:");
		TenSV = new JTextField(12);
		nhapTen.add(lblNhapTen);
		nhapTen.add(TenSV);
		pnLeft_SinhVien.add(nhapTen);

		JPanel pnSinhVien = new JPanel();
		pnSinhVien.setLayout(new BoxLayout(pnSinhVien, BoxLayout.Y_AXIS));

		JPanel chontinh = new JPanel();
		chontinh.setLayout(new FlowLayout());
		JLabel txttinh = new JLabel("Thành phố:  ");
		chontinh.add(txttinh);
		chontinh.add(tp);
		pnSinhVien.add(chontinh);

		JPanel chonhuyen = new JPanel();
		chonhuyen.setLayout(new FlowLayout());
		JLabel txthuyen = new JLabel("Quận/Huyện:");
		chonhuyen.add(txthuyen);
		chonhuyen.add(quan);
		pnSinhVien.add(chonhuyen);

		JPanel chonquan = new JPanel();
		chonquan.setLayout(new FlowLayout());
		JLabel txtquan = new JLabel("Phường/Xã: ");
		chonquan.add(txtquan);
		chonquan.add(phuong);
		pnSinhVien.add(chonquan);

		JPanel pnRight_SinhVien = new JPanel();
		pnRight_SinhVien.setLayout(new BoxLayout(pnRight_SinhVien, BoxLayout.Y_AXIS));

		JPanel nhapDiachi = new JPanel();
		nhapDiachi.setLayout(new FlowLayout());
		JLabel lblNhapDiachi = new JLabel("Địa chỉ:");
		Diachi = new JTextField(12);
		nhapDiachi.add(lblNhapDiachi);
		nhapDiachi.add(Diachi);
		pnRight_SinhVien.add(nhapDiachi);

		JPanel nhapEmail = new JPanel();
		nhapEmail.setLayout(new FlowLayout());
		JLabel lblNhapEmail = new JLabel("Email:   ");
		Email = new JTextField(12);
		nhapEmail.add(lblNhapEmail);
		nhapEmail.add(Email);
		pnRight_SinhVien.add(nhapEmail);

		JPanel nhapSDT = new JPanel();
		nhapSDT.setLayout(new FlowLayout());
		JLabel lblNhapSDT = new JLabel("SĐT:     ");
		SDT = new JTextField(12);
		nhapSDT.add(lblNhapSDT);
		nhapSDT.add(SDT);
		pnRight_SinhVien.add(nhapSDT);

		JPanel Nhap = new JPanel();
		Nhap.setLayout(new GridLayout(1, 3));
		Nhap.add(pnLeft_SinhVien);
		Nhap.add(pnSinhVien);
		Nhap.add(pnRight_SinhVien);

		SinhVien.add(Nhap);

		JPanel Table_SinhVien = new JPanel();
		Table_SinhVien.setLayout(new BorderLayout());
		Border border_SinhVien = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle_SinhVien = BorderFactory.createTitledBorder(border_SinhVien, "Danh sách");
		Table_SinhVien.setBorder(borderTitle_SinhVien);

		dm_SinhVien = new DefaultTableModel();

		dm_SinhVien.addColumn("Mã");
		dm_SinhVien.addColumn("Tên");
		dm_SinhVien.addColumn("Địa chỉ");
		dm_SinhVien.addColumn("Thành phố");
		dm_SinhVien.addColumn("Quận");
		dm_SinhVien.addColumn("Phường");
		dm_SinhVien.addColumn("Email");
		dm_SinhVien.addColumn("SĐT");

		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM sinhvien");
			while (result.next()) {
				arrSV.add(new SinhVien(result.getString("MaSV"), result.getString("TenSV"), result.getString("MaLop"),
						result.getString("DiaChi"), result.getString("Phuong"), result.getString("Quan"),
						result.getString("ThanhPho"), result.getString("Email"), result.getString("DT")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (SinhVien x : arrSV) {
			String[] row = { x.getMaSV(), x.getTenSV(), x.getAdress(), x.getTp(), x.getQuan(), x.getPhuong(),
					x.getEmail(), x.getSdt() };
			dm_SinhVien.addRow(row);
		}

		table_SinhVien = new JTable(dm_SinhVien);
		table_SinhVien.setLayout(new BorderLayout());
		sp_SinhVien = new JScrollPane(table_SinhVien);
		JScrollPane sc_SinhVien = new JScrollPane(sp_SinhVien, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc_SinhVien.setPreferredSize(new Dimension(470, 180));
		Table_SinhVien.add(sc_SinhVien, BorderLayout.CENTER);
		SinhVien.add(Table_SinhVien);

		// Quản lý môn học
		
		MonHoc.setLayout(new BoxLayout(MonHoc, BoxLayout.Y_AXIS));

		JPanel pnButton_MonHoc = new JPanel();
		pnButton_MonHoc.setLayout(new FlowLayout());
		pnButton_MonHoc.add(themMH);
		pnButton_MonHoc.add(suaMH);
		pnButton_MonHoc.add(xoaMH);
		pnButton_MonHoc.add(nhapMH);
		MonHoc.add(pnButton_MonHoc);

		JPanel pnLeft_MonHoc = new JPanel();
		pnLeft_MonHoc.setLayout(new BoxLayout(pnLeft_MonHoc, BoxLayout.Y_AXIS));

		JPanel nhapMaMH = new JPanel();
		nhapMaMH.setLayout(new FlowLayout());
		JLabel lblNhapMaMH = new JLabel("Mã môn học:");
		MaMH = new JTextField(12);
		nhapMaMH.add(lblNhapMaMH);
		nhapMaMH.add(MaMH);
		pnLeft_MonHoc.add(nhapMaMH);

		JPanel nhapTenMH = new JPanel();
		nhapTenMH.setLayout(new FlowLayout());
		JLabel lblNhapTenMH = new JLabel("Tên môn học:");
		TenMH = new JTextField(12);
		nhapTenMH.add(lblNhapTenMH);
		nhapTenMH.add(TenMH);
		pnLeft_MonHoc.add(nhapTenMH);
		
		JPanel pnRight_MonHoc = new JPanel();
		pnRight_MonHoc.setLayout(new BoxLayout(pnRight_MonHoc, BoxLayout.Y_AXIS));

		JPanel nhapTinChi = new JPanel();
		nhapTinChi.setLayout(new FlowLayout());
		JLabel lblNhapTinChi = new JLabel("Tín chỉ:                ");
		Tinchi = new JTextField(12);
		nhapTinChi.add(lblNhapTinChi);
		nhapTinChi.add(Tinchi);
		pnRight_MonHoc.add(nhapTinChi);

		JPanel nhapTime = new JPanel();
		nhapTime.setLayout(new FlowLayout());
		JLabel lblNhapTime = new JLabel("Thời gian học:   ");
		Time = new JTextField(12);
		nhapTime.add(lblNhapTime);
		nhapTime.add(Time);
		pnRight_MonHoc.add(nhapTime);
		
		JPanel pnMH = new JPanel();
		pnMH.setLayout(new FlowLayout());
		
		pnMH.add(pnLeft_MonHoc);
		pnMH.add(pnRight_MonHoc);
		MonHoc.add(pnMH);
		
		JPanel Table_MonHoc = new JPanel();
		Table_MonHoc.setLayout(new BorderLayout());
		Border border_MonHoc = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle_MonHoc = BorderFactory.createTitledBorder(border_MonHoc, "Danh sách");
		Table_MonHoc.setBorder(borderTitle_MonHoc);

		dm_MonHoc = new DefaultTableModel();

		dm_MonHoc.addColumn("Mã môn học");
		dm_MonHoc.addColumn("Tên môn học");
		dm_MonHoc.addColumn("Tín chỉ");
		dm_MonHoc.addColumn("Thời gian học");

		// Connection conn = Connect.getConnect("localhost", "minhad", "minhad",
		// "minh");
		// try {
		// Statement statement = conn.createStatement();
		// ResultSet result = statement.executeQuery("SELECT * FROM lophoc");
		// while (result.next()) {
		// arrLH.add(new LopHoc(result.getString("MaLH"), result.getString("TenSV"),
		// result.getString("MaLop")));
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		//
		// for (SinhVien x : arrSV) {
		// String[] row = { x.getMaSV(), x.getTenSV(), x.getAdress(), x.getTp(),
		// x.getQuan(),x.getPhuong(),x.getEmail(),x.getSdt() };
		// dm.addRow(row);
		// }
		//
		table_MonHoc = new JTable(dm_MonHoc);
		table_MonHoc.setLayout(new BorderLayout());
		sp_MonHoc = new JScrollPane(table_MonHoc);
		JScrollPane sc_MonHoc = new JScrollPane(sp_MonHoc, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc_MonHoc.setPreferredSize(new Dimension(470, 180));
		Table_MonHoc.add(sc_MonHoc, BorderLayout.CENTER);
		MonHoc.add(Table_MonHoc);
		// Nhập điểm cho sinh viên
		
		NhapDiem.setLayout(new BoxLayout(NhapDiem, BoxLayout.Y_AXIS));

		JPanel pnButton_NhapDiem = new JPanel();
		pnButton_NhapDiem.setLayout(new FlowLayout());
		pnButton_NhapDiem.add(themND);
		pnButton_NhapDiem.add(suaND);
		pnButton_NhapDiem.add(xoaND);
		pnButton_NhapDiem.add(nhapND);
		NhapDiem.add(pnButton_NhapDiem);

		JPanel pnLeft_NhapDiem = new JPanel();
		pnLeft_NhapDiem.setLayout(new BoxLayout(pnLeft_NhapDiem, BoxLayout.Y_AXIS));

		
		
		JPanel pnRight_NhapDiem = new JPanel();
		pnRight_NhapDiem.setLayout(new BoxLayout(pnRight_NhapDiem, BoxLayout.Y_AXIS));

		
		
		JPanel pn_NhapDiem = new JPanel();
		pn_NhapDiem.setLayout(new FlowLayout());
		
		pn_NhapDiem.add(pnLeft_NhapDiem);
		pn_NhapDiem.add(pnRight_NhapDiem);
		NhapDiem.add(pn_NhapDiem);
		
		JPanel pnLop_NhapDiem = new JPanel();
		pnLop_NhapDiem.setLayout(new FlowLayout());
		JLabel txtLop_NhapDiem = new JLabel("Chọn lớp: ");
		select_NhapDiem = new JComboBox(lop);
		pnLop_NhapDiem.add(txtLop_NhapDiem);
		pnLop_NhapDiem.add(select_NhapDiem);
		NhapDiem.add(pnLop_NhapDiem);
		
		JPanel Table_NhapDiem = new JPanel();
		Table_NhapDiem.setLayout(new BorderLayout());
		Border border_NhapDiem = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle_NhapDiem = BorderFactory.createTitledBorder(border_NhapDiem, "Danh sách");
		Table_NhapDiem.setBorder(borderTitle_NhapDiem);

		dm_NhapDiem = new DefaultTableModel();

		dm_NhapDiem.addColumn("Mã môn học");
		dm_NhapDiem.addColumn("Tên môn học");
		dm_NhapDiem.addColumn("Tín chỉ");
		dm_NhapDiem.addColumn("Thời gian học");

		// Connection conn = Connect.getConnect("localhost", "minhad", "minhad",
		// "minh");
		// try {
		// Statement statement = conn.createStatement();
		// ResultSet result = statement.executeQuery("SELECT * FROM lophoc");
		// while (result.next()) {
		// arrLH.add(new LopHoc(result.getString("MaLH"), result.getString("TenSV"),
		// result.getString("MaLop")));
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		//
		// for (SinhVien x : arrSV) {
		// String[] row = { x.getMaSV(), x.getTenSV(), x.getAdress(), x.getTp(),
		// x.getQuan(),x.getPhuong(),x.getEmail(),x.getSdt() };
		// dm.addRow(row);
		// }
		//
		table_NhapDiem = new JTable(dm_NhapDiem);
		table_NhapDiem.setLayout(new BorderLayout());
		sp_NhapDiem = new JScrollPane(table_NhapDiem);
		JScrollPane sc_NhapDiem = new JScrollPane(sp_NhapDiem, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc_NhapDiem.setPreferredSize(new Dimension(470, 180));
		Table_NhapDiem.add(sc_NhapDiem, BorderLayout.CENTER);
		NhapDiem.add(Table_NhapDiem);
		
		ttSV.add(LopHoc);
		ttSV.add(SinhVien);
		ttSV.add(MonHoc);
		ttSV.add(NhapDiem);
		Main.add(ttSV);
		con.add(Main);
		setVisible(true);
	}

	public void tinh() {
		Connection conn = Connect.getConnect("localhost", "minhad", "minhad", "minh");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM devvn_tinhthanhpho");
			while (result.next()) {
				tp.addItem(new String(result.getString("name")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void quan() {
		Connection conn = Connect.getConnect("localhost", "minhad", "minhad", "minh");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM devvn_quanhuyen");
			while (result.next()) {
				quan.addItem(new String(result.getString("name")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void huyen() {
		Connection conn = Connect.getConnect("localhost", "minhad", "minhad", "minh");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM devvn_xaphuongthitran");
			while (result.next()) {
				phuong.addItem(new String(result.getString("name")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addEvent() {
		select_SinhVien.addActionListener(eventChooseClass);
		tp.addActionListener(eventChooseTp);
		quan.addActionListener(eventChooseQuan);
		//nhapSV.addActionListener(eventNhapSV);
		table_LopHoc.addMouseListener(eventTable_LopHoc);
		them_LopHoc.addActionListener(eventAdd_LopHoc);
		xoa_LopHoc.addActionListener(eventDel_LopHoc);

		Lop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				LopHoc.setVisible(true);
				SinhVien.setVisible(false);
				MonHoc.setVisible(false);
				NhapDiem.setVisible(false);
			}
		});

		SV.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				LopHoc.setVisible(false);
				SinhVien.setVisible(true);
				MonHoc.setVisible(false);
				NhapDiem.setVisible(false);
			}
		});
		MH.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				LopHoc.setVisible(false);
				SinhVien.setVisible(false);
				MonHoc.setVisible(true);
				NhapDiem.setVisible(false);
			}
		});
		Diem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				LopHoc.setVisible(false);
				SinhVien.setVisible(false);
				MonHoc.setVisible(false);
				NhapDiem.setVisible(true);
			}
		});
	}

	ActionListener eventChooseClass = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String chonLop = (String) select_SinhVien.getSelectedItem();
			dm_SinhVien.setRowCount(0);
			if (chonLop == "Tất Cả") {

				for (SinhVien x : arrSV) {
					String[] row = { x.getMaSV(), x.getTenSV(), x.getAdress(), x.getTp(), x.getQuan(), x.getPhuong(),
							x.getEmail(), x.getSdt() };
					dm_SinhVien.addRow(row);
				}

			} else {
				for (SinhVien x : arrSV) {
					if (chonLop.equals(x.getLop())) {
						String[] row = { x.getMaSV(), x.getTenSV(), x.getAdress(), x.getTp(), x.getQuan(),
								x.getPhuong(), x.getEmail(), x.getSdt() };
						dm_SinhVien.addRow(row);
					}
				}
			}
		}

	};
	
	
//Chọn tỉnh -> quận huyện -> xã phường
	ActionListener eventChooseTp = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String chonTinh = (String) tp.getSelectedItem();
			dm_SinhVien.setRowCount(0);
			quan.removeAllItems();
			Connection conn = Connect.getConnect("localhost", "minhad", "minhad", "minh");
			try {
				Statement statement = conn.createStatement();
				ResultSet result = statement.executeQuery(
						"SELECT devvn_quanhuyen.name FROM devvn_quanhuyen INNER JOIN devvn_tinhthanhpho WHERE devvn_quanhuyen.matp=devvn_tinhthanhpho.matp AND devvn_tinhthanhpho.name ='"
								+ chonTinh + "'");
				while (result.next()) {
					quan.addItem(new String(result.getString("devvn_quanhuyen.name")));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	};

	ActionListener eventChooseQuan = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String chonTinh = (String) quan.getSelectedItem();
			dm_SinhVien.setRowCount(0);
			phuong.removeAllItems();
			Connection conn = Connect.getConnect("localhost", "minhad", "minhad", "minh");
			try {
				Statement statement = conn.createStatement();
				ResultSet result = statement.executeQuery(
						"SELECT devvn_xaphuongthitran.name FROM devvn_xaphuongthitran INNER JOIN devvn_quanhuyen WHERE devvn_xaphuongthitran.maqh=devvn_quanhuyen.maqh AND devvn_quanhuyen.name ='"
								+ chonTinh + "'");
				while (result.next()) {
					phuong.addItem(new String(result.getString("devvn_xaphuongthitran.name")));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	};
	//kết thúc chọn tỉnh -> quận huyện -> xã phường
	//CRUD Lớp Học
	
	MouseAdapter eventTable_LopHoc = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int row = table_LopHoc.getSelectedRow();
			String[] col = new String[3];
			col[0] = (String) table_LopHoc.getValueAt(row, 0);
			col[1] = (String) table_LopHoc.getValueAt(row, 1);
			col[2] = (String) table_LopHoc.getValueAt(row, 2);
			MaLH.setText(col[0]);
			TenLH.setText(col[1]);
			NamHoc.setText(col[2]);
		}
	};
	
	ActionListener eventAdd_LopHoc = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String ma_LopHoc = MaLH.getText();
			String ten_LopHoc = TenLH.getText();
			String nam_LopHoc = NamHoc.getText();

			try {
				if (ma_LopHoc.equals("") || ten_LopHoc.equals("") || nam_LopHoc.equals("")) {
					JOptionPane.showMessageDialog(null, "Bạn chưa nhập thông tin");
				} else {
					arrLH.add(new LopHoc(ma_LopHoc, ten_LopHoc, nam_LopHoc));
					dm_LopHoc.addRow(new String[] { ma_LopHoc, ten_LopHoc, nam_LopHoc });
					Connection conn = Connect.getConnect("localhost", "minhad", "minhad", "minh");
					try {
						String sql = "INSERT INTO lophoc(MaLop,TenLop,NamHoc) VALUES (" + "'" + ma_LopHoc + "','"
								+ ten_LopHoc + "','" + nam_LopHoc + "'" + ")";
						Statement statement = conn.createStatement();
						int x = statement.executeUpdate(sql);
						if (x > 0) {
							JOptionPane.showMessageDialog(null, "Đã lưu thông tin sinh viên");
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Bạn cần nhập thông tin sinh viên");
			}

			MaLH.setText("");
			TenLH.setText("");
			NamHoc.setText("");

		}
	};
	
	ActionListener eventDel_LopHoc = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			for (LopHoc x : arrLH) {
				if (MaLH.getText().equals(x.getMaLop())) {
					arrLH.remove(x);
					break;
				}
			}
			Connection conn = Connect.getConnect("localhost", "minhad", "minhad", "minh");
			try {
				String sql = "DELETE FROM lophoc WHERE MaLop = '" + MaLH.getText() + "'";
				Statement statement = conn.createStatement();
				int x = statement.executeUpdate(sql);
				if (x >= 0) {
					JOptionPane.showMessageDialog(null, "Đã xóa thông tin sinh viên");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			dm_LopHoc.setRowCount(0);
			for (LopHoc x : arrLH) {
				String[] row = { x.getMaLop(), x.getTenLop(), x.getNamHoc() };
				dm_LopHoc.addRow(row);
			}
		}

	};

	public void showWindow() {
		this.setSize(1350, 700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setMinimumSize(new Dimension(1050,567));
		this.setVisible(true);
	}
}
