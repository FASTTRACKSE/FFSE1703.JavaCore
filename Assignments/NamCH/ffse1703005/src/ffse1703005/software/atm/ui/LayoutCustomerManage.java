package ffse1703005.software.atm.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ffse1703005.software.atm.model.*;
/*tạo class LayoutCustomerManage kế thừa JPanel*/
public class LayoutCustomerManage extends JPanel{

	private static final long serialVersionUID = 1L;
	private NumberFormat balanceFormat;
	private JComboBox<String> cboWards,cboDistricts;
	private JTextField txtSeacher,txtFullname,txtPhone,txtEmail,txtStreets,txtCode,txtAccountNumber,txtBalance;
	private JButton btnAddCus,btnEditCus,btnDeleteCus,btnCancelCus,btnUpdate;
	private JPanel pnList = new JPanel();;
	private DefaultTableModel list =new DefaultTableModel();;
	private final JTable tbl=new JTable(list);
	private ArrayList<String> arrAdress = new ArrayList<String>();
	private StamentAdress adress = new StamentAdress();
	private Customer ctm;
	private ArrayList<Customer> arrCtm;
	private ArrayList<Customer> arrCtmAll;
	public LayoutCustomerManage() {
		addControlls();
		addEvents();
		/*Hiển thi Quận Từ phương thức SeclectDis của class StamentAdress*/
		arrAdress = adress.SeclectDis();
		for(String x:arrAdress) {
			cboDistricts.addItem(x);
		}
		arrCtm = new ArrayList<Customer>();
		arrCtm = CustomerDB.getCustomersList();
		arrCtmAll = new ArrayList<Customer>();
		arrCtmAll = CustomerDB.getCustomersList();
		printListCus();
	}

	private void addControlls() {
		try {
			this.setOpaque(false);		
			
			JPanel pnMain = new JPanel();
			pnMain.setOpaque(false);	
			/*set boxlayout cho pnMail*/
			pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.X_AXIS));
			pnMain.setPreferredSize(new Dimension(1050, 587));
			pnMain.setMaximumSize(pnMain.getPreferredSize() );
			
			JPanel pnCenter = new JPanel();
			pnCenter.setOpaque(false);
			
			JPanel pnSeacher = new JPanel();
			pnSeacher.setOpaque(false);
			pnSeacher.setPreferredSize(new Dimension(700, 35));
			pnSeacher.setMaximumSize(pnSeacher.getPreferredSize() );
			
			JPanel pnSeacherLeft = new JPanel();
			pnSeacherLeft.setOpaque(false);
			pnSeacherLeft.setPreferredSize(new Dimension(350, 35));
			pnSeacherLeft.setMaximumSize(pnSeacherLeft.getPreferredSize() );
			pnSeacher.add(pnSeacherLeft);
			JPanel pnSeacherRight = new JPanel();
			pnSeacherRight.setOpaque(false);
			JLabel lblSeacher=new JLabel("            Tìm Kiếm : ");
			lblSeacher.setOpaque(false);
			pnSeacherRight.add(lblSeacher);
			txtSeacher = new JTextField(20);		
			pnSeacherRight.add(txtSeacher);
			pnSeacher.add(pnSeacherRight);
			
