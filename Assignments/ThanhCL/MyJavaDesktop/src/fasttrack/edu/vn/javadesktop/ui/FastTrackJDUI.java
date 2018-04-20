package fasttrack.edu.vn.javadesktop.ui;

import javax.swing.JFrame;

public class FastTrackJDUI extends JFrame {
	public FastTrackJDUI(String title) {
		super(title);
	}
	
	public void showWindow() {
		this.setSize(640, 480);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
