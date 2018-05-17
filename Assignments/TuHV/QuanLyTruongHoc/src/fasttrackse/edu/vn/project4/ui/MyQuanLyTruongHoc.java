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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import fasttrackse.edu.vn.project4.model.Connect;



public class MyQuanLyTruongHoc extends JFrame {
	
	//sinh vien
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
	
	//diem
	private JTextField maMH = new JTextField(15);
	private JTextField maSV = new JTextField(15);
	private JTextField tenMH = new JTextField(15);
	private JTextField diem = new JTextField(15);
	
	//lop
	private JTextField malop = new JTextField(15);
	private JTextField tenlop = new JTextField(15);
	private JTextField namhoc = new JTextField(15);
	
	//mon
	private JTextField malophoc = new JTextField(15);
	private JTextField mamonhoc = new JTextField(15);
	private JTextField tenmonhoc = new JTextField(15);
	private JTextField soTC = new JTextField(15);
	private JTextField thoiluong = new JTextField(15);
	
	
	
	DefaultTableModel dm;
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
	
	private JButton btnThemlop = new JButton("Thêm");
	private JButton btnSualop = new JButton("Sửa");
	private JButton btnXoalop = new JButton("Xoá");
	
	private JButton btnThemdiem = new JButton("Thêm");
	private JButton btnSuadiem = new JButton("Sửa");
	private JButton btnXoadiem = new JButton("Xoá");
	
	private JButton btnThemmon = new JButton("Thêm");
	private JButton btnSuamon = new JButton("Sửa");
	private JButton btnXoamon = new JButton("Xoá");
	
	
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

		//quan ly sinh vien
		
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
		
		JPanel pnbutton = new JPanel();
		pnbutton.setLayout(new FlowLayout());
		pnbutton.add(btnThemsv);
		pnbutton.add(btnSuasv);
		pnbutton.add(btnXoasv);
		pnCenter.add(pnbutton);
		
		JPanel pnCombo = new JPanel();
		pnCombo.setLayout(new FlowLayout());
		JLabel lblContent1 = new JLabel("Chọn Lớp : ");
		//JComboBox cbo=new JComboBox();
		cbo.addItem("FFSE1701");
		cbo.addItem("FFSE1702");
		cbo.addItem("FFSE1703");
		cbo.addItem("FFSE1704");
		pnCombo.add(lblContent1);
		pnCombo.add(cbo);
		
		JLabel lblContent2 = new JLabel("Chọn Tỉnh : ");
		//JComboBox cbo2=new JComboBox();
		
		pnCombo.add(lblContent2);
		pnCombo.add(cbo2);
		
		JLabel lblContent3 = new JLabel("Chọn Quận : ");
		//JComboBox cbo3=new JComboBox();
		
		pnCombo.add(lblContent3);
		pnCombo.add(cbo3);
		
		JLabel lblContent4 = new JLabel("Chọn Phường : ");
		//JComboBox cbo4=new JComboBox();
		
		pnCombo.add(lblContent4);
		pnCombo.add(cbo4);		
		pnCenter.add(pnCombo);
		
		JPanel pnnhap = new JPanel();
		pnnhap.setLayout(new FlowLayout());
		JPanel pnLeft = new JPanel();
		pnLeft.setLayout(new BoxLayout(pnLeft, BoxLayout.Y_AXIS));
		JLabel lbl1 = new JLabel("Nhập Tên :");
		pnLeft.add(lbl1);
		pnLeft.add(ten);
		
		JLabel lbl5 = new JLabel("Nhập Mã Sinh Viên :");
		pnLeft.add(lbl5);
		pnLeft.add(masv);
		pnnhap.add(pnLeft);
		
		JPanel pnGiua = new JPanel();
		pnGiua.setLayout(new BoxLayout(pnGiua, BoxLayout.Y_AXIS));
		JLabel lbl6 = new JLabel("Nhập Tuổi Sinh Viên :");
		pnGiua.add(lbl6);
		pnGiua.add(tuoisv);
		
		JLabel lbl4 = new JLabel("Nhập Địa Chỉ :");
		pnGiua.add(lbl4);
		pnGiua.add(diachi);
		pnnhap.add(pnGiua);
		
		JPanel pnRight = new JPanel();
		pnRight.setLayout(new BoxLayout(pnRight, BoxLayout.Y_AXIS));
		JLabel lbl2 = new JLabel("Nhập Email :");
		pnRight.add(lbl2);
		pnRight.add(email);
		
		JLabel lbl3 = new JLabel("Nhập SĐT :");
		pnRight.add(lbl3);
		pnRight.add(sdt);
		pnnhap.add(pnRight);
		
		
		
