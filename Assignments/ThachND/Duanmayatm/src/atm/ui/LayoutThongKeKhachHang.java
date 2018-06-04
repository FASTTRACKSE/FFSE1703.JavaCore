package atm.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import atm.model.GetDatabase;
import atm.model.GetQuanPhuong;
import atm.model.KhachHang;

public class LayoutThongKeKhachHang extends JPanel {
	GetDatabase conn = new GetDatabase();
	Connection db = (Connection) GetDatabase.getConnect();
	DefaultTableModel dm = new DefaultTableModel();
	final JTable tbl = new JTable();
//	{ 
//        public void paintComponent(Graphics g) 
//        { 
//            Dimension d = getSize(); 
//            Image img = this.getToolkit().getImage("image/tpbank.png"); 
//            g.drawImage(img, 0, 0, d.width, d.height, null); 
//
//            setOpaque( false );  // lam trong suot  
//            super.paintComponent(g); 
//        } 
//    };
	JScrollPane sc = new JScrollPane();
	GetQuanPhuong cbItem = new GetQuanPhuong();
	ArrayList<String> arrPhuong = new ArrayList<String>();
	ArrayList<KhachHang> arrKh = new ArrayList<KhachHang>();
	JComboBox<String> cboQuan, cboPhuong;
	JButton btnThem, btnSua, btnXoa, btnHuy, btnSubmit, btnXoatt;
	JTextField txtMaKh, txtEmail, txtTen, txtDiaChi, txtSoTk, txtSoThe, txtSdt, txtSoDu, txtSoTienRut;
	private String tbKh[] = {"Mã Khách Hàng", "Tên Khách Hàng", "Số Điện Thoại", "Email", "Số Tài Khoản", "Số Dư"};
	DefaultTableModel tb = new DefaultTableModel(tbKh, 0);
	public LayoutThongKeKhachHang() {
		addControls();
		addEvent();
		arrKh=select();
	}

