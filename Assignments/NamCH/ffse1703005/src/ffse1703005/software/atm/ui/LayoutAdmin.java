package ffse1703005.software.atm.ui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import ffse1703005.software.atm.model.UserAdmin;
/*tạo class LayoutAdmin kế thừa JPanel*/
public class LayoutAdmin extends JPanel {
	private static final long serialVersionUID = 1L;
	private JPanel pnAction,pnInforAd;
	private LayoutChangePassAd layoutChange;
	private CardLayout cardLayoutAction,cardLayoutInfor;
	private JButton btnATM,btnCustomer,btnLogoutAd,btnChangePassAd;
	public JButton getBtnLogoutAd() {
		return btnLogoutAd;
	}
	private LayoutCustomer layoutCus;
	private LayoutATM layoutATM;
	public LayoutAdmin(ArrayList<UserAdmin> arrUser) {
		addControlls(arrUser);
		addEvents();
	}
	/*tạo phương thức  addControlls */
	private void addControlls(ArrayList<UserAdmin> arrUser) {
		try {
			/*set boxlayout cho Jpanel của class*/
			this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			this.setOpaque(false);
			/*tạo Jpanel pnInfor chứa các thông tin của quản trị viên*/
			JPanel pnInfor = new JPanel();
			pnInfor.setOpaque(false);
			/*sét Boxlayout cho pnInfor*/
			pnInfor.setLayout(new BoxLayout(pnInfor, BoxLayout.Y_AXIS));
			pnInfor.setPreferredSize(new Dimension(250, 600));
			pnInfor.setMaximumSize( pnInfor.getPreferredSize() );
			
			pnInforAd = new JPanel();
			pnInforAd.setOpaque(false);		
			cardLayoutInfor = new CardLayout();
			/*sét cardlayout cho pnInforAd*/
			pnInforAd.setLayout(cardLayoutInfor);								
					
			JPanel pnInforAdmin = new JPanel();
			pnInforAdmin.setOpaque(false);
			/*sét Boxlayout cho pnInforAdmin*/
			pnInforAdmin.setLayout(new BoxLayout(pnInforAdmin, BoxLayout.Y_AXIS));
			pnInforAdmin.setPreferredSize(new Dimension(250, 350));
			pnInforAdmin.setMaximumSize( pnInforAdmin.getPreferredSize() );
			/*sét Boder cho pnInforAdmin*/
			Border titleBorder;
			Border blueBorder = BorderFactory.createLineBorder(Color.BLACK,3);
			titleBorder = BorderFactory.createTitledBorder(blueBorder, "Xin Chào : "+arrUser.get(0).getUsername(),
			        TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);		
			pnInforAdmin.setBorder(titleBorder);				
			
			JPanel pnHeader =new JPanel();
			pnHeader.setOpaque(false);
			JLabel lblHeader =new JLabel("Thông Tin Quản Trị Viên");
			/*sét font cho lblHeader*/
			lblHeader.setFont(new Font("Times New Roman", Font.BOLD, 15));
			/*sét color cho lblHeader*/
			lblHeader.setForeground(Color.RED	);
			pnHeader.add(lblHeader);
			pnInforAdmin.add(pnHeader);
			
			JPanel pnCodeAd =new JPanel();
			pnCodeAd.setOpaque(false);
			JLabel lblCodeAd =new JLabel("Mã Nhân Viên       : ");
			pnCodeAd.add(lblCodeAd);
			JTextField txtCodeAd = new JTextField(10);
			/*Truyền dữ liệu vào txtCodeAd */
			txtCodeAd.setText(arrUser.get(0).getCode());
			txtCodeAd.setEditable(false);
			pnCodeAd.add(txtCodeAd);
			pnInforAdmin.add(pnCodeAd);
			
			JPanel pnFullnameAd =new JPanel();
			pnFullnameAd.setOpaque(false);
			JLabel lblFullnameAd =new JLabel("Họ Và Tên              : ");
			pnFullnameAd.add(lblFullnameAd);
			JTextField txtFullnameAd = new JTextField(10);
			/*Truyền dữ liệu vào txtFullnameAd */
			txtFullnameAd.setText(arrUser.get(0).getFullname());
			txtFullnameAd.setEditable(false);
			pnFullnameAd.add(txtFullnameAd);
			pnInforAdmin.add(pnFullnameAd);				
			
			JPanel pnPositionAd =new JPanel();
			pnPositionAd.setOpaque(false);
			JLabel lblPositionAd =new JLabel("Chức Vụ                : ");
			pnPositionAd.add(lblPositionAd);
			JTextField txtPositionAd = new JTextField(10);
			/*Truyền dữ liệu vào txtPositionAd */
			txtPositionAd.setText(arrUser.get(0).getPosition());
			txtPositionAd.setEditable(false);
			pnPositionAd.add(txtPositionAd);
			pnInforAdmin.add(pnPositionAd);
			
			JPanel pnAgencyAd =new JPanel();
			pnAgencyAd.setOpaque(false);
			JLabel lblAgencyAd =new JLabel("Đơn Vị Công Tác : ");
			pnAgencyAd.add(lblAgencyAd);
			JTextField txtAgencyAd = new JTextField(10);
			/*Truyền dữ liệu vào txtAgencyAd */
			txtAgencyAd.setText(arrUser.get(0).getAgency());
			txtAgencyAd.setEditable(false);
			pnAgencyAd.add(txtAgencyAd);
			pnInforAdmin.add(pnAgencyAd);
			/*button để thực hiện các chức năng*/
			JPanel pnMethodAd =new JPanel();
			pnMethodAd.setOpaque(false);		
			btnChangePassAd=new JButton("Đổi Mật Khẩu");
			pnMethodAd.add(btnChangePassAd);
			btnLogoutAd=new JButton("Đăng Xuất");
			pnMethodAd.add(btnLogoutAd);
			pnInforAdmin.add(pnMethodAd);
			
			/*add pnInforAdmin vào cardlayout pnInforAd*/
			pnInforAd.add(pnInforAdmin,"myCardInforAdmin");
			
			JPanel pnInforAdminAction = new JPanel();
			/*sét độ trong suốt cho pnInforAdminAction*/
			pnInforAdminAction.setOpaque(false);
			/*Truyền dữ liệu vào LayoutChangePassAd */
			layoutChange = new LayoutChangePassAd(arrUser.get(0).getUsername());
			/*Add layoutChange từ Class LayoutChange vào pnInforAdminAction*/
			pnInforAdminAction.add(layoutChange);
			/*add pnInforAdminAction vào cardlayout pnInforAd*/
			pnInforAd.add(pnInforAdminAction,"myCardInforAdminAction");	
			
			
			JPanel pnInforAction = new JPanel();
			pnInforAction.setOpaque(false);
			/*set Boxlayout cho pnInforAction*/
			pnInforAction.setLayout(new BoxLayout(pnInforAction, BoxLayout.Y_AXIS));
			pnInforAction.setPreferredSize(new Dimension(250, 230));
			pnInforAction.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE) );
			/*set Border cho pnInforAction*/
			Border titleBorderAc;
			Border blueBorderAc = BorderFactory.createLineBorder(Color.BLACK,3);
			titleBorderAc = BorderFactory.createTitledBorder(blueBorderAc, "Chức Năng",
			        TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
			pnInforAction.setBorder(titleBorderAc);
			
			JPanel pnInforCustomer = new JPanel();
			pnInforCustomer.setOpaque(false);
			/*set pnInforCustomer cho pnInforCustomer*/
	        pnInforCustomer.setLayout(new BoxLayout(pnInforCustomer, BoxLayout.Y_AXIS));
	        pnInforCustomer.setPreferredSize(new Dimension(250, 100));
	        pnInforCustomer.setMaximumSize(pnInforCustomer.getPreferredSize() );
			btnCustomer =new JButton("Quản Lý Khách Hàng");
			/*set setBackground cho btnCustomer*/
			btnCustomer.setBackground(Color.GREEN);				
			pnInforCustomer.add(Box.createVerticalGlue());
			pnInforCustomer.add(btnCustomer);
			btnCustomer.setAlignmentX(CENTER_ALIGNMENT);
			pnInforCustomer.add(Box.createVerticalGlue());
			
			pnInforAction.add(pnInforCustomer);
			
			JPanel pnInforATM = new JPanel();
			pnInforATM.setOpaque(false);
			/*set BoxLayout cho pnInforATM*/
	        pnInforATM.setLayout(new BoxLayout(pnInforATM, BoxLayout.Y_AXIS));
	        pnInforATM.setPreferredSize(new Dimension(250, 125));
	        pnInforATM.setMaximumSize(pnInforATM.getPreferredSize() );
			
			btnATM =new JButton("Quản Lý Cây ATM");
			btnATM.setMargin(new Insets(3,23,3,23));
			pnInforATM.add(Box.createVerticalGlue());
			pnInforATM.add(btnATM);
			btnATM.setAlignmentX(CENTER_ALIGNMENT);
			pnInforATM.add(Box.createVerticalGlue());
			pnInforATM.add(Box.createVerticalGlue());
			
			pnInforAction.add(pnInforATM);
			
			pnInfor.add(pnInforAd);				
			pnInfor.add(pnInforAction);
			
			pnAction = new JPanel();
			pnAction.setOpaque(false);
			/*set BoxLayout cho pnAction*/
			pnAction.setLayout(new BoxLayout(pnAction, BoxLayout.Y_AXIS));
			pnAction.setPreferredSize(new Dimension(1050, 587));
			pnAction.setMaximumSize(pnAction.getPreferredSize() );
			/*set Border cho pnAction*/
			Border titleBorderAction;
			Border blueBorderAction = BorderFactory.createLineBorder(Color.BLACK,3);
			titleBorderAction = BorderFactory.createTitledBorder(blueBorderAction,"",
			        TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
			pnAction.setBorder(titleBorderAction);
			cardLayoutAction = new CardLayout();
			pnAction.setLayout(cardLayoutAction);
			
			JPanel pnActionCustomer=new JPanel();		
			layoutCus=new LayoutCustomer();
			/*pnActionCustomer Add layoutCus từ class LayoutCustomer */
			pnActionCustomer.add(layoutCus);
			
			JPanel pnActionATM=new JPanel();
			layoutATM=new LayoutATM();
			/*pnActionATM Add layoutATM từ class LayoutATM */
			pnActionATM.add(layoutATM);
			
			pnAction.add(pnActionCustomer,"myCardCustomer");
			pnAction.add(pnActionATM,"myCardATM");
			
			this.add(pnInfor);
			this.add(pnAction);
		}catch (Exception e) {
			
		}		
	}

