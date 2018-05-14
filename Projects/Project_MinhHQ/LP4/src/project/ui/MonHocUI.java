package project.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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

import project.connect.Connect;
import project.model.MonHoc;

public class MonHocUI extends JPanel{
	private static final long serialVersionUID = 1L;
	
	public MonHocUI() {
		lop(selectMonHoc);
		monhoc(selectMaMH);
		addControls();
		addEvent();
	}
	
	private JTextField MaMH = new JTextField();
	private JTextField TenMH = new JTextField();
	private JTextField Tinchi = new JTextField();
	private JTextField Time = new JTextField();

	private ArrayList<MonHoc> arrMH = new ArrayList<MonHoc>();

	private JButton themMonHoc = new JButton("Thêm");
	private JButton xoaMonHoc = new JButton("Xóa");
	private JButton suaMonHoc = new JButton("Sửa");
	private JButton nhapMonHoc = new JButton("Nhập");


	private JComboBox<String> selectMonHoc = new JComboBox<>();
	private JComboBox<String> selectMaMH = new JComboBox<>();
	

	private DefaultTableModel dm_MonHoc;
	private JTable table_MonHoc;
	private JScrollPane sp_MonHoc;
	
	

	public void addControls() {
		// Quản lý môn học

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel pnButton_MonHoc = new JPanel();
		pnButton_MonHoc.setLayout(new FlowLayout());
		pnButton_MonHoc.add(themMonHoc);
		pnButton_MonHoc.add(suaMonHoc);
		pnButton_MonHoc.add(xoaMonHoc);
		pnButton_MonHoc.add(nhapMonHoc);
		this.add(pnButton_MonHoc);

		JPanel pnLeft_MonHoc = new JPanel();
		pnLeft_MonHoc.setLayout(new BoxLayout(pnLeft_MonHoc, BoxLayout.Y_AXIS));

		JPanel nhapMaMH = new JPanel();
		nhapMaMH.setLayout(new FlowLayout());
		JLabel lblNhapMaMH = new JLabel("Mã môn học:");
		MaMH = new JTextField(20);
		nhapMaMH.add(lblNhapMaMH);
		nhapMaMH.add(MaMH);
		pnLeft_MonHoc.add(nhapMaMH);

		JPanel nhapTenMH = new JPanel();
		nhapTenMH.setLayout(new FlowLayout());
		JLabel lblNhapTenMH = new JLabel("Tên môn học:");
		TenMH = new JTextField(20);
		nhapTenMH.add(lblNhapTenMH);
		nhapTenMH.add(TenMH);
		pnLeft_MonHoc.add(nhapTenMH);

		JPanel pnRight_MonHoc = new JPanel();
		pnRight_MonHoc.setLayout(new BoxLayout(pnRight_MonHoc, BoxLayout.Y_AXIS));

		JPanel nhapTinChi = new JPanel();
		nhapTinChi.setLayout(new FlowLayout());
		JLabel lblNhapTinChi = new JLabel("Tín chỉ:                ");
		Tinchi = new JTextField(20);
		nhapTinChi.add(lblNhapTinChi);
		nhapTinChi.add(Tinchi);
		pnRight_MonHoc.add(nhapTinChi);

		JPanel nhapTime = new JPanel();
		nhapTime.setLayout(new FlowLayout());
		JLabel lblNhapTime = new JLabel("Thời gian học:   ");
		Time = new JTextField(20);
		nhapTime.add(lblNhapTime);
		nhapTime.add(Time);
		pnRight_MonHoc.add(nhapTime);

		JPanel pnMH = new JPanel();
		pnMH.setLayout(new FlowLayout());

		pnMH.add(pnLeft_MonHoc);
		pnMH.add(pnRight_MonHoc);
		this.add(pnMH);

		JPanel Table_MonHoc = new JPanel();
		Table_MonHoc.setLayout(new BorderLayout());
		Border border_MonHoc = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle_MonHoc = BorderFactory.createTitledBorder(border_MonHoc, "Danh sách môn học");
		Table_MonHoc.setBorder(borderTitle_MonHoc);

		dm_MonHoc = new DefaultTableModel();

		dm_MonHoc.addColumn("Mã môn học");
		dm_MonHoc.addColumn("Tên môn học");
		dm_MonHoc.addColumn("Tín chỉ");
		dm_MonHoc.addColumn("Thời gian học");
		Connection conn = Connect.getConnect("localhost", "minhad", "minhad", "minh");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM table_monhoc");
			while (result.next()) {
				arrMH.add(new MonHoc(result.getString("maMH"), result.getString("tenMH"), result.getString("STC"),
						result.getString("ThoiGian")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (MonHoc x : arrMH) {
			String[] row = { x.getMaMH(), x.getTenMH(), x.getTinChi(), x.getTime() };
			dm_MonHoc.addRow(row);
		}

		table_MonHoc = new JTable(dm_MonHoc);
		table_MonHoc.setLayout(new BorderLayout());
		sp_MonHoc = new JScrollPane(table_MonHoc);
		JScrollPane sc_MonHoc = new JScrollPane(sp_MonHoc, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc_MonHoc.setPreferredSize(new Dimension(470, 180));
		Table_MonHoc.add(sc_MonHoc, BorderLayout.CENTER);
		this.add(Table_MonHoc);
		
	}

	// Lấy giá trị tĩnh cho các JComboBox

	public void lop(JComboBox<String> x) {
		x.addItem("Tất Cả");
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

	public void monhoc(JComboBox<String> x) {
		Connection conn = Connect.getConnect("localhost", "minhad", "minhad", "minh");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM table_monhoc");
			while (result.next()) {
				x.addItem(new String(result.getString("MaMH")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// lấy xong giá trị của JComboBox

	public void addEvent() {

		// CRUD môn học
		table_MonHoc.addMouseListener(eventTable_MonHoc);
		themMonHoc.addActionListener(eventAdd_MonHoc);
		xoaMonHoc.addActionListener(eventDel_MonHoc);
		suaMonHoc.addActionListener(eventEdit_MonHoc);
		nhapMonHoc.addActionListener(eventReset_MonHoc);
	}

	
	// CRUD Lớp Học

	MouseAdapter eventTable_MonHoc = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int row = table_MonHoc.getSelectedRow();
			String[] col = new String[4];
			col[0] = (String) table_MonHoc.getValueAt(row, 0);
			col[1] = (String) table_MonHoc.getValueAt(row, 1);
			col[2] = (String) table_MonHoc.getValueAt(row, 2);
			col[3] = (String) table_MonHoc.getValueAt(row, 3);
			themMonHoc.setEnabled(false);
			MaMH.setEditable(false);
			MaMH.setText(col[0]);
			TenMH.setText(col[1]);
			Tinchi.setText(col[2]);
			Time.setText(col[3]);
		}
	};

	ActionListener eventAdd_MonHoc = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String ma_MonHoc = MaMH.getText();
			String ten_MonHoc = TenMH.getText();
			String tinchi_MonHoc = Tinchi.getText();
			String time_MonHoc = Time.getText();

			try {
				Connection conn = Connect.getConnect("localhost", "minhad", "minhad", "minh");
				if (ma_MonHoc.equals("") || ten_MonHoc.equals("") || tinchi_MonHoc.equals("")
						|| time_MonHoc.equals("")) {
					JOptionPane.showMessageDialog(null, "Bạn chưa nhập thông tin");
				} else {
					for (MonHoc y : arrMH) {
						if (ma_MonHoc.equals(y.getMaMH())) {
							JOptionPane.showMessageDialog(null, "Trùng mã môn học");
							break;
						} else {
							arrMH.add(new MonHoc(ma_MonHoc, ten_MonHoc, tinchi_MonHoc, time_MonHoc));
							dm_MonHoc.addRow(new String[] { ma_MonHoc, ten_MonHoc, tinchi_MonHoc, time_MonHoc });

							try {
								String sql = "INSERT INTO table_monhoc( maMH, tenMH, STC, ThoiGian) VALUES ('"
										+ ma_MonHoc + "','" + ten_MonHoc + "','" + tinchi_MonHoc + "','" + time_MonHoc
										+ "')";
								Statement statement = conn.createStatement();
								int x = statement.executeUpdate(sql);
								if (x > 0) {
									JOptionPane.showMessageDialog(null, "Đã lưu thông tin");
								}
							} catch (Exception ex) {
								ex.printStackTrace();
							}
						}

					}
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Bạn cần nhập thông tin");
			}

			MaMH.setText("");
			TenMH.setText("");
			Tinchi.setText("");
			Time.setText("");
		}
	};

	ActionListener eventDel_MonHoc = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			for (MonHoc x : arrMH) {
				if (MaMH.getText().equals(x.getMaMH())) {
					arrMH.remove(x);
					break;
				}
			}
			Connection conn = Connect.getConnect("localhost", "minhad", "minhad", "minh");
			try {
				String sql = "DELETE FROM table_monhoc WHERE MaMH = '" + MaMH.getText() + "'";
				Statement statement = conn.createStatement();
				int x = statement.executeUpdate(sql);
				if (x >= 0) {
					JOptionPane.showMessageDialog(null, "Đã xóa thông tin sinh viên");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			dm_MonHoc.setRowCount(0);
			for (MonHoc x : arrMH) {
				String[] row = { x.getMaMH(), x.getTenMH(), x.getTinChi(), x.getTime() };
				dm_MonHoc.addRow(row);
			}

			MaMH.setText("");
			TenMH.setText("");
			Tinchi.setText("");
			Time.setText("");
		}

	};

	ActionListener eventEdit_MonHoc = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			for (MonHoc x : arrMH) {
				if (MaMH.getText().equals(x.getMaMH())) {
					x.setTenMH(TenMH.getText());
					x.setTinChi(Tinchi.getText());
					x.setTime(Time.getText());
					break;
				}
			}
			Connection conn = Connect.getConnect("localhost", "minhad", "minhad", "minh");
			try {
				String sql = "UPDATE table_monhoc SET TenMH ='" + TenMH.getText() + "',STC ='" + Tinchi.getText()
						+ "',ThoiGian ='" + Time.getText() + "' WHERE MaMH = '" + MaMH.getText() + "'";
				Statement statement = conn.createStatement();
				int x = statement.executeUpdate(sql);
				if (x >= 0) {
					JOptionPane.showMessageDialog(null, "Đã sửa thông tin sinh viên");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			dm_MonHoc.setRowCount(0);
			for (MonHoc x : arrMH) {
				String[] row = { x.getMaMH(), x.getTenMH(), x.getTinChi(), x.getTime() };
				dm_MonHoc.addRow(row);
			}

			MaMH.setText("");
			TenMH.setText("");
			Tinchi.setText("");
			Time.setText("");
		}
	};

	ActionListener eventReset_MonHoc = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			themMonHoc.setEnabled(true);
			MaMH.setEditable(true);
			MaMH.setText("");
			TenMH.setText("");
			Tinchi.setText("");
			Time.setText("");
		}
	};
	// kết thúc CRUD môn học
	
	
	
}
