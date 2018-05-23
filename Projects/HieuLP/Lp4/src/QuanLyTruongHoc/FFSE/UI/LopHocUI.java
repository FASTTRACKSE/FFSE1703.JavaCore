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

public class LopHocUI extends JPanel {
	private static final long serialVersionUID = 1L;
	private JPanel  pnLophoc, pnLophocbutton;
	private DefaultTableModel dm_lophoc;
	private JTable table_lophoc;
	private JScrollPane sc_lophoc;
	private JScrollPane sp_lophoc;
	private JTextField maLop = new JTextField(),
					   namHoc = new JTextField(),
					   moTa = new JTextField();
	private ArrayList<QuanLyModelLopHoc> arrLop = new ArrayList<QuanLyModelLopHoc>();
	private JComboBox<String> maLopcomnoBox = new JComboBox<>();
	private JButton ThemLop = new JButton("Thêm");
	private JButton SuaLop = new JButton("Sửa");
	private JButton XoaLop = new JButton("Xóa");
	private JButton nhapSinhVien = new JButton("Nhập");
	public LopHocUI() {
		addControls();
		addEvent();
	}
	public void addControls() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setLayout(new BorderLayout());
		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Danh sách lớp học");
		this.setBorder(borderTitle);
		dm_lophoc = new DefaultTableModel();
		dm_lophoc.addColumn("Mã lớp");
		dm_lophoc.addColumn("Mô tả");
		dm_lophoc.addColumn("Năm học");
		Connection conn = Connect.getConnect("localhost", "admin", "admin1", "12345");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM table_lop");
			while (result.next()) {
				arrLop.add(new QuanLyModelLopHoc(result.getString("MaLop"), result.getString("MoTa"),
						result.getString("NamHoc")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (QuanLyModelLopHoc x : arrLop) {
			String[] row = { x.getMaLop(), x.getMoTa(), x.getNamHoc() };
			dm_lophoc.addRow(row);
		}
		table_lophoc = new JTable(dm_lophoc);
		table_lophoc.setLayout(new BorderLayout());
		sp_lophoc = new JScrollPane(table_lophoc);
		sc_lophoc = new JScrollPane(sp_lophoc, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc_lophoc.setPreferredSize(new Dimension(470, 180));
		this.add(sc_lophoc);

		pnLophoc = new JPanel();
//		Border nhapthongtin = BorderFactory.createLineBorder(Color.RED);
		pnLophoc.setLayout(new FlowLayout());
		pnLophoc = new JPanel();
		Border border2 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle2 = BorderFactory.createTitledBorder(border2);
		pnLophoc.setBorder(borderTitle2);
		pnLophoc.setLayout(new FlowLayout());

		JPanel pnLeft = new JPanel();
		pnLeft.setLayout(new BoxLayout(pnLeft, BoxLayout.Y_AXIS));

		JPanel nhapmaLop = new JPanel();
		nhapmaLop.setLayout(new FlowLayout());
		JLabel lblNhapmaLop = new JLabel("Mã lớp:");
		lblNhapmaLop.setPreferredSize(new Dimension(70, 30));
		maLop = new JTextField(20);
		nhapmaLop.add(lblNhapmaLop);
		nhapmaLop.add(maLop);
		pnLeft.add(nhapmaLop);
		;

		JPanel nhapNamhoc = new JPanel();
		nhapNamhoc.setLayout(new FlowLayout());
		JLabel lblNhapNamhoc = new JLabel("Năm học:");
		lblNhapNamhoc.setPreferredSize(new Dimension(70, 30));
		namHoc = new JTextField(20);
		nhapNamhoc.add(lblNhapNamhoc);
		nhapNamhoc.add(namHoc);
		pnLeft.add(nhapNamhoc);

		JPanel nhapMota = new JPanel();
		nhapMota.setLayout(new FlowLayout());
		JLabel lblNhapMota = new JLabel("Mô tả:");
		lblNhapMota.setPreferredSize(new Dimension(70, 30));
		moTa = new JTextField(20);
		nhapMota.add(lblNhapMota);
		nhapMota.add(moTa);
		pnLeft.add(nhapMota);

		pnLophocbutton = new JPanel();
		Border border4 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle4 = BorderFactory.createTitledBorder(border4);
		pnLophocbutton.setBorder(borderTitle4);
		pnLophocbutton.setLayout(new FlowLayout());
		JPanel chucnang = new JPanel();
		chucnang.setLayout(new BoxLayout(chucnang, BoxLayout.Y_AXIS));
		pnLophocbutton.setPreferredSize(new Dimension(200, 100));
		pnLophocbutton.add(ThemLop);
		pnLophocbutton.add(SuaLop);
		pnLophocbutton.add(XoaLop);
		pnLophocbutton.add(nhapSinhVien);

		pnLophoc.add(pnLeft);
		pnLophocbutton.add(chucnang);
		pnLophoc.add(pnLophocbutton);
		this.add(pnLophoc, BorderLayout.SOUTH);

	}

	public void maLopcomnoBox() {
		Connection conn = Connect.getConnect("localhost", "admin", "admin1", "12345");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM table_lop");
			while (result.next()) {
				maLopcomnoBox.addItem(new String(result.getString("MaLop")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void addEvent() {

		table_lophoc.addMouseListener(eventTable_lophoc);
		ThemLop.addActionListener(eventAdd_lop);
		XoaLop.addActionListener(eventDel_lop);
		SuaLop.addActionListener(eventEdit_lop);
		nhapSinhVien.addActionListener(eventReset_SinhVien);


	}

	MouseAdapter eventTable_lophoc = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int row = table_lophoc.getSelectedRow();
			String[] col = new String[3];
			col[0] = (String) table_lophoc.getValueAt(row, 0);
			col[1] = (String) table_lophoc.getValueAt(row, 1);
			col[2] = (String) table_lophoc.getValueAt(row, 2);
			maLop.setText(col[0]);
			maLop.setEditable(false);
			ThemLop.setEnabled(false);
			moTa.setText(col[1]);
			namHoc.setText(col[2]);
		}
	};

	ActionListener eventAdd_lop = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			int kt = 0;
			int KT2 = 0;
			String lop = maLop.getText();
			String mota = moTa.getText();
			String nam = namHoc.getText();
			
			try {
				Integer.parseInt(nam);
			} catch (NumberFormatException ex) {
				KT2 = 1;

			}
			
			for (QuanLyModelLopHoc x : arrLop) {
				if (maLop.getText().equals(x.getMaLop())) {
					kt = 2;
					break;
				}
			}
			Connection conn = Connect.getConnect("localhost", "admin", "admin1", "12345");
			try {

				if (lop.isEmpty() || mota.isEmpty()) {
					JOptionPane.showMessageDialog(null, "XIN HÃY NHẬP ĐẦY ĐỦ THÔNG TIN!", null,
							JOptionPane.WARNING_MESSAGE);
				} else if (nam == "TẤT CẢ") {
					JOptionPane.showMessageDialog(null, "HÃY CHỌN NĂM", null, JOptionPane.WARNING_MESSAGE);

				} else if (kt == 2) {
					JOptionPane.showMessageDialog(null, "ĐÃ TỒN TẠI", null, JOptionPane.WARNING_MESSAGE);

				} 
				else if (KT2 > 0) {
					JOptionPane.showMessageDialog(null, "NĂM CHỈ BAO GỒM SỐ", null, JOptionPane.WARNING_MESSAGE);
				}else {

					arrLop.add(new QuanLyModelLopHoc(lop, mota, nam));
					dm_lophoc.addRow(new String[] { lop, mota, nam });
					try {
						String sql = "INSERT INTO table_lop(maLop,moTa,namHoc) VALUES (" + "'" + lop + "','" + mota + "','"
								+ nam + "')";
						Statement statement = conn.createStatement();
						int x = statement.executeUpdate(sql);
						if (x > 0) {
							JOptionPane.showMessageDialog(null, "LƯU THÀNH CÔNG");

						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}

				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "XIN HÃY NHẬP THÔNG TIN");
			}
			dm_lophoc.setRowCount(0);
			for (QuanLyModelLopHoc x : arrLop) {
				String[] row = { x.getMaLop(), x.getMoTa(), x.getNamHoc() };
				dm_lophoc.addRow(row);
			}
		}
	};

	ActionListener eventDel_lop = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String lop = maLop.getText();
			String mota = moTa.getText();
			String nam = namHoc.getText();
			if (lop.isEmpty() || mota.isEmpty() || nam.isEmpty() 
					) {
				JOptionPane.showMessageDialog(null, "XIN HÃY NHẬP ĐẦY ĐỦ THÔNG TIN!", null,
						JOptionPane.WARNING_MESSAGE);

			}
			else {
			for (QuanLyModelLopHoc x : arrLop) {
				if (maLop.getText().equals(x.getMaLop())) {
					arrLop.remove(x);
					break;
				}
			}
			
			Connection conn = Connect.getConnect("localhost", "admin", "admin1", "12345");
			try {
				String sql = "DELETE FROM table_lop WHERE maLop = '" + maLop.getText() + "'";
				Statement statement = conn.createStatement();
				int x = statement.executeUpdate(sql);
				if (x >= 0) {
					JOptionPane.showMessageDialog(null, "Đã xóa");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			dm_lophoc.setRowCount(0);
			for (QuanLyModelLopHoc x : arrLop) {
				String[] row = { x.getMaLop(), x.getMoTa(), x.getNamHoc() };
				dm_lophoc.addRow(row);
			}
			
		}
			}

	};
	

	ActionListener eventEdit_lop = new ActionListener() {

		public void actionPerformed(ActionEvent arg0) {
			int KT2 = 0;

			String lop = maLop.getText();
			String mota = moTa.getText();
			String nam = namHoc.getText();
			
			try {
				Integer.parseInt(nam);
			} catch (NumberFormatException ex) {
				KT2 = 1;

			}
			for (QuanLyModelLopHoc x : arrLop) {
				if (maLop.getText().equals(x.getMaLop())) {
					x.setMoTa(moTa.getText());
					x.setNamHoc(namHoc.getText());
					break;
				}
			}
			
			if (lop.isEmpty() || mota.isEmpty() || nam.isEmpty() 
					) {
				JOptionPane.showMessageDialog(null, "XIN HÃY NHẬP ĐẦY ĐỦ THÔNG TIN!", null,
						JOptionPane.WARNING_MESSAGE);

			} else if (KT2 > 0) {
				JOptionPane.showMessageDialog(null, "NĂM CHỈ BAO GỒM SỐ", null, JOptionPane.WARNING_MESSAGE);

			 
				
				maLop.setText("");
				moTa.setText("");
				namHoc.setText("");
			

			} else {
			Connection conn = Connect.getConnect("localhost", "admin", "admin1", "12345");
			try {
				String sql = "UPDATE table_lop SET NamHoc ='" + namHoc.getText() + "',MoTa ='" + moTa.getText()
						+ "' WHERE MaLop = '" + maLop.getText() + "'";
				Statement statement = conn.createStatement();
				int x = statement.executeUpdate(sql);
				if (x >= 0) {
					JOptionPane.showMessageDialog(null, "Đã sửa thông tin môn học");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			dm_lophoc.setRowCount(0);
			for (QuanLyModelLopHoc x : arrLop) {
				String[] row = { x.getMaLop(), x.getMoTa(), x.getNamHoc() };
				dm_lophoc.addRow(row);
			}

		}
			}

	};
	ActionListener eventReset_SinhVien = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			maLop.setEditable(true);
			ThemLop.setEnabled(true);
			maLop.setText("");
			moTa.setText("");
			namHoc.setText("");
			
		}
	};
}
