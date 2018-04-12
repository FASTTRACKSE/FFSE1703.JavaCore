package ffse1703.qlsv.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import ffse1703.model.HocSinh;
import ffse1703.qlsv.oi.SerializeFileFactory;

import javax.swing.*;
import javax.swing.BoxLayout;
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
import java.util.ArrayList;

public class QuanLySinhVien extends JFrame {
	private JTextField txtMa, txtTen, txtTuoi;
	private JButton btnthem, btnsua, btnxoa, btnthoat, btnnhap;
	String[] items = { "Tất cả", "FFSE1701", "FFSE1702", "FFSE1703", "FFSE1704" };
	JComboBox<String> cbbClass = new JComboBox<>(items);
	DefaultTableModel list = new DefaultTableModel();
	public static ArrayList<HocSinh> arrSv = new ArrayList<HocSinh>();
	String chooseClass = "Tất cả";
	final JTable tbl = new JTable(list);
	JScrollPane sc = new JScrollPane(tbl);
	int stt = 0;

	public QuanLySinhVien(String title) {
		super(title);
		addControls();
		addEvents();
	}

	public void addControls() {
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		JPanel pnTitle = new JPanel();
		JLabel lblTitle = new JLabel("Chương Trình Quản Lý Sinh Viên");
		Font fontTitle = new Font("arial", Font.BOLD, 30);
		lblTitle.setFont(fontTitle);
		pnTitle.add(lblTitle);

		JPanel pnMainContent1=new JPanel();
		pnMainContent1.setLayout(new FlowLayout());
		JLabel lblContent1=new JLabel("Chọn Lớp:       ");		
		pnMainContent1.add(lblContent1);
		add(cbbClass);
		pnMainContent1.add(cbbClass);
		

		JPanel pnInput1 = new JPanel();
		JLabel lblMa = new JLabel("Nhập Mã Sinh Viên:");
		txtMa = new JTextField(20);
		pnInput1.add(lblMa);
		pnInput1.add(txtMa);

		JPanel pnInput2 = new JPanel();
		JLabel lblTen = new JLabel("Nhập Tên Sinh Viên:");
		txtTen = new JTextField(20);
		pnInput2.add(lblTen);
		pnInput2.add(txtTen);

		JPanel pnInput3 = new JPanel();
		JLabel lblTuoi = new JLabel("Nhập Tuổi Sinh Viên:");
		txtTuoi = new JTextField(20);
		pnInput3.add(lblTuoi);
		pnInput3.add(txtTuoi);

		JPanel pnTable = new JPanel();
		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Danh sách");
	    list.addColumn("Mã");
	    list.addColumn("Tên");
	    list.addColumn("Tuổi");
	    list.addColumn("Lớp");
		pnTable.setLayout(new BorderLayout());
		pnTable.setBorder(borderTitle);
		pnTable.add(sc);

		JPanel pnAction = new JPanel();
		pnAction.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 30));

		btnthem = new JButton("Thêm");
		btnsua = new JButton("Sửa");
		btnxoa = new JButton("Xóa");
		btnthoat = new JButton("Thoát");
		btnnhap = new JButton("Nhập");

		//

		pnAction.add(btnthem);
		pnAction.add(btnsua);
		pnAction.add(btnxoa);
		pnAction.add(btnthoat);
		pnAction.add(btnnhap);
		//
		pnMain.add(pnTitle);
		pnMain.add(pnMainContent1);
		pnMain.add(pnInput1);
		pnMain.add(pnInput2);
		pnMain.add(pnInput3);
		pnMain.add(pnAction);
		pnMain.add(pnTable);

		con.add(pnMain);

	}

	//
	private void addEvents() {
		tbl.addMouseListener(eventChooseRow);
		btnthem.addActionListener(eventThem);
		btnnhap.addActionListener(eventNhap);
		cbbClass.addActionListener(eventChooseClass);
		btnsua.addActionListener(eventSua);
		btnthoat.addActionListener(eventThoat);
		btnxoa.addActionListener(eventXoa);
	}

	ActionListener eventChooseClass = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			File file = new File("C:/javacore/FFSE1703.JavaCore/Assignments/TUANTD/Assignment10/dulieusinhvien.txt");
			if (file.exists()) {
				ArrayList<HocSinh> arrSvFile = SerializeFileFactory.readFile("dulieusinhvien.txt");
				arrSv = arrSvFile;
			}
			chooseClass = (String) cbbClass.getSelectedItem();
			list.setRowCount(0);
			if (chooseClass == "Tất cả") {
				for (HocSinh sv : arrSv) {
					String[] row = { sv.getMaSv(), sv.getTenSv(), sv.getTuoiSv(), sv.getLopSv() };
					list.addRow(row);
				}
			} else {
				for (HocSinh sv : arrSv) {
					if (chooseClass.equals(sv.getLopSv())) {
						String[] row = { sv.getMaSv(), sv.getTenSv(), sv.getTuoiSv(), sv.getLopSv() };
						list.addRow(row);
					}
				}
			}
			txtMa.setText("");
			txtTen.setText("");
			txtTuoi.setText("");
		}
	};
	// Thêm sinh viên
	ActionListener eventThem = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			txtMa.setText("");
			txtTen.setText("");
			txtTuoi.setText("");
			txtMa.requestFocus();
		}
	};
	MouseAdapter eventChooseRow = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int col = tbl.getSelectedRow();
			String[] row = new String[3];
			row[0] = (String) tbl.getValueAt(col, 0);
			row[1] = (String) tbl.getValueAt(col, 1);
			row[2] = (String) tbl.getValueAt(col, 2);
			txtMa.setText(row[0]);
			txtTen.setText(row[1]);
			txtTuoi.setText(row[2]);
			for (int i = 0; i < arrSv.size(); i++) {
				if (row[0].equals(arrSv.get(i).getMaSv())) {
					stt = i;
				}
			}
		}
	};
	// Sửa thông tin sinh viên
	ActionListener eventSua = new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			String maSv = txtMa.getText();
			String tenSv = txtTen.getText();
			String tuoiSv = txtTuoi.getText();
			String lopSv = (String) cbbClass.getSelectedItem();

			try {
				Integer.parseInt(tuoiSv);
				try {
					int tuoi = Integer.parseInt(tuoiSv);
					int so = -1;
					for (int i = 0; i < arrSv.size(); i++) {
						if (lopSv.equals(arrSv.get(i).getLopSv())) {
							so = i;
						}
					}
					if (maSv.isEmpty() && tenSv.isEmpty() && tuoiSv.isEmpty()) {
						throw new Exception();
					} else if (maSv.isEmpty() || tenSv.isEmpty() || tuoiSv.isEmpty()) {

						JOptionPane.showMessageDialog(null, JOptionPane.INFORMATION_MESSAGE);

					} else if (tuoi >= 18) {

						JOptionPane.showMessageDialog(null, JOptionPane.INFORMATION_MESSAGE);
					} else {
						arrSv.get(stt).setMaSv(maSv);
						arrSv.get(stt).setTenSv(tenSv);
						arrSv.get(stt).setTuoiSv(tuoiSv);
						boolean checked = SerializeFileFactory.saveFile(arrSv, "dulieusinhvien.txt");
						if (checked == true) {

							JOptionPane.showMessageDialog(null, JOptionPane.INFORMATION_MESSAGE);
						} else {
							System.out.println("Lưu thất bại");
						}
						int col = tbl.getSelectedRow();
						txtMa.setText("");
						txtTen.setText("");
						txtTuoi.setText("");
						txtMa.requestFocus();
						chooseClass = (String) cbbClass.getSelectedItem();
						;
						list.setRowCount(0);
						if (chooseClass == "Tất cả") {
							for (HocSinh sv : arrSv) {
								String[] row = { sv.getMaSv(), sv.getTenSv(), sv.getTuoiSv(), sv.getLopSv() };
								list.addRow(row);
							}
						} else {
							for (HocSinh sv : arrSv) {
								if (chooseClass.equals(sv.getLopSv())) {
									String[] row = { sv.getMaSv(), sv.getTenSv(), sv.getTuoiSv(), sv.getLopSv() };
									list.addRow(row);
								}
							}
						}
					}
				} catch (Exception e2) {

					JOptionPane.showMessageDialog(null, JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (Exception e2) {

				JOptionPane.showMessageDialog(null, JOptionPane.INFORMATION_MESSAGE);
			}

		}
	};
	// xóa sinh viên
	ActionListener eventXoa = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String maSv = txtMa.getText();
			String tenSv = txtTen.getText();
			String tuoiSv = txtTuoi.getText();
			arrSv.remove(stt);
			boolean checked = SerializeFileFactory.saveFile(arrSv, "dulieusinhvien.txt");
			if (checked == true) {

				JOptionPane.showMessageDialog(null, JOptionPane.INFORMATION_MESSAGE);
			} else {
				System.out.println("Xóa thất bại");
			}
			int col = tbl.getSelectedRow();
			txtMa.setText("");
			txtTen.setText("");
			txtTuoi.setText("");
			txtMa.requestFocus();
			chooseClass = (String) cbbClass.getSelectedItem();
			;
			list.setRowCount(0);
			if (chooseClass == "Tất cả") {
				for (HocSinh sv : arrSv) {
					String[] row = { sv.getMaSv(), sv.getTenSv(), sv.getTuoiSv(), sv.getLopSv() };
					list.addRow(row);
				}
			} else {
				for (HocSinh sv : arrSv) {
					if (chooseClass.equals(sv.getLopSv())) {
						String[] row = { sv.getMaSv(), sv.getTenSv(), sv.getTuoiSv(), sv.getLopSv() };
						list.addRow(row);
					}
				}
			}
		}
	};
	//  nhập dử liệu
	ActionListener eventNhap = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			try {
				String maSv = txtMa.getText();
				String tenSv = txtTen.getText();
				String tuoiSv = txtTuoi.getText();
				String lopSv = (String) cbbClass.getSelectedItem();
				int so = -1;
				for (int i = 0; i < arrSv.size(); i++) {
					if (maSv.equals(arrSv.get(i).getMaSv())) {
						so = i;
					}
				}
				try {
					if (maSv.isEmpty() || tenSv.isEmpty() || tuoiSv.isEmpty()) {
						throw new Exception();
					} else if (lopSv == "Tất cả") {
						throw new NullPointerException();
					} else {
						String[] row = { maSv, tenSv, tuoiSv, lopSv };
						list.addRow(row);
						arrSv.add(new HocSinh(maSv, tenSv, tuoiSv, lopSv));
						boolean checked = SerializeFileFactory.saveFile(arrSv, "dulieusinhvien.txt");
						if (checked == true) {
							JOptionPane.showMessageDialog(null, JOptionPane.INFORMATION_MESSAGE);
						} else {
							System.out.println("Lưu thất bại");
						}
						txtMa.setText("");
						txtTen.setText("");
						txtTuoi.setText("");				}
				} catch (NullPointerException e) {
					String msg = "Chưa chọn Lớp\n Vui Lòng Nhập Lại " + tenSv;
					JOptionPane.showMessageDialog(null, msg, "Lỗi Nhập Thiếu", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e) {
					String msg = "Chưa nhập đủ các dòng\n Vui Lòng Nhập Lại " + tenSv;
					JOptionPane.showMessageDialog(null, msg, "Lỗi Nhập Thiếu", JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (Exception e) {
		}
		}
		
	};
	// thoát chương trình
	ActionListener eventThoat = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	};

	//
	public void showWindow() {
		this.setSize(600, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
