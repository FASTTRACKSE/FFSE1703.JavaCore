package fasttrack.edu.vn.ui;

import javax.swing.*;
import javax.swing.border.Border;
import java.sql.*;
import com.mysql.*;
import java.io.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fasttrack.edu.vn.connection.ConnectSql;
import fasttrack.edu.vn.ui.MenuUI;

public class LoginUI extends JFrame {
	static Connection conn = ConnectSql.getConnect("localhost", "ffse1702011", "ffse1702011", "123456");
	JTextField txtID = new JTextField(15);
	JPasswordField txtPass = new JPasswordField(15);
	JButton btnLogin, btnExit;
	
	public LoginUI(String title) {
		super(title);
		addControls();
		addEvents();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void addControls() {
		this.setResizable(false);
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		
		JPanel pnBox = new JPanel();
		pnBox.setLayout(new BoxLayout(pnBox, BoxLayout.Y_AXIS));
		
		JPanel pnTitle = new JPanel();
		JLabel lbTitle = new JLabel("ĐĂNG NHẬP TÀI KHOẢN");
		Font fontTitle = new Font("Roboto", Font.BOLD, 40);
		lbTitle.setForeground(Color.RED);
		lbTitle.setFont(fontTitle);
		pnTitle.add(lbTitle);
		pnBox.add(pnTitle);
		pnMain.add(pnBox);
		
		
		JPanel pnID = new JPanel();
		JLabel lbID = new JLabel("Tài khoản");
		Font fontID = new Font("Arial", Font.BOLD, 16);
		lbID.setFont(fontID);
		lbID.setPreferredSize(new Dimension(80, 40));
		pnID.add(lbID);
		pnID.add(txtID);
		
		JPanel pnPass = new JPanel();
		JLabel lbPass = new JLabel ("Mật khẩu");
		Font fontPass = new Font("Arial", Font.BOLD, 16);
		lbPass.setFont(fontPass);
		lbPass.setPreferredSize(new Dimension(80, 40));
		pnPass.add(lbPass);
		pnPass.add(txtPass);
		
		JPanel pnActionDN = new JPanel();
		btnLogin = new JButton("Đăng nhập");
		btnExit = new JButton("Thoát");
		pnActionDN.add(btnLogin);
		pnActionDN.add(btnExit);
		
		pnBox.add(pnID);
		pnBox.add(pnPass);
		pnBox.add(pnActionDN);
		pnMain.add(pnBox);
		
		
		con.add(pnMain);
	}
	
	//EVENT LOGIN
	ActionListener eventLogin = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			login();
		}
	};
	
	public void login() {
		String sql = "select * from ffse1702011_admin";
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			if(result.next()) {
				String idDb = result.getString(2);
				String passDb = result.getString(4);
				String id = txtID.getText();
				String pass = String.valueOf(txtPass.getPassword());
				if(id.equals(idDb) && pass.equals(passDb)) {
					MenuUI giaodien = new MenuUI("Chương trình quản lý tiền điện");
					giaodien.showWindow();
					dispose();
				} else if(pass.equals("123123")){
					String sqlUser = "select Email from ffse1702011_user_information where Email = '"+id+"'";
					try {
						Statement stmUser = conn.createStatement();
						ResultSet rsUser = stmUser.executeQuery(sqlUser);
						if(rsUser.next()) {
							String idUser = rsUser.getString(1);
							if(id.equals(idUser)) {
								ViewUserUI giaodien = new ViewUserUI(id);
								giaodien.showWindow();
								dispose();
							} else {
								JOptionPane.showMessageDialog(null, "Bạn đã nhập sai tên đăng nhập hoặc mật khẩu. Vui lòng nhập lại!", "Alert", JOptionPane.WARNING_MESSAGE);
							}
						}
					} catch (Exception e2) {
						e2.printStackTrace();
					}
					
				} else {
					JOptionPane.showMessageDialog(null, "Bạn đã nhập sai tên đăng nhập hoặc mật khẩu. Vui lòng nhập lại!", "Alert", JOptionPane.WARNING_MESSAGE);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addEvents() {
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);			
			}
		});
		btnLogin.addActionListener(eventLogin);
	}
	
	public void showWindow() {
		this.setSize(600, 240);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
