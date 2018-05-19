package ffse1703020.qltv.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

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

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import ffse1703020.qltv.main.MyApp;
import ffse1703020.qltv.model.AccountModel;
import ffse1703020.qltv.model.ConnectDB;
import ffse1703020.qltv.model.MyException;

@SuppressWarnings("serial")
public class LoginUi extends JFrame {
	ConnectDB cn = new ConnectDB();
	Connection conn = (Connection) ConnectDB.getConnect();
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnSubmit, btnTaiKhoan;
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
	public LoginUi(String tieude) {
		super(tieude);
		addControls();
		addEvents();
		showWindow();
	}

	private void addControls() {
		Container con = getContentPane();

		JPanel pnl = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				Image img = this.getToolkit().getImage("icons/img.jpg");
				g.drawImage(img, 0, 0, d.width, d.height, null);

				setOpaque(false); // lam trong suot
				super.paintComponent(g);
			}
		};

		con.add(pnl);
		pnl.setLayout(new BorderLayout(0, 0));

		JPanel pnlNorth = new JPanel();
		pnlNorth.setOpaque(false);
		FlowLayout flowLayout_2 = (FlowLayout) pnlNorth.getLayout();
		flowLayout_2.setVgap(15);
		pnl.add(pnlNorth, BorderLayout.NORTH);

		JLabel lblHeader = new JLabel("Đăng nhập");
		lblHeader.setFont(new Font("Tahoma", Font.BOLD, 20));
		pnlNorth.add(lblHeader);

		JPanel pnlCenter = new JPanel();
		pnlCenter.setOpaque(false);
		pnl.add(pnlCenter);

		JPanel pnlBorder = new JPanel();
		pnlBorder.setOpaque(false);
		pnlCenter.add(pnlBorder);
		pnlBorder.setLayout(new BoxLayout(pnlBorder, BoxLayout.Y_AXIS));

		JPanel pnlUser = new JPanel();
		pnlUser.setOpaque(false);
		FlowLayout flowLayout = (FlowLayout) pnlUser.getLayout();
		flowLayout.setHgap(20);
		pnlBorder.add(pnlUser);

		ImageIcon icon = new ImageIcon(
				new ImageIcon("icons/admin-icon.png").getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH));
		JLabel lblIconUser = new JLabel(icon);
		pnlUser.add(lblIconUser);

		JPanel pnlBorderUser = new JPanel();
		pnlBorderUser.setOpaque(false);
		pnlBorderUser
				.setBorder(new TitledBorder(null, "Tài khoản", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlUser.add(pnlBorderUser);

		textField = new JTextField();
		pnlBorderUser.add(textField);
		textField.setPreferredSize(new Dimension(200, 25));

		JPanel pnlPass = new JPanel();
		pnlPass.setOpaque(false);
		FlowLayout flowLayout_1 = (FlowLayout) pnlPass.getLayout();
		flowLayout_1.setHgap(20);
		pnlBorder.add(pnlPass);

		ImageIcon icon1 = new ImageIcon(
				new ImageIcon("icons/pass.png").getImage().getScaledInstance(40, 45, Image.SCALE_SMOOTH));
		JLabel lblIconUser1 = new JLabel(icon1);
		pnlPass.add(lblIconUser1);

		JPanel pnlBorderPass = new JPanel();
		pnlBorderPass.setOpaque(false);
		pnlBorderPass.setBorder(new TitledBorder(null, "Mật khẩu", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlPass.add(pnlBorderPass);

		passwordField = new JPasswordField();
		pnlBorderPass.add(passwordField);
		passwordField.setPreferredSize(textField.getPreferredSize());

		JPanel pnlSouth = new JPanel();
		pnlSouth.setOpaque(false);
		pnl.add(pnlSouth, BorderLayout.SOUTH);
		pnlSouth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));

		btnSubmit = new JButton("Đăng nhập");
		btnSubmit.setBorder(new LineBorder(UIManager.getColor("Button.light"), 1, true));
		btnSubmit.setPreferredSize(new Dimension(100, 30));

		btnTaiKhoan = new JButton("Tạo Tài Khoản");
		btnTaiKhoan.setBorder(new LineBorder(UIManager.getColor(""), 1, true));
		btnTaiKhoan.setPreferredSize(new Dimension(100, 30));
		pnlSouth.add(btnSubmit);
		pnlSouth.add(btnTaiKhoan);
	}

	private void addEvents() {
		passwordField.addActionListener(new EnterListener());
		btnSubmit.addActionListener(new DangNhapListener());
		btnTaiKhoan.addActionListener(evInsert);

	}

	private class EnterListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			btnSubmit.doClick();
		}
	}

	ActionListener evInsert = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			try {
				insert();
			} catch (MyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	};

	@SuppressWarnings("deprecation")
	public void insert() throws MyException {
		try {

			if (MyException.ChekEmpty(textField.getText()) && MyException.ChekEmpty(passwordField.getText())) {
				if (conn != null) {
					String sql = "INSERT INTO account (username, password, role, ma_ban_doc) VALUES (?,?,'bandoc','DK')";
					try {

						PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
						// khởi tạo resultset
						ptmt.setString(1, textField.getText());
						ptmt.setString(2, passwordField.getText());
						int k = ptmt.executeUpdate();
						if (k != 0) {
							JOptionPane.showMessageDialog(null, "Thêm thành công");
							textField.setText("");
							passwordField.setText("");
						} else
							JOptionPane.showMessageDialog(null, "Thêm không thành công");
					} catch (SQLException e) {
						System.out.println("loi  " + e.getMessage());
					}
				} else {
					System.out.println("Kết nối MYSQL thất bại");
				}
			}
		} catch (MyException e) {
			System.out.println(e);
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
					MyApp.mainFrame = new QuanLiThuVienUI("Quản lí thư viện");
				}
			} catch (HeadlessException | SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

}
