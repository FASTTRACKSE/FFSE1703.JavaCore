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
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;

import connector.GetConnect;

public class ThongKeLopHoc extends JPanel {
	//final Connection conn= GetConnect.getConnect("localhost", "Quan_li_truong_hoc", "admin", "123456");
	public ThongKeLopHoc() {
		addControls();
		addEvents();
	} 
	
	private void addControls() {
		JPanel boxThongKeLopHoc = new JPanel();
		boxThongKeLopHoc.setLayout(new BoxLayout(boxThongKeLopHoc, BoxLayout.Y_AXIS));
		Font font = new Font("Arial", Font.BOLD, 15);
		Border borderThongKe = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitleThongKe = BorderFactory.createTitledBorder(borderThongKe,"Báo cáo lớp học",TitledBorder.CENTER, 
				TitledBorder.DEFAULT_POSITION);
		borderTitleThongKe.setTitleFont(borderTitleThongKe.getTitleFont().deriveFont(Font.ITALIC,20));
		borderTitleThongKe.setTitleColor(Color.RED);
		boxThongKeLopHoc.setBorder(borderTitleThongKe);
		JPanel phanTimKiem = new JPanel();
		phanTimKiem.setLayout(new FlowLayout(FlowLayout.RIGHT));
		phanTimKiem.setPreferredSize(new Dimension(0, 1));
		JLabel namHoc = new JLabel("Năm Học:");
		namHoc.setFont(font);
		namHoc.setPreferredSize(new Dimension(90, 70));
		JComboBox cboNamHoc = new JComboBox<>();
		cboNamHoc.addItem("Chọn năm học");
		cboNamHoc.setPreferredSize(new Dimension(120, 30));
		JPanel phanHienThi = new JPanel();
		phanHienThi.setLayout(new BoxLayout(phanHienThi, BoxLayout.Y_AXIS));
		phanHienThi.setPreferredSize(new Dimension(0, 500));
		DefaultTableModel dm = new DefaultTableModel();
		dm.addColumn("Mã lớp");
		dm.addColumn("Tên lớp");
		dm.addColumn("Năm học");
		dm.addColumn("Số lượng sinh viên");
		JTable tbLop = new JTable(dm);
		dm.addRow(new String[] {"FFSE1703", "Lập trình", "2018", "20"});
		JScrollPane sc = new JScrollPane(tbLop);
		JPanel phanNut = new JPanel();
		phanNut.setLayout(new FlowLayout(FlowLayout.RIGHT));
		JButton btnThoat = new JButton("Thoát");
		btnThoat.setPreferredSize(new Dimension(100, 30));
		
		
		phanTimKiem.add(namHoc);
		phanTimKiem.add(cboNamHoc);
		phanTimKiem.add(Box.createRigidArea(new Dimension(100, 0)));

		phanHienThi.add(sc);
		
		phanNut.add(btnThoat);
		phanNut.add(Box.createRigidArea(new Dimension(100, 0)));
		
		boxThongKeLopHoc.add(phanTimKiem);
		boxThongKeLopHoc.add(phanHienThi);
		boxThongKeLopHoc.add(Box.createRigidArea(new Dimension(0, 50)));
		boxThongKeLopHoc.add(phanNut);
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(boxThongKeLopHoc);
	}
	
	private void addEvents() {
		
	}
}
