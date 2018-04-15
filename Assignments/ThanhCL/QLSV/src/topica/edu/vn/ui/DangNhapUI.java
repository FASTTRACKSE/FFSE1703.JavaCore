package topica.edu.vn.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import topica.edu.vn.io.FileFactory;
import topica.edu.vn.model.DangNhap;
import topica.edu.vn.service.DangNhapService;

public class DangNhapUI extends JFrame {
	
	JTextField txtUserName;
	JPasswordField txtPassword;
	
	JCheckBox chkSave;
	
	JButton btnLogin,btnExit;
	
	public DangNhapUI(String title)
	{
		super(title);
		addControls();
		addEvents();		
		hienThiLaiThongTinDangNhap();
	}

	private void hienThiLaiThongTinDangNhap() {
		File f=new File("login.data");
		if(f.exists())
		{
			Object data=FileFactory.readData("login.data");
			if(data!=null)
			{
				DangNhap dn=(DangNhap) data;
				txtUserName.setText(dn.getUserName());
				txtPassword.setText(dn.getPassword());
				chkSave.setSelected(true);
			}
		}
	}

	private void addEvents() {
		btnLogin.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				xuLyDangNhap();
			}
		});
	}

	protected void xuLyDangNhap() {
		DangNhapService dnService=new DangNhapService();
		DangNhap dn=dnService.login(txtUserName.getText(), txtPassword.getText());
		if(dn!=null)
		{
			if(chkSave.isSelected())
			{
				FileFactory.saveData(dn, "login.data");
			}
			else
			{
				FileFactory.saveData(null, "login.data");
			}
			dispose();
			MainUI ui=new MainUI("Quản Trị Sinh Viên");
			ui.showWindow();
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Đăng nhập thất bại");
		}
	}

	private void addControls() {
		// TODO Auto-generated method stub
		Container con=getContentPane();
		con.setLayout(new BorderLayout());
		JPanel pnNorth=new JPanel();
		con.add(pnNorth,BorderLayout.NORTH);
		JPanel pnCenter=new JPanel();
		con.add(pnCenter,BorderLayout.CENTER);
		JPanel pnSouth=new JPanel();
		con.add(pnSouth,BorderLayout.SOUTH);
		
		JLabel lblTitle=new JLabel("Đăng nhập hệ thống");
		lblTitle.setFont(new Font("tahoma",Font.BOLD,15));
		lblTitle.setForeground(Color.RED);
		pnNorth.add(lblTitle);
		
		pnCenter.setLayout(new BorderLayout());
		JPanel pnImage=new JPanel();
		JLabel lblIcon=new JLabel(new ImageIcon("images/login.png"));
		pnImage.add(lblIcon);
		pnCenter.add(pnImage,BorderLayout.WEST);
		
		JPanel pnUser=new JPanel();
		pnUser.setLayout(new BoxLayout(pnUser, BoxLayout.Y_AXIS));
		pnCenter.add(pnUser,BorderLayout.CENTER);
		
		JPanel pnUserName=new JPanel();
		pnUserName.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblUserName=new JLabel("Tài khoản:");
		txtUserName=new JTextField(20);
		pnUserName.add(lblUserName);
		pnUserName.add(txtUserName);
		pnUser.add(pnUserName);
		
		JPanel pnPassword=new JPanel();
		pnPassword.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblPassword=new JLabel("Mật khẩu:");
		txtPassword=new JPasswordField(20);
		pnPassword.add(lblPassword);
		pnPassword.add(txtPassword);
		pnUser.add(pnPassword);
		
		JPanel pnSave=new JPanel();
		chkSave=new JCheckBox("Lưu thông tin đăng nhập");
		pnSave.add(chkSave);
		pnUser.add(pnSave);
		
		
		btnLogin=new JButton("Đăng nhập");
		btnExit=new JButton("Thoát");
		
		pnSouth.add(btnLogin);
		pnSouth.add(btnExit);
		
		TitledBorder borderUser=
				new TitledBorder(BorderFactory.createLineBorder(Color.RED),
						"Thông tin đăng nhập");
		pnUser.setBorder(borderUser);
		pnImage.setBorder(BorderFactory.createLineBorder(Color.RED));
		pnCenter.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		
		btnLogin.setIcon(new ImageIcon("images/action.png"));
		btnExit.setIcon(new ImageIcon("images/exit.png"));
		lblPassword.setPreferredSize(lblUserName.getPreferredSize());
	}
	public void showWindow()
	{
		this.setSize(450, 270);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
