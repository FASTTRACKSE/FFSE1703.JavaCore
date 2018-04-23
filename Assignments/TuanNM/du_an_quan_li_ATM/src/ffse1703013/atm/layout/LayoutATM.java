package ffse1703013.atm.layout;

import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class LayoutATM extends JFrame {
	JPanel pnKhachHang,pnKH1,pnKH2;
	public LayoutATM(String title) {
		super(title);
		addControl();
	}
	public void addControl() {
		Container con=getContentPane();
		JTabbedPane myTabled=new JTabbedPane();
		
		
		// jpanel Quản lí khach hàng
		 
		pnKhachHang=new JPanel();
		pnKhachHang.setBackground(Color.BLUE);
		pnKhachHang.setLayout(new BoxLayout(pnKhachHang, BoxLayout.X_AXIS));
		pnKH1 =new JPanel();
		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Cập nhật khách hàng");
		pnKH1.setBorder(borderTitle);
		pnKH2 =new JPanel();
		Border border2 = BorderFactory.createLineBorder(Color.BLUE);
		TitledBorder borderTitle1 = BorderFactory.createTitledBorder(border, "Danh sách khách hàng");
		pnKH2.setBorder(borderTitle1);
		pnKhachHang.add(pnKH1);
		pnKhachHang.add(pnKH2);
		
		
		//jpanell Quản lí cây ATM
		JPanel pnATM=new JPanel();
		pnATM.setBackground(Color.ORANGE);
		
		
		
		//jpanel quản lí giao dịch
		JPanel pnGiaoDich = new JPanel();
		pnGiaoDich.setBackground(Color.darkGray);
		
		
		
		//jpanel Thống kê báo cáo
		JPanel pnThongKe = new JPanel();
		pnThongKe.setBackground(Color.PINK);
		
		
		
		// thêm vào tab chính
		myTabled.add(pnKhachHang,"Quản lí khach hàng");
		myTabled.add(pnATM,"Quản lí ATM");
		myTabled.add(pnGiaoDich, "Quản lí Giao Dịch");
		myTabled.add(pnThongKe, "Thống kê báo cáo");
		
		con.add(myTabled);
	}
	public void showWindow() {
		this.setSize(900, 650);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
