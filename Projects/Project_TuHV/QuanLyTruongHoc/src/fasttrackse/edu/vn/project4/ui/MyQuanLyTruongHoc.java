package fasttrackse.edu.vn.project4.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class MyQuanLyTruongHoc extends JFrame {

	int stt = 0;

	DefaultTableModel dm;

	JTable tbl;

	CardLayout cardlayout;

	private JPanel pnCenter = new JPanel();
	private JPanel pnCenter4 = new JPanel();

	private JPanel pnBorder = new JPanel();

	private JPanel pnBorder4 = new JPanel();

	private Button btn1 = new Button("QUẢN LÝ SINH VIÊN");
	private Button btn2 = new Button("QUẢN LÝ ĐIỂM");
	private Button btn3 = new Button("QUẢN LÝ LỚP HỌC");
	private Button btn4 = new Button("QUẢN LÝ MÔN HỌC");
	private Button btn5 = new Button("THỐNG KÊ BÁO CÁO");
	private Button btn6 = new Button("QLMH CHO TỪNG LỚP");
	

	private QuanLyDiemUI nhapDiem;
	private QuanLySinhVienUI sinhVien;
	private QuanLyLopHocUI lopHoc;
	private QuanLyMonHocUI monHoc;
	private QuanLyMonHocTungMonUI monChoTungLop;

	public MyQuanLyTruongHoc(String tieude) {
		this.setTitle(tieude);
		addControls();

		addEvent();
	}

	public void addControls() {
		Container con = getContentPane();
		cardlayout = new CardLayout();
		pnCenter.setLayout(cardlayout);

		pnBorder.setLayout(new BorderLayout());

		JPanel pnWest = new JPanel();
		pnWest.setLayout(new BoxLayout(pnWest, BoxLayout.Y_AXIS));
		pnWest.add(btn1);
		pnWest.add(btn2);
		pnWest.add(btn3);
		pnWest.add(btn4);
		pnWest.add(btn6);
		pnWest.add(btn5);
		pnBorder.add(pnWest, BorderLayout.WEST);

		// thống kê báo cáo
		pnBorder4.setLayout(new BorderLayout());
		JLabel lblbaocao = new JLabel("Chương Trình Thống Kê Báo Cáo");
		Font fontbaocao = new Font("Arial", Font.BOLD, 24);
		lblbaocao.setFont(fontbaocao);

		JPanel pnNorth4 = new JPanel();
		pnNorth4.setBackground(Color.blue);
		pnNorth4.add(lblbaocao);
		pnCenter4.add(pnNorth4, BorderLayout.NORTH);

		JPanel pnSouth4 = new JPanel();
		pnSouth4.setBackground(Color.blue);
		pnBorder4.add(pnSouth4, BorderLayout.SOUTH);

		pnCenter4.setLayout(new BoxLayout(pnCenter4, BoxLayout.Y_AXIS));

		JPanel pnCombo4 = new JPanel();
		pnCombo4.setLayout(new FlowLayout());

		JPanel pnnhap4 = new JPanel();
		pnnhap4.setLayout(new FlowLayout());
		JPanel pnLeft4 = new JPanel();
		pnLeft4.setLayout(new BoxLayout(pnLeft4, BoxLayout.Y_AXIS));

		pnCenter4.add(pnnhap4);

		pnCenter4.setBackground(Color.white);
		pnBorder4.add(pnCenter4, BorderLayout.CENTER);
		getContentPane().add(pnBorder4);

		JPanel pnTable4 = new JPanel();
		dm = new DefaultTableModel();
		tbl = new JTable(dm);
		dm.addColumn("Mã Môn Học");
		dm.addColumn("Mã Sinh Viên");
		dm.addColumn("Điểm");
		dm.addColumn("Tên Môn Học");

		JScrollPane sc4 = new JScrollPane(tbl);
		JScrollPane VT4 = new JScrollPane(sc4, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		VT4.setPreferredSize(new Dimension(1170, 520));
		pnTable4.add(VT4, BorderLayout.CENTER);
		pnCenter4.add(pnTable4);

		Border border4 = BorderFactory.createLineBorder(Color.blue);
		TitledBorder borderTitle4 = BorderFactory.createTitledBorder(border4, "Danh sách sinh viên");
		pnTable4.setBorder(borderTitle4);

		sinhVien = new QuanLySinhVienUI();
		pnCenter.setLayout(cardlayout);
		pnCenter.add(sinhVien, "0");
		pnBorder.add(pnCenter);
		con.add(pnBorder);

		setVisible(true);

	}

	public void addEvent() {

		btn1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				sinhVien = new QuanLySinhVienUI();
				pnCenter.add(sinhVien, "0");
				cardlayout.show(pnCenter, "0");

			}
		});

		btn2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				nhapDiem = new QuanLyDiemUI();
				pnCenter.add(nhapDiem, "1");
				cardlayout.show(pnCenter, "1");

			}
		});
		btn3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				lopHoc = new QuanLyLopHocUI();
				pnCenter.add(lopHoc, "2");
				cardlayout.show(pnCenter, "2");

			}
		});
		btn4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				monHoc = new QuanLyMonHocUI();
				pnCenter.add(monHoc, "3");
				cardlayout.show(pnCenter, "3");

			}
		});
		btn5.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				pnCenter.add(pnCenter4, "4");
				cardlayout.show(pnCenter, "4");

			}
		});
		btn6.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				monChoTungLop = new QuanLyMonHocTungMonUI();
				pnCenter.add(monChoTungLop, "5");
				cardlayout.show(pnCenter, "5");

			}
		});
	}

	public void showWindow() {
		this.setSize(1350, 700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
