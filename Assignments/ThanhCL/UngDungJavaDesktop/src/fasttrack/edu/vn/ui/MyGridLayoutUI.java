package fasttrack.edu.vn.ui;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyGridLayoutUI extends JFrame {
	public MyGridLayoutUI(String title) {
		super(title);
		addControls();
	}

	public void addControls() {
		Container con = getContentPane();

		// tạo 1 JPanel:
		JPanel pnGridLayout = new JPanel();
		pnGridLayout.setLayout(new GridLayout(2, 2, 10, 10));

		JButton btn1 = new JButton("Button 1");
		JButton btn2 = new JButton("Button 2");
		JButton btn3 = new JButton("Button 3");
		JButton btn4 = new JButton("Button 4");
		JButton btn5 = new JButton("Button 5");
		JButton btn6 = new JButton("Button 6");

		pnGridLayout.add(btn1);
		pnGridLayout.add(btn2);
		pnGridLayout.add(btn3);
		pnGridLayout.add(btn4);
		pnGridLayout.add(btn5);
		pnGridLayout.add(btn6);

		con.add(pnGridLayout);

	}

	public void showWindow() {
		this.setSize(600, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
