package giaiptb1.ui;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;

public class giaiptbac1 extends JFrame {
	private int a;
	private int b;
	JTextField txtResult;

	public giaiptbac1(String title) {
		super(title);
		addControls();
	}

	public giaiptbac1(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}

	public int getA() {
		return a;
	}

	public int getB() {
		return b;
	}

	public void setA(int a) {
		this.a = a;
	}

	public void setB(int b) {
		this.b = b;
	}

	public double giai() {
		return (-(double) this.b / this.a);
	}

	public void addControls() {
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		JPanel pnTitle = new JPanel();
		pnTitle.setBackground(Color.RED);
		JLabel lblTitle = new JLabel("Giai phuong trinh bac 1");
		lblTitle.setForeground(Color.BLUE);
		Font fontTitle = new Font("arial", Font.BOLD, 20);
		lblTitle.setFont(fontTitle);
		pnTitle.add(lblTitle);

		JPanel pnInput1 = new JPanel();
		JLabel lblTitle1 = new JLabel("Nhap he so a:");
		JTextField txtHeSoA = new JTextField(20);
		pnInput1.add(lblTitle1);
		pnInput1.add(txtHeSoA);

		JPanel pnInput2 = new JPanel();
		JLabel lblTitle2 = new JLabel("Nhap he so b:");
		JTextField txtHeSoB = new JTextField(20);
		pnInput2.add(lblTitle2);
		pnInput2.add(txtHeSoB);

		JPanel pnAction = new JPanel();
		pnAction.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 30));
		JButton btnCalc = new JButton("Calculate");
		btnCalc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = Integer.parseInt(txtHeSoA.getText());
				int b = Integer.parseInt(txtHeSoB.getText());
				if (a == 0 && b == 0) {
					JOptionPane.showMessageDialog(null, "phuong trinh vo so nghiem");
				} else if (a == 0 && b != 0) {
					JOptionPane.showMessageDialog(null, "phuong trinh vo nghiem");
				} else {
					giaiptbac1 ass = new giaiptbac1(a, b);

					txtResult.setText("x = " + String.valueOf(ass.giai()));
				}
			}
		});
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JButton btnHelp = new JButton("Help");
		
		pnAction.add(btnCalc);
		pnAction.add(btnExit);
		pnAction.add(btnHelp);

		JPanel pnResult = new JPanel();
		JLabel lblTitleResult = new JLabel("Nghiem Phuong Trinh: ");
		txtResult = new JTextField(20);
		pnResult.add(lblTitleResult);
		pnResult.add(txtResult);
		pnMain.add(pnTitle);
		pnMain.add(pnInput1);
		pnMain.add(pnInput2);
		pnMain.add(pnAction);
		pnMain.add(pnResult);

		con.add(pnMain);
	}

	public void showWindow() {
		this.setSize(600, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}