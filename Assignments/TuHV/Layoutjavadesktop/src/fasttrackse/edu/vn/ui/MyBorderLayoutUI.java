package fasttrackse.edu.vn.ui;

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

public class MyBorderLayoutUI extends JFrame {
	private JTextField txtHeSoa = new JTextField(15);
	private JTextField txtHeSob = new JTextField(15);
	private JTextField resuilt = new JTextField(15);
	private JButton btnCalc = new JButton("Calc");
	private JButton btnExit = new JButton("Exit");
	private JButton btnHelp = new JButton("Help");

	public MyBorderLayoutUI(String tieude) {
		super(tieude);
		addConTrols();
		addEvents();
	}

	public void addConTrols() {
		Container con = getContentPane();
		JPanel pnBorderLayout = new JPanel();

		pnBorderLayout.setLayout(new BoxLayout(pnBorderLayout, BoxLayout.Y_AXIS));
		JLabel lbl = new JLabel("Giải Phương Trình Bậc 1");
		lbl.setForeground(Color.BLUE);
		Font font = new Font("Arial", Font.BOLD, 20);
		lbl.setFont(font);
		JPanel pnTitle = new JPanel();
		pnTitle.setBackground(Color.RED);
		pnTitle.add(lbl);
		pnBorderLayout.add(pnTitle);

		JPanel pnContent1 = new JPanel();
		pnContent1.setLayout(new FlowLayout());
		JLabel lblContent1 = new JLabel("Hệ Số a");
		pnContent1.add(lblContent1);
		pnContent1.add(txtHeSoa);
		pnBorderLayout.add(pnContent1);

		JPanel pnContent2 = new JPanel();
		pnContent1.setLayout(new FlowLayout());
		JLabel lblContent2 = new JLabel("Hệ Số b");
		pnContent1.add(lblContent2);
		pnContent1.add(txtHeSob);
		pnBorderLayout.add(pnContent2);

		JPanel pnContent3 = new JPanel();
		pnContent3.setLayout(new FlowLayout());
		pnContent3.add(btnCalc);
		pnContent3.add(btnExit);
		pnContent3.add(btnHelp);
		pnBorderLayout.add(pnContent3);

		JPanel pnContent4 = new JPanel();
		pnContent4.setLayout(new FlowLayout());
		JLabel lblContent4 = new JLabel("Kết quả");
		pnContent4.add(lblContent4);
		pnContent4.add(resuilt);
		pnBorderLayout.add(pnContent4);

		con.add(pnBorderLayout);
	}

	public void addEvents() {

		btnCalc.addActionListener(eventCalc);
		btnExit.addActionListener(eventExit);
		btnHelp.addActionListener(eventHelp);

	}

	ActionListener eventCalc = new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			String heSoA = txtHeSoa.getText();
			String heSoB = txtHeSob.getText();

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

		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}

	};
	ActionListener eventHelp = new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "Nhập Phương Trình ax + b = 0",
	                  "Title", JOptionPane.WARNING_MESSAGE);
		}

	};

	public void showWindow() {
		this.setSize(600, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
