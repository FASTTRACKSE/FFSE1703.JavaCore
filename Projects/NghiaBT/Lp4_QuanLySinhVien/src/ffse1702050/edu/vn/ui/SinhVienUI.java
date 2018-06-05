package ffse1702050.edu.vn.ui;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import ffse1702050.edu.vn.model.*;
import ffse1702050.edu.vn.connectData.*;
public class SinhVienUI extends JPanel {
	private static final long serialVersionUID = 1L;
	private JPanel pnSinhvien, pnSinhvienbutton;
	private DefaultTableModel dm_sv;
	private JTable table_sv;
	private JScrollPane sc_sv;
	private JScrollPane sp_sv;
	
	SinhVienUI sinhVienUI;
	private JTextField maSV = new JTextField(), hoTen = new JTextField(), DiaChi = new JTextField(),
			Email = new JTextField(), DT = new JTextField();
	private ArrayList<SinhVienModel> arrSV = new ArrayList<SinhVienModel>();
	private JComboBox<String> tp = new JComboBox<>();
	private JComboBox<String> quan = new JComboBox<>();
	private JComboBox<String> phuong = new JComboBox<>();
	private JComboBox<String> maLopcomnoBox = new JComboBox<>();
	private JComboBox<String> comBoboxlop = new JComboBox<>();
	JTextField seach = new JTextField(30);
	private Button ThemSV = new Button("Thêm");
	private Button SuaSV = new Button("Sửa");
	private Button XoaSV = new Button("Xóa");
	private Button Timkiem = new Button("Tìm kiếm");

	public SinhVienUI() {
		tinh();
		quan();
		huyen();
		maLopcomnoBox();
		addControls();
		addEvent();
		selectLop();

	}

	public void timkiemlop() {
		String cholop = (String) comBoboxlop.getSelectedItem();
		dm_sv.setRowCount(0);
		if (cholop.equals("TẤT CẢ")) {
			for (SinhVienModel x : arrSV) {
				String[] row = { x.getMaSV(), x.getTen(), x.getLop(), x.getDiaChi(), x.getPhuong(), x.getQuan(),
						x.getTp(), x.getEmail(), x.getSdt() };
				dm_sv.addRow(row);
			}

		} else {
			for (SinhVienModel x : arrSV) {
				if (cholop.equals(x.getLop())) {
					String[] row = { x.getMaSV(), x.getTen(), x.getLop(), x.getDiaChi(), x.getPhuong(), x.getQuan(),
							x.getTp(), x.getEmail(), x.getSdt() };
					dm_sv.addRow(row);

				}

			}
		}
	}

