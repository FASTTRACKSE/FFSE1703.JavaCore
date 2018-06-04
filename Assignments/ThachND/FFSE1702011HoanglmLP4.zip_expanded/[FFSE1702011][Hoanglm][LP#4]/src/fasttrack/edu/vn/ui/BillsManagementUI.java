package fasttrack.edu.vn.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.*;
import fasttrack.edu.vn.model.*;
import com.mysql.*;
import java.io.*;
import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.toedter.calendar.JDateChooser;

import fasttrack.edu.vn.connection.ConnectSql;
import fasttrack.edu.vn.model.MyException;

import java.util.*;

public class BillsManagementUI extends JFrame {
	static Connection conn = ConnectSql.getConnect("localhost", "ffse1702011", "ffse1702011", "123456");
	private MyException myEx = new MyException();
	JTextField txtMeterCode = new JTextField(17);
	JTextField txtAddress = new JTextField(20);
	JTextField txtUserName= new JTextField(12);
	JTextField txtMeterNumber = new JTextField(12);
	JTextField txtUserID = new JTextField(12); 
	JTextField txtDateAdd = new JTextField(12);
	JButton btnFind, btnFindAll, btnAdd, btnEdit, btnDel, btnBack;
	String[] month = {"1","2","3","4","5","6","7","8","9","10","11","12"};
	JComboBox cbbMonth = new JComboBox(month);
	String[] year = {"2018","2019","2020","2021","2022","2023","2024","2025","2026","2027","2028","2029","2030"};
	JComboBox cbbYear = new JComboBox(year);
	private JDateChooser dateChooser;
	JScrollPane spList = new JScrollPane();
	JTable table = new JTable();
	String[] col = {"ID","Mã CT","Mã KH", "Tên KH", "Địa chỉ", "Ngày nhập", "Chu kì tháng", "Chu kì năm", "Chỉ số CT"};
	DefaultTableModel demoTable = new DefaultTableModel(col,0); 
	
	public BillsManagementUI(String title) {
		super(title);
		addControls();
		addEvents();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void addControls() {
		this.setResizable(false);
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		
		JPanel pnGeneral = new JPanel();
		pnGeneral.setLayout(new GridBagLayout());
		
		//TITLE BILLS MANAGEMENT
		GridBagConstraints grbcTitle = new GridBagConstraints();
		JPanel pnBillsManagement = new JPanel();
		JLabel lbBillsManagement = new JLabel("QUẢN LÝ BIÊN LAI");
		Font fontBillsManagement = new Font("RoSoutho", Font.BOLD, 40);
		lbBillsManagement.setForeground(Color.RED);
		lbBillsManagement.setFont(fontBillsManagement);
		pnBillsManagement.add(lbBillsManagement);
		
		grbcTitle.gridx = 0;
		grbcTitle.gridy = 0;
		grbcTitle.gridwidth = 2;
		pnGeneral.add(pnBillsManagement, grbcTitle);
		
		//GRIDBAGCONSTRAINTS INPUT
		GridBagConstraints grbcInput = new GridBagConstraints();
		
		//User ID
		JPanel pnUserID = new JPanel();
		pnUserID.add(txtUserID);
		pnUserID.setVisible(false);
		
		grbcInput.gridx = 0;
		grbcInput.gridy = 1;
		pnGeneral.add(pnUserID, grbcInput);
		
		//Meter Code
		JPanel pnMeterCode = new JPanel();
		JLabel lbMeterCode = new JLabel("Mã CT");
		lbMeterCode.setPreferredSize(new Dimension(50, 30));
		Font fontMeterCode = new Font("Arial", Font.BOLD, 12);
		lbMeterCode.setFont(fontMeterCode);
		pnMeterCode.add(lbMeterCode);
		pnMeterCode.add(txtMeterCode);
		ImageIcon iconFind = new ImageIcon("Image/321830.png");
		Image getIconFind = iconFind.getImage();
		Image newIconFind = getIconFind.getScaledInstance(16, 16,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newIconFind);
		btnFind = new JButton(newIcon);
		pnMeterCode.add(btnFind);
		
		grbcInput.gridx = 0;
		grbcInput.gridy = 2;
		grbcInput.insets = new Insets(0, 15, 10, 15);
		pnGeneral.add(pnMeterCode, grbcInput);
		
		//User Name
		JPanel pnUserName = new JPanel();
		JLabel lbUserName = new JLabel("Tên KH");
		lbUserName.setPreferredSize(new Dimension(70, 30));
		Font fontUserName = new Font("Arial", Font.BOLD, 12);
		lbUserName.setFont(fontUserName);
		pnUserName.add(lbUserName);
		pnUserName.add(txtUserName);
		
		grbcInput.gridx = 1;
		grbcInput.gridy = 2;
		pnGeneral.add(pnUserName, grbcInput);
		
		//Address
		JPanel pnAddress = new JPanel();
		JLabel lbAddress = new JLabel("Địa chỉ");
		lbAddress.setPreferredSize(new Dimension(50, 30));
		Font fontAddress = new Font("Arial", Font.BOLD, 12);
		lbAddress.setFont(fontAddress);
		pnAddress.add(lbAddress);
		pnAddress.add(txtAddress);
		
		grbcInput.gridx = 0;
		grbcInput.gridy = 3;
		pnGeneral.add(pnAddress, grbcInput);
		
		//Date entered information -- Ngày nhập thông tin
		JPanel pnDateEnter = new JPanel();
		JLabel lbDateEnter = new JLabel("Ngày nhập");
		lbDateEnter.setPreferredSize(new Dimension(70, 30));
		Font fontDateEnter = new Font("Arial", Font.BOLD, 12);
		lbDateEnter.setFont(fontDateEnter);
		pnDateEnter.add(lbDateEnter);
		//Create Calendar for Date entered information
		dateChooser = new JDateChooser();
		dateChooser.setFont(new Font("Arial", Font.PLAIN, 12));
		dateChooser.setBounds(80,60,20,10);
		dateChooser.setPreferredSize(new Dimension(153, 20));
		dateChooser.setDateFormatString("dd/MM/yyyy");
		pnDateEnter.add(dateChooser);
		
		grbcInput.gridx = 1;
		grbcInput.gridy = 3;
		pnGeneral.add(pnDateEnter, grbcInput);
		
		//Cycle
		JPanel pnCycle = new JPanel();
		JLabel lbCycle = new JLabel("Chu kì");
		lbCycle.setPreferredSize(new Dimension(50, 30));
		Font fontCycle = new Font("Arial", Font.BOLD, 12);
		lbCycle.setFont(fontCycle);
		pnCycle.add(lbCycle);
		JLabel lbMonth = new JLabel("Tháng:");
		pnCycle.add(lbMonth);
		pnCycle.add(cbbMonth);
		JLabel lbYear = new JLabel("Năm:");
		pnCycle.add(lbYear);
		pnCycle.add(cbbYear);
		
		grbcInput.gridx = 0;
		grbcInput.gridy = 4;
		pnGeneral.add(pnCycle, grbcInput);
		
		//Meter Number
		JPanel pnMeterNumber = new JPanel();
		JLabel lbMeterNumber = new JLabel("Chỉ số CT");
		lbMeterNumber.setPreferredSize(new Dimension(70, 30));
		Font fontMeterNumber = new Font("Arial", Font.BOLD, 12);
		lbMeterNumber.setFont(fontMeterNumber);
		pnMeterNumber.add(lbMeterNumber);
		pnMeterNumber.add(txtMeterNumber);
		
		grbcInput.gridx = 1;
		grbcInput.gridy = 4;
		pnGeneral.add(pnMeterNumber, grbcInput);
		
		
		//BUTTON
		JPanel pnActionBillManagerment = new JPanel();
		btnAdd = new JButton("Thêm");
		pnActionBillManagerment.add(btnAdd);
		btnEdit = new JButton("Sửa");
		pnActionBillManagerment.add(btnEdit);
		btnDel = new JButton("Xoá");
		pnActionBillManagerment.add(btnDel);
		btnFindAll = new JButton("Tìm kiếm");
		pnActionBillManagerment.add(btnFindAll);
		btnBack = new JButton("Quay lại");
		pnActionBillManagerment.add(btnBack);
		
		grbcInput.gridx = 0;
		grbcInput.gridy = 5;
		grbcInput.gridwidth = 2;
		pnGeneral.add(pnActionBillManagerment, grbcInput);
		
		//DISPLAY
		JPanel pnDisplay = new JPanel();
		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder titleBorder = BorderFactory.createTitledBorder(border, "Hiển thị");
		spList.setBorder(titleBorder);
		table.setModel(demoTable);
		spList.setViewportView(table);
		pnDisplay.add(spList);
		
		grbcInput.gridx = 0;
		grbcInput.gridy = 6;
		pnGeneral.add(pnDisplay, grbcInput);
		
		pnMain.add(pnGeneral);
		
		con.add(pnMain);
		
	}
	
	//FIND USER INFORMATION
	ActionListener eventFind = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			demoTable.getDataVector().removeAllElements();
			demoTable.fireTableDataChanged();
			try {
				find();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	};
	
	public void find() throws MyException {
		if(myEx.chkFindMeterCode(txtMeterCode.getText())) {
			String meterCode = txtMeterCode.getText();
			try {
				String sql = "select * from ffse1702011_user_information where Meter_Code = '"+meterCode+"'";
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
	}
	
	//FIND ALL INFORMATION
	ActionListener eventFindAll = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			demoTable.getDataVector().removeAllElements();
			demoTable.fireTableDataChanged();
			try {
				findAll();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	};
	
	public void findAll() throws MyException {
		if(myEx.chkFindMeterCode(txtMeterCode.getText())) {
			String meterCode = txtMeterCode.getText();
			try {
				String sql = "SELECT * FROM `ffse1702011_bill_information` \n" + 
						"INNER JOIN ffse1702011_user_information\n" + 
						"WHERE ffse1702011_bill_information.Meter_Code = ffse1702011_user_information.Meter_Code\n"
						+ "AND ffse1702011_bill_information.Meter_Code = '"+meterCode+"'";
				Statement statement = conn.createStatement();
				ResultSet result = statement.executeQuery(sql);
				while(result.next()) {
					String rows[] = new String[9];
					int idInt = result.getInt(1);
					String idString = Integer.toString(idInt);
					rows[0] = idString;
					rows[1] = result.getString(2);
					rows[2] = result.getString(8);
					rows[3] = result.getString(9);
					rows[4] = result.getString(10);
					rows[5] = result.getString(3);
					rows[6] = result.getString(4);
					rows[7] = result.getString(5);
					rows[8] = result.getString(6);
					demoTable.addRow(rows);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//ADD BILL
	ActionListener eventAdd = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			demoTable.getDataVector().removeAllElements();
			demoTable.fireTableDataChanged();
			try {
				add();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			addDisplay();
		}
	};
	
	public void add() throws MyException {
		try {
			String meterCode = txtMeterCode.getText();
			DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			if(dateChooser.getDate() == null) {
				JOptionPane.showMessageDialog(null , "Vui lòng không để trống!");
			} else {
			txtDateAdd.setText(format.format(dateChooser.getDate()));
			String dateAdd = txtDateAdd.getText();
			if(myEx.chkMeterNumber(txtMeterNumber.getText())) {
				String cycleMonth = (String) cbbMonth.getSelectedItem();
				String cycleYear = (String) cbbYear.getSelectedItem();
				String meterNumber = txtMeterNumber.getText();
				if(myEx.chkCycle(cycleMonth, cycleYear, meterCode) && myEx.chkSameCycle(cycleMonth, cycleYear, meterCode)) {
					String sql = "INSERT INTO `ffse1702011_bill_information`(`Meter_Code`, `DateAdded`, `Cycle_Month`, `Cycle_Year`, `Meter_Number`) "
							+ "VALUES ('"+meterCode+"','"+dateAdd+"','"+cycleMonth+"','"+cycleYear+"','"+meterNumber+"')";
					Statement statement = conn.createStatement();
					int x = statement.executeUpdate(sql);
					if(x>0) {
						JOptionPane.showMessageDialog(null , "Thêm thành công!");
						txtMeterCode.setText("");
						txtMeterCode.setEditable(true);
						txtUserName.setText("");
						txtUserName.setEditable(true);
						txtAddress.setText("");
						txtAddress.setEditable(true);
						cbbMonth.setSelectedItem("1");
						cbbMonth.setEnabled(true);
						cbbYear.setSelectedItem("2018");
						cbbYear.setEnabled(true);
						dateChooser.setEnabled(true);
						txtMeterNumber.setText("");
					} else {
						JOptionPane.showMessageDialog(null , "Thêm thất bại!");
					}
				}
			}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addDisplay() {
		try {
			String sql = "select * from ffse1702011_bill_information\n" + 
					"INNER JOIN ffse1702011_user_information\n" + 
					"WHERE ffse1702011_bill_information.Meter_Code = ffse1702011_user_information.Meter_Code\n" + 
					"ORDER BY ffse1702011_bill_information.ID DESC \n" + 
					"LIMIT 1";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while(result.next()) {
				String rows[] = new String[9];
				int idInt = result.getInt(1);
				String idString = Integer.toString(idInt);
				rows[0] = idString;
				rows[1] = result.getString(2);
				rows[2] = result.getString(8);
				rows[3] = result.getString(9);
				rows[4] = result.getString(10);
				rows[5] = result.getString(3);
				rows[6] = result.getString(4);
				rows[7] = result.getString(5);
				rows[8] = result.getString(6);
				demoTable.addRow(rows);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//EDIT BILL
	MouseAdapter eventClick = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int i = table.getSelectedRow();
			String[] row = new String[9];
			for(int j = 0; j < 9; j++) {
				row[j]=(String)table.getValueAt(i,j);
			}
			txtUserID.setText(row[0]);
			txtMeterCode.setText(row[1]);
			txtMeterCode.setEditable(false);
			txtUserName.setText(row[3]);
			txtUserName.setEditable(false);
			txtAddress.setText(row[4]);
			txtAddress.setEditable(false);
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	        String dateString = row[5];
	        try {
	            Date date = format.parse(dateString);
	           dateChooser.setDate(date);
	           dateChooser.setEnabled(false);
	        } catch (ParseException e1) {
	            e1.printStackTrace();
	        }
			cbbMonth.setSelectedItem(row[6]);
			cbbMonth.setEnabled(false);
			cbbYear.setSelectedItem(row[7]);
			cbbYear.setEnabled(false);
			txtMeterNumber.setText(row[8]);
		}
	};
	
	ActionListener eventEdit = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			demoTable.getDataVector().removeAllElements();
			demoTable.fireTableDataChanged();
			edit();
			editDisplay();
		}
	};
	
	public void edit() {
		String stringID = txtUserID.getText();
		int intID = Integer.parseInt(stringID);
		String meterNumber = txtMeterNumber.getText();
		try {
			String sql = "UPDATE `ffse1702011_bill_information` \n" + 
					"SET `Meter_Number`='"+meterNumber+"' \n" + 
					"WHERE ID = '"+intID+"'";
			Statement statement = conn.createStatement();
			int x = statement.executeUpdate(sql);
			if(x>0) {
				JOptionPane.showMessageDialog(null, "Cập nhật thành công");
				txtMeterCode.setText("");
				txtMeterCode.setEditable(true);
				txtUserName.setText("");
				txtUserName.setEditable(true);
				txtAddress.setText("");
				txtAddress.setEditable(true);
				cbbMonth.setSelectedItem("1");
				cbbMonth.setEnabled(true);
				cbbYear.setSelectedItem("2018");
				cbbYear.setEnabled(true);
				dateChooser.setEnabled(true);
				txtMeterNumber.setText("");
			} else {
				JOptionPane.showMessageDialog(null, "Cập nhật thất bại");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void editDisplay() {
		try {
			String stringID = txtUserID.getText();
			int intID = Integer.parseInt(stringID);
			String sql = "SELECT * FROM `ffse1702011_bill_information`\n" + 
					"INNER JOIN ffse1702011_user_information\n" + 
					"WHERE ffse1702011_bill_information.Meter_Code = ffse1702011_user_information.Meter_Code\n" + 
					"AND ffse1702011_bill_information.ID = '"+intID+"' \n" + 
					"ORDER BY ffse1702011_bill_information.ID DESC LIMIT 1";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while(result.next()) {
				String rows[] = new String[9];
				int idInt = result.getInt(1);
				String idString = Integer.toString(idInt);
				rows[0] = idString;
				rows[1] = result.getString(2);
				rows[2] = result.getString(8);
				rows[3] = result.getString(9);
				rows[4] = result.getString(10);
				rows[5] = result.getString(3);
				rows[6] = result.getString(4);
				rows[7] = result.getString(5);
				rows[8] = result.getString(6);
				demoTable.addRow(rows);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//DELETE BILL
	ActionListener eventDel = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			demoTable.getDataVector().removeAllElements();
			demoTable.fireTableDataChanged();
			del();
		}
	};
	
	public void del() {
		String stringID = txtUserID.getText();
		int intID = Integer.parseInt(stringID);
		try {
			String sql = "DELETE FROM `ffse1702011_bill_information` WHERE ID = '"+intID+"'";
			Statement statement = conn.createStatement();
			int x = statement.executeUpdate(sql);
			if(x > 0) {
				JOptionPane.showMessageDialog(null, "Xoá thành công");
				txtMeterCode.setText("");
				txtMeterCode.setEditable(true);
				txtUserName.setText("");
				txtUserName.setEditable(true);
				txtAddress.setText("");
				txtAddress.setEditable(true);
				cbbMonth.setSelectedItem("1");
				cbbMonth.setEnabled(true);
				cbbYear.setSelectedItem("2018");
				cbbYear.setEnabled(true);
				dateChooser.setEnabled(true);
				txtMeterNumber.setText("");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addEvents() {
		table.addMouseListener(eventClick);
		btnAdd.addActionListener(eventAdd);
		btnFind.addActionListener(eventFind);
		btnDel.addActionListener(eventDel);
		btnFindAll.addActionListener(eventFindAll);
		btnEdit.addActionListener(eventEdit);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuUI giaodien = new MenuUI("Chương trình quản lý tiền điện");
				giaodien.showWindow();	
				dispose();
			}
		});
	}
	
	public void showWindow() {
		this.setSize(700, 750);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
