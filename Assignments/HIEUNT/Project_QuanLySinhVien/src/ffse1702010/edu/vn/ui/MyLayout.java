package ffse1702010.edu.vn.ui;

import java.awt.BorderLayout;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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

	private JPanel pnBorder;
	private JPanel pnESL;
	private JPanel pnMTD;
	private JPanel pnJcombobox;
	private JPanel pnCRUD;
	private JPanel pnCRUDL;
	private JPanel pnTMN;
	// pn chinh
	private JPanel pnQuanLySinhVien;
	private JPanel pnQuanLyMonHoc;
	private JPanel pnQuanLyLopHoc;
	private JPanel pnQuanLyDiem;
	private JPanel pnThongKe;
	private JPanel pnMonHocCuaLop;

	// pn mon hoc
	private JPanel pnMaSo;
	private JPanel pnThoiTen;
	private JPanel pnCRUDMonHoc;

	private Button btnQuanLySinhVien = new Button("QUẢN LÝ SINH VIÊN");
	private Button btnQuanLyLopHoc = new Button("QUẢN LỚP HỌC");
	private Button btnQuanLyMonHoc = new Button("QUẢN LÝ MÔN HỌC");
	private Button btnQuanLyDiem = new Button("QUẢN LÝ ĐIỂM");
	private Button btnThongKe = new Button("THỐNG KÊ BÁO CÁO");
	private Button btnMonHocTungLop = new Button("MÔN HỌC CỦA TỪNG LỚP");

	private Button them = new Button("THÊM");
	private Button sua = new Button("SỬA");
	private Button xoa = new Button("XÓA");
	private Button refreshSV = new Button("REFRESH");

	// buttonquanlydiem
	private Button themL = new Button("THÊM");
	private Button suaL = new Button("SỬA");
	private Button xoaL = new Button("XÓA");
	private Button refreshLop = new Button("REFRESH");
	// button mon hoc
	private Button themMonHoc = new Button("THÊM");
	private Button suaMonHoc = new Button("SỬA");
	private Button xoaMonHoc = new Button("XÓA");
	private Button refreshMonHoc = new Button("REFRESH");
	// button diem
	private Button themDiem = new Button("THÊM");
	private Button suaDiem = new Button("SỬA");
	private Button xoaDiem = new Button("XÓA");
	// button mon hoc cua lop nao
	private Button themMonHocCuaLop = new Button("THÊM");
	private Button xoaMonHocCuaLop = new Button("XÓA");

	// button tim
	private Button btnTimKiem = new Button("TÌM");

	private JTextField nhapMaSinhVien = new JTextField(20);
	private JTextField nhapTenSinhVien = new JTextField(20);
	private JTextField nhapNgaySinh = new JTextField(20);
	private JTextField nhapDiaChi = new JTextField(20);
	private JTextField nhapEmail = new JTextField(20);
	private JTextField nhapSDT = new JTextField(20);
	// JTextField QUan ly điểm
	private JTextField nhapMaLop = new JTextField(20);
	private JTextField nhapMoTa = new JTextField(20);
	// JtextField MonHoc
	private JTextField nhapMaMonHoc = new JTextField(20);
	private JTextField nhapSoTinChi = new JTextField(20);
	private JTextField nhapThoiLuongHoc = new JTextField(20);
	private JTextField nhapTenMonHoc = new JTextField(20);
	// jtextField Diem
	private JTextField nhapDiem = new JTextField(20);
	// JTEXTFIELDTIM
	private JTextField timKiemJT = new JTextField(30);

	private JLabel maSinhVien;
	private JLabel tenSinhVien;
	private JLabel ngaySinh;
	private JLabel diaChi;
	private JLabel email;
	private JLabel sDT;
	private JLabel chonLop;
	private JLabel chonPhuong;
	private JLabel chonQuan;
	private JLabel chonTinh;
	// JLabel Quan ly Diem
	private JLabel maLop;
	private JLabel moTa;
	private JLabel chonNam;
	// JLabel Quan MonHoc
	private JLabel maMonHoc;
	private JLabel soTinChi;
	private JLabel thoiLuongHoc;
	private JLabel tenMonHoc;
	// JLabel Diem
	private JLabel diem;
	private JLabel maLopHocDiem1;
	private JLabel maMonHocDiem1;
	private JLabel maSinhVien1;

	final ObservableList<Object> options = FXCollections.observableArrayList();

	private JComboBox<String> cboLop2 = new JComboBox<>();
	private JComboBox<String> cboLopPrint = new JComboBox<>();

	private JComboBox<String> cboLop1 = new JComboBox<>();
	private JComboBox<String> cboPhuong = new JComboBox<>();
	private JComboBox<String> cboQuan = new JComboBox<>();
	private JComboBox<String> cboTinh = new JComboBox<>();
	// JCOMBOX DIEM
	private JComboBox<String> maLopHocDiem = new JComboBox<>();
	private JComboBox<String> maMonHocDiem = new JComboBox<>();
	private JComboBox<String> maSinhVienDiem = new JComboBox<>();
	// JCOMBOX THONG KE
	private JComboBox<String> cbochonLop = new JComboBox<>();
	private JComboBox<String> cbochonNamThongKe = new JComboBox<>();
	private JComboBox<String> thongKeSinhVien = new JComboBox<>();

	// JCOMBOX MON HOC CUA LOP
	private JComboBox<String> cboChonLopMonHoc = new JComboBox<>();
	private JComboBox<String> cboChonMaMonHoc = new JComboBox<>();
	//private JComboBox<String> cboXemLop = new JComboBox<>();

	// tablesv
	private DefaultTableModel dm;
	private JTable tbl1;
	int stt = 0;
	JScrollPane sc;
	// tablelop
	private DefaultTableModel dm2;
	private JTable tbl2;
	JScrollPane sc2;
	// tablemonhoc
	private DefaultTableModel dm3;
	private JTable tbl3;
	JScrollPane sc3;
	// tablediem
	private DefaultTableModel dm4;
	private JTable tbl4;
	JScrollPane sc4;
	// tablethongke
	private DefaultTableModel dm5;
	private JTable tbl5;
	JScrollPane sc5;
	// tablethongke2
	private DefaultTableModel dm7;
	private JTable tbl7;
	JScrollPane sc7;

	private DefaultTableModel dm6;
	private JTable tbl6;
	JScrollPane sc6;

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
		// chonLopSinhVien();

		chonLopSinhVienPrint();

	}

	public void addLayout() {
		con = getContentPane();

		JPanel cardLayout = new JPanel();
		cardLayout.setLayout(new CardLayout());

		pnBorder = new JPanel();
		pnBorder.setLayout(new BorderLayout());

		JPanel pnWest = new JPanel();
		pnWest.setLayout(new BoxLayout(pnWest, BoxLayout.Y_AXIS));
		pnWest.add(btnQuanLySinhVien);
		pnWest.add(btnQuanLyLopHoc);
		pnWest.add(btnQuanLyMonHoc);
		pnWest.add(btnMonHocTungLop);
		pnWest.add(btnQuanLyDiem);
		pnWest.add(btnThongKe);
		pnBorder.add(pnWest, BorderLayout.WEST);

		// Layout Quản Lý SV
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
		chonLop = new JLabel("XEM LỚP");

		JLabel timKiem = new JLabel("TÌM KIẾM");
		flowSeach.add(chonLop);
		flowSeach.add(cboLop2);
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

		maSinhVien = new JLabel("MÃ SINH VIÊN");
		maSinhVien.setPreferredSize(new Dimension(100, 50));
		tenSinhVien = new JLabel("TÊN SINH VIÊN");
		tenSinhVien.setPreferredSize(new Dimension(100, 50));
		ngaySinh = new JLabel("NGÀY SINH");
		ngaySinh.setPreferredSize(new Dimension(100, 50));
		diaChi = new JLabel("ĐỊA CHỈ");
		diaChi.setPreferredSize(new Dimension(100, 50));
		email = new JLabel("EMAIL");
		email.setPreferredSize(new Dimension(100, 50));
		sDT = new JLabel("SỐ ĐIỆN THOẠI");
		sDT.setPreferredSize(new Dimension(100, 50));

		chonLop = new JLabel("CHỌN LỚP");
		// chonLop.setPreferredSize(new Dimension(100,50));

		chonPhuong = new JLabel("CHỌN PHƯỜNG");
		chonPhuong.setPreferredSize(new Dimension(100, 50));

		chonQuan = new JLabel("CHỌN QUẬN");
		chonQuan.setPreferredSize(new Dimension(100, 50));

		chonTinh = new JLabel("CHỌN TỈNH");
		chonTinh.setPreferredSize(new Dimension(100, 50));
		cboPhuong.setPreferredSize(new Dimension(225, 20));
		cboQuan.setPreferredSize(new Dimension(225, 20));
		cboTinh.setPreferredSize(new Dimension(225, 20));

		JPanel pnBox = new JPanel();
		pnBox.setLayout(new BoxLayout(pnBox, BoxLayout.Y_AXIS));

		pnMTD = new JPanel();
		pnMTD.setLayout(new FlowLayout());
		pnMTD.setBackground(Color.PINK);

		pnMTD.add(maSinhVien);
		pnMTD.add(nhapMaSinhVien);
		pnMTD.add(tenSinhVien);
		pnMTD.add(nhapTenSinhVien);
		pnMTD.add(ngaySinh);
		pnMTD.add(nhapNgaySinh);

		pnESL = new JPanel();
		pnESL.setLayout(new FlowLayout());
		pnESL.setBackground(Color.pink);

		pnESL.add(diaChi);
		pnESL.add(nhapDiaChi);

		pnESL.add(email);
		pnESL.add(nhapEmail);

		pnESL.add(sDT);
		pnESL.add(nhapSDT);

		pnJcombobox = new JPanel();
		pnJcombobox.setLayout(new FlowLayout());
		pnJcombobox.setBackground(Color.PINK);

		pnJcombobox.add(chonTinh);
		pnJcombobox.add(cboTinh);

		pnJcombobox.add(chonQuan);
		pnJcombobox.add(cboQuan);

		pnJcombobox.add(chonPhuong);
		pnJcombobox.add(cboPhuong);

		pnBox.add(pnMTD);
		pnBox.add(pnESL);
		pnBox.add(pnJcombobox);

		pnSouth.add(pnBox);

		pnCRUD = new JPanel();
		pnCRUD.setLayout(new FlowLayout());

		pnCRUD.add(them);
		pnCRUD.add(sua);
		pnCRUD.add(xoa);
		pnCRUD.add(refreshSV);

		pnSouth.add(pnCRUD);

		pnSouth.setBackground(Color.PINK);
		pnQuanLySinhVien.add(pnSouth, BorderLayout.SOUTH);

		JPanel pnCenter = new JPanel();
		pnCenter.setBackground(Color.WHITE);
		pnCenter.setLayout(new BorderLayout());

		Border bor2 = BorderFactory.createEtchedBorder(Color.BLUE, Color.RED);
		TitledBorder titlebor2 = new TitledBorder(bor2, "THÔNG TIN SINH VIÊN:");
		pnCenter.setBorder(titlebor2);

		dm = new DefaultTableModel();
		tbl1 = new JTable(dm);
		dm.addColumn("Mã ");
		dm.addColumn("Tên");
		dm.addColumn("Ngày sinh");
		dm.addColumn("Địa chỉ");
		dm.addColumn("Email");
		dm.addColumn("SĐT");
		dm.addColumn("Lớp");
		dm.addColumn("Xã");
		dm.addColumn("Huyện");
		dm.addColumn("Tỉnh");
		sc = new JScrollPane(tbl1);

		pnCenter.add(sc);
		pnQuanLySinhVien.add(pnCenter);
		// Layout Quản Lý MonHoc
		pnQuanLyMonHoc = new JPanel();
		pnQuanLyMonHoc.setLayout(new BorderLayout());

		JPanel pnCenter1 = new JPanel();
		pnCenter1.setBackground(Color.WHITE);
		pnCenter1.setLayout(new BorderLayout());

		Border bor4 = BorderFactory.createEtchedBorder(Color.BLUE, Color.RED);
		TitledBorder titlebor4 = new TitledBorder(bor4, "THÔNG TIN MÔN HỌC:");
		pnCenter1.setBorder(titlebor4);

		dm2 = new DefaultTableModel();
		tbl2 = new JTable(dm2);
		dm2.addColumn("MÃ MÔN HỌC");
		dm2.addColumn("TÊN MÔN HỌC");
		dm2.addColumn("SỐ TÍN CHỈ");
		dm2.addColumn("THỜI GIAN HỌC");
		sc2 = new JScrollPane(tbl2);

		JPanel pnSouth1 = new JPanel();
		pnSouth1.setLayout(new BoxLayout(pnSouth1, BoxLayout.Y_AXIS));

		Border bor5 = BorderFactory.createMatteBorder(1, 1, 5, 5, Color.pink);
		TitledBorder titlebor5 = new TitledBorder(bor5, "THÊM THÔNG TIN MÔN HỌC:");
		pnSouth1.setBorder(titlebor5);

		JPanel pnMSTT = new JPanel();
		pnMSTT.setLayout(new BoxLayout(pnMSTT, BoxLayout.Y_AXIS));

		pnMaSo = new JPanel();
		pnMaSo.setLayout(new FlowLayout());
		pnMaSo.setBackground(Color.PINK);

		maMonHoc = new JLabel("MÃ MÔN HỌC");
		maMonHoc.setPreferredSize(new Dimension(100, 50));
		tenMonHoc = new JLabel("TÊN MÔN HỌC");
		tenMonHoc.setPreferredSize(new Dimension(100, 50));
		pnMaSo.add(maMonHoc);
		pnMaSo.add(nhapMaMonHoc);
		pnMaSo.add(tenMonHoc);
		pnMaSo.add(nhapTenMonHoc);

		pnThoiTen = new JPanel();
		pnThoiTen.setLayout(new FlowLayout());
		pnThoiTen.setBackground(Color.PINK);

		soTinChi = new JLabel("SỐ TÍN CHỈ");
		soTinChi.setPreferredSize(new Dimension(100, 50));
		thoiLuongHoc = new JLabel("THỜI GIAN HỌC");
		thoiLuongHoc.setPreferredSize(new Dimension(100, 50));
		pnThoiTen.add(soTinChi);
		pnThoiTen.add(nhapSoTinChi);
		pnThoiTen.add(thoiLuongHoc);
		pnThoiTen.add(nhapThoiLuongHoc);

		pnCRUDMonHoc = new JPanel();
		pnCRUDMonHoc.setLayout(new FlowLayout());
		pnCRUDMonHoc.setBackground(Color.white);
		pnCRUDMonHoc.add(themMonHoc);
		pnCRUDMonHoc.add(suaMonHoc);
		pnCRUDMonHoc.add(xoaMonHoc);
		pnCRUDMonHoc.add(refreshMonHoc);

		pnMSTT.add(pnMaSo);
		pnMSTT.add(pnThoiTen);
		pnSouth1.add(pnMSTT);
		pnSouth1.add(pnCRUDMonHoc);

		pnQuanLyMonHoc.add(pnSouth1, BorderLayout.SOUTH);
		pnCenter1.add(sc2);
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

		dm3 = new DefaultTableModel();
		tbl3 = new JTable(dm3);
		dm3.addColumn("LỚP ");
		dm3.addColumn("MÔ TẢ");
		dm3.addColumn("NĂM HỌC");
		sc3 = new JScrollPane(tbl3);

		JPanel pnSouth2 = new JPanel();
		pnSouth2.setLayout(new BoxLayout(pnSouth2, BoxLayout.Y_AXIS));

		Border bor7 = BorderFactory.createMatteBorder(1, 1, 5, 5, Color.PINK);
		TitledBorder titlebor7 = new TitledBorder(bor7, "THÊM THÔNG TIN LỚP HỌC:");
		pnSouth2.setBorder(titlebor7);
		// pnSouth2.add(pnLop);
		maLop = new JLabel("LỚP HỌC");
		maLop.setPreferredSize(new Dimension(70, 100));
		moTa = new JLabel("MÔ TẢ");
		moTa.setPreferredSize(new Dimension(70, 100));

		JPanel pnLop1 = new JPanel();
		pnLop1.setBackground(Color.pink);
		chonNam = new JLabel("CHỌN NĂM");
		pnLop1.add(chonNam);
		cboLop1.addItem("TẤT CẢ");
		cboLop1.addItem("2018");
		cboLop1.addItem("2017");
		cboLop1.addItem("2016");
		cboLop1.addItem("2015");
		cboLop1.addItem("2014");
		pnLop1.add(cboLop1);
		pnSouth2.add(pnLop1);

		pnTMN = new JPanel();
		pnTMN.setLayout(new FlowLayout());
		pnTMN.setBackground(Color.PINK);

		pnTMN.add(maLop);
		pnTMN.add(nhapMaLop);
		pnTMN.add(moTa);
		pnTMN.add(nhapMoTa);

		pnCRUDL = new JPanel();
		pnCRUDL.setLayout(new FlowLayout());
		pnCRUDL.setBackground(Color.WHITE);
		pnCRUDL.add(themL);
		pnCRUDL.add(suaL);
		pnCRUDL.add(xoaL);
		pnCRUDL.add(refreshLop);

		pnSouth2.add(pnTMN);
		pnSouth2.add(pnCRUDL);
		pnCenter2.add(sc3);
		pnQuanLyLopHoc.add(pnCenter2);
		pnQuanLyLopHoc.add(pnSouth2, BorderLayout.SOUTH);

		// layoutquanlydiem
		pnQuanLyDiem = new JPanel();
		pnQuanLyDiem.setLayout(new BorderLayout());

		JPanel pnCenter4 = new JPanel();
		pnCenter4.setBackground(Color.WHITE);
		pnCenter4.setLayout(new BorderLayout());

		Border bor8 = BorderFactory.createEtchedBorder(Color.BLUE, Color.RED);
		TitledBorder titlebor8 = new TitledBorder(bor8, "ĐIỂM SINH VIÊN");
		pnCenter4.setBorder(titlebor8);

		dm4 = new DefaultTableModel();
		tbl4 = new JTable(dm4);
		dm4.addColumn("LỚP");
		dm4.addColumn("MÃ SINH VIÊN");
		dm4.addColumn("MÃ MÔN HỌC");
		dm4.addColumn("ĐIỂM");
		sc4 = new JScrollPane(tbl4);

		JPanel pnSouth4 = new JPanel();
		pnSouth4.setLayout(new BoxLayout(pnSouth4, BoxLayout.Y_AXIS));

		Border bor9 = BorderFactory.createMatteBorder(1, 1, 5, 5, Color.pink);
		TitledBorder titlebor9 = new TitledBorder(bor9, "THÊM ĐIỂM SINH VIÊN");
		pnSouth4.setBorder(titlebor9);

		JPanel boxlayoutY = new JPanel();
		boxlayoutY.setLayout(new BoxLayout(boxlayoutY, BoxLayout.Y_AXIS));

		JPanel pnfolow = new JPanel();
		pnfolow.setLayout(new FlowLayout());
		pnfolow.setBackground(Color.PINK);
		diem = new JLabel("NHẬP ĐIỂM");
		maLopHocDiem1 = new JLabel("CHỌN LỚP");
		maMonHocDiem1 = new JLabel("CHỌN MÔN HỌC");
		maSinhVien1 = new JLabel("CHỌN MÃ SINH VIÊN");
		pnfolow.add(maLopHocDiem1);
		pnfolow.add(maLopHocDiem);
		pnfolow.add(maMonHocDiem1);
		pnfolow.add(maMonHocDiem);
		pnfolow.add(maSinhVien1);
		pnfolow.add(maSinhVienDiem);
		pnfolow.add(diem);
		pnfolow.add(nhapDiem);

		JPanel pnfolowCRUD = new JPanel();
		pnfolowCRUD.setLayout(new FlowLayout());
		pnfolowCRUD.setBackground(Color.white);
		pnfolowCRUD.add(themDiem);
		pnfolowCRUD.add(suaDiem);
		pnfolowCRUD.add(xoaDiem);

		boxlayoutY.add(pnfolow);
		boxlayoutY.add(pnfolowCRUD);

		pnSouth4.add(boxlayoutY);

		pnQuanLyDiem.add(pnSouth4, BorderLayout.SOUTH);
		pnCenter4.add(sc4);
		pnQuanLyDiem.add(pnCenter4);

		// LayoutThongKe
		pnThongKe = new JPanel();
		pnThongKe.setLayout(new BoxLayout(pnThongKe, BoxLayout.Y_AXIS));
		JPanel pnFolowThongKe = new JPanel();
		pnFolowThongKe.setLayout(new FlowLayout());
		pnFolowThongKe.setBackground(Color.PINK);
		thongKeSinhVien= new JComboBox();
		pnFolowThongKe.add(thongKeSinhVien);
		
		pnThongKe.add(pnFolowThongKe);
		

		

		JPanel pnNorthThongKe = new JPanel();
		pnNorthThongKe.setLayout(new BorderLayout());

		Border bor15 = BorderFactory.createEtchedBorder(Color.BLUE, Color.RED);
		TitledBorder titlebor15 = new TitledBorder(bor15, "THỐNG KÊ BÁO CÁO SỐ LƯỢNG SINH VIÊN");
		pnNorthThongKe.setBorder(titlebor15);
		dm7 = new DefaultTableModel();
		tbl7 = new JTable(dm7);
		dm7.addColumn("MÃ LỚP");
		dm7.addColumn("MÔ TẢ");
		dm7.addColumn("SỐ LƯỢNG SINH VIÊN");

		sc7 = new JScrollPane(tbl7);

		pnNorthThongKe.add(sc7);
		pnThongKe.add(pnNorthThongKe, BorderLayout.NORTH);

		JPanel pnCenter5 = new JPanel();
		pnCenter5.setBackground(Color.WHITE);
		pnCenter5.setLayout(new BorderLayout());

		Border bor10 = BorderFactory.createEtchedBorder(Color.BLUE, Color.RED);
		TitledBorder titlebor10 = new TitledBorder(bor10, "THỐNG KÊ BÁO CÁO ĐIỂM SINH VIÊN");
		pnCenter5.setBorder(titlebor10);

		dm5 = new DefaultTableModel();
		tbl5 = new JTable(dm5);
		dm5.addColumn("LP#0");
		dm5.addColumn("LP#1");
		dm5.addColumn("LP#2");
		dm5.addColumn("LP#3");
		dm5.addColumn("LP#4");
		dm5.addColumn("LP#5");
		dm5.addColumn("LP#6");
		dm5.addColumn("E4IT");
		dm5.addColumn("AVG");
		dm5.addColumn("XẾP LOẠI");
		sc5 = new JScrollPane(tbl5);

		JPanel pnSouth5 = new JPanel();
		pnSouth5.setLayout(new BoxLayout(pnSouth5, BoxLayout.Y_AXIS));

		Border bor11 = BorderFactory.createMatteBorder(1, 1, 5, 5, Color.pink);
		TitledBorder titlebor11 = new TitledBorder(bor11, "CHỌN LỚP VÀ CHON NĂM CẦN XEM ĐIỂM");
		pnSouth5.setBorder(titlebor11);

		JPanel pnfolowThongKe = new JPanel();
		pnfolowThongKe.setLayout(new FlowLayout());
		pnfolowThongKe.setBackground(Color.PINK);
		JLabel chonLopThongKe = new JLabel("CHỌN LỚP");
		JLabel chonNamThongKe = new JLabel("CHỌN NĂM");
		pnfolowThongKe.add(chonLopThongKe);
		pnfolowThongKe.add(cbochonLop);
		pnfolowThongKe.add(chonNamThongKe);
		pnfolowThongKe.add(cbochonNamThongKe);
		pnSouth5.add(pnfolowThongKe);

		pnThongKe.add(pnSouth5, BorderLayout.SOUTH);
		pnCenter5.add(sc5);
	
		pnThongKe.add(pnCenter5);
		// layoutmonhoccualop

		pnMonHocCuaLop = new JPanel();
		pnMonHocCuaLop.setLayout(new BorderLayout());
		JPanel pnCenter6 = new JPanel();
		pnCenter6.setBackground(Color.WHITE);
		pnCenter6.setLayout(new BorderLayout());

		Border bor12 = BorderFactory.createEtchedBorder(Color.BLUE, Color.RED);
		TitledBorder titlebor12 = new TitledBorder(bor12, "MÔN HỌC CỦA TỪNG LỚP");
		pnCenter6.setBorder(titlebor12);

		dm6 = new DefaultTableModel();
		tbl6 = new JTable(dm6);
		dm6.addColumn("LỚP");
		dm6.addColumn("MÃ MÔN HỌC");
		dm6.addColumn("TÊN MÔN HỌC");
		sc6 = new JScrollPane(tbl6);

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
		pnCenter6.add(sc6);
		pnMonHocCuaLop.add(pnCenter6);

		cardLayout.add(pnQuanLySinhVien);
		cardLayout.add(pnQuanLyDiem);
		cardLayout.add(pnQuanLyMonHoc);
		cardLayout.add(pnQuanLyLopHoc);
		cardLayout.add(pnThongKe);
		cardLayout.add(pnMonHocCuaLop);

		pnBorder.add(cardLayout);

		getContentPane().add(pnBorder);
		con.add(pnBorder);

		// connect data SinhVien
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
			dm.addRow(row);
		}
		// connect Lop
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
			dm3.addRow(row);
		}
		// connect Mon hoc
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
			dm2.addRow(row);
		}
		// connect Diem

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
			dm4.addRow(row);
		}
		// connect môn học từng lớp

		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM MonHocCuaTungLop");
			while (result.next()) {
				arrMonHocCuaTungLop.add(new MonHocCuaTungLop(result.getString("Lop"), result.getString("MaMonHoc"),
						result.getString("TenMonHoc")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (MonHocCuaTungLop x : arrMonHocCuaTungLop) {
			String[] row = { x.getLopMonHocCuaTungLop(), x.getMaMonHocCuaTungLop(), x.getTenMonHocCuaTungLop() };
			dm6.addRow(row);
		}
	}
	// kiem tra

	// select devvn_tinhthanhpho
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
	// select lop

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

	// select lop của dienn

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

	// select lop của sinh vien print
	public void chonLopSinhVienPrint() {

		Connection conn = ConnectData.getConnect("localhost", "QuanLySinhVien", "QuanLySinhVien", "QuanLySinhVien");
		cboLop2.addItem("TẤT CẢ");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("select * from Lop");
			while (result.next()) {
				cboLopPrint.addItem(result.getString("MaLop"));
				cboLop2.addItem(result.getString("MaLop"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// select lop của masinhvien

	// public void chonLopSinhVien() {
	// Connection conn = ConnectData.getConnect("localhost", "QuanLySinhVien",
	// "QuanLySinhVien", "QuanLySinhVien");
	// cboLop.addItem("TẤT CẢ");
	//
	// try {
	// Statement statement = conn.createStatement();
	// ResultSet result = statement.executeQuery("select * from Lop");
	// while (result.next()) {
	// cboLop.addItem(result.getString("MaLop"));
	//
	//
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }

	// select ma sinh vie
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
	// select ma mon hoc

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
	// select devvn_quanhuyen

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

	// select devvn_xaphuongthitran
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

	public void setLop() {
		System.out.println("hieu");
		String chonLop = (String) cboLop2.getSelectedItem();
		dm.setRowCount(0);
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
				dm.addRow(row);
			}

			 } else {
			 Connection conn = ConnectData.getConnect("localhost", "QuanLySinhVien",
			 "QuanLySinhVien", "QuanLySinhVien");
			 try {
			
			 Statement statement = conn.createStatement();
			 ResultSet result = statement.executeQuery("SELECT * FROM SinhVien WHERE Lop='" + chonLop + "'");
				arrSV.clear();

			 while (result.next()) {
			 arrSV.add(new ThongTinSinhVien(result.getString("MaSV"),
			 result.getString("TenSinhVien"),
			 result.getString("NgaySinh"), result.getString("DiaChi"),
			 result.getString("Email"),
			 result.getString("SDT"), result.getString("Lop"), result.getString("Phuong"),
			 result.getString("Quan"), result.getString("Tinh")));
			 }
			 } catch (Exception e) {
			 e.printStackTrace();
			 }
			 dm.setRowCount(0);
			 for (ThongTinSinhVien x : arrSV) {
			 String[] row = { x.getMaSV(), x.getTenSV(), x.getNgaySinh(), x.getDiaChi(),
			 x.getEmail(), x.getsDT(),
			 x.getLop(), x.getPhuong(), x.getQuan(), x.getTinh() };
			 dm.addRow(row);
			 }
			
		}

	}

	public void setNam() {
		String chonNam = (String) cboLop1.getSelectedItem();
		dm3.setRowCount(0);
		if (chonNam == "TẤT CẢ") {

			for (Lop x : arrLop) {
				String[] row = { x.getMaLop(), x.getMoTa(), x.getNam() };
				dm3.addRow(row);
			}

		} else {
			for (Lop x : arrLop) {
				if (chonNam.equals(x.getNam())) {
					String[] row = { x.getMaLop(), x.getMoTa(), x.getNam() };
					dm3.addRow(row);
				}
			}
		}
	}

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

	// quanlyyevent
	public void addEvent() {
		// event sv
		cboTinh.addActionListener(eventChooseQuan);
		cboQuan.addActionListener(eventChoosePhuong);
		btnQuanLyLopHoc.addActionListener(eventQuanLyLopHoc);
		btnQuanLyMonHoc.addActionListener(eventQuanLyMonHoc);
		btnQuanLySinhVien.addActionListener(eventQuanLySinhVien);
		btnQuanLyDiem.addActionListener(eventQuanLyDiem);
		btnThongKe.addActionListener(eventThongKe);
		btnMonHocTungLop.addActionListener(eventMonHocCuaLop);
		them.addActionListener(eventAdd);
		xoa.addActionListener(eventDel);
		sua.addActionListener(eventEdit);
		tbl1.addMouseListener(eventTable);
		cboLop2.addActionListener(eventchooseLop);
		cboLopPrint.addActionListener(eventchooseLopPrint);
		refreshSV.addActionListener(eventrefreshSV);
		// eventlop
		cboLop1.addActionListener(eventchooseNam);
		refreshLop.addActionListener(eventrefreshLop);
		themL.addActionListener(eventAddLop);
		xoaL.addActionListener(eventDelLop);
		suaL.addActionListener(eventEditLop);
		tbl3.addMouseListener(eventTableLop);
		// eventmonhoc
		refreshMonHoc.addActionListener(eventRefreshMonHoc);
		themMonHoc.addActionListener(eventAddMonHoc);
		suaMonHoc.addActionListener(eventEditMonHoc);
		xoaMonHoc.addActionListener(eventDelMonHoc);
		tbl2.addMouseListener(eventTableMonHoc);
		// eventthongke
		// tìm kiếm
		btnTimKiem.addActionListener(eventTimKiem);
		// eventmonhoccuatunglop
		themMonHocCuaLop.addActionListener(eventThemMonHocCuaTungLop);
		xoaMonHocCuaLop.addActionListener(eventXoaMonHocCuaTungLop);
		// eventtablemoncuatunglop
		tbl6.addMouseListener(eventTableMonHocCuaTungLop);
		// event diem
		maLopHocDiem.addActionListener(eventChonMaSinhVien);
		themDiem.addActionListener(eventThemDiem);
		xoaDiem.addActionListener(eventXoaDiem);
		suaDiem.addActionListener(eventsuaDiem);
		tbl4.addMouseListener(eventTableDiem);

	}

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

			dm4.setRowCount(0);
			for (Diem x : arrDiem) {
				String[] row = { x.getMaLop(), x.getMaSinhVien(), x.getMaMonHoc(), x.getDiem() };
				dm4.addRow(row);

			}

		}
	};

	// table diem
	MouseAdapter eventTableDiem = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int row = tbl4.getSelectedRow();
			String[] col = new String[4];
			col[0] = (String) tbl4.getValueAt(row, 0);
			col[1] = (String) tbl4.getValueAt(row, 1);
			col[2] = (String) tbl4.getValueAt(row, 2);
			col[3] = (String) tbl4.getValueAt(row, 3);

			maLopHocDiem.setSelectedItem(col[0]);
			maSinhVienDiem.setSelectedItem(col[1]);
			maMonHocDiem.setSelectedItem(col[2]);
			nhapDiem.setText(col[3]);

		}
	};

	// event xoa diem
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
			dm4.setRowCount(0);
			for (Diem x : arrDiem) {
				String[] row = { x.getMaLop(), x.getMaSinhVien(), x.getMaMonHoc(), x.getDiem() };
				dm4.addRow(row);
			}

		}
	};
	ActionListener eventThemDiem = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			int KT1 = 0;
			String chonLopHocDiem = (String) maLopHocDiem.getSelectedItem();
			String chonMonHocDiem = (String) maMonHocDiem.getSelectedItem();
			String chonMaSinhVienDiem = (String) maSinhVienDiem.getSelectedItem();
			String nhapDiem1 = nhapDiem.getText();
			Connection conn = ConnectData.getConnect("localhost", "QuanLySinhVien", "QuanLySinhVien", "QuanLySinhVien");
			for (Diem x : arrDiem) {
				if (chonLopHocDiem.equals(x.getMaLop()) && chonMonHocDiem.equals(x.getMaMonHoc())
						&& chonMaSinhVienDiem.equals(x.getMaSinhVien())) {
					KT1 = 2;
					break;
				}
			}
			try {
				if (nhapDiem1.isEmpty()) {
					JOptionPane.showMessageDialog(null, "XIN HÃY NHẬP ĐẦY ĐỦ THÔNG TIN!", null,
							JOptionPane.WARNING_MESSAGE);
				} else if (KT1 > 0) {
					JOptionPane.showMessageDialog(null, "ĐIỂM CỦA MÔN HỌC ĐÃ TỒN TẠI!", null,
							JOptionPane.WARNING_MESSAGE);
					nhapDiem.setText("");

				} else {
					arrDiem.add(new Diem(chonLopHocDiem, chonMaSinhVienDiem, chonMonHocDiem, nhapDiem1));
					dm4.addRow(new String[] { chonLopHocDiem, chonMaSinhVienDiem, chonMonHocDiem, nhapDiem1 });
					try {
						String sql = "INSERT INTO Diem(MaMonHoc, MaLop, MaSV, Diem) VALUES (" + "'" + chonMonHocDiem
								+ "','" + chonLopHocDiem + "','" + chonMaSinhVienDiem + "','" + nhapDiem1 + "')";
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
			} catch (Exception ex) {
			}

			dm4.setRowCount(0);
			for (Diem x : arrDiem) {
				String[] row = { x.getMaLop(), x.getMaSinhVien(), x.getMaMonHoc(), x.getDiem() };
				dm4.addRow(row);
			}

		}
	};
	ActionListener eventChonMaSinhVien = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			chonMon();

		}
	};

	MouseAdapter eventTableMonHocCuaTungLop = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int row = tbl6.getSelectedRow();
			String[] col = new String[2];
			col[0] = (String) tbl6.getValueAt(row, 0);
			col[1] = (String) tbl6.getValueAt(row, 1);
			cboChonLopMonHoc.setSelectedItem(col[0]);
			cboChonMaMonHoc.setSelectedItem(col[1]);

		}
	};

	ActionListener eventXoaMonHocCuaTungLop = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			for (MonHocCuaTungLop x : arrMonHocCuaTungLop) {

				if (((String) cboChonLopMonHoc.getSelectedItem()).equals(x.getLopMonHocCuaTungLop())) {
					if (((String) cboChonMaMonHoc.getSelectedItem()).equals(x.getMaMonHocCuaTungLop())) {
						arrMonHocCuaTungLop.remove(x);
					}
					break;
				}
			}
			Connection conn = ConnectData.getConnect("localhost", "QuanLySinhVien", "QuanLySinhVien", "QuanLySinhVien");
			try {
				String sql = "DELETE  FROM MonHocCuaTungLop WHERE Lop = '" + (String) cboChonLopMonHoc.getSelectedItem()
						+ "' AND MaMonHoc ='" + (String) cboChonMaMonHoc.getSelectedItem() + "'";
				System.out.println(sql);
				Statement statement = conn.createStatement();
				int x = statement.executeUpdate(sql);
				if (x > 0) {
					JOptionPane.showMessageDialog(null, "XÓA THÀNH CÔNG");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			dm6.setRowCount(0);
			for (MonHocCuaTungLop x : arrMonHocCuaTungLop) {
				String[] row = { x.getLopMonHocCuaTungLop(), x.getMaMonHocCuaTungLop(), x.getTenMonHocCuaTungLop() };
				dm6.addRow(row);
			}
		}
	};

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
					dm6.addRow(new String[] { result.getString("MaLop"), result.getString("MaMonHoc"),
							result.getString("TenMonHoc") });
					String sql = "INSERT INTO MonHocCuaTungLop(Lop, MaMonHoc,TenMonHoc) VALUES (" + "'"
							+ result.getString("MaLop") + "','" + result.getString("MaMonHoc") + "','"
							+ result.getString("TenMonHoc") + "')";
					statement.executeUpdate(sql);
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}

			dm6.setRowCount(0);
			for (MonHocCuaTungLop x : arrMonHocCuaTungLop) {
				String[] row = { x.getLopMonHocCuaTungLop(), x.getMaMonHocCuaTungLop(), x.getTenMonHocCuaTungLop() };
				dm6.addRow(row);
			}
		}
	};

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
					dm.setRowCount(0);
					String[] row = { x.getMaSV(), x.getTenSV(), x.getNgaySinh(), x.getDiaChi(), x.getEmail(),
							x.getsDT(), x.getLop(), x.getPhuong(), x.getQuan(), x.getTinh() };
					dm.addRow(row);
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

	// buttonmonhoccualop
	ActionListener eventMonHocCuaLop = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			pnQuanLyLopHoc.setVisible(false);
			pnQuanLySinhVien.setVisible(false);
			pnQuanLyMonHoc.setVisible(false);
			pnQuanLyDiem.setVisible(false);
			pnThongKe.setVisible(false);
			pnMonHocCuaLop.setVisible(true);

			cboChonLopMonHoc.removeAllItems();
			chonLop();

		}
	};
	// button thong ke
	ActionListener eventThongKe = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			pnQuanLyLopHoc.setVisible(false);
			pnQuanLySinhVien.setVisible(false);
			pnQuanLyMonHoc.setVisible(false);
			pnQuanLyDiem.setVisible(false);
			pnMonHocCuaLop.setVisible(false);
			pnThongKe.setVisible(true);
		}
	};

	ActionListener eventQuanLyDiem = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			pnQuanLyLopHoc.setVisible(false);
			pnQuanLySinhVien.setVisible(false);
			pnQuanLyMonHoc.setVisible(false);
			pnThongKe.setVisible(false);
			pnQuanLyDiem.setVisible(true);
			pnMonHocCuaLop.setVisible(false);
			maLopHocDiem.removeAllItems();
			chonLopDiem();
			chonMaSinhVien();
			chonMon();

		}
	};
	// suamonhoc

	ActionListener eventEditMonHoc = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			int ktTonTai = 0;
			int kt = 0;

			String maMonHoc = nhapMaMonHoc.getText();
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

			dm2.setRowCount(0);
			for (MonHoc x : arrMonHoc) {
				String tinChi = String.valueOf(x.getTinChi());
				String[] row = { x.getMaMonHoc(), x.getTenMonHoc(), tinChi, x.getThoiGian() };
				dm2.addRow(row);
			}

		}
	};
	// xoamonhoc
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
			dm2.setRowCount(0);
			for (MonHoc x : arrMonHoc) {
				String tinChi = String.valueOf(x.getTinChi());
				String[] row = { x.getMaMonHoc(), x.getTenMonHoc(), tinChi, x.getThoiGian() };
				dm2.addRow(row);
			}

		}
	};
	// tablemonhoc
	MouseAdapter eventTableMonHoc = new MouseAdapter() {

		@Override
		public void mouseClicked(java.awt.event.MouseEvent e) {
			int row = tbl2.getSelectedRow();
			String[] col = new String[4];
			col[0] = (String) tbl2.getValueAt(row, 0);
			col[1] = (String) tbl2.getValueAt(row, 1);
			col[2] = (String) tbl2.getValueAt(row, 2);
			col[3] = (String) tbl2.getValueAt(row, 3);

			nhapMaMonHoc.setText(col[0]);
			nhapTenMonHoc.setText(col[1]);
			nhapSoTinChi.setText(col[2]);
			nhapThoiLuongHoc.setText(col[3]);

		}
	};
	// event refesh
	ActionListener eventRefreshMonHoc = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			nhapMaMonHoc.setText("");
			nhapTenMonHoc.setText("");
			nhapThoiLuongHoc.setText("");
			nhapSoTinChi.setText("");

		}
	};
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
					dm2.addRow(new String[] { maMonHoc, tenMonHoc, soTinChi, thoiLuongHoc });
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

			dm2.setRowCount(0);
			for (MonHoc x : arrMonHoc) {
				String tinChi = String.valueOf(x.getTinChi());
				String[] row = { x.getMaMonHoc(), x.getTenMonHoc(), tinChi, x.getThoiGian() };
				dm2.addRow(row);
			}

		}
	};

	// event add lop
	ActionListener eventAddLop = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			int kt = 0;
			String lop = nhapMaLop.getText();
			String mota = nhapMoTa.getText();
			String chonNam = (String) cboLop1.getSelectedItem();
			for (Lop x : arrLop) {
				if (nhapMaLop.getText().equals(x.getMaLop()) && mota.equals(x.getMoTa())
						&& chonNam.equals(x.getNam())) {
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
					dm3.addRow(new String[] { lop, mota, chonNam });
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
			dm3.setRowCount(0);
			for (Lop x : arrLop) {
				String[] row = { x.getMaLop(), x.getMoTa(), x.getNam() };
				dm3.addRow(row);
				setNam();
			}
		}
	};

	// event sua lop
	ActionListener eventEditLop = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			int ktTonTai = 0;
			int kt = 0;
			String lop = nhapMaLop.getText();
			String mota = nhapMoTa.getText();
			String chonNam = (String) cboLop1.getSelectedItem();
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
					x.setNam((String) cboLop1.getSelectedItem());
					break;
				}
			}
			try {
				if (nhapMaLop.getText().equals("") || nhapMoTa.getText().equals("")
						|| cboLop1.getSelectedItem().equals("")) {
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
								+ "',Nam ='" + cboLop1.getSelectedItem() + "' WHERE MaLop = '" + nhapMaLop.getText()
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
				dm3.addRow(row);
				setNam();

			}

		}
	};

	ActionListener eventchooseNam = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			setNam();

		}

	};
	// event refresh LOP
	ActionListener eventrefreshLop = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			nhapMoTa.setText("");
			nhapMaLop.setText("");
			cboLop1.setSelectedItem("TẤT CẢ");

		}
	};
	// event refresh SInhvIEN
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

	// event Delete Lop
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
			dm3.setRowCount(0);
			for (Lop x : arrLop) {
				String[] row = { x.getMaLop(), x.getMoTa(), x.getNam() };
				dm3.addRow(row);
				setNam();

			}

		}

	};
	// eventchonlop
	ActionListener eventchooseLop = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			setLop();

		}
	};

	// event table lop
	MouseListener eventTableLop = new MouseListener() {

		@Override
		public void mouseClicked(java.awt.event.MouseEvent arg0) {
			int row = tbl3.getSelectedRow();
			String[] col = new String[3];
			col[0] = (String) tbl3.getValueAt(row, 0);
			col[1] = (String) tbl3.getValueAt(row, 1);
			col[2] = (String) tbl3.getValueAt(row, 2);

			nhapMaLop.setText(col[0]);
			nhapMoTa.setText(col[1]);
			cboLop1.setSelectedItem(col[2]);

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

	// event Layout LopHoc
	ActionListener eventQuanLyLopHoc = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			pnQuanLySinhVien.setVisible(false);
			pnQuanLyMonHoc.setVisible(false);
			pnQuanLyLopHoc.setVisible(true);
			pnQuanLyDiem.setVisible(false);
			pnThongKe.setVisible(false);
			pnMonHocCuaLop.setVisible(false);

		}
	};

	// event table
	MouseAdapter eventTable = new MouseAdapter() {

		@Override
		public void mouseClicked(java.awt.event.MouseEvent e) {
			int row = tbl1.getSelectedRow();
			String[] col = new String[10];
			col[0] = (String) tbl1.getValueAt(row, 0);
			col[1] = (String) tbl1.getValueAt(row, 1);
			col[2] = (String) tbl1.getValueAt(row, 2);
			col[3] = (String) tbl1.getValueAt(row, 3);
			col[4] = (String) tbl1.getValueAt(row, 4);
			col[5] = (String) tbl1.getValueAt(row, 5);
			col[6] = (String) tbl1.getValueAt(row, 6);
			col[7] = (String) tbl1.getValueAt(row, 7);
			col[8] = (String) tbl1.getValueAt(row, 8);
			col[9] = (String) tbl1.getValueAt(row, 9);

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

	// sua
	ActionListener eventEdit = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			int ktTonTai = 0;
			String ma = nhapMaSinhVien.getText();
			String ten = nhapTenSinhVien.getText();
			String ngaySinh = nhapNgaySinh.getText();
			String diaChi = nhapDiaChi.getText();
			String email = nhapEmail.getText();
			String sDT = nhapSDT.getText();
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
				nhapNgaySinh.setText("");
				nhapMaSinhVien.setText("");
				nhapTenSinhVien.setText("");
				nhapDiaChi.setText("");
				nhapEmail.setText("");
				nhapSDT.setText("");
			} else if (ktTonTai < 1) {
				JOptionPane.showMessageDialog(null, "MÃ SINH VIÊN KHÔNG ĐƯỢC SỮA,HÃY THÊM MỚI SINH VIÊN", null,
						JOptionPane.WARNING_MESSAGE);
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

			dm.setRowCount(0);
			for (ThongTinSinhVien x : arrSV) {

				String[] row = { x.getMaSV(), x.getTenSV(), x.getNgaySinh(), x.getDiaChi(), x.getEmail(), x.getsDT(),
						x.getLop(), x.getPhuong(), x.getQuan(), x.getTinh() };
				dm.addRow(row);
				setLop();

			}

		}

	};

	// xoa
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
					Statement statement = conn.createStatement();
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
			dm.setRowCount(0);
			for (ThongTinSinhVien x : arrSV) {
				String[] row = { x.getMaSV(), x.getTenSV(), x.getNgaySinh(), x.getDiaChi(), x.getEmail(), x.getsDT(),
						x.getLop(), x.getPhuong(), x.getQuan(), x.getTinh() };
				dm.addRow(row);
				setLop();
			}

		}
	};

	// them
	ActionListener eventAdd = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			int ktTonTai = 0;
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

			} else {

				dm.addRow(new String[] { ma, ten, ngaySinh, diaChi, email, sDT, chonLop, chonPhuong, chonQuan,
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

	// layout quanlydiem
	ActionListener eventQuanLyMonHoc = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			pnQuanLyLopHoc.setVisible(false);
			pnQuanLySinhVien.setVisible(false);
			pnQuanLyMonHoc.setVisible(true);
			pnQuanLyDiem.setVisible(false);
			pnThongKe.setVisible(false);
			pnMonHocCuaLop.setVisible(false);

		}

	};

	// layout quanlySinhVien
	ActionListener eventQuanLySinhVien = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			cboLopPrint.removeAllItems();
			cboLop2.removeAllItems();
			chonLopSinhVienPrint();

			pnQuanLyLopHoc.setVisible(false);
			pnQuanLySinhVien.setVisible(true);
			pnQuanLyMonHoc.setVisible(false);
			pnThongKe.setVisible(false);
			pnMonHocCuaLop.setVisible(false);
			pnQuanLyDiem.setVisible(false);

		}
	};
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

	public void showWindow() {
		this.setSize(1340, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

}