	public void addControls() {
		
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setLayout(new BorderLayout());
		
//		Danh sách khách hàng
		JPanel pnLon = new JPanel();
		pnLon.setLayout(new BoxLayout(pnLon, BoxLayout.Y_AXIS));
		
		JPanel pn1 = new JPanel();
		
		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Danh sách Khách Hàng");
		sc.setBorder(borderTitle);
		tbl.setModel(tb);
		tbl.setPreferredScrollableViewportSize(new Dimension(1160, 300));
		sc.setViewportView(tbl);
		sc.setOpaque( false );
		tbl.setOpaque(true);
		tbl.setFillsViewportHeight(true);
//		tbl.setBackground(Color.WHITE);
		pn1.add(sc, BorderLayout.CENTER);
//		pn1.setLayout(new BorderLayout());
//		pn1.setPreferredSize(new Dimension(0, 350));
//		pn1.add(sc, BorderLayout.CENTER);
		
//		Panel kiếm theo địa chỉ và thời gian
		JPanel pn1Right = new JPanel();
		
		Border border2 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle2 = BorderFactory.createTitledBorder(border2, "Tùy chọn Khách Hàng", TitledBorder.CENTER, TitledBorder.DEFAULT_JUSTIFICATION);
		
//		pn1Right.setBorder(borderTitle2);
		
		
		
		
		JLabel lblQuan = new JLabel("        Quận:");
		cboQuan = new JComboBox<String>();
		cboQuan.setPreferredSize(new Dimension(120, 20));
		ArrayList<String> arrquan = new ArrayList<String>();
		cboQuan.addItem("Chọn Quận");
		arrquan = GetQuanPhuong.getQuan();
				for(String x : arrquan) {
				cboQuan.addItem(x);	
				}
		pn1Right.add(lblQuan);
		pn1Right.add(cboQuan);
		
		
		
		JLabel lblPhuong = new JLabel("          Phường: ");
		cboPhuong = new JComboBox<String>();
		cboPhuong.addItem("Chọn Phường");
		cboPhuong.setPreferredSize(new Dimension(120, 20));
		pn1Right.add(lblPhuong);
		pn1Right.add(cboPhuong);
		
		JPanel pnSubmit = new JPanel();
		btnSubmit = new JButton("Submit");
		
		pn1Right.add(pnSubmit);
		pnSubmit.add(btnSubmit);
		
		//In thông tin
		pnLon.add(pn1);
		pnLon.add(pn1Right);
		
		pn1Right.setBorder(new CompoundBorder(new EmptyBorder(0,10,0,0), BorderFactory.createTitledBorder(borderTitle2)));
		
//		pn1Right.setBorder(new CompoundBorder(new EmptyBorder(0,10,0,0), BorderFactory.createTitledBorder(borderTitle2)));
		
//		Danh sách khách hàng
//		JPanel pnLon = new JPanel();
//		pnLon.setLayout(new BoxLayout(pnLon, BoxLayout.X_AXIS));
//		
//		JPanel pn1 = new JPanel();
//		
//		Border border = BorderFactory.createLineBorder(Color.RED);
//		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Danh sách Khách Hàng");
//		pn1.setBorder(borderTitle);
//		dm.addColumn("Mã Khách Hàng");
//		dm.addColumn("Tên Khách Hàng");
//		dm.addColumn("Địa chỉ");
//		dm.addColumn("Số thẻ ATM");
//		dm.addColumn("Số tài khoản");
//		dm.addColumn("Số lần rút tiền");
//		dm.addColumn("Tổng tiền rút(VNĐ)");
//		pn1.setLayout(new BorderLayout());
//		pn1.setPreferredSize(new Dimension(0, 350));
//		pn1.add(sc, BorderLayout.CENTER);
//		
////		Panel tìm kiếm
//		JPanel pn1Right = new JPanel();
//		
//		JPanel pnTim = new JPanel();
//		JPanel pnKiem = new JPanel();
//		//pn1Right.setLayout(new BoxLayout(pn1Right, BoxLayout._AXIS));
//		pn1Right.setLayout(new BoxLayout(pn1Right, BoxLayout.Y_AXIS));
//		Border border2 = BorderFactory.createLineBorder(Color.RED);
//		TitledBorder borderTitle2 = BorderFactory.createTitledBorder(border2, "Tìm kiếm");
//		pn1Right.setBorder(borderTitle2);
//		JTextField txtTimKiem = new JTextField(20);
//		JButton btnTimKiem = new JButton("Tìm");
//		pnTim.setPreferredSize(new Dimension(200,10));
//		pnKiem.setPreferredSize(new Dimension(255,50));
//		pnTim.add(txtTimKiem);
//		pnKiem.add(btnTimKiem);
//		pn1Right.add(pnTim);
//		pn1Right.add(pnKiem);
//		pnLon.add(pn1);
//		pnLon.add(pn1Right);
//		
//		pn1Right.setBorder(new CompoundBorder(new EmptyBorder(0,10,0,0), BorderFactory.createTitledBorder(borderTitle2)));
		
//		JPanel pn2 = new JPanel();
		
		
		// nhập thông tin
		JPanel pn3 = new JPanel();
		pn3.setLayout(new BoxLayout(pn3, BoxLayout.Y_AXIS));
		Border border3 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle3 = BorderFactory.createTitledBorder(border3, "Nhập thông tin");
		pn3.setBorder(borderTitle3);

		JPanel pnLeft = new JPanel();
		pnLeft.setLayout(new BoxLayout(pnLeft, BoxLayout.Y_AXIS));
		
		JPanel pnInfor = new JPanel();
		pnInfor.setLayout(new BoxLayout(pnInfor, BoxLayout.X_AXIS)); 
		
		Border border3n = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle3n = BorderFactory.createTitledBorder(border3n);
		pnLeft.setBorder(borderTitle3n);
		
		JPanel pnLeft1 = new JPanel();
		pnLeft1.setLayout(new BoxLayout(pnLeft1, BoxLayout.Y_AXIS));
		
		JPanel pnMkh = new JPanel();	
		JLabel lblMkh = new JLabel("Mã Khách Hàng:");
		lblMkh.setFont(new Font("Times New Roman", Font.PLAIN,18));
		txtMaKh = new JTextField(20);
		pnMkh.add(lblMkh);
		pnMkh.add(txtMaKh);
		
		JPanel pnEmail = new JPanel();	
		JLabel lblEmail = new JLabel("Email:               ");
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN,18));
		txtEmail = new JTextField(20);
		pnEmail.add(lblEmail);
		pnEmail.add(txtEmail);
		
		JPanel pnTen = new JPanel();	
		JLabel lblTen = new JLabel("Họ & Tên KH:  ");
		lblTen.setFont(new Font("Times New Roman", Font.PLAIN,18));
		txtTen = new JTextField(20);
		pnTen.add(lblTen);
		pnTen.add(txtTen);
		
		JPanel pnDiaChi = new JPanel();	
		JLabel lblDiaChi = new JLabel("Địa Chỉ:            ");
		lblDiaChi.setFont(new Font("Times New Roman", Font.PLAIN,18));
		txtDiaChi = new JTextField(20);
		pnDiaChi.add(lblDiaChi);
		pnDiaChi.add(txtDiaChi);
		
		pnLeft1.add(pnMkh);
		pnLeft1.add(pnEmail);
		pnLeft1.add(pnTen);
		pnLeft1.add(pnDiaChi);
		
		JPanel pnLeft2 = new JPanel();
		pnLeft2.setLayout(new BoxLayout(pnLeft2, BoxLayout.Y_AXIS));
		
		JPanel pnSoTk = new JPanel();
		JLabel lblSoTk = new JLabel("Số TK Ngân Hàng:");
		lblSoTk.setFont(new Font("Times New Roman", Font.PLAIN,18));
		txtSoTk = new JTextField(20);
		pnSoTk.add(lblSoTk);
		pnSoTk.add(txtSoTk);
		
		
		JPanel pnSdt = new JPanel();
		JLabel lblSdt = new JLabel("Điện thoại:            ");
		lblSdt.setFont(new Font("Times New Roman", Font.PLAIN,18));
		txtSdt = new JTextField(20);
		pnSdt.add(lblSdt);
		pnSdt.add(txtSdt);
		
		JPanel pnSoDu = new JPanel();
		JLabel lblSoDu = new JLabel("Số Dư:                 ");
		lblSoDu.setFont(new Font("Times New Roman", Font.PLAIN,18));
		txtSoDu = new JTextField(20);
		pnSoDu.add(lblSoDu);
		pnSoDu.add(txtSoDu);
		
		JPanel pnSoTienRut = new JPanel();
		JLabel lblSoTienRut = new JLabel("Số Tiền Đã Rút:    ");
		lblSoTienRut.setFont(new Font("Times New Roman", Font.PLAIN,18));
		txtSoTienRut = new JTextField(20);
		pnSoTienRut.add(lblSoTienRut);
		pnSoTienRut.add(txtSoTienRut);
		
		JPanel pnXoatt = new JPanel();
		pnXoatt.setLayout(new BoxLayout(pnXoatt, BoxLayout.Y_AXIS));
		btnXoatt = new JButton("Xóa thông tin");
		
		pnXoatt.add(btnXoatt);


		pnLeft2.add(pnSoTk);
		pnLeft2.add(pnSdt);
		pnLeft2.add(pnSoDu);
		pnLeft2.add(pnSoTienRut);
		
		
		pnInfor.add(pnLeft1);
		pnInfor.add(pnLeft2);
		pnLeft.add(pnInfor);
		pnLeft.add(pnXoatt);
		
		pn3.add(pnLeft, BorderLayout.CENTER);
		
		this.add(pnLon, BorderLayout.PAGE_START);
