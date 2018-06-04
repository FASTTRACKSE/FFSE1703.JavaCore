package fasttrack.edu.vn.ui;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.NumberFormat;

import com.mysql.*;
import java.io.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.Thread.State;
import java.util.Locale;
import java.util.Vector;
import fasttrack.edu.vn.model.*;
import fasttrack.edu.vn.connection.ConnectSql;
import fasttrack.edu.vn.ui.*;
public class ViewUserUI extends JFrame {
	static Connection conn = ConnectSql.getConnect("localhost", "ffse1702011", "ffse1702011", "123456");
	private String id;
	JButton btnView, btnLogOut;
	JScrollPane spList = new JScrollPane();
	JTable table = new JTable();
	String[] col = {"ID","Mã KH", "Tên KH", "Phường", "Quận", "Mã CT", "Chu kì tháng", "Chu kì năm", "Chỉ số CT", "Tiền điện"};
	DefaultTableModel demoTable = new DefaultTableModel(col,0); 
	String[] month = {" ","1","2","3","4","5","6","7","8","9","10","11","12"};
	JComboBox cbbMonth = new JComboBox(month);
	String[] year = {"2018","2019","2020","2021","2022","2023","2024","2025","2026","2027","2028","2029","2030"};
	JComboBox cbbYear = new JComboBox(year);
	public ViewUserUI(String id) {
		super();
		this.id = id;
		addControls();
		addEvents();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void addControls() {
		this.setResizable(false);
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		String sql = "SELECT * FROM ffse1702011_user_information WHERE Email = '"+this.id+"'";
		Statement statement;
		try {
			statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			if(result.next()) {
				JPanel pnGeneral = new JPanel();
				pnGeneral.setLayout(new GridBagLayout());
				
				//TITLE USER MANAGEMENT
				GridBagConstraints grbcTitle = new GridBagConstraints();
				JPanel pnViewUser = new JPanel();
				JLabel lbViewUser = new JLabel("THÔNG TIN KHÁCH HÀNG");
				Font fontViewUser = new Font("RoSoutho", Font.BOLD, 40);
				lbViewUser.setForeground(Color.RED);
				lbViewUser.setFont(fontViewUser);
				pnViewUser.add(lbViewUser);
				
				grbcTitle.gridx = 0;
				grbcTitle.gridy = 0;
				grbcTitle.gridwidth = 2;
				pnGeneral.add(pnViewUser, grbcTitle);

				//GRIDBAGCONSTRAINTS INPUT
				GridBagConstraints grbcInput = new GridBagConstraints();
				
				//User Code
				JPanel pnUserCode = new JPanel();
				JLabel lbUserCode = new JLabel("Mã KH");
				lbUserCode.setPreferredSize(new Dimension(60, 30));
				Font fontUserCode = new Font("Arial", Font.BOLD, 12);
				lbUserCode.setFont(fontUserCode);
				JLabel lbshowUserCode = new JLabel(result.getString(2));
				lbshowUserCode.setPreferredSize(new Dimension(230, 30));
				pnUserCode.add(lbUserCode);
				pnUserCode.add(lbshowUserCode);
				
				grbcInput.gridx = 0;
				grbcInput.gridy = 2;
				pnGeneral.add(pnUserCode, grbcInput);
				
				//User Name
				JPanel pnUserName = new JPanel();
				JLabel lbUserName = new JLabel("Tên KH");
				lbUserName.setPreferredSize(new Dimension(60, 30));
				Font fontUserName = new Font("Arial", Font.BOLD, 12);
				lbUserName.setFont(fontUserName);
				JLabel lbshowUserName = new JLabel(result.getString(3));
				lbshowUserName.setPreferredSize(new Dimension(200, 30));
				pnUserName.add(lbUserName);
				pnUserName.add(lbshowUserName);
				
				grbcInput.gridx = 1;
				grbcInput.gridy = 2;
				pnGeneral.add(pnUserName, grbcInput);
				
				//Address
				JPanel pnAddress = new JPanel();
				JLabel lbAddress = new JLabel("Địa chỉ");
				lbAddress.setPreferredSize(new Dimension(60, 30));
				Font fontAddress = new Font("Arial", Font.BOLD, 12);
				lbAddress.setFont(fontAddress);
				JLabel lbshowAddress= new JLabel(result.getString(4));
				lbshowAddress.setPreferredSize(new Dimension(230, 30));
				pnAddress.add(lbAddress);
				pnAddress.add(lbshowAddress);
				
				grbcInput.gridx = 0;
				grbcInput.gridy = 3;
				pnGeneral.add(pnAddress, grbcInput);
				
				//Meter Code
				JPanel pnMeterCode = new JPanel();
				JLabel lbMeterCode  = new JLabel("Mã CT");
				lbMeterCode .setPreferredSize(new Dimension(60, 30));
				Font fontMeterCode  = new Font("Arial", Font.BOLD, 12);
				lbMeterCode.setFont(fontMeterCode);
				JLabel lbshowMeterCode = new JLabel(result.getString(6));
				lbshowMeterCode.setPreferredSize(new Dimension(200, 30));
				pnMeterCode.add(lbMeterCode);
				pnMeterCode.add(lbshowMeterCode);
				
				grbcInput.gridx = 1;
				grbcInput.gridy = 3;
				pnGeneral.add(pnMeterCode, grbcInput);
				
				//District
				JPanel pnDistrict = new JPanel();
				JLabel lbDistrict = new JLabel("Quận");
				lbDistrict.setPreferredSize(new Dimension(60, 30));
				Font fontDistrict = new Font("Arial", Font.BOLD, 12);
				lbDistrict.setFont(fontDistrict);
				JLabel lbshowDistrict = new JLabel(result.getString(7));
				lbshowDistrict.setPreferredSize(new Dimension(230, 30));
				pnDistrict.add(lbDistrict);		
				pnDistrict.add(lbshowDistrict);
				
				grbcInput.gridx = 0;
				grbcInput.gridy = 4;
				pnGeneral.add(pnDistrict, grbcInput);
				
				//Ward
				JPanel pnWard = new JPanel();
				JLabel lbWard = new JLabel("Phường");
				lbWard.setPreferredSize(new Dimension(60, 30));
				Font fontWard = new Font("Arial", Font.BOLD, 12);
				lbWard.setFont(fontWard);
				JLabel lbshowWard = new JLabel(result.getString(8));
				lbshowWard.setPreferredSize(new Dimension(200, 30));
				pnWard.add(lbWard);
				pnWard.add(lbshowWard);
				
				grbcInput.gridx = 1;
				grbcInput.gridy = 4;
				pnGeneral.add(pnWard, grbcInput);
				
				//Telephone Number
				JPanel pnPhone = new JPanel();
				JLabel lbPhone = new JLabel("Điện thoại");
				lbPhone.setPreferredSize(new Dimension(60, 30));
				Font fontPhone = new Font("Arial", Font.BOLD, 12);
				lbPhone.setFont(fontPhone);
				JLabel lbshowPhone = new JLabel(result.getString(5));
				lbshowPhone.setPreferredSize(new Dimension(230, 30));
				pnPhone.add(lbPhone);
				pnPhone.add(lbshowPhone);
				
				grbcInput.gridx = 0;
				grbcInput.gridy = 5;
				pnGeneral.add(pnPhone, grbcInput);
				
				//Email
				JPanel pnMail = new JPanel();
				JLabel lbMail = new JLabel("Email");
				lbMail.setPreferredSize(new Dimension(60, 30));
				Font fontMail = new Font("Arial", Font.BOLD, 12);
				lbMail.setFont(fontMail);
				JLabel lbshowEmail = new JLabel(result.getString(9));
				lbshowEmail.setPreferredSize(new Dimension(200, 30));
				pnMail.add(lbMail);
				pnMail.add(lbshowEmail);
				
				grbcInput.gridx = 1;
				grbcInput.gridy = 5;
				pnGeneral.add(pnMail, grbcInput);
				
				//Combobox Month
				JPanel pnMonth = new JPanel();
				JLabel lbMonth = new JLabel("Tháng");
				lbMonth.setPreferredSize(new Dimension(60, 30));
				Font fontMonth = new Font("Arial", Font.BOLD, 12);
				lbMonth.setFont(fontMonth);
				pnMonth.add(lbMonth);
				cbbMonth.setPreferredSize(new Dimension(100, 30));
				pnMonth.add(cbbMonth);
				
				grbcInput.gridx = 0;
				grbcInput.gridy = 6;
				pnGeneral.add(pnMonth, grbcInput);
				
				//Combobox Year
				JPanel pnYear = new JPanel();
				JLabel lbYear = new JLabel("Năm");
				lbYear.setPreferredSize(new Dimension(60, 30));
				Font fontYear = new Font("Arial", Font.BOLD, 12);
				lbYear.setFont(fontYear);
				pnYear.add(lbYear);
				cbbYear.setPreferredSize(new Dimension(100, 30));
				pnYear.add(cbbYear);

				grbcInput.gridx = 1;
				grbcInput.gridy = 6;
				pnGeneral.add(pnYear, grbcInput);
				
				//BUTTON
				JPanel pnActionViewUser = new JPanel();
				btnView = new JButton("Xem");
				pnActionViewUser.add(btnView);
				btnLogOut = new JButton("Đăng xuất");
				pnActionViewUser.add(btnLogOut);
				
				grbcInput.gridx = 0;
				grbcInput.gridy = 7;
				grbcInput.gridwidth = 2;
				pnGeneral.add(pnActionViewUser, grbcInput);
				
				
				//DISPLAY
				JPanel pnDisplay = new JPanel();
				Border border = BorderFactory.createLineBorder(Color.RED);
				TitledBorder titleBorder = BorderFactory.createTitledBorder(border, "Hiển thị");
				spList.setBorder(titleBorder);
				table.setModel(demoTable);
				spList.setViewportView(table);
				pnDisplay.add(spList);
				
				grbcInput.gridx = 0;
				grbcInput.gridy = 8;
				pnGeneral.add(pnDisplay, grbcInput);
				
				pnMain.add(pnGeneral);
				con.add(pnMain);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	ActionListener eventView = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			demoTable.getDataVector().removeAllElements();
			demoTable.fireTableDataChanged();
			view();
		}
	};
	
	public void view() {
		String chkMonth = (String) cbbMonth.getSelectedItem();
		String chkYear = (String) cbbYear.getSelectedItem();
		if(chkMonth.equals(" ")) {
			String sql = "SELECT * FROM ffse1702011_user_information INNER JOIN ffse1702011_bill_information WHERE ffse1702011_user_information.Meter_Code = ffse1702011_bill_information.Meter_Code AND ffse1702011_user_information.Email = '"+this.id+"' AND ffse1702011_bill_information.Cycle_Year = '"+chkYear+"' ";
			try {
				Statement statement = conn.createStatement();
				ResultSet result = statement.executeQuery(sql);
				while(result.next()) {
					String rows[] = new String[10];
					rows[0] = result.getString(1);
					rows[1] = result.getString(2);
					rows[2] = result.getString(3);
					rows[3] = result.getString(8);
					rows[4] = result.getString(7);
					rows[5] = result.getString(6);
					rows[6] = result.getString(14);
					rows[7] = result.getString(15);
					rows[8] = result.getString(16);
					
					//Charged
					String id = result.getString(11);
					String price = null;
					try {
						Statement stmMeter = conn.createStatement();
						String sqlMeter = "SELECT Meter_Number FROM `ffse1702011_bill_information`\n" + 
								"WHERE Meter_Code = '"+rows[5]+"' and ID < " +id + 
								" ORDER BY ID DESC\n" + 
								" LIMIT 1";
						ResultSet rsMeter = stmMeter.executeQuery(sqlMeter);	
						int p1;
						if(!rsMeter.next()) {
							p1 = 0;
						} else {
							p1 = rsMeter.getInt(1);
						}
						String p2String = rows[8];
						int p2 = Integer.parseInt(p2String);
						int p = p2 - p1;
						int prc = 0;
						if(p <= 100) {
							prc = p * 1600;
						} else if(p <= 200) {
							prc = p *1858;
						} else if(p <= 300) {
							prc = p * 2340;
						} else if(p <= 400) {
							prc = p * 2615;
						}
						Locale loc =Locale.getDefault();  
						NumberFormat nf =NumberFormat.  
						getCurrencyInstance(loc);
						price = nf.format(prc);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					//----//
					rows[9] = price;
					demoTable.addRow(rows);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			String sql = "SELECT * FROM ffse1702011_user_information INNER JOIN ffse1702011_bill_information WHERE ffse1702011_user_information.Meter_Code = ffse1702011_bill_information.Meter_Code AND ffse1702011_user_information.Email = '"+this.id+"' AND ffse1702011_bill_information.Cycle_Month = '"+chkMonth+"' AND ffse1702011_bill_information.Cycle_Year = '"+chkYear+"' ";
			try {
				Statement statement = conn.createStatement();
				ResultSet result = statement.executeQuery(sql);
				while(result.next()) {
					String rows[] = new String[10];
					rows[0] = result.getString(1);
					rows[1] = result.getString(2);
					rows[2] = result.getString(3);
					rows[3] = result.getString(8);
					rows[4] = result.getString(7);
					rows[5] = result.getString(6);
					rows[6] = result.getString(14);
					rows[7] = result.getString(15);
					rows[8] = result.getString(16);
					
					//Charged
					String id = result.getString(11);
					String price = null;
					try {
						Statement stmMeter = conn.createStatement();
						String sqlMeter = "SELECT Meter_Number FROM `ffse1702011_bill_information`\n" + 
								"WHERE Meter_Code = '"+rows[5]+"' and ID < " +id + 
								" ORDER BY ID DESC\n" + 
								" LIMIT 1";
						ResultSet rsMeter = stmMeter.executeQuery(sqlMeter);	
						int p1;
						if(!rsMeter.next()) {
							p1 = 0;
						} else {
							p1 = rsMeter.getInt(1);
						}
						String p2String = rows[8];
						int p2 = Integer.parseInt(p2String);
						int p = p2 - p1;
						int prc = 0;
						if(p <= 100) {
							prc = p * 1600;
						} else if(p <= 200) {
							prc = p *1858;
						} else if(p <= 300) {
							prc = p * 2340;
						} else if(p <= 400) {
							prc = p * 2615;
						}
						Locale loc =Locale.getDefault();  
						NumberFormat nf =NumberFormat.  
						getCurrencyInstance(loc);
						price = nf.format(prc);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					//----//
					rows[9] = price;
					demoTable.addRow(rows);
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public void addEvents() {
		btnView.addActionListener(eventView);
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginUI giaodien = new LoginUI("Chương trình quản lý tiền điện");
				giaodien.showWindow();
				dispose();
			}
		});
	}
	
	public void showWindow() {
		this.setSize(700,800);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
