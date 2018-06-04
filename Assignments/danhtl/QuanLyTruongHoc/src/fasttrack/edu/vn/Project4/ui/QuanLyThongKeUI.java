package fasttrack.edu.vn.Project4.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import fasttrack.edu.vn.Project4.model.Connect;

public class QuanLyThongKeUI extends JPanel{

	private static final long serialVersionUID = 1L;
	private JComboBox<String> selectNamDiem = new JComboBox<>();
	private JComboBox<String> selectLopDiem = new JComboBox<>();
	private JComboBox<String> selectNamSV = new JComboBox<>();

	private DefaultTableModel dm_ThongkeDiem;
	private JTable table_ThongkeDiem;
	private JScrollPane sp_ThongkeDiem;

	private DefaultTableModel dm_ThongkeSV;
	private JTable table_ThongkeSV;
	private JScrollPane sp_ThongkeSV;

	private JPanel thongkeDiem = new JPanel();
	private JPanel thongkeSV = new JPanel();

	public QuanLyThongKeUI() {
		lop();
		addControls();
		addEvent();
	}

	public void addControls() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		// Quản lý thống kê điểm

		thongkeDiem.setLayout(new BoxLayout(thongkeDiem, BoxLayout.Y_AXIS));

		JPanel pnMHDiem = new JPanel();
		pnMHDiem.setLayout(new FlowLayout());

