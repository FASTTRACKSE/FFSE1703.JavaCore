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

public class MonCuaLopUI extends JPanel {
	private static final long serialVersionUID = 1L;
	private JPanel pnMoncholop, pnMoncholopbutton;
	private DefaultTableModel dm_moncholop;
	private JTable table_moncholop;
	private JScrollPane sc_moncholop;
	private JScrollPane sp_moncholop;
	private JTextField maLop = new JTextField(), maMH = new JTextField(), ten = new JTextField();
	private ArrayList<MonCuaLop> arrMoncholop = new ArrayList<MonCuaLop>();
	private JComboBox<String> maLopcomnoBox = new JComboBox<>();
	private JComboBox<String> maMonhoc = new JComboBox<>();
	private JComboBox<String> comBoboxlop = new JComboBox<>();
	private JButton ThemMoncholop = new JButton("Thêm");
	private JButton XoaMoncholop = new JButton("Xóa");
	private JButton nhapSinhVien = new JButton("Nhập");

	public MonCuaLopUI() {
		maLopcomnoBox();
		maMonhoc();
		addControls();
		addEvent();
		selectLop();
	}

	public void timkiemlop() {
		String cholop = (String) comBoboxlop.getSelectedItem();
		dm_moncholop.setRowCount(0);
		if (cholop.equals("TẤT CẢ")) {
			for (MonCuaLop x : arrMoncholop) {
				String[] row = { x.getMaLop(), x.getMaMH(), x.getTen() };
				dm_moncholop.addRow(row);
			}

		} else {
			for (MonCuaLop x : arrMoncholop) {
				if (cholop.equals(x.getMaLop())) {
					String[] row = { x.getMaLop(), x.getMaMH(), x.getTen() };
					dm_moncholop.addRow(row);

				}

			}
		}
	}

