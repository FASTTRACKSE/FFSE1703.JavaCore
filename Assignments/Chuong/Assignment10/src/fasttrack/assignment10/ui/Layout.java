package fasttrack.assignment10.ui;

import fasttrack.assignment10.model.*;
import java.util.ArrayList;
import java.io.File;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;


import java.util.ArrayList;
public class Layout extends JFrame {
	
	private JTextField txtMaSv,txtTenSv,txtTuoiSv;
	private JButton btnAdd,btnEdit,btnDelete,btnExit,btnSubmit;
	String[] items = {"Tất cả","FFSE1701", "FFSE1702", "FFSE1703", "FFSE1704"};
	JComboBox<String> cbbClass = new JComboBox<>(items);
	String[] col = {"Mã Sinh Viên","Tên Sinh Viên","Tuổi Sinh Viên"};
    DefaultTableModel list = new DefaultTableModel(col, 0);
	public static ArrayList<SinhVien> arrSv=new ArrayList<SinhVien>();
	String chooseClass="Tất cả";
	final JTable tbl=new JTable(list);		
	JScrollPane sc=new JScrollPane(tbl);
	int stt=0;
	public Layout(String title)
	{
		super(title);
		addControls();
		addEvent();
	}

	private void addControls() {
		// TODO Auto-generated method stub
		Container con=getContentPane();
		JPanel pnMain=new JPanel();
		
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		
		JLabel lbltitle=new JLabel("Chương Trình Quản Lý Sinh Viên");
		Font font=new Font("Arial", Font.BOLD,20);
		lbltitle.setFont(font);
		JPanel pnMainTitle=new JPanel();
		pnMainTitle.add(lbltitle);
		pnMain.add(pnMainTitle);
		
		JPanel pnMainContent1=new JPanel();
		pnMainContent1.setLayout(new FlowLayout());
		JLabel lblContent1=new JLabel("Chọn Lớp:       ");		
		pnMainContent1.add(lblContent1);
		
		add(cbbClass);
		pnMainContent1.add(cbbClass);
		pnMain.add(pnMainContent1);
		
		JPanel pnMainContent2=new JPanel();
		pnMainContent2.setLayout(new FlowLayout());
		JLabel lblContent2=new JLabel("Mã Sinh Viên:    ");		
		pnMainContent2.add(lblContent2);
		txtMaSv = new JTextField(25);
		pnMainContent2.add(txtMaSv);
		pnMain.add(pnMainContent2);
		
		JPanel pnMainContent3=new JPanel();
		pnMainContent3.setLayout(new FlowLayout());
		JLabel lblContent3=new JLabel("Tên Sinh Viên:   ");		
		pnMainContent3.add(lblContent3);
		txtTenSv = new JTextField(25);
		pnMainContent3.add(txtTenSv);
		pnMain.add(pnMainContent3);
		
		JPanel pnMainContent4=new JPanel();
		pnMainContent4.setLayout(new FlowLayout());
		JLabel lblContent4=new JLabel("Tuổi Sinh Viên:  ");		
		pnMainContent4.add(lblContent4);
		txtTuoiSv = new JTextField(25);
		pnMainContent4.add(txtTuoiSv);
		pnMain.add(pnMainContent4);
		
		JPanel pnMainContent5=new JPanel();
		pnMainContent5.setLayout(new FlowLayout());	
		btnAdd =new JButton("Thêm");
		btnEdit =new JButton("Sửa");
		btnDelete =new JButton("Xóa");
		btnExit =new JButton("Thoát");
		btnSubmit =new JButton("Nhập");
		pnMainContent5.add(btnAdd);
		pnMainContent5.add(btnEdit);
		pnMainContent5.add(btnDelete);
		pnMainContent5.add(btnExit);
		pnMainContent5.add(btnSubmit);
		pnMain.add(pnMainContent5);
		
		JPanel pnMainContent6=new JPanel();
		Border border=
				BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle=
				BorderFactory.createTitledBorder(
				border, "Danh sách");

		pnMainContent6.setBorder(borderTitle);
		
		
		pnMainContent6.setLayout(new BorderLayout());
		pnMainContent6.add(sc,BorderLayout.CENTER);
		
		pnMain.add(pnMainContent6);
		
		
		
		con.add(pnMain);			
	}
	
	public void addEvent() {
		btnAdd.addActionListener(eventAdd);
		//btnEdit.addActionListener(eventEdit);
		//btnDelete.addActionListener(eventDelete);
		//btnExit.addActionListener(eventExit);
		//btnSubmit.addActionListener(eventSubmit);
	}
	ActionListener eventAdd = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String maSv = txtMaSv.getText();
			String tenSv = txtTenSv.getText();
			String tuoiSv = txtTuoiSv.getText();
			
			if(maSv.isEmpty()) {
				txtMaSv.requestFocus();
				String click = "Chưa nhập mã sinh viên";
				JOptionPane.showMessageDialog(null, click, "Lỗi chưa nhập", JOptionPane.INFORMATION_MESSAGE);
			}else {
				try {
					Float.parseFloat(maSv);
				} catch	 (Exception ex) {
					txtMaSv.requestFocus();
					String click = "Mã số sinh viên";
					JOptionPane.showMessageDialog(null, click, "Mã sinh viên đã nhập", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
};

	
	public void showWindow() {
		this.setSize(600, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}