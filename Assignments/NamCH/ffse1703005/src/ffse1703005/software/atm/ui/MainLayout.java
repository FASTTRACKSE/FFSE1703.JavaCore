package ffse1703005.software.atm.ui;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import ffse1703005.software.atm.model.Customer;
import ffse1703005.software.atm.model.CustomerDB;
import ffse1703005.software.atm.model.UserAdmin;
import ffse1703005.software.atm.model.UserAdminDb;

public class MainLayout extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel pnMainAll,pnCardUser,pnCardUserContent,pnCardAdmin,pnCardAdminContent;
	private LayoutLogin layLogin;
	private LayoutAdmin layAdmin;
	private LayoutUser layUser ;
	private CardLayout layout;
	private ArrayList<Customer> arrCheck;
	public MainLayout(String title){
		super(title);
		addControls();
		addEvents();
	}

	private void addControls() {
		Container con=getContentPane();
		
		pnMainAll = new JPanel();
		layout = new CardLayout();
		pnMainAll.setLayout(layout);
		
		layLogin = new LayoutLogin();
		JPanel pnCardLogin =new JPanel();
		JPanel pnCardLoginContent =new JPanel(){ 
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) 
            { 
                Dimension d = getSize(); 
                Image img=this.getToolkit().getImage("src/ffse1703005/software/atm/images/space.jpg"); 
                g.drawImage(img, 0, 0, d.width, d.height, null); 

                setOpaque( false );  // lam trong suot  
                super.paintComponent(g); 
            } 
        };
        pnCardLoginContent.update(getGraphics());
        pnCardLogin.setLayout(new BoxLayout(pnCardLogin, BoxLayout.Y_AXIS));
        
        pnCardLoginContent.add(layLogin);
        pnCardLogin.add(pnCardLoginContent);
		        
		
		pnMainAll.add(pnCardLogin,"myCardLogin");
		
		
		
		
		con.add(pnMainAll);
		
		
	}
	

	private void addEvents() {
		layLogin.getBtnSubmitAd().addActionListener(getLayoutAdmin);
		layLogin.getBtnSubmitUser().addActionListener(getLayoutUser);		
	}
	
	ActionListener getLayoutAdmin = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				String username = layLogin.getTxtUser().getText();
				String password = new String(layLogin.getTxtPass().getPassword()); 
				ArrayList<UserAdmin> arrUser = new ArrayList<UserAdmin>();
				arrUser = UserAdminDb.getUser(username, password);
				System.out.println(arrUser.get(0).getFullname());
				if(arrUser.get(0).getUsername().equals(username)) {					
					pnCardAdmin =new JPanel();
			        pnCardAdminContent =new JPanel() { 
						private static final long serialVersionUID = 1L;

						public void paintComponent(Graphics g) 
			            { 
			                Dimension d = getSize(); 
			                Image img=this.getToolkit().getImage("src/ffse1703005/software/atm/images/money.png"); 
			                g.drawImage(img, 0, 0, d.width, d.height, null); 

			                setOpaque( false );  // lam trong suot  
			                super.paintComponent(g); 
			            }
			        };
			        pnCardAdmin.setLayout(new BoxLayout(pnCardAdmin, BoxLayout.Y_AXIS));    
			        layAdmin = new LayoutAdmin(arrUser);
			        pnCardAdminContent.add(layAdmin);
			        
			        pnCardAdmin.add(pnCardAdminContent);
			        pnMainAll.add(pnCardAdmin,"myCardAdmin");
					layout.show(pnMainAll, "myCardAdmin");
					layAdmin.getBtnLogoutAd().addActionListener(getLayoutLogin);
					showCustomer();
				}
			}catch (Exception e) {
				String msgXoa ="Tên Đăng Nhập Hoặc Mật Khẩu Không Đúng !!!";
				JOptionPane.showMessageDialog(null, msgXoa, "Lỗi Đăng Nhập!!!", JOptionPane.INFORMATION_MESSAGE);
			}
						
		}
		
	};
	
	ActionListener getLayoutUser = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				String cardnumber = layLogin.getTxtNumAcc().getText();
				String password =new String(layLogin.getTxtPassCode().getPassword()); 
				String codeATM = (String) layLogin.getCboCodeATM().getSelectedItem();
				int checkCbo = layLogin.getCboCodeATM().getSelectedIndex();
				String cardCheked = CustomerDB.checkCustomer(cardnumber, password);
				
				if(!cardCheked.isEmpty()) {
					if(checkCbo==0) {
						String msgXoa ="Chưa Chọn Máy ATM !!!";
						JOptionPane.showMessageDialog(null, msgXoa, "Lỗi Đăng Nhập!!!", JOptionPane.INFORMATION_MESSAGE);
					}else {
						arrCheck = CustomerDB.searchCardNumber(cardnumber);
						pnCardUser =new JPanel();
						pnCardUserContent =new JPanel(){ 
							private static final long serialVersionUID = 1L;
							public void paintComponent(Graphics g) 
				            { 
				                Dimension d = getSize(); 
				                Image img=this.getToolkit().getImage("src/ffse1703005/software/atm/images/bguser.jpg"); 
				                g.drawImage(img, 0, 0, d.width, d.height, null); 
				
				                setOpaque( false );  // lam trong suot  
				                super.paintComponent(g); 
				            } 
				        };		        		        
				        pnCardUser.add(pnCardUserContent);
						
						layUser = new LayoutUser(arrCheck.get(0).getFullnameCus(),arrCheck.get(0).getCodeCus(),codeATM);
						layUser.getBtnLogoutUser().addActionListener(getLayoutLogin);
						pnCardUserContent.add(layUser);
				        pnMainAll.add(pnCardUser,"myCardUser");
						layout.show(pnMainAll, "myCardUser");
						
						showUser();
					}					
				}								
			}catch (Exception e) {
				String msgXoa ="Số Tài Khoản Hoặc Mật Khẩu Không Đúng !!!";
				JOptionPane.showMessageDialog(null, msgXoa, "Lỗi Đăng Nhập!!!", JOptionPane.INFORMATION_MESSAGE);
			}
			
			
		}		
	};		
	
	ActionListener getLayoutLogin = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			layLogin.getTxtNumAcc().setText("");
			layLogin.getTxtPass().setText("");
			layLogin.getTxtPassCode().setText("");
			layLogin.getTxtUser().setText("");
			layLogin.getCboCodeATM().setSelectedIndex(0);
			layout.show(pnMainAll, "myCardLogin");			
			showWindow();
		}		
	};
	
	public void showWindow() {
		this.setSize(1000, 400);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);				
	}
	
	private void showCustomer() {
		this.dispose();
		this.setSize(1300, 600);
		this.setLocationRelativeTo(null);
		this.setTitle("TPBank - Hệ thống quản lý ATM");
		this.setVisible(true);
	}
	
	private void showUser() {
		this.dispose();
		this.setSize(900, 500);
		this.setLocationRelativeTo(null);
		this.setTitle("TPBank - Quản Lý Tài Khoảng");
		this.setVisible(true);
	}
}
