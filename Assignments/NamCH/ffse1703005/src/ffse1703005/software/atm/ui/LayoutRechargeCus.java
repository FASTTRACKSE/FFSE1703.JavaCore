
package ffse1703005.software.atm.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
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

import ffse1703005.software.atm.model.Customer;
import ffse1703005.software.atm.model.CustomerDB;
import ffse1703005.software.atm.model.TransactionsDb;
/*tạo class LayoutRechargeCus kế thừa JPanel*/
public class LayoutRechargeCus extends JPanel{
	private static final long serialVersionUID = 1L;
	private JButton btnClearInfor,btnRecharge,btnUpdate;
	private JTextField txtFullname,txtPhone,txtEmail,txtCode,txtRecharge;
	private JTextField txtDetailFullname,txtDetailPhone,txtDetailEmail,txtDetailDistricts,txtDetailWards,
	txtDetailStreets,txtDetailCode,txtDetailAccNumber,txtDetailBalance;
	private String nameSearch="",phoneSearch="",emailSearch="",codeSearch="";
	private DefaultTableModel list=new DefaultTableModel();
	private final JTable tbl=new JTable(list);
	private ArrayList<Customer> arrCtm;
	private ArrayList<Customer> arrCtmAll;
	public LayoutRechargeCus() {
		addControlls();
		addEvents();		
		arrCtmAll = new ArrayList<Customer>();
		arrCtmAll = CustomerDB.getCustomersList();
		arrCtm = new ArrayList<Customer>();
		arrCtm = updateArrCtm();
	}

	private void addControlls() {
		try {
			this.setOpaque(false);		
			
			JPanel pnMain = new JPanel();
			pnMain.setOpaque(false);	
			/*set BoxLayout cho pnMain*/
			pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.X_AXIS));
			pnMain.setPreferredSize(new Dimension(1050, 587));
			pnMain.setMaximumSize(pnMain.getPreferredSize() );
			
			JPanel pnCenter = new JPanel();
			pnCenter.setOpaque(false);		
			/*set BoxLayout cho pnCenter*/
			pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
			pnCenter.setPreferredSize(new Dimension(700, 587));
			pnCenter.setMaximumSize(pnCenter.getPreferredSize() );
			
			JPanel pnSeacher = new JPanel();
			pnSeacher.setOpaque(false);
			pnSeacher.setPreferredSize(new Dimension(700, 35));
			pnSeacher.setMaximumSize(pnSeacher.getPreferredSize() );
			pnCenter.add(pnSeacher);
			
