package ffse1702010.edu.vn.ui;

import java.awt.Color;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyLayout extends JFrame {
	private Container con;

	public MyLayout(String title) {

		this.setTitle(title);
		addLayout();
	}

	public void addLayout() {
		con = getContentPane();
		
		
		
	}
	

	public void showWindow() {
		this.setSize(580, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		JLabel background=new JLabel();
		add(background);
		ImageIcon icon=new ImageIcon("nen.jpg");
		background.setIcon(icon);
		con.add(background);

	}

}
