package ffse1702.edu.vn.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
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
import com.mysql.jdbc.Statement;

import ffse1702.edu.vn.model.SinhVien;
import ffse1702.edu.vn.model.ConnectData;

public class MyBorderLayout extends JFrame {
	private Container con;

	private JLabel chonLop;
	private JLabel title;
	private JLabel maSinhVien;
	private JLabel tenSinhVien;
	private JLabel tuoiSinhVien;

	private JTextField nhapMaSinhVien = new JTextField(20);
	private JTextField nhapTenSinhVien = new JTextField(20);
	private JTextField nhapTuoiSinhVien = new JTextField(20);

	private JPanel pnBox;
	private JPanel pnLop;
	private JPanel pnTen;
	private JPanel pnTuoi;
	private JPanel pnMaSV;
	private JPanel pnTitle;
	private JPanel pnButton;
	private JPanel pnDanhSach;

	private Button btn1 = new Button("THÊM");
	private Button btn2 = new Button("SỬA");
	private Button btn3 = new Button("XÓA");
	private Button btn4 = new Button("THOÁT");
	private Button btn5 = new Button("NHẬP");

	private JComboBox cbo = new JComboBox();
	private DefaultTableModel dm;
	private JTable tbl1;

	JScrollPane sc;

	private ArrayList<SinhVien> arr = new ArrayList<SinhVien>();

	public MyBorderLayout(String title) {
		addLayout();
		addEvent();
		this.setTitle(title);
	}

