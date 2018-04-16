package test_ui.model;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.*;
public class Ui_Model extends JFrame {
	public Ui_Model(String tittle) {
		super(tittle);
		addControls();
	}
	public void addControls() {
		Container con = getContentPane();
		JPanel pnFlowLayout = new JPanel();
		pnFlowLayout.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
		JButton btn1 = new JButton("Create");
		JButton btn2 = new JButton("Update");
		JButton btn3 = new JButton("Delete");
		JButton btn4 = new JButton("Exit");
		pnFlowLayout.add(btn1);
		pnFlowLayout.add(btn2);
		pnFlowLayout.add(btn3);
		pnFlowLayout.add(btn4);
		con.add(pnFlowLayout);
	}
	public void showWindow() {
		this.setSize(600,400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
