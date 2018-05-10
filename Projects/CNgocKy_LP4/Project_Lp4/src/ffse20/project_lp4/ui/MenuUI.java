package ffse20.project_lp4.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.nio.file.Path;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class MenuUI extends JFrame {
	private String[] lop = { "Tất Cả", "FFSE1701", "FFSE1702", "FFSE1703", "FFSE1704" };
	private JButton btnThem = new JButton("Thêm");
	private JButton btnSua = new JButton("Sửa");
	private JButton btnXoa = new JButton("Xóa");

	public MenuUI(String title) {
		super(title);
		addControls();
		// addEvents();
	}

	public void addControls() {
		this.setResizable(false);
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		JPanel pnTitle = new JPanel();
		pnTitle.add(new JLabel(new ImageIcon("image/ffse.png")));
		pnTitle.setBackground(new Color(255, 255, 255));
		pnTitle.setMaximumSize(new Dimension(1300, 70));

		JPanel pnGroup1 = new JPanel();
		pnGroup1.setLayout(new BoxLayout(pnGroup1, BoxLayout.X_AXIS));

		JPanel pnAction = new JPanel();
		ImageIcon iconView = new ImageIcon("image/1.png");
		Image getIconView = iconView.getImage();
		Image newIconView = getIconView.getScaledInstance(90, 100, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newIconView);
		JButton btnQlkh = new JButton("QUẢN LÝ LỚP HỌC", newIcon);

		pnAction.add(btnQlkh);
		pnGroup1.add(pnAction);

		JPanel pnAction1 = new JPanel();
		ImageIcon iconView1 = new ImageIcon("image/6.jpg");
		Image getIconView1 = iconView1.getImage();
		Image newIconView1 = getIconView1.getScaledInstance(90, 100, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon1 = new ImageIcon(newIconView1);
		JButton btnQlbl = new JButton("QUẢN LÝ SINH VIÊN", newIcon1);
		pnAction1.add(btnQlbl);
		pnGroup1.add(pnAction1);

		JPanel pnAction2 = new JPanel();
		ImageIcon iconView2 = new ImageIcon("image/2.jpg");
		Image getIconView2 = iconView2.getImage();
		Image newIconView2 = getIconView2.getScaledInstance(90, 100, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon2 = new ImageIcon(newIconView2);
		JButton btnBckh = new JButton("QUẢN LÝ MÔN HỌC", newIcon2);
		pnAction2.add(btnBckh);
		pnGroup1.add(pnAction2);

		JPanel pnAction3 = new JPanel();
		ImageIcon iconView3 = new ImageIcon("image/3.png");
		Image getIconView3 = iconView3.getImage();
		Image newIconView3 = getIconView3.getScaledInstance(90, 100, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon3 = new ImageIcon(newIconView3);
		JButton btnBctd = new JButton("QUẢNG LÝ ĐIỂM      ", newIcon3);
		pnAction3.add(btnBctd);

		pnGroup1.add(pnAction3);

		JPanel pnAction4 = new JPanel();
		ImageIcon iconView4 = new ImageIcon("image/5.jpg");
		Image getIconView4 = iconView4.getImage();
		Image newIconView4 = getIconView4.getScaledInstance(90, 100, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon4 = new ImageIcon(newIconView4);
		JButton btnBctdd = new JButton("THỐNG KÊ                ", newIcon4);
		pnAction4.add(btnBctdd);

		pnGroup1.add(pnAction4);

		pnMain.add(Box.createRigidArea(new Dimension(30, 20)));
		pnMain.add(pnTitle);

		pnMain.add(pnGroup1);

		JPanel pnSouth = new JPanel();
		Border border2 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle2 = BorderFactory.createTitledBorder(border2, "NHẬP THÔNG TIN");
		pnSouth.setBorder(borderTitle2);

		JPanel chonlop = new JPanel();
		JLabel txtlop = new JLabel("Chọn Mã: ");
		JComboBox select = new JComboBox(lop);

		chonlop.add(txtlop);
		chonlop.add(select);
		pnSouth.add(chonlop);

		JPanel nhapTenlop = new JPanel();
		nhapTenlop.setLayout(new FlowLayout());
		JLabel lblNhaptenlop = new JLabel("Tên lớp:");
		JTextField tenLop = new JTextField(20);
		nhapTenlop.add(lblNhaptenlop);
		nhapTenlop.add(tenLop);
		pnSouth.add(nhapTenlop);

		JPanel nhapNamhoc = new JPanel();
		nhapNamhoc.setLayout(new FlowLayout());
		JLabel lblNhapNamhoc = new JLabel("Năm học:");
		JTextField namHoc = new JTextField(20);
		nhapNamhoc.add(lblNhapNamhoc);
		nhapNamhoc.add(namHoc);
		pnSouth.add(nhapNamhoc);

		JPanel nhapMota = new JPanel();
		nhapMota.setLayout(new FlowLayout());
		JLabel lblNhapMota = new JLabel("Mô tả:");
		JTextField moTa = new JTextField(20);
		nhapMota.add(lblNhapMota);
		nhapMota.add(moTa);
		pnSouth.add(nhapMota);

		JPanel chucNang = new JPanel();
		chucNang.setLayout(new FlowLayout());
		chucNang.add(btnThem);
		chucNang.add(btnSua);
		chucNang.add(btnXoa);
		pnSouth.add(chucNang);
		getContentPane().add(pnSouth);

		pnMain.add(pnSouth, BorderLayout.SOUTH);

		JPanel pnTable = new JPanel();
		DefaultTableModel dm = new DefaultTableModel();
		JTable tbl = new JTable(dm);
		dm.addColumn("Mã");
		dm.addColumn("Tên");
		dm.addColumn("Tuổi");
		dm.addColumn("Lớp");

		JScrollPane sc = new JScrollPane(tbl);
		JScrollPane VT = new JScrollPane(sc, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		VT.setPreferredSize(new Dimension(1200, 300));
		pnTable.add(VT, BorderLayout.CENTER);
		pnMain.add(pnTable);

		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Danh sách");
		pnTable.setBorder(borderTitle);

		getContentPane().add(pnMain);

		con.add(pnMain);

	}

	public void showWindow() {
		this.setSize(1250, 750);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
