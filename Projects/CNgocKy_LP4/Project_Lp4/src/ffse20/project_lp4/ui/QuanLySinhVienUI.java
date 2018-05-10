
package ffse20.project_lp4.ui;

import java.awt.BorderLayout;
import ffse20.project_lp4.connect.*;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.nio.file.Path;
import java.sql.ResultSet;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
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
import ffse20.project_lp4.model.*;
import com.mysql.jdbc.Connection;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;

public class QuanLySinhVienUI extends JFrame {
	// private String[] lop = { "Tất Cả", "FFSE1701", "FFSE1702", "FFSE1703",
	// "FFSE1704" };

	private JButton btnThemsv = new JButton("Thêm");
	private JButton btnSuasv = new JButton("Sửa");
	private JButton btnXoasv = new JButton("Xóa");

	private JButton btnThemlp = new JButton("Thêm");
	private JButton btnSualp = new JButton("Sửa");
	private JButton btnXoalp = new JButton("Xóa");

	private JButton btnThemMon = new JButton("Thêm");
	private JButton btnSuaMon = new JButton("Sửa");
	private JButton btnXoaMon = new JButton("Xóa");
	
	private JComboBox<String> cboTinh = new JComboBox();
	private JComboBox<String> cboQuan = new JComboBox();
	private JComboBox<String> cboPhuong = new JComboBox();
	private JLabel txtquan = new JLabel("Quận(Huyện): ");
	private JLabel txttinh = new JLabel("Thành Phố(Tỉnh): ");
	private JLabel txtphuong = new JLabel("Phường(Xã): ");
	private JLabel txtlop = new JLabel("Chọn Mã Lớp: ");
	private JLabel txtlop1 = new JLabel("Nhập Mã Lớp: ");
	private JLabel lblNhapmaSV = new JLabel("Mã SV:");
	private JLabel lblNhapten = new JLabel("Họ Tên:");
	private JLabel lblNhapNgaySinh = new JLabel("Ngày Sinh:");
	private JLabel lblPhone = new JLabel("SĐT:");
	private JLabel lblNhapEmail = new JLabel("Email:");

	private JButton btnQlkh;
	private JButton btnQlbl;
	private JButton btnBckh;
	private JButton btnBctd;
	private JButton btnBctdd;
	private JTable tableMH, table1;
	private DefaultTableModel dm, dmMhoc, dmLhoc;
	private JTextField maLop1 = new JTextField(), tenLop1 = new JTextField(), namHoc1 = new JTextField(),
			moTa1 = new JTextField();// LopHoc
	
	private JTextField maMhoc = new JTextField(), tenMhoc = new JTextField(),maLop = new JTextField(), soTinChi = new JTextField(),
			gioHoc = new JTextField();// monHoc
///////quanlylophoc////////
	private JLabel lblNhapTenLop = new JLabel("Tên Lớp:");
	private JLabel lblNhapNamHoc = new JLabel("Năm Học:");
	private JLabel lblNhapMota = new JLabel("Mô tả:");
	private JScrollPane sc_lopHoc;
	private JTable tblLopHoc;
	private JScrollPane sc_monHoc;
	private JTable tblMonHoc;

	private JPanel pnCard1;
	private JPanel pnCard2;
	private JPanel pnCard3;
	
	private ArrayList<QuanLyLopHocModel> arrMH = new ArrayList<QuanLyLopHocModel>();

	public QuanLySinhVienUI(String title) {
		super(title);
		addControls();
		addEvents();
		tinh();

	}