	public void addControls() {

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setLayout(new BorderLayout());
		Border borderSV = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitleSV = BorderFactory.createTitledBorder(borderSV, "Danh sách");
		this.setBorder(borderTitleSV);

		dm_sv = new DefaultTableModel();
		dm_sv.addColumn("Mã SV");
		dm_sv.addColumn("Họ và tên");
		dm_sv.addColumn("Mã lớp");
		dm_sv.addColumn("Địa chỉ");
		dm_sv.addColumn("Phường");
		dm_sv.addColumn("Quận");
		dm_sv.addColumn("Thành phố");
		dm_sv.addColumn("Email");
		dm_sv.addColumn("Điện thoại");
		Connection conn = ConnectData.getConnect("localhost", "Lp4", "Lp4", "12345");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM lp4_sinhvien");
			while (result.next()) {
				arrSV.add(new SinhVienModel(result.getString("MaSV"), result.getString("Ten"),
						result.getString("MaLop"), result.getString("DiaChi"), result.getString("Phuong"),
						result.getString("Quan"), result.getString("ThanhPho"), result.getString("Email"),
						result.getString("DT")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (SinhVienModel x : arrSV) {
			String[] row = { x.getMaSV(), x.getTen(), x.getLop(), x.getDiaChi(), x.getPhuong(), x.getQuan(), x.getTp(),
					x.getEmail(), x.getSdt() };
			dm_sv.addRow(row);
		}

		table_sv = new JTable(dm_sv);
		table_sv.setLayout(new BorderLayout());
		sp_sv = new JScrollPane(table_sv);
		sc_sv = new JScrollPane(sp_sv, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc_sv.setPreferredSize(new Dimension(470, 180));

		JPanel muctimlopseachsv = new JPanel();
		muctimlopseachsv.setLayout(new BoxLayout(muctimlopseachsv, BoxLayout.Y_AXIS));
		JPanel flow = new JPanel();
		flow.setLayout(new FlowLayout());
		comBoboxlop = new JComboBox<>();
		JLabel xemlop = new JLabel("XEM LỚP");
		JLabel timkiem = new JLabel("TÌM KIẾM");
		flow.add(xemlop);
		flow.add(comBoboxlop);
		flow.add(timkiem);
		flow.add(seach);
		flow.add(Timkiem);
		muctimlopseachsv.add(flow);
		muctimlopseachsv.add(sc_sv);
		this.add(muctimlopseachsv);


		pnSinhvien = new JPanel();
		Border border2SV = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle2SV = BorderFactory.createTitledBorder(border2SV);
		pnSinhvien.setBorder(borderTitle2SV);
		pnSinhvien.setLayout(new FlowLayout());

		JPanel pnLeft1 = new JPanel();
		pnLeft1.setLayout(new BoxLayout(pnLeft1, BoxLayout.Y_AXIS));

		JPanel chonlop = new JPanel();
		chonlop.setLayout(new FlowLayout());
		JLabel txtlop = new JLabel("Mã lớp:  ");
		chonlop.add(txtlop);
		chonlop.add(maLopcomnoBox);
		pnLeft1.add(chonlop);

		JPanel nhapMaSV = new JPanel();
		JLabel lblNhapMaSV = new JLabel("Mã SV:");
		lblNhapMaSV.setPreferredSize(new Dimension(100, 30));
		maSV = new JTextField(20);
		nhapMaSV.add(lblNhapMaSV);
		nhapMaSV.add(maSV);
		pnLeft1.add(nhapMaSV);

		JPanel nhapHoten = new JPanel();
		nhapHoten.setLayout(new FlowLayout());
		JLabel lblHoTenSV = new JLabel("Họ và tên:");
		lblHoTenSV.setPreferredSize(new Dimension(100, 30));
		hoTen = new JTextField(20);
		nhapHoten.add(lblHoTenSV);
		nhapHoten.add(hoTen);
		pnLeft1.add(nhapHoten);

		JPanel nhapEmail = new JPanel();
		nhapEmail.setLayout(new FlowLayout());
		JLabel lblnhapEmail = new JLabel("Emaill:");
		lblnhapEmail.setPreferredSize(new Dimension(100, 30));
		Email = new JTextField(20);
		nhapEmail.add(lblnhapEmail);
		nhapEmail.add(Email);
		pnLeft1.add(nhapEmail);

		JPanel nhapSDT = new JPanel();
		nhapSDT.setLayout(new FlowLayout());
		JLabel lblnhapSDT = new JLabel("Số điện thoại:");
		lblnhapSDT.setPreferredSize(new Dimension(100, 30));
		DT = new JTextField(20);
		nhapSDT.add(lblnhapSDT);
		nhapSDT.add(DT);
		pnLeft1.add(nhapSDT);

		JPanel nhapDiaChi = new JPanel();
		nhapSDT.setLayout(new FlowLayout());
		JLabel lblnhapDiaChi = new JLabel("Địa chỉ:");
		lblnhapDiaChi.setPreferredSize(new Dimension(100, 30));
		DiaChi = new JTextField(20);
		nhapDiaChi.add(lblnhapDiaChi);
		nhapDiaChi.add(DiaChi);
		pnLeft1.add(nhapDiaChi);

		JPanel chontinh = new JPanel();
		chontinh.setLayout(new FlowLayout());
		JLabel txttinh = new JLabel("Tỉnh/Thành phố:  ");
		txttinh.setPreferredSize(new Dimension(100, 30));
		tp.setPreferredSize(new Dimension(220, 20));
		chontinh.add(txttinh);
		chontinh.add(tp);
		pnLeft1.add(chontinh);

		JPanel chonhuyen = new JPanel();
		chonhuyen.setLayout(new FlowLayout());
		JLabel txthuyen = new JLabel("Quận/Huyện:");
		txthuyen.setPreferredSize(new Dimension(100, 30));
		quan.setPreferredSize(new Dimension(220, 20));
		chonhuyen.add(txthuyen);
		chonhuyen.add(quan);
		pnLeft1.add(chonhuyen);

		JPanel chonquan = new JPanel();
		chonquan.setLayout(new FlowLayout());
		JLabel txtquan = new JLabel("Phường/Xã: ");
		txtquan.setPreferredSize(new Dimension(100, 30));
		phuong.setPreferredSize(new Dimension(220, 20));
		chonquan.add(txtquan);
		chonquan.add(phuong);
		pnLeft1.add(chonquan);

		pnSinhvienbutton = new JPanel();
		Border border4SV = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle4SV = BorderFactory.createTitledBorder(border4SV);
		pnSinhvienbutton.setBorder(borderTitle4SV);
		pnSinhvienbutton.setLayout(new FlowLayout());
		JPanel chucnangSV = new JPanel();
		chucnangSV.setLayout(new BoxLayout(chucnangSV, BoxLayout.X_AXIS));
		pnSinhvienbutton.setPreferredSize(new Dimension(200, 100));
		pnSinhvienbutton.add(ThemSV);
		pnSinhvienbutton.add(SuaSV);
		pnSinhvienbutton.add(XoaSV);

		pnSinhvienbutton.add(chucnangSV);
		pnSinhvien.add(pnLeft1);
		pnSinhvien.add(pnSinhvienbutton);

		this.add(pnSinhvien, BorderLayout.SOUTH);

	}

	public void selectLop() {
		Connection conn = ConnectData.getConnect("localhost", "Lp4", "Lp4", "12345");
		try {
			comBoboxlop.addItem("TẤT CẢ");
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM lp4_class");
			while (result.next()) {
				comBoboxlop.addItem(new String(result.getString("MaLop")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void maLopcomnoBox() {
		Connection conn = ConnectData.getConnect("localhost", "Lp4", "Lp4", "12345");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM lp4_class");
			while (result.next()) {
				maLopcomnoBox.addItem(new String(result.getString("MaLop")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void tinh() {
		Connection conn = ConnectData.getConnect("localhost", "Lp4", "Lp4", "12345");
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
		Connection conn = ConnectData.getConnect("localhost", "Lp4", "Lp4", "12345");
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
		Connection conn = ConnectData.getConnect("localhost", "Lp4", "Lp4", "12345");
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

		tp.addActionListener(eventChooseTp);
		quan.addActionListener(eventChooseQuan);
		table_sv.addMouseListener(eventTable_SV);
		ThemSV.addActionListener(eventAdd_SV);
		XoaSV.addActionListener(eventDel_SV);
		SuaSV.addActionListener(eventEdit_SV);
		comBoboxlop.addActionListener(eventchoseLop);
		Timkiem.addActionListener(eventTim);

	}

	ActionListener eventTim = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			try {
				dm_sv.setRowCount(0);
				for (SinhVienModel x : arrSV) {
					if ((seach.getText()).equals(x.getTen())) {
						String[] row = { x.getMaSV(), x.getTen(), x.getLop(), x.getDiaChi(), x.getPhuong(), x.getQuan(),
								x.getTp(), x.getEmail(), x.getSdt() };
						dm_sv.addRow(row);
					} else if ((seach.getText()).equals(x.getMaSV())) {
						String[] row = { x.getMaSV(), x.getTen(), x.getLop(), x.getDiaChi(), x.getPhuong(), x.getQuan(),
								x.getTp(), x.getEmail(), x.getSdt() };
						dm_sv.addRow(row);
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	};

	ActionListener eventchoseLop = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			timkiemlop();
		}
	};

	MouseAdapter eventTable_SV = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {

			int row = table_sv.getSelectedRow();
			String[] col = new String[9];
			col[0] = (String) table_sv.getValueAt(row, 0);
			col[1] = (String) table_sv.getValueAt(row, 1);
			col[2] = (String) table_sv.getValueAt(row, 2);
			col[3] = (String) table_sv.getValueAt(row, 3);
			col[4] = (String) table_sv.getValueAt(row, 4);
			col[5] = (String) table_sv.getValueAt(row, 5);
			col[6] = (String) table_sv.getValueAt(row, 6);
			col[7] = (String) table_sv.getValueAt(row, 7);
			col[8] = (String) table_sv.getValueAt(row, 8);
			maSV.setText(col[0]);
			hoTen.setText(col[1]);
			maLopcomnoBox.setSelectedItem(col[2]);
			DiaChi.setText(col[3]);
			phuong.setSelectedItem(col[4]);
			quan.setSelectedItem(col[5]);
			tp.setSelectedItem(col[6]);
			Email.setText(col[7]);
			DT.setText(col[8]);

		}
	};

	ActionListener eventAdd_SV = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String lop_SinhVien = (String) maLopcomnoBox.getSelectedItem();
			String ma_SinhVien = lop_SinhVien + maSV.getText();
			String ten_SinhVien = hoTen.getText();
			String diachi_SinhVien = DiaChi.getText();
			String tp_SinhVien = (String) tp.getSelectedItem();
			String quan_SinhVien = (String) quan.getSelectedItem();
			String phuong_SinhVien = (String) phuong.getSelectedItem();
			String email_SinhVien = Email.getText();
			String sdt_SinhVien = DT.getText();

			try {
				if (ma_SinhVien.equals(lop_SinhVien) || ten_SinhVien.equals("") || diachi_SinhVien.equals("")
						|| email_SinhVien.equals("") || sdt_SinhVien.equals("")) {
					JOptionPane.showMessageDialog(null, "Bạn chưa nhập thông tin");
				} else {
					arrSV.add(new SinhVienModel(ma_SinhVien, ten_SinhVien, lop_SinhVien, diachi_SinhVien,
							phuong_SinhVien, quan_SinhVien, tp_SinhVien, email_SinhVien, sdt_SinhVien));
					dm_sv.addRow(new String[] { ma_SinhVien, ten_SinhVien, lop_SinhVien, diachi_SinhVien,
							phuong_SinhVien, quan_SinhVien, tp_SinhVien, email_SinhVien, sdt_SinhVien });
					Connection conn = ConnectData.getConnect("localhost", "Lp4", "Lp4", "12345");
					try {
						String sql = "INSERT INTO lp4_sinhvien(MaSV, Ten, MaLop , DiaChi,Phuong, Quan,ThanhPho, Email, DT) VALUES  ('"
								+ ma_SinhVien + "','" + ten_SinhVien + "','" + lop_SinhVien + "','" + diachi_SinhVien
								+ "','" + phuong_SinhVien + "','" + quan_SinhVien + "','" + tp_SinhVien + "','"
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

			dm_sv.setRowCount(0);
			for (SinhVienModel x : arrSV) {
				if (lop_SinhVien.equals(x.getLop())) {
					String[] row = { x.getMaSV(), x.getTen(), x.getLop(), x.getDiaChi(), x.getPhuong(), x.getQuan(),
							x.getTp(), x.getEmail(), x.getSdt() };
					dm_sv.addRow(row);
				}
			}

			maSV.setText("");
			hoTen.setText("");
			DiaChi.setText("");
			Email.setText("");
			DT.setText("");
		}
	};

	ActionListener eventDel_SV = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			for (SinhVienModel x : arrSV) {
				if (maSV.getText().equals(x.getMaSV())) {
					arrSV.remove(x);
					break;
				}
			}
			Connection conn = ConnectData.getConnect("localhost", "Lp4", "Lp4", "12345");
			try {
				String sql = "DELETE FROM lp4_sinhvien WHERE MaSV = '" + maSV.getText() + "'";
				Statement statement = conn.createStatement();
				int x = statement.executeUpdate(sql);
				if (x >= 0) {
					JOptionPane.showMessageDialog(null, "Đã xóa thông tin sinh viên");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			dm_sv.setRowCount(0);
			String chonLop = (String) maLopcomnoBox.getSelectedItem();
			for (SinhVienModel x : arrSV) {
				if (chonLop.equals(x.getLop())) {
					String[] row = { x.getMaSV(), x.getTen(), x.getLop(), x.getDiaChi(), x.getPhuong(), x.getQuan(),
							x.getTp(), x.getEmail(), x.getSdt() };
					dm_sv.addRow(row);
				}
			}
		}

	};

	ActionListener eventEdit_SV = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			for (SinhVienModel x : arrSV) {
				if (maSV.getText().equals(x.getMaSV())) {
					x.setTen(hoTen.getText());
					x.setLop((String) maLopcomnoBox.getSelectedItem());
					x.setTp((String) tp.getSelectedItem());
					x.setQuan((String) quan.getSelectedItem());
					x.setPhuong((String) phuong.getSelectedItem());
					x.setAdress(DiaChi.getText());
					x.setEmail(Email.getText());
					x.setSdt(DT.getText());
					break;
				}
			}
			Connection conn = ConnectData.getConnect("localhost", "Lp4", "Lp4", "12345");
			try {
				String sql = "UPDATE lp4_sinhvien SET Ten ='" + hoTen.getText() + "',MaLop='"
						+ (String) maLopcomnoBox.getSelectedItem() + "',DiaChi='" + DiaChi.getText() + "',Phuong='"
						+ (String) phuong.getSelectedItem() + "',Quan='" + (String) quan.getSelectedItem()
						+ "',ThanhPho='" + (String) tp.getSelectedItem() + "',Email='" + Email.getText() + "',DT='"
						+ DT.getText() + "' WHERE  MaSV='" + maSV.getText() + "'";
				Statement statement = conn.createStatement();
				int x = statement.executeUpdate(sql);
				if (x >= 0) {
					JOptionPane.showMessageDialog(null, "Đã sửa thông tin sinh viên");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			dm_sv.setRowCount(0);
			String chonLop = (String) maLopcomnoBox.getSelectedItem();
			for (SinhVienModel x : arrSV) {
				if (chonLop.equals(x.getLop())) {
					String[] row = { x.getMaSV(), x.getTen(), x.getLop(), x.getDiaChi(), x.getPhuong(), x.getQuan(),
							x.getTp(), x.getEmail(), x.getSdt() };
					dm_sv.addRow(row);
				}
			}
		}
	};

	ActionListener eventReset_SinhVien = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			maSV.setText("");
			hoTen.setText("");
			DiaChi.setText("");
			Email.setText("");
			DT.setText("");
			maLopcomnoBox.setSelectedItem("Tất Cả");
			tp.setSelectedItem("Thành phố Hà Nội");
		}
	};

	ActionListener eventChooseTp = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String chonTinh = (String) tp.getSelectedItem();
			quan.removeAllItems();
			Connection conn = ConnectData.getConnect("localhost", "Lp4", "Lp4", "12345");
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
			Connection conn = ConnectData.getConnect("localhost", "Lp4", "Lp4", "12345");
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

}