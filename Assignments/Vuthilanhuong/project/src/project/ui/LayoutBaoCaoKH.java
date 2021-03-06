package project.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;

import project.model.ConnectDB;
import project.model.DiaChiDB;
import project.model.KhachHang;
import project.model.KhachHangDB;

@SuppressWarnings("serial")
public class LayoutBaoCaoKH extends JPanel{
	JTextField txtMaKhach, txtSoNha, txtTenK;
	@SuppressWarnings("rawtypes")
	JComboBox cbQuan, cbPhuong;
	JButton btnXem,btnHuy;
	DefaultTableModel dm=new DefaultTableModel();
	final JTable tbl=new JTable(dm);
	JScrollPane sc=new JScrollPane(tbl);
	static ConnectDB myDb = new ConnectDB();
	@SuppressWarnings("static-access")
	Connection conn = myDb.getConnect("localhost", "ffse1703001", "huong", "12345");
	DiaChiDB diachiDb = new DiaChiDB();
	KhachHangDB khDb = new KhachHangDB();
	ArrayList<KhachHang> arrKhachHang = new ArrayList<KhachHang>();
	ArrayList<String> arrDiaChi = new ArrayList<String>();
	@SuppressWarnings("static-access")
	public LayoutBaoCaoKH() {
		addControll();
		arrKhachHang=khDb.hienThiKH();
		for(KhachHang x:arrKhachHang) {
			String[] row = {x.getMaKhach(),x.getTenKhach(),x.getDiaChiN(),x.getSoDT(),x.getEmailK(),x.getSoThe(),x.getSoTien()};
			dm.addRow(row);
		}
			addEvent();
			
	}
	private void addEvent() {
		// TODO Auto-generated method stub
		txtMaKhach.getDocument().addDocumentListener(eventTimTheoMa);
		txtTenK.getDocument().addDocumentListener(eventTimTheoTen);
		btnXem.addActionListener(eventTimTheoDiaChi);
		cbQuan.addActionListener(eventHienThiPhuong);
		btnHuy.addActionListener(eventHuy);
	}
	//event hiển thị phường
	ActionListener eventHienThiPhuong = new ActionListener() {

		@SuppressWarnings("unchecked")
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int key= cbQuan.getSelectedIndex();
			arrDiaChi= diachiDb.hienThiPhuong(key);
			cbPhuong.removeAllItems();
			cbPhuong.addItem("Tât cả");
			for(String x:arrDiaChi) {
				cbPhuong.addItem(x);
				
			}
		}

	};
	ActionListener eventTimTheoDiaChi = new ActionListener() {
		//event tìm kiếm theo địa chỉ
		@Override
		public void actionPerformed(ActionEvent arg0) {
			ArrayList<KhachHang>arrKh= new ArrayList<KhachHang>();
			String duong = txtSoNha.getText();
			String quan = cbQuan.getSelectedItem().toString();
			int keyQuan= cbQuan.getSelectedIndex();
			String phuong = cbPhuong.getSelectedItem().toString();
			int keyPhuong = cbPhuong.getSelectedIndex();
			
			if(keyQuan==0) {
				quan = "";
				phuong = "";
				arrKh = khDb.timTheoDiaChi(duong, quan, phuong);
				
			}else if (keyPhuong==0) {
				phuong = "";
				arrKh = khDb.timTheoDiaChi(duong, quan, phuong);
			}else {
				arrKh = khDb.timTheoDiaChi(duong, quan, phuong);
			}
			dm.setRowCount(0);
			for(KhachHang x:arrKh) {
				String[] row = {x.getMaKhach(),x.getTenKhach(),x.getDiaChiN(),x.getSoDT(),x.getEmailK(),x.getSoThe(),x.getSoTien()};
				dm.addRow(row);
			}
			
		}

	};
	
	private DocumentListener eventTimTheoMa = new DocumentListener() {		
		@Override
		//event tìm kiếm theo mã
		public void changedUpdate(DocumentEvent e) {
			searchCode();
		}
		@Override
		public void insertUpdate(DocumentEvent e) {
			searchCode();
		}
		@Override
		public void removeUpdate(DocumentEvent e) {	
			searchCode();
			
		}
	};
	
	public void searchCode() {
		String ma =  txtMaKhach.getText();
		ArrayList<KhachHang> arrKh = new ArrayList <KhachHang>();
		arrKh = khDb.timTheoMa(ma);
		dm.setRowCount(0);
		for(KhachHang x:arrKh) {
			String[] row = {x.getMaKhach(),x.getTenKhach(),x.getDiaChiN(),x.getSoDT(),x.getEmailK(),x.getSoThe(),x.getSoTien()};
			dm.addRow(row);
		}
	}
	//event tìm theo tên
	private DocumentListener eventTimTheoTen = new DocumentListener() {		
		@Override
		public void changedUpdate(DocumentEvent e) {
			timTen();
		}
		@Override
		public void insertUpdate(DocumentEvent e) {
			timTen();
		}
		@Override
		public void removeUpdate(DocumentEvent e) {	
			timTen();
			
		}
	};
	
	public void timTen() {
		String ten =  txtTenK.getText();
		ArrayList<KhachHang> arrKh = new ArrayList <KhachHang>();
		arrKh = khDb.timTheoTen(ten);
		dm.setRowCount(0);
		for(KhachHang x:arrKh) {
			String[] row = {x.getMaKhach(),x.getTenKhach(),x.getDiaChiN(),x.getSoDT(),x.getEmailK(),x.getSoThe(),x.getSoTien()};
			dm.addRow(row);
		}
	}
	//sự kiện set ô JTextF về trống và in ra bảng
	ActionListener eventHuy = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			dm.setRowCount(0);
			for(KhachHang x:arrKhachHang) {
				String[] row = {x.getMaKhach(),x.getTenKhach(),x.getDiaChiN(),x.getSoDT(),x.getEmailK(),x.getSoThe(),x.getSoTien()};
				dm.addRow(row);
			}
			txtMaKhach.setText("");
			txtTenK.setText("");
			 txtSoNha.setText("");
			cbQuan.setSelectedIndex(0);
			cbPhuong.setSelectedIndex(0);
		}

	};
	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void addControll() {
		// TODO Auto-generated method stub
		Border border5=BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle5=BorderFactory.createTitledBorder(border5, "Báo cáo khách hàng");
		this.setBorder(borderTitle5);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		//JPanel chính
		JPanel pnChinh = new JPanel();
		//JPanel chứa các ô JTextF 
		JPanel pnChinh1 = new JPanel();
		pnChinh1.setLayout(new BoxLayout(pnChinh1, BoxLayout.X_AXIS));
		//JPanel mã
		JPanel pnMaK = new JPanel();
		JLabel lblMaKhach = new JLabel("Mã Khách: ");
		lblMaKhach.setPreferredSize(new Dimension(90, 20));
		txtMaKhach = new JTextField(15);
		pnMaK.add(lblMaKhach);
		pnMaK.add(txtMaKhach);
		pnChinh1.add(pnMaK);
		//JPanel tên khách
		JPanel pnTenK = new JPanel();
		JLabel lblTenK = new JLabel("Tên khách: ");
		lblTenK.setPreferredSize(new Dimension(90, 20));
		txtTenK = new JTextField(15);
		pnTenK.add(lblTenK);
		pnTenK.add(txtTenK);
		pnChinh1.add(pnTenK);
		//JPanel chứa các ô JTextF và các ô comboBox
		JPanel pnDiaChiChinh = new JPanel();
		pnDiaChiChinh.setLayout(new BoxLayout(pnDiaChiChinh, BoxLayout.Y_AXIS));
		Border border8=BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle8=BorderFactory.createTitledBorder(border8, "Địa chỉ khách");
		pnDiaChiChinh.setBorder(borderTitle8);
		//JPanel số nhà
		JPanel pnSoNha = new JPanel();
		JLabel lblSoNha = new JLabel("Địa Chỉ: ");
		lblSoNha.setPreferredSize(new Dimension(90, 20));
		txtSoNha = new JTextField(20);
		pnSoNha.add(lblSoNha);
		pnSoNha.add(txtSoNha);
		pnDiaChiChinh.add(pnSoNha);
		//JPanel quận
		JPanel pnQuan = new JPanel();
		JLabel lblQuan = new JLabel("Chọn quận: ");
		lblQuan.setPreferredSize(new Dimension(90, 20));
		cbQuan = new JComboBox();
		cbQuan.setPreferredSize(new Dimension(165, 20));
		arrDiaChi = diachiDb.hienThiQuan();
		cbQuan.addItem("Tât cả");
		for(String x: arrDiaChi) {
			cbQuan.addItem(x);
		}
		pnQuan.add(lblQuan);
		pnQuan.add(cbQuan);
		pnDiaChiChinh.add(pnQuan);
		//JPanel phường
		JPanel pnPhuong = new JPanel();
		JLabel lblPhuong = new JLabel("Chọn phường: ");
		lblPhuong.setPreferredSize(new Dimension(90, 20));
		cbPhuong = new JComboBox();
		cbPhuong.addItem("Tất cả");
		cbPhuong.setPreferredSize(new Dimension(165, 20));
		pnPhuong.add(lblPhuong);
		pnPhuong.add(cbPhuong);
		pnDiaChiChinh.add(pnPhuong);
	
		//JPanel chứa các JButton
		JPanel pnFlow=new JPanel();
		pnFlow.setLayout(new FlowLayout());
		pnFlow.setBackground(Color.PINK);
		btnXem=new JButton("Xem");
		btnHuy=new JButton("Hủy");
		pnFlow.add(btnXem);
		pnFlow.add(btnHuy);
		
		//JPanel hiển thị bảng
		JPanel pnBang5 = new JPanel();
		Border border3=BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder borderTitle3=BorderFactory.createTitledBorder(border3, "Hiển Thị Thông Tin Khách Hàng");
		pnBang5.setBorder(borderTitle3);
		dm.addColumn("Mã");
		dm.addColumn("Tên");
		dm.addColumn("Địa Chỉ");
		dm.addColumn("SĐT");
		dm.addColumn("Email");
		dm.addColumn("Số Thẻ");
		dm.addColumn("Số Dư");
		pnBang5.setLayout(new BorderLayout());
		pnBang5.add(sc,BorderLayout.CENTER);
		
		
		pnChinh1.add(pnDiaChiChinh);
		pnChinh.add(pnChinh1);
		this.add(pnChinh);
		
		this.add(pnFlow);
		this.add(pnBang5);
	}

	
	
}
