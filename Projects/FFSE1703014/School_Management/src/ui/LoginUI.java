package ui;

import java.awt.Container;
import java.awt.Font;
import java.awt.ImageCapabilities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.gjt.mm.mysql.Driver;

import com.mysql.jdbc.Connection;

public class LoginUI extends JFrame {
	final static Connection connection = getConnect("localhost", "ffse1703014", "admin", "123456");
	public String username, password;
	ImageIcon userIcon = new ImageIcon("icons/user.png");
	ImageIcon passwordIcon = new ImageIcon("icons/password.png");
	ImageIcon loginIcon = new ImageIcon("icons/login.png");
	public JButton btnLogin = new JButton("Login", loginIcon);
	public JTextField txtUsername = new JTextField(20);
	public JPasswordField txtPassword = new JPasswordField(20);
	public LoginUI(String title) {
		super(title);
		addControllers();
		addEvents();
	}

	private void addControllers() {
		Container conn = getContentPane();
		
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		JPanel pnTitle = new JPanel();
		JPanel pnUsername = new JPanel();
		JPanel pnPassword = new JPanel();
		JPanel pnButton = new JPanel();
		
		btnLogin.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel title = new JLabel("Đăng nhập chương trình");
		Font font = new Font("Arial", 1, 30);
		title.setFont(font);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel labelName = new JLabel(userIcon);
		JLabel labelPassword = new JLabel(passwordIcon);
		
		pnTitle.add(title);
		
		pnUsername.add(labelName);
		pnUsername.add(txtUsername);
		
		pnPassword.add(labelPassword);
		pnPassword.add(txtPassword);
		
		pnButton.add(btnLogin);
		
		pnMain.add(pnTitle);
		pnMain.add(pnUsername);
		pnMain.add(pnPassword);
		pnMain.add(pnButton);
		
		conn.add(pnMain);
	}

	private void addEvents() {
		btnLogin.addActionListener(login);
	}
	ActionListener login = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			username = txtUsername.getText();
			password = txtPassword.getText();
			if (username.isEmpty() && password.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!");
			} else {
				try {
					Statement statement = (Statement) connection.createStatement();
					ResultSet result = statement.executeQuery("select * from user where username = '"+ username +"' and password = '"+ password +"'");
					if (result.next()) {
						HomeUI myUI = new HomeUI("Chương trình quản lý trường học");
						myUI.showWindow();
						hideWindow();
						JOptionPane.showMessageDialog(null, "Hi,"+username+"\n Chào mừng đến với chương trình quản lý trường học");
					} else {
						txtUsername.setText("");
						txtPassword.setText("");
						JOptionPane.showMessageDialog(null, "Username hoặc password bạn đã nhập chưa đúng!", "Đăng nhập thất bại", 0);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
	};
	public static Connection getConnect(String strServer, String strDatabase, String strUser, String strPwd) {
		Connection conn = null;
		String strConnect = "jdbc:mysql://" + strServer + "/" + strDatabase;
		Properties pro = new Properties();
		pro.put("user", strUser);
		pro.put("password", strPwd);
		try {
			com.mysql.jdbc.Driver driver = new Driver();
			conn = (Connection) driver.connect(strConnect, pro);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return conn;
	}
	public void hideWindow() {
		this.setVisible(false);
	}
	public void showWindow() {
		this.setSize(500, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
}
