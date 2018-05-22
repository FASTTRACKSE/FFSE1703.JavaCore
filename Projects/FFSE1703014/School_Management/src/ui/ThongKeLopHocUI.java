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

import model.DiemSinhVIen;

public class ThongKeLopHocUI extends JPanel {
	final static Connection connection = getConnect("localhost", "ffse1703014", "admin", "123456");
	public String namHoc, maLH, tongSV;
	public JComboBox cbNamHoc = new JComboBox();
	ImageIcon search = new ImageIcon("icons/search.png");
	public JButton btnSort = new JButton("Lọc", search);
	public DefaultTableModel dm = new DefaultTableModel();
	public JTable table = new JTable(dm) {
		public boolean isCellEditable(int row, int column) {
				return false;
		}
	};
	public ThongKeLopHocUI() {
		addControllers();
		addEvents();
		getNamHoc();
	}
	private void getNamHoc() {
		try {
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void addControllers() {
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BorderLayout());
		pnMain.setPreferredSize(new Dimension(800,500));
		JPanel pnSort = new JPanel();
		pnSort.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel pnCBbox = new JPanel();
		pnCBbox.setLayout(new GridLayout(1, 2, 10, 10));
		JPanel pnTable = new JPanel();
		pnTable.setLayout(new BorderLayout());
		
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder tilleBorder = BorderFactory.createTitledBorder(border, "Danh sách sinh viên");
		JScrollPane sc = new JScrollPane(table);
		pnTable.setBorder(tilleBorder);
		pnTable.add(sc, BorderLayout.CENTER);
		dm.addColumn("Lớp học");
		dm.addColumn("Tổng số sinh viên");
		
		btnSort.setPreferredSize(new Dimension(100, 27));
		
		JLabel labelNamHoc = new JLabel("Chọn năm học:");
		
		pnCBbox.add(labelNamHoc);
		pnCBbox.add(cbNamHoc);
		
		pnSort.add(pnCBbox);
		pnSort.add(btnSort);
		
		pnMain.add(pnSort, BorderLayout.NORTH);
		pnMain.add(pnTable, BorderLayout.CENTER);
		this.add(pnMain);
	}
	private void addEvents() {
		btnSort.addActionListener(getRowTable);
	}
	ActionListener getRowTable = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			dm.setRowCount(0);
			String[] row = new String[2];
			namHoc = cbNamHoc.getSelectedItem().toString();
			if (namHoc == "Chọn năm học") {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn năm học!");
			} else {
				try {
					Statement statement = (Statement) connection.createStatement();
					ResultSet result = statement.executeQuery("select * from lophoc where NamHoc = '"+ namHoc +"' order by MaLop ASC");
					while (result.next()) {
						maLH = result.getString("MaLop");
						row[0] = maLH;
						try {
							Statement statement2 = (Statement) connection.createStatement();
							ResultSet result2 = statement2.executeQuery("select count(*) from sinhvien where LopHoc = '"+ maLH +"'");
							while (result2.next()) {
								row[1] = result2.getString("COUNT(*)");
							}
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						dm.addRow(row);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
	};
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
