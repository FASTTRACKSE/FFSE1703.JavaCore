package ffse20.project_lp4.ui;




import java.awt.BorderLayout;
import ffse20.project_lp4.connect.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import ffse20.project_lp4.model.*;
import com.mysql.jdbc.Connection;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;

public class SinhVienUI  extends JPanel {
	private static final long serialVersionUID = 1L;
	private JButton btnThemsv = new JButton("Thêm");
	private JButton btnSuasv = new JButton("Sửa");
	private JButton btnXoasv = new JButton("Xóa");
	private JButton btnNhapsv = new JButton("Nhập");
	private JComboBox<String> cboTinh = new JComboBox<>();
	private JComboBox<String> cboQuan = new JComboBox<>();
	private JComboBox<String> cboPhuong = new JComboBox<>();
	private JLabel txtquan = new JLabel("Quận(Huyện): ");
	private JLabel txttinh = new JLabel("Thành Phố(Tỉnh): ");
	private JLabel txtphuong = new JLabel("Phường(Xã): ");
	private JLabel txtlop = new JLabel("Chọn Mã Lớp: ");
	private JLabel lblNhapmaSV = new JLabel("Mã SV:");
	private JLabel lblNhapten = new JLabel("Họ Tên:");
	private JLabel lblNhapNgaySinh = new JLabel("Ngày Sinh:");
	private JLabel lblPhone = new JLabel("SĐT:");
	private JLabel lblNhapEmail = new JLabel("Email:");

	private DefaultTableModel  dmSV;

	private JTextField masv;
	private JTextField tenSV;
	private JTextField ngaySinh;
	private JTextField phone;
	private JTextField Email;

	private JScrollPane sc_SVien;
	private JTable tblSinhVien;
	JPanel ttSV = new JPanel();

	private JComboBox<String> maLopcomnoBox = new JComboBox<>();

	
	private JComboBox<String> maSV5 = new JComboBox<>();




	private ArrayList<QuanLySinhVienModel> arrSV = new ArrayList<QuanLySinhVienModel>();

	
	public SinhVienUI() {
		addControls();
		addEvents();
		tinh();
		lop(maLopcomnoBox);


	}

