package fasttrack.edu.vn.ui;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HelloWorldUI extends JFrame {
	public HelloWorldUI(String tieude)
	{
		super(tieude);
		
		addControls();
	}
	public void addControls()
	{
		//Lấy lớp chứa cửa sổ ra:
		Container con=getContentPane();
		
		//tạo 1 lớp chứa control
		JPanel pn=new JPanel();
		//pn.setBackground(Color.BLUE);
		
		JButton btn=new JButton("Hello World button");
		pn.add(btn);
		
		//đưa panel lên giao diện:
		con.add(pn);
	}
	public void showWindow()
	{
		this.setSize(500, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}
}
