package ffse20.project_lp4.ui;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JButton;

public class QuanLySinhVienUI extends JFrame {
	private static final long serialVersionUID = 1L;

	private JButton btnQllh;
	private JButton btnQlsv;
	private JButton btnQlmh;
	private JButton btnQld;
	private JButton btnTk;
	private JButton btnMHLop;
	
	CardLayout cardlayout = new CardLayout();
	JPanel ttSV = new JPanel();
	
	
	private SinhVienUI sinhVienUI;
	private LopUI lopHocUI;
	private MonHocUI monHocUI;
	private MonHoc_LopUI monHocLopUI;
	private DiemUI nhapDiemUI;
	
	public QuanLySinhVienUI(String title) {
		super(title);
		addControls();
		addEvents();

	}

	public void addControls() {
		this.setResizable(false);
		Container con = getContentPane();
		
		ttSV.setLayout(cardlayout);

		JPanel pnTitle = new JPanel();
		pnTitle.add(new JLabel(new ImageIcon("image/ffse.png")));
		pnTitle.setBackground(new Color(255, 255, 255));
		pnTitle.setMaximumSize(new Dimension(1350, 70));

		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		///// Icon Button //////

		JPanel pnCenter = new JPanel();
		pnCenter.add(pnTitle);
		JPanel pnGroup1 = new JPanel();
		pnGroup1.setLayout(new BoxLayout(pnGroup1, BoxLayout.X_AXIS));

		JPanel pnAction = new JPanel();
		ImageIcon iconView = new ImageIcon("image/1.png");
		Image getIconView = iconView.getImage();
		Image newIconView = getIconView.getScaledInstance(70, 90, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newIconView);
		btnQllh = new JButton("QUẢN LÝ LỚP HỌC", newIcon);
		pnAction.add(btnQllh);
		pnGroup1.add(pnAction);

		JPanel pnAction1 = new JPanel();
		ImageIcon iconView1 = new ImageIcon("image/6.jpg");
		Image getIconView1 = iconView1.getImage();
		Image newIconView1 = getIconView1.getScaledInstance(70, 90, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon1 = new ImageIcon(newIconView1);
		btnQlsv = new JButton("QUẢN LÝ SINH VIÊN", newIcon1);
		pnAction1.add(btnQlsv);
		pnGroup1.add(pnAction1);

		JPanel pnAction2 = new JPanel();
		ImageIcon iconView2 = new ImageIcon("image/2.jpg");
		Image getIconView2 = iconView2.getImage();
		Image newIconView2 = getIconView2.getScaledInstance(70, 90, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon2 = new ImageIcon(newIconView2);
		btnQlmh = new JButton("QUẢN LÝ MÔN HỌC", newIcon2);
		pnAction2.add(btnQlmh);
		pnGroup1.add(pnAction2);
		
		JPanel pnAction5 = new JPanel();
		ImageIcon iconView5 = new ImageIcon("image/1a.jpg");
		Image getIconView5 = iconView5.getImage();
		Image newIconView5 = getIconView5.getScaledInstance(70, 90, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon5 = new ImageIcon(newIconView5);
		btnMHLop = new JButton("MÔN HỌC-LỚP    ", newIcon5);
		pnAction5.add(btnMHLop);
		pnGroup1.add(pnAction5);

		JPanel pnAction3 = new JPanel();
		ImageIcon iconView3 = new ImageIcon("image/a.jpg");
		Image getIconView3 = iconView3.getImage();
		Image newIconView3 = getIconView3.getScaledInstance(70, 90, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon3 = new ImageIcon(newIconView3);
		btnQld = new JButton("QUẢN LÝ ĐIỂM       ", newIcon3);
		pnAction3.add(btnQld);

		pnGroup1.add(pnAction3);

		JPanel pnAction4 = new JPanel();
		ImageIcon iconView4 = new ImageIcon("image/5.jpg");
		Image getIconView4 = iconView4.getImage();
		Image newIconView4 = getIconView4.getScaledInstance(70, 90, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon4 = new ImageIcon(newIconView4);
		btnTk = new JButton("THỐNG KÊ                ", newIcon4);
		pnAction4.add(btnTk);

		pnGroup1.add(pnAction4);
		pnCenter.add(pnGroup1);

		// Button menu
		JPanel Luachon = new JPanel();
		Luachon.setLayout(new BoxLayout(Luachon, BoxLayout.X_AXIS));
		Luachon.add(btnQllh);
		Luachon.add(btnQlsv);
		Luachon.add(btnQlmh);
		Luachon.add(btnMHLop);
		Luachon.add(btnQld);
		Luachon.add(btnTk);
		
		
		lopHocUI = new LopUI();
		ttSV.add(lopHocUI, "1");

		//////////////////////////
		pnMain.add(pnTitle);
		pnMain.add(Luachon, BorderLayout.WEST);
		pnMain.add(pnCenter);
		pnMain.add(ttSV);

		getContentPane().add(pnMain);

		con.add(pnMain);

	}


	public void addEvents() {


		btnQllh.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				lopHocUI = new LopUI();
				ttSV.add(lopHocUI, "1");
				cardlayout.show(ttSV, "1");
			}
		});

		btnQlsv.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				sinhVienUI = new SinhVienUI();
				ttSV.add(sinhVienUI, "2");
				cardlayout.show(ttSV, "2");
			}
		});
		btnQlmh.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				monHocUI = new MonHocUI();
				ttSV.add(monHocUI, "3");
				cardlayout.show(ttSV, "3");
			}
		});

		btnMHLop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				monHocLopUI = new MonHoc_LopUI();
				ttSV.add(monHocLopUI, "4");
				cardlayout.show(ttSV, "4");
			}
		});

		btnQld.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				nhapDiemUI = new DiemUI();
				ttSV.add(nhapDiemUI, "5");
				cardlayout.show(ttSV, "5");
			}
		});
	}
	

	public void showWindow() {
		this.setSize(1350, 750);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}

