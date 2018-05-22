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
import QuanLyTruongHoc.FFSE.Model.QuanLyTruonghocMonhoc;

public class MonHocUI extends JPanel {
	private static final long serialVersionUID = 1L;
	private JPanel  pnMonhoc, pnMonhocbutton; 
	private DefaultTableModel dm_monhoc;
	private JTable table_monhoc;
	private JScrollPane sp_monhoc;
	private JTextField maMonhoc = new JTextField(), Ten = new JTextField(), soTinhChi = new JTextField(),
			Thoiluonghoc = new JTextField();
	private ArrayList<QuanLyTruonghocMonhoc> arrMH = new ArrayList<QuanLyTruonghocMonhoc>();
	private Button ThemMon = new Button("Thêm");
	private Button SuaMon = new Button("Sửa");
	private Button XoaMon = new Button("Xóa");
	private JButton nhapSinhVien = new JButton("Nhập");
	public MonHocUI() {
		addControls();
		addEvent();
	}

	public void addControls() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setLayout(new BorderLayout());
		Border bordermonhoc = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitlemonhoc = BorderFactory.createTitledBorder(bordermonhoc, "Danh sách");
		this.setBorder(borderTitlemonhoc);
		dm_monhoc = new DefaultTableModel();
		dm_monhoc.addColumn("Mã môn học");
		dm_monhoc.addColumn("Tên môn học");
		dm_monhoc.addColumn("Số tính chỉ");
		dm_monhoc.addColumn("Thời lượng học");
		Connection conn = Connect.getConnect("localhost", "admin", "admin1", "12345");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM table_monhoc");
			while (result.next()) {
				arrMH.add(new QuanLyTruonghocMonhoc(result.getString("MaMH"), result.getString("Ten"),
						result.getString("SoTinhChi"), result.getString("ThoiLuongHoc")));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (QuanLyTruonghocMonhoc x : arrMH) {
			String[] row = { x.getMaMH(), x.getTen(), x.getSoTinhChi(), x.getThoiLuongHoc() };
			dm_monhoc.addRow(row);
		}

		table_monhoc = new JTable(dm_monhoc);
		table_monhoc.setLayout(new BorderLayout());
		sp_monhoc = new JScrollPane(table_monhoc);
		sp_monhoc = new JScrollPane(table_monhoc, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp_monhoc.setPreferredSize(new Dimension(470, 180));
		this.add(sp_monhoc);

		pnMonhoc = new JPanel();
		Border border2monhoc = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle2monhoc = BorderFactory.createTitledBorder(border2monhoc);
		pnMonhoc.setBorder(borderTitle2monhoc);
		pnMonhoc.setLayout(new FlowLayout());

		JPanel pnLeftmonhoc = new JPanel();
		pnLeftmonhoc.setLayout(new BoxLayout(pnLeftmonhoc, BoxLayout.Y_AXIS));

		JPanel nhapmaMonhoc = new JPanel();
		JLabel lblNhapmaMonhoc = new JLabel("Mã môn học:");
		maMonhoc = new JTextField(20);
		nhapmaMonhoc.add(lblNhapmaMonhoc);
		nhapmaMonhoc.add(maMonhoc);
		pnLeftmonhoc.add(nhapmaMonhoc);

		JPanel nhaptenMonhoc = new JPanel();
		JLabel lblNhaptenMonhoc = new JLabel("Tên môn học:");
		Ten = new JTextField(20);
		nhaptenMonhoc.add(lblNhaptenMonhoc);
		nhaptenMonhoc.add(Ten);
		pnLeftmonhoc.add(nhaptenMonhoc);

		JPanel nhapSotinhchi = new JPanel();
		JLabel lblSotinhchi = new JLabel("Số tính chỉ:");
		soTinhChi = new JTextField(20);
		nhapSotinhchi.add(lblSotinhchi);
		nhapSotinhchi.add(soTinhChi);
		pnLeftmonhoc.add(nhapSotinhchi);

		JPanel nhapThoiluonghoc = new JPanel();
		JLabel lblNhapthoiluonghoc = new JLabel("Thời lượng học:");
		Thoiluonghoc = new JTextField(20);
		nhapThoiluonghoc.add(lblNhapthoiluonghoc);
		nhapThoiluonghoc.add(Thoiluonghoc);
		pnLeftmonhoc.add(nhapThoiluonghoc);

		pnMonhocbutton = new JPanel();
		Border border4monhoc = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle4monhoc = BorderFactory.createTitledBorder(border4monhoc);
		pnMonhocbutton.setBorder(borderTitle4monhoc);
		pnMonhocbutton.setLayout(new FlowLayout());
		JPanel chucnangmonhoc = new JPanel();
		chucnangmonhoc.setLayout(new BoxLayout(chucnangmonhoc, BoxLayout.X_AXIS));
		pnMonhocbutton.setPreferredSize(new Dimension(200, 100));
		pnMonhocbutton.add(ThemMon);
		pnMonhocbutton.add(SuaMon);
		pnMonhocbutton.add(XoaMon);
		pnMonhocbutton.add(nhapSinhVien);


		pnMonhocbutton.add(chucnangmonhoc);
		pnMonhoc.add(pnLeftmonhoc);
		pnMonhoc.add(pnMonhocbutton);
		this.add(pnMonhoc, BorderLayout.SOUTH);
	}

	public void addEvent() {

		table_monhoc.addMouseListener(eventTable_Monhoc);
		ThemMon.addActionListener(eventAdd_Mon);
		XoaMon.addActionListener(eventDel_Mon);
		SuaMon.addActionListener(eventEdit_Mon);
		nhapSinhVien.addActionListener(eventReset_SinhVien);
	}

	MouseAdapter eventTable_Monhoc = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int row = table_monhoc.getSelectedRow();
			String[] col = new String[4];
			col[0] = (String) table_monhoc.getValueAt(row, 0);
			col[1] = (String) table_monhoc.getValueAt(row, 1);
			col[2] = (String) table_monhoc.getValueAt(row, 2);
			col[3] = (String) table_monhoc.getValueAt(row, 3);
			maMonhoc.setText(col[0]);
			maMonhoc.setEditable(false);
			ThemMon.setEnabled(false);
			Ten.setText(col[1]);
			soTinhChi.setText(col[2]);
			Thoiluonghoc.setText(col[3]);

		}
	};

	ActionListener eventAdd_Mon = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int kt = 0;
			String maMonHoc = maMonhoc.getText();
			String tenMonHoc = Ten.getText();
			String thoiLuongHoc = Thoiluonghoc.getText();
			String soTinChi = String.valueOf(soTinhChi.getText());
			for (QuanLyTruonghocMonhoc x : arrMH ) {
				if (maMonHoc.equals(x.getMaMH()) && tenMonHoc.equals(x.getTen())) {
					kt = 2;
					break;
				}
			}
			Connection conn = Connect.getConnect("localhost", "admin", "admin1", "12345");
			try {
				if (maMonHoc.isEmpty() || tenMonHoc.isEmpty() || soTinChi.isEmpty() || thoiLuongHoc.isEmpty()) {
					JOptionPane.showMessageDialog(null, "XIN HÃY NHẬP ĐẦY ĐỦ THÔNG TIN!", null,
							JOptionPane.WARNING_MESSAGE);
				} else if (kt == 2) {
					JOptionPane.showMessageDialog(null, "MÔN HỌC ĐÃ TỒN TẠI RỒI!", null, JOptionPane.WARNING_MESSAGE);

				} else {

					arrMH.add(new QuanLyTruonghocMonhoc(maMonHoc, tenMonHoc, soTinChi, thoiLuongHoc));
					dm_monhoc.addRow(new String[] { maMonHoc, tenMonHoc, soTinChi, thoiLuongHoc });
					try {
						String sql = "INSERT INTO table_monhoc( MaMH, Ten , SoTinhChi, ThoiLuongHoc) VALUES ('"
								+ maMonHoc + "','" + tenMonHoc + "','" + soTinChi + "','" + thoiLuongHoc + "')";
						Statement statement = conn.createStatement();
						int x = statement.executeUpdate(sql);
						if (x > 0) {
							JOptionPane.showMessageDialog(null, "ĐÃ LƯU THÔNG TIN MÔN HỌC");
						
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					maMonhoc.setText("");
					Ten.setText("");
					soTinhChi.setText("");
					Thoiluonghoc.setText("");

				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "HÃY NHẬP SỐ TÍN CHỈ KIỂU SỐ");
			}

			dm_monhoc.setRowCount(0);
			for (QuanLyTruonghocMonhoc x : arrMH) {
				
				String[] row = { x.getMaMH(), x.getTen(), x.getSoTinhChi(), x.getThoiLuongHoc() };
				dm_monhoc.addRow(row);
			}

		}
	};


	ActionListener eventDel_Mon = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String maMonHoc = maMonhoc.getText();
			String tenMonHoc = Ten.getText();
			String thoiLuongHoc = Thoiluonghoc.getText();
			String soTinChi = String.valueOf(soTinhChi.getText());
			if (maMonHoc.isEmpty() || tenMonHoc.isEmpty() || thoiLuongHoc.isEmpty()  || soTinChi.isEmpty() 
					) {
				JOptionPane.showMessageDialog(null, "XIN HÃY NHẬP ĐẦY ĐỦ THÔNG TIN!", null,
						JOptionPane.WARNING_MESSAGE);

			}
			else {
			for (QuanLyTruonghocMonhoc x : arrMH) {
				if ((maMonhoc.getText()).equals(x.getMaMH())) {
					arrMH.remove(x);
					break;
				}
			}
			Connection conn = Connect.getConnect("localhost", "admin", "admin1", "12345");
			try {
				String sql = "DELETE FROM table_monhoc WHERE MaMH = '" + maMonhoc.getText() + "'";
				Statement statement = conn.createStatement();

				int x = statement.executeUpdate(sql);
				if (x >= 0) {
					JOptionPane.showMessageDialog(null, "Đã xóa thông tin sinh viên");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			dm_monhoc.setRowCount(0);
			for (QuanLyTruonghocMonhoc x : arrMH) {
				String[] row = { x.getMaMH(), x.getTen(), x.getSoTinhChi(), x.getThoiLuongHoc() };
				dm_monhoc.addRow(row);
			}
			}

		}

	};

	ActionListener eventEdit_Mon = new ActionListener() {

		public void actionPerformed(ActionEvent arg0) {
			int KT2 = 0;
			String maMonHoc = maMonhoc.getText();
			String tenMonHoc = Ten.getText();
			String thoiLuongHoc = Thoiluonghoc.getText();
			String soTinChi = String.valueOf(soTinhChi.getText());
			try {
				Integer.parseInt(soTinChi);
			} catch (NumberFormatException ex) {
				KT2 = 1;

			}
			
			if (maMonHoc.isEmpty() || tenMonHoc.isEmpty() || thoiLuongHoc.isEmpty()  || soTinChi.isEmpty() 
					) {
				JOptionPane.showMessageDialog(null, "XIN HÃY NHẬP ĐẦY ĐỦ THÔNG TIN!", null,
						JOptionPane.WARNING_MESSAGE);

			} else if (KT2 > 0) {
				JOptionPane.showMessageDialog(null, "SỐ TÍN CHỈ BAO GỒM SỐ", null, JOptionPane.WARNING_MESSAGE);

			 
				
				maMonhoc.setText("");
				Ten.setText("");
				Thoiluonghoc.setText("");
				soTinhChi.setText("");
			

			} else {
			for (QuanLyTruonghocMonhoc x : arrMH) {
				if (maMonhoc.getText().equals(x.getMaMH())) {
					x.setTen(Ten.getText());
					x.setSoTinhChi(soTinhChi.getText());
					x.setThoiLuongHoc(Thoiluonghoc.getText());
					break;
				}
			}
			Connection conn = Connect.getConnect("localhost", "admin", "admin1", "12345");
			try {
				String sql = "UPDATE table_monhoc SET Ten ='" + Ten.getText() + "',SoTinhChi ='" + soTinhChi.getText()
						+ "',ThoiLuongHoc ='" + Thoiluonghoc.getText() + "' WHERE MaMH = '" + maMonhoc.getText() + "'";
				Statement statement = conn.createStatement();
				int x = statement.executeUpdate(sql);
				if (x >= 0) {
					JOptionPane.showMessageDialog(null, "Đã sửa thông tin sinh viên");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			dm_monhoc.setRowCount(0);
			for (QuanLyTruonghocMonhoc x : arrMH) {
				String[] row = { x.getMaMH(), x.getTen(), x.getSoTinhChi(), x.getThoiLuongHoc() };
				dm_monhoc.addRow(row);
			}
			}
		}
	};
	ActionListener eventReset_SinhVien = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			maMonhoc.setEditable(true);
			ThemMon.setEnabled(true);
			maMonhoc.setText("");
			Ten.setText("");
			soTinhChi.setText("");
			Thoiluonghoc.setText("");
			
		}
	};

}
