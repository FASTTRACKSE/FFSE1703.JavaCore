package fasttrack.edu.vn.ui;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import com.mysql.*;
import java.io.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.Thread.State;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Vector;
import fasttrack.edu.vn.model.*;
import fasttrack.edu.vn.connection.ConnectSql;
import fasttrack.edu.vn.ui.*;

public class UserManagementUI extends JFrame {
	static Connection conn = ConnectSql.getConnect("localhost", "ffse1702011", "ffse1702011", "123456");
	//DECLARE
	JTextField txtUserID = new JTextField(5);		
	JTextField txtUserCode = new JTextField(12);
	JTextField txtAddress = new JTextField(12);
	JTextField txtPhone = new JTextField(12);
	JTextField txtUserName = new JTextField(12);
	JTextField txtMeterCode = new JTextField(15); //Mã công tơ
	JTextField txtEmail = new JTextField(15);
	JButton btnAdd, btnEdit, btnDel, btnFind, btnBack;
	JScrollPane spList = new JScrollPane();
	JTable table = new JTable();
	String[] col = {"ID","Mã KH", "Tên KH", "Địa chỉ", "Mã CT", "Điện thoại","Email", "Quận", "Phường"};
	DefaultTableModel demoTable = new DefaultTableModel(col,0); 
	//---------------//
	
	private MyException myEx = new MyException();
	
