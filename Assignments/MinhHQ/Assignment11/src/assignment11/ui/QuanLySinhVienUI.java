package assignment11.ui;

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

import assignment11.model.*;

public class QuanLySinhVienUI extends JFrame {
	boolean checked;
	private JScrollPane sp;
	private DefaultTableModel dm;
	private JTable table;
	private JComboBox select;
	private JTextField tenSV = new JTextField(), maSV = new JTextField(), tuoiSV = new JTextField();
	private ArrayList<SinhVien> arrSV = new ArrayList<SinhVien>();
	private String[] lop = { "Tất Cả", "FFSE1701", "FFSE1702", "FFSE1703", "FFSE1704" };

	private JButton them = new JButton("Thêm"), xoa = new JButton("Xóa"), sua = new JButton("Sửa"),
			thoat = new JButton("Thoát"), nhap = new JButton("Nhập");

	public QuanLySinhVienUI(String tieude) {
		super(tieude);
		addControls();
		addEvent();
	}

	public void addControls() {
		Container con = getContentPane();
		con.setLayout(new FlowLayout());
		JPanel main = new JPanel();

		main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

		JPanel Title = new JPanel();
		JLabel lbl = new JLabel("Chương trình quản lý sinh viên ");
		Font font = new Font("Arial", Font.BOLD, 14);
		lbl.setFont(font);
		Title.setPreferredSize(new Dimension(0, 30));
		Title.add(lbl);
		main.add(Title, BorderLayout.NORTH);

		JPanel chonlop = new JPanel();
		JLabel txtlop = new JLabel("Chọn lớp: ");
		select = new JComboBox(lop);
		chonlop.add(txtlop);
		chonlop.add(select);
		main.add(chonlop);

		JPanel nhapMaSV = new JPanel();
		nhapMaSV.setLayout(new FlowLayout());
		JLabel lblNhapMaSV = new JLabel("Mã sinh viên:");
		maSV = new JTextField(20);
		nhapMaSV.add(lblNhapMaSV);
		nhapMaSV.add(maSV);
		main.add(nhapMaSV);

		JPanel nhapTen = new JPanel();
		nhapTen.setLayout(new FlowLayout());
		JLabel lblNhapTen = new JLabel("Tên sinh viên:");
		tenSV = new JTextField(20);
		nhapTen.add(lblNhapTen);
		nhapTen.add(tenSV);
		main.add(nhapTen);

		JPanel nhapTuoi = new JPanel();
		nhapTuoi.setLayout(new FlowLayout());
		JLabel lblNhapTuoi = new JLabel("Tuổi sinh viên:");
		tuoiSV = new JTextField(20);
		nhapTuoi.add(lblNhapTuoi);
		nhapTuoi.add(tuoiSV);
		main.add(nhapTuoi);

		JPanel button = new JPanel();
		button.add(them);
		button.add(sua);
		button.add(xoa);
		button.add(thoat);
		button.add(nhap);
		main.add(button);

		JPanel center = new JPanel();
		center.setLayout(new BorderLayout());
		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Danh sách");
		center.setBorder(borderTitle);

		dm = new DefaultTableModel();

		dm.addColumn("Mã");
		dm.addColumn("Tên");
		dm.addColumn("Tuổi");
		dm.addColumn("Lớp");

		Connection conn = QuanLySinhVienSQL.getConnect("localhost", "minhad", "minhad", "minh");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM quanlysinhvien");
			while (result.next()) {
				arrSV.add(new SinhVien(result.getString("maSV"), result.getString("tenSV"), result.getString("tuoiSV"),
						result.getString("lopSV")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (SinhVien x : arrSV) {
			String[] row = { x.getMaSV(), x.getTenSV(), x.getTuoi(), x.getLopSV() };
			dm.addRow(row);
		}

		table = new JTable(dm);
		table.setLayout(new BorderLayout());
		sp = new JScrollPane(table);
		JScrollPane sc = new JScrollPane(sp, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc.setPreferredSize(new Dimension(470, 180));
		center.add(sc, BorderLayout.CENTER);
		main.add(center);

		con.add(main);

	}

	public void addEvent() {
		table.addMouseListener(eventTable);
		select.addActionListener(eventChooseClass);
		thoat.addActionListener(eventExit);
		them.addActionListener(eventAdd);
		xoa.addActionListener(eventDel);
		sua.addActionListener(eventEdit);

	}

	MouseAdapter eventTable = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int row = table.getSelectedRow();
			String[] col = new String[3];
			col[0] = (String) table.getValueAt(row, 0);
			col[1] = (String) table.getValueAt(row, 1);
			col[2] = (String) table.getValueAt(row, 2);
			maSV.setText(col[0]);
			tenSV.setText(col[1]);
			tuoiSV.setText(col[2]);
		}
	};

	ActionListener eventChooseClass = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String chonLop = (String) select.getSelectedItem();
			dm.setRowCount(0);
			if (chonLop == "Tất Cả") {
				SinhVien[] temp = new SinhVien[arrSV.size()];
				for (int i = 0; i < arrSV.size() - 1; i++) {
					for (int j = i + 1; j < arrSV.size(); j++) {
						if (arrSV.get(i).getTenSV().compareTo(arrSV.get(j).getTenSV()) > 0) {
							temp[i] = arrSV.get(j);
							arrSV.set(j, arrSV.get(i));
							arrSV.set(i, temp[i]);
						}
					}
				}
				for (SinhVien x : arrSV) {
					String[] row = { x.getMaSV(), x.getTenSV(), x.getTuoi(), x.getLopSV() };
					dm.addRow(row);
				}
			} else {
				for (SinhVien x : arrSV) {
					if (chonLop.equals(x.getLopSV())) {
						String[] row = { x.getMaSV(), x.getTenSV(), x.getTuoi(), x.getLopSV() };
						dm.addRow(row);
					}
				}
			}
			maSV.setText("");
			tenSV.setText("");
			tuoiSV.setText("");
		}

	};

