package asm10.ui;
import java.util.ArrayList;
import asm10.model.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class Layout extends JFrame {
	JTextField txtMa, txtTen,txtTuoi;
	JButton btnThem, btnSua,btnXoa,btnThoat,btnNhap;
	JComboBox cbo;
	DefaultTableModel dm=new DefaultTableModel();
	final JTable tbl7=new JTable(dm);
	JScrollPane sc=new JScrollPane(tbl7);
	ArrayList <SinhVien> arrSv = new ArrayList<SinhVien>();
	public Layout(String title) {
		super(title);
		addControl();
		addEvents();
	}
	

	private void addEvents() {
		// TODO Auto-generated method stub
		btnThem.addActionListener(eventThem);
		btnSua.addActionListener(eventSua);
		btnXoa.addActionListener(eventXoa);
		btnThoat.addActionListener(eventThoat);
		btnNhap.addActionListener(eventNhap);
		tbl7.addMouseListener(eventChooseRow);
	}
	 MouseAdapter eventChooseRow = new MouseAdapter() {
	    	public void mouseClicked(MouseEvent e) {
	    		int col = tbl7.getSelectedRow();
	    		String ma =  (String) tbl7.getValueAt(col, 0);
	    		String ten =  (String) tbl7.getValueAt(col, 1);
	    		String tuoi =  (String) tbl7.getValueAt(col, 2);
	    		txtMa.setText(ma);
	    		txtTen.setText(ten);
	    		txtTuoi.setText(tuoi);
	    	}
	 };
	ActionListener eventThem = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			// TODO Auto-generated method stub
			String ma = txtMa.getText();
			String ten = txtTen.getText();
			String tuoi = txtTuoi.getText();
			String lop = cbo.getSelectedItem().toString();
			arrSv.add(new SinhVien(ma,ten,tuoi,lop));
			dm.addRow(new String[]{ma, ten, tuoi, lop});
		}
		
	};	
	ActionListener eventSua= new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			dm.setRowCount(0);
			// TODO Auto-generated method stub
			String ma = txtMa.getText();
			String ten = txtTen.getText();
			String tuoi = txtTuoi.getText();
			for (int i=0; i<arrSv.size(); i++) {
				if(ma.equals(arrSv.get(i).getMaSv())) {
					arrSv.get(i).setTenSv(ten);
					arrSv.get(i).setTuoiSv(tuoi);
				}
			}
			for(SinhVien x : arrSv) {
				dm.addRow(new String[]{x.getMaSv(), x.getTenSv(), x.getTuoiSv(), x.getLopSv()});
			}
		}
		
	};		
	ActionListener eventXoa = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
		}
		
	};		
	ActionListener eventThoat = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.exit(0);
		}
		
	};		
	ActionListener eventNhap = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String ma = txtMa.getText();
			String ten = txtTen.getText();
			String tuoi = txtTuoi.getText();
			String lop = cbo.getSelectedItem().toString();
			arrSv.add(new SinhVien(ma,ten,tuoi,lop));
			dm.addRow(new String[]{ma, ten, tuoi,lop});
			txtMa.setText("");
			txtTen.setText("");
			txtTuoi.setText("");
			
		}
		
	};		
		
	

	private void addControl() {
		// TODO Auto-generated method stub
		Container con=getContentPane();
		JPanel pnChinh=new JPanel();
		
		pnChinh.setLayout(new BoxLayout(pnChinh, BoxLayout.Y_AXIS));
		
		
		JPanel pnChinh1 = new JPanel();
		JLabel lbl=new JLabel("Chương trình quản lý sinh siên");
		Font font=new Font("Arial", Font.BOLD,20);
		lbl.setFont(font);
		pnChinh1.add(lbl);
		
		JPanel pnChinh2 = new JPanel();
		JLabel lbl2 = new JLabel("Chọn lớp: ");
		cbo=new JComboBox();
		cbo.addItem("FFSE1701");
		cbo.addItem("FFSE1702");
		cbo.addItem("FFSE1703");
		cbo.addItem("FFSE1704 ");
		pnChinh2.add(lbl2);
		pnChinh2.add(cbo);
		
		
		JPanel pnChinh3 = new JPanel();
		JLabel lbl3 = new JLabel("Mã sinh viên: ");
		txtMa = new JTextField(15);
		pnChinh3.add(lbl3);
		pnChinh3.add(txtMa);
		
		
		JPanel pnChinh4 = new JPanel();
		JLabel lbl4 = new JLabel("Tên sinh viên: ");
		txtTen = new JTextField(15);
		pnChinh4.add(lbl4);
		pnChinh4.add(txtTen);
		
		JPanel pnChinh5 = new JPanel();
		JLabel lbl5 = new JLabel("Tuổi sinh viên: ");
		pnChinh5.add(lbl5);
		txtTuoi = new JTextField(15);
		pnChinh5.add(txtTuoi);
		
		JPanel pnChinh6 = new JPanel();
		pnChinh6.setLayout(new FlowLayout());
		btnThem = new JButton("Thêm");
		btnSua = new JButton("Sửa");
		btnXoa = new JButton("Xóa");
		btnThoat = new JButton("Thoát");
		btnNhap = new JButton("Nhập");
		pnChinh6.add(btnThem);
		pnChinh6.add(btnSua);
		pnChinh6.add(btnXoa);
		pnChinh6.add(btnThoat);
		pnChinh6.add(btnNhap);
		
		
		JPanel pnChinh7 = new JPanel();
		Border border=BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle=BorderFactory.createTitledBorder(border, "Danh sách");
		pnChinh7.setBorder(borderTitle);
		dm.addColumn("Mã");
		dm.addColumn("Tên");
		dm.addColumn("Tuổi");
		dm.addColumn("Lớp");
		pnChinh7.setLayout(new BorderLayout());
		pnChinh7.add(sc,BorderLayout.CENTER);
		
		pnChinh.add(pnChinh1);pnChinh.add(pnChinh2);pnChinh.add(pnChinh3);
		pnChinh.add(pnChinh4);pnChinh.add(pnChinh5);pnChinh.add(pnChinh6);
		pnChinh.add(pnChinh7);
		con.add(pnChinh);
	}
	public void showWindow()
	{
		this.setSize(600, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	
}
