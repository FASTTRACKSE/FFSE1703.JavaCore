package QuanLyTruongHoc.FFSE.UI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;



public class ThongKeUI extends JPanel {


	private JComboBox<String> selectNamDiem = new JComboBox<>();
	private JComboBox<String> selectLopDiem = new JComboBox<>();
	private JComboBox<String> selectNamSV = new JComboBox<>();
	
	private static final long serialVersionUID = 1L;
	private JPanel pnNhapdiem = new JPanel();
	private JPanel pnNhapdiem1 = new JPanel();
	private DefaultTableModel dm_nhapdiem, dm_nhapdiem1;
	private JTable table_nhapdiem, table_nhapdiem1;
	private JScrollPane sc_nhapdiem, sc_nhapdiem1;
	private JScrollPane sp_nhapdiem, sp_nhapdiem1;

	public ThongKeUI() {
		lop();
		addControls();
		addEvent();
	}

	public void addControls() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		pnNhapdiem.setLayout(new BoxLayout(pnNhapdiem, BoxLayout.Y_AXIS));

		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Danh sách");
		pnNhapdiem.setBorder(borderTitle);
		dm_nhapdiem = new DefaultTableModel();
		dm_nhapdiem.addColumn("Mã SV");
		dm_nhapdiem.addColumn("Tên SV");

