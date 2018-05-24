package ffse1703005.software.atm.ui;


import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import ffse1703005.software.atm.model.MachineATMDb;
/*tạo class LayoutLogin kế thừa JPanel*/
public class LayoutLogin extends JPanel{

	private static final long serialVersionUID = 1L;
	private JButton btnSubmitAd,btnSubmitUser;
	
	public JButton getBtnSubmitAd() {
		return btnSubmitAd;
	}
	
	public JButton getBtnSubmitUser() {
		return btnSubmitUser;
	}
	private JTextField txtUser,txtNumAcc;
	private JPasswordField txtPass,txtPassCode;
				
	public JTextField getTxtUser() {
		return txtUser;
	}

	public JTextField getTxtNumAcc() {
		return txtNumAcc;
	}

	public JPasswordField getTxtPass() {
		return txtPass;
	}

	public JPasswordField getTxtPassCode() {
		return txtPassCode;
	}
	private JComboBox<String> cboCodeATM;	
	public JComboBox<String> getCboCodeATM() {
		return cboCodeATM;
	}
	private CardLayout cardLogin;
	private JPanel pnContent;
	private JRadioButton rdoAdmin,rdoUser;
	private MachineATMDb atmDb = new MachineATMDb();
	private ArrayList<String> arrCodeATM = new ArrayList<String>();
	
