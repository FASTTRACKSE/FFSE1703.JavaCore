package fasttrackse.edu.vn.ui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ptrinhbac1UI extends JFrame {
	private JTextField txtHeSoA = new JTextField(15);
	private JTextField txtHeSoB = new JTextField(15);
	private JTextField ketQua = new JTextField(15);
	private JButton btnCalc = new JButton("Calc");
	private JButton btnExit = new JButton("Exit");
	private JButton btnHelp = new JButton("Help");

	public Ptrinhbac1UI(String title) {
		super(title);
		addControls();
		addEvents();
	}

	public void addControls() {
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		JLabel lbl = new JLabel("Giải Phương trình bậc 1");
		Font font=new Font("Arial", Font.BOLD,19);
		lbl.setFont(font);
		lbl.setForeground(Color.BLUE);
		JPanel Title = new JPanel();
		Title.setBackground(Color.GRAY);
		Title.add(lbl);
		pnMain.add(Title);

		JPanel nhapHeSoA = new JPanel();
		nhapHeSoA.setLayout(new FlowLayout());
		JLabel HesoA = new JLabel("Hệ số a :");
		txtHeSoA = new JTextField(16);
		nhapHeSoA.add(HesoA);
		nhapHeSoA.add(txtHeSoA);
		pnMain.add(nhapHeSoA);

		JPanel nhapHeSoB = new JPanel();
		nhapHeSoB.setLayout(new FlowLayout());
		JLabel HesoB = new JLabel("Hệ số b :");
		txtHeSoB = new JTextField(16);
		nhapHeSoB.add(HesoB);
		nhapHeSoB.add(txtHeSoB);
		pnMain.add(nhapHeSoB);

		JPanel Button = new JPanel();
		Button.setLayout(new FlowLayout());
		Button.add(btnCalc);
		Button.add(btnExit);
		Button.add(btnHelp);
		pnMain.add(Button);

		JPanel raKetQua = new JPanel();
		raKetQua.setLayout(new FlowLayout());
		JLabel ketqua = new JLabel("Kết quả :");
		raKetQua.add(ketqua);
		raKetQua.add(ketQua);
		pnMain.add(raKetQua);

		con.add(pnMain);
	}

	private void addEvents() {

		btnCalc.addActionListener(eventCalc);
		btnExit.addActionListener(eventExit);
		btnHelp.addActionListener(eventHelp);
		
	}

	ActionListener eventCalc = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			String heSoA = txtHeSoA.getText();
			String heSoB = txtHeSoB.getText();
			
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
			ketQua.setText(x);
			
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
			 JOptionPane.showMessageDialog(null, "Giải Phương trình bật nhất có dạng : ax + b = 0 Nhập vào hệ số a và b sau đó nhấn Calc để xem kết quả . Nhấn Exit để thoát chương trình",
	                  "Title", JOptionPane.WARNING_MESSAGE);

		}

	};

	public void showWindow() {
		this.setSize(400, 200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
