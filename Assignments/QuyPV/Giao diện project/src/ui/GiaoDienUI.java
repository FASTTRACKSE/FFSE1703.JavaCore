package ui;

import java.awt.Container;

import javax.swing.JFrame;

public class GiaoDienUI extends JFrame {
	public GiaoDienUI() {
		super();
	}
	
	public GiaoDienUI(String title) {
		super(title);
		addControls();
		addEvents();
	}
	
	public void addControls() {
		Container con = getContentPane();
		
	}
	
	public void addEvents() {
		
	}
	
	public void addWindown() {
		this.setSize(800,600);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}
}
