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
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.sun.glass.events.MouseEvent;

import ffse1702010.edu.vn.model.ThongTinSinhVien;

public class MyLayout extends JFrame {

	private Container con;

	private JPanel pnBorder;
	private JPanel pnESL;
	private JPanel pnMTD;
	private JPanel pnPQT;
	private JPanel pnJcombobox;
	private JPanel pnCRUD;
	private JPanel pnLopHoc;
	private JPanel pnQuanLySinhVien;
	private JPanel pnQuanLyDiem;

	private Button btn1 = new Button("QUẢN LÝ SINH VIÊN");
	private Button btn2 = new Button("QUẢN LÝ ĐIỂM");
	private Button btn3 = new Button("QUẢN LÝ LỚP HỌC");
	private Button btn4 = new Button("QUẢN LÝ MÔN HỌC");
	private Button btn5 = new Button("THỐNG KÊ BÁO CÁO");
	private Button them = new Button("THÊM");
	private Button sua = new Button("SỬA");
	private Button xoa = new Button("XÓA");

	private JTextField nhapMaSinhVien = new JTextField(15);
	private JTextField nhapTenSinhVien = new JTextField(20);
	private JTextField nhapNgaySinh = new JTextField(20);
	private JTextField nhapDiaChi = new JTextField(20);
	private JTextField nhapEmail = new JTextField(20);
	private JTextField nhapSDT = new JTextField(20);

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

	final ObservableList<Object> options = FXCollections.observableArrayList();

	private JComboBox cboLop = new JComboBox();
	private JComboBox cboPhuong = new JComboBox();
	private JComboBox cboQuan = new JComboBox();
	private JComboBox cboTinh = new JComboBox();

	private DefaultTableModel dm;
	private JTable tbl1;
	int stt = 0;
	JScrollPane sc;

	private ArrayList<ThongTinSinhVien> arrSV = new ArrayList<ThongTinSinhVien>();

	public MyLayout(String title) {

		this.setTitle(title);
		addLayout();
		tinh();
		quan();
		huyen();
		addEvent();
	}

	public void addLayout() {
		con = getContentPane();

		JPanel cardLayout = new JPanel();
		cardLayout.setLayout(new CardLayout());

		pnBorder = new JPanel();
		pnBorder.setLayout(new BorderLayout());

		JPanel pnTitle2 = new JPanel();
		pnTitle2.add(new JLabel(new ImageIcon("image/t1.jpg")));
		// pnTitle2.setBackground(new Color(255, 255, 255));
		// pnTitle2.setMaximumSize(new Dimension(1200, 70));
		pnBorder.add(pnTitle2);

		JPanel pnNorth = new JPanel();
		JLabel title = new JLabel("CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN");
		title.setOpaque(true);
		Font font = new Font("Arial", Font.BOLD, 24);
		title.setFont(font);
		title.setForeground(Color.BLACK);
		title.setBackground(Color.WHITE);
		pnNorth.add(title);
		pnNorth.setBackground(Color.pink);
		pnBorder.add(pnNorth, BorderLayout.NORTH);

		JPanel pnWest = new JPanel();
		pnWest.setLayout(new BoxLayout(pnWest, BoxLayout.Y_AXIS));
		pnWest.add(btn1);
		pnWest.add(btn2);
		pnWest.add(btn3);
		pnWest.add(btn4);
		pnWest.add(btn5);
		pnBorder.add(pnWest, BorderLayout.WEST);

		pnQuanLySinhVien = new JPanel();
		pnQuanLySinhVien.setLayout(new BorderLayout());

		JPanel pnSouth = new JPanel();
		pnSouth.setLayout(new BoxLayout(pnSouth, BoxLayout.Y_AXIS));

		Border bor3 = BorderFactory.createMatteBorder(1, 1, 5, 5, Color.WHITE);
		TitledBorder titlebor3 = new TitledBorder(bor3, "THÊM THÔNG TIN SINH VIÊN:");
		pnSouth.setBorder(titlebor3);

		maSinhVien = new JLabel("MÃ SINH VIÊN");
		tenSinhVien = new JLabel("TÊN SINH VIÊN");
		ngaySinh = new JLabel("NGÀY SINH");
		diaChi = new JLabel("ĐỊA CHỈ");
		email = new JLabel("EMAIL(@gmail.com)");
		sDT = new JLabel("SỐ ĐIỆN THOẠI");
		chonLop = new JLabel("CHỌN LỚP");
		chonPhuong = new JLabel("CHỌN PHƯỜNG");
		chonQuan = new JLabel("CHỌN QUẬN");
		chonTinh = new JLabel("CHỌN TỈNH");

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
		pnJcombobox.add(chonLop);
		cboLop.addItem("FFSE1701");
		cboLop.addItem("FFSE1702");
		cboLop.addItem("FFSE1703");
		cboLop.addItem("FFSE1704");
		pnJcombobox.add(cboLop);

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
		pnQuanLyDiem = new JPanel();
		pnQuanLyDiem.setLayout(new BorderLayout());

		

		pnBorder.add(pnQuanLySinhVien);
		pnBorder.add(pnQuanLyDiem);
		cardLayout.add(pnQuanLySinhVien);
		cardLayout.add(pnQuanLyDiem);
		pnBorder.add(cardLayout);

		getContentPane().add(pnBorder);
		con.add(pnBorder);

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

	}

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

