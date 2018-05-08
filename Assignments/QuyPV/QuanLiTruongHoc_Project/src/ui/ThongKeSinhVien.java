package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;

import connector.GetConnect;

public class ThongKeSinhVien extends JPanel {
	//final Connection conn= GetConnect.getConnect("localhost", "Quan_li_truong_hoc", "admin", "123456");
	public ThongKeSinhVien() {
		addControls();
		addEvents();
	}
	
	private void addControls() {
		JPanel boxQuanLiSinhVien = new JPanel();
		boxQuanLiSinhVien.setLayout(new BoxLayout(boxQuanLiSinhVien, BoxLayout.Y_AXIS));
		Font font = new Font("Arial", Font.BOLD, 15);
		Border borderThongKe = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitleThongKe = BorderFactory.createTitledBorder(borderThongKe,"Báo cáo sinh viên",TitledBorder.CENTER, 
				TitledBorder.DEFAULT_POSITION);
		borderTitleThongKe.setTitleFont(borderTitleThongKe.getTitleFont().deriveFont(Font.ITALIC,20));
		borderTitleThongKe.setTitleColor(Color.RED);
		boxQuanLiSinhVien.setBorder(borderTitleThongKe);
		JPanel phanTimKiem = new JPanel();
		phanTimKiem.setLayout(new FlowLayout(FlowLayout.RIGHT));
		phanTimKiem.setPreferredSize(new Dimension(0, 1));
		JLabel namHoc = new JLabel("Năm học:");
		namHoc.setFont(font);
		namHoc.setPreferredSize(new Dimension(90, 70));
		JComboBox cboNamHoc = new JComboBox<>();
		cboNamHoc.addItem("Chọn năm học");
		cboNamHoc.setPreferredSize(new Dimension(120, 30));
		JLabel maLop = new JLabel("Mã lớp:");
		maLop.setFont(font);
		maLop.setPreferredSize(new Dimension(90, 70));
		JComboBox cboMaLop = new JComboBox<>();
		cboMaLop.addItem("Chọn Mã lớp");
		cboMaLop.setPreferredSize(new Dimension(120, 30));
		JPanel phanHienThi = new JPanel();
		phanHienThi.setLayout(new BoxLayout(phanHienThi, BoxLayout.Y_AXIS));
		phanHienThi.setPreferredSize(new Dimension(0, 500));
		DefaultTableModel dm = new DefaultTableModel();
		dm.addColumn("Mã sinh viên");
		dm.addColumn("Tên sinh viên");
		dm.addColumn("Năm học");
		dm.addColumn("Mã Lớp");
		dm.addColumn("Môn");
		dm.addColumn("Môn");
		dm.addColumn("Môn");
		dm.addColumn("Môn");
		dm.addColumn("Môn");
		JTable tbSinhVien = new JTable(dm);
		//dm.addRow(new String[] {"FFSE1703", "Lập trình", "2018", "20"});
		JScrollPane sc = new JScrollPane(tbSinhVien);
		JPanel phanNut = new JPanel();
		phanNut.setLayout(new FlowLayout(FlowLayout.RIGHT));
		JButton btnThoat = new JButton("Thoát");
		btnThoat.setPreferredSize(new Dimension(100, 30));
		
		
		phanTimKiem.add(namHoc);
		phanTimKiem.add(cboNamHoc);
		phanTimKiem.add(Box.createRigidArea(new Dimension(50, 0)));
		phanTimKiem.add(maLop);
		phanTimKiem.add(cboMaLop);
		phanTimKiem.add(Box.createRigidArea(new Dimension(50, 0)));
		
		phanHienThi.add(sc);
		
		phanNut.add(btnThoat);
		phanNut.add(Box.createRigidArea(new Dimension(100, 0)));
		
		boxQuanLiSinhVien.add(phanTimKiem);
		boxQuanLiSinhVien.add(phanHienThi);
		boxQuanLiSinhVien.add(Box.createRigidArea(new Dimension(0, 50)));
		boxQuanLiSinhVien.add(phanNut);
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(boxQuanLiSinhVien);
	}
	
	private void addEvents() {}
}
