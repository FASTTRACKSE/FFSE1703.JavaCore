package QuanLyTruongHoc.FFSE.UI;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import QuanLyTruongHoc.FFSE.Model.*;

public class NhapDiemUI extends JPanel {
	private static final long serialVersionUID = 1L;

	private JPanel pnNhapdiem, pnNhapdiembutton;
	private DefaultTableModel dm_nhapdiem;
	private JTable table_nhapdiem;
	private JScrollPane sc_nhapdiem;
	private JTextField nhapDiemsv = new JTextField();
	private ArrayList<NhapDiem> arrNhapdiem = new ArrayList<NhapDiem>();
	private JComboBox<String> maLopcomnoBox = new JComboBox<>();
	private JComboBox<String> maSVcomnoBox = new JComboBox<>();
	private JComboBox<String> maMonhoc = new JComboBox<>();
	private JComboBox<String> comBoboxlop = new JComboBox<>();
	private JButton ThemDiem = new JButton("Thêm");
	private JButton SuaDiem = new JButton("Sửa");
	private JButton nhapSinhVien = new JButton("Nhập");
	public NhapDiemUI() {
		maLopcomnoBox();
		maMonhoc();
		maSVcomnoBox();
		addControls();
		addEvent();
		selectLop();

	}

	public void timkiemlop() {
		String cholop = (String) comBoboxlop.getSelectedItem();
		dm_nhapdiem.setRowCount(0);
		if (cholop.equals("TẤT CẢ")) {
			for (NhapDiem x : arrNhapdiem) {
				String[] row = { x.getMaLop(), x.getMaSV(), x.getMaMH(), x.getDiem() };
				dm_nhapdiem.addRow(row);
			}

		} else {
			for (NhapDiem x : arrNhapdiem) {
				if (cholop.equals(x.getMaLop())) {
					String[] row = { x.getMaLop(), x.getMaSV(), x.getMaMH(), x.getDiem() };
					dm_nhapdiem.addRow(row);

				}

			}
		}
	}

	public void timkiemMaSV() {
		try {
			String Command = "SELECT MaSV FROM table_sinhvien WHERE MaLop ='" + (String) maLopcomnoBox.getSelectedItem()
					+ "'";
			Connection conn = Connect.getConnect("localhost", "admin", "admin1", "12345");
			Statement st = conn.createStatement();
			ResultSet result = st.executeQuery(Command);
			while (result.next()) {
				maSVcomnoBox.addItem(new String(result.getString("MaSV")));
			}
		} catch (Exception e) {

		}
	}

	public void timkiemMaMon() {
		try {
			String Command = "SELECT MaMH FROM table_monhoccholop WHERE MaLop ='"
					+ (String) maLopcomnoBox.getSelectedItem() + "'";
			Connection conn = Connect.getConnect("localhost", "admin", "admin1", "12345");
			Statement st = conn.createStatement();
			ResultSet result = st.executeQuery(Command);
			while (result.next()) {
				maMonhoc.addItem(new String(result.getString("MaMH")));
			}
		} catch (Exception e) {

		}
	}

