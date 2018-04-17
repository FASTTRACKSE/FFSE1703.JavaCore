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
			double delta = (b*b)-(4*(a*c));
			if(delta < 0) {
				
				String x = ("Phuong trinh vo nghiem !");
				ketQua.setText(x);
			}
			else if(delta > 0) {
				double x1 = (-b+(Math.sqrt(delta))/2*a);
				double x2 = (-b-(Math.sqrt(delta))/2*a);
				String ketqua=("Phuong trinh co nghiem x1 : "+x1+"Phuong trinh co nghiem x2 : "+x2);
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
		JPanel pnBox1,pnBox2,pnBox3,pnFlow4,pnBorder5;
		Container con = getContentPane();
		pnBox1 = new JPanel();
		pnBox1.setLayout(new BoxLayout(pnBox1,BoxLayout.Y_AXIS));
		pnBox2 = new JPanel();
		pnBox2.setLayout(new BoxLayout(pnBox2,BoxLayout.Y_AXIS));
		pnBox3 = new JPanel();
		pnBox3.setLayout(new BoxLayout(pnBox3,BoxLayout.Y_AXIS));
		pnFlow4 = new JPanel();
		pnFlow4.setLayout(new FlowLayout());
		pnBorder5 = new JPanel();
		pnBorder5.setLayout(new BorderLayout());
		JPanel pnKetqua = new JPanel();
		pnBorder5.add(pnKetqua,BorderLayout.SOUTH);
		label1 = new JLabel("Xin moi nhap so a: ");
		soA = new JTextField();
		label2 = new JLabel("Xin moi nhap so b: ");
		soB = new JTextField();
		label3 = new JLabel("Xin moi nhap so c: ");
		soC = new JTextField();
		btn1 = new JButton("Calc");
		pnFlow4.add(btn1);
		btn2 = new JButton("Cancel");
		pnFlow4.add(btn2);
		pnKetqua.add(ketQua);
		pnBox1.add(label1);
		pnBox2.add(label2);
		pnBox3.add(label3);
		pnBox2.add(soB);
		pnBox3.add(soC);
		pnBox1.add(soA);
		
		pnBox1.add(pnBox2);
		pnBox1.add(pnBox3);
		pnBox1.add(pnFlow4);
		pnBox1.add(pnBorder5);
		con.add(pnBox1);
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
