package ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.LoginSQL;

public class LoginUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField txtUser;
	JPasswordField txtPass;
	JButton btnLogin;

	public LoginUI(String title) {
		super(title);
		addControls();
		addEvents();
	}

	public void showWindow() {
		this.setSize(500, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	void addControls() {
		Container con = getContentPane();

		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		JPanel pnName = new JPanel();
		pnName.setPreferredSize(new Dimension(100, 100));
		ImageIcon fasttrack = new ImageIcon(getClass().getResource("/image/ff.png"));
		JLabel lblName = new JLabel(fasttrack);

		pnName.add(lblName);

		JPanel pnUser = new JPanel();

		JLabel lblUser = new JLabel("User");
		txtUser = new JTextField(15);
		txtUser.setPreferredSize(new Dimension(220, 25));
		lblUser.setPreferredSize(new Dimension(80, 25));
		pnUser.add(lblUser);
		pnUser.add(txtUser);

		JPanel pnPass = new JPanel();
		JLabel lblPass = new JLabel("PassWord");
		txtPass = new JPasswordField(15);
		txtPass.setPreferredSize(new Dimension(220, 25));
		lblPass.setPreferredSize(new Dimension(80, 25));
		pnPass.add(lblPass);
		pnPass.add(txtPass);

		JPanel pnButtonLogin = new JPanel();
		JLabel lblDangNhap = new JLabel("");
		btnLogin = new JButton("Đăng nhập");
		btnLogin.setPreferredSize(new Dimension(170, 25));
		lblDangNhap.setPreferredSize(new Dimension(80, 25));
		pnButtonLogin.add(lblDangNhap);
		pnButtonLogin.add(btnLogin);

		pnMain.add(pnName);
		pnMain.add(pnUser);
		pnMain.add(pnPass);
		pnMain.add(pnButtonLogin);

		con.add(pnMain);
	}

	public void addEvents() {
		btnLogin.addActionListener(eventLogin);
		txtUser.addActionListener(eventLogin);
		txtPass.addActionListener(eventLogin);
	}

	ActionListener eventLogin = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String user = txtUser.getText();
			String pass = txtPass.getText();
			if (login()) {
				QuanLiTruongHocUI myUI = new QuanLiTruongHocUI("Quản Lí Trường Học");
				myUI.showWindow();
				dispose();
			} else if (user.equals("") && pass.equals("")) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập user và password");
			} else {
				JOptionPane.showMessageDialog(null, "Sai tên đăng nhập hoặc mật khẩu");
			}
		}
	};

	public boolean login() {
		if (LoginSQL.checkLogin(txtUser.getText(), txtPass.getText())) {
			return true;
		} else {
			return false;
		}
	}
}
