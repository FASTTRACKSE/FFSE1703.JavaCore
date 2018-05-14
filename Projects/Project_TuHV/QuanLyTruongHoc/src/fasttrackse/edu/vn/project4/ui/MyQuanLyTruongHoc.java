package fasttrackse.edu.vn.project4.ui;

import fasttrackse.edu.vn.project4.model.*;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
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

import fasttrackse.edu.vn.project4.model.Connect;

public class MyQuanLyTruongHoc extends JFrame {

	// sinh vien
	private JTextField ten = new JTextField(15);
	private JTextField email = new JTextField(15);
	private JTextField sdt = new JTextField(15);
	private JTextField diachi = new JTextField(15);
	private JTextField masv = new JTextField(15);
	private JTextField tuoisv = new JTextField(15);

	JComboBox cbo = new JComboBox();
	JComboBox cbo2 = new JComboBox();
	JComboBox cbo3 = new JComboBox();
	JComboBox cbo4 = new JComboBox();

	// diem
	JComboBox maMH = new JComboBox();
	JComboBox tenMH = new JComboBox();
	JComboBox maSV = new JComboBox();
	private JTextField diem = new JTextField(15);

	// lop
	private JTextField malop = new JTextField(15);
	private JTextField tenlop = new JTextField(15);
	private JTextField namhoc = new JTextField(15);

	// mon
	private JTextField malophoc = new JTextField(15);
	private JTextField mamonhoc = new JTextField(15);
	private JTextField tenmonhoc = new JTextField(15);
	private JTextField soTC = new JTextField(15);
	private JTextField thoiluong = new JTextField(15);

	private ArrayList<LopHoc> arrLH = new ArrayList<LopHoc>();
	private ArrayList<SinhVien> arrSV = new ArrayList<SinhVien>();
	private ArrayList<MonHoc> arrMH = new ArrayList<MonHoc>();

	int stt = 0;

	DefaultTableModel dm_lophoc;
	DefaultTableModel dm_sinhvien;
	DefaultTableModel dm_monhoc;
	DefaultTableModel dm;

	JTable tbl_lophoc;
	JTable tbl_sinhvien;
	JTable tbl_monhoc;
	JTable tbl;
	private JPanel pnCenter = new JPanel();
	private JPanel pnCenter1 = new JPanel();
	private JPanel pnCenter2 = new JPanel();
	private JPanel pnCenter3 = new JPanel();
	private JPanel pnCenter4 = new JPanel();

	private JPanel pnBorder = new JPanel();
	private JPanel pnBorder1 = new JPanel();
	private JPanel pnBorder2 = new JPanel();
	private JPanel pnBorder3 = new JPanel();
	private JPanel pnBorder4 = new JPanel();

	private JButton btnThemsv = new JButton("Thêm");
	private JButton btnSuasv = new JButton("Sửa");
	private JButton btnXoasv = new JButton("Xoá");
	private JButton btnNhapsv = new JButton("Nhập");

	private JButton btnThemlop = new JButton("Thêm");
	private JButton btnSualop = new JButton("Sửa");
	private JButton btnXoalop = new JButton("Xoá");
	private JButton btnNhaplop = new JButton("Nhập");

	private JButton btnThemdiem = new JButton("Thêm");
	private JButton btnSuadiem = new JButton("Sửa");
	private JButton btnXoadiem = new JButton("Xoá");
	private JButton btnNhapdiem = new JButton("Nhập");

	private JButton btnThemmon = new JButton("Thêm");
	private JButton btnSuamon = new JButton("Sửa");
	private JButton btnXoamon = new JButton("Xoá");
	private JButton btnNhapmon = new JButton("Nhập");

	private Button btn1 = new Button("QUẢN LÝ SINH VIÊN");
	private Button btn2 = new Button("QUẢN LÝ ĐIỂM");
	private Button btn3 = new Button("QUẢN LÝ LỚP HỌC");
	private Button btn4 = new Button("QUẢN LÝ MÔN HỌC");
	private Button btn5 = new Button("THỐNG KÊ BÁO CÁO");

	public MyQuanLyTruongHoc(String tieude) {
		this.setTitle(tieude);
		addControls();
		tinh();
		quan();
		huyen();
		addEvent();
	}

