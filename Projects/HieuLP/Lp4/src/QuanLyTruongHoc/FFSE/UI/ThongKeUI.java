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
	private JTable table_nhapdiem,table_nhapdiem1;
	private JScrollPane sc_nhapdiem,sc_nhapdiem1;
	private JScrollPane sp_nhapdiem,sp_nhapdiem1;

	public ThongKeUI() {
		addControls();
		maLopcomnoBox();
		chonNam();
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
				dm_nhapdiem.addColumn(new String (result.getString("MaMH")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dm_nhapdiem.addColumn("ĐTB");
		dm_nhapdiem.addColumn("Xếp loại");

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



}
