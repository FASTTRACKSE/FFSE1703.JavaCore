package fasttrack.edu.vn.Project4.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import fasttrack.edu.vn.Project4.model.Connect;
import fasttrack.edu.vn.Project4.model.SinhVien;

public class QuanLySinhVienUI extends JPanel {
	private static final long serialVersionUID = 1L;

	public QuanLySinhVienUI() {
		tinh();
		Huyen();
		xa();
		xemdssv();
		addControls();
		addEvent();
	}

	private JTextField ten = new JTextField();
	private JTextField masv = new JTextField();
	private JTextField diachi = new JTextField();
	private JTextField email = new JTextField();
	private JTextField sdt = new JTextField();

	ArrayList<SinhVien> arrSV = new ArrayList<SinhVien>();

	JComboBox<String> LOP = new JComboBox<>();
	JComboBox<String> cbo = new JComboBox<>();
	JComboBox<String> tinh = new JComboBox<>();
	JComboBox<String> huyen = new JComboBox<>();
	JComboBox<String> xa = new JComboBox<>();
	JComboBox<String> xemsv = new JComboBox<>();
	JComboBox<String> lopmoncualop = new JComboBox<>();
	JComboBox<String> monmoncualop = new JComboBox<>();


	private JButton themsv = new JButton("Thêm");
	private JButton suasv = new JButton("Sửa");
	private JButton xoasv = new JButton("Xóa");
	private JButton nhapsv = new JButton("nhập");

	private DefaultTableModel dmsv;
	private JTable tablesv;
	private JScrollPane spsv;

