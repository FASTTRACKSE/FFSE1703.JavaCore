package fasttrackse.edu.vn.project4.ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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

import fasttrackse.edu.vn.project4.model.Connect;

import fasttrackse.edu.vn.project4.model.SinhVien;

public class QuanLySinhVienUI  extends JPanel{
	private static final long serialVersionUID = 1L;

	public QuanLySinhVienUI() {
		tinh();
		quan();
		huyen();
		lopSinhVien();
		addControl();
		addEvent();

	}


	// sinh vien
	private JTextField ten = new JTextField(15);
	private JTextField email = new JTextField(15);
	private JTextField sdt = new JTextField(15);
	private JTextField diachi = new JTextField(15);
	private JTextField masv = new JTextField(15);
	private JTextField tuoisv = new JTextField(15);

	@SuppressWarnings("rawtypes")
	JComboBox cbo = new JComboBox();
	@SuppressWarnings("rawtypes")
	JComboBox cbo2 = new JComboBox();
	@SuppressWarnings("rawtypes")
	JComboBox cbo3 = new JComboBox();
	@SuppressWarnings("rawtypes")
	JComboBox cbo4 = new JComboBox();

	private ArrayList<SinhVien> arrSV = new ArrayList<SinhVien>();

	int stt = 0;

	DefaultTableModel dm_sinhvien;

	JTable tbl_sinhvien;

	CardLayout cardlayout;

	

	private JPanel pnBorder = new JPanel();

