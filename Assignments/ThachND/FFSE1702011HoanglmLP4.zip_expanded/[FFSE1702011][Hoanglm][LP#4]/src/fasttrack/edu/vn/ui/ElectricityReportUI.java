package fasttrack.edu.vn.ui;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Vector;

import com.mysql.*;

import fasttrack.edu.vn.connection.ConnectSql;

import java.io.*;
import java.awt.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
public class ElectricityReportUI extends JFrame{
	static Connection conn = ConnectSql.getConnect("localhost", "ffse1702011", "ffse1702011", "123456");
	//DECLARE
	JPanel pnDistrict, pnWard, pnUserCode, pnUserName, pnAddress, pnInYear, pnFromDate, pnToDate, pnCycle;
	JTextField txtUserCode = new JTextField(8);
	JTextField txtUserName = new JTextField(11);
	JTextField txtAddress = new JTextField(11);
	JButton btnFind, btnView, btnBack;
	JRadioButton rbtnAllUser = new JRadioButton("Tất cả khách hàng");
	JRadioButton rbtnUserRegion = new JRadioButton("Khách hàng theo khu vực");
	JRadioButton rbtnSpecificUser = new JRadioButton("Khách hàng cụ thể");
	JRadioButton rbtnByYear = new JRadioButton("Theo năm");
	JRadioButton rbtnByTime = new JRadioButton("Theo khoảng thời gian");
	JRadioButton rbtnByCycle = new JRadioButton("Theo chu kì");
	String[] byYear = {"2018","2019","2020","2021","2022","2023","2024","2025","2026","2027","2028","2029","2030"};
	JComboBox cbbByYear = new JComboBox(byYear);
	String[] month = {"1","2","3","4","5","6","7","8","9","10","11","12"};
	JComboBox cbbMonth = new JComboBox(month);
	String[] year = {"2018","2019","2020","2021","2022","2023","2024","2025","2026","2027","2028","2029","2030"};
	JComboBox cbbYear = new JComboBox(year);
	String[] monthFrom = {"1","2","3","4","5","6","7","8","9","10","11","12"};
	JComboBox cbbMonthFrom = new JComboBox(monthFrom);
	String[] yearFrom = {"2018","2019","2020","2021","2022","2023","2024","2025","2026","2027","2028","2029","2030"};
	JComboBox cbbYearFrom = new JComboBox(yearFrom);
	String[] monthTo = {"1","2","3","4","5","6","7","8","9","10","11","12"};
	JComboBox cbbMonthTo = new JComboBox(monthTo);
	String[] yearTo = {"2018","2019","2020","2021","2022","2023","2024","2025","2026","2027","2028","2029","2030"};
	JComboBox cbbYearTo = new JComboBox(yearTo);
	JScrollPane spList = new JScrollPane();
	JTable table = new JTable();
	String[] col = {"ID","Mã KH", "Tên KH", "Phường", "Quận", "Mã CT", "Chu kì tháng", "Chu kì năm", "Chỉ số CT", "Tiền điện"};
	DefaultTableModel demoTable = new DefaultTableModel(col,0); 

	public ElectricityReportUI(String title) {
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
		
		//TITLE ELECTRICITY REPORT
		GridBagConstraints grbcTitle = new GridBagConstraints();
		JPanel pnElectricityReport = new JPanel();
		JLabel lbElectricityReport = new JLabel("QUẢN LÝ TÌNH HÌNH TIÊU THỤ ĐIỆN");
		Font fontElectricityReport = new Font("RoSoutho", Font.BOLD, 25);
		lbElectricityReport.setForeground(Color.RED);
		lbElectricityReport.setFont(fontElectricityReport);
		pnElectricityReport.add(lbElectricityReport);
		
		grbcTitle.gridx = 0;
		grbcTitle.gridy = 0;
		grbcTitle.gridwidth = 2;
		pnGeneral.add(pnElectricityReport, grbcTitle);
		
		//GRIDBAGCONSTRAINTS INPUT
		GridBagConstraints grbcInput = new GridBagConstraints();
		
		//User Title
		JPanel pnUserTitle = new JPanel();
		JLabel lbUserTitle = new JLabel("KHÁCH HÀNG");
		Font fontUserTitle = new Font("RoSoutho", Font.BOLD, 15);
		lbUserTitle.setFont(fontUserTitle);
		lbUserTitle.setPreferredSize(new Dimension(200, 30));
		pnUserTitle.add(lbUserTitle);
		
		grbcInput.gridx = 0;
		grbcInput.gridy = 1;
		pnGeneral.add(pnUserTitle, grbcInput);
		
		//All User
		JPanel pnAllUser = new JPanel();
		rbtnAllUser.setPreferredSize(new Dimension(200, 20));
		pnAllUser.add(rbtnAllUser);
		
		grbcInput.gridx = 0;
		grbcInput.gridy = 2;
		pnGeneral.add(pnAllUser, grbcInput);
		
		//User by Region
		JPanel pnUserRegion = new JPanel();
		rbtnUserRegion.setPreferredSize(new Dimension(200, 20));
		pnUserRegion.add(rbtnUserRegion);
		
		grbcInput.gridx = 0;
		grbcInput.gridy = 4;
		grbcInput.insets = new Insets(3, 25, 3, 25);
		pnGeneral.add(pnUserRegion, grbcInput);
		
			//District
			pnDistrict = new JPanel();
			pnDistrict.setVisible(false);
			JLabel lbDistrict = new JLabel("Quận");
			lbDistrict.setPreferredSize(new Dimension(60, 30));
			Font fontDistrict = new Font("Arial", Font.BOLD, 12);
			lbDistrict.setFont(fontDistrict);
			pnDistrict.add(lbDistrict);
			cbbDistrict.setPreferredSize(new Dimension(120, 30));
			pnDistrict.add(cbbDistrict);
			
			grbcInput.gridx = 0;
			grbcInput.gridy = 5;
			pnGeneral.add(pnDistrict, grbcInput);
			
			//Ward
			pnWard = new JPanel();
			pnWard.setVisible(false);
			JLabel lbWard = new JLabel("Phường");
			lbWard.setPreferredSize(new Dimension(60, 30));
			Font fontWard = new Font("Arial", Font.BOLD, 12);
			lbWard.setFont(fontWard);
			pnWard.add(lbWard);
			cbbWard.setPreferredSize(new Dimension(120, 30));
			pnWard.add(cbbWard);
			
			grbcInput.gridx = 0;
			grbcInput.gridy = 6;
			pnGeneral.add(pnWard, grbcInput);
			
		//Specific User
		JPanel pnSpecificUser = new JPanel();
		rbtnSpecificUser.setPreferredSize(new Dimension(200, 20));
		pnSpecificUser.add(rbtnSpecificUser);
		
		grbcInput.gridx = 0;
		grbcInput.gridy = 7;
		pnGeneral.add(pnSpecificUser, grbcInput);
		
			//User Code
			pnUserCode = new JPanel();
			pnUserCode.setVisible(false);
			JLabel lbUserCode = new JLabel("Mã KH");
			lbUserCode.setPreferredSize(new Dimension(50, 30));
			Font fontUserCode = new Font("Arial", Font.BOLD, 12);
			lbUserCode.setFont(fontUserCode);
			pnUserCode.add(lbUserCode);
			pnUserCode.add(txtUserCode);
			ImageIcon iconFind = new ImageIcon("Image/321830.png");
			Image getIconFind = iconFind.getImage();
			Image newIconFind = getIconFind.getScaledInstance(15, 15,  java.awt.Image.SCALE_SMOOTH);
			ImageIcon newIcon = new ImageIcon(newIconFind);
			btnFind = new JButton(newIcon);
			btnFind.setVisible(false);
			pnUserCode.add(btnFind);
			
			grbcInput.gridx = 0;
			grbcInput.gridy = 8;
			pnGeneral.add(pnUserCode, grbcInput);
			
			//User Name
			pnUserName = new JPanel();
			pnUserName.setVisible(false);
			JLabel lbUserName = new JLabel("Tên KH");
			lbUserName.setPreferredSize(new Dimension(50, 30));
			Font fontUserName = new Font("Arial", Font.BOLD, 12);
			lbUserName.setFont(fontUserName);
			pnUserName.add(lbUserName);
			pnUserName.add(txtUserName);
			
			grbcInput.gridx = 0;
			grbcInput.gridy = 9;
			pnGeneral.add(pnUserName, grbcInput);
			
			//Adress 
			pnAddress = new JPanel();
			pnAddress.setVisible(false);
			JLabel lbAddress = new JLabel("Địa chỉ");
			lbAddress.setPreferredSize(new Dimension(50, 30));
			Font fontAddress = new Font("Arial", Font.BOLD, 12);
			lbAddress.setFont(fontAddress);
			pnAddress.add(lbAddress);
			pnAddress.add(txtAddress);
			
			grbcInput.gridx = 0;
			grbcInput.gridy = 10;
			pnGeneral.add(pnAddress, grbcInput);
			
		//Add group User
		ButtonGroup groupUser = new ButtonGroup();
		
		groupUser.add(rbtnAllUser);
		groupUser.add(rbtnUserRegion);
		groupUser.add(rbtnSpecificUser);
		rbtnAllUser.setSelected(true);	
		
		//Time Title
		JPanel pnTimeTitle = new JPanel();
		JLabel lbTimeTitle = new JLabel("THỜI GIAN");
		Font fontTimeTitle = new Font("RoSoutho", Font.BOLD, 15);
		lbTimeTitle.setFont(fontTimeTitle);
		lbTimeTitle.setPreferredSize(new Dimension(230, 30));
		pnTimeTitle.add(lbTimeTitle);
		
		grbcInput.gridx = 1;
		grbcInput.gridy = 1;
		pnGeneral.add(pnTimeTitle, grbcInput);
			
		//By Year
		JPanel pnByYear = new JPanel();
		rbtnByYear.setPreferredSize(new Dimension(180, 20));
		pnByYear.add(rbtnByYear);
		
		grbcInput.gridx = 1;
		grbcInput.gridy = 2;
		pnGeneral.add(pnByYear, grbcInput);
			
			pnInYear = new JPanel();
			pnInYear.add(cbbByYear);
			
			grbcInput.gridx = 1;
			grbcInput.gridy = 3;
			pnGeneral.add(pnInYear, grbcInput);
		
		//By Time
		JPanel pnByTime = new JPanel();
		rbtnByTime.setPreferredSize(new Dimension(180, 20));
		pnByTime.add(rbtnByTime);
		
		grbcInput.gridx = 1;
		grbcInput.gridy = 4;
		pnGeneral.add(pnByTime, grbcInput);
		
			//From Date
			pnFromDate = new JPanel();
			pnFromDate.setVisible(false);
			JLabel lbFromDate = new JLabel("Từ");
			lbFromDate.setPreferredSize(new Dimension(25, 30));
			Font fontFromDate = new Font("Arial", Font.BOLD, 12);
			lbFromDate.setFont(fontFromDate);
			pnFromDate.add(lbFromDate);
			JLabel lbMonthFrom = new JLabel("Tháng:");
			pnFromDate.add(lbMonthFrom);
			pnFromDate.add(cbbMonthFrom);
			JLabel lbYearFrom = new JLabel("Năm:");
			pnFromDate.add(lbYearFrom);
			pnFromDate.add(cbbYearFrom);
			
			grbcInput.gridx = 1;
			grbcInput.gridy = 5;
			pnGeneral.add(pnFromDate, grbcInput);
			
			//To Date
			pnToDate = new JPanel();
			pnToDate.setVisible(false);
			JLabel lbToDate = new JLabel("Đến");
			lbToDate.setPreferredSize(new Dimension(25, 30));
			Font fontToDate = new Font("Arial", Font.BOLD, 12);
			lbToDate.setFont(fontToDate);
			pnToDate.add(lbToDate);
			JLabel lbMonthTo = new JLabel("Tháng:");
			pnToDate.add(lbMonthTo);
			pnToDate.add(cbbMonthTo);
			JLabel lbYearTo = new JLabel("Năm:");
			pnToDate.add(lbYearTo);
			pnToDate.add(cbbYearTo);
			
			grbcInput.gridx = 1;
			grbcInput.gridy = 6;
			pnGeneral.add(pnToDate, grbcInput);
			
		//By Cycle
		JPanel pnByCycle = new JPanel();
		rbtnByCycle.setPreferredSize(new Dimension(180, 20));
		pnByCycle.add(rbtnByCycle);
		
		grbcInput.gridx = 1;
		grbcInput.gridy = 7;
		pnGeneral.add(pnByCycle, grbcInput);
		
		pnCycle = new JPanel();
		pnCycle.setVisible(false);
		JLabel lbMonth = new JLabel("Tháng:");
		pnCycle.add(lbMonth);
		pnCycle.add(cbbMonth);
		JLabel lbYear = new JLabel("Năm:");
		pnCycle.add(lbYear);
		pnCycle.add(cbbYear);
		
		grbcInput.gridx = 1;
		grbcInput.gridy = 8;
		pnGeneral.add(pnCycle, grbcInput);
		
		//Add group Time
		ButtonGroup groupTime = new ButtonGroup();
		groupTime.add(rbtnByYear);
		groupTime.add(rbtnByTime);
		groupTime.add(rbtnByCycle);
		rbtnByYear.setSelected(true);
		
		//Button
		JPanel pnActionElectricityReport = new JPanel();
		btnView = new JButton("Xem");
		pnActionElectricityReport.add(btnView);
		btnBack = new JButton("Quay lại");
		pnActionElectricityReport.add(btnBack);
		
		grbcInput.gridx = 0;
		grbcInput.gridy = 11;
		grbcInput.gridwidth = 2;
		pnGeneral.add(pnActionElectricityReport, grbcInput);
		
		//Display
		JPanel pnDisplay = new JPanel();
		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder titleBorder = BorderFactory.createTitledBorder(border, "Hiển thị");
		spList.setBorder(titleBorder);
		table.setModel(demoTable);
		spList.setViewportView(table);
		pnDisplay.add(spList);
		
		grbcInput.gridx = 0;
		grbcInput.gridy = 12;
		pnGeneral.add(pnDisplay, grbcInput);
	
		pnMain.add(pnGeneral);
		
		con.add(pnMain);
	}
	
	//Create Combobox Dictrict
		JComboBox cbbDistrict = new JComboBox();
		public void combobox() {
			if (conn != null) {

				String sql = "select * from ffse1702011_district";
				try {
					PreparedStatement ptmt = conn.prepareStatement(sql);
					// Create resultset
					ResultSet rs = ptmt.executeQuery();
					cbbDistrict.addItem("");
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
		
	//EVENT COMBOBOX DISTRICT & WARD
	ActionListener eventCombobox = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			combobox1(cbbDistrict.getSelectedItem().toString());
		}
	};
		
	//VIEW ELECTRICITY REPORT
	ActionListener eventView = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			demoTable.getDataVector().removeAllElements();
			demoTable.fireTableDataChanged();
			view();
		}
	};
	
	public void view() {
		try {
			String sql = "select * from ffse1702011_user_information"
					+ " inner join ffse1702011_bill_information"
					+ " where ffse1702011_bill_information.Meter_Code = ffse1702011_user_information.Meter_Code ";
			String sqlWhere = null;
			String byYear = (String) cbbByYear.getSelectedItem();
			String monthFrom = (String) cbbMonthFrom.getSelectedItem();
			String yearFrom = (String) cbbYearFrom.getSelectedItem();
			String monthTo = (String) cbbMonthTo.getSelectedItem();
			String yearTo = (String) cbbYearTo.getSelectedItem();
			String month = (String) cbbMonth.getSelectedItem();
			String year = (String) cbbYear.getSelectedItem();
			String district = (String) cbbDistrict.getSelectedItem();
			String ward = (String) cbbWard.getSelectedItem();
			if(rbtnAllUser.isSelected()) {
				if(rbtnByYear.isSelected()) {
					sqlWhere = sql.concat(" and ffse1702011_bill_information.Cycle_Year = '"+byYear+"'");
				} else if(rbtnByTime.isSelected()) {
					sqlWhere = sql.concat(" AND ffse1702011_bill_information.Cycle_Month >= '"+monthFrom+"' AND ffse1702011_bill_information.Cycle_Month <= '"+monthTo+"' AND ffse1702011_bill_information.Cycle_Year >= '"+yearFrom+"' AND ffse1702011_bill_information.Cycle_Year <= '"+yearTo+"'");
				} else if(rbtnByCycle.isSelected()) {
					sqlWhere = sql.concat(" and ffse1702011_bill_information.Cycle_Month = '"+month+"' and ffse1702011_bill_information.Cycle_Year = '"+year+"'");
				}
			} else if(rbtnUserRegion.isSelected()) {
				if(rbtnByYear.isSelected()) {
					sqlWhere = sql.concat(" and ffse1702011_user_information.District = '"+district+"' and ffse1702011_user_information.Ward = '"+ward+"' and ffse1702011_bill_information.Cycle_Year = '"+byYear+"'");
				} else if(rbtnByTime.isSelected()) {
					sqlWhere = sql.concat(" and ffse1702011_user_information.District = '"+district+"' and ffse1702011_user_information.Ward = '"+ward+"' and ffse1702011_bill_information.Cycle_Month >= '"+monthFrom+"' AND ffse1702011_bill_information.Cycle_Month <= '"+monthTo+"' AND ffse1702011_bill_information.Cycle_Year >= '"+yearFrom+"' AND ffse1702011_bill_information.Cycle_Year <= '"+yearTo+"'");
				} else if(rbtnByCycle.isSelected()) {
					sqlWhere = sql.concat(" and ffse1702011_bill_information.Cycle_Month = '"+month+"' and ffse1702011_bill_information.Cycle_Year = '"+year+"' and ffse1702011_user_information.District = '"+district+"' and ffse1702011_user_information.Ward = '"+ward+"' ");
				}
			} else if(rbtnSpecificUser.isSelected()) {
				String userCode = txtUserCode.getText();
				if(rbtnByYear.isSelected()) {
					sqlWhere = sql.concat(" and ffse1702011_user_information.User_Code = '"+userCode+"' and ffse1702011_bill_information.Cycle_Year = '"+byYear+"'");
				} else if(rbtnByTime.isSelected()) {
					sqlWhere = sql.concat(" and ffse1702011_user_information.User_Code = '"+userCode+"' AND ffse1702011_bill_information.Cycle_Month >= '"+monthFrom+"' AND ffse1702011_bill_information.Cycle_Month <= '"+monthTo+"' AND ffse1702011_bill_information.Cycle_Year >= '"+yearFrom+"' AND ffse1702011_bill_information.Cycle_Year <= '"+yearTo+"'");
				} else if(rbtnByCycle.isSelected()) {
					sqlWhere = sql.concat(" and ffse1702011_user_information.User_Code = '"+userCode+"' and ffse1702011_bill_information.Cycle_Month = '"+month+"' and ffse1702011_bill_information.Cycle_Year = '"+year+"'");
				}
			}
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sqlWhere);
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//FIND USER INFORMATION
		ActionListener eventFind = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				demoTable.getDataVector().removeAllElements();
				demoTable.fireTableDataChanged();
				find();
			}
		};
		
		public void find() {
			String userCode = txtUserCode.getText();
			try {
				String sql = "select * from ffse1702011_user_information where User_Code = '"+userCode+"'";
				Statement statement = conn.createStatement();
				ResultSet result = statement.executeQuery(sql);
				while(result.next()) {
					String userName = result.getString("User_Name");
					String address = result.getString("Address");
					txtUserName.setText(userName);
					txtAddress.setText(address);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	public void addEvents() {
		btnView.addActionListener(eventView);
		btnFind.addActionListener(eventFind);
		cbbDistrict.addActionListener(eventCombobox);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuUI giaodien = new MenuUI("Chương trình quản lý tiền điện");
				giaodien.showWindow();	
				dispose();
			}
		});
		rbtnUserRegion.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					pnDistrict.setVisible(true);
					pnWard.setVisible(true);
				} else {
					pnDistrict.setVisible(false);
					pnWard.setVisible(false);
				}
			}
        });
		rbtnSpecificUser.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					pnUserCode.setVisible(true);
					pnUserName.setVisible(true);
					pnAddress.setVisible(true);
					btnFind.setVisible(true);
				} else {
					pnUserCode.setVisible(false);
					pnUserName.setVisible(false);
					pnAddress.setVisible(false);
					btnFind.setVisible(false);
				}
			}
        });
		
		rbtnByYear.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					pnInYear.setVisible(true);
				} else {
					pnInYear.setVisible(false);
				}
			}
		});
		
		rbtnByTime.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					pnFromDate.setVisible(true);
					pnToDate.setVisible(true);
				} else {
					pnFromDate.setVisible(false);
					pnToDate.setVisible(false);
				}
			}
		});
		
		rbtnByCycle.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					pnCycle.setVisible(true);
				} else {
					pnCycle.setVisible(false);
				}
			}
		});
		
	}
	
	public void showWindow() {
		this.setSize(600, 750);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