	public void addControls() {

		// sinh vien

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel pnButtonsv = new JPanel();
		pnButtonsv.setLayout(new FlowLayout());
		pnButtonsv.add(themsv);
		pnButtonsv.add(suasv);
		pnButtonsv.add(xoasv);
		pnButtonsv.add(nhapsv);
		this.add(pnButtonsv);

		JPanel vitri = new JPanel();
		vitri.setLayout(new BoxLayout(vitri, BoxLayout.Y_AXIS));

		JPanel lop = new JPanel();
		lop.setLayout(new FlowLayout());
		JLabel lblContent = new JLabel("Chọn Lớp :");
		lop.add(lblContent);
		lop.add(cbo);
		vitri.add(lop);

		JPanel pnmasv = new JPanel();
		pnmasv.setLayout(new FlowLayout());
		JLabel lblmasv = new JLabel("Mã Sinh Viên :");
		masv = new JTextField(12);
		pnmasv.add(lblmasv);
		pnmasv.add(masv);
		vitri.add(pnmasv);

		JPanel pntensv = new JPanel();
		pntensv.setLayout(new FlowLayout());
		JLabel lblten = new JLabel("Tên Sinh Viên :");
		ten = new JTextField(12);
		pntensv.add(lblten);
		pntensv.add(ten);
		vitri.add(pntensv);

		JPanel vitri1 = new JPanel();
		vitri1.setLayout(new BoxLayout(vitri1, BoxLayout.Y_AXIS));

		JPanel pntinh = new JPanel();
		pntinh.setLayout(new FlowLayout());
		JLabel lbltinh = new JLabel("Tỉnh/Thành Phố :");
		lbltinh.setPreferredSize(new Dimension(100, 50));
		tinh.setPreferredSize(new Dimension(100, 20));

		pntinh.add(lbltinh);
		pntinh.add(tinh);
		vitri1.add(pntinh);

		JPanel pnhuyen = new JPanel();
		pnhuyen.setLayout(new FlowLayout());
		JLabel lblhuyen = new JLabel("Quận/Huyện :");
		lblhuyen.setPreferredSize(new Dimension(100, 50));
		huyen.setPreferredSize(new Dimension(100, 20));

		pnhuyen.add(lblhuyen);
		pnhuyen.add(huyen);
		vitri1.add(pnhuyen);

		JPanel pnxa = new JPanel();
		pnxa.setLayout(new FlowLayout());
		JLabel lblxa = new JLabel("Xã/Phường :");
		lblxa.setPreferredSize(new Dimension(100, 50));
		xa.setPreferredSize(new Dimension(100, 20));

		pnxa.add(lblxa);
		pnxa.add(xa);
		vitri1.add(pnxa);

		JPanel vitri2 = new JPanel();
		vitri2.setLayout(new BoxLayout(vitri2, BoxLayout.Y_AXIS));

		JPanel pndiachi = new JPanel();
		pndiachi.setLayout(new FlowLayout());
		JLabel lbldiachi = new JLabel("       Địa Chỉ :");
		diachi = new JTextField(12);
		pndiachi.add(lbldiachi);
		pndiachi.add(diachi);
		vitri2.add(pndiachi);

		JPanel pnemail = new JPanel();
		pnemail.setLayout(new FlowLayout());
		JLabel lblemail = new JLabel("        Email :");
		email = new JTextField(12);
		pnemail.add(lblemail);
		pnemail.add(email);
		vitri2.add(pnemail);

		JPanel pmsdt = new JPanel();
		pmsdt.setLayout(new FlowLayout());
		JLabel lblsdt = new JLabel("Điện Thoại :");
		sdt = new JTextField(12);
		pmsdt.add(lblsdt);
		pmsdt.add(sdt);
		vitri2.add(pmsdt);

		JPanel nhapsv = new JPanel();
		nhapsv.setLayout(new GridLayout(1, 3));
		Border borsv = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitlesv = BorderFactory.createTitledBorder(borsv, "Thêm Thông Tin");

		nhapsv.setBorder(borderTitlesv);
		nhapsv.add(vitri);
		nhapsv.add(vitri1);
		nhapsv.add(vitri2);
		this.add(nhapsv);

		JPanel xemttsv = new JPanel();
		xemttsv.setLayout(new BoxLayout(xemttsv, BoxLayout.X_AXIS));

		JPanel xemdssv = new JPanel();
		xemdssv.setLayout(new FlowLayout());
		JLabel lblxemdssv = new JLabel("Xem Danh Sách Lớp :");
		xemdssv.add(lblxemdssv);
		xemdssv.add(xemsv);
		xemttsv.add(xemdssv);

		JPanel Table = new JPanel();
		Table.setLayout(new FlowLayout());
		Border bordersv1 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitlesv1 = BorderFactory.createTitledBorder(bordersv1, "Danh sách sinh viên");
		Table.setBorder(borderTitlesv1);

		dmsv = new DefaultTableModel();
		dmsv.addColumn("Mã Lớp");
		dmsv.addColumn("Mã Sinh Viên");
		dmsv.addColumn("Tên");
		dmsv.addColumn("Địa Chỉ");
		dmsv.addColumn("Phường");
		dmsv.addColumn("Quận");
		dmsv.addColumn("Tỉnh/TP");
		dmsv.addColumn("SĐT");
		dmsv.addColumn("Email");

		Connection connsv = Connect.getConnect("localhost", "Danh", "Danh", "Danh");
		try {
			Statement statement = connsv.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM quan_ly_sinh_vien");
			while (result.next()) {
				arrSV.add(new SinhVien(result.getString("ma_lop"), result.getString("ma_sinh_vien"),
						result.getString("ten_sinh_vien"), result.getString("dia_chi"), result.getString("phuong"),
						result.getString("quan"), result.getString("tinh_thanh_pho"), result.getString("dien_thoai"),
						result.getString("email")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//dmsv.setRowCount(0);
		for (SinhVien x : arrSV) {
			String[] row = { x.getLop(), x.getMasv(), x.getTensv(), x.getDiachi(), x.getXa(), x.getHuyen(), x.getTinh(),
					x.getSdt(), x.getEmail() };
			dmsv.addRow(row);
		}
		tablesv = new JTable(dmsv);
		tablesv.setLayout(new BorderLayout());
		spsv = new JScrollPane(tablesv);
		JScrollPane sc = new JScrollPane(spsv, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc.setPreferredSize(new Dimension(1170, 300));
		Table.add(sc, BorderLayout.CENTER);
		Table.add(xemdssv);
		this.add(Table);

	}

	public void tinh() {
		Connection conn = Connect.getConnect("localhost", "Danh", "Danh", "Danh");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM devvn_tinhthanhpho");
			while (result.next()) {
				tinh.addItem(new String(result.getString("name")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void Huyen() {
		Connection conn = Connect.getConnect("localhost", "Danh", "Danh", "Danh");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM devvn_quanhuyen");
			while (result.next()) {
				huyen.addItem(new String(result.getString("name")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void xa() {
		Connection conn = Connect.getConnect("localhost", "Danh", "Danh", "Danh");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM devvn_xaphuongthitran");
			while (result.next()) {
				xa.addItem(new String(result.getString("name")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void xemdssv() {
		Connection conn = Connect.getConnect("localhost", "Danh", "Danh", "Danh");
		xemsv.addItem("Tất Cả");

		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM quan_ly_lop_hoc");
			while (result.next()) {
				xemsv.addItem(new String(result.getString("ma_Lop")));
				cbo.addItem(new String(result.getString("ma_Lop")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void addEvent() {

		tinh.addActionListener(eventChoosetinh);
		huyen.addActionListener(eventChoosehuyen);
		xemsv.addActionListener(eventChooseClass);

		// CRUD SINH VIÊN
		tablesv.addMouseListener(eventtablesv);
		themsv.addActionListener(eventthemSV);
		suasv.addActionListener(eventsuasv);
		xoasv.addActionListener(eventxoasv);
	
	}

	// Chọn tỉnh -> quận huyện -> xã phường
	ActionListener eventChoosetinh = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String chonTinh = (String) tinh.getSelectedItem();

			huyen.removeAllItems();
			Connection conn = Connect.getConnect("localhost", "Danh", "Danh", "Danh");
			try {
				Statement statement = conn.createStatement();
				ResultSet result = statement.executeQuery(
						"SELECT devvn_quanhuyen.name FROM devvn_quanhuyen INNER JOIN devvn_tinhthanhpho WHERE devvn_quanhuyen.matp=devvn_tinhthanhpho.matp AND devvn_tinhthanhpho.name ='"
								+ chonTinh + "'");
				while (result.next()) {
					huyen.addItem(new String(result.getString("devvn_quanhuyen.name")));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	};

	ActionListener eventChoosehuyen = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String chonTinh = (String) huyen.getSelectedItem();

			xa.removeAllItems();
			Connection conn = Connect.getConnect("localhost", "Danh", "Danh", "Danh");
			try {
				Statement statement = conn.createStatement();
				ResultSet result = statement.executeQuery(
						"SELECT devvn_xaphuongthitran.name FROM devvn_xaphuongthitran INNER JOIN devvn_quanhuyen WHERE devvn_xaphuongthitran.maqh=devvn_quanhuyen.maqh AND devvn_quanhuyen.name ='"
								+ chonTinh + "'");
				while (result.next()) {
					xa.addItem(new String(result.getString("devvn_xaphuongthitran.name")));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	};
	// kết thúc chọn tỉnh -> quận huyện -> xã phường
	
	
	

	// CRUD SINH VIÊN
	MouseAdapter eventtablesv = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int row = tablesv.getSelectedRow();
			String[] col = new String[9];
			col[0] = (String) tablesv.getValueAt(row, 0);
			col[1] = (String) tablesv.getValueAt(row, 1);
			col[2] = (String) tablesv.getValueAt(row, 2);
			col[3] = (String) tablesv.getValueAt(row, 3);
			col[4] = (String) tablesv.getValueAt(row, 4);
			col[5] = (String) tablesv.getValueAt(row, 5);
			col[6] = (String) tablesv.getValueAt(row, 6);
			col[7] = (String) tablesv.getValueAt(row, 7);
			col[8] = (String) tablesv.getValueAt(row, 8);

			cbo.setSelectedItem(col[0]);
			masv.setText(col[1]);
			ten.setText(col[2]);
			diachi.setText(col[3]);
			xa.setSelectedItem(col[4]);
			huyen.setSelectedItem(col[5]);
			tinh.setSelectedItem(col[6]);
			sdt.setText(col[7]);
			email.setText(col[8]);
		}
	};

	ActionListener eventthemSV = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			int i = 0;
			int KT2 = 0;
			String lop_SinhVien = (String) cbo.getSelectedItem();
			String ma_SinhVien = masv.getText();
			String ten_SinhVien = ten.getText();
			String diachi_SinhVien = diachi.getText();
			String tp_SinhVien = (String) tinh.getSelectedItem();
			String quan_SinhVien = (String) huyen.getSelectedItem();
			String phuong_SinhVien = (String) xa.getSelectedItem();
			String email_SinhVien = email.getText();
			String sdt_SinhVien = sdt.getText();

			for (SinhVien x : arrSV) {
				if (masv.getText().equals(x.getMasv())) {
					i = 1;
				}
			}
			Pattern checkmail = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
			Matcher mail1 = checkmail.matcher((CharSequence) email_SinhVien);
			try {
				Integer.parseInt(sdt_SinhVien);
			} catch (NumberFormatException ex) {
				KT2 = 1;

			}
			if (i > 0) {
				JOptionPane.showMessageDialog(null, "Sinh viên đã tồn tại!!", null, JOptionPane.WARNING_MESSAGE);
			} else if (!mail1.find()) {
				JOptionPane.showMessageDialog(null, "EMAIL KHÔNG HỢP LỆ", null, JOptionPane.WARNING_MESSAGE);

			} else if (KT2 > 0) {
				JOptionPane.showMessageDialog(null, "SỐ ĐIỆN THOẠI CHỈ BAO GỒM SỐ", null, JOptionPane.WARNING_MESSAGE);

			} else if (sdt_SinhVien.length() > 0 && (sdt_SinhVien.length() < 10 || sdt_SinhVien.length() > 11)) {
				JOptionPane.showMessageDialog(null, "SỐ ĐIỆN THOẠI CHỈ TỪ 10-11 SỐ", null, JOptionPane.WARNING_MESSAGE);

			} else {
				try {
					if (lop_SinhVien.equals("Tất Cả") || ma_SinhVien.isEmpty() || ten_SinhVien.isEmpty()
							|| diachi_SinhVien.isEmpty() || email_SinhVien.isEmpty() || sdt_SinhVien.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Bạn chưa nhập thông tin cho sinh viên", null,
								JOptionPane.WARNING_MESSAGE);
					} else {
						arrSV.add(new SinhVien(lop_SinhVien, ma_SinhVien, ten_SinhVien, tp_SinhVien, quan_SinhVien,
								phuong_SinhVien, diachi_SinhVien, email_SinhVien, sdt_SinhVien));
						dmsv.addRow(new String[] { lop_SinhVien, ma_SinhVien, ten_SinhVien, tp_SinhVien,
								quan_SinhVien, phuong_SinhVien, diachi_SinhVien, email_SinhVien, sdt_SinhVien });
						Connection conn = Connect.getConnect("localhost", "Danh", "Danh", "Danh");
						try {
							String sql = "INSERT INTO Quan_ly_sinh_vien(ma_sinh_vien, ten_sinh_vien, ma_lop,tinh_thanh_pho, quan,Phuong, dia_chi, email, dien_thoai) VALUES  ('"
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
						try {
							Statement statement = conn.createStatement();
							ResultSet result = statement
									.executeQuery("SELECT * FROM mon_hoc_lop WHERE ten_lop ='" + lop_SinhVien + "'");
							while (result.next()) {
								String query = "INSERT INTO Quan_ly_diem(Lop,ma_sinh_vien,ma_mon_hoc,diem) VALUES ('" + lop_SinhVien
										+ "','" + ma_SinhVien + "','" + result.getString("ma_MH") + "','" + "0" + "')";
								Statement sttm = conn.createStatement();
								sttm.executeUpdate(query);

							}
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Bạn cần nhập thông tin sinh viên");
				}
			}
			dmsv.setRowCount(0);
			for (SinhVien x : arrSV) {
				if (lop_SinhVien.equals(x.getLop())) {
					String[] row = { x.getLop(), x.getMasv(), x.getTensv(), x.getDiachi(), x.getXa(), x.getHuyen(), x.getTinh(),
							x.getSdt(), x.getEmail() };
					dmsv.addRow(row);
				}
			}

			masv.setText("");
			ten.setText("");
			diachi.setText("");
			email.setText("");
			sdt.setText("");
			cbo.setSelectedItem("Tất Cả");
			tinh.setSelectedItem("Thành phố Hà Nội");
		}
	};

	ActionListener eventxoasv = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String lop_SinhVien = (String) cbo.getSelectedItem();
			String ma_SinhVien = masv.getText();
			String ten_SinhVien = ten.getText();
			String diachi_SinhVien = diachi.getText();
			String email_SinhVien = email.getText();
			String sdt_SinhVien = sdt.getText();

			Connection conn = Connect.getConnect("localhost", "Danh", "Danh", "Danh");
			try {
				if (lop_SinhVien.equals("Tất Cả") || ma_SinhVien.isEmpty() || ten_SinhVien.isEmpty()
						|| diachi_SinhVien.isEmpty() || email_SinhVien.isEmpty() || sdt_SinhVien.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Bạn chưa có thông tin sinh viên cần xóa", null,
							JOptionPane.WARNING_MESSAGE);
				} else {
					for (SinhVien x : arrSV) {
						if (masv.getText().equals(x.getMasv())) {
							arrSV.remove(x);
							break;
						}
					}
					String sql = "DELETE FROM Quan_ly_sinh_vien WHERE ma_sinh_vien = '" + masv.getText() + "'";
					String query = "DELETE FROM Quan_ly_diem WHERE ma_sinh_vien = '" + masv.getText() + "'";
					Statement statement = conn.createStatement();
					statement.executeUpdate(query);
					int x = statement.executeUpdate(sql);
					if (x >= 0) {
						JOptionPane.showMessageDialog(null, "Đã xóa thông tin sinh viên");
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			dmsv.setRowCount(0);
			String chonLop = (String) cbo.getSelectedItem();
			for (SinhVien x : arrSV) {
				if (chonLop.equals(x.getLop())) {
					String[] row = { x.getLop(), x.getMasv(), x.getTensv(), x.getDiachi(), x.getXa(), x.getHuyen(), x.getTinh(),
							x.getSdt(), x.getEmail() };
					dmsv.addRow(row);
				}
			}

			masv.setText("");
			ten.setText("");
			diachi.setText("");
			email.setText("");
			sdt.setText("");
			cbo.setSelectedItem("Tất Cả");
			tinh.setSelectedItem("Thành phố Hà Nội");
		}

	};

	ActionListener eventsuasv = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			int KT2 = 0;
			try {
				Integer.parseInt(sdt.getText());
			} catch (NumberFormatException ex) {
				KT2 = 1;

			}

			Pattern checkmail = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
			Matcher mail1 = checkmail.matcher(email.getText());
			try {
				if (((String) cbo.getSelectedItem()).equals("Tất Cả") || masv.getText().isEmpty()
						|| ten.getText().isEmpty() || diachi.getText().isEmpty() || email.getText().isEmpty()
						|| sdt.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Bạn chưa có thông tin sinh viên cần sửa", null,
							JOptionPane.WARNING_MESSAGE);
				} else if (!mail1.find()) {
					JOptionPane.showMessageDialog(null, "EMAIL KHÔNG HỢP LỆ", null, JOptionPane.WARNING_MESSAGE);

				} else if (KT2 > 0) {
					JOptionPane.showMessageDialog(null, "SỐ ĐIỆN THOẠI CHỈ BAO GỒM SỐ", null,
							JOptionPane.WARNING_MESSAGE);

				} else if (sdt.getText().length() > 0 && (sdt.getText().length() < 10 || sdt.getText().length() > 11)) {
					JOptionPane.showMessageDialog(null, "SỐ ĐIỆN THOẠI CHỈ TỪ 10-11 SỐ", null,
							JOptionPane.WARNING_MESSAGE);
				} else {
					for (SinhVien x : arrSV) {
						if (masv.getText().equals(x.getMasv())) {
							x.setTensv(ten.getText());
							x.setLop((String) cbo.getSelectedItem());
							x.setTinh((String) tinh.getSelectedItem());
							x.setHuyen((String) huyen.getSelectedItem());
							x.setXa((String) xa.getSelectedItem());
							x.setDiachi(diachi.getText());
							x.setEmail(email.getText());
							x.setSdt(sdt.getText());
							break;
						}
					}
					Connection conn = Connect.getConnect("localhost", "Danh", "Danh", "Danh");
					try {
						String sql = "UPDATE Quan_ly_sinh_vien SET ten_sinh_vien='" + ten.getText() + "',MaLop='"
								+ (String) cbo.getSelectedItem() + "',DiaChi='" + diachi.getText()
								+ "',Phuong='" + (String) xa.getSelectedItem() + "',Quan='"
								+ (String) huyen.getSelectedItem() + "',ThanhPho='" + (String) tinh.getSelectedItem()
								+ "',Email='" + email.getText() + "',DT='" + sdt.getText() + "' WHERE  MaSV='"
								+ masv.getText() + "'";
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

			dmsv.setRowCount(0);
			String chonLop = (String) cbo.getSelectedItem();
			for (SinhVien x : arrSV) {
				if (chonLop.equals(x.getLop())) {
					String[] row = { x.getLop(), x.getMasv(), x.getTensv(), x.getDiachi(), x.getXa(), x.getHuyen(), x.getTinh(),
							x.getSdt(), x.getEmail() };
					dmsv.addRow(row);
				}
			}

			masv.setText("");
			ten.setText("");
			diachi.setText("");
			email.setText("");
			sdt.setText("");
			cbo.setSelectedItem("Tất Cả");
			tinh.setSelectedItem("Thành phố Hà Nội");
		}
	};

//	ActionListener eventReset_SinhVien = new ActionListener() {
//
//		@Override
//		public void actionPerformed(ActionEvent arg0) {
//			themSinhVien.setEnabled(true);
//			MaSV.setEditable(true);
//			MaSV.setText("");
//			ten.setText("");
//			diachi.setText("");
//			email.setText("");
//			sdt.setText("");
//			selectSinhVien.setSelectedItem("Tất Cả");
//			tinh.setSelectedItem("Thành phố Hà Nội");
//		}
//	};
	// kết thúc CRUD Sinh viên


	ActionListener eventChooseClass = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String chonLop = (String) xemsv.getSelectedItem();

			dmsv.setRowCount(0);
			if (chonLop == "Tất Cả") {
				for (SinhVien x : arrSV) {
					String[] row = { x.getLop(), x.getMasv(), x.getTensv(), x.getDiachi(), x.getXa(), x.getHuyen(),
							x.getTinh(), x.getSdt(), x.getEmail() };
					dmsv.addRow(row);
				}
			} else {
				for (SinhVien x : arrSV) {
					if (chonLop.equals(x.getLop())) {
						String[] row = { x.getLop(), x.getMasv(), x.getTensv(), x.getDiachi(), x.getXa(), x.getHuyen(),
								x.getTinh(), x.getSdt(), x.getEmail() };
						dmsv.addRow(row);
					}
					cbo.setSelectedItem("");
					masv.setText("");
					ten.setText("");
					diachi.setText("");
					xa.setSelectedItem("");
					huyen.setSelectedItem("");
					tinh.setSelectedItem("");
					diachi.setText("");
					email.setText("");

				}
			}

		}

	};

}
