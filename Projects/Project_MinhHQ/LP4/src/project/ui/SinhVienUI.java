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

public class SinhVienUI extends JPanel{

	private static final long serialVersionUID = 1L;

	private JTextField MaSV = new JTextField();
	private JTextField TenSV = new JTextField();
	private JTextField Diachi = new JTextField();
	private JTextField Email = new JTextField();
	private JTextField SDT = new JTextField();

	private ArrayList<SinhVien> arrSV = new ArrayList<SinhVien>();

	private JButton themSinhVien = new JButton("Thêm");
	private JButton xoaSinhVien = new JButton("Xóa");
	private JButton suaSinhVien = new JButton("Sửa");
	private JButton nhapSinhVien = new JButton("Nhập");



	private JComboBox<String> selectSinhVien = new JComboBox<>();
	private JComboBox<String> selectMaSV = new JComboBox<>();
	private JComboBox<String> tp = new JComboBox<>();
	private JComboBox<String> quan = new JComboBox<>();
	private JComboBox<String> phuong = new JComboBox<>();
	// private JComboBox<String> TenMHLop = new JComboBox<>();


	private DefaultTableModel dm_SinhVien;
	private JTable table_SinhVien;
	private JScrollPane sp_SinhVien;



	public SinhVienUI() {
		lop(selectSinhVien);	
		sinhvien();
		tinh();
		quan();
		xa();
		addControls();
		addEvent();
	}

