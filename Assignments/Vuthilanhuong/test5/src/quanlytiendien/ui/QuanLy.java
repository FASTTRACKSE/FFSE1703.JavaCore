package quanlytiendien.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class QuanLy extends JFrame {
	public  QuanLy(String title){
		super(title);
		addEvents();
		addControls();
	}

	private void addControls() {
		// TODO Auto-generated method stub
		Container con=getContentPane();
		JPanel pnChinh=new JPanel();
		
		pnChinh.setLayout(new BoxLayout(pnChinh, BoxLayout.Y_AXIS));
		
		JPanel pnTieuDe = new JPanel();
		JLabel lblTieuDe=new JLabel("Chương trình quản lý khách hàng");
		Font font=new Font("Arial", Font.BOLD,20);
		lblTieuDe.setFont(font);
		pnTieuDe.add(lblTieuDe);
	
		
		JPanel pnNoiDung = new JPanel();
		pnNoiDung.setLayout(new BoxLayout(pnNoiDung, BoxLayout.X_AXIS));
		
		JPanel pnNhap = new JPanel();
		pnNhap.setLayout(new BoxLayout(pnNhap, BoxLayout.Y_AXIS));
		
		JPanel pnTen = new JPanel();
		JLabel lblTen = new JLabel("Tên khách hàng: ");
		JTextField txtTen = new JTextField(15);
		
		pnTen.add(lblTen);
		pnTen.add(txtTen);
		pnNhap.add(pnTen);
		
		JPanel pnMa = new JPanel();
		JLabel lblMa = new JLabel("Mã khách hàng: ");
		JTextField txtMa = new JTextField(15);
		
		pnMa.add(lblMa);
		pnMa.add(txtMa);
		pnNhap.add(pnMa);
		
		JPanel pnSCT = new JPanel();
		JLabel lblSCT = new JLabel("Số công tơ khách hàng: ");
		JTextField txtSCT = new JTextField(15);
		
		pnSCT.add(lblSCT);
		pnSCT.add(txtSCT);
		pnNhap.add(pnSCT);
		
		JPanel pnDiaChi = new JPanel();
		JLabel lblDiaChi = new JLabel("Địa chỉ khách hàng: ");
		JTextField txtDiaChi = new JTextField(15);
		
		pnDiaChi.add(lblDiaChi);
		pnDiaChi.add(txtDiaChi);
		pnNhap.add(pnDiaChi);
		
		JPanel pnFlow=new JPanel();
		JButton btn1=new JButton("FlowLayout");
		JButton btn2=new JButton("Add các control");
		JButton btn3=new JButton("Trên 1 dòng");
		JButton btn4=new JButton("Hết chỗ chứa");
		JButton btn5=new JButton("Thì xuống dòng");
		pnFlow.add(btn1);pnFlow.add(btn2);
		pnFlow.add(btn3);pnFlow.add(btn4);
		pnFlow.add(btn5);
		pnNhap.add(pnFlow);
		
		
		JPanel pnBangC = new JPanel();
		JPanel pnTimKiem = new JPanel();
		
		JTextField txtTimKiem = new JTextField(15);
		pnTimKiem.add(txtTimKiem);
		JButton btnTimKiem =new JButton("Tìm Kiếm");
		pnTimKiem.add(btnTimKiem);
		JPanel pnBang = new JPanel();
		DefaultTableModel dm=new DefaultTableModel();
		dm.addColumn("Tên");
		dm.addColumn("Mã");
		dm.addColumn("SCT");
		dm.addColumn("Địa Chỉ");
		final JTable tbl=new JTable(dm);
		JScrollPane sc=new JScrollPane(tbl);
		pnBang.setLayout(new BorderLayout());
		pnBang.add(sc,BorderLayout.CENTER);
		
		pnBangC.add(pnTimKiem);	
		pnBangC.add(pnBang);
		pnNoiDung.add(pnNhap);
		pnNoiDung.add(pnBangC);
		
		pnChinh.add(pnTieuDe);
		pnChinh.add(pnNoiDung);
		con.add(pnChinh);
	}

	private void addEvents() {
		// TODO Auto-generated method stub
		
	}
	public void showWindow()
	{
		this.setSize(600, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
}
}
