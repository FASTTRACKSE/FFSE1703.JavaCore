package giaiphuongtrinh;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.lang.Math;

public class TinhPhuongTrinh extends JFrame{	
	JTextField soA,soB,soC;
	JButton btn1,btn2;
	JTextField ketQua=new JTextField(25);
	JLabel label1,label2,label3;
	public TinhPhuongTrinh() {
		super();
		addControls();
		addEvent();
	}
	public void myWindow() {
		this.setSize(600,400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setTitle("Phuong trinh bac 2");
		this.setVisible(true);
	}
	public void tinhPhuongTrinh(JTextField soA,JTextField soB,JTextField soC) {
		int a = Integer.parseInt(soA.getText());
		int b = Integer.parseInt(soB.getText());
		int c = Integer.parseInt(soC.getText());
		if(a==0) {
			if(b==0) {
				if(c==0) {
					String x =("Phuong trinh vo so nghiem");
					ketQua.setText(x);
				}
				else {
				String x=("phuong trinh vo nghiem");
				ketQua.setText(x);
				}
			}
			else {
				int x = -c/b;
				String ketqua=("phuong trinh co nghiem la : " + x);
				ketQua.setText(ketqua);
			}
		}
		else {
			int delta = (b*b)-(4*(a*c));
			if(delta < 0) {
				
				String x = ("Phuong trinh vo nghiem !");
				ketQua.setText(x);
			}
			else if(delta > 0) {
				int x1 = (int) (-b+(Math.sqrt(delta))/2*a);
				int x2 = (int) (-b-(Math.sqrt(delta))/2*a);
				String ketqua=("Phuong trinh co nghiem x1 : "+x1+"|Phuong trinh co nghiem x2 : "+x2);
				ketQua.setText(ketqua);
			}
			else {
				int x = -b/2*a;
				String ketqua=("Phuong trinh co nghiem kep la: "+x);
				ketQua.setText(ketqua);
			}
		}
	}
	public void addControls() {
		JPanel pnMain,pnBox2,pnFlow4,pnBorder5;
		Container con = getContentPane();
		pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain,BoxLayout.Y_AXIS));
		pnBox2 = new JPanel();
		pnBox2.setLayout(new BoxLayout(pnBox2,BoxLayout.Y_AXIS));
		pnFlow4 = new JPanel();
		pnFlow4.setLayout(new FlowLayout());
		pnBorder5 = new JPanel();
		pnBorder5.setLayout(new BorderLayout());
		pnBorder5.add(ketQua,BorderLayout.SOUTH);
		label1 = new JLabel("Xin moi nhap so a: ");
		label1.setForeground(Color.red);
		label1.setFont(new Font("Courier New", Font.BOLD ,12));
		soA = new JTextField(5);
		label2 = new JLabel("Xin moi nhap so b: ");
		label2.setForeground(Color.red);
		label2.setFont(new Font("Courier New", Font.BOLD ,12));
		soB = new JTextField(5);
		label3 = new JLabel("Xin moi nhap so c: ");
		label3.setForeground(Color.red);
		label3.setFont(new Font("Courier New", Font.BOLD ,12));
		soC = new JTextField(5);
		btn1 = new JButton("Calc");
		pnFlow4.add(btn1);
		btn2 = new JButton("Cancel");
		pnFlow4.add(btn2);
		pnBox2.add(label1);
		pnBox2.add(soA);
		pnBox2.add(label2);
		pnBox2.add(soB);
		pnBox2.add(label3);
		pnBox2.add(soC);
		pnMain.add(pnBox2);
		pnMain.add(pnFlow4);
		pnMain.add(pnBorder5);
		con.add(pnMain);
	}

	public void addEvent() {
		btn1.addActionListener(eventTinhPhuongTrinh);
		btn2.addActionListener(eventThoatPhuongTrinh);
	}
	ActionListener eventTinhPhuongTrinh = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			tinhPhuongTrinh(soA,soB,soC);
		}
	};
	ActionListener eventThoatPhuongTrinh = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			endProgram();
		}
	};
	public void endProgram() {
		System.exit(0);
	}
}
