package QuanLyTruongHoc.FFSE.UI;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import QuanLyTruongHoc.FFSE.Model.*;

public class QuanLyUI extends JFrame {

	private DefaultTableModel dm_lophoc, dm_sv;
	private JTable table_lophoc, table_sv;
	private JScrollPane sc_lophoc, sc_sv;
	private JScrollPane sp_lophoc, sp_sv;
	private JTextField maLop = new JTextField(), namHoc = new JTextField(), moTa = new JTextField();// Lớp học
	private JTextField maSV = new JTextField(), hoTen = new JTextField(), DiaChi = new JTextField(), // sinh viên
					   Email = new JTextField(), DT = new JTextField();
	
	private JButton qlLophoc;
	private JButton ThongTinSV;
	private JButton qlmonhoc;
	private JButton nhapDiem;
	private JButton thongke;
	private JPanel quanlilophoc, pnLophoc, pnLophocbutton;// Lớp học
	private JPanel sinhvien, pnSinhvien, pnSinhvienbutton; // Sinh viên
	private JPanel monhocSV, pnMonhoc, pnMonhocbutton; // Môn học
	private JPanel nhapDiemSV, pnNhapdiem, pnNhapdiembutton; // Nhập điểm
	private JPanel thongkeSV, pnThongke, pnthongkebutton; // Thống kê
	private ArrayList<QuanLyModelLopHoc> arrMH = new ArrayList<QuanLyModelLopHoc>();
	private ArrayList<QuanLyTruongHocSV> arrSV = new ArrayList<QuanLyTruongHocSV>();

	private JComboBox select;
	private JComboBox tp = new JComboBox();
	private JComboBox quan = new JComboBox();
	private JComboBox phuong = new JComboBox();
	private JComboBox maLopcomnoBox = new JComboBox();

	private Button ThemLop = new Button("Thêm");
	private Button SuaLop = new Button("Sửa");
	private Button XoaLop = new Button("Xóa");

	private Button ThemSV = new Button("Thêm");
	private Button SuaSV = new Button("Sửa");
	private Button XoaSV = new Button("Xóa");

	public QuanLyUI(String tieude) {
		super(tieude);
		maLopcomnoBox();
		tinh();
		quan();
		huyen();
		addControls();
		addEvent();

	}

	public void addControls() {
		Container con = getContentPane();
		JPanel cardlayout = new JPanel(new CardLayout());

		// Tiêu đề
		JPanel pnTitle = new JPanel();
		pnTitle.add(new JLabel(new ImageIcon("image/3.png")));
		pnTitle.setBackground(new Color(255, 255, 255));
		pnTitle.setMaximumSize(new Dimension(1700, 70));

		JPanel pnBorder = new JPanel();
		pnBorder.setLayout(new BorderLayout());
		JPanel pnNorth = new JPanel();
		pnNorth.add(pnTitle);
		pnBorder.add(pnNorth, BorderLayout.NORTH);
		pnNorth.setLayout(new BoxLayout(pnNorth, BoxLayout.Y_AXIS));

		// Icon Button 
		JPanel pnWest = new JPanel();
		pnWest.setLayout(new BoxLayout(pnWest, BoxLayout.Y_AXIS));

		JPanel pnQuanLyLopHoc = new JPanel();
		ImageIcon iconView = new ImageIcon("image/qlLophoc.png");
		Image getIconView = iconView.getImage();
		Image newIconView = getIconView.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newIconView);
		qlLophoc = new JButton("QUẢN LÝ LỚP HỌC     ", newIcon);
		pnQuanLyLopHoc.add(qlLophoc);

		JPanel pnThongTinSV = new JPanel();
		ImageIcon iconView1 = new ImageIcon("image/thongtinsv.jpg");
		Image getIconView1 = iconView1.getImage();
		Image newIconView1 = getIconView1.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon1 = new ImageIcon(newIconView1);
		ThongTinSV = new JButton("THÔNG TIN SINH VIÊN ", newIcon1);
		pnThongTinSV.add(ThongTinSV);

		JPanel pnQuanlymonhoc = new JPanel();
		ImageIcon iconView2 = new ImageIcon("image/monhoc.jpg");
		Image getIconView2 = iconView2.getImage();
		Image newIconView2 = getIconView2.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon2 = new ImageIcon(newIconView2);
		JButton quanlymonhoc = new JButton("QUẢN LÝ MÔN HỌC     ", newIcon2);
		pnQuanlymonhoc.add(quanlymonhoc);

