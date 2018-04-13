package assignment11.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GiaoDien extends JFrame {
	JTextField txtHeSoA, txtHeSoB, txtKetQua;
	JButton btnTinh, btnThoat, btnTroGiup;
	public GiaoDien(String tieude) {
		super(tieude);
		addControls();
		addEvents();
	}

	

	private void addControls() {
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		JPanel pn1 = new JPanel();
		JLabel lbl1 = new JLabel("Giai Phuong Trinh");
		Font font = new Font("Arial",Font.BOLD, 20);
		pn1.setBackground(Color.RED);
		lbl1.setFont(font);
		pn1.add(lbl1);
		
		JPanel pn2 = new JPanel();
		JLabel lbl2 = new JLabel("He so a: ");
		pn2.add(lbl2);
		txtHeSoA = new JTextField(15);
		pn2.add(txtHeSoA);
		
		JPanel pn3 = new JPanel();
		JLabel lbl3 = new JLabel("He so b: ");
		pn3.add(lbl3);
		txtHeSoB = new JTextField(15);
		pn3.add(txtHeSoB);
		
		JPanel pn4 = new JPanel();
		btnTinh = new JButton("Calc");
		pn4.add(btnTinh);
		btnThoat = new JButton("Exit");
		pn4.add(btnThoat);
		btnTroGiup = new JButton("Help");
		pn4.add(btnTroGiup);
		
		JPanel pn5 = new JPanel();
		JLabel lbl4 = new JLabel("Ket qua: ");
		pn5.add(lbl4);
		txtKetQua = new JTextField(15);
		pn5.add(txtKetQua);
		
		
		pnMain.add(pn1);
		pnMain.add(pn2);
		pnMain.add(pn3);
		pnMain.add(pn4);
		pnMain.add(pn5);
		
		con.add(pnMain);
	}
	private void addEvents() {
		btnTinh.addActionListener(eventTinh);
		btnThoat.addActionListener(eventThoat);
		btnTroGiup.addActionListener(eventTroGiup);
		
	}
	ActionListener eventTinh = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			try {
				String a = txtHeSoA.getText();
				String b = txtHeSoB.getText();
				float soA = Float.parseFloat(a);
				float soB = Float.parseFloat(b);
				String x;
				if(soA ==0) {
					if(soB == 0) {
						x = "Phương Trình Vô Số Nghiệm";
					}else {
						x = "Phương Trình Vô Nghiệm";
					}
				}else {
					x = Float.toString(-soB/soA);
				}
				txtKetQua.setText(x);
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Nhập sai vui lòng kiểm tra", "Lỗi", JOptionPane.INFORMATION_MESSAGE);
			}
			
		}
	};
	ActionListener eventThoat = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.exit(0);
		}
	};
	ActionListener eventTroGiup = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JOptionPane.showMessageDialog(null, "Giai Phuong Trinh Bac 1\n có dạng ax + b = 0 \n "
					+ "nhập hệ số a và b để tính \n"
					+ "nhấn Calc để xem kết quả", "Hướng Dẫn", JOptionPane.INFORMATION_MESSAGE);
		}
	};
	public void Window() {
		this.setSize(500,400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
