package fasttrackse.javadesktop.layoutsample.ui;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SampleFlowLayout extends JFrame {
	public SampleFlowLayout(String title) {
		super(title);
		
		addControls();
		
		addEvents();
	}
	
	public void addControls() {
		Container con=getContentPane();
		
		JPanel pnFlowLayout=new JPanel();
		pnFlowLayout.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		
		JButton btn1=new JButton("1. Create");
		JButton btn2=new JButton("2. Update");
		JButton btn3=new JButton("3. Delete");
		JButton btn4=new JButton("4. Exit");
		
		pnFlowLayout.add(btn1);
		pnFlowLayout.add(btn2);
		pnFlowLayout.add(btn3);
		pnFlowLayout.add(btn4);
		
		con.add(pnFlowLayout);

	}
	
	public void addEvents() {
		//
	}
	
	public void showWindow() {
		this.setSize(600, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