	private void addEvents() {
		btnCustomer.addActionListener(getLayoutCustomer);
		btnATM.addActionListener(getLayoutATM);
		btnChangePassAd.addActionListener(getLayoutChangePassAd);
		layoutChange.getBtnBack().addActionListener(getLayoutInforAdmin);
	}
	/*Sự kiện khi click button gọi cardlayout có tên myCardCustomer*/
	ActionListener getLayoutCustomer = new ActionListener() {		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			cardLayoutAction.show(pnAction, "myCardCustomer");
			btnCustomer.setBackground(Color.GREEN);
			btnATM.setBackground(null);	
		}
		
	};
	/*Sự kiện khi click button gọi cardlayout có tên myCardATM*/
	ActionListener getLayoutATM = new ActionListener() {		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			cardLayoutAction.show(pnAction, "myCardATM");
			btnATM.setBackground(Color.GREEN);
			btnCustomer.setBackground(null);	
		}
		
	};
	/*Sự kiện khi click button gọi cardlayout có tên myCardInforAdminAction*/
	ActionListener getLayoutChangePassAd = new ActionListener() {		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			cardLayoutInfor.show(pnInforAd, "myCardInforAdminAction");
		}
		
	};
	/*Sự kiện khi click button gọi cardlayout có tên myCardInforAdmin*/
	ActionListener getLayoutInforAdmin = new ActionListener() {		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			cardLayoutInfor.show(pnInforAd, "myCardInforAdmin");			
		}	
	};
}
