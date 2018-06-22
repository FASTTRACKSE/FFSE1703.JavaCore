package ffse1703013.atm.layout;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class LayoutMagageATM extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LayoutMagageATM() {
		super("TP Bank");
		addControl();
		addEvents();

	}

	public void addEvents() {

	}

	public void addControl() {
		Container con = getContentPane();
		JPanel pnMain = new JPanel() {
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				Image img = this.getToolkit().getImage(
						"D:\\FFSE1703.JavaCore\\Assignments\\TuanNM\\du_an_quan_li_ATM\\src\\ffse1703013\\atm\\images\\main.jpg");
				g.drawImage(img, 0, 0, d.width, d.height, null);

				setOpaque(false); // lam trong suot
				super.paintComponent(g);
			}
		};
		pnMain.setLayout(new BorderLayout());
		JPanel pnMenu = new JPanel();
		pnMenu.setOpaque(false);

		JPanel pnSelected = new JPanel();
		pnSelected.setOpaque(false);

		// Image background = Toolkit.getDefaultToolkit().createImage("Background.png");
		// ((Object) pnSelected).drawImage(background, 0, 0, null);
		CardLayout cl = new CardLayout();
		pnSelected.setLayout(cl);

		// panel đã chọn
		pnMenu.setPreferredSize(new Dimension(200, 600));
		pnSelected.setPreferredSize(new Dimension(850, 600));

		// panel Khách hàng

		Border border = BorderFactory.createLineBorder(Color.decode("#191970"));
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Quản lí khách hàng", TitledBorder.CENTER,
				TitledBorder.DEFAULT_POSITION);
		LayoutKhachHang pnKhachHang = new LayoutKhachHang();
		pnKhachHang.setBorder(borderTitle);

		// jpanell Quản lí cây ATM

		Border borderATM = BorderFactory.createLineBorder(Color.decode("#191970"));
		TitledBorder borderTitleATM = BorderFactory.createTitledBorder(borderATM, "Quản lí máy ATM",
				TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
		LayoutATM pnATM = new LayoutATM();
		pnATM.setBorder(borderTitleATM);

		// jpanel Thống kê báo cáo khách hàng

		LayoutBaoCaoKH pnBaoCaoKH = new LayoutBaoCaoKH();

		// jpanel thống kê báo cáo mayATM
		LayoutBaoCaoATM pnBaoCaoKHRutTien = new LayoutBaoCaoATM();

		pnSelected.add(pnKhachHang, "1");
		pnSelected.add(pnATM, "2");
		pnSelected.add(pnBaoCaoKH, "4");
		pnSelected.add(pnBaoCaoKHRutTien, "5");

		cl.show(pnSelected, "1");

		// các panel con của menu
		JPanel pnAvatar = new JPanel();

		pnAvatar.setPreferredSize(new Dimension(200, 170));
		JLabel avatars = new JLabel();

		ImageIcon bgImage = new ImageIcon(
				"D:\\FFSE1703.JavaCore\\Assignments\\TuanNM\\du_an_quan_li_ATM\\src\\ffse1703013\\atm\\images\\avatars.png");
		bgImage.getImage().getScaledInstance(200, 170, Image.SCALE_SMOOTH);
		avatars.setIcon(bgImage);
		pnAvatar.add(avatars);

		// panel menu
		pnMenu.setLayout(new BoxLayout(pnMenu, BoxLayout.Y_AXIS));
		JPanel kh = new JPanel();
		ImageIcon iconKH = new ImageIcon(
				"D:\\FFSE1703.JavaCore\\Assignments\\TuanNM\\du_an_quan_li_ATM\\src\\ffse1703013\\atm\\images\\network.png");
		JButton buttonKH = new JButton("Quản lí khách hàng", iconKH);
		buttonKH.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		// buttonKH.setBackground(Color.decode("#FFF5EE"));
		buttonKH.setPreferredSize(new Dimension(200, 30));
		kh.add(buttonKH);

		JPanel atm = new JPanel();
		ImageIcon iconATM = new ImageIcon(
				"D:\\FFSE1703.JavaCore\\Assignments\\TuanNM\\du_an_quan_li_ATM\\src\\ffse1703013\\atm\\images\\if_atm_44572.png");
		JButton buttonATM = new JButton("Quản lí máy ATM", iconATM);
		buttonATM.setPreferredSize(new Dimension(200, 30));
		atm.add(buttonATM);

		JPanel tkKhachHang = new JPanel();
		ImageIcon iconTK = new ImageIcon(
				"D:\\FFSE1703.JavaCore\\Assignments\\TuanNM\\du_an_quan_li_ATM\\src\\ffse1703013\\atm\\images\\baocao.png");

		JButton buttonThongKeKH = new JButton("Thống kê Khách hàng", iconTK);
		buttonThongKeKH.setPreferredSize(new Dimension(200, 30));
		tkKhachHang.add(buttonThongKeKH);

		JPanel tkATM = new JPanel();
		ImageIcon iconTKATM = new ImageIcon(
				"D:\\FFSE1703.JavaCore\\Assignments\\TuanNM\\du_an_quan_li_ATM\\src\\ffse1703013\\atm\\images\\atm.png");

		JButton buttonThongKeATM = new JButton("Thống kê máy ATM", iconTKATM);
		buttonThongKeATM.setPreferredSize(new Dimension(200, 30));
		tkATM.add(buttonThongKeATM);

		JPanel action = new JPanel();
		JPanel action1 = new JPanel();
		JPanel action3 = new JPanel();
		JPanel action4 = new JPanel();
		JPanel action5 = new JPanel();
		JPanel action2 = new JPanel();
		JButton btnLogout = new JButton("Đăng xuất");
		JButton buttonExit = new JButton("Thoát");
		buttonExit.setLayout(new BoxLayout(buttonExit, BoxLayout.X_AXIS));
		action2.add(btnLogout);
		action2.add(buttonExit);

		// set độ mờ cho janel
		pnAvatar.setOpaque(false);
		kh.setOpaque(false);
		atm.setOpaque(false);

		tkKhachHang.setOpaque(false);
		tkATM.setOpaque(false);
		action.setOpaque(false);
		action1.setOpaque(false);
		action2.setOpaque(false);
		action3.setOpaque(false);
		action4.setOpaque(false);
		action5.setOpaque(false);

		pnMenu.add(pnAvatar);
		pnMenu.add(kh);
		pnMenu.add(atm);

		pnMenu.add(tkKhachHang);
		pnMenu.add(tkATM);
		pnMenu.add(action);
		pnMenu.add(action1);
		pnMenu.add(action3);
		pnMenu.add(action4);
		pnMenu.add(action5);
		pnMenu.add(action2);

		JSplitPane splitMain = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pnMenu, pnSelected);
		splitMain.setOpaque(false);

		splitMain.setContinuousLayout(true);
		splitMain.setOneTouchExpandable(true);
		splitMain.setDividerLocation(.1);

		/// sự kiện nhấn nút button khach hàng
		buttonKH.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(pnSelected, "1");
				buttonKH.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
				buttonATM.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
				buttonThongKeKH.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
				buttonThongKeATM.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
				pnKhachHang.duLieu();
			}
		});
		/// sự kiện nhấn nút button Atm
		buttonATM.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(pnSelected, "2");
				buttonATM.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
				buttonKH.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
				buttonThongKeKH.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
				buttonThongKeATM.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
				pnATM.duLieu();
			}
		});
		/// sự kiện nhấn nút button thống kê
		buttonThongKeKH.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(pnSelected, "4");
				buttonThongKeKH.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
				buttonKH.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
				buttonATM.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
				buttonThongKeATM.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
				pnBaoCaoKH.duLieu();
				
			}
		});
		buttonThongKeATM.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(pnSelected, "5");
				buttonThongKeATM.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
				buttonKH.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
				buttonATM.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
				buttonThongKeKH.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
				pnBaoCaoKHRutTien.selectDanhSach();
			}
		});
		btnLogout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn muốn đăng xuất?", "LOGUOT", dialogButton);
				if (dialogResult == JOptionPane.YES_OPTION) {
					LayoutLogin lg = new LayoutLogin("TP BANK");
					lg.showWindow();
					dispose();
				}
			}
		});
		buttonExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn muốn thoát chương trình?", "LOGUOT",
						dialogButton);
				if (dialogResult == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});

		pnMain.add(splitMain);

		con.add(pnMain);
	}

	public void showWindow() {
		this.setSize(1150, 680);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