		Connection conn = Connect.getConnect("localhost", "admin", "admin1", "12345");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM table_monhoc");
			while (result.next()) {
				dm_nhapdiem.addColumn(new String(result.getString("MaMH")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dm_nhapdiem.addColumn("ĐTB");
		dm_nhapdiem.addColumn("Xếp loại");

		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(
					"SELECT MaSV,\r\n" + "    SUM(CASE WHEN MaMH = 'LP0' THEN Diem ELSE 0 END) AS Lp0,\r\n"
							+ "    SUM(CASE WHEN MaMH = 'LP1' THEN Diem  END) AS Lp1,\r\n"
							+ "    SUM(CASE WHEN MaMH = 'LP2' THEN Diem  END) AS Lp2,\r\n"
							+ "    SUM(CASE WHEN MaMH = 'LP3' THEN Diem  END) AS Lp3,\r\n"
							+ "    SUM(CASE WHEN MaMH = 'LP4' THEN Diem  END) AS Lp4,\r\n"
							+ "    SUM(CASE WHEN MaMH = 'LP5' THEN Diem  END) AS Lp5,\r\n"
							+ "    SUM(CASE WHEN MaMH = 'LP6' THEN Diem  END) AS Lp6,\r\n"
							+ "    SUM(CASE WHEN MaMH = 'LPE' THEN Diem  END) AS LpE\r\n" + "FROM table_diem\r\n"
							+ "GROUP BY MaSV");
			while (result.next()) {
				Statement stt = conn.createStatement();
				ResultSet query = stt.executeQuery(
						"SELECT * FROM table_sinhvien WHERE table_sinhvien.MaSV = '" + result.getString("MaSV") + "'");
				query.next();
				String[] row = { result.getString("MaSV"), query.getString("table_sinhvien.Ten"), result.getString("Lp0"),
						result.getString("Lp1"), result.getString("Lp2"), result.getString("Lp3"),
						result.getString("Lp4"), result.getString("Lp5"), result.getString("Lp6"),
						result.getString("LpE") };
				
				int t= 0;
				int n = 0;
				int y = 0;
				for (int i=2;i<row.length;i++) {
					if(row[i] != null) {
					y = Integer.parseInt(row[i]);
					n =  n + y;
					t++;
					}
					}
				    float tbc=(float)n/t;
				    
				    String xeploai ;
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
				    String[] dm = { result.getString("MaSV"),query.getString("table_sinhvien.Ten"), result.getString("Lp0"), result.getString("Lp1"),
							result.getString("Lp2"), result.getString("Lp3"), result.getString("Lp4"),
							result.getString("Lp5"), result.getString("Lp6"), result.getString("LpE"),TBM,xeploai };
				
				dm_nhapdiem.addRow(dm);
			}
		} catch (Exception e) {
		
			e.printStackTrace();
		}

		table_nhapdiem = new JTable(dm_nhapdiem);
		table_nhapdiem.setLayout(new BorderLayout());
		sp_nhapdiem = new JScrollPane(table_nhapdiem);
		sc_nhapdiem = new JScrollPane(sp_nhapdiem, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc_nhapdiem.setPreferredSize(new Dimension(715, 380));

		JPanel muctimlopseachsv = new JPanel();
		muctimlopseachsv.setLayout(new BoxLayout(muctimlopseachsv, BoxLayout.Y_AXIS));
		JPanel flow = new JPanel();
		flow.setLayout(new FlowLayout());
		selectNamDiem = new JComboBox<>();
		JLabel xemlop = new JLabel("Chọn năm");
	
		try {
			selectNamDiem.addItem("Chọn năm học");
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT DISTINCT NamHoc FROM table_lop");
			while (result.next()) {
				selectNamDiem.addItem(result.getString("NamHoc"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		flow.add(xemlop);
		flow.add(selectNamDiem);
		JLabel chonlop = new JLabel("Chọn lớp");
		flow.add(chonlop);
		flow.add(selectLopDiem);
		muctimlopseachsv.add(flow);
		muctimlopseachsv.add(sc_nhapdiem);
		pnNhapdiem.add(muctimlopseachsv);
		this.add(pnNhapdiem);

		pnNhapdiem1.setLayout(new BoxLayout(pnNhapdiem1, BoxLayout.Y_AXIS));

		Border border1 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle1 = BorderFactory.createTitledBorder(border1, "Danh sách");
		pnNhapdiem1.setBorder(borderTitle1);
		dm_nhapdiem1 = new DefaultTableModel();
		dm_nhapdiem1.addColumn("Mã lớp học");
		dm_nhapdiem1.addColumn("Tên lớp học");
		dm_nhapdiem1.addColumn("Số sinh viên");
		dm_nhapdiem1.addColumn("Năm học");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(
					"SELECT *,(SELECT Count(*) FROM table_sinhvien WHERE table_sinhvien.MaLop = table_lop.MaLop) as Tong FROM table_lop");
			while (result.next()) {
				String[] row = { result.getString("table_lop.MaLop"), result.getString("MoTa"), result.getString("Tong"),
						result.getString("NamHoc") };
				dm_nhapdiem1.addRow(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		table_nhapdiem1 = new JTable(dm_nhapdiem1);
		table_nhapdiem1.setLayout(new BorderLayout());
		sp_nhapdiem1 = new JScrollPane(table_nhapdiem1);
		sc_nhapdiem1 = new JScrollPane(sp_nhapdiem1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc_nhapdiem1.setPreferredSize(new Dimension(715, 380));

		JPanel muctimlopseachsv1 = new JPanel();
		muctimlopseachsv1.setLayout(new BoxLayout(muctimlopseachsv1, BoxLayout.Y_AXIS));
		JPanel flow1 = new JPanel();
		flow1.setLayout(new FlowLayout());
		selectNamSV = new JComboBox<>();
		
		try {
			selectNamSV.addItem("Chọn năm học");
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT DISTINCT NamHoc FROM table_lop");
			while (result.next()) {
				selectNamSV.addItem(result.getString("NamHoc"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JLabel xemlop1 = new JLabel("Chọn năm");
		flow1.add(xemlop1);
		flow1.add(selectNamSV);
		muctimlopseachsv1.add(flow1);
		muctimlopseachsv1.add(sc_nhapdiem1);
		pnNhapdiem1.add(muctimlopseachsv1);
		this.add(pnNhapdiem1);

	}

	public void lop() {
		selectLopDiem.addItem("Tất cả");
		Connection conn = Connect.getConnect("localhost", "admin", "admin1", "12345");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM table_lop");
			while (result.next()) {
				selectLopDiem.addItem(new String(result.getString("MaLop")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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
				dm_nhapdiem1.setRowCount(0);
				Connection conn = Connect.getConnect("localhost", "admin", "admin1", "12345");
				try {
					Statement statement = conn.createStatement();
					ResultSet result = statement.executeQuery(
							"SELECT *,(SELECT Count(*) FROM table_sinhvien WHERE table_sinhvien.MaLop = table_lop.MaLop) as Tong FROM table_lop");
					while (result.next()) {
						String[] row = { result.getString("table_lop.MaLop"), result.getString("TenLop"),
								result.getString("Tong"), result.getString("NamHoc") };
						dm_nhapdiem1.addRow(row);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			} else {
				dm_nhapdiem1.setRowCount(0);
				Connection conn = Connect.getConnect("localhost", "admin", "admin1", "12345");
				try {
					Statement statement = conn.createStatement();
					ResultSet result = statement.executeQuery(
							"SELECT *,(SELECT Count(*) FROM table_sinhvien WHERE table_sinhvien.MaLop = table_lop.MaLop) as Tong FROM table_lop WHERE table_lop.NamHoc='"
									+ chonNamHoc + "'");
					while (result.next()) {
						String[] row = { result.getString("table_lop.MaLop"), result.getString("MoTa"),
								result.getString("Tong"), result.getString("NamHoc") };
						dm_nhapdiem1.addRow(row);
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
				Connection conn = Connect.getConnect("localhost", "admin", "admin1", "12345");
				try {
					Statement statement = conn.createStatement();
					ResultSet result = statement.executeQuery("SELECT * FROM table_lop");
					while (result.next()) {
						selectLopDiem.addItem(new String(result.getString("MaLop")));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			} else {
				Connection conn = Connect.getConnect("localhost", "admin", "admin1", "12345");
				try {
					Statement statement = conn.createStatement();
					ResultSet result = statement
							.executeQuery("SELECT * FROM table_lop WHERE NamHoc ='" + chonNamHoc + "'");
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
					dm_nhapdiem.setRowCount(0);
					Connection conn = Connect.getConnect("localhost", "admin", "admin1", "12345");
					try {
						Statement statement = conn.createStatement();
						ResultSet result = statement.executeQuery(
								"SELECT MaSV,\r\n" + "    SUM(CASE WHEN MaMH = 'LP0' THEN Diem ELSE 0 END) AS Lp0,\r\n"
										+ "    SUM(CASE WHEN MaMH = 'LP1' THEN Diem  END) AS Lp1,\r\n"
										+ "    SUM(CASE WHEN MaMH = 'LP2' THEN Diem  END) AS Lp2,\r\n"
										+ "    SUM(CASE WHEN MaMH = 'LP3' THEN Diem  END) AS Lp3,\r\n"
										+ "    SUM(CASE WHEN MaMH = 'LP4' THEN Diem  END) AS Lp4,\r\n"
										+ "    SUM(CASE WHEN MaMH = 'LP5' THEN Diem  END) AS Lp5,\r\n"
										+ "    SUM(CASE WHEN MaMH = 'LP6' THEN Diem  END) AS Lp6,\r\n"
										+ "    SUM(CASE WHEN MaMH = 'LPE' THEN Diem  END) AS LpE\r\n" + "FROM table_diem\r\n"
										+ "GROUP BY MaSV");
						while (result.next()) {
							Statement stt = conn.createStatement();
							ResultSet query = stt.executeQuery(
									"SELECT * FROM table_sinhvien WHERE table_sinhvien.MaSV = '" + result.getString("MaSV") + "'");
							query.next();
							String[] row = { result.getString("MaSV"), query.getString("table_sinhvien.Ten"),
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
							String[] dm = { result.getString("MaSV"), query.getString("table_sinhvien.Ten"),
									result.getString("Lp0"), result.getString("Lp1"), result.getString("Lp2"),
									result.getString("Lp3"), result.getString("Lp4"), result.getString("Lp5"),
									result.getString("Lp6"), result.getString("LpE"), TBM, xeploai };
							dm_nhapdiem.addRow(dm);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					dm_nhapdiem.setRowCount(0);
					Connection conn = Connect.getConnect("localhost", "admin", "admin1", "12345");
					try {
						Statement statement = conn.createStatement();
						ResultSet result = statement.executeQuery(
								"SELECT MaSV,\r\n" + "    SUM(CASE WHEN MaMH = 'LP0' THEN Diem ELSE 0 END) AS Lp0,\r\n"
										+ "    SUM(CASE WHEN MaMH = 'LP1' THEN Diem  END) AS Lp1,\r\n"
										+ "    SUM(CASE WHEN MaMH = 'LP2' THEN Diem  END) AS Lp2,\r\n"
										+ "    SUM(CASE WHEN MaMH = 'LP3' THEN Diem  END) AS Lp3,\r\n"
										+ "    SUM(CASE WHEN MaMH = 'LP4' THEN Diem  END) AS Lp4,\r\n"
										+ "    SUM(CASE WHEN MaMH = 'LP5' THEN Diem  END) AS Lp5,\r\n"
										+ "    SUM(CASE WHEN MaMH = 'LP6' THEN Diem  END) AS Lp6,\r\n"
										+ "    SUM(CASE WHEN MaMH = 'LPE' THEN Diem  END) AS LpE\r\n" + "FROM table_diem\r\n"
										+ "GROUP BY MaSV");

						while (result.next()) {
							Statement stt = conn.createStatement();
							ResultSet query = stt.executeQuery("SELECT * FROM table_sinhvien WHERE table_sinhvien.MaSV = '"
									+ result.getString("MaSV") + "' AND table_sinhvien.MaLop ='" + chonLopHoc + "'");
							while (query.next()) {
								String[] row = { result.getString("MaSV"), query.getString("table_sinhvien.Ten"),
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
								String[] dm = { result.getString("MaSV"), query.getString("table_sinhvien.Ten"),
										result.getString("Lp0"), result.getString("Lp1"), result.getString("Lp2"),
										result.getString("Lp3"), result.getString("Lp4"), result.getString("Lp5"),
										result.getString("Lp6"), result.getString("LpE"), TBM, xeploai };
								dm_nhapdiem.addRow(dm);
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