package fasttrack.edu.vn.ui;

import java.awt.Container;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HelloWorldUI extends JFrame {
	public HelloWorldUI(String title) {
		super(title);
		addControls();
	}

	public void addControls() {
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		JPanel pnTitle = new JPanel();
		JLabel lblTitle = new JLabel("Chương trình GPTB1");
		Font fontTitle = new Font("arial", Font.BOLD, 20);
		lblTitle.setFont(fontTitle);

		pnTitle.add(lblTitle);

		JPanel pnInput1 = new JPanel();
		JLabel lblTitle1 = new JLabel("Nhập hệ số a:");
		JTextField txtHeSoA = new JTextField(15);
		pnInput1.add(lblTitle1);
		pnInput1.add(txtHeSoA);

		JPanel pnInput2 = new JPanel();
		JLabel lblTitle2 = new JLabel("Nhập hệ số b:");
		JTextField txtHeSoB = new JTextField(15);
		pnInput2.add(lblTitle2);
		pnInput2.add(txtHeSoB);

		JPanel pnAction = new JPanel();
		JButton btnCalc = new JButton("Calculate");
		JButton btnExit = new JButton("Exit");
		pnAction.add(btnCalc);
		pnAction.add(btnExit);

		JPanel pnResult = new JPanel();
		JLabel lblTitleResult = new JLabel("Nghiệm: ");
		JTextField txtResult = new JTextField(15);
		pnResult.add(lblTitleResult);
		pnResult.add(txtResult);

		pnMain.add(pnTitle);
		pnMain.add(pnInput1);
		pnMain.add(pnInput2);
		pnMain.add(pnAction);
		pnMain.add(pnResult);

		con.add(pnMain);
	}

	public void showWindow() {
		this.setSize(600, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
