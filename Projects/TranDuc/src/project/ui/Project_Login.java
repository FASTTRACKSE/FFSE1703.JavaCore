package project.ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import project.model.ConnectDB;
import project.model.User;
import project.ui.Project_UI;
public class Project_Login extends JFrame {
	Connection conn;
	Container con;
	JPanel login,user,password,action,tittle;
	JLabel titlogin,tituser,titpass;
	JTextField txtuser,txtpass;
//	JPasswordField txtpas;
	JButton btnlogin,btncancel;
	ArrayList<User> arrUS = new ArrayList<User>();
	public Project_Login(String tittle) {
		super(tittle);
		connectDB();
		loaddata();
		setContent();
		addEvent();
		setDisplay();
	}
	private void loaddata() {
		// TODO Auto-generated method stub
		try {
			Statement stm = conn.createStatement();
			String sql = "select * from `user`";
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				User us = new User(rs.getString("user_id"),
						rs.getString("user_name"),rs.getString("user_password"));
				arrUS.add(us);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void setDisplay() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setMinimumSize(new Dimension(550, 350));
	}
	public void connectDB() {
		conn=ConnectDB.getConnect("Localhost","project_quanlysv","Project_QuanLySv","12345");
		if (conn != null) {
			String result = "Kết nối thành công Database";
			System.out.println(result);
		} else {
			JOptionPane.showMessageDialog(null, "Không kết nối được vs Database");
		}
	}
	public void setContent() {
		con = new Container();
		con = getContentPane();
		login = new JPanel();
		login.setLayout(new GridLayout(4,1));
		user = new JPanel();
		password = new JPanel();
		action = new JPanel();
		tittle = new JPanel();
		titlogin = new JLabel("Đăng Nhập Vào Chương Trình");
		tituser = new JLabel("Tên Đăng Nhập");
		titpass = new JLabel("Mật Khẩu");
		txtuser = new JTextField();
		txtpass = new JPasswordField();
		txtuser.setPreferredSize(new Dimension(350,30));
		txtpass.setPreferredSize(new Dimension(350,30));
		btnlogin = new JButton("Đăng Nhập");
		btncancel = new JButton("Thoát");
		titlogin.setFont(new Font("Courier New",Font.BOLD,24));
		tituser.setFont(new Font("Courier New",Font.BOLD,18));
		titpass.setFont(new Font("Courier New",Font.BOLD,18));
		btnlogin.setFont(new Font("Courier New",Font.BOLD,18));
		btncancel.setFont(new Font("Courier New",Font.BOLD,18));
		tittle.add(titlogin);
		user.add(tituser);
		user.add(txtuser);
		password.add(titpass);
		password.add(txtpass);
		action.add(btnlogin);
		action.add(btncancel);
		login.add(tittle);
		login.add(user);
		login.add(password);
		login.add(action);
		con.add(login);
	}
	public void addEvent() {
		btnlogin.addActionListener(eventLogin);
		btncancel.addActionListener(eventCancel);
	}
	ActionListener eventLogin = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String user = txtuser.getText();
			String pass = txtpass.getText();
			int kt=0;
			for(User z: arrUS) {
				if(user.equals(z.getUserName())) {
					if(pass.equals(z.getUserPass())) {
						kt=1;
					}
				}
			}
			if(kt>0) {
				Project_UI myUI = new Project_UI("Chương Trình Quản Lý Sinh Viên");
				myUI.setDisplay();
				LoginClose();
			}
			else {
				JOptionPane.showMessageDialog(null,"Đăng Nhập Sai!");
			}
		}
	};
	ActionListener eventCancel = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.exit(0);
		}
	};
	private void LoginClose() {
		this.dispose();
	}

}
