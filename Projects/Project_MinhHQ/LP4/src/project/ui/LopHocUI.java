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

public class LopHocUI extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextField MaLH = new JTextField();
	private JTextField TenLH = new JTextField();
	private JTextField NamHoc = new JTextField();

	private ArrayList<LopHoc> arrLH = new ArrayList<LopHoc>();

	private JButton themLopHoc = new JButton("Thêm");
	private JButton xoaLopHoc = new JButton("Xóa");
	private JButton suaLopHoc = new JButton("Sửa");
	private JButton nhapLopHoc = new JButton("Nhập");

	private JComboBox<String> namhoc = new JComboBox<>();

	private DefaultTableModel dm_LopHoc;
	private JTable table_LopHoc;
	private JScrollPane sp_LopHoc;

	public LopHocUI() {
		addControls();
		addEvent();
	}

	public void addControls() {

		// Quản lý lớp học

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel pnButton_LopHoc = new JPanel();
		pnButton_LopHoc.setLayout(new FlowLayout());
		pnButton_LopHoc.add(themLopHoc);
		pnButton_LopHoc.add(suaLopHoc);
		pnButton_LopHoc.add(xoaLopHoc);
		pnButton_LopHoc.add(nhapLopHoc);
		this.add(pnButton_LopHoc);

		JPanel pnLopHoc = new JPanel();
		pnLopHoc.setLayout(new BoxLayout(pnLopHoc, BoxLayout.Y_AXIS));

		JPanel nhapMaLH = new JPanel();
		JLabel lblNhapmaLH = new JLabel("Mã lớp học: ");
		MaLH = new JTextField(19);
		nhapMaLH.add(lblNhapmaLH);
		nhapMaLH.add(MaLH);
		pnLopHoc.add(nhapMaLH);

		JPanel nhapTenLH = new JPanel();
		JLabel lblNhapTenLH = new JLabel("Tên lớp học:");
		TenLH = new JTextField(19);
		nhapTenLH.add(lblNhapTenLH);
		nhapTenLH.add(TenLH);
		pnLopHoc.add(nhapTenLH);

		JPanel nhapNamHoc = new JPanel();
		JLabel txtnhapNamHoc = new JLabel("Năm học:      ");
		NamHoc = new JTextField(19);
		nhapNamHoc.add(txtnhapNamHoc);
		nhapNamHoc.add(NamHoc);
		pnLopHoc.add(nhapNamHoc);

		this.add(pnLopHoc);

		JPanel chonNamHoc = new JPanel();
		chonNamHoc.setLayout(new FlowLayout());
		JLabel txtNamHoc = new JLabel("Năm học: ");
		namhoc = new JComboBox<>();
		namhoc.addItem("Chọn năm học");
		Connection conn = Connect.getConnect("localhost", "minhad", "minhad", "minh");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT DISTINCT NamHoc FROM lophoc");
			while (result.next()) {
				namhoc.addItem(result.getString("NamHoc"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		chonNamHoc.add(txtNamHoc);
		chonNamHoc.add(namhoc);

		this.add(chonNamHoc);

		JPanel Table_LopHoc = new JPanel();
		Table_LopHoc.setLayout(new BorderLayout());
		Border border_LopHoc = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle_LopHoc = BorderFactory.createTitledBorder(border_LopHoc, "Danh sách lớp học");
		Table_LopHoc.setBorder(borderTitle_LopHoc);

		dm_LopHoc = new DefaultTableModel();

		dm_LopHoc.addColumn("Mã lớp học");
		dm_LopHoc.addColumn("Tên lớp học");
		dm_LopHoc.addColumn("Năm học");

		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM lophoc");
			while (result.next()) {
				arrLH.add(
						new LopHoc(result.getString("MaLop"), result.getString("TenLop"), result.getString("NamHoc")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (LopHoc x : arrLH) {
			String[] row = { x.getMaLop(), x.getTenLop(), x.getNamHoc() };
			dm_LopHoc.addRow(row);
		}

		table_LopHoc = new JTable(dm_LopHoc);
		table_LopHoc.setLayout(new BorderLayout());
		sp_LopHoc = new JScrollPane(table_LopHoc);
		JScrollPane sc_LopHoc = new JScrollPane(sp_LopHoc, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc_LopHoc.setPreferredSize(new Dimension(470, 180));
		Table_LopHoc.add(sc_LopHoc, BorderLayout.CENTER);
		this.add(Table_LopHoc);
	}

	public void addEvent() {

		// CRUD lớp học
		table_LopHoc.addMouseListener(eventTable_LopHoc);
		themLopHoc.addActionListener(eventAdd_LopHoc);
		xoaLopHoc.addActionListener(eventDel_LopHoc);
		suaLopHoc.addActionListener(eventEdit_LopHoc);
		nhapLopHoc.addActionListener(eventReset_LopHoc);
		namhoc.addActionListener(eventChooseNH);

	}

	// Chọn năm học
	ActionListener eventChooseNH = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String chonNH = (String) namhoc.getSelectedItem();

			dm_LopHoc.setRowCount(0);

			for (LopHoc x : arrLH) {
				if (chonNH.equals("Chọn năm học")) {
					String[] row = { x.getMaLop(), x.getTenLop(), x.getNamHoc() };
					dm_LopHoc.addRow(row);
				} else if (chonNH.equals(x.getNamHoc())) {
					String[] row = { x.getMaLop(), x.getTenLop(), x.getNamHoc() };
					dm_LopHoc.addRow(row);
				}
			}
		}
	};

	// Kết thúc chọn năm học

	// CRUD Lớp Học

	MouseAdapter eventTable_LopHoc = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int row = table_LopHoc.getSelectedRow();
			String[] col = new String[3];
			col[0] = (String) table_LopHoc.getValueAt(row, 0);
			col[1] = (String) table_LopHoc.getValueAt(row, 1);
			col[2] = (String) table_LopHoc.getValueAt(row, 2);
			themLopHoc.setEnabled(false);
			MaLH.setEditable(false);
			MaLH.setText(col[0]);
			TenLH.setText(col[1]);
			NamHoc.setText(col[2]);
		}
	};

	ActionListener eventAdd_LopHoc = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			int i = 0;
			String ma_LopHoc = MaLH.getText();
			String ten_LopHoc = TenLH.getText();
			String nam_LopHoc = NamHoc.getText();

			for (LopHoc y : arrLH) {
				if (ma_LopHoc.equals(y.getMaLop())) {
					i = 1;
				}
			}
			if (i > 0) {
				JOptionPane.showMessageDialog(null, "Lớp Học đã tồn tại!!", null, JOptionPane.WARNING_MESSAGE);
			} else {

				try {
					Connection conn = Connect.getConnect("localhost", "minhad", "minhad", "minh");
					if (ma_LopHoc.equals("") || ten_LopHoc.equals("") || nam_LopHoc.equals("")) {
						JOptionPane.showMessageDialog(null, "Bạn chưa nhập thông tin");
					} else {

						arrLH.add(new LopHoc(ma_LopHoc, ten_LopHoc, nam_LopHoc));
						dm_LopHoc.addRow(new String[] { ma_LopHoc, ten_LopHoc, nam_LopHoc });
						try {
							String sql = "INSERT INTO lophoc(MaLop,TenLop,NamHoc) VALUES (" + "'" + ma_LopHoc + "','"
									+ ten_LopHoc + "','" + nam_LopHoc + "'" + ")";
							Statement statement = conn.createStatement();
							int x = statement.executeUpdate(sql);
							if (x > 0) {
								JOptionPane.showMessageDialog(null, "Đã lưu thông tin");
							}
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Bạn cần nhập thông tin");
				}
			}
			MaLH.setText("");
			TenLH.setText("");
			NamHoc.setText("");

		}
	};

	ActionListener eventDel_LopHoc = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String ma_LopHoc = MaLH.getText();
			String ten_LopHoc = TenLH.getText();
			String nam_LopHoc = NamHoc.getText();
			Connection conn = Connect.getConnect("localhost", "minhad", "minhad", "minh");
			if (ma_LopHoc.equals("") || ten_LopHoc.equals("") || nam_LopHoc.equals("")) {
				JOptionPane.showMessageDialog(null, "Bạn chưa có thông tin cần xóa", null, JOptionPane.WARNING_MESSAGE);
			} else {
				try {
					for (LopHoc x : arrLH) {
						if (MaLH.getText().equals(x.getMaLop())) {
							arrLH.remove(x);
							break;
						}
					}
					String sql = "DELETE FROM lophoc WHERE MaLop = '" + MaLH.getText() + "'";
					Statement statement = conn.createStatement();
					int x = statement.executeUpdate(sql);
					if (x >= 0) {
						JOptionPane.showMessageDialog(null, "Đã xóa thông tin sinh viên");
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			dm_LopHoc.setRowCount(0);
			for (LopHoc x : arrLH) {
				String[] row = { x.getMaLop(), x.getTenLop(), x.getNamHoc() };
				dm_LopHoc.addRow(row);
			}

			MaLH.setText("");
			TenLH.setText("");
			NamHoc.setText("");
		}

	};

	ActionListener eventEdit_LopHoc = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String ma_LopHoc = MaLH.getText();
			String ten_LopHoc = TenLH.getText();
			String nam_LopHoc = NamHoc.getText();
			Connection conn = Connect.getConnect("localhost", "minhad", "minhad", "minh");
			if (ma_LopHoc.equals("") || ten_LopHoc.equals("") || nam_LopHoc.equals("")) {
				JOptionPane.showMessageDialog(null, "Bạn chưa có thông tin cần sửa", null, JOptionPane.WARNING_MESSAGE);
			} else {
				try {
					for (LopHoc x : arrLH) {
						if (MaLH.getText().equals(x.getMaLop())) {
							x.setTenLop(TenLH.getText());
							x.setNamHoc(NamHoc.getText());
							break;
						}
					}
					String sql = "UPDATE lophoc SET TenLop ='" + TenLH.getText() + "',NamHoc ='" + NamHoc.getText()
							+ "' WHERE MaLop = '" + MaLH.getText() + "'";
					Statement statement = conn.createStatement();
					int x = statement.executeUpdate(sql);
					if (x >= 0) {
						JOptionPane.showMessageDialog(null, "Đã sửa thông tin sinh viên");
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			dm_LopHoc.setRowCount(0);
			for (LopHoc x : arrLH) {
				String[] row = { x.getMaLop(), x.getTenLop(), x.getNamHoc() };
				dm_LopHoc.addRow(row);
			}

			MaLH.setText("");
			TenLH.setText("");
			NamHoc.setText("");
		}

	};

	ActionListener eventReset_LopHoc = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			themLopHoc.setEnabled(true);
			MaLH.setEditable(true);
			MaLH.setText("");
			TenLH.setText("");
			NamHoc.setText("");
		}

	};
	// kết thúc CRUD lớp học

}
