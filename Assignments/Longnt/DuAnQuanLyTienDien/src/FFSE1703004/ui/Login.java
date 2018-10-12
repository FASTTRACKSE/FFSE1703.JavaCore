//package FFSE1703004.ui;
//
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.Container;
//
//import java.awt.Dimension;
//import java.awt.Font;
//import java.awt.HeadlessException;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.Connection;
//
//import javax.swing.BoxLayout;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTextField;
//
//import FFSE1703004.model.DBConnection;
//
//
//public class Login extends JFrame {
//	JTextField txtUser, txtPass;
//	JButton ButtonLogin;
//
//	public Login(String title) throws HeadlessException {
//		super(title);
//		addControls();
//		addEvents();
//	}
//
//
//	void addControls() {
//		Container con = getContentPane();
//
//		JPanel pnMain = new JPanel();
//		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
//
//		JPanel pnAppName = new JPanel();
//		pnAppName.setMaximumSize(new Dimension(800, 100));
//		JLabel lblAppName = new JLabel("QUẢN LÝ TIỀN ĐIỆN");
//		Font fontAppName = new Font("arial", Font.BOLD, 20);
//		lblAppName.setFont(fontAppName);
//		pnAppName.add(lblAppName);
//		
//		JPanel panimg = new JPanel();
//		panimg.setLayout(new BorderLayout(100,80));
//		ImageIcon img=new ImageIcon("images/login.jpg");
//		JLabel lblImg=new JLabel(img);
//		lblImg.setPreferredSize(new Dimension(60, 50));
//		panimg.add(lblImg);
//
//		JPanel pnUser = new JPanel();
//		pnUser.setMaximumSize(new Dimension(800, 50));
//		JLabel lblUser = new JLabel("Username");
//		lblUser.setPreferredSize(new Dimension(80, 10));
//		txtUser = new JTextField(15);
//		pnUser.add(lblUser);
//		pnUser.add(txtUser);
//
//		JPanel pnPass = new JPanel();
//		pnPass.setMaximumSize(new Dimension(800, 100));
//		JLabel lblPass = new JLabel("Password");
//		lblPass.setPreferredSize(new Dimension(80, 10));
//		txtPass = new JTextField(15);
//		pnPass.add(lblPass);
//		pnPass.add(txtPass);
//
//		JPanel pnButtonLogin = new JPanel();
//		pnButtonLogin.setMaximumSize(new Dimension(800, 100));
//		ButtonLogin = new JButton("Đăng nhập");
//		pnButtonLogin.add(ButtonLogin);
//
//		JPanel pnConnection = new JPanel();
//		pnConnection.setMaximumSize(new Dimension(800, 100));
//		JLabel lblConnection = new JLabel("");
//		if (DBConnection.checkConnection()) {
//			lblConnection.setText("Kết nối thành công");
//		} else {
//			lblConnection.setText("Kết nối thất bại");
//			;
//		}
//		pnConnection.add(lblConnection);
//		
//		JPanel copyRight = new JPanel();
//		copyRight.setMaximumSize(new Dimension(800, 100));
//		JLabel lblCopyRight = new JLabel("Nguyễn Thanh Long");
//		copyRight.add(lblCopyRight);
//
//		pnMain.add(pnAppName);
//		pnMain.add(panimg);
//		pnMain.add(pnUser);
//		pnMain.add(pnPass);
//		pnMain.add(pnButtonLogin);
//		pnMain.add(pnConnection);
//		pnMain.add(copyRight);
//
//		con.add(pnMain);
//	}
//	void addEvents() {
//		ButtonLogin.addActionListener(eventLogin);
//	}
//	ActionListener eventLogin = new ActionListener() {
//
//		@Override
//		public void actionPerformed(ActionEvent arg0) {
//			// TODO Auto-generated method stub
//			if (login()) {
//				DanhMuc homeUI = new DanhMuc("Electricity Invoice Management");
//				homeUI.showWindow();
//				dispose();
//			} else {
//				JOptionPane.showMessageDialog(null, "Sai tên đăng nhập hoặc mật khẩu");
//			}
//		}
//	};
//
//	boolean login() {
//		if (DBConnection.checkLogin(txtUser.getText(), txtPass.getText())) {
//			return true;
//		} else {
//			return false;
//		}
//	}
//	public void showWindow() {
//		this.setSize(800, 600);
//		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//		this.setLocationRelativeTo(null);
//		this.setVisible(true);
//	}
//}