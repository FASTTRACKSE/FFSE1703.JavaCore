package atm.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import com.toedter.calendar.JDateChooser;

import atm.model.Atm;
import atm.model.GetDatabase;
import atm.model.GetQuanPhuong;

public class LayoutThongKeMayAtm extends JPanel {
	GetDatabase conn = new GetDatabase();
	Connection db = (Connection) GetDatabase.getConnect();
	DefaultTableModel dm = new DefaultTableModel();
	ArrayList<Atm> arrAtm = new ArrayList<>();
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
	JComboBox<String> cboQuan, cboPhuong, cboTimMaMay;
	JButton btnThem, btnSua, btnXoa, btnHuy, btnSubmit;
	JTextField txtMaMay, txtViTriDat, txtSoDu;
	private String tbAtm[] = {"Mã Máy ATM", "Vị Trí Đặt Máy", "Số Thẻ", "Mã Giao Dịch", "Thời Gian Giao Dịch", "Số tiền rút"};
	DefaultTableModel tb = new DefaultTableModel(tbAtm, 0);
	JDateChooser jdtDenNgay,jdtTuNgay;
	public LayoutThongKeMayAtm() {
		addControls();
		addEvent();
		select();
	}

	@SuppressWarnings({ "unchecked", "rawtypes", "static-access" })
	public void addControls() {
		
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setLayout(new BorderLayout());
		
//		Danh sách khách hàng
		JPanel pnLon = new JPanel();
		pnLon.setLayout(new BoxLayout(pnLon, BoxLayout.Y_AXIS));
		
		JPanel pn1 = new JPanel();
		
		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Danh sách Giao Dịch");
		sc.setBorder(borderTitle);
		tbl.setModel(tb);
		tbl.setPreferredScrollableViewportSize(new Dimension(1160, 400));
		sc.setViewportView(tbl);
		sc.setOpaque( false );
		tbl.setOpaque(true);
		tbl.setFillsViewportHeight(true);
//		tbl.setBackground(Color.WHITE);
		pn1.add(sc, BorderLayout.CENTER);
//		pn1.setLayout(new BorderLayout());
//		pn1.setPreferredSize(new Dimension(0, 350));
//		pn1.add(sc, BorderLayout.CENTER);
		pnLon.add(pn1);	
		
		
//		pnLon.add(pn1Right);
//		
//		pn1Right.setBorder(new CompoundBorder(new EmptyBorder(0,10,0,0), BorderFactory.createTitledBorder(borderTitle2)));
//		
		JPanel pn3 = new JPanel();
		pn3.setLayout(new BoxLayout(pn3, BoxLayout.Y_AXIS));
		Border border3 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle3 = BorderFactory.createTitledBorder(border3, "Tùy chọn theo khu vực hoặc thời gian", TitledBorder.CENTER, TitledBorder.DEFAULT_JUSTIFICATION);
		pn3.setBorder(borderTitle3);
		pn3.setPreferredSize(new Dimension(100, 100));
		
		
		JPanel pnTuyChon = new JPanel();
		pnTuyChon.setLayout(new BoxLayout(pnTuyChon, BoxLayout.X_AXIS));
		
		JPanel pnTimMaMay = new JPanel();
		cboTimMaMay = new JComboBox<String>();
		cboTimMaMay.addItem("Tất Cả");
		arrAtm = selectArr();
		for(Atm x:arrAtm) {
			cboTimMaMay.addItem(x.getMaMay());
		}
		cboTimMaMay.addItem("Tất Cả");
		JLabel lblTimMaMay = new JLabel("Mã Máy ATM: ");
		cboTimMaMay.setPreferredSize(new Dimension(160, 20));
		pnTimMaMay.add(lblTimMaMay);
		pnTimMaMay.add(cboTimMaMay);
		pnTuyChon.add(pnTimMaMay);
		
		JPanel pnViTriDat = new JPanel();
		JLabel lblViTriDat = new JLabel("Địa Chỉ: ");
		txtViTriDat = new JTextField(15);
		pnViTriDat.add(lblViTriDat);
		pnViTriDat.add(txtViTriDat);
		pnTuyChon.add(pnViTriDat);
		
		JPanel pnQuan = new JPanel();
		JLabel lblQuan = new JLabel("        Quận:");
		cboQuan = new JComboBox();
		cboQuan.addItem("Chọn Quận");
		cboQuan.setPreferredSize(new Dimension(160, 20));
		ArrayList<String> arrquan = new ArrayList<String>();
		arrquan = cbItem.getQuan();
				for(String x : arrquan) {
				cboQuan.addItem(x);	
				}
		pnQuan.add(lblQuan);
		pnQuan.add(cboQuan);
		pnTuyChon.add(pnQuan);
		
		JPanel pnPhuong = new JPanel();
		JLabel lblPhuong = new JLabel("          Phường: ");
		cboPhuong = new JComboBox();
		cboPhuong.addItem("Chọn Phường");
		cboPhuong.setPreferredSize(new Dimension(160, 20));
		pnPhuong.add(lblPhuong);
		pnPhuong.add(cboPhuong);
		pnTuyChon.add(pnPhuong);
		
		JPanel pnThoiGian = new JPanel();
		pnThoiGian.setLayout(new BoxLayout(pnThoiGian, BoxLayout.Y_AXIS));
		
		JPanel pnTuNgay = new JPanel();
		JLabel lblTuNgay = new JLabel("Từ Ngày:     ");
//		lblTuNgay.setFont(new Font("Times New Roman", Font.PLAIN,18));
		jdtTuNgay = new JDateChooser();
		jdtTuNgay.setPreferredSize(new Dimension(170, 20));
		pnTuNgay.add(lblTuNgay);
		pnTuNgay.add(jdtTuNgay);
		pnThoiGian.add(pnTuNgay);
		
		
		JPanel pnDenNgay = new JPanel();
		JLabel lblDenNgay = new JLabel("Đến Ngày:   ");
//		lblDenNgay.setFont(new Font("Times New Roman", Font.PLAIN,18));
		jdtDenNgay = new JDateChooser();
		jdtDenNgay.setPreferredSize(new Dimension(170, 20));
		
		JPanel pnSubmit = new JPanel();
		
		btnSubmit = new JButton("Tìm Kiếm");
		btnHuy = new JButton("Hủy");
		
		JPanel pnChonNgayThang = new JPanel();
		
		pnDenNgay.add(lblDenNgay);
		pnDenNgay.add(jdtDenNgay);
		pnThoiGian.add(pnDenNgay);
		
		pn3.add(pnTuyChon);
		pn3.add(pnThoiGian);
		
		pn3.add(pnSubmit);
		pnSubmit.add(btnSubmit);
		pnSubmit.add(btnHuy);
		
		pn3.add(pnChonNgayThang);
		
		this.add(pnLon, BorderLayout.PAGE_START);
//		pnMain.add(pn2);
		this.add(pn3,BorderLayout.CENTER);
		
	}
	public void addEvent() {
		cboQuan.addActionListener(chonPhuong);
		btnSubmit.addActionListener(TimKiem);
		btnHuy.addActionListener(Huy);
	}
	
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
	
