package assignment9.java.ui;

import java.awt.Button;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PhuongTrinh extends JFrame {
	private JTextField txtHeSoA, txtHeSoB, comeOut;
	private JButton buttonCalc, buttonExit, buttonHelp;

	public PhuongTrinh(String tieude) {
		super(tieude);
		addControls();
		events();

	}

	public void addControls() {
		Container con = getContentPane();
		JPanel pnBox = new JPanel();

		pnBox.setLayout(new BoxLayout(pnBox, BoxLayout.Y_AXIS));
		// jpanel 1
		JPanel pnBox2 = new JPanel();
		pnBox2.setBackground(Color.RED);
		JLabel header = new JLabel(" Phương trình bậc nhất");
		

		pnBox2.add(header);
		// jpanel 2
		JPanel pnBox3 = new JPanel();
		JLabel name1 = new JLabel("Nhập số a: ");
		Font font1 = new Font("Arial", Font.BOLD, 25);
		name1.setFont(font1);
		txtHeSoA = new JTextField(20);
		pnBox3.add(name1);
		pnBox3.add(txtHeSoA);
		// jpanel 3
		JPanel pnBox4 = new JPanel();
		JLabel name2 = new JLabel("Nhập số b: ");

		name2.setFont(font1);
		txtHeSoB = new JTextField(20);
		pnBox4.add(name2);
		pnBox4.add(txtHeSoB);
		// JPANEL 4
		JPanel pnBox5 = new JPanel();

		buttonCalc = new JButton("Calc");
		buttonExit = new JButton("Exit");
		buttonHelp = new JButton("help");
		pnBox5.add(buttonCalc);
		pnBox5.add(buttonExit);
		pnBox5.add(buttonHelp);
		// jpanel 5
		JPanel pnBox6 = new JPanel();
		JLabel name3 = new JLabel("Kết Quả: ");
		name3.setFont(font1);
		comeOut = new JTextField(25);
		comeOut.setEditable(false);
		pnBox6.add(name3);
		pnBox6.add(comeOut);

		pnBox.add(pnBox2);
		pnBox.add(pnBox3);
		pnBox.add(pnBox4);
		pnBox.add(pnBox5);
		pnBox.add(pnBox6);

		con.add(pnBox);

	}

	public void events() {
		buttonCalc.addActionListener(eventCalc);
		buttonExit.addActionListener(eventExit);
		buttonHelp.addActionListener(eventHelp);
	}

	ActionListener eventCalc = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			String heSoA = txtHeSoA.getText();
			String heSoB = txtHeSoB.getText();
			try {
				if (heSoA.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Bạn chưa nhập hệ số A !!");
				} else {

					Double.parseDouble(heSoA);
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Bạn phải nhập số !!");
			}
			try {
				if (heSoB.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Bạn chưa nhập hệ số A !!");
				} else {

					Double.parseDouble(heSoB);
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Bạn phải nhập số !!");
			}
			try {
			String x;
			Double a = Double.parseDouble(heSoA);
			Double b = Double.parseDouble(heSoB);
			if (a == 0) {
				if (b == 0) {
					x = "phương trình có vô số nghiệm";

				} else {
					x = "phương trình vô nghiệm";
				}
			} else {
				x = Double.toString(-b / a);
			}
			comeOut.setText(x);

		}catch(Exception ex) {
			
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
			String msg = "Giải Phương trình bật nhất có dạng : " + "ax + b = 0\n"
					+ "Nhập vào hệ số a và b sau đó nhấn Calc để xem kết quả.\n" + "Nhấn Exit để thoát chương trình";
			JOptionPane.showMessageDialog(null, msg, "Hướng dẫn", JOptionPane.INFORMATION_MESSAGE);

		}
	};

	public void showWindow() {
		this.setSize(600, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
