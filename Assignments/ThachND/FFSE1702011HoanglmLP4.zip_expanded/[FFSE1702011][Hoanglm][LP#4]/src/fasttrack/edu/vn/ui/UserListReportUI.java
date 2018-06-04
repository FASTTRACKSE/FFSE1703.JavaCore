package fasttrack.edu.vn.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.sql.*;
import com.mysql.*;

import fasttrack.edu.vn.connection.ConnectSql;

import java.io.*;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class UserListReportUI extends JFrame{
	static Connection conn = ConnectSql.getConnect("localhost", "ffse1702011", "ffse1702011", "123456");
	JButton btnView, btnBack;
	JScrollPane spList = new JScrollPane();
	JTable table = new JTable();
	String[] col = {"ID","Mã KH", "Tên KH", "Địa chỉ", "Mã CT", "Điện thoại","Email", "Quận", "Phường"};
	DefaultTableModel demoTable = new DefaultTableModel(col,0); 

	public UserListReportUI(String title) {
		super(title);
		addControls();
		combobox();
		addEvents();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
		
	public void addControls() {
		this.setResizable(false);
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		
		JPanel pnGeneral = new JPanel();
		pnGeneral.setLayout(new GridBagLayout());
		
		//TITLE USER LIST REPORT
		GridBagConstraints grbcTitle = new GridBagConstraints();
		JPanel pnUserListReport1 = new JPanel();
		JLabel lbUserListReportTop = new JLabel("BÁO CÁO DANH SÁCH KHÁCH HÀNG");
		Font fontUserListReportTop = new Font("RoSoutho", Font.BOLD, 25);
		lbUserListReportTop.setFont(fontUserListReportTop);
		lbUserListReportTop.setForeground(Color.RED);
		pnUserListReport1.add(lbUserListReportTop);
		
		grbcTitle.gridx = 0;
		grbcTitle.gridy = 0;
		grbcTitle.gridwidth = 2;
		pnGeneral.add(pnUserListReport1, grbcTitle);
		
		JPanel pnUserListReport2 = new JPanel();
		JLabel lbUserListReportBottom = new JLabel("THÀNH PHỐ ĐÀ NẴNG");
		Font fontUserListReportBottom = new Font("RoSoutho", Font.BOLD, 25);
		lbUserListReportBottom.setFont(fontUserListReportBottom);
		lbUserListReportBottom.setForeground(Color.RED);
		pnUserListReport2.add(lbUserListReportBottom);
		
		grbcTitle.gridx = 0;
		grbcTitle.gridy = 1;
		grbcTitle.gridwidth = 2;
		pnGeneral.add(pnUserListReport2, grbcTitle);
		
		//GRIDBAGCONSTRAINTS INPUT
		GridBagConstraints grbcInput = new GridBagConstraints();
		
		//DISTRICT
		JPanel pnDistrict = new JPanel();
		JLabel lbDistrict = new JLabel("Quận");
		lbDistrict.setPreferredSize(new Dimension(60, 30));
		Font fontDistrict = new Font("Arial", Font.BOLD, 12);
		lbDistrict.setFont(fontDistrict);
		pnDistrict.add(lbDistrict);
		cbbDistrict.setPreferredSize(new Dimension(200, 30));
		pnDistrict.add(cbbDistrict);
		
		grbcInput.gridx = 0;
		grbcInput.gridy = 2;
		grbcInput.gridwidth = 2;
		grbcInput.insets = new Insets(15, 10, 0, 10);
		pnGeneral.add(pnDistrict, grbcInput);
		
		//WARD
		JPanel pnWard = new JPanel();
		JLabel lbWard = new JLabel("Phường");
		lbWard.setPreferredSize(new Dimension(60, 30));
		Font fontWard = new Font("Arial", Font.BOLD, 12);
		lbWard.setFont(fontWard);
		pnWard.add(lbWard);
		cbbWard.setPreferredSize(new Dimension(200, 30));
		pnWard.add(cbbWard);
		
		grbcInput.gridx = 0;
		grbcInput.gridy = 3;
		pnGeneral.add(pnWard, grbcInput);
		
		//BUTTON
		JPanel pnActionUserListReport = new JPanel();
		btnView = new JButton("Xem");
		pnActionUserListReport.add(btnView);
		btnBack = new JButton("Quay lại");
		pnActionUserListReport.add(btnBack);
		
		grbcInput.gridx = 0;
		grbcInput.gridy = 4;
		pnGeneral.add(pnActionUserListReport, grbcInput);
		
		//DISPLAY
		JPanel pnDisplay = new JPanel();
		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder titleBorder = BorderFactory.createTitledBorder(border, "Hiển thị");
		spList.setBorder(titleBorder);
		table.setModel(demoTable);
		spList.setViewportView(table);
		pnDisplay.add(spList);
		
		grbcInput.gridx = 0;
		grbcInput.gridy = 5;
		pnGeneral.add(pnDisplay, grbcInput);
		
		pnMain.add(pnGeneral);
		
		con.add(pnMain);
		
	}
	
	//EVENT COMBOBOX DISTRICT & WARD
		ActionListener eventCombobox = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				combobox1(cbbDistrict.getSelectedItem().toString());
			}
		};
	
	//Create Combobox Dictrict
		JComboBox cbbDistrict = new JComboBox();
		public void combobox() {
			if (conn != null) {

				String sql = "select * from ffse1702011_district";
				try {
					PreparedStatement ptmt = conn.prepareStatement(sql);
					// Create resultset
					ResultSet rs = ptmt.executeQuery();
					cbbDistrict.addItem("Tất cả");
					while (rs.next()) {
						String district = rs.getString("District_Name");

						cbbDistrict.addItem(district);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null, "Kết nối MYSQL thất bại", "Alert", JOptionPane.WARNING_MESSAGE);
			}
		}
				
		//Create Combobox Ward
		JComboBox cbbWard = new JComboBox();

		public void combobox1(String name) {
			if (conn != null) {

				String sql = "SELECT Ward_Name FROM ffse1702011_district INNER JOIN ffse1702011_ward WHERE ffse1702011_district.ID = ffse1702011_ward.District_ID AND District_Name = ?";

				try {
					PreparedStatement ptmt = conn.prepareStatement(sql);
					ptmt.setString(1, name);
					// create resultset
					ResultSet rs = ptmt.executeQuery();
					Vector items = new Vector();
					//items.add("");
					items.add("Tất cả");
					while (rs.next()) {
						String phuong = rs.getString("Ward_Name");

						items.add(phuong);
					}
					cbbWard.setModel(new DefaultComboBoxModel(items));
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null, "Kết nối MYSQL thất bại", "Alert", JOptionPane.WARNING_MESSAGE);
			}
		}
		
	//VIEW USER INFORMATION FROM DISTRICT & WARD
	ActionListener eventView = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			demoTable.getDataVector().removeAllElements();
			demoTable.fireTableDataChanged();
			view();
		}
	};
	
	public void view() {
		String district = (String) cbbDistrict.getSelectedItem();
		String ward = (String) cbbWard.getSelectedItem();
		try {
			String sql = "select * from ffse1702011_user_information ";
			String sqlWhere = null;
			if(district.equals("Tất cả")) {
				sqlWhere = sql.concat(" ");
			} else if(ward.equals("Tất cả")) {
				sqlWhere = sql.concat("where District = '"+district+"'");
			} else {
				sqlWhere = sql.concat("where Ward = '"+ward+"' AND District = '"+district+"'");
			}
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sqlWhere);
			while(result.next()) {
				String rows[] = new String[9];
				int idInt = result.getInt("ID");
				String idString = Integer.toString(idInt);
				rows[0] = idString;
				rows[1] = result.getString("User_Code");
				rows[2] = result.getString("User_Name");
				rows[3] = result.getString("Address");
				rows[4] = result.getString("Meter_Code");
				rows[5] = result.getString("Phone");
				rows[6] = result.getString("Email");
				rows[7] = result.getString("District");
				rows[8] = result.getString("Ward");
				demoTable.addRow(rows);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addEvents() {
		cbbDistrict.addActionListener(eventCombobox);
		btnView.addActionListener(eventView);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuUI giaodien = new MenuUI("Chương trình quản lý tiền điện");
				giaodien.showWindow();
				dispose();
			}
		});
	}
	
	public void showWindow() {
		this.setSize(600, 750);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
