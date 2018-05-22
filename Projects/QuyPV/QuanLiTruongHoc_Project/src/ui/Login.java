package ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ColorUIResource;
import javax.swing.text.AbstractDocument.Content;

import model.Login_Statement;

public class Login extends JFrame {
	private JButton btnDangNhap, btnThoat;
	private JTextField textTaiKhoan;
	private JPasswordField textMatKhau;
	private Login_Statement loginStatement = new Login_Statement();
	Image bgImage = Toolkit.getDefaultToolkit().createImage("/images/background_login.png"); 
	UIManager UI=new UIManager();
	 
	
	public Login() {
		super();
	}
	
	public Login(String title) {
		super(title);
		addControls();
		addEvents();
	}
	
	public void addControls() {
		try {
		Container con = getContentPane();
		JPanel boxMain = new JPanel();
		boxMain.setLayout(new BoxLayout(boxMain, BoxLayout.Y_AXIS));
		Color color = new Color(30, 144, 255);
//		UI.put("OptionPane.background",color);
//		UI.put("Panel.background",color);
//      boxMain.setBackground(Color.WHITE);
		Font font = new Font("Arial", Font.BOLD, 15);
		
		JPanel hangTaiKhoan = new JPanel();
		hangTaiKhoan.setLayout(new FlowLayout());
		hangTaiKhoan.setPreferredSize(new Dimension(0, 90));
		ImageIcon imgUser = new ImageIcon(getClass().getResource("/images/user_icon.png"));
		JLabel taiKhoan = new JLabel(imgUser);
		taiKhoan.setFont(font);
		taiKhoan.setPreferredSize(new Dimension(30, 100));
		textTaiKhoan = new JTextField();
		textTaiKhoan.setPreferredSize(new Dimension(140, 35));
		textTaiKhoan.setText("Nhập Tài Khoản");
		textTaiKhoan.setForeground(new Color(190, 190, 190));
		textTaiKhoan.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				String taiKhoan = textTaiKhoan.getText();
				
				if(taiKhoan.equals("") || taiKhoan.equalsIgnoreCase("Nhập Tài Khoản")) {
					//textMatKhau.setEchoChar('*');
					textTaiKhoan.setText("Nhập Tài Khoản");
					textTaiKhoan.setForeground(new Color(190, 190, 190));
				}
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				String taiKhoan = textTaiKhoan.getText();
				
				if(taiKhoan.equals("Nhập Tài Khoản")) {
					textTaiKhoan.setText("");
					textTaiKhoan.setForeground(new Color(0, 0, 0));
				}
				
			}
		});
		JPanel hangMatKhau = new JPanel();
		hangMatKhau.setLayout(new FlowLayout());
		hangMatKhau.setPreferredSize(new Dimension(0, 40));
		ImageIcon imgPass = new ImageIcon(getClass().getResource("/images/pass_icon.png"));
		JLabel matKhau = new JLabel(imgPass);
		matKhau.setFont(font);
		matKhau.setPreferredSize(new Dimension(30, 35));
		textMatKhau = new JPasswordField();
		textMatKhau.setPreferredSize(new Dimension(140, 35));
		textMatKhau.setEchoChar((char) 0);
		textMatKhau.setText("Nhập Mật Khẩu");
		textMatKhau.setForeground(new Color(190, 190, 190));
		textMatKhau.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				String matKhau = textMatKhau.getText();
				
				if(matKhau.equals("")) {
					textMatKhau.setEchoChar((char) 0);
					textMatKhau.setText("Nhập Mật Khẩu");
					textMatKhau.setForeground(new Color(190, 190, 190));
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				String matKhau = textMatKhau.getText();
				
				if(matKhau.equals("Nhập Mật Khẩu")) {
					textMatKhau.setEchoChar('*');
					textMatKhau.setText("");
					textMatKhau.setForeground(new Color(0, 0, 0));
				}
				
			}
		});
		JPanel hangNut = new JPanel();
		hangNut.setLayout(new FlowLayout());
		ImageIcon bntDangNhapIcon = new ImageIcon(getClass().getResource("/images/btn_dangnhap.png"));
		Border thickBorder = new LineBorder(color, 1);
		btnDangNhap = new JButton("Đăng Nhập");
		btnDangNhap.setForeground(Color.WHITE);
		btnDangNhap.setPreferredSize(new Dimension(170, 35));
		btnDangNhap.setBackground(color);
		btnDangNhap.setBorder(thickBorder);
		
		hangTaiKhoan.add(taiKhoan);
		hangTaiKhoan.add(textTaiKhoan);
		
		hangMatKhau.add(matKhau);
		hangMatKhau.add(textMatKhau);
		
		hangNut.add(btnDangNhap);
		
		
		
		boxMain.add(hangTaiKhoan);
		boxMain.add(hangMatKhau);
		boxMain.add(Box.createRigidArea(new Dimension(0, 10)));
		boxMain.add(hangNut);
		boxMain.add(Box.createRigidArea(new Dimension(0, 40)));
		
		
		con.add(boxMain);
		} catch (Exception e) {
			
		}
	}
	
	public void addEvents() {
		btnDangNhap.addActionListener(btnDangNhapEvents);
	}
	
	ActionListener btnDangNhapEvents = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String taiKhoan = textTaiKhoan.getText();
			String matKhau = textMatKhau.getText();
			
			
			
			if(taiKhoan.isEmpty() || taiKhoan.equals("Nhập Tài Khoản")) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập tài khoản");
				textTaiKhoan.requestFocus();
			} else if(matKhau.isEmpty() || matKhau.equals("Nhập Mật Khẩu")) {
				JOptionPane.showMessageDialog(null, "Vui lòng Nhập Mật Khẩu");
				textMatKhau.requestFocus();
			} else {
				int kt = loginStatement.check(taiKhoan, matKhau);
				if(kt > 0) {
					// tắt cửa sổ đăng nhập
					dispose();
					QuanLi myUI = new QuanLi("Quản lí trường học");
					myUI.showWindown();
					JOptionPane.showMessageDialog(null, "Xin chào: " + taiKhoan);
					
				} else {
					JOptionPane.showMessageDialog(null, "Sai tên mật khẩu hoặc mật khẩu. Vui lòng nhập lại");
					textMatKhau.setText("");
					textTaiKhoan.setText("");
					textTaiKhoan.requestFocus();
				}
			}
			
			
			
			
		}
	};
	
	
	
	public void showWindown() {
		this.setSize(400,300);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		// set focus vào nút đăng nhập khi show windown
		this.getRootPane().setDefaultButton(btnDangNhap);
		btnDangNhap.requestFocus();
	}
	

}