			JPanel pnList = new JPanel();
			/*set Border cho pnList*/
			Border titleBorderList;
			Border blueBorderList = BorderFactory.createLineBorder(Color.BLACK,2);
			titleBorderList = BorderFactory.createTitledBorder(blueBorderList,"CHỌN KHÁCH HÀNG",
			        TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
			pnList.setBorder(titleBorderList);
			pnList.setPreferredSize(new Dimension(700,220));
			pnList.setMaximumSize(pnList.getPreferredSize() );
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
			/*Cảnh chỉnh value cột nằm bên phải của table*/
			DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
			rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
			tbl.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
			tbl.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
			tbl.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
			
			
			
			JPanel pnDetail = new JPanel();
			/*set BoxLayout cho pnDetail*/
			pnDetail.setLayout(new BoxLayout(pnDetail, BoxLayout.Y_AXIS));
			/*set Border cho pnDetail*/
			Border titleBorderDetail;
			Border blueBorderDetail = BorderFactory.createLineBorder(Color.BLACK,2);
			titleBorderDetail = BorderFactory.createTitledBorder(blueBorderDetail,"Nạp Tiền Cho Khách Hàng",
			        TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
			pnDetail.setBorder(titleBorderDetail);
			pnDetail.setPreferredSize(new Dimension(700,190));
			pnDetail.setMaximumSize(pnDetail.getPreferredSize() );
			pnCenter.add(pnDetail);
			
			JPanel pnAllInfor = new JPanel();
			/*set BoxLayout cho pnAllInfor*/
			pnAllInfor.setLayout(new BoxLayout(pnAllInfor, BoxLayout.X_AXIS));
			
			JPanel pnDetailInfor = new JPanel();
			JLabel lblDetailFn = new JLabel("Họ Và Tên :");
			txtDetailFullname = new JTextField(20);
			txtDetailFullname.setEditable(false);
			
			JLabel lblDetailP = new JLabel("Số Điện Thoại :");
			txtDetailPhone = new JTextField(20);	
			txtDetailPhone.setEditable(false);

			JLabel lblDetailE = new JLabel("Địa Chỉ Email :");
			txtDetailEmail = new JTextField(20);
			txtDetailEmail.setEditable(false);
			/*Group layout để canh chỉnh lề cho các Jlabel và JtextField*/
			GroupLayout infoDetailLayout = new GroupLayout(pnDetailInfor);
			pnDetailInfor.setLayout(infoDetailLayout);
			infoDetailLayout.setAutoCreateGaps(true);
			infoDetailLayout.setAutoCreateContainerGaps(true);
			
			infoDetailLayout.setHorizontalGroup(infoDetailLayout.createSequentialGroup()
				.addGroup(infoDetailLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
					.addComponent(lblDetailFn, 0, 100, Short.MAX_VALUE)
					.addComponent(lblDetailP)
					.addComponent(lblDetailE)
				)
				.addGroup(infoDetailLayout.createParallelGroup()
					.addComponent(txtDetailFullname)
					.addComponent(txtDetailPhone)
					.addComponent(txtDetailEmail)
				)
			);
			
			infoDetailLayout.setVerticalGroup(infoDetailLayout.createSequentialGroup()
				.addGroup(infoDetailLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(lblDetailFn)
					.addComponent(txtDetailFullname)
				)			
				.addGroup(infoDetailLayout.createParallelGroup()
						.addComponent(lblDetailP)
						.addComponent(txtDetailPhone)
					)
				.addGroup(infoDetailLayout.createParallelGroup()
						.addComponent(lblDetailE)
						.addComponent(txtDetailEmail)
					)
			);
			pnAllInfor.add(pnDetailInfor);
			
			JPanel pnDetailAdress = new JPanel();
			JLabel lblDetailDis = new JLabel("Quận :");
			txtDetailDistricts = new JTextField(20);
			txtDetailDistricts.setEditable(false);
			
			JLabel lblDetailWa = new JLabel("Phường :");
			txtDetailWards = new JTextField(20);
			txtDetailWards.setEditable(false);

			JLabel lblDetailSt = new JLabel("Địa Chỉ Nhà :");
			txtDetailStreets = new JTextField(20);
			txtDetailStreets.setEditable(false);
			/*Group layout để canh chỉnh lề cho các Jlabel và JtextField*/
			GroupLayout adressDetailLayout = new GroupLayout(pnDetailAdress);
			pnDetailAdress.setLayout(adressDetailLayout);
			adressDetailLayout.setAutoCreateGaps(true);
			adressDetailLayout.setAutoCreateContainerGaps(true);
			
			adressDetailLayout.setHorizontalGroup(adressDetailLayout.createSequentialGroup()
				.addGroup(adressDetailLayout.createParallelGroup()
					.addComponent(lblDetailDis)
					.addComponent(lblDetailWa)
					.addComponent(lblDetailSt)
				)
				.addGroup(adressDetailLayout.createParallelGroup()
					.addComponent(txtDetailDistricts)
					.addComponent(txtDetailWards)
					.addComponent(txtDetailStreets)
				)
			);
			
			adressDetailLayout.setVerticalGroup(adressDetailLayout.createSequentialGroup()
				.addGroup(adressDetailLayout.createParallelGroup()
					.addComponent(lblDetailDis)
					.addComponent(txtDetailDistricts)
				)			
				.addGroup(adressDetailLayout.createParallelGroup()
						.addComponent(lblDetailWa)
						.addComponent(txtDetailWards)
					)
				.addGroup(adressDetailLayout.createParallelGroup()
						.addComponent(lblDetailSt)
						.addComponent(txtDetailStreets)
					)
			);
			pnAllInfor.add(pnDetailAdress);
			
			JPanel pnDetailAccount = new JPanel();
			JLabel lblDetailCd = new JLabel("Mã Khách Hàng :");
			txtDetailCode = new JTextField(20);
			txtDetailCode.setEditable(false);
			

			JLabel lblDetailAN = new JLabel("Số Tài Khoảng :");
			txtDetailAccNumber = new JTextField(20);	
			txtDetailAccNumber.setEditable(false);
			
			JLabel lblDetailB = new JLabel("Số Dư :");
			txtDetailBalance = new JTextField(20);
			txtDetailBalance.setEditable(false);
			/*Group layout để canh chỉnh lề cho các Jlabel và JtextField*/
			GroupLayout accountDetailLayout = new GroupLayout(pnDetailAccount);
			pnDetailAccount.setLayout(accountDetailLayout);
			accountDetailLayout.setAutoCreateGaps(true);
			accountDetailLayout.setAutoCreateContainerGaps(true);
			
			accountDetailLayout.setHorizontalGroup(accountDetailLayout.createSequentialGroup()
				.addGroup(accountDetailLayout.createParallelGroup()
					.addComponent(lblDetailCd)
					.addComponent(lblDetailAN)
					.addComponent(lblDetailB)
				)
				.addGroup(accountDetailLayout.createParallelGroup()
					.addComponent(txtDetailCode)
					.addComponent(txtDetailAccNumber)
					.addComponent(txtDetailBalance)
				)
			);
			
			accountDetailLayout.setVerticalGroup(accountDetailLayout.createSequentialGroup()
				.addGroup(accountDetailLayout.createParallelGroup()
					.addComponent(lblDetailCd)
					.addComponent(txtDetailCode)
				)			
				.addGroup(accountDetailLayout.createParallelGroup()
						.addComponent(lblDetailAN)
						.addComponent(txtDetailAccNumber)
					)
				.addGroup(accountDetailLayout.createParallelGroup()
						.addComponent(lblDetailB)
						.addComponent(txtDetailBalance)
					)
			);
			pnAllInfor.add(pnDetailAccount);
			
			JPanel pnRecharge = new JPanel();
			JLabel lblRecharge = new JLabel("Nhập Số Tiền Cần Nạp");
			txtRecharge = new JTextField(20);
			btnRecharge = new JButton("Nạp Tiền");
			pnRecharge.add(lblRecharge);
			pnRecharge.add(txtRecharge);
			pnRecharge.add(btnRecharge);
			
			JPanel pnClear = new JPanel();
			btnClearInfor = new JButton("Clear Thông Tin");
			btnClearInfor.setEnabled(false);
			pnClear.add(btnClearInfor);
			
			pnDetail.add(pnAllInfor);
			pnDetail.add(pnRecharge);
			pnDetail.add(pnClear);
			pnMain.add(pnCenter);
			
			JPanel pnAction = new JPanel();
			
			pnAction.setPreferredSize(new Dimension(350, 587));
			pnAction.setMaximumSize(pnAction.getPreferredSize() );
			/*set Border cho pnAction*/
			Border titleBorderAction;
			Border blueBorderAction = BorderFactory.createLineBorder(Color.BLACK,3);
			titleBorderAction = BorderFactory.createTitledBorder(blueBorderAction,"TÌM KIẾM THEO",
			        TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
			pnAction.setBorder(titleBorderAction);
			pnAction.setOpaque(false);
			
			JPanel pnBlank = new JPanel();
			pnBlank.setPreferredSize(new Dimension(340,140));
			pnBlank.setMaximumSize(pnBlank.getPreferredSize() );
			pnBlank.setOpaque(false);
			pnAction.add(pnBlank);
			
			JPanel pnInformation = new JPanel();
			pnInformation.setPreferredSize(new Dimension(340,140));
			pnInformation.setMaximumSize(pnInformation.getPreferredSize() );
			/*set BoxLayout cho pnInformation*/
			pnInformation.setLayout(new BoxLayout(pnInformation, BoxLayout.Y_AXIS));
			pnInformation.setOpaque(false);
			/*set Border cho pnInformation*/
			Border titleBorderInfor;
			Border blueBorderInfor = BorderFactory.createLineBorder(Color.GRAY);
			titleBorderInfor = BorderFactory.createTitledBorder(blueBorderInfor,"Nhập 1 trong các ô dưới để tìm kiếm",
			        TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
			pnInformation.setBorder(titleBorderInfor);
			pnInformation.setOpaque(false);
			

			JLabel lblFullname = new JLabel("Họ Và Tên :");
			txtFullname = new JTextField(20);

			JLabel lblPhone = new JLabel("Số Điện Thoại :");
			txtPhone = new JTextField(20);
			
			JLabel lblEmail = new JLabel("Địa Chỉ Email :");
			txtEmail = new JTextField(20);
			
			JLabel lblCode = new JLabel("Mã Khách Hàng :");
			txtCode = new JTextField(20);				
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
					.addComponent(lblCode)
				)
				.addGroup(infolayout.createParallelGroup()
					.addComponent(txtFullname)
					.addComponent(txtPhone)
					.addComponent(txtEmail)
					.addComponent(txtCode)
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
				.addGroup(infolayout.createParallelGroup()
						.addComponent(lblCode)
						.addComponent(txtCode)
					)			
			);
											
			pnAction.add(pnInformation);
			JPanel pnUpdate = new JPanel();
			pnUpdate.setOpaque(false);
			btnUpdate = new JButton("Cập Nhập");
			pnUpdate.add(btnUpdate);
			
			pnAction.add(pnUpdate);
			
			pnMain.add(pnAction);
			this.add(pnMain);
		}catch (Exception e) {
		}
		
		
	}

	private void addEvents() {
		tbl.addMouseListener(eventChooseRow);
		txtFullname.getDocument().addDocumentListener(eventSearchFullname);
		txtPhone.getDocument().addDocumentListener(eventSearchPhone);
		txtEmail.getDocument().addDocumentListener(eventSearchEmail);
		txtCode.getDocument().addDocumentListener(eventSearchCode);	
		btnClearInfor.addActionListener(eventClearInfor);
		btnRecharge.addActionListener(eventRecharge);
		btnUpdate.addActionListener(eventUpdate);
	}
	/*update lại arraylist*/
	ActionListener eventUpdate = new ActionListener() {
		public void actionPerformed(ActionEvent e) {			
			arrCtmAll = CustomerDB.getCustomersList();
			updateArrCtm();
			String msgXoa ="Cập Nhập Thành Công Dữ Liệu Mới Nhất !!!";
			JOptionPane.showMessageDialog(null, msgXoa, "Cập Nhập Dữ Liệu!!!", JOptionPane.INFORMATION_MESSAGE);
		}
    };
    /*Sự kiện khi click vào các dòng trong table*/
	MouseAdapter eventChooseRow = new MouseAdapter() {
    	public void mouseClicked(MouseEvent e) {
    		/*Lấy index số dòng khi click*/
    		int col = tbl.getSelectedRow();
    		String[] row = new String[6];	    		
    		row[0] = (String) tbl.getValueAt(col, 0);
    		row[1] = (String) tbl.getValueAt(col, 1);
    		row[2] = (String) tbl.getValueAt(col, 2);
    		row[3] = (String) tbl.getValueAt(col, 3);
    		row[4] = (String) tbl.getValueAt(col, 4);
    		row[5] = (String) tbl.getValueAt(col, 5);
    		txtDetailCode.setText(row[0]);
    		txtDetailFullname.setText(row[1]);
    		txtDetailPhone.setText(row[2]);
    		txtDetailEmail.setText(row[3]);
    		txtDetailAccNumber.setText(row[4]);
    		txtDetailBalance.setText(row[5]);
    		/*duyệt mảng ArrayList để lấy các giá trị đưa vào Ô textfield*/
			for(int i=0;i<arrCtm.size();i++) {
				if(row[0].equals(arrCtm.get(i).getCodeCus())) {
					txtDetailStreets.setText(arrCtm.get(i).getStreetCus());
					txtDetailDistricts.setText(arrCtm.get(i).getNameDistricts());
					txtDetailWards.setText(arrCtm.get(i).getNameWards());									
				}
			}
			btnClearInfor.setEnabled(true);
    	}
    };
	/*Sự kiện nạp tiền*/
    ActionListener eventRecharge = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			ArrayList<Customer> arrCtm = new ArrayList<Customer>();			
			try {
				String codeCus = txtDetailCode.getText();				
				String money = txtRecharge.getText();
				/*validate khi nhập số tiền cần nạp*/
				if(codeCus.isEmpty()) {
					String msg = "Chưa Chọn Khách Hàng";
					JOptionPane.showMessageDialog(null, msg, "Lỗi Nạp Tiền!!!", JOptionPane.INFORMATION_MESSAGE);
				}else {
					int moneyRecharge = Integer.parseInt(money);
					arrCtm = CustomerDB.searchCode(codeCus);
					if(moneyRecharge % 10000 == 0) {
						int balanceCus = (arrCtm.get(0).getAmountCus() + moneyRecharge);	
						/*kiểm tra đã nạp tiền thành công chưa từ phương thức editMoney của class CustomerDB*/
						int checkCus = CustomerDB.editMoney(balanceCus,codeCus);
						if(checkCus >-1) {
							txtRecharge.setText("");							
							    LocalTime localTime=LocalTime.now();
							    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
							    String formattedTime=localTime.format(formatter);
							    
							    Time t = Time.valueOf(formattedTime);
							    System.out.println(formattedTime);
							    long int_transactions = t.getTime();	
							    String code_transactions = "MGD" + int_transactions;
								/*Kiểm tra đã tạo giao dịch thành công hay chưa từ phương thức addTransactions của class TransactionsDb*/
							    int checkTss = TransactionsDb.addTransactions(codeCus, "Tại Hệ Thống", code_transactions , moneyRecharge ,"Nạp Tiền");
								if(checkTss>-1) {
									list.setRowCount(0);
									arrCtmAll = CustomerDB.getCustomersList();
									String msg = "Nạp Thành Công\n"+ String.format("%,d", (long) moneyRecharge)+" VNĐ"+
											" Từ Tài Khoản\n"+"Số Tiền Còn Lại Trong Tài Khoản Của "+arrCtm.get(0).getFullnameCus()+" Là "
											+String.format("%,d", (long) balanceCus)+" VNĐ";
									JOptionPane.showMessageDialog(null, msg, "Nạp Tiền!!!", JOptionPane.INFORMATION_MESSAGE);									
								}																						
						}
											
					}else {
						String msg = "Số tiền mỗi lần nạp là bội số của 10.000 VNĐ";
						JOptionPane.showMessageDialog(null, msg, "Lỗi Nhập!!!", JOptionPane.INFORMATION_MESSAGE);						
					}
				}
			}catch (Exception e1) {
				String msg = "Phải Nhập Số!!!";
				JOptionPane.showMessageDialog(null, msg, "Lỗi Chưa Nhập!!!", JOptionPane.INFORMATION_MESSAGE);
			}
			
		}
    };
    /*Sự kiện khi nhấn vào gọi phương thức clearInfor();*/
    ActionListener eventClearInfor = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			clearInfor();
			btnClearInfor.setEnabled(false);
		}
    };
    /*set các giá trị về trống*/
    public void clearInfor() {
    	txtDetailCode.setText("");
		txtDetailFullname.setText("");
		txtDetailPhone.setText("");
		txtDetailEmail.setText("");
		txtDetailAccNumber.setText("");
		txtDetailBalance.setText("");
		txtDetailStreets.setText("");
		txtDetailDistricts.setText("");
		txtDetailWards.setText("");	
		tbl.clearSelection();
		btnClearInfor.setEnabled(false);
    }    			
	/*tìm kiếm theo tên*/
	private DocumentListener eventSearchFullname = new DocumentListener() {		
		@Override
		public void changedUpdate(DocumentEvent e) {
			changeFullname();
			searchName();
			
		}
		@Override
		public void insertUpdate(DocumentEvent e) {
			changeFullname();
			searchName();
		}
		@Override
		public void removeUpdate(DocumentEvent e) {
			String change = txtFullname.getText();
			if(change.isEmpty()) {
				changeReset();
				arrCtm = updateArrCtm();
				printListCus();
			}else {
				changeFullname();
				searchName();
			}
		}
	};
	/*duyệt arrayList theo tên*/
	private void searchName() {	
		clearInfor();
		nameSearch = txtFullname.getText();
		list.setRowCount(0);
		for(Customer x:arrCtmAll) {		
			if(x.getFullnameCus().toUpperCase().indexOf(nameSearch.toUpperCase()) > -1) {				
				String phone = String.valueOf(x.getPhoneCus());
				String[] row = {x.getCodeCus(), x.getFullnameCus(), phone,x.getEmailCus(),x.getCardnumberCus(),String.format("%,d", (long) x.getAmountCus())+" VNĐ"};
				list.addRow(row);			
			}			
		}												
	}
	
	private void changeFullname() {
		
		txtFullname.setEditable(true);
		txtPhone.setEditable(false);
		txtEmail.setEditable(false);
		txtCode.setEditable(false);
	}
	/*tìm kiếm theo số điện thoại*/
	private DocumentListener eventSearchPhone = new DocumentListener() {		
		@Override
		public void changedUpdate(DocumentEvent e) {
			changePhone();	
			searchPhone();
		}
		@Override
		public void insertUpdate(DocumentEvent e) {
			changePhone();
			searchPhone();
		}
		@Override
		public void removeUpdate(DocumentEvent e) {
			String change = txtPhone.getText();
			if(change.isEmpty()) {
				arrCtm = updateArrCtm();
				printListCus();
				changeReset();
				
			}else {
				changePhone();
				searchPhone();
			}
		}
	};
	/*Duyệt ArrayList theo số đt*/
	private void searchPhone() {	
		clearInfor();
		phoneSearch = txtPhone.getText();
		list.setRowCount(0);
		for(Customer x:arrCtmAll) {		
			if(x.getPhoneCus().toUpperCase().trim().indexOf(phoneSearch.toUpperCase().trim()) > -1) {				
				String phone = String.valueOf(x.getPhoneCus());
				String[] row = {x.getCodeCus(), x.getFullnameCus(), phone,x.getEmailCus(),x.getCardnumberCus(),String.format("%,d", (long) x.getAmountCus())+" VNĐ"};
				list.addRow(row);			
			}			
		}				
	}
	
	private void changePhone() {
		txtFullname.setEditable(false);
		txtPhone.setEditable(true);
		txtEmail.setEditable(false);
		txtCode.setEditable(false);
	}
	/*tìm kiếm theo mail*/
	private DocumentListener eventSearchEmail = new DocumentListener() {		
		@Override
		public void changedUpdate(DocumentEvent e) {
			changeEmail();
			searchEmail();
		}
		@Override
		public void insertUpdate(DocumentEvent e) {
			changeEmail();
			searchEmail();
		}
		@Override
		public void removeUpdate(DocumentEvent e) {
			String change = txtEmail.getText();
			if(change.isEmpty()) {
				arrCtm = updateArrCtm();
				printListCus();
				changeReset();
			}else {
				changeEmail();
				searchEmail();
			}
		}
	};
	/*Duyệt arrayList theo email*/
	private void searchEmail() {
		clearInfor();
		emailSearch = txtEmail.getText();
		list.setRowCount(0);
		for(Customer x:arrCtmAll) {		
			if(x.getEmailCus().toUpperCase().trim().indexOf(emailSearch.toUpperCase().trim()) > -1) {				
				String phone = String.valueOf(x.getPhoneCus());
				String[] row = {x.getCodeCus(), x.getFullnameCus(), phone,x.getEmailCus(),x.getCardnumberCus(),String.format("%,d", (long) x.getAmountCus())+" VNĐ"};
				list.addRow(row);			
			}			
		}				
	}
	
	private void changeEmail() {
		txtFullname.setEditable(false);
		txtPhone.setEditable(false);
		txtEmail.setEditable(true);
		txtCode.setEditable(false);
	}
	/*tìm kiếm theo Mã*/
	private DocumentListener eventSearchCode = new DocumentListener() {		
		@Override
		public void changedUpdate(DocumentEvent e) {
			changeCode();
			searchCode();
		}
		@Override
		public void insertUpdate(DocumentEvent e) {
			changeCode();
			searchCode();
		}
		@Override
		public void removeUpdate(DocumentEvent e) {
			String change = txtCode.getText();
			if(change.isEmpty()) {
				arrCtm = updateArrCtm();
				printListCus();
				changeReset();
			}else {
				changeCode();
				searchCode();
			}
		}
	};
	/*Duyệt mảng theo mã */
	private void searchCode() {	
		clearInfor();
		codeSearch = txtCode.getText();
		list.setRowCount(0);
		for(Customer x:arrCtmAll) {		
			if(x.getCodeCus().toUpperCase().trim().indexOf(codeSearch.toUpperCase().trim()) > -1) {				
				String phone = String.valueOf(x.getPhoneCus());
				String[] row = {x.getCodeCus(), x.getFullnameCus(), phone,x.getEmailCus(),x.getCardnumberCus(),String.format("%,d", (long) x.getAmountCus())+" VNĐ"};
				list.addRow(row);			
			}			
		}				
	}
	
	private void changeCode() {
		txtFullname.setEditable(false);
		txtPhone.setEditable(false);
		txtEmail.setEditable(false);
		txtCode.setEditable(true);
	}	
		
	
	private void changeReset() {
		txtFullname.setEditable(true);
		txtPhone.setEditable(true);
		txtEmail.setEditable(true);
		txtCode.setEditable(true);
	}		
	/*Cập nhập lại ArrayList*/
	private ArrayList<Customer> updateArrCtm() {
    	return arrCtm = arrCtmAll;
    }
    /*in từ ArrayList vào Table*/
    private void printListCus() {
    	arrCtm = arrCtmAll;
    	list.setRowCount(0);
    	for (Customer ctm : arrCtm) { 		
			String phone = String.valueOf(ctm.getPhoneCus());
			String[] row = {ctm.getCodeCus(), ctm.getFullnameCus(), phone,ctm.getEmailCus(),ctm.getCardnumberCus(),String.format("%,d", (long) ctm.getAmountCus())+" VNĐ"};
			list.addRow(row);
		}
    }       
	
}
