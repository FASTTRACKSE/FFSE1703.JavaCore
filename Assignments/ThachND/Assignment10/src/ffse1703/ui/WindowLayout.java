package ffse1703.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

	public class WindowLayout extends JFrame{
	private JTextField txtMaSv, txtTenSv, txtTuoiSv ;
	private JButton btnAdd, btnEdit, btnDelete, btnExit, btnSubmit;
	String[] items = {"Tất cả","FFSE1701", "FFSE1702", "FFSE1703", "FFSE1704"};
	JComboBox<String> cbbClass = new JComboBox<>(items);
	String[] col = {"Mã Sinh Viên","Tên Sinh Viên","Tuổi Sinh Viên","Lớp"};
	public WindowLayout(String title) {
		super(title);
		addControls();
		
	}
	
	public void addControls()
	{
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		
		JLabel lbl=new JLabel("Chương Trình Quản Lý Sinh Viên");
		Font font=new Font("Arial", Font.BOLD,20);
		lbl.setFont(font);
		JPanel pnMainTitle=new JPanel();
		pnMainTitle.add(lbl);
		pnMain.add(pnMainTitle);
		
		JPanel pnMainContent1=new JPanel();
		pnMainContent1.setLayout(new FlowLayout());
		JLabel lblContent1=new JLabel("Chọn lớp:   ");		
		pnMainContent1.add(lblContent1);
		add(cbbClass);
		pnMainContent1.add(cbbClass);
		pnMain.add(pnMainContent1);
		
		JPanel pnMainContent2=new JPanel();
		pnMainContent2.setLayout(new FlowLayout());
		JLabel lblContent2=new JLabel("Mã Sinh Viên:  ");		
		pnMainContent2.add(lblContent2);
		txtMaSv = new JTextField(25);
		pnMainContent2.add(txtMaSv);
		pnMain.add(pnMainContent2);
		
		JPanel pnMainContent3=new JPanel();
		pnMainContent3.setLayout(new FlowLayout());
		JLabel lblContent3=new JLabel("Tên Sinh Viên:  ");		
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
		btnAdd = new JButton("Thêm");	
		btnEdit = new JButton("Sửa");
		btnDelete = new JButton("Xóa");
		btnExit = new JButton("Thoát");
		btnSubmit = new JButton("Nhập");
		pnMainContent5.add(btnAdd);
		pnMainContent5.add(btnEdit);
		pnMainContent5.add(btnDelete);
		pnMainContent5.add(btnExit);
		pnMainContent5.add(btnSubmit);
		pnMain.add(pnMainContent5);
		
		
		con.add(pnMain);
	}
	

	public void showWindow()
	{
		this.setSize(600, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}




