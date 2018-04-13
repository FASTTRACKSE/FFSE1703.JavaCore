package box_layout;

import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyBoxLayout extends JFrame {
	public MyBoxLayout() {
		super();
	}
	
	public MyBoxLayout(String title) {
		super(title);
		addControls();
	}
	
	public void addControls() {
		Container con=getContentPane();
		
		JPanel pnBoxMain=new JPanel();
		pnBoxMain.setLayout(new BoxLayout(pnBoxMain, BoxLayout.Y_AXIS));
		
		JPanel pnBox1=new JPanel();
		pnBox1.setBackground(Color.RED);
		JLabel lb1=new JLabel("Tiêu đề");
		pnBox1.add(lb1);
		lb1.setForeground(Color.BLUE);
		Font font=new Font("Arial",Font.BOLD,20);
		lb1.setFont(font);
		
		
		JPanel pnBox2=new JPanel();
		JLabel lb2 = new JLabel("Nhập tên: ");
		JTextField text1 = new JTextField(15);
		pnBox2.add(lb2);
		pnBox2.add(text1);
	
		
		JPanel pnBox3=new JPanel();
		JButton btn1 = new JButton("Button 6");
		JButton btn2 = new JButton("Button 7");
		pnBox3.add(btn1);
		pnBox3.add(btn2);
		
		
		pnBoxMain.add(pnBox1);
		pnBoxMain.add(pnBox2);
		pnBoxMain.add(pnBox3);
		con.add(pnBoxMain);

	}
	
	public void showWindown() {
		this.setSize(600, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
