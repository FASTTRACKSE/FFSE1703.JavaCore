package ffse1702010.edu.vn.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyBorderLayout extends JFrame {

	JLabel title, a;
	JPanel pnBox;
	JPanel heSoa;
	JPanel heSob;
	JPanel ketQua;
	JPanel button;


	Container con;

	public MyBorderLayout(String tieude) {
		addControl();
		this.setTitle(tieude);

	}

	private void addControl() {
		con = getContentPane();
		pnBox = new JPanel();
		pnBox.setBackground(Color.pink);
		pnBox.setLayout(new BoxLayout(pnBox, BoxLayout.Y_AXIS));
		
		title = new JLabel("GIẢI PHƯƠNG TRÌNH BẬC NHẤT");
		title.setOpaque(true);
		Font font = new Font("Arial", Font.BOLD, 24);
		title.setFont(font);
		title.setBackground(Color.LIGHT_GRAY);
		pnBox.add(title);
		con.add(pnBox);
		
		heSoa=new JPanel();
		heSoa.setLayout(new FlowLayout());
		JLabel lbla=new JLabel("Nhập hệ số A:");
		JTextField a=new JTextField(15);
		heSoa.add(lbla);
        heSoa.add(a);
        pnBox.add(heSoa);
        
    	heSob=new JPanel();
    	heSob.setLayout(new FlowLayout());
    	JLabel lblb=new JLabel("Nhập hệ số B");
		JTextField b=new JTextField(15);
		heSob.add(lblb);
		heSob.add(b);
		pnBox.add(heSob);
		
		button=new JPanel();
		button.setLayout(new FlowLayout());
		Button btn1=new Button("CALC");
		Button btn2=new Button("EXIT");
		Button btn3=new Button("HELP");
		button.add(btn1);
		button.add(btn2);
		button.add(btn3);
		pnBox.add(button);
		
	    
    	ketQua=new JPanel();
    	ketQua.setLayout(new FlowLayout());
    	JLabel lblKQ=new JLabel("Nhập hệ số B");
		JTextField KQ=new JTextField(15);
		ketQua.add(lblKQ);
		ketQua.add(KQ);
		pnBox.add(ketQua);


    	

	}

	public void showWindow() {
		this.setSize(650, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

}