		JPanel chonNamDiem = new JPanel();
		chonNamDiem.setLayout(new FlowLayout());
		JLabel lblchonNam = new JLabel("Năm học:");
		chonNamDiem.add(lblchonNam);
		selectNamDiem.addItem("Chọn năm học");
		Connection conn = Connect.getConnect("localhost", "Danh", "Danh", "Danh");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT DISTINCT nam_hoc FROM quan_ly_lop_hoc");
			while (result.next()) {
				selectNamDiem.addItem(result.getString("nam_hoc"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		chonNamDiem.add(selectNamDiem);
		pnMHDiem.add(chonNamDiem);

		JPanel chonLopDiem = new JPanel();
		chonLopDiem.setLayout(new FlowLayout());
		JLabel lblchonLop = new JLabel("Mã lớp học:");
		chonLopDiem.add(lblchonLop);
		chonLopDiem.add(selectLopDiem);
		pnMHDiem.add(chonLopDiem);

		thongkeDiem.add(pnMHDiem);

		JPanel tbthongkediem = new JPanel();
		tbthongkediem.setLayout(new BorderLayout());
		Border borderDiem = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitleDiem = BorderFactory.createTitledBorder(borderDiem, "Thống kê điểm của sinh viên");
		tbthongkediem.setBorder(borderTitleDiem);

		dm_ThongkeDiem = new DefaultTableModel();

		dm_ThongkeDiem.addColumn("Mã sinh viên");
		dm_ThongkeDiem.addColumn("Tên sinh viên");
//		try {
//			Statement statement = conn.createStatement();
//			ResultSet result = statement.executeQuery("SELECT * FROM Quan_ly_mon_hoc");
//			while (result.next()) {
//				dm_ThongkeDiem.addColumn(new String(result.getString("ma_mon_hoc")));
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		dm_ThongkeDiem.addColumn("lp0");
		dm_ThongkeDiem.addColumn("lp1");
		dm_ThongkeDiem.addColumn("lp2");
		dm_ThongkeDiem.addColumn("lp3");
		dm_ThongkeDiem.addColumn("lp4");
		dm_ThongkeDiem.addColumn("lp5");
		dm_ThongkeDiem.addColumn("lp6");
		dm_ThongkeDiem.addColumn("lpe");
		dm_ThongkeDiem.addColumn("ĐTB");
		dm_ThongkeDiem.addColumn("Xếp loại");

		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT ma_sinh_vien,\r\n"
					+ "    SUM(CASE WHEN ma_mon_hoc = 'LP#0' THEN diem ELSE 0 END) AS Lp0,\r\n"
					+ "    SUM(CASE WHEN ma_mon_hoc = 'LP#1' THEN diem END) AS Lp1,\r\n"
					+ "    SUM(CASE WHEN ma_mon_hoc = 'LP#2' THEN diem END) AS Lp2,\r\n"
					+ "    SUM(CASE WHEN ma_mon_hoc = 'LP#3' THEN diem END) AS Lp3,\r\n"
					+ "    SUM(CASE WHEN ma_mon_hoc = 'LP#4' THEN diem END) AS Lp4,\r\n"
					+ "    SUM(CASE WHEN ma_mon_hoc = 'LP#5' THEN diem END) AS Lp5,\r\n"
					+ "    SUM(CASE WHEN ma_mon_hoc = 'LP#6' THEN diem END) AS Lp6,\r\n"
					+ "    SUM(CASE WHEN ma_mon_hoc = 'LP#E' THEN diem END) AS LpE\r\n" + "FROM Quan_ly_diem\r\n" + "GROUP BY ma_sinh_vien");
			while (result.next()) {
				Statement stt = conn.createStatement();
				ResultSet query = stt.executeQuery(
						"SELECT * FROM Quan_ly_sinh_vien WHERE Quan_ly_sinh_vien.ma_sinh_vien = '" + result.getString("ma_sinh_vien") + "'");
				query.next();
				String[] row = { result.getString("ma_sinh_vien"), query.getString("Quan_ly_sinh_vien.ten_sinh_vien"), result.getString("Lp0"),
						result.getString("Lp1"), result.getString("Lp2"), result.getString("Lp3"),
						result.getString("Lp4"), result.getString("Lp5"), result.getString("Lp6"),
						result.getString("LpE") };
				int t = 0;
				int n = 0;
				int y = 0;
				for (int i = 2; i < row.length; i++) {
					if (row[i] != null) {
						y = Integer.parseInt(row[i]);
						n = n + y;
						t++;
					}
				}
				double tbc = (double) n / t;

				String xeploai;
				if (tbc <= 4.9) {
					xeploai = "Yếu";
				} else if (tbc <= 6.4) {
					xeploai = "Trung Bình";
				} else if (tbc <= 7.9) {
					xeploai = "Khá";
				} else {
					xeploai = "Giỏi";
				}

				String TBM = Double.toString(tbc);
				String[] dm = { result.getString("ma_sinh_vien"), query.getString("Quan_ly_sinh_vien.ten_sinh_vien"), result.getString("Lp0"),
						result.getString("Lp1"), result.getString("Lp2"), result.getString("Lp3"),
						result.getString("Lp4"), result.getString("Lp5"), result.getString("Lp6"),
						result.getString("LpE"), TBM, xeploai };
				dm_ThongkeDiem.addRow(dm);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		table_ThongkeDiem = new JTable(dm_ThongkeDiem);
		table_ThongkeDiem.setLayout(new BorderLayout());
		sp_ThongkeDiem = new JScrollPane(table_ThongkeDiem);
		JScrollPane sc_lopMonHoc = new JScrollPane(sp_ThongkeDiem, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc_lopMonHoc.setPreferredSize(new Dimension(470, 180));
		tbthongkediem.add(sc_lopMonHoc, BorderLayout.CENTER);
		thongkeDiem.add(tbthongkediem);

		this.add(thongkeDiem);

		// kết thúc quản lý thống kê điểm

		// quản lý thống kê sinh viên
		thongkeSV.setLayout(new BoxLayout(thongkeSV, BoxLayout.Y_AXIS));

		JPanel tksv = new JPanel();
		tksv.setLayout(new FlowLayout());

		JPanel chonNamSV = new JPanel();
		chonNamSV.setLayout(new FlowLayout());
		JLabel lblNamSV = new JLabel("Năm học:");
		chonNamSV.add(lblNamSV);
		selectNamSV.addItem("Chọn năm học");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT DISTINCT nam_hoc FROM quan_ly_lop_hoc");
			while (result.next()) {
				selectNamSV.addItem(result.getString("nam_hoc"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		chonNamSV.add(selectNamSV);
		tksv.add(chonNamSV);

		thongkeSV.add(tksv);

		JPanel tbthongkesv = new JPanel();
		tbthongkesv.setLayout(new BorderLayout());
		Border bordersv = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitlesv = BorderFactory.createTitledBorder(bordersv, "Thống kê tổng số sinh viên của lớp");
		tbthongkesv.setBorder(borderTitlesv);

		dm_ThongkeSV = new DefaultTableModel();

		dm_ThongkeSV.addColumn("Mã lớp học");
		dm_ThongkeSV.addColumn("Tên lớp học");
		dm_ThongkeSV.addColumn("Số lượng sinh viên");
		dm_ThongkeSV.addColumn("Năm học");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(
					"SELECT *,(SELECT Count(*) FROM Quan_ly_sinh_vien WHERE Quan_ly_sinh_vien.ma_lop = quan_ly_lop_hoc.ma_lop) as Tong FROM quan_ly_lop_hoc");
			while (result.next()) {
				String[] row = { result.getString("quan_ly_lop_hoc.ma_lop"), result.getString("mo_ta"), result.getString("Tong"),
						result.getString("nam_hoc") };
				dm_ThongkeSV.addRow(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		table_ThongkeSV = new JTable(dm_ThongkeSV);
		table_ThongkeSV.setLayout(new BorderLayout());
		sp_ThongkeSV = new JScrollPane(table_ThongkeSV);
		JScrollPane sc_thongkeSV = new JScrollPane(sp_ThongkeSV, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc_thongkeSV.setPreferredSize(new Dimension(470, 180));
		tbthongkesv.add(sc_thongkeSV, BorderLayout.CENTER);
		thongkeSV.add(tbthongkesv);
		this.add(thongkeSV);

		// Kết thúc quản lý thống kê sinh viên
	}

	// Lấy giá trị tĩnh cho các JComboBox

	public void lop() {
		selectLopDiem.addItem("Tất cả");
		Connection conn = Connect.getConnect("localhost", "Danh", "Danh", "Danh");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM quan_ly_lop_hoc");
			while (result.next()) {
				selectLopDiem.addItem(new String(result.getString("ma_lop")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// lấy xong giá trị của JComboBox

	public void addEvent() {
		selectNamSV.addActionListener(eventChooseNamSV);
		selectNamDiem.addActionListener(eventChooseNamDiem);
		selectLopDiem.addActionListener(eventChooseLopDiem);
	}

	ActionListener eventChooseNamSV = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String chonNamHoc = (String) selectNamSV.getSelectedItem();
			if (chonNamHoc.equals("Chọn năm học")) {
				dm_ThongkeSV.setRowCount(0);
				Connection conn = Connect.getConnect("localhost", "Danh", "Danh", "Danh");
				try {
					Statement statement = conn.createStatement();
					ResultSet result = statement.executeQuery(
							"SELECT *,(SELECT Count(*) FROM Quan_ly_sinh_vien WHERE Quan_ly_sinh_vien.ma_lop = quan_ly_lop_hoc.ma_lop) as Tong FROM quan_ly_lop_hoc");
					while (result.next()) {
						String[] row = { result.getString("quan_ly_lop_hoc.ma_lop"), result.getString("mo_ta"),
								result.getString("Tong"), result.getString("nam_hoc") };
						dm_ThongkeSV.addRow(row);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			} else {
				dm_ThongkeSV.setRowCount(0);
				Connection conn = Connect.getConnect("localhost", "Danh", "Danh", "Danh");
				try {
					Statement statement = conn.createStatement();
					ResultSet result = statement.executeQuery(
							"SELECT *,(SELECT Count(*) FROM Quan_ly_sinh_vien WHERE Quan_ly_sinh_vien.ma_lop = quan_ly_lop_hoc.ma_lop) as Tong FROM quan_ly_lop_hoc WHERE quan_ly_lop_hoc.nam_hoc ='"
									+ chonNamHoc + "'");
					while (result.next()) {
						String[] row = { result.getString("quan_ly_lop_hoc.ma_lop"), result.getString("mo_ta"),
								result.getString("Tong"), result.getString("nam_hoc") };
						dm_ThongkeSV.addRow(row);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	};

	ActionListener eventChooseNamDiem = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String chonNamHoc = (String) selectNamDiem.getSelectedItem();
			selectLopDiem.removeAllItems();
			if (chonNamHoc.equals("Chọn năm học")) {
				selectLopDiem.addItem("Tất cả");
				Connection conn = Connect.getConnect("localhost", "Danh", "Danh", "Danh");
				try {
					Statement statement = conn.createStatement();
					ResultSet result = statement.executeQuery("SELECT * FROM quan_ly_lop_hoc");
					while (result.next()) {
						selectLopDiem.addItem(new String(result.getString("ma_lop")));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			} else {
				Connection conn = Connect.getConnect("localhost", "Danh", "Danh", "Danh");
				try {
					Statement statement = conn.createStatement();
					ResultSet result = statement
							.executeQuery("SELECT * FROM quan_ly_lop_hoc WHERE nam_hoc ='" + chonNamHoc + "'");
					while (result.next()) {
						selectLopDiem.addItem(new String(result.getString("ma_lop")));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	};

	ActionListener eventChooseLopDiem = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			int x = selectLopDiem.getSelectedIndex();
			if (x >= 0) {
				String chonLopHoc = (String) selectLopDiem.getSelectedItem();
				if (chonLopHoc.equals("Tất cả")) {
					dm_ThongkeDiem.setRowCount(0);
					Connection conn = Connect.getConnect("localhost", "Danh", "Danh", "Danh");
					try {
						Statement statement = conn.createStatement();
						ResultSet result = statement.executeQuery(
								"SELECT ma_sinh_vien,\r\n" + "    SUM(CASE WHEN ma_mon_hoc = 'LP#0' THEN diem ELSE 0 END) AS Lp0,\r\n"
										+ "    SUM(CASE WHEN ma_mon_hoc = 'LP#1' THEN diem END) AS Lp1,\r\n"
										+ "    SUM(CASE WHEN ma_mon_hoc = 'LP#2' THEN diem END) AS Lp2,\r\n"
										+ "    SUM(CASE WHEN ma_mon_hoc = 'LP#3' THEN diem END) AS Lp3,\r\n"
										+ "    SUM(CASE WHEN ma_mon_hoc = 'LP#4' THEN diem END) AS Lp4,\r\n"
										+ "    SUM(CASE WHEN ma_mon_hoc = 'LP#5' THEN diem END) AS Lp5,\r\n"
										+ "    SUM(CASE WHEN ma_mon_hoc = 'LP#6' THEN diem END) AS Lp6,\r\n"
										+ "    SUM(CASE WHEN ma_mon_hoc = 'LP#E' THEN diem END) AS LpE\r\n" + "FROM Quan_ly_diem\r\n"
										+ "GROUP BY ma_sinh_vien");
						while (result.next()) {
							Statement stt = conn.createStatement();
							ResultSet query = stt.executeQuery(
									"SELECT * FROM Quan_ly_sinh_vien WHERE Quan_ly_sinh_vien.ma_sinh_vien = '" + result.getString("ma_sinh_vien") + "'");
							query.next();
							String[] row = { result.getString("ma_sinh_vien"), query.getString("Quan_ly_sinh_vien.ten_sinh_vien"),
									result.getString("Lp0"), result.getString("Lp1"), result.getString("Lp2"),
									result.getString("Lp3"), result.getString("Lp4"), result.getString("Lp5"),
									result.getString("Lp6"), result.getString("LpE") };
							int t = 0;
							int n = 0;
							int y = 0;
							for (int i = 2; i < row.length; i++) {
								if (row[i] != null) {
									y = Integer.parseInt(row[i]);
									n = n + y;
									t++;
								}
							}
							float tbc = (float) n / t;

							String xeploai;
							if (tbc <= 4.9) {
								xeploai = "Yếu";
							} else if (tbc <= 6.4) {
								xeploai = "Trung Bình";
							} else if (tbc <= 7.9) {
								xeploai = "Khá";
							} else {
								xeploai = "Giỏi";
							}

							String TBM = Float.toString(tbc);
							String[] dm = { result.getString("ma_sinh_vien"), query.getString("Quan_ly_sinh_vien.ten_sinh_vien"),
									result.getString("Lp0"), result.getString("Lp1"), result.getString("Lp2"),
									result.getString("Lp3"), result.getString("Lp4"), result.getString("Lp5"),
									result.getString("Lp6"), result.getString("LpE"), TBM, xeploai };
							dm_ThongkeDiem.addRow(dm);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					dm_ThongkeDiem.setRowCount(0);
					Connection conn = Connect.getConnect("localhost", "Danh", "Danh", "Danh");
					try {
						Statement statement = conn.createStatement();
						ResultSet result = statement.executeQuery(
								"SELECT ma_sinh_vien,\r\n" + "    SUM(CASE WHEN ma_mon_hoc = '#Lp0' THEN diem ELSE 0 END) AS Lp0,\r\n"
										+ "    SUM(CASE WHEN ma_mon_hoc = 'LP#1' THEN diem END) AS Lp1,\r\n"
										+ "    SUM(CASE WHEN ma_mon_hoc = 'LP#2' THEN diem END) AS Lp2,\r\n"
										+ "    SUM(CASE WHEN ma_mon_hoc = 'LP#3' THEN diem END) AS Lp3,\r\n"
										+ "    SUM(CASE WHEN ma_mon_hoc = 'LP#4' THEN diem END) AS Lp4,\r\n"
										+ "    SUM(CASE WHEN ma_mon_hoc = 'LP#5' THEN diem END) AS Lp5,\r\n"
										+ "    SUM(CASE WHEN ma_mon_hoc = 'LP#6' THEN diem END) AS Lp6,\r\n"
										+ "    SUM(CASE WHEN ma_mon_hoc = 'LP#E' THEN diem END) AS LpE\r\n" + "FROM Quan_ly_diem\r\n"
										+ "GROUP BY ma_sinh_vien");

						while (result.next()) {
							Statement stt = conn.createStatement();
							ResultSet query = stt.executeQuery("SELECT * FROM Quan_ly_sinh_vien WHERE Quan_ly_sinh_vien.ma_sinh_vien = '"
									+ result.getString("ma_sinh_vien") + "' AND Quan_ly_sinh_vien.ma_lop ='" + chonLopHoc + "'");
							while (query.next()) {
								String[] row = { result.getString("ma_sinh_vien"), query.getString("Quan_ly_sinh_vien.ten_sinh_vien"),
										result.getString("Lp0"), result.getString("Lp1"), result.getString("Lp2"),
										result.getString("Lp3"), result.getString("Lp4"), result.getString("Lp5"),
										result.getString("Lp6"), result.getString("LpE") };
								int t = 0;
								int n = 0;
								int y = 0;
								for (int i = 2; i < row.length; i++) {
									if (row[i] != null) {
										y = Integer.parseInt(row[i]);
										n = n + y;
										t++;
									}
								}
								float tbc = (float) n / t;

								String xeploai;
								if (tbc <= 4.9) {
									xeploai = "Yếu";
								} else if (tbc <= 6.4) {
									xeploai = "Trung Bình";
								} else if (tbc <= 7.9) {
									xeploai = "Khá";
								} else {
									xeploai = "Giỏi";
								}

								String TBM = Float.toString(tbc);
								String[] dm = { result.getString("ma_sinh_vien"), query.getString("Quan_ly_sinh_vien.ten_sinh_vien"),
										result.getString("Lp0"), result.getString("Lp1"), result.getString("Lp2"),
										result.getString("Lp3"), result.getString("Lp4"), result.getString("Lp5"),
										result.getString("Lp6"), result.getString("LpE"), TBM, xeploai };
								dm_ThongkeDiem.addRow(dm);
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	};

}