	public UserManagementUI(String title) {
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
		
		//TITLE USER MANAGEMENT
		GridBagConstraints grbcTitle = new GridBagConstraints();
		JPanel pnUserManagement = new JPanel();
		JLabel lbUserManagement = new JLabel("QUẢN LÝ KHÁCH HÀNG");
		Font fontUserManagement = new Font("RoSoutho", Font.BOLD, 40);
		lbUserManagement.setForeground(Color.RED);
		lbUserManagement.setFont(fontUserManagement);
		pnUserManagement.add(lbUserManagement);
		
		grbcTitle.gridx = 0;
		grbcTitle.gridy = 0;
		grbcTitle.gridwidth = 2;
		pnGeneral.add(pnUserManagement, grbcTitle);

		//GRIDBAGCONSTRAINTS INPUT
		GridBagConstraints grbcInput = new GridBagConstraints();
		//User ID
		JPanel pnUserID = new JPanel();
		pnUserID.add(txtUserID);
		pnUserID.setVisible(false);
		
		grbcInput.gridx = 0;
		grbcInput.gridy = 1;
		grbcInput.insets = new Insets(5, 20, 5, 20);
		pnGeneral.add(pnUserID, grbcInput);
		
		//User Code
		JPanel pnUserCode = new JPanel();
		JLabel lbUserCode = new JLabel("Mã KH");
		lbUserCode.setPreferredSize(new Dimension(60, 30));
		Font fontUserCode = new Font("Arial", Font.BOLD, 12);
		lbUserCode.setFont(fontUserCode);
		pnUserCode.add(lbUserCode);
		pnUserCode.add(txtUserCode);
		
		grbcInput.gridx = 0;
		grbcInput.gridy = 2;
		pnGeneral.add(pnUserCode, grbcInput);
		
		//User Name
		JPanel pnUserName = new JPanel();
		JLabel lbUserName = new JLabel("Tên KH");
		lbUserName.setPreferredSize(new Dimension(60, 30));
		Font fontUserName = new Font("Arial", Font.BOLD, 12);
		lbUserName.setFont(fontUserName);
		pnUserName.add(lbUserName);
		pnUserName.add(txtUserName);
		ImageIcon iconFind = new ImageIcon("Image/321830.png");
		Image getIconFind = iconFind.getImage();
		Image newIconFind = getIconFind.getScaledInstance(12, 12,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newIconFind);
		btnFind = new JButton(newIcon);
		pnUserName.add(btnFind);
		
		grbcInput.gridx = 1;
		grbcInput.gridy = 2;
		pnGeneral.add(pnUserName, grbcInput);
		
		//Address
		JPanel pnAddress = new JPanel();
		JLabel lbAddress = new JLabel("Địa chỉ");
		lbAddress.setPreferredSize(new Dimension(60, 30));
		Font fontAddress = new Font("Arial", Font.BOLD, 12);
		lbAddress.setFont(fontAddress);
		pnAddress.add(lbAddress);
		pnAddress.add(txtAddress);
		
		grbcInput.gridx = 0;
		grbcInput.gridy = 3;
		pnGeneral.add(pnAddress, grbcInput);
		
		//Meter Code
		JPanel pnMeterCode = new JPanel();
		JLabel lbMeterCode  = new JLabel("Mã CT");
		lbMeterCode .setPreferredSize(new Dimension(60, 30));
		Font fontMeterCode  = new Font("Arial", Font.BOLD, 12);
		lbMeterCode.setFont(fontMeterCode );
		pnMeterCode.add(lbMeterCode);
		pnMeterCode.add(txtMeterCode);
		
		grbcInput.gridx = 1;
		grbcInput.gridy = 3;
		pnGeneral.add(pnMeterCode, grbcInput);
		
		//District
		JPanel pnDistrict = new JPanel();
		JLabel lbDistrict = new JLabel("Quận");
		lbDistrict.setPreferredSize(new Dimension(60, 30));
		Font fontDistrict = new Font("Arial", Font.BOLD, 12);
		lbDistrict.setFont(fontDistrict);
		pnDistrict.add(lbDistrict);		
		cbbDistrict.setPreferredSize(new Dimension(156, 30));
		pnDistrict.add(cbbDistrict);
		
		grbcInput.gridx = 0;
		grbcInput.gridy = 4;
		pnGeneral.add(pnDistrict, grbcInput);
		
		//Ward
		JPanel pnWard = new JPanel();
		JLabel lbWard = new JLabel("Phường");
		lbWard.setPreferredSize(new Dimension(60, 30));
		Font fontWard = new Font("Arial", Font.BOLD, 12);
		lbWard.setFont(fontWard);
		pnWard.add(lbWard);
		cbbWard.setPreferredSize(new Dimension(193, 30));
		pnWard.add(cbbWard);
		
		grbcInput.gridx = 1;
		grbcInput.gridy = 4;
		pnGeneral.add(pnWard, grbcInput);
		
		//Telephone Number
		JPanel pnPhone = new JPanel();
		JLabel lbPhone = new JLabel("Điện thoại");
		lbPhone.setPreferredSize(new Dimension(60, 30));
		Font fontPhone = new Font("Arial", Font.BOLD, 12);
		lbPhone.setFont(fontPhone);
		pnPhone.add(lbPhone);
		pnPhone.add(txtPhone);
		
		grbcInput.gridx = 0;
		grbcInput.gridy = 5;
		pnGeneral.add(pnPhone, grbcInput);
		
		//Email
		JPanel pnMail = new JPanel();
		JLabel lbMail = new JLabel("Email");
		lbMail.setPreferredSize(new Dimension(60, 30));
		Font fontMail = new Font("Arial", Font.BOLD, 12);
		lbMail.setFont(fontMail);
		pnMail.add(lbMail);
		pnMail.add(txtEmail);
		
		grbcInput.gridx = 1;
		grbcInput.gridy = 5;
		pnGeneral.add(pnMail, grbcInput);
		
		//BUTTON
		JPanel pnActionUserManagement = new JPanel();
		btnAdd = new JButton("Thêm");
		pnActionUserManagement.add(btnAdd);
		btnEdit = new JButton("Sửa");
		pnActionUserManagement.add(btnEdit);
		btnDel = new JButton("Xoá");
		pnActionUserManagement.add(btnDel);
		btnBack = new JButton("Quay lại");
		pnActionUserManagement.add(btnBack);
		
		grbcInput.gridx = 0;
		grbcInput.gridy = 6;
		grbcInput.gridwidth = 2;
		pnGeneral.add(pnActionUserManagement, grbcInput);
		
		
		//DISPLAY
		JPanel pnDisplay = new JPanel();
		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder titleBorder = BorderFactory.createTitledBorder(border, "Hiển thị");
		spList.setBorder(titleBorder);
		table.setModel(demoTable);
		spList.setViewportView(table);
		pnDisplay.add(spList);
		
		grbcInput.gridx = 0;
		grbcInput.gridy = 7;
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
	
	//ADD USER INFORMATION 
	ActionListener eventAdd = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			demoTable.getDataVector().removeAllElements();
			demoTable.fireTableDataChanged();
			try {
				addInfo();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			Display();
		}
	};
	
