package fasttrack.edu.vn.ui;
import java.awt.Button;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
public class MyBoxLayoutUI extends JFrame {
	public MyBoxLayoutUI(String tieude)
	{
		super(tieude);
		addControls();
	}
	public void addControls()
	{
		Container con=getContentPane();
		JPanel pnBox=new JPanel();
		JPanel pnBox1=new JPanel();
		
		pnBox.setLayout(new BoxLayout(pnBox, BoxLayout.X_AXIS));
		pnBox1.setLayout(new FlowLayout());
		
		Button btn1=new Button("Button 1");
		Button btn2=new Button("Button 2");
		Button btn3=new Button("Button 3");
		JButton btn4 = new JButton("Button 4");
		JButton btn5 = new JButton("Button 5");
		pnBox.add(btn1);
		pnBox.add(btn2);
		pnBox.add(btn3);
		pnBox.add(btn4);
		pnBox.add(btn5);
		
		con.add(pnBox);
	}
	
	public void showWindow()
	{
		this.setSize(600, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