		JPanel pnNhapdiem = new JPanel();
		ImageIcon iconView3 = new ImageIcon("image/nhapdiem.jpg");
		Image getIconView3 = iconView3.getImage();
		Image newIconView3 = getIconView3.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon3 = new ImageIcon(newIconView3);
		JButton nhapdiem = new JButton("NHẬP ĐIỂM SINH VIÊN", newIcon3);
		pnNhapdiem.add(nhapdiem);

		JPanel pnThongke = new JPanel();
		ImageIcon iconView4 = new ImageIcon("image/thongke.jpg");
		Image getIconView4 = iconView4.getImage();
		Image newIconView4 = getIconView4.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon4 = new ImageIcon(newIconView4);
		JButton thongke = new JButton("THỐNG KÊ                       ", newIcon4);
		pnThongke.add(thongke);

		pnWest.add(pnQuanLyLopHoc, BorderLayout.SOUTH);
		pnWest.add(pnThongTinSV, BorderLayout.SOUTH);
		pnWest.add(pnQuanlymonhoc, BorderLayout.SOUTH);
		pnWest.add(pnNhapdiem, BorderLayout.SOUTH);
		pnWest.add(pnThongke, BorderLayout.SOUTH);
		pnBorder.add(pnWest, BorderLayout.WEST);

		// Table lớp học
		quanlilophoc = new JPanel();
		quanlilophoc.setLayout(new BorderLayout());

		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Danh sách");
		quanlilophoc.setBorder(borderTitle);
		pnBorder.add(quanlilophoc);

		dm_lophoc = new DefaultTableModel();

		dm_lophoc.addColumn("Mã lớp");
		dm_lophoc.addColumn("Mô tả");
		dm_lophoc.addColumn("Năm học");

