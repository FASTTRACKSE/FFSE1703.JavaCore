package assignment10.java.ui;

import java.awt.BorderLayout;

import assignment10.java.io.SerializeFileFactory;
import assignment10.java.modle.ModleSinhVien;

import java.awt.Color;
import java.awt.Container;
import java.awt.Desktop.Action;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class SinhVien extends JFrame {

	private JTextField nameSV, maSV, ageSV;
	private JButton creat, edit, delete, exit, submit;
	private JComboBox classSV;
	public static ArrayList<ModleSinhVien> arrSv = new ArrayList<ModleSinhVien>();
	DefaultTableModel modle;
	JTable table;
	int stt = 0;
	String lop = "All";

	public SinhVien(String tieude) {
		super(tieude);
		addControls();
		addEvents();
		//docFile();

	}

	public void addControls() {
		Container con = getContentPane();
		JPanel pnBox = new JPanel();
		pnBox.setLayout(new BoxLayout(pnBox, BoxLayout.Y_AXIS));
		// Jpanel box 1
		JPanel pnBox1 = new JPanel();
		JLabel name1 = new JLabel("Chương trình Quản lí sinh viên");
		Font font1 = new Font("Arial", Font.BOLD | Font.ITALIC, 25);
		name1.setFont(font1);
		pnBox1.add(name1);

		// Jpanel box 2
		JPanel pnBox2 = new JPanel();
		classSV = new JComboBox();
		classSV.addItem("All");
		classSV.addItem("FFSE1701");
		classSV.addItem("FFSE1702");
		classSV.addItem("FFSE1703");
		classSV.addItem("FFSE1704");
		pnBox2.add(classSV);
		// jpanel box 3
		JPanel pnBox3 = new JPanel();
		JLabel name2 = new JLabel("Mã Sinh Viên: ");
		maSV = new JTextField(20);
		pnBox3.add(name2);
		pnBox3.add(maSV);
		// jpanel box 4
		JPanel pnBox4 = new JPanel();
		JLabel name3 = new JLabel("Tên Sinh Viên: ");
		name3.setPreferredSize(name2.getPreferredSize());
		nameSV = new JTextField(20);
		pnBox4.add(name3);
		pnBox4.add(nameSV);
		// jpanel box 5
		JPanel pnBox5 = new JPanel();
		JLabel name4 = new JLabel("Tuổi: ");
		name4.setPreferredSize(name2.getPreferredSize());
		ageSV = new JTextField(20);
		pnBox5.add(name4);
		pnBox5.add(ageSV);
		// jpanel box 6
		JPanel pnBox6 = new JPanel();
		creat = new JButton("Creat");
		edit = new JButton("Edit");
		delete = new JButton("Delete");
		exit = new JButton("Exit");
		submit = new JButton("submit");
		pnBox6.add(creat);
		pnBox6.add(edit);
		pnBox6.add(delete);
		pnBox6.add(exit);
		pnBox6.add(submit);
		// jpanel box 7 tạo table
		JPanel pnBox7 = new JPanel();
		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Danh sách");
		pnBox7.setBorder(borderTitle);
		modle = new DefaultTableModel();
		table = new JTable(modle);
		pnBox7.setLayout(new BorderLayout());

		modle.addColumn("Mã số");
		modle.addColumn("Tên Sinh Viên");
		modle.addColumn("Tuổi");
		modle.addColumn("Lớp");

		JScrollPane scroll = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pnBox7.add(scroll, BorderLayout.CENTER);

		// thêm jPanel
		pnBox.add(pnBox1);
		pnBox.add(pnBox2);
		pnBox.add(pnBox3);
		pnBox.add(pnBox4);
		pnBox.add(pnBox5);
		pnBox.add(pnBox6);
		pnBox.add(pnBox7);
		con.add(pnBox);

	}

	public void addEvents() {
		classSV.addActionListener(chonLop);
		creat.addActionListener(themSinhVien);
		edit.addActionListener(chinhSuaSinhVien);
		table.addMouseListener(chonHang);
		delete.addActionListener(xoaSinhVien);
		exit.addActionListener(eventExit);
	}

//	public void docFile() {
//		File file = new File("D:/FFSE1703.JavaCore/Assignments/TuanNM/assignment10/dulieuSV.txt");
//		if (file.exists()) {
//			ArrayList<ModleSinhVien> arrSvFile = SerializeFileFactory.docFile("dulieuSV.txt");
//			arrSv = arrSvFile;
//		}
//
//		for (ModleSinhVien sv : arrSv) {
//			String[] row = { sv.getMaSV(), sv.getNameSV(), sv.getAge(), sv.getLopSV() };
//			modle.addRow(row);
//		}
//	}

	ActionListener chonLop = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			File file = new File("D:/FFSE1703.JavaCore/Assignments/TuanNM/assignment10/dulieuSV.txt");
			if (file.exists()) {
				ArrayList<ModleSinhVien> arrSvFile = SerializeFileFactory.docFile("dulieuSV.txt");
				arrSv = arrSvFile;
			}
			maSV.setText("");
			nameSV.setText("");
			ageSV.setText("");
			lop = classSV.getSelectedItem().toString();
			modle.setRowCount(0);
			if (lop == "All") {
				for (ModleSinhVien sv : arrSv) {
					String[] row = { sv.getMaSV(), sv.getNameSV(), sv.getAge(), sv.getLopSV() };
					modle.addRow(row);
				}
			} else {
				for (ModleSinhVien sv : arrSv) {
					if (lop.equals(sv.getLopSV())) {
						String[] row = { sv.getMaSV(), sv.getNameSV(), sv.getAge(), sv.getLopSV() };
						modle.addRow(row);
					}
				}
			}
			
		}
	};

	ActionListener themSinhVien = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			try {
				int ktTonTai = -1;
				String lop = classSV.getSelectedItem().toString();
				String tenSV = nameSV.getText();
				String maSinhVien = maSV.getText();
				String tuoi = ageSV.getText();
				for (int i = 0; i < arrSv.size(); i++) {
					if (maSinhVien.equals(arrSv.get(i).getMaSV())) {
						ktTonTai = i;
					}
				}
				try {
					if (tenSV.isEmpty() || maSinhVien.isEmpty() || tuoi.isEmpty()) {
						throw new Exception();
						// JOptionPane.showMessageDialog(null, "Bạn phải nhập số !!");
					} else if (ktTonTai >= 0) {
						String msg = "Sinh viên " + arrSv.get(ktTonTai).getMaSV() + " đã tồn tạ !!";
						JOptionPane.showMessageDialog(null, msg, "Lỗi nhập", JOptionPane.INFORMATION_MESSAGE);
					} else if (lop == "All") {
						//throw new NullPointerException();
						String msg = "Vui lòng chọn lớp!!";
						JOptionPane.showMessageDialog(null, msg, "Lỗi nhập", JOptionPane.INFORMATION_MESSAGE);
					} else {

						arrSv.add(new ModleSinhVien(maSinhVien, tenSV, tuoi, lop));

						for (int i = (arrSv.size() - 1); i < arrSv.size(); i++) {

							String[] row = { arrSv.get(i).getMaSV(), arrSv.get(i).getNameSV(), arrSv.get(i).getAge(),
									arrSv.get(i).getLopSV() };
							modle.addRow(row);
						}
						boolean kt = SerializeFileFactory.luuFile(arrSv, "dulieuSV.txt");
						if (kt == true) {
							System.out.println("Đã lưu file thành công");
						} else {
							System.out.println("Lưu file thất bại");
						}
						maSV.setText("");
						nameSV.setText("");
						ageSV.setText("");
					}

				} catch (Exception ex) {
					String msg = "Vui lòng nhập đầy đủ thông tin";
					JOptionPane.showMessageDialog(null, msg, "Lỗi Nhập Thiếu", JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (Exception ex) {
			}

		}

	};

	ActionListener chinhSuaSinhVien = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String maSv = maSV.getText();
			String tenSv = nameSV.getText();
			String tuoiSv = ageSV.getText();
			String lop = (String) classSV.getSelectedItem();

			try {
				Integer.parseInt(tuoiSv);
				try {
					
					int so = -1;
					for (int i = 0; i < arrSv.size(); i++) {
						if (lop.equals(arrSv.get(i).getLopSV())) {
							so = i;
						}
					}
					if (maSv.isEmpty() && tenSv.isEmpty() && tuoiSv.isEmpty()) {
						throw new Exception();
					} else if (maSv.isEmpty() || tenSv.isEmpty() || tuoiSv.isEmpty()) {
						String msg = "Không được để trống các dòng " + maSv;
						JOptionPane.showMessageDialog(null, msg, "Lỗi Nhập Thông tin", JOptionPane.INFORMATION_MESSAGE);

					} else {
						arrSv.get(stt).setMaSV(maSv);
						arrSv.get(stt).setNameSv(tenSv);
						arrSv.get(stt).setAge(tuoiSv);
						boolean checked = SerializeFileFactory.luuFile(arrSv, "dulieusinhvien.txt");
						if (checked == true) {
							String msg = "Đã Sửa Thành công Sinh viên " + tenSv;
							JOptionPane.showMessageDialog(null, msg, "Sửa Thành Công", JOptionPane.INFORMATION_MESSAGE);
						} else {
							System.out.println("Lưu thất bại");
						}
						int col = table.getSelectedRow();
						maSV.setText("");
						nameSV.setText("");
						ageSV.setText("");
						maSV.requestFocus();
						lop = (String) classSV.getSelectedItem();
						;
						modle.setRowCount(0);
						if (lop == "All") {
							for (ModleSinhVien sv : arrSv) {
								String[] row = { sv.getMaSV(), sv.getNameSV(), sv.getAge(), sv.getLopSV() };
								modle.addRow(row);
							}
						} else {
							for (ModleSinhVien sv : arrSv) {
								if (lop.equals(sv.getLopSV())) {
									String[] row = { sv.getMaSV(), sv.getNameSV(), sv.getAge(), sv.getLopSV() };
									modle.addRow(row);
								}
							}
						}
					}
				} catch (Exception e2) {
					String msg = "Chưa chọn dòng cần thay đổi ";
					JOptionPane.showMessageDialog(null, msg, "Sửa Thành Công", JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (Exception e2) {
			}
		}
	};

	ActionListener eventExit = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	};
	MouseAdapter chonHang = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int col = table.getSelectedRow();
			String[] row = new String[3];
			row[0] = (String) table.getValueAt(col, 0);
			row[1] = (String) table.getValueAt(col, 1);
			row[2] = (String) table.getValueAt(col, 2);
			maSV.setText(row[0]);
			nameSV.setText(row[1]);
			ageSV.setText(row[2]);
			for (int i = 0; i < arrSv.size(); i++) {
				if (row[0].equals(arrSv.get(i).getMaSV())) {
					stt = i;
				}
			}
		}
	};
	ActionListener xoaSinhVien = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String maSv = maSV.getText();
			String tenSv = nameSV.getText();
			String tuoiSv = ageSV.getText();
			arrSv.remove(stt);
			boolean checked = SerializeFileFactory.luuFile(arrSv, "dulieuSV.txt");
			if (checked == true) {
				String msg = "Đã Xóa Thành công Sinh viên " + tenSv;
				JOptionPane.showMessageDialog(null, msg, "Xóa Thành Công", JOptionPane.INFORMATION_MESSAGE);
			} else {
				System.out.println("Xóa thất bại");
			}
			
			maSV.setText("");
			nameSV.setText("");
			ageSV.setText("");
			maSV.requestFocus();
			lop = classSV.getSelectedItem().toString();
			modle.setRowCount(arrSv.size());
			
		}
	};

	public void showWindow() {
		this.setSize(600, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