		pnCenter.add(pnnhap);
		
		
		pnCenter.setBackground(Color.white);
		
		
		
		
		JPanel pnTable = new JPanel();
		dm = new DefaultTableModel();
		tbl = new JTable(dm);
		dm.addColumn("Tên");
		dm.addColumn("Mã");		
		dm.addColumn("Địa Chỉ");
		dm.addColumn("Phường");
		dm.addColumn("Quận");
		dm.addColumn("Tỉnh/TP");
		dm.addColumn("SĐT");
		dm.addColumn("Email");
		dm.addColumn("Mã Lớp");

		
		JScrollPane sc = new JScrollPane(tbl);
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
		
		//quản lý điểm
		
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
		pnCenter1.add(pnbutton1);

		JPanel pnCombo1 = new JPanel();
		pnCombo1.setLayout(new FlowLayout());

		JPanel pnnhap1 = new JPanel();
		pnnhap1.setLayout(new FlowLayout());
		JPanel pnLeft1 = new JPanel();
		pnLeft1.setLayout(new BoxLayout(pnLeft1, BoxLayout.Y_AXIS));
		JLabel lbl1diem = new JLabel("Nhập Mã Môn Học :");
		pnLeft1.add(lbl1diem);
		pnLeft1.add(maMH);

		JLabel lbl5diem = new JLabel("Nhập Mã Sinh Viên :");
		pnLeft1.add(lbl5diem);
		pnLeft1.add(maSV);
		pnnhap1.add(pnLeft1);

		JPanel pnGiua1 = new JPanel();
		pnGiua1.setLayout(new BoxLayout(pnGiua1, BoxLayout.Y_AXIS));
		JLabel lbl6diem = new JLabel("Nhập Tên Môn Học :");
		pnGiua1.add(lbl6diem);
		pnGiua1.add(tenMH);

		JLabel lbl4diem = new JLabel("Nhập Điểm :");
		pnGiua1.add(lbl4diem);
		pnGiua1.add(diem);
		pnnhap1.add(pnGiua1);

		pnCenter1.add(pnnhap1);

		pnCenter1.setBackground(Color.white);
		pnBorder1.add(pnCenter1, BorderLayout.CENTER);
		getContentPane().add(pnBorder1);

		JPanel pnTable1 = new JPanel();
		dm = new DefaultTableModel();
		tbl = new JTable(dm);
		dm.addColumn("Mã Môn Học");
		dm.addColumn("Mã Sinh Viên");
		dm.addColumn("Điểm");
		dm.addColumn("Tên Môn Học");

