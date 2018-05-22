package ffse1703020.qltv.ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


import ffse1703020.qltv.main.MyApp;
import ffse1703020.qltv.model.CheckLogin;

public class QuanLiThuVienUI extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton docgia;
	private JPanel quanlydocgia, thongtingiaodich, thongkebaocao, quanlysach, quanlymuontra, logout;
	private JButton capnhat;
	private JButton sach;
	
	private JButton muontrasach,giaodich;
	private JButton thoat;
	

	public void ShowWindow() {
		this.setSize(1000, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public QuanLiThuVienUI(String tieude) {
		super(tieude);
		addControls();
		addEvents();
		ShowWindow();
	

	}

	private void addControls() {
		Container con = getContentPane();

		// Menu
		JPanel pnMain = new JPanel() { 
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) 
            { 
                Dimension d = getSize(); 
                Image img=this.getToolkit().getImage("icons/img1.jpg"); 
                g.drawImage(img, 0, 0, d.width, d.height, null); 

                setOpaque( false );  // lam trong suot  
                super.paintComponent(g); 
            } 
        };
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
//quản lí sách
		JPanel iconb = new JPanel();
		iconb.setOpaque( false );
		capnhat = new JButton(" Quản Lý Sách");
		capnhat.setPreferredSize(new Dimension(190, 60));
		ImageIcon img = new ImageIcon(
				new ImageIcon("icons/qlsach.png").getImage().getScaledInstance(40, 45, Image.SCALE_SMOOTH));
		JLabel lblIconUser1 = new JLabel(img);
		capnhat.add(lblIconUser1);
		iconb.add(capnhat);
//quản lí đọc giả
		JPanel icon = new JPanel();
		icon.setOpaque( false );
		docgia = new JButton(" Quản Lý Đọc Giả");
		docgia.setPreferredSize(new Dimension(190, 60));
		ImageIcon img1 = new ImageIcon(
				new ImageIcon("icons/bandoc.png").getImage().getScaledInstance(40, 45, Image.SCALE_SMOOTH));
		JLabel lblIconUser2 = new JLabel(img1);
		docgia.add(lblIconUser2);
		icon.add(docgia);
//thống kê báo cáo
		JPanel icon1 = new JPanel();
		icon1.setOpaque( false );
		sach = new JButton("Thống Kế,Báo Cáo");
		sach.setPreferredSize(new Dimension(190, 60));
		ImageIcon img2 = new ImageIcon(
				new ImageIcon("icons/tkbc.png").getImage().getScaledInstance(40, 45, Image.SCALE_SMOOTH));
		JLabel lblIconUser3 = new JLabel(img2);
		sach.add(lblIconUser3);
		icon1.add(sach);
//quản lí mượn trả sách
		JPanel icon2 = new JPanel();
		icon2.setOpaque( false );
		muontrasach = new JButton(" Quản Lý Mượn,Trả Sách");
		muontrasach.setPreferredSize(new Dimension(190, 60));
		ImageIcon img3 = new ImageIcon(
				new ImageIcon("icons/muon.png").getImage().getScaledInstance(25, 45, Image.SCALE_SMOOTH));
		JLabel lblIconmuon = new JLabel(img3);
		muontrasach.add(lblIconmuon);
		icon2.add(muontrasach);
////quản lí giao dịch
		JPanel icon3 = new JPanel();
		icon3.setOpaque( false );
		giaodich = new JButton(" Quản Lý Giao Dịch");
		giaodich.setPreferredSize(new Dimension(190, 60));
		ImageIcon img5 = new ImageIcon(
				new ImageIcon("icons/bussiness.png").getImage().getScaledInstance(35, 45, Image.SCALE_SMOOTH));
		JLabel lblIconmuon1 = new JLabel(img5);
		giaodich.add(lblIconmuon1);
		icon3.add(giaodich);
//logout
		JPanel icon4 = new JPanel();
		icon4.setOpaque( false );
		thoat = new JButton(" Logout");
		thoat.setPreferredSize(new Dimension(190, 60));
		ImageIcon img4 = new ImageIcon(
				new ImageIcon("icons/logout.png").getImage().getScaledInstance(40, 45, Image.SCALE_SMOOTH));
		JLabel lblIconlogout = new JLabel(img4);
		thoat.add(lblIconlogout);
		icon4.add(thoat);

		pnMain.add(iconb);
		pnMain.add(icon);
		pnMain.add(icon1);
		pnMain.add(icon2);
		pnMain.add(icon3);
		pnMain.add(icon4);
		con.add(pnMain, BorderLayout.LINE_END);
				// Card Layout\
		CardLayout t = new CardLayout();
		JPanel cards = new JPanel(t);
	

		quanlysach = new JPanel();// giao dien quan ly sach
		JLabel txt = new JLabel("Quản Lý Sách");
		quanlysach.add(txt);
		
		quanlydocgia = new JPanel();// giao dien quan ly doc gia
		JLabel txt1 = new JLabel("Quản Lý Đọc Giả");
		quanlydocgia.add(txt1);

		thongkebaocao = new JPanel();// giao dien cạp nhat
		JLabel txt2 = new JLabel("Quản Lý Thống Kê Báo Cáo");
		thongkebaocao.add(txt2);

		quanlymuontra = new JPanel();// giao dien mượn trả
		JLabel txt3 = new JLabel("Quản Lý Mượn,Trả Sách");
		quanlymuontra.add(txt3);
		
		thongtingiaodich = new JPanel();//giao diện thông tin giao dịch
		JLabel txt4 = new JLabel("Thông Tin Giao Dịch");
		thongtingiaodich.add(txt4);

		logout = new JPanel();// giao dien logout
		JLabel txt5 = new JLabel("Logout");
		logout.add(txt5);
        
		SachUI pnSach = new SachUI();
		BanDocUI pnBanDoc = new BanDocUI();
		ThongKeBaoCaoUI pnThongKeBaoCao = new ThongKeBaoCaoUI();
		MuonTraSachUI pnMuonTraSach = new MuonTraSachUI();
		QuanLiGiaoDichUI pnQuanLiGiaoDich = new QuanLiGiaoDichUI(); 
		

		cards.add(pnSach, "1");
		cards.add(pnBanDoc, "2");
		cards.add(pnThongKeBaoCao, "3");
		cards.add(pnMuonTraSach, "4");
		cards.add(pnQuanLiGiaoDich,"5");
		cards.add(logout, "6");
		getContentPane().add(cards);
		setVisible(true);

		// quan li doc gia
		docgia.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				t.show(cards, "2");
			}

		});
		// quan li sách
		capnhat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				t.show(cards, "1");

			}

		});
		// quan li muon, tra
		muontrasach.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				t.show(cards, "4");
			}

		});
		// quan li thống kê báo cáo
		sach.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				t.show(cards, "3");
			}

		});
		// thoat
		giaodich.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				t.show(cards, "5");
			}

		});
		// thoat
		thoat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				CheckLogin.setLoggedrole(null);
				MyApp.mainFrame.dispose();
				MyApp.loginFrame = new LoginUi("Đăng nhập hệ thống");
			}

		});
	
	}
	private void addEvents() {
		
	}
	
}
