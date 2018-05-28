package ffse1703013.atm.layout;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import ffse1703013.atm.model.DatabaseUser;

public class LayoutLogin extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton buttonSubmit, buttonSubmitGD;
	private JTextField txtTenDangNhap, htLoi, txtTenDangNhapGD;
	private JPasswordField txtMatKhau, txtMatKhauGD;

	public LayoutLogin(String title) {
		super(title);
		addControl();
		addEvents();

	}

	public void addControl() {
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setBackground(Color.BLACK);
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		JPanel tieuDe = new JPanel();
		tieuDe.setBackground(Color.decode("#87CEFA"));
		ImageIcon imgLogin = new ImageIcon(
				"D:\\FFSE1703.JavaCore\\Assignments\\TuanNM\\du_an_quan_li_ATM\\src\\ffse1703013\\atm\\images\\tpbank.jpg");
		JLabel nameTieuDe = new JLabel(imgLogin);

		tieuDe.add(nameTieuDe);

		JPanel pnLoi = new JPanel();
		pnLoi.setBackground(Color.decode("#87CEFA"));
		htLoi = new JTextField(30);
		htLoi.setHorizontalAlignment(JLabel.CENTER);
		htLoi.setBackground(Color.decode("#87CEFA"));
		htLoi.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.LIGHT_GRAY));
		htLoi.setForeground(Color.RED);
		htLoi.setEditable(false);
		Font font4 = new Font("Arial", Font.BOLD | Font.ITALIC, 18);
		htLoi.setFont(font4);
		pnLoi.add(htLoi);
		// panel đăng nhập quản lí
		JPanel pnTenDangNhap = new JPanel();
		pnTenDangNhap.setBackground(Color.decode("#87CEFA"));
		@SuppressWarnings("unused")
		ImageIcon iconName = new ImageIcon(
				"D:\\FFSE1703.JavaCore\\Assignments\\TuanNM\\du_an_quan_li_ATM\\src\\ffse1703013\\atm\\images\\if_Username_372902.png");
		JLabel nameDangNhap = new JLabel(iconName);
		txtTenDangNhap = new JTextField(20);
		txtTenDangNhap.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		pnTenDangNhap.add(nameDangNhap);
		pnTenDangNhap.add(txtTenDangNhap);

		JPanel pnMatKhau = new JPanel();
		pnMatKhau.setBackground(Color.decode("#87CEFA"));
		ImageIcon iconPass = new ImageIcon(
				"D:\\FFSE1703.JavaCore\\Assignments\\TuanNM\\du_an_quan_li_ATM\\src\\ffse1703013\\atm\\images\\pass.png");
		JLabel nameMatKhau = new JLabel(iconPass);
		nameMatKhau.setPreferredSize(nameDangNhap.getPreferredSize());
		txtMatKhau = new JPasswordField(20);
		txtMatKhau.setEchoChar('*');
		txtMatKhau.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		pnMatKhau.add(nameMatKhau);
		pnMatKhau.add(txtMatKhau);

		JPanel pnButton = new JPanel();
		pnButton.setBackground(Color.decode("#87CEFA"));
		buttonSubmit = new JButton("Đăng nhập");
		buttonSubmit.setPreferredSize(new Dimension(150, 30));
		buttonSubmit.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		buttonSubmit.setBackground(Color.decode("#F08080"));
		buttonSubmit.setForeground(Color.WHITE);
		Font font7 = new Font("Arial", Font.BOLD | Font.ITALIC, 16);
		buttonSubmit.setFont(font7);
		pnButton.add(buttonSubmit);
		// add vào panel
		JPanel pnLoginQuanLi = new JPanel();
		pnLoginQuanLi.setBackground(Color.decode("#87CEFA"));
		pnLoginQuanLi.setLayout(new BoxLayout(pnLoginQuanLi, BoxLayout.Y_AXIS));
		pnLoginQuanLi.setPreferredSize(new Dimension(100, 450));
		pnLoginQuanLi.add(pnTenDangNhap);
		pnLoginQuanLi.add(pnMatKhau);
		pnLoginQuanLi.add(pnButton);

		// panel dang nhập giao dịch
		JPanel pnTenDangNhapGD = new JPanel();
		pnTenDangNhapGD.setBackground(Color.decode("#87CEFA"));
		ImageIcon iconThe = new ImageIcon(
				"D:\\FFSE1703.JavaCore\\Assignments\\TuanNM\\du_an_quan_li_ATM\\src\\ffse1703013\\atm\\images\\card.png");
		JLabel nameDangNhapGD = new JLabel(iconThe);

		txtTenDangNhapGD = new JTextField(20);
		txtTenDangNhapGD.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		pnTenDangNhapGD.add(nameDangNhapGD);
		pnTenDangNhapGD.add(txtTenDangNhapGD);

		JPanel pnMatKhauGD = new JPanel();
		pnMatKhauGD.setBackground(Color.decode("#87CEFA"));
		ImageIcon iconMaPin = new ImageIcon(
				"D:\\FFSE1703.JavaCore\\Assignments\\TuanNM\\du_an_quan_li_ATM\\src\\ffse1703013\\atm\\images\\pass.png");

		JLabel nameMatKhauGD = new JLabel(iconMaPin);

		txtMatKhauGD = new JPasswordField(20);
		txtMatKhauGD.setEchoChar('*');
		txtMatKhauGD.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		pnMatKhauGD.add(nameMatKhauGD);
		pnMatKhauGD.add(txtMatKhauGD);

		JPanel pnButtonGD = new JPanel();
		pnButtonGD.setBackground(Color.decode("#87CEFA"));
		buttonSubmitGD = new JButton("Đăng nhập");
		buttonSubmitGD.setPreferredSize(new Dimension(150, 30));
		buttonSubmitGD.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		buttonSubmitGD.setBackground(Color.decode("#F08080"));
		buttonSubmitGD.setForeground(Color.WHITE);
		Font font6 = new Font("Arial", Font.BOLD | Font.ITALIC, 16);
		buttonSubmitGD.setFont(font6);
		pnButtonGD.add(buttonSubmitGD);

		JPanel pnLoginGD = new JPanel();
		pnLoginGD.setBackground(Color.decode("#87CEFA"));
		pnLoginGD.setLayout(new BoxLayout(pnLoginGD, BoxLayout.Y_AXIS));
		pnLoginGD.setPreferredSize(new Dimension(70, 450));
		pnLoginGD.add(pnTenDangNhapGD);
		pnLoginGD.add(pnMatKhauGD);
		pnLoginGD.add(pnButtonGD);

		// đưa vào cardlayout
		CardLayout cl = new CardLayout();
		JPanel pnLogin = new JPanel(cl);
		pnLogin.setBackground(Color.decode("#87CEFA"));
		pnLogin.add(pnLoginQuanLi, "1");
		pnLogin.add(pnLoginGD, "2");
		cl.show(pnLogin, "1");

		// PANEL chọn login

		JPanel pnRadio = new JPanel();
		pnRadio.setBackground(Color.decode("#87CEFA"));

		JRadioButton r1 = new JRadioButton("Quản lí ATM");
		r1.setBackground(Color.decode("#87CEFA"));
		r1.setPreferredSize(new Dimension(200, 20));
		r1.setSelected(true);
		r1.setBounds(50, 100, 70, 30);
		JRadioButton r2 = new JRadioButton("Rút tiền khách hàng");
		r2.setPreferredSize(new Dimension(150, 20));
		r2.setBackground(Color.decode("#87CEFA"));
		r2.setBounds(50, 150, 70, 30);

		ButtonGroup bg = new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		pnRadio.add(r1);
		pnRadio.add(r2);

		///

		pnMain.add(tieuDe);

		pnMain.add(pnLoi);
		pnMain.add(pnLogin);
		pnMain.add(pnRadio);

		con.add(pnMain);

		// bắt sự kiện cho chuyển kiểu đăng nhập
		r1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(pnLogin, "1");
				htLoi.setText("");
			}
		});
		r2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(pnLogin, "2");
				htLoi.setText("");
			}
		});
	}

	public void addEvents() {
		buttonSubmit.addActionListener(eventDangNhap);
		txtMatKhau.addActionListener(eventDangNhap);
		txtTenDangNhap.addActionListener(eventDangNhap);
		buttonSubmitGD.addActionListener(eventDangNhapGD);
		txtMatKhauGD.addActionListener(eventDangNhapGD);
		txtTenDangNhapGD.addActionListener(eventDangNhapGD);
	}

	ActionListener eventDangNhap = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			String ten = txtTenDangNhap.getText();
			@SuppressWarnings("deprecation")
			String matKhau = txtMatKhau.getText();

			if (ten.isEmpty() || matKhau.isEmpty()) {
				htLoi.setText("Vui lòng  nhập đầy đủ thông tin !!");

			} else if (login()) {
				dispose();
				layoutATM();
				ImageIcon tb = new ImageIcon(
						"D:\\FFSE1703.JavaCore\\Assignments\\TuanNM\\du_an_quan_li_ATM\\src\\ffse1703013\\atm\\images\\TPBANK WAGC 2015.png");
				JOptionPane.showMessageDialog(null, "", "XIN CHÀO", JOptionPane.INFORMATION_MESSAGE, tb);

			} else {
				htLoi.setText("Tên đăng nhập hoặc mật khẩu không chính xác !!");
			}
		}
	};
	ActionListener eventDangNhapGD = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			String ten = txtTenDangNhapGD.getText();
			@SuppressWarnings("deprecation")
			String matKhau = txtMatKhauGD.getText();

			if (ten.isEmpty() || matKhau.isEmpty()) {
				htLoi.setText("Vui lòng  nhập đầy đủ thông tin !!");

			} else if (loginGD()) {
				dispose();
				layoutRutTien();
			} else {
				htLoi.setText("Số thẻ hoặc mã pin không chính xác !!");
			}

		}
	};

	@SuppressWarnings("deprecation")
	public boolean login() {
		if (DatabaseUser.checkLogin(txtTenDangNhap.getText(), txtMatKhau.getText())) {
			return true;
		} else {
			return false;
		}
	}

	@SuppressWarnings("deprecation")
	public boolean loginGD() {
		if (DatabaseUser.checkLoginGD(txtTenDangNhapGD.getText(), txtMatKhauGD.getText())) {
			return true;
		} else {
			return false;
		}
	}

	public void layoutATM() {
		LayoutMagageATM atm = new LayoutMagageATM();
		atm.showWindow();
	}

	public void layoutRutTien() {
		LayoutRutTien rt = new LayoutRutTien();
		String soThe = txtTenDangNhapGD.getText();
		rt.showWindow();
		rt.thongTinKH(soThe);
	}

	public void showWindow() {
		this.setSize(550, 440);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
