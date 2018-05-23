package namdv.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;
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
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import namdv.main.MyApp;
import namdv.model.AccountModel;

@SuppressWarnings("serial")
public class LoginUI extends JFrame {
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnSubmit;
	private AccountModel accountModel = new AccountModel();

	public void showWindow() {
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public LoginUI(String tieude) {
		super(tieude);
		addControls();
		addEvents();

		showWindow();
	}

	private void addControls() {
		Container con = getContentPane();

		JPanel pnl = new JPanel();
		con.add(pnl);
		pnl.setLayout(new BorderLayout(0, 0));

		JPanel pnlNorth = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) pnlNorth.getLayout();
		flowLayout_2.setVgap(15);
		pnl.add(pnlNorth, BorderLayout.NORTH);

		JLabel lblHeader = new JLabel("ĐĂNG NHẬP");
		lblHeader.setFont(new Font("Tahoma", Font.BOLD, 15));
		pnlNorth.add(lblHeader);

		JPanel pnlCenter = new JPanel();
		pnl.add(pnlCenter);

		JPanel pnlBorder = new JPanel();
		pnlCenter.add(pnlBorder);
		pnlBorder.setLayout(new BoxLayout(pnlBorder, BoxLayout.Y_AXIS));

		JPanel pnlUser = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnlUser.getLayout();
		flowLayout.setHgap(20);
		pnlBorder.add(pnlUser);

		JLabel lblIconUser = new JLabel(getIcon("username.png", 35, 35));
		pnlUser.add(lblIconUser);

		JPanel pnlBorderUser = new JPanel();
		pnlBorderUser
				.setBorder(new TitledBorder(null, "Tài khoản", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlUser.add(pnlBorderUser);

		textField = new JTextField();
		pnlBorderUser.add(textField);
		textField.setPreferredSize(new Dimension(200, 25));

		JPanel pnlPass = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) pnlPass.getLayout();
		flowLayout_1.setHgap(20);
		pnlBorder.add(pnlPass);

		JLabel lblIconPass = new JLabel(getIcon("password.png", 37, 37));
		pnlPass.add(lblIconPass);

		JPanel pnlBorderPass = new JPanel();
		pnlBorderPass.setBorder(new TitledBorder(null, "Mật khẩu", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlPass.add(pnlBorderPass);

		passwordField = new JPasswordField();
		pnlBorderPass.add(passwordField);
		passwordField.setPreferredSize(textField.getPreferredSize());

		JPanel pnlSouth = new JPanel();
		pnl.add(pnlSouth, BorderLayout.SOUTH);
		pnlSouth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));

		btnSubmit = new JButton("ĐĂNG NHẬP");
		btnSubmit.setBorder(new LineBorder(UIManager.getColor("Button.light"), 1, true));
		btnSubmit.setPreferredSize(new Dimension(91, 30));
		pnlSouth.add(btnSubmit);
	}

	private void addEvents() {
		passwordField.addActionListener(new EnterListener());
		btnSubmit.addActionListener(new DangNhapListener());
	}

	private class EnterListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			btnSubmit.doClick();
		}
	}

	private class DangNhapListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				String username = textField.getText();
				String password = new String(passwordField.getPassword());

				if (username.isEmpty() || password.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Tên đăng nhập hoặc mật khẩu không được để trống!");
				} else if (!accountModel.checkLogin(username, password)) {
					JOptionPane.showMessageDialog(null, "Tên đăng nhập hoặc mật khẩu không đúng!");
				} else {
					MyApp.loginFrame.dispose();
					MyApp.mainFrame = new QuanLyThuVienUI("Quản lí thư viện");
				}
			} catch (HeadlessException | SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	private ImageIcon getIcon(String filename, int width, int height) {
		BufferedImage myPicture;
		try {
			String src = "src/namdv/icons/" + filename;
			myPicture = ImageIO.read(new File(src));
			ImageIcon icon = new ImageIcon(myPicture);
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			return icon;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}