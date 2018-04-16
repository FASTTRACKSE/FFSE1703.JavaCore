package javadestop.ui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*; 


public class QuanLySinhVienUI extends JFrame{
	JScrollPane sp;
	DefaultTableModel dm;
	JTable table;
	JComboBox select;
	JTextField tenSV = new JTextField(), maSV = new JTextField(), tuoiSV = new JTextField();
	String[] lop = {"FFSE1701","FFSE1702","FFSE1703","FFSE1704"};
	
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
		JLabel lblNhapMaSV= new JLabel("Mã sinh viên:	");
		maSV = new JTextField(20);
		nhapMaSV.add(lblNhapMaSV);
		nhapMaSV.add(maSV);
		main.add(nhapMaSV);
		
		JPanel nhapTen = new JPanel();
		nhapTen.setLayout(new FlowLayout());
		JLabel lblNhapTen= new JLabel("Tên sinh viên:	");
		tenSV = new JTextField(20);
		nhapTen.add(lblNhapTen);
		nhapTen.add(tenSV);
		main.add(nhapTen);
		
		JPanel nhapTuoi = new JPanel();
		nhapTuoi.setLayout(new FlowLayout());
		JLabel lblNhapTuoi= new JLabel("Tuổi:       ");
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
		Border border=BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle=BorderFactory.createTitledBorder(border, "Danh sách");
		dm=new DefaultTableModel();
		
		dm.addColumn("Mã");
		dm.addColumn("Tên");
		dm.addColumn("Tuổi");
		
		dm.addRow(new String[] { "Môn học", "Tác giả", "Tổng số"});
		dm.addRow(new String[] { "Môn học", "Tác giả", "Tổng số"});
		dm.addRow(new String[] {"Môn học", "Tác giả", "Tổng số"});
		
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
		thoat.addActionListener(eventExit);
		them.addActionListener(eventAdd);
		
	}
		ActionListener eventExit = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
				
			}
			
		};
		ActionListener eventAdd = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String ma = select + maSV.getText();
				String ten = tenSV.getText();
				String tuoi = tuoiSV.getText();
				dm.addRow(new String[] {ma,ten,tuoi});
				table = new JTable(dm);
				sp=new JScrollPane(table);
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
