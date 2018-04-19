package ffse1702010.edu.vn.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sun.xml.internal.ws.org.objectweb.asm.Label;

public class MyBorderLayout extends JFrame {

	private JPanel pnBox;
	JPanel heSoa;
	JPanel heSob;
	JPanel ketQua;
	JPanel button;
	
	private Button btn1 = new Button("CALC");
	private Button btn2 = new Button("EXIT");
	private Button btn3 = new Button("HELP");
	
	private JTextField KQ = new JTextField(15);
	private JTextField a = new JTextField(15);
	private JTextField b = new JTextField(15);
	
	
	private JLabel lblKQ = new JLabel("KẾT QUẢ");
	private JLabel lblb = new JLabel("Nhập hệ số B");
	private JLabel lbla = new JLabel("Nhập hệ số A:");

	private JLabel title;
    
	private Container con;

	public MyBorderLayout(String tieude) {
		addControl();
		this.setTitle(tieude);
		addEvent();

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

		heSoa = new JPanel();
		heSoa.setLayout(new FlowLayout());
		heSoa.add(lbla);
		heSoa.add(a);
		pnBox.add(heSoa);

		heSob = new JPanel();
		heSob.setLayout(new FlowLayout());
		heSob.add(lblb);
		heSob.add(b);
		pnBox.add(heSob);

		button = new JPanel();
		button.setLayout(new FlowLayout());

		button.add(btn1);
		button.add(btn2);
		button.add(btn3);
		pnBox.add(button);

		ketQua = new JPanel();
		ketQua.setLayout(new FlowLayout());
		ketQua.add(lblKQ);
		ketQua.add(KQ);
		pnBox.add(ketQua);

	}

	public void addEvent() {
		btn1.addActionListener(eventCalc);
		btn2.addActionListener(eventExit);
		btn3.addActionListener(eventHelp);

	}

	ActionListener eventExit = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}

	};
	ActionListener eventCalc = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			String heSoa =a.getText();
			String heSob =b.getText();
			double a = Double.parseDouble(heSoa);
			double b = Double.parseDouble(heSob);
			String x;
			if (a == 0) {
				if (b == 0) {
				x = "Phương trình có vô số nghiệm";
				} else {
					x = "Phương trình vô nghiệm";
				}
			} else {
				x = Double.toString(-b / a);
			}
			KQ.setText(x);
			
		}
		
	};

			// TODO Auto-generated method stub

		

	ActionListener eventHelp = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}
	};

	public void showWindow() {
		this.setSize(580, 200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

}
