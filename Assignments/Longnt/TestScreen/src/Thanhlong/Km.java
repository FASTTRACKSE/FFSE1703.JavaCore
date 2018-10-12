package Thanhlong;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;


public class Km extends JFrame{
	Container con=getContentPane();
	String[] items = {"All","FFSE1701", "FFSE1702", "FFSE1703", "FFSE1704"};
	String chonlop = "All";
	JComboBox<String> comb = new JComboBox<>(items);
	
	public Km(String tieude){
				super(tieude);
				addControls();
				addEvents();
	}

	private void addEvents() {
		// TODO Auto-generated method stub
		
	}

	private void addControls() {
		
		
		JPanel pan = new JPanel();
		pan.setLayout(new BoxLayout(pan, BoxLayout.Y_AXIS));
		
		JPanel pan1 = new JPanel();
		JLabel lab1 = new JLabel("Chương Trình Quản Lý Sinh Viên");
		Font fontTitle = new Font("arial", Font.BOLD, 30);
		lab1.setFont(fontTitle);
		pan1.add(lab1);
		pan.add(pan1);
		
		JPanel pan2 = new JPanel();
		JLabel lab2 = new JLabel("Chọn Lớp:   " );
		pan2.add(lab2);
		add(comb);
		pan2.add(comb);
		pan.add(pan2);
		
		
      con.add(pan);
	}
	public void showWindow()
	{
		this.setSize(600, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}