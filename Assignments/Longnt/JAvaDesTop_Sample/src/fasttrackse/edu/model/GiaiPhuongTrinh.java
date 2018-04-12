package fasttrackse.edu.model;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
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
public class GiaiPhuongTrinh extends JFrame {
	private JTextField HeSoA = new JTextField(15);
	private JTextField HeSoB = new JTextField(15);
	private JTextField resuilt = new JTextField(15);
	private JButton Calc = new JButton("Calc");
	private JButton Exit = new JButton("Exit");
	private JButton Help = new JButton("Help");
		public GiaiPhuongTrinh(String tieude)
		{
					super(tieude);
					addControls();
					addEvents();
		}
		
		public void addControls()
		{
			Container con=getContentPane();
			JPanel pnBox=new JPanel();
			pnBox.setLayout(new BoxLayout(pnBox, BoxLayout.Y_AXIS));
			JLabel lbl=new JLabel("Giải Phương trình bậc 1");
			lbl.setForeground(Color.BLUE);		
			Font font=new Font("Arial", Font.BOLD,15);
			lbl.setFont(font);
			
			JPanel pnBoxtieude=new JPanel();
			pnBoxtieude.setBackground(Color.RED);
			pnBoxtieude.add(lbl);
			pnBox.add(pnBoxtieude);

			
			JPanel pnbox1=new JPanel();
			pnbox1.setLayout(new FlowLayout());
			JLabel lbbox1=new JLabel("Hệ số a :");		
			pnbox1.add(lbbox1);
			pnbox1.add(HeSoA);
			pnBox.add(pnbox1);
			
			JPanel pnbox2=new JPanel();
			pnbox2.setLayout(new FlowLayout());
			JLabel lbbox2=new JLabel("Hệ số b :");		
			pnbox2.add(lbbox2);
			pnbox2.add(HeSoB);
			pnBox.add(pnbox2);
			
			JPanel pnbox3=new JPanel();
			pnbox3.setLayout(new FlowLayout());				
			pnbox3.add(Calc);
			pnbox3.add(Exit);
			pnbox3.add(Help);
			pnBox.add(pnbox3);
			
			JPanel pnbox4=new JPanel();
			pnbox4.setLayout(new FlowLayout());
			JLabel lblbox4=new JLabel("Kết quả :");		
			pnbox4.add(lblbox4);
			pnbox4.add(resuilt);
			pnBox.add(pnbox4);
			
			con.add(pnBox);
		}
		public void addEvents() {
		Calc.addActionListener(eventCalc);
		Exit.addActionListener(eventExit);
		Help.addActionListener(eventHelp);
		}
		ActionListener eventCalc = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String hesoA=HeSoA.getText();
				String hesoB=HeSoB.getText();
				if(hesoA.isEmpty()) {
					String msg = "Chưa nhập hệ số A";
					JOptionPane.showMessageDialog(null, msg, "Lỗi Chưa Nhập", JOptionPane.INFORMATION_MESSAGE);
				} else { 
			      try { 
					Float.parseFloat(hesoA);		           
		        } 
			      catch (Exception ex) { 
		        	String msg = "Hệ Số A phải là số";
					JOptionPane.showMessageDialog(null, msg, " Sai Định Dạng", JOptionPane.INFORMATION_MESSAGE); 
		        }
				}
				if(hesoB.isEmpty()) {
					String msg = "Chưa nhập hệ số B";
					JOptionPane.showMessageDialog(null, msg, "Lỗi Chưa Nhập", JOptionPane.INFORMATION_MESSAGE);
				} else {
				try { 
					Float.parseFloat(hesoB);		           
		        } catch (Exception ex) { 
		        	String msg = "Hệ Số B phải là số";
					JOptionPane.showMessageDialog(null, msg, " Sai Định Dạng", JOptionPane.INFORMATION_MESSAGE); 
		        }
			    }
			try {					
				float a = Float.parseFloat(hesoA);
				float b = Float.parseFloat(hesoB);
				
				String x;
				if (a == 0) {
				if (b == 0) {
						x = "Phương trình có vô số nghiệm";
				} 
				else {
						x = "Phương trình vô nghiệm";
				}
				}  
				else {
					x = Float.toString(-b / a);
				}
				resuilt.setText(x);
			    }catch(Exception ex){
				
			}
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
				String Helpme = "Phương trình bậc nhất 1 ẩn có dạng" + "ax + b =0" + "để tìm nghiệm của bài toán nhất Calc" + "nhấn Exit để thoát";
						JOptionPane.showMessageDialog(null, Helpme, " ", JOptionPane.INFORMATION_MESSAGE); 		
				
			}
		};	
		public void showWindow()
		{
			this.setSize(600, 400);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setLocationRelativeTo(null);
			this.setVisible(true);
		}
	}

