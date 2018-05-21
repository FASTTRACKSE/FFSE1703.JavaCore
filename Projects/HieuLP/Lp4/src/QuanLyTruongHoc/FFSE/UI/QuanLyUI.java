package QuanLyTruongHoc.FFSE.UI;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class QuanLyUI extends JFrame {
	private static final long serialVersionUID = 1L;
	CardLayout cardlayout = new CardLayout();
	JPanel ttSV = new JPanel();
	private JButton qlLophoc;
	private JButton ThongTinSV;
	private JButton qlmonhoc;
	private JButton qlmonhoccholop;
	private JButton nhapDiem;
	private JButton thongke;
	LopHocUI lopHocUI;
	SinhVienUI sinhVienUI;
	MonHocUI monHocUI;
	MonCuaLopUI monCuaLop;
	NhapDiemUI nhapDiemUI;
	ThongKeUI thongKeUI;

	public QuanLyUI(String tieude) {
		super(tieude);
		addControls();
		addEvent();
	}

	public void addControls() {
		Container con = getContentPane();
		ttSV.setLayout(cardlayout);

		// Tiêu đề
		JPanel pnTitle = new JPanel();
		pnTitle.add(new JLabel(new ImageIcon("image/3.png")));
		pnTitle.setBackground(new Color(255, 255, 255));
		pnTitle.setMaximumSize(new Dimension(1700, 70));

		JPanel pnBorder = new JPanel();
		pnBorder.setLayout(new BorderLayout());
		JPanel pnNorth = new JPanel();
		pnNorth.add(pnTitle);
		pnBorder.add(pnNorth, BorderLayout.NORTH);
		pnNorth.setLayout(new BoxLayout(pnNorth, BoxLayout.Y_AXIS));

		// Icon Button
		JPanel pnWest = new JPanel();
		pnWest.setLayout(new BoxLayout(pnWest, BoxLayout.Y_AXIS));

		JPanel pnQuanLyLopHoc = new JPanel();
		ImageIcon iconView = new ImageIcon("image/qlLophoc.png");
		Image getIconView = iconView.getImage();
		Image newIconView = getIconView.getScaledInstance(80, 70, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newIconView);
		qlLophoc = new JButton("QUẢN LÝ LỚP HỌC     ", newIcon);
		qlLophoc.setFocusPainted(false);
		pnQuanLyLopHoc.add(qlLophoc);

		JPanel pnThongTinSV = new JPanel();
		ImageIcon iconView1 = new ImageIcon("image/thongtinsv.jpg");
		Image getIconView1 = iconView1.getImage();
		Image newIconView1 = getIconView1.getScaledInstance(80, 70, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon1 = new ImageIcon(newIconView1);
		ThongTinSV = new JButton("THÔNG TIN SINH VIÊN ", newIcon1);
		ThongTinSV.setFocusPainted(false);
		pnThongTinSV.add(ThongTinSV);

		JPanel pnQuanlymonhoc = new JPanel();
		ImageIcon iconView2 = new ImageIcon("image/monhoc.jpg");
		Image getIconView2 = iconView2.getImage();
		Image newIconView2 = getIconView2.getScaledInstance(80, 70, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon2 = new ImageIcon(newIconView2);
		qlmonhoc = new JButton("QUẢN LÝ MÔN HỌC     ", newIcon2);
		qlmonhoc.setFocusPainted(false);
		pnQuanlymonhoc.add(qlmonhoc);

		JPanel pnQuanlymonhoccholop = new JPanel();
		ImageIcon iconView2cholop = new ImageIcon("image/moncholop1.gif");
		Image getIconView2cholop = iconView2cholop.getImage();
		Image newIconView2cholop = getIconView2cholop.getScaledInstance(85, 70, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon2cholop = new ImageIcon(newIconView2cholop);
		qlmonhoccholop = new JButton("MÔN HỌC CỦA LỚP", newIcon2cholop);
		qlmonhoccholop.setFocusPainted(false);
		pnQuanlymonhoccholop.add(qlmonhoccholop);

		JPanel pnNhapdiem = new JPanel();
		ImageIcon iconView3 = new ImageIcon("image/nhapdiem.jpg");
		Image getIconView3 = iconView3.getImage();
		Image newIconView3 = getIconView3.getScaledInstance(80, 70, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon3 = new ImageIcon(newIconView3);
		nhapDiem = new JButton("NHẬP ĐIỂM SINH VIÊN", newIcon3);
		nhapDiem.setFocusPainted(false);
		pnNhapdiem.add(nhapDiem);

		JPanel pnThongke = new JPanel();
		ImageIcon iconView4 = new ImageIcon("image/thongke.jpg");
		Image getIconView4 = iconView4.getImage();
		Image newIconView4 = getIconView4.getScaledInstance(80, 70, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon4 = new ImageIcon(newIconView4);
		thongke = new JButton("THỐNG KÊ                       ", newIcon4);
		thongke.setFocusPainted(false);
		pnThongke.add(thongke);

		pnWest.add(pnQuanLyLopHoc, BorderLayout.SOUTH);
		pnWest.add(pnThongTinSV, BorderLayout.SOUTH);
		pnWest.add(pnQuanlymonhoc, BorderLayout.SOUTH);
		pnWest.add(pnQuanlymonhoccholop, BorderLayout.SOUTH);
		pnWest.add(pnNhapdiem, BorderLayout.SOUTH);
		pnWest.add(pnThongke, BorderLayout.SOUTH);
		pnBorder.add(pnWest, BorderLayout.WEST);

		lopHocUI = new LopHocUI();
		ttSV.add(lopHocUI, "1");

		pnBorder.add(ttSV);
		con.add(pnBorder);
		setVisible(true);

	}

	public void addEvent() {

		qlLophoc.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				lopHocUI = new LopHocUI();
				ttSV.add(lopHocUI, "1");
				cardlayout.show(ttSV, "1");
			}
		});

		ThongTinSV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sinhVienUI = new SinhVienUI();
				ttSV.add(sinhVienUI, "2");
				cardlayout.show(ttSV, "2");

			}
		});
		qlmonhoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				monHocUI = new MonHocUI();
				ttSV.add(monHocUI, "3");
				cardlayout.show(ttSV, "3");

			}
		});
		qlmonhoccholop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				monCuaLop = new MonCuaLopUI();
				ttSV.add(monCuaLop, "4");
				cardlayout.show(ttSV, "4");

			}
		});
		nhapDiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nhapDiemUI = new NhapDiemUI();
				ttSV.add(nhapDiemUI, "4");
				cardlayout.show(ttSV, "4");

			}
		});
		thongke.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				thongKeUI = new ThongKeUI();
				ttSV.add(thongKeUI, "5");
				cardlayout.show(ttSV, "5");

			}
		});

	}

	public void showWindow() {
		this.setSize(1000, 700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}