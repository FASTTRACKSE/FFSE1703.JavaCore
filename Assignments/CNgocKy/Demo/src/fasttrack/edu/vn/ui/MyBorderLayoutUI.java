package fasttrack.edu.vn.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyBorderLayoutUI extends JFrame {
	public MyBorderLayoutUI(String tieude)
	{
		this.setTitle(tieude);
		addControls();
	}
	public void addControls()
	{
		Container con=getContentPane();
		JPanel pnBorderLayout=new JPanel();
		pnBorderLayout.setLayout(new BorderLayout());
		
		JPanel pnNorth=new JPanel();
		pnNorth.setBackground(Color.BLUE);
		pnBorderLayout.add(pnNorth,BorderLayout.NORTH);
		pnNorth.setPreferredSize(new Dimension(0, 100));
		
		
		JPanel pnSouth=new JPanel();
		pnSouth.setBackground(Color.PINK);
		pnBorderLayout.add(pnSouth,BorderLayout.SOUTH);
		pnSouth.setPreferredSize(new Dimension(0, 50));
		
		JPanel pnWest=new JPanel();
		pnWest.setBackground(Color.YELLOW);
		pnBorderLayout.add(pnWest,BorderLayout.WEST);
		pnWest.setPreferredSize(new Dimension(30, 0));
		
		JPanel pnEast=new JPanel();
		pnEast.setBackground(Color.CYAN);
		pnBorderLayout.add(pnEast,BorderLayout.EAST);
		pnEast.setPreferredSize(new Dimension(70, 0));
		
		JPanel pnCenter=new JPanel();
		pnCenter.setBackground(Color.RED);
		pnBorderLayout.add(pnCenter,BorderLayout.CENTER);
		
		con.add(pnBorderLayout);
	}
	
	public void showWindow()
	{
		this.setSize(600, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}