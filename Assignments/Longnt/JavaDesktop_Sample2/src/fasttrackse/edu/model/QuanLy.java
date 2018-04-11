package fasttrackse.edu.model;
import fasttrackse.edu.main.*;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
public class QuanLy extends JFrame {
	private JTextField maSinhVien = new JTextField(25);
	private JTextField tenSinhVien = new JTextField(25);
	private JTextField tuoi = new JTextField(25);
	private JButton Them = new JButton("Thêm");
    private JButton Sua = new JButton("Sửa");
    private JButton Xoa = new JButton("Xóa");
    private JButton Thoat = new JButton("Thoát");
    private JButton Nhap = new JButton("Nhập");
    
	public QuanLy(String tieude)
	{
		this.setTitle(tieude);
		addControls();
		addEvent();
	}
	public void addControls()
	{
		Container con = getContentPane();
		JPanel jpan = new JPanel();
		jpan.setLayout(new BoxLayout(jpan, BoxLayout.Y_AXIS));
		JLabel lbl=new JLabel("Quan Ly Sinh Vien");
		lbl.setForeground(Color.BLACK);		
		Font font=new Font("Arial", Font.BOLD,15);
		lbl.setFont(font);
		
		JPanel jpan0=new JPanel();
		jpan0.add(lbl);
		jpan.add(jpan0);
		
		JPanel jpan1=new JPanel();
		jpan1.setLayout(new FlowLayout());
		JLabel lbbox1=new JLabel("Mã sinh viên :");		
		jpan1.add(lbbox1);
		jpan1.add(maSinhVien);
		jpan.add(jpan1);
		
		JPanel jpan2=new JPanel();
		jpan2.setLayout(new FlowLayout());
		JLabel lbbox2=new JLabel("Tên sinh viên :");		
		jpan2.add(lbbox2);
		jpan2.add(tenSinhVien);
		jpan.add(jpan2);
		
		JPanel jpan3=new JPanel();
		jpan3.setLayout(new FlowLayout());
		JLabel lbbox3=new JLabel("Tuổi");		
		jpan3.add(lbbox3);
		jpan3.add(tuoi);
		jpan.add(jpan3);
		
		JPanel jpan4=new JPanel();
		jpan4.setLayout(new FlowLayout());				
		jpan4.add(Them);
		jpan4.add(Sua);
		jpan4.add(Xoa);
		jpan4.add(Thoat);
		jpan.add(Nhap);
		jpan.add(jpan4);
		
		con.add(jpan);
		
	}
	public void addEvent() {
		
	}
	
	public void showWindow()
	{
		this.setSize(600, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
