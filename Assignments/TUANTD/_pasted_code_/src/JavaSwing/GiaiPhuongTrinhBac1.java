package JavaSwing;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;

public class GiaiPhuongTrinhBac1 implements ActionListener {
	JTextField a, b, x;
	JLabel lblInputA, lblInputB, lblX, header, check_a, check_b;
	JButton submit, exit, help;

	GiaiPhuongTrinhBac1() {
		JFrame f = new JFrame("Gi?i ph??ng trình b?c 1 - JunBjn");
		a = new JTextField();
		a.setBounds(100, 50, 140, 20);
		b = new JTextField();
		b.setBounds(100, 100, 140, 20);
		x = new JTextField();
		x.setBounds(100, 210, 140, 20);
		x.setEditable(false);
		f.getContentPane().add(a);
		f.getContentPane().add(b);
		f.getContentPane().add(x);
		f.setSize(300, 300);
		f.getContentPane().setLayout(null);

		lblInputA = new JLabel("H? s? a:");
		lblInputA.setBounds(40, 50, 46, 14);
		f.getContentPane().add(lblInputA);

		lblInputB = new JLabel("H? s? b:");
		lblInputB.setBounds(40, 100, 46, 14);
		f.getContentPane().add(lblInputB);

		lblX = new JLabel("K?t qu?:");
		lblX.setBounds(40, 213, 42, 14);
		f.getContentPane().add(lblX);

		header = new JLabel("GI?I PH??NG TRÌNH ax + b = 0");
		header.setFont(new Font("Tahoma", Font.BOLD, 12));
		header.setForeground(new Color(0, 0, 255));
		header.setBackground(UIManager.getColor("Button.background"));
		header.setBounds(40, 11, 200, 20);
		f.getContentPane().add(header);

		check_a = new JLabel("Vui lòng nh?p s?!");
		check_a.setForeground(new Color(255, 0, 0));
		check_a.setBackground(UIManager.getColor("Button.background"));
		check_a.setBounds(100, 69, 140, 20);
		check_a.setVisible(false);
		f.getContentPane().add(check_a);

		check_b = new JLabel("Vui lòng nh?p s?!");
		check_b.setForeground(new Color(255, 0, 0));
		check_b.setBackground(UIManager.getColor("Button.background"));
		check_b.setBounds(100, 119, 140, 20);
		check_b.setVisible(false);
		f.getContentPane().add(check_b);

		submit = new JButton("Gi?i");
		submit.setBounds(40, 157, 60, 30);
		submit.addActionListener(new SubmitListener());
		f.getContentPane().add(submit);

		exit = new JButton("Thoát");
		exit.setMargin(new Insets(2, 4, 2, 4));
		ImageIcon icon = new ImageIcon(GiaiPhuongTrinhBac1.class.getResource("/JavaSwing/exit.png"));
		Image img = icon.getImage();
		Image newimg = img.getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(newimg);
		exit.setIcon(icon);
		exit.setBounds(105, 157, 70, 30);
		exit.addActionListener(new ExitListener());
		f.getContentPane().add(exit);

		help = new JButton("Help");
		help.setBounds(180, 157, 60, 30);
		help.addActionListener(new HelpListener());
		f.getContentPane().add(help);
		f.setVisible(true);
	}

	private class SubmitListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String s1 = a.getText();
			String s2 = b.getText();
			boolean check_s1 = checkFloat(s1);
			if (check_s1) {
				check_a.setVisible(false);
			} else {
				check_a.setVisible(true);
			}
			boolean check_s2 = checkFloat(s2);
			if (check_s2) {
				check_b.setVisible(false);
			} else {
				check_b.setVisible(true);
			}
			String result = "";
			if (check_s1 && check_s2) {
				float a = Float.parseFloat(s1);
				float b = Float.parseFloat(s2);
				float c = 0;
				if (e.getSource() == submit) {
					if (a == 0 && b == 0) {
						result = "Vô s? nghi?m!";
					} else if (a == 0 && b != 0) {
						result = "Vô nghi?m!";
					} else {
						c = -b / a;
						result = "x = " + String.valueOf(c);
					}
				}
			}
			x.setText(result);
		}
	}

	private class ExitListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}

	private class HelpListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JFrame helpFrame = new JFrame("Help");
			helpFrame.setBounds(40, 75, 215, 110);

			JPanel helpPanel = new JPanel();
			helpPanel.setBackground(Color.white);
			JLabel msglabel = new JLabel("JunBjn", JLabel.CENTER);

			helpPanel.add(msglabel);
			helpFrame.getContentPane().add(helpPanel);
			helpFrame.setVisible(true);
		}
	}

	public boolean checkFloat(String n) {
		try {
			Float.parseFloat(n);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static void setSystemLookAndFeel() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
		}
	}

	public static void main(String[] args) {
		setSystemLookAndFeel();
		new GiaiPhuongTrinhBac1();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
}