	public LayoutLogin() {
		addControlls();
		addEvents();
		/*hiển thị mã máy ATM cho combobox
		 * từ phương thức SeclectCodeATM của class MachineATMDb */
		arrCodeATM = atmDb.SeclectCodeATM();
		for(String x:arrCodeATM) {
			cboCodeATM.addItem(x);
		}
		
	}
	public void addControlls() {
		try {
			/*set Boxlayout cho class*/
			this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			this.setOpaque(false);
			

			/* Main -> Top */
			JPanel pnTop = new JPanel(){ 
				/*set Background image cho pnTop*/
				private static final long serialVersionUID = 1L;
				public void paintComponent(Graphics g) 
	            { 
	                Dimension d = getSize(); 
	                Image img=this.getToolkit().getImage("src/ffse1703005/software/atm/images/logo.png"); 
	                g.drawImage(img, 0, 0, d.width, d.height, null); 

	                setOpaque( false );  // lam trong suot  
	                super.paintComponent(g); 
	            } 
	        };	
			pnTop.setPreferredSize(new Dimension(700, 170));
			pnTop.setOpaque(false);
			
			pnContent = new JPanel();
			cardLogin = new CardLayout();
			JPanel pnContentAll =new JPanel();
			pnContentAll.setPreferredSize(new Dimension(400, 190));
			pnContentAll.setMaximumSize( pnContentAll.getPreferredSize() );
			/*set Boxlayout cho pnContentAll*/
			pnContentAll.setLayout(new BoxLayout(pnContentAll, BoxLayout.Y_AXIS));
			/*set Border cho pnContentAll*/
			Border border=
			BorderFactory.createLineBorder(Color.BLACK,2);
			TitledBorder borderTitle=
			BorderFactory.createTitledBorder(
			border);
			pnContentAll.setBorder(borderTitle);
			pnContentAll.setBackground(Color.WHITE);
			pnContent.setLayout(cardLogin);
			pnContent.setPreferredSize(new Dimension(400, 170));
			pnContent.setMaximumSize( pnContent.getPreferredSize() );
			
			JPanel pnContentAdmin=new JPanel();
			/*set BoxLayout cho pnContentAdmin*/
			pnContentAdmin.setLayout(new BoxLayout(pnContentAdmin, BoxLayout.Y_AXIS));	
			/*set Border cho pnContentAdmin*/
			Border borderAd=
			BorderFactory.createLineBorder(Color.BLACK,2);
			TitledBorder borderTitlAd=
			BorderFactory.createTitledBorder(
					borderAd, "Đăng Nhập Quản Trị Viên");
			borderTitlAd.setTitleColor(Color.red);
			pnContentAdmin.setBorder(borderTitlAd);
			pnContentAdmin.setBackground(Color.WHITE);
			JPanel pnUser=new JPanel();
			pnUser.setOpaque(false);
			JLabel lblUser = new JLabel("Tên Đăng Nhập : ");
			txtUser =new JTextField(15);
			pnUser.add(lblUser);
			pnUser.add(txtUser);
			pnContentAdmin.add(pnUser);
			JPanel pnPass=new JPanel();
			pnPass.setOpaque(false);
			JLabel lblPass = new JLabel("Mật Khẩu            : ");
			txtPass =new JPasswordField(15);
			pnPass.add(lblPass);
			pnPass.add(txtPass);
			pnContentAdmin.add(pnPass);				
			
			JPanel pnSubmitAd = new JPanel();
			pnSubmitAd.setOpaque(false);
			btnSubmitAd = new JButton("Đăng Nhập.");
			pnSubmitAd.add(btnSubmitAd);
			pnContentAdmin.add(pnSubmitAd);
			
			JPanel pnContentUser=new JPanel();
			/*set BoxLayout cho pnContentUser*/
			pnContentUser.setLayout(new BoxLayout(pnContentUser, BoxLayout.Y_AXIS));
			/*set Border cho pnContentUser*/
			Border borderUser=
			BorderFactory.createLineBorder(Color.BLACK,2);
			TitledBorder borderTitleUser=
			BorderFactory.createTitledBorder(
			borderUser, "Đăng Nhập Khách Hàng");
			borderTitleUser.setTitleColor(Color.red);
			pnContentUser.setBorder(borderTitleUser);
			pnContentUser.setBackground(Color.WHITE);
			
			JPanel pnContentUserGroup=new JPanel();
			pnContentUserGroup.setOpaque(false);
			
			JLabel lblNumAcc = new JLabel("Số Tài Khoảng: ");
			txtNumAcc =new JTextField(15);
			

			JLabel lblPassCode = new JLabel("Mã Pin: ");
			txtPassCode =new JPasswordField(15);
			
			JLabel lblCodeATM = new JLabel("Chọn Máy ATM: ");
			cboCodeATM =new JComboBox<>();
			cboCodeATM.addItem("Chọn Máy ATM");
			/*Group layout để canh chỉnh lề cho các Jlabel và JtextField*/
			GroupLayout infolayout = new GroupLayout(pnContentUserGroup);
			pnContentUserGroup.setLayout(infolayout);
			infolayout.setAutoCreateGaps(true);
			infolayout.setAutoCreateContainerGaps(true);
			
			infolayout.setHorizontalGroup(infolayout.createSequentialGroup()
				.addGroup(infolayout.createParallelGroup()
					.addComponent(lblNumAcc)
					.addComponent(lblPassCode)
					.addComponent(lblCodeATM)
				)
				.addGroup(infolayout.createParallelGroup()
					.addComponent(txtNumAcc)
					.addComponent(txtPassCode)
					.addComponent(cboCodeATM)
				)
			);
			
			infolayout.setVerticalGroup(infolayout.createSequentialGroup()
				.addGroup(infolayout.createParallelGroup()
					.addComponent(lblNumAcc)
					.addComponent(txtNumAcc)
				)			
				.addGroup(infolayout.createParallelGroup()
						.addComponent(lblPassCode)
						.addComponent(txtPassCode)
					)
				.addGroup(infolayout.createParallelGroup()
						.addComponent(lblCodeATM)
						.addComponent(cboCodeATM)
					)			
			);
			pnContentUser.add(pnContentUserGroup);
			
			JPanel pnSubmitUser = new JPanel();
			pnSubmitUser.setOpaque(false);
			btnSubmitUser = new JButton("Đăng Nhập.");
			pnSubmitUser.add(btnSubmitUser);
			pnContentUser.add(pnSubmitUser);
			
			
			
			JPanel pnChoose=new JPanel();
			pnChoose.setOpaque(false);
			rdoAdmin=new JRadioButton("Quản Trị Viên"); 
			rdoAdmin.setOpaque(false);
			rdoUser=new JRadioButton("Khách Hàng");
			rdoUser.setOpaque(false);
			rdoAdmin.setBounds(50,100,70,30);  
			rdoUser.setBounds(50,150,70,30);
			ButtonGroup bgSelect = new ButtonGroup();
			bgSelect.add(rdoAdmin);
			bgSelect.add(rdoUser);
			rdoAdmin.setSelected(true);
			pnChoose.add(rdoAdmin);
			pnChoose.add(rdoUser);
			
			
			pnContent.add(pnContentAdmin,"1");
			pnContent.add(pnContentUser,"2");
			
			pnContentAll.add(pnContent);
			pnContentAll.add(pnChoose);
											
			
			
			this.add(pnTop);
			this.add(pnContentAll);
		}catch (Exception e) {
			
		}
		
	}
	private void addEvents() {
		rdoAdmin.addActionListener(chooseLogin);
		rdoUser.addActionListener(chooseLogin);		
	}
	/*Gọi cardlayout theo radioButton*/
	private ActionListener chooseLogin = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (rdoAdmin.isSelected()) {
				cardLogin.show(pnContent,"1");
			} else {
				cardLogin.show(pnContent,"2");
			}
		}
	};
	
	
}
