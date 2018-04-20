package assignment9.ui;

import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
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

public class DemoDesktop extends JFrame{
	private JTextField txtHeSoA = new JTextField(15);
	private JTextField txtHeSoB = new JTextField(15);
	private JTextField resuilt = new JTextField(15);
	private JButton btnCalc = new JButton("Calc");
	private JButton btnExit = new JButton("Exit");
	private JButton btnHelp = new JButton("Help");
	public DemoDesktop(String title)
	{
		super(title);
		addControls();
		addEvent();
		
	}
	
	
	public void addControls() {
		Container con=getContentPane();
		JPanel pnMain=new JPanel();
		
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		
		JLabel lbl=new JLabel("Giải Phương trình bậc 1");
		lbl.setForeground(Color.BLUE);		
		Font font=new Font("Arial", Font.BOLD,30);
		lbl.setFont(font);
		JPanel pnMainTitle=new JPanel();
		pnMainTitle.setBackground(Color.BLACK);
		pnMainTitle.add(lbl);
		pnMain.add(pnMainTitle);
		
		JPanel pnMainContent1=new JPanel();
		pnMainContent1.setLayout(new FlowLayout());
		JLabel lblContent1=new JLabel("Hệ số a :");		
		pnMainContent1.add(lblContent1);
		pnMainContent1.add(txtHeSoA);
		pnMain.add(pnMainContent1);
		
		JPanel pnMainContent2=new JPanel();
		pnMainContent2.setLayout(new FlowLayout());
		JLabel lblContent2=new JLabel("Hệ số b :");		
		pnMainContent2.add(lblContent2);
		pnMainContent2.add(txtHeSoB);
		pnMain.add(pnMainContent2);
		
		JPanel pnMainContent3=new JPanel();
		pnMainContent3.setLayout(new FlowLayout());				
		pnMainContent3.add(btnCalc);
		pnMainContent3.add(btnExit);
		pnMainContent3.add(btnHelp);
		pnMain.add(pnMainContent3);
		
		JPanel pnMainContent4=new JPanel();
		pnMainContent4.setLayout(new FlowLayout());
		JLabel lblContent4=new JLabel("Kết quả :");		
		pnMainContent4.add(lblContent4);
		pnMainContent4.add(resuilt);
		pnMain.add(pnMainContent4);
		
		con.add(pnMain);
	}
	
	public void addEvent() {
		btnCalc.addActionListener(eventCalc);
		btnExit.addActionListener(eventExit);
		btnHelp.addActionListener(eventHelp);
	     
	}
	ActionListener eventCalc = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String heSoA = txtHeSoA.getText();
			String heSoB = txtHeSoB.getText();				
           
			if(heSoA.isEmpty()) {
				txtHeSoA.requestFocus();
				String click = "Chưa nhập hệ số A";
				JOptionPane.showMessageDialog(null, click, "Lỗi Chưa Nhập", JOptionPane.INFORMATION_MESSAGE);
			}else {
				try { 
					Float.parseFloat(heSoA);		           
		        } catch (Exception ex) { 
		        	txtHeSoA.requestFocus();
		        	String click = "Hệ Số A phải Nhập số";
					JOptionPane.showMessageDialog(null, click, "Lỗi Nhập Sai Định Dạng", JOptionPane.INFORMATION_MESSAGE); 
		        }
			}
															
			if(heSoB.isEmpty()) {
				txtHeSoB.requestFocus();
				String click= "Chưa nhập hệ số B";
				JOptionPane.showMessageDialog(null, click, "Lỗi Chưa Nhập", JOptionPane.INFORMATION_MESSAGE);
			}else {
				try { 
					Float.parseFloat(heSoB);		           
		        } catch (Exception ex) {
		        	txtHeSoB.requestFocus();
		        	String click = "Hệ Số B phải Nhập số";
					JOptionPane.showMessageDialog(null, click, "Lỗi Nhập Sai Định Dạng", JOptionPane.INFORMATION_MESSAGE); 
		        }
			}
			
			try {					
				float a = Float.parseFloat(heSoA);
				float b = Float.parseFloat(heSoB);
				
				String x;
				if (a == 0) {
					if (b == 0) {
						x = "Phương trình có vô số nghiệm";
					} else {
						x = "Phương trình vô nghiệm";
					}
				} else {
					x = Float.toString(-b / a);
				}
				resuilt.setText(x);
			}catch(Exception ex){
				
			}
		}
	};
	
ActionListener eventExit = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
		System.exit(0);
		}
	};
	
ActionListener eventHelp = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String click = "Giải Phương trình bật nhất có dạng :\n"
					+ "ax + b = 0\n"+"Nhập vào hệ số a và b sau đó nhấn Calc để xem kết quả.\n"+
					"Nhấn Exit để thoát chương trình";
			JOptionPane.showMessageDialog(null, click, "Hướng dẫn", JOptionPane.INFORMATION_MESSAGE);
		}
	};
	
	
public void showWindow() {
	this.setSize(410, 265);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setLocationRelativeTo(null);
	this.setVisible(true);
}
}