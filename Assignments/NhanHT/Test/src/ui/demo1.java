package ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class demo1 extends JFrame{
	public demo1() {
		super();
	}
	public demo1(String title) {
		super(title);;
		addControls();
		
	}
	public void showWindow() {
		this.setSize(600, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	public void addControls() {
		JTabbedPane myTabled=new JTabbedPane();
		JPanel pnTab1=new JPanel();
		JPanel box1=new JPanel();
		JPanel box2=new JPanel();
		pnTab1.add(new JButton("Tabbed 1"));

		
		pnTab1.setLayout(new BoxLayout(pnTab1, BoxLayout.Y_AXIS));
		JLabel lblTen=new JLabel("Nhập tên:");
		JTextField txtTen=new JTextField(15);
		box1.add(lblTen);
		box1.add(txtTen);
		JLabel lblTen1=new JLabel("Nhập tên:");
		JTextField txtTen1=new JTextField(15);
		box2.add(lblTen1);
		box2.add(txtTen1);
		pnTab1.add(box1);
		pnTab1.add(box2);
		//
		JPanel pnTab2=new JPanel();
		pnTab2.setBackground(Color.BLACK);
		pnTab2.add(new JButton("Tabbed 2"));
		JPanel pnTab3=new JPanel();
		pnTab3.setBackground(Color.BLACK);
		myTabled.add(pnTab1,"Tab1");
		myTabled.add(pnTab2,"Tab2");
		myTabled.add(pnTab3,"Tab3");
		
		Container con=getContentPane();
		con.add(myTabled);
	}
}
