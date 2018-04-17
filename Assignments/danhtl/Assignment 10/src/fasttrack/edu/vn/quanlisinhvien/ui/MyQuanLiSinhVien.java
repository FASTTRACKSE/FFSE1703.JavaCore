package fasttrack.edu.vn.quanlisinhvien.ui;

import java.util.ArrayList;
import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JTable;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import fasttrack.edu.vn.quanlisinhvien.model.*;
import fasttrack.edu.vn.quanlisinhvien.io.*;

public class MyQuanLiSinhVien extends JFrame {

	JComboBox select;
	 

	private String[] Item = { "FFSE1701", "FFSE1702", "FFSE1703", "FFSE1704"};
	private DefaultTableModel dm;
	private JTable tbl;
	static JTextField tenSV = new JTextField(), maSV = new JTextField(), tuoiSV = new JTextField();
	static ArrayList<SinhVien> arrSV = new ArrayList<SinhVien>();
	static String[] lop = { "FFSE1701", "FFSE1702", "FFSE1703", "FFSE1704", "Tất Cả" };

	private JButton btnthem = new JButton("Thêm");
	private JButton btnsua = new JButton("Sửa");
	private JButton btnxoa = new JButton("Xóa");
	private JButton btnthoat = new JButton("Thoát");
	private JButton btnnhap = new JButton("Nhập");

	public MyQuanLiSinhVien(String tieude) {
		this.setTitle(tieude);
		addControls();
		addEvent();
	}

	public void addControls() {
		Container con = getContentPane();
		JPanel pnMain = new JPanel();

		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		JLabel lbl = new JLabel("Chương Trình Quản Lý Nhân Viên");
		Font font = new Font("Arial", Font.BOLD, 24);
		lbl.setFont(font);
		lbl.setForeground(Color.YELLOW);
		JPanel Title = new JPanel();
		Title.setBackground(Color.PINK);
		Title.setPreferredSize(new Dimension(0, 20));
		Title.add(lbl);
		pnMain.add(Title, BorderLayout.NORTH);

		JPanel pnContent1 = new JPanel();
		JLabel lblContent1 = new JLabel("Chọn Lớp :");
		select = new JComboBox(Item);
		pnContent1.add(lblContent1);
		pnContent1.add(select);
		pnMain.add(pnContent1);

		JPanel nhapma = new JPanel();
		nhapma.setLayout(new FlowLayout());
		JLabel lblmaSv = new JLabel("Mã Sinh Viên :");
		maSV = new JTextField(30);
		nhapma.add(lblmaSv);
		nhapma.add(maSV);
		pnMain.add(nhapma);

		JPanel nhapTen = new JPanel();
		nhapTen.setLayout(new FlowLayout());
		JLabel lblten = new JLabel("Tên Sinh Viên :");
		tenSV = new JTextField(30);
		nhapTen.add(lblten);
		nhapTen.add(tenSV);
		pnMain.add(nhapTen);

		JPanel tuoi = new JPanel();
		tuoi.setLayout(new FlowLayout());
		JLabel lbltuoi = new JLabel("Tuổi Sinh Viên :");
		tuoiSV = new JTextField(30);
		tuoi.add(lbltuoi);
		tuoi.add(tuoiSV);
		pnMain.add(tuoi);

		JPanel button = new JPanel();
		button.setLayout(new FlowLayout());
		button.add(btnthem);
		button.add(btnsua);
		button.add(btnxoa);
		button.add(btnthoat);
		button.add(btnnhap);
		pnMain.add(button);

		JPanel pnTable = new JPanel();
		dm = new DefaultTableModel();
		tbl = new JTable(dm);
		dm.addColumn("Mã");
		dm.addColumn("Tên");
		dm.addColumn("Tuổi");
		Path path = Paths.get("dulieu");
		if (Files.exists(path)) {
			arrSV = TextFileFacTory.docFile("dulieu");
		} else {
			arrSV = new ArrayList<SinhVien>();
		}
		for (SinhVien x : arrSV) {

			dm.addRow(new String[] { x.getMaSV(), x.getTenSV(), x.getTuoiSV() });
			tbl = new JTable(dm);
		}

		JScrollPane sc = new JScrollPane(tbl);
		pnTable.add(sc, BorderLayout.CENTER);
		pnMain.add(pnTable);

		JPanel pnTable1 = new JPanel();
		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Danh sách");
		pnTable.setBorder(borderTitle);

		con.add(pnMain);
	}

