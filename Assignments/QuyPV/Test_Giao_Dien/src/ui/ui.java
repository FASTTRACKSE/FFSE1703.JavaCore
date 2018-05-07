package ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.ConnectException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class ui extends JFrame {
	public ui() {
		super();
	}
	
	public ui(String title) {
		super(title);
		addControls();
		addEvents();
	}
	
	public void addControls() {
		Container con = getContentPane();
//		JPanel bdMain = new JPanel();
//		bdMain.setLayout(new BorderLayout());
//		JPanel box1 = new JPanel();
//		box1.setBackground(Color.BLACK);
//		JPanel box2 = new JPanel();
//		box2.setBackground(Color.BLUE);
//		JPanel box3 = new JPanel();
//		box3.setBackground(Color.green);
//		bdMain.add(box1,BorderLayout.NORTH);
//		bdMain.add(box2,BorderLayout.NORTH);
//		bdMain.add(box,BorderLayout.NORTH);
		JPanel boxMain = new JPanel();
		boxMain.setLayout(new BoxLayout(boxMain, BoxLayout.X_AXIS ));
		
//		JPanel box1 = new JPanel();
//		JLabel lb1 = new JLabel("Phạm Văn Quý");
//		Font fontT = new Font("Arial", Font.BOLD, 20);
//		lb1.setFont(fontT);
//		lb1.setForeground(Color.blue);
//		box1.add(lb1);
		
		// phần JTree
//		DefaultMutableTreeNode folderMain = new DefaultMutableTreeNode("Thư mục gốc");
//		JTree tree = new JTree(folderMain);
//		DefaultMutableTreeNode folder1 = new DefaultMutableTreeNode("Thư mục 1");
//		DefaultMutableTreeNode folder1_1 = new DefaultMutableTreeNode("Thư mục 1.1");
//		folder1.add(folder1_1);
//		folderMain.add(folder1);
//		box1.add(tree);
		
		JTabbedPane myTab = new JTabbedPane();
		JPanel box1 = new JPanel();
		Font font = new Font("Arial", Font.BOLD, 30);
		box1.setLayout(new BorderLayout());
		JPanel pnNorth = new JPanel();
		JLabel lbNorth = new JLabel("Quản lí sinh viên");
		lbNorth.setFont(font);
		pnNorth.add(lbNorth);
		pnNorth.setBackground(Color.RED);
		JPanel pnSouth = new JPanel();
		JLabel lbSouth = new JLabel("South");
		lbSouth.setFont(font);
		pnSouth.add(lbSouth);
		pnSouth.setBackground(Color.RED);
		JPanel pnWest = new JPanel();
		JLabel lbWest = new JLabel("West");
		lbWest.setFont(font);
		pnWest.add(lbWest);
		pnWest.setBackground(Color.BLUE);
		JPanel pnEast = new JPanel();
		JLabel lbEast = new JLabel("East");
		lbEast.setFont(font);
		pnEast.add(lbEast);
		pnEast.setBackground(Color.BLUE);
		JPanel pnCenter = new JPanel();
		pnCenter.setBackground(Color.YELLOW);
		JPanel box = new JPanel();
		JPanel box2 = new JPanel();
		box2.setLayout(new CardLayout());
		JPanel pnCard1 = new JPanel();
		pnCard1.setBackground(Color.LIGHT_GRAY);
		JPanel pnCard2 = new JPanel();
		pnCard2.setBackground(Color.PINK);
		box2.add(pnCard1, "mycard1");
		box2.add(pnCard2, "mycard2");
		JButton btn2 = new JButton("nút 2");
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)box2.getLayout();
				cl.show(box2, "mycard1");
				
			}
		});
		//add north
		box1.add(pnNorth, BorderLayout.NORTH);
		//add south
		box1.add(pnSouth, BorderLayout.SOUTH);
		//add west
		box1.add(pnWest, BorderLayout.WEST);
		//add east
		box1.add(pnEast, BorderLayout.EAST);
		//add center
		box1.add(pnCenter, BorderLayout.CENTER);
		getContentPane().add(box1);
		box.add(btn2);
		box.add(box2);
		myTab.add("Quản lí danh sách sinh viên", box1);
		myTab.addTab("Quản lí danh sách lớp học", box);
		
		
		boxMain.add(myTab);
		
		con.add(boxMain);
	}
	
	public void addEvents() {
		
	}
	
	public void showWindown() {
		this.setSize(800,600);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}
}
