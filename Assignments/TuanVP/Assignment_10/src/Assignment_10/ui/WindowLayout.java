package Assignment_10.ui;

import javax.swing.BorderFactory;
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

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;

import Assignment_10.model.*;
import Assignment_10.io.*;
public class WindowLayout extends JFrame {
	public JButton btn1 = new JButton("Them");
	public JButton btn2 = new JButton("Sua");
	public JButton btn3 = new JButton("Xoa");
	public JButton btn4 = new JButton("Thoat");
//	public JButton btn5 = new JButton("Nhap");
	public JButton btn6 = new JButton("Xuat");
	public JTextField textTenSV = new JTextField(20);
	public JTextField textTuoiSV = new JTextField(20);
	public JTextField textMaSV = new JTextField(20);
	public DefaultTableModel dm = new DefaultTableModel();
	public JTable tableSV = new JTable(dm){
		public boolean isCellEditable(int row,int column){
		    if(column == 0) return false;
		    return true;
		  }
		};
	private String[] lop = {"FFSE1701","FFSE1702","FFSE1703","FFSE1704"};
	public ArrayList<SinhVien> arrSV = new ArrayList<SinhVien>();
	public SinhVien sv;
	public int row, column;
	public String maSV,tenSV,tuoiSV,text;
	public JComboBox cb = new JComboBox(lop);
	
	public WindowLayout(String tille) {
		super(tille);
		addControls();
		addEvents();
	}

	private void addControls() {
		Container con=getContentPane();		
		JPanel pnMainLayout = new JPanel();
		pnMainLayout.setLayout(new BoxLayout(pnMainLayout,BoxLayout.Y_AXIS ));
		
		JPanel pnTitle = new JPanel();
		JLabel title = new JLabel("Chuong trinh quan ly sinh vien");
		Font font = new Font("Arial", Font.BOLD, 20);
		title.setFont(font);
		title.setForeground(Color.BLACK);
		pnTitle.add(title);
		
		JPanel pnOption = new JPanel();
		JLabel labelOption = new JLabel("Chon lop: ");
		pnOption.add(labelOption);
		pnOption.add(cb);
		
		JPanel pnTenSV = new JPanel();
		JLabel labelTenSV = new JLabel("Ten sinh vien:");
		pnTenSV.add(labelTenSV);
		pnTenSV.add(textTenSV);

		JPanel pnTuoiSV = new JPanel();
		JLabel labelTuoiSV = new JLabel("Tuoi sinh vien:");
		pnTuoiSV.add(labelTuoiSV);
		pnTuoiSV.add(textTuoiSV);
		
		JPanel pnMaSV = new JPanel();
		JLabel labelMaSV = new JLabel("Ma sinh vien:");
		pnMaSV.add(labelMaSV);
		pnMaSV.add(textMaSV);
		
		JPanel pnAction = new JPanel();
		cb.addActionListener(showSV);
		pnAction.add(btn1);
		pnAction.add(btn2);
		pnAction.add(btn3);
		pnAction.add(btn4);
//		pnAction.add(btn5);
		pnAction.add(btn6);
		
		JPanel pnTable = new JPanel();
		pnTable.setLayout(new BorderLayout());
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder tilleBorder = BorderFactory.createTitledBorder(border, "Danh sach");
		dm.addColumn("Ma");
		dm.addColumn("Ten");
		dm.addColumn("Tuoi");
		arrSV = TextFileFactory.docFile("dulieu.txt");
		for (SinhVien x : arrSV) {
			dm.addRow(new String[] {x.getMaSV(),x.getTenSV(),x.getTuoiSV()});
		}
		JScrollPane sc = new JScrollPane(tableSV);
		pnTable.setBorder(tilleBorder);
		pnTable.add(sc, BorderLayout.CENTER);
		
		pnMainLayout.add(pnTitle);
		pnMainLayout.add(pnOption);
		pnMainLayout.add(pnMaSV);
		pnMainLayout.add(pnTenSV);
		pnMainLayout.add(pnTuoiSV);
		pnMainLayout.add(pnAction);
		pnMainLayout.add(pnTable);
		
		con.add(pnMainLayout);
		
	}
	
