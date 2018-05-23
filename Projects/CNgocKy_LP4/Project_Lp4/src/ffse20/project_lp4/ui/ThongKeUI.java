package ffse20.project_lp4.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import com.mysql.jdbc.Connection;

import ffse20.project_lp4.connect.Connect;


public class ThongKeUI extends JPanel {
	private static final long serialVersionUID = 1L;

	private JComboBox<String> cboNamHocSV = new JComboBox<>();
	private JComboBox<String> cboLopSV = new JComboBox<>();
	private JComboBox<String> cboNamHocLop = new JComboBox<>();
	private DefaultTableModel dmTK, dmTK1;
	private JScrollPane scDiem, scDiem1;
	private JTable tblDiem, tblDiem1;

	public ThongKeUI() {
		addControls();
		namHoc_Lop(cboNamHocLop);
		addEvents();
		lop();
	}

	public void addControls() {

		this.setLayout(new FlowLayout());
		Border border6 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle6 = BorderFactory.createTitledBorder(border6, "NHẬP THÔNG TIN");
		this.setBorder(borderTitle6);

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JPanel Panel1 = new JPanel();
		JLabel lblNamHocSV = new JLabel("Năm Học-Sinh Viên :");
		JPanel namhocSV = new JPanel();
		namhocSV.add(lblNamHocSV);
//		namhocSV.add(cboNamHocSV);
		
		
		cboNamHocSV.addItem("Chọn năm học");
		Connection conn3 = Connect.getConnect("localhost", "quanlysinhvien", "quanlysinhvien", "12345");
		try {

			Statement statement = conn3.createStatement();
			ResultSet result = statement.executeQuery("SELECT DISTINCT namHoc FROM tabel_lop");
			while (result.next()) {
				cboNamHocSV.addItem(new String(result.getString("namHoc")));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		namhocSV.add(cboNamHocSV);
		Panel1.add(namhocSV);

		JLabel lblLopSV = new JLabel("Mã Lớp-Sinh Viên :");
		JPanel lopSV = new JPanel();
		lopSV.add(lblLopSV);
		lopSV.add(cboLopSV);
		Panel1.add(lopSV);

		JPanel pnTable5 = new JPanel();

		dmTK = new DefaultTableModel();

		dmTK.addColumn("Mã sinh viên");
		dmTK.addColumn("Tên sinh viên");
		Connection conn = Connect.getConnect("localhost", "quanlysinhvien", "quanlysinhvien", "12345");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM table_monhoc");
			while (result.next()) {
				dmTK.addColumn(new String(result.getString("ma_monHoc")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dmTK.addColumn("ĐTB");
		dmTK.addColumn("Xếp loại");

		try {
			
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(
					"SELECT tenSV,\r\n" + "    SUM(CASE WHEN ma_monHoc = 'LP0' THEN diem ELSE 0 END) AS Lp0,\r\n"
							+ "    SUM(CASE WHEN ma_monHoc = 'LP1' THEN diem END) AS Lp1,\r\n"
							+ "    SUM(CASE WHEN ma_monHoc = 'LP2' THEN diem END) AS Lp2,\r\n"
							+ "    SUM(CASE WHEN ma_monHoc = 'LP3' THEN diem END) AS Lp3,\r\n"
							+ "    SUM(CASE WHEN ma_monHoc = 'LP4' THEN diem END) AS Lp4,\r\n"
							+ "    SUM(CASE WHEN ma_monHoc = 'LP5' THEN diem END) AS Lp5,\r\n"
							+ "    SUM(CASE WHEN ma_monHoc = 'LP6' THEN diem END) AS Lp6,\r\n"
							+ "    SUM(CASE WHEN ma_monHoc = 'LPE' THEN diem END) AS LpE\r\n" + "FROM table_diem\r\n"
							+ "GROUP BY tenSV");
			while (result.next()) {
				Statement stt = conn.createStatement();
				ResultSet query = stt.executeQuery("SELECT * FROM tabel_sinhvien WHERE tabel_sinhvien.tenSV = '"+result.getString("tenSV")+"'");
				query.next();
				String[] row = { query.getString("tabel_sinhvien.ma_SV"),query.getString("tabel_sinhvien.tenSV"), result.getString("Lp0"), result.getString("Lp1"),
						result.getString("Lp2"), result.getString("Lp3"), result.getString("Lp4"),
						result.getString("Lp5"), result.getString("Lp6"), result.getString("LpE") };
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
				    String[] dm = { query.getString("tabel_sinhvien.ma_SV"),query.getString("tabel_sinhvien.tenSV"), result.getString("Lp0"), result.getString("Lp1"),
							result.getString("Lp2"), result.getString("Lp3"), result.getString("Lp4"),
							result.getString("Lp5"), result.getString("Lp6"), result.getString("LpE"),TBM,xeploai };
				    dmTK.addRow(dm);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		tblDiem = new JTable(dmTK);
		scDiem = new JScrollPane(tblDiem);
		JScrollPane VT5 = new JScrollPane(scDiem, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		VT5.setPreferredSize(new Dimension(1300, 170));
		pnTable5.add(VT5, BorderLayout.CENTER);

		Border border7 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle7 = BorderFactory.createTitledBorder(border7, "Danh sách");
		pnTable5.setBorder(borderTitle7);
		Panel1.add(pnTable5);
		this.add(Panel1);

		JPanel Panel2 = new JPanel();
		JLabel lblNamHocLp = new JLabel("Năm Học-Lớp :");
		JPanel namhocLp = new JPanel();
		namhocLp.add(lblNamHocLp);
		namhocLp.add(cboNamHocLop);
		Panel2.add(namhocLp);

		JPanel pnTable6 = new JPanel();

		dmTK1 = new DefaultTableModel();

		dmTK1.addColumn("Mã Lớp Học");
		dmTK1.addColumn("Tên Lớp Học");
		dmTK1.addColumn("Số Lượng Sinh Viên");
		dmTK1.addColumn("Năm Học");

		Connection con3 = Connect.getConnect("localhost", "quanlysinhvien", "quanlysinhvien", "12345");
		try {
			Statement statement = con3.createStatement();
			ResultSet result = statement.executeQuery("SELECT *,(SELECT Count(*) FROM tabel_sinhvien WHERE tabel_sinhvien.maLop = tabel_lop.maLop) AS Tong FROM `tabel_lop`");
			while (result.next()) {
				String[] row = { result.getString("maLop"), result.getString("tenLop"), result.getString("namHoc"), result.getString("Tong") };
				dmTK1.addRow(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}


		tblDiem1 = new JTable(dmTK1);
		scDiem1 = new JScrollPane(tblDiem1);
		JScrollPane VT6 = new JScrollPane(scDiem1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		VT6.setPreferredSize(new Dimension(1300, 170));
		pnTable6.add(VT6, BorderLayout.CENTER);

		Border border8 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle8 = BorderFactory.createTitledBorder(border8, "Danh sách");
		pnTable6.setBorder(borderTitle8);
		Panel2.add(pnTable6);
		this.add(Panel2);
	}

	public void namHoc_Lop(JComboBox<String> x) {
		x.addItem("Chọn năm học");
		Connection conn = Connect.getConnect("localhost", "quanlysinhvien", "quanlysinhvien", "12345");
		try {

			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT DISTINCT namHoc FROM tabel_lop");
			while (result.next()) {
				cboNamHocLop.addItem(new String(result.getString("namHoc")));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void lop() {
		cboLopSV.addItem("Tất cả");
		Connection conn = Connect.getConnect("localhost", "quanlysinhvien", "quanlysinhvien", "12345");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT tabel_lop.maLop FROM `tabel_lop`");
			while (result.next()) {
				cboLopSV.addItem(new String(result.getString("maLop")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addEvents() {
		cboNamHocLop.addActionListener(eventChooseClass);
		cboNamHocSV.addActionListener(eventChooseClass1);
		cboLopSV.addActionListener(eventChooseLopDiem);

	}
	ActionListener eventChooseClass = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String chonLop = (String) cboNamHocLop.getSelectedItem();
			dmTK1.setRowCount(0);
			Connection con3 = Connect.getConnect("localhost", "quanlysinhvien", "quanlysinhvien", "12345");
				try {
					Statement statement = con3.createStatement();
					ResultSet result = statement.executeQuery("SELECT *,(SELECT Count(*) FROM tabel_sinhvien WHERE tabel_sinhvien.maLop = tabel_lop.maLop) AS Tong FROM `tabel_lop`");
					while (result.next()) {
						if (chonLop == "Chọn năm học") {
						String[] row = { result.getString("maLop"), result.getString("tenLop"), result.getString("namHoc"), result.getString("Tong") };
						dmTK1.addRow(row);
						} else if(chonLop.equals(result.getString("namHoc"))) {
							String[] row = { result.getString("maLop"), result.getString("tenLop"), result.getString("namHoc"), result.getString("Tong") };
							dmTK1.addRow(row);
							}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			
			
		}
	};

		ActionListener eventChooseClass1 = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String chonNamHoc = (String) cboNamHocSV.getSelectedItem();
				cboLopSV.removeAllItems();
				if (chonNamHoc.equals("Chọn năm học")) {
					cboLopSV.addItem("Tất cả");
					Connection conn = Connect.getConnect("localhost", "quanlysinhvien", "quanlysinhvien", "12345");
					try {
						Statement statement = conn.createStatement();
						ResultSet result = statement.executeQuery("SELECT * FROM tabel_lop");
						while (result.next()) {
							cboLopSV.addItem(new String(result.getString("maLop")));
						}
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					Connection conn = Connect.getConnect("localhost", "quanlysinhvien", "quanlysinhvien", "12345");
					try {
						Statement statement = conn.createStatement();
						ResultSet result = statement
								.executeQuery("SELECT * FROM tabel_lop WHERE namHoc ='" + chonNamHoc + "'");
						while (result.next()) {
							cboLopSV.addItem(new String(result.getString("maLop")));
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
				int x = cboLopSV.getSelectedIndex();
				if (x >= 0) {
					String chonLopHoc = (String) cboLopSV.getSelectedItem();
					if (chonLopHoc.equals("Tất cả")) {
						dmTK.setRowCount(0);
						Connection conn = Connect.getConnect("localhost", "quanlysinhvien", "quanlysinhvien", "12345");
						try {
							Statement statement = conn.createStatement();
							ResultSet result = statement.executeQuery(
									"SELECT tenSV,\r\n" + "    SUM(CASE WHEN ma_monHoc = 'LP0' THEN diem ELSE 0 END) AS Lp0,\r\n"
											+ "    SUM(CASE WHEN ma_monHoc = 'LP1' THEN diem END) AS Lp1,\r\n"
											+ "    SUM(CASE WHEN ma_monHoc = 'LP2' THEN diem END) AS Lp2,\r\n"
											+ "    SUM(CASE WHEN ma_monHoc = 'LP3' THEN diem END) AS Lp3,\r\n"
											+ "    SUM(CASE WHEN ma_monHoc = 'LP4' THEN diem END) AS Lp4,\r\n"
											+ "    SUM(CASE WHEN ma_monHoc = 'LP5' THEN diem END) AS Lp5,\r\n"
											+ "    SUM(CASE WHEN ma_monHoc = 'LP6' THEN diem END) AS Lp6,\r\n"
											+ "    SUM(CASE WHEN ma_monHoc = 'LPE' THEN diem END) AS LpE\r\n" + "FROM table_diem\r\n"
											+ "GROUP BY tenSV");
							while (result.next()) {
								Statement stt = conn.createStatement();
								ResultSet query = stt.executeQuery("SELECT * FROM tabel_sinhvien WHERE tabel_sinhvien.tenSV = '"+result.getString("tenSV")+"'");
								query.next();
								String[] row = { query.getString("tabel_sinhvien.ma_SV"),query.getString("tabel_sinhvien.tenSV"), result.getString("Lp0"), result.getString("Lp1"),
										result.getString("Lp2"), result.getString("Lp3"), result.getString("Lp4"),
										result.getString("Lp5"), result.getString("Lp6"), result.getString("LpE") };
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
								    String[] dm = { query.getString("tabel_sinhvien.ma_SV"),query.getString("tabel_sinhvien.tenSV"), result.getString("Lp0"), result.getString("Lp1"),
											result.getString("Lp2"), result.getString("Lp3"), result.getString("Lp4"),
											result.getString("Lp5"), result.getString("Lp6"), result.getString("LpE"),TBM,xeploai };
								    dmTK.addRow(dm);
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					} else {
						dmTK.setRowCount(0);
						Connection conn = Connect.getConnect("localhost", "quanlysinhvien", "quanlysinhvien", "12345");
						try {
							Statement statement = conn.createStatement();
							ResultSet result = statement.executeQuery(
									"SELECT tenSV,\r\n" + "    SUM(CASE WHEN ma_monHoc = 'LP0' THEN diem ELSE 0 END) AS Lp0,\r\n"
											+ "    SUM(CASE WHEN ma_monHoc = 'LP1' THEN diem END) AS Lp1,\r\n"
											+ "    SUM(CASE WHEN ma_monHoc = 'LP2' THEN diem END) AS Lp2,\r\n"
											+ "    SUM(CASE WHEN ma_monHoc = 'LP3' THEN diem END) AS Lp3,\r\n"
											+ "    SUM(CASE WHEN ma_monHoc = 'LP4' THEN diem END) AS Lp4,\r\n"
											+ "    SUM(CASE WHEN ma_monHoc = 'LP5' THEN diem END) AS Lp5,\r\n"
											+ "    SUM(CASE WHEN ma_monHoc = 'LP6' THEN diem END) AS Lp6,\r\n"
											+ "    SUM(CASE WHEN ma_monHoc = 'LPE' THEN diem END) AS LpE\r\n" + "FROM table_diem\r\n"
											+ "GROUP BY tenSV");

							while (result.next()) {
								Statement stt = conn.createStatement();
								ResultSet query = stt.executeQuery("SELECT * FROM tabel_sinhvien WHERE tabel_sinhvien.tenSV = '"
										+ result.getString("tenSV") + "' AND tabel_sinhvien.maLop ='" + chonLopHoc + "'");
								while (query.next()) {
									String[] row = { query.getString("tabel_sinhvien.ma_SV"),query.getString("tabel_sinhvien.tenSV"), result.getString("Lp0"), result.getString("Lp1"),
											result.getString("Lp2"), result.getString("Lp3"), result.getString("Lp4"),
											result.getString("Lp5"), result.getString("Lp6"), result.getString("LpE") };
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
								    String[] dm = { query.getString("tabel_sinhvien.ma_SV"),query.getString("tabel_sinhvien.tenSV"), result.getString("Lp0"), result.getString("Lp1"),
											result.getString("Lp2"), result.getString("Lp3"), result.getString("Lp4"),
											result.getString("Lp5"), result.getString("Lp6"), result.getString("LpE"),TBM,xeploai };
								    dmTK.addRow(dm);
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
