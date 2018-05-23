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
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import ffse1703005.software.atm.model.Customer;
import ffse1703005.software.atm.model.CustomerDB;

public class LayoutUserChangePass extends JPanel {
	private String codeCus;
	private ArrayList<Customer> arrCtm;
	private JButton btnSubmit,btnCancel;
	private JPasswordField txtOldPassword,txtNewPassword,txtConfimPassword;
	private static final long serialVersionUID = 1L;

	public LayoutUserChangePass(String codeATM,String codeCus) {
		this.codeCus = codeCus;
		arrCtm = CustomerDB.searchCode(codeCus);
		addControlls(codeATM);
		addEvents();
	}

	private void addControlls(String codeATM) {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.setOpaque(false);
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		pnMain.setPreferredSize(new Dimension(650, 587));
		pnMain.setMaximumSize(pnMain.getPreferredSize() );
		pnMain.setOpaque(false);
		
		JPanel pnTitle = new JPanel();
		pnTitle.setPreferredSize(new Dimension(650, 180));
		pnTitle.setMaximumSize(pnTitle.getPreferredSize() );
		pnTitle.setOpaque(false);
		JPanel pnBlankTitle = new JPanel();
		pnBlankTitle.setPreferredSize(new Dimension(650, 20));
		pnBlankTitle.setMaximumSize(pnBlankTitle.getPreferredSize() );
		pnBlankTitle.setOpaque(false);
		pnTitle.add(pnBlankTitle);
		JLabel lblTitle = new JLabel("THAY ĐỔI MẬT KHẨU CỦA BẠN");
		Font font=new Font("Arial", Font.BOLD,25);
		lblTitle.setFont(font);
		lblTitle.setForeground(Color.RED	);
		pnTitle.add(lblTitle);
		JLabel lblReport = new JLabel("Gợi ý : Nên Đặt Mật Khẩu Bao Gồm Chữ Và Số Cho An Toàn.");
		JPanel pnNameATM = new JPanel();
		pnNameATM.setPreferredSize(new Dimension(650, 20));
		pnNameATM.setMaximumSize(pnNameATM.getPreferredSize() );
		pnNameATM.setOpaque(false);
		JLabel lblNameATM = new JLabel("Thực Hiện Tại Máy : "+codeATM);
		lblNameATM.setForeground(Color.BLUE	);
		pnNameATM.add(lblNameATM);
		pnTitle.add(lblReport);
		pnTitle.add(pnNameATM);
		
		JPanel pnChangePassword = new JPanel();
		pnChangePassword.setPreferredSize(new Dimension(400, 150));
		pnChangePassword.setMaximumSize(pnChangePassword.getPreferredSize() );
		pnChangePassword.setBackground(Color.WHITE);
		Border titleBorderAction;
		Border blueBorderAction = BorderFactory.createLineBorder(Color.BLACK,3);
		titleBorderAction = BorderFactory.createTitledBorder(blueBorderAction,"",
		        TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
		pnChangePassword.setBorder(titleBorderAction);
		
		JLabel lblOldPassword = new JLabel("Mật Khẩu Cũ:");
		txtOldPassword = new JPasswordField(20);

		JLabel lblNewPassword = new JLabel("Mật Khẩu Mới:");
		txtNewPassword = new JPasswordField(20);
		
		JLabel lblConfimPassword = new JLabel("Nhập Lại Mật Khẩu Mới:");
		txtConfimPassword = new JPasswordField(20);
		
		JPanel pnChangePasswordGroup = new JPanel();
		pnChangePasswordGroup.setOpaque(false);
		
		GroupLayout infolayout = new GroupLayout(pnChangePasswordGroup);
		pnChangePasswordGroup.setLayout(infolayout);
		infolayout.setAutoCreateGaps(true);
		infolayout.setAutoCreateContainerGaps(true);
		
		infolayout.setHorizontalGroup(infolayout.createSequentialGroup()
			.addGroup(infolayout.createParallelGroup()
				.addComponent(lblOldPassword)
				.addComponent(lblNewPassword)
				.addComponent(lblConfimPassword)			
			)
			.addGroup(infolayout.createParallelGroup()
				.addComponent(txtOldPassword)
				.addComponent(txtNewPassword)
				.addComponent(txtConfimPassword)			
			)
		);
		
		infolayout.setVerticalGroup(infolayout.createSequentialGroup()
			.addGroup(infolayout.createParallelGroup()
				.addComponent(lblOldPassword)
				.addComponent(txtOldPassword)
			)			
			.addGroup(infolayout.createParallelGroup()
					.addComponent(lblNewPassword)
					.addComponent(txtNewPassword)
				)
			.addGroup(infolayout.createParallelGroup()
					.addComponent(lblConfimPassword)
					.addComponent(txtConfimPassword)
				)			
		);
		pnChangePassword.add(pnChangePasswordGroup);
		
		JPanel pnSubmit = new JPanel();
		pnSubmit.setPreferredSize(new Dimension(650, 50));
		pnSubmit.setMaximumSize(pnSubmit.getPreferredSize() );
		pnSubmit.setOpaque(false);
		btnSubmit = new JButton("Xác Nhận");
		btnCancel = new JButton("Hủy");
		pnSubmit.add(btnSubmit);
		pnSubmit.add(btnCancel);
		
		pnChangePassword.add(pnSubmit);
		
		pnMain.add(pnTitle);
		pnMain.add(pnChangePassword);
		this.add(pnMain);
	}

	private void addEvents() {
		btnSubmit.addActionListener(eventSubmit);
		btnCancel.addActionListener(eventCancel);
	}
	
	ActionListener eventSubmit = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String oldPassword =new String(txtOldPassword.getPassword()); 
			String newPassword =new String(txtNewPassword.getPassword());
			String confimPassword =new String(txtConfimPassword.getPassword());
			String checkPassword = String.valueOf(arrCtm.get(0).getPin());
			if(oldPassword.isEmpty()||newPassword.isEmpty()||confimPassword.isEmpty()) {
				String msg = "Chưa Điền Đầy Đủ Thông Tin";
				JOptionPane.showMessageDialog(null, msg, "Lỗi Nhập!!!", JOptionPane.INFORMATION_MESSAGE);
			}else {
				if(oldPassword.equals(checkPassword)) {
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
						int checkPass = CustomerDB.changePass(codeCus, newPassword);
						if(checkPass>-1) {
							txtConfimPassword.setText("");
							txtNewPassword.setText("");
							txtOldPassword.setText("");
							arrCtm = CustomerDB.searchCode(codeCus);
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
	
	ActionListener eventCancel = new ActionListener() {		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			txtConfimPassword.setText("");
			txtNewPassword.setText("");
			txtOldPassword.setText("");
		}
		
	};
}