	private void addEvents() {
		btn1.addActionListener(nhapSV);
		btn2.addActionListener(suaSV);
		btn3.addActionListener(xoaSV);
		btn4.addActionListener(exit);
//		btn5.addActionListener(nhapFile);
		btn6.addActionListener(xuatFile);
	}
	ActionListener showSV = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			showArray();
		}
	};
	ActionListener nhapSV = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String lopSV = (String) cb.getSelectedItem();
			String maSV = textMaSV.getText();
			String tenSV = textTenSV.getText();
			String tuoiSV = textTuoiSV.getText();
			if (maSV.isEmpty() || tenSV.isEmpty() || tuoiSV.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Xin hay nhap day du thong tin!");
			} else {
				for (SinhVien x : arrSV) {
					if (maSV.equals(x.getMaSV())) {
						if (lopSV.equals(x.getLopSV())) {
							JOptionPane.showMessageDialog(null, "Sinh vien da ton tai!"); 
						}
					} else {
						textMaSV.setText("");
						textTenSV.setText("");
						textTuoiSV.setText("");
						dm.addRow(new String[] {maSV,tenSV,tuoiSV});
						JOptionPane.showMessageDialog(null, "Nhap thanh cong!");
						break;
					}	
				}
			}
			arrayList();
		}
	};
	ActionListener suaSV = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			arrayList();
			JOptionPane.showMessageDialog(null, "Sua thanh cong!");
		}
	};
	ActionListener xoaSV = new ActionListener() {
			
		@Override
		public void actionPerformed(ActionEvent e) {
			row = tableSV.getSelectedRow();
			dm.removeRow(row);
			arrayList();
		}
	};
	ActionListener exit = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			int mess = JOptionPane.showConfirmDialog(null, "Ban muon thoat?", "Thoat", JOptionPane.YES_NO_OPTION);
			if (mess == JOptionPane.YES_OPTION) {
				System.exit(0);
			} else {}
		}
	};
	ActionListener nhapFile = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {

		}
	};
	ActionListener xuatFile = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JFrame f = new JFrame();
			boolean kt = TextFileFactory.luuFile(arrSV, "dulieu.txt");
//			boolean kt2 = ByteFileFactory.luuFile(arrSV, "dulieu2.txt");
			if (kt == true) {
				JOptionPane.showMessageDialog(f,"Luu file thanh cong!");
			} else {
				JOptionPane.showMessageDialog(f,"Luu file that bai cong!");
			}
		}
	}; 
	public void showArray() {
		row = dm.getRowCount();
		arrSV = TextFileFactory.docFile("dulieu.txt");
		for (int i = 0; i < row; i++) {
			dm.removeRow(i);
		}
		String lopSV = (String) cb.getSelectedItem();
		for (SinhVien x : arrSV) {
			if (lopSV.equals(x.getLopSV())) {
				dm.addRow(new String[] {x.getMaSV(),x.getTenSV(),x.getTuoiSV()});
			}
		}
	}
	public void arrayList() {
		row = dm.getRowCount();
		String lopSV = (String) cb.getSelectedItem();
		for (SinhVien x : arrSV) {
			if (lopSV.equals(x.getLopSV())) {
				arrSV.remove(x);
				break;
			}
		}		
		for (int i = 0; i < row; i++) {
			sv = new SinhVien();
			sv.setLopSV(lopSV);
			String maSV = (String) dm.getValueAt(i, 0);
			sv.setMaSV(maSV);
			String tenSV = (String) dm.getValueAt(i, 1);
			sv.setTenSV(tenSV);
			String tuoiSV = (String) dm.getValueAt(i, 2);
			sv.setTuoiSV(tuoiSV);
			arrSV.add(sv);
		}
	}
	public void showWindow() {
		this.setSize(500, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