	public void addControls() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setLayout(new BorderLayout());
		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Quản lý môn học cho lớp");
		this.setBorder(borderTitle);
		dm_moncholop = new DefaultTableModel();
		dm_moncholop.addColumn("Mã lớp học");
		dm_moncholop.addColumn("Mã môn học");
		dm_moncholop.addColumn("Tên môn học");
		Connection conn = Connect.getConnect("localhost", "admin", "admin1", "12345");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM table_monhoccholop");
			while (result.next()) {
				arrMoncholop.add(
						new MonCuaLop(result.getString("MaLop"), result.getString("MaMH"), result.getString("Ten")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (MonCuaLop x : arrMoncholop) {
			String[] row = { x.getMaLop(), x.getMaMH(), x.getTen() };
			dm_moncholop.addRow(row);
		}
		table_moncholop = new JTable(dm_moncholop);
		table_moncholop.setLayout(new BorderLayout());
		sp_moncholop = new JScrollPane(table_moncholop);
		sc_moncholop = new JScrollPane(sp_moncholop, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc_moncholop.setPreferredSize(new Dimension(715, 415));

		
		JPanel muctimlopseachsv = new JPanel();
		muctimlopseachsv.setLayout(new BoxLayout(muctimlopseachsv, BoxLayout.Y_AXIS));
		JPanel flow = new JPanel();
		flow.setLayout(new FlowLayout());
		comBoboxlop = new JComboBox<>();
		JLabel xemlop = new JLabel("XEM LỚP");
		flow.add(xemlop);
		flow.add(comBoboxlop);
		muctimlopseachsv.add(flow);
		muctimlopseachsv.add(sc_moncholop);
		this.add(muctimlopseachsv);

		
		pnMoncholop = new JPanel();
		pnMoncholop.setLayout(new FlowLayout());
		pnMoncholop = new JPanel();
		Border border2 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle2 = BorderFactory.createTitledBorder(border2);
		pnMoncholop.setBorder(borderTitle2);
		pnMoncholop.setLayout(new FlowLayout());

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

		JPanel chonma = new JPanel();
		chonma.setLayout(new FlowLayout());
		JLabel txtma = new JLabel("Mã môn:  ");
		txtma.setPreferredSize(new Dimension(70, 30));
		maMonhoc.setPreferredSize(new Dimension(220, 20));
		chonma.add(txtma);
		chonma.add(maMonhoc);
		pnLeft.add(chonma);

		pnMoncholopbutton = new JPanel();
		Border border4 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle4 = BorderFactory.createTitledBorder(border4);
		pnMoncholopbutton.setBorder(borderTitle4);
		pnMoncholopbutton.setLayout(new FlowLayout());
		JPanel chucnang = new JPanel();
		chucnang.setLayout(new BoxLayout(chucnang, BoxLayout.X_AXIS));
		pnMoncholopbutton.setPreferredSize(new Dimension(200, 100));
		pnMoncholopbutton.add(ThemMoncholop);
		pnMoncholopbutton.add(XoaMoncholop);
		pnMoncholopbutton.add(nhapSinhVien);

		pnMoncholop.add(pnLeft);
		pnMoncholopbutton.add(chucnang);
		pnMoncholop.add(pnMoncholopbutton);
		this.add(pnMoncholop, BorderLayout.SOUTH);

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

		table_moncholop.addMouseListener(eventTable_lophoc);
		ThemMoncholop.addActionListener(eventAdd_lop);
		XoaMoncholop.addActionListener(eventDel_lop);
		comBoboxlop.addActionListener(eventchoseLop);
		nhapSinhVien.addActionListener(eventReset_SinhVien);

	}

	ActionListener eventchoseLop = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			timkiemlop();
		}
	};

	MouseAdapter eventTable_lophoc = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int row = table_moncholop.getSelectedRow();
			String[] col = new String[2];
			col[0] = (String) table_moncholop.getValueAt(row, 0);
			col[1] = (String) table_moncholop.getValueAt(row, 1);
			maLopcomnoBox.setSelectedItem(col[0]);
			maMonhoc.setSelectedItem(col[1]);
			ThemMoncholop.setEnabled(false);
		}
	};

	ActionListener eventAdd_lop = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int kt = 0;
			String lop_SinhVien = (String) maLopcomnoBox.getSelectedItem();
			String maMhoc_SinhVien = (String) maMonhoc.getSelectedItem();
			for (MonCuaLop x : arrMoncholop ) {
				if (lop_SinhVien.equals(x.getMaLop()) && maMhoc_SinhVien.equals(x.getMaMH())) {
					kt = 2;
					break;
				}
			}

			try {
				if (kt == 2) {
					JOptionPane.showMessageDialog(null, "MÔN HỌC ĐÃ TỒN TẠI RỒI!", null, JOptionPane.WARNING_MESSAGE);

				} else {	
				
				Connection conn = Connect.getConnect("localhost", "admin", "admin1", "12345");
				Statement statement = conn.createStatement();
				ResultSet result = statement.executeQuery(
						"SELECT table_lop.MaLop,table_monhoc.MaMH,table_monhoc.Ten FROM table_lop INNER JOIN table_monhoc WHERE MaLop= '"
								+ lop_SinhVien + "' AND table_monhoc.MaMH='" + maMhoc_SinhVien + "'");

			
				result.next();
				arrMoncholop.add(
						new MonCuaLop(result.getString("MaLop"), result.getString("MaMH"), result.getString("Ten")));
				dm_moncholop.addRow(
						new String[] { result.getString("MaLop"), result.getString("MaMH"), result.getString("Ten") });
				String sql = "INSERT INTO table_monhoccholop (MaLop, MaMH,Ten) VALUES (" + "'"
						+ result.getString("MaLop") + "','" + result.getString("MaMH") + "','" + result.getString("Ten")
						+ "')";
				statement.executeUpdate(sql);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			dm_moncholop.setRowCount(0);
			for (MonCuaLop x : arrMoncholop) {
				String[] row = { x.getMaLop(), x.getMaMH(), x.getTen() };
				dm_moncholop.addRow(row);
			}

			maLop.setText("");
			maMH.setText("");
			ten.setText("");

		}
	};

	ActionListener eventDel_lop = new ActionListener() {
		

		@Override
		public void actionPerformed(ActionEvent arg0) {

			Connection conn = Connect.getConnect("localhost", "admin", "admin1", "12345");
			try {
				for (MonCuaLop x : arrMoncholop) {
					if (((String) maLopcomnoBox.getSelectedItem()).equals(x.getMaLop())) {
						if (((String) maMonhoc.getSelectedItem()).equals(x.getMaMH())) {
							arrMoncholop.remove(x);
						}
						break;
					}
				}
				String sql = "DELETE FROM table_monhoccholop WHERE MaLop = '" + (String) maLopcomnoBox.getSelectedItem()
						+ "' AND MaMH ='" + (String) maMonhoc.getSelectedItem() + "'";
				Statement statement = conn.createStatement();
				int x = statement.executeUpdate(sql);
				if (x >= 0) {
					JOptionPane.showMessageDialog(null, "Xóa thông tin môn học");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			dm_moncholop.setRowCount(0);
			for (MonCuaLop x : arrMoncholop) {
				String[] row = { x.getMaLop(), x.getMaMH(), x.getTen() };
				dm_moncholop.addRow(row);

			}
		}

	};
	ActionListener eventReset_SinhVien = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			ThemMoncholop.setEnabled(true);
			maLopcomnoBox.setSelectedItem("");
			maMonhoc.setSelectedItem("");
			
			
		}
	};

}
