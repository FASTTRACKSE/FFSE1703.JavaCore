package sinhvien.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

import java.util.ArrayList;
import sinhvien.model.*;
public class WindowLayout extends JFrame {
	JComboBox cbo;
	JTextField txtMaSV, txtTenSV, txtTuoi;
	JButton btnAdd, btnEdit, btnDelete, btnClose, btnSubmit;
	DefaultTableModel dm=new DefaultTableModel();
	
	final JTable tbl= new JTable(dm);
	JScrollPane sc= new JScrollPane(tbl);
	ArrayList<SinhVien> arrSv = new ArrayList<SinhVien>();
	public WindowLayout(String Window){
		super(Window);
		addControls();
		addEvent();
	}


	private void addControls() {
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		JPanel pn1 = new JPanel();
		JLabel lbl1 = new JLabel("Chương Trình Quản Lí Sinh Viên");
		Font font = new Font("Arial",Font.BOLD,20);
		lbl1.setFont(font);
		pn1.add(lbl1);
		
		JPanel pn2 = new JPanel();
		JLabel lbl2 = new JLabel("Chọn lớp: ");
		pn2.add(lbl2);
		cbo=new JComboBox();
		cbo.addItem("ffse1701");
		cbo.addItem("ffse1702");
		cbo.addItem("ffse1703");
		cbo.addItem("ffse1704");
		add(cbo);
		pn2.add(cbo);
		
		JPanel pn3 = new JPanel();
		JLabel lbl3 = new JLabel("Mã sinh viên: ");
		txtMaSV = new JTextField(20);
		pn3.add(lbl3);
		pn3.add(txtMaSV);
		
		
		JPanel pn4 = new JPanel();
		JLabel lbl4 = new JLabel("Tên sinh viên: ");
		txtTenSV = new JTextField(20);
		pn4.add(lbl4);
		pn4.add(txtTenSV);
		
		
		JPanel pn5 = new JPanel();
		JLabel lbl5 = new JLabel("Tuổi:                 ");
		txtTuoi = new JTextField(20);
		pn5.add(lbl5);
		pn5.add(txtTuoi);
		
		
		JPanel pn6 = new JPanel();
		btnAdd = new JButton("Thêm");
		pn6.add(btnAdd);
		btnEdit = new JButton("Sửa");
		pn6.add(btnEdit);
		btnDelete = new JButton("Xóa");
		pn6.add(btnDelete);
		btnClose = new JButton("Thoát");
		pn6.add(btnClose);
		btnSubmit = new JButton("Nhập");
		pn6.add(btnSubmit);
		
		JPanel pn7 = new JPanel();
		Border border=BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle=BorderFactory.createTitledBorder(border, "Danh sách");
		pn7.setBorder(borderTitle);
		dm.addColumn("Mã");
		dm.addColumn("Tên");
		dm.addColumn("Tuổi");
	
		
		pn7.setLayout(new BorderLayout());
		pn7.add(sc,BorderLayout.CENTER);
		
		pnMain.add(pn1);
		pnMain.add(pn2);
		pnMain.add(pn3);
		pnMain.add(pn4);
		pnMain.add(pn5);
		pnMain.add(pn6);
		pnMain.add(pn7);
		
		con.add(pnMain);
		
	}
	private void addEvent() {
		// TODO Auto-generated method stub
		cbo.addActionListener(eventChooseClass);
		btnAdd.addActionListener(eventAdd);
		btnEdit.addActionListener(eventEdit);
		btnDelete.addActionListener(eventDelete);
		btnClose.addActionListener(eventClose);
		btnSubmit.addActionListener(eventSubmit);
		tbl.addMouseListener(eventChooseRow);
	}
	MouseAdapter eventChooseRow = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int cot = tbl.getSelectedRow();
			String ma = tbl.getValueAt(cot,0).toString();
			String ten = tbl.getValueAt(cot,1).toString();
			String tuoi = tbl.getValueAt(cot,2).toString();
			txtMaSV.setText(ma);
			txtTenSV.setText(ten);
			txtTuoi.setText(tuoi);
			}
	};
	ActionListener eventChooseClass = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			dm.setRowCount(0);
			String choose = cbo.getSelectedItem().toString();
			for(SinhVien x : arrSv) {
				if(choose.equalsIgnoreCase(x.getLopSv())) {
					dm.addRow(new String[]{x.getMaSv(), x.getTenSv(), x.getTuoiSv()});		
				}
			}
		}
	};
	ActionListener eventAdd = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			txtMaSV.setText("");
			txtTenSV.setText("");
			txtTuoi.setText("");
			cbo.showPopup();
		}
	};
	
	ActionListener eventEdit = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String maSv = txtMaSV.getText();
			String tenSv = txtTenSV.getText();
			String tuoiSv = txtTuoi.getText();
			for(SinhVien x : arrSv) {
				if(maSv.equals(x.getMaSv())) {
					x.setTenSv(tenSv);
					x.setTuoiSv(tuoiSv);
				}
			}
			dm.setRowCount(0);
			String choose = cbo.getSelectedItem().toString();
			for(SinhVien x : arrSv) {
				if(choose.equalsIgnoreCase(x.getLopSv())) {
					dm.addRow(new String[]{x.getMaSv(), x.getTenSv(), x.getTuoiSv()});		
				}
			}
			txtMaSV.setText("");
			txtTenSV.setText("");
			txtTuoi.setText("");
			
		}
	};
	ActionListener eventDelete = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String maSv = txtMaSV.getText();
			int stt=0;
			for(int i=0;i<arrSv.size();i++) {
				if(maSv.equals(arrSv.get(i).getMaSv())) {
					stt=i;
				}
			}
			arrSv.remove(stt);
			dm.setRowCount(0);
			String choose = cbo.getSelectedItem().toString();
			for(SinhVien x : arrSv) {
				if(choose.equalsIgnoreCase(x.getLopSv())) {
					dm.addRow(new String[]{x.getMaSv(), x.getTenSv(), x.getTuoiSv()});		
				}
			}
			txtMaSV.setText("");
			txtTenSV.setText("");
			txtTuoi.setText("");
		}
	};
	ActionListener eventClose = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.exit(0);
		}
	};
	ActionListener eventSubmit = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String maSv = txtMaSV.getText();
			String tenSv = txtTenSV.getText();
			String tuoiSv = txtTuoi.getText();
			String lopSv = cbo.getSelectedItem().toString();
			arrSv.add(new SinhVien(maSv, tenSv, tuoiSv, lopSv));
			dm.addRow(new String[]{maSv,tenSv,tuoiSv});
			txtMaSV.setText("");
			txtTenSV.setText("");
			txtTuoi.setText("");
		}
	};
	public void showWindow() {
		this.setSize(500,400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}