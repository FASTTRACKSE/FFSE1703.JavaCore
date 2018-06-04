package fasttrackse.edu.vn.quanlisinhvien.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import fasttrackse.edu.vn.quanlisinhvien.*;
import fasttrackse.edu.vn.quanlisinhvien.ui.*;

import javax.swing.JButton;
import javax.swing.JComboBox;

public class MyQuanLySinhVienUI extends JFrame {

	private JTextField txtMaSV = new JTextField(15);
	private JTextField txtTenSV = new JTextField(15);
	private JTextField txtTuoi = new JTextField(15);
	private String[] Item = { "FFSE1701", "FFSE1702", "FFSE1703", "FFSE1704", "All" };
	private ArrayList<SinhVien> arrSV = new ArrayList<SinhVien>();
	DefaultTableModel dm;
	private JComboBox classSV;
	JTable tbl;
	JComboBox cbo;
	DefaultTableModel modle;
	int stt = 0;
	String lop = "All";
	private JButton btnThem = new JButton("Thêm");
	private JButton btnSua = new JButton("Sửa");
	private JButton btnXoa = new JButton("Xoá");
	private JButton btnThoat = new JButton("Thoát");
	private JButton btnNhap = new JButton("Nhập");
	protected JComboBox select;

	public MyQuanLySinhVienUI(String tieude) {
		super(tieude);
		addConTrols();
		addEvent();
	}

	public void addConTrols() {
		Container con = getContentPane();
		JPanel pnBorderLayout = new JPanel();

		pnBorderLayout.setLayout(new BoxLayout(pnBorderLayout, BoxLayout.Y_AXIS));
		JLabel lbl = new JLabel("Chương Trình Quản Lý Sinh Viên");
		lbl.setForeground(Color.BLACK);
		Font font = new Font("Arial", Font.BOLD, 20);
		lbl.setFont(font);
		JPanel pnTitle = new JPanel();
		pnTitle.add(lbl);
		pnBorderLayout.add(pnTitle);

		JPanel pnContent6 = new JPanel();
		cbo = new JComboBox(Item);
		JLabel lblContent6 = new JLabel("Chọn Lớp : ");

		pnContent6.add(lblContent6);
		pnContent6.add(cbo);
		pnBorderLayout.add(pnContent6);

		JPanel pnContent1 = new JPanel();
		pnContent1.setLayout(new FlowLayout());
		JLabel lblContent1 = new JLabel("Mã Sinh Viên : ");
		txtMaSV = new JTextField(30);
		pnContent1.add(lblContent1);
		pnContent1.add(txtMaSV);
		pnBorderLayout.add(pnContent1);

		JPanel pnContent2 = new JPanel();
		pnContent2.setLayout(new FlowLayout());
		JLabel lblContent2 = new JLabel("Tên Sinh Viên :");
		txtTenSV = new JTextField(30);
		pnContent2.add(lblContent2);
		pnContent2.add(txtTenSV);
		pnBorderLayout.add(pnContent2);

		JPanel pnContent5 = new JPanel();
		pnContent5.setLayout(new FlowLayout());
		JLabel lblContent5 = new JLabel("Tuổi :                 ");
		txtTuoi = new JTextField(30);
		pnContent5.add(lblContent5);
		pnContent5.add(txtTuoi);
		pnBorderLayout.add(pnContent5);

		JPanel pnContent3 = new JPanel();
		pnContent3.setLayout(new FlowLayout());
		pnContent3.add(btnThem);
		pnContent3.add(btnSua);
		pnContent3.add(btnXoa);
		pnContent3.add(btnThoat);
		pnContent3.add(btnNhap);
		pnBorderLayout.add(pnContent3);

		JPanel pnTable = new JPanel();
		dm = new DefaultTableModel();
		tbl = new JTable(dm);
		dm.addColumn("Mã");
		dm.addColumn("Tên");
		dm.addColumn("Tuổi");
		dm.addColumn("Lớp");

		Path path = Paths.get("dulieu.txt");
		if (Files.exists(path)) {
			arrSV = TextFileFactory.docFile("dulieu.txt");
		} else {
			arrSV = new ArrayList<SinhVien>();
		}
		for (SinhVien x : arrSV) {

			dm.addRow(new String[] { x.getSVma(), x.getSVten(), x.getSVtuoi() });
			tbl = new JTable(dm);
		}

		JScrollPane sc = new JScrollPane(tbl);
		JScrollPane VT = new JScrollPane(sc, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		VT.setPreferredSize(new Dimension(470, 100));
		pnTable.add(VT, BorderLayout.CENTER);
		pnBorderLayout.add(pnTable);

		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Danh sách");
		pnTable.setBorder(borderTitle);

		con.add(pnBorderLayout);
	}

	public void addEvent() {
		tbl.addMouseListener(eventTable);
		cbo.addActionListener(eventChooseClass);
		btnThoat.addActionListener(Exit);
		btnThem.addActionListener(Add);
		btnXoa.addActionListener(Del);
		btnSua.addActionListener(Edit);

	}

	MouseAdapter eventTable = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int col = tbl.getSelectedRow();
			String[] row = new String[3];
			row[0] = (String) tbl.getValueAt(col, 0);
			row[1] = (String) tbl.getValueAt(col, 1);
			row[2] = (String) tbl.getValueAt(col, 2);
			txtMaSV.setText(row[0]);
			txtTenSV.setText(row[1]);
			txtTuoi.setText(row[2]);
		}
	};

	ActionListener eventChooseClass = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			docFile();
			String chonLop = (String) cbo.getSelectedItem();
			dm.setRowCount(0);
			if (chonLop == "Tất Cả") {
				for (SinhVien x : arrSV) {
					String[] row = { x.getSVma(), x.getSVten(), x.getSVtuoi(), x.getSVlop() };
					dm.addRow(row);
				}
			} else {
				for (SinhVien x : arrSV) {
					if (chonLop.equals(x.getSVlop())) {
						String[] row = { x.getSVma(), x.getSVten(), x.getSVtuoi(), x.getSVlop()};
						dm.addRow(row);
					}
				}
			}
			txtMaSV.setText("");
			txtTenSV.setText("");
			txtTuoi.setText("");
		}

	};

	ActionListener Exit = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);

		}

	};

	ActionListener Add = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String chonLop = (String) cbo.getSelectedItem();
			String ma = chonLop + txtMaSV.getText();
			String ten = txtTenSV.getText();
			String tuoi = txtTuoi.getText();

			
			txtMaSV.setText("");
			txtTenSV.setText("");
			txtTuoi.setText("");
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
				String[] row = { x.getSVma(), x.getSVten(), x.getSVtuoi(), x.getSVlop() };
				dm.addRow(row);
			}
		}
	};

	ActionListener Del = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			docFile();
			for (SinhVien x : arrSV) {
				if (txtMaSV.getText().equals(x.getSVma())) {
					arrSV.remove(x);
					luuFile();
					break;
				}
			}
			dm.setRowCount(0);
			for (SinhVien x : arrSV) {
				String[] row = {  x.getSVma(), x.getSVten(), x.getSVtuoi(), x.getSVlop() };
				dm.addRow(row);
			}
		}

	};

	ActionListener Edit = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			docFile();
			for (SinhVien x : arrSV) {
				if (txtMaSV.getText().equals(x.getSVma())) {
					x.setSVten(txtTenSV.getText());
					x.setSVtuoi(txtTuoi.getText());
					luuFile();
					break;
				}
			}
			dm.setRowCount(0);
			for (SinhVien x : arrSV) {
				String[] row = { x.getSVma(), x.getSVten(), x.getSVtuoi(), x.getSVlop() };
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