package ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.sql.SQLException;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.gjt.mm.mysql.Driver;

import com.mysql.jdbc.Connection;

public class HomeUI extends JFrame {
	public JPanel pnRight = new JPanel();
	public ImageIcon sinhVien = new ImageIcon("icons/student.png");
	public ImageIcon lopHoc = new ImageIcon("icons/class.png");
	public ImageIcon monHoc = new ImageIcon("icons/subject.png");
	public ImageIcon diem = new ImageIcon("icons/static.png");
	public ImageIcon danhSach = new ImageIcon("icons/document.png");
	public ImageIcon thoat = new ImageIcon("icons/exit.png");
	public JButton btnSV = new JButton("Quản lý sinh viên", sinhVien);
	public JButton btnLH = new JButton("Quản lý lớp học", lopHoc);
	public JButton btnMH = new JButton("Danh sách môn học", monHoc);
	public JButton btnDiem = new JButton("Quản lý điểm", diem);
	public JButton btnTKSV = new JButton("Thống kê sinh viên", danhSach);
	public JButton btnTKLH = new JButton("Thống kê lớp học", danhSach);
	public JButton btnExit = new JButton("Thoát", thoat);
	
	public HomeUI(String title) {
		super(title);
		addControllers();
		addEvents();
	}

	private void addEvents() {
		btnSV.addActionListener(QuanLySV);
		btnLH.addActionListener(QuanLyLH);
		btnMH.addActionListener(QuanLyMH);
		btnDiem.addActionListener(QuanLyDiem);
		btnTKSV.addActionListener(ThongKeSV);
		btnTKLH.addActionListener(ThongKeLH);
		btnExit.addActionListener(thoatCT);
	}
	private void addControllers() {
		Container conn = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BorderLayout());
		
		JPanel pnLeft = new JPanel();
		pnLeft.setLayout(new BoxLayout(pnLeft, BoxLayout.Y_AXIS));
		pnLeft.setPreferredSize(new Dimension(175, HEIGHT));
		pnRight.setLayout(new CardLayout());
		
		JPanel pnLogo = new JPanel();
		ImageIcon logo = new ImageIcon("icons/school.png");
		JLabel addlogo = new JLabel(logo);
		pnLogo.setPreferredSize(new Dimension(100, 100));
		pnLogo.add(addlogo);
		
		
		
		JPanel pnButton = new JPanel();
		pnButton.setLayout(new GridLayout(10, 1, 10, 10));
		pnButton.add(btnSV);
		pnButton.add(btnLH);
		pnButton.add(btnMH);
		pnButton.add(btnDiem);
		pnButton.add(btnTKSV);
		pnButton.add(btnTKLH);
		pnButton.add(btnExit);
		
		btnSV.setHorizontalAlignment(SwingConstants.LEFT);
		btnMH.setHorizontalAlignment(SwingConstants.LEFT);
		btnLH.setHorizontalAlignment(SwingConstants.LEFT);
		btnTKLH.setHorizontalAlignment(SwingConstants.LEFT);
		btnTKSV.setHorizontalAlignment(SwingConstants.LEFT);
		btnDiem.setHorizontalAlignment(SwingConstants.LEFT);
		btnExit.setHorizontalAlignment(SwingConstants.LEFT);
		
		pnLeft.add(pnLogo);
		pnLeft.add(pnButton);
		
		QuanLySinhVienUI pnQuanLySinhVien = new QuanLySinhVienUI();
		
		pnRight.add("qlsv", pnQuanLySinhVien);
		pnMain.add(pnRight,BorderLayout.CENTER);
		pnMain.add(pnLeft, BorderLayout.WEST);
		conn.add(pnMain);
	}
	
	ActionListener QuanLySV = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			QuanLySinhVienUI pnQuanLySinhVien = new QuanLySinhVienUI();
			pnRight.add("qlsv", pnQuanLySinhVien);
			CardLayout card = (CardLayout) pnRight.getLayout();
			card.show(pnRight, "qlsv");
		}
	};
	ActionListener QuanLyMH = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			QuanLyMonHocUI pnQuanLyMonHoc = new QuanLyMonHocUI();
			CardLayout card = (CardLayout) pnRight.getLayout();
			pnRight.add("qlmh", pnQuanLyMonHoc);
			card.show(pnRight, "qlmh");
		}
	};
	ActionListener QuanLyLH = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			QuanLyLopHocUI pnQuanLyLopHoc = new QuanLyLopHocUI();
			CardLayout card = (CardLayout) pnRight.getLayout();
			pnRight.add("qllh", pnQuanLyLopHoc);
			card.show(pnRight, "qllh");
		}
	};
	ActionListener QuanLyDiem = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			QuanLyDiemSinhVienUI pnQuanLyDiem = new QuanLyDiemSinhVienUI();
			CardLayout card = (CardLayout) pnRight.getLayout();
			pnRight.add("qld", pnQuanLyDiem);
			card.show(pnRight, "qld");
		}
	};
	ActionListener ThongKeSV = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			ThongKeSinhVienUI pnThongKeSV = new ThongKeSinhVienUI();
			CardLayout card = (CardLayout) pnRight.getLayout();
			pnRight.add("tksv", pnThongKeSV);
			card.show(pnRight, "tksv");
		}
	};
	ActionListener ThongKeLH = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			ThongKeLopHocUI pnThongKeLH = new ThongKeLopHocUI();
			CardLayout card = (CardLayout) pnRight.getLayout();
			pnRight.add("tklh", pnThongKeLH);
			card.show(pnRight, "tklh");
		}
	};
	ActionListener thoatCT = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			int mess = JOptionPane.showConfirmDialog(null, "Bạn muốn tắt chương trình?", "Thoat", JOptionPane.YES_NO_OPTION);
			if (mess == JOptionPane.YES_OPTION) {
				JOptionPane.showMessageDialog(null, "Cảm ơn đã sử dụng chương trình của chúng tôi!!(*_*)", "Cảm ơn", 1);
				System.exit(0);
			} else {
			}
		}
	};

	public void showWindow() {
		this.setSize(1000, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
}
