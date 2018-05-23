package ffse1702010.edu.vn.ui;

import java.awt.BorderLayout;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
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

import com.mysql.jdbc.Connection;

import ffse1702010.edu.vn.Connect.ConnectData;
import ffse1702010.edu.vn.model.Diem;
import ffse1702010.edu.vn.model.Lop;
import ffse1702010.edu.vn.model.MonHoc;
import ffse1702010.edu.vn.model.MonHocCuaTungLop;
import ffse1702010.edu.vn.model.ThongTinSinhVien;

public class MyLayout extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Container con;
	// JPANNEL CHÍNH
	private JPanel pnBorder;
	// JPANNEL SINH VIÊN
	private JPanel pnFolowSinhVien1;
	private JPanel pnFolowSinhVien2;
	private JPanel pnFolowSinhVien3;
	private JPanel pnFowlowTinhQuanHuyen;
	private JPanel pnCRUDSinhVien;
	private JPanel pnCRUDLop;
	// JPANNEL CHÍNH
	CardLayout card;
	private JPanel pnLayout;
	private JPanel pnQuanLySinhVien;
	private JPanel pnQuanLyMonHoc;
	private JPanel pnQuanLyLopHoc;
	private JPanel pnQuanLyDiem;
	private JPanel pnThongKe;
	private JPanel pnMonHocCuaLop;
	// PN MÔN HỌC
	private JPanel pnFowlowMonHoc1;
	private JPanel pnFowlowMonHoc2;
	private JPanel pnCRUDMonHoc;
	// BUTTON MENU
	private Button btnQuanLySinhVien = new Button("QUẢN LÝ SINH VIÊN");
	private Button btnQuanLyLopHoc = new Button("QUẢN LỚP HỌC");
	private Button btnQuanLyMonHoc = new Button("QUẢN LÝ MÔN HỌC");
	private Button btnQuanLyDiem = new Button("QUẢN LÝ ĐIỂM");
	private Button btnThongKe = new Button("THỐNG KÊ BÁO CÁO");
	private Button btnMonHocTungLop = new Button("MÔN HỌC CỦA TỪNG LỚP");
	// BUTTON CRUD CỦA SINH VIÊN
	private Button themSinhVien = new Button("THÊM");
	private Button suaSinhVien = new Button("SỬA");
	private Button xoaSinhVien = new Button("XÓA");
	private Button refreshSV = new Button("REFRESH");
	// BUTTON CRUD CỦA LỚP
	private Button themLop = new Button("THÊM");
	private Button suaLop = new Button("SỬA");
	private Button xoaLop = new Button("XÓA");
	private Button refreshLop = new Button("REFRESH");
	// BUTTON CRUD CỦA MÔN HỌC
	private Button themMonHoc = new Button("THÊM");
	private Button suaMonHoc = new Button("SỬA");
	private Button xoaMonHoc = new Button("XÓA");
	private Button refreshMonHoc = new Button("REFRESH");
	// BUTTON ĐIỂM
	private Button themDiem = new Button("THÊM");
	private Button suaDiem = new Button("SỬA");
	private Button xoaDiem = new Button("XÓA");
	// BUTTON MÔN HỌC CỦA LỚP NÀO
	private Button themMonHocCuaLop = new Button("THÊM");
	private Button xoaMonHocCuaLop = new Button("XÓA");
	// BUTTON TÌM KIẾM
	private Button btnTimKiem = new Button("TÌM");
	// JTEXTFIELD SINH VIÊN
	private JTextField nhapMaSinhVien = new JTextField(20);
	private JTextField nhapTenSinhVien = new JTextField(20);
	private JTextField nhapNgaySinh = new JTextField(20);
	private JTextField nhapDiaChi = new JTextField(20);
	private JTextField nhapEmail = new JTextField(20);
	private JTextField nhapSDT = new JTextField(20);
	// JTEXTFILE QUẢN LÝ ĐIỂM
	private JTextField nhapMaLop = new JTextField(20);
	private JTextField nhapMoTa = new JTextField(20);
	// JTEXTFILE MÔN HỌC
	private JTextField nhapMaMonHoc = new JTextField(20);
	private JTextField nhapSoTinChi = new JTextField(20);
	private JTextField nhapThoiLuongHoc = new JTextField(20);
	private JTextField nhapTenMonHoc = new JTextField(20);
	// JTEXTFILE ĐIỂM
	private JTextField nhapDiem = new JTextField(20);
	// JTEXTFIELD TÌM KIẾM
	private JTextField timKiemJT = new JTextField(30);
	// JLABEL SINH VIÊN
	private JLabel jlmaSinhVien;
	private JLabel jltenSinhVien;
	private JLabel jlngaySinh;
	private JLabel jldiaChi;
	private JLabel jlemail;
	private JLabel jlSDT;
	private JLabel jlchonLop;
	private JLabel jlChonPhuong;
	private JLabel jlChonQuan;
	private JLabel jlChonTinh;
	// JLABEL QUẢN LÝ LỚP
	private JLabel jlMaLop;
	private JLabel jlMoTa;
	private JLabel jlChonNam;
	// JLABEL QUẢN LÝ MÔN HỌC
	private JLabel jlMaMonHoc;
	private JLabel jlSoTinChi;
	private JLabel jlThoiLuongHoc;
	private JLabel jlTenMonHoc;
	// JLABEL QUẢN LÝ ĐIỂM
	private JLabel jlDiem;
	private JLabel jlMaLopHocDiem1;
	private JLabel jlMaMonHocDiem1;
	private JLabel jlMaSinhVien1;
	private JLabel jlXemDiemCuaLop;

	// JCOMBOBOX PRINT SINH VIÊN
	private JComboBox<String> cboLopSinhVienPrint = new JComboBox<>();
	private JComboBox<String> cboLopPrint = new JComboBox<>();
	// JCOMBOBOX PHƯỜNG QUẬN TỈNH
	private JComboBox<String> cboChonNam = new JComboBox<>();
	private JComboBox<String> cboPhuong = new JComboBox<>();
	private JComboBox<String> cboQuan = new JComboBox<>();
	private JComboBox<String> cboTinh = new JComboBox<>();
	// JCOMBOX DIEM
	private JComboBox<String> maLopHocDiem = new JComboBox<>();
	private JComboBox<String> maMonHocDiem = new JComboBox<>();
	private JComboBox<String> maSinhVienDiem = new JComboBox<>();
	private JComboBox<String> cboXemDiemCuaLop = new JComboBox<>();
	// JCOMBOX THONG KE
	private JComboBox<String> cbochonLop = new JComboBox<>();
	private JComboBox<String> cbochonNamThongKe = new JComboBox<>();
	private JComboBox<String> thongKeSinhVien = new JComboBox<>();
	// JCOMBOX MON HOC CUA LOP
	private JComboBox<String> cboChonLopMonHoc = new JComboBox<>();
	private JComboBox<String> cboChonMaMonHoc = new JComboBox<>();
	// TABLE SINH VIÊN
	private DefaultTableModel dmSinhVien;
	private JTable tblSinhVien;
	int stt = 0;
	JScrollPane scSinhVien;
	// TABLE LỚP
	private DefaultTableModel dmLop;
	private JTable tblLop;
	JScrollPane scLop;
	// TABLE MÔN HỌC
	private DefaultTableModel dmMonHoc;
	private JTable tblMonHoc;
	JScrollPane scMonHoc;
	// TABLE ĐIỂM
	private DefaultTableModel dmDiem;
	private JTable tblDiem;
	JScrollPane scDiem;
	// TABLE THỐNG KÊ
	private DefaultTableModel dmThongKe;
	private JTable tblThongKe;
	JScrollPane scThongKe;
	// TABLE THỐNG KÊ 2
	private DefaultTableModel dmThongKe2;
	private JTable tblThongKe2;
	JScrollPane scThongKe2;
	// TABLE MÔN HỌC CỦA TỪNG LỚP
	private DefaultTableModel dmMonHocCuaTungLop;
	private JTable tblMonHocCuaTungLop;
	JScrollPane scMonHocCuaTungLop;
	// ARRAYLIST
	private ArrayList<ThongTinSinhVien> arrSV = new ArrayList<ThongTinSinhVien>();
	private ArrayList<Lop> arrLop = new ArrayList<Lop>();
	private ArrayList<MonHoc> arrMonHoc = new ArrayList<MonHoc>();
	private ArrayList<Diem> arrDiem = new ArrayList<Diem>();
	private ArrayList<MonHocCuaTungLop> arrMonHocCuaTungLop = new ArrayList<MonHocCuaTungLop>();

	public MyLayout(String title) {
		this.setTitle(title);
		addLayout();
		tinh();
		quan();
		huyen();
		chonLop();
		maMonHoc();
		addEvent();
		chonLopDiem();
		chonNam();
		chonLopSinhVienPrint();
		chonNam1();
		chonLopThongKe();
		chonLopXemDiem();
	}

	public void addLayout() {
		con = getContentPane();

		pnLayout = new JPanel();
		card = new CardLayout();
		pnLayout.setLayout(card);

		pnBorder = new JPanel();
		pnBorder.setLayout(new BorderLayout());
		// CÁC BUTTON CỐ ĐỊNH
		JPanel pnWest = new JPanel();
		pnWest.setLayout(new BoxLayout(pnWest, BoxLayout.Y_AXIS));
		pnWest.add(btnQuanLySinhVien);
		pnWest.add(btnQuanLyLopHoc);
		pnWest.add(btnQuanLyMonHoc);
		pnWest.add(btnMonHocTungLop);
		pnWest.add(btnQuanLyDiem);
		pnWest.add(btnThongKe);
		pnBorder.add(pnWest, BorderLayout.WEST);

		// LAYOUT QUẢN LÝ SINH VIÊN
		pnQuanLySinhVien = new JPanel();
		pnQuanLySinhVien.setLayout(new BorderLayout());
		JPanel pnTitle2 = new JPanel();
		pnQuanLySinhVien.add(pnTitle2);

		JPanel pnNorth = new JPanel();
		JLabel title = new JLabel("CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN");
		title.setOpaque(true);
		Font font = new Font("Arial", Font.BOLD, 24);
		title.setFont(font);
		title.setForeground(Color.BLACK);
		title.setBackground(Color.WHITE);
		JPanel pnXemLop = new JPanel();
		pnXemLop.setLayout(new BoxLayout(pnXemLop, BoxLayout.Y_AXIS));

		JPanel flowSeach = new JPanel();
		flowSeach.setLayout(new FlowLayout());
		flowSeach.setBackground(Color.PINK);
		jlchonLop = new JLabel("XEM LỚP");

		JLabel timKiem = new JLabel("TÌM KIẾM");
		flowSeach.add(jlchonLop);
		flowSeach.add(cboLopSinhVienPrint);
		flowSeach.add(timKiem);
		flowSeach.add(timKiemJT);
		flowSeach.add(btnTimKiem);

		pnXemLop.add(title);
		pnXemLop.add(flowSeach);
		pnNorth.add(pnXemLop);
		pnNorth.setBackground(Color.pink);
		pnQuanLySinhVien.add(pnNorth, BorderLayout.NORTH);

		JPanel pnSouth = new JPanel();
		pnSouth.setLayout(new BoxLayout(pnSouth, BoxLayout.Y_AXIS));

		Border bor3 = BorderFactory.createMatteBorder(1, 1, 5, 5, Color.WHITE);
		TitledBorder titlebor3 = new TitledBorder(bor3, "THÊM THÔNG TIN SINH VIÊN:");
		pnSouth.setBorder(titlebor3);

		JPanel flowLop = new JPanel();
		flowLop.setLayout(new FlowLayout());
		flowLop.setBackground(Color.pink);

		JLabel chonLopPrint = new JLabel("CHỌN LỚP");

		flowLop.add(chonLopPrint);
		flowLop.add(cboLopPrint);
		pnSouth.add(flowLop);

		jlmaSinhVien = new JLabel("MÃ SINH VIÊN");
		jlmaSinhVien.setPreferredSize(new Dimension(100, 50));
		jltenSinhVien = new JLabel("TÊN SINH VIÊN");
		jltenSinhVien.setPreferredSize(new Dimension(100, 50));
		jlngaySinh = new JLabel("NGÀY SINH");
		jlngaySinh.setPreferredSize(new Dimension(100, 50));
		jldiaChi = new JLabel("ĐỊA CHỈ");
		jldiaChi.setPreferredSize(new Dimension(100, 50));
		jlemail = new JLabel("EMAIL");
		jlemail.setPreferredSize(new Dimension(100, 50));
		jlSDT = new JLabel("SỐ ĐIỆN THOẠI");
		jlSDT.setPreferredSize(new Dimension(100, 50));

		jlchonLop = new JLabel("CHỌN LỚP");
		jlChonPhuong = new JLabel("CHỌN PHƯỜNG");
		jlChonPhuong.setPreferredSize(new Dimension(100, 50));

		jlChonQuan = new JLabel("CHỌN QUẬN");
		jlChonQuan.setPreferredSize(new Dimension(100, 50));

		jlChonTinh = new JLabel("CHỌN TỈNH");
		jlChonTinh.setPreferredSize(new Dimension(100, 50));
		cboPhuong.setPreferredSize(new Dimension(225, 20));
		cboQuan.setPreferredSize(new Dimension(225, 20));
		cboTinh.setPreferredSize(new Dimension(225, 20));

		JPanel pnBox = new JPanel();
		pnBox.setLayout(new BoxLayout(pnBox, BoxLayout.Y_AXIS));

		pnFolowSinhVien2 = new JPanel();
		pnFolowSinhVien2.setLayout(new FlowLayout());
		pnFolowSinhVien2.setBackground(Color.PINK);

		pnFolowSinhVien2.add(jlmaSinhVien);
		pnFolowSinhVien2.add(nhapMaSinhVien);
		pnFolowSinhVien2.add(jltenSinhVien);
		pnFolowSinhVien2.add(nhapTenSinhVien);
		pnFolowSinhVien2.add(jlngaySinh);
		pnFolowSinhVien2.add(nhapNgaySinh);

		pnFolowSinhVien1 = new JPanel();
		pnFolowSinhVien1.setLayout(new FlowLayout());
		pnFolowSinhVien1.setBackground(Color.pink);

		pnFolowSinhVien1.add(jldiaChi);
		pnFolowSinhVien1.add(nhapDiaChi);

		pnFolowSinhVien1.add(jlemail);
		pnFolowSinhVien1.add(nhapEmail);

		pnFolowSinhVien1.add(jlSDT);
		pnFolowSinhVien1.add(nhapSDT);

		pnFowlowTinhQuanHuyen = new JPanel();
		pnFowlowTinhQuanHuyen.setLayout(new FlowLayout());
		pnFowlowTinhQuanHuyen.setBackground(Color.PINK);

		pnFowlowTinhQuanHuyen.add(jlChonTinh);
		pnFowlowTinhQuanHuyen.add(cboTinh);

		pnFowlowTinhQuanHuyen.add(jlChonQuan);
		pnFowlowTinhQuanHuyen.add(cboQuan);

		pnFowlowTinhQuanHuyen.add(jlChonPhuong);
		pnFowlowTinhQuanHuyen.add(cboPhuong);

		pnBox.add(pnFolowSinhVien2);
		pnBox.add(pnFolowSinhVien1);
		pnBox.add(pnFowlowTinhQuanHuyen);

		pnSouth.add(pnBox);

		pnCRUDSinhVien = new JPanel();
		pnCRUDSinhVien.setLayout(new FlowLayout());

		pnCRUDSinhVien.add(themSinhVien);
		pnCRUDSinhVien.add(suaSinhVien);
		pnCRUDSinhVien.add(xoaSinhVien);
		pnCRUDSinhVien.add(refreshSV);

		pnSouth.add(pnCRUDSinhVien);

		pnSouth.setBackground(Color.PINK);
		pnQuanLySinhVien.add(pnSouth, BorderLayout.SOUTH);

		JPanel pnCenter = new JPanel();
		pnCenter.setBackground(Color.WHITE);
		pnCenter.setLayout(new BorderLayout());

		Border bor2 = BorderFactory.createEtchedBorder(Color.BLUE, Color.RED);
		TitledBorder titlebor2 = new TitledBorder(bor2, "THÔNG TIN SINH VIÊN:");
		pnCenter.setBorder(titlebor2);

		dmSinhVien = new DefaultTableModel();
		tblSinhVien = new JTable(dmSinhVien);
		dmSinhVien.addColumn("Mã ");
		dmSinhVien.addColumn("Tên");
		dmSinhVien.addColumn("Ngày sinh");
		dmSinhVien.addColumn("Địa chỉ");
		dmSinhVien.addColumn("Email");
		dmSinhVien.addColumn("SĐT");
		dmSinhVien.addColumn("Lớp");
		dmSinhVien.addColumn("Xã");
		dmSinhVien.addColumn("Huyện");
		dmSinhVien.addColumn("Tỉnh");
		scSinhVien = new JScrollPane(tblSinhVien);

		pnCenter.add(scSinhVien);
		pnQuanLySinhVien.add(pnCenter);
		// LAYOUT QUẢN LÝ MÔN HỌC
		pnQuanLyMonHoc = new JPanel();
		pnQuanLyMonHoc.setLayout(new BorderLayout());

		JPanel pnCenter1 = new JPanel();
		pnCenter1.setBackground(Color.WHITE);
		pnCenter1.setLayout(new BorderLayout());

		Border bor4 = BorderFactory.createEtchedBorder(Color.BLUE, Color.RED);
		TitledBorder titlebor4 = new TitledBorder(bor4, "THÔNG TIN MÔN HỌC:");
		pnCenter1.setBorder(titlebor4);

		dmLop = new DefaultTableModel();
		tblLop = new JTable(dmLop);
		dmLop.addColumn("MÃ MÔN HỌC");
		dmLop.addColumn("TÊN MÔN HỌC");
		dmLop.addColumn("SỐ TÍN CHỈ");
		dmLop.addColumn("THỜI GIAN HỌC");
		scLop = new JScrollPane(tblLop);

		JPanel pnSouth1 = new JPanel();
		pnSouth1.setLayout(new BoxLayout(pnSouth1, BoxLayout.Y_AXIS));

		Border bor5 = BorderFactory.createMatteBorder(1, 1, 5, 5, Color.pink);
		TitledBorder titlebor5 = new TitledBorder(bor5, "THÊM THÔNG TIN MÔN HỌC:");
		pnSouth1.setBorder(titlebor5);

		JPanel pnMSTT = new JPanel();
		pnMSTT.setLayout(new BoxLayout(pnMSTT, BoxLayout.Y_AXIS));

		pnFowlowMonHoc1 = new JPanel();
		pnFowlowMonHoc1.setLayout(new FlowLayout());
		pnFowlowMonHoc1.setBackground(Color.PINK);

		jlMaMonHoc = new JLabel("MÃ MÔN HỌC");
		jlMaMonHoc.setPreferredSize(new Dimension(100, 50));
		jlTenMonHoc = new JLabel("TÊN MÔN HỌC");
		jlTenMonHoc.setPreferredSize(new Dimension(100, 50));
		pnFowlowMonHoc1.add(jlMaMonHoc);
		pnFowlowMonHoc1.add(nhapMaMonHoc);
		pnFowlowMonHoc1.add(jlTenMonHoc);
		pnFowlowMonHoc1.add(nhapTenMonHoc);

		pnFowlowMonHoc2 = new JPanel();
		pnFowlowMonHoc2.setLayout(new FlowLayout());
		pnFowlowMonHoc2.setBackground(Color.PINK);

		jlSoTinChi = new JLabel("SỐ TÍN CHỈ");
		jlSoTinChi.setPreferredSize(new Dimension(100, 50));
		jlThoiLuongHoc = new JLabel("THỜI GIAN HỌC");
		jlThoiLuongHoc.setPreferredSize(new Dimension(100, 50));
		pnFowlowMonHoc2.add(jlSoTinChi);
		pnFowlowMonHoc2.add(nhapSoTinChi);
		pnFowlowMonHoc2.add(jlThoiLuongHoc);
		pnFowlowMonHoc2.add(nhapThoiLuongHoc);

		pnCRUDMonHoc = new JPanel();
		pnCRUDMonHoc.setLayout(new FlowLayout());
		pnCRUDMonHoc.setBackground(Color.white);
		pnCRUDMonHoc.add(themMonHoc);
		pnCRUDMonHoc.add(suaMonHoc);
		pnCRUDMonHoc.add(xoaMonHoc);
		pnCRUDMonHoc.add(refreshMonHoc);

		pnMSTT.add(pnFowlowMonHoc1);
		pnMSTT.add(pnFowlowMonHoc2);
		pnSouth1.add(pnMSTT);
		pnSouth1.add(pnCRUDMonHoc);

		pnQuanLyMonHoc.add(pnSouth1, BorderLayout.SOUTH);
		pnCenter1.add(scLop);
		pnQuanLyMonHoc.add(pnCenter1);

		// Layout Quản Lý lop
		pnQuanLyLopHoc = new JPanel();
		pnQuanLyLopHoc.setLayout(new BorderLayout());
		JPanel pnCenter2 = new JPanel();
		pnCenter2.setBackground(Color.WHITE);
		pnCenter2.setLayout(new BorderLayout());

		Border bor6 = BorderFactory.createEtchedBorder(Color.BLUE, Color.RED);
		TitledBorder titlebor6 = new TitledBorder(bor6, "THÔNG TIN LỚP HỌC:");
		pnCenter2.setBorder(titlebor6);

		dmMonHoc = new DefaultTableModel();
		tblMonHoc = new JTable(dmMonHoc);
		dmMonHoc.addColumn("LỚP ");
		dmMonHoc.addColumn("MÔ TẢ");
		dmMonHoc.addColumn("NĂM HỌC");
		scMonHoc = new JScrollPane(tblMonHoc);

		JPanel pnSouth2 = new JPanel();
		pnSouth2.setLayout(new BoxLayout(pnSouth2, BoxLayout.Y_AXIS));

		Border bor7 = BorderFactory.createMatteBorder(1, 1, 5, 5, Color.PINK);
		TitledBorder titlebor7 = new TitledBorder(bor7, "THÊM THÔNG TIN LỚP HỌC:");
		pnSouth2.setBorder(titlebor7);
		jlMaLop = new JLabel("LỚP HỌC");
		jlMaLop.setPreferredSize(new Dimension(70, 100));
		jlMoTa = new JLabel("MÔ TẢ");
		jlMoTa.setPreferredSize(new Dimension(70, 100));

		JPanel pnLop1 = new JPanel();
		pnLop1.setBackground(Color.pink);
		jlChonNam = new JLabel("CHỌN NĂM");
		pnLop1.add(jlChonNam);
		cboChonNam.addItem("TẤT CẢ");
		cboChonNam.addItem("2018");
		cboChonNam.addItem("2017");
		cboChonNam.addItem("2016");
		cboChonNam.addItem("2015");
		cboChonNam.addItem("2014");
		pnLop1.add(cboChonNam);
		pnSouth2.add(pnLop1);

		pnFolowSinhVien3 = new JPanel();
		pnFolowSinhVien3.setLayout(new FlowLayout());
		pnFolowSinhVien3.setBackground(Color.PINK);

		pnFolowSinhVien3.add(jlMaLop);
		pnFolowSinhVien3.add(nhapMaLop);
		pnFolowSinhVien3.add(jlMoTa);
		pnFolowSinhVien3.add(nhapMoTa);

		pnCRUDLop = new JPanel();
		pnCRUDLop.setLayout(new FlowLayout());
		pnCRUDLop.setBackground(Color.WHITE);
		pnCRUDLop.add(themLop);
		pnCRUDLop.add(suaLop);
		pnCRUDLop.add(xoaLop);
		pnCRUDLop.add(refreshLop);

		pnSouth2.add(pnFolowSinhVien3);
		pnSouth2.add(pnCRUDLop);
		pnCenter2.add(scMonHoc);
		pnQuanLyLopHoc.add(pnCenter2);
		pnQuanLyLopHoc.add(pnSouth2, BorderLayout.SOUTH);

		// LAYOUT QUẢN LÝ ĐIỂM
		pnQuanLyDiem = new JPanel();
		pnQuanLyDiem.setLayout(new BorderLayout());

		JPanel pnCenter4 = new JPanel();
		pnCenter4.setBackground(Color.WHITE);
		pnCenter4.setLayout(new BorderLayout());

		Border bor8 = BorderFactory.createEtchedBorder(Color.BLUE, Color.RED);
		TitledBorder titlebor8 = new TitledBorder(bor8, "ĐIỂM SINH VIÊN");
		pnCenter4.setBorder(titlebor8);

		dmDiem = new DefaultTableModel();
		tblDiem = new JTable(dmDiem);
		dmDiem.addColumn("LỚP");
		dmDiem.addColumn("MÃ SINH VIÊN");
		dmDiem.addColumn("MÃ MÔN HỌC");
		dmDiem.addColumn("ĐIỂM");
		scDiem = new JScrollPane(tblDiem);

		JPanel pnSouth4 = new JPanel();
		pnSouth4.setLayout(new BoxLayout(pnSouth4, BoxLayout.Y_AXIS));

		Border bor9 = BorderFactory.createMatteBorder(1, 1, 5, 5, Color.pink);
		TitledBorder titlebor9 = new TitledBorder(bor9, "THÊM ĐIỂM SINH VIÊN");
		pnSouth4.setBorder(titlebor9);

		JPanel boxlayoutY = new JPanel();
		boxlayoutY.setLayout(new BoxLayout(boxlayoutY, BoxLayout.Y_AXIS));
		JPanel pnfolowXemDiem = new JPanel();
		pnfolowXemDiem.setLayout(new FlowLayout());
		pnfolowXemDiem.setBackground(Color.WHITE);
		jlXemDiemCuaLop = new JLabel("XEM ĐIỂM CỦA LỚP:");

		pnfolowXemDiem.add(jlXemDiemCuaLop);
		pnfolowXemDiem.add(cboXemDiemCuaLop);

		JPanel pnfolow = new JPanel();
		pnfolow.setLayout(new FlowLayout());
		pnfolow.setBackground(Color.PINK);
		jlDiem = new JLabel("NHẬP ĐIỂM");
		jlMaLopHocDiem1 = new JLabel("CHỌN LỚP");
		jlMaMonHocDiem1 = new JLabel("CHỌN MÔN HỌC");
		jlMaSinhVien1 = new JLabel("CHỌN MÃ SINH VIÊN");
		pnfolow.add(jlMaLopHocDiem1);
		pnfolow.add(maLopHocDiem);
		pnfolow.add(jlMaMonHocDiem1);
		pnfolow.add(maMonHocDiem);
		pnfolow.add(jlMaSinhVien1);
		pnfolow.add(maSinhVienDiem);
		pnfolow.add(jlDiem);
		pnfolow.add(nhapDiem);

		JPanel pnfolowCRUD = new JPanel();
		pnfolowCRUD.setLayout(new FlowLayout());
		pnfolowCRUD.setBackground(Color.white);
		pnfolowCRUD.add(themDiem);
		pnfolowCRUD.add(suaDiem);
		pnfolowCRUD.add(xoaDiem);

		boxlayoutY.add(pnfolowXemDiem);
		boxlayoutY.add(pnfolow);
		boxlayoutY.add(pnfolowCRUD);

		pnSouth4.add(boxlayoutY);

		pnQuanLyDiem.add(pnSouth4, BorderLayout.SOUTH);
		pnCenter4.add(scDiem);
		pnQuanLyDiem.add(pnCenter4);

		// LayoutThongKe
		pnThongKe = new JPanel();
		pnThongKe.setLayout(new BoxLayout(pnThongKe, BoxLayout.Y_AXIS));
		JPanel pnFolowThongKe = new JPanel();
		pnFolowThongKe.setLayout(new FlowLayout());
		pnFolowThongKe.setBackground(Color.WHITE);
		Border bor17 = BorderFactory.createMatteBorder(1, 1, 5, 5, Color.PINK);
		TitledBorder titlebor17 = new TitledBorder(bor17, "CHỌN NĂM CẦN XEM");
		pnFolowThongKe.setBorder(titlebor17);
		thongKeSinhVien = new JComboBox<String>();
		JLabel chonNamThongKe1 = new JLabel("CHỌN NĂM");
		pnFolowThongKe.add(chonNamThongKe1);
		pnFolowThongKe.add(thongKeSinhVien);

		pnThongKe.add(pnFolowThongKe);

		JPanel pnNorthThongKe = new JPanel();
		pnNorthThongKe.setLayout(new BorderLayout());

		Border bor15 = BorderFactory.createEtchedBorder(Color.BLUE, Color.RED);
		TitledBorder titlebor15 = new TitledBorder(bor15, "THỐNG KÊ BÁO CÁO SỐ LƯỢNG SINH VIÊN");
		pnNorthThongKe.setBorder(titlebor15);
		dmThongKe2 = new DefaultTableModel();
		tblThongKe2 = new JTable(dmThongKe2);
		dmThongKe2.addColumn("MÃ LỚP");
		dmThongKe2.addColumn("MÔ TẢ");
		dmThongKe2.addColumn("SỐ LƯỢNG SINH VIÊN");

		scThongKe2 = new JScrollPane(tblThongKe2);

		pnNorthThongKe.add(scThongKe2);
		pnThongKe.add(pnNorthThongKe, BorderLayout.NORTH);

		JPanel pnCenter5 = new JPanel();
		pnCenter5.setBackground(Color.WHITE);
		pnCenter5.setLayout(new BorderLayout());

		Border bor10 = BorderFactory.createEtchedBorder(Color.BLUE, Color.RED);
		TitledBorder titlebor10 = new TitledBorder(bor10, "THỐNG KÊ BÁO CÁO ĐIỂM SINH VIÊN");
		pnCenter5.setBorder(titlebor10);

		dmThongKe = new DefaultTableModel();
		tblThongKe = new JTable(dmThongKe);

		dmThongKe.addColumn("Mã sinh viên");
		dmThongKe.addColumn("Tên sinh viên");
		try {
			Connection conn = ConnectData.getConnect("localhost", "QuanLySinhVien", "QuanLySinhVien", "QuanLySinhVien");
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM MonHoc");
			while (result.next()) {
				dmThongKe.addColumn(new String(result.getString("MaMonHoc")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dmThongKe.addColumn("AVG");
		dmThongKe.addColumn("XẾP LOẠI");
		inThongKe();

		scThongKe = new JScrollPane(tblThongKe);

		JPanel pnSouth5 = new JPanel();
		pnSouth5.setLayout(new BoxLayout(pnSouth5, BoxLayout.Y_AXIS));

		Border bor11 = BorderFactory.createMatteBorder(1, 1, 5, 5, Color.pink);
		TitledBorder titlebor11 = new TitledBorder(bor11, "CHỌN LỚP VÀ CHON NĂM CẦN XEM ĐIỂM");
		pnSouth5.setBorder(titlebor11);

		JPanel pnfolowThongKe = new JPanel();
		pnfolowThongKe.setLayout(new FlowLayout());
		pnfolowThongKe.setBackground(Color.WHITE);
		JLabel chonLopThongKe = new JLabel("CHỌN LỚP");
		JLabel chonNamThongKe = new JLabel("CHỌN NĂM");
		pnfolowThongKe.add(chonNamThongKe);
		pnfolowThongKe.add(cbochonNamThongKe);
		pnfolowThongKe.add(chonLopThongKe);
		pnfolowThongKe.add(cbochonLop);

		pnSouth5.add(pnfolowThongKe);

		pnThongKe.add(pnSouth5, BorderLayout.SOUTH);
		pnCenter5.add(scThongKe);

		pnThongKe.add(pnCenter5);
		// LAYOUT QUẢN LÝ MÔN HỌC
		pnMonHocCuaLop = new JPanel();
		pnMonHocCuaLop.setLayout(new BorderLayout());
		JPanel pnCenter6 = new JPanel();
		pnCenter6.setBackground(Color.WHITE);
		pnCenter6.setLayout(new BorderLayout());

		Border bor12 = BorderFactory.createEtchedBorder(Color.BLUE, Color.RED);
		TitledBorder titlebor12 = new TitledBorder(bor12, "MÔN HỌC CỦA TỪNG LỚP");
		pnCenter6.setBorder(titlebor12);

		dmMonHocCuaTungLop = new DefaultTableModel();
		tblMonHocCuaTungLop = new JTable(dmMonHocCuaTungLop);
		dmMonHocCuaTungLop.addColumn("LỚP");
		dmMonHocCuaTungLop.addColumn("MÃ MÔN HỌC");
		dmMonHocCuaTungLop.addColumn("TÊN MÔN HỌC");
		scMonHocCuaTungLop = new JScrollPane(tblMonHocCuaTungLop);

		JPanel pnSouth6 = new JPanel();
		pnSouth6.setLayout(new BoxLayout(pnSouth6, BoxLayout.Y_AXIS));

		Border bor13 = BorderFactory.createMatteBorder(1, 1, 5, 5, Color.pink);
		TitledBorder titlebor13 = new TitledBorder(bor13, "CHỌN MÔN HỌC CỦA LỚP");
		pnSouth6.setBorder(titlebor13);

		JPanel Y_AXIS = new JPanel();
		Y_AXIS.setLayout(new BoxLayout(Y_AXIS, BoxLayout.Y_AXIS));

		JPanel pnfolowMonHocCuaTungLop = new JPanel();
		pnfolowMonHocCuaTungLop.setLayout(new FlowLayout());
		pnfolowMonHocCuaTungLop.setBackground(Color.PINK);
		JLabel lop = new JLabel("CHỌN LỚP");
		JLabel chonMaMonHoc = new JLabel("CHỌN MÃ MÔN HỌC");

		pnfolowMonHocCuaTungLop.add(lop);
		pnfolowMonHocCuaTungLop.add(cboChonLopMonHoc);
		pnfolowMonHocCuaTungLop.add(chonMaMonHoc);
		pnfolowMonHocCuaTungLop.add(cboChonMaMonHoc);
		pnfolowMonHocCuaTungLop.add(themMonHocCuaLop);
		pnfolowMonHocCuaTungLop.add(xoaMonHocCuaLop);

		Y_AXIS.add(pnfolowMonHocCuaTungLop);
		pnSouth6.add(Y_AXIS);

		pnMonHocCuaLop.add(pnSouth6, BorderLayout.SOUTH);
		pnCenter6.add(scMonHocCuaTungLop);
		pnMonHocCuaLop.add(pnCenter6);

		// ADD CAR LAYOUT
		pnLayout.add(pnQuanLySinhVien, "1");
		pnLayout.add(pnQuanLyDiem, "2");
		pnLayout.add(pnQuanLyMonHoc, "3");
		pnLayout.add(pnQuanLyLopHoc, "4");
		pnLayout.add(pnThongKe, "5");
		pnLayout.add(pnMonHocCuaLop, "6");

		pnBorder.add(pnLayout);

		// ADD BUTTON CỐ ĐỊNH
		getContentPane().add(pnBorder);
		con.add(pnBorder);

		// CONNECT SINH VIÊN
		Connection conn = ConnectData.getConnect("localhost", "QuanLySinhVien", "QuanLySinhVien", "QuanLySinhVien");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM SinhVien");
			while (result.next()) {
				arrSV.add(new ThongTinSinhVien(result.getString("MaSV"), result.getString("TenSinhVien"),
						result.getString("NgaySinh"), result.getString("DiaChi"), result.getString("Email"),
						result.getString("SDT"), result.getString("Lop"), result.getString("Phuong"),
						result.getString("Quan"), result.getString("Tinh")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (ThongTinSinhVien x : arrSV) {
			String[] row = { x.getMaSV(), x.getTenSV(), x.getNgaySinh(), x.getDiaChi(), x.getEmail(), x.getsDT(),
					x.getLop(), x.getPhuong(), x.getQuan(), x.getTinh() };
			dmSinhVien.addRow(row);
		}
		// CONNECT LỚP
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM Lop");
			while (result.next()) {
				arrLop.add(new Lop(result.getString("MaLop"), result.getString("MoTa"), result.getString("Nam")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (Lop x : arrLop) {
			String[] row = { x.getMaLop(), x.getMoTa(), x.getNam() };
			dmMonHoc.addRow(row);
		}
		// CONNECT MÔN HỌC
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM MonHoc");
			while (result.next()) {
				arrMonHoc.add(new MonHoc(result.getString("MaMonHoc"), result.getInt("SoTinChi"),
						result.getString("TenMonHoc"), result.getString("ThoiLuongHoc")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (MonHoc x : arrMonHoc) {
			String tinChi = String.valueOf(x.getTinChi());
			String[] row = { x.getMaMonHoc(), x.getTenMonHoc(), tinChi, x.getThoiGian() };
			dmLop.addRow(row);
		}
		// CONNECT ĐIỂM
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM Diem");
			while (result.next()) {
				arrDiem.add(new Diem(result.getString("MaLop"), result.getString("MaSV"), result.getString("MaMonHoc"),
						result.getString("Diem")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (Diem x : arrDiem) {
			String[] row = { x.getMaLop(), x.getMaSinhVien(), x.getMaMonHoc(), x.getDiem() };
			dmDiem.addRow(row);
		}
	}

	// SELECT TỈNH
	public void tinh() {
		Connection conn = ConnectData.getConnect("localhost", "QuanLySinhVien", "QuanLySinhVien", "QuanLySinhVien");

		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("select * from devvn_tinhthanhpho");
			while (result.next()) {
				cboTinh.addItem(result.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// SELECT CHỌN LỚP THỐNG KÊ
	public void chonLopThongKe() {
		String chonNamDuoi = (String) cbochonNamThongKe.getSelectedItem();
		Connection conn = ConnectData.getConnect("localhost", "QuanLySinhVien", "QuanLySinhVien", "QuanLySinhVien");

		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("select * from Lop WHERE Nam='" + chonNamDuoi + "'");
			while (result.next()) {
				cbochonLop.addItem(result.getString("MaLop"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// SELECT CHỌN LỚP XEM ĐIỂM
	public void chonLopXemDiem() {
		Connection conn = ConnectData.getConnect("localhost", "QuanLySinhVien", "QuanLySinhVien", "QuanLySinhVien");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("select * from Lop");
			while (result.next()) {
				cboXemDiemCuaLop.addItem(result.getString("MaLop"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// SELECT LỚP THỐNG KÊ
	public void thongKePrint() {
		String chonNam = (String) thongKeSinhVien.getSelectedItem();
		Connection conn = ConnectData.getConnect("localhost", "QuanLySinhVien", "QuanLySinhVien", "QuanLySinhVien");

		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(
					"SELECT * ,(SELECT Count(*) FROM SinhVien WHERE SinhVien.Lop=MaLop)  AS TongSinhVien FROM Lop WHERE Nam='"
							+ chonNam + "'");

			while (result.next()) {

				String[] row = { result.getString("MaLop"), result.getString("MoTa"),
						result.getString("TongSinhVien") };

				dmThongKe2.addRow(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// SELECT LỚP CHO MÔN HỌC
	public void chonLop() {

		Connection conn = ConnectData.getConnect("localhost", "QuanLySinhVien", "QuanLySinhVien", "QuanLySinhVien");

		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("select * from Lop");
			while (result.next()) {
				cboChonLopMonHoc.addItem(result.getString("MaLop"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// SELECT NĂM THỐNG KÊ 1
	public void chonNam() {
		Connection conn = ConnectData.getConnect("localhost", "QuanLySinhVien", "QuanLySinhVien", "QuanLySinhVien");

		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT DISTINCT Nam FROM Lop");
			while (result.next()) {
				thongKeSinhVien.addItem(result.getString("Nam"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// SELECY CHỌN NĂM THỐNG KÊ
	public void chonNam1() {
		Connection conn = ConnectData.getConnect("localhost", "QuanLySinhVien", "QuanLySinhVien", "QuanLySinhVien");

		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT DISTINCT Nam FROM Lop");
			while (result.next()) {
				cbochonNamThongKe.addItem(result.getString("Nam"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// SELECT LỚP CỦA ĐIỂM
	public void chonLopDiem() {
		Connection conn = ConnectData.getConnect("localhost", "QuanLySinhVien", "QuanLySinhVien", "QuanLySinhVien");

		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("select * from Lop");
			while (result.next()) {
				maLopHocDiem.addItem(result.getString("MaLop"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// SELECT LỚP CỦA SINH VIÊN PRINT
	public void chonLopSinhVienPrint() {

		Connection conn = ConnectData.getConnect("localhost", "QuanLySinhVien", "QuanLySinhVien", "QuanLySinhVien");
		cboLopSinhVienPrint.addItem("TẤT CẢ");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("select * from Lop");
			while (result.next()) {
				cboLopPrint.addItem(result.getString("MaLop"));
				cboLopSinhVienPrint.addItem(result.getString("MaLop"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// SELECT MÃ SINH VIÊN
	public void chonMaSinhVien() {

		Connection conn = ConnectData.getConnect("localhost", "QuanLySinhVien", "QuanLySinhVien", "QuanLySinhVien");
		String chonLopHocDiem = (String) maLopHocDiem.getSelectedItem();

		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT MaSV FROM SinhVien WHERE Lop='" + chonLopHocDiem + "'");
			while (result.next()) {
				maSinhVienDiem.addItem(result.getString("MaSV"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// SELECT MÃ MÔN HỌC
	public void maMonHoc() {
		Connection conn = ConnectData.getConnect("localhost", "QuanLySinhVien", "QuanLySinhVien", "QuanLySinhVien");

		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("select * from MonHoc");
			while (result.next()) {
				cboChonMaMonHoc.addItem(result.getString("MaMonHoc"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// RESET DIEM
	public void resetDiem() {
		arrDiem.clear();
		try {
			Connection conn = ConnectData.getConnect("localhost", "QuanLySinhVien", "QuanLySinhVien", "QuanLySinhVien");

			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM Diem");
			while (result.next()) {
				arrDiem.add(new Diem(result.getString("MaLop"), result.getString("MaSV"), result.getString("MaMonHoc"),
						result.getString("Diem")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dmDiem.setRowCount(0);
		for (Diem x : arrDiem) {
			String[] row = { x.getMaLop(), x.getMaSinhVien(), x.getMaMonHoc(), x.getDiem() };
			dmDiem.addRow(row);

		}
	}

	// SELECT QUẬN
	public void quan() {
		Connection conn = ConnectData.getConnect("localhost", "QuanLySinhVien", "QuanLySinhVien", "QuanLySinhVien");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM devvn_quanhuyen");
			while (result.next()) {
				cboQuan.addItem(new String(result.getString("name")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// SELECT HUYỆN
	public void huyen() {
		Connection conn = ConnectData.getConnect("localhost", "QuanLySinhVien", "QuanLySinhVien", "QuanLySinhVien");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM devvn_xaphuongthitran");
			while (result.next()) {
				cboPhuong.addItem(new String(result.getString("name")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// CHỌN LỚP CHO SINH VIÊN
	public void setLop() {
		String chonLop = (String) cboLopSinhVienPrint.getSelectedItem();
		dmSinhVien.setRowCount(0);
		if (chonLop == "TẤT CẢ") {
			Connection conn = ConnectData.getConnect("localhost", "QuanLySinhVien", "QuanLySinhVien", "QuanLySinhVien");
			try {
				Statement statement = conn.createStatement();
				ResultSet result = statement.executeQuery("SELECT * FROM SinhVien");
				arrSV.clear();
				while (result.next()) {

					arrSV.add(new ThongTinSinhVien(result.getString("MaSV"), result.getString("TenSinhVien"),
							result.getString("NgaySinh"), result.getString("DiaChi"), result.getString("Email"),
							result.getString("SDT"), result.getString("Lop"), result.getString("Phuong"),
							result.getString("Quan"), result.getString("Tinh")));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			for (ThongTinSinhVien x : arrSV) {

				String[] row = { x.getMaSV(), x.getTenSV(), x.getNgaySinh(), x.getDiaChi(), x.getEmail(), x.getsDT(),
						x.getLop(), x.getPhuong(), x.getQuan(), x.getTinh() };
				dmSinhVien.addRow(row);
			}

		} else {
			Connection conn = ConnectData.getConnect("localhost", "QuanLySinhVien", "QuanLySinhVien", "QuanLySinhVien");
			try {

				Statement statement = conn.createStatement();
				ResultSet result = statement.executeQuery("SELECT * FROM SinhVien WHERE Lop='" + chonLop + "'");
				arrSV.clear();

				while (result.next()) {
					arrSV.add(new ThongTinSinhVien(result.getString("MaSV"), result.getString("TenSinhVien"),
							result.getString("NgaySinh"), result.getString("DiaChi"), result.getString("Email"),
							result.getString("SDT"), result.getString("Lop"), result.getString("Phuong"),
							result.getString("Quan"), result.getString("Tinh")));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			dmSinhVien.setRowCount(0);
			for (ThongTinSinhVien x : arrSV) {
				String[] row = { x.getMaSV(), x.getTenSV(), x.getNgaySinh(), x.getDiaChi(), x.getEmail(), x.getsDT(),
						x.getLop(), x.getPhuong(), x.getQuan(), x.getTinh() };
				dmSinhVien.addRow(row);
			}
		}
	}

	// EVENT CHỌN NĂM
	public void setNam() {
		String chonNam = (String) cboChonNam.getSelectedItem();
		dmMonHoc.setRowCount(0);
		if (chonNam == "TẤT CẢ") {

			for (Lop x : arrLop) {
				String[] row = { x.getMaLop(), x.getMoTa(), x.getNam() };
				dmMonHoc.addRow(row);
			}

		} else {
			for (Lop x : arrLop) {
				if (chonNam.equals(x.getNam())) {
					String[] row = { x.getMaLop(), x.getMoTa(), x.getNam() };
					dmMonHoc.addRow(row);
				}
			}
		}
	}

	// EVENT XEM LỚP HỌC CÓ MÔN NÀO
	public void xemLopHocCoMonNao() {
		String chonLop = (String) cboChonLopMonHoc.getSelectedItem();
		dmMonHocCuaTungLop.setRowCount(0);
		for (MonHocCuaTungLop x : arrMonHocCuaTungLop) {
			System.out.println(chonLop.equals(x.getLopMonHocCuaTungLop()));
			if (chonLop.equals(x.getLopMonHocCuaTungLop())) {
				String[] row = { x.getLopMonHocCuaTungLop(), x.getMaMonHocCuaTungLop(), x.getTenMonHocCuaTungLop() };
				dmMonHocCuaTungLop.addRow(row);
			}
		}
	}

	// ADD ITEM CHO CBO maMonHocDiem
	public void chonMon() {
		maMonHocDiem.removeAllItems();
		maSinhVienDiem.removeAllItems();

		String chonLopHocDiem = (String) maLopHocDiem.getSelectedItem();
		Connection conn = ConnectData.getConnect("localhost", "QuanLySinhVien", "QuanLySinhVien", "QuanLySinhVien");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement
					.executeQuery("SELECT MaMonHoc FROM MonHocCuaTungLop WHERE Lop='" + chonLopHocDiem + "'");
			while (result.next()) {
				maMonHocDiem.addItem(result.getString("MaMonHoc"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		chonMaSinhVien();

	}

	// EVENT
	public void addEvent() {
		// EVENT SINH VIÊN
		cboTinh.addActionListener(eventChooseQuan);
		cboQuan.addActionListener(eventChoosePhuong);
		btnQuanLyLopHoc.addActionListener(eventQuanLyLopHoc);
		btnQuanLyMonHoc.addActionListener(eventQuanLyMonHoc);
		btnQuanLySinhVien.addActionListener(eventQuanLySinhVien);
		btnQuanLyDiem.addActionListener(eventQuanLyDiem);
		btnThongKe.addActionListener(eventThongKe);
		btnMonHocTungLop.addActionListener(eventMonHocCuaLop);
		themSinhVien.addActionListener(eventAdd);
		xoaSinhVien.addActionListener(eventDel);
		suaSinhVien.addActionListener(eventEdit);
		tblSinhVien.addMouseListener(eventTable);
		cboLopSinhVienPrint.addActionListener(eventchooseLop);
		cboLopPrint.addActionListener(eventchooseLopPrint);
		refreshSV.addActionListener(eventrefreshSV);
		// EVENT LỚP
		cboChonNam.addActionListener(eventchooseNam);
		refreshLop.addActionListener(eventrefreshLop);
		themLop.addActionListener(eventAddLop);
		xoaLop.addActionListener(eventDelLop);
		suaLop.addActionListener(eventEditLop);
		tblMonHoc.addMouseListener(eventTableLop);
		// EVENT MÔN HỌC
		refreshMonHoc.addActionListener(eventRefreshMonHoc);
		themMonHoc.addActionListener(eventAddMonHoc);
		suaMonHoc.addActionListener(eventEditMonHoc);
		xoaMonHoc.addActionListener(eventDelMonHoc);
		tblLop.addMouseListener(eventTableMonHoc);
		// EVENT TÌM KIẾM
		btnTimKiem.addActionListener(eventTimKiem);
		// EVENT MÔN HỌC CỦA TỪNG LỚP
		themMonHocCuaLop.addActionListener(eventThemMonHocCuaTungLop);
		xoaMonHocCuaLop.addActionListener(eventXoaMonHocCuaTungLop);
		cboChonLopMonHoc.addActionListener(eventChonLopHocMonHoc);
		tblMonHocCuaTungLop.addMouseListener(eventTableMonHocCuaTungLop);
		// EVENT ĐIỂM
		maLopHocDiem.addActionListener(eventChonMaSinhVien);
		themDiem.addActionListener(eventThemDiem);
		xoaDiem.addActionListener(eventXoaDiem);
		suaDiem.addActionListener(eventsuaDiem);
		tblDiem.addMouseListener(eventTableDiem);
		cboXemDiemCuaLop.addActionListener(eventXemDiemCuaLop);
		// EVENT THỐNG KÊ
		thongKeSinhVien.addActionListener(eventPrintLop);
		cbochonNamThongKe.addActionListener(eventChonLopThongKe);
		cbochonLop.addActionListener(eventTheoLop);

	}
	// EVENT XEM ĐIỂM CỦA LỚP
	ActionListener eventXemDiemCuaLop = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String xemDiemCuaLop = (String) cboXemDiemCuaLop.getSelectedItem();
			try {
				Connection conn = ConnectData.getConnect("localhost", "QuanLySinhVien", "QuanLySinhVien",
						"QuanLySinhVien");
				Statement statement = conn.createStatement();
				ResultSet result = statement.executeQuery("SELECT * FROM Diem WHERE MaLop='" + xemDiemCuaLop + "'");

				arrDiem.clear();
				while (result.next()) {
					arrDiem.add(new Diem(result.getString("MaLop"), result.getString("MaSV"),
							result.getString("MaMonHoc"), result.getString("Diem")));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			dmDiem.setRowCount(0);
			for (Diem x : arrDiem) {
				String[] row = { x.getMaLop(), x.getMaSinhVien(), x.getMaMonHoc(), x.getDiem() };
				dmDiem.addRow(row);
			}
		}
	};
	// EVENT PRINT THEO LỚP
	ActionListener eventTheoLop = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			dmThongKe.setRowCount(0);
			inThongKeTheoLop();
		}
	};
	// EVENT CHỌN LỚP HỌC CỦA MÔN HỌC
	ActionListener eventChonLopHocMonHoc = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			String chonLop = (String) cboChonLopMonHoc.getSelectedItem();
			try {
				Connection conn = ConnectData.getConnect("localhost", "QuanLySinhVien", "QuanLySinhVien",
						"QuanLySinhVien");
				Statement statement = conn.createStatement();
				ResultSet result = statement.executeQuery("SELECT * FROM MonHocCuaTungLop WHERE Lop='" + chonLop + "'");
				arrMonHocCuaTungLop.clear();
				while (result.next()) {
					arrMonHocCuaTungLop.add(new MonHocCuaTungLop(result.getString("Lop"), result.getString("MaMonHoc"),
							result.getString("TenMonHoc")));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			dmMonHocCuaTungLop.setRowCount(0);

			for (MonHocCuaTungLop x : arrMonHocCuaTungLop) {
				String[] row = { x.getLopMonHocCuaTungLop(), x.getMaMonHocCuaTungLop(), x.getTenMonHocCuaTungLop() };
				dmMonHocCuaTungLop.addRow(row);
			}

		}
	};
	// EVENT CHỌN LỚP THỐNG KÊ
	ActionListener eventChonLopThongKe = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			cbochonLop.removeAllItems();

			chonLopThongKe();

		}
	};

	// EVENT PRINT THỐNG KÊ
	ActionListener eventPrintLop = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			dmThongKe2.setRowCount(0);
			thongKePrint();
		}
	};
	// EVENT SỮA ĐIỂM
	ActionListener eventsuaDiem = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int KT = 0;
			String chonLopHocDiem = (String) maLopHocDiem.getSelectedItem();
			String chonMonHocDiem = (String) maMonHocDiem.getSelectedItem();
			String chonMaSinhVienDiem = (String) maSinhVienDiem.getSelectedItem();
			String nhapDiem1 = nhapDiem.getText();
			if (nhapDiem1.isEmpty()) {
				JOptionPane.showMessageDialog(null, "HÃY NHẬP ĐIỂM", null, JOptionPane.WARNING_MESSAGE);

			} else {
				for (Diem x : arrDiem) {
					if (chonLopHocDiem.equals(x.getMaLop()) && chonMonHocDiem.equals(x.getMaMonHoc())
							&& chonMaSinhVienDiem.equals(x.getMaSinhVien())) {
						KT = 2;

						x.setMaLop(chonLopHocDiem);
						x.setMaMonHoc(chonMonHocDiem);
						x.setMaSinhVien(chonMaSinhVienDiem);
						x.setDiem(nhapDiem1);
						break;
					}
				}
				if (KT < 2) {
					JOptionPane.showMessageDialog(null, "CHỈ ĐƯỢC SỮA ĐIỂM", null, JOptionPane.WARNING_MESSAGE);

				} else {
					try {
						Connection conn = ConnectData.getConnect("localhost", "QuanLySinhVien", "QuanLySinhVien",
								"QuanLySinhVien");
						try {
							String sql = "UPDATE Diem SET MaMonHoc ='" + chonMonHocDiem + "',MaLop ='" + chonLopHocDiem
									+ "',MaSV ='" + chonMaSinhVienDiem + "',Diem ='" + nhapDiem1 + "' WHERE MaMonHoc ='"
									+ chonMonHocDiem + "'AND MaLop ='" + chonLopHocDiem + "' AND MaSV ='"
									+ chonMaSinhVienDiem + "'";
							System.out.println(sql);
							Statement statement = conn.createStatement();
							int x = statement.executeUpdate(sql);
							if (x >= 0) {
								JOptionPane.showMessageDialog(null, "SỮA THÀNH CÔNG");
								nhapDiem.setText("");
							}
						} catch (Exception ex) {
							ex.printStackTrace();
						}

					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "BẠN CẦN NHẬP THÔNG TIN SINH VIÊN");
					}
				}
			}
			dmDiem.setRowCount(0);
			for (Diem x : arrDiem) {
				String[] row = { x.getMaLop(), x.getMaSinhVien(), x.getMaMonHoc(), x.getDiem() };
				dmDiem.addRow(row);
			}
		}
	};

	// TABLE ĐIỂM
	MouseAdapter eventTableDiem = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int row = tblDiem.getSelectedRow();
			String[] col = new String[4];
			col[0] = (String) tblDiem.getValueAt(row, 0);
			col[1] = (String) tblDiem.getValueAt(row, 1);
			col[2] = (String) tblDiem.getValueAt(row, 2);
			col[3] = (String) tblDiem.getValueAt(row, 3);

			maLopHocDiem.setSelectedItem(col[0]);
			maSinhVienDiem.setSelectedItem(col[1]);
			maMonHocDiem.setSelectedItem(col[2]);
			nhapDiem.setText(col[3]);
		}
	};

	// EVENT XÓA ĐIỂM
	ActionListener eventXoaDiem = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			int KT = 0;
			String chonLopHocDiem = (String) maLopHocDiem.getSelectedItem();
			String chonMonHocDiem = (String) maMonHocDiem.getSelectedItem();
			String chonMaSinhVienDiem = (String) maSinhVienDiem.getSelectedItem();
			String nhapDiem1 = nhapDiem.getText();
			for (Diem x : arrDiem) {
				if (chonLopHocDiem.equals(x.getMaLop()) && chonMonHocDiem.equals(x.getMaMonHoc())
						&& chonMaSinhVienDiem.equals(x.getMaSinhVien()) && nhapDiem1.equals(x.getDiem())) {
					arrDiem.remove(x);
					KT = 2;
					break;
				}
			}
			if (KT < 1) {
				JOptionPane.showMessageDialog(null, "CHƯA XÓA ĐƯỢC", null, JOptionPane.WARNING_MESSAGE);
			} else {
				Connection conn = ConnectData.getConnect("localhost", "QuanLySinhVien", "QuanLySinhVien",
						"QuanLySinhVien");
				try {
					String sql = "DELETE  FROM Diem WHERE MaLop = '" + (String) maLopHocDiem.getSelectedItem()
							+ "' AND MaMonHoc ='" + (String) maMonHocDiem.getSelectedItem() + "' AND MaSV ='"
							+ (String) maSinhVienDiem.getSelectedItem() + "'" + "AND Diem ='"
							+ (String) nhapDiem.getText() + "' ";
					System.out.println(sql);
					Statement statement = conn.createStatement();
					int x = statement.executeUpdate(sql);
					if (x > 0) {
						JOptionPane.showMessageDialog(null, "XÓA THÀNH CÔNG");

					}
				} catch (Exception ex) {
					ex.printStackTrace();

				}
			}
			dmDiem.setRowCount(0);
			for (Diem x : arrDiem) {
				String[] row = { x.getMaLop(), x.getMaSinhVien(), x.getMaMonHoc(), x.getDiem() };
				dmDiem.addRow(row);
			}

		}
	};
	// EVENT THÊM ĐIỂM
	ActionListener eventThemDiem = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			int KT1 = 0;
			int KT2 = 0;

			String chonLopHocDiem = (String) maLopHocDiem.getSelectedItem();
			String chonMonHocDiem = (String) maMonHocDiem.getSelectedItem();
			String chonMaSinhVienDiem = (String) maSinhVienDiem.getSelectedItem();
			String nhapDiem1 = nhapDiem.getText();
			String diemString = String.valueOf(nhapDiem1);

			Connection conn = ConnectData.getConnect("localhost", "QuanLySinhVien", "QuanLySinhVien", "QuanLySinhVien");

			for (Diem x : arrDiem) {
				if (chonLopHocDiem.equals(x.getMaLop()) && chonMonHocDiem.equals(x.getMaMonHoc())
						&& chonMaSinhVienDiem.equals(x.getMaSinhVien())) {
					KT1 = 2;
					break;
				}
			}
			try {
				Integer.parseInt(nhapDiem1);
			} catch (NumberFormatException ex) {
				KT2 = 1;

			}
			if (diemString.equals("")) {
				JOptionPane.showMessageDialog(null, "XIN HÃY NHẬP ĐẦY ĐỦ THÔNG TIN!", null,
						JOptionPane.WARNING_MESSAGE);
			}
			int diem = Integer.parseInt(nhapDiem1);

			if (KT1 > 0) {
				JOptionPane.showMessageDialog(null, "ĐIỂM CỦA MÔN HỌC ĐÃ TỒN TẠI!", null, JOptionPane.WARNING_MESSAGE);
				nhapDiem.setText("");

			} else if (KT2 > 0) {
				JOptionPane.showMessageDialog(null, "HÃY NHẬP KIỂU SỐ!", null, JOptionPane.WARNING_MESSAGE);
				nhapDiem.setText("");

			} else if (diem < 1 || diem > 10) {
				JOptionPane.showMessageDialog(null, "HÃY NHẬP TỪ 1 DẾN 10!", null, JOptionPane.WARNING_MESSAGE);
				nhapDiem.setText("");
			} else {

				arrDiem.add(new Diem(chonLopHocDiem, chonMaSinhVienDiem, chonMonHocDiem, nhapDiem1));
				dmDiem.addRow(new String[] { chonLopHocDiem, chonMaSinhVienDiem, chonMonHocDiem, nhapDiem1 });
				try {
					String sql = "INSERT INTO Diem(MaMonHoc, MaLop, MaSV, Diem) VALUES (" + "'" + chonMonHocDiem + "','"
							+ chonLopHocDiem + "','" + chonMaSinhVienDiem + "','" + nhapDiem1 + "')";
					Statement statement = conn.createStatement();
					int x = statement.executeUpdate(sql);
					if (x > 0) {
						JOptionPane.showMessageDialog(null, "ĐÃ LƯU THÔNG TIN MÔN HỌC");
						nhapDiem.setText("");
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}

			}

			nhapDiem.setText("");

			dmDiem.setRowCount(0);
			for (Diem x : arrDiem) {
				String[] row = { x.getMaLop(), x.getMaSinhVien(), x.getMaMonHoc(), x.getDiem() };
				dmDiem.addRow(row);
			}

		}
	};
	// EVENT CHỌN MÃ SINH VIÊN
	ActionListener eventChonMaSinhVien = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			chonMon();
		}
	};

	// TABLE MÔN HỌC CỦA TỪNG LỚP
	MouseAdapter eventTableMonHocCuaTungLop = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int row = tblMonHocCuaTungLop.getSelectedRow();
			String[] col = new String[2];
			col[0] = (String) tblMonHocCuaTungLop.getValueAt(row, 0);
			col[1] = (String) tblMonHocCuaTungLop.getValueAt(row, 1);
			cboChonLopMonHoc.setSelectedItem(col[0]);
			cboChonMaMonHoc.setSelectedItem(col[1]);

		}
	};
	// EVENT XÓA MÔN HỌC CỦA TỪNG LỚP
	ActionListener eventXoaMonHocCuaTungLop = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			for (MonHocCuaTungLop x : arrMonHocCuaTungLop) {

				if (((String) cboChonLopMonHoc.getSelectedItem()).equals(x.getLopMonHocCuaTungLop())) {
					if (((String) cboChonMaMonHoc.getSelectedItem()).equals(x.getMaMonHocCuaTungLop())) {
						arrMonHocCuaTungLop.remove(x);
						break;
					}
				}
			}
			Connection conn = ConnectData.getConnect("localhost", "QuanLySinhVien", "QuanLySinhVien", "QuanLySinhVien");
			try {
				String sql = "DELETE  FROM MonHocCuaTungLop WHERE Lop = '" + (String) cboChonLopMonHoc.getSelectedItem()
						+ "' AND MaMonHoc ='" + (String) cboChonMaMonHoc.getSelectedItem() + "'";
				Statement statement = conn.createStatement();
				int x = statement.executeUpdate(sql);
				if (x > 0) {
					JOptionPane.showMessageDialog(null, "XÓA THÀNH CÔNG");

				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			dmMonHocCuaTungLop.setRowCount(0);
			for (MonHocCuaTungLop x1 : arrMonHocCuaTungLop) {
				String[] row = { x1.getLopMonHocCuaTungLop(), x1.getMaMonHocCuaTungLop(), x1.getTenMonHocCuaTungLop() };
				dmMonHocCuaTungLop.addRow(row);
			}

		}
	};
	// EVENT THÊM MÔN HỌC CỦA TỪNG LỚP
	ActionListener eventThemMonHocCuaTungLop = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			int KTTT = 0;
			String chonLopMonHoc = (String) cboChonLopMonHoc.getSelectedItem();
			String chonMaMonHoc = (String) cboChonMaMonHoc.getSelectedItem();

			try {
				for (MonHocCuaTungLop x : arrMonHocCuaTungLop) {

					if ((chonLopMonHoc.equals(x.getLopMonHocCuaTungLop()))
							&& (chonMaMonHoc.equals(x.getMaMonHocCuaTungLop()))) {
						KTTT = 1;
					}
				}
				if (KTTT > 0) {

					JOptionPane.showMessageDialog(null, "MÔN HỌC ĐÃ TỒN TẠI!", null, JOptionPane.WARNING_MESSAGE);

				} else {

					Connection conn = ConnectData.getConnect("localhost", "QuanLySinhVien", "QuanLySinhVien",
							"QuanLySinhVien");
					Statement statement = conn.createStatement();
					ResultSet result = statement.executeQuery(
							"SELECT Lop.MaLop,MonHoc.MaMonHoc,MonHoc.TenMonHoc FROM Lop INNER JOIN MonHoc WHERE MaLop= '"
									+ chonLopMonHoc + "' AND MonHoc.MaMonHoc='" + chonMaMonHoc + "'");

					// while (result.next()) {
					result.next();
					arrMonHocCuaTungLop.add(new MonHocCuaTungLop(result.getString("MaLop"),
							result.getString("MaMonHoc"), result.getString("TenMonHoc")));
					dmMonHocCuaTungLop.addRow(new String[] { result.getString("MaLop"), result.getString("MaMonHoc"),
							result.getString("TenMonHoc") });
					String sql = "INSERT INTO MonHocCuaTungLop(Lop, MaMonHoc,TenMonHoc) VALUES (" + "'"
							+ result.getString("MaLop") + "','" + result.getString("MaMonHoc") + "','"
							+ result.getString("TenMonHoc") + "')";
					statement.executeUpdate(sql);
					JOptionPane.showMessageDialog(null, "THÊM THÀNH CÔNG");

				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}

			dmMonHocCuaTungLop.setRowCount(0);
			for (MonHocCuaTungLop x : arrMonHocCuaTungLop) {
				String[] row = { x.getLopMonHocCuaTungLop(), x.getMaMonHocCuaTungLop(), x.getTenMonHocCuaTungLop() };
				dmMonHocCuaTungLop.addRow(row);
			}
		}
	};
	// EVENT TÌM KIẾM
	ActionListener eventTimKiem = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (timKiemJT.getText().isEmpty()) {

				JOptionPane.showMessageDialog(null, "XIN HÃY NHẬP ĐẦY ĐỦ THÔNG TIN!", null,
						JOptionPane.WARNING_MESSAGE);
			} else {

				Connection conn = ConnectData.getConnect("localhost", "QuanLySinhVien", "QuanLySinhVien",
						"QuanLySinhVien");
				try {
					Statement statement = conn.createStatement();
					ResultSet result = statement.executeQuery("SELECT * FROM `SinhVien` WHERE TenSinhVien LIKE  '%"
							+ timKiemJT.getText() + "' OR MaSV LIKE '%" + timKiemJT.getText() + "' ");
					while (result.next()) {
						arrSV.add(new ThongTinSinhVien(result.getString("MaSV"), result.getString("TenSinhVien"),
								result.getString("NgaySinh"), result.getString("DiaChi"), result.getString("Email"),
								result.getString("SDT"), result.getString("Lop"), result.getString("Phuong"),
								result.getString("Quan"), result.getString("Tinh")));
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}

				for (ThongTinSinhVien x : arrSV) {
					dmSinhVien.setRowCount(0);
					String[] row = { x.getMaSV(), x.getTenSV(), x.getNgaySinh(), x.getDiaChi(), x.getEmail(),
							x.getsDT(), x.getLop(), x.getPhuong(), x.getQuan(), x.getTinh() };
					dmSinhVien.addRow(row);
				}
			}

		}

	};
	ActionListener eventchooseLopPrint = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String chonLopPrintt = (String) cboLopPrint.getSelectedItem();
			nhapMaSinhVien.setText(chonLopPrintt);
			nhapNgaySinh.setText("");
			nhapTenSinhVien.setText("");
			nhapDiaChi.setText("");
			nhapEmail.setText("");
			nhapSDT.setText("");
			cboTinh.setSelectedItem("");

		}
	};

	// CARLAYOUT MÔN HỌC CỦA LỚP
	ActionListener eventMonHocCuaLop = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			card.show(pnLayout, "6");
			cboChonLopMonHoc.removeAllItems();
			chonLop();

		}
	};
	// CARLAYOUT THỐNG KÊ
	ActionListener eventThongKe = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			card.show(pnLayout, "5");
			dmThongKe.setRowCount(0);
			inThongKe();
			thongKeSinhVien.removeAllItems();
			cbochonNamThongKe.removeAllItems();
			cbochonLop.removeAllItems();
			chonNam();
			chonNam1();
		}
	};
	// CARLAYOUT QUẢN LÝ ĐIỂM
	ActionListener eventQuanLyDiem = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			card.show(pnLayout, "2");
			maLopHocDiem.removeAllItems();
			cboXemDiemCuaLop.removeAllItems();
			chonLopXemDiem();
			chonLopDiem();
			chonMaSinhVien();
			chonMon();
			resetDiem();

		}
	};
	// EVENT SỮA MÔN HỌC
	ActionListener eventEditMonHoc = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			int ktTonTai = 0;
			int kt = 0;

			String tenMonHoc = nhapTenMonHoc.getText();
			String thoiLuongHoc = nhapThoiLuongHoc.getText();
			Integer tinChi1 = Integer.valueOf(nhapSoTinChi.getText());

			for (int i = 0; i < arrMonHoc.size(); i++) {
				if (nhapMaMonHoc.getText().equals(arrMonHoc.get(i).getMaMonHoc())) {
					ktTonTai = 1;
				}
			}
			for (MonHoc x : arrMonHoc) {
				if (nhapMaMonHoc.getText().equals(x.getMaMonHoc()) && tenMonHoc.equals(x.getTenMonHoc())
						&& thoiLuongHoc.equals(x.getThoiGian()) && tinChi1.equals(x.getTinChi())) {
					kt = 2;
					break;
				}
			}
			for (MonHoc x : arrMonHoc) {
				if (nhapMaMonHoc.getText().equals(x.getMaMonHoc())) {
					String maMonHoc1 = nhapMaMonHoc.getText();
					String tenMonHoc1 = nhapTenMonHoc.getText();
					String thoiLuongHoc1 = nhapThoiLuongHoc.getText();
					Integer tinChi2 = Integer.valueOf(nhapSoTinChi.getText());
					x.setMaMonHoc(maMonHoc1);
					x.setTenMonHoc(tenMonHoc1);
					x.setTinChi(tinChi2);
					x.setThoiGian(thoiLuongHoc1);
					break;
				}
			}
			try {
				if (nhapMaMonHoc.getText().isEmpty() || nhapTenMonHoc.getText().isEmpty()
						|| nhapSoTinChi.getText().isEmpty() || nhapThoiLuongHoc.getText().isEmpty()) {

					JOptionPane.showMessageDialog(null, "XIN HÃY NHẬP ĐẦY ĐỦ THÔNG TIN!", null,
							JOptionPane.WARNING_MESSAGE);
				} else if (ktTonTai < 1) {
					JOptionPane.showMessageDialog(null, "MÃ MÔN HỌC KHÔNG ĐỰC SỮA,HÃY THÊM MỚI", null,
							JOptionPane.WARNING_MESSAGE);
				} else if (kt == 2) {
					JOptionPane.showMessageDialog(null, "HÃY SỮA THÔNG TIN", null, JOptionPane.WARNING_MESSAGE);
				} else {
					Connection conn = ConnectData.getConnect("localhost", "QuanLySinhVien", "QuanLySinhVien",
							"QuanLySinhVien");
					try {
						String sql = "UPDATE MonHoc SET MaMonHoc ='" + nhapMaMonHoc.getText() + "',TenMonHoc ='"
								+ nhapTenMonHoc.getText() + "',SoTinChi ='" + nhapSoTinChi.getText()
								+ "',ThoiLuongHoc ='" + nhapThoiLuongHoc.getText() + "' WHERE MaMonHoc = '"
								+ nhapMaMonHoc.getText() + "'";
						Statement statement = conn.createStatement();
						int x = statement.executeUpdate(sql);
						if (x >= 0) {
							JOptionPane.showMessageDialog(null, "SỮA THÀNH CÔNG");
							cboChonMaMonHoc.removeAllItems();
							maMonHoc();
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					nhapMaMonHoc.setText("");
					nhapTenMonHoc.setText("");
					nhapThoiLuongHoc.setText("");
					nhapSoTinChi.setText("");
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "BẠN CẦN NHẬP THÔNG TIN SINH VIÊN");
			}

			dmLop.setRowCount(0);
			for (MonHoc x : arrMonHoc) {
				String tinChi = String.valueOf(x.getTinChi());
				String[] row = { x.getMaMonHoc(), x.getTenMonHoc(), tinChi, x.getThoiGian() };
				dmLop.addRow(row);
			}
		}
	};
	// EVENT XÓA MÔN HỌC
	ActionListener eventDelMonHoc = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			int kt = 0;
			for (MonHoc x : arrMonHoc) {
				if (nhapMaMonHoc.getText().equals(x.getMaMonHoc())) {
					kt = 2;
					arrMonHoc.remove(x);
					break;
				}
			}
			if (nhapMaMonHoc.getText().isEmpty() || nhapTenMonHoc.getText().isEmpty()
					|| nhapSoTinChi.getText().isEmpty() || nhapThoiLuongHoc.getText().isEmpty()) {

				JOptionPane.showMessageDialog(null, "XIN HÃY NHẬP ĐẦY ĐỦ THÔNG TIN!", null,
						JOptionPane.WARNING_MESSAGE);
			} else if (kt < 1) {
				JOptionPane.showMessageDialog(null, "THÔNG TIN MÔN HỌC CHƯA XÓA ĐƯỢC", null,
						JOptionPane.WARNING_MESSAGE);
			} else {
				Connection conn = ConnectData.getConnect("localhost", "QuanLySinhVien", "QuanLySinhVien",
						"QuanLySinhVien");

				try {
					String sql = "DELETE FROM MonHoc WHERE MaMonHoc = '" + nhapMaMonHoc.getText() + "'";

					Statement statement = conn.createStatement();

					int x = statement.executeUpdate(sql);
					if (x >= 0 && kt > 1) {
						JOptionPane.showMessageDialog(null, "ĐÃ XÓA THÔNG TIN MÔN HỌC");
						cboChonMaMonHoc.removeAllItems();
						maMonHoc();
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			nhapMaMonHoc.setText("");
			nhapTenMonHoc.setText("");
			nhapThoiLuongHoc.setText("");
			nhapSoTinChi.setText("");
			dmLop.setRowCount(0);
			for (MonHoc x : arrMonHoc) {
				String tinChi = String.valueOf(x.getTinChi());
				String[] row = { x.getMaMonHoc(), x.getTenMonHoc(), tinChi, x.getThoiGian() };
				dmLop.addRow(row);
			}

		}
	};
	// TABLE MÔN HỌC
	MouseAdapter eventTableMonHoc = new MouseAdapter() {
		@Override
		public void mouseClicked(java.awt.event.MouseEvent e) {
			int row = tblLop.getSelectedRow();
			String[] col = new String[4];
			col[0] = (String) tblLop.getValueAt(row, 0);
			col[1] = (String) tblLop.getValueAt(row, 1);
			col[2] = (String) tblLop.getValueAt(row, 2);
			col[3] = (String) tblLop.getValueAt(row, 3);

			nhapMaMonHoc.setText(col[0]);
			nhapTenMonHoc.setText(col[1]);
			nhapSoTinChi.setText(col[2]);
			nhapThoiLuongHoc.setText(col[3]);

		}
	};
	// EVENT REFRESH MÔN HỌC
	ActionListener eventRefreshMonHoc = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			nhapMaMonHoc.setText("");
			nhapTenMonHoc.setText("");
			nhapThoiLuongHoc.setText("");
			nhapSoTinChi.setText("");
		}
	};
	// EVENT THÊM MÔN HỌC
	ActionListener eventAddMonHoc = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int kt = 0;
			String maMonHoc = nhapMaMonHoc.getText();
			String tenMonHoc = nhapTenMonHoc.getText();
			String thoiLuongHoc = nhapThoiLuongHoc.getText();
			// String s = Integer.toString("");
			String soTinChi = String.valueOf(nhapSoTinChi.getText());
			for (MonHoc x : arrMonHoc) {
				if (maMonHoc.equals(x.getMaMonHoc()) && tenMonHoc.equals(x.getTenMonHoc())) {
					kt = 2;
					break;
				}
			}
			Connection conn = ConnectData.getConnect("localhost", "QuanLySinhVien", "QuanLySinhVien", "QuanLySinhVien");
			try {
				if (maMonHoc.isEmpty() || tenMonHoc.isEmpty() || soTinChi.isEmpty() || thoiLuongHoc.isEmpty()) {
					JOptionPane.showMessageDialog(null, "XIN HÃY NHẬP ĐẦY ĐỦ THÔNG TIN!", null,
							JOptionPane.WARNING_MESSAGE);
				} else if (kt == 2) {
					JOptionPane.showMessageDialog(null, "MÔN HỌC ĐÃ TỒN TẠI RỒI!", null, JOptionPane.WARNING_MESSAGE);

				} else {
					Integer tinChi = Integer.valueOf(nhapSoTinChi.getText());

					arrMonHoc.add(new MonHoc(maMonHoc, tinChi, tenMonHoc, thoiLuongHoc));
					dmLop.addRow(new String[] { maMonHoc, tenMonHoc, soTinChi, thoiLuongHoc });
					try {
						String sql = "INSERT INTO MonHoc(MaMonHoc,SoTinChi,ThoiLuongHoc,TenMonHoc) VALUES (" + "'"
								+ maMonHoc + "','" + tinChi + "','" + thoiLuongHoc + "','" + tenMonHoc + "')";
						Statement statement = conn.createStatement();
						int x = statement.executeUpdate(sql);
						if (x > 0) {
							JOptionPane.showMessageDialog(null, "ĐÃ LƯU THÔNG TIN MÔN HỌC");
							cboChonMaMonHoc.removeAllItems();
							maMonHoc();
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					nhapMaMonHoc.setText("");
					nhapTenMonHoc.setText("");
					nhapThoiLuongHoc.setText("");
					nhapSoTinChi.setText("");

				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "HÃY NHẬP SỐ TÍN CHỈ KIỂU SỐ");
			}

			dmLop.setRowCount(0);
			for (MonHoc x : arrMonHoc) {
				String tinChi = String.valueOf(x.getTinChi());
				String[] row = { x.getMaMonHoc(), x.getTenMonHoc(), tinChi, x.getThoiGian() };
				dmLop.addRow(row);
			}
		}
	};
	// EVENT THÊM LỚP
	ActionListener eventAddLop = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			int kt = 0;
			String lop = nhapMaLop.getText();
			String mota = nhapMoTa.getText();
			String chonNam = (String) cboChonNam.getSelectedItem();
			for (Lop x : arrLop) {
				if (nhapMaLop.getText().equals(x.getMaLop()) && mota.equals(x.getMoTa())) {
					kt = 2;
					break;
				}
			}
			Connection conn = ConnectData.getConnect("localhost", "QuanLySinhVien", "QuanLySinhVien", "QuanLySinhVien");
			try {

				if (lop.isEmpty() || mota.isEmpty()) {
					JOptionPane.showMessageDialog(null, "XIN HÃY NHẬP ĐẦY ĐỦ THÔNG TIN!", null,
							JOptionPane.WARNING_MESSAGE);
				} else if (chonNam == "TẤT CẢ") {
					JOptionPane.showMessageDialog(null, "HÃY CHỌN NĂM", null, JOptionPane.WARNING_MESSAGE);

				} else if (kt == 2) {
					JOptionPane.showMessageDialog(null, "ĐÃ TỒN TẠI", null, JOptionPane.WARNING_MESSAGE);

				} else {

					arrLop.add(new Lop(lop, mota, chonNam));
					dmMonHoc.addRow(new String[] { lop, mota, chonNam });
					try {
						String sql = "INSERT INTO Lop(MaLop,MoTa,Nam) VALUES ('" + lop + "','" + mota + "','" + chonNam
								+ "')";
						Statement statement = conn.createStatement();
						int x = statement.executeUpdate(sql);
						if (x > 0) {
							JOptionPane.showMessageDialog(null, "LƯU THÀNH CÔNG");

						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}

				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "XIN HÃY NHẬP THÔNG TIN");
			}
			dmMonHoc.setRowCount(0);
			for (Lop x : arrLop) {
				String[] row = { x.getMaLop(), x.getMoTa(), x.getNam() };
				dmMonHoc.addRow(row);
				setNam();
			}
		}
	};

	// EVENT SỮA LỚP
	ActionListener eventEditLop = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			int ktTonTai = 0;
			int kt = 0;
			String mota = nhapMoTa.getText();
			String chonNam = (String) cboChonNam.getSelectedItem();
			for (int i = 0; i < arrLop.size(); i++) {
				if (nhapMaLop.getText().equals(arrLop.get(i).getMaLop())) {
					ktTonTai = 1;
				}
			}
			for (Lop x : arrLop) {
				if (nhapMaLop.getText().equals(x.getMaLop()) && mota.equals(x.getMoTa())
						&& chonNam.equals(x.getNam())) {
					kt = 2;
					break;
				}
			}

			for (Lop x : arrLop) {
				if (nhapMaLop.getText().equals(x.getMaLop())) {
					x.setMaLop(nhapMaLop.getText());
					x.setMoTa(nhapMoTa.getText());
					x.setNam((String) cboChonNam.getSelectedItem());
					break;
				}
			}
			try {
				if (nhapMaLop.getText().equals("") || nhapMoTa.getText().equals("")
						|| cboChonNam.getSelectedItem().equals("")) {
					JOptionPane.showMessageDialog(null, "XIN HÃY NHẬP ĐẦY ĐỦ THÔNG TIN!", null,
							JOptionPane.WARNING_MESSAGE);
				} else if (ktTonTai < 1) {
					JOptionPane.showMessageDialog(null, "LỚP KHÔNG ĐỰC SỮA,HÃY THÊM MỚI", null,
							JOptionPane.WARNING_MESSAGE);
				} else if (kt == 2) {
					JOptionPane.showMessageDialog(null, "HÃY SỮA THÔNG TIN", null, JOptionPane.WARNING_MESSAGE);

				} else {
					Connection conn = ConnectData.getConnect("localhost", "QuanLySinhVien", "QuanLySinhVien",
							"QuanLySinhVien");

					try {
						String sql = "UPDATE Lop SET MaLop ='" + nhapMaLop.getText() + "',MoTa ='" + nhapMoTa.getText()
								+ "',Nam ='" + cboChonNam.getSelectedItem() + "' WHERE MaLop = '" + nhapMaLop.getText()
								+ "'";
						Statement statement = conn.createStatement();
						int x = statement.executeUpdate(sql);
						if (x >= 0) {
							JOptionPane.showMessageDialog(null, "SỮA THÀNH CÔNG");
							cboChonLopMonHoc.removeAllItems();
							chonLop();

						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					nhapMoTa.setText("");
					nhapMaLop.setText("");
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "BẠN CẦN NHẬP THÔNG TIN LỚP");
			}

			for (Lop x : arrLop) {
				String[] row = { x.getMaLop(), x.getMoTa(), x.getNam() };
				dmMonHoc.addRow(row);
				setNam();

			}

		}
	};

	// EVENT CHỌN NĂM
	ActionListener eventchooseNam = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			setNam();
		}

	};
	// EVENT REFESH LỚP
	ActionListener eventrefreshLop = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			nhapMoTa.setText("");
			nhapMaLop.setText("");
			cboChonNam.setSelectedItem("TẤT CẢ");

		}
	};
	// EVENT REFESH SINH VIÊN
	ActionListener eventrefreshSV = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			nhapNgaySinh.setText("");
			nhapMaSinhVien.setText("");
			nhapTenSinhVien.setText("");
			nhapDiaChi.setText("");
			nhapEmail.setText("");
			nhapSDT.setText("");
			cboLopPrint.setSelectedItem("TẤT CẢ");
			cboTinh.setSelectedItem("");
			timKiemJT.setText("");

		}

	};
	// EVENT XÓA LỚP
	ActionListener eventDelLop = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {

			int kt = 0;
			for (Lop x : arrLop) {
				if (nhapMaLop.getText().equals(x.getMaLop())) {
					arrLop.remove(x);
					kt = 2;
					break;
				}
			}
			if (nhapMoTa.getText().isEmpty() || nhapMaLop.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "XIN HÃY NHẬP ĐẦY ĐỦ THÔNG TIN!", null,
						JOptionPane.WARNING_MESSAGE);
			} else if (kt < 1) {
				JOptionPane.showMessageDialog(null, "THÔNG TIN LỚP HỌC CHƯA ĐƯỢC XÓA", null,
						JOptionPane.WARNING_MESSAGE);
			} else {
				Connection conn = ConnectData.getConnect("localhost", "QuanLySinhVien", "QuanLySinhVien",
						"QuanLySinhVien");
				try {
					String sql = "DELETE FROM Lop WHERE MaLop = '" + nhapMaLop.getText() + "'";
					Statement statement = conn.createStatement();
					int x = statement.executeUpdate(sql);
					if (x >= 0 == kt > 1) {
						JOptionPane.showMessageDialog(null, "XÓA THÀNH CÔNG");
						cboChonLopMonHoc.removeAllItems();
						chonLop();

					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			nhapMoTa.setText("");
			nhapMaLop.setText("");
			dmMonHoc.setRowCount(0);
			for (Lop x : arrLop) {
				String[] row = { x.getMaLop(), x.getMoTa(), x.getNam() };
				dmMonHoc.addRow(row);
				setNam();

			}

		}

	};
	// EVENT CHỌN LỚP
	ActionListener eventchooseLop = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			setLop();

		}
	};

	// EVENT TABLE LỚP
	MouseListener eventTableLop = new MouseListener() {
		@Override
		public void mouseClicked(java.awt.event.MouseEvent arg0) {
			int row = tblMonHoc.getSelectedRow();
			String[] col = new String[3];
			col[0] = (String) tblMonHoc.getValueAt(row, 0);
			col[1] = (String) tblMonHoc.getValueAt(row, 1);
			col[2] = (String) tblMonHoc.getValueAt(row, 2);

			nhapMaLop.setText(col[0]);
			nhapMoTa.setText(col[1]);
			cboChonNam.setSelectedItem(col[2]);
		}

		@Override
		public void mouseEntered(java.awt.event.MouseEvent arg0) {

		}

		@Override
		public void mouseExited(java.awt.event.MouseEvent arg0) {

		}

		@Override
		public void mousePressed(java.awt.event.MouseEvent arg0) {

		}

		@Override
		public void mouseReleased(java.awt.event.MouseEvent arg0) {

		}
	};

	// CARLAYOUT LỚP HỌC
	ActionListener eventQuanLyLopHoc = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			card.show(pnLayout, "4");
		}
	};
	// EVENT TABLE SINH VIÊN
	MouseAdapter eventTable = new MouseAdapter() {
		@Override
		public void mouseClicked(java.awt.event.MouseEvent e) {
			int row = tblSinhVien.getSelectedRow();
			String[] col = new String[10];
			col[0] = (String) tblSinhVien.getValueAt(row, 0);
			col[1] = (String) tblSinhVien.getValueAt(row, 1);
			col[2] = (String) tblSinhVien.getValueAt(row, 2);
			col[3] = (String) tblSinhVien.getValueAt(row, 3);
			col[4] = (String) tblSinhVien.getValueAt(row, 4);
			col[5] = (String) tblSinhVien.getValueAt(row, 5);
			col[6] = (String) tblSinhVien.getValueAt(row, 6);
			col[7] = (String) tblSinhVien.getValueAt(row, 7);
			col[8] = (String) tblSinhVien.getValueAt(row, 8);
			col[9] = (String) tblSinhVien.getValueAt(row, 9);

			cboLopPrint.setSelectedItem(col[6]);
			nhapTenSinhVien.setText(col[1]);
			nhapNgaySinh.setText(col[2]);
			nhapDiaChi.setText(col[3]);
			nhapEmail.setText(col[4]);
			nhapSDT.setText(col[5]);
			cboPhuong.setSelectedItem(col[7]);
			cboQuan.setSelectedItem(col[8]);
			cboTinh.setSelectedItem(col[9]);
			nhapMaSinhVien.setText(col[0]);

		}
	};

	// EVENT SỮA SINH VIÊN
	ActionListener eventEdit = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			int ktTonTai = 0;
			int KT2 = 0;

			String ma = nhapMaSinhVien.getText();
			String ten = nhapTenSinhVien.getText();
			String ngaySinh = nhapNgaySinh.getText();
			String diaChi = nhapDiaChi.getText();
			String email = nhapEmail.getText();
			String sDT = nhapSDT.getText();
			try {
				Integer.parseInt(sDT);
			} catch (NumberFormatException ex) {
				KT2 = 1;

			}

			Pattern checkmail = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
			Matcher mail1 = checkmail.matcher(email);
			for (ThongTinSinhVien x : arrSV) {
				if (ma.equals(x.getMaSV())) {
					x.setMaSV(ma);
					x.setTenSV(ten);
					x.setNgaySinh(ngaySinh);
					x.setDiaChi(diaChi);
					x.setEmail(email);
					x.setsDT(sDT);
					x.setLop((String) cboLopPrint.getSelectedItem());
					x.setPhuong((String) cboPhuong.getSelectedItem());
					x.setQuan((String) cboQuan.getSelectedItem());
					x.setTinh((String) cboTinh.getSelectedItem());
					break;
				}
			}
			for (int i = 0; i < arrSV.size(); i++) {
				if (ma.equals(arrSV.get(i).getMaSV())) {
					ktTonTai = 1;
				}
			}
			if (ma.isEmpty() || ten.isEmpty() || ngaySinh.isEmpty() || diaChi.isEmpty() || email.isEmpty()
					|| sDT.isEmpty()) {
				JOptionPane.showMessageDialog(null, "XIN HÃY NHẬP ĐẦY ĐỦ THÔNG TIN!", null,
						JOptionPane.WARNING_MESSAGE);

			} else if (ktTonTai < 1) {
				JOptionPane.showMessageDialog(null, "MÃ SINH VIÊN KHÔNG ĐƯỢC SỮA,HÃY THÊM MỚI SINH VIÊN", null,
						JOptionPane.WARNING_MESSAGE);
			} else if (!mail1.find()) {
				JOptionPane.showMessageDialog(null, "EMAIL KHÔNG HỢP LỆ", null, JOptionPane.WARNING_MESSAGE);

			} else if (KT2 > 0) {
				JOptionPane.showMessageDialog(null, "SỐ ĐIỆN THOẠI CHỈ BAO GỒM SỐ", null, JOptionPane.WARNING_MESSAGE);

			} else if (sDT.length() > 0 && (sDT.length() < 10 || sDT.length() > 11)) {
				JOptionPane.showMessageDialog(null, "SỐ ĐIỆN THOẠI CHỈ TỪ 10-11 SỐ", null, JOptionPane.WARNING_MESSAGE);
				nhapNgaySinh.setText("");
				nhapMaSinhVien.setText("");
				nhapTenSinhVien.setText("");
				nhapDiaChi.setText("");
				nhapEmail.setText("");
				nhapSDT.setText("");

			} else {

				Connection conn = ConnectData.getConnect("localhost", "QuanLySinhVien", "QuanLySinhVien",
						"QuanLySinhVien");
				try {
					String sql = "UPDATE SinhVien SET MaSV ='" + nhapMaSinhVien.getText() + "',TenSinhVien ='"
							+ nhapTenSinhVien.getText() + "',NgaySinh ='" + nhapNgaySinh.getText() + "',DiaChi ='"
							+ nhapDiaChi.getText() + "'," + "Email ='" + nhapEmail.getText() + "',SDT ='"
							+ nhapSDT.getText() + "',Lop ='" + (String) cboLopPrint.getSelectedItem() + "',"
							+ "Phuong ='" + (String) cboPhuong.getSelectedItem() + "',Quan ='"
							+ (String) cboQuan.getSelectedItem() + "',Tinh ='" + (String) cboTinh.getSelectedItem()
							+ "' WHERE MaSV = '" + nhapMaSinhVien.getText() + "'";
					Statement statement = conn.createStatement();
					int x = statement.executeUpdate(sql);
					if (x >= 0) {
						JOptionPane.showMessageDialog(null, "SỬA THÀNH CÔNG");
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			nhapNgaySinh.setText("");
			nhapMaSinhVien.setText("");
			nhapTenSinhVien.setText("");
			nhapDiaChi.setText("");
			nhapEmail.setText("");
			nhapSDT.setText("");

			dmSinhVien.setRowCount(0);
			for (ThongTinSinhVien x : arrSV) {

				String[] row = { x.getMaSV(), x.getTenSV(), x.getNgaySinh(), x.getDiaChi(), x.getEmail(), x.getsDT(),
						x.getLop(), x.getPhuong(), x.getQuan(), x.getTinh() };
				dmSinhVien.addRow(row);
				setLop();

			}

		}

	};

	// EVENT XÓA SINH VIÊN
	ActionListener eventDel = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int kt = 0;
			String ma = nhapMaSinhVien.getText();
			String ten = nhapTenSinhVien.getText();
			String ngaySinh = nhapNgaySinh.getText();
			String diaChi = nhapDiaChi.getText();
			String email = nhapEmail.getText();
			String sDT = nhapSDT.getText();
			for (ThongTinSinhVien x : arrSV) {
				if (nhapMaSinhVien.getText().equals(x.getMaSV())) {
					kt = 2;
					arrSV.remove(x);
					break;
				}
			}
			if (ma.isEmpty() || ten.isEmpty() || ngaySinh.isEmpty() || diaChi.isEmpty() || email.isEmpty()
					|| sDT.isEmpty()) {
				JOptionPane.showMessageDialog(null, "XIN HÃY NHẬP ĐẦY ĐỦ THÔNG TIN!", null,
						JOptionPane.WARNING_MESSAGE);
				nhapNgaySinh.setText("");
				nhapMaSinhVien.setText("");
				nhapTenSinhVien.setText("");
				nhapDiaChi.setText("");
				nhapEmail.setText("");
				nhapSDT.setText("");
			} else if (kt < 1) {
				JOptionPane.showMessageDialog(null, "KHÔNG TÌM THẤY SINH VIÊN CẦN XÓA", null,
						JOptionPane.WARNING_MESSAGE);
			} else {
				Connection conn = ConnectData.getConnect("localhost", "QuanLySinhVien", "QuanLySinhVien",
						"QuanLySinhVien");
				try {
					String sql = "DELETE FROM SinhVien WHERE MaSV = '" + nhapMaSinhVien.getText() + "'";
					String query = "DELETE FROM Diem WHERE MaSV = '" + nhapMaSinhVien.getText() + "'";
					Statement statement = conn.createStatement();
					statement.executeUpdate(query);
					int x = statement.executeUpdate(sql);
					if (x >= 0 && kt > 1) {
						JOptionPane.showMessageDialog(null, "XÓA THÀNH CÔNG");
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			nhapNgaySinh.setText("");
			nhapMaSinhVien.setText("");
			nhapTenSinhVien.setText("");
			nhapDiaChi.setText("");
			nhapEmail.setText("");
			nhapSDT.setText("");
			dmSinhVien.setRowCount(0);
			for (ThongTinSinhVien x : arrSV) {
				String[] row = { x.getMaSV(), x.getTenSV(), x.getNgaySinh(), x.getDiaChi(), x.getEmail(), x.getsDT(),
						x.getLop(), x.getPhuong(), x.getQuan(), x.getTinh() };
				dmSinhVien.addRow(row);
			}

		}
	};

	// EVENT THÊM SINH VIÊN
	ActionListener eventAdd = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			int ktTonTai = 0;
			int KT2 = 0;

			String ma = nhapMaSinhVien.getText();
			String ten = nhapTenSinhVien.getText();
			String ngaySinh = nhapNgaySinh.getText();
			String diaChi = nhapDiaChi.getText();
			String email = nhapEmail.getText();
			String sDT = nhapSDT.getText();
			String chonLop = (String) cboLopPrint.getSelectedItem();
			String chonTinh = (String) cboTinh.getSelectedItem();
			String chonQuan = (String) cboQuan.getSelectedItem();
			String chonPhuong = (String) cboPhuong.getSelectedItem();

			Pattern checkmail = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
			Matcher mail1 = checkmail.matcher(email);
			try {
				Integer.parseInt(sDT);
			} catch (NumberFormatException ex) {
				KT2 = 1;

			}

			for (int i = 0; i < arrSV.size(); i++) {
				if (ma.equals(arrSV.get(i).getMaSV())) {
					ktTonTai = 1;
				}
			}
			if (ma.isEmpty() || ten.isEmpty() || ngaySinh.isEmpty() || diaChi.isEmpty() || email.isEmpty()
					|| sDT.isEmpty()) {
				JOptionPane.showMessageDialog(null, "XIN HÃY NHẬP ĐẦY ĐỦ THÔNG TIN!", null,
						JOptionPane.WARNING_MESSAGE);

			} else if (chonLop == "TẤT CẢ") {
				JOptionPane.showMessageDialog(null, "HÃY CHỌN LỚP", null, JOptionPane.WARNING_MESSAGE);

			} else if (ktTonTai > 0) {
				JOptionPane.showMessageDialog(null, "MÃ SINH VIÊN ĐÃ TỒN TẠI", null, JOptionPane.WARNING_MESSAGE);

			} else if (!mail1.find()) {
				JOptionPane.showMessageDialog(null, "EMAIL KHÔNG HỢP LỆ", null, JOptionPane.WARNING_MESSAGE);

			} else if (KT2 > 0) {
				JOptionPane.showMessageDialog(null, "SỐ ĐIỆN THOẠI CHỈ BAO GỒM SỐ", null, JOptionPane.WARNING_MESSAGE);

			} else if (sDT.length() > 0 && (sDT.length() < 10 || sDT.length() > 11)) {
				JOptionPane.showMessageDialog(null, "SỐ ĐIỆN THOẠI CHỈ TỪ 10-11 SỐ", null, JOptionPane.WARNING_MESSAGE);

			}

			else {

				dmSinhVien.addRow(new String[] { ma, ten, ngaySinh, diaChi, email, sDT, chonLop, chonPhuong, chonQuan,
						chonTinh });
				arrSV.add(new ThongTinSinhVien(ma, ten, ngaySinh, diaChi, email, sDT, chonLop, chonPhuong, chonQuan,
						chonTinh));
				Connection conn = ConnectData.getConnect("localhost", "QuanLySinhVien", "QuanLySinhVien",
						"QuanLySinhVien");
				try {
					String sql = "INSERT INTO SinhVien (MaSV,TenSinhVien,NgaySinh,DiaChi,Email,SDT,Lop,Phuong,Quan,Tinh) VALUES ("
							+ "'" + ma + "','" + ten + "','" + ngaySinh + "','" + diaChi + "','" + email + "','" + sDT
							+ "','" + chonLop + "','" + chonPhuong + "','" + chonQuan + "','" + chonTinh + "')";
					Statement statement = conn.createStatement();
					int x = statement.executeUpdate(sql);
					if (x > 0) {
						JOptionPane.showMessageDialog(null, "LƯU THÀNH CÔNG");
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				nhapNgaySinh.setText("");
				nhapMaSinhVien.setText("");
				nhapTenSinhVien.setText("");
				nhapDiaChi.setText("");
				nhapEmail.setText("");
				nhapSDT.setText("");
				setLop();
			}
		}
	};

	// CARLAYOUT QUẢN LÝ MÔN HỌC
	ActionListener eventQuanLyMonHoc = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			card.show(pnLayout, "3");
		}

	};

	// CARLAYOUT QUẢN LÝ SINH VIÊN
	ActionListener eventQuanLySinhVien = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			cboLopPrint.removeAllItems();
			cboLopSinhVienPrint.removeAllItems();
			chonLopSinhVienPrint();
			card.show(pnLayout, "1");

		}
	};
	// EVENT CHỌN PHƯỜNG
	ActionListener eventChoosePhuong = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			cboPhuong.removeAllItems();
			String chonPhuong = (String) cboQuan.getSelectedItem();
			Connection conn = ConnectData.getConnect("localhost", "QuanLySinhVien", "QuanLySinhVien", "QuanLySinhVien");
			try {
				Statement statement = conn.createStatement();
				ResultSet result = statement.executeQuery(
						"SELECT devvn_xaphuongthitran.name FROM devvn_xaphuongthitran INNER JOIN devvn_quanhuyen WHERE devvn_quanhuyen.maqh=devvn_xaphuongthitran.maqh AND devvn_quanhuyen.name='"
								+ chonPhuong + "'");
				while (result.next()) {
					cboPhuong.addItem(result.getString("devvn_xaphuongthitran.name"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	};

	// EVENT CHỌN QUẬN
	ActionListener eventChooseQuan = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			cboQuan.removeAllItems();
			String chonTinh = (String) cboTinh.getSelectedItem();
			Connection conn = ConnectData.getConnect("localhost", "QuanLySinhVien", "QuanLySinhVien", "QuanLySinhVien");
			try {
				Statement statement = conn.createStatement();
				ResultSet result = statement.executeQuery(
						"SELECT devvn_quanhuyen.name FROM devvn_quanhuyen INNER JOIN devvn_tinhthanhpho WHERE devvn_quanhuyen.matp=devvn_tinhthanhpho.matp AND devvn_tinhthanhpho.name='"
								+ chonTinh + "'");
				while (result.next()) {
					cboQuan.addItem(result.getString("devvn_quanhuyen.name"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	};

	// EVENT ĐIỀU CHỈNH HIỂN THỊ
	public void showWindow() {
		this.setSize(1340, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	// IN THỐNG KÊ THEO LỚP
	private void inThongKeTheoLop() {
		try {
			String chonLop = (String) cbochonLop.getSelectedItem();

			Connection conn = ConnectData.getConnect("localhost", "QuanLySinhVien", "QuanLySinhVien", "QuanLySinhVien");
			Statement statement = conn.createStatement();
			ResultSet result = statement
					.executeQuery("SELECT MaSV,\r\n" + "    SUM(CASE WHEN MaMonHoc = 'LP#0' THEN Diem  END) AS Lp0,\r\n"
							+ "    SUM(CASE WHEN MaMonHoc = 'LP#1' THEN Diem END) AS Lp1,\r\n"
							+ "    SUM(CASE WHEN MaMonHoc = 'LP#2' THEN Diem END) AS Lp2,\r\n"
							+ "    SUM(CASE WHEN MaMonHoc = 'LP#3' THEN Diem END) AS Lp3,\r\n"
							+ "    SUM(CASE WHEN MaMonHoc = 'LP#4' THEN Diem END) AS Lp4,\r\n"
							+ "    SUM(CASE WHEN MaMonHoc = 'LP#5' THEN Diem END) AS Lp5,\r\n"
							+ "    SUM(CASE WHEN MaMonHoc = 'LP#6' THEN Diem END) AS Lp6,\r\n"
							+ "    SUM(CASE WHEN MaMonHoc = 'E4IT' THEN Diem END) AS E4IT\r\n" + "FROM Diem\r\n"
							+ "GROUP BY MaSV");
			while (result.next()) {
				Statement stt = conn.createStatement();
				ResultSet query = stt.executeQuery("SELECT * FROM Sinhvien WHERE Sinhvien.MaSV = '"
						+ result.getString("MaSV") + "' AND SinhVien.Lop ='" + chonLop + "'");
				while (query.next()) {
					String[] row = { result.getString("MaSV"), query.getString("Sinhvien.TenSinhVien"),
							result.getString("Lp0"), result.getString("Lp1"), result.getString("Lp2"),
							result.getString("Lp3"), result.getString("Lp4"), result.getString("Lp5"),
							result.getString("Lp6"), result.getString("E4IT") };
					int t = 0;
					int n = 0;
					int y = 0;
					for (int i = 2; i < row.length; i++) {
						if (row[i] != null) {
							y = Integer.parseInt(row[i]);
							n = n + y;
							t++;
						}
					}
					float tbc = (float) n / t;
					String xeploai;
					if (tbc <= 4.9) {
						xeploai = "Yếu";
					} else if (tbc <= 6.4) {
						xeploai = "Trung Bình";
					} else if (tbc <= 7.9) {
						xeploai = "Khá";
					} else {
						xeploai = "Giỏi";
					}
					String TBM = Float.toString(tbc);
					String[] dm = { result.getString("MaSV"), query.getString("Sinhvien.TenSinhVien"),
							result.getString("Lp0"), result.getString("Lp1"), result.getString("Lp2"),
							result.getString("Lp3"), result.getString("Lp4"), result.getString("Lp5"),
							result.getString("Lp6"), result.getString("E4IT"), TBM, xeploai };
					dmThongKe.addRow(dm);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// IN THỐNG KÊ
	private void inThongKe() {
		try {
			Connection conn = ConnectData.getConnect("localhost", "QuanLySinhVien", "QuanLySinhVien", "QuanLySinhVien");
			Statement statement = conn.createStatement();
			ResultSet result = statement
					.executeQuery("SELECT MaSV,\r\n" + "    SUM(CASE WHEN MaMonHoc = 'LP#0' THEN Diem  END) AS Lp0,\r\n"
							+ "    SUM(CASE WHEN MaMonHoc = 'LP#1' THEN Diem END) AS Lp1,\r\n"
							+ "    SUM(CASE WHEN MaMonHoc = 'LP#2' THEN Diem END) AS Lp2,\r\n"
							+ "    SUM(CASE WHEN MaMonHoc = 'LP#3' THEN Diem END) AS Lp3,\r\n"
							+ "    SUM(CASE WHEN MaMonHoc = 'LP#4' THEN Diem END) AS Lp4,\r\n"
							+ "    SUM(CASE WHEN MaMonHoc = 'LP#5' THEN Diem END) AS Lp5,\r\n"
							+ "    SUM(CASE WHEN MaMonHoc = 'LP#6' THEN Diem END) AS Lp6,\r\n"
							+ "    SUM(CASE WHEN MaMonHoc = 'E4IT' THEN Diem END) AS E4IT\r\n" + "FROM Diem\r\n"
							+ "GROUP BY MaSV");
			while (result.next()) {
				Statement stt = conn.createStatement();
				ResultSet query = stt.executeQuery(
						"SELECT * FROM Sinhvien WHERE Sinhvien.MaSV = '" + result.getString("MaSV") + "'");
				query.next();
				String[] row = { result.getString("MaSV"), query.getString("Sinhvien.TenSinhVien"),
						result.getString("Lp0"), result.getString("Lp1"), result.getString("Lp2"),
						result.getString("Lp3"), result.getString("Lp4"), result.getString("Lp5"),
						result.getString("Lp6"), result.getString("E4IT") };
				int t = 0;
				int n = 0;
				int y = 0;
				for (int i = 2; i < row.length; i++) {
					if (row[i] != null) {
						y = Integer.parseInt(row[i]);
						n = n + y;
						t++;
					}
				}
				float tbc = (float) n / t;
				String xeploai;
				if (tbc <= 4.9) {
					xeploai = "Yếu";
				} else if (tbc <= 6.4) {
					xeploai = "Trung Bình";
				} else if (tbc <= 7.9) {
					xeploai = "Khá";
				} else {
					xeploai = "Giỏi";
				}
				String TBM = Float.toString(tbc);
				String[] dm = { result.getString("MaSV"), query.getString("Sinhvien.TenSinhVien"),
						result.getString("Lp0"), result.getString("Lp1"), result.getString("Lp2"),
						result.getString("Lp3"), result.getString("Lp4"), result.getString("Lp5"),
						result.getString("Lp6"), result.getString("E4IT"), TBM, xeploai };
				dmThongKe.addRow(dm);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
