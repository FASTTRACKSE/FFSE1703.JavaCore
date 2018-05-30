package project.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.prefs.BackingStoreException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import project.model.*;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.mysql.jdbc.Driver;
import project.model.LopHoc;
import project.model.ConnectDB.*;
import project.model.SinhVien;

public class Project_UI extends JFrame {
	Container con = new Container();
	Connection conn;
	JTabbedPane tabbed;
	JPanel lophocQL = new JPanel();
	JPanel sinhvienQL = new JPanel();
	JPanel monhocQL = new JPanel();
	JPanel thongke = new JPanel();
	JPanel nhapdiem = new JPanel();
	JPanel user = new JPanel();
	ArrayList<LopHoc> arrLH = new ArrayList<LopHoc>();
	ArrayList<SinhVien> arrSV = new ArrayList<SinhVien>();
	ArrayList<MonHoc> arrMH = new ArrayList<MonHoc>();
	ArrayList<BangDiem> arrBD = new ArrayList<BangDiem>();
	ArrayList<User> arrUS = new ArrayList<User>();
	ImageIcon sinhvienAnh = new ImageIcon(new ImageIcon("sinhvien.jpg").
			getImage().getScaledInstance(80,65,Image.SCALE_SMOOTH));
	ImageIcon lopAnh = new ImageIcon(new ImageIcon("Classroom.jpeg").
			getImage().getScaledInstance(80,65,Image.SCALE_SMOOTH));
	ImageIcon monhocAnh = new ImageIcon(new ImageIcon("monhoc.png").
			getImage().getScaledInstance(80,65,Image.SCALE_SMOOTH));
	ImageIcon diemsoAnh = new ImageIcon(new ImageIcon("diem.png").
			getImage().getScaledInstance(80,65,Image.SCALE_SMOOTH));
	ImageIcon thongkeAnh = new ImageIcon(new ImageIcon("thongke.png").
			getImage().getScaledInstance(80,65,Image.SCALE_SMOOTH));
	ImageIcon userAnh = new ImageIcon(new ImageIcon("user.png").
			getImage().getScaledInstance(80,65,Image.SCALE_SMOOTH));
	
	JPanel actionLH = new JPanel();
	JPanel settingLH = new JPanel();
	JPanel btnstLH = new JPanel();
	JPanel maLop, tenLop, namHoc, moTa;
	JTextField textmaLop, texttenLop, textnamHoc, textmoTa;
	JLabel titmaLop, tittenLop, titnamHoc, titmoTa;
	JButton themLop, suaLop, xoaLop, resetLop;
	JLabel tittleLH = new JLabel("Chương Trình Quản Lý Lớp Học");
	DefaultTableModel defTableLH = new DefaultTableModel();
	JTable tableLH = new JTable(defTableLH);
	JScrollPane scrPaneLH;
		
	JPanel maSV, tenSV, diachiSV, phuongSV, quanSV, thanhphoSV, sdtSV, emailSV, lopSV;
	JComboBox cboLop;
	JComboBox phuong;
	JComboBox quan;
	JComboBox thanhpho;
	JPanel svPN;
	JLabel svLB,tittimSV;
	JComboBox lopsvCBO;
	JButton themSV, suaSV, xoaSV, resetSV, timSV;
	JTextField textmaSV, texttenSV, textdiachiSV, textsdtSV, textemailSV, txttimSV;
	JLabel titmaSV, tittenSV, titdiachiSV, titphuongSV, titquanSV, 
	titthanhphoSV, titsdtSV, titemailSV, titlopSV;
	JLabel tittleSV = new JLabel("Chương Trình Quản Lý Sinh Viên");
	JPanel actionSV = new JPanel();
	JPanel settingSV = new JPanel();
	JPanel btnstSV = new JPanel();
	DefaultTableModel defTableSV = new DefaultTableModel();
	JTable tableSV = new JTable(defTableSV);
	JScrollPane scrPaneSV = new JScrollPane(tableSV);
	
	JLabel tittleMH,titmaMH,tittenMH,tittinchiMH,tittimeMH;
	JPanel tunglopMH,settingMH,btnstMH;
	JTextField txtmaMH,txttenMH,txttinchiMH,txttimeMH;
	JButton themMH,suaMH,xoaMH,resetMH;
	DefaultTableModel defTableMH = new DefaultTableModel();
	JTable tableMH = new JTable(defTableMH);
	JScrollPane scrPaneMH = new JScrollPane(tableMH);
	JPanel maMH,tenMH,tinchiMH,timeMH;
	
	JLabel titmalhTL,titmamhTL,tittenmhTL;
	JPanel malhTL,mamhTL,tenmhTL;
	JComboBox cbomalhTL,cbomamhTL;
	JTextField txttenmhTL;
	DefaultTableModel defTableTL = new DefaultTableModel();
	JTable tableTL = new JTable(defTableTL);
	JScrollPane srcPaneTL = new JScrollPane(tableTL);
	JButton themTL,suaTL,xoaTL;
	
	JLabel tittleND,titmasvND,titlopsvND,
	titLP0,titLP1,titLP2,titLP3,titLP4,titLP5,titLP6,titE4IT;
	JTextField txtLP0,txtLP1,txtLP2,txtLP3,txtLP4,txtLP5,txtLP6,txtE4IT,txtlopsvND,txtmasvND;
	JPanel actionND,settingND,btnstND,masvND,malhND,LP0,LP1,LP2,LP3,LP4,LP5,LP6,E4IT;
	JButton suaND;
	DefaultTableModel defTableND = new DefaultTableModel();
	JTable tableND = new JTable(defTableND);
	JScrollPane scrPaneND = new JScrollPane(tableND);
	
	JPanel thongke1,thongke2,setting1,setting2;
	JLabel titnamhocSV,titlophocSV,titnamhocLH;
	JComboBox namhocSV, lophocSV, namhocLH;
	DefaultTableModel defTableTK1 = new DefaultTableModel();
	JTable tableTK1 = new JTable(defTableTK1);
	JScrollPane scrPaneTK1 = new JScrollPane(tableTK1);
	DefaultTableModel defTableTK2 = new DefaultTableModel();
	JTable tableTK2 = new JTable(defTableTK2);
	JScrollPane scrPaneTK2 = new JScrollPane(tableTK2);
	
