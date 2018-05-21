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

public class MonHocLopUI extends JPanel {

	private static final long serialVersionUID = 1L;

	private ArrayList<MonHocLop> arrLopMH = new ArrayList<MonHocLop>();

	private JButton themMonHocLop = new JButton("Thêm");
	private JButton xoaMonHocLop = new JButton("Xóa");

	private JComboBox<String> selectMonHoc = new JComboBox<>();
	private JComboBox<String> maMHLop = new JComboBox<>();

	private DefaultTableModel dm_MonHoc_lop;
	private JTable table_MonHoc_lop;
	private JScrollPane sp_MonHoc_lop;

	public MonHocLopUI() {
		lop(selectMonHoc);
		monhoc();
		addControls();
		addEvent();
	}

	public void addControls() {
		// Quản lý môn học theo lớp

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel pnMH_lopMonHoc = new JPanel();
		pnMH_lopMonHoc.setLayout(new FlowLayout());

		JPanel nhapMaLop = new JPanel();
		nhapMaLop.setLayout(new FlowLayout());
		JLabel lblchonLop = new JLabel("Mã lớp học:");
		nhapMaLop.add(lblchonLop);
		nhapMaLop.add(selectMonHoc);
		pnMH_lopMonHoc.add(nhapMaLop);

		JPanel nhapMaMHLop = new JPanel();
		nhapMaMHLop.setLayout(new FlowLayout());
		JLabel lblNhapMaMHLop = new JLabel("Mã môn học:");
		nhapMaMHLop.add(lblNhapMaMHLop);
		nhapMaMHLop.add(maMHLop);
		pnMH_lopMonHoc.add(nhapMaMHLop);

		pnMH_lopMonHoc.add(themMonHocLop);
		pnMH_lopMonHoc.add(xoaMonHocLop);

		this.add(pnMH_lopMonHoc);

		JPanel Table_lopMonHoc = new JPanel();
		Table_lopMonHoc.setLayout(new BorderLayout());
		Border border_lopMonHoc = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle_lopMonHoc = BorderFactory.createTitledBorder(border_lopMonHoc, "Danh sách môn học");
		Table_lopMonHoc.setBorder(borderTitle_lopMonHoc);

		dm_MonHoc_lop = new DefaultTableModel();

		dm_MonHoc_lop.addColumn("Mã lớp học");
		dm_MonHoc_lop.addColumn("Mã môn học");
		dm_MonHoc_lop.addColumn("Tên môn học");
		Connection conn = Connect.getConnect("localhost", "minhad", "minhad", "minh");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM monhoc");
			while (result.next()) {
				arrLopMH.add(new MonHocLop(result.getString("MaMH"), result.getString("Ten"),
						result.getString("TenLop"), result.getString("SoTC"), result.getString("thoigian")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (MonHocLop x : arrLopMH) {
			if (((String) selectMonHoc.getSelectedItem()).equals(x.getTenLop())) {
				String[] row = { x.getTenLop(), x.getMaMH(), x.getTenMH(), x.getSoTC(), x.getThoigian() };
				dm_MonHoc_lop.addRow(row);
			}
		}

		table_MonHoc_lop = new JTable(dm_MonHoc_lop);
		table_MonHoc_lop.setLayout(new BorderLayout());
		sp_MonHoc_lop = new JScrollPane(table_MonHoc_lop);
		JScrollPane sc_lopMonHoc = new JScrollPane(sp_MonHoc_lop, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc_lopMonHoc.setPreferredSize(new Dimension(470, 180));
		Table_lopMonHoc.add(sc_lopMonHoc, BorderLayout.CENTER);
		this.add(Table_lopMonHoc);
	}

	// Lấy giá trị tĩnh cho các JComboBox

	public void lop(JComboBox<String> x) {
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

	public void monhoc() {
		Connection conn = Connect.getConnect("localhost", "minhad", "minhad", "minh");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM table_monhoc");
			while (result.next()) {
				maMHLop.addItem(new String(result.getString("MaMH")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// lấy xong giá trị của JComboBox

	public void addEvent() {

		// CRUD môn học cho từng lớp học
		table_MonHoc_lop.addMouseListener(eventTable_MonHocLop);
		themMonHocLop.addActionListener(eventAdd_MonHocLop);
		xoaMonHocLop.addActionListener(eventDel_MonHocLop);
		selectMonHoc.addActionListener(eventChooseLop);
	}

	// CRUD môn học cho lớp học

	MouseAdapter eventTable_MonHocLop = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int row = table_MonHoc_lop.getSelectedRow();
			String[] col = new String[3];
			col[0] = (String) table_MonHoc_lop.getValueAt(row, 0);
			col[1] = (String) table_MonHoc_lop.getValueAt(row, 1);
			col[2] = (String) table_MonHoc_lop.getValueAt(row, 2);
			selectMonHoc.setSelectedItem(col[0]);
			maMHLop.setSelectedItem(col[1]);

		}
	};

	ActionListener eventAdd_MonHocLop = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			int i = 0;
			String chonLop = (String) selectMonHoc.getSelectedItem();
			String chonMH = (String) maMHLop.getSelectedItem();
			try {
				Connection conn = Connect.getConnect("localhost", "minhad", "minhad", "minh");
				for (MonHocLop y : arrLopMH) {
					if (chonLop.equals(y.getTenLop()) && chonMH.equals(y.getMaMH())) {
						i = 1;
					}
				}
				if (i > 0) {
					JOptionPane.showMessageDialog(null, "Môn học đã tồn tại!", null, JOptionPane.WARNING_MESSAGE);
				} else {
					Statement statement = conn.createStatement();
					ResultSet result = statement
							.executeQuery("SELECT * FROM table_monhoc WHERE maMH ='" + chonMH + "'");
					result.next();
					arrLopMH.add(new MonHocLop(result.getString("maMH"), result.getString("tenMH"), chonLop,
							result.getString("STC"), result.getString("ThoiGian")));

					String[] row = { chonLop, result.getString("maMH"), result.getString("tenMH") };
					dm_MonHoc_lop.addRow(row);

					String sql = "INSERT INTO monhoc( MaMH, Ten, TenLop, SoTC, thoigian) VALUES ('"
							+ result.getString("maMH") + "','" + result.getString("tenMH") + "','" + chonLop + "','"
							+ result.getString("STC") + "','" + result.getString("ThoiGian") + "')";
					int x = statement.executeUpdate(sql);
					if (x > 0) {
						JOptionPane.showMessageDialog(null, "Đã lưu thông tin");
					}
				}

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Bạn cần nhập thông tin");
			}
			dm_MonHoc_lop.setRowCount(0);
			for (MonHocLop x : arrLopMH) {
				if (chonLop.equals(x.getTenLop())) {
					String[] row = { x.getTenLop(), x.getMaMH(), x.getTenMH(), x.getSoTC(), x.getThoigian() };
					dm_MonHoc_lop.addRow(row);
				}
			}
		}
	};

	ActionListener eventDel_MonHocLop = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String chonLop = (String) selectMonHoc.getSelectedItem();
			String chonMH = (String) maMHLop.getSelectedItem();
			for (MonHocLop x : arrLopMH) {
				if (chonMH.equals(x.getMaMH()) && chonLop.equals(x.getTenLop())) {
					arrLopMH.remove(x);
					break;
				}
			}
			Connection conn = Connect.getConnect("localhost", "minhad", "minhad", "minh");
			try {
				String sql = "DELETE FROM monhoc WHERE MaMH = '" + chonMH + "' AND TenLop ='" + chonLop + "'";
				Statement statement = conn.createStatement();
				int x = statement.executeUpdate(sql);
				if (x >= 0) {
					JOptionPane.showMessageDialog(null, "Đã xóa thông tin sinh viên");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			dm_MonHoc_lop.setRowCount(0);
			for (MonHocLop x : arrLopMH) {
				if (chonLop.equals(x.getTenLop())) {
					String[] row = { x.getTenLop(), x.getMaMH(), x.getTenMH(), x.getSoTC(), x.getThoigian() };
					dm_MonHoc_lop.addRow(row);
				}
			}
		}

	};
	// kết thúc CRUD chọn môn học cho lớp

	// Chọn lớp học cho button
	ActionListener eventChooseLop = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String chonLop = (String) selectMonHoc.getSelectedItem();
			dm_MonHoc_lop.setRowCount(0);
			for (MonHocLop x : arrLopMH) {
				if (chonLop.equals(x.getTenLop())) {
					String[] row = { x.getTenLop(), x.getMaMH(), x.getTenMH(), x.getSoTC(), x.getThoigian() };
					dm_MonHoc_lop.addRow(row);
				}
			}
		}
	};
}
