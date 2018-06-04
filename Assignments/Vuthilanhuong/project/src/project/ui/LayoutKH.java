package project.ui;
import java.util.ArrayList;
import project.model.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;



@SuppressWarnings("serial")
public class LayoutKH extends JFrame {
	JTextField txtMaK, txtTenK, txtDiaChi, txtDienThoai, txtEmail, txtSoThe, txtTaiKhoan, txtTimKiem;
	@SuppressWarnings("rawtypes")
	JComboBox cbQuan, cbPhuong, cboTimKiem;
	JButton btnThem, btnSua, btnXoa, btnHuy;
	DefaultTableModel dm = new DefaultTableModel();
	final JTable tbl = new JTable(dm);
	JScrollPane sc = new JScrollPane(tbl);
	static ConnectDB myDb = new ConnectDB();
	@SuppressWarnings("static-access")
	Connection conn = myDb.getConnect("localhost", "ffse1703001", "huong", "12345");
	DiaChiDB diachiDb = new DiaChiDB();
	ArrayList<String> arrDiaChi = new ArrayList<String>();
	KhachHangDB khDb = new KhachHangDB();
	ArrayList<KhachHang> arrKhachHang = new ArrayList<KhachHang>();
	@SuppressWarnings("static-access")
	public LayoutKH(String title) {
		super(title);
		addControll();
		arrKhachHang=khDb.hienThiKH();
		for(KhachHang x:arrKhachHang) {
			String[] row = {x.getMaKhach(),x.getTenKhach(),x.getDiaChiN(),x.getSoDT(),x.getEmailK(),x.getSoThe(),x.getSoTien()};
			dm.addRow(row);
		}
		addEvent();
	}