	public void addEvent() {

		btnthoat.addActionListener(eventExit);
		btnthem.addActionListener(eventAdd);
		btnsua.addActionListener(eventEdit);
		btnxoa.addActionListener(eventXoa);
		tbl.addMouseListener(eventTable);
		select.addActionListener(eventChooseClass);
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
			for (int i = tbl.getSelectedRow(); i <= tbl.getSelectedRow(); i++) {
				for (int y = 0; y < tbl.getColumnCount(); y++) {
					String value = (String) tbl.getValueAt(i,y);
					if (y == 0) {
						maSV.setText(value);
					}
					if (y == 1) {
						tenSV.setText(value);
					}
					if (y == 2) {
						tuoiSV.setText(value);
					}
					if (y == (tbl.getColumnCount() - 1)) {
						select.setSelectedItem(value);
					}

				}
			}

		}
	};

		
	ActionListener eventExit = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);

		}

	};
	ActionListener eventXoa = new ActionListener() {

	public void actionPerformed(ActionEvent e) {
		docFile();
		for(SinhVien x: arrSV) {
			if(maSV.getText().equals(x.getMaSV())) {
				arrSV.remove(x);
				luuFile();
				break;		
		}
			}
			dm.setRowCount(0);
			for (int i = 0; i < arrSV.size(); i++) {
				String row[] = { arrSV.get(i).getMaSV(),arrSV.get(i).getTenSV(),arrSV.get(i).getTuoiSV(),arrSV.get(i).getLopSV() };
				dm.addRow(row);
			
        }
			
		}

	}
;

ActionListener eventChooseClass = new ActionListener() {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		docFile();
		String pnContent1 = (String) select.getSelectedItem();
		dm.setRowCount(0);
			for (SinhVien x : arrSV) {
				if (pnContent1.equals(x.getLopSV())) {
					String[] row = { x.getMaSV(), x.getTenSV(), x.getTuoiSV(), x.getLopSV() };
					dm.addRow(row);
				}
			
		}
		maSV.setText("");
		tenSV.setText("");
		tuoiSV.setText("");
	

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
			tbl = new JTable(dm);
			maSV.setText("");
			tenSV.setText("");
			tuoiSV.setText("");
			Path path = Paths.get("dulieu");
			if (Files.exists(path)) {
				arrSV = TextFileFacTory.docFile("dulieu");
			} else {
				arrSV = new ArrayList<SinhVien>();
			}

			try {
				arrSV.add(new SinhVien(ma, ten, tuoi, chonLop));
				boolean checked = TextFileFacTory.luuFile(arrSV, "dulieu");
				if (checked == true) {
					JOptionPane.showMessageDialog(null, "Đã lưu thông tin của sinh viên", "Title",
							JOptionPane.WARNING_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Lưu thất bại", "Title", JOptionPane.WARNING_MESSAGE);
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Bạn đã nhập sai vui lòng nhập lại!", "Title",
						JOptionPane.WARNING_MESSAGE);
			}
		}
	};

	ActionListener eventEdit = new ActionListener() {

		@Override
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
	public void docFile() {
		Path path = Paths.get("dulieu");
		if (Files.exists(path)) {
			arrSV= TextFileFacTory.docFile("dulieu");
		} else {
			arrSV= new ArrayList<SinhVien>();
		}
	}
	public void luuFile() {
		boolean checked = TextFileFacTory.luuFile(arrSV, "dulieu");

	}
	public void showWindow() {
		this.setSize(500, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
