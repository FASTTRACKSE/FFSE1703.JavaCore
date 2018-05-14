package project.ui;

import project.connect.Connect;
import project.model.*;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class QuanLySinhVienUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private Button Lop = new Button("Quản lý Lớp Học");
	private Button SV = new Button("Quản lý Sinh Viên");
	private Button MH = new Button("Quản lý Môn Học");
	private Button LopMH = new Button("Môn Học của từng Lớp");
	private Button Diem = new Button("Nhập Điểm");
	private Button Thongke = new Button("Thống kê");

	private JTextField MaMH = new JTextField();
	private JTextField TenMH = new JTextField();
	private JTextField Tinchi = new JTextField();
	private JTextField Time = new JTextField();

	private JTextField maMHLop = new JTextField();

	private JTextField DiemSV = new JTextField();


	private ArrayList<MonHocLop> arrLopMH = new ArrayList<MonHocLop>();
	private ArrayList<Diem> arrDiem = new ArrayList<Diem>();




	private JButton themMonHocLop = new JButton("Thêm");
	private JButton xoaMonHocLop = new JButton("Xóa");



	private JButton suaND = new JButton("Sửa");


	private JComboBox<String> selectNhapDiem = new JComboBox<>();
	private JComboBox<String> selectMonHoc = new JComboBox<>();
	private JComboBox<String> selectMaMH = new JComboBox<>();
	private JComboBox<String> selectMaSV = new JComboBox<>();

	
	private DefaultTableModel dm_MonHoc_lop;
	private JTable table_MonHoc_lop;
	private JScrollPane sp_MonHoc_lop;



	private DefaultTableModel dm_NhapDiem;
	private JTable table_NhapDiem;
	private JScrollPane sp_NhapDiem;
	
	CardLayout cardlayout = new CardLayout();
	JPanel ttSV = new JPanel();

	private SinhVienUI sinhVienUI;
	private LopHocUI lopHocUI;
	private MonHocUI monHocUI;
	private JPanel Lop_MonHoc = new JPanel();

	private JPanel NhapDiem = new JPanel();

	public QuanLySinhVienUI(String tieude) {
		super(tieude);
		lop(selectMonHoc);
		lop(selectNhapDiem);
		monhoc(selectMaMH);
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

		
		
		// Quản lý môn học theo lớp

		Lop_MonHoc.setLayout(new BoxLayout(Lop_MonHoc, BoxLayout.Y_AXIS));

		JPanel pnMH_lopMonHoc = new JPanel();
		pnMH_lopMonHoc.setLayout(new FlowLayout());

		JPanel nhapMaLop = new JPanel();
		nhapMaLop.setLayout(new FlowLayout());
		JLabel lblchonLop = new JLabel("Mã lớp học:");
		nhapMaLop.add(lblchonLop);
		nhapMaLop.add(selectMonHoc);
		pnMH_lopMonHoc.add(nhapMaLop);

		JPanel nhapMaMHLop = new JPanel();
		nhapMaMHLop.setLayout(new FlowLayout());
		JLabel lblNhapMaMHLop = new JLabel("Mã môn học:");
		maMHLop = new JTextField(12);
		nhapMaMHLop.add(lblNhapMaMHLop);
		nhapMaMHLop.add(maMHLop);
		pnMH_lopMonHoc.add(nhapMaMHLop);

		pnMH_lopMonHoc.add(themMonHocLop);
		pnMH_lopMonHoc.add(xoaMonHocLop);

		Lop_MonHoc.add(pnMH_lopMonHoc);

		JPanel Table_lopMonHoc = new JPanel();
		Table_lopMonHoc.setLayout(new BorderLayout());
		Border border_lopMonHoc = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle_lopMonHoc = BorderFactory.createTitledBorder(border_lopMonHoc, "Danh sách môn học");
		Table_lopMonHoc.setBorder(borderTitle_lopMonHoc);

		dm_MonHoc_lop = new DefaultTableModel();

		dm_MonHoc_lop.addColumn("Mã lớp học");
		dm_MonHoc_lop.addColumn("Mã môn học");
		dm_MonHoc_lop.addColumn("Tên môn học");
		dm_MonHoc_lop.addColumn("Tín chỉ");
		dm_MonHoc_lop.addColumn("Thời gian học");
		Connection conn = Connect.getConnect("localhost", "minhad", "minhad", "minh");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM monhoc");
			while (result.next()) {
				arrLopMH.add(new MonHocLop(result.getString("MaMH"), result.getString("Ten"),
						result.getString("TenLop"), result.getString("SoTC"), result.getString("thoigian")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (MonHocLop x : arrLopMH) {
			String[] row = { x.getTenLop(), x.getMaMH(), x.getTenMH(), x.getSoTC(), x.getThoigian() };
			dm_MonHoc_lop.addRow(row);
		}

		table_MonHoc_lop = new JTable(dm_MonHoc_lop);
		table_MonHoc_lop.setLayout(new BorderLayout());
		sp_MonHoc_lop = new JScrollPane(table_MonHoc_lop);
		JScrollPane sc_lopMonHoc = new JScrollPane(sp_MonHoc_lop, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc_lopMonHoc.setPreferredSize(new Dimension(470, 180));
		Table_lopMonHoc.add(sc_lopMonHoc, BorderLayout.CENTER);
		Lop_MonHoc.add(Table_lopMonHoc);

		// Nhập điểm cho sinh viên

		NhapDiem.setLayout(new BoxLayout(NhapDiem, BoxLayout.Y_AXIS));

		JPanel pnLeft_NhapDiem = new JPanel();

		JPanel chonlop_NhapDiem = new JPanel();
		chonlop_NhapDiem.setLayout(new FlowLayout());
		JLabel txtlop_NhapDiem = new JLabel("Mã lớp học: ");
		chonlop_NhapDiem.add(txtlop_NhapDiem);
		chonlop_NhapDiem.add(selectNhapDiem);
		pnLeft_NhapDiem.add(chonlop_NhapDiem);

		JPanel chon_NhapDiem = new JPanel();
		chon_NhapDiem.setLayout(new FlowLayout());
		JLabel txt_NhapDiem = new JLabel("Mã môn học: ");
		chon_NhapDiem.add(txt_NhapDiem);
		chon_NhapDiem.add(selectMaMH);
		pnLeft_NhapDiem.add(chon_NhapDiem);

		JPanel pnLop_NhapDiem = new JPanel();
		pnLop_NhapDiem.setLayout(new FlowLayout());
		JLabel txtLop_NhapDiem = new JLabel("Mã sinh viên: ");
		pnLop_NhapDiem.add(txtLop_NhapDiem);
		pnLop_NhapDiem.add(selectMaSV);
		pnLeft_NhapDiem.add(pnLop_NhapDiem);

		JPanel nhapDiem = new JPanel();
		nhapDiem.setLayout(new FlowLayout());
		JLabel lblNhapDiem = new JLabel("Điểm :");
		DiemSV = new JTextField(20);
		nhapDiem.add(lblNhapDiem);
		nhapDiem.add(DiemSV);
		pnLeft_NhapDiem.add(nhapDiem);
		pnLeft_NhapDiem.add(suaND);

		JPanel pn_NhapDiem = new JPanel();
		pn_NhapDiem.setLayout(new FlowLayout());

		pn_NhapDiem.add(pnLeft_NhapDiem);
		NhapDiem.add(pn_NhapDiem);

		JPanel Table_NhapDiem = new JPanel();
		Table_NhapDiem.setLayout(new BorderLayout());
		Border border_NhapDiem = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle_NhapDiem = BorderFactory.createTitledBorder(border_NhapDiem,
				"Danh sách điểm sinh viên");
		Table_NhapDiem.setBorder(borderTitle_NhapDiem);

		dm_NhapDiem = new DefaultTableModel();

		dm_NhapDiem.addColumn("Mã lớp");
		dm_NhapDiem.addColumn("Mã sinh viên");
		dm_NhapDiem.addColumn("Mã môn học");
		dm_NhapDiem.addColumn("Điểm");

		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM diem");
			while (result.next()) {
				arrDiem.add(new Diem(result.getString("MaLop"), result.getString("MaSV"), result.getString("MaMH"),
						result.getString("Diem")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (Diem x : arrDiem) {
			String[] row = { x.getLop(), x.getMaSV(), x.getMaMH(), x.getDiem() };
			dm_NhapDiem.addRow(row);
		}

		table_NhapDiem = new JTable(dm_NhapDiem);
		table_NhapDiem.setLayout(new BorderLayout());
		sp_NhapDiem = new JScrollPane(table_NhapDiem);
		JScrollPane sc_NhapDiem = new JScrollPane(sp_NhapDiem, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc_NhapDiem.setPreferredSize(new Dimension(470, 180));
		Table_NhapDiem.add(sc_NhapDiem, BorderLayout.CENTER);
		NhapDiem.add(Table_NhapDiem);
		
		lopHocUI = new LopHocUI();
		ttSV.add(lopHocUI, "1");

		Main.add(ttSV);
		con.add(Main);
		setVisible(true);
	}

	// Lấy giá trị tĩnh cho các JComboBox

	public void lop(JComboBox<String> x) {
		x.addItem("Tất Cả");
		Connection conn = Connect.getConnect("localhost", "minhad", "minhad", "minh");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM lophoc");
			while (result.next()) {
				x.addItem(new String(result.getString("MaLop")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void monhoc(JComboBox<String> x) {
		Connection conn = Connect.getConnect("localhost", "minhad", "minhad", "minh");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM table_monhoc");
			while (result.next()) {
				x.addItem(new String(result.getString("MaMH")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// lấy xong giá trị của JComboBox

	public void addEvent() {

		
		// CRUD môn học cho từng lớp học
		 table_MonHoc_lop.addMouseListener(eventTable_MonHocLop);
		 themMonHocLop.addActionListener(eventAdd_MonHocLop);
		 xoaMonHocLop.addActionListener(eventDel_MonHocLop);

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
				ttSV.add(Lop_MonHoc, "4");
				cardlayout.show(ttSV, "4");
			}
		});

		Diem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				ttSV.add(NhapDiem, "5");
				cardlayout.show(ttSV, "5");
			}
		});
	}

	
	
	// CRUD môn học cho lớp học

		MouseAdapter eventTable_MonHocLop = new MouseAdapter() {
//			public void mouseClicked(MouseEvent e) {
//				int row = table_MonHoc.getSelectedRow();
//				String[] col = new String[4];
//				col[0] = (String) table_MonHoc.getValueAt(row, 0);
//				col[1] = (String) table_MonHoc.getValueAt(row, 1);
//				col[2] = (String) table_MonHoc.getValueAt(row, 2);
//				col[3] = (String) table_MonHoc.getValueAt(row, 3);
//				themMonHoc.setEnabled(false);
//				MaMH.setEditable(false);
//				MaMH.setText(col[0]);
//				TenMH.setText(col[1]);
//				Tinchi.setText(col[2]);
//				Time.setText(col[3]);
//			}
		};

		ActionListener eventAdd_MonHocLop = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String ma_MonHoc = MaMH.getText();
				String ten_MonHoc = TenMH.getText();
				String tinchi_MonHoc = Tinchi.getText();
				String time_MonHoc = Time.getText();

				try {
					Connection conn = Connect.getConnect("localhost", "minhad", "minhad", "minh");
					if (ma_MonHoc.equals("") || ten_MonHoc.equals("") || tinchi_MonHoc.equals("")
							|| time_MonHoc.equals("")) {
						JOptionPane.showMessageDialog(null, "Bạn chưa nhập thông tin");
					} else {
//						for (MonHoc y : arrMH) {
//							if (ma_MonHoc.equals(y.getMaMH())) {
//								JOptionPane.showMessageDialog(null, "Trùng mã môn học");
//								break;
//							} else {
//								arrMH.add(new MonHoc(ma_MonHoc, ten_MonHoc, tinchi_MonHoc, time_MonHoc));
//								dm_MonHoc.addRow(new String[] { ma_MonHoc, ten_MonHoc, tinchi_MonHoc, time_MonHoc });

								try {
									String sql = "INSERT INTO table_monhoc( maMH, tenMH, STC, ThoiGian) VALUES ('"
											+ ma_MonHoc + "','" + ten_MonHoc + "','" + tinchi_MonHoc + "','" + time_MonHoc
											+ "')";
									Statement statement = conn.createStatement();
									int x = statement.executeUpdate(sql);
									if (x > 0) {
										JOptionPane.showMessageDialog(null, "Đã lưu thông tin");
									}
								} catch (Exception ex) {
									ex.printStackTrace();
								}
//							}
//
//						}
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Bạn cần nhập thông tin");
				}

				MaMH.setText("");
				TenMH.setText("");
				Tinchi.setText("");
				Time.setText("");
			}
		};

		ActionListener eventDel_MonHocLop = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
//				for (MonHoc x : arrMH) {
//					if (MaMH.getText().equals(x.getMaMH())) {
//						arrMH.remove(x);
//						break;
//					}
//				}
				Connection conn = Connect.getConnect("localhost", "minhad", "minhad", "minh");
				try {
					String sql = "DELETE FROM table_monhoc WHERE MaMH = '" + MaMH.getText() + "'";
					Statement statement = conn.createStatement();
					int x = statement.executeUpdate(sql);
					if (x >= 0) {
						JOptionPane.showMessageDialog(null, "Đã xóa thông tin sinh viên");
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
//				dm_MonHoc.setRowCount(0);
//				for (MonHoc x : arrMH) {
//					String[] row = { x.getMaMH(), x.getTenMH(), x.getTinChi(), x.getTime() };
//					dm_MonHoc.addRow(row);
//				}

				MaMH.setText("");
				TenMH.setText("");
				Tinchi.setText("");
				Time.setText("");
			}

		};	
	//kết thúc CRUD chọn môn học cho lớp

	// CRUD nhập điểm

	MouseAdapter eventTable_NhapDiem = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int row = table_NhapDiem.getSelectedRow();
			String[] col = new String[4];
			col[0] = (String) table_NhapDiem.getValueAt(row, 0);
			col[1] = (String) table_NhapDiem.getValueAt(row, 1);
			col[2] = (String) table_NhapDiem.getValueAt(row, 2);
			col[3] = (String) table_NhapDiem.getValueAt(row, 3);
			selectNhapDiem.setSelectedItem(col[0]);
			selectMaMH.setSelectedItem(col[1]);
			selectMaSV.setSelectedItem(col[2]);
			DiemSV.setText(col[3]);
		}
	};

	ActionListener eventEdit_NhapDiem = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			for (Diem x : arrDiem) {
			}
			Connection conn = Connect.getConnect("localhost", "minhad", "minhad", "minh");
			try {
				String sql = "UPDATE table_monhoc SET TenMH ='" + TenMH.getText() + "',STC ='" + Tinchi.getText()
						+ "',ThoiGian ='" + Time.getText() + "' WHERE MaMH = '" + MaMH.getText() + "'";
				Statement statement = conn.createStatement();
				int x = statement.executeUpdate(sql);
				if (x >= 0) {
					JOptionPane.showMessageDialog(null, "Đã sửa thông tin sinh viên");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
//			dm_MonHoc.setRowCount(0);
//			for (MonHoc x : arrMH) {
//				String[] row = { x.getMaMH(), x.getTenMH(), x.getTinChi(), x.getTime() };
//				dm_MonHoc.addRow(row);
//			}
		}
	};
	// kết thúc CRUD nhập điểm

	// Chọn đối tượng cho nhập điểm

	// kết thúc việc chọn đối tượng

	public void showWindow() {
		this.setSize(1350, 700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setMinimumSize(new Dimension(1050, 567));
		this.setVisible(true);
	}
}