	private void addEvent() {

		btnThem.addActionListener(eventThem);
		btnSua.addActionListener(eventSua);
		btnXoa.addActionListener(eventXoa);
		btnHuy.addActionListener(eventHuy);
		tbl.addMouseListener(eventChooseRow);
		cbQuan.addActionListener(eventHienThiPhuong);
		txtTimKiem.getDocument().addDocumentListener(eventTimTheoMa);
	}
	//event hiển thị phường 
	ActionListener eventHienThiPhuong = new ActionListener() {

		@SuppressWarnings("unchecked")
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int key= cbQuan.getSelectedIndex();
			arrDiaChi= diachiDb.hienThiPhuong(key);
			cbPhuong.removeAllItems();
			for(String x:arrDiaChi) {
				cbPhuong.addItem(x);
				
			}
		}

	};
	//sự kiện click vào các dòng trong bảng table
	 MouseAdapter eventChooseRow = new MouseAdapter() {
	    	public void mouseClicked(MouseEvent e) {
	    		/*Lấy dòng được chọn trong table*/
	    		btnSua.setEnabled(true);
				btnXoa.setEnabled(true);
				btnThem.setEnabled(false);
	    		int col = tbl.getSelectedRow();
	    		
	    		String ma =  (String) tbl.getValueAt(col, 0);
	    		String ten = (String) tbl.getValueAt(col,1);
	    		String dc = (String) tbl.getValueAt(col,2);
	    		String sdt = (String) tbl.getValueAt(col,3);
	    		String email = (String) tbl.getValueAt(col,4);
	    		String soThe = (String) tbl.getValueAt(col,5);
	    		String soTien = (String) tbl.getValueAt(col,6);
	    		
	    		
	    		/*Nếu đã chọn dòng trên table thì col sẽ lớn hơn giá trị mặc định là -1*/ 
	    		if(col>-1) {
	    			/*Duyệt mảng từ arraylist để đặt giá trị vào ô quận phường*/
	    			for(KhachHang x:arrKhachHang) {
		    			if(ma.equals(x.getMaKhach())) {
		    				cbQuan.setSelectedItem(x.getChonQuan());
		    				cbPhuong.setSelectedItem(x.getChonPhuong());
		    			}
		    		}
	    			/*đặt giá trị cho các ô textfield*/
	    			txtMaK.setText(ma);
	    			txtMaK.setEditable(false);
		    		txtTenK.setText(ten);
		    		txtDiaChi.setText(dc);
		    		txtDienThoai.setText(sdt);
		    		txtEmail.setText(email);
		    		txtSoThe.setText(soThe);
		    		txtSoThe.setEditable(false);
		    		txtTaiKhoan.setText(soTien);
	    		}
	    		
	    		
	    	}
	 };

	ActionListener eventThem = new ActionListener() {

		@SuppressWarnings("static-access")
		@Override
		public void actionPerformed(ActionEvent arg0) {
		try {
			String maKh = txtMaK.getText();
			String tenKh= txtTenK.getText();
			String diaChiKh = txtDiaChi.getText();
			String dienThoaiKh =txtDienThoai.getText();
			String emailKh =txtEmail.getText();
			String sotheKh =txtSoThe.getText();
			String taiKhoanKh =txtTaiKhoan.getText();
			String quanKh =(String) cbQuan.getSelectedItem();
			int keyQuan = cbQuan.getSelectedIndex();
			String phuongKh =(String) cbPhuong.getSelectedItem();
			if(maKh.isEmpty()||tenKh.isEmpty()||diaChiKh.isEmpty()||dienThoaiKh.isEmpty()||emailKh.isEmpty()||sotheKh.isEmpty()||taiKhoanKh.isEmpty()||keyQuan==0) {
				JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin");
			}else {
				KhachHang khachHang=new KhachHang();
				khachHang.add(maKh,tenKh,diaChiKh,dienThoaiKh,emailKh,sotheKh,taiKhoanKh,quanKh,phuongKh);
				//đưa gt qua class KhachHangDB để xử lý thêm dữ liệu vào database
				khDb.themKhachHang(khachHang);
				
				// làm các input về trống
				txtMaK.setText("");
				txtTenK.setText("");
				txtDiaChi.setText("");
				txtDienThoai.setText("");
				txtEmail.setText("");
				txtSoThe.setText("");
				txtTaiKhoan.setText("");
				cbQuan.setSelectedIndex(0);
				
				// thêm cột trong table list
				String[] row = {khachHang.getMaKhach(),khachHang.getTenKhach(),khachHang.getDiaChiN(),khachHang.getSoDT(),khachHang.getEmailK(),khachHang.getSoThe(),khachHang.getSoTien()};
				dm.addRow(row);
			}
			
		
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Nhập sai thông tin");
		}
			
		}	

	};
	
	ActionListener eventSua = new ActionListener() {

		@SuppressWarnings("static-access")
		@Override
		public void actionPerformed(ActionEvent e) {
			//Lấy giá trị từ textField đưa vào mảng kh
			try {
				btnSua.setEnabled(false);
				btnXoa.setEnabled(false);
				String maKh = txtMaK.getText();
				
				String tenKh= txtTenK.getText();
				String diaChiKh = txtDiaChi.getText();
				String dienThoaiKh =txtDienThoai.getText();
				String emailKh =txtEmail.getText();
				String sotheKh =txtSoThe.getText();
				String taiKhoanKh =txtTaiKhoan.getText();
				String quanKh =(String) cbQuan.getSelectedItem();
				int keyQuan = cbQuan.getSelectedIndex();
				String phuongKh =(String) cbPhuong.getSelectedItem();
				if(maKh.isEmpty()||tenKh.isEmpty()||diaChiKh.isEmpty()||dienThoaiKh.isEmpty()||emailKh.isEmpty()||sotheKh.isEmpty()||taiKhoanKh.isEmpty()||keyQuan==0) {
					JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin");
				}else {
					KhachHang khachHang=new KhachHang();
					khachHang.add(maKh,tenKh,diaChiKh,dienThoaiKh,emailKh,sotheKh,taiKhoanKh,quanKh,phuongKh);
					
					//gọi lệnh suaKhachHang từ class KhachHangDB
					khDb.suaKhachHang(khachHang);
					//set bảng về trống
					dm.setRowCount(0);
					//chạy lại bảng từ arrayList
					arrKhachHang=khDb.hienThiKH();
					for(KhachHang x:arrKhachHang) {
						String[] row = {x.getMaKhach(),x.getTenKhach(),x.getDiaChiN(),x.getSoDT(),x.getEmailK(),x.getSoThe(),x.getSoTien()};
						dm.addRow(row);
					}
					//set ô input về trống
					txtMaK.setText("");
					txtTenK.setText("");
					txtDiaChi.setText("");
					txtDienThoai.setText("");
					txtEmail.setText("");
					txtSoThe.setText("");
					txtTaiKhoan.setText("");
					cbQuan.setSelectedIndex(0);
					txtMaK.setEditable(true);
					txtSoThe.setEditable(true);
					btnThem.setEnabled(true);
				}			
			}catch (Exception x){
				JOptionPane.showMessageDialog(null, "Nhập sai thông tin");
			}
			
		}
		
	};
	ActionListener eventXoa = new ActionListener() {

		@SuppressWarnings("static-access")
		@Override
		public void actionPerformed(ActionEvent e) {
			btnSua.setEnabled(false);
			btnXoa.setEnabled(false);
			String maK = txtMaK.getText();
			khDb.xoaKhachHang(maK);
			int row;
			row = tbl.getSelectedRow();
			if(row>-1) {
				dm.removeRow(row);
				
			}
			//set ô input về trống
			txtMaK.setText("");
			txtTenK.setText("");
			txtDiaChi.setText("");
			txtDienThoai.setText("");
			txtEmail.setText("");
			txtSoThe.setText("");
			txtTaiKhoan.setText("");
			cbQuan.setSelectedIndex(0);
			txtMaK.setEditable(true);
			txtSoThe.setEditable(true);
			btnThem.setEnabled(true);
		}
	};
	
	
	ActionListener eventHuy = new ActionListener() {
		

		@Override
		public void actionPerformed(ActionEvent arg0) {
			btnSua.setEnabled(false);
			btnXoa.setEnabled(false);
			btnThem.setEnabled(true);
			btnHuy.setEnabled(true);
			
			//sự kiện huỷ đưa các ô JTextField về trống
			txtMaK.setEditable(true);
			txtSoThe.setEditable(true);
			txtMaK.setText("");
			txtTenK.setText("");
			txtDiaChi.setText("");
			txtDienThoai.setText("");
			txtEmail.setText("");
			txtSoThe.setText("");
			txtTaiKhoan.setText("");
			cbQuan.setSelectedIndex(0);

		}

	};
	
	
	private DocumentListener eventTimTheoMa = new DocumentListener() {		
		@Override
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
	//sự kiện tìm theo mã từ mảng arrKh
	public void searchCode() {
		String ma =  txtTimKiem.getText();
		ArrayList<KhachHang> arrKh = new ArrayList <KhachHang>();
		arrKh = khDb.timTheoMa(ma);
		dm.setRowCount(0);
		for(KhachHang x:arrKh) {
			String[] row = {x.getMaKhach(),x.getTenKhach(),x.getDiaChiN(),x.getSoDT(),x.getEmailK(),x.getSoThe(),x.getSoTien()};
			dm.addRow(row);
		}
	}
	

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void addControll() {
		Container con = getContentPane();
		JPanel pnMain= new JPanel();
		pnMain.setLayout(new BorderLayout());
		JTabbedPane myTabled = new JTabbedPane();
		
		//JPanel chính
		JPanel quanLyKh = new JPanel();
		myTabled.add(quanLyKh, "Quản lý khách hàng");
		quanLyKh.setLayout(new BoxLayout(quanLyKh, BoxLayout.Y_AXIS));
		
		//JPanel thông tinkhachs hàng chứa các ô JTextF và các comboBox
		JPanel thongTinK =new JPanel();
		thongTinK.setPreferredSize(new Dimension(1050, 180));
		thongTinK.setLayout(new BoxLayout(thongTinK, BoxLayout.X_AXIS));
		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Thông Tin Khách Hàng");
		thongTinK.setBorder(borderTitle);
		
		
		//JPanel chứa các ô JTextF và jLabel
		JPanel pnC1 =new JPanel();
		
		//JPanel mã khách
		JPanel pnMaK = new JPanel();
		JLabel lblMaK = new JLabel("Mã Khách: ");
		lblMaK.setPreferredSize(new Dimension(90, 20));
		txtMaK = new JTextField(15);
		pnMaK.add(lblMaK);
		pnMaK.add(txtMaK);
		pnC1.add(pnMaK);
		
		//JPanel tên khách
		JPanel pnKhach = new JPanel();
		JLabel lblTenK = new JLabel("Tên khách: ");
		lblTenK.setPreferredSize(new Dimension(90, 20));
		txtTenK = new JTextField(15);
		// pnKhach.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
		pnKhach.add(lblTenK);
		pnKhach.add(txtTenK);
		pnC1.add(pnKhach);
		
		//JPanel số  thẻ
		JPanel pnSoThe = new JPanel();
		JLabel lblSoThe = new JLabel("Số thẻ ATM: ");
		lblSoThe.setPreferredSize(new Dimension(90, 20));
		txtSoThe = new JTextField(15);
		pnSoThe.add(lblSoThe);
		pnSoThe.add(txtSoThe);
		pnC1.add(pnSoThe);
		
		//JPanel chứa các thông tin về địa chỉ khách
		JPanel pnC2 = new JPanel();
		//JPanel địa chỉ khách
		JPanel pnDiaChi = new JPanel();
		JLabel lblDiaChi = new JLabel("Địa Chỉ nhà: ");
		lblDiaChi.setPreferredSize(new Dimension(90, 20));
		txtDiaChi = new JTextField(20);
		pnDiaChi.add(lblDiaChi);
		pnDiaChi.add(txtDiaChi);
		pnC2.add(pnDiaChi);
		//JPanel chọn quận
		JPanel pnQuan = new JPanel();
		JLabel lblQuan = new JLabel("Chọn quận: ");
		lblQuan.setPreferredSize(new Dimension(90, 20));
		cbQuan = new JComboBox();
		cbQuan.setPreferredSize(new Dimension(165, 20));
		arrDiaChi = diachiDb.hienThiQuan();
		cbQuan.addItem("Chọn Quận");
		for(String x: arrDiaChi) {
			cbQuan.addItem(x);
		}
		pnQuan.add(lblQuan);
		pnQuan.add(cbQuan);
		pnC2.add(pnQuan);
		//JPanel chọn phường
		JPanel pnPhuong = new JPanel();
		JLabel lblPhuong = new JLabel("Chọn phường: ");
		lblPhuong.setPreferredSize(new Dimension(90, 20));
		cbPhuong = new JComboBox();
		cbPhuong.setPreferredSize(new Dimension(165, 20));
		
		pnPhuong.add(lblPhuong);
		pnPhuong.add(cbPhuong);
		pnC2.add(pnPhuong);
		
		
		//JPanel chưa thông tin liên lạc của khách
		JPanel pnC3 =new JPanel();
		//JPanel số điện thoại
		JPanel pnDienThoai = new JPanel();
		JLabel lblDienThoai = new JLabel("Số điện thoại: ");
		lblDienThoai.setPreferredSize(new Dimension(90, 20));
		txtDienThoai = new JTextField(15);
		pnDienThoai.add(lblDienThoai);
		pnDienThoai.add(txtDienThoai);
		pnC3.add(pnDienThoai);
		
		//JPanel email
		JPanel pnEmail = new JPanel();
		JLabel lblEmail = new JLabel("Email khách: ");
		lblEmail.setPreferredSize(new Dimension(90, 20));
		txtEmail = new JTextField(15);
		pnEmail.add(lblEmail);
		pnEmail.add(txtEmail);
		pnC3.add(pnEmail);
		
		//JPanel tài khoản
		JPanel pnTaiKhoan = new JPanel();
		JLabel lblTaiKhoan = new JLabel("Tài khoản: ");
		lblTaiKhoan.setPreferredSize(new Dimension(90, 20));
		txtTaiKhoan = new JTextField(15);
		pnTaiKhoan.add(lblTaiKhoan);
		pnTaiKhoan.add(txtTaiKhoan);
		pnC3.add(pnTaiKhoan);
		
		//JPanel chứa các JButton
		JPanel pnFlow = new JPanel();
		pnFlow.setLayout(new FlowLayout());
		pnFlow.setBackground(Color.PINK);
		btnThem = new JButton("Thêm");
		btnSua = new JButton("Sửa");
		btnXoa = new JButton("Xóa");
		btnHuy = new JButton("Hủy");
		btnSua.setEnabled(false);
		btnXoa.setEnabled(false);
		pnFlow.add(btnThem);
		pnFlow.add(btnSua);
		pnFlow.add(btnXoa);
		pnFlow.add(btnHuy);

		JPanel pnBang3 = new JPanel();
		Border border3 = BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder borderTitle3 = BorderFactory.createTitledBorder(border3, "Hiển Thị Thông Tin Khách Hàng");
		pnBang3.setBorder(borderTitle3);
		
		dm.addColumn("Mã");
		dm.addColumn("Tên");
		dm.addColumn("Địa Chỉ");
		dm.addColumn("SĐT");
		dm.addColumn("Email");
		dm.addColumn("Số Thẻ");
		dm.addColumn("Số Dư");
		pnBang3.setLayout(new BorderLayout());
		pnBang3.add(sc, BorderLayout.CENTER);
		
		
		JPanel pnC4 = new JPanel();
		JPanel pnTimKiem = new JPanel();
		Border borderTK = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitleTK = BorderFactory.createTitledBorder(borderTK, "Tìm kiếm ");
		pnTimKiem.setBorder(borderTitleTK);
		JLabel lblTimKiem= new JLabel("Tìm theo mã: ");
		txtTimKiem = new JTextField(15);
		pnTimKiem.add(lblTimKiem);
		pnTimKiem.add(txtTimKiem);
		pnC4.add(pnTimKiem);
		
		quanLyKh.add(pnC4);
		thongTinK.add(pnC1);
		thongTinK.add(pnC2);
		thongTinK.add(pnC3);
		quanLyKh.add(thongTinK);
		quanLyKh.add(pnFlow);
		quanLyKh.add(pnBang3);
		
		LayoutBaoCaoKH pnBaoCaoKH = new LayoutBaoCaoKH();
		myTabled.add(pnBaoCaoKH, "Báo cáo khách hàng");
		
		LayoutTinhHinhRutTien pnThRutTien = new LayoutTinhHinhRutTien();
		myTabled.add(pnThRutTien, "Quản lý giao dịch");

		LayoutATM pnATM = new LayoutATM();
		myTabled.add(pnATM, "Quản lý máy ATM");
		
		LayoutTinhTrangATM pnTTrangATM = new LayoutTinhTrangATM();
		myTabled.add(pnTTrangATM, "Báo cáo tình trạng ATM");

			LayoutGiaoDich pnGiaoDich = new LayoutGiaoDich();
		myTabled.add(pnGiaoDich, "Quản lý giao dịch máy ATM");

		LayoutRutTien pnRutTien = new LayoutRutTien();
		myTabled.add(pnRutTien, "Demo rút tiền");

		pnMain.add(myTabled);
		con.add(pnMain);

		// con.add(pnChinh);
		
	}

	public void showWindow() {
		this.setSize(1050, 700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
}