	public void addLayout() {
		con = getContentPane();

		pnBox = new JPanel();
		pnBox.setBackground(Color.pink);
		pnBox.setLayout(new BoxLayout(pnBox, BoxLayout.Y_AXIS));

		pnTitle = new JPanel();
		pnTitle.setBackground(Color.PINK);
		title = new JLabel("CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN");
		title.setOpaque(true);
		Font font = new Font("Arial", Font.BOLD, 24);
		title.setFont(font);
		title.setForeground(Color.BLACK);
		title.setBackground(Color.WHITE);
		pnTitle.add(title);
		pnBox.add(pnTitle, BorderLayout.NORTH);

		pnLop = new JPanel();
		pnLop.setLayout(new FlowLayout());
		chonLop = new JLabel("CHỌN LỚP:");
		cbo.addItem("FFSE1701");
		cbo.addItem("FFSE1702");
		cbo.addItem("FFSE1703");
		cbo.addItem("FFSE1704");
		pnLop.add(chonLop);
		pnLop.add(cbo);
		pnBox.add(pnLop);

		pnMaSV = new JPanel();
		pnMaSV.setLayout(new FlowLayout());
		maSinhVien = new JLabel("MÃ SINH VIÊN:");
		pnMaSV.add(maSinhVien);
		pnMaSV.add(nhapMaSinhVien);
		pnBox.add(pnMaSV);

		pnTen = new JPanel();
		pnTen.setLayout(new FlowLayout());
		tenSinhVien = new JLabel("TÊN SINH VIÊN:");
		pnTen.add(tenSinhVien);
		pnTen.add(nhapTenSinhVien);
		pnBox.add(pnTen);

		pnTuoi = new JPanel();
		pnTuoi.setLayout(new FlowLayout());
		tuoiSinhVien = new JLabel("TUỔI SINH VIÊN");
		pnTuoi.add(tuoiSinhVien);
		pnTuoi.add(nhapTuoiSinhVien);
		pnBox.add(pnTuoi);

		pnButton = new JPanel();
		pnButton.setLayout(new FlowLayout());
		pnButton.setBackground(Color.PINK);
		pnButton.add(btn1);
		pnButton.add(btn2);
		pnButton.add(btn3);
		pnButton.add(btn4);
		pnButton.add(btn5);
		pnBox.add(pnButton);

		pnDanhSach = new JPanel();
		pnDanhSach.setLayout(new BorderLayout());
		Border bor2 = BorderFactory.createEtchedBorder(Color.BLUE, Color.RED);
		TitledBorder titlebor2 = new TitledBorder(bor2, "DANH SÁCH:");
		pnDanhSach.setBorder(titlebor2);
		dm = new DefaultTableModel();
		tbl1 = new JTable(dm);
		dm.addColumn("Mã");
		dm.addColumn("Tên");
		dm.addColumn("Tuổi");
		dm.addColumn("Lớp");

		Connection conn = ConnectData.getConnect("localhost", "QuanLySinhVien", "QuanLySinhVien", "QuanLySinhVien");
		try {
			Statement statement = (Statement) conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM `QuanLySinhVien`");
			while (result.next()) {
				arr.add(new SinhVien(result.getString("MASV"), result.getString("NAME"), result.getString("AGE"),
						result.getString("CLASS")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (SinhVien x : arr) {
			String[] row = { x.getMaSV(), x.getTenSV(), x.getTuoiSV(), x.getLopSV() };
			dm.addRow(row);
		}

		sc = new JScrollPane(tbl1);
		pnDanhSach.add(sc);
		pnBox.add(pnDanhSach);

		con.add(pnBox);

	}

	public void addEvent() {
		btn1.addActionListener(themSinhVien);
		btn3.addActionListener(xoa);
		btn2.addActionListener(sua);

		btn4.addActionListener(exit);
		tbl1.addMouseListener(eventTable);

	}

	ActionListener sua = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			String lop = (String) cbo.getSelectedItem();
			String nhapMa = nhapMaSinhVien.getText();
			String nhapTen = nhapTenSinhVien.getText();
			String nhapTuoi = nhapTuoiSinhVien.getText();
			Connection conn = ConnectData.getConnect("localhost", "QuanLySinhVien", "QuanLySinhVien", "QuanLySinhVien");
			try {
				String sql = "UPDATE `QuanLySinhVien` SET NAME ='" + nhapTen + "',AGE='" + nhapTuoi + "' WHERE MASV='"
						+ nhapMa + "'";
				Statement statement = (Statement) conn.createStatement();
				int x = statement.executeUpdate(sql);
				if (x > 0) {
					JOptionPane.showMessageDialog(null, "Lưu OK");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			for (SinhVien x : arr) {
				if (nhapMa.equals(x.getMaSV())) {
					x.setTenSV(nhapTen);
					x.setTuoiSV(nhapTuoi);
					break;
				}
			}
			dm.setRowCount(0);
			for (SinhVien x : arr) {
				String[] row = { x.getMaSV(), x.getTenSV(), x.getTuoiSV(), x.getLopSV() };
				dm.addRow(row);
			}
			
			nhapMaSinhVien.setText("");
			nhapTenSinhVien.setText("");
			nhapTuoiSinhVien.setText("");

		}

	};
	MouseListener eventTable = new MouseListener() {

		@Override
		public void mouseClicked(MouseEvent arg0) {
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
						nhapTuoiSinhVien.setText(value);
					}
					if (y == (tbl1.getColumnCount() - 1)) {
						cbo.setSelectedItem(value);
					}

				}
			}
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

	};

	ActionListener xoa = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			String lop = (String) cbo.getSelectedItem();
			String nhapMa = nhapMaSinhVien.getText();
			String nhapTen = nhapTenSinhVien.getText();
			String nhapTuoi = nhapTuoiSinhVien.getText();
			Connection conn = ConnectData.getConnect("localhost", "QuanLySinhVien", "QuanLySinhVien", "QuanLySinhVien");
			try {
				String sql = "DELETE FROM quanlysinhvien WHERE MASV = '" + nhapMaSinhVien.getText() + "'";
				Statement statement = (Statement) conn.createStatement();
				int x = statement.executeUpdate(sql);
				if (x > 0) {
					JOptionPane.showMessageDialog(null, "Xóa OK");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			for (SinhVien x : arr) {
				if (nhapMa.equals(x.getMaSV())) {
					arr.remove(x);
					break;
				}
			}
			dm.setRowCount(0);
			for (SinhVien x : arr) {
				String[] row = { x.getMaSV(), x.getTenSV(), x.getTuoiSV(), x.getLopSV() };
				dm.addRow(row);
			}
			nhapMaSinhVien.setText("");
			nhapTenSinhVien.setText("");
			nhapTuoiSinhVien.setText("");

		}

	};
	ActionListener exit = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);

		}

	};

	ActionListener themSinhVien = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String lop = (String) cbo.getSelectedItem();
			String nhapMa = nhapMaSinhVien.getText();
			String nhapTen = nhapTenSinhVien.getText();
			String nhapTuoi = nhapTuoiSinhVien.getText();

			Connection conn = ConnectData.getConnect("localhost", "QuanLySinhVien", "QuanLySinhVien", "QuanLySinhVien");

			try {
				String sql = "insert into QuanLySinhVien(`MASV`, `NAME`, `AGE`,`CLASS`) values('"
						+ nhapMaSinhVien.getText() + "','" + nhapTenSinhVien.getText() + "','"
						+ nhapTuoiSinhVien.getText() + "','" + lop + "')";

				Statement statement = (Statement) conn.createStatement();
				int x = statement.executeUpdate(sql);
				if (x > 0) {
					JOptionPane.showMessageDialog(null, "Lưu OK");

				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			arr.add(new SinhVien(nhapMa, nhapTen, nhapTuoi, lop));
			dm.setRowCount(0);
			for (SinhVien x : arr) {
				String[] row = { x.getMaSV(), x.getTenSV(), x.getTuoiSV(), x.getLopSV() };
				dm.addRow(row);
			}

			nhapMaSinhVien.setText("");
			nhapTenSinhVien.setText("");
			nhapTuoiSinhVien.setText("");
		}

	};

	public void showWindow() {
		this.setSize(580, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

	public void inSinhVien() {
		Connection conn = ConnectData.getConnect("localhost", "QuanLySinhVien", "QuanLySinhVien", "QuanLySinhVien");
		try {
			Statement statement = (Statement) conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM `QuanLySinhVien`");
			while (result.next()) {
				arr.add(new SinhVien(result.getString("MASV"), result.getString("NAME"), result.getString("AGE"),
						result.getString("CLASS")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (SinhVien x : arr) {
			String[] row = { x.getMaSV(), x.getTenSV(), x.getTuoiSV(), x.getLopSV() };
			dm.addRow(row);
		}

	}

}
