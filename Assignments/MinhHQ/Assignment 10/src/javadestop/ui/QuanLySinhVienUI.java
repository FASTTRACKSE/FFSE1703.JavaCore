package javadestop.ui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import javadestop.model.*;
import javadestop.io.TextFileFactory;

public class QuanLySinhVienUI extends JFrame {
	private JScrollPane sp;
	private DefaultTableModel dm;
	private JTable table;
	private JComboBox select;
	private JTextField tenSV = new JTextField(), maSV = new JTextField(), tuoiSV = new JTextField();
	private ArrayList<SinhVien> arrSV = new ArrayList<SinhVien>();
	private String[] lop = { "FFSE1701", "FFSE1702", "FFSE1703", "FFSE1704", "Tất Cả" };

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

		docFile();
		for (SinhVien x : arrSV) {
			dm.addRow(new String[] { x.getMaSV(), x.getTenSV(), x.getTuoi() });

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

	}

	MouseListener eventTable = new MouseListener() {

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseClicked(MouseEvent e) {
			for (int i = table.getSelectedRow(); i <= table.getSelectedRow(); i++) {
				for (int y = 0; y < table.getColumnCount(); y++) {
					String value = (String) table.getValueAt(i, y);
					if (y == 0) {
						maSV.setText(value);
					}
					if (y == 1) {
						tenSV.setText(value);
					}
					if (y == 2) {
						tuoiSV.setText(value);
					}
					if (y == (table.getColumnCount() - 1)) {
						select.setSelectedItem(value);
					}

				}
			}

		}
	};

	ActionListener eventChooseClass = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			docFile();
			

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

			dm.addRow(new String[] { ma, ten, tuoi });
			table = new JTable(dm);
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
			dm.setRowCount(0);
			for (int i = 0; i < arrSV.size(); i++) {
				String row[] = { arrSV.get(i).getMaSV(), arrSV.get(i).getTenSV(), arrSV.get(i).getTuoi() };
				dm.addRow(row);
			}
		}
	};

	ActionListener eventDel = new ActionListener() {

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
				String row[] = { arrSV.get(i).getMaSV(), arrSV.get(i).getTenSV(), arrSV.get(i).getTuoi() };
				dm.addRow(row);
			}

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
		this.setSize(500, 440);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
