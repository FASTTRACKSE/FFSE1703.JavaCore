package javadesktop.ui;
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
//
public class PhuongTrinh extends JFrame{
	JTextField txtHesoA=new JTextField(15);
	JTextField txtHesoB=new JTextField(15);
	JTextField txtKetQua=new JTextField(15);
	JButton btnCalc=new JButton("Calc");
	JButton btnExit=new JButton("Exit");
	JButton btnHelp=new JButton("Help");
	public PhuongTrinh(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		addControls();
		addEvents();
	}
	public void addControls()
	{
		Container con=getContentPane();
		JPanel Box=new JPanel();
		JPanel Box0=new JPanel();
		JPanel Box1=new JPanel();
		JPanel Box2=new JPanel();
		JPanel Box3=new JPanel();
		JPanel Box4=new JPanel();
		//
		Box.setLayout(new BoxLayout(Box, BoxLayout.Y_AXIS));
		//
		JLabel lblTen0=new JLabel("GIẢI PHƯƠNG TRÌNH BẬC 1");
		Font font =new Font("Arial", Font.BOLD, 40);
		lblTen0.setFont(font);
		lblTen0.setForeground(Color.BLUE);
		Box0.setBackground(Color.RED);
		Box0.add(lblTen0);
		// he so A
		JLabel lblHesoA=new JLabel("HỆ SỐ A: ");
		Box1.add(lblHesoA);
		Box1.add(txtHesoA);
		// he so B
		JLabel lblHesoB=new JLabel("HỆ SỐ B: ");
		Box2.add(lblHesoB);
		Box2.add(txtHesoB);
		// Button
		Box3.add(btnCalc);
		Box3.add(btnExit);
		Box3.add(btnHelp);
		// ket qua
		JLabel lblKetQua=new JLabel("KẾT QUẢ:");
		Box4.add(lblKetQua);
		Box4.add(txtKetQua);
		//
		Box.add(Box0);
		Box.add(Box1);
		Box.add(Box2);
		Box.add(Box3);
		Box.add(Box4);
		//
		con.add(Box);
		
		
		
	}
	public void showWindow()
	{
		this.setSize(600, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	private void addEvents () {
		btnCalc.addActionListener(btnCalc1);
		btnExit.addActionListener(btnExit1);
		btnHelp.addActionListener(btnHelp1);
	}
	ActionListener btnCalc1 = new ActionListener() {
		
		
		public void actionPerformed(ActionEvent e) {
			String HesoA = txtHesoA.getText();
			String HesoB = txtHesoB.getText();
			try {
				if(HesoA.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Chưa Nhập Hệ Số A");
				}else{
					Double.parseDouble(HesoA);
				}
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "Phải Nhập Số");
			}
			try {
				if(HesoB.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Chưa Nhập Hệ Số B");
				}else {
					Double.parseDouble(HesoB);
				}
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "Phải Nhập Số");
			}
			//
			try {
			double a = Double.parseDouble(HesoA);
				double b = Double.parseDouble(HesoB);
				String x;
				if (a == 0) {
					if(b == 0) {
						 x = "Phương trình có vô số nghiệm";
					}else {
						 x = "Phương trình vô nghiệm";
					}
				}else {
					x = Double.toString(-b/a);
				}
				txtKetQua.setText(x);
			}catch(Exception ex){
			
		}
		}
	};
	ActionListener btnExit1 = new ActionListener() {
		
		
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	};
	ActionListener btnHelp1 = new ActionListener() {
		
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String msg = "Nhấn Exit để thoát chương trình";
			JOptionPane.showMessageDialog(null, msg , "GIẢI PHƯƠNG TRÌNH BẬC 2",JOptionPane.INFORMATION_MESSAGE);
			
		}
	};
}
