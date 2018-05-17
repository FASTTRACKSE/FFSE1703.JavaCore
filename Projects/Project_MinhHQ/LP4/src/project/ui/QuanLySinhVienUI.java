package project.ui;

import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

public class QuanLySinhVienUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private Button Lop = new Button("Quản lý Lớp Học");
	private Button SV = new Button("Quản lý Sinh Viên");
	private Button MH = new Button("Quản lý Môn Học");
	private Button LopMH = new Button("Môn Học của từng Lớp");
	private Button Diem = new Button("Nhập Điểm");
	private Button Thongke = new Button("Thống kê");

	CardLayout cardlayout = new CardLayout();
	JPanel ttSV = new JPanel();

	private SinhVienUI sinhVienUI;
	private LopHocUI lopHocUI;
	private MonHocUI monHocUI;
	private MonHocLopUI monHocLopUI;
	private NhapDiemUI nhapDiemUI;

	public QuanLySinhVienUI(String tieude) {
		super(tieude);
		addControls();
		addEvent();
	}

	public void addControls() {
		Container con = getContentPane();

		ttSV.setLayout(cardlayout);

		JPanel Main = new JPanel();
		Main.setLayout(new BorderLayout());
		// Title của chương trình
		JPanel Title = new JPanel();
		JLabel lbl = new JLabel("Chương trình quản lý trường học");
		Font font = new Font("Arial", Font.BOLD, 24);
		lbl.setFont(font);
		Title.add(lbl);
		Main.add(Title, BorderLayout.NORTH);
		// Button menu
		JPanel Luachon = new JPanel();
		Luachon.setLayout(new BoxLayout(Luachon, BoxLayout.Y_AXIS));
		Luachon.add(Lop);
		Luachon.add(SV);
		Luachon.add(MH);
		Luachon.add(LopMH);
		Luachon.add(Diem);
		Luachon.add(Thongke);
		Main.add(Luachon, BorderLayout.WEST);

		lopHocUI = new LopHocUI();
		ttSV.add(lopHocUI, "1");

		Main.add(ttSV);
		con.add(Main);
		setVisible(true);
	}

	public void addEvent() {

		Lop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				lopHocUI = new LopHocUI();
				ttSV.add(lopHocUI, "1");
				cardlayout.show(ttSV, "1");
			}
		});

		SV.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				sinhVienUI = new SinhVienUI();
				ttSV.add(sinhVienUI, "2");
				cardlayout.show(ttSV, "2");
			}
		});
		MH.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				monHocUI = new MonHocUI();
				ttSV.add(monHocUI, "3");
				cardlayout.show(ttSV, "3");
			}
		});

		LopMH.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				monHocLopUI = new MonHocLopUI();
				ttSV.add(monHocLopUI, "4");
				cardlayout.show(ttSV, "4");
			}
		});

		Diem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				nhapDiemUI = new NhapDiemUI();
				ttSV.add(nhapDiemUI, "5");
				cardlayout.show(ttSV, "5");
			}
		});
	}

	public void showWindow() {
		this.setSize(1350, 700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setMinimumSize(new Dimension(1050, 567));
		this.setVisible(true);
	}
}