	public void addControls() {
		this.setResizable(false);
		Container con = getContentPane();

		JPanel cardlayout = new JPanel(new CardLayout());

		JPanel pnTitle = new JPanel();
		pnTitle.add(new JLabel(new ImageIcon("image/ffse.png")));
		pnTitle.setBackground(new Color(255, 255, 255));
		pnTitle.setMaximumSize(new Dimension(1300, 70));

		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		///// Icon Button //////

		JPanel pnCenter = new JPanel();
		pnCenter.add(pnTitle);
		JPanel pnGroup1 = new JPanel();
		pnGroup1.setLayout(new BoxLayout(pnGroup1, BoxLayout.X_AXIS));

		JPanel pnAction = new JPanel();
		ImageIcon iconView = new ImageIcon("image/1.png");
		Image getIconView = iconView.getImage();
		Image newIconView = getIconView.getScaledInstance(90, 90, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newIconView);
		btnQlkh = new JButton("QUẢN LÝ LỚP HỌC", newIcon);
		pnAction.add(btnQlkh);
		pnGroup1.add(pnAction);

		JPanel pnAction1 = new JPanel();
		ImageIcon iconView1 = new ImageIcon("image/6.jpg");
		Image getIconView1 = iconView1.getImage();
		Image newIconView1 = getIconView1.getScaledInstance(90, 90, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon1 = new ImageIcon(newIconView1);
		btnQlbl = new JButton("QUẢN LÝ SINH VIÊN", newIcon1);
		pnAction1.add(btnQlbl);
		pnGroup1.add(pnAction1);

		JPanel pnAction2 = new JPanel();
		ImageIcon iconView2 = new ImageIcon("image/2.jpg");
		Image getIconView2 = iconView2.getImage();
		Image newIconView2 = getIconView2.getScaledInstance(90, 90, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon2 = new ImageIcon(newIconView2);
		btnBckh = new JButton("QUẢN LÝ MÔN HỌC", newIcon2);
		pnAction2.add(btnBckh);
		pnGroup1.add(pnAction2);

		JPanel pnAction3 = new JPanel();
		ImageIcon iconView3 = new ImageIcon("image/a.jpg");
		Image getIconView3 = iconView3.getImage();
		Image newIconView3 = getIconView3.getScaledInstance(90, 90, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon3 = new ImageIcon(newIconView3);
		btnBctd = new JButton("QUẢN LÝ ĐIỂM       ", newIcon3);
		pnAction3.add(btnBctd);

		pnGroup1.add(pnAction3);

		JPanel pnAction4 = new JPanel();
		ImageIcon iconView4 = new ImageIcon("image/5.jpg");
		Image getIconView4 = iconView4.getImage();
		Image newIconView4 = getIconView4.getScaledInstance(90, 90, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon4 = new ImageIcon(newIconView4);
		btnBctdd = new JButton("THỐNG KÊ                ", newIcon4);
		pnAction4.add(btnBctdd);

		pnGroup1.add(pnAction4);
		pnCenter.add(pnGroup1);

		////////////////////////// CardLayout1-QuảnLýSinhViên/////////////////////////////

		pnCard1 = new JPanel();
		Border border2 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle2 = BorderFactory.createTitledBorder(border2, "NHẬP THÔNG TIN");
		pnCard1.setBorder(borderTitle2);

		JPanel cot1 = new JPanel();

		JPanel chonlop = new JPanel();
		chonlop.add(txtlop);
		JComboBox select = new JComboBox();
		chonlop.add(select);
		cot1.add(chonlop);
		
//		Connection con1 = Connect.getConnect("localhost", "quanlysinhvien", "quanlysinhvien", "12345");
//		try {
//			Statement statement = con1.createStatement();
//			ResultSet result = statement.executeQuery("SELECT tabel_lop.maLop FROM tabel_lop");
//			while (result.next()) {
//				arrMH.add(new QuanLyLopHocModel(result.getString("MaLop"), result.getString("TenLop"),
//						result.getString("NamHoc")));
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		for (QuanLyLopHocModel x : arrMH) {
//			String[] row = { x.getMaLop(), x.getTenLop(), x.getNamHoc()};
//			dmMhoc.addRow(row);
//		}

		JPanel nhapMaSV = new JPanel();
		nhapMaSV.setLayout(new FlowLayout());
		JTextField masv = new JTextField(12);
		nhapMaSV.add(lblNhapmaSV);
		nhapMaSV.add(masv);
		cot1.add(nhapMaSV);

		JPanel nhapTen = new JPanel();
		nhapTen.setLayout(new FlowLayout());
		JTextField tenLop = new JTextField(12);
		nhapTen.add(lblNhapten);
		nhapTen.add(tenLop);
		cot1.add(nhapTen);

		JPanel nhapNgaySinh = new JPanel();
		nhapNgaySinh.setLayout(new FlowLayout());
		JTextField namHoc = new JTextField(12);
		nhapNgaySinh.add(lblNhapNgaySinh);
		nhapNgaySinh.add(namHoc);
		cot1.add(nhapNgaySinh);

		JPanel nhapPhone = new JPanel();
		nhapPhone.setLayout(new FlowLayout());
		JTextField phone = new JTextField(12);
		nhapPhone.add(lblPhone);
		nhapPhone.add(phone);
		cot1.add(nhapPhone);

		JPanel nhapEmail = new JPanel();
		nhapEmail.setLayout(new FlowLayout());
		JTextField Email = new JTextField(12);
		nhapEmail.add(lblNhapEmail);
		nhapEmail.add(Email);
		cot1.add(nhapEmail);

		pnCard1.add(cot1);

		JPanel cot2 = new JPanel();

		JPanel chontinh = new JPanel();
		chontinh.add(txttinh);
		chontinh.add(cboTinh);
		cot2.add(chontinh);

		JPanel chonquan = new JPanel();
		chonquan.add(txtquan);
		chonquan.add(cboQuan);
		cot2.add(chonquan);

		JPanel chonphuong = new JPanel();
		chonphuong.add(txtphuong);
		chonphuong.add(cboPhuong);
		cot2.add(chonphuong);

		pnCard1.add(cot2);

		JPanel cot3 = new JPanel();

		JPanel chucNang = new JPanel();
		chucNang.setLayout(new FlowLayout());
		chucNang.add(btnThemsv);
		chucNang.add(btnSuasv);
		chucNang.add(btnXoasv);
		cot3.add(chucNang);

		pnCard1.add(cot3);

		JPanel pnTable = new JPanel();
		dm = new DefaultTableModel();
		JTable tbl = new JTable(dm);
		dm.addColumn("Mã Lớp");
		dm.addColumn("Mã SV");
		dm.addColumn("Họ Tên");
		dm.addColumn("Ngày Sinh");
		dm.addColumn("SĐT");
		dm.addColumn("Email");
		dm.addColumn("Thành Phố(Tỉnh)");
		dm.addColumn("Quận(Huyện)");
		dm.addColumn("Phường(Xã)");

		JScrollPane sc = new JScrollPane(tbl);
		JScrollPane VT = new JScrollPane(sc, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		VT.setPreferredSize(new Dimension(1200, 350));
		pnTable.add(VT, BorderLayout.CENTER);

		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Danh sách");
		pnTable.setBorder(borderTitle);
		pnCard1.add(pnTable);
		pnCenter.add(pnCard1);

		//////////////////////////////// CardLayout2-QuanLyMonHoc///////////////////////////////////
		pnCard2 = new JPanel();
		Border border1 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle1 = BorderFactory.createTitledBorder(border1, "NHẬP THÔNG TIN");
		pnCard2.setBorder(borderTitle1);

		JPanel chonlop1 = new JPanel();
		chonlop1.add(txtlop1);
		maLop1 = new JTextField(12);
		chonlop1.add(maLop1);
		pnCard2.add(chonlop1);

		JPanel nhapTenlop2 = new JPanel();
		tenLop1 = new JTextField(12);
		nhapTenlop2.add(lblNhapTenLop);
		nhapTenlop2.add(tenLop1);
		pnCard2.add(nhapTenlop2);

		JPanel nhapNamhoc = new JPanel();
		nhapNamhoc.setLayout(new FlowLayout());
		namHoc1 = new JTextField(12);
		nhapNamhoc.add(lblNhapNamHoc);
		nhapNamhoc.add(namHoc1);
		pnCard2.add(nhapNamhoc);


		JPanel chucNang1 = new JPanel();
		chucNang1.setLayout(new FlowLayout());
		chucNang1.add(btnThemlp);
		chucNang1.add(btnSualp);
		chucNang1.add(btnXoalp);
		pnCard2.add(chucNang1);

		JPanel pnTable1 = new JPanel();

		dmLhoc = new DefaultTableModel();

		dmLhoc.addColumn("Mã Lớp");
		dmLhoc.addColumn("Tên Lớp");
		dmLhoc.addColumn("Năm Học");

		Connection conn = Connect.getConnect("localhost", "quanlysinhvien", "quanlysinhvien", "12345");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM tabel_lop");
			while (result.next()) {
				arrMH.add(new QuanLyLopHocModel(result.getString("maLop"), result.getString("tenLop"),
						result.getString("namHoc")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (QuanLyLopHocModel x : arrMH) {
			String[] row = { x.getMaLop(), x.getTenLop(), x.getNamHoc()};
			dmLhoc.addRow(row);
		}

		tblLopHoc = new JTable(dmLhoc);
		sc_lopHoc = new JScrollPane(tblLopHoc);
		JScrollPane VT1 = new JScrollPane(sc_lopHoc, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		VT1.setPreferredSize(new Dimension(1200, 400));
		pnTable1.add(VT1, BorderLayout.CENTER);
		pnMain.add(pnTable1);

		Border border3 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle3 = BorderFactory.createTitledBorder(border3, "Danh sách");
		pnTable1.setBorder(borderTitle3);
		pnCard2.add(pnTable1);
		
		////////////Card3-QuanLyMonHoc///////////////////
		pnCard3 = new JPanel();
		Border border4 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle4 = BorderFactory.createTitledBorder(border4, "NHẬP THÔNG TIN");
		pnCard3.setBorder(borderTitle4);

		JLabel lblNhapLop4 = new JLabel("Mã Lớp :");
		JPanel chonlop4 = new JPanel();
		chonlop4.add(lblNhapLop4);
		JComboBox maLop = new JComboBox();
		chonlop4.add(maLop);
		pnCard3.add(chonlop4);
		
		JPanel nhapMaMhoc4 = new JPanel();
		maMhoc = new JTextField(12);
		JLabel lblNhapMaMhoc4 = new JLabel("Mã Môn Học :");
		nhapMaMhoc4.add(lblNhapMaMhoc4);
		nhapMaMhoc4.add(maMhoc);
		pnCard3.add(nhapMaMhoc4);

		JPanel nhapTenMhoc4 = new JPanel();
		nhapTenMhoc4.setLayout(new FlowLayout());
		tenMhoc = new JTextField(12);
		JLabel lblnhapTenMhoc4 = new JLabel("Tên Môn Học:");
		nhapTenMhoc4.add(lblnhapTenMhoc4);
		nhapTenMhoc4.add(tenMhoc);
		pnCard3.add(nhapTenMhoc4);

		JPanel nhapSoTC4 = new JPanel();
		nhapSoTC4.setLayout(new FlowLayout());
		soTinChi = new JTextField(12);
		JLabel lblnhapSoTinChi4 = new JLabel("Số tín chỉ:");
		nhapSoTC4.add(lblnhapSoTinChi4);
		nhapSoTC4.add(soTinChi);
		pnCard3.add(nhapSoTC4);
		
		JPanel nhapGioHoc4 = new JPanel();
		nhapGioHoc4.setLayout(new FlowLayout());
		gioHoc = new JTextField(12);
		JLabel lblsoGioHoc4 = new JLabel("Giờ học:");
		nhapGioHoc4.add(lblsoGioHoc4);
		nhapGioHoc4.add(gioHoc);
		pnCard3.add(nhapGioHoc4);

		JPanel chucNang4 = new JPanel();
		chucNang4.setLayout(new FlowLayout());
		chucNang4.add(btnThemMon);
		chucNang4.add(btnSuaMon);
		chucNang4.add(btnXoaMon);
		pnCard3.add(chucNang4);
		
		JPanel pnTable2 = new JPanel();
		
		dmMhoc = new DefaultTableModel();

		dmMhoc.addColumn("Mã Lớp");
		dmMhoc.addColumn("Mã Môn Học");
		dmMhoc.addColumn("Tên Môn Học");
		dmMhoc.addColumn("Số Tín Chỉ");
		dmMhoc.addColumn("Giờ Học");

//		Connection con2 = Connect.getConnect("localhost", "quanlysinhvien", "quanlysinhvien", "12345");
//		try {
//			Statement statement = con2.createStatement();
//			ResultSet result = statement.executeQuery("SELECT * FROM tabel_lop");
//			while (result.next()) {
//				arrMH.add(new QuanLyLopHocModel(result.getString("maLop"), result.getString("tenLop"),
//						result.getString("namHoc")));
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		for (QuanLyLopHocModel x : arrMH) {
//			String[] row = { x.getMaLop(), x.getTenLop(), x.getNamHoc()};
//			dmMhoc.addRow(row);
//		}
		
		tblMonHoc = new JTable(dmMhoc);
		sc_monHoc = new JScrollPane(tblMonHoc);
		JScrollPane VT2 = new JScrollPane(sc_monHoc, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		VT2.setPreferredSize(new Dimension(1200, 400));
		pnTable2.add(VT2, BorderLayout.CENTER);
		pnMain.add(pnTable2);

		Border border5 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle5 = BorderFactory.createTitledBorder(border5, "Danh sách");
		pnTable2.setBorder(borderTitle5);
		pnCard3.add(pnTable2);
		
		///////////////////////////
		
		pnMain.add(pnTitle);
		pnMain.add(pnCenter);
		cardlayout.add(pnCard1);
		cardlayout.add(pnCard2);
		cardlayout.add(pnCard3);
		pnMain.add(cardlayout);
		setVisible(true);

		getContentPane().add(pnMain);

		con.add(pnMain);

	}

	public void tinh() {
		Connection conn = Connect.getConnect("localhost", "quanlysinhvien", "quanlysinhvien", "12345");

		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("select * from devvn_tinhthanhpho");
			while (result.next()) {
				// System.out.print(result);
				cboTinh.addItem(result.getString("name"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addEvents() {
		tblLopHoc.addMouseListener(eventTableLop);
		btnThemlp.addActionListener(eventAdd);
		btnXoalp.addActionListener(eventDel);
		btnSualp.addActionListener(eventEdit);
		cboTinh.addActionListener(eventChooseQuan);
		cboQuan.addActionListener(eventChoosePhuong);

		btnQlkh.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				pnCard1.setVisible(false);
				pnCard2.setVisible(true);
				pnCard3.setVisible(false);
			}

		});
		btnQlbl.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				pnCard1.setVisible(true);
				pnCard2.setVisible(false);
				pnCard3.setVisible(false);
			}

		});
		btnBckh.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				pnCard1.setVisible(false);
				pnCard2.setVisible(false);
				pnCard3.setVisible(true);
			}

		});
	}

	///////////// event-ThanhPho/////////////////////
	ActionListener eventChooseQuan = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			cboQuan.removeAllItems();

			String chonTinh = (String) cboTinh.getSelectedItem();
			Connection conn = Connect.getConnect("localhost", "quanlysinhvien", "quanlysinhvien", "12345");
			try {
				Statement statement = conn.createStatement();
				ResultSet result = statement.executeQuery(
						"SELECT devvn_quanhuyen.name FROM devvn_quanhuyen INNER JOIN devvn_tinhthanhpho WHERE devvn_quanhuyen.matp=devvn_tinhthanhpho.matp AND devvn_tinhthanhpho.name ='"
								+ chonTinh + "'");
				System.out.println(result.next());
				while (result.next()) {
					cboQuan.addItem(result.getString("devvn_quanhuyen.name"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	};
	ActionListener eventChoosePhuong = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			cboPhuong.removeAllItems();
			String chonPhuong = (String) cboQuan.getSelectedItem();
			Connection conn = Connect.getConnect("localhost", "quanlysinhvien", "quanlysinhvien", "12345");
			try {
				Statement statement = conn.createStatement();
				ResultSet result = statement.executeQuery(
						"SELECT devvn_xaphuongthitran.name FROM devvn_xaphuongthitran INNER JOIN devvn_quanhuyen WHERE devvn_quanhuyen.maqh=devvn_xaphuongthitran.maqh AND devvn_quanhuyen.name='"
								+ chonPhuong + "'");
				// System.out.println(result.next());
				while (result.next()) {
					cboPhuong.addItem(result.getString("devvn_xaphuongthitran.name"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			// System.out.println(chonPhuong);

		}
	};
	/////////////////// envent-QuanLyLop////////////////////
	MouseAdapter eventTableLop = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int row = tblLopHoc.getSelectedRow();
			String[] col = new String[3];
			col[0] = (String) tblLopHoc.getValueAt(row, 0);
			col[1] = (String) tblLopHoc.getValueAt(row, 1);
			col[2] = (String) tblLopHoc.getValueAt(row, 2);

			maLop1.setText(col[0]);
			tenLop1.setText(col[1]);
			namHoc1.setText(col[2]);

		}
	};

	ActionListener eventAdd = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			String malop = maLop1.getText();
			String tenlp = tenLop1.getText();
			String nam = namHoc1.getText();


			try {
				if (malop.equals("") || tenlp.equals("") || nam.equals("")) {
					JOptionPane.showMessageDialog(null, "Bạn chưa nhập thông tin");
				}else {
				arrMH.add(new QuanLyLopHocModel(malop, tenlp, nam));
				dmLhoc.addRow(new String[] { malop, tenlp, nam });
				Connection conn = Connect.getConnect("localhost", "quanlysinhvien", "quanlysinhvien", "12345");
				try {
					String sql = "INSERT INTO tabel_lop(maLop,tenLop,namHoc) VALUES (" + "'" + malop + "','"
							+ tenlp + "','" + nam + "')";
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
		}
		};

	ActionListener eventDel = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			for (QuanLyLopHocModel x : arrMH) {
				if (maLop1.getText().equals(x.getMaLop())) {
					arrMH.remove(x);
					break;
				}
			}
			Connection conn = Connect.getConnect("localhost", "quanlysinhvien", "quanlysinhvien", "12345");
			try {
				String sql = "DELETE FROM tabel_lop WHERE maLop = '" + maLop1.getText() + "'";
				Statement statement = conn.createStatement();
				int x = statement.executeUpdate(sql);
				if (x >= 0) {
					JOptionPane.showMessageDialog(null, "Đã xóa thông tin môn học");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			dmLhoc.setRowCount(0);
			for (QuanLyLopHocModel x : arrMH) {
				String[] row = { x.getMaLop(), x.getTenLop(), x.getNamHoc()};
				dmLhoc.addRow(row);
			}
		}

	};

	ActionListener eventEdit = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			for (QuanLyLopHocModel x : arrMH) {
				if (maLop1.getText().equals(x.getMaLop())) {
					x.setTenLop(tenLop1.getText());
					x.setNamHoc(namHoc1.getText());
					break;
				}
			}
			Connection conn = Connect.getConnect("localhost", "quanlysinhvien", "quanlysinhvien", "12345");
			try {
				String sql = "UPDATE tabel_lop SET namHoc ='" + namHoc1.getText() + "',tenLop='" + tenLop1.getText() + "'  WHERE maLop = '" + maLop1.getText() + "'";
				Statement statement = conn.createStatement();
				int x = statement.executeUpdate(sql);
				if (x >= 0) {
					JOptionPane.showMessageDialog(null, "Đã sửa thông tin môn học");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			dmLhoc.setRowCount(0);
			for (QuanLyLopHocModel x : arrMH) {
				String[] row = { x.getMaLop(), x.getTenLop(), x.getNamHoc()};
				dmLhoc.addRow(row);
			}

		}

	};

	public void showWindow() {
		this.setSize(1250, 750);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
