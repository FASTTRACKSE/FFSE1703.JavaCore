package quanlysinhvien.ui;

import java.awt.*;
import quanlysinhvien.model.*;
import quanlysinhvien.io.*;
import java.awt.event.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class QuanLySinhVienUi extends JFrame {
	JTable table = new JTable();
	JScrollPane scrPane = new JScrollPane();
	DefaultTableModel dm;
	JButton them, sua, xoa, thoat, nhap;
	JTextField maSv, tenSv, tuoiSv;
	JComboBox<String> combo1;
	ArrayList<SinhVien> arrSv = new ArrayList<SinhVien>();

	public QuanLySinhVienUi(String tittle) {
		super(tittle);
		addControls();
		addEvent();
	}

	public void actCreate() {
		arrSv = QuanLySinhVienIO.readFile("FileName.txt");
		String Lop = combo1.getSelectedItem().toString();
		String ten = tenSv.getText();
		int masv = (arrSv.size()+1);
		String ma = String.valueOf(masv);
		String tuoi = tuoiSv.getText();
		dm.addRow(new String[] { Lop, ma, ten, tuoi });
		Path path = Paths.get("FileName.txt");
		if (Files.exists(path)) {
			arrSv = QuanLySinhVienIO.readFile("FileName.txt");
		} else {
			arrSv = new ArrayList<SinhVien>();
		}
		arrSv.add(new SinhVien(Lop, ma, ten, tuoi));
		boolean kt = QuanLySinhVienIO.saveFile(arrSv, "FileName.txt");
		if (kt == true) {
			System.out.println("Luu file thanh cong!");
		} else {
			System.out.println("Luu file that bai!");
		}
		tenSv.setText("");
		maSv.setText("");
		tuoiSv.setText("");
	}

	public void actUpdate() {
		arrSv = QuanLySinhVienIO.readFile("FileName.txt");
		for(SinhVien x : arrSv) {
			if(maSv.getText().equals(x.getMaSv())) {
				x.setLopSv(combo1.getSelectedItem().toString());
				x.setTenSv(tenSv.getText());
				x.setTuoiSv(tuoiSv.getText());
				QuanLySinhVienIO.saveFile(arrSv, "FileName.txt");
			}
		}
		dm.setRowCount(0);
		for(SinhVien x :arrSv) {
			String[] row = {x.getLopSv(),x.getMaSv(),x.getTenSv(),x.getTuoiSv()};
			dm.addRow(row);
		}
		tenSv.setText("");
		maSv.setText("");
		tuoiSv.setText("");
	}

	public void actDelete() {
		arrSv = QuanLySinhVienIO.readFile("FileName.txt");
		for (SinhVien x : arrSv) {
			if (maSv.getText().equals(x.getMaSv())) {
				arrSv.remove(x);
				QuanLySinhVienIO.saveFile(arrSv, "FileName.txt");
				break;
			}
		}
		dm.setRowCount(0);
		for (SinhVien x : arrSv) {
			String[] row = { x.getLopSv(), x.getMaSv(), x.getTenSv(), x.getTuoiSv() };
			dm.addRow(row);
		}
		tenSv.setText("");
		maSv.setText("");
		tuoiSv.setText("");
	}

	public void actSave() {

	}

	public void actEndProgram() {
		System.exit(0);
	}

	public void myWindowUi() {
		this.setSize(700, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void addControls() {
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		JLabel label1 = new JLabel();
		label1.setText("Chuong trinh quan li sinh vien");
		JPanel tittle = new JPanel();
		tittle.setLayout(new FlowLayout());
		tittle.add(label1);

		JLabel label2 = new JLabel();
		label2.setText("Chon lop: ");
		JPanel pnFlow1 = new JPanel();
		pnFlow1.setLayout(new FlowLayout());
		pnFlow1.add(label2);

		combo1 = new JComboBox<String>();
		combo1.addItem("FFSE1701");
		combo1.addItem("FFSE1702");
		combo1.addItem("FFSE1703");
		combo1.addItem("FFSE1704");
		pnFlow1.add(combo1);

		JLabel label3 = new JLabel();
		label3.setText("Ma sinh vien: ");
		maSv = new JTextField(30);
		JPanel divMaSv = new JPanel();
		divMaSv.add(label3);
		divMaSv.add(maSv);

		JLabel label4 = new JLabel();
		label4.setText("Ten sinh vien: ");
		tenSv = new JTextField(30);
		JPanel divTenSv = new JPanel();
		divTenSv.add(label4);
		divTenSv.add(tenSv);

		JLabel label5 = new JLabel();
		label5.setText("Tuoi: ");
		tuoiSv = new JTextField(30);
		JPanel divTuoiSv = new JPanel();
		divTuoiSv.add(label5);
		divTuoiSv.add(tuoiSv);

		JPanel divAction = new JPanel();
		divAction.setLayout(new FlowLayout());
		them = new JButton("Them");
		sua = new JButton("Sua");
		xoa = new JButton("Xoa");
		thoat = new JButton("Thoat");
		nhap = new JButton("Nhap");

		dm = new DefaultTableModel();
		dm.addColumn("Lop");
		dm.addColumn("Ma");
		dm.addColumn("Ten");
		dm.addColumn("Tuoi");
		table = new JTable(dm);
		ArrayList<SinhVien> dsSv = QuanLySinhVienIO.readFile("FileName.txt");
		for (int i = 0; i < dsSv.size(); i++) {
			dm.addRow(new String[] { dsSv.get(i).getLopSv(), dsSv.get(i).getMaSv(), dsSv.get(i).getTenSv(),
					dsSv.get(i).getTuoiSv() });
		}
		JScrollPane scrPane = new JScrollPane(table);

		divAction.add(them);
		divAction.add(sua);
		divAction.add(xoa);
		divAction.add(nhap);
		divAction.add(thoat);
		pnMain.add(tittle);
		pnMain.add(pnFlow1);
		pnMain.add(divMaSv);
		pnMain.add(divTenSv);
		pnMain.add(divTuoiSv);
		pnMain.add(divAction);
		pnMain.add(scrPane);
		con.add(pnMain);
		label1.setFont(new Font("Courier New", Font.BOLD, 16));
		label2.setFont(new Font("Courier New", Font.BOLD, 16));
		label3.setFont(new Font("Courier New", Font.BOLD, 16));
		label4.setFont(new Font("Courier New", Font.BOLD, 16));
		label5.setFont(new Font("Courier New", Font.BOLD, 16));
		table.setFont(new Font("Courier New", Font.BOLD, 15));
	}

	public void addEvent() {
		table.addMouseListener(eventTable);
		them.addActionListener(eventCreate);
		sua.addActionListener(eventUpdate);
		xoa.addActionListener(eventDelete);
		thoat.addActionListener(eventEndProgram);
		nhap.addActionListener(eventSave);
	}

	MouseListener eventTable = new MouseListener() {
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			for (int i = table.getSelectedRow(); i <= table.getSelectedRow(); i++) {
				for (int y = 0; y < table.getColumnCount(); y++) {
					String value = (String) table.getValueAt(i, y);
					if (y == 1) {
						maSv.setText(value);
					}
					if (y == 2) {
						tenSv.setText(value);
					}
					if (y == 3) {
						tuoiSv.setText(value);
					}
					if (y == (table.getColumnCount() - 1)) {
						combo1.setSelectedItem(value);
					}
				}
			}
		}
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}
	};
	ActionListener eventCreate = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			actCreate();
		}
	};
	ActionListener eventUpdate = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			actUpdate();
		}
	};
	ActionListener eventDelete = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			actDelete();
		}
	};
	ActionListener eventEndProgram = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			actEndProgram();
		}
	};
	ActionListener eventSave = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			actSave();
		}
	};
}
