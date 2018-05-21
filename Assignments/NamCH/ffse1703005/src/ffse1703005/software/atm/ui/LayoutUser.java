package ffse1703005.software.atm.ui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import ffse1703005.software.atm.model.CusTransaction;
import ffse1703005.software.atm.model.Customer;
import ffse1703005.software.atm.model.CustomerDB;
import ffse1703005.software.atm.model.MachineATM;
import ffse1703005.software.atm.model.MachineATMDb;
import ffse1703005.software.atm.model.StamentAdress;
import ffse1703005.software.atm.model.TransactionsDb;

public class LayoutUser extends JPanel {
	private static final long serialVersionUID = 1L;
	private JPanel pnAction;
	private CardLayout cardLayoutAction;
	private JButton btnChangePass,btnWithdrawal,btnBalance,btnHistory,btnLogoutUser,btnShowUser,btnHideUser;
	private LayoutUserWithdrawal layoutWithdrawal;
	private LayoutUserBalance layoutBalance;
	private LayoutUserChangePass layoutChangePass;
	private LayoutUserHistory layoutHistory;
	private String fullname,codeCus,codeATM;
	private int balance;
	private JTextField txtCodeUser,txtAccountNumber,txtDistrictsUser,txtWardsUser,txtStreetUser;
	private ArrayList<Customer> arrCheckCtm;
	private ArrayList<MachineATM> arrCheckAtm;
	private ArrayList<CusTransaction> arrCheckTss;
	private StamentAdress adress = new StamentAdress();
	public JButton getBtnLogoutUser() {
		return btnLogoutUser;
	}

	LayoutCustomer layoutCus;
	LayoutATM layoutATM;
	
	public LayoutUser(){
		
	}
	
	public LayoutUser(String fullname,String codeCus,String codeATM) {
		this.fullname = fullname;
		this.codeCus = codeCus;
		this.codeATM = codeATM;
		arrCheckCtm = CustomerDB.searchCode(codeCus);
		arrCheckTss = TransactionsDb.getSearchCusList(codeCus);
		addControlls();
		addEvents();
	}

