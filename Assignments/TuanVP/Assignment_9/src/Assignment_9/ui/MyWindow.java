package Assignment_9.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyWindow extends JFrame {
	public String kq;
	private JTextField result = new JTextField(20);
	private JTextField pnAText = new JTextField(20);
	private JTextField pnBText = new JTextField(20);
	private JButton btn1,btn2,btn3;;
	public MyWindow(String tille) {
		super(tille);
		addControls();
		addEvents();
		
	}
	private void addControls() {
		Container con=getContentPane();
		
		JPanel pnBoxLayout=new JPanel();
		pnBoxLayout.setLayout(new BoxLayout(pnBoxLayout,BoxLayout.Y_AXIS));
		
		
		JPanel pnTille = new JPanel();
		JLabel pnTilleLabel = new JLabel("Giai phuong trinh bac nhat");
		Font font = new Font("Arial", Font.BOLD, 20);
		pnTilleLabel.setFont(font);
		pnTilleLabel.setForeground(Color.BLUE);
		pnTille.setBackground(Color.RED);
		pnTille.add(pnTilleLabel);
		
		
		JPanel pnHeSoA = new JPanel();
		JLabel pnALabel = new JLabel("He So A");
		pnHeSoA.add(pnALabel);
		pnHeSoA.add(pnAText);
		
		
		JPanel pnHeSoB = new JPanel();
		JLabel pnBLabel = new JLabel("He So B");
		pnHeSoB.add(pnBLabel);
		pnHeSoB.add(pnBText);
		 

		JPanel pnAction = new JPanel();
		btn1 = new JButton("Calc");
		btn2 = new JButton("Help");
		btn3 = new JButton("Exit");
		pnAction.add(btn1);
		pnAction.add(btn2);
		pnAction.add(btn3);
		
		
		JPanel pnResult = new JPanel();
		JLabel pnRLabel = new JLabel("Ket Qua: ");
		result.setEditable(false);
		pnResult.add(pnRLabel);
		pnResult.add(result);
		
		
		pnBoxLayout.add(pnTille);
		pnBoxLayout.add(pnHeSoA);
		pnBoxLayout.add(pnHeSoB);
		pnBoxLayout.add(pnAction);
		pnBoxLayout.add(pnResult);
		con.add(pnBoxLayout);
	}
	private void addEvents() {
		btn1.addActionListener(calc);
		btn2.addActionListener(help);
		btn3.addActionListener(exit);
	}
	ActionListener calc = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			int a = Integer.parseInt(pnAText.getText());
			int b = Integer.parseInt(pnBText.getText());
			if (a==0) {
				if (b==0) {
					result.setText("Pt co vo so nghiem!");
				} else {
					result.setText("Pt vo nghiem!");
				}
			} else {
				result.setText("Pt co nghiem duy nhat x = "+ (-b/a));
			}
		}
	};
	ActionListener help = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	};
ActionListener exit = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
			
		}
	};
	public void showWindow()
	{
		this.setSize(400, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
