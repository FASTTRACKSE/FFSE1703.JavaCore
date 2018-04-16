package flow_layout;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFlowLayout extends JFrame{
	public MyFlowLayout() {
		super();
	}

	public MyFlowLayout(String title) {
		super(title);
		addControls();
	}

	

	public void addControls() {
		Container con=getContentPane();
		JPanel pnFLow = new JPanel();
		pnFLow.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		pnFLow.setBackground(Color.pink);
		JButton btn1 = new JButton("Create");
		JButton btn2 = new JButton("Update");
		JButton btn3 = new JButton("Delete");

		pnFLow.add(btn1);
		pnFLow.add(btn2);
		pnFLow.add(btn3);

		con.add(pnFLow);

	}

	public void showWindown() {
		this.setSize(600, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
