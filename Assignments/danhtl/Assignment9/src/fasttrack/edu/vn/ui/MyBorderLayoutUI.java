package fasttrack.edu.vn.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class MyBorderLayoutUI extends JFrame {
	private JTextField txthesoA = new JTextField(15);
	private JTextField txthesoB = new JTextField(15);
	private JTextField resuilt = new JTextField(15);
	private JButton btnCalc = new JButton("Calc"); 
	private JButton btnExit = new JButton("Exit"); 
	private JButton btnHelp = new JButton("Help"); 
	public MyBorderLayoutUI(String tieude)
	{
		this.setTitle(tieude);
		addControls();
		addEvent();
	}
	public void addControls()
	{
		Container con=getContentPane();
		JPanel pnMain=new JPanel();
		
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		
		JLabel lbl=new JLabel("Giải Phương trình bậc 1");
		Font font=new Font("Arial", Font.BOLD,24);
		lbl.setFont(font);
		lbl.setForeground(Color.YELLOW);		
		JPanel Title=new JPanel();
		Title.setBackground(Color.PINK);
		Title.setPreferredSize(new Dimension(0, 30));
		Title.add(lbl);
		pnMain.add(Title,BorderLayout.NORTH);

		
		JPanel nhapa = new JPanel();
		nhapa.setLayout(new FlowLayout());
		JLabel lblHesoA= new JLabel("Hệ số a :");
		txthesoA = new JTextField(15);
		nhapa.add(lblHesoA);
		nhapa.add(txthesoA);
		pnMain.add(nhapa);
		
		JPanel nhapb = new JPanel();
		nhapb.setLayout(new FlowLayout());
		JLabel lblHesoB= new JLabel("Hệ số b :");
		txthesoB = new JTextField(15);
		nhapb.add(lblHesoB);
		nhapb.add(txthesoB);
		pnMain.add(nhapb);
		
		JPanel button = new JPanel();
		button.setLayout(new FlowLayout());
		button.add(btnCalc);
		button.add(btnExit);
		button.add(btnHelp);
		pnMain.add(button);
		
		JPanel ketqua = new JPanel();
		ketqua.setLayout(new FlowLayout());
		JLabel pnKetqua= new JLabel("Kết Quả :");
		ketqua.add(pnKetqua);
		ketqua.add(resuilt);
		pnMain.add(ketqua);
		
		con.add(pnMain);
	}
	
	public void addEvent() 
	{
		btnCalc.addActionListener(eventCalc);
		btnExit.addActionListener(eventExit);
		btnHelp.addActionListener(eventHelp);
		
	}
		
		ActionListener eventCalc = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String heSoA = txthesoA.getText();
				String heSoB = txthesoB.getText();
				
				double a = Double.parseDouble(heSoA);
				double b = Double.parseDouble(heSoB);
				
				String x;
				if (a == 0) {
					if (b == 0) {
						x = "Phương trình có vô số nghiệm";
					} else {
						x = "Phương trình vô nghiệm";
					}
				} else {
					x = Double.toString(-b / a);
				}
				resuilt.setText(x);
				
			}
			
		};
		ActionListener eventExit = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		};
		ActionListener eventHelp = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			}
			
		};
		
	
	

	
	public void showWindow()
	{
		this.setSize(500, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}