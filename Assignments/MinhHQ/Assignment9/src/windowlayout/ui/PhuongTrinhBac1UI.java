package windowlayout.ui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class PhuongTrinhBac1UI extends JFrame{
	private JTextField txtHesoA = new JTextField(15);
	private JTextField txtHesoB = new JTextField(15);
	private JTextField txtKetqua = new JTextField(15);
	private JButton btnCalc= new JButton("Calc");
	private JButton btnExit= new JButton("Exit");
	private JButton btnHelp= new JButton("Help");
	
	public PhuongTrinhBac1UI(String tieude)
	{
		super(tieude);
		addControls();
		addEvent();
	}
	
	public void addControls()
	{
		Container con=getContentPane();
		JPanel pnMain=new JPanel();
		
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		
		JLabel lbl=new JLabel("Giải Phương trình bậc 1");
		Font font=new Font("Arial", Font.BOLD,24);
		lbl.setFont(font);
		lbl.setForeground(Color.BLUE);		
		JPanel Title=new JPanel();
		Title.setBackground(Color.RED);
		Title.setPreferredSize(new Dimension(0, 30));
		Title.add(lbl);
		pnMain.add(Title,BorderLayout.NORTH);

		
		JPanel nhapa = new JPanel();
		nhapa.setLayout(new FlowLayout());
		JLabel lblHesoA= new JLabel("Hệ số a :");
		txtHesoA = new JTextField(15);
		nhapa.add(lblHesoA);
		nhapa.add(txtHesoA);
		pnMain.add(nhapa);
		
		JPanel nhapb = new JPanel();
		nhapa.setLayout(new FlowLayout());
		JLabel lblHesoB= new JLabel("Hệ số b :");
		txtHesoB = new JTextField(15);
		nhapb.add(lblHesoB);
		nhapb.add(txtHesoB);
		pnMain.add(nhapb);
		
		JPanel button = new JPanel();
		button.setLayout(new FlowLayout());
		button.add(btnCalc);
		button.add(btnExit);
		button.add(btnHelp);
		pnMain.add(button);
		
		JPanel ketqua = new JPanel();
		ketqua.setLayout(new FlowLayout());
		JLabel pnKetqua= new JLabel("Kết Quả :");
		ketqua.add(pnKetqua);
		ketqua.add(txtKetqua);
		pnMain.add(ketqua);
		
		con.add(pnMain);
	}
	
	public void addEvent() 
	{
		btnCalc.addActionListener(eventCalc);
		btnExit.addActionListener(eventExit);
		btnHelp.addActionListener(eventHelp);
		
	}
		
		ActionListener eventCalc = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String heSoA = txtHesoA.getText();
				String heSoB = txtHesoB.getText();
				
				double a = Double.parseDouble(heSoA);
				double b = Double.parseDouble(heSoB);
				
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
				txtKetqua.setText(x);
				
			}
			
		};
		ActionListener eventExit = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		};
		ActionListener eventHelp = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			}
			
		};
		
	
	public void showWindow()
	{
		this.setSize(410, 250);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
