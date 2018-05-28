package project.ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Project_Login extends JFrame {
	Container con;
	JPanel login,user,password,action;
	JLabel titlogin,tituser,titpass;
	JTextField txtuser;
	JPasswordField txtpass;
	JButton btnlogin,btncancel;
	public Project_Login(String tittle) {
		super(tittle);
		setContent();
		setDisplay();
	}
	public void setDisplay() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setMinimumSize(new Dimension(600, 400));
		con = new Container();
		login = new JPanel();
		login.setLayout(new BoxLayout(login,BoxLayout.Y_AXIS));
		user = new JPanel();
		password = new JPanel();
		action = new JPanel();
		titlogin = new JLabel("Đăng Nhập Vào Chương Trình");
		tituser = new JLabel("Tên Đăng Nhập");
		titpass = new JLabel("Mật Khẩu");
		txtuser = new JTextField();
		txtpass = new JPasswordField();
		btnlogin = new JButton("Đăng Nhập");
		btncancel = new JButton("Thoát");
		tituser.setFont(new Font("Courier New",Font.BOLD,20));
		titpass.setFont(new Font("Courier New",Font.BOLD,20));
		user.add(tituser);
		user.add(txtuser);
		password.add(titpass);
		password.add(txtpass);
		login.add(user);
		login.add(password);
		login.add(action);
		con.add(login);
	}
	public void setContent() {
		
	}
}