		Connection conn = Connect.getConnect("localhost", "admin", "admin1", "12345");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM table_lop");
			while (result.next()) {
				arrMH.add(new QuanLyModelLopHoc(result.getString("MaLop"), result.getString("MoTa"),
						result.getString("NamHoc")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (QuanLyModelLopHoc x : arrMH) {
			String[] row = { x.getMaLop(), x.getMoTa(), x.getNamHoc() };
			dm_lophoc.addRow(row);
		}

		table_lophoc = new JTable(dm_lophoc);
		table_lophoc.setLayout(new BorderLayout());
		sp_lophoc = new JScrollPane(table_lophoc);
		sc_lophoc = new JScrollPane(sp_lophoc, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc_lophoc.setPreferredSize(new Dimension(470, 180));
		quanlilophoc.add(sc_lophoc);
		pnBorder.add(quanlilophoc);

		pnLophoc = new JPanel();
		Border nhapthongtin = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle3 = BorderFactory.createTitledBorder(nhapthongtin, "NHẬP THÔNG TIN");
		pnLophoc.setBorder(borderTitle3);
		pnLophoc.setLayout(new FlowLayout());

		pnLophoc = new JPanel();
		Border border2 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle2 = BorderFactory.createTitledBorder(border2);
		pnLophoc.setBorder(borderTitle2);
		pnLophoc.setLayout(new FlowLayout());

		JPanel pnLeft = new JPanel();
		pnLeft.setLayout(new BoxLayout(pnLeft, BoxLayout.Y_AXIS));

		JPanel nhapmaLop = new JPanel();
		nhapmaLop.setLayout(new FlowLayout());
		JLabel lblNhapmaLop = new JLabel("Mã lớp:");
		maLop = new JTextField(20);
		nhapmaLop.add(lblNhapmaLop);
		nhapmaLop.add(maLop);
		pnLeft.add(nhapmaLop);
		;

		JPanel nhapNamhoc = new JPanel();
		nhapNamhoc.setLayout(new FlowLayout());
		JLabel lblNhapNamhoc = new JLabel("Năm học:");
		namHoc = new JTextField(20);
		nhapNamhoc.add(lblNhapNamhoc);
		nhapNamhoc.add(namHoc);
		pnLeft.add(nhapNamhoc);

		JPanel nhapMota = new JPanel();
		nhapMota.setLayout(new FlowLayout());
		JLabel lblNhapMota = new JLabel("Mô tả      :");
		moTa = new JTextField(20);
		nhapMota.add(lblNhapMota);
		nhapMota.add(moTa);
		pnLeft.add(nhapMota);

		pnLophocbutton = new JPanel();
		Border border4 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle4 = BorderFactory.createTitledBorder(border4);
		pnLophocbutton.setBorder(borderTitle4);
		pnLophocbutton.setLayout(new FlowLayout());
		JPanel chucnang = new JPanel();
		chucnang.setLayout(new BoxLayout(chucnang, BoxLayout.X_AXIS));
		pnLophocbutton.setPreferredSize(new Dimension(200, 100));
		pnLophocbutton.add(ThemLop);
		pnLophocbutton.add(SuaLop);
		pnLophocbutton.add(XoaLop);

		pnLophoc.add(pnLeft);
		pnLophocbutton.add(chucnang);
		pnLophoc.add(pnLophocbutton);
		quanlilophoc.add(pnLophoc, BorderLayout.SOUTH);

		// Sinh viên
		sinhvien = new JPanel();
		sinhvien.setLayout(new BorderLayout());

		Border borderSV = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitleSV = BorderFactory.createTitledBorder(borderSV, "Danh sách");
		sinhvien.setBorder(borderTitleSV);
		pnBorder.add(sinhvien);

		dm_sv = new DefaultTableModel();

		dm_sv.addColumn("Mã SV");
		dm_sv.addColumn("Họ và tên");
		dm_sv.addColumn("Mã lớp");
		dm_sv.addColumn("Địa chỉ");
		dm_sv.addColumn("Phường");
		dm_sv.addColumn("Quận");
		dm_sv.addColumn("Thành phố");
		dm_sv.addColumn("Email");
		dm_sv.addColumn("Điện thoại");

		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM table_sinhvien");
			while (result.next()) {
				arrSV.add(new QuanLyTruongHocSV(result.getString("MaSV"), 
												result.getString("Ten"), 
												result.getString("MaLop"),
												result.getString("DiaChi"), 
												result.getString("Phuong"), 
												result.getString("Quan"),
												result.getString("ThanhPho"), 
												result.getString("Email"),
												result.getString("DT")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (QuanLyTruongHocSV x : arrSV) {
			String[] row = { x.getMaSV(), x.getTen(),
							x.getLop(), x.getDiaChi(),
							x.getPhuong(), x.getQuan(),
							x.getTp(),x.getEmail(),
							x.getSdt() };
			dm_sv.addRow(row);
		}

		table_sv = new JTable(dm_sv);
		table_sv.setLayout(new BorderLayout());
		sp_sv = new JScrollPane(table_sv);
		sc_sv = new JScrollPane(sp_sv, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc_sv.setPreferredSize(new Dimension(470, 180));
		sinhvien.add(sc_sv);
		pnBorder.add(sinhvien);

		
		pnSinhvien = new JPanel();
		Border nhapthongtinSV = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle3SV = BorderFactory.createTitledBorder(nhapthongtinSV, "NHẬP THÔNG TIN SV");
		pnSinhvien.setBorder(borderTitle3SV);
		pnSinhvien.setLayout(new FlowLayout());

		
		pnSinhvien = new JPanel();
		Border border2SV = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle2SV = BorderFactory.createTitledBorder(border2SV);
		pnSinhvien.setBorder(borderTitle2SV);
		pnSinhvien.setLayout(new FlowLayout());

		JPanel pnLeft1 = new JPanel();
		pnLeft1.setLayout(new BoxLayout(pnLeft1, BoxLayout.Y_AXIS));

		JPanel chonlop = new JPanel();
		chonlop.setLayout(new FlowLayout());
		JLabel txtlop = new JLabel("Mã lớp:  ");
		chonlop.add(txtlop);
		chonlop.add(maLopcomnoBox);
		pnLeft1.add(chonlop);

		JPanel nhapMaSV = new JPanel();
		JLabel lblNhapMaSV = new JLabel("Mã SV:");
		maSV = new JTextField(20);
		nhapMaSV.add(lblNhapMaSV);
		nhapMaSV.add(maSV);
		pnLeft1.add(nhapMaSV);

		JPanel nhapHoten = new JPanel();
		nhapHoten.setLayout(new FlowLayout());
		JLabel lblHoTenSV = new JLabel("Họ và tên:");
		hoTen = new JTextField(20);
		nhapHoten.add(lblHoTenSV);
		nhapHoten.add(hoTen);
		pnLeft1.add(nhapHoten);

		JPanel nhapEmail = new JPanel();
		nhapEmail.setLayout(new FlowLayout());
		JLabel lblnhapEmail = new JLabel("Emaill:");
		Email = new JTextField(20);
		nhapEmail.add(lblnhapEmail);
		nhapEmail.add(Email);
		pnLeft1.add(nhapEmail);

		JPanel nhapSDT = new JPanel();
		nhapSDT.setLayout(new FlowLayout());
		JLabel lblnhapSDT = new JLabel("Số điện thoại:");
		DT = new JTextField(20);
		nhapSDT.add(lblnhapSDT);
		nhapSDT.add(DT);
		pnLeft1.add(nhapSDT);

		JPanel nhapDiaChi = new JPanel();
		nhapSDT.setLayout(new FlowLayout());
		JLabel lblnhapDiaChi = new JLabel("Địa chỉ:");
		DiaChi = new JTextField(20);
		nhapDiaChi.add(lblnhapDiaChi);
		nhapDiaChi.add(DiaChi);
		pnLeft1.add(nhapDiaChi);

		JPanel chontinh = new JPanel();
		chontinh.setLayout(new FlowLayout());
		JLabel txttinh = new JLabel("Tỉnh/Thành phố:  ");
		chontinh.add(txttinh);
		chontinh.add(tp);
		pnLeft1.add(chontinh);

		JPanel chonhuyen = new JPanel();
		chonhuyen.setLayout(new FlowLayout());
		JLabel txthuyen = new JLabel("Quận/Huyện:");
		chonhuyen.add(txthuyen);
		chonhuyen.add(quan);
		pnLeft1.add(chonhuyen);

		JPanel chonquan = new JPanel();
		chonquan.setLayout(new FlowLayout());
		JLabel txtquan = new JLabel("Phường/Xã: ");
		chonquan.add(txtquan);
		chonquan.add(phuong);
		pnLeft1.add(chonquan);

		pnSinhvienbutton = new JPanel();
		Border border4SV = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle4SV = BorderFactory.createTitledBorder(border4SV);
		pnSinhvienbutton.setBorder(borderTitle4SV);
		pnSinhvienbutton.setLayout(new FlowLayout());
		JPanel chucnangSV = new JPanel();
		chucnang.setLayout(new BoxLayout(chucnang, BoxLayout.X_AXIS));
		pnSinhvienbutton.setPreferredSize(new Dimension(200, 100));
		pnSinhvienbutton.add(ThemSV);
		pnSinhvienbutton.add(SuaSV);
		pnSinhvienbutton.add(XoaSV);

		pnSinhvienbutton.add(chucnangSV);
		pnSinhvien.add(pnLeft1);
		pnSinhvien.add(pnSinhvienbutton);
		sinhvien.add(pnSinhvien, BorderLayout.SOUTH);

		
		
		
		
		
		
		pnBorder.add(sinhvien);
		cardlayout.add(sinhvien);
		pnBorder.add(quanlilophoc);
		cardlayout.add(quanlilophoc);
		
		con.add(pnBorder);
		pnBorder.add(cardlayout);
		setVisible(true);

	}

	public void maLopcomnoBox() {
		Connection conn = Connect.getConnect("localhost", "admin", "admin1", "12345");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM table_lop");
			while (result.next()) {
				maLopcomnoBox.addItem(new String(result.getString("MaLop")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void tinh() {
		Connection conn = Connect.getConnect("localhost", "admin", "admin1", "12345");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM devvn_tinhthanhpho");
			while (result.next()) {
				tp.addItem(new String(result.getString("name")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void quan() {
		Connection conn = Connect.getConnect("localhost", "admin", "admin1", "12345");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM devvn_quanhuyen");
			while (result.next()) {
				quan.addItem(new String(result.getString("name")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void huyen() {
		Connection conn = Connect.getConnect("localhost", "admin", "admin1", "12345");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM devvn_xaphuongthitran");
			while (result.next()) {
				phuong.addItem(new String(result.getString("name")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addEvent() {

		tp.addActionListener(eventChooseTp);
		quan.addActionListener(eventChooseQuan);

		table_lophoc.addMouseListener(eventTable_lophoc);
		ThemLop.addActionListener(eventAdd_lop);
		XoaLop.addActionListener(eventDel_lop);
		SuaLop.addActionListener(eventEdit_lop);

		table_sv.addMouseListener(eventTable_SV);
		ThemSV.addActionListener(eventAdd_SV);
		XoaSV.addActionListener(eventDel_SV);
		SuaSV.addActionListener(eventEdit_SV);

		qlLophoc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				sinhvien.setVisible(false);
				quanlilophoc.setVisible(true);
				// pnSouthTong.setVisible(true);

			}
		});

		ThongTinSV.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				quanlilophoc.setVisible(false);
				// pnSouthTong.setVisible(false);
				sinhvien.setVisible(true);

			}
		});

	}

	MouseAdapter eventTable_lophoc = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int row = table_lophoc.getSelectedRow();
			String[] col = new String[3];
			col[0] = (String) table_lophoc.getValueAt(row, 0);
			col[1] = (String) table_lophoc.getValueAt(row, 1);
			col[2] = (String) table_lophoc.getValueAt(row, 2);
			maLop.setText(col[0]);
			moTa.setText(col[1]);
			namHoc.setText(col[2]);
		}
	};

	ActionListener eventAdd_lop = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			String lop = maLop.getText();
			String mota = moTa.getText();
			String nam = namHoc.getText();

			try {
				arrMH.add(new QuanLyModelLopHoc(lop, mota, nam));
				dm_lophoc.addRow(new String[] { lop, mota, nam });
				Connection conn = Connect.getConnect("localhost", "admin", "admin1", "12345");
				try {
					String sql = "INSERT INTO table_lop(maLop,moTa,namHoc) VALUES (" + "'" + lop + "','" + mota + "','"
							+ nam + "')";
					Statement statement = conn.createStatement();
					int x = statement.executeUpdate(sql);
					if (x > 0) {
						JOptionPane.showMessageDialog(null, "Đã lưu thông tin sinh viên");
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			dm_lophoc.setRowCount(0);
			for (QuanLyModelLopHoc x : arrMH) {
				String[] row = { x.getMaLop(), x.getMoTa(), x.getNamHoc() };
				dm_lophoc.addRow(row);
			}

			maLop.setText("");
			moTa.setText("");
			namHoc.setText("");

		}
	};

	ActionListener eventDel_lop = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			for (QuanLyModelLopHoc x : arrMH) {
				if (maLop.getText().equals(x.getMaLop())) {
					arrMH.remove(x);
					break;
				}
			}
			Connection conn = Connect.getConnect("localhost", "admin", "admin1", "12345");
			try {
				String sql = "DELETE FROM table_lop WHERE maLop = '" + maLop.getText() + "'";
				Statement statement = conn.createStatement();
				int x = statement.executeUpdate(sql);
				if (x >= 0) {
					JOptionPane.showMessageDialog(null, "Đã sửa thông tin môn học");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			dm_lophoc.setRowCount(0);
			for (QuanLyModelLopHoc x : arrMH) {
				String[] row = { x.getMaLop(), x.getMoTa(), x.getNamHoc() };
				dm_lophoc.addRow(row);
			}
		}

	};

	ActionListener eventEdit_lop = new ActionListener() {

		
		public void actionPerformed(ActionEvent arg0) {
			for (QuanLyModelLopHoc x : arrMH) {
				if (maLop.getText().equals(x.getMaLop())) {
					x.setMoTa(moTa.getText());
					x.setNamHoc(namHoc.getText());
					break;
				}
			}
			Connection conn = Connect.getConnect("localhost", "admin", "admin1", "12345");
			try {
				String sql = "UPDATE table_lop SET NamHoc ='" + namHoc.getText() + "',MoTa ='" + moTa.getText()
						+ "' WHERE MaLop = '" + maLop.getText() + "'";
				Statement statement = conn.createStatement();
				int x = statement.executeUpdate(sql);
				if (x >= 0) {
					JOptionPane.showMessageDialog(null, "Đã sửa thông tin môn học");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			dm_lophoc.setRowCount(0);
			for (QuanLyModelLopHoc x : arrMH) {
				String[] row = { x.getMaLop(), x.getMoTa(), x.getNamHoc() };
				dm_lophoc.addRow(row);
			}

		}

	};

	MouseAdapter eventTable_SV = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {

			int row = table_sv.getSelectedRow();
			String[] col = new String[9];
			col[0] = (String) table_sv.getValueAt(row, 0);
			col[1] = (String) table_sv.getValueAt(row, 1);
			col[2] = (String) table_sv.getValueAt(row, 2);
			col[3] = (String) table_sv.getValueAt(row, 3);
			col[4] = (String) table_sv.getValueAt(row, 4);
			col[5] = (String) table_sv.getValueAt(row, 5);
			col[6] = (String) table_sv.getValueAt(row, 6);
			col[7] = (String) table_sv.getValueAt(row, 7);
			col[8] = (String) table_sv.getValueAt(row, 8);
			
			maSV.setText(col[0]);
			hoTen.setText(col[1]);
			maLopcomnoBox.setSelectedItem(col[2]);
			DiaChi.setText(col[3]);
			phuong.setSelectedItem(col[4]);
			quan.setSelectedItem(col[5]);
			tp.setSelectedItem(col[6]);
			Email.setText(col[7]);
			DT.setText(col[8]);
			
			
			
			
			
			
		

		}
	};

	ActionListener eventAdd_SV = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String lop_SinhVien = (String)maLopcomnoBox.getSelectedItem();
			String ma_SinhVien = lop_SinhVien + maSV.getText();
			String ten_SinhVien = hoTen.getText();
			String diachi_SinhVien = DiaChi.getText();
			String tp_SinhVien = (String)tp.getSelectedItem();
			String quan_SinhVien = (String)quan.getSelectedItem();
			String phuong_SinhVien = (String)phuong.getSelectedItem();
			String email_SinhVien = Email.getText();
			String sdt_SinhVien = DT.getText();

			try {
				if ( ma_SinhVien.equals(lop_SinhVien) || ten_SinhVien.equals("") || diachi_SinhVien.equals("")
						|| email_SinhVien.equals("") || sdt_SinhVien.equals("")) {
					JOptionPane.showMessageDialog(null, "Bạn chưa nhập thông tin");
				} else {
					arrSV.add(new QuanLyTruongHocSV( ma_SinhVien, ten_SinhVien,lop_SinhVien,diachi_SinhVien,phuong_SinhVien,quan_SinhVien, tp_SinhVien,email_SinhVien,sdt_SinhVien));
					dm_sv.addRow(new String[] {  ma_SinhVien, ten_SinhVien,lop_SinhVien, diachi_SinhVien,phuong_SinhVien,quan_SinhVien,tp_SinhVien,email_SinhVien,sdt_SinhVien });
					Connection conn = Connect.getConnect("localhost", "admin", "admin1", "12345");
					try {
						String sql = "INSERT INTO table_sinhvien(MaSV, Ten, MaLop , DiaChi,Phuong, Quan,ThanhPho, Email, DT) VALUES  ('"+ ma_SinhVien +"','"+ ten_SinhVien +"','"+ lop_SinhVien +"','"+ diachi_SinhVien +"','"+ phuong_SinhVien +"','"+ quan_SinhVien +"','"+ tp_SinhVien +"','"+ email_SinhVien +"','"+ sdt_SinhVien +"')";
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
			
			dm_sv.setRowCount(0);
			for (QuanLyTruongHocSV x : arrSV) {
				if (lop_SinhVien.equals(x.getLop())) {
					String[] row = {x.getMaSV(), x.getTen(), x.getLop(), x.getDiaChi(), x.getPhuong(), x.getQuan(), x.getTp(),
							x.getEmail(), x.getSdt() };
					dm_sv.addRow(row);
				}
			}
			
			maSV.setText("");
			hoTen.setText("");
			DiaChi.setText("");
			Email.setText("");
			DT.setText("");
		}
	};

	ActionListener eventDel_SV = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {

		}

	};

	ActionListener eventEdit_SV = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {

		}

	};

	ActionListener eventChooseTp = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String chonTinh = (String) tp.getSelectedItem();
			quan.removeAllItems();
			Connection conn = Connect.getConnect("localhost", "admin", "admin1", "12345");
			try {
				Statement statement = conn.createStatement();
				ResultSet result = statement.executeQuery(
						"SELECT devvn_quanhuyen.name FROM devvn_quanhuyen INNER JOIN devvn_tinhthanhpho WHERE devvn_quanhuyen.matp=devvn_tinhthanhpho.matp AND devvn_tinhthanhpho.name ='"
								+ chonTinh + "'");
				while (result.next()) {
					quan.addItem(new String(result.getString("devvn_quanhuyen.name")));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	};

	ActionListener eventChooseQuan = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String chonTinh = (String) quan.getSelectedItem();
			phuong.removeAllItems();
			Connection conn = Connect.getConnect("localhost", "admin", "admin1", "12345");
			try {
				Statement statement = conn.createStatement();
				ResultSet result = statement.executeQuery(
						"SELECT devvn_xaphuongthitran.name FROM devvn_xaphuongthitran INNER JOIN devvn_quanhuyen WHERE devvn_xaphuongthitran.maqh=devvn_quanhuyen.maqh AND devvn_quanhuyen.name ='"
								+ chonTinh + "'");
				while (result.next()) {
					phuong.addItem(new String(result.getString("devvn_xaphuongthitran.name")));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	};

	public void showWindow() {
		this.setSize(1000, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}