	public void addControls() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setLayout(new BorderLayout());
		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Danh sách điểm của sinh viên");
		this.setBorder(borderTitle);
		dm_nhapdiem = new DefaultTableModel();
		dm_nhapdiem.addColumn("Mã lớp học");
		dm_nhapdiem.addColumn("Mã sinh viên");
		dm_nhapdiem.addColumn("Mã môn học");
		dm_nhapdiem.addColumn("Điểm môn học");
		Connection conn = Connect.getConnect("localhost", "admin", "admin1", "12345");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM table_diem");
			while (result.next()) {
				arrNhapdiem.add(new NhapDiem(result.getString("MaLop"), result.getString("MaMH"),
						result.getString("MaSV"), result.getString("Diem")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (NhapDiem x : arrNhapdiem) {
			String[] row = { x.getMaLop(), x.getMaSV(), x.getMaMH(), x.getDiem() };
			dm_nhapdiem.addRow(row);
		}
		table_nhapdiem = new JTable(dm_nhapdiem);
		table_nhapdiem.setLayout(new BorderLayout());
		//sp_nhapdiem = new JScrollPane(table_nhapdiem);
		sc_nhapdiem = new JScrollPane(table_nhapdiem, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc_nhapdiem.setPreferredSize(new Dimension(715, 380));

		JPanel muctimlopseachsv = new JPanel();
		muctimlopseachsv.setLayout(new BoxLayout(muctimlopseachsv, BoxLayout.Y_AXIS));
		JPanel flow = new JPanel();
		flow.setLayout(new FlowLayout());
		comBoboxlop = new JComboBox<>();
		JLabel xemlop = new JLabel("XEM LỚP");
		flow.add(xemlop);
		flow.add(comBoboxlop);
		muctimlopseachsv.add(flow);
		muctimlopseachsv.add(sc_nhapdiem);
		this.add(muctimlopseachsv);
		
		pnNhapdiem = new JPanel();
		pnNhapdiem.setLayout(new FlowLayout());
		pnNhapdiem = new JPanel();
		Border border2 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle2 = BorderFactory.createTitledBorder(border2);
		pnNhapdiem.setBorder(borderTitle2);
		pnNhapdiem.setLayout(new FlowLayout());

		JPanel pnLeft = new JPanel();
		pnLeft.setLayout(new BoxLayout(pnLeft, BoxLayout.Y_AXIS));

		JPanel chonlop = new JPanel();
		chonlop.setLayout(new FlowLayout());
		JLabel txtlop = new JLabel("Mã lớp:  ");
		txtlop.setPreferredSize(new Dimension(70, 30));
		maLopcomnoBox.setPreferredSize(new Dimension(220, 20));
		chonlop.add(txtlop);
		chonlop.add(maLopcomnoBox);
		pnLeft.add(chonlop);

		JPanel chonmasv = new JPanel();
		chonmasv.setLayout(new FlowLayout());
		JLabel txtsv = new JLabel("Mã SV:  ");
		txtsv.setPreferredSize(new Dimension(70, 30));
		maSVcomnoBox.setPreferredSize(new Dimension(220, 20));
		chonmasv.add(txtsv);
		chonmasv.add(maSVcomnoBox);
		pnLeft.add(chonmasv);

		JPanel chonma = new JPanel();
		chonma.setLayout(new FlowLayout());
		JLabel txtma = new JLabel("Mã môn:  ");
		txtma.setPreferredSize(new Dimension(70, 30));
		maMonhoc.setPreferredSize(new Dimension(220, 20));
		chonma.add(txtma);
		chonma.add(maMonhoc);
		pnLeft.add(chonma);

		JPanel nhapdiemsv = new JPanel();
		nhapdiemsv.setLayout(new FlowLayout());
		JLabel lblHoTenSV = new JLabel("Nhập điểm:");
		lblHoTenSV.setPreferredSize(new Dimension(70, 30));
		nhapDiemsv = new JTextField(20);
		nhapdiemsv.add(lblHoTenSV);
		nhapdiemsv.add(nhapDiemsv);
		pnLeft.add(nhapdiemsv);

		pnNhapdiembutton = new JPanel();
		Border border4 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle4 = BorderFactory.createTitledBorder(border4);
		pnNhapdiembutton.setBorder(borderTitle4);
		pnNhapdiembutton.setLayout(new FlowLayout());
		JPanel chucnang = new JPanel();
		chucnang.setLayout(new BoxLayout(chucnang, BoxLayout.X_AXIS));
		pnNhapdiembutton.setPreferredSize(new Dimension(200, 100));
		pnNhapdiembutton.add(ThemDiem);
		pnNhapdiembutton.add(SuaDiem);
		pnNhapdiembutton.add(nhapSinhVien);

		pnNhapdiem.add(pnLeft);
		pnNhapdiembutton.add(chucnang);
		pnNhapdiem.add(pnNhapdiembutton);
		this.add(pnNhapdiem, BorderLayout.SOUTH);

	}

	public void selectLop() {
		Connection conn = Connect.getConnect("localhost", "admin", "admin1", "12345");
		try {
			comBoboxlop.addItem("TẤT CẢ");
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM table_lop");
			while (result.next()) {
				comBoboxlop.addItem(new String(result.getString("MaLop")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void maLopcomnoBox() {
		Connection conn = Connect.getConnect("localhost", "admin", "admin1", "12345");
		try {
			maLopcomnoBox.addItem("CHỌN LỚP");
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM table_lop");
			while (result.next()) {
				maLopcomnoBox.addItem(new String(result.getString("MaLop")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void maSVcomnoBox() {
		Connection conn = Connect.getConnect("localhost", "admin", "admin1", "12345");
		try {
			maSVcomnoBox.addItem("CHỌN MÃ SV");
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM table_sinhvien");
			while (result.next()) {
				maSVcomnoBox.addItem(new String(result.getString("MaSV")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void maMonhoc() {
		Connection conn = Connect.getConnect("localhost", "admin", "admin1", "12345");
		try {
			maMonhoc.addItem("CHỌN MÔN");
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM table_monhoc");
			while (result.next()) {
				maMonhoc.addItem(new String(result.getString("MaMH")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void addEvent() {

		table_nhapdiem.addMouseListener(eventTable_lophoc);
		ThemDiem.addActionListener(eventAdd_lop);
		SuaDiem.addActionListener(eventEDit_lop);
		comBoboxlop.addActionListener(eventchoseLop);
		nhapSinhVien.addActionListener(eventReset_SinhVien);
		maLopcomnoBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				maSVcomnoBox.removeAllItems();
				maMonhoc.removeAllItems();
				timkiemMaSV();
				timkiemMaMon();
			}

		});

	}

	ActionListener eventchoseLop = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			timkiemlop();
		}
	};

	MouseAdapter eventTable_lophoc = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int row = table_nhapdiem.getSelectedRow();
			String[] col = new String[4];
			col[0] = (String) table_nhapdiem.getValueAt(row, 0);
			col[1] = (String) table_nhapdiem.getValueAt(row, 1);
			col[2] = (String) table_nhapdiem.getValueAt(row, 2);
			col[3] = (String) table_nhapdiem.getValueAt(row, 3);
			maLopcomnoBox.setSelectedItem(col[0]);
			maSVcomnoBox.setSelectedItem(col[1]);
			maMonhoc.setSelectedItem(col[2]);
			nhapDiemsv.setText(col[3]);
			ThemDiem.setEnabled(false);

		}
	};

	ActionListener eventAdd_lop = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int kt = 0;
			String maLp = (String) maLopcomnoBox.getSelectedItem();
			String maMH = (String) maMonhoc.getSelectedItem();
			String sinhVien = (String) maSVcomnoBox.getSelectedItem();
			String diem = nhapDiemsv.getText();
			int KT = 0;
			try {
				Double.parseDouble(diem);
			} catch (NumberFormatException ex) {
				KT = 1;
			}

			try {
				for (NhapDiem x : arrNhapdiem ) {
					if (maLp.equals(x.getMaLop()) && maMH.equals(x.getMaMH())&& sinhVien.equals(x.getMaSV())) {
						kt = 1;
					}
				}
				if (kt == 1) {
					JOptionPane.showMessageDialog(null, "ĐIỂM ĐÃ TỒN TẠI RỒI!", null, JOptionPane.WARNING_MESSAGE);

				} else if (KT == 1) {
					JOptionPane.showMessageDialog(null, "Bạn nhập sai điểm sinh viên vui lòng nhập lại!!", null,
							JOptionPane.WARNING_MESSAGE);
				} else if ((Double.parseDouble(diem)) > 10 || (Double.parseDouble(diem)) < 0) {
					JOptionPane.showMessageDialog(null, "Nhập sai điểm sinh viên vui lòng nhập lại!!", null,
							JOptionPane.WARNING_MESSAGE);
				} else {	
						if (diem.equals("")) {
							JOptionPane.showMessageDialog(null, "Bạn chưa nhập thông tin");
						} else {
							arrNhapdiem.add(new NhapDiem(maLp, maMH, sinhVien, diem));
							dm_nhapdiem.addRow(new String[] { maLp, sinhVien, maMH, diem });
							Connection conn = Connect.getConnect("localhost", "admin", "admin1", "12345");
							try {
								String sql = "INSERT INTO table_diem (MaLop, MaMH,MaSV, Diem) VALUES('" + maLp + "','" + maMH
										+ "','" + sinhVien + "','" + diem + "')";
								Statement statement = conn.createStatement();
								int x = statement.executeUpdate(sql);
								if (x > 0) {
									JOptionPane.showMessageDialog(null, "Đã lưu thông tin điểm");
								}
							} catch (Exception ex) {
								ex.printStackTrace();
							}
						}
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Bạn cần nhập thông tin");
			}
			
		}
	};

	ActionListener eventEDit_lop = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			int KT = 0;

			String chonLopHocDiem = (String) maLopcomnoBox.getSelectedItem();
			String chonMonHocDiem = (String) maMonhoc.getSelectedItem();
			String chonMaSinhVienDiem = (String) maSVcomnoBox.getSelectedItem();
			String nhapDiem1 = nhapDiemsv.getText();
			
			try {
				Double.parseDouble(nhapDiem1);
			} catch (NumberFormatException ex) {
				KT = 1;
			}
			
			if (nhapDiem1.isEmpty()) {
				JOptionPane.showMessageDialog(null, "HÃY NHẬP ĐIỂM", null, JOptionPane.WARNING_MESSAGE);

			} else if (KT == 1) {
					JOptionPane.showMessageDialog(null, "Bạn nhập sai điểm sinh viên vui lòng nhập lại!!", null,
							JOptionPane.WARNING_MESSAGE);
				} else if ((Double.parseDouble(nhapDiem1)) > 10 || (Double.parseDouble(nhapDiem1)) < 0) {
					JOptionPane.showMessageDialog(null, "Nhập sai điểm sinh viên vui lòng nhập lại!!", null,
							JOptionPane.WARNING_MESSAGE);
				} else {					
						Connection conn = Connect.getConnect("localhost", "admin", "admin1", "12345");
						try {
							for (NhapDiem x : arrNhapdiem) {
								if (chonLopHocDiem.equals(x.getMaLop()) && chonMonHocDiem.equals(x.getMaMH())
										&& chonMaSinhVienDiem.equals(x.getMaSV())) {
									x.setDiem(nhapDiem1);
									break;
								}
							}
							String sql = "UPDATE table_diem SET Diem ='" + nhapDiem1
									+ "' WHERE MaMH ='" + chonMonHocDiem + "'AND MaLop ='" + chonLopHocDiem
									+ "' AND MaSV ='" + chonMaSinhVienDiem + "'";
							Statement statement = conn.createStatement();
							int x = statement.executeUpdate(sql);
							if (x >= 0) {
								JOptionPane.showMessageDialog(null, "SỮA THÀNH CÔNG");
								nhapDiemsv.setText("");

							}
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "BẠN CẦN NHẬP THÔNG TIN SINH VIÊN");
					}
			}

			dm_nhapdiem.setRowCount(0);
			for (NhapDiem x : arrNhapdiem) {
				String[] row = { x.getMaLop(), x.getMaSV(), x.getMaMH(), x.getDiem() };
				dm_nhapdiem.addRow(row);

			}

		}

	};
	ActionListener eventReset_SinhVien = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			ThemDiem.setEnabled(true);
			maLopcomnoBox.setSelectedItem("");
			maSVcomnoBox.setSelectedItem("");
			maMonhoc.setSelectedItem("");
			nhapDiemsv.setText("");
			
			
		}
	};

}
