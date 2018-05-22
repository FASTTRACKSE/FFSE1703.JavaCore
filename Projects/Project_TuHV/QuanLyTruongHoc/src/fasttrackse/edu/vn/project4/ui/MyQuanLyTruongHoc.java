package fasttrackse.edu.vn.project4.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Container;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MyQuanLyTruongHoc extends JFrame {

	
	CardLayout cardlayout;

	private JPanel pnCenter = new JPanel();


	private JPanel pnBorder = new JPanel();

	
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
	private ThongKeBaoCaoUI thongKe;

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
				thongKe = new ThongKeBaoCaoUI();
				pnCenter.add(thongKe, "4");
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
