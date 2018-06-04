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

public class ProjectUI extends JFrame {

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

	private ArrayList<SinhVien> arrSV = new ArrayList<SinhVien>();
	//private ArrayList<String> thanhpho = new ArrayList<String>();
	private String[] lop = { "Tất Cả", "FFSE1701", "FFSE1702", "FFSE1703", "FFSE1704" };

	private JButton them = new JButton("Thêm");
	private JButton xoa = new JButton("Xóa");
	private JButton sua = new JButton("Sửa");
	private JComboBox select;
	private JComboBox tp = new JComboBox();
	private JComboBox quan = new JComboBox();
	private JComboBox phuong = new JComboBox();

	private DefaultTableModel dm;
	private JTable table;
	private JScrollPane sp;

	public ProjectUI(String tieude) {
		super(tieude);
		Tinh();
		addControls();
		addEvent();
	}

	public void addControls() {
		Container con = getContentPane();
		JPanel Main = new JPanel();
		Main.setLayout(new BorderLayout());

		JPanel Title = new JPanel();
		JLabel lbl = new JLabel("Chương trình quản lý trường học");
		Font font = new Font("Arial", Font.BOLD, 24);
		lbl.setFont(font);
		Title.add(lbl);
		Main.add(Title, BorderLayout.NORTH);

		JPanel Luachon = new JPanel();
		Luachon.setLayout(new BoxLayout(Luachon, BoxLayout.Y_AXIS));
		Luachon.add(Lop);
		Luachon.add(SV);
		Luachon.add(MH);
		Luachon.add(Diem);
		Luachon.add(Thongke);
		Main.add(Luachon, BorderLayout.WEST);

		JPanel Center = new JPanel();
		Center.setLayout(new BoxLayout(Center, BoxLayout.Y_AXIS));

		JPanel pnButton = new JPanel();
		pnButton.setLayout(new FlowLayout());
		pnButton.add(them);
		pnButton.add(sua);
		pnButton.add(xoa);
		Center.add(pnButton);

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

		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));

		JPanel chontinh = new JPanel();
		chontinh.setLayout(new FlowLayout());
		JLabel txttinh = new JLabel("Thành phố:  ");
//		tp = new JComboBox();
//		Connection conn = Connect.getConnect("localhost", "minhad", "minhad", "minh");
//		try {
//			Statement statement = conn.createStatement();
//			ResultSet result = statement.executeQuery("SELECT * FROM devvn_tinhthanhpho");
//
//			while (result.next()) {
//				tp.addItem(new String(result.getString("name")));
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		chontinh.add(txttinh);
		chontinh.add(tp);
		pnCenter.add(chontinh);

		JPanel chonhuyen = new JPanel();
		chonhuyen.setLayout(new FlowLayout());
		JLabel txthuyen = new JLabel("Quận/Huyện:");
//		quan = new JComboBox();
//		try {
//			Statement statement = conn.createStatement();
//			ResultSet result = statement.executeQuery(
//					"SELECT devvn_quanhuyen.name FROM devvn_quanhuyen INNER JOIN devvn_tinhthanhpho WHERE devvn_quanhuyen.matp=devvn_tinhthanhpho.matp");
//
//			while (result.next()) {
//				quan.addItem(new String(result.getString("name")));
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		chonhuyen.add(txthuyen);
		chonhuyen.add(quan);
		pnCenter.add(chonhuyen);

		JPanel chonquan = new JPanel();
		chonquan.setLayout(new FlowLayout());
		JLabel txtquan = new JLabel("Phường/Xã: ");
//		phuong = new JComboBox();
//		try {
//			Statement statement = conn.createStatement();
//			ResultSet result = statement.executeQuery(
//					"SELECT devvn_xaphuongthitran.name FROM devvn_xaphuongthitran INNER JOIN devvn_quanhuyen WHERE devvn_xaphuongthitran.maqh=devvn_quanhuyen.maqh");
//
//			while (result.next()) {
//				phuong.addItem(new String(result.getString("name")));
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		chonquan.add(txtquan);
		chonquan.add(phuong);
		pnCenter.add(chonquan);

		JPanel pnRight = new JPanel();
		pnRight.setLayout(new BoxLayout(pnRight, BoxLayout.Y_AXIS));

		JPanel nhapDiachi = new JPanel();
		nhapDiachi.setLayout(new FlowLayout());
		JLabel lblNhapDiachi = new JLabel("Địa chỉ:");
		MaSV = new JTextField(12);
		nhapDiachi.add(lblNhapDiachi);
		nhapDiachi.add(MaSV);
		pnRight.add(nhapDiachi);

		JPanel nhapEmail = new JPanel();
		nhapEmail.setLayout(new FlowLayout());
		JLabel lblNhapEmail = new JLabel("Email:   ");
		MaSV = new JTextField(12);
		nhapEmail.add(lblNhapEmail);
		nhapEmail.add(MaSV);
		pnRight.add(nhapEmail);

		JPanel nhapSDT = new JPanel();
		nhapSDT.setLayout(new FlowLayout());
		JLabel lblNhapSDT = new JLabel("SĐT:     ");
		TenSV = new JTextField(12);
		nhapSDT.add(lblNhapSDT);
		nhapSDT.add(TenSV);
		pnRight.add(nhapSDT);

		JPanel Nhap = new JPanel();
		Nhap.setLayout(new FlowLayout());
		Nhap.add(pnLeft, BorderLayout.WEST);
		Nhap.add(pnCenter);
		Nhap.add(pnRight, BorderLayout.EAST);

		Center.add(Nhap);



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
		Center.add(Table);
		Main.add(Center);

		con.add(Main);

	}
	
	public void Tinh() {
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
	
	public void addEvent() {
		select.addActionListener(eventChooseClass);
		tp.addActionListener(eventChooseTp);
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
//			MaSV.setText("");
//			TenSV.setText("");
//			Diachi.setText("");
//			Email.setText("");
//			SDT.setText("");
		}

	};
	
	ActionListener eventChooseTp = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			dm.setRowCount(0);
			quan.removeAllItems();
			Connection conn = Connect.getConnect("localhost", "minhad", "minhad", "minh");
			try {
				Statement statement = conn.createStatement();
				ResultSet result = statement.executeQuery(
						"SELECT devvn_quanhuyen.name FROM devvn_quanhuyen INNER JOIN devvn_tinhthanhpho WHERE devvn_quanhuyen.matp=devvn_tinhthanhpho.matp = '"+(String) tp.getSelectedItem()+"'");
				while (result.next()) {
					quan.addItem(new String(result.getString("devvn_quanhuyen.name")));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
//			MaSV.setText("");
//			TenSV.setText("");
//			Diachi.setText("");
//			Email.setText("");
//			SDT.setText("");
		}

	};

	public void showWindow() {
		this.setSize(1350, 700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