	public void addInfo() throws MyException {	
		try {
			if(myEx.chkUserCode(txtUserCode.getText()) &&  myEx.chkEmpty(txtUserName.getText()) && myEx.chkEmpty(txtAddress.getText()) && myEx.chkMeterCode(txtMeterCode.getText()) && myEx.chkEmpty((String) cbbDistrict.getSelectedItem()) && myEx.chkEmpty((String) cbbWard.getSelectedItem()) && myEx.chkPhone(txtPhone.getText()) && myEx.chkEmail(txtEmail.getText())) {
				String userCode = txtUserCode.getText();
				String userName = txtUserName.getText();
				String address = txtAddress.getText();
				String meterCode = txtMeterCode.getText();
				String district = (String) cbbDistrict.getSelectedItem();
				String ward = (String) cbbWard.getSelectedItem();
				String phone = txtPhone.getText();
				String email = txtEmail.getText();
				
				String sql = "INSERT INTO ffse1702011_user_information(User_Code, User_Name, Address, Phone, Meter_Code, District, Ward, Email, Password) VALUES ('"+userCode+"','"+userName+"','"+address+"','"+phone+"','"+meterCode+"','"+district+"','"+ward+"','"+email+"', '"+123123+"')";
				Statement statement = conn.createStatement();
				int x = statement.executeUpdate(sql);
				if(x>0) {
					JOptionPane.showMessageDialog(null, "Lưu thành công","Alert", JOptionPane.WARNING_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Lưu không thành công","Alert", JOptionPane.WARNING_MESSAGE);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		txtUserCode.setText("");
		txtUserName.setText("");
		txtAddress.setText("");
		txtMeterCode.setText("");
		txtPhone.setText("");
		txtEmail.setText("");
	}
	
	public void Display() {
		try {
			String sql = "select * from ffse1702011_user_information ORDER BY ffse1702011_user_information.ID DESC LIMIT 1";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
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
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//EDIT USER INFORMATION
	MouseAdapter eventClick = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int i = table.getSelectedRow();
			String[] row = new String[9];
			for(int j = 0; j < 9; j++) {
				row[j]=(String)table.getValueAt(i,j);
			}
			txtUserID.setText(row[0]);
			txtUserCode.setText(row[1]);
			txtUserName.setText(row[2]);
			txtAddress.setText(row[3]);
			txtMeterCode.setText(row[4]);
			txtPhone.setText(row[5]);
			txtEmail.setText(row[6]);
			cbbDistrict.setSelectedItem(row[7]);
			cbbWard.setSelectedItem(row[8]);
		}
	};
	
	ActionListener eventEdit = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			demoTable.getDataVector().removeAllElements();
			demoTable.fireTableDataChanged();
			editInfo();
			editDisplay();
		}
	};
	
	public void editInfo() {
		try {
			String userCode = txtUserCode.getText();
			String userName = txtUserName.getText();
			String address = txtAddress.getText();
			String meterCode = txtMeterCode.getText();
			String district = (String) cbbDistrict.getSelectedItem();
			String ward = (String) cbbWard.getSelectedItem();
			String phone = txtPhone.getText();
			String email = txtEmail.getText();
			String idString = txtUserID.getText();
			int idInt = Integer.parseInt(idString);
			String sql = "UPDATE ffse1702011_user_information SET User_Code='"+userCode+"',User_Name='"+userName+"',Address='"+address+"',Phone='"+phone+"',Meter_Code='"+meterCode+"',District='"+district+"',Ward='"+ward+"',Email='"+email+"' WHERE ID='"+idInt+"'";
			Statement statement = conn.createStatement();
			int x = statement.executeUpdate(sql);
			if(x>0) {
				JOptionPane.showMessageDialog(null, "Cập nhật thành công");
			} else {
				JOptionPane.showMessageDialog(null, "Cập nhật thất bại");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		txtUserCode.setText("");
		txtUserName.setText("");
		txtAddress.setText("");
		txtMeterCode.setText("");
		txtPhone.setText("");
		txtEmail.setText("");
	}
	
	public void editDisplay() {
		try {
			String stringID = txtUserID.getText();
			int intID = Integer.parseInt(stringID);
			String sql = "select * from ffse1702011_user_information WHERE ID = '"+intID+"'";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
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
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//FIND USER INFORMATION
	ActionListener eventFind = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			demoTable.getDataVector().removeAllElements();
			demoTable.fireTableDataChanged();
			try {
				findInfo();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	};
	
	public void findInfo() throws MyException {
		if(myEx.chkFindUserCode(txtUserCode.getText())) {
			String userCode = txtUserCode.getText();
			String userName = txtUserName.getText();
			try {
				String sql = "select * from ffse1702011_user_information ";
				String sqlWhere = null;
				if(userCode != "" && userName.isEmpty()) {
					sqlWhere = sql.concat("where User_Code = '"+userCode+"'");
				} else if(userName != "" && userCode.isEmpty()) {
					sqlWhere = sql.concat("where User_Name LIKE '%"+userName+"%'");
				} else {
					sqlWhere = sql.concat(" ");
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
			txtUserCode.setText("");
			txtUserName.setText("");
		}
	}
	
	//DELETE USER INFORMATION
	ActionListener eventDel = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			demoTable.getDataVector().removeAllElements();
			demoTable.fireTableDataChanged();
			delInfo();
		}
	};
	
	public void delInfo() {
		String stringID = txtUserID.getText();
		int intID = Integer.parseInt(stringID);
		try {
			String sql = "DELETE FROM `ffse1702011_user_information` WHERE ID = '"+intID+"'";
			Statement statement = conn.createStatement();
			int x = statement.executeUpdate(sql);
			if(x > 0) {
				JOptionPane.showMessageDialog(null, "Xoá thành công");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		txtUserCode.setText("");
		txtUserName.setText("");
		txtAddress.setText("");
		txtMeterCode.setText("");
		txtPhone.setText("");
		txtEmail.setText("");
	}
	
	public void addEvents() {
		table.addMouseListener(eventClick);
		cbbDistrict.addActionListener(eventCombobox);
		btnAdd.addActionListener(eventAdd);
		btnEdit.addActionListener(eventEdit);
		btnFind.addActionListener(eventFind);
		btnDel.addActionListener(eventDel);
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