	ActionListener TimKiem = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
			String mamay = cboTimMaMay.getSelectedItem().toString();
			String vitridat = txtViTriDat.getText();
			String quan = cboQuan.getSelectedItem().toString();
			String phuong = cboPhuong.getSelectedItem().toString();	
			Calendar tuNgay = jdtTuNgay.getCalendar();
			Calendar denNgay = jdtDenNgay.getCalendar();
			TimTheoDiaChi(mamay,vitridat,quan,phuong,tuNgay,denNgay);
			}catch(Exception ex){
				JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày");
			}
		}
	};
	
	ActionListener Huy = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			cboTimMaMay.setSelectedIndex(0);
			txtViTriDat.setText("");
			cboQuan.setSelectedIndex(0);
			cboPhuong.setSelectedIndex(0);
			jdtTuNgay.setCalendar(null);
			jdtDenNgay.setCalendar(null);
		}
	};
	
	public void select() {
		if(db != null) {
			
			String sql = "select * from giaodichatm inner join atm on giaodichatm.ma_may = atm.ma_may";
			try {
				PreparedStatement pstt = (PreparedStatement) db.prepareStatement(sql);
				// khởi tạo resultset
				ResultSet rs = pstt.executeQuery();
				while (rs.next()) {
					String mamay = rs.getString("atm.ma_may");
					String vitridat = rs.getString("atm.dia_chi_dat");
					String sothe = rs.getString("giaodichatm.so_the");
				    String magd = rs.getString("giaodichatm.ma_gd");
				    String thoigiangd = rs.getString("giaodichatm.thoi_gian");
				    String sotienrut = rs.getString("giaodichatm.tong_tien");
				    String[] rows = {mamay,vitridat,sothe,magd,thoigiangd,sotienrut};
					tb.addRow(rows);
				}
			} catch (SQLException e) {
				System.out.println("Lỗi  " + e.getMessage());

			}
		}
	}
	
	public ArrayList<Atm> selectArr() {
		ArrayList<Atm> arrAtm = new ArrayList<>();
			String sql = "select * from atm";
			
			try {
				PreparedStatement pstt = (PreparedStatement) db.prepareStatement(sql);
				// khởi tạo resultset
				ResultSet rs = pstt.executeQuery();
				while (rs.next()) {
					String mamay  = rs.getString("ma_may");
					String vitridat = rs.getString("dia_chi_dat");
				    String sodu = rs.getString("so_du");
				    String quan = rs.getString("quan");
				    String phuong = rs.getString("phuong");
				    
					arrAtm.add(new Atm(mamay, vitridat, sodu, quan, phuong));
				}
			} catch (SQLException e) {
				System.out.println("Lỗi  " + e.getMessage());

			}
			return arrAtm;
	}
	
	
	public ArrayList<Atm> TimTheoDiaChi(String mamay, String vitridat,String quan,String phuong,Calendar tuNgay,Calendar denNgay) {
		if(db != null) {
			tuNgay.add(Calendar.DATE, -1);
			denNgay.add(Calendar.DATE, 1);
			Timestamp timeTuNgay = new Timestamp(tuNgay.getTimeInMillis());
			Timestamp timeDenNgay = new Timestamp(denNgay.getTimeInMillis());
			tb.setRowCount(0);
			String sql = "select * from giaodichatm inner join atm on giaodichatm.ma_may = atm.ma_may where atm.ma_may LIKE ? AND atm.dia_chi_dat LIKE ? "
					+"AND atm.quan LIKE ? AND phuong LIKE ? AND (giaodichatm.thoi_gian BETWEEN ? AND ?)";
			try {
				PreparedStatement pstt = (PreparedStatement) db.prepareStatement(sql);
				// khởi tạo resultset
				pstt.setString(1, "%" + mamay + "%");
				pstt.setString(2, "%" + vitridat + "%");
				pstt.setString(3, "%" + quan + "%");
				pstt.setString(4, "%" + phuong + "%");
				pstt.setTimestamp(5, timeTuNgay);
				pstt.setTimestamp(6, timeDenNgay);
				ResultSet rs = pstt.executeQuery();
				while (rs.next()) {
					String maAtm = rs.getString("atm.ma_may");
					String vitri = rs.getString("atm.dia_chi_dat");
					String sothe = rs.getString("giaodichatm.so_the");
				    String magd = rs.getString("giaodichatm.ma_gd");
				    String thoigiangd = rs.getString("giaodichatm.thoi_gian");
				    String sotienrut = rs.getString("giaodichatm.tong_tien");
				    String[] rows = {maAtm,vitri,sothe,magd,thoigiangd,sotienrut};
					tb.addRow(rows);
				}
			} catch (SQLException e) {
				System.out.println("  " + e.getMessage());

			}
		}
		return arrAtm;
	}
}
