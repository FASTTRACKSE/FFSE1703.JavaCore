package ffse1702010.edu.vn.ui;

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
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

import ffse1702010.edu.vn.io.SerializeFileFactory;
import ffse1702010.edu.vn.model.SinhVien;

public class MyBorderLayout extends JFrame {
	private Container con;

	// private JLabel title;
	private JLabel chonLop;
	private JLabel maSinhVien;
	private JLabel tenSinhVien;
	private JLabel tuoi;
	private JLabel maDS;
	private JLabel tenDS;
	private JLabel tuoiDS;

	private JTextField nhapMaSinhVien = new JTextField(20);
	private JTextField nhapTenSinhVien = new JTextField(20);
	private JTextField nhapTuoiSinhVien = new JTextField(20);

	private JComboBox cbo = new JComboBox();
	private ArrayList<SinhVien> arr = new ArrayList<SinhVien>();
	private DefaultTableModel dm;
	private JTable tbl1;
	int stt = 0;
	JScrollPane sc;

	private JPanel pnBox;
	private JPanel pnLop;
	private JPanel pnTuoi;
	private JPanel pnTen;
	private JPanel pnMaSV;
	private JPanel pntitle;
	private JPanel pnButton;
	private JPanel pnDanhSach;
	private String lopAll = "All";

	private Button btn1 = new Button("Thêm");
	private Button btn2 = new Button("Sửa");
	private Button btn3 = new Button("Xóa");
	private Button btn4 = new Button("Thoát");
	private Button btn5 = new Button("Nhập");

	public MyBorderLayout(String tieude) {
		addControl();
		addEvents();
		
		this.setTitle(tieude);

	}

	public void addControl() {
		con = getContentPane();
		pnBox = new JPanel();
		pnBox.setBackground(Color.PINK);
		pnBox.setLayout(new BoxLayout(pnBox, BoxLayout.Y_AXIS));

		pntitle = new JPanel();
		pntitle.setBackground(Color.PINK);
		JLabel title = new JLabel("CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN");
		title.setOpaque(true);
		Font font = new Font("Arial", Font.BOLD, 24);
		title.setFont(font);
		title.setForeground(Color.BLACK);
		title.setBackground(Color.WHITE);
		pntitle.add(title);
		pnBox.add(pntitle, BorderLayout.NORTH);

		pnLop = new JPanel();
		pnLop.setLayout(new FlowLayout());
		chonLop = new JLabel("CHỌN LỚP:");
		cbo.addItem("FFSE1701");
		cbo.addItem("FFSE1702");
		cbo.addItem("FFSE1703");
		cbo.addItem("FFSE1704");
		add(cbo);
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
		tuoi = new JLabel("TUỔI SINH VIÊN");
		pnTuoi.add(tuoi);
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

		Path path = Paths.get("dulieu2.txt");
		if (Files.exists(path)) {
			arr = SerializeFileFactory.docFile("dulieu2.txt");
		} else {
			arr = new ArrayList<SinhVien>();
		}
		for (SinhVien x : arr) {
			dm.addRow(new String[] { x.getMaSV(), x.getTenSV(), x.getTuoiSV(), x.getLopSV() });
			tbl1 = new JTable(dm);
		}

		sc = new JScrollPane(tbl1);
		pnDanhSach.add(sc);
		pnBox.add(pnDanhSach);

		con.add(pnBox);

	}

	public void addEvents() {
		cbo.addActionListener(lop);
		btn1.addActionListener(themSinhVien);
		btn2.addActionListener(chinhSuaSinhVien);
		btn3.addActionListener(xoaSinhVien);
		btn4.addActionListener(thoat);
		btn5.addActionListener(nhap);
		tbl1.addMouseListener(eventTable);

	}

	ActionListener lop = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			String chonLop = (String) cbo.getSelectedItem();
			dm.setRowCount(0);
			for (SinhVien x : arr) {
				if (chonLop.equals(x.getLopSV())) {
					String[] row = { x.getMaSV(), x.getTenSV(), x.getTuoiSV(), x.getLopSV() };
					dm.addRow(row);
				}
				}
			nhapMaSinhVien.setText("");
			nhapTenSinhVien.setText("");
			nhapTuoiSinhVien.setText("");

		



		
		}
	};
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
	};
	ActionListener themSinhVien = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			String lop = (String) cbo.getSelectedItem();
			String nhapMa = lop + nhapMaSinhVien.getText();
			String nhapTen = nhapTenSinhVien.getText();
			String nhapTuoi = nhapTuoiSinhVien.getText();
			if (nhapMa.isEmpty() || nhapTen.isEmpty() || nhapTuoi.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Xin hay nhap day du thong tin!");
			} else {

				arr.add(new SinhVien(nhapMa, nhapTen, nhapTuoi, lop));
				String[] row = { nhapMa, nhapTen, nhapTuoi, lop };
				dm.addRow(row);
				luuFile();
			
				nhapMaSinhVien.setText("");
				nhapTenSinhVien.setText("");
				nhapTuoiSinhVien.setText("");
			}
		}
	};

	ActionListener chinhSuaSinhVien = new ActionListener() {
		

		@Override
		public void actionPerformed(ActionEvent e) {

			for (SinhVien x : arr) {				
				if (nhapMaSinhVien.getText().equals(x.getMaSV())) {
					x.setTenSV(nhapTenSinhVien.getText());
					x.setTuoiSV(nhapTuoiSinhVien.getText());          
					luuFile();
					break;
				}else {
					JOptionPane.showMessageDialog(null, "MÃ SINH VIÊN KHÔNG ĐƯỢC SỮA");
					break;


					
					
				}
			}
			dm.setRowCount(0);
			for (int i = 0; i < arr.size(); i++) {
				String row[] = { arr.get(i).getMaSV(), arr.get(i).getTenSV(), arr.get(i).getTuoiSV(),
						arr.get(i).getLopSV() };

				dm.addRow(row);

			}

		}

	};
	ActionListener xoaSinhVien = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			for (SinhVien x : arr) {
				if (nhapMaSinhVien.getText().equals(x.getMaSV())) {
					arr.remove(x);
					luuFile();
					break;
				}
			}
			dm.setRowCount(0);
			for (int i = 0; i < arr.size(); i++) {
				String row[] = { arr.get(i).getMaSV(), arr.get(i).getTenSV(), arr.get(i).getTuoiSV(),
						arr.get(i).getLopSV() };
				dm.addRow(row);

			}
		}

	};

	public void docFile() {
		Path path = Paths.get("dulieu2.txt");
		if (Files.exists(path)) {
			arr = SerializeFileFactory.docFile("dulieu2.txt");
		} else {
			arr = new ArrayList<SinhVien>();
		}
	}

	public void luuFile() {
		boolean checked = SerializeFileFactory.luuFile(arr, "dulieu2.txt");
		if (checked == true) {
			JOptionPane.showMessageDialog(null, "Đã luu thông tin của sinh viên", "Title",
					JOptionPane.WARNING_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Lưu thất bại", "Title", JOptionPane.WARNING_MESSAGE);
		}

	}

	ActionListener thoat = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.exit(0);

		}

	};
	ActionListener nhap = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	};

	public void showWindow() {
		this.setSize(580, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

}
