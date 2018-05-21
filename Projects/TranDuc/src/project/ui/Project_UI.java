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
	ArrayList<LopHoc> arrLH = new ArrayList<LopHoc>();
	ArrayList<SinhVien> arrSV = new ArrayList<SinhVien>();
	ArrayList<MonHoc> arrMH = new ArrayList<MonHoc>();
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
	
	JPanel actionLH = new JPanel();
	JPanel settingLH = new JPanel();
	JPanel btnstLH = new JPanel();
	JPanel maLop, tenLop, namHoc, moTa;
	JTextField textmaLop, texttenLop, textnamHoc, textmoTa;
	JLabel titmaLop, tittenLop, titnamHoc, titmoTa;
	JButton themLop, suaLop, xoaLop, resetLop;
	JLabel tittleLH = new JLabel("Chương trình quản lý lớp học");
	DefaultTableModel defTableLH = new DefaultTableModel();
	JTable tableLH = new JTable();
	JScrollPane scrPaneLH;
		
	JPanel maSV, tenSV, diachiSV, phuongSV, quanSV, thanhphoSV, sdtSV, emailSV, lopSV;
	JComboBox cboLop;
	JComboBox phuong;
	JComboBox quan;
	JComboBox thanhpho;
	JPanel svPN;
	JLabel svLB;
	JComboBox lopsvCBO;
	
	JButton themSV, suaSV, xoaSV, resetSV;
	JTextField textmaSV, texttenSV, textdiachiSV, textsdtSV, textemailSV;
	JLabel titmaSV, tittenSV, titdiachiSV, titphuongSV, titquanSV, 
	titthanhphoSV, titsdtSV, titemailSV, titlopSV;
	JLabel tittleSV = new JLabel("Chương trình quản lý sinh viên");
	JPanel actionSV = new JPanel();
	JPanel settingSV = new JPanel();
	JPanel btnstSV = new JPanel();
	DefaultTableModel defTableSV = new DefaultTableModel();
	JTable tableSV = new JTable(defTableSV);
	JScrollPane scrPaneSV = new JScrollPane(tableSV);
	
	JLabel tittleMH,titmaMH,tittenMH,tittinchiMH,tittimeMH;
	JPanel actionMH,settingMH,btnstMH;
	JTextField txtmaMH,txttenMH,txttinchiMH,txttimeMH;
	JButton themMH,suaMH,xoaMH,resetMH;
	DefaultTableModel defTableMH = new DefaultTableModel();
	JTable tableMH = new JTable(defTableMH);
	JScrollPane scrPaneMH = new JScrollPane(tableMH);
	
	public Project_UI(String tittle) {
		super(tittle);
		connectDB();
		setContent();
		lophoc_UI();
		lophocEvent();
		sinhvien_UI();
		sinhvienEvent();
		monhoc_UI();
		monhocEvent();
		thongke_UI();
		thongkeEvent();
		setDisplay();
	}
	public void connectDB() {
		conn=ConnectDB.getConnect("Localhost",
				"project_quanlysv","Project_QuanLySv","12345");
		if (conn != null) {
			String result = "Kết nối thành công Database";
			System.out.println(result);
		} else {
			JOptionPane.showMessageDialog(null, "Không kết nối được vs Database");
		}
	}

	public void setDisplay() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1900, 1000);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setMinimumSize(new Dimension(1900, 1000));
	}

	public void setContent() {
		tabbed = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbed.addTab("Quản Lý Lớp Học", lopAnh, lophocQL, "Quản Lý Lớp Học");
		tabbed.addTab("Quản Lý Sinh Viên", sinhvienAnh, sinhvienQL, "Quản Lý Sinh Viên");
		tabbed.addTab("Môn Học", monhocAnh, monhocQL, "Môn Học");
		tabbed.addTab("Nhập Điểm", diemsoAnh, nhapdiem, "Nhập Điểm");
		tabbed.addTab("Thống Kê", thongkeAnh, thongke, "Thống Kê");
		lophocQL.setLayout(new BoxLayout(lophocQL, BoxLayout.Y_AXIS));
		sinhvienQL.setLayout(new BoxLayout(sinhvienQL, BoxLayout.Y_AXIS));
		monhocQL.setLayout(new BoxLayout(monhocQL, BoxLayout.Y_AXIS));
		thongke.setLayout(new BoxLayout(thongke, BoxLayout.Y_AXIS));
		con = getContentPane();
		con.add(tabbed);
		tabbed.setFont(new Font("Courier New", Font.CENTER_BASELINE, 26));
	}
	
	public ArrayList<LopHoc> loadLopHoc() {
		ArrayList<LopHoc> arr = new ArrayList<>();
		Statement statement;
		try {
			statement = conn.createStatement();
			ResultSet resultLH = statement.executeQuery("select * from lop_hoc");
			while (resultLH.next()) {
				arr.add(new LopHoc(resultLH.getString("ma_lop"), resultLH.getString
				("ten_lop"),resultLH.getString("nam_hoc"),resultLH.getString("mo_ta")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}

	public void lophoc_UI() {
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
		textmaLop.setPreferredSize(new Dimension(75, 35));
		titmaLop.setText("Mã Lớp");
		titmaLop.setFont(new Font("Courier New", Font.BOLD, 20));
		maLop = new JPanel();
		maLop.add(titmaLop);
		maLop.add(textmaLop);
		settingLH.add(maLop);

		tittenLop = new JLabel();
		texttenLop = new JTextField(50);
		texttenLop.setPreferredSize(new Dimension(75, 35));
		tittenLop.setText("Tên Lớp");
		tittenLop.setFont(new Font("Courier New", Font.BOLD, 20));
		tenLop = new JPanel();
		tenLop.add(tittenLop);
		tenLop.add(texttenLop);
		settingLH.add(tenLop);

		titnamHoc = new JLabel();
		textnamHoc = new JTextField(50);
		textnamHoc.setPreferredSize(new Dimension(75, 35));
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
		arrLH = loadLopHoc();
		for (LopHoc x : arrLH) {
			defTableLH.addRow(new String[]
			{ x.getMaLop(), x.getTenLop(), x.getMotaLop(), x.getNamhocLop() });
		}
		Border bor1 = BorderFactory.createEtchedBorder(Color.BLACK, Color.WHITE);
		TitledBorder tittle = new TitledBorder(bor1, "Thông Tin Lớp Học");
		actionLH.setBorder(tittle);
		tittle.setTitleFont(new Font("Courier New", Font.BOLD, 20));
		tableLH.setModel(defTableLH);
		scrPaneLH = new JScrollPane(tableLH);
		lophocQL.add(scrPaneLH);
		lophocQL.add(actionLH);
	}

	public ArrayList<SinhVien> loadSinhVien() {
		 arrSV = new ArrayList<>();
		Statement statement;
		try {
			statement = conn.createStatement();
			ResultSet resultSV = statement.executeQuery("Select * from sinh_vien");
			while(resultSV.next()) {
				arrSV.add(new SinhVien(resultSV.getString("codesv"),
				resultSV.getString("namesv"),resultSV.getString("addressSv"),
				resultSV.getString("wardsv"),resultSV.getString("countysv"),
				resultSV.getString("citysv"),resultSV.getString("phonenumbsv"),
				resultSV.getString("emailSv"),resultSV.getString("classsv")));
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return arrSV;
	}
	public void sinhvien_UI() {
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
		try {
			Statement statement = conn.createStatement();
			ResultSet tpRS=statement.executeQuery("Select * from devvn_tinhthanhpho");
			while (tpRS.next()) {
				thanhpho.addItem(tpRS.getString("name"));
			}
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
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
		Border bor2 = BorderFactory.createEtchedBorder(Color.BLACK, Color.WHITE);
		TitledBorder tittle = new TitledBorder(bor2, "Thông Tin Sinh Viên");
		actionSV.setBorder(tittle);
		tittle.setTitleFont(new Font("Courier New", Font.BOLD, 20));
		
		svLB = new JLabel("Chọn Lớp");
		svLB.setFont(new Font("",Font.BOLD,20));
		svPN = new JPanel();
		svPN.add(svLB);
		svPN.add(lopsvCBO);
		sinhvienQL.add(tittleSV);
		sinhvienQL.add(svPN);
		sinhvienQL.add(scrPaneSV);
		sinhvienQL.add(actionSV);

	}
	private void showLopSvCbo() {
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
	private class SelectedTab implements ChangeListener {
		@Override
		public void stateChanged(ChangeEvent e) {
			int choose = tabbed.getSelectedIndex();
			switch (choose) {
			case 1:
				showLopSvCbo();
				break;
			}
		}
	}
	
	public void monhoc_UI() {
		
	}

	public void thongke_UI() {

	}

	public void thongkeEvent() {

	}

	public void monhocEvent() {

	}

	public void sinhvienEvent() {
		tableSV.addMouseListener(eventTblSV);
		thanhpho.addActionListener(tpEvent);
		quan.addActionListener(quanEvent);
		lopsvCBO.addActionListener(chonLop);
		tabbed.addChangeListener(new SelectedTab());
		themSV.addActionListener(eventThemSV);
		suaSV.addActionListener(eventSuaSV);
		xoaSV.addActionListener(eventXoaSV);
		resetSV.addActionListener(eventResetSV);
	}
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
	public void lophocEvent() {
		tableLH.addMouseListener(eventTblLH);
		themLop.addActionListener(eventThemLop);
		suaLop.addActionListener(eventSuaLop);
		xoaLop.addActionListener(eventXoaLop);
		resetLop.addActionListener(eventResetLop);
	}
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
				JOptionPane.showMessageDialog(null, "Thêm Mới Thành Công");
				LopHoc lh = new LopHoc(maLop, tenLop, moTa, namHoc);
				arrLH.add(lh);
				defTableLH.setRowCount(0);
				for(LopHoc f :arrLH) {
					String[] row = {f.getMaLop(),f.getTenLop(),
						f.getNamhocLop(),f.getMotaLop()};
					defTableLH.addRow(row);
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
	ActionListener chonLop=new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			try {
				String tenLop = (String)lopsvCBO.getItemAt(lopsvCBO.getSelectedIndex());
				Statement statement = conn.createStatement();
				if(tenLop =="Tất Cả Các Lớp") {
					String sql = "select * from sinh_vien";
					ResultSet allRS = statement.executeQuery(sql);
					defTableSV.setRowCount(0);
					while(allRS.next()) {
					defTableSV.addRow(new String[]{allRS.getString("codesv"),
							allRS.getString("namesv"),allRS.getString("addresssv"),
							allRS.getString("wardSV"),allRS.getString("countysv"),
							allRS.getString("citysv"),allRS.getString("phonenumbSV"),
							allRS.getString("emailSV"),allRS.getString("classsv")});
					}
				}
				else {
					String sql = "select * from sinh_vien where `classsv`='"+tenLop+"'";
					ResultSet chonLopRS = statement.executeQuery(sql);
					defTableSV.setRowCount(0);
					while(chonLopRS.next()) {
					defTableSV.addRow(new String[]{chonLopRS.getString("codesv"),
							chonLopRS.getString("namesv"),chonLopRS.getString("addresssv"),
							chonLopRS.getString("wardSV"),chonLopRS.getString("countysv"),
							chonLopRS.getString("citysv"),chonLopRS.getString("phonenumbSV"),
							chonLopRS.getString("emailSV"),chonLopRS.getString("classsv")});
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
				try {
				Statement statement = conn.createStatement();
				int x = statement.executeUpdate(sql);
				if(x>0) {
					JOptionPane.showMessageDialog(null, "Thêm Mới Thành Công");
					SinhVien sv = new SinhVien(codeSV,nameSV,addressSV,wardSV,countySV,citySV,
							phonenumbSV,emailSV,classSV);
					arrSV.add(sv);
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
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
}