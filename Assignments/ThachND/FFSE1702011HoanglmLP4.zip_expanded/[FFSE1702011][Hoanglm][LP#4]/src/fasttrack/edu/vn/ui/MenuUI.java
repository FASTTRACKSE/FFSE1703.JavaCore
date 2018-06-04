package fasttrack.edu.vn.ui;

import javax.swing.*;
import javax.swing.border.Border;
import java.sql.*;
import com.mysql.*;
import java.io.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import fasttrack.edu.vn.ui.*;

public class MenuUI extends JFrame{
	JButton btnInput1, btnInput2, btnInput3, btnInput4, btnLogOut;
	public MenuUI(String title) {
		super(title);
		addControls();
		addEvents();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void addControls() {
		this.setResizable(false);
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		
		JPanel pnMenu = new JPanel();
		pnMenu.setLayout(new GridBagLayout());
		
		GridBagConstraints gbCTit = new GridBagConstraints();
		JPanel pnTitle = new JPanel();
		JLabel lbTitle = new JLabel("Menu");
		Font fontTitle = new Font("Roboto", Font.BOLD, 40);
		lbTitle.setForeground(Color.RED);
		lbTitle.setFont(fontTitle);
		pnTitle.add(lbTitle);
		pnTitle.setPreferredSize(new Dimension(300, 80));
		gbCTit.gridx = 0;
		gbCTit.gridy = 0;
		gbCTit.gridwidth = 2;
		pnMenu.add(pnTitle, gbCTit);
		
		GridBagConstraints gbC = new GridBagConstraints();
		JPanel pnLine1 = new JPanel();
		btnInput1 = new JButton("QUẢN LÝ KHÁCH HÀNG");
		btnInput1.setPreferredSize(new Dimension(300, 80));
		pnLine1.add(btnInput1);
		gbC.gridx = 0;
		gbC.gridy = 1;
		gbC.insets = new Insets(0, 10, 20, 10);
		pnMenu.add(pnLine1, gbC);
		
		JPanel pnLine2 = new JPanel();
		btnInput2 = new JButton("QUẢN LÝ BIÊN LAI");
		btnInput2.setPreferredSize(new Dimension(300, 80));
		pnLine2.add(btnInput2);
		gbC.gridx = 1;
		gbC.gridy = 1;
		pnMenu.add(pnLine2, gbC);
		
		JPanel pnLine3 = new JPanel();
		btnInput3 = new JButton("BÁO CÁO DANH SÁCH KHÁCH HÀNG");
		btnInput3.setPreferredSize(new Dimension(300, 80));
		pnLine3.add(btnInput3);
		gbC.gridx = 0;
		gbC.gridy = 2;
		pnMenu.add(pnLine3, gbC);
		
		JPanel pnLine4 = new JPanel();
		btnInput4 = new JButton("BÁO CÁO TÌNH HÌNH TIÊU THỤ ĐIỆN");
		btnInput4.setPreferredSize(new Dimension(300, 80));
		pnLine4.add(btnInput4);
		gbC.gridx = 1;
		gbC.gridy = 2;
		pnMenu.add(pnLine4, gbC);
		
		//pnMenu.add(pnLine);
		
		JPanel pnBtn = new JPanel();
		btnLogOut = new JButton("ĐĂNG XUẤT");
		btnLogOut.setPreferredSize(new Dimension(150, 40));
		pnBtn.add(btnLogOut);
		gbC.gridx = 0;
		gbC.gridy = 3;
		gbC.gridwidth = 2;
		pnMenu.add(pnBtn, gbC);
		pnMain.add(pnMenu);
		
		con.add(pnMain);
	}
	
	//EVENT USER MANAGEMENT
	ActionListener eventUserManagement = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			UserManagement();
		}
	};
	
	public void UserManagement() {
		UserManagementUI giaodien = new UserManagementUI("Chương trình quản lý tiền điện");
		giaodien.showWindow();
		dispose();
	}
	
	//EVENT BILLS MANAGEMENT
	ActionListener eventBillManagement = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			BillManagement();
		}
	};
	
	public void BillManagement() {
		BillsManagementUI giaodien = new BillsManagementUI("Chương trình quản lý tiền điện");
		giaodien.showWindow();
		dispose();
	}
	
	//EVENT USER LISR REPORT
	ActionListener eventUserListReport = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			UserListReport();
		}
	};
	
	public void UserListReport() {
		UserListReportUI giaodien = new UserListReportUI("Chương trình quản lý tiền điện");
		giaodien.showWindow();
		dispose();
	}
	
	//EVENT ELECTRICITY REPORT
	ActionListener eventElectricityReport = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			ElectricityReport();
		}
	};
	
	public void ElectricityReport() {
		ElectricityReportUI giaodien = new ElectricityReportUI("Chương trình quản lý tiền điện");
		giaodien.showWindow();
		dispose();
	}
	
	public void addEvents() {
		btnInput1.addActionListener(eventUserManagement);
		btnInput2.addActionListener(eventBillManagement);
		btnInput3.addActionListener(eventUserListReport);
		btnInput4.addActionListener(eventElectricityReport);
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginUI giaodien = new LoginUI("Chương trình quản lý tiền điện");
				giaodien.showWindow();
				dispose();
			}
		});
	}
	
	public void showWindow() {
		this.setSize(700,400);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
