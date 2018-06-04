package project.ui;

import project.connect.Connect;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ThongKeUI extends JPanel {
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

	public ThongKeUI() {
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
		Connection conn = Connect.getConnect("localhost", "minhad", "minhad", "minh");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT DISTINCT NamHoc FROM lophoc");
			while (result.next()) {
				selectNamDiem.addItem(result.getString("NamHoc"));
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
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM table_monhoc");
			while (result.next()) {
				dm_ThongkeDiem.addColumn(new String(result.getString("MaMH")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dm_ThongkeDiem.addColumn("ĐTB");
		dm_ThongkeDiem.addColumn("Xếp loại");

		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT MaSV,\r\n"
					+ "    SUM(CASE WHEN MaMH = '#Lp0' THEN Diem ELSE 0 END) AS Lp0,\r\n"
					+ "    SUM(CASE WHEN MaMH = '#Lp1' THEN Diem END) AS Lp1,\r\n"
					+ "    SUM(CASE WHEN MaMH = '#Lp2' THEN Diem END) AS Lp2,\r\n"
					+ "    SUM(CASE WHEN MaMH = '#Lp3' THEN Diem END) AS Lp3,\r\n"
					+ "    SUM(CASE WHEN MaMH = '#Lp4' THEN Diem END) AS Lp4,\r\n"
					+ "    SUM(CASE WHEN MaMH = '#Lp5' THEN Diem END) AS Lp5,\r\n"
					+ "    SUM(CASE WHEN MaMH = '#Lp6' THEN Diem END) AS Lp6,\r\n"
					+ "    SUM(CASE WHEN MaMH = '#LpE' THEN Diem END) AS LpE\r\n" + "FROM diem\r\n" + "GROUP BY MaSV");
			while (result.next()) {
				Statement stt = conn.createStatement();
				ResultSet query = stt.executeQuery(
						"SELECT * FROM sinhvien WHERE sinhvien.MaSV = '" + result.getString("MaSV") + "'");
				query.next();
				String[] row = { result.getString("MaSV"), query.getString("sinhvien.TenSV"), result.getString("Lp0"),
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
				String[] dm = { result.getString("MaSV"), query.getString("sinhvien.TenSV"), result.getString("Lp0"),
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
			ResultSet result = statement.executeQuery("SELECT DISTINCT NamHoc FROM lophoc");
			while (result.next()) {
				selectNamSV.addItem(result.getString("NamHoc"));
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
					"SELECT *,(SELECT Count(*) FROM sinhvien WHERE sinhvien.MaLop = lophoc.MaLop) as Tong FROM lophoc");
			while (result.next()) {
				String[] row = { result.getString("lophoc.MaLop"), result.getString("TenLop"), result.getString("Tong"),
						result.getString("NamHoc") };
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
		Connection conn = Connect.getConnect("localhost", "minhad", "minhad", "minh");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM lophoc");
			while (result.next()) {
				selectLopDiem.addItem(new String(result.getString("MaLop")));
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
				Connection conn = Connect.getConnect("localhost", "minhad", "minhad", "minh");
				try {
					Statement statement = conn.createStatement();
					ResultSet result = statement.executeQuery(
							"SELECT *,(SELECT Count(*) FROM sinhvien WHERE sinhvien.MaLop = lophoc.MaLop) as Tong FROM lophoc");
					while (result.next()) {
						String[] row = { result.getString("lophoc.MaLop"), result.getString("TenLop"),
								result.getString("Tong"), result.getString("NamHoc") };
						dm_ThongkeSV.addRow(row);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			} else {
				dm_ThongkeSV.setRowCount(0);
				Connection conn = Connect.getConnect("localhost", "minhad", "minhad", "minh");
				try {
					Statement statement = conn.createStatement();
					ResultSet result = statement.executeQuery(
							"SELECT *,(SELECT Count(*) FROM sinhvien WHERE sinhvien.MaLop = lophoc.MaLop) as Tong FROM lophoc WHERE lophoc.NamHoc='"
									+ chonNamHoc + "'");
					while (result.next()) {
						String[] row = { result.getString("lophoc.MaLop"), result.getString("TenLop"),
								result.getString("Tong"), result.getString("NamHoc") };
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
				Connection conn = Connect.getConnect("localhost", "minhad", "minhad", "minh");
				try {
					Statement statement = conn.createStatement();
					ResultSet result = statement.executeQuery("SELECT * FROM lophoc");
					while (result.next()) {
						selectLopDiem.addItem(new String(result.getString("MaLop")));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			} else {
				Connection conn = Connect.getConnect("localhost", "minhad", "minhad", "minh");
				try {
					Statement statement = conn.createStatement();
					ResultSet result = statement
							.executeQuery("SELECT * FROM lophoc WHERE NamHoc ='" + chonNamHoc + "'");
					while (result.next()) {
						selectLopDiem.addItem(new String(result.getString("MaLop")));
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
					Connection conn = Connect.getConnect("localhost", "minhad", "minhad", "minh");
					try {
						Statement statement = conn.createStatement();
						ResultSet result = statement.executeQuery(
								"SELECT MaSV,\r\n" + "    SUM(CASE WHEN MaMH = '#Lp0' THEN Diem ELSE 0 END) AS Lp0,\r\n"
										+ "    SUM(CASE WHEN MaMH = '#Lp1' THEN Diem END) AS Lp1,\r\n"
										+ "    SUM(CASE WHEN MaMH = '#Lp2' THEN Diem END) AS Lp2,\r\n"
										+ "    SUM(CASE WHEN MaMH = '#Lp3' THEN Diem END) AS Lp3,\r\n"
										+ "    SUM(CASE WHEN MaMH = '#Lp4' THEN Diem END) AS Lp4,\r\n"
										+ "    SUM(CASE WHEN MaMH = '#Lp5' THEN Diem END) AS Lp5,\r\n"
										+ "    SUM(CASE WHEN MaMH = '#Lp6' THEN Diem END) AS Lp6,\r\n"
										+ "    SUM(CASE WHEN MaMH = '#LpE' THEN Diem END) AS LpE\r\n" + "FROM diem\r\n"
										+ "GROUP BY MaSV");
						while (result.next()) {
							Statement stt = conn.createStatement();
							ResultSet query = stt.executeQuery(
									"SELECT * FROM sinhvien WHERE sinhvien.MaSV = '" + result.getString("MaSV") + "'");
							query.next();
							String[] row = { result.getString("MaSV"), query.getString("sinhvien.TenSV"),
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
							String[] dm = { result.getString("MaSV"), query.getString("sinhvien.TenSV"),
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
					Connection conn = Connect.getConnect("localhost", "minhad", "minhad", "minh");
					try {
						Statement statement = conn.createStatement();
						ResultSet result = statement.executeQuery(
								"SELECT MaSV,\r\n" + "    SUM(CASE WHEN MaMH = '#Lp0' THEN Diem ELSE 0 END) AS Lp0,\r\n"
										+ "    SUM(CASE WHEN MaMH = '#Lp1' THEN Diem END) AS Lp1,\r\n"
										+ "    SUM(CASE WHEN MaMH = '#Lp2' THEN Diem END) AS Lp2,\r\n"
										+ "    SUM(CASE WHEN MaMH = '#Lp3' THEN Diem END) AS Lp3,\r\n"
										+ "    SUM(CASE WHEN MaMH = '#Lp4' THEN Diem END) AS Lp4,\r\n"
										+ "    SUM(CASE WHEN MaMH = '#Lp5' THEN Diem END) AS Lp5,\r\n"
										+ "    SUM(CASE WHEN MaMH = '#Lp6' THEN Diem END) AS Lp6,\r\n"
										+ "    SUM(CASE WHEN MaMH = '#LpE' THEN Diem END) AS LpE\r\n" + "FROM diem\r\n"
										+ "GROUP BY MaSV");

						while (result.next()) {
							Statement stt = conn.createStatement();
							ResultSet query = stt.executeQuery("SELECT * FROM sinhvien WHERE sinhvien.MaSV = '"
									+ result.getString("MaSV") + "' AND sinhvien.MaLop ='" + chonLopHoc + "'");
							while (query.next()) {
								String[] row = { result.getString("MaSV"), query.getString("sinhvien.TenSV"),
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
								String[] dm = { result.getString("MaSV"), query.getString("sinhvien.TenSV"),
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