//		pnMain.add(pn2);
		this.add(pn3,BorderLayout.CENTER);
		
	}
	
	public void addEvent() {
		cboQuan.addActionListener(chonPhuong);
		btnSubmit.addActionListener(TimTheoDiaChi);
		btnXoatt.addActionListener(Xoathongtin);
//		btnXoa.addActionListener(Xoa);
//		btnHuy.addActionListener(Huy);
		tbl.addMouseListener(eventChooseRow);
	}
	MouseAdapter eventChooseRow = new MouseAdapter() {
	public void mouseClicked(MouseEvent e) {
		int dong = tbl.getSelectedRow();
		if(dong>-1) {
			String makh = tbl.getValueAt(dong,0).toString();
			String email = tbl.getValueAt(dong,3).toString();
			String ten = tbl.getValueAt(dong,1).toString();
//			String diachi = tbl.getValueAt(dong,3).toString();
			String sdt = tbl.getValueAt(dong,2).toString();
			String sotk = tbl.getValueAt(dong,4).toString();
			String sodu = tbl.getValueAt(dong,5).toString();
//			String quan = tbl.getValueAt(dong,7).toString();
//			String phuong = tbl.getValueAt(dong,8).toString();
			
			
			txtMaKh.setText(makh);
			txtEmail.setText(email);
			txtTen.setText(ten);
//			txtDiaChi.setText(diachi);
			txtSdt.setText(sdt);
			txtSoTk.setText(sotk);
			txtSoDu.setText(sodu);
			for(KhachHang x:arrKh) {
				if(makh.equals(x.getMaKh())) {
					txtDiaChi.setText(x.getSoNha());
					cboQuan.setSelectedItem(x.getQuan());
					cboPhuong.setSelectedItem(x.getPhuong());
				}
			}
//			cboQuan.setSelectedItem(quan);
//			cboPhuong.setSelectedItem(phuong);
			txtMaKh.setEditable(false);
		}
	}
};
	
	ActionListener chonPhuong = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			int id = cboQuan.getSelectedIndex();
			if(id==0) {
				cboPhuong.removeAllItems();
				cboPhuong.addItem("Chọn Phường");
			}else {
				arrPhuong = GetQuanPhuong.getPhuong(id);
				cboPhuong.removeAllItems();
				for (String x : arrPhuong) {
					cboPhuong.addItem(x);
				}
			}
			
		}
	};
	
	ActionListener TimTheoDiaChi = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String quan = cboQuan.getSelectedItem().toString();
			String phuong = cboPhuong.getSelectedItem().toString();
			TimTheoDiaChi(quan, phuong);
			
		}
	};
	
	ActionListener Xoathongtin = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			txtMaKh.setText("");
			txtEmail.setText("");
			txtTen.setText("");
			txtDiaChi.setText("");
			txtSdt.setText("");
			txtSoTk.setText("");
			txtSoDu.setText("");
			cboQuan.setSelectedIndex(0);
			cboPhuong.setSelectedIndex(0);
			txtMaKh.setEditable(true);
		}
	};

	public ArrayList<KhachHang> select() {
		ArrayList<KhachHang> arrKh = new ArrayList<>();
		if(db != null) {
			
			String sql = "select * from khachhang";
			try {
				PreparedStatement pstt = (PreparedStatement) db.prepareStatement(sql);
				// khởi tạo resultset
				ResultSet rs = pstt.executeQuery();
				while (rs.next()) {
					String makh  = rs.getString("ma_kh");
					String email = rs.getString("email");
				    String ten = rs.getString("ten_kh");
				    String sdt = rs.getString("sdt");
				    String diachi = rs.getString("so_nha");
				    String sotk = rs.getString("so_tk");
				    String sodu = rs.getString("so_du");
				    String quan = rs.getString("quan");
				    String phuong = rs.getString("phuong");
				    String sothe = rs.getString("so_the");
				    String[] rows = {makh,ten,sdt,email,sotk,sodu,quan,phuong};
				    arrKh.add(new KhachHang(makh,ten,diachi,quan,phuong,sdt,email,sothe,sotk,sodu));
					tb.addRow(rows);
				}
			} catch (SQLException e) {
				System.out.println("Lỗi  " + e.getMessage());

			}
		}
		return arrKh;
	}
	
	public ArrayList<KhachHang> TimTheoDiaChi(String quan,String phuong) {
		ArrayList<KhachHang> arrKh = new ArrayList<>();
		if(db != null) {
			tb.setRowCount(0);
			String sql = "select * from khachhang WHERE quan LIKE ? AND phuong LIKE ?";
			try {
				PreparedStatement pstt = (PreparedStatement) db.prepareStatement(sql);
				// khởi tạo resultset
				pstt.setString(1,"%"+ quan +"%");
				pstt.setString(2,"%"+ phuong +"%");
				ResultSet rs = pstt.executeQuery();
				while (rs.next()) {
					String makh  = rs.getString("ma_kh");
					String email = rs.getString("email");
				    String ten = rs.getString("ten_kh");
				    String sdt = rs.getString("sdt");
				    String sotk = rs.getString("so_tk");
				    String sodu = rs.getString("so_du");
				    String quan1 = rs.getString("quan");
				    String phuong1 = rs.getString("phuong");
				    String diachi = rs.getString("so_nha");
				    String sothe = rs.getString("so_the");
				    String[] rows = {makh,ten,sdt,email,sotk,sodu};
				    arrKh.add(new KhachHang(makh,ten,diachi,quan1,phuong1,sdt,email,sothe,sotk,sodu));
					tb.addRow(rows);
				}
			} catch (SQLException e) {
				System.out.println("Lỗi  " + e.getMessage());

			}
		}
		return arrKh;
	}
}
