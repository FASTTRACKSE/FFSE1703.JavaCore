package qlsinhvien.ui;

import qlsinhvien.model.*;
import qlsinhvien.ui.*;
import qlsinhvien.model.*;
import qlsinhvien.io.*;

import java.util.ArrayList;
import java.util.Vector;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.Box;
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

public class QuanLi extends JFrame {
	private JComboBox cbo;
	private JTextField txtMaSv, txtTenSv, txtTuoi;
	private JButton btnThem, btnXoa, btnSua, btnThoat, btnNhap;
	private static ArrayList<SinhVien> arrSinhVien = new ArrayList<>();
	private DefaultTableModel dm;
	private JTable tbl1;

	public QuanLi() {
		super();
	}

	public QuanLi(String title) {
		super(title);
		addControls();
		addEvent();
		docFile();
	}

	public void showWindow() {
		this.setSize(600, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void addControls() {
		Container con = getContentPane();
		JPanel pnBox = new JPanel();
		JPanel pnFlow = new JPanel();

		JPanel Box1 = new JPanel();
		JPanel Box2 = new JPanel();
		JPanel Box3 = new JPanel();
		JPanel Box4 = new JPanel();
		JPanel Box5 = new JPanel();
		JPanel Box6 = new JPanel();
		JPanel Box7 = new JPanel();

		//
		pnFlow.setLayout(new FlowLayout());
		pnBox.setLayout(new BoxLayout(pnBox, BoxLayout.Y_AXIS));
		//
		JLabel lblTen = new JLabel("CHÆ¯Æ NG TRÃŒNH QUáº¢N LÃ� SINH VIÃŠN");
		Font font = new Font("ApnFlowrial", Font.BOLD, 25);
		lblTen.setFont(font);
		Box1.add(lblTen);
		//
		JLabel lblLop = new JLabel("Chá»�n Lá»›p");
		cbo = new JComboBox();
		cbo.addItem("ALL");
		cbo.addItem("FFSE 1701");
		cbo.addItem("FFSE 1702");
		cbo.addItem("FFSE 1703");
		cbo.addItem("FFSE 1704");
		Box2.add(lblLop);
		Box2.add(cbo);
		//
		JLabel lblMaSv = new JLabel("MÃ£ Sinh ViÃªn");
		lblMaSv.setPreferredSize(new Dimension(100, 10));
		txtMaSv = new JTextField(15);
		Box3.add(lblMaSv);
		Box3.add(txtMaSv);
		//
		JLabel lblTenSv = new JLabel("TÃªn Sinh ViÃªn");
		lblTenSv.setPreferredSize(new Dimension(100, 10));
		txtTenSv = new JTextField(15);
		Box4.add(lblTenSv);
		Box4.add(txtTenSv);
		//
		//
		JLabel lblTuoi = new JLabel("Tuá»•i");
		lblTuoi.setPreferredSize(new Dimension(100, 10));
		txtTuoi = new JTextField(15);
		Box5.add(lblTuoi);
		Box5.add(txtTuoi);
		//
		btnThem = new JButton("ThÃªm");
		btnSua = new JButton("Sá»­a");
		btnXoa = new JButton("XÃ³a");
		btnThoat = new JButton("ThoÃ¡t");
		btnNhap = new JButton("Nháº­p Má»›i");

		Box6.add(btnThem);
		Box6.add(btnSua);
		Box6.add(btnXoa);
		Box6.add(btnThoat);
		Box6.add(btnNhap);
		//
		JPanel pnTable = new JPanel();
		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Danh sÃ¡ch");
		pnTable.setBorder(borderTitle);

		dm = new DefaultTableModel();
		dm.addColumn("MÃ£");
		dm.addColumn("TÃªn");
		dm.addColumn("Tuá»•i");
		dm.addColumn("Lá»›p");
		tbl1 = new JTable(dm);
		JScrollPane sc = new JScrollPane(tbl1);
		pnTable.setLayout(new BorderLayout());
		pnTable.add(sc);
		Box7.setLayout(new BorderLayout());
		Box7.add(pnTable);
		//
		pnBox.add(Box1);
		pnBox.add(Box2);
		pnBox.add(Box3);
		pnBox.add(Box4);
		pnBox.add(Box5);
		pnBox.add(Box6);
		pnBox.add(Box7);
		//
		con.add(pnBox);
		//

		tbl1.addMouseListener(new MouseListener() {

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
				txtMaSv.setEditable(false);
				for (int i = tbl1.getSelectedRow(); i <= tbl1.getSelectedRow(); i++) {
					for (int y = 0; y < tbl1.getColumnCount(); y++) {
						String value = (String) tbl1.getValueAt(i, y);
						if (y == 0) {
							txtMaSv.setText(value);
						}
						if (y == 1) {
							txtTenSv.setText(value);
						}
						if (y == 2) {
							txtTuoi.setText(value);
						}
						if (y == (tbl1.getColumnCount() - 1)) {
							cbo.setSelectedItem(value);
						}

					}
				}

			}
		});
	}

	public void addEvent() {
		btnThoat.addActionListener(eventExit);
		btnThem.addActionListener(eventThem);
		btnXoa.addActionListener(eventXoa);
		btnSua.addActionListener(eventSua);
		btnNhap.addActionListener(eventNhapmoi);
		cbo.addActionListener(eventCbo);
	}

	//
	ActionListener eventExit = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
		}
	};
	ActionListener eventNhapmoi = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			txtMaSv.setText("");
			txtTenSv.setText("");
			txtTuoi.setText("");
			txtMaSv.setEditable(true);
		}
	};
	//
	ActionListener eventThem = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (txtMaSv.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Pháº£i Nháº­p MÃ£ Sinh ViÃªn !!!");
			}
			if (txtTenSv.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Pháº£i Nháº­p TÃªn Sinh ViÃªn !!!");
			}
			if (txtTuoi.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Pháº£i Nháº­p Tuá»•i Sinh ViÃªn !!!");
			} else {
				Them();
				luuFile();
				txtMaSv.setText("");
				txtTenSv.setText("");
				txtTuoi.setText("");
				txtMaSv.setEditable(true);
			}

		}

	};

	public void Them() {
		int ktMasv = 0;
		String lopSv = cbo.getSelectedItem().toString();
		String maSv = txtMaSv.getText();
		String tenSv = txtTenSv.getText();
		String tuoiSv = txtTuoi.getText();
		for (SinhVien x : arrSinhVien) {
			if (maSv.equals(x.getMaSv())) {
				ktMasv = 1;
			}
		}
		if (ktMasv > 0) {
			JOptionPane.showMessageDialog(null, "MÃ£ Sinh ViÃªn Ä‘Ã£ tá»“n táº¡i !!!");
		} else {
			arrSinhVien.add(new SinhVien(maSv, tenSv, tuoiSv, lopSv));
			dm.setRowCount(0);
			for (int i = 0; i < arrSinhVien.size(); i++) {
				String row[] = { arrSinhVien.get(i).getMaSv(), arrSinhVien.get(i).getTenSv(),
						arrSinhVien.get(i).getTuoiSv(), arrSinhVien.get(i).getLop() };
				dm.addRow(row);
			}
		}
	}

	ActionListener eventXoa = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			txtTenSv.setEditable(true);
			if (txtMaSv.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Vui lÃ²ng chá»�n sinh viÃªn cáº§n Xoa!");
			} else {
				xoa();
				txtMaSv.setText("");
				txtTenSv.setText("");
				txtTuoi.setText("");
				txtMaSv.setEditable(true);
				JOptionPane.showMessageDialog(null, "XÃ³a tÃªn sinh viÃªn thÃ nh cÃ´ng!");
			}
		}
	};

	public void xoa() {
		for (SinhVien x : arrSinhVien) {
			if (txtMaSv.getText().equals(x.getMaSv())) {
				arrSinhVien.remove(x);
				luuFile();
				break;
			}
		}
		dm.setRowCount(0);
		for (int i = 0; i < arrSinhVien.size(); i++) {
			String row[] = { arrSinhVien.get(i).getMaSv(), arrSinhVien.get(i).getTenSv(),
					arrSinhVien.get(i).getTuoiSv(), arrSinhVien.get(i).getLop() };
			dm.addRow(row);
		}
		txtMaSv.setEditable(true);
	}

	ActionListener eventSua = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			txtTenSv.setEditable(true);
			if (txtMaSv.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Vui lÃ²ng chá»�n sinh viÃªn cáº§n sá»­a!");
			} else {
				sua();
				txtMaSv.setText("");
				txtTenSv.setText("");
				txtTuoi.setText("");
				JOptionPane.showMessageDialog(null, "Sá»­a tÃªn sinh viÃªn thÃ nh cÃ´ng!");
			}
		}
	};

	public void sua() {
		for (SinhVien x : arrSinhVien) {
			if (txtMaSv.getText().equals(x.getMaSv())) {
				x.setTenSv(txtTenSv.getText());
				x.setTuoiSv(txtTuoi.getText());
				x.setLop(cbo.getSelectedItem().toString());
				luuFile();
			}
		}
		dm.setRowCount(0);
		for (int i = 0; i < arrSinhVien.size(); i++) {
			String row[] = { arrSinhVien.get(i).getMaSv(), arrSinhVien.get(i).getTenSv(),
					arrSinhVien.get(i).getTuoiSv(), arrSinhVien.get(i).getLop() };
			dm.addRow(row);
		}
	}

	//
	ActionListener eventCbo = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			dm.setRowCount(0);
			String comBox = cbo.getSelectedItem().toString();
			if (comBox == "ALL") {
				for (SinhVien x : arrSinhVien) {
					String row[] = { x.getMaSv(), x.getTenSv(), x.getTuoiSv(), x.getLop() };
					dm.addRow(row);
				}
			} else {
				for (SinhVien x : arrSinhVien) {
					if (comBox.equals(x.getLop())) {
						String row[] = { x.getMaSv(), x.getTenSv(), x.getTuoiSv(), x.getLop() };
						dm.addRow(row);
					}
				}

			}
		}
	};
	//

	public void luuFile() {
		boolean kt = Serialize.luuFile(arrSinhVien, "dulieu.txt");
	}

	public void docFile() {
		ArrayList<SinhVien> arrFile = Serialize.docFile("dulieu.txt");
		arrSinhVien = arrFile;
		dm.setRowCount(0);
		for (int i = 0; i < arrSinhVien.size(); i++) {

			String row[] = { arrSinhVien.get(i).getMaSv(), arrSinhVien.get(i).getTenSv(),
					arrSinhVien.get(i).getTuoiSv(), arrSinhVien.get(i).getLop() };
			dm.addRow(row);

		}
	}

}
