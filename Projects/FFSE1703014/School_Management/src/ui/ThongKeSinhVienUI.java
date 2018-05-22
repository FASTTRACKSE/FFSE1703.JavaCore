package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Driver;

import model.*;

public class ThongKeSinhVienUI extends JPanel {
	final static Connection connection = getConnect("localhost", "ffse1703014", "admin", "123456");
	public String maLop, maSV, tenSV, namHoc, xepLoai;
	public int count = 0;
	public ArrayList<LopHoc> arrLH = new ArrayList<LopHoc>();
	public ArrayList<SinhVien> arrSV = new ArrayList<SinhVien>();
	public ArrayList<DiemSinhVIen> arrDiem = new ArrayList<DiemSinhVIen>();
	public JComboBox cbNamHoc = new JComboBox();
	public JComboBox cbLopHoc = new JComboBox();
	ImageIcon search = new ImageIcon("icons/search.png");
	public JButton btnSort = new JButton("Lọc", search);
	public DefaultTableModel dm = new DefaultTableModel();
	public JTable table = new JTable(dm) {
		public boolean isCellEditable(int row, int column) {
				return false;
		}
	};
	public ThongKeSinhVienUI() {
		addControllers();
		addEvents();
		getNamHoc();
		getLop();
	}

	private void addEvents() {
		btnSort.addActionListener(sort);
		cbNamHoc.addActionListener(cbLop);
	}

	private void addControllers() {
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BorderLayout());
		pnMain.setPreferredSize(new Dimension(800,500));
		JPanel pnSort = new JPanel();
		pnSort.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel pnCbNamHoc = new JPanel();
		pnCbNamHoc.setLayout(new GridLayout(1, 2, 10, 10));
		JPanel pnCbLopHoc = new JPanel();
		pnCbLopHoc.setLayout(new GridLayout(1, 2, 10, 10));
		JPanel pnTable = new JPanel();
		pnTable.setLayout(new BorderLayout());
		
		JLabel labelNamHoc = new JLabel("Chọn năm học: ");
		JLabel labelLopHoc = new JLabel("Chọn lớp học: ");
		
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder tilleBorder = BorderFactory.createTitledBorder(border, "Danh sách sinh viên");
		JScrollPane sc = new JScrollPane(table);
		pnTable.setBorder(tilleBorder);
		pnTable.add(sc, BorderLayout.CENTER);
		
		btnSort.setPreferredSize(new Dimension(100, 27));
		
		pnCbNamHoc.add(labelNamHoc);
		pnCbNamHoc.add(cbNamHoc);
		
		pnCbLopHoc.add(labelLopHoc);
		pnCbLopHoc.add(cbLopHoc);
		
		pnSort.add(pnCbNamHoc);
		pnSort.add(pnCbLopHoc);
		pnSort.add(btnSort);
		
		pnMain.add(pnSort, BorderLayout.NORTH);
		pnMain.add(pnTable, BorderLayout.CENTER);
		
		this.add(pnMain);
	}
	ActionListener sort = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			getColumn();
			getTableSV(count);
		}
	};
ActionListener cbLop = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			getLop();
		}
	};
	public void getNamHoc() {
		cbNamHoc.addItem("Chọn năm học");
		try {
			Statement statement =  connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT DISTINCT `NamHoc` FROM `lophoc` order by NamHoc ASC");
			while (result.next()) {
				cbNamHoc.addItem(result.getString("NamHoc"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void getLop() {
		cbLopHoc.removeAllItems();
		namHoc = cbNamHoc.getSelectedItem().toString();
		cbLopHoc.addItem("Chọn lớp học");
		try {
			Statement statement =  connection.createStatement();
			ResultSet result = statement.executeQuery("select * from lophoc where NamHoc = '"+ namHoc+"' order by MaLop ASC");
			while (result.next()) {
				cbLopHoc.addItem(result.getString("MaLop"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void getColumn() {
		count = 0;
		dm.setColumnCount(0);
		dm.setRowCount(0);
		maLop = cbLopHoc.getSelectedItem().toString();
		dm.addColumn("Mã");
		dm.addColumn("Tên");
		if (maLop == "Chọn lớp học") {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn lớp học!");
		} else {
			try {
				Statement statement =  connection.createStatement();
				ResultSet result = statement.executeQuery("select * from monhoctheolop where MaLH = '"+ maLop + "' order by MaMH ASC");
				while (result.next()) {
					dm.addColumn(result.getString("MaMH"));
					count++;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			dm.addColumn("Điểm TB");
			dm.addColumn("Xếp loại");
			count = count+4;
		}
	}
	public void getTableSV(int count) {
		maLop = cbLopHoc.getSelectedItem().toString();
		arrSV.removeAll(arrSV);
		String[] row = new String[count]; 
		try {
			Statement statement = (Statement) connection.createStatement();
			ResultSet result = statement.executeQuery("select * from sinhvien where LopHoc = '"+ maLop +"' order by MaSV ASC");
			while (result.next()) {
				int i = 0;
				int tong= 0;
				row[0] = result.getString("MaSV");
				row[1] = result.getString("TenSV");
				try {
					Statement statement2 = (Statement) connection.createStatement();
					ResultSet result2 = statement2.executeQuery("select * from diemsinhvien where MaSV = '"+ result.getString("MaSV") +"' order by MaMH ASC");
					while (result2.next()) {
						row[i+2] = result2.getString("Diem");
						i++;
						tong+= Integer.parseInt(result2.getString("Diem"));
					}
					double TB = 0;
					if (i>0) {
						TB = (tong/i);
						System.out.println(TB);
					}
					if (TB == 0) {
						
					} else {
					row[count-2] = String.valueOf(TB);
					if(TB<=4.9) {
			    		row[count-1] = "Kém";
			    	} else if(TB>=5.0 && TB<=6.9) {
			    		row[count-1] = "Trung Bình";
			    	} else if(TB>=7 && TB<=8.4) {
			    		row[count-1] = "Khá";
			    	} else {
			    		row[count-1] = "Giỏi";
			    	}
					}
					dm.addRow(row);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
	}
	public static Connection getConnect(String strServer, String strDatabase, String strUser, String strPwd) {
		Connection conn = null;
		String strConnect = "jdbc:mysql://" + strServer + "/" + strDatabase+"?useUnicode=true&characterEncoding=UTF-8";
		Properties pro = new Properties();
		pro.put("user", strUser);
		pro.put("password", strPwd);
		try {
			Driver driver = new Driver();
			conn = driver.connect(strConnect, pro);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return conn;
	}
}
