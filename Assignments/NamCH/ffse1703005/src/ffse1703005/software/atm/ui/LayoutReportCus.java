
package ffse1703005.software.atm.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
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

import ffse1703005.software.atm.model.CusTransaction;
import ffse1703005.software.atm.model.Customer;
import ffse1703005.software.atm.model.CustomerDB;
import ffse1703005.software.atm.model.StamentAdress;
import ffse1703005.software.atm.model.TransactionsDb;
/*tạo class LayoutReportCus kế thừa JPanel*/
public class LayoutReportCus extends JPanel{
	private static final long serialVersionUID = 1L;
	private JButton btnSearchAdress,btnCancelAdress,btnClearInfor,btnUpdate;
	private JComboBox<String> cboDistricts,cboWards;
	private JTextField txtFullname,txtPhone,txtEmail,txtCode,txtStreets;
	private JTextField txtDetailFullname,txtDetailPhone,txtDetailEmail,txtDetailDistricts,txtDetailWards,
	txtDetailStreets,txtDetailCode,txtDetailAccNumber,txtDetailBalance,txtDetailRecharge,txtWithdrawal;
	private String nameSearch="",phoneSearch="",emailSearch="",codeSearch="",streetSearch;
	private int moneyWithdrawal;
	private int moneyRecharge;
	private DefaultTableModel list=new DefaultTableModel();
	private final JTable tbl=new JTable(list);
	private ArrayList<String> arrAdress = new ArrayList<String>();
	private StamentAdress adress = new StamentAdress();
	private ArrayList<Customer> arrCtm;
	private ArrayList<Customer> arrCtmAll;
	private ArrayList<CusTransaction> arrCtmTss;
	public LayoutReportCus() {
		addControlls();
		addEvents();
		/*Lấy giá trị quận truyền vào combobox từ phương thức SeclectDis của class StamentAdress*/
		arrAdress = adress.SeclectDis();
		for(String x:arrAdress) {
			cboDistricts.addItem(x);
		}
		
		arrCtmAll = new ArrayList<Customer>();
		arrCtmAll = CustomerDB.getCustomersList();
		arrCtmTss = TransactionsDb.getCusTransactionList();
		arrCtm = new ArrayList<Customer>();
		arrCtm = arrCtmAll;
		printListCus();
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
			titleBorderList = BorderFactory.createTitledBorder(blueBorderList,"DANH SÁCH KHÁCH HÀNG",
			        TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
			pnList.setBorder(titleBorderList);
			pnList.setPreferredSize(new Dimension(700,250));
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
			titleBorderDetail = BorderFactory.createTitledBorder(blueBorderDetail,"Chi Tiết Khách Hàng",
			        TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
			pnDetail.setBorder(titleBorderDetail);
			pnDetail.setPreferredSize(new Dimension(700,185));
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
			
			JPanel pnMoney = new JPanel();
			
			pnMoney.setLayout(new BoxLayout(pnMoney, BoxLayout.X_AXIS));
			
			JPanel pnRecharge = new JPanel();
			JLabel lblDetailRecharge = new JLabel("Tổng tiền Đã Nạp :");
			txtDetailRecharge = new JTextField(20);
			txtDetailRecharge.setEditable(false);
			
			pnRecharge.add(lblDetailRecharge);
			pnRecharge.add(txtDetailRecharge);
			
			JPanel pnWithdrawal = new JPanel();
			JLabel lblWithdrawal = new JLabel("Tổng tiền Đã Rút :");
			txtWithdrawal = new JTextField(20);
			txtWithdrawal.setEditable(false);
			
			pnWithdrawal.add(lblWithdrawal);
			pnWithdrawal.add(txtWithdrawal);
			
			pnMoney.add(pnRecharge);
			pnMoney.add(pnWithdrawal);
			
			JPanel pnClear = new JPanel();
			btnClearInfor = new JButton("Clear Thông Tin");
			btnClearInfor.setEnabled(false);
			pnClear.add(btnClearInfor);
			
			pnDetail.add(pnAllInfor);
			pnDetail.add(pnMoney);
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
			pnBlank.setPreferredSize(new Dimension(340,50));
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
			
			
			JPanel pnAdress = new JPanel();
			pnAdress.setPreferredSize(new Dimension(340,130));
			pnAdress.setMaximumSize(pnAdress.getPreferredSize() );
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
			cboDistricts.addItem("Tất Cả");

			JLabel lblWards = new JLabel("Phường :");
			cboWards=new JComboBox<>();
			cboWards.addItem("Tất Cả");
			
			JLabel lblStreets = new JLabel("Địa Chỉ Nhà :");
			txtStreets = new JTextField(20);
			
			JPanel pnSearchAdress = new JPanel();
			pnSearchAdress.setOpaque(false);
			btnSearchAdress = new JButton("Xem");										
			btnCancelAdress = new JButton("Hủy");
			btnUpdate = new JButton("Cập Nhập");
			btnCancelAdress.setEnabled(false);
			pnSearchAdress.add(btnSearchAdress);
			pnSearchAdress.add(btnCancelAdress);
			pnSearchAdress.add(btnUpdate);
			
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
			

			
			pnAction.add(pnInformation);
			pnAction.add(pnAdress);
			pnAction.add(pnSearchAdress);
			
			pnMain.add(pnAction);
			this.add(pnMain);
		}catch (Exception e) {
		}
		
		
	}

	private void addEvents() {
		tbl.addMouseListener(eventChooseRow);
		cboDistricts.addActionListener(eventChooseDistricts);
		txtFullname.getDocument().addDocumentListener(eventSearchFullname);
		txtPhone.getDocument().addDocumentListener(eventSearchPhone);
		txtEmail.getDocument().addDocumentListener(eventSearchEmail);
		txtCode.getDocument().addDocumentListener(eventSearchCode);	
		txtStreets.getDocument().addDocumentListener(eventSearchStreets);
		btnSearchAdress.addActionListener(eventSearchDistricts);
		btnCancelAdress.addActionListener(eventCancelAdress);
		btnClearInfor.addActionListener(eventClearInfor);
		btnUpdate.addActionListener(eventUpdate);
	}
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
    		btnClearInfor.setEnabled(true);
    		int money=0;
    		/*duyệt mảng ArrayList để lấy các giá trị đưa vào Ô textfield*/
			for(int i=0;i<arrCtm.size();i++) {
				if(row[0].equals(arrCtm.get(i).getCodeCus())) {
					txtDetailStreets.setText(arrCtm.get(i).getStreetCus());
					txtDetailDistricts.setText(arrCtm.get(i).getNameDistricts());
					txtDetailWards.setText(arrCtm.get(i).getNameWards());	
					money = arrCtm.get(i).getAmountCus();
				}
			}
			moneyRecharge=0;moneyWithdrawal=0;
			for(CusTransaction x:arrCtmTss) {				
				if(x.getCodeCus().indexOf(row[0])>-1&&x.getStatus().indexOf("Rút Tiền")>-1) {				
					moneyWithdrawal=x.getPayTransaction()+moneyWithdrawal;
				}
			}
			moneyRecharge = money+moneyWithdrawal;
			txtDetailRecharge.setText(String.format("%,d", (long) moneyRecharge)+" VNĐ");
			txtWithdrawal.setText(String.format("%,d", (long) moneyWithdrawal)+" VNĐ");
    	}
    };
	/*Xóa các thông tin từ phương thức clearInfor();*/
    ActionListener eventClearInfor = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			clearInfor();
		}
    };
    /*Cập nhập dữ liệu cho ArrayList*/
    ActionListener eventUpdate = new ActionListener() {
		public void actionPerformed(ActionEvent e) {			
			arrCtmAll = CustomerDB.getCustomersList();
			updateArrCtm();
			printListCus();
			String msgXoa ="Cập Nhập Thành Công Dữ Liệu Mới Nhất !!!";
			JOptionPane.showMessageDialog(null, msgXoa, "Cập Nhập Dữ Liệu!!!", JOptionPane.INFORMATION_MESSAGE);
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
		txtDetailRecharge.setText("");
		txtWithdrawal.setText("");
		tbl.clearSelection();
		btnClearInfor.setEnabled(false);
    }
    /*set các giá trị về trống*/
	ActionListener eventCancelAdress = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			txtFullname.setText("");
			txtPhone.setText("");			
			txtEmail.setText("");
			txtCode.setText("");
			txtStreets.setText("");
			cboDistricts.setSelectedIndex(0);			
			btnCancelAdress.setEnabled(false);
			txtStreets.setEditable(true);
			cboDistricts.setEnabled(isEnabled());
			cboWards.setEnabled(isEnabled());
			printListCus();
			clearInfor();
		}
    };
	/*Sự kiện khi thay đổi combobox sẽ hiện thị các item của cboWards*/
	ActionListener eventChooseDistricts = new ActionListener() {
		public void actionPerformed(ActionEvent e) {			
			int keys = cboDistricts.getSelectedIndex();
			if (keys==0) {
				cboWards.removeAllItems();
				cboWards.addItem("Tất Cả");
				btnCancelAdress.setEnabled(false);
			}else {
				btnCancelAdress.setEnabled(true);
				arrAdress = adress.SeclectWard(keys);
				cboWards.removeAllItems();
				cboWards.addItem("Tất Cả");
				for(String x:arrAdress) {
					
					cboWards.addItem(x);
				}
			}						
		}
    };		
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
				btnCancelAdress.setEnabled(false);
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
		btnCancelAdress.setEnabled(true);
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
				btnCancelAdress.setEnabled(false);
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
		btnCancelAdress.setEnabled(true);
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
				btnCancelAdress.setEnabled(false);
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
		btnCancelAdress.setEnabled(true);
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
				btnCancelAdress.setEnabled(false);
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
		btnCancelAdress.setEnabled(true);
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
	/*Tìm kiếm theo đường */
	private DocumentListener eventSearchStreets = new DocumentListener() {		
		@Override
		public void changedUpdate(DocumentEvent e) {
			searchStreets();
		}
		@Override
		public void insertUpdate(DocumentEvent e) {
			searchStreets();
		}
		@Override
		public void removeUpdate(DocumentEvent e) {
			String change = txtCode.getText();
			if(change.isEmpty()) {
				arrCtm = updateArrCtm();
				btnCancelAdress.setEnabled(false);
				printListCus();
			}else {
				searchStreets();
			}
		}
	};
	/*Duyệt mảng theo Địa chỉ */
	private void searchStreets() {	
		clearInfor();
		btnCancelAdress.setEnabled(true);
		streetSearch = txtStreets.getText();
		list.setRowCount(0);
		for(Customer x:arrCtmAll) {		
			if(x.getStreetCus().toUpperCase().trim().indexOf(streetSearch.toUpperCase().trim()) > -1) {				
				String phone = String.valueOf(x.getPhoneCus());
				String[] row = {x.getCodeCus(), x.getFullnameCus(), phone,x.getEmailCus(),x.getCardnumberCus(),String.format("%,d", (long) x.getAmountCus())+" VNĐ"};
				list.addRow(row);			
			}			
		}				
	}
	
	/*Tìm kiếm theo quận*/
	ActionListener eventSearchDistricts = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			clearInfor();
			btnCancelAdress.setEnabled(true);
				int keyDistricts = cboDistricts.getSelectedIndex();
				if(keyDistricts==0) {
					arrCtm = updateArrCtm();
					printListCus();
				}else {
					btnCancelAdress.setEnabled(true);
					int keyW = cboWards.getSelectedIndex();
					if(keyW==0) {
						searchStreetsWards( keyDistricts);						
					}else {
						String wards = (String) cboWards.getSelectedItem();
						int keyWards = adress.SeclectIdWards(wards);
						searchStreets( keyDistricts, keyWards);					
					}
				}								
		}
    };
	
    private void searchStreets(int keyDistricts,int keyWards) {
		btnCancelAdress.setEnabled(true);
		clearInfor();
		list.setRowCount(0);
		for(Customer ctm : arrCtm) {		
			if(ctm.getDistrictCus()==keyDistricts && ctm.getWardCus()==keyWards ) {				
				String phone = String.valueOf(ctm.getPhoneCus());
				String[] row = {ctm.getCodeCus(), ctm.getFullnameCus(), phone,ctm.getEmailCus(),ctm.getCardnumberCus(),String.format("%,d", (long) ctm.getAmountCus())+" VNĐ"};
				list.addRow(row);			
			}			
		}			
	}
    
    private void searchStreetsWards(int keyDistricts) {
		btnCancelAdress.setEnabled(true);
		clearInfor();
		list.setRowCount(0);
		for(Customer ctm : arrCtm) {		
			if(ctm.getDistrictCus()==keyDistricts ) {				
				String phone = String.valueOf(ctm.getPhoneCus());
				String[] row = {ctm.getCodeCus(), ctm.getFullnameCus(), phone,ctm.getEmailCus(),ctm.getCardnumberCus(),String.format("%,d", (long) ctm.getAmountCus())+" VNĐ"};
				list.addRow(row);			
			}			
		}			
	}
    
	private void changeReset() {
		txtFullname.setEditable(true);
		txtPhone.setEditable(true);
		txtEmail.setEditable(true);
		txtCode.setEditable(true);
	}		
	
	private ArrayList<Customer> updateArrCtm() {
    	return arrCtm = arrCtmAll;
    }
    
    private void printListCus() {
    	list.setRowCount(0);
    	for (Customer ctm : arrCtm) { 		
			String phone = String.valueOf(ctm.getPhoneCus());
			String[] row = {ctm.getCodeCus(), ctm.getFullnameCus(), phone,ctm.getEmailCus(),ctm.getCardnumberCus(),String.format("%,d", (long) ctm.getAmountCus())+" VNĐ"};
			list.addRow(row);
		}
    }       
	
}