	public void addControls() {
		Container con = getContentPane();
		JPanel cardLayout = new JPanel(new CardLayout());

		pnBorder.setLayout(new BorderLayout());
		JLabel lbl = new JLabel("Chương Trình Quản Lý Sinh Viên");
		Font font = new Font("Arial", Font.BOLD, 24);
		lbl.setFont(font);

		JPanel pnNorth = new JPanel();
		pnNorth.setBackground(Color.blue);
		pnNorth.add(lbl);
		pnCenter.add(pnNorth, BorderLayout.NORTH);

		JPanel pnSouth = new JPanel();
		pnSouth.setBackground(Color.blue);
		pnBorder.add(pnSouth, BorderLayout.SOUTH);

		JPanel pnWest = new JPanel();
		pnWest.setLayout(new BoxLayout(pnWest, BoxLayout.Y_AXIS));
		pnWest.add(btn1);
		pnWest.add(btn2);
		pnWest.add(btn3);
		pnWest.add(btn4);
		pnWest.add(btn5);
		pnBorder.add(pnWest, BorderLayout.WEST);

		// quan ly sinh vien

		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));

		JPanel pnbutton = new JPanel();
		pnbutton.setLayout(new FlowLayout());
		pnbutton.add(btnThemsv);
		pnbutton.add(btnSuasv);
		pnbutton.add(btnXoasv);
		pnbutton.add(btnNhapsv);
		pnCenter.add(pnbutton);

		JPanel pnCombo = new JPanel();
		pnCombo.setLayout(new FlowLayout());
		JLabel lblContent1 = new JLabel("Chọn Lớp : ");
		// JComboBox cbo=new JComboBox();
		cbo.addItem("FFSE1701");
		cbo.addItem("FFSE1702");
		cbo.addItem("FFSE1703");
		cbo.addItem("FFSE1704");
		pnCombo.add(lblContent1);
		pnCombo.add(cbo);

		JLabel lblContent2 = new JLabel("Tỉnh/TP : ");
		// JComboBox cbo2=new JComboBox();

		pnCombo.add(lblContent2);
		pnCombo.add(cbo2);

		JLabel lblContent3 = new JLabel("Quận : ");
		// JComboBox cbo3=new JComboBox();

		pnCombo.add(lblContent3);
		pnCombo.add(cbo3);

		JLabel lblContent4 = new JLabel("Phường : ");
		// JComboBox cbo4=new JComboBox();

		pnCombo.add(lblContent4);
		pnCombo.add(cbo4);
		pnCenter.add(pnCombo);

		JPanel pnnhap = new JPanel();
		pnnhap.setLayout(new FlowLayout());
		JPanel pnLeft = new JPanel();
		pnLeft.setLayout(new BoxLayout(pnLeft, BoxLayout.Y_AXIS));
		JLabel lbl1 = new JLabel("Tên :");
		pnLeft.add(lbl1);
		pnLeft.add(ten);

		JLabel lbl5 = new JLabel("Mã Sinh Viên :");
		pnLeft.add(lbl5);
		pnLeft.add(masv);
		pnnhap.add(pnLeft);

		JPanel pnGiua = new JPanel();
		pnGiua.setLayout(new BoxLayout(pnGiua, BoxLayout.Y_AXIS));
		JLabel lbl6 = new JLabel("Day Of Birth :");
		pnGiua.add(lbl6);
		pnGiua.add(tuoisv);

		JLabel lbl4 = new JLabel("Địa Chỉ :");
		pnGiua.add(lbl4);
		pnGiua.add(diachi);
		pnnhap.add(pnGiua);

		JPanel pnRight = new JPanel();
		pnRight.setLayout(new BoxLayout(pnRight, BoxLayout.Y_AXIS));
		JLabel lbl2 = new JLabel("Email :");
		pnRight.add(lbl2);
		pnRight.add(email);

		JLabel lbl3 = new JLabel("SĐT :");
		pnRight.add(lbl3);
		pnRight.add(sdt);
		pnnhap.add(pnRight);

		pnCenter.add(pnnhap);

		pnCenter.setBackground(Color.white);

		JPanel pnTable = new JPanel();
		dm_sinhvien = new DefaultTableModel();

		dm_sinhvien.addColumn("Mã Lớp");
		dm_sinhvien.addColumn("Mã");
		dm_sinhvien.addColumn("Tên");
		dm_sinhvien.addColumn("Tỉnh/TP");
		dm_sinhvien.addColumn("Phường");
		dm_sinhvien.addColumn("Quận");
		dm_sinhvien.addColumn("Địa Chỉ");

		dm_sinhvien.addColumn("Email");
		dm_sinhvien.addColumn("SĐT");
		dm_sinhvien.addColumn(" Ngày Sinh");
		Connection conn = Connect.getConnect("localhost", "project4", "viettu", "12345");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM Quan_ly_sinh_vien");
			while (result.next()) {
				arrSV.add(new SinhVien(result.getString("ma_lop"), result.getString("ma_sinh_vien"),
						result.getString("ten_sinh_vien"), result.getString("tinh_thanh_pho"),
						result.getString("phuong"), result.getString("quan"), result.getString("dia_chi"),
						result.getString("email"), result.getString("dien_thoai"), result.getString("tuoi")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (SinhVien x : arrSV) {
			String[] row = { x.getLop(), x.getMaSV(), x.getTenSV(), x.getTp(), x.getPhuong(), x.getQuan(),
					x.getDiaChi(), x.getEmail(), x.getSdt(), x.getTuoi() };
			dm_sinhvien.addRow(row);
		}

		tbl_sinhvien = new JTable(dm_sinhvien);
		JScrollPane sc = new JScrollPane(tbl_sinhvien);
		JScrollPane VT = new JScrollPane(sc, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		VT.setPreferredSize(new Dimension(1170, 520));
		pnTable.add(VT, BorderLayout.CENTER);

		Border border = BorderFactory.createLineBorder(Color.blue);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Danh sách sinh viên");
		pnTable.setBorder(borderTitle);
		pnCenter.add(pnTable);
		pnBorder.add(pnCenter, BorderLayout.CENTER);
		getContentPane().add(pnBorder);

		// quản lý điểm

		pnBorder1.setLayout(new BorderLayout());
		JLabel lbldiem = new JLabel("Chương Trình Quản Lý Điểm");
		Font fontdiem = new Font("Arial", Font.BOLD, 24);
		lbldiem.setFont(fontdiem);

		JPanel pnNorth1 = new JPanel();
		pnNorth1.setBackground(Color.blue);
		pnNorth1.add(lbldiem);
		pnCenter1.add(pnNorth1, BorderLayout.NORTH);

		JPanel pnSouth1 = new JPanel();
		pnSouth1.setBackground(Color.blue);
		pnBorder1.add(pnSouth1, BorderLayout.SOUTH);

		pnCenter1.setLayout(new BoxLayout(pnCenter1, BoxLayout.Y_AXIS));

		JPanel pnbutton1 = new JPanel();
		pnbutton1.setLayout(new FlowLayout());
		pnbutton1.add(btnThemdiem);
		pnbutton1.add(btnSuadiem);
		pnbutton1.add(btnXoadiem);
		pnbutton1.add(btnNhapdiem);
		pnCenter1.add(pnbutton1);

		JPanel pnCombo1 = new JPanel();
		pnCombo1.setLayout(new FlowLayout());

		JLabel lblContentdiem2 = new JLabel("Mã Môn Học : ");

		pnCombo1.add(lblContentdiem2);
		pnCombo1.add(maMH);

		JLabel lblContentdiem3 = new JLabel("Tên Môn Học : ");

		pnCombo1.add(lblContentdiem3);
		pnCombo1.add(tenMH);

		JLabel lblContentdiem4 = new JLabel("Mã Sinh Viên : ");

		pnCombo1.add(lblContentdiem4);
		pnCombo1.add(maSV);
		pnCenter1.add(pnCombo1);

		JLabel lbl6diem = new JLabel("Điểm :");
		pnCombo1.add(lbl6diem);
		pnCombo1.add(diem);

		pnCenter1.setBackground(Color.white);
		pnBorder1.add(pnCenter1, BorderLayout.CENTER);
		getContentPane().add(pnBorder1);

		JPanel pnTable1 = new JPanel();
		dm_monhoc = new DefaultTableModel();

		dm_monhoc.addColumn("Mã Môn Học");
		dm_monhoc.addColumn("Mã Sinh Viên");
		dm_monhoc.addColumn("Tên Môn Học");
		dm_monhoc.addColumn("Điểm");

		tbl_monhoc = new JTable(dm_monhoc);
		JScrollPane sc1 = new JScrollPane(tbl_monhoc);
		JScrollPane VT1 = new JScrollPane(sc1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		VT1.setPreferredSize(new Dimension(1170, 520));
		pnTable1.add(VT1, BorderLayout.CENTER);
		pnCenter1.add(pnTable1);

		Border border1 = BorderFactory.createLineBorder(Color.blue);
		TitledBorder borderTitle1 = BorderFactory.createTitledBorder(border1, "Danh sách sinh viên");
		pnTable1.setBorder(borderTitle1);

		// quản lý lớp học

		pnBorder2.setLayout(new BorderLayout());
		JLabel lbllop = new JLabel("Chương Trình Quản Lý Lớp Học");
		Font fontlop = new Font("Arial", Font.BOLD, 24);
		lbllop.setFont(fontlop);

		JPanel pnNorth2 = new JPanel();
		pnNorth2.setBackground(Color.blue);
		pnNorth2.add(lbllop);
		pnCenter2.add(pnNorth2, BorderLayout.NORTH);

		JPanel pnSouth2 = new JPanel();
		pnSouth2.setBackground(Color.blue);
		pnBorder2.add(pnSouth2, BorderLayout.SOUTH);

		pnCenter2.setLayout(new BoxLayout(pnCenter2, BoxLayout.Y_AXIS));

		JPanel pnbutton2 = new JPanel();
		pnbutton2.setLayout(new FlowLayout());
		pnbutton2.add(btnThemlop);
		pnbutton2.add(btnSualop);
		pnbutton2.add(btnXoalop);
		pnbutton2.add(btnNhaplop);
		pnCenter2.add(pnbutton2);

		JPanel pnCombo2 = new JPanel();
		pnCombo2.setLayout(new FlowLayout());

		JPanel pnnhap2 = new JPanel();
		pnnhap2.setLayout(new FlowLayout());

		JPanel pnLeft2 = new JPanel();
		pnLeft2.setLayout(new BoxLayout(pnLeft2, BoxLayout.X_AXIS));
		JLabel lbl1lop = new JLabel("Mã Lớp Học :");
		pnLeft2.add(lbl1lop);
		pnLeft2.add(malop);

		JLabel lbl5lop = new JLabel("Tên Lớp Học :");
		pnLeft2.add(lbl5lop);
		pnLeft2.add(tenlop);
		pnnhap2.add(pnLeft2);

		JLabel lbl6lop = new JLabel("Năm Học :");
		pnLeft2.add(lbl6lop);
		pnLeft2.add(namhoc);
		pnnhap2.add(pnLeft2);

		pnCenter2.add(pnnhap2);

		pnCenter2.setBackground(Color.white);
		pnBorder2.add(pnCenter2, BorderLayout.CENTER);
		getContentPane().add(pnBorder2);

		JPanel pnTable2 = new JPanel();
		dm_lophoc = new DefaultTableModel();

		dm_lophoc.addColumn("Mã Lớp Học");
		dm_lophoc.addColumn("Tên Lớp");
		dm_lophoc.addColumn("Năm Học");
		tbl_lophoc = new JTable(dm_lophoc);

		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM Quan_ly_lop_hoc");
			while (result.next()) {
				arrLH.add(
						new LopHoc(result.getString("ma_lop"), result.getString("mo_ta"), result.getString("nam_hoc")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (LopHoc x : arrLH) {
			String[] row = { x.getMalop(), x.getTenlop(), x.getNamhoc() };
			dm_lophoc.addRow(row);
		}

		JScrollPane sc2 = new JScrollPane(tbl_lophoc);
		JScrollPane VT2 = new JScrollPane(sc2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		VT2.setPreferredSize(new Dimension(1170, 520));
		pnTable2.add(VT2, BorderLayout.CENTER);
		pnCenter2.add(pnTable2);

		Border border2 = BorderFactory.createLineBorder(Color.blue);
		TitledBorder borderTitle2 = BorderFactory.createTitledBorder(border2, "Danh sách sinh viên");
		pnTable2.setBorder(borderTitle2);

		// quản lý môn học

		pnBorder3.setLayout(new BorderLayout());
		JLabel lblmon = new JLabel("Chương Trình Quản Lý Môn Học");
		Font fontmon = new Font("Arial", Font.BOLD, 24);
		lblmon.setFont(fontmon);

		JPanel pnNorth3 = new JPanel();
		pnNorth3.setBackground(Color.blue);
		pnNorth3.add(lblmon);
		pnCenter3.add(pnNorth3, BorderLayout.NORTH);

		JPanel pnSouth3 = new JPanel();
		pnSouth3.setBackground(Color.blue);
		pnBorder3.add(pnSouth3, BorderLayout.SOUTH);

		pnCenter3.setLayout(new BoxLayout(pnCenter3, BoxLayout.Y_AXIS));

		JPanel pnbutton3 = new JPanel();
		pnbutton3.setLayout(new FlowLayout());
		pnbutton3.add(btnThemmon);
		pnbutton3.add(btnSuamon);
		pnbutton3.add(btnXoamon);
		pnbutton3.add(btnNhapmon);
		pnCenter3.add(pnbutton3);

		JPanel pnCombo3 = new JPanel();
		pnCombo3.setLayout(new FlowLayout());

		JPanel pnnhap3 = new JPanel();
		pnnhap3.setLayout(new FlowLayout());
		JPanel pnLeft3 = new JPanel();
		pnLeft3.setLayout(new BoxLayout(pnLeft3, BoxLayout.X_AXIS));

		JLabel lbl5mon = new JLabel("Mã Môn Học :");
		pnLeft3.add(lbl5mon);
		pnLeft3.add(mamonhoc);
		pnnhap3.add(pnLeft3);

		JPanel pnnhapp = new JPanel();
		pnnhapp.setLayout(new FlowLayout());
		JPanel pnGiua3 = new JPanel();
		pnGiua3.setLayout(new BoxLayout(pnGiua3, BoxLayout.X_AXIS));
		JLabel lbl6mon = new JLabel("Tên Môn Học :");
		pnGiua3.add(lbl6mon);
		pnGiua3.add(tenmonhoc);

		JLabel lbl4mon = new JLabel("Số Tín Chỉ :");
		pnGiua3.add(lbl4mon);
		pnGiua3.add(soTC);
		pnnhapp.add(pnGiua3);

		JLabel lbl7mon = new JLabel("Thời Lượng Học :");
		pnGiua3.add(lbl7mon);
		pnGiua3.add(thoiluong);
		pnnhapp.add(pnGiua3);

		pnCenter3.add(pnnhap3);
		pnCenter3.add(pnnhapp);
		pnCenter3.setBackground(Color.white);
		pnBorder3.add(pnCenter3, BorderLayout.CENTER);
		getContentPane().add(pnBorder3);

		JPanel pnTable3 = new JPanel();
		dm_monhoc = new DefaultTableModel();

		dm_monhoc.addColumn("Mã Môn Học");
		dm_monhoc.addColumn("Tên Môn Học");
		dm_monhoc.addColumn("Số Tín Chỉ");
		dm_monhoc.addColumn("Thời Lượng Học");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM quan_ly_mon_hoc");
			while (result.next()) {
				arrMH.add(new MonHoc(result.getString("ma_mon_hoc"), result.getString("ten"),
						result.getString("so_tin_chi"), result.getString("thoi_luong_hoc")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (MonHoc x : arrMH) {
			String[] row = { x.getMaMH(), x.getTenMH(), x.getSoTC(), x.getThoiluonghoc() };
			dm_monhoc.addRow(row);
		}

		tbl_monhoc = new JTable(dm_monhoc);
		JScrollPane sc3 = new JScrollPane(tbl_monhoc);
		JScrollPane VT3 = new JScrollPane(sc3, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		VT3.setPreferredSize(new Dimension(1170, 520));
		pnTable3.add(VT3, BorderLayout.CENTER);
		pnCenter3.add(pnTable3);

		Border border3 = BorderFactory.createLineBorder(Color.blue);
		TitledBorder borderTitle3 = BorderFactory.createTitledBorder(border3, "Danh sách sinh viên");
		pnTable3.setBorder(borderTitle3);

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

		cardLayout.add(pnCenter);
		cardLayout.add(pnCenter1);
		cardLayout.add(pnCenter2);
		cardLayout.add(pnCenter3);
		cardLayout.add(pnCenter4);
		pnBorder.add(cardLayout);
		con.add(pnBorder);

		setVisible(true);

	}

	public void tinh() {
		Connection conn = Connect.getConnect("localhost", "project4", "viettu", "12345");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM devvn_tinhthanhpho");
			while (result.next()) {
				cbo2.addItem(new String(result.getString("name")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void quan() {
		Connection conn = Connect.getConnect("localhost", "project4", "viettu", "12345");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM devvn_quanhuyen");
			while (result.next()) {
				cbo3.addItem(new String(result.getString("name")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void huyen() {
		Connection conn = Connect.getConnect("localhost", "project4", "viettu", "12345");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM devvn_xaphuongthitran");
			while (result.next()) {
				cbo4.addItem(new String(result.getString("name")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void addEvent() {

		cbo2.addActionListener(eventChooseTp);
		cbo3.addActionListener(eventChooseQuan);
		// lớp học
		tbl_lophoc.addMouseListener(eventTable_lophoc);
		btnThemlop.addActionListener(Add);
		btnSualop.addActionListener(eventEdit);
		btnXoalop.addActionListener(Del);
		btnNhaplop.addActionListener(Reset_LH);
		// môn học
		tbl_monhoc.addMouseListener(eventTable_monhoc);
		btnThemmon.addActionListener(Add_MH);
		btnXoamon.addActionListener(Del_MH);
		btnSuamon.addActionListener(Edit_MH);
		btnNhapmon.addActionListener(Reset_MH);
		// sinh viên
		tbl_sinhvien.addMouseListener(eventTable_sinhvien);
		btnThemsv.addActionListener(AddSV);
		btnXoasv.addActionListener(DelSV);
		btnSuasv.addActionListener(eventEditSV);
		btnNhapsv.addActionListener(Reset_SV);

		btn2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				pnCenter.setVisible(false);
				pnCenter1.setVisible(true);

			}
		});

		btn1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				pnCenter.setVisible(true);
				pnCenter1.setVisible(false);

			}
		});
		btn3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				pnCenter.setVisible(false);
				pnCenter1.setVisible(false);
				pnCenter2.setVisible(true);

			}
		});
		btn4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				pnCenter.setVisible(false);
				pnCenter1.setVisible(false);
				pnCenter2.setVisible(false);
				pnCenter3.setVisible(true);

			}
		});
		btn5.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				pnCenter.setVisible(false);
				pnCenter1.setVisible(false);
				pnCenter2.setVisible(false);
				pnCenter3.setVisible(false);
				pnCenter4.setVisible(true);

			}
		});
	}

	ActionListener eventChooseTp = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String chonTinh = (String) cbo2.getSelectedItem();
			dm.setRowCount(0);
			cbo3.removeAllItems();
			Connection conn = Connect.getConnect("localhost", "project4", "viettu", "12345");
			System.out.println(chonTinh);
			try {
				Statement statement = conn.createStatement();
				ResultSet result = statement.executeQuery(
						"SELECT devvn_quanhuyen.name FROM devvn_quanhuyen INNER JOIN devvn_tinhthanhpho WHERE devvn_quanhuyen.matp=devvn_tinhthanhpho.matp AND devvn_tinhthanhpho.name ='"
								+ chonTinh + "'");
				while (result.next()) {
					cbo3.addItem(new String(result.getString("devvn_quanhuyen.name")));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	};

	ActionListener eventChooseQuan = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String chonTinh = (String) cbo3.getSelectedItem();
			dm.setRowCount(0);
			cbo4.removeAllItems();
			Connection conn = Connect.getConnect("localhost", "project4", "viettu", "12345");
			System.out.println(chonTinh);
			try {
				Statement statement = conn.createStatement();
				ResultSet result = statement.executeQuery(
						"SELECT devvn_xaphuongthitran.name FROM devvn_xaphuongthitran INNER JOIN devvn_quanhuyen WHERE devvn_xaphuongthitran.maqh=devvn_quanhuyen.maqh AND devvn_quanhuyen.name ='"
								+ chonTinh + "'");
				while (result.next()) {
					cbo4.addItem(new String(result.getString("devvn_xaphuongthitran.name")));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	};

	// mouseclick sinh viên
	MouseAdapter eventTable_sinhvien = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int col = tbl_sinhvien.getSelectedRow();
			String[] row = new String[10];
			row[0] = (String) tbl_sinhvien.getValueAt(col, 0);
			row[1] = (String) tbl_sinhvien.getValueAt(col, 1);
			row[2] = (String) tbl_sinhvien.getValueAt(col, 2);
			row[3] = (String) tbl_sinhvien.getValueAt(col, 3);
			row[4] = (String) tbl_sinhvien.getValueAt(col, 4);
			row[5] = (String) tbl_sinhvien.getValueAt(col, 5);
			row[6] = (String) tbl_sinhvien.getValueAt(col, 6);
			row[7] = (String) tbl_sinhvien.getValueAt(col, 7);
			row[8] = (String) tbl_sinhvien.getValueAt(col, 8);
			row[9] = (String) tbl_sinhvien.getValueAt(col, 9);

			cbo.setSelectedItem(row[0]);

			masv.setText(row[1]);
			ten.setText(row[2]);
			cbo2.setSelectedItem(row[3]);
			cbo3.setSelectedItem(row[4]);
			cbo4.setSelectedItem(row[5]);
			diachi.setText(row[6]);

			email.setText(row[7]);
			sdt.setText(row[8]);
			tuoisv.setText(row[9]);

			for (int i = 0; i < arrSV.size(); i++) {
				if (row[0].equals(arrSV.get(i).getMaSV())) {
					stt = i;
				}
			}
		}
	};

	// thêm sinh viên
	ActionListener AddSV = new ActionListener() {

		public void actionPerformed(ActionEvent arg0) {
			String chonLop = (String) cbo.getSelectedItem();
			String tinh = (String) cbo2.getSelectedItem();
			String quan = (String) cbo3.getSelectedItem();
			String xa = (String) cbo4.getSelectedItem();

			String tensv = ten.getText();
			String emailsv = email.getText();
			String sdtsv = sdt.getText();
			String diachisv = diachi.getText();
			String ma = masv.getText();
			String tuoi = tuoisv.getText();
			try {
				if (tensv.equals("") || emailsv.equals("") || sdtsv.equals("") || diachisv.equals("") || ma.equals("")
						|| tuoi.equals("")) {
					JOptionPane.showMessageDialog(null, "Bạn chưa nhập thông tin cho sinh viên");
				} else {
					arrSV.add(new SinhVien(chonLop, ma, tensv, tinh, quan, xa, diachisv, emailsv, sdtsv, tuoi));
					dm_sinhvien.addRow(
							new String[] { chonLop, ma, tensv, tinh, quan, xa, diachisv, emailsv, sdtsv, tuoi });
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			;

			Connection conn = Connect.getConnect("localhost", "project4", "viettu", "12345");
			try {

				String sql = "INSERT INTO Quan_ly_sinh_vien(  ma_lop, ma_sinh_vien,ten_sinh_vien,tinh_thanh_pho,  phuong, quan,dia_chi,  dien_thoai, email, tuoi ) VALUES ('"
						+ chonLop + "','" + ma + "','" + tensv + "','" + tinh + "','" + quan + "','" + xa + "','"
						+ diachisv + "','" + sdtsv + "', '" + emailsv + "', '" + tuoi + "')";
				Statement statement = (Statement) conn.createStatement();
				int x = statement.executeUpdate(sql);
				if (x > 0) {
					JOptionPane.showMessageDialog(null, "Đã lưu thông tin sinh viên");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			ten.setText("");
			email.setText("");
			sdt.setText("");
			diachi.setText("");
			masv.setText("");
			tuoisv.setText("");

		}
	};

	// xóa sinh viên
	ActionListener DelSV = new ActionListener() {

		public void actionPerformed(ActionEvent arg0) {
			try {

				arrSV.remove(stt);

				Connection conn = Connect.getConnect("localhost", "project4", "viettu", "12345");
				try {
					String sql = "DELETE FROM Quan_ly_sinh_vien WHERE ma_sinh_vien = '" + masv.getText() + "'";
					Statement statement = (Statement) conn.createStatement();
					int x = statement.executeUpdate(sql);
					if (x >= 0) {
						JOptionPane.showMessageDialog(null, "Đã xóa thông tin sinh viên");
					}
				} catch (Exception ex) {
					ex.printStackTrace();

				}
			}

			catch (Exception e) {

			}
			dm_sinhvien.setRowCount(0);
			for (SinhVien x : arrSV) {
				String[] row = { x.getLop(), x.getMaSV(), x.getTenSV(), x.getTp(), x.getPhuong(), x.getQuan(),
						x.getDiaChi(), x.getEmail(), x.getSdt(), x.getTuoi() };
				dm_sinhvien.addRow(row);
			}

		}
	};
	// sửa sinh viên
	ActionListener eventEditSV = new ActionListener() {

		public void actionPerformed(ActionEvent arg0) {

			for (SinhVien x : arrSV) {
				if (masv.getText().equals(x.getMaSV())) {
					x.setDiaChi(diachi.getText());
					x.setTenSV(ten.getText());
					x.setLop((String) cbo.getSelectedItem());
					x.setTp((String) cbo2.getSelectedItem());
					x.setPhuong((String) cbo3.getSelectedItem());
					x.setQuan((String) cbo4.getSelectedItem());
					x.setEmail(email.getText());
					x.setSdt(sdt.getText());
					x.setTuoi(tuoisv.getText());

					break;
				}
			}
			Connection conn = Connect.getConnect("localhost", "project4", "viettu", "12345");
			try {
				String sql = "UPDATE Quan_ly_sinh_vien SET dia_chi ='" + diachi.getText() + "',phuong ='"
						+ (String) cbo3.getSelectedItem() + "',quan ='" + (String) cbo4.getSelectedItem()
						+ "',tinh_thanh_pho ='" + (String) cbo2.getSelectedItem() + "',dien_thoai ='" + sdt.getText()
						+ "',email ='" + email.getText() + "',ma_lop ='" + (String) cbo.getSelectedItem() + "',tuoi ='"
						+ tuoisv.getText() + "',ten_sinh_vien ='" + ten.getText() + "' WHERE ma_sinh_vien = '"
						+ masv.getText() + "'";

				Statement statement = (Statement) conn.createStatement();
				int x = statement.executeUpdate(sql);
				if (x >= 0) {
					JOptionPane.showMessageDialog(null, "Đã sửa thông tin sinh viên");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			dm_sinhvien.setRowCount(0);
			for (SinhVien x : arrSV) {
				String[] row = { x.getLop(), x.getMaSV(), x.getTenSV(), x.getTp(), x.getPhuong(), x.getQuan(),
						x.getDiaChi(), x.getEmail(), x.getSdt(), x.getTuoi() };
				dm_sinhvien.addRow(row);
			}

		}

	};

	// reset sinh viên
	ActionListener Reset_SV = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			ten.setText("");
			email.setText("");
			sdt.setText("");
			diachi.setText("");
			masv.setText("");
			tuoisv.setText("");
		}
	};

	// mouseclick lop hoc
	MouseAdapter eventTable_lophoc = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int col = tbl_lophoc.getSelectedRow();
			String[] row = new String[3];
			row[0] = (String) tbl_lophoc.getValueAt(col, 0);
			row[1] = (String) tbl_lophoc.getValueAt(col, 1);
			row[2] = (String) tbl_lophoc.getValueAt(col, 2);
			malop.setText(row[0]);
			tenlop.setText(row[1]);
			namhoc.setText(row[2]);
			for (int i = 0; i < arrLH.size(); i++) {
				if (row[0].equals(arrLH.get(i).getMalop())) {
					stt = i;
				}
			}
		}
	};

	// them lop hoc

	ActionListener Add = new ActionListener() {

		public void actionPerformed(ActionEvent arg0) {

			String ma = malop.getText();
			String ten = tenlop.getText();
			String nam = namhoc.getText();
			try {
				if (ma.equals("") || ten.equals("") || nam.equals("")) {
					JOptionPane.showMessageDialog(null, "Bạn chưa nhập thông tin cho sinh viên");
				} else {
					arrLH.add(new LopHoc(ma, ten, nam));
					dm_lophoc.addRow(new String[] { ma, ten, nam });
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			;

			Connection conn = Connect.getConnect("localhost", "project4", "viettu", "12345");
			try {

				String sql = "INSERT INTO Quan_ly_lop_hoc( ma_lop, mo_ta, nam_hoc) VALUES ('" + ma + "','" + ten + "','"
						+ nam + "')";
				Statement statement = (Statement) conn.createStatement();
				int x = statement.executeUpdate(sql);
				if (x > 0) {
					JOptionPane.showMessageDialog(null, "Đã lưu thông tin sinh viên");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			malop.setText("");
			tenlop.setText("");
			namhoc.setText("");

		}
	};

	// sua lop hoc

	ActionListener eventEdit = new ActionListener() {

		public void actionPerformed(ActionEvent arg0) {

			for (LopHoc x : arrLH) {
				if (malop.getText().equals(x.getMalop())) {
					x.setTenlop(tenlop.getText());
					x.setNamhoc(namhoc.getText());

					break;
				}
			}
			Connection conn = Connect.getConnect("localhost", "project4", "viettu", "12345");
			try {
				String sql = "UPDATE Quan_ly_lop_hoc SET mo_ta ='" + tenlop.getText() + "',nam_hoc ='"
						+ namhoc.getText() + "' WHERE ma_lop = '" + malop.getText() + "'";
				Statement statement = (Statement) conn.createStatement();
				int x = statement.executeUpdate(sql);
				if (x >= 0) {
					JOptionPane.showMessageDialog(null, "Đã sửa thông tin sinh viên");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			dm_lophoc.setRowCount(0);
			for (LopHoc x : arrLH) {
				String[] row = { x.getMalop(), x.getTenlop(), x.getNamhoc() };
				dm_lophoc.addRow(row);
			}

		}

	};
	// xoa lop học
	ActionListener Del = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			for (LopHoc x : arrLH) {
				if (malop.getText().equals(x.getMalop())) {
					arrLH.remove(x);
					break;
				}
			}
			Connection conn = Connect.getConnect("localhost", "project4", "viettu", "12345");
			try {
				String sql = "DELETE FROM quan_ly_lop_hoc WHERE ma_lop = '" + malop.getText() + "'";
				Statement statement = conn.createStatement();
				int x = statement.executeUpdate(sql);
				if (x >= 0) {
					JOptionPane.showMessageDialog(null, "Đã xóa thông tin sinh viên");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			dm_lophoc.setRowCount(0);
			for (LopHoc x : arrLH) {
				String[] row = { x.getMalop(), x.getTenlop(), x.getNamhoc() };
				dm_lophoc.addRow(row);
			}

		}

	};

	// reset lớp học
	ActionListener Reset_LH = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			malop.setText("");
			tenlop.setText("");
			namhoc.setText("");
		}

	};

	// mouseclick môn học
	MouseAdapter eventTable_monhoc = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int col = tbl_monhoc.getSelectedRow();
			String[] row = new String[4];
			row[0] = (String) tbl_monhoc.getValueAt(col, 0);
			row[1] = (String) tbl_monhoc.getValueAt(col, 1);
			row[2] = (String) tbl_monhoc.getValueAt(col, 2);
			row[3] = (String) tbl_monhoc.getValueAt(col, 3);

			mamonhoc.setText(row[0]);
			tenmonhoc.setText(row[1]);
			soTC.setText(row[2]);
			thoiluong.setText(row[3]);
			for (int i = 0; i < arrMH.size(); i++) {
				if (row[0].equals(arrMH.get(i).getMaMH())) {
					stt = i;
				}
			}
		}
	};

	// thêm môn học
	ActionListener Add_MH = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			String ma_MonHoc = mamonhoc.getText();
			String ten_MonHoc = tenmonhoc.getText();
			String tinchi_MonHoc = soTC.getText();
			String time_MonHoc = thoiluong.getText();

			try {
				if (ma_MonHoc.equals("") || ten_MonHoc.equals("") || tinchi_MonHoc.equals("")
						|| time_MonHoc.equals("")) {
					JOptionPane.showMessageDialog(null, "Bạn chưa nhập thông tin");
				} else {
					arrMH.add(new MonHoc(ma_MonHoc, ten_MonHoc, tinchi_MonHoc, time_MonHoc));
					dm_monhoc.addRow(new String[] { ma_MonHoc, ten_MonHoc, tinchi_MonHoc, time_MonHoc });
					Connection conn = Connect.getConnect("localhost", "project4", "viettu", "12345");
					try {
						String sql = "INSERT INTO quan_ly_mon_hoc( ma_mon_hoc, ten, so_tin_chi, thoi_luong_hoc) VALUES ('"
								+ ma_MonHoc + "','" + ten_MonHoc + "','" + tinchi_MonHoc + "','" + time_MonHoc + "')";
						Statement statement = conn.createStatement();
						int x = statement.executeUpdate(sql);
						if (x > 0) {
							JOptionPane.showMessageDialog(null, "Đã lưu thông tin sinh viên");
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Bạn cần nhập thông tin sinh viên");
			}

			mamonhoc.setText("");
			tenmonhoc.setText("");
			soTC.setText("");
			thoiluong.setText("");
		}
	};

	// xóa môn học
	ActionListener Del_MH = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			for (MonHoc x : arrMH) {
				if (mamonhoc.getText().equals(x.getMaMH())) {
					arrMH.remove(x);
					break;
				}
			}
			Connection conn = Connect.getConnect("localhost", "project4", "viettu", "12345");
			try {
				String sql = "DELETE FROM quan_ly_mon_hoc WHERE ma_mon_hoc = '" + mamonhoc.getText() + "'";
				Statement statement = conn.createStatement();
				int x = statement.executeUpdate(sql);
				if (x >= 0) {
					JOptionPane.showMessageDialog(null, "Đã xóa thông tin sinh viên");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			dm_monhoc.setRowCount(0);
			for (MonHoc x : arrMH) {
				String[] row = { x.getMaMH(), x.getTenMH(), x.getSoTC(), x.getThoiluonghoc() };
				dm_monhoc.addRow(row);
			}
		}

	};

	// sửa môn học
	ActionListener Edit_MH = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			for (MonHoc x : arrMH) {
				if (mamonhoc.getText().equals(x.getMaMH())) {
					x.setTenMH(tenmonhoc.getText());
					x.setSoTC(soTC.getText());
					x.setThoiluonghoc(thoiluong.getText());
					break;
				}
			}
			Connection conn = Connect.getConnect("localhost", "project4", "viettu", "12345");
			try {
				String sql = "UPDATE quan_ly_mon_hoc SET ten ='" + tenmonhoc.getText() + "',so_tin_chi ='"
						+ soTC.getText() + "',thoi_luong_hoc ='" + thoiluong.getText() + "' WHERE ma_mon_hoc = '"
						+ mamonhoc.getText() + "'";
				Statement statement = conn.createStatement();
				int x = statement.executeUpdate(sql);
				if (x >= 0) {
					JOptionPane.showMessageDialog(null, "Đã sửa thông tin sinh viên");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			dm_monhoc.setRowCount(0);
			for (MonHoc x : arrMH) {
				String[] row = { x.getMaMH(), x.getTenMH(), x.getSoTC(), x.getThoiluonghoc() };
				dm_monhoc.addRow(row);
			}
		}
	};

	ActionListener Reset_MH = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			mamonhoc.setText("");
			tenmonhoc.setText("");
			soTC.setText("");
			thoiluong.setText("");
		}
	};

	public void showWindow() {
		this.setSize(1350, 700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