	private JButton btnThemsv = new JButton("Thêm");
	private JButton btnSuasv = new JButton("Sửa");
	private JButton btnXoasv = new JButton("Xoá");
	private JButton btnNhapsv = new JButton("Reset");

	
@SuppressWarnings("unchecked")
public void addControl() {
	
	

	

		// quan ly sinh vien
	

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JLabel lbl = new JLabel("Chương Trình Quản Lý Sinh Viên");
		Font font = new Font("Arial", Font.BOLD, 24);
		lbl.setFont(font);
		JPanel pnSouth = new JPanel();
		pnSouth.setBackground(Color.blue);
		pnSouth.add(lbl);
		this.add(pnSouth, BorderLayout.SOUTH);
		

		JPanel pnbutton = new JPanel();
		pnbutton.setLayout(new FlowLayout());
		pnbutton.add(btnThemsv);
		pnbutton.add(btnSuasv);
		pnbutton.add(btnXoasv);
		pnbutton.add(btnNhapsv);
		this.add(pnbutton);

		JPanel pnCombo = new JPanel();
		pnCombo.setLayout(new FlowLayout());
		JLabel lblContent1 = new JLabel("Chọn Lớp : ");
		// JComboBox cbo=new JComboBox();
		
		pnCombo.add(lblContent1);
		pnCombo.add(cbo);

		JLabel lblContent2 = new JLabel("Tỉnh/TP : ");
		// JComboBox cbo2=new JComboBox();

		pnCombo.add(lblContent2);
		pnCombo.add(cbo2);

		JLabel lblContent3 = new JLabel("Quận : ");
		// JComboBox cbo3=new JComboBox();

		pnCombo.add(lblContent3);
		pnCombo.add(cbo3);

		JLabel lblContent4 = new JLabel("Phường : ");
		// JComboBox cbo4=new JComboBox();

		pnCombo.add(lblContent4);
		pnCombo.add(cbo4);
		this.add(pnCombo);

		JPanel pnnhap = new JPanel();
		pnnhap.setLayout(new FlowLayout());
		JPanel pnLeft = new JPanel();
		pnLeft.setLayout(new BoxLayout(pnLeft, BoxLayout.Y_AXIS));
		JLabel lbl1 = new JLabel("Tên :");
		pnLeft.add(lbl1);
		pnLeft.add(ten);

		JLabel lbl5 = new JLabel("Mã Sinh Viên :");
		pnLeft.add(lbl5);
		pnLeft.add(masv);
		pnnhap.add(pnLeft);

		JPanel pnGiua = new JPanel();
		pnGiua.setLayout(new BoxLayout(pnGiua, BoxLayout.Y_AXIS));
		JLabel lbl6 = new JLabel("Day Of Birth :");
		pnGiua.add(lbl6);
		pnGiua.add(tuoisv);

		JLabel lbl4 = new JLabel("Địa Chỉ :");
		pnGiua.add(lbl4);
		pnGiua.add(diachi);
		pnnhap.add(pnGiua);

		JPanel pnRight = new JPanel();
		pnRight.setLayout(new BoxLayout(pnRight, BoxLayout.Y_AXIS));
		JLabel lbl2 = new JLabel("Email :");
		pnRight.add(lbl2);
		pnRight.add(email);

		JLabel lbl3 = new JLabel("SĐT :");
		pnRight.add(lbl3);
		pnRight.add(sdt);
		pnnhap.add(pnRight);

		this.add(pnnhap);

		this.setBackground(Color.white);

		JPanel pnTable = new JPanel();
		dm_sinhvien = new DefaultTableModel();

		dm_sinhvien.addColumn("Mã Lớp");
		dm_sinhvien.addColumn("Mã");
		dm_sinhvien.addColumn("Tên");
		dm_sinhvien.addColumn("Tỉnh/TP");
		dm_sinhvien.addColumn("Phường");
		dm_sinhvien.addColumn("Quận");
		dm_sinhvien.addColumn("Địa Chỉ");

		dm_sinhvien.addColumn("Email");
		dm_sinhvien.addColumn("SĐT");
		dm_sinhvien.addColumn(" Ngày Sinh");
		Connection conn = Connect.getConnect("localhost", "project4", "viettu", "12345");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM Quan_ly_sinh_vien");
			while (result.next()) {
				arrSV.add(new SinhVien(result.getString("ma_lop"), result.getString("ma_sinh_vien"),
						result.getString("ten_sinh_vien"), result.getString("tinh_thanh_pho"),
						result.getString("phuong"), result.getString("quan"), result.getString("dia_chi"),
						result.getString("email"), result.getString("dien_thoai"), result.getString("tuoi")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (SinhVien x : arrSV) {
			String[] row = { x.getLop(), x.getMaSV(), x.getTenSV(), x.getTp(), x.getPhuong(), x.getQuan(),
					x.getDiaChi(), x.getEmail(), x.getSdt(), x.getTuoi() };
			dm_sinhvien.addRow(row);
		}

		tbl_sinhvien = new JTable(dm_sinhvien);
		JScrollPane sc = new JScrollPane(tbl_sinhvien);
		JScrollPane VT = new JScrollPane(sc, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		VT.setPreferredSize(new Dimension(1170, 520));
		pnTable.add(VT, BorderLayout.CENTER);

		Border border = BorderFactory.createLineBorder(Color.blue);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Danh sách sinh viên");
		pnTable.setBorder(borderTitle);
		this.add(pnTable);
		pnBorder.add(this, BorderLayout.CENTER);
//		getContentPane().add(pnBorder);

}
	@SuppressWarnings("unchecked")
	public void tinh() {
		Connection conn = Connect.getConnect("localhost", "project4", "viettu", "12345");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM devvn_tinhthanhpho");
			while (result.next()) {
				cbo2.addItem(new String(result.getString("name")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	public void quan() {
		Connection conn = Connect.getConnect("localhost", "project4", "viettu", "12345");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM devvn_quanhuyen");
			while (result.next()) {
				cbo3.addItem(new String(result.getString("name")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	public void huyen() {
		Connection conn = Connect.getConnect("localhost", "project4", "viettu", "12345");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM devvn_xaphuongthitran");
			while (result.next()) {
				cbo4.addItem(new String(result.getString("name")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	@SuppressWarnings("unchecked")
	public void lopSinhVien() {
		Connection conn = Connect.getConnect("localhost", "project4", "viettu", "12345");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM quan_ly_lop_hoc");
			while (result.next()) {
				cbo.addItem(new String(result.getString("ma_lop")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addEvent() {

		// chọn TP, huyện, xã
		cbo2.addActionListener(eventChooseTp);
		cbo3.addActionListener(eventChooseQuan);
		cbo.addActionListener(eventChooseClass);
		
		// sinh viên
		tbl_sinhvien.addMouseListener(eventTable_sinhvien);
		btnThemsv.addActionListener(AddSV);
		btnXoasv.addActionListener(DelSV);
		btnSuasv.addActionListener(eventEditSV);
		btnNhapsv.addActionListener(Reset_SV);

		
	}

	// chọn TP, huyện, xã
	ActionListener eventChooseTp = new ActionListener() {

		@SuppressWarnings("unchecked")
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String chonTinh = (String) cbo2.getSelectedItem();
			dm_sinhvien.setRowCount(0);
			cbo3.removeAllItems();
			Connection conn = Connect.getConnect("localhost", "project4", "viettu", "12345");
			System.out.println(chonTinh);
			try {
				Statement statement = conn.createStatement();
				ResultSet result = statement.executeQuery(
						"SELECT devvn_quanhuyen.name FROM devvn_quanhuyen INNER JOIN devvn_tinhthanhpho WHERE devvn_quanhuyen.matp=devvn_tinhthanhpho.matp AND devvn_tinhthanhpho.name ='"
								+ chonTinh + "'");
				while (result.next()) {
					cbo3.addItem(new String(result.getString("devvn_quanhuyen.name")));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	};

	ActionListener eventChooseQuan = new ActionListener() {

		@SuppressWarnings("unchecked")
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String chonTinh = (String) cbo3.getSelectedItem();
			dm_sinhvien.setRowCount(0);
			cbo4.removeAllItems();
			Connection conn = Connect.getConnect("localhost", "project4", "viettu", "12345");
			System.out.println(chonTinh);
			try {
				Statement statement = conn.createStatement();
				ResultSet result = statement.executeQuery(
						"SELECT devvn_xaphuongthitran.name FROM devvn_xaphuongthitran INNER JOIN devvn_quanhuyen WHERE devvn_xaphuongthitran.maqh=devvn_quanhuyen.maqh AND devvn_quanhuyen.name ='"
								+ chonTinh + "'");
				while (result.next()) {
					cbo4.addItem(new String(result.getString("devvn_xaphuongthitran.name")));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	};

	// mouseclick sinh viên
	MouseAdapter eventTable_sinhvien = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int col = tbl_sinhvien.getSelectedRow();
			String[] row = new String[10];
			row[0] = (String) tbl_sinhvien.getValueAt(col, 0);
			row[1] = (String) tbl_sinhvien.getValueAt(col, 1);
			row[2] = (String) tbl_sinhvien.getValueAt(col, 2);
			row[3] = (String) tbl_sinhvien.getValueAt(col, 3);
			row[4] = (String) tbl_sinhvien.getValueAt(col, 4);
			row[5] = (String) tbl_sinhvien.getValueAt(col, 5);
			row[6] = (String) tbl_sinhvien.getValueAt(col, 6);
			row[7] = (String) tbl_sinhvien.getValueAt(col, 7);
			row[8] = (String) tbl_sinhvien.getValueAt(col, 8);
			row[9] = (String) tbl_sinhvien.getValueAt(col, 9);

			cbo.setSelectedItem(row[0]);
			masv.setText(row[1]);
			ten.setText(row[2]);
			cbo2.setSelectedItem(row[3]);
			cbo3.setSelectedItem(row[4]);
			cbo4.setSelectedItem(row[5]);
			diachi.setText(row[6]);
			email.setText(row[7]);
			sdt.setText(row[8]);
			tuoisv.setText(row[9]);

			for (int i = 0; i < arrSV.size(); i++) {
				if (row[1].equals(arrSV.get(i).getMaSV())) {
					stt = i;
				}
			}
		}
	};

	// choseclass sinh viên
	ActionListener eventChooseClass = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String chonLop = (String) cbo.getSelectedItem();
			dm_sinhvien.setRowCount(0);
			if (chonLop == "Tất Cả") {

				for (SinhVien x : arrSV) {
					String[] row = { x.getLop(), x.getMaSV(), x.getTenSV(), x.getTp(), x.getPhuong(), x.getQuan(),
							x.getDiaChi(), x.getEmail(), x.getSdt(), x.getTuoi() };
					dm_sinhvien.addRow(row);
				}

			} else {
				for (SinhVien x : arrSV) {
					if (chonLop.equals(x.getLop())) {
						String[] row = { x.getLop(), x.getMaSV(), x.getTenSV(), x.getTp(), x.getPhuong(), x.getQuan(),
								x.getDiaChi(), x.getEmail(), x.getSdt(), x.getTuoi() };
						dm_sinhvien.addRow(row);
					}
				}
			}
		}

	};

	// thêm sinh viên
	ActionListener AddSV = new ActionListener() {

		public void actionPerformed(ActionEvent arg0) {
			String chonLop = (String) cbo.getSelectedItem();
			String tinh = (String) cbo2.getSelectedItem();
			String quan = (String) cbo3.getSelectedItem();
			String xa = (String) cbo4.getSelectedItem();

			String tensv = ten.getText();
			String emailsv = email.getText();
			String sdtsv = sdt.getText();
			String diachisv = diachi.getText();
			String ma = masv.getText();
			String tuoi = tuoisv.getText();

			Connection conn = Connect.getConnect("localhost", "project4", "viettu", "12345");
			try {
				try {
					if (chonLop.equals("Tất Cả") || tensv.equals("") || emailsv.equals("") || sdtsv.equals("")
							|| diachisv.equals("") || ma.equals("") || tuoi.equals("")) {
						JOptionPane.showMessageDialog(null, "Bạn chưa nhập thông tin cho sinh viên");
					} else {
						arrSV.add(new SinhVien(chonLop, ma, tensv, tinh, quan, xa, diachisv, emailsv, sdtsv, tuoi));
						dm_sinhvien.addRow(
								new String[] { chonLop, ma, tensv, tinh, quan, xa, diachisv, emailsv, sdtsv, tuoi });
						String sql = "INSERT INTO Quan_ly_sinh_vien(  ma_lop, ma_sinh_vien,ten_sinh_vien,tinh_thanh_pho,  phuong, quan,dia_chi,  dien_thoai, email, tuoi ) VALUES ('"
								+ chonLop + "','" + ma + "','" + tensv + "','" + tinh + "','" + quan + "','" + xa
								+ "','" + diachisv + "','" + sdtsv + "', '" + emailsv + "', '" + tuoi + "')";
						Statement statement = (Statement) conn.createStatement();
						int x = statement.executeUpdate(sql);
						if (x > 0) {
							JOptionPane.showMessageDialog(null, "Đã lưu thông tin sinh viên");
						}
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}
			ten.setText("");
			email.setText("");
			sdt.setText("");
			diachi.setText("");
			masv.setText("");
			tuoisv.setText("");

		}
	};

	// xóa sinh viên
	ActionListener DelSV = new ActionListener() {

		public void actionPerformed(ActionEvent arg0) {
			try {

				arrSV.remove(stt);

				Connection conn = Connect.getConnect("localhost", "project4", "viettu", "12345");
				try {
					String sql = "DELETE FROM Quan_ly_sinh_vien WHERE ma_sinh_vien = '" + masv.getText() + "'";
					Statement statement = (Statement) conn.createStatement();
					int x = statement.executeUpdate(sql);
					if (x >= 0) {
						JOptionPane.showMessageDialog(null, "Đã xóa thông tin sinh viên");
					}
				} catch (Exception ex) {
					ex.printStackTrace();

				}
			}

			catch (Exception e) {

			}
			dm_sinhvien.setRowCount(0);
			for (SinhVien x : arrSV) {
				String[] row = { x.getLop(), x.getMaSV(), x.getTenSV(), x.getTp(), x.getPhuong(), x.getQuan(),
						x.getDiaChi(), x.getEmail(), x.getSdt(), x.getTuoi() };
				dm_sinhvien.addRow(row);
			}

		}
	};
	// sửa sinh viên
	ActionListener eventEditSV = new ActionListener() {

		public void actionPerformed(ActionEvent arg0) {

			for (SinhVien x : arrSV) {
				if (masv.getText().equals(x.getMaSV())) {
					x.setDiaChi(diachi.getText());
					x.setTenSV(ten.getText());
					x.setLop((String) cbo.getSelectedItem());
					x.setTp((String) cbo2.getSelectedItem());
					x.setPhuong((String) cbo3.getSelectedItem());
					x.setQuan((String) cbo4.getSelectedItem());
					x.setEmail(email.getText());
					x.setSdt(sdt.getText());
					x.setTuoi(tuoisv.getText());

					break;
				}
			}
			Connection conn = Connect.getConnect("localhost", "project4", "viettu", "12345");
			try {
				String sql = "UPDATE Quan_ly_sinh_vien SET dia_chi ='" + diachi.getText() + "',phuong ='"
						+ (String) cbo3.getSelectedItem() + "',quan ='" + (String) cbo4.getSelectedItem()
						+ "',tinh_thanh_pho ='" + (String) cbo2.getSelectedItem() + "',dien_thoai ='" + sdt.getText()
						+ "',email ='" + email.getText() + "',ma_lop ='" + (String) cbo.getSelectedItem() + "',tuoi ='"
						+ tuoisv.getText() + "',ten_sinh_vien ='" + ten.getText() + "' WHERE ma_sinh_vien = '"
						+ masv.getText() + "'";

				Statement statement = (Statement) conn.createStatement();
				int x = statement.executeUpdate(sql);
				if (x >= 0) {
					JOptionPane.showMessageDialog(null, "Đã sửa thông tin sinh viên");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			dm_sinhvien.setRowCount(0);
			@SuppressWarnings("unused")
			String chonLop = (String) cbo.getSelectedItem();
			for (SinhVien x : arrSV) {
				String[] row = { x.getLop(), x.getMaSV(), x.getTenSV(), x.getTp(), x.getPhuong(), x.getQuan(),
						x.getDiaChi(), x.getEmail(), x.getSdt(), x.getTuoi() };
				dm_sinhvien.addRow(row);
			}

		}

	};

	// reset sinh viên
	ActionListener Reset_SV = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			ten.setText("");
			email.setText("");
			sdt.setText("");
			diachi.setText("");
			masv.setText("");
			tuoisv.setText("");
		}
	};



}