			pnCenter.add(pnSeacher);
			/*set boxlayout cho pnCenter*/
			pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
			pnCenter.setPreferredSize(new Dimension(700, 587));
			pnCenter.setMaximumSize(pnCenter.getPreferredSize() );
			/*set Border cho pnCenter*/
			Border titleBorderList;
			Border blueBorderList = BorderFactory.createLineBorder(Color.BLACK,2);
			titleBorderList = BorderFactory.createTitledBorder(blueBorderList,"DANH SÁCH KHÁCH HÀNG",
			        TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
			pnList.setBorder(titleBorderList);
			pnList.setPreferredSize(new Dimension(700, 400));
			pnList.setMaximumSize(pnList.getPreferredSize() );	
			/*Add column cho table*/
			list.addColumn("Mã Khách Hàng");
			list.addColumn("Họ Và Tên");
			list.addColumn("Số Điện Thoại");
			list.addColumn("Địa Chỉ Email");
			list.addColumn("Số Tài Khoảng");
			list.addColumn("Số Dư Tài Khoảng");						
			JScrollPane sc=new JScrollPane(tbl);		
			pnList.setLayout(new BorderLayout());
			pnList.add(sc,BorderLayout.CENTER);
			pnCenter.add(pnList);
			/*Canh chỉnh các value các cột sang bên phải*/
			DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
			rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
			tbl.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
			tbl.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
			tbl.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
			pnMain.add(pnCenter);
			
			JPanel pnAction = new JPanel();
			
			pnAction.setPreferredSize(new Dimension(350, 587));
			pnAction.setMaximumSize(pnAction.getPreferredSize() );
			/*set Border cho pnAction*/
			Border titleBorderAction;
			Border blueBorderAction = BorderFactory.createLineBorder(Color.BLACK,3);
			titleBorderAction = BorderFactory.createTitledBorder(blueBorderAction,"",
			        TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
			pnAction.setBorder(titleBorderAction);
			pnAction.setOpaque(false);
			
			
			JPanel pnInformation = new JPanel();
			pnInformation.setOpaque(false);
			/*set Border cho pnInformation*/
			Border titleBorderInfor;
			Border blueBorderInfor = BorderFactory.createLineBorder(Color.GRAY);
			titleBorderInfor = BorderFactory.createTitledBorder(blueBorderInfor,"Thông tin Cá nhân",
			        TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
			pnInformation.setBorder(titleBorderInfor);
			pnInformation.setOpaque(false);
			
			JLabel lblFullname = new JLabel("Họ Và Tên :");
			txtFullname = new JTextField(20);
			
			JLabel lblPhone = new JLabel("Số Điện Thoại :");
			txtPhone = new JTextField(20);		

			JLabel lblEmail = new JLabel("Địa Chỉ Email :");
			txtEmail = new JTextField(20);	
			/*Group layout để canh chỉnh lề cho các Jlabel và JtextField*/
			GroupLayout infolayout = new GroupLayout(pnInformation);
			pnInformation.setLayout(infolayout);
			infolayout.setAutoCreateGaps(true);
			infolayout.setAutoCreateContainerGaps(true);
			
			infolayout.setHorizontalGroup(infolayout.createSequentialGroup()
				.addGroup(infolayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
					.addComponent(lblFullname, 0, 100, Short.MAX_VALUE)
					.addComponent(lblPhone)
					.addComponent(lblEmail)
				)
				.addGroup(infolayout.createParallelGroup()
					.addComponent(txtFullname)
					.addComponent(txtPhone)
					.addComponent(txtEmail)
				)
			);
			
			infolayout.setVerticalGroup(infolayout.createSequentialGroup()
				.addGroup(infolayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(lblFullname)
					.addComponent(txtFullname)
				)			
				.addGroup(infolayout.createParallelGroup()
						.addComponent(lblPhone)
						.addComponent(txtPhone)
					)
				.addGroup(infolayout.createParallelGroup()
						.addComponent(lblEmail)
						.addComponent(txtEmail)
					)
			);
			
			
			JPanel pnAdress = new JPanel();
			/*set BoxLayout cho pnAdress*/
			pnAdress.setLayout(new BoxLayout(pnAdress, BoxLayout.Y_AXIS));
			pnAdress.setOpaque(false);
			/*set Border cho pnAdress*/
			Border titleBorderAdress;
			Border blueBorderAdress = BorderFactory.createLineBorder(Color.GRAY);
			titleBorderAdress = BorderFactory.createTitledBorder(blueBorderAdress,"Địa Chỉ",
			        TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
			pnAdress.setBorder(titleBorderAdress);
			pnAdress.setOpaque(false);
					
			JLabel lblDistricts = new JLabel("Quận :");
			cboDistricts=new JComboBox<>();
			cboDistricts.addItem("Chọn Quận");
			

			JLabel lblWards = new JLabel("Phường :");
			cboWards=new JComboBox<>();
			cboWards.addItem("Chọn Phường");
			

			JLabel lblStreets = new JLabel("Địa Chỉ Nhà :");
			txtStreets = new JTextField(20);
			/*Group layout để canh chỉnh lề cho các Jlabel và JtextField*/
			GroupLayout adressLayout = new GroupLayout(pnAdress);
			pnAdress.setLayout(adressLayout);
			adressLayout.setAutoCreateGaps(true);
			adressLayout.setAutoCreateContainerGaps(true);
			
			adressLayout.setHorizontalGroup(adressLayout.createSequentialGroup()
				.addGroup(adressLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
					.addComponent(lblDistricts, 0, 100, Short.MAX_VALUE)
					.addComponent(lblWards)
					.addComponent(lblStreets)
				)
				.addGroup(adressLayout.createParallelGroup()
					.addComponent(cboDistricts)
					.addComponent(cboWards)
					.addComponent(txtStreets)
				)
			);
			
			adressLayout.setVerticalGroup(adressLayout.createSequentialGroup()
				.addGroup(adressLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(lblDistricts)
					.addComponent(cboDistricts)
				)
				.addGroup(adressLayout.createParallelGroup()
						.addComponent(lblWards)
						.addComponent(cboWards)
					)
				.addGroup(adressLayout.createParallelGroup()
						.addComponent(lblStreets)
						.addComponent(txtStreets)
					)
			);
			
			JPanel pnAccount = new JPanel();
			pnAccount.setOpaque(false);
			/*set BoxLayout cho pnAccount*/
			pnAccount.setLayout(new BoxLayout(pnAccount, BoxLayout.Y_AXIS));
			/*set Border cho pnAccount*/
			Border titleBorderAccount;
			Border blueBorderAccount = BorderFactory.createLineBorder(Color.GRAY);
			titleBorderAccount = BorderFactory.createTitledBorder(blueBorderAccount,"Thông tin tài khoảng",
			        TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
			pnAccount.setBorder(titleBorderAccount);
			pnAccount.setOpaque(false);
			
			
			JLabel lblCode = new JLabel("Mã Khách Hàng :");
			txtCode = new JTextField(20);		
			

			JLabel lblAccountNumber = new JLabel("Số Tài Khoảng :");
			txtAccountNumber = new JTextField(20);

			
			
			JLabel lblBalance = new JLabel("Số Dư :");	
			/*format cho số dư */
			balanceFormat = NumberFormat.getNumberInstance();
			txtBalance = new JFormattedTextField(balanceFormat);
			((JFormattedTextField) txtBalance).setValue(new Float("50000"));
			txtBalance.setEditable(false);
			/*Group layout để canh chỉnh lề cho các Jlabel và JtextField*/
			GroupLayout accountLayout = new GroupLayout(pnAccount);
			pnAccount.setLayout(accountLayout);
			accountLayout.setAutoCreateGaps(true);
			accountLayout.setAutoCreateContainerGaps(true);
			
			accountLayout.setHorizontalGroup(accountLayout.createSequentialGroup()
				.addGroup(accountLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
					.addComponent(lblCode, 0, 100, Short.MAX_VALUE)
					.addComponent(lblAccountNumber)
					.addComponent(lblBalance)
				)
				.addGroup(accountLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
					.addComponent(txtCode, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(txtAccountNumber)
					.addComponent(txtBalance)
				)
			);
			
			accountLayout.setVerticalGroup(accountLayout.createSequentialGroup()
				.addGroup(accountLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(lblCode)
					.addComponent(txtCode)
				)
				.addGroup(accountLayout.createParallelGroup()
						.addComponent(lblAccountNumber)
						.addComponent(txtAccountNumber)
					)
				.addGroup(accountLayout.createParallelGroup()
						.addComponent(lblBalance)
						.addComponent(txtBalance)
					)
			);
			
			JPanel pnMethod = new JPanel();
			pnMethod.setOpaque(false);
			btnAddCus = new JButton("Thêm");
			btnEditCus = new JButton("Sửa");
			btnDeleteCus = new JButton("Xóa");
			btnCancelCus = new JButton("Hủy");
			btnEditCus.setEnabled(false);
			btnDeleteCus.setEnabled(false);
			pnMethod.add(btnAddCus);
			pnMethod.add(btnEditCus);
			pnMethod.add(btnDeleteCus);
			pnMethod.add(btnCancelCus);
			
			JPanel pnUpdate = new JPanel();
			pnUpdate.setOpaque(false);
			btnUpdate = new JButton("Cập Nhập Dữ Liệu");
			pnUpdate.add(btnUpdate);
			
			pnAction.add(pnInformation);
			pnAction.add(pnAdress);
			pnAction.add(pnAccount);
			pnAction.add(pnMethod);
			pnAction.add(pnUpdate);
			
			pnMain.add(pnAction);
			this.add(pnMain);
		}catch (Exception e) {
			
		}
		
		
	}

	private void addEvents() {
		tbl.addMouseListener(eventChooseRow);
		cboDistricts.addActionListener(eventChooseDistricts);
		btnAddCus.addActionListener(eventAddCus);
		btnEditCus.addActionListener(eventEditCus);
		btnDeleteCus.addActionListener(eventDeleteCus);
		btnCancelCus.addActionListener(eventCancelCus);
		txtSeacher.getDocument().addDocumentListener(eventSearch);
		btnUpdate.addActionListener(eventUpdate);
	}
	/*Cập nhập lại ArrayList*/
	ActionListener eventUpdate = new ActionListener() {
		public void actionPerformed(ActionEvent e) {			
			arrCtm = CustomerDB.getCustomersList();
			arrCtmAll = CustomerDB.getCustomersList();
			printListCus();
			String msgXoa ="Cập Nhập Thành Công Dữ Liệu Mới Nhất !!!";
			JOptionPane.showMessageDialog(null, msgXoa, "Cập Nhập Dữ Liệu!!!", JOptionPane.INFORMATION_MESSAGE);
		}
    };
    /*Sự kiện khi Button Hủy thay đổi sẽ gọi phương thức resetAll*/
	ActionListener eventCancelCus = new ActionListener() {
		public void actionPerformed(ActionEvent e) {			
			resetAll();	
		}
    };
    /*Sự kiện khi chọn quận sẽ in vào combobox Phường*/
	ActionListener eventChooseDistricts = new ActionListener() {
		public void actionPerformed(ActionEvent e) {			
			int keys = cboDistricts.getSelectedIndex();
			if (keys==0) {
				cboWards.removeAllItems();
				cboWards.addItem("Chọn Phường");
			}else {
				arrAdress = adress.SeclectWard(keys);
				cboWards.removeAllItems();
				for(String x:arrAdress) {
					cboWards.addItem(x);
				}
			}						
		}
    };
    /*Sự kiện lấy giá trị từ textfield và combobox đưa vào database*/
    ActionListener eventAddCus = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			/*Lấy các giá trị từ phương thức getValueIntput*/
			ctm = getValueIntput();	
			if(ctm==null) {
				
			}else {
				boolean checkCode=false;
				boolean checkAcc=false;
				String code = txtCode.getText();
				String accNum = txtAccountNumber.getText();
				for(Customer x:arrCtmAll ) {
					if(code.equals(x.getCodeCus())) {						
						checkCode=true;
					}
				}
				for(Customer x:arrCtmAll ) {
					if(accNum.equals(x.getCardnumberCus())) {						
						checkAcc=true;
					}
				}
				if(checkCode) {
					String msg = "Đã Tồn Tại Khách Hàng Có Mã : "+code;
					JOptionPane.showMessageDialog(null, msg, "Lỗi Thêm Khách Hàng!!!", JOptionPane.INFORMATION_MESSAGE);
				}else if(checkAcc){
					String msg = "Đã Tồn Tại Khách Hàng Có Số Tài Khoản : "+accNum;
					JOptionPane.showMessageDialog(null, msg, "Lỗi Thêm Khách Hàng!!!", JOptionPane.INFORMATION_MESSAGE);
				}else {				
					/*kiểm tra đã thêm dữ liệu thành công chưa từ phương thức addCustomer của class CustomerDB*/
					int check =CustomerDB.addCustomer(ctm);
					if (check>-1) {
						String msg = "Thêm Thành Công Khách Hàng : "+txtFullname.getText()
									+"\nSố Tài Khoản : "+txtAccountNumber.getText()
									+"\nMã Pin Mặc Định Của Khách Là : 123456";
						JOptionPane.showMessageDialog(null, msg, "Thêm Khách Hàng!!!", JOptionPane.INFORMATION_MESSAGE);
					}
					/*cập Nhập lại ArrayList rồi in ra table*/
					arrCtmAll = CustomerDB.getCustomersList();
					updateArrCtm();
					printListCus();
					resetAll();
				}
				
			}
			
		}
    };
    /*Sự kiện Sửa các giá trị rồi đưa lên database*/
    ActionListener eventEditCus = new ActionListener() {
		public void actionPerformed(ActionEvent e) {	
			/*Lấy các giá trị từ phương thức getValueIntput*/
			ctm = getValueIntput();
			if(ctm==null) {
				
			}else {
				String fullname = txtFullname.getText();
				String phone = txtPhone.getText();
				String email = txtEmail.getText();
				String street = txtStreets.getText();
				String code = txtCode.getText();				
				int keyDistricts = cboDistricts.getSelectedIndex();
				String wards = (String) cboWards.getSelectedItem();
				int keyWards = adress.SeclectIdWards(wards);
				int balance = ((Number) ((JFormattedTextField) txtBalance).getValue()).intValue();
				for(Customer x:arrCtmAll) {
					/*validate khi sữa*/
					if(code.equals(x.getCodeCus())) {
						if(fullname.equals(x.getFullnameCus())
						&&phone.equals(x.getPhoneCus())
						&&email.equals(x.getEmailCus())
						&&keyDistricts==x.getDistrictCus()
						&&keyWards==x.getWardCus()
						&&street.equals(x.getStreetCus())
						&&balance==x.getAmountCus()) {
							String msg = "Chưa Dòng Nào Được Sửa \n ";
							JOptionPane.showMessageDialog(null, msg, "Sửa Khách Hàng!!!", JOptionPane.INFORMATION_MESSAGE);
						}else {
							/*kiểm tra đã sửa dữ liệu thành công chưa từ phương thức editCustomer của class CustomerDB*/
							int check =CustomerDB.editCustomer(ctm);
							if (check>-1) {
								String msg = "Sửa Thành Công Khách Hàng : "+txtFullname.getText()
											+"\nSố Tài Khoản : "+txtAccountNumber.getText()
											+"\nMã Khách Hàng : "+txtCode.getText();
								JOptionPane.showMessageDialog(null, msg, "Sửa Khách Hàng!!!", JOptionPane.INFORMATION_MESSAGE);
							}
						}
					}
				}
				/*cập Nhập lại ArrayList rồi in ra table*/
				arrCtmAll = CustomerDB.getCustomersList();
				resetAll();
				updateArrCtm();
				printListCus();
			}
			
		}
    };
    /*Sự kiện Xóa các giá trị trong database*/
    ActionListener eventDeleteCus = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String msg = "Xóa Bạn Có Muốn Xóa Khách Hàng : "+txtFullname.getText()
			+"\nSố Tài Khoản : "+txtAccountNumber.getText()
			+"\nMã Khách Hàng : "+txtCode.getText();
			int i = JOptionPane.showConfirmDialog(null, msg, "Xóa Khách Hàng!!!", JOptionPane.YES_NO_OPTION);
			if (i == JOptionPane.YES_OPTION) {
				String code = txtCode.getText();
				/*kiểm tra đã sửa dữ liệu thành công chưa từ phương thức delCustomer của class CustomerDB*/
				int check = CustomerDB.delCustomer(code);
				if(check>-1) {
					String msgXoa = "Xóa Thành Công Khách Hàng : "+txtFullname.getText();
					JOptionPane.showMessageDialog(null, msgXoa, "Xóa Khách Hàng!!!", JOptionPane.INFORMATION_MESSAGE);
					arrCtmAll = CustomerDB.getCustomersList();
					updateArrCtm();
					printListCus();
					resetAll();
				}
			}						
		}
    };
    /*Sự kiện khi click vào các dòng trong table*/
    MouseAdapter eventChooseRow = new MouseAdapter() {
    	public void mouseClicked(MouseEvent e) {
    		txtBalance.setEditable(true);
    		txtCode.setEditable(false);
    		txtAccountNumber.setEditable(false);
    		/*Lấy index số dòng khi click*/
    		int col = tbl.getSelectedRow();
    		String[] row = new String[5];	    		
    		row[0] = (String) tbl.getValueAt(col, 0);
    		row[1] = (String) tbl.getValueAt(col, 1);
    		row[2] = (String) tbl.getValueAt(col, 2);
    		row[3] = (String) tbl.getValueAt(col, 3);
    		row[4] = (String) tbl.getValueAt(col, 4);
    		txtCode.setText(row[0]);
    		txtFullname.setText(row[1]);
    		txtPhone.setText(row[2]);
    		txtEmail.setText(row[3]);
    		txtAccountNumber.setText(row[4]);
    		/*duyệt mảng ArrayList để lấy các giá trị đưa vào Ô textfield*/
			for(int i=0;i<arrCtm.size();i++) {
				if(row[0].equals(arrCtm.get(i).getCodeCus())) {
					((JFormattedTextField) txtBalance).setValue(new Double(arrCtm.get(i).getAmountCus()));
					txtStreets.setText(arrCtm.get(i).getStreetCus());
					cboDistricts.setSelectedIndex(arrCtm.get(i).getDistrictCus());
					cboWards.setSelectedItem(arrCtm.get(i).getNameWards());					
				}
			}
			btnAddCus.setEnabled(false);
			btnEditCus.setEnabled(true);
			btnDeleteCus.setEnabled(true);
    	}
    };
    /*Sự kiện khi tìm kiếm sẽ gọi phương thức searcher*/
    private DocumentListener eventSearch = new DocumentListener() {		
		@Override
		public void changedUpdate(DocumentEvent e) {
			searcher();
		}
		@Override
		public void insertUpdate(DocumentEvent e) {
			searcher();
		}
		@Override
		public void removeUpdate(DocumentEvent e) {
			searcher();
		}
	};
	/*Tìm kiếm tên đường theo ArrayList*/
	private void searcher() {
		String nameSearch = txtSeacher.getText();
		list.setRowCount(0);
		/*Duyệt mảng */
		for(Customer x:arrCtmAll) {		
			if(x.getFullnameCus().toUpperCase().trim().indexOf(nameSearch.toUpperCase().trim()) > -1) {				
				String phone = String.valueOf(x.getPhoneCus());
				String[] row = {x.getCodeCus(), x.getFullnameCus(), phone,x.getEmailCus(),x.getCardnumberCus(),String.format("%,d", (long) x.getAmountCus())+" VNĐ"};
				list.addRow(row);	
			}			
		}
	}
	 /*Cập nhập ArrayList*/
	private ArrayList<Customer> updateArrCtm() {
    	return arrCtm = arrCtmAll;
    }
	/*phương thức in vào các dòng trong bảng từ Arraylist*/
    private void printListCus() {
    	list.setRowCount(0);
    	for (Customer ctm : arrCtm) { 		
			String phone = String.valueOf(ctm.getPhoneCus());
			String[] row = {ctm.getCodeCus(), ctm.getFullnameCus(), phone,ctm.getEmailCus(),ctm.getCardnumberCus(),String.format("%,d", (long) ctm.getAmountCus())+" VNĐ"};
			list.addRow(row);
		}
    }
    /*Phương thức lấy giá trị của các ô TextField và combobox*/
    private Customer getValueIntput() {
    	ctm = new Customer();
		String fullname = txtFullname.getText();
		String phone = txtPhone.getText();
		String email = txtEmail.getText();
		String street = txtStreets.getText();
		String code = txtCode.getText();
		String accountNumber = txtAccountNumber.getText();
		
		int keyDistricts = cboDistricts.getSelectedIndex();
		String wards = (String) cboWards.getSelectedItem();
		int keyWards = adress.SeclectIdWards(wards);
		/*Validate các giá trị lấy về*/
		if(fullname.isEmpty()&&phone.isEmpty()&&email.isEmpty()&&street.isEmpty()&&code.isEmpty()
				&& accountNumber.isEmpty() && keyDistricts==0 && txtBalance.getText().isEmpty()) {
			String msg = "Chưa Nhập!!!\nThông Tin Của Khách Hàng";
			JOptionPane.showMessageDialog(null, msg, "Lỗi Chưa Nhập!!!", JOptionPane.INFORMATION_MESSAGE);
			return ctm=null;
		}else if(fullname.isEmpty()||phone.isEmpty()||email.isEmpty()){
			txtFullname.requestFocus();
			String msg = "Phải Điền Đầy Đủ!!!\nPhần Thông Tin Cá Nhân";
			JOptionPane.showMessageDialog(null, msg, "Lỗi Chưa Nhập!!!", JOptionPane.INFORMATION_MESSAGE);
			return ctm=null;
		}else if(street.isEmpty()|| keyDistricts==0){
			cboDistricts.showPopup();
			String msg = "Phải Điền Đầy Đủ!!!\nPhần Địa Chỉ";
			JOptionPane.showMessageDialog(null, msg, "Lỗi Chưa Nhập!!!", JOptionPane.INFORMATION_MESSAGE);
			return ctm=null;
		}else if(code.isEmpty()|| accountNumber.isEmpty()|| txtBalance.getText().isEmpty()){
			cboDistricts.showPopup();
			String msg = "Phải Điền Đầy Đủ!!!\nPhần Thông Tin Tài Khoảng";
			JOptionPane.showMessageDialog(null, msg, "Lỗi Chưa Nhập!!!", JOptionPane.INFORMATION_MESSAGE);	
			return ctm=null;
		}else {			
			String phoneReg = "0\\d{9,10}";
			Pattern phonePatt = Pattern.compile(phoneReg);
			Matcher phoneMat = phonePatt.matcher(phone);
			if(!phoneMat.find()) {
				txtPhone.requestFocus();
	        	String msg = "Nhập Sai Định Dạng Số Điện Thoại";
				JOptionPane.showMessageDialog(null, msg, "Lỗi Nhập Sai Định Dạng", JOptionPane.INFORMATION_MESSAGE);
				return ctm=null;
			}
				 Pattern validate = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
				 Matcher matcher = validate .matcher(email);
				 if(!matcher.find()) {
					 txtEmail.requestFocus();
			        	String msg = "Nhập Sai Định Dạng Email.\nĐịnh Dạng Đúng :tpbank@gmail.com ";
						JOptionPane.showMessageDialog(null, msg, "Lỗi Nhập Sai Định Dạng", JOptionPane.INFORMATION_MESSAGE);
						return ctm=null;
				 }
			int balance = ((Number) ((JFormattedTextField) txtBalance).getValue()).intValue();
				if(balance<0) {
					 txtBalance.requestFocus();
			        	String msg = "Số Tài Khoảng Phải Lớn Hơn 0";
						JOptionPane.showMessageDialog(null, msg, "Lỗi Nhập Sai Định Dạng", JOptionPane.INFORMATION_MESSAGE);
						return ctm=null;
				}
			ctm.add(code,fullname,keyDistricts,keyWards,street,phone,email,accountNumber,"123456",balance);
			return ctm;
		}
    }
    /*phương thức reset về trống cho các ô textfield và combobox*/
    private void resetAll() {
    	txtFullname.setText("");
		txtPhone.setText("");
		txtEmail.setText("");
		txtStreets.setText("");
		txtCode.setText("");
		((JFormattedTextField) txtBalance).setValue(new Float("50000"));
		txtBalance.setEditable(false);
		txtAccountNumber.setText("");	
		cboDistricts.setSelectedIndex(0);
		txtAccountNumber.setText("");
		tbl.clearSelection();
		txtCode.setEditable(true);
		txtAccountNumber.setEditable(true);
		btnAddCus.setEnabled(true);
		btnEditCus.setEnabled(false);
		btnDeleteCus.setEnabled(false);	
    }
}
