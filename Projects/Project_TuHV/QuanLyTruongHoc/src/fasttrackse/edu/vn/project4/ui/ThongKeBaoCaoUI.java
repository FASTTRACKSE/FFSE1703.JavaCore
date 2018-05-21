package fasttrackse.edu.vn.project4.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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


import fasttrackse.edu.vn.project4.model.Connect;

public class ThongKeBaoCaoUI extends JPanel {

	private static final long serialVersionUID = 1L;

	private JComboBox<String> namDiem = new JComboBox<>();
	private JComboBox<String> lopDiem = new JComboBox<>();
	private JComboBox<String> namSV = new JComboBox<>();

	private DefaultTableModel dm_ThongkeDiem;
	private JTable tbl_ThongkeDiem;
	private JScrollPane sp_ThongkeDiem;

	private DefaultTableModel dm_ThongkeSV;
	private JTable tbl_ThongkeSV;
	private JScrollPane sp_ThongkeSV;

	private JPanel thongkeDiem = new JPanel();
	private JPanel thongkeSV = new JPanel();

	public ThongKeBaoCaoUI() {
		lop();
		addControls();
		addEvent();
	}

	public void addControls() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JLabel lbl = new JLabel("Thống Kê Báo Cáo");
		Font font = new Font("Arial", Font.BOLD, 24);
		lbl.setFont(font);
		JPanel pnSouth = new JPanel();
		pnSouth.setBackground(Color.blue);
		pnSouth.add(lbl);
		this.add(pnSouth, BorderLayout.SOUTH);
		// Quản lý thống kê điểm

		thongkeDiem.setLayout(new BoxLayout(thongkeDiem, BoxLayout.Y_AXIS));

		JPanel pnMHDiem = new JPanel();
		pnMHDiem.setLayout(new FlowLayout());

		JPanel chon = new JPanel();
		chon.setLayout(new FlowLayout());
		JLabel lblchonNam = new JLabel("Năm học:");
		chon.add(lblchonNam);
		namDiem.addItem("Chọn năm học");
		Connection conn = Connect.getConnect("localhost", "project4", "viettu", "12345");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT DISTINCT nam_hoc FROM quan_ly_lop_hoc");
			while (result.next()) {
				namDiem.addItem(result.getString("nam_hoc"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		chon.add(namDiem);
		pnMHDiem.add(chon);

		JPanel chonLopDiem = new JPanel();
		chonLopDiem.setLayout(new FlowLayout());
		JLabel lblchonLop = new JLabel("Mã lớp học:");
		chonLopDiem.add(lblchonLop);
		chonLopDiem.add(lopDiem);
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
			ResultSet result = statement.executeQuery("SELECT * FROM quan_ly_mon_hoc");
			while (result.next()) {
				dm_ThongkeDiem.addColumn(new String(result.getString("ma_mon_hoc")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dm_ThongkeDiem.addColumn("ĐTB");
		dm_ThongkeDiem.addColumn("Xếp loại");

		try {
			Statement statement = conn.createStatement();
			String sSQLAllStudents = "" + 
					"SELECT quan_ly_sinh_vien.ma_sinh_vien,SUM(CASE WHEN ma_mon_hoc = 'LP0' THEN diem ELSE 0 END) AS LP0,\r\n" + 
					"							   SUM(CASE WHEN ma_mon_hoc = 'LP1' THEN diem ELSE 0 END) AS LP1,\r\n" + 
					"							   SUM(CASE WHEN ma_mon_hoc = 'Lp2' THEN diem ELSE 0 END) AS LP2,\r\n" + 
					"							   SUM(CASE WHEN ma_mon_hoc = 'LP3' THEN diem ELSE 0 END) AS LP3,\r\n" + 
					"							   SUM(CASE WHEN ma_mon_hoc = 'LP4' THEN diem ELSE 0 END) AS LP4,\r\n" + 
					"							   SUM(CASE WHEN ma_mon_hoc = 'LP5' THEN diem ELSE 0 END) AS LP5,\r\n" + 
					"							   SUM(CASE WHEN ma_mon_hoc = 'LP6' THEN diem ELSE 0 END) AS LP6,\r\n" + 
					"							   SUM(CASE WHEN ma_mon_hoc = 'LPE' THEN diem ELSE 0 END) AS LPE " +
					"							FROM quan_ly_sinh_vien INNER JOIN quan_ly_diem ON quan_ly_sinh_vien.ma_sinh_vien = quan_ly_diem.ma_sinh_vien \r\n" + 
					"							GROUP BY ma_sinh_vien";
			
			ResultSet result = statement.executeQuery(sSQLAllStudents);
			while (result.next()) {
				Statement stt = conn.createStatement();
				String sSQL = "SELECT * FROM quan_ly_sinh_vien WHERE quan_ly_sinh_vien.ma_sinh_vien = '" + result.getString("quan_ly_sinh_vien.ma_sinh_vien") + "'";
				ResultSet query = stt.executeQuery(sSQL);
				if (!query.wasNull()) {
				query.next();
				String[] row = { result.getString("quan_ly_sinh_vien.ma_sinh_vien"),query.getString("quan_ly_sinh_vien.ten_sinh_vien"), result.getString("LP0"), result.getString("LP1"),
						result.getString("LP2"), result.getString("LP3"), result.getString("LP4"),
						result.getString("LP5"), result.getString("LP6"), result.getString("LPE") };
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
				    @SuppressWarnings("unused")
					String[] dm = { result.getString("quan_ly_sinh_vien.ma_sinh_vien"),query.getString("quan_ly_sinh_vien.ten_sinh_vien"), result.getString("LP0"), result.getString("LP1"),
							result.getString("LP2"), result.getString("LP3"), result.getString("LP4"),
							result.getString("LP5"), result.getString("LP6"), result.getString("LPE"),TBM,xeploai };
				dm_ThongkeDiem.addRow(dm);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		tbl_ThongkeDiem = new JTable(dm_ThongkeDiem);
		tbl_ThongkeDiem.setLayout(new BorderLayout());
		sp_ThongkeDiem = new JScrollPane(tbl_ThongkeDiem);
		JScrollPane sc_lopMonHoc = new JScrollPane(sp_ThongkeDiem);
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
		namSV.addItem("Chọn năm học");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT DISTINCT nam_hoc FROM quan_ly_lop_hoc");
			while (result.next()) {
				namSV.addItem(result.getString("nam_hoc"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		chonNamSV.add(namSV);
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
					"SELECT *,(SELECT Count(*) FROM quan_ly_sinh_vien WHERE quan_ly_sinh_vien.ma_lop = quan_ly_lop_hoc.ma_lop) as Tong FROM quan_ly_lop_hoc");
			while (result.next()) {
				String[] row = { result.getString("quan_ly_lop_hoc.ma_lop"), result.getString("mo_ta"), result.getString("Tong"),
						result.getString("nam_hoc") };
				dm_ThongkeSV.addRow(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		tbl_ThongkeSV = new JTable(dm_ThongkeSV);
		tbl_ThongkeSV.setLayout(new BorderLayout());
		sp_ThongkeSV = new JScrollPane(tbl_ThongkeSV);
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
		lopDiem.addItem("Tất cả");
		Connection conn = Connect.getConnect("localhost", "project4", "viettu", "12345");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM quan_ly_lop_hoc");
			while (result.next()) {
				lopDiem.addItem(new String(result.getString("ma_lop")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// lấy xong giá trị của JComboBox

	public void addEvent() {
	}

}
