package quanlytiendien.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import quanlytiendien.model.*;


public class QuanLy extends JFrame {
	JTextField txtTen, txtMa, txtSCT, txtDiaChi,txtTimKiem;
	JButton btnThem, btnSua, btnXoa, btnThoat, btnReset, btnTimKiem;
	DefaultTableModel dm=new DefaultTableModel();
	final JTable tbl=new JTable(dm);
	ArrayList <KhachHang> arrKH = new ArrayList<KhachHang>();
	public QuanLy(String title){
		super(title);
		addControls();
		addEvents();
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
		txtTen = new JTextField(15);
		
		pnTen.add(lblTen);
		pnTen.add(txtTen);
		pnNhap.add(pnTen);
		
		JPanel pnMa = new JPanel();
		JLabel lblMa = new JLabel("Mã khách hàng: ");
		 txtMa = new JTextField(15);
		
		pnMa.add(lblMa);
		pnMa.add(txtMa);
		pnNhap.add(pnMa);
		
		JPanel pnSCT = new JPanel();
		JLabel lblSCT = new JLabel("Số công tơ khách hàng: ");
		txtSCT = new JTextField(15);
		
		pnSCT.add(lblSCT);
		pnSCT.add(txtSCT);
		pnNhap.add(pnSCT);
		
		JPanel pnDiaChi = new JPanel();
		JLabel lblDiaChi = new JLabel("Địa chỉ khách hàng: ");
		txtDiaChi = new JTextField(15);
		
		pnDiaChi.add(lblDiaChi);
		pnDiaChi.add(txtDiaChi);
		pnNhap.add(pnDiaChi);
		
		JPanel pnFlow=new JPanel();
		 btnThem=new JButton("Thêm");
		 btnSua=new JButton("Sửa");
		 btnXoa=new JButton("Xóa");
		 btnThoat=new JButton("Thoát");
		 btnReset=new JButton("Reset");
		pnFlow.add(btnThem);
		pnFlow.add(btnSua);
		pnFlow.add(btnXoa);
		pnFlow.add(btnThoat);
		pnFlow.add(btnReset);
		pnNhap.add(pnFlow);
		
		
		JPanel pnBangC = new JPanel();
		JPanel pnTimKiem = new JPanel();
		
		txtTimKiem = new JTextField(15);
		pnTimKiem.add(txtTimKiem);
		 btnTimKiem =new JButton("Tìm Kiếm");
		pnTimKiem.add(btnTimKiem);
		JPanel pnBang = new JPanel();
		
		dm.addColumn("Tên");
		dm.addColumn("Mã");
		dm.addColumn("SCT");
		dm.addColumn("Địa Chỉ");
		
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
		btnThem.addActionListener(eventThem);
		btnSua.addActionListener(eventSua);
		btnXoa.addActionListener(eventXoa);
		btnThoat.addActionListener(eventThoat);
		btnReset.addActionListener(eventReset);
		btnTimKiem.addActionListener(eventTimKiem);
		tbl.addMouseListener(eventChooseRow);
	}
	MouseAdapter eventChooseRow = new MouseAdapter() {
    	public void mouseClicked(MouseEvent e) {
    		txtMa.setEditable(false);
    		int col = tbl.getSelectedRow();
    		String ten =  (String) tbl.getValueAt(col, 0);
    		String ma =  (String) tbl.getValueAt(col, 1);
    		String sct =  (String) tbl.getValueAt(col, 2);
    		String diaC =  (String) tbl.getValueAt(col, 3);
    		txtMa.setText(ten);
    		txtTen.setText(ma);
    		txtSCT.setText(sct);
    		txtDiaChi.setText(diaC);
    		btnSua.setEnabled(true);
			btnXoa.setEnabled(true);
			btnThem.setEnabled(false);
    	}
 };
	ActionListener eventThem = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String ma = txtTen.getText();
			String ten = txtMa.getText();
			String sct = txtSCT.getText();
			String diaC = txtDiaChi.getText();
			if (ma.isEmpty()||ten.isEmpty()||sct.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Chưa nhập",
		                  "Lỗi", JOptionPane.WARNING_MESSAGE);
			}else {
				arrKH.add(new KhachHang(ma,ten,sct,diaC));
				dm.addRow(new String[]{ma, ten, sct,diaC});
				txtMa.setText("");
				txtTen.setText("");
				txtSCT.setText("");
				txtDiaChi.setText("");
				btnSua.setEnabled(false);
				btnXoa.setEnabled(false);
			
		}
		}
		
	};
	ActionListener eventSua = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	};
	
	ActionListener eventXoa = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	};
	ActionListener eventThoat = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.exit(0);
		}
		
	};
	ActionListener eventReset = new ActionListener() {
		

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			btnThem.setEnabled(true);
			btnSua.setEnabled(false);
			btnXoa.setEnabled(false);
			btnThoat.setEnabled(true);
			txtMa.setText("");
			txtTen.setText("");
			txtSCT.setText("");
			txtDiaChi.setText("");
			txtMa.setEditable(true);
			
		}
		
	};
	ActionListener eventTimKiem = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	};
	public void showWindow()
	{
		this.setSize(900, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		btnSua.setEnabled(false);
		btnXoa.setEnabled(false);
}
}
