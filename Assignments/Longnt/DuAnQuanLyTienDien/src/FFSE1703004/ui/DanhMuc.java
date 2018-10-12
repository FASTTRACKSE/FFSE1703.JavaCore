package FFSE1703004.ui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DanhMuc extends JFrame {
	JButton butKH, butBL, butTK;
	public DanhMuc(String arg0) throws HeadlessException {
		super(arg0);
		// TODO Auto-generated constructor stub
		try {
			addControls();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	void addControls() throws HeadlessException, SQLException {
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.X_AXIS));
		JPanel pnMain1 = new JPanel();
		JPanel pnMain2 = new JPanel();
		JPanel card = new JPanel();
		CardLayout tl =new CardLayout();
		pnMain1.setLayout(new BoxLayout(pnMain1, BoxLayout.Y_AXIS));
		pnMain1.setPreferredSize(new Dimension(200, 50));
		pnMain2.setLayout(tl);
		
		
		JPanel panKH = new JPanel();
		butKH = new JButton("Quản Lý Khách Hàng");
		butKH.setPreferredSize(new Dimension(200, 50));
		panKH.add(butKH);
		
		JPanel panBL = new JPanel();
		butBL = new JButton("Quản Lý Biên Lai");
		butBL.setPreferredSize(new Dimension(200, 50));
		panBL.add(butBL);

		JPanel panTK = new JPanel();
		butTK = new JButton("Thống kê");
		butTK.setPreferredSize(new Dimension(200, 50));
		panTK.add(butTK);
		
		KhachHang a = new KhachHang();
		BienLai b = new BienLai();
		ThongKe c = new ThongKe();
		
		pnMain2.add(a, "1");
		pnMain2.add(b, "2");
		pnMain2.add(c, "3");
		tl.show(pnMain2, "1");
	
		
		butKH.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tl.show(pnMain2, "1");
			}


		}); 
		
		butBL.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tl.show(pnMain2, "2");
				
			}
		});
		
		pnMain1.add(panKH);
		pnMain1.add(panBL);
		pnMain1.add(panTK);
		pnMain2.add(card);

		pnMain.add(pnMain1);
		pnMain.add(pnMain2);
		con.add(pnMain);
		
		
	
	}

		
	
	public void showWindow() {
		this.setSize(900, 700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}