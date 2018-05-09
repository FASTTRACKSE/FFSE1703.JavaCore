package project.ui;

import project.model.SinhVien;

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

public class ThongTinSVUI extends JFrame {

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
	private JTextField MaMH = new JTextField();
	private JTextField TenMH = new JTextField();
	private JTextField NamHoc = new JTextField();

	private ArrayList<SinhVien> arrSV = new ArrayList<SinhVien>();
	private String[] lop = { "Tất Cả", "FFSE1701", "FFSE1702", "FFSE1703", "FFSE1704" };

	private JButton themSV = new JButton("Thêm");
	private JButton xoaSV = new JButton("Xóa");
	private JButton suaSV = new JButton("Sửa");
	
	private JButton themMH = new JButton("Thêm");
	private JButton xoaMH = new JButton("Xóa");
	private JButton suaMH = new JButton("Sửa");
	
	private JButton themLH = new JButton("Thêm");
	private JButton xoaLH = new JButton("Xóa");
	private JButton suaLH = new JButton("Sửa");
	
	private JComboBox select;
	private JComboBox tp = new JComboBox();
	private JComboBox quan = new JComboBox();
	private JComboBox phuong = new JComboBox();
	private JComboBox namhoc = new JComboBox();

	private DefaultTableModel dm;
	private JTable table;
	private JScrollPane sp;
	private JPanel SinhVien = new JPanel();
	private JPanel LopHoc = new JPanel();

	public ThongTinSVUI(String tieude) {
		super(tieude);
		tinh();quan();huyen();
		addControls();
		addEvent();
	}

	public void addControls() {
		Container con = getContentPane();
		
		JPanel ttSV = new JPanel();
		ttSV.setLayout( new CardLayout());
		
		JPanel Main = new JPanel();
		Main.setLayout(new BorderLayout());
// Title của chương trình
		JPanel Title = new JPanel();
		JLabel lbl = new JLabel("Chương trình quản lý trường học");
		Font font = new Font("Arial", Font.BOLD, 24);
		lbl.setFont(font);
		Title.add(lbl);
		Main.add(Title, BorderLayout.NORTH);
//Button menu
		JPanel Luachon = new JPanel();
		Luachon.setLayout(new BoxLayout(Luachon, BoxLayout.Y_AXIS));
		Luachon.add(Lop);
		Luachon.add(SV);
		Luachon.add(MH);
		Luachon.add(Diem);
		Luachon.add(Thongke);
		Main.add(Luachon, BorderLayout.WEST);

		//Thông tin Sinh Viên
		SinhVien.setLayout(new BoxLayout(SinhVien, BoxLayout.Y_AXIS));

		JPanel pnButton = new JPanel();
		pnButton.setLayout(new FlowLayout());
		pnButton.add(themSV);
		pnButton.add(suaSV);
		pnButton.add(xoaSV);
		SinhVien.add(pnButton);

		JPanel pnLeft = new JPanel();
		pnLeft.setLayout(new BoxLayout(pnLeft, BoxLayout.Y_AXIS));

		JPanel chonlop = new JPanel();
		chonlop.setLayout(new FlowLayout());
		JLabel txtlop = new JLabel("Chọn lớp: ");
		select = new JComboBox(lop);
		chonlop.add(txtlop);
		chonlop.add(select);
		pnLeft.add(chonlop);

		JPanel nhapMaSV = new JPanel();
		nhapMaSV.setLayout(new FlowLayout());
		JLabel lblNhapMaSV = new JLabel("Mã sinh viên:");
		MaSV = new JTextField(12);
		nhapMaSV.add(lblNhapMaSV);
		nhapMaSV.add(MaSV);
		pnLeft.add(nhapMaSV);

		JPanel nhapTen = new JPanel();
		nhapTen.setLayout(new FlowLayout());
		JLabel lblNhapTen = new JLabel("Tên sinh viên:");
		TenSV = new JTextField(12);
		nhapTen.add(lblNhapTen);
		nhapTen.add(TenSV);
		pnLeft.add(nhapTen);

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

		JPanel pnRight = new JPanel();
		pnRight.setLayout(new BoxLayout(pnRight, BoxLayout.Y_AXIS));

		JPanel nhapDiachi = new JPanel();
		nhapDiachi.setLayout(new FlowLayout());
		JLabel lblNhapDiachi = new JLabel("Địa chỉ:");
		Diachi = new JTextField(12);
		nhapDiachi.add(lblNhapDiachi);
		nhapDiachi.add(Diachi);
		pnRight.add(nhapDiachi);

		JPanel nhapEmail = new JPanel();
		nhapEmail.setLayout(new FlowLayout());
		JLabel lblNhapEmail = new JLabel("Email:   ");
		Email = new JTextField(12);
		nhapEmail.add(lblNhapEmail);
		nhapEmail.add(Email);
		pnRight.add(nhapEmail);

		JPanel nhapSDT = new JPanel();
		nhapSDT.setLayout(new FlowLayout());
		JLabel lblNhapSDT = new JLabel("SĐT:     ");
		SDT = new JTextField(12);
		nhapSDT.add(lblNhapSDT);
		nhapSDT.add(SDT);
		pnRight.add(nhapSDT);

		JPanel Nhap = new JPanel();
		Nhap.setLayout(new GridLayout(1, 3));
//		Border borderNhap = BorderFactory.createLineBorder(Color.BLUE);
//		TitledBorder borderTitleNhap = BorderFactory.createTitledBorder(borderNhap, "Nhập thông tin");
//		Nhap.setBorder(borderTitleNhap);
		Nhap.add(pnLeft);
		Nhap.add(pnSinhVien);
		Nhap.add(pnRight);

		SinhVien.add(Nhap);



		JPanel Table = new JPanel();
		Table.setLayout(new BorderLayout());
		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Danh sách");
		Table.setBorder(borderTitle);

		dm = new DefaultTableModel();

		dm.addColumn("Mã");
		dm.addColumn("Tên");
		dm.addColumn("Địa chỉ");
		dm.addColumn("Thành phố");
		dm.addColumn("Quận");
		dm.addColumn("Phường");
		dm.addColumn("Email");
		dm.addColumn("SĐT");

		Connection conn = Connect.getConnect("localhost", "minhad", "minhad", "minh");
		 try {
		 Statement statement = conn.createStatement();
		 ResultSet result = statement.executeQuery("SELECT * FROM sinhvien");
		 while (result.next()) {
		 arrSV.add(new SinhVien(result.getString("MaSV"), result.getString("TenSV"),
		 result.getString("MaLop"),
		 result.getString("DiaChi"), result.getString("Phuong"),
		 result.getString("Quan"),
		 result.getString("ThanhPho"), result.getString("Email"),
		 result.getString("DT")));
		 }
		 } catch (Exception e) {
		 e.printStackTrace();
		 }
		
		 for (SinhVien x : arrSV) {
		 String[] row = { x.getMaSV(), x.getTenSV(), x.getAdress(), x.getTp(), x.getQuan(),x.getPhuong(),x.getEmail(),x.getSdt() };
		 dm.addRow(row);
		 }

		table = new JTable(dm);
		table.setLayout(new BorderLayout());
		sp = new JScrollPane(table);
		JScrollPane sc = new JScrollPane(sp, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc.setPreferredSize(new Dimension(470, 180));
		Table.add(sc, BorderLayout.CENTER);
		SinhVien.add(Table);
		
		//Quản lý lớp học
		
		LopHoc.setLayout(new BoxLayout(LopHoc, BoxLayout.Y_AXIS));

		JPanel pnButton1 = new JPanel();
		pnButton1.setLayout(new FlowLayout());
		pnButton1.add(themLH);
		pnButton1.add(suaLH);
		pnButton1.add(xoaLH);
		LopHoc.add(pnButton1);

		JPanel pnLopHoc = new JPanel();
		pnLopHoc.setLayout(new BoxLayout(pnLopHoc, BoxLayout.Y_AXIS));
		
		JPanel nhapMaMH = new JPanel();
//		nhapMaMH.setLayout(new FlowLayout());
		JLabel lblNhapmaMH = new JLabel("Nhập mã môn học:");
		MaMH = new JTextField(12);
		nhapMaMH.add(lblNhapmaMH);
		nhapMaMH.add(MaMH);
		pnLopHoc.add(nhapMaMH);

		JPanel nhapTenMH = new JPanel();
//		nhapTenMH.setLayout(new FlowLayout());
		JLabel lblNhapTenMH = new JLabel("Nhập tên môn học:");
		TenMH = new JTextField(12);
		nhapTenMH.add(lblNhapTenMH);
		nhapTenMH.add(TenMH);
		pnLopHoc.add(nhapTenMH);

		JPanel nhapNamHoc = new JPanel();
//		nhapNamHoc.setLayout(new FlowLayout());
		JLabel txtnhapNamHoc = new JLabel("Năm học:                  ");
		NamHoc = new JTextField(12);
		nhapNamHoc.add(txtnhapNamHoc);
		nhapNamHoc.add(NamHoc);
		pnLopHoc.add(nhapNamHoc);
		
		LopHoc.add(pnLopHoc);
		
		JPanel chonNamHoc = new JPanel();
		chonNamHoc.setLayout(new FlowLayout());
		JLabel txtNamHoc = new JLabel("Năm học: ");
		chonNamHoc.add(txtNamHoc);
		chonNamHoc.add(namhoc);
		
		LopHoc.add(chonNamHoc);

		JPanel Table1 = new JPanel();
		Table1.setLayout(new BorderLayout());
		Border border1 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle1 = BorderFactory.createTitledBorder(border1, "Danh sách");
		Table1.setBorder(borderTitle1);
		
		

		dm = new DefaultTableModel();

		dm.addColumn("Mã môn học");
		dm.addColumn("Tên môn học");
		dm.addColumn("Năm học");

//		Connection conn = Connect.getConnect("localhost", "minhad", "minhad", "minh");
//		 try {
//		 Statement statement = conn.createStatement();
//		 ResultSet result = statement.executeQuery("SELECT * FROM sinhvien");
//		 while (result.next()) {
//		 arrLH.add(new LopHoc(result.getString("MaSV"), result.getString("TenSV"),
//		 result.getString("MaLop"),
//		 result.getString("DiaChi"), result.getString("Phuong"),
//		 result.getString("Quan"),
//		 result.getString("ThanhPho"), result.getString("Email"),
//		 result.getString("DT")));
//		 }
//		 } catch (Exception e) {
//		 e.printStackTrace();
//		 }
//		
//		 for (SinhVien x : arrSV) {
//		 String[] row = { x.getMaSV(), x.getTenSV(), x.getAdress(), x.getTp(), x.getQuan(),x.getPhuong(),x.getEmail(),x.getSdt() };
//		 dm.addRow(row);
//		 }
//
		table = new JTable(dm);
		table.setLayout(new BorderLayout());
		sp = new JScrollPane(table);
		JScrollPane sc1 = new JScrollPane(sp, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc1.setPreferredSize(new Dimension(470, 180));
		Table1.add(sc1, BorderLayout.CENTER);
		LopHoc.add(Table1);

		
		
		ttSV.add(SinhVien);
		ttSV.add(LopHoc);
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
		select.addActionListener(eventChooseClass);
		tp.addActionListener(eventChooseTp);
		quan.addActionListener(eventChooseQuan);
		
		Lop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				SinhVien.setVisible(false);
				LopHoc.setVisible(true);
				
				
			}
		});
		