	public void addControls() {


		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		Border border2 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle2 = BorderFactory.createTitledBorder(border2, "NHẬP THÔNG TIN");
		this.setBorder(borderTitle2);

		JPanel cot1 = new JPanel();

		JPanel chonlop = new JPanel();
		chonlop.add(txtlop);
		chonlop.add(maLopcomnoBox);
		cot1.add(chonlop);

		JPanel nhapMaSV = new JPanel();
		nhapMaSV.setLayout(new FlowLayout());
		masv = new JTextField(12);
		nhapMaSV.add(lblNhapmaSV);
		nhapMaSV.add(masv);
		cot1.add(nhapMaSV);

		JPanel nhapTen = new JPanel();
		nhapTen.setLayout(new FlowLayout());
		tenSV = new JTextField(12);
		nhapTen.add(lblNhapten);
		nhapTen.add(tenSV);
		cot1.add(nhapTen);

		JPanel nhapNgaySinh = new JPanel();
		nhapNgaySinh.setLayout(new FlowLayout());
		ngaySinh = new JTextField(12);
		nhapNgaySinh.add(lblNhapNgaySinh);
		nhapNgaySinh.add(ngaySinh);
		cot1.add(nhapNgaySinh);

		JPanel nhapPhone = new JPanel();
		nhapPhone.setLayout(new FlowLayout());
		phone = new JTextField(12);
		nhapPhone.add(lblPhone);
		nhapPhone.add(phone);
		cot1.add(nhapPhone);

		JPanel nhapEmail = new JPanel();
		nhapEmail.setLayout(new FlowLayout());
		Email = new JTextField(12);
		nhapEmail.add(lblNhapEmail);
		nhapEmail.add(Email);
		cot1.add(nhapEmail);

		this.add(cot1);

		JPanel cot2 = new JPanel();

		JPanel chontinh = new JPanel();
		chontinh.add(txttinh);
		chontinh.add(cboTinh);
		cot2.add(chontinh);

		JPanel chonquan = new JPanel();
		chonquan.add(txtquan);
		chonquan.add(cboQuan);
		cot2.add(chonquan);

		JPanel chonphuong = new JPanel();
		chonphuong.add(txtphuong);
		chonphuong.add(cboPhuong);
		cot2.add(chonphuong);

		this.add(cot2);

		JPanel cot3 = new JPanel();

		JPanel chucNang = new JPanel();
		chucNang.setLayout(new FlowLayout());
		chucNang.add(btnThemsv);
		chucNang.add(btnSuasv);
		chucNang.add(btnXoasv);
		chucNang.add(btnNhapsv);
		cot3.add(chucNang);

		this.add(cot3);

		JPanel pnTable = new JPanel();
		dmSV = new DefaultTableModel();
		new JTable(dmSV);
		dmSV.addColumn("Mã Lớp");
		dmSV.addColumn("Mã SV");
		dmSV.addColumn("Họ Tên");
		dmSV.addColumn("Ngày Sinh");
		dmSV.addColumn("SĐT");
		dmSV.addColumn("Email");
		dmSV.addColumn("Phường(Xã)");
		dmSV.addColumn("Quận(Huyện)");
		dmSV.addColumn("Thành Phố(Tỉnh)");

		Connection conn = Connect.getConnect("localhost", "quanlysinhvien", "quanlysinhvien", "12345");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM tabel_sinhvien");
			while (result.next()) {
				arrSV.add(new QuanLySinhVienModel(result.getString("ma_SV"), result.getString("tenSV"),
						result.getString("maLop"), result.getString("ngaysinh"), result.getString("phuong"),
						result.getString("quan"), result.getString("thanhPho"), result.getString("email"),
						result.getString("phone")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (QuanLySinhVienModel x : arrSV) {
			String[] row = { x.getMaLop(), x.getMaSV(), x.getTenSV(), x.getNgaySinh(), x.getPhone(), x.getEmail(),
					x.getPhuong(), x.getQuan(), x.getThanhPho() };
			dmSV.addRow(row);
		}

		tblSinhVien = new JTable(dmSV);
		sc_SVien = new JScrollPane(tblSinhVien);
		JScrollPane VT = new JScrollPane(sc_SVien, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		VT.setPreferredSize(new Dimension(1300, 350));
		pnTable.add(VT, BorderLayout.CENTER);

		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Danh sách");
		pnTable.setBorder(borderTitle);
		this.add(pnTable);

	}

	public void tinh() {
		Connection conn = Connect.getConnect("localhost", "quanlysinhvien", "quanlysinhvien", "12345");

		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("select * from devvn_tinhthanhpho");
			while (result.next()) {
				// System.out.print(result);
				cboTinh.addItem(result.getString("name"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public void lop(JComboBox<String> x) {
		x.addItem("Tất Cả");
		Connection conn = Connect.getConnect("localhost", "quanlysinhvien", "quanlysinhvien", "12345");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM tabel_lop");
			while (result.next()) {
				x.addItem(new String(result.getString("MaLop")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	public void maLopcomnoBox() {
//		Connection conn = Connect.getConnect("localhost", "quanlysinhvien", "quanlysinhvien", "12345");
//		try {
//
//			Statement statement = conn.createStatement();
//			ResultSet result = statement.executeQuery("SELECT * FROM tabel_lop");
//			while (result.next()) {
//				maLopcomnoBox.addItem(new String(result.getString("MaLop")));
//
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}



	public void addEvents() {

		tblSinhVien.addMouseListener(eventTableSV);

		maLopcomnoBox.addActionListener(eventChooseClass);
		
		btnSuasv.addActionListener(eventEditSV);
		btnThemsv.addActionListener(eventAddSinhVien);
		btnXoasv.addActionListener(eventDelSinhVien);
		btnNhapsv.addActionListener(eventReset_SinhVien);
			
		cboTinh.addActionListener(eventChooseQuan);
		cboQuan.addActionListener(eventChoosePhuong);



	}

	
	
	
	ActionListener eventChooseSVien= new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			maSV5.removeAllItems();

			String chonSV = (String) maLopcomnoBox.getSelectedItem();
			Connection conn = Connect.getConnect("localhost", "quanlysinhvien", "quanlysinhvien", "12345");
			try {
				Statement statement = conn.createStatement();
				ResultSet result = statement.executeQuery(
						"SELECT tabel_sinhvien.tenSV FROM tabel_sinhvien INNER JOIN tabel_lop WHERE tabel_lop.maLop=tabel_sinhvien.maLop AND tabel_lop.maLop ='"
								+ chonSV + "'");
				while (result.next()) {
					maSV5.addItem(result.getString("tabel_sinhvien.tenSV"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	};

	///////////// event-ThanhPho/////////////////////
	ActionListener eventChooseQuan = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			cboQuan.removeAllItems();

			String chonTinh = (String) cboTinh.getSelectedItem();
			Connection conn = Connect.getConnect("localhost", "quanlysinhvien", "quanlysinhvien", "12345");
			try {
				Statement statement = conn.createStatement();
				ResultSet result = statement.executeQuery(
						"SELECT devvn_quanhuyen.name FROM devvn_quanhuyen INNER JOIN devvn_tinhthanhpho WHERE devvn_quanhuyen.matp=devvn_tinhthanhpho.matp AND devvn_tinhthanhpho.name ='"
								+ chonTinh + "'");
				while (result.next()) {
					cboQuan.addItem(result.getString("devvn_quanhuyen.name"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	};
	ActionListener eventChoosePhuong = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			cboPhuong.removeAllItems();
			String chonPhuong = (String) cboQuan.getSelectedItem();
			Connection conn = Connect.getConnect("localhost", "quanlysinhvien", "quanlysinhvien", "12345");
			try {
				Statement statement = conn.createStatement();
				ResultSet result = statement.executeQuery(
						"SELECT devvn_xaphuongthitran.name FROM devvn_xaphuongthitran INNER JOIN devvn_quanhuyen WHERE devvn_quanhuyen.maqh=devvn_xaphuongthitran.maqh AND devvn_quanhuyen.name='"
								+ chonPhuong + "'");
				// System.out.println(result.next());
				while (result.next()) {
					cboPhuong.addItem(result.getString("devvn_xaphuongthitran.name"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			// System.out.println(chonPhuong);

		}
	};



	///////////////////////////////////////////////////////////////////
	///////////////// EVENT-QUANLYSINHVIEN////////////////////////
	///////////////////////////////////////////////////////
	MouseAdapter eventTableSV = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int row = tblSinhVien.getSelectedRow();
			String[] col = new String[9];
			col[0] = (String) tblSinhVien.getValueAt(row, 0);
			col[1] = (String) tblSinhVien.getValueAt(row, 1);
			col[2] = (String) tblSinhVien.getValueAt(row, 2);
			col[3] = (String) tblSinhVien.getValueAt(row, 3);
			col[4] = (String) tblSinhVien.getValueAt(row, 4);
			col[5] = (String) tblSinhVien.getValueAt(row, 5);
			col[6] = (String) tblSinhVien.getValueAt(row, 6);
			col[7] = (String) tblSinhVien.getValueAt(row, 7);
			col[8] = (String) tblSinhVien.getValueAt(row, 8);

			maLopcomnoBox.setSelectedItem(col[0]);
			masv.setEditable(false);
			masv.setText(col[1]);
			tenSV.setText(col[2]);
			ngaySinh.setText(col[3]);
			phone.setText(col[4]);
			Email.setText(col[5]);
			cboPhuong.setSelectedItem(col[6]);
			cboQuan.setSelectedItem(col[7]);
			cboTinh.setSelectedItem(col[8]);

		}
	};

	ActionListener eventAddSinhVien = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String maLp = (String) maLopcomnoBox.getSelectedItem();

			String maSV = masv.getText();
			String ten = tenSV.getText();
			String nam = ngaySinh.getText();
			String sdt = phone.getText();
			String email = Email.getText();
			String tp_SinhVien = (String) cboTinh.getSelectedItem();
			String quan_SinhVien = (String) cboQuan.getSelectedItem();
			String phuong_SinhVien = (String) cboPhuong.getSelectedItem();

			try {
				if (maSV.equals("") || ten.equals("") || nam.equals("") || email.equals("")) {
					JOptionPane.showMessageDialog(null, "Bạn chưa nhập thông tin");
				} else {
					arrSV.add(new QuanLySinhVienModel(maSV, ten, maLp, nam, phuong_SinhVien, quan_SinhVien, tp_SinhVien,
							email, sdt));
					dmSV.addRow(new String[] { maLp, maSV, ten, nam, sdt, email, phuong_SinhVien, quan_SinhVien,
							tp_SinhVien });
					Connection conn = Connect.getConnect("localhost", "quanlysinhvien", "quanlysinhvien", "12345");
					try {
						String sql = "INSERT INTO tabel_sinhvien(ma_SV, tenSV, maLop , ngaysinh, phuong, quan, thanhPho, email, phone) VALUES('"
								+ maSV + "','" + ten + "','" + maLp + "','" + nam + "','" + phuong_SinhVien + "','"
								+ quan_SinhVien + "','" + tp_SinhVien + "','" + email + "','" + sdt + "')";
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
		}
	};
	ActionListener eventEditSV = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			for (QuanLySinhVienModel x : arrSV) {
				if ((masv.getText()).equals(x.getMaSV())) {
					x.setMaLop((String) maLopcomnoBox.getSelectedItem());
					x.setTenSV(tenSV.getText());
					x.setThanhPho((String) cboTinh.getSelectedItem());
					x.setQuan((String) cboQuan.getSelectedItem());
					x.setPhuong((String) cboPhuong.getSelectedItem());
					x.setNgaySinh(ngaySinh.getText());
					x.setEmail(Email.getText());
					x.setPhone(phone.getText());
					break;
				}
			}
			Connection conn = Connect.getConnect("localhost", "quanlysinhvien", "quanlysinhvien", "12345");
			try {
				String sql = "UPDATE tabel_sinhvien SET tenSV='" + tenSV.getText() + "',ma_SV='" + masv.getText()
						+ "',maLop='" + maLopcomnoBox.getSelectedItem() + "',ngaysinh='" + ngaySinh.getText()
						+ "',phuong='" + cboPhuong.getSelectedItem() + "',quan='" + cboQuan.getSelectedItem()
						+ "',thanhPho='" + cboTinh.getSelectedItem() + "',email='" + Email.getText() + "',phone='"
						+ phone.getText() + "'  WHERE ma_SV = '" + masv.getText() + "'";
				Statement statement = conn.createStatement();
				int x = statement.executeUpdate(sql);
				if (x >= 0) {
					JOptionPane.showMessageDialog(null, "Đã sửa thông tin môn học");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			dmSV.setRowCount(0);
			for (QuanLySinhVienModel x : arrSV) {
				String[] row = { x.getMaLop(), x.getMaSV(), x.getTenSV(), x.getNgaySinh(), x.getPhone(), x.getEmail(),
						x.getPhuong(), x.getQuan(), x.getThanhPho() };
				dmSV.addRow(row);
			}

		}

	};
	ActionListener eventDelSinhVien = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			for (QuanLySinhVienModel x : arrSV) {
				if (masv.getText().equals(x.getMaSV())) {
					arrSV.remove(x);
					break;
				}
			}
			Connection conn = Connect.getConnect("localhost", "quanlysinhvien", "quanlysinhvien", "12345");
			try {
				String sql = "DELETE FROM tabel_sinhvien WHERE ma_SV = '" + masv.getText() + "'";
				Statement statement = conn.createStatement();
				int x = statement.executeUpdate(sql);
				if (x >= 0) {
					JOptionPane.showMessageDialog(null, "Đã xóa thông tin sinh viên");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			dmSV.setRowCount(0);
			for (QuanLySinhVienModel x : arrSV) {
				String[] row = { x.getMaLop(), x.getMaSV(), x.getTenSV(), x.getNgaySinh(), x.getPhone(), x.getEmail(),
						x.getPhuong(), x.getQuan(), x.getThanhPho() };
				dmSV.addRow(row);
			}
		}

	};
	ActionListener eventChooseClass = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String chonLop = (String) maLopcomnoBox.getSelectedItem();
			dmSV.setRowCount(0);
			if (chonLop == "Tất Cả") {

				for (QuanLySinhVienModel x : arrSV) {
					String[] row = { x.getMaLop(), x.getMaSV(), x.getTenSV(), x.getNgaySinh(), x.getPhone(), x.getEmail(),
							x.getPhuong(), x.getQuan(), x.getThanhPho() };
					dmSV.addRow(row);
				}

			} else {
				for (QuanLySinhVienModel x : arrSV) {
					if (chonLop.equals(x.getMaLop())) {
						String[] row = { x.getMaLop(), x.getMaSV(), x.getTenSV(), x.getNgaySinh(), x.getPhone(), x.getEmail(),
								x.getPhuong(), x.getQuan(), x.getThanhPho() };
						dmSV.addRow(row);
					}
				}
			}
		}

	};
	ActionListener eventReset_SinhVien = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			masv.setEditable(true);
			masv.setText("");
			tenSV.setText("");
			ngaySinh.setText("");
			Email.setText("");
			phone.setText("");

		}
	};
}
