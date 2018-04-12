package ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyUi extends JFrame {
	private JTextField text1, text2, text3;
	private JButton calc, help, exit;
	
	
	public MyUi() {
		super();
	}
	
	public MyUi(String title) {
		super(title);
		addControls();
		addEvents();
	}
	
	public void addControls() {
		Container con = getContentPane();
		JPanel boxMain = new JPanel();
		boxMain.setLayout(new BoxLayout(boxMain, BoxLayout.Y_AXIS));
		
		JPanel box1 = new JPanel();
		JLabel lb1 = new JLabel("Giải Phương Trình Bậc 1");
		Font font = new Font("Arial", Font.BOLD,30);
		lb1.setFont(font);
		lb1.setForeground(Color.BLUE);
		box1.setBackground(Color.RED);
		box1.add(lb1);
		
		JPanel box2 = new JPanel();
		JLabel lb2 = new JLabel("Hệ số a: ");
		text1 = new JTextField(20);
		Font font1 = new Font("Arial", Font.BOLD,20);
		lb2.setFont(font1);
		box2.add(lb2);
		box2.add(text1);
		
		JPanel box3 = new JPanel();
		JLabel lb3 = new JLabel("Hệ số b: ");
		 text2 = new JTextField(20);
		Font font2 = new Font("Arial", Font.BOLD,20);
		lb3.setFont(font2);
		box3.add(lb3);
		box3.add(text2);
		
		JPanel box4 = new JPanel();
		JPanel flow = new JPanel();
		flow.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
	    calc = new JButton("Calc");
		exit = new JButton("Exit");
		help = new JButton("Help");
		flow.add(calc);
		flow.add(exit);
		flow.add(help);
		box4.add(flow);
		
		JPanel box5 = new JPanel();
		JLabel lb5 = new JLabel("Kết Quả: ");
		text3 = new JTextField(20);
		text3.setEditable(false);
		Font font3 = new Font("Arial", Font.BOLD,20);
		lb5.setFont(font3);
		box5.add(lb5);
		box5.add(text3);
		
		
		
		boxMain.add(box1);
		boxMain.add(box2);
		boxMain.add(box3);
		boxMain.add(box4);
		boxMain.add(box5);
		
		con.add(boxMain);
	}
	
	public void addEvents() {
		calc.addActionListener(eventCalc);
		help.addActionListener(eventHelp);
		exit.addActionListener(eventExit);
	}
	
	
	// 	EVENT CALC
	ActionListener eventCalc = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String heSoA = text1.getText();
			String heSoB = text2.getText();
			
			if(heSoA.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Chưa nhập hệ số a!");
			} else {
				try {
				Double.parseDouble(heSoA);
				} catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Hệ số a phải nhập dạng số!");
				}
			}
			
			
			
			if(heSoB.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Chưa nhập hệ số b!");
			} else {
				try {
				Double.parseDouble(heSoB);
			} catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "Hệ số b phải nhập dạng số!");
				}
			}
			
			
			try {
			double a = Double.parseDouble(heSoA);
			double b = Double.parseDouble(heSoB);
			String x = null;
			
			if(a == 0) {
				if(b == 0) {
					x = "Phương trình có vô số nghiệm!";
				} else if(b != 0) {
					x = "Phương trình vô nghiệm";
				}
			} else if(a != 0) {
				x = Double.toString(-b/a);
			}
			
			text3.setText(x);
			} catch (Exception ex) {
			
			}
		}
	};
	
	
	// EVENT HELP
	ActionListener eventHelp = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String mes = "Giải phương trình bậc nhất: ax + b = 0 \n"
					+ "Nhấn Calc để xem kết quả \n"
					+ "Nhấn Exit để thoát chương trình \n"
					+ "<<<< Develope by QuyPham >>>>";
			JOptionPane.showMessageDialog(null, mes);
			
		}
	};
	
	
	//    EVENT EXIT
	ActionListener eventExit = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
			
		}
	};
	
	
	public void showWindown() {
		this.setSize(600,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
