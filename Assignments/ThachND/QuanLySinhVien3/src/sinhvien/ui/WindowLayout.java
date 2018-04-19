package sinhvien.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

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

import java.util.ArrayList;

import sinhvien.io.SerializeFileFactory;
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
		cbo = new JComboBox();
		cbo.addItem("Tất cả");
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
			File file = new File("D:/FFSE1703.JavaCore/Assignments/ThachND/QuanLySinhVien3/dulieusinhvien.txt");	    
		    if(file.exists()) {
		    	ArrayList<SinhVien> arrSvFile = SerializeFileFactory.docFile("dulieusinhvien.txt");
		  		arrSv=arrSvFile;
		    }
			dm.setRowCount(0);
			String choose = cbo.getSelectedItem().toString();
			for(SinhVien x : arrSv) {
				if(choose.equals(x.getLopSv())) {
					dm.addRow(new String[]{x.getMaSv(), x.getTenSv(), x.getTuoiSv()});		
				}
			}
			txtMaSV.setText("");
			txtTenSV.setText("");
			txtTuoi.setText("");
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
					if(choose.equals(x.getLopSv())) {
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
			String tenSv = txtTenSV.getText();
			
			int stt=0;
			for(int i=0;i<arrSv.size();i++) {
				if(maSv.equals(arrSv.get(i).getMaSv())) {
					stt=i;
				}
			}
			arrSv.remove(stt);
			boolean checked= SerializeFileFactory.luuFile(arrSv, "dulieusinhvien.txt");
			if (checked == true) {
				String msg = "Đã Xóa Thành công Sinh viên "+tenSv;
				JOptionPane.showMessageDialog(null, msg, "Xóa Thành Công", JOptionPane.INFORMATION_MESSAGE);
			} else {
				System.out.println("Xóa thất bại");
			}
			dm.setRowCount(0);
			String choose = cbo.getSelectedItem().toString();
			for(SinhVien x : arrSv) {
				if(choose.equals(x.getLopSv())) {
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
			String kt = "Không trùng";
			for(int i = 0; i < arrSv.size(); i++) {
				if(txtMaSV.getText().equals(arrSv.get(i).getMaSv()) && cbo.getSelectedItem().toString().equals(arrSv.get(i).getLopSv())) {
					kt = "trùng";
				}
			}
			
			if(kt == "trùng") {
				JOptionPane.showMessageDialog(null, "Mã sinh viên đã tồn tại!");
			}
			else {
			arrSv.add(new SinhVien(maSv, tenSv, tuoiSv, lopSv));
			boolean checked= SerializeFileFactory.luuFile(arrSv, "dulieusinhvien.txt");
			if (checked == true) {
				String msg = "Đã lưu thành công Sinh viên "+tenSv;
				JOptionPane.showMessageDialog(null, msg, "Lưu Thành Công", JOptionPane.INFORMATION_MESSAGE);
			} else {
				System.out.println("Lưu thất bại");
			}
			dm.addRow(new String[]{maSv,tenSv,tuoiSv});
			txtMaSV.setText("");
			txtTenSV.setText("");
			txtTuoi.setText("");
			}
			
		}
	};
	public void showWindow() {
		this.setSize(800,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