	public void addControls() {

		// Thông tin Sinh Viên
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel pnButton_SinhVien = new JPanel();
		pnButton_SinhVien.setLayout(new FlowLayout());
		pnButton_SinhVien.add(themSinhVien);
		pnButton_SinhVien.add(suaSinhVien);
		pnButton_SinhVien.add(xoaSinhVien);
		pnButton_SinhVien.add(nhapSinhVien);
		this.add(pnButton_SinhVien);

		JPanel pnLeft_SinhVien = new JPanel();
		pnLeft_SinhVien.setLayout(new BoxLayout(pnLeft_SinhVien, BoxLayout.Y_AXIS));

		JPanel chonlop_SinhVien = new JPanel();
		chonlop_SinhVien.setLayout(new FlowLayout());
		JLabel txtlop_SinhVien = new JLabel("Mã lớp học: ");
		chonlop_SinhVien.add(txtlop_SinhVien);
		chonlop_SinhVien.add(selectSinhVien);
		pnLeft_SinhVien.add(chonlop_SinhVien);

		JPanel nhapMaSV = new JPanel();
		nhapMaSV.setLayout(new FlowLayout());
		JLabel lblNhapMaSV = new JLabel("Mã sinh viên:");
		MaSV = new JTextField(20);
		nhapMaSV.add(lblNhapMaSV);
		nhapMaSV.add(MaSV);
		pnLeft_SinhVien.add(nhapMaSV);

		JPanel nhapTen = new JPanel();
		nhapTen.setLayout(new FlowLayout());
		JLabel lblNhapTen = new JLabel("Tên sinh viên:");
		TenSV = new JTextField(20);
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
		Diachi = new JTextField(20);
		nhapDiachi.add(lblNhapDiachi);
		nhapDiachi.add(Diachi);
		pnRight_SinhVien.add(nhapDiachi);

		JPanel nhapEmail = new JPanel();
		nhapEmail.setLayout(new FlowLayout());
		JLabel lblNhapEmail = new JLabel("Email:   ");
		Email = new JTextField(20);
		nhapEmail.add(lblNhapEmail);
		nhapEmail.add(Email);
		pnRight_SinhVien.add(nhapEmail);

		JPanel nhapSDT = new JPanel();
		nhapSDT.setLayout(new FlowLayout());
		JLabel lblNhapSDT = new JLabel("SĐT:     ");
		SDT = new JTextField(20);
		nhapSDT.add(lblNhapSDT);
		nhapSDT.add(SDT);
		pnRight_SinhVien.add(nhapSDT);

		JPanel Nhap = new JPanel();
		Nhap.setLayout(new GridLayout(1, 3));
		Nhap.add(pnLeft_SinhVien);
		Nhap.add(pnSinhVien);
		Nhap.add(pnRight_SinhVien);

		this.add(Nhap);

		JPanel Table_SinhVien = new JPanel();
		Table_SinhVien.setLayout(new BorderLayout());
		Border border_SinhVien = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle_SinhVien = BorderFactory.createTitledBorder(border_SinhVien, "Danh sách sinh viên");
		Table_SinhVien.setBorder(borderTitle_SinhVien);

		dm_SinhVien = new DefaultTableModel();

		dm_SinhVien.addColumn("Lớp");
		dm_SinhVien.addColumn("Mã sinh viên");
		dm_SinhVien.addColumn("Tên sinh viên");
		dm_SinhVien.addColumn("Thành phố");
		dm_SinhVien.addColumn("Quận");
		dm_SinhVien.addColumn("Phường");
		dm_SinhVien.addColumn("Địa chỉ");
		dm_SinhVien.addColumn("Email");
		dm_SinhVien.addColumn("SĐT");

		try {
			Connection conn = Connect.getConnect("localhost", "minhad", "minhad", "minh");
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM sinhvien");
			while (result.next()) {
				arrSV.add(new SinhVien(result.getString("MaLop"), result.getString("MaSV"), result.getString("TenSV"),
						result.getString("ThanhPho"), result.getString("Quan"), result.getString("Phuong"),
						result.getString("DiaChi"), result.getString("Email"), result.getString("DT")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (SinhVien x : arrSV) {
			String[] row = { x.getLop(), x.getMaSV(), x.getTenSV(), x.getTp(), x.getQuan(), x.getPhuong(),
					x.getAdress(), x.getEmail(), x.getSdt() };
			dm_SinhVien.addRow(row);
		}

		table_SinhVien = new JTable(dm_SinhVien);
		table_SinhVien.setLayout(new BorderLayout());
		sp_SinhVien = new JScrollPane(table_SinhVien);
		JScrollPane sc_SinhVien = new JScrollPane(sp_SinhVien, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc_SinhVien.setPreferredSize(new Dimension(470, 180));
		Table_SinhVien.add(sc_SinhVien, BorderLayout.CENTER);
		this.add(Table_SinhVien);

	}

	// Lấy giá trị tĩnh cho các JComboBox
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

	public void xa() {
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

	public void lop(JComboBox<String> x) {
		x.addItem("Tất Cả");
		Connection conn = Connect.getConnect("localhost", "minhad", "minhad", "minh");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM lophoc");
			while (result.next()) {
				x.addItem(new String(result.getString("MaLop")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sinhvien() {
		Connection conn = Connect.getConnect("localhost", "minhad", "minhad", "minh");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM sinhvien");
			while (result.next()) {
				selectMaSV.addItem(new String(result.getString("MaSV")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// lấy xong giá trị của JComboBox

	public void addEvent() {
		selectSinhVien.addActionListener(eventChooseClass);
		tp.addActionListener(eventChooseTp);
		quan.addActionListener(eventChooseQuan);
		
		// CRUD sinh viên
		table_SinhVien.addMouseListener(eventTable_SinhVien);
		themSinhVien.addActionListener(eventAdd_SinhVien);
		xoaSinhVien.addActionListener(eventDel_SinhVien);
		suaSinhVien.addActionListener(eventEdit_SinhVien);
		nhapSinhVien.addActionListener(eventReset_SinhVien);

		
	}

	// Chọn tỉnh -> quận huyện -> xã phường
	ActionListener eventChooseTp = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String chonTinh = (String) tp.getSelectedItem();
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
	// kết thúc chọn tỉnh -> quận huyện -> xã phường

	


	// CRUD Sinh Viên

	MouseAdapter eventTable_SinhVien = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int row = table_SinhVien.getSelectedRow();
			String[] col = new String[9];
			col[0] = (String) table_SinhVien.getValueAt(row, 0);
			col[1] = (String) table_SinhVien.getValueAt(row, 1);
			col[2] = (String) table_SinhVien.getValueAt(row, 2);
			col[3] = (String) table_SinhVien.getValueAt(row, 3);
			col[4] = (String) table_SinhVien.getValueAt(row, 4);
			col[5] = (String) table_SinhVien.getValueAt(row, 5);
			col[6] = (String) table_SinhVien.getValueAt(row, 6);
			col[7] = (String) table_SinhVien.getValueAt(row, 7);
			col[8] = (String) table_SinhVien.getValueAt(row, 8);
			themSinhVien.setEnabled(false);
			MaSV.setEditable(false);
			selectSinhVien.setSelectedItem(col[0]);
			MaSV.setText(col[1]);
			TenSV.setText(col[2]);
			tp.setSelectedItem(col[3]);
			quan.setSelectedItem(col[4]);
			phuong.setSelectedItem(col[5]);
			Diachi.setText(col[6]);
			Email.setText(col[7]);
			SDT.setText(col[8]);
		}
	};

	ActionListener eventAdd_SinhVien = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String lop_SinhVien = (String) selectSinhVien.getSelectedItem();
			String ma_SinhVien = lop_SinhVien + MaSV.getText();
			String ten_SinhVien = TenSV.getText();
			String diachi_SinhVien = Diachi.getText();
			String tp_SinhVien = (String) tp.getSelectedItem();
			String quan_SinhVien = (String) quan.getSelectedItem();
			String phuong_SinhVien = (String) phuong.getSelectedItem();
			String email_SinhVien = Email.getText();
			String sdt_SinhVien = SDT.getText();

			try {
				if (lop_SinhVien.equals("Tất Cả") || ma_SinhVien.equals(lop_SinhVien) || ten_SinhVien.equals("")
						|| diachi_SinhVien.equals("") || email_SinhVien.equals("") || sdt_SinhVien.equals("")) {
					JOptionPane.showMessageDialog(null, "Bạn chưa nhập thông tin cho sinh viên",null,JOptionPane.WARNING_MESSAGE );
				} else {
					arrSV.add(new SinhVien(lop_SinhVien, ma_SinhVien, ten_SinhVien, tp_SinhVien, quan_SinhVien,
							phuong_SinhVien, diachi_SinhVien, email_SinhVien, sdt_SinhVien));
					dm_SinhVien.addRow(new String[] { lop_SinhVien, ma_SinhVien, ten_SinhVien, tp_SinhVien,
							quan_SinhVien, phuong_SinhVien, diachi_SinhVien, email_SinhVien, sdt_SinhVien });
					Connection conn = Connect.getConnect("localhost", "minhad", "minhad", "minh");
					try {
						String sql = "INSERT INTO sinhvien(MaSV, TenSV, MaLop,  ThanhPho, Quan,Phuong, DiaChi, Email, DT) VALUES  ('"
								+ ma_SinhVien + "','" + ten_SinhVien + "','" + lop_SinhVien + "','" + tp_SinhVien
								+ "','" + quan_SinhVien + "','" + phuong_SinhVien + "','" + diachi_SinhVien + "','"
								+ email_SinhVien + "','" + sdt_SinhVien + "')";
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

			dm_SinhVien.setRowCount(0);
			for (SinhVien x : arrSV) {
				if (lop_SinhVien.equals(x.getLop())) {
					String[] row = { x.getLop(), x.getMaSV(), x.getTenSV(), x.getTp(), x.getQuan(), x.getPhuong(),
							x.getAdress(), x.getEmail(), x.getSdt() };
					dm_SinhVien.addRow(row);
				}
			}

			MaSV.setText("");
			TenSV.setText("");
			Diachi.setText("");
			Email.setText("");
			SDT.setText("");
			selectSinhVien.setSelectedItem("Tất Cả");
			tp.setSelectedItem("Thành phố Hà Nội");
		}
	};

	ActionListener eventDel_SinhVien = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			for (SinhVien x : arrSV) {
				if (MaSV.getText().equals(x.getMaSV())) {
					arrSV.remove(x);
					break;
				}
			}
			Connection conn = Connect.getConnect("localhost", "minhad", "minhad", "minh");
			try {
				String sql = "DELETE FROM sinhvien WHERE MaSV = '" + MaSV.getText() + "'";
				Statement statement = conn.createStatement();
				int x = statement.executeUpdate(sql);
				if (x >= 0) {
					JOptionPane.showMessageDialog(null, "Đã xóa thông tin sinh viên");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			dm_SinhVien.setRowCount(0);
			String chonLop = (String) selectSinhVien.getSelectedItem();
			for (SinhVien x : arrSV) {
				if (chonLop.equals(x.getLop())) {
					String[] row = { x.getLop(), x.getMaSV(), x.getTenSV(), x.getTp(), x.getQuan(), x.getPhuong(),
							x.getAdress(), x.getEmail(), x.getSdt() };
					dm_SinhVien.addRow(row);
				}
			}

			MaSV.setText("");
			TenSV.setText("");
			Diachi.setText("");
			Email.setText("");
			SDT.setText("");
			selectSinhVien.setSelectedItem("Tất Cả");
			tp.setSelectedItem("Thành phố Hà Nội");
		}

	};

	ActionListener eventEdit_SinhVien = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			try {
				if (((String) selectSinhVien.getSelectedItem()).equals("Tất Cả") || MaSV.getText().equals("")
						|| TenSV.getText().equals("") || Diachi.getText().equals("") || Email.getText().equals("")
						|| SDT.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Bạn chưa nhập thông tin");
				} else {
					for (SinhVien x : arrSV) {
						if (MaSV.getText().equals(x.getMaSV())) {
							x.setTenSV(TenSV.getText());
							x.setLop((String) selectSinhVien.getSelectedItem());
							x.setTp((String) tp.getSelectedItem());
							x.setQuan((String) quan.getSelectedItem());
							x.setPhuong((String) phuong.getSelectedItem());
							x.setAdress(Diachi.getText());
							x.setEmail(Email.getText());
							x.setSdt(SDT.getText());
							break;
						}
					}
					Connection conn = Connect.getConnect("localhost", "minhad", "minhad", "minh");
					try {
						String sql = "UPDATE sinhvien SET TenSV='" + TenSV.getText() + "',MaLop='"
								+ (String) selectSinhVien.getSelectedItem() + "',DiaChi='" + Diachi.getText()
								+ "',Phuong='" + (String) phuong.getSelectedItem() + "',Quan='"
								+ (String) quan.getSelectedItem() + "',ThanhPho='" + (String) tp.getSelectedItem()
								+ "',Email='" + Email.getText() + "',DT='" + SDT.getText() + "' WHERE  MaSV='"
								+ MaSV.getText() + "'";
						Statement statement = conn.createStatement();
						int x = statement.executeUpdate(sql);
						if (x >= 0) {
							JOptionPane.showMessageDialog(null, "Đã sửa thông tin sinh viên");
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			dm_SinhVien.setRowCount(0);
			String chonLop = (String) selectSinhVien.getSelectedItem();
			for (SinhVien x : arrSV) {
				if (chonLop.equals(x.getLop())) {
					String[] row = { x.getLop(), x.getMaSV(), x.getTenSV(), x.getTp(), x.getQuan(), x.getPhuong(),
							x.getAdress(), x.getEmail(), x.getSdt() };
					dm_SinhVien.addRow(row);
				}
			}

			MaSV.setText("");
			TenSV.setText("");
			Diachi.setText("");
			Email.setText("");
			SDT.setText("");
			selectSinhVien.setSelectedItem("Tất Cả");
			tp.setSelectedItem("Thành phố Hà Nội");
		}
	};

	ActionListener eventReset_SinhVien = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			themSinhVien.setEnabled(true);
			MaSV.setEditable(true);
			MaSV.setText("");
			TenSV.setText("");
			Diachi.setText("");
			Email.setText("");
			SDT.setText("");
			selectSinhVien.setSelectedItem("Tất Cả");
			tp.setSelectedItem("Thành phố Hà Nội");
		}
	};
	// kết thúc CRUD Sinh viên

	// chọn lớp cho table Sinh viên
	ActionListener eventChooseClass = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String chonLop = (String) selectSinhVien.getSelectedItem();
			dm_SinhVien.setRowCount(0);
			if (chonLop == "Tất Cả") {

				for (SinhVien x : arrSV) {
					String[] row = { x.getLop(), x.getMaSV(), x.getTenSV(), x.getTp(), x.getQuan(), x.getPhuong(),
							x.getAdress(), x.getEmail(), x.getSdt() };
					dm_SinhVien.addRow(row);
				}

			} else {
				for (SinhVien x : arrSV) {
					if (chonLop.equals(x.getLop())) {
						String[] row = { x.getLop(), x.getMaSV(), x.getTenSV(), x.getTp(), x.getQuan(), x.getPhuong(),
								x.getAdress(), x.getEmail(), x.getSdt() };
						dm_SinhVien.addRow(row);
					}
				}
			}
		}

	};
	// Kết thúc chọn lớp cho sinh vien

	
}
