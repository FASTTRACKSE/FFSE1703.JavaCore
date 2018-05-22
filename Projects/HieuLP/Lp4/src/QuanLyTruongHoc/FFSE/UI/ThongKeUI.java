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

public class ThongKeUI extends JPanel {

	private JComboBox<String> maLopcomnoBox = new JComboBox<>();
	private JComboBox<String> maSVcomnoBox = new JComboBox<>();
	private JComboBox<String> chonNam = new JComboBox<>();
	private JComboBox<String> comBoboxlop = new JComboBox<>();
	private static final long serialVersionUID = 1L;
	private JPanel pnNhapdiem = new JPanel();
	private JPanel pnNhapdiem1 = new JPanel();
	private DefaultTableModel dm_nhapdiem, dm_nhapdiem1;
	private JTable table_nhapdiem, table_nhapdiem1;
	private JScrollPane sc_nhapdiem, sc_nhapdiem1;
	private JScrollPane sp_nhapdiem, sp_nhapdiem1;

	public ThongKeUI() {
		addControls();
		maLopcomnoBox();
		chonNam();
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
		chonNam = new JComboBox<>();
		JLabel xemlop = new JLabel("Chọn năm");
		flow.add(xemlop);
		flow.add(chonNam);
		maLopcomnoBox = new JComboBox<>();
		JLabel chonlop = new JLabel("Chọn lớp");
		flow.add(chonlop);
		flow.add(maLopcomnoBox);
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
		comBoboxlop = new JComboBox<>();
		JLabel xemlop1 = new JLabel("Chọn năm");
		flow1.add(xemlop1);
		flow1.add(comBoboxlop);
		muctimlopseachsv1.add(flow1);
		muctimlopseachsv1.add(sc_nhapdiem1);
		pnNhapdiem1.add(muctimlopseachsv1);
		this.add(pnNhapdiem1);

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

	public void chonNam() {
		chonNam.addItem("Tất cả");
		Connection conn = Connect.getConnect("localhost", "admin", "admin1", "12345");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT DISTINCT NamHoc FROM table_lop");
			while (result.next()) {
				chonNam.addItem(new String(result.getString("NamHoc")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void addEvent() {
	}

}
