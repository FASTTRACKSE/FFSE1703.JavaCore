package fasttrackse.edu.vn.ui;

import fasttrackse.edu.vn.io.TextFileFactory;
import fasttrackse.edu.vn.model.SinhVien;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

import java.awt.event.*;
import java.nio.file.*;
import java.util.ArrayList;

public class QuanLySVUI extends JFrame {
	JScrollPane sp;
	DefaultTableModel dm;
	JTable table;
	JComboBox select;
	private JTextField maSV = new JTextField(15);
	private JTextField tenSV = new JTextField(15);
	private JTextField tuoiSV = new JTextField(15);
	private JButton btnThem = new JButton("Thêm");
	private JButton btnSua = new JButton("Sửa");
	private JButton btnXoa = new JButton("Xóa");
	private JButton btnThoat = new JButton("Thoát");
	private JButton btnNhap = new JButton("Nhập");
	static ArrayList<SinhVien> arrSV = new ArrayList<SinhVien>();
	String chonLop[] = { "FFSE1701", "FFSE1702", "FFSE1703", "FFSE1704" };

	public QuanLySVUI(String title) {
		super(title);
		addControls();
		addEvents();
	}
	public void addControls() {
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		JLabel lbl = new JLabel("Chương trình quản lý sinh viên");
		Font font = new Font("Arial", Font.BOLD, 19);
		lbl.setFont(font);
		lbl.setForeground(Color.BLACK);
		JPanel Title = new JPanel();
		Title.add(lbl);
		pnMain.add(Title);

		JPanel chonLopSV = new JPanel();
		JLabel lop = new JLabel("Chọn Lớp:");
		select = new JComboBox(chonLop);
		chonLopSV.add(lop);
		chonLopSV.add(select);
		pnMain.add(chonLopSV);

		JPanel nhapmaSV = new JPanel();
		nhapmaSV.setLayout(new FlowLayout());
		JLabel ma = new JLabel("Nhập mã Sinh viên :");
		maSV = new JTextField(16);
		nhapmaSV.add(ma);
		nhapmaSV.add(maSV);
		pnMain.add(nhapmaSV);

		JPanel nhaptenSV = new JPanel();
		nhaptenSV.setLayout(new FlowLayout());
		JLabel ten = new JLabel("Nhập tên Sinh viên:");
		tenSV = new JTextField(16);
		nhaptenSV.add(ten);
		nhaptenSV.add(tenSV);
		pnMain.add(nhaptenSV);

		JPanel nhaptuoiSV = new JPanel();
		nhaptuoiSV.setLayout(new FlowLayout());
		JLabel tuoi = new JLabel("Nhập tuổi Sinh viên:");
		tuoiSV = new JTextField(16);
		nhaptuoiSV.add(tuoi);
		nhaptuoiSV.add(tuoiSV);
		pnMain.add(nhaptuoiSV);

		JPanel Button = new JPanel();
		Button.setLayout(new FlowLayout());
		Button.add(btnThem);
		Button.add(btnSua);
		Button.add(btnXoa);
		Button.add(btnThoat);
		Button.add(btnNhap);
		pnMain.add(Button);

		JPanel center = new JPanel();
		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Danh sách");

		dm = new DefaultTableModel();
		dm.addColumn("Mã");
		dm.addColumn("Tên");
		dm.addColumn("Tuổi");
		dm.addColumn("Lớp");

		docFile();
		for (SinhVien x : arrSV) {
			dm.addRow(new String[] { x.getMaSV(), x.getTenSV(), x.getTuoiSV(), x.getLopSV() });

		}

		table = new JTable(dm);
		sp = new JScrollPane(table);
		JScrollPane sc = new JScrollPane(sp, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc.setPreferredSize(new Dimension(470, 120));
		center.add(sc, BorderLayout.CENTER);
		pnMain.add(center);
		center.setBorder(borderTitle);

		con.add(pnMain);
	}
	private void addEvents() {
		table.addMouseListener(eventTable);
		select.addActionListener(eventChooseClass);
		btnThem.addActionListener(eventThem);
		btnSua.addActionListener(eventSua);
		btnXoa.addActionListener(eventXoa);
		btnThoat.addActionListener(eventThoat);
		btnNhap.addActionListener(eventNhap);

	}

	MouseListener eventTable = new MouseAdapter() {

		public void mouseClicked(MouseEvent e) {
			int col = table.getSelectedRow();
			String[] row = new String[3];
			row[0] = (String) table.getValueAt(col, 0);
			row[1] = (String) table.getValueAt(col, 1);
			row[2] = (String) table.getValueAt(col, 2);
			maSV.setText(row[0]);
			tenSV.setText(row[1]);
			tuoiSV.setText(row[2]);
		}
	};
	ActionListener eventChooseClass = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			docFile();
			String chonLop = (String) select.getSelectedItem();
			dm.setRowCount(0);
			if (chonLop == "Tất Cả") {
				for (SinhVien x : arrSV) {
					String[] row = { x.getMaSV(), x.getTenSV(), x.getTuoiSV(), x.getLopSV() };
					dm.addRow(row);
				}
			} else {
				for (SinhVien x : arrSV) {
					if (chonLop.equals(x.getLopSV())) {
						String[] row = { x.getMaSV(), x.getTenSV(), x.getTuoiSV(), x.getLopSV() };
						dm.addRow(row);
					}
				}
			}
			maSV.setText("");
			tenSV.setText("");
			tuoiSV.setText("");
		}

	};
	
	ActionListener eventThem = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String chonLop = (String) select.getSelectedItem();
			String ma = chonLop + maSV.getText();
			String ten = tenSV.getText();
			String tuoi = tuoiSV.getText();

			
			maSV.setText("");
			tenSV.setText("");
			tuoiSV.setText("");
			docFile();
			try {
				arrSV.add(new SinhVien(ma, ten, tuoi, chonLop));
				luuFile();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Bạn đã nhập sai vui lòng nhập lại!", "Title",
						JOptionPane.WARNING_MESSAGE);
			}
			dm.addRow(new String[] { ma, ten, tuoi });
			dm.setRowCount(0);
			for (SinhVien x : arrSV) {
				String[] row = { x.getMaSV(), x.getTenSV(), x.getTuoiSV(), x.getLopSV() };
				dm.addRow(row);
			}
		}
	};

	ActionListener eventSua = new ActionListener() {

		public void actionPerformed(ActionEvent arg0) {
			docFile();
			for (SinhVien x : arrSV) {
				if (maSV.getText().equals(x.getMaSV())) {
					x.setTenSV(tenSV.getText());
					x.setTuoiSV(tuoiSV.getText());
					luuFile();
					break;
				}
			}
			dm.setRowCount(0);
			for (SinhVien x : arrSV) {
				String[] row = { x.getMaSV(), x.getTenSV(), x.getTuoiSV(), x.getLopSV() };
				dm.addRow(row);
			}

		}

	};
	ActionListener eventXoa = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			docFile();
			for (SinhVien x : arrSV) {
				if (maSV.getText().equals(x.getMaSV())) {
					arrSV.remove(x);
					luuFile();
					break;
				}
			}
			dm.setRowCount(0);
			for (int i = 0; i < arrSV.size(); i++) {
				String row[] = { arrSV.get(i).getMaSV(), arrSV.get(i).getTenSV(), arrSV.get(i).getTuoiSV(), arrSV.get(i).getLopSV()  };
				dm.addRow(row);
			}

		}


	};
	ActionListener eventThoat = new ActionListener() {

		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);

		}

	};
	ActionListener eventNhap = new ActionListener() {

		public void actionPerformed(ActionEvent arg0) {

		}

	};
	
	public void docFile() {
		Path path = Paths.get("dulieu.txt");
		if (Files.exists(path)) {
			arrSV = TextFileFactory.docFile("dulieu.txt");
		} else {
			arrSV = new ArrayList<SinhVien>();
		}
	}

	public void luuFile() {
		boolean checked = TextFileFactory.luuFile(arrSV, "dulieu.txt");
		if (checked == true) {
			JOptionPane.showMessageDialog(null, "Đã lưu thông tin của sinh viên", "Title", JOptionPane.WARNING_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Lưu thất bại", "Title", JOptionPane.WARNING_MESSAGE);
		}

	}
	public void showWindow() {
		this.setSize(500, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
