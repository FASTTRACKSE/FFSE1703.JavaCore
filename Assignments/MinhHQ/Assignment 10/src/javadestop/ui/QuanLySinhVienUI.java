package javadestop.ui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList; 
import javadestop.model.*;
import javadestop.io.TextFileFactory;


public class QuanLySinhVienUI extends JFrame{
	static JScrollPane sp;
	static DefaultTableModel dm;
	static JTable table;
	static JComboBox select;
	static JTextField tenSV = new JTextField(), maSV = new JTextField(), tuoiSV = new JTextField();
	static ArrayList<SinhVien> arrSV = new ArrayList<SinhVien>();
	static String[] lop = {"FFSE1701","FFSE1702","FFSE1703","FFSE1704","Tất Cả"};
	
	JButton them = new JButton("Thêm"), 
			xoa = new JButton("Xóa"),
			sua = new JButton("Sửa"), 
			thoat= new JButton("Thoát"),
			nhap= new JButton("Nhập"); 
	
	
	public QuanLySinhVienUI(String tieude)
	{
		super(tieude);
		addControls();
		addEvent();
	}
	
	public void addControls()
	{
		Container con=getContentPane();
		con.setLayout(new FlowLayout());
		JPanel main = new JPanel();
		
		main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
		
		JPanel Title=new JPanel();
		JLabel lbl=new JLabel("Chương trình quản lý sinh viên ");
		Font font=new Font("Arial", Font.BOLD,14);
		lbl.setFont(font);
		Title.setPreferredSize(new Dimension(0, 30));
		Title.add(lbl);
		main.add(Title,BorderLayout.NORTH);
		
		JPanel chonlop = new JPanel();
		JLabel txtlop=new JLabel("Chọn lớp: ");
		select=new JComboBox(lop);
		chonlop.add(txtlop);
		chonlop.add(select);
		main.add(chonlop);
		
		JPanel nhapMaSV = new JPanel();
		nhapMaSV.setLayout(new FlowLayout());
		JLabel lblNhapMaSV= new JLabel("Mã sinh viên:");
		maSV = new JTextField(20);
		nhapMaSV.add(lblNhapMaSV);
		nhapMaSV.add(maSV);
		main.add(nhapMaSV);
		
		JPanel nhapTen = new JPanel();
		nhapTen.setLayout(new FlowLayout());
		JLabel lblNhapTen= new JLabel("Tên sinh viên:");
		tenSV = new JTextField(20);
		nhapTen.add(lblNhapTen);
		nhapTen.add(tenSV);
		main.add(nhapTen);
		
		JPanel nhapTuoi = new JPanel();
		nhapTuoi.setLayout(new FlowLayout());
		JLabel lblNhapTuoi= new JLabel("Tuổi sinh viên:");
		tuoiSV = new JTextField(20);
		nhapTuoi.add(lblNhapTuoi);
		nhapTuoi.add(tuoiSV);
		main.add(nhapTuoi);
		
		JPanel button = new JPanel();
		button.add(them);
		button.add(sua);
		button.add(xoa);
		button.add(thoat);
		button.add(nhap);
		main.add(button);
		
		JPanel center = new JPanel();
		center.setLayout(new BorderLayout());
		Border border=BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle=BorderFactory.createTitledBorder(border, "Danh sách");
		dm=new DefaultTableModel();
		
		dm.addColumn("Mã");
		dm.addColumn("Tên");
		dm.addColumn("Tuổi");
		
		Path path = Paths.get("dulieu.txt");
		if(Files.exists(path)) {
			arrSV = TextFileFactory.docFile("dulieu.txt");
		}else {
			arrSV = new ArrayList<SinhVien>();
			}
		for(SinhVien x : arrSV) {
			dm.addRow(new String[] {x.getMaSV(),x.getTenSV(),x.getTuoi()});
			
		}
		
		 table = new JTable(dm);
			sp=new JScrollPane(table);
			table.setLayout(new BorderLayout());
			center.setBorder(borderTitle);
			center.add(sp,BorderLayout.CENTER);
			main.add(center);
				  
		con.add(main);
		
		
	}
	
	public void addEvent() 
	{
		select.addActionListener(eventChooseClass);
		thoat.addActionListener(eventExit);
		them.addActionListener(eventAdd);
		sua.addActionListener(eventEdit);
		
	}
	
	ActionListener eventChooseClass = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			
		}
		
	};
	
		ActionListener eventExit = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
				
			}
			
		};
		
		ActionListener eventAdd = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String chonLop =(String) select.getSelectedItem();
				String ma = chonLop + maSV.getText();
				String ten = tenSV.getText();
				String tuoi = tuoiSV.getText();
				dm.addRow(new String[] {ma,ten,tuoi});
				table = new JTable(dm);
				maSV.setText("");
				tenSV.setText("");
				tuoiSV.setText("");
				Path path = Paths.get("dulieu.txt");
				if(Files.exists(path)) {
					arrSV = TextFileFactory.docFile("dulieu.txt");
				}else {
					arrSV = new ArrayList<SinhVien>();
					}
				
				try {	arrSV.add(new SinhVien(ma,ten,tuoi,chonLop));
				boolean checked= TextFileFactory.luuFile(arrSV, "dulieu.txt");
				if (checked == true) {
					JOptionPane.showMessageDialog(null, "Đã lưu thông tin của sinh viên",
			                  "Title", JOptionPane.WARNING_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Lưu thất bại",
			                  "Title", JOptionPane.WARNING_MESSAGE);
				}
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Bạn đã nhập sai vui lòng nhập lại!",
		                  "Title", JOptionPane.WARNING_MESSAGE);
			}
				}
		};
		
		ActionListener eventEdit = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String ma = maSV.getText();
				String ten = tenSV.getText();
				String tuoi = tuoiSV.getText();
				
				
				
			
			}
			
		};
		
	
	public void showWindow()
	{
		this.setSize(500, 440);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