		SV.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				SinhVien.setVisible(true);
				LopHoc.setVisible(false);
				
				
			}
		});
	}
	
	ActionListener eventChooseClass = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String chonLop = (String) select.getSelectedItem();
			dm.setRowCount(0);
			if (chonLop == "Tất Cả") {
				
				for (SinhVien x : arrSV) {
					String[] row = { x.getMaSV(), x.getTenSV(), x.getAdress(), x.getTp(), x.getQuan(),x.getPhuong(),x.getEmail(),x.getSdt() };
					dm.addRow(row);
				}
				
			} else {
				for (SinhVien x : arrSV) {
					if (chonLop.equals(x.getLop())) {
						String[] row = { x.getMaSV(), x.getTenSV(), x.getAdress(), x.getTp(), x.getQuan(),x.getPhuong(),x.getEmail(),x.getSdt() };
						dm.addRow(row);
					}
				}
			}
		}

	};
	
	ActionListener eventChooseTp = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String chonTinh = (String)tp.getSelectedItem();
			dm.setRowCount(0);
			quan.removeAllItems();
			Connection conn = Connect.getConnect("localhost", "minhad", "minhad", "minh");
			try {
				Statement statement = conn.createStatement();
				ResultSet result = statement.executeQuery(
						"SELECT devvn_quanhuyen.name FROM devvn_quanhuyen INNER JOIN devvn_tinhthanhpho WHERE devvn_quanhuyen.matp=devvn_tinhthanhpho.matp AND devvn_tinhthanhpho.name ='"+chonTinh+"'");
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
			String chonTinh = (String)quan.getSelectedItem();
			dm.setRowCount(0);
			phuong.removeAllItems();
			Connection conn = Connect.getConnect("localhost", "minhad", "minhad", "minh");
			try {
				Statement statement = conn.createStatement();
				ResultSet result = statement.executeQuery(
						"SELECT devvn_xaphuongthitran.name FROM devvn_xaphuongthitran INNER JOIN devvn_quanhuyen WHERE devvn_xaphuongthitran.maqh=devvn_quanhuyen.maqh AND devvn_quanhuyen.name ='"+chonTinh+"'");
				while (result.next()) {
					phuong.addItem(new String(result.getString("devvn_xaphuongthitran.name")));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	};
	
	

	public void showWindow() {
		this.setSize(1350, 700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
