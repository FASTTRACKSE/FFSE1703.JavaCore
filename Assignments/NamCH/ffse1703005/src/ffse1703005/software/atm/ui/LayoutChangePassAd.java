package ffse1703005.software.atm.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import ffse1703005.software.atm.model.UserAdmin;
import ffse1703005.software.atm.model.UserAdminDb;

public class LayoutChangePassAd extends JPanel {
	private String username;
	private ArrayList<UserAdmin> arrUser = new ArrayList<UserAdmin>();
	private static final long serialVersionUID = 1L;
	private JPasswordField txtOldPassword,txtNewPassword,txtConfimPass;
	private JButton btnCancel,btnChange,btnBack;
	
	public JTextField getTxtOldPassword() {
		return txtOldPassword;
	}

	public JTextField getTxtNewPassword() {
		return txtNewPassword;
	}

	public JTextField getTxtConfimPass() {
		return txtConfimPass;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

	public JButton getBtnChange() {
		return btnChange;
	}

	public JButton getBtnBack() {
		return btnBack;
	}

	public LayoutChangePassAd(String username) {		
		this.username=username;
		addControlls();
		addEvents();
	}

	private void addControlls() {
		this.setOpaque(false);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JPanel pnBlank = new JPanel();
		pnBlank.setOpaque(false);
		pnBlank.setPreferredSize(new Dimension(250, 80));
		pnBlank.setMaximumSize( pnBlank.getPreferredSize() );
		
		JPanel pnInforAdminAction = new JPanel();
		pnInforAdminAction.setOpaque(false);
		pnInforAdminAction.setLayout(new BoxLayout(pnInforAdminAction, BoxLayout.Y_AXIS));
		pnInforAdminAction.setPreferredSize(new Dimension(250, 200));
		pnInforAdminAction.setMaximumSize( pnInforAdminAction.getPreferredSize() );
		Border titleBorder;
		Border blueBorder = BorderFactory.createLineBorder(Color.BLACK,3);
		titleBorder = BorderFactory.createTitledBorder(blueBorder, "Xin Chào : "+username,
		        TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);		
		pnInforAdminAction.setBorder(titleBorder);				
		
		JPanel pnHeader =new JPanel();
		pnHeader.setOpaque(false);
		JLabel lblHeader =new JLabel("Đổi Mật Khẩu");
		lblHeader.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblHeader.setForeground(Color.RED	);
		pnHeader.add(lblHeader);
		pnInforAdminAction.add(pnHeader);
		

		JLabel lblOldPassword = new JLabel("Mật Khẩu Cũ:");
		txtOldPassword = new JPasswordField(20);

		JLabel lblNewPassword = new JLabel("Mật Khẩu Mới:");
		txtNewPassword = new JPasswordField(20);
		
		JLabel lblConfimPass = new JLabel("Nhập Lại Mật Khẩu Mới:");
		txtConfimPass = new JPasswordField(20);
		
		JPanel pnChangePass = new JPanel();
		pnChangePass.setOpaque(false);
		
		GroupLayout accountLayout = new GroupLayout(pnChangePass);
		pnChangePass.setLayout(accountLayout);
		accountLayout.setAutoCreateGaps(true);
		accountLayout.setAutoCreateContainerGaps(true);
		
		accountLayout.setHorizontalGroup(accountLayout.createSequentialGroup()
			.addGroup(accountLayout.createParallelGroup()
				.addComponent(lblOldPassword)
				.addComponent(lblNewPassword)
				.addComponent(lblConfimPass)
			)
			.addGroup(accountLayout.createParallelGroup()
				.addComponent(txtOldPassword)
				.addComponent(txtNewPassword)
				.addComponent(txtConfimPass)
			)
		);
		
		accountLayout.setVerticalGroup(accountLayout.createSequentialGroup()
			.addGroup(accountLayout.createParallelGroup()
				.addComponent(lblOldPassword)
				.addComponent(txtOldPassword)
			)
			.addGroup(accountLayout.createParallelGroup()
					.addComponent(lblNewPassword)
					.addComponent(txtNewPassword)
				)
			.addGroup(accountLayout.createParallelGroup()
					.addComponent(lblConfimPass)
					.addComponent(txtConfimPass)
				)
		);
		pnInforAdminAction.add(pnChangePass);
		JPanel pnAction = new JPanel();
		pnAction.setOpaque(false);
		btnChange = new JButton("Xác Nhận");
		btnCancel = new JButton("Hủy");
		btnBack = new JButton("Cancel");
		pnAction.add(btnChange);
		pnAction.add(btnCancel);
		pnAction.add(btnBack);
		pnInforAdminAction.add(pnAction);
		this.add(pnBlank);
		this.add(pnInforAdminAction);
	}

	private void addEvents() {
		btnCancel.addActionListener(eventCancel);
		btnChange.addActionListener(eventChangePass);
	}
	
	ActionListener eventCancel = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			txtConfimPass.setText("");
			txtNewPassword.setText("");
			txtOldPassword.setText("");
		}
		
	};
	ActionListener eventChangePass = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			arrUser = UserAdminDb.getUserList(username);
			String oldPassword =new String(txtOldPassword.getPassword()); 
			String newPassword =new String(txtNewPassword.getPassword());
			String confimPassword =new String(txtConfimPass.getPassword());			
			if(oldPassword.isEmpty()||newPassword.isEmpty()||confimPassword.isEmpty()) {
				String msg = "Chưa Điền Đầy Đủ Thông Tin";
				JOptionPane.showMessageDialog(null, msg, "Lỗi Nhập!!!", JOptionPane.INFORMATION_MESSAGE);
			}else {
				if(oldPassword.equals(arrUser.get(0).getPassword())) {
					if(oldPassword.equals(newPassword)) {
						String msg = "Mât Khẩu Mới Không Trùng Với Mật Khẩu Cũ";
						JOptionPane.showMessageDialog(null, msg, "Lỗi Nhập!!!", JOptionPane.INFORMATION_MESSAGE);
					}else if(newPassword.length()<6) {
						String msg = "Mật Khẩu Phải Từ 6 Ký tự";
						JOptionPane.showMessageDialog(null, msg, "Lỗi Nhập!!!", JOptionPane.INFORMATION_MESSAGE);
					}else if(!newPassword.equals(confimPassword)) {
						String msg = "Mật Khẩu Xác Nhận Không Trùng Khớp Với Mật Khẩu Mới";
						JOptionPane.showMessageDialog(null, msg, "Lỗi Nhập!!!", JOptionPane.INFORMATION_MESSAGE);
					}else {
						int checkPass = UserAdminDb.changePass(username, newPassword);
						if(checkPass>-1) {
							txtConfimPass.setText("");
							txtNewPassword.setText("");
							txtOldPassword.setText("");
							arrUser = UserAdminDb.getUserList(username);
							String msg = "Đổi Mật Khẩu Thành Công";
							JOptionPane.showMessageDialog(null, msg, "Đổi Mật Khẩu!!!", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}else {
					String msg = "Nhập Sai Mật Khẩu Cũ";
					JOptionPane.showMessageDialog(null, msg, "Lỗi Nhập!!!", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		
		}
		
	};
}