		JScrollPane sc1 = new JScrollPane(tbl);
		JScrollPane VT1 = new JScrollPane(sc1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		VT1.setPreferredSize(new Dimension(1170, 520));
		pnTable1.add(VT1, BorderLayout.CENTER);
		pnCenter1.add(pnTable1);

		Border border1 = BorderFactory.createLineBorder(Color.blue);
		TitledBorder borderTitle1 = BorderFactory.createTitledBorder(border1, "Danh sách sinh viên");
		pnTable1.setBorder(borderTitle1);
		
		
		
		//quản lý lớp học
		
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
		pnCenter2.add(pnbutton2);

		JPanel pnCombo2 = new JPanel();
		pnCombo2.setLayout(new FlowLayout());

		JPanel pnnhap2 = new JPanel();
		pnnhap2.setLayout(new FlowLayout());
		
		JPanel pnLeft2 = new JPanel();
		pnLeft2.setLayout(new BoxLayout(pnLeft2, BoxLayout.X_AXIS));
		JLabel lbl1lop = new JLabel("Nhập Mã Lớp Học :");
		pnLeft2.add(lbl1lop);
		pnLeft2.add(malop);

		JLabel lbl5lop = new JLabel("Nhập Tên Lớp Học :");
		pnLeft2.add(lbl5lop);
		pnLeft2.add(tenlop);
		pnnhap2.add(pnLeft2);

		JLabel lbl6lop = new JLabel("Nhập Năm Học :");
		pnLeft2.add(lbl6lop);
		pnLeft2.add(namhoc);
		pnnhap2.add(pnLeft2);

		

		pnCenter2.add(pnnhap2);

		pnCenter2.setBackground(Color.white);
		pnBorder2.add(pnCenter2, BorderLayout.CENTER);
		getContentPane().add(pnBorder2);

		JPanel pnTable2 = new JPanel();
		dm = new DefaultTableModel();
		tbl = new JTable(dm);
		dm.addColumn("Mã Lớp Học");
		dm.addColumn("Tên Lớp");
		dm.addColumn("Năm Học");
		

		JScrollPane sc2 = new JScrollPane(tbl);
		JScrollPane VT2 = new JScrollPane(sc2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		VT2.setPreferredSize(new Dimension(1170, 520));
		pnTable2.add(VT2, BorderLayout.CENTER);
		pnCenter2.add(pnTable2);

		Border border2 = BorderFactory.createLineBorder(Color.blue);
		TitledBorder borderTitle2 = BorderFactory.createTitledBorder(border2, "Danh sách sinh viên");
		pnTable2.setBorder(borderTitle2);
		
		
		
		//quản lý môn học
		
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
		pnCenter3.add(pnbutton3);

		JPanel pnCombo3 = new JPanel();
		pnCombo3.setLayout(new FlowLayout());

		JPanel pnnhap3 = new JPanel();
		pnnhap3.setLayout(new FlowLayout());
		JPanel pnLeft3 = new JPanel();
		pnLeft3.setLayout(new BoxLayout(pnLeft3, BoxLayout.X_AXIS));
		JLabel lbl1mon = new JLabel("Nhập Mã Lớp Học :");
		pnLeft3.add(lbl1mon);
		pnLeft3.add(malophoc);

		JLabel lbl5mon = new JLabel("Nhập Mã Môn Học :");
		pnLeft3.add(lbl5mon);
		pnLeft3.add(mamonhoc);
		pnnhap3.add(pnLeft3);
		
		JPanel pnnhapp =new JPanel();
		pnnhapp.setLayout(new FlowLayout());
		JPanel pnGiua3 = new JPanel();
		pnGiua3.setLayout(new BoxLayout(pnGiua3, BoxLayout.X_AXIS));
		JLabel lbl6mon = new JLabel("Nhập Tên Môn Học :");
		pnGiua3.add(lbl6mon);
		pnGiua3.add(tenmonhoc);

		JLabel lbl4mon = new JLabel("Nhập Số Tín Chỉ :");
		pnGiua3.add(lbl4mon);
		pnGiua3.add(soTC);
		pnnhapp.add(pnGiua3);
		
		JLabel lbl7mon = new JLabel("Nhập Thời Lượng Học :");
		pnGiua3.add(lbl7mon);
		pnGiua3.add(thoiluong);
		pnnhapp.add(pnGiua3);

		pnCenter3.add(pnnhap3);
		pnCenter3.add(pnnhapp);
		pnCenter3.setBackground(Color.white);
		pnBorder3.add(pnCenter3, BorderLayout.CENTER);
		getContentPane().add(pnBorder3);

		JPanel pnTable3 = new JPanel();
		dm = new DefaultTableModel();
		tbl = new JTable(dm);
		dm.addColumn("Mã Lớp Học");
		dm.addColumn("Mã Môn Học");
		dm.addColumn("Tên Môn Học");
		dm.addColumn("Số Tín Chỉ");
		dm.addColumn("Thời Lượng Học");

		JScrollPane sc3 = new JScrollPane(tbl);
		JScrollPane VT3 = new JScrollPane(sc3, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		VT3.setPreferredSize(new Dimension(1170, 520));
		pnTable3.add(VT3, BorderLayout.CENTER);
		pnCenter3.add(pnTable3);

		Border border3 = BorderFactory.createLineBorder(Color.blue);
		TitledBorder borderTitle3 = BorderFactory.createTitledBorder(border3, "Danh sách sinh viên");
		pnTable3.setBorder(borderTitle3);
		
		

		//thống kê báo cáo
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
			String chonTinh = (String)cbo2.getSelectedItem();
			dm.setRowCount(0);
			cbo3.removeAllItems();
			Connection conn = Connect.getConnect("localhost", "project4", "viettu", "12345");
			System.out.println(chonTinh);
			try {
				Statement statement = conn.createStatement();
				ResultSet result = statement.executeQuery(
						"SELECT devvn_quanhuyen.name FROM devvn_quanhuyen INNER JOIN devvn_tinhthanhpho WHERE devvn_quanhuyen.matp=devvn_tinhthanhpho.matp AND devvn_tinhthanhpho.name ='"+chonTinh+"'");
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
			String chonTinh = (String)cbo3.getSelectedItem();
			dm.setRowCount(0);
			cbo4.removeAllItems();
			Connection conn = Connect.getConnect("localhost", "project4", "viettu", "12345");
			System.out.println(chonTinh);
			try {
				Statement statement = conn.createStatement();
				ResultSet result = statement.executeQuery(
						"SELECT devvn_xaphuongthitran.name FROM devvn_xaphuongthitran INNER JOIN devvn_quanhuyen WHERE devvn_xaphuongthitran.maqh=devvn_quanhuyen.maqh AND devvn_quanhuyen.name ='"+chonTinh+"'");
				while (result.next()) {
					cbo4.addItem(new String(result.getString("devvn_xaphuongthitran.name")));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	};
	

	public void showWindow() {
		this.setSize(1350, 700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
