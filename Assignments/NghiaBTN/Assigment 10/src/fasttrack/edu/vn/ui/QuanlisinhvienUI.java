package fasttrack.edu.vn.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class QuanlisinhvienUI extends JFrame {
	
	private JTextField txtMaSV = new JTextField(15);
	private JTextField txtTenSV = new JTextField(15);
	private JTextField txtTuoiSV = new JTextField(15);
	private JButton btnThem = new JButton("Thêm");
	private JButton btnSua = new JButton("Sửa");
	private JButton btnXoa = new JButton("Xóa");
	private JButton btnThoat = new JButton("Thoát");
	private JButton btnNhap = new JButton("Nhập");
	String[]arr = {"Tất cả","FFSE1701","FFSE1702","FFSE1703","FFSE1704"};
	JComboBox cbo=new JComboBox(arr);
	public QuanlisinhvienUI(String title) {
		super(title);
		addControls();
		addEvents();
	}
	public void addControls() {
		Container con=getContentPane();
		JPanel pnMain=new JPanel();
		
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		
		JLabel lbl=new JLabel("Chương Trình Quản Lí Sinh Viên");
		lbl.setForeground(Color.BLUE);
		Font font=new Font("Arial",Font.BOLD,20);
		lbl.setFont(font);
		JPanel pnMainTitle=new JPanel();
		pnMainTitle.add(lbl);
		pnMain.add(pnMainTitle);
		
		
		
		JPanel pnMainContent1=new JPanel();
		pnMainContent1.setLayout(new FlowLayout());
		JLabel lblContent1=new JLabel(" Mã Sinh viên:  ");
		pnMainContent1.add(lblContent1);
		pnMainContent1.add(txtMaSV);
		pnMain.add(pnMainContent1);
		
		JPanel pnMainContent2=new JPanel();
		pnMainContent2.setLayout(new FlowLayout());
		JLabel lblContent2=new JLabel("Tên Sinh Viên: ");
		pnMainContent2.add(lblContent2);
		pnMainContent2.add(txtTenSV);
		pnMain.add(pnMainContent2);
		
		JPanel pnMainContent3=new JPanel();
		pnMainContent3.setLayout(new FlowLayout());
		JLabel lblContent3=new JLabel("     Tuổi:            ");
		pnMainContent3.add(lblContent3);
		pnMainContent3.add(txtTuoiSV);
		pnMain.add(pnMainContent3);
		
		JPanel pnMainContent4=new JPanel();
		pnMainContent4.setLayout(new FlowLayout());
		pnMainContent4.add(btnThem);
		pnMainContent4.add(btnSua);
		pnMainContent4.add(btnXoa);
		pnMainContent4.add(btnThoat);
		pnMainContent4.add(btnNhap);
		pnMain.add(pnMainContent4);
		
		con.add(pnMain);
		
	}
	
	public void addEvents() {
		
	}
	public void showWindow() {
		this.setSize(410, 265);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
