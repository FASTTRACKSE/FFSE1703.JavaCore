package atm.ui;

import java.awt.Color;
import java.awt.Container;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import atm.main.*;
public class LayoutQuanLy extends JFrame {
	
	
		public LayoutQuanLy(String Window) {
			super(Window);
			addControls();
			
		}
		private void addControls() {
			Container con = getContentPane();
			
			
			
			JTabbedPane myTab = new JTabbedPane();
			JPanel pnMain = new JPanel();
			LayoutKhachHang tabLayoutKhachHang = new LayoutKhachHang();
			LayoutAtm tabLayoutAtm = new LayoutAtm();
			
			myTab.add( tabLayoutKhachHang,"Quản Lý Khách Hàng");
			myTab.add( tabLayoutAtm,"Quản Lý Máy ATM");
			
			pnMain.add(myTab);
			con.add(pnMain);
		}
		
		public void showWindow() {
			this.setSize(1000,700);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setLocationRelativeTo(null);
			this.setVisible(true);
		}
}