	ActionListener eventExit = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);

		}

	};

	ActionListener eventAdd = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String chonLop = (String) select.getSelectedItem();
			String ma = chonLop + maSV.getText();
			String ten = tenSV.getText();
			String tuoi = tuoiSV.getText();

			try {
				if (chonLop.equals("Tất Cả")) {
					JOptionPane.showMessageDialog(null, "Bạn chưa chọn lớp cho sinh viên");
				} else if (ma.equals(chonLop) || ten.equals("") || tuoi.equals("")) {
					JOptionPane.showMessageDialog(null, "Bạn chưa nhập thông tin cho sinh viên");
				} else {
					arrSV.add(new SinhVien(ma, ten, tuoi, chonLop));
					dm.addRow(new String[] { ma, ten, tuoi, chonLop });
					Connection conn = QuanLySinhVienSQL.getConnect("localhost", "minhad", "minhad", "minh");
					try {
						String sql = "INSERT INTO quanlysinhvien(maSV,tenSV,tuoiSV,lopSV) VALUES (" + "'" + ma + "','"
								+ ten + "','" + tuoi + "','" + chonLop + "'" + ")";
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

			maSV.setText("");
			tenSV.setText("");
			tuoiSV.setText("");

		}
	};

	ActionListener eventDel = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			for (SinhVien x : arrSV) {
				if (maSV.getText().equals(x.getMaSV())) {
					arrSV.remove(x);
					break;
				}
			}
			Connection conn = QuanLySinhVienSQL.getConnect("localhost", "minhad", "minhad", "minh");
			try {
				String sql = "DELETE FROM quanlysinhvien WHERE maSV = '" + maSV.getText() + "'";
				Statement statement = conn.createStatement();
				int x = statement.executeUpdate(sql);
				if (x >= 0) {
					JOptionPane.showMessageDialog(null, "Đã xóa thông tin sinh viên");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			dm.setRowCount(0);
			for (SinhVien x : arrSV) {
				String[] row = { x.getMaSV(), x.getTenSV(), x.getTuoi(), x.getLopSV() };
				dm.addRow(row);
			}
		}

	};

	ActionListener eventEdit = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			for (SinhVien x : arrSV) {
				if (maSV.getText().equals(x.getMaSV())) {
					x.setTenSV(tenSV.getText());
					x.setTuoi(tuoiSV.getText());
					break;
				}
			}
			Connection conn = QuanLySinhVienSQL.getConnect("localhost", "minhad", "minhad", "minh");
			try {
				String sql = "UPDATE quanlysinhvien SET tenSV ='" + tenSV.getText() + "',tuoiSV ='" + tuoiSV.getText()
						+ "' WHERE maSV = '" + maSV.getText() + "'";
				Statement statement = conn.createStatement();
				int x = statement.executeUpdate(sql);
				if (x >= 0) {
					JOptionPane.showMessageDialog(null, "Đã sửa thông tin sinh viên");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			dm.setRowCount(0);
			for (SinhVien x : arrSV) {
				String[] row = { x.getMaSV(), x.getTenSV(), x.getTuoi(), x.getLopSV() };
				dm.addRow(row);
			}

		}

	};

	public void showWindow() {
		this.setSize(500, 440);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