	private void addControlls() {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.setOpaque(false);
		
		JPanel pnInfor = new JPanel();
		pnInfor.setOpaque(false);
		pnInfor.setLayout(new BoxLayout(pnInfor, BoxLayout.Y_AXIS));
		pnInfor.setPreferredSize(new Dimension(250, 600));
		pnInfor.setMaximumSize( pnInfor.getPreferredSize() );
		
		JPanel pnInforUser = new JPanel();
		JPanel pnInforGroup = new JPanel();
		pnInforGroup.setOpaque(false);
		pnInforUser.setOpaque(false);
		pnInforUser.setLayout(new BoxLayout(pnInforUser, BoxLayout.Y_AXIS));
		pnInforUser.setPreferredSize(new Dimension(260, 235));
		pnInforUser.setMaximumSize( pnInforUser.getPreferredSize() );
		String nameUser = fullname ;
		Border titleBorder;
		Border blueBorder = BorderFactory.createLineBorder(Color.BLACK,3);
		titleBorder = BorderFactory.createTitledBorder(blueBorder, "Xin Chào : "+nameUser,
		        TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);		
		pnInforUser.setBorder(titleBorder);				
		
		JPanel pnHeader =new JPanel();
		pnHeader.setOpaque(false);
		JLabel lblHeader =new JLabel("Thông Tin Tài Khoảng");
		lblHeader.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblHeader.setForeground(Color.RED	);
		pnHeader.add(lblHeader);
		pnInforUser.add(pnHeader);
		

		JLabel lblCodeUser =new JLabel("Mã Của Bạn:");
		txtCodeUser = new JTextField(10);
		txtCodeUser.setEditable(false);
		

		JLabel lblAccountNumber =new JLabel("Số Tài Khoảng:");
		txtAccountNumber = new JTextField(10);
		txtAccountNumber.setEditable(false);

		JLabel lblDistrictsUser =new JLabel("Quận: ");
		txtDistrictsUser = new JTextField(10);
		txtDistrictsUser.setEditable(false);
		
		JLabel lblWardsUser =new JLabel("Phường: ");
		txtWardsUser = new JTextField(10);
		txtWardsUser.setEditable(false);

		JLabel lblStreetUser =new JLabel("Đường: ");
		txtStreetUser = new JTextField(10);
		txtStreetUser.setEditable(false);
				
		txtCodeUser.setText("*********");
		txtAccountNumber.setText("*********");			
		txtDistrictsUser.setText("*********");			
		txtDistrictsUser.setText("*********");
		txtWardsUser.setText("*********");
		txtStreetUser.setText("*********");
		
		GroupLayout infolayout = new GroupLayout(pnInforGroup);
		pnInforGroup.setLayout(infolayout);
		infolayout.setAutoCreateGaps(true);
		infolayout.setAutoCreateContainerGaps(true);
		
		infolayout.setHorizontalGroup(infolayout.createSequentialGroup()
			.addGroup(infolayout.createParallelGroup()
				.addComponent(lblCodeUser)
				.addComponent(lblAccountNumber)
				.addComponent(lblDistrictsUser)
				.addComponent(lblWardsUser)
				.addComponent(lblStreetUser)
			)
			.addGroup(infolayout.createParallelGroup()
				.addComponent(txtCodeUser)
				.addComponent(txtAccountNumber)
				.addComponent(txtDistrictsUser)
				.addComponent(txtWardsUser)
				.addComponent(txtStreetUser)
			)
		);
		
		infolayout.setVerticalGroup(infolayout.createSequentialGroup()
			.addGroup(infolayout.createParallelGroup()
				.addComponent(lblCodeUser)
				.addComponent(txtCodeUser)
			)			
			.addGroup(infolayout.createParallelGroup()
					.addComponent(lblAccountNumber)
					.addComponent(txtAccountNumber)
				)
			.addGroup(infolayout.createParallelGroup()
					.addComponent(lblDistrictsUser)
					.addComponent(txtDistrictsUser)
				)
			.addGroup(infolayout.createParallelGroup()
					.addComponent(lblWardsUser)
					.addComponent(txtWardsUser)
				)
			.addGroup(infolayout.createParallelGroup()
					.addComponent(lblStreetUser)
					.addComponent(txtStreetUser)
				)
		);
		pnInforUser.add(pnInforGroup);
		
		JPanel pnLogoutUser = new JPanel();
		pnLogoutUser.setOpaque(false);
		btnLogoutUser = new JButton("Đăng Xuất");
		btnShowUser = new JButton("Hiển Thị");		
		btnHideUser = new JButton("Ẩn");
		btnHideUser.setEnabled(false);
		pnLogoutUser.add(btnShowUser);
		pnLogoutUser.add(btnHideUser);
		pnLogoutUser.add(btnLogoutUser);
		pnInforUser.add(pnLogoutUser);
		
		JPanel pnInforAction = new JPanel();
		pnInforAction.setOpaque(false);
		pnInforAction.setLayout(new BoxLayout(pnInforAction, BoxLayout.Y_AXIS));
		pnInforAction.setPreferredSize(new Dimension(250, 250));
		pnInforAction.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE) );
		Border titleBorderAc;
		Border blueBorderAc = BorderFactory.createLineBorder(Color.BLACK,3);
		titleBorderAc = BorderFactory.createTitledBorder(blueBorderAc, "Chức Năng",
		        TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
		pnInforAction.setBorder(titleBorderAc);
		
		JPanel pnWithdrawal = new JPanel();
		pnWithdrawal.setOpaque(false);
        pnWithdrawal.setPreferredSize(new Dimension(250, 50));
        pnWithdrawal.setMaximumSize(pnWithdrawal.getPreferredSize() );
		btnWithdrawal =new JButton("Rút Tiền");
		btnWithdrawal.setBackground(Color.GREEN);				
		btnWithdrawal.setMargin(new Insets(3,35,3,35));
		pnWithdrawal.add(btnWithdrawal);
		
		pnInforAction.add(pnWithdrawal);
		
		JPanel pnBalance = new JPanel();
		pnBalance.setOpaque(false);
		pnBalance.setPreferredSize(new Dimension(250, 50));
		pnBalance.setMaximumSize(pnBalance.getPreferredSize() );
		btnBalance =new JButton("Xem Số Dư");
		btnBalance.setSize(80, 20);
		btnBalance.setMargin(new Insets(3,27,3,27));
		pnBalance.add(btnBalance);
		
		pnInforAction.add(pnBalance);
		
		JPanel pnChangePass = new JPanel();
		pnChangePass.setOpaque(false);
		pnChangePass.setPreferredSize(new Dimension(250, 50));
		pnChangePass.setMaximumSize(pnChangePass.getPreferredSize() );
		
		btnChangePass =new JButton("Đổi Mật Khẩu");
		btnChangePass.setMargin(new Insets(3,23,3,23));
		pnChangePass.add(btnChangePass);
		
		pnInforAction.add(pnChangePass);
		
		JPanel pnHistory = new JPanel();
		pnHistory.setOpaque(false);
		pnHistory.setPreferredSize(new Dimension(250, 50));
		pnHistory.setMaximumSize(pnHistory.getPreferredSize() );
		
		btnHistory =new JButton("Lịch Sử Giao Dịch");
		btnHistory.setMargin(new Insets(3,12,3,12));
		pnHistory.add(btnHistory);
		
		pnInforAction.add(pnHistory);
		
		pnInfor.add(pnInforUser);				
		pnInfor.add(pnInforAction);
		
		pnAction = new JPanel();
		pnAction.setOpaque(false);
		pnAction.setLayout(new BoxLayout(pnAction, BoxLayout.Y_AXIS));
		pnAction.setPreferredSize(new Dimension(650, 587));
		pnAction.setMaximumSize(pnAction.getPreferredSize() );
		Border titleBorderAction;
		Border blueBorderAction = BorderFactory.createLineBorder(Color.BLACK,3);
		titleBorderAction = BorderFactory.createTitledBorder(blueBorderAction,"",
		        TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
		pnAction.setBorder(titleBorderAction);
		cardLayoutAction = new CardLayout();
		pnAction.setLayout(cardLayoutAction);
		
		JPanel pnActionWithdrawal=new JPanel();
		pnActionWithdrawal.setOpaque(false);
		layoutWithdrawal = new LayoutUserWithdrawal(codeATM);
		pnActionWithdrawal.add(layoutWithdrawal);						
		
		JPanel pnActionChangePass=new JPanel();
		pnActionChangePass.setOpaque(false);	
		layoutChangePass = new LayoutUserChangePass(codeATM,codeCus);
		pnActionChangePass.add(layoutChangePass);		
		
		JPanel pnActionHistory = new JPanel();
		pnActionHistory.setOpaque(false);
		layoutHistory = new LayoutUserHistory(codeCus,codeATM);
		pnActionHistory.add(layoutHistory);
		
		pnAction.add(pnActionWithdrawal,"myCardWithdrawal");
		
		pnAction.add(pnActionChangePass,"myCardChangePass");
		
		pnAction.add(pnActionHistory,"myCardHistory");
		
		this.add(pnInfor);
		this.add(pnAction);
	}

	private void addEvents() {
		btnWithdrawal.addActionListener(getLayoutWithdrawal);
		btnBalance.addActionListener(getLayoutBalance);
		btnChangePass.addActionListener(getLayoutChangePass);
		btnHistory.addActionListener(getLayoutHistory);
		btnShowUser.addActionListener(eventShowUser);
		btnHideUser.addActionListener(eventHideUser);
		layoutWithdrawal.getBtnSubmit().addActionListener(eventWithdrawal);
	}
	
	ActionListener getLayoutHistory = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			cardLayoutAction.show(pnAction, "myCardHistory");
			btnBalance.setBackground(null);
			btnWithdrawal.setBackground(null);	
			btnChangePass.setBackground(null);
			btnHistory.setBackground(Color.GREEN);
		}
		
	};
	
	ActionListener getLayoutWithdrawal = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			cardLayoutAction.show(pnAction, "myCardWithdrawal");
			btnWithdrawal.setBackground(Color.GREEN);
			btnBalance.setBackground(null);
			btnChangePass.setBackground(null);
			btnHistory.setBackground(null);
		}
		
	};
	ActionListener getLayoutBalance = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			JPanel pnActionBalance=new JPanel();
			pnActionBalance.setOpaque(false);
			arrCheckCtm = CustomerDB.searchCode(codeCus);
			for(Customer x:arrCheckCtm) {
				if(codeCus.equals(x.getCodeCus())) {
					balance=x.getAmountCus();
				}
			}
			layoutBalance = new LayoutUserBalance(codeATM,balance);
			pnActionBalance.add(layoutBalance);
			pnAction.add(pnActionBalance,"myCardBalance");
			cardLayoutAction.show(pnAction, "myCardBalance");
			btnBalance.setBackground(Color.GREEN);
			btnWithdrawal.setBackground(null);	
			btnChangePass.setBackground(null);
			btnHistory.setBackground(null);
		}
		
	};
	
	ActionListener getLayoutChangePass = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			cardLayoutAction.show(pnAction, "myCardChangePass");
			btnChangePass.setBackground(Color.GREEN);
			btnBalance.setBackground(null);	
			btnWithdrawal.setBackground(null);
			btnHistory.setBackground(null);
		}
		
	};
	
	ActionListener eventShowUser = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			txtCodeUser.setText(arrCheckCtm.get(0).getCodeCus());
			txtAccountNumber.setText(arrCheckCtm.get(0).getCardnumberCus());
			
			txtDistrictsUser.setText(arrCheckCtm.get(0).getCodeCus());
			String nameWards = adress.SeclectStringWards(arrCheckCtm.get(0).getWardCus());
			String nameDistricts = adress.SeclectStringDistricts(arrCheckCtm.get(0).getDistrictCus());
			txtDistrictsUser.setText(nameDistricts);
			txtWardsUser.setText(nameWards);
			txtStreetUser.setText(arrCheckCtm.get(0).getStreetCus());
			btnShowUser.setEnabled(false);
			btnHideUser.setEnabled(true);
		}
		
	};
	ActionListener eventHideUser = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			txtCodeUser.setText("*********");
			txtAccountNumber.setText("*********");			
			txtDistrictsUser.setText("*********");			
			txtDistrictsUser.setText("*********");
			txtWardsUser.setText("*********");
			txtStreetUser.setText("*********");
			btnShowUser.setEnabled(true);
			btnHideUser.setEnabled(false);
		}
		
	};
	
	ActionListener eventWithdrawal = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				String money = layoutWithdrawal.getTxtMoney().getText();
				DateFormat dateFormatChoose = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				Date dateChoose = new Date();
				Calendar cldNowDay = Calendar.getInstance();
				int i=0;String month=null;
				for(CusTransaction x:arrCheckTss) {
					dateChoose.setTime(x.getTimeTransaction().getTime());
					String timeChoose = dateFormatChoose.format(dateChoose);
					int nowMonth =(cldNowDay.get(Calendar.MONTH)+1);
					if(cldNowDay.get(Calendar.MONTH)>10) {
						month =String.valueOf(nowMonth);
					}else {
						month = "0"+(nowMonth);
					}
					String nowDay = cldNowDay.get(Calendar.YEAR)+"-"+month+"-"+cldNowDay.get(Calendar.DATE);
					if(timeChoose.indexOf(nowDay)>-1) {
						i++;
					}
				}
				int moneyWithdrawal = Integer.parseInt(money);
				if(i>=3) {
					String msg = "Bạn Đã Rút Hết Số Lần Trong Ngày!!!\nMỗi Ngày Được Rút Tối Đa 3 Lần";
					JOptionPane.showMessageDialog(null, msg, "Rút Quá Giới Hạn!!!", JOptionPane.INFORMATION_MESSAGE);
				}else {
					if(moneyWithdrawal>5000000||moneyWithdrawal<0) {
						String msg = "Mỗi Lần Rút Không Quá 5.000.000 VNĐ!!!\nSố Tiền Phải Lớn Hơn 0";
						JOptionPane.showMessageDialog(null, msg, "Lỗi Nhập!!!", JOptionPane.INFORMATION_MESSAGE);
					}else {
						if(moneyWithdrawal % 10000 == 0) {
							int balanceCus = (arrCheckCtm.get(0).getAmountCus()-moneyWithdrawal);
							if(balanceCus<0) {
								String msg = "Số Dư Trong Tài Khoản Không Đủ";
								JOptionPane.showMessageDialog(null, msg, "Lỗi Nhập!!!", JOptionPane.INFORMATION_MESSAGE);
							}else {
								int checkCus = CustomerDB.editMoney(balanceCus,codeCus);
								if(checkCus >-1) {
									arrCheckAtm = MachineATMDb.searchCode(codeATM);
									int balanceAtm = (arrCheckAtm.get(0).getAmountATM()-moneyWithdrawal);
									int checkAtm = MachineATMDb.editMoney(balanceAtm,codeATM) ;
									layoutWithdrawal.getTxtMoney().setText("");
									if(checkAtm>-1) {
									    LocalTime localTime=LocalTime.now();
									    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
									    String formattedTime=localTime.format(formatter);
									    
									    Time t = Time.valueOf(formattedTime);
									    System.out.println(formattedTime);
									    long int_transactions = t.getTime();	
									    String code_transactions = "MGD" + int_transactions;
										int checkTss = TransactionsDb.addTransactions(codeCus, codeATM, code_transactions , moneyWithdrawal ,"Rút Tiền");
										if(checkTss>-1) {
											arrCheckTss = TransactionsDb.getSearchCusList(codeCus);
											String msg = "Rút Thành Công\n"+ String.format("%,d", (long) moneyWithdrawal)+" VNĐ"+
													" Từ Tài Khoản\n"+"Số Tiền Còn Lại Trong Tài Khoản Của Bạn Là "
													+String.format("%,d", (long) balanceCus)+" VNĐ";
											JOptionPane.showMessageDialog(null, msg, "Rút Tiền!!!", JOptionPane.INFORMATION_MESSAGE);									
										}											
									}				
								}
							}						
						}else {
							String msg = "Số tiền mỗi lần rút là bội số của 10.000 VNĐ";
							JOptionPane.showMessageDialog(null, msg, "Lỗi Nhập!!!", JOptionPane.INFORMATION_MESSAGE);						
						}
					}									
				}
				
			}catch (Exception e) {
				String msg = "Phải Nhập Số!!!";
				JOptionPane.showMessageDialog(null, msg, "Lỗi Chưa Nhập!!!", JOptionPane.INFORMATION_MESSAGE);
			}
			
		}
		
	};
}