	JPanel informUS,suaUS,btnstUS,settingUS;
	JLabel titthemnameUS,titthempswUS,titsuanameUS,titsuapswUS,titXoaUS,titidUS,titsuapswmoiUS,
		titidmoiUS,titpswmoiUS,titidsuaUS;
	JTextField txtnameUS,txtidUS,txtnamesuaUS,txtnamexoaUS,txtidxoaUS,txtidsuaUS,
	txtPass,txtpasSua,txtpasXoa,txtpasSuaMoi;
	JButton btnthemUS,btnsuaUS,btnxoaUS;
	DefaultTableModel defTableUS = new DefaultTableModel();
	JTable tableUS = new JTable(defTableUS);
	JScrollPane scrPaneUS = new JScrollPane(tableUS);
	public Project_UI(String tittle) {
		super(tittle);
		setContent();
		setDisplay();
		tabbed.addChangeListener(new SelectedTab());
	}
	public void connectDB() {
		conn=ConnectDB.getConnect("Localhost","project_quanlysv","Project_QuanLySv","12345");
		if (conn != null) {
			String result = "Kết nối thành công Database";
			System.out.println(result);
		} else {
			JOptionPane.showMessageDialog(null, "Không kết nối được vs Database");
		}
	}
	public void setDisplay() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);
		this.setMinimumSize(new Dimension(1900, 1000));
	}
	private class SelectedTab implements ChangeListener {
		//Chọn Tab
		public void stateChanged(ChangeEvent e) {
			int choose = tabbed.getSelectedIndex();
			switch (choose) {
			case 1:
				showLopSvCbo();
				break;
			case 2:
				showmaLop();
				showmaMH();
				arrMH.clear();
				defTableMH.setRowCount(0);
				getdataMH();
				showTableMH();
				break;
			case 3:
				defTableND.setRowCount(0);
				arrBD.clear();
				getDataND();
				showTableND();
				break;
			case 4:
				lophocSV.removeAllItems();
				showlhTK();
				namhocLH.removeAllItems();
				defTableTK1.setRowCount(0);
				showtbTK1();
				namhocSV.removeAllItems();
				shownhSV();
				shownhLH();
			case 5:
				defTableUS.setRowCount(0);
				arrUS.clear();
				showtbUser();
			}
		}
	}
	public void setContent() {
		// Set Nội Dung TabbedPane
		connectDB();
		lophoc_UI();
		lophocEvent();
		sinhvien_UI();
		sinhvienEvent();
		monhoc_UI();
		monhocEvent();
		nhapdiem_UI();
		nhapdiemEvent();
		thongke_UI();
		thongkeEvent();
		user_UI();
		userEvent();
		tabbed = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbed.addTab("Quản Lý Lớp Học", lopAnh, lophocQL, "Quản Lý Lớp Học");
		tabbed.addTab("Quản Lý Sinh Viên", sinhvienAnh, sinhvienQL, "Quản Lý Sinh Viên");
		tabbed.addTab("Môn Học", monhocAnh, monhocQL, "Quản Lý Môn Học");
		tabbed.addTab("Nhập Điểm", diemsoAnh, nhapdiem, "Nhập Điểm");
		tabbed.addTab("Thống Kê", thongkeAnh, thongke, "Thống Kê");
		tabbed.addTab("Người Dùng", userAnh,user,"Người Dùng");
		lophocQL.setLayout(new BoxLayout(lophocQL, BoxLayout.Y_AXIS));
		sinhvienQL.setLayout(new BoxLayout(sinhvienQL, BoxLayout.Y_AXIS));
		monhocQL.setLayout(new GridLayout(2,1));
		nhapdiem.setLayout(new BoxLayout(nhapdiem, BoxLayout.Y_AXIS));
		thongke.setLayout(new GridLayout(2,1));
		user.setLayout(new BoxLayout(user, BoxLayout.Y_AXIS));
		con = getContentPane();
		con.add(tabbed);
		tabbed.setFont(new Font("Courier New", Font.CENTER_BASELINE, 26));
	}
	public void lophoc_UI() {
		//Add Controls Tab Lophoc
		actionLH.setLayout(new BorderLayout());
		settingLH.setLayout(new GridLayout(2, 2));
		btnstLH.setLayout(new FlowLayout());
		themLop = new JButton();
		xoaLop = new JButton();
		suaLop = new JButton();
		resetLop = new JButton();
		themLop.setText("Thêm Lớp");
		themLop.setFont(new Font("Courier New", Font.BOLD, 18));
		suaLop.setText("Sửa Lớp");
		suaLop.setFont(new Font("Courier New", Font.BOLD, 18));
		xoaLop.setText("Xóa Lớp");
		xoaLop.setFont(new Font("Courier New", Font.BOLD, 18));
		resetLop.setText("Reset");
		resetLop.setFont(new Font("Courier New", Font.BOLD, 18));
		btnstLH.add(themLop);
		btnstLH.add(suaLop);
		btnstLH.add(xoaLop);
		btnstLH.add(resetLop);
		titmaLop = new JLabel();
		textmaLop = new JTextField(50);
		textmaLop.setPreferredSize(new Dimension(60, 30));
		titmaLop.setText("Mã Lớp");
		titmaLop.setFont(new Font("Courier New", Font.BOLD, 20));
		maLop = new JPanel();
		maLop.add(titmaLop);
		maLop.add(textmaLop);
		settingLH.add(maLop);
		tittenLop = new JLabel();
		texttenLop = new JTextField(50);
		texttenLop.setPreferredSize(new Dimension(60, 30));
		tittenLop.setText("Tên Lớp");
		tittenLop.setFont(new Font("Courier New", Font.BOLD, 20));
		tenLop = new JPanel();
		tenLop.add(tittenLop);
		tenLop.add(texttenLop);
		settingLH.add(tenLop);
		titnamHoc = new JLabel();
		textnamHoc = new JTextField(50);
		textnamHoc.setPreferredSize(new Dimension(60, 30));
		titnamHoc.setText("Năm Học");
		titnamHoc.setFont(new Font("Courier New", Font.BOLD, 20));
		namHoc = new JPanel();
		namHoc.add(titnamHoc);
		namHoc.add(textnamHoc);
		settingLH.add(namHoc);
		titmoTa = new JLabel();
		textmoTa = new JTextField(50);
		textmoTa.setPreferredSize(new Dimension(75, 35));
		titmoTa.setText("Mô Tả");
		titmoTa.setFont(new Font("Courier New", Font.BOLD, 20));
		moTa = new JPanel();
		moTa.add(titmoTa);
		moTa.add(textmoTa);
		settingLH.add(moTa);
		tittleLH.setAlignmentX(Component.CENTER_ALIGNMENT);
		tittleLH.setFont(new Font("Courier New", Font.PLAIN, 30));
		actionLH.add(settingLH, BorderLayout.CENTER);
		actionLH.add(btnstLH, BorderLayout.SOUTH);
		lophocQL.add(tittleLH);
		tableLH.setFont(new Font("Serif", 0, 20));
		tableLH.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 18));
		defTableLH.addColumn("Mã Lớp");
		defTableLH.addColumn("Tên Lớp");
		defTableLH.addColumn("Năm Học");
		defTableLH.addColumn("Mô Tả");
		loadLopHoc();
		Border bor = BorderFactory.createEtchedBorder(Color.BLACK, Color.WHITE);
		TitledBorder tittle = new TitledBorder(bor, "Thông Tin Lớp Học");
		actionLH.setBorder(tittle);
		tittle.setTitleFont(new Font("Courier New", Font.BOLD, 30));
		scrPaneLH = new JScrollPane(tableLH);
		lophocQL.add(scrPaneLH);
		lophocQL.add(actionLH);
	}
	public void sinhvien_UI() {
		//Add Controls Tab Sinhvien
		tableSV.setFont(new Font("Serif", 0, 20));
		tableSV.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 18));
		tittleSV.setAlignmentX(Component.CENTER_ALIGNMENT);
		tittleSV.setFont(new Font("Courier New", Font.PLAIN, 30));
		defTableSV.addColumn("Mã Sinh Viên");
		defTableSV.addColumn("Họ Tên Sinh Viên");
		defTableSV.addColumn("Địa Chỉ Sinh Viên");
		defTableSV.addColumn("Phường");
		defTableSV.addColumn("Quận");
		defTableSV.addColumn("Thành Phố");
		defTableSV.addColumn("Số Điện Thoại");
		defTableSV.addColumn("Email");
		defTableSV.addColumn("Lớp");
		TableColumn column = null;
		for(int i = 0;i<5;i++) {
			if(i==3) {
				column = tableSV.getColumnModel().getColumn(i);
				column.setPreferredWidth(180);
		}
			if(i==2) {
				column = tableSV.getColumnModel().getColumn(i);
				column.setPreferredWidth(180);
			}
		}
		titmaSV = new JLabel("Mã Sinh Viên");
		titmaSV.setFont(new Font("Courier New", Font.BOLD, 20));
		tittenSV = new JLabel("Họ Tên Sinh Viên");
		tittenSV.setFont(new Font("Courier New", Font.BOLD, 20));
		titdiachiSV = new JLabel("Địa Chỉ Sinh Viên");
		titdiachiSV.setFont(new Font("Courier New", Font.BOLD, 20));
		titphuongSV = new JLabel("Phường Sinh Viên");
		titphuongSV.setFont(new Font("Courier New", Font.BOLD, 20));
		titquanSV = new JLabel("Quận Sinh Viên");
		titquanSV.setFont(new Font("Courier New", Font.BOLD, 20));
		titthanhphoSV = new JLabel("Thành Phố Sinh Viên");
		titthanhphoSV.setFont(new Font("Courier New", Font.BOLD, 20));
		titemailSV = new JLabel("Email Sinh Viên");
		titemailSV.setFont(new Font("Courier New", Font.BOLD, 20));
		titsdtSV = new JLabel("Số Điện Thoại Sinh Viên");
		titsdtSV.setFont(new Font("Courier New", Font.BOLD, 20));
		titlopSV = new JLabel("Lớp Sinh Viên");
		titlopSV.setFont(new Font("Courier New", Font.BOLD, 20));
		textmaSV = new JTextField(30);
		textmaSV.setPreferredSize(new Dimension(60, 30));
		texttenSV = new JTextField(30);
		texttenSV.setPreferredSize(new Dimension(60, 30));
		textdiachiSV = new JTextField(30);
		textdiachiSV.setPreferredSize(new Dimension(60, 30));
		textsdtSV = new JTextField(30);
		textsdtSV.setPreferredSize(new Dimension(60, 30));
		textemailSV = new JTextField(30);
		textemailSV.setPreferredSize(new Dimension(60, 30));
		themSV = new JButton();
		suaSV = new JButton();
		xoaSV = new JButton();
		resetSV = new JButton();
		themSV.setText("Thêm Sinh Viên");
		themSV.setFont(new Font("Courier New", Font.BOLD, 18));
		suaSV.setText("Sửa Sinh Viên");
		suaSV.setFont(new Font("Courier New", Font.BOLD, 18));
		xoaSV.setText("Xóa Sinh Viên");
		xoaSV.setFont(new Font("Courier New", Font.BOLD, 18));
		resetSV.setText("Reset");
		resetSV.setFont(new Font("Courier New", Font.BOLD, 18));
		btnstSV.add(themSV);
		btnstSV.add(suaSV);
		btnstSV.add(xoaSV);
		btnstSV.add(resetSV);
		phuong = new JComboBox();
		quan = new JComboBox();
		thanhpho = new JComboBox();
		lopsvCBO = new JComboBox();
		lopsvCBO.setFont(new Font("Courier New",Font.CENTER_BASELINE,16));
		cboLop = new JComboBox();
		showLopSvCbo();
		thanhpho.setFont(new Font("Courier New",Font.BOLD,18));
		quan.setFont(new Font("Courier New",Font.BOLD,18));
		phuong.setFont(new Font("Courier New",Font.BOLD,18));
		showTP();
		maSV = new JPanel();
		maSV.setLayout(new FlowLayout());
		maSV.add(titmaSV);
		maSV.add(textmaSV);
		tenSV = new JPanel();
		tenSV.setLayout(new FlowLayout());
		tenSV.add(tittenSV);
		tenSV.add(texttenSV);
		diachiSV = new JPanel();
		diachiSV.setLayout(new FlowLayout());
		diachiSV.add(titdiachiSV);
		diachiSV.add(textdiachiSV);
		phuongSV = new JPanel();
		phuongSV.setLayout(new FlowLayout());
		phuongSV.add(titthanhphoSV);
		phuongSV.add(thanhpho);
		quanSV = new JPanel();
		quanSV.setLayout(new FlowLayout());
		quanSV.add(titquanSV);
		quanSV.add(quan);
		thanhphoSV = new JPanel();
		thanhphoSV.setLayout(new FlowLayout());
		thanhphoSV.add(titphuongSV);
		thanhphoSV.add(phuong);
		sdtSV = new JPanel();
		sdtSV.setLayout(new FlowLayout());
		sdtSV.add(titsdtSV);
		sdtSV.add(textsdtSV);
		emailSV = new JPanel();
		emailSV.setLayout(new FlowLayout());
		emailSV.add(titemailSV);
		emailSV.add(textemailSV);
		lopSV = new JPanel();
		lopSV.setLayout(new FlowLayout());
		lopSV.add(titlopSV);
		lopSV.add(cboLop);
		settingSV.add(maSV);
		settingSV.add(tenSV);
		settingSV.add(diachiSV);
		settingSV.add(phuongSV);
		settingSV.add(quanSV);
		settingSV.add(thanhphoSV);
		settingSV.add(sdtSV);
		settingSV.add(emailSV);
		settingSV.add(lopSV);
		actionSV.setLayout(new BorderLayout());
		settingSV.setLayout(new GridLayout(3, 3));
		btnstSV.setLayout(new FlowLayout());
		actionSV.add(settingSV, BorderLayout.CENTER);
		actionSV.add(btnstSV, BorderLayout.SOUTH);
		Border bor = BorderFactory.createEtchedBorder(Color.BLACK, Color.WHITE);
		TitledBorder tittle = new TitledBorder(bor, "Thông Tin Sinh Viên");
		actionSV.setBorder(tittle);
		tittle.setTitleFont(new Font("Courier New", Font.BOLD, 30));
		svLB = new JLabel("Chọn Lớp");
		svLB.setFont(new Font("",Font.BOLD,20));
		svPN = new JPanel();
		timSV = new JButton("Tìm Sinh Viên");
		tittimSV = new JLabel("Tìm Theo Mã Hoặc Tên");
		tittimSV.setFont(new Font("",Font.BOLD,20));
		timSV.setFont(new Font("Courier New",Font.CENTER_BASELINE,16));
		txttimSV = new JTextField();
		txttimSV.setPreferredSize(new Dimension(100,30));
		svPN.add(svLB);
		svPN.add(lopsvCBO);
		svPN.add(tittimSV);
		svPN.add(txttimSV);
		svPN.add(timSV);
		sinhvienQL.add(tittleSV);
		sinhvienQL.add(svPN);
		sinhvienQL.add(scrPaneSV);
		sinhvienQL.add(actionSV);
	}
	public void monhoc_UI() {
		//Add Controls Tab Monhoc
		tunglopMH = new JPanel();
		settingMH = new JPanel();
		btnstMH = new JPanel();
		tunglopMH.setLayout(new BorderLayout());
		settingMH.setLayout(new GridLayout(2,2));
		btnstMH.setLayout(new FlowLayout());
		tittleMH = new JLabel("Tất Cả Môn Học");
		defTableMH.addColumn("Mã Môn Học");
		defTableMH.addColumn("Tên Môn Học");
		defTableMH.addColumn("Tín Chỉ Môn Học");
		defTableMH.addColumn("Thời Gian Môn Học");
		titmaMH = new JLabel();
		tittenMH = new JLabel();
		tittinchiMH = new JLabel();
		tittimeMH = new JLabel();
		titmaMH.setText("Mã Môn Học");
		tittenMH.setText("Tên Môn Học");
		tittinchiMH.setText("Tín Chỉ");
		tittimeMH.setText("Thời Gian Học");
		titmaMH.setPreferredSize(new Dimension(200,30));
		tittenMH.setPreferredSize(new Dimension(200,30));
		tittinchiMH.setPreferredSize(new Dimension(200,30));
		tittimeMH.setPreferredSize(new Dimension(200,30));
		titmaMH.setFont(new Font("Courier New", Font.BOLD, 20));
		tittenMH.setFont(new Font("Courier New", Font.BOLD, 20));
		tittimeMH.setFont(new Font("Courier New", Font.BOLD, 20));
		tittinchiMH.setFont(new Font("Courier New", Font.BOLD, 20));
		tableMH.setFont(new Font("Serif", 0, 20));
		tableMH.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 18));
		tittleMH.setFont(new Font("Courier New", Font.PLAIN, 30));
		txtmaMH = new JTextField(30);
		txttenMH = new JTextField(30);
		txttimeMH = new JTextField(30);
		txttinchiMH = new JTextField(30);
		txttenMH.setPreferredSize(new Dimension(80, 30));
		txtmaMH.setPreferredSize(new Dimension(80, 30));
		txttimeMH.setPreferredSize(new Dimension(80, 30));
		txttinchiMH.setPreferredSize(new Dimension(80, 30));
		themMH = new JButton();
		suaMH = new JButton();
		xoaMH = new JButton();
		resetMH = new JButton();
		themMH.setText("Thêm Môn Học");
		suaMH.setText("Sửa Môn Học");
		xoaMH.setText("Xóa Môn Học");
		resetMH.setText("Reset");
		themMH.setFont(new Font("Courier New", Font.BOLD, 18));
		suaMH.setFont(new Font("Courier New", Font.BOLD, 18));
		xoaMH.setFont(new Font("Courier New", Font.BOLD, 18));
		resetMH.setFont(new Font("Courier New", Font.BOLD, 18));
		maMH = new JPanel();
		tenMH = new JPanel();
		tinchiMH = new JPanel();
		timeMH = new JPanel();
		JPanel allMH = new JPanel();
		allMH.setLayout(new BoxLayout(allMH,BoxLayout.Y_AXIS));
		tittleMH.setAlignmentX(Component.CENTER_ALIGNMENT);
		allMH.add(tittleMH);
		allMH.add(scrPaneMH,BorderLayout.CENTER);
		allMH.add(settingMH, BorderLayout.CENTER);
		allMH.add(btnstMH, BorderLayout.SOUTH);
		Border bor = BorderFactory.createEtchedBorder(Color.BLACK, Color.WHITE);
		TitledBorder tittle = new TitledBorder(bor, "Môn Học Của Từng Lớp");
		tunglopMH.setBorder(tittle);
		tittle.setTitleFont(new Font("Courier New", Font.BOLD, 30));
		malhTL = new JPanel();
		malhTL.setLayout(new FlowLayout());
		mamhTL = new JPanel();
		mamhTL.setLayout(new FlowLayout());
		tenmhTL = new JPanel();
		tenmhTL.setLayout(new FlowLayout());
		titmalhTL = new JLabel();
		titmamhTL = new JLabel();
		tittenmhTL = new JLabel();
		txttenmhTL = new JTextField();
		txttenmhTL.setPreferredSize(new Dimension(400,30));
		txttenmhTL.setEditable(false);
		titmalhTL.setText("Mã Lớp Học");
		titmamhTL.setText("Mã Môn Học");
		tittenmhTL.setText("Tên Môn Học");
		titmalhTL.setFont(new Font("Courier New", Font.BOLD, 20));
		titmamhTL.setFont(new Font("Courier New", Font.BOLD, 20));
		tittenmhTL.setFont(new Font("Courier New", Font.BOLD, 20));
		cbomalhTL = new JComboBox();
		cbomamhTL = new JComboBox();
		tableTL.setFont(new Font("Serif", 0, 20));
		tableTL.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 18));
		themTL = new JButton();
		suaTL = new JButton();
		xoaTL = new JButton();
		themTL.setText("Thêm Môn Học");
		suaTL.setText("Sửa Môn Học");
		xoaTL.setText("Xóa Môn Học");
		themTL.setFont(new Font("Courier New", Font.BOLD, 18));
		suaTL.setFont(new Font("Courier New", Font.BOLD, 18));
		xoaTL.setFont(new Font("Courier New", Font.BOLD, 18));
		JPanel btnTL = new JPanel(new FlowLayout());
		btnTL.add(themTL);
		btnTL.add(suaTL);
		btnTL.add(xoaTL);
		defTableTL.addColumn("Mã Lớp Học");
		defTableTL.addColumn("Mã Môn Học");
		defTableTL.addColumn("Tên Môn Học");
		showTableTL();
		malhTL.add(titmalhTL);
		malhTL.add(cbomalhTL);
		mamhTL.add(titmamhTL);
		mamhTL.add(cbomamhTL);
		tenmhTL.add(tittenmhTL);
		tenmhTL.add(txttenmhTL);
		JPanel actTL = new JPanel(new BorderLayout());
		actTL.add(malhTL,BorderLayout.WEST);
		actTL.add(mamhTL,BorderLayout.CENTER);
		actTL.add(tenmhTL,BorderLayout.EAST);
		actTL.add(btnTL,BorderLayout.SOUTH);
		tunglopMH.add(srcPaneTL,BorderLayout.CENTER);
		tunglopMH.add(actTL,BorderLayout.SOUTH);
		monhocQL.add(allMH);
		monhocQL.add(tunglopMH);
		maMH.add(titmaMH);
		maMH.add(txtmaMH);
		tenMH.add(tittenMH);
		tenMH.add(txttenMH);
		tinchiMH.add(tittinchiMH);
		tinchiMH.add(txttinchiMH);
		timeMH.add(tittimeMH);
		timeMH.add(txttimeMH);
		settingMH.add(maMH);
		settingMH.add(tenMH);
		settingMH.add(tinchiMH);
		settingMH.add(timeMH);
		btnstMH.add(themMH);
		btnstMH.add(suaMH);
		btnstMH.add(xoaMH);
		btnstMH.add(resetMH);
	}

	public void monhocEvent() {
		// Add Event MonHoc
		tableMH.addMouseListener(eventTblMH);
		themMH.addActionListener(eventThemMH);
		suaMH.addActionListener(eventSuaMH);
		xoaMH.addActionListener(eventXoaMH);
		resetMH.addActionListener(eventResetMH);
		tableTL.addMouseListener(eventTblTL);
		themTL.addActionListener(eventThemTL);
		suaTL.addActionListener(eventSuaTL);
		xoaTL.addActionListener(eventXoaTL);
		cbomamhTL.addActionListener(eventcbomamhTL);
	}
	private void nhapdiem_UI() {
		//Add Controls Tab Nhapdiem
		tittleND = new JLabel("Nhập Điểm Sinh Viên");
		defTableND.addColumn("Mã Lớp");
		defTableND.addColumn("Mã Sinh Viên");
		defTableND.addColumn("LP0");
		defTableND.addColumn("LP1");
		defTableND.addColumn("LP2");
		defTableND.addColumn("LP3");
		defTableND.addColumn("LP4");
		defTableND.addColumn("LP5");
		defTableND.addColumn("LP6");
		defTableND.addColumn("E4IT");
		actionND = new JPanel();
		settingND = new JPanel();
		btnstND = new JPanel();
		actionND.setLayout(new BorderLayout());
		settingND.setLayout(new GridLayout(2,5));
		btnstND.setLayout(new FlowLayout());
		suaND = new JButton();
		suaND.setText("Update");
		malhND = new JPanel();
		masvND = new JPanel();
		E4IT = new JPanel();
		LP0 = new JPanel();
		LP1 = new JPanel();
		LP2 = new JPanel();
		LP3 = new JPanel();
		LP4 = new JPanel();
		LP5 = new JPanel();
		LP6 = new JPanel();
		txtLP0 = new JTextField();
		txtLP1 = new JTextField();
		txtLP2 = new JTextField();
		txtLP3 = new JTextField();
		txtLP4 = new JTextField();
		txtLP5 = new JTextField();
		txtLP6 = new JTextField();
		txtE4IT = new JTextField();
		titlopsvND = new JLabel("Mã Lớp");
		titmasvND = new JLabel("Mã Sinh Viên");
		titLP0 = new JLabel("Điểm LP0");
		titLP1 =new JLabel("Điểm LP1");
		titLP2 = new JLabel("Điểm LP2");
		titLP3 = new JLabel("Điểm LP3");
		titLP4 = new JLabel("Điểm LP4");
		titLP5 = new JLabel("Điểm LP5");
		titLP6 = new JLabel("Điểm LP6");
		titE4IT = new JLabel("Điểm Tiếng Anh");
		txtlopsvND= new JTextField();
		txtmasvND = new JTextField();
		txtlopsvND.setPreferredSize(new Dimension(100, 30));
		txtmasvND.setPreferredSize(new Dimension(100, 30));
		txtlopsvND.setEditable(false);
		txtmasvND.setEditable(false);
		txtLP0.setPreferredSize(new Dimension(60, 30));
		txtLP1.setPreferredSize(new Dimension(60, 30));
		txtLP2.setPreferredSize(new Dimension(60, 30));
		txtLP3.setPreferredSize(new Dimension(60, 30));
		txtLP4.setPreferredSize(new Dimension(60, 30));
		txtLP5.setPreferredSize(new Dimension(60, 30));
		txtLP6.setPreferredSize(new Dimension(60, 30));
		txtE4IT.setPreferredSize(new Dimension(60, 30));
		suaND.setFont(new Font("Courier New", Font.BOLD, 18));
		titmasvND.setFont(new Font("Courier New", Font.BOLD, 20));
		titlopsvND.setFont(new Font("Courier New", Font.BOLD, 20));
		titE4IT.setFont(new Font("Courier New", Font.BOLD, 20));
		titLP0.setFont(new Font("Courier New", Font.BOLD, 20));
		titLP1.setFont(new Font("Courier New", Font.BOLD, 20));
		titLP2.setFont(new Font("Courier New", Font.BOLD, 20));
		titLP3.setFont(new Font("Courier New", Font.BOLD, 20));
		titLP4.setFont(new Font("Courier New", Font.BOLD, 20));
		titLP5.setFont(new Font("Courier New", Font.BOLD, 20));
		titLP6.setFont(new Font("Courier New", Font.BOLD, 20));
		tableND.setFont(new Font("Serif", 0, 20));
		tableND.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 18));
		Border bor = BorderFactory.createEtchedBorder(Color.BLACK, Color.WHITE);
		TitledBorder tittle = new TitledBorder(bor, "Nhập Điểm");
		actionND.setBorder(tittle);
		tittle.setTitleFont(new Font("Courier New", Font.BOLD, 30));
		btnstND.add(suaND);
		malhND.add(titlopsvND);
		malhND.add(txtlopsvND);
		masvND.add(titmasvND);
		masvND.add(txtmasvND);
		LP0.add(titLP0);
		LP0.add(txtLP0);
		LP1.add(titLP1);
		LP1.add(txtLP1);
		LP2.add(titLP2);
		LP2.add(txtLP2);
		LP3.add(titLP3);
		LP3.add(txtLP3);
		LP4.add(titLP4);
		LP4.add(txtLP4);
		LP5.add(titLP5);
		LP5.add(txtLP5);
		LP6.add(titLP6);
		LP6.add(txtLP6);
		E4IT.add(titE4IT);
		E4IT.add(txtE4IT);
		settingND.add(malhND);
		settingND.add(masvND);
		settingND.add(E4IT);
		settingND.add(LP0);
		settingND.add(LP1);
		settingND.add(LP2);
		settingND.add(LP3);
		settingND.add(LP4);
		settingND.add(LP5);
		settingND.add(LP6);
		tittleND.setAlignmentX(Component.CENTER_ALIGNMENT);
		tittleND.setFont(new Font("Courier New", Font.PLAIN, 30));
		actionND.add(settingND,BorderLayout.CENTER);
		actionND.add(btnstND,BorderLayout.SOUTH);
		nhapdiem.add(tittleND);
		nhapdiem.add(scrPaneND);
		nhapdiem.add(actionND);
	}

	private void nhapdiemEvent() {
		//Add Event NhapDiem
		suaND.addActionListener(eventSuaND);
		tableND.addMouseListener(eventTblND);
	}
	private void thongke_UI() {
		//Add Controls Tab ThongKe
		thongke1 = new JPanel(new BorderLayout());
		thongke2 = new JPanel(new BorderLayout());
		setting1 = new JPanel();
		setting2 = new JPanel();
		titnamhocSV = new JLabel("Năm Học");
		titlophocSV = new JLabel("Lớp Học");
		titnamhocLH = new JLabel("Năm Học");
		namhocSV = new JComboBox();
		lophocSV = new JComboBox();
		namhocLH = new JComboBox();
		Border bor = BorderFactory.createEtchedBorder(Color.BLACK, Color.WHITE);
		TitledBorder tittle = new TitledBorder(bor, "Thống Kê Sinh Viên");
		thongke1.setBorder(tittle);
		tittle.setTitleFont(new Font("Courier New", Font.BOLD, 30));
		Border bor2 = BorderFactory.createEtchedBorder(Color.BLACK, Color.WHITE);
		TitledBorder tittle2 = new TitledBorder(bor2, "Thống Kê Lớp Học");
		thongke2.setBorder(tittle2);
		tittle2.setTitleFont(new Font("Courier New", Font.BOLD, 30));
		titnamhocSV.setFont(new Font("Courier New", Font.BOLD, 20));
		titlophocSV.setFont(new Font("Courier New", Font.BOLD, 20));
		titnamhocLH.setFont(new Font("Courier New", Font.BOLD, 20));
		defTableTK1.addColumn("Mã Sinh Viên");
		defTableTK1.addColumn("Tên Sinh Viên");
		defTableTK1.addColumn("Điểm Trung Bình");
		defTableTK1.addColumn("Xếp Loại");
		defTableTK2.addColumn("Mã Lớp");
		defTableTK2.addColumn("Mô Tả");
		defTableTK2.addColumn("Tổng Số Sinh Viên");
		tableTK1.setFont(new Font("Serif", 0, 20));
		tableTK1.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 18));
		tableTK2.setFont(new Font("Serif", 0, 20));
		tableTK2.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 18));
		setting1.add(titnamhocSV);
		setting1.add(namhocSV);
		setting1.add(titlophocSV);
		setting1.add(lophocSV);
		setting2.add(titnamhocLH);
		setting2.add(namhocLH);
		thongke1.add(setting1,BorderLayout.NORTH);
		thongke1.add(scrPaneTK1,BorderLayout.CENTER);
		thongke2.add(setting2,BorderLayout.NORTH);
		thongke2.add(scrPaneTK2,BorderLayout.CENTER);
		thongke.add(thongke1);
		thongke.add(thongke2);
	}
	private void userEvent() {
		tableUS.addMouseListener(eventTblUS);
		btnthemUS.addActionListener(eventThemUser);
		btnsuaUS.addActionListener(eventSuaUser);
		btnxoaUS.addActionListener(eventXoaUser);
	}
	MouseListener eventTblUS= new MouseListener() {
		public void mouseClicked(MouseEvent arg0) {
			for(int i = tableUS.getSelectedRow();i<=tableUS.getSelectedRow();i++) {
				for(int y =0;y<tableUS.getColumnCount();y++) {
					String value =(String)tableUS.getValueAt(i,y);
					if(y==0) {
						txtidUS.setText(value);
					}
					if(y==1) {
						txtnameUS.setText(value);
					}
				}
			}
		}
		public void mouseEntered(MouseEvent arg0) {

		}
		public void mouseExited(MouseEvent arg0) {

		}
		public void mousePressed(MouseEvent arg0) {

		}
		public void mouseReleased(MouseEvent arg0) {

		}
	};
	ActionListener eventXoaUser = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			String id = txtidUS.getText();
			try {
				Statement stm = conn.createStatement();
				String sql = "delete from `user` where `user_id`='"+id+"'";
				int x = stm.executeUpdate(sql);
				if(x>0) {
					JOptionPane.showMessageDialog(null, "Xóa Thành Công");
					for(User z: arrUS) {
						if(id.equals(z.getUserID())) {
							arrUS.remove(z);
							break;
						}
					}
					defTableUS.setRowCount(0);
					for(User f: arrUS) {
						String row[] = {f.getUserID(),f.getUserName()};
						defTableUS.addRow(row);
					}
				}
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	};
	ActionListener eventSuaUser = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String id = txtidUS.getText();
			String user = txtnameUS.getText();
			String pass = MD5Library.md5(txtPass.getText());
			try {
				Statement stm = conn.createStatement();
				String sql="update `user` set `user_name`='"+user+
						"',`user_password`='"+pass+"' where `user_id`='"+id+"'";
				if(id.isEmpty()||user.isEmpty()||pass.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Bạn Chưa Nhập Đủ Dữ Liệu!");
				}
				else {
					int x = stm.executeUpdate(sql);
					if(x>0) {
						JOptionPane.showMessageDialog(null, "Update Thành Công!");
						for(User z: arrUS) {
							if(id.equals(z.getUserID())) {
								z.setUserName(user);
								z.setUserPass(pass);
							}
						}
						defTableUS.setRowCount(0);
						for(User f: arrUS) {
							String row[]= {f.getUserID(),f.getUserName()};
							defTableUS.addRow(row);
						}
					}
				}
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	};
	ActionListener eventThemUser = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String id = txtidUS.getText();
			String user = txtnameUS.getText();
			String pass = MD5Library.md5(txtPass.getText());
			int kt = 0;
			try {
				for(User f: arrUS) {
				if(id.equals(f.getUserID())) {
					kt = 1;
				}}
				if(kt>0){
					JOptionPane.showMessageDialog(null, "ID Đã Có Người Dùng!");
				}
				else if (id.isEmpty()||user.isEmpty()||pass.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Bạn Chưa Nhập Đủ Dữ Liệu!");
				}
				else{
					Statement stm = conn.createStatement();
					String sql = "insert into `user` (`user_id`,`user_name`,`user_password`)"
							+ " values ('"+id+"','"+user+"','"+pass+"')";
					int x = stm.executeUpdate(sql);
					if(x>0) {
						JOptionPane.showMessageDialog(null, "Thêm Mới Thành Công!");
						defTableUS.setRowCount(0);
						User us = new User(id,user,pass);
						arrUS.add(us);
						for(User z: arrUS) {
							String row[]= {z.getUserID(),z.getUserName()};
							defTableUS.addRow(row);
						}
					}
				}

			}
			catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	};
	private void user_UI() {
		// Add Controls Tab User
		defTableUS.addColumn("User ID");
		defTableUS.addColumn("Tên Người Dùng");
		settingUS = new JPanel();
		informUS = new JPanel();
		suaUS = new JPanel();
		btnstUS = new JPanel();
		settingUS = new JPanel(new GridLayout(2,1));
		titidsuaUS = new JLabel("ID Người Dùng");
		titsuanameUS = new JLabel("Tên Người Dùng Mới");
		titsuapswUS = new JLabel("Mật Khẩu Hiện Tại");
		titpswmoiUS= new JLabel("Mật Khẩu");
		titidmoiUS = new JLabel("ID Người Dùng");
		titidUS = new JLabel("ID Người Dùng");
		titthemnameUS = new JLabel("Tên Người Dùng");
		titthempswUS = new JLabel("Mật Khẩu");
		titXoaUS = new JLabel("Tên Người Dùng Xóa");
		titsuapswmoiUS= new JLabel("Mật Khẩu Mới");
		txtidsuaUS = new JTextField();
		txtidxoaUS = new JTextField();
		txtnameUS = new JTextField();
		txtidUS = new JTextField();
		txtnamesuaUS = new JTextField();
		txtnamexoaUS = new JTextField();
		txtPass = new JPasswordField();
		txtpasSua= new JPasswordField();
		txtpasXoa= new JPasswordField();
		txtpasSuaMoi= new JPasswordField();
		titidUS.setFont(new Font("Courier New", Font.BOLD, 18));
		titthemnameUS.setFont(new Font("Courier New", Font.BOLD, 18));
		titpswmoiUS.setFont(new Font("Courier New", Font.BOLD, 18));
		txtidsuaUS.setPreferredSize(new Dimension(200,30));
		txtidxoaUS.setPreferredSize(new Dimension(200,30));
		txtnameUS.setPreferredSize(new Dimension(200,30));;
		txtidUS.setPreferredSize(new Dimension(200,30));
		txtnamesuaUS.setPreferredSize(new Dimension(200,30));
		txtnamexoaUS.setPreferredSize(new Dimension(200,30));
		txtPass.setPreferredSize(new Dimension(200,30));
		txtpasSua.setPreferredSize(new Dimension(200,30));
		txtpasXoa.setPreferredSize(new Dimension(200,30));
		txtpasSuaMoi.setPreferredSize(new Dimension(200,30));
		btnthemUS = new JButton("Thêm Người Dùng");
		btnsuaUS = new JButton("Sửa Người Dùng");
		btnxoaUS = new JButton("Xóa Người Dùng");
		btnthemUS.setFont(new Font("Courier New", Font.BOLD, 18));
		btnsuaUS.setFont(new Font("Courier New", Font.BOLD, 18));
		btnxoaUS.setFont(new Font("Courier New", Font.BOLD, 18));
		Border bor = BorderFactory.createEtchedBorder(Color.BLACK, Color.WHITE);
		TitledBorder tittle = new TitledBorder(bor, "Thông Tin Người Dùng");
		settingUS.setBorder(tittle);
		tittle.setTitleFont(new Font("Courier New", Font.BOLD, 30));
		tableUS.setFont(new Font("Serif", 0, 20));
		tableUS.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 18));
		informUS.add(titidUS);
		informUS.add(txtidUS);
		informUS.add(titthemnameUS);
		informUS.add(txtnameUS);
		informUS.add(titpswmoiUS);
		informUS.add(txtPass);
		btnstUS.add(btnthemUS);
		btnstUS.add(btnsuaUS);
		btnstUS.add(btnxoaUS);
		settingUS.add(informUS);
		settingUS.add(btnstUS);
		user.add(scrPaneUS);
		user.add(settingUS);
	}
	private void showtbUser() {
		try {
			Statement stm = conn.createStatement();
			String sql = "select * from `user`";
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				User us = new User(rs.getString("user_id"),rs.getString("user_name"),
						rs.getString("user_password"));
				arrUS.add(us);
			}
			for(User z: arrUS) {
				String row[]= {z.getUserID(),z.getUserName()};
				defTableUS.addRow(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private void showTableTL() {
		//Show Table Môn Học Từng Lớp
		try {
			Statement stm = conn.createStatement();
			String sql ="select * from `mon_hoc_tung_lop`";
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				String row[]={rs.getString("ma_lop"),rs.getString("ma_mon")};
				defTableTL.addRow(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private void showTP() {
		//Show Thành Phố
		try {
			thanhpho.addItem("");
			Statement statement = conn.createStatement();
			ResultSet tpRS=statement.executeQuery("Select * from devvn_tinhthanhpho");
			while (tpRS.next()) {
				thanhpho.addItem(tpRS.getString("name"));
			}
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}
	private void showLopSvCbo() {
		// Show Tất Cả Lớp Vào JcomboBox
		try {
			cboLop.removeAllItems();
			lopsvCBO.removeAllItems();
			Statement statement = conn.createStatement();
			ResultSet lop = statement.executeQuery("select * from lop_hoc");
			lopsvCBO.addItem("Tất Cả Các Lớp");
			while(lop.next()) {
				lopsvCBO.addItem(lop.getString("ma_lop"));
				cboLop.addItem(lop.getString("ma_lop"));
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	private void showmaLop(){
		// Show Mã Lớp Jcombobox
		try {
			cbomalhTL.removeAllItems();
			Statement stm = conn.createStatement();
			String sql = "select * from lop_hoc";
			ResultSet lop = stm.executeQuery(sql);
			while(lop.next()) {
				cbomalhTL.addItem(lop.getString("ma_lop"));
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	private void showmaMH() {
		//Show Mã Monhoc Jcombobox
		try {
			cbomamhTL.removeAllItems();
			Statement stm5 = conn.createStatement();
			String sql5 = "Select * from mon_hoc";
			ResultSet rs5 = stm5.executeQuery(sql5);
			while(rs5.next()) {
				cbomamhTL.addItem(rs5.getString("ma_mh"));
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	private void getdataMH() {
		//Get Dữ Liệu Từ Database
		try {
			Statement stm = conn.createStatement();
			String sql = "select * from mon_hoc";
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				MonHoc mh=new MonHoc(rs.getString("ma_mh"),rs.getString("ten_mh"),
						rs.getString("tin_chi_mh"),rs.getString("time_mh"));
				arrMH.add(mh);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void showTableMH() {
		//Show Table MonHoc
		for(MonHoc x: arrMH) {
			String row[]= {x.getMaMh(),x.getNameMh(),x.getTinchiMh(),x.getTimeMh()};
			defTableMH.addRow(row);
		}
	}
	private void showTableND() {
		//Show Table Nhập Điểm
		for(BangDiem x: arrBD) {
			String row[]= {x.getLop_sv(),x.getMa_sv(),x.getLp0(),x.getLp1(),x.getLp2(),
				x.getLp3(),x.getLp4(),x.getLp5(),x.getLp6(),x.getE4IT()};
			defTableND.addRow(row);
		}
	}
	private void getDataND() {
		// Get Dữ Liệu Từ Database
		try {
			Statement stm = conn.createStatement();
			String sql ="Select * from `bang_diem`";
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				BangDiem bd = new BangDiem(rs.getString("lop_sv"),rs.getString("ma_sv"),
						rs.getString("LP0"),rs.getString("LP1"),rs.getString("LP2"),
						rs.getString("LP3"),rs.getString("LP4"),rs.getString("LP5"),
						rs.getString("LP6"),rs.getString("E4IT"));
				arrBD.add(bd);
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private void showtbTK1() {
		//Show Table Thống Kê Sinh Viên
		try {
			Statement stm = conn.createStatement();
			String sql="select * from `sinh_vien`";
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				Statement stm2 = conn.createStatement();
				String sql2="select * from `bang_diem` where ma_sv='"+rs.getString("codesv")+"'";
				ResultSet rs2 = stm2.executeQuery(sql2);
				while(rs2.next()) {
					int lp0= Integer.parseInt(rs2.getString("lp0"));
					int lp1= Integer.parseInt(rs2.getString("lp1"));
					int lp2= Integer.parseInt(rs2.getString("lp2"));
					int lp3= Integer.parseInt(rs2.getString("lp3"));
					int lp4= Integer.parseInt(rs2.getString("lp4"));
					int lp5= Integer.parseInt(rs2.getString("lp5"));
					int lp6= Integer.parseInt(rs2.getString("lp6"));
					int e4it= Integer.parseInt(rs2.getString("E4IT"));
					float diemtb = (lp0+lp1+lp2+lp3+lp4+lp5+lp6+e4it)/8;
					String xeploai;
					if(diemtb<=4.9) {
						xeploai="Yếu";
					}
					else if(diemtb<=6.4) {
						xeploai="Trung Bình";
					}
					else if(diemtb<=7.9) {
						xeploai="Khá";
					}
					else {
						xeploai="Giỏi";
					}
					String diemtbm = Float.toString(diemtb);
					String row[]= {rs.getString("codesv"),rs.getString("namesv"),diemtbm,xeploai};
					defTableTK1.addRow(row);
					}
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	private void shownhSV() {
		//Show Năm Học Jcombobox
		try {
			namhocSV.addItem("Tất Cả");
			Statement stm = conn.createStatement();
			String sql="select distinct `nam_hoc` from `lop_hoc`";
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				namhocSV.addItem(rs.getString("nam_hoc"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private void showlhTK() {
		//Show Lớp Học Jcombobox
		try {
			Statement stm = conn.createStatement();
			String sql = "Select * from `lop_hoc` ";
			ResultSet rs = stm.executeQuery(sql);
			lophocSV.addItem("");
			while (rs.next()) {
				lophocSV.addItem(rs.getString("ma_lop"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private void shownhLH() {
		// Show Năm Học Của Lớp JCombobox
		try {
			namhocLH.addItem("Tất Cả");
			Statement stm = conn.createStatement();
			String sql="select distinct `nam_hoc` from `lop_hoc`";
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				namhocLH.addItem(rs.getString("nam_hoc"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void loadLopHoc() {
		//Get Dữ Liệu Từ Database
		try {
			Statement statement = conn.createStatement();
			ResultSet resultLH = statement.executeQuery("select * from lop_hoc");
			while (resultLH.next()) {
				arrLH.add(new LopHoc(resultLH.getString("ma_lop"), resultLH.getString
				("ten_lop"),resultLH.getString("nam_hoc"),resultLH.getString("mo_ta")));
			}
			for (LopHoc x : arrLH) {
				defTableLH.addRow(new String[]
				{ x.getMaLop(), x.getTenLop(), x.getNamhocLop(), x.getMotaLop()});
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void lophocEvent() {
		//Add Event Tab Lớp Học
		tableLH.addMouseListener(eventTblLH);
		themLop.addActionListener(eventThemLop);
		suaLop.addActionListener(eventSuaLop);
		xoaLop.addActionListener(eventXoaLop);
		resetLop.addActionListener(eventResetLop);
	}
	private void thongkeEvent() {
		//Add Event Tab Thống Kê
		namhocSV.addActionListener(eventNamHocSV);
		lophocSV.addActionListener(eventLopHocSV);
		namhocLH.addActionListener(eventNamHocLH);
	}
	private void sinhvienEvent() {
		//Add Event Tab Sinh Viên
		tableSV.addMouseListener(eventTblSV);
		thanhpho.addActionListener(tpEvent);
		quan.addActionListener(quanEvent);
		lopsvCBO.addActionListener(chonLop);
		themSV.addActionListener(eventThemSV);
		suaSV.addActionListener(eventSuaSV);
		xoaSV.addActionListener(eventXoaSV);
		resetSV.addActionListener(eventResetSV);
		timSV.addActionListener(eventTimSV);
	}
	ActionListener eventNamHocSV = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			defTableTK1.setRowCount(0);
			String namhoc = (String)namhocSV.getItemAt(namhocSV.getSelectedIndex());
			if(namhoc=="Tất Cả") {
				try {
					Statement stm = conn.createStatement();
					String sql="select * from `sinh_vien`";
					ResultSet rs = stm.executeQuery(sql);
					while(rs.next()) {
						Statement stm2 = conn.createStatement();
						String sql2="select * from `bang_diem` where ma_sv='"
						+rs.getString("codesv")+"'";
						ResultSet rs2 = stm2.executeQuery(sql2);
						while(rs2.next()) {
							int lp0= Integer.parseInt(rs2.getString("lp0"));
							int lp1= Integer.parseInt(rs2.getString("lp1"));
							int lp2= Integer.parseInt(rs2.getString("lp2"));
							int lp3= Integer.parseInt(rs2.getString("lp3"));
							int lp4= Integer.parseInt(rs2.getString("lp4"));
							int lp5= Integer.parseInt(rs2.getString("lp5"));
							int lp6= Integer.parseInt(rs2.getString("lp6"));
							int e4it= Integer.parseInt(rs2.getString("E4IT"));
							float diemtb = (lp0+lp1+lp2+lp3+lp4+lp5+lp6+e4it)/8;
							String xeploai;
							if(diemtb<=4.9) {
								xeploai="Yếu";
							}
							else if(diemtb<=6.4) {
								xeploai="Trung Bình";
							}
							else if(diemtb<=7.9) {
								xeploai="Khá";
							}
							else {
								xeploai="Giỏi";
							}
							String diemtbm = Float.toString(diemtb);
							String row[]= {rs.getString("codesv"),rs.getString("namesv"),
								diemtbm,xeploai};
							defTableTK1.addRow(row);
							}
					}
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
			}
			try {
				Statement stm = conn.createStatement();
				String sql="select * from `lop_hoc` where `nam_hoc` ='"+namhoc+"'";
				ResultSet rs= stm.executeQuery(sql);
				while(rs.next()) {
					Statement stm1 = conn.createStatement();
					String sql1 = "select * from `sinh_vien` where `classsv`='"
					+rs.getString("ma_lop")+"'";
					ResultSet rs1 = stm1.executeQuery(sql1);
					while(rs1.next()) {
						Statement stm2 = conn.createStatement();
						String sql2="select * from `bang_diem` where ma_sv='"
						+rs1.getString("codesv")+"'";
						ResultSet rs2 = stm2.executeQuery(sql2);
						while(rs2.next()) {
							int lp0= Integer.parseInt(rs2.getString("lp0"));
							int lp1= Integer.parseInt(rs2.getString("lp1"));
							int lp2= Integer.parseInt(rs2.getString("lp2"));
							int lp3= Integer.parseInt(rs2.getString("lp3"));
							int lp4= Integer.parseInt(rs2.getString("lp4"));
							int lp5= Integer.parseInt(rs2.getString("lp5"));
							int lp6= Integer.parseInt(rs2.getString("lp6"));
							int e4it= Integer.parseInt(rs2.getString("E4IT"));
							float diemtb = (lp0+lp1+lp2+lp3+lp4+lp5+lp6+e4it)/8;
							String xeploai;
							if(diemtb<=4.9) {
								xeploai="Yếu";
							}
							else if(diemtb<=6.4) {
								xeploai="Trung Bình";
							}
							else if(diemtb<=7.9) {
								xeploai="Khá";
							}
							else {
								xeploai="Giỏi";
							}
							String diemtbm = Float.toString(diemtb);
							String row[]= {rs1.getString("codesv"),rs1.getString("namesv")
								,diemtbm,xeploai};
							defTableTK1.addRow(row);
							}
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	};
	ActionListener eventLopHocSV = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			defTableTK1.setRowCount(0);
			String lophoc = (String) lophocSV.getItemAt(lophocSV.getSelectedIndex());
			try {
				Statement stm = conn.createStatement();
				String sql="select * from `sinh_vien` where `classsv`='"+lophoc+"'";
				ResultSet rs = stm.executeQuery(sql);
				while(rs.next()) {
					Statement stm1 = conn.createStatement();
					String sql1="select * from `bang_diem` where `ma_sv`='"+rs.getString("codesv")+"'";
					ResultSet rs1 = stm1.executeQuery(sql1);
					while(rs1.next()) {
						int lp0= Integer.parseInt(rs1.getString("lp0"));
						int lp1= Integer.parseInt(rs1.getString("lp1"));
						int lp2= Integer.parseInt(rs1.getString("lp2"));
						int lp3= Integer.parseInt(rs1.getString("lp3"));
						int lp4= Integer.parseInt(rs1.getString("lp4"));
						int lp5= Integer.parseInt(rs1.getString("lp5"));
						int lp6= Integer.parseInt(rs1.getString("lp6"));
						int e4it= Integer.parseInt(rs1.getString("E4IT"));
						float diemtb = (lp0+lp1+lp2+lp3+lp4+lp5+lp6+e4it)/8;
						String xeploai;
						if(diemtb<=4.9) {
							xeploai="Yếu";
						}
						else if(diemtb<=6.4) {
							xeploai="Trung Bình";
						}
						else if(diemtb<=7.9) {
							xeploai="Khá";
						}
						else {
							xeploai="Giỏi";
						}
						String diemtbm = Float.toString(diemtb);
						String row[]= {rs1.getString("ma_sv"),rs.getString("namesv"),diemtbm,xeploai};
						defTableTK1.addRow(row);
						}
				}	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	};
	ActionListener eventNamHocLH = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			defTableTK2.setRowCount(0);
			String namhoc = (String) namhocLH.getItemAt(namhocLH.getSelectedIndex());
			if(namhoc=="Tất Cả") {
				try {
					Statement stm2 = conn.createStatement();
					String sql2 = "select * from `lop_hoc`";
					ResultSet rs2 = stm2.executeQuery(sql2);
					while(rs2.next()) {
						Statement stm3 = conn.createStatement();
						String sql3 ="SELECT COUNT(`codeSV`),`classSV`FROM`sinh_vien`WHERE`classSV`='"
						+rs2.getString("ma_lop")+"' GROUP BY `classSV`";
						ResultSet rs3 = stm3.executeQuery(sql3);
						while(rs3.next()) {
							String row[]= {rs2.getString("ma_lop"),rs2.getString("mo_ta"),
								rs3.getString("COUNT(`codeSV`)")};
							defTableTK2.addRow(row);
						}
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			try {
				Statement stm = conn.createStatement();
				String sql = "select * from `lop_hoc` where `nam_hoc`='"+namhoc+"'";
				ResultSet rs = stm.executeQuery(sql);
				while(rs.next()) {
					Statement stm1 = conn.createStatement();
					String sql1 ="SELECT COUNT(`codeSV`),`classSV`FROM`sinh_vien`WHERE`classSV`='"
					+rs.getString("ma_lop")+"' GROUP BY `classSV`";
					ResultSet rs1 = stm1.executeQuery(sql1);
					while(rs1.next()) {
						String row[]= {rs.getString("ma_lop"),rs.getString("mo_ta"),
							rs1.getString("COUNT(`codeSV`)")};
						defTableTK2.addRow(row);
					}
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	};
	ActionListener eventTimSV = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String timsv=txttimSV.getText();
			if(txttimSV.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null,"Bạn Chưa Nhập Thông Tin");
			}
			else {
				try {
					Statement stm = conn.createStatement();
					String sql = "Select * from `sinh_vien` where `codesv` like '%"+timsv+
							"%' or `namesv` like'%"+timsv+"%'";
					ResultSet svRS = stm.executeQuery(sql);
					defTableSV.setRowCount(0);
					while(svRS.next()) {
						String row[]= {svRS.getString("codesv"),svRS.getString("namesv"),
								svRS.getString("addresssv"),svRS.getString("wardSV"),
								svRS.getString("countysv"),svRS.getString("citySV"),
								svRS.getString("phonenumbSV"),svRS.getString("emailSV"),
								svRS.getString("classsv")};
						defTableSV.addRow(row);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
	};
	ActionListener eventSuaND = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			String lopsv = txtlopsvND.getText();
			String masv = txtmasvND.getText();
			String lp0 = txtLP0.getText();
			String lp1 = txtLP1.getText();
			String lp2 = txtLP2.getText();
			String lp3 = txtLP3.getText();
			String lp4 = txtLP4.getText();
			String lp5 = txtLP5.getText();
			String lp6 = txtLP6.getText();
			String e4it = txtE4IT.getText();
			try {
				Statement stm = conn.createStatement();
				String sql="update `bang_diem` set `lp0`='"+lp0+"',`lp1`='"+lp1+"',`lp2`='"+lp2+
					"',`lp3`='"+lp3+"',`lp4`='"+lp4+"',`lp5`='"+lp5+"',`lp6`='"+lp6+
					"',`e4it`='"+e4it+"' where `lop_sv`='"+lopsv+"' and `ma_sv`='"
					+masv+"'";
				int x = stm.executeUpdate(sql);
				if(x>0) {
					JOptionPane.showMessageDialog(null, "Sửa Thành Công!");
					for(BangDiem z: arrBD) {
						if(lopsv.equals(z.getLop_sv())) {
							if(masv.equals(z.getMa_sv())) {
								z.setLp0(lp0);
								z.setLp1(lp1);
								z.setLp2(lp2);
								z.setLp3(lp3);
								z.setLp4(lp4);
								z.setLp5(lp5);
								z.setLp6(lp6);
								z.setE4IT(e4it);
							}
						}
					}
					defTableND.setRowCount(0);
					for(BangDiem f: arrBD) {
						String row[]= {f.getLop_sv(),f.getMa_sv(),f.getLp0(),f.getLp1(),f.getLp2
							(),f.getLp3(),f.getLp4(),f.getLp5(),f.getLp6(),f.getE4IT()};
						defTableND.addRow(row);
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	};
	ActionListener eventResetND = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			txtLP0.setText("");
			txtLP1.setText("");
			txtLP2.setText("");
			txtLP3.setText("");
			txtLP4.setText("");
			txtLP5.setText("");
			txtLP6.setText("");
			txtE4IT.setText("");
		}
	};
	MouseListener eventTblND = new MouseListener() {
		public void mouseClicked(MouseEvent arg0) {
			for(int i = tableND.getSelectedRow();i<=tableND.getSelectedRow();i++) {
				for(int y=0;y<tableND.getColumnCount();y++) {
					String value=(String)tableND.getValueAt(i,y);
					if(y==0) {
						txtlopsvND.setText(value);
					}
					if(y==1) {
						txtmasvND.setText(value);
					}
					if(y==2) {
						txtLP0.setText(value);
					}
					if(y==3) {
						txtLP1.setText(value);
					}
					if(y==4) {
						txtLP2.setText(value);
					}
					if(y==5) {
						txtLP3.setText(value);
					}
					if(y==6) {
						txtLP4.setText(value);
					}
					if(y==7) {
						txtLP5.setText(value);
					}
					if(y==8) {
						txtLP6.setText(value);
					}
					if(y==9) {
						txtE4IT.setText(value);
					}
				}
			}
		}
		public void mouseEntered(MouseEvent e) {
				
		}
		public void mouseExited(MouseEvent e) {
			
		}
		public void mousePressed(MouseEvent e) {
			
		}
		public void mouseReleased(MouseEvent e) {
				
		}
	};
	MouseListener eventTblMH = new MouseListener() {
		public void mouseClicked(MouseEvent e) {
			for(int i = tableMH.getSelectedRow();i<=tableMH.getSelectedRow();i++) {
				for(int y =0;y<tableMH.getColumnCount();y++) {
					String value = (String)tableMH.getValueAt(i,y);
					if(y==0) {
						txtmaMH.setText(value);
					}
					if(y==1) {
						txttenMH.setText(value);
					}
					if(y==2) {
						txttinchiMH.setText(value);
					}
					if(y==3) {
						txttimeMH.setText(value);
					}
				}
			}
		}
		public void mouseEntered(MouseEvent arg0) {			
		}
		public void mouseExited(MouseEvent arg0) {	
		}
		public void mousePressed(MouseEvent arg0) {	
		}
		public void mouseReleased(MouseEvent arg0) {	
		}
	};
	ActionListener eventThemMH = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			String maMh = txtmaMH.getText();
			String tenMh = txttenMH.getText();
			String tinchiMh = txttinchiMH.getText();
			String timeMh = txttimeMH.getText();
			try {
				Statement stm = conn.createStatement();
				String sql ="Insert into `mon_hoc`(`ma_mh`,`ten_mh`,`tin_chi_mh`,`time_mh`"
						+ ")values('"+maMh+"','"+tenMh+"','"+tinchiMh+"','"+timeMh+"')";
				int x = stm.executeUpdate(sql);
				if(x>0) {
					JOptionPane.showMessageDialog(null, "Thêm Mới Thành Công !");
					MonHoc mh = new MonHoc(maMh,tenMh,tinchiMh,timeMh);
					arrMH.add(mh);
					defTableMH.setRowCount(0);
					showTableMH();
					cbomamhTL.removeAllItems();
					showmaMH();
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	};
	ActionListener eventSuaMH = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String maMh = txtmaMH.getText();
			String tenMh = txttenMH.getText();
			String tinchiMh = txttinchiMH.getText();
			String timeMh = txttimeMH.getText();
			try {
				Statement stm = conn.createStatement();
				String sql="update`mon_hoc`set`ten_mh`='"+tenMh+"',`tin_chi_mh`='"+tinchiMh
						+"',`time_mh`='"+timeMh+"' where `ma_mh`='"+maMh+"'";
				int x = stm.executeUpdate(sql);
				if(x>0) {
					JOptionPane.showMessageDialog(null,"Sửa Thành Công!");
					for(MonHoc z: arrMH) {
						if(txtmaMH.getText().equals(z.getMaMh())) {
							z.setNameMh(maMh);
							z.setTinchiMh(tinchiMh);
							z.setTimeMh(timeMh);
						}
					}
					defTableMH.setRowCount(0);
					showTableMH();
				}
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	};
	ActionListener eventXoaMH = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String maMh = txtmaMH.getText();
			try {
				Statement stm = conn.createStatement();
				String sql="delete from `mon_hoc` where `ma_mh`='"+maMh+"'";
				int x = stm.executeUpdate(sql);
				if(x>0) {
					JOptionPane.showMessageDialog(null, "Xóa Thành Công!");
					for(MonHoc z: arrMH) {
						if(maMh.equals(z.getMaMh())) {
							arrMH.remove(z);
							break;
						}
					}
					defTableMH.setRowCount(0);
					showTableMH();
				}
			} 
			catch (SQLException ex) {
				ex.printStackTrace();
			}
			
		}
	};
	ActionListener eventResetMH = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			txtmaMH.setText("");
			txttenMH.setText("");
			txttimeMH.setText("");
			txttinchiMH.setText("");
		}
	};
	MouseListener eventTblSV = new MouseListener() {
		public void mouseClicked(MouseEvent e) {
			for(int i = tableSV.getSelectedRow();i<=tableSV.getSelectedRow();i++) {
				for(int y=0;y<tableSV.getColumnCount();y++) {
					String valueSV=(String)tableSV.getValueAt(i,y);
					if(y==0) {
						textmaSV.setText(valueSV);
					}
					if(y==1) {
						texttenSV.setText(valueSV);
					}
					if(y==2) {
						textdiachiSV.setText(valueSV);
					}
					if(y==3) {
						phuong.setSelectedItem(valueSV);
					}
					if(y==4) {
						quan.setSelectedItem(valueSV);
					}
					if(y==5){
						thanhpho.setSelectedItem(valueSV);
					}
					if(y==6) {
						textsdtSV.setText(valueSV);
					}
					if(y==7) {
						textemailSV.setText(valueSV);
					}
					if(y==8) {
						cboLop.setSelectedItem(valueSV);
					}
				}
			}
		}
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub	
		}
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub	
		}
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub	
		}
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}
	};
	MouseListener eventTblLH = new MouseListener() {
		public void mouseClicked(MouseEvent e) {
			for (int i=tableLH.getSelectedRow();i<= tableLH.getSelectedRow();i++) {
				for (int y = 0; y < tableLH.getColumnCount(); y++) {
					String valueLH = (String) tableLH.getValueAt(i, y);
					if (y == 0) {
						textmaLop.setText(valueLH);
					}
					if (y == 1) {
						texttenLop.setText(valueLH);
					}
					if (y == 2) {
						textnamHoc.setText(valueLH);
					}
					if (y == 3) {
						textmoTa.setText(valueLH);
					}
				}
			}
		}
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}
		public void mouseReleased(MouseEvent arg0) {
			// 
		}
	};
	ActionListener eventThemLop = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		try {
			String maLop = textmaLop.getText();
			String tenLop = texttenLop.getText();
			String namHoc = textnamHoc.getText();
			String moTa = textmoTa.getText();
			String sql="insert into`lop_hoc`(`ma_lop`,`ten_lop`,`nam_hoc`,`mo_ta`) values('"
			+ textmaLop.getText() + "','" + texttenLop.getText() + "','" + 
				textnamHoc.getText() + "','"+ textmoTa.getText() + "')";
			Statement statement = conn.createStatement();
			int x = statement.executeUpdate(sql);
			if (x > 0) {
				int trunglap=0;
				for(LopHoc g: arrLH) {
					if(maLop.equals(g.getMaLop())) {
						trunglap=1;
					}
				}
				if(textmaLop.getText().isEmpty()||texttenLop.getText().isEmpty()||
					textnamHoc.getText().isEmpty()||textmoTa.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"Bạn Chưa Nhập Đủ Thông Tin!");
				}
				else if(trunglap>0) {
					JOptionPane.showMessageDialog(null,"Mã Lớp Học Đã Có!");
				}
				else {
					JOptionPane.showMessageDialog(null, "Thêm Mới Thành Công!");
					LopHoc lh = new LopHoc(maLop, tenLop, namHoc, moTa);
					arrLH.add(lh);
					defTableLH.setRowCount(0);
					for(LopHoc f :arrLH) {
						String[]row={f.getMaLop(),f.getTenLop(),f.getNamhocLop(),f.getMotaLop()};
						defTableLH.addRow(row);
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		}
	};
	ActionListener eventSuaLop = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
			String maLop = textmaLop.getText();
			String tenLop = texttenLop.getText();
			String namHoc = textnamHoc.getText();
			String moTa = textmoTa.getText();
			String sql = "UPDATE lop_hoc SET ma_lop ='"+maLop+"', ten_lop='"+tenLop+
					"', nam_hoc='"+namHoc+"',mo_ta='"+moTa+"' WHERE ma_lop='"+maLop+"'";
			Statement statement = conn.createStatement();
			int x = statement.executeUpdate(sql);
			if(x>0) {
				JOptionPane.showMessageDialog(null, "Update thành công!");
				for(LopHoc z: arrLH) {
					if(textmaLop.getText().equals(z.getMaLop())) {
						z.setMaLop(maLop);
						z.setTenLop(tenLop);
						z.setNamhocLop(namHoc);
						z.setMotaLop(moTa);
						defTableLH.setRowCount(0);
						}
					}
				for(LopHoc f :arrLH) {
					String[] row = {f.getMaLop(),f.getTenLop(),
						f.getNamhocLop(),f.getMotaLop()};
					defTableLH.addRow(row);
				}
			}
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	};
	ActionListener eventXoaLop = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				String maLop = textmaLop.getText();
				String sql = "delete from lop_hoc where `ma_lop`= '"+maLop+"'";
				Statement statement = conn.createStatement();
				int x = statement.executeUpdate(sql);
				if (x>0) {
					JOptionPane.showMessageDialog(null,"Xóa thành công!");
					for(LopHoc z: arrLH) {
						if(maLop.equals(z.getMaLop())) {
							arrLH.remove(z);
							defTableLH.setRowCount(0);
							for(LopHoc f :arrLH) {
								String[] row = {f.getMaLop(),f.getTenLop(),
									f.getNamhocLop(),f.getMotaLop()};
								defTableLH.addRow(row);	
							}
							break;
							}
						}
				}
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
	};
	ActionListener eventResetLop = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			textmaLop.setText("");
			textnamHoc.setText("");
			texttenLop.setText("");
			textmoTa.setText("");
		}
	};
	ActionListener chonLop = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			try {
				String tenLop = (String)lopsvCBO.getItemAt(lopsvCBO.getSelectedIndex());
				Statement statement = conn.createStatement();
				if(tenLop =="Tất Cả Các Lớp") {
					String sql = "select * from sinh_vien";
					ResultSet allRS = statement.executeQuery(sql);
					defTableSV.setRowCount(0);
					arrSV.clear();
					while(allRS.next()) {
					 SinhVien sv = new SinhVien(allRS.getString("codesv"),
							allRS.getString("namesv"),allRS.getString("addresssv"),
							allRS.getString("wardSV"),allRS.getString("countysv"),
							allRS.getString("citysv"),allRS.getString("phonenumbSV"),
							allRS.getString("emailSV"),allRS.getString("classsv"));
					 arrSV.add(sv);
					}
					for(SinhVien  x:arrSV) {
						String row[]= {x.getCodeSv(),x.getNameSv(),x.getAddressSv(),
								x.getWardSv(),x.getCountySv(),x.getCitySv(),
								x.getPhonenumbSv(),x.getEmailSv(),x.getClassSv()};
						defTableSV.addRow(row);
					}
				}
				else {
					String sql = "select * from sinh_vien where `classsv`='"+tenLop+"'";
					ResultSet chonLopRS = statement.executeQuery(sql);
					defTableSV.setRowCount(0);
					arrSV.clear();
					while(chonLopRS.next()) {
					SinhVien sv = new SinhVien(chonLopRS.getString("codesv"),
							chonLopRS.getString("namesv"),chonLopRS.getString("addresssv"),
							chonLopRS.getString("wardSV"),chonLopRS.getString("countysv"),
							chonLopRS.getString("citysv"),chonLopRS.getString("phonenumbSV"),
							chonLopRS.getString("emailSV"),chonLopRS.getString("classsv"));
					arrSV.add(sv);
					}
					for(SinhVien x: arrSV) {
						String row[]= {x.getCodeSv(),x.getNameSv(),x.getAddressSv(),
								x.getWardSv(),x.getCountySv(),x.getCitySv(),
								x.getPhonenumbSv(),x.getEmailSv(),x.getClassSv()};
						defTableSV.addRow(row);
					}
				}
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
	};
	ActionListener eventThemSV = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
				String codeSV = textmaSV.getText();
				String nameSV = texttenSV.getText();
				String addressSV = textdiachiSV.getText();
				String wardSV = (String) phuong.getItemAt(phuong.getSelectedIndex());
				String countySV =(String)quan.getItemAt(quan.getSelectedIndex());
				String citySV = (String) thanhpho.getItemAt(thanhpho.getSelectedIndex());
				String phonenumbSV = textsdtSV.getText();
				String emailSV = textemailSV.getText();
				String classSV = (String)cboLop.getItemAt(cboLop.getSelectedIndex());
				String sql = "insert into `sinh_vien`(`codesv`,`namesv`,`addresssv`,`wardsv`,"
						+ "`countysv`,`citysv`,`phonenumbsv`,`emailsv`,`classsv`)values('"
						+codeSV+"','"+nameSV+"','"+addressSV+"','"+wardSV+"','"+countySV+"','"+
						citySV+"','"+phonenumbSV+"','"+emailSV+"','"+classSV+"')";
				int ktTrungLap = 0;
				int ktSDT = 0;
				Pattern checkmail = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$"
						,Pattern.CASE_INSENSITIVE);
				Matcher mail = checkmail.matcher(emailSV);
				try {
					Integer.parseInt(phonenumbSV);
				}
				catch(NumberFormatException ex) {
					ktSDT = 1;
				}
				for(SinhVien z: arrSV) {
					if(codeSV.equals(z.getCodeSv())) {
						ktTrungLap = 1;
					}
				}
				if(codeSV.isEmpty()||nameSV.isEmpty()||addressSV.isEmpty()||phonenumbSV.isEmpty()
						||emailSV.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Hãy Nhập Đầy Đủ Thông Tin!",
							null,JOptionPane.WARNING_MESSAGE);
				}
				else if(ktTrungLap>0) {
					JOptionPane.showMessageDialog(null, "Mã Sinh Viên Đã Tồn Tại", null,
							JOptionPane.WARNING_MESSAGE);
				}
				else if(!mail.find()) {
					JOptionPane.showMessageDialog(null, "Email Không Hợp Lệ", null,
							JOptionPane.WARNING_MESSAGE);
				}
				else if(ktSDT>0) {
					JOptionPane.showMessageDialog(null,"Số Điện Thoại Chỉ Bao Gồm Số" , null,
							JOptionPane.WARNING_MESSAGE);
				}
				else if(phonenumbSV.length()>0 && (phonenumbSV.length()<10||
						phonenumbSV.length()>11)){
					JOptionPane.showMessageDialog(null, "Số Điện Thoại Chỉ Được 10-11 Số",null,
							JOptionPane.WARNING_MESSAGE);
				}
				else {
					String lopsv = (String)cboLop.getItemAt(cboLop.getSelectedIndex());
					String masv = textmaSV.getText();
					String lp0 = "0";
					String lp1 = "0";
					String lp2 = "0";
					String lp3 = "0";
					String lp4 = "0";
					String lp5 = "0";
					String lp6 = "0";
					String e4it = "0";
					try {
						Statement stm3 = conn.createStatement();
						String sql3 = "insert into `bang_diem`(`lop_sv`,`ma_sv`,`lp0`,`lp1`,`lp2`,"
								+ "`lp3`,`lp4`,`lp5`,`lp6`,`e4it`) values('"+lopsv+"','"+masv+
								"','"+lp0+"','"+lp1+"','"+lp2+"','"+lp3+"','"+lp4+"','"+lp5+"','"
								+lp6+"','"+e4it+"')";
						int x = stm3.executeUpdate(sql3);
						if(x>0) {
							JOptionPane.showMessageDialog(null, "Thêm Thành Công!");
							BangDiem bd = new BangDiem(lopsv,masv,lp0,lp1,lp2,lp3,lp4,lp5,lp6,e4it);
							arrBD.add(bd);
							defTableND.setRowCount(0);
							for(BangDiem j:arrBD) {
								String row[]= {j.getLop_sv(),j.getMa_sv(),j.getLp0(),j.getLp1(),j.getLp2
										(),j.getLp3(),j.getLp4(),j.getLp5(),j.getLp6(),j.getE4IT()};
								defTableND.addRow(row);
								}
							}
						}
					catch (SQLException e) {
						e.printStackTrace();
					}
					try {
						Statement statement = conn.createStatement();
						int x = statement.executeUpdate(sql);
						if(x>0) {
						SinhVien sv = new SinhVien(codeSV,nameSV,addressSV,wardSV,countySV,citySV,
								phonenumbSV,emailSV,classSV);
						arrSV.add(sv);
						defTableSV.setRowCount(0);
						textmaSV.setText("");
						texttenSV.setText("");
						textdiachiSV.setText("");
						textsdtSV.setText("");
						textemailSV.setText("");
							try {
								String sql2="select * from sinh_vien";
								ResultSet svRS = statement.executeQuery(sql2);
								while(svRS.next()) {
									String row[]= {svRS.getString("codesv"),svRS.getString("namesv"),
											svRS.getString("addresssv"),svRS.getString("wardSV"),
											svRS.getString("countysv"),svRS.getString("citySV"),
											svRS.getString("phonenumbSV"),svRS.getString("emailSV"),
											svRS.getString("classsv")};
									defTableSV.addRow(row);
								}
							}
							catch(Exception ex) {
								ex.printStackTrace();
							}
						}
					}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
		}
	};
	ActionListener eventSuaSV = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			String codeSV = textmaSV.getText();
			String nameSV = texttenSV.getText();
			String addressSV = textdiachiSV.getText();
			String wardSV = (String) phuong.getItemAt(phuong.getSelectedIndex());
			String countySV =(String)quan.getItemAt(quan.getSelectedIndex());
			String citySV = (String) thanhpho.getItemAt(thanhpho.getSelectedIndex());
			String phonenumbSV = textsdtSV.getText();
			String emailSV = textemailSV.getText();
			String classSV = (String)cboLop.getItemAt(cboLop.getSelectedIndex());
			String sql="Update sinh_vien set `namesv`='"+nameSV+"',`addresssv`='"+addressSV+
					"',`wardsv`='"+wardSV+"',`countysv`='"+countySV+"',`citysv`='"+citySV+
					"',`phonenumbsv`='"+phonenumbSV+"',`emailsv`='"+emailSV+
					"',`classsv`='"+classSV+"' where `codesv`='"+codeSV+"'";
			try {
			Statement statement = conn.createStatement();
			int x = statement.executeUpdate(sql);
			if(x>0) {
				for(SinhVien z: arrSV) {
					if(codeSV==z.getCodeSv()) {
						z.setCodeSv(codeSV);
						z.setNameSv(nameSV);
						z.setAddressSv(addressSV);
						z.setWardSv(wardSV);
						z.setCountySv(countySV);
						z.setCitySv(citySV);
						z.setPhonenumbSv(phonenumbSV);
						z.setEmailSv(emailSV);
						z.setClassSv(classSV);
					}
				}
				JOptionPane.showMessageDialog(null, "Sửa Thành Công!");
				defTableSV.setRowCount(0);
				try {
					String sql2="select * from sinh_vien";
					ResultSet svRS = statement.executeQuery(sql2);
					while(svRS.next()) {
						String row[]= {svRS.getString("codesv"),svRS.getString("namesv"),
								svRS.getString("addresssv"),svRS.getString("wardSV"),
								svRS.getString("countysv"),svRS.getString("citySV"),
								svRS.getString("phonenumbSV"),svRS.getString("emailSV"),
								svRS.getString("classsv")};
						defTableSV.addRow(row);
					}
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
			}
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	};
	ActionListener eventXoaSV = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			try {
				String codeSV = textmaSV.getText();
				Statement statement = conn.createStatement();
				String sql="delete from `sinh_vien` where `codesv`='"+codeSV+"'";
				int x = statement.executeUpdate(sql);
				if(x>0) {
					JOptionPane.showMessageDialog(null,"Xóa Thành Công!");
					for(SinhVien z: arrSV) {
						if(z.getCodeSv()==codeSV) {
							arrSV.remove(z);
							break;
						}
					}
					defTableSV.setRowCount(0);
					try {
						String masv =textmaSV.getText();
						Statement stm = conn.createStatement();
						String sql1="delete from `bang_diem` where `ma_sv`='"+masv+"'";
						int p = stm.executeUpdate(sql1);
						if(p>0) {
							for(BangDiem h: arrBD) {
								if(masv.equals(h.getMa_sv())) {
									arrBD.remove(h);
									break;
								}
							}
							defTableND.setRowCount(0);
							for(BangDiem f:arrBD) {
								String row[]= {f.getLop_sv(),f.getMa_sv(),f.getLp0(),f.getLp1(),f.getLp2
									(),f.getLp3(),f.getLp4(),f.getLp5(),f.getLp6(),f.getE4IT()};
								defTableND.addRow(row);
							}
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
					try {
						String sql2="select * from sinh_vien";
						ResultSet svRS = statement.executeQuery(sql2);
						while(svRS.next()) {
							String row[]= {svRS.getString("codesv"),svRS.getString("namesv"),
									svRS.getString("addresssv"),svRS.getString("wardSV"),
									svRS.getString("countysv"),svRS.getString("citySV"),
									svRS.getString("phonenumbSV"),svRS.getString("emailSV"),
									svRS.getString("classsv")};
							defTableSV.addRow(row);
						}
					}
					catch(Exception ex) {
						ex.printStackTrace();
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	};
	ActionListener eventResetSV = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			textmaSV.setText("");
			texttenSV.setText("");
			textdiachiSV.setText("");
			textsdtSV.setText("");
			textemailSV.setText("");
		}
	};
	ActionListener tpEvent = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		try {
			String tenTP = (String)thanhpho.getItemAt(thanhpho.getSelectedIndex());
			Statement statement = conn.createStatement();			
			ResultSet quanRS=statement.executeQuery("SELECT `devvn_quanhuyen`.name "
			+"FROM`devvn_tinhthanhpho` INNER JOIN `devvn_quanhuyen`WHERE `devvn_tinhthanhpho"
			+ "`.name='"+tenTP+"' AND devvn_quanhuyen.matp=devvn_tinhthanhpho.matp");
			quan.removeAllItems();
			while(quanRS.next()) {
				quan.addItem(new String(quanRS.getString("name")));
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		}
	};
	ActionListener quanEvent = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		try {
			String tenQuan = (String)quan.getItemAt(quan.getSelectedIndex());
			Statement statement = conn.createStatement();
			String sql = "Select `devvn_xaphuongthitran`.name from devvn_quanhuyen INNER JOIN"
					+ "`devvn_xaphuongthitran` where devvn_quanhuyen.name ='"+tenQuan+"' and "
							+ "devvn_xaphuongthitran.maqh=devvn_quanhuyen.maqh";
			ResultSet phuongRS=statement.executeQuery(sql);
			phuong.removeAllItems();
			while(phuongRS.next()) {
			phuong.addItem(phuongRS.getString("name"));
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		}
	};
	MouseListener eventTblTL = new MouseListener() {
		public void mouseClicked(MouseEvent arg0) {
			for(int i = tableTL.getSelectedRow();i<=tableTL.getSelectedRow();i++) {
				for(int y =0;y<tableTL.getColumnCount();y++) {
					String value = (String)tableTL.getValueAt(i,y);
					if(y==0) {
						cbomalhTL.setSelectedItem(value);
					}
					if(y==1) {
						cbomamhTL.setSelectedItem(value);
					}
					if(y==2) {
						txttenmhTL.setText(value);
					}
				}
			}
		}
		public void mouseEntered(MouseEvent arg0) {	
		}
		public void mouseExited(MouseEvent arg0) {	
		}
		public void mousePressed(MouseEvent arg0) {	
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	};
	ActionListener eventcbomamhTL = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				String mamhTL = (String) cbomamhTL.getItemAt(cbomamhTL.getSelectedIndex());
			try {
				Statement stm = conn.createStatement();
				String sql="Select * from `mon_hoc` where `ma_mh`='"+mamhTL+"'";
				ResultSet rs = stm.executeQuery(sql);
				while(rs.next()) {
					txttenmhTL.setText(rs.getString("ten_mh"));
				}
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	};
	ActionListener eventThemTL = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			String malop = (String) cbomalhTL.getItemAt(cbomalhTL.getSelectedIndex());
			String mamon = (String) cbomamhTL.getItemAt(cbomamhTL.getSelectedIndex());
			String tenmh = txttenmhTL.getText();
			try {
				Statement stm = conn.createStatement();
				String sql="Insert mon_hoc_tung_lop(`ma_lop`,`ma_mon`,`ten_mh`) values('"
				+malop+"','"+mamon+"','"+tenmh+"') ";
				int x=stm.executeUpdate(sql);
				if(x>0) {
					JOptionPane.showMessageDialog(null, "Thêm Môn Học Thành Công!");
					defTableTL.setRowCount(0);
					showTableTL();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	};
	ActionListener eventSuaTL = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			try {
				String malop = (String) cbomalhTL.getItemAt(cbomalhTL.getSelectedIndex());
				String mamon = (String) cbomamhTL.getItemAt(cbomamhTL.getSelectedIndex());
				String tenmh = txttenmhTL.getText();
				Statement stm = conn.createStatement();
				String sql = "update mon_hoc_tung_lop set `ma_mon`='"+mamon+"',`ten_mh`='"
				+tenmh+"' where `ma_lop`='"+malop+"'";
				int x = stm.executeUpdate(sql);
				if(x>0) {
					JOptionPane.showMessageDialog(null, "Sửa Thành Công!");
					defTableTL.setRowCount(0);
					showTableTL();
				}
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	};
	ActionListener eventXoaTL = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			String malop = (String) cbomalhTL.getItemAt(cbomalhTL.getSelectedIndex());
			try {
				Statement stm = conn.createStatement();
				String sql="delete from `mon_hoc_tung_lop` where `ma_lop`='"+malop+"'";
				int x = stm.executeUpdate(sql);
				if(x>0) {
					JOptionPane.showMessageDialog(null, "Xóa Thành Công!");
					defTableTL.setRowCount(0);
					showTableTL();
				}
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	};
}