	public void addEvent() {
		cboTinh.addActionListener(eventChooseQuan);
		cboQuan.addActionListener(eventChoosePhuong);
		btn2.addActionListener(eventQuanLyDiem);
		btn1.addActionListener(eventQuanLySinhVien);

		them.addActionListener(eventAdd);
		xoa.addActionListener(eventDel);
		sua.addActionListener(eventEdit);

		tbl1.addMouseListener(eventTable);

	}

	MouseListener eventTable = new MouseListener() {

		@Override
		public void mouseClicked(java.awt.event.MouseEvent e) {
			for (int i = tbl1.getSelectedRow(); i <= tbl1.getSelectedRow(); i++) {
				for (int y = 0; y < tbl1.getColumnCount(); y++) {
					String value = (String) tbl1.getValueAt(i, y);
					if (y == 0) {
						nhapMaSinhVien.setText(value);
					}
					if (y == 1) {
						nhapTenSinhVien.setText(value);
					}
					if (y == 2) {
						nhapNgaySinh.setText(value);
					}
					if (y == 3) {
						nhapDiaChi.setText(value);
					}
					if (y == 4) {
						nhapEmail.setText(value);
					}
					if (y == 5) {
						nhapSDT.setText(value);
					}
					if (y == 6) {
						cboLop.setSelectedItem(value);
					}
					if (y == 7) {
						cboPhuong.setSelectedItem(value);
					}
					if (y == 8) {
						cboQuan.setSelectedItem(value);
					}
					if (y == (tbl1.getColumnCount() - 1)) {
						cboTinh.setSelectedItem(value);
					}

				}
			}

		}

		@Override
		public void mouseEntered(java.awt.event.MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(java.awt.event.MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(java.awt.event.MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(java.awt.event.MouseEvent e) {
			// TODO Auto-generated method stub

		}

	};
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
					x.setLop((String) cboLop.getSelectedItem());
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

				JOptionPane.showMessageDialog(null, "MÃ SINH VIÊN ĐÃ TỒN TẠI", null, JOptionPane.WARNING_MESSAGE);
				nhapNgaySinh.setText("");
				nhapMaSinhVien.setText("");
				nhapTenSinhVien.setText("");
				nhapDiaChi.setText("");
				nhapEmail.setText("");
				nhapSDT.setText("");
			} else if (ktTonTai != 1) {
				JOptionPane.showMessageDialog(null, "MÃ SINH VIÊN KHÔNG ĐƯỢC SỮA,HÃY THÊM MỚI SINH VIÊN", null,
						JOptionPane.WARNING_MESSAGE);
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
							+ nhapSDT.getText() + "',Lop ='" + (String) cboLop.getSelectedItem() + "'," + "Phuong ='"
							+ (String) cboPhuong.getSelectedItem() + "',Quan ='" + (String) cboQuan.getSelectedItem()
							+ "',Tinh ='" + (String) cboTinh.getSelectedItem() + "' WHERE MaSV = '"
							+ nhapMaSinhVien.getText() + "'";
					Statement statement = conn.createStatement();
					System.out.println(sql);
					int x = statement.executeUpdate(sql);
					if (x >= 0) {
						JOptionPane.showMessageDialog(null, "Đã sửa thông tin sinh viên");
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

			}

		}

	};

	ActionListener eventDel = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			for (ThongTinSinhVien x : arrSV) {
				if (nhapMaSinhVien.getText().equals(x.getMaSV())) {
					arrSV.remove(x);
					break;
				}
			}
			Connection conn = ConnectData.getConnect("localhost", "QuanLySinhVien", "QuanLySinhVien", "QuanLySinhVien");
			try {
				String sql = "DELETE FROM SinhVien WHERE MaSV = '" + nhapMaSinhVien.getText() + "'";
				Statement statement = conn.createStatement();
				int x = statement.executeUpdate(sql);
				if (x >= 0) {
					JOptionPane.showMessageDialog(null, "Đã xóa thông tin sinh viên");
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

			dm.setRowCount(0);

			for (ThongTinSinhVien x : arrSV) {
				String[] row = { x.getMaSV(), x.getTenSV(), x.getNgaySinh(), x.getDiaChi(), x.getEmail(), x.getsDT(),
						x.getLop(), x.getPhuong(), x.getQuan(), x.getTinh() };
				dm.addRow(row);
			}

		}
	};

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
			String chonLop = (String) cboLop.getSelectedItem();
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

			} else if (ktTonTai > 0) {
				JOptionPane.showMessageDialog(null, "MÃ SINH VIÊN ĐÃ TỒN TẠI", null, JOptionPane.WARNING_MESSAGE);
				nhapNgaySinh.setText("");
				nhapMaSinhVien.setText("");
				nhapTenSinhVien.setText("");
				nhapDiaChi.setText("");
				nhapEmail.setText("");
				nhapSDT.setText("");
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
					System.out.println(sql);
					Statement statement = conn.createStatement();
					int x = statement.executeUpdate(sql);
					if (x > 0) {
						JOptionPane.showMessageDialog(null, "Đã lưu thông tin sinh viên");
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

			}
		}
	};

	ActionListener eventQuanLyDiem = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			pnQuanLySinhVien.setVisible(false);
			pnQuanLyDiem.setVisible(true);

		}

	};
	ActionListener eventQuanLySinhVien = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			pnQuanLySinhVien.setVisible(true);
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
				System.out.println(result.next());
				while (result.next()) {
					cboPhuong.addItem(result.getString("devvn_xaphuongthitran.name"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(chonPhuong);
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
				System.out.println(result.next());
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
