package fasttrack.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
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

public class PhuongTrinh extends JFrame {
	private static final Component pnBox = null;
	JTextField txtHesoA = new JTextField(15);
	JTextField txtHesoB = new JTextField(15);
	JTextField txtKetQua = new JTextField(15);
	JButton btnCalc = new JButton("Calc");
	JButton btnExit = new JButton("Exit");
	JButton btnHelp = new JButton("Help");

	public PhuongTrinh(String title) {
		super(title);
		addControls();
		addEvent();
	}

	public void addControls() {
		Container con = getContentPane();
		JPanel pnBox = new JPanel();
		pnBox.setLayout(new BoxLayout(pnBox, BoxLayout.Y_AXIS));

		JPanel Box1 = new JPanel();
		JPanel Box2 = new JPanel();
		JPanel Box3 = new JPanel();
		JPanel Box4 = new JPanel();
		JPanel Box5 = new JPanel();
		JPanel Box6 = new JPanel();
		//
		JLabel jblTen1 = new JLabel("Giai Phuong Trinh Bac 1");
		Font font = new Font("Arial", Font.BOLD, 40);
		jblTen1.setFont(font);
		jblTen1.setBackground(Color.BLUE);
		Box1.setBackground(Color.RED);
		Box1.add(jblTen1);

		//
		JLabel jblTen2 = new JLabel("He So a:");
		Box2.add(jblTen2);
		Box2.add(txtHesoA);
		JLabel jblTen3 = new JLabel("He So b:");
		Box3.add(jblTen3);
		Box3.add(txtHesoB);
		Box4.add(btnCalc);
		Box4.add(btnExit);
		Box4.add(btnHelp);
		JLabel jblTen4 = new JLabel("Ket Qua:");
		Box5.add(jblTen4);
		Box5.add(txtKetQua);
		//
		pnBox.add(Box1);
		pnBox.add(Box2);
		pnBox.add(Box3);
		pnBox.add(Box4);
		pnBox.add(Box5);
		//
		con.add(pnBox);
	}

	public void showWindow() {
		this.setSize(600, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void addEvent() {
		btnCalc.addActionListener(giaipt);
		btnExit.addActionListener(out);
	}

	ActionListener giaipt = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String hesoA = txtHesoA.getText();
			String hesoB = txtHesoB.getText();
			try {
				if (hesoA.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Ban chua nhap he so A");
				} else {
					Double.parseDouble(hesoA);
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Ban phai nhap so");

			}
			try {
				if (hesoB.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Ban chua nhap he so B");
				} else {
					Double.parseDouble(hesoB);
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Ban phai nhap so");

			}
			try {
				String x;
				Double a = Double.parseDouble(hesoA);
				Double b = Double.parseDouble(hesoB);
				if (a == 0) {
					if (b == 0) {
						x = "Phuong trinh co vo so nghiem";
					} else {
						x = "Phuong trinh vo nghiem";
					}
				} else {
					x = Double.toString(-b / a);
				}
				txtKetQua.setText(x);

			} catch (Exception ex) {

			}
		}
	};
	ActionListener out=new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.exit(0);
		}
	};
}
