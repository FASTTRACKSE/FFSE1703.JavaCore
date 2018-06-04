package atm.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;
import com.toedter.calendar.JDateChooser;

import atm.model.GetDatabase;
import atm.model.GetQuanPhuong;
import atm.model.KhachHang;

public class LayoutGiaoDichKhachHang extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	JButton btnThem, btnSua, btnXoa, btnSubmit, btnHuy;
	JTextField txtMaMay, txtViTriDat, txtSoDu, txtMaKh;
	JDateChooser jdtTuNgay, jdtDenNgay;
	private String tbAtm[] = {"Mã Khách Hàng", "Tên Khách Hàng", "Mã Máy ATM","Mã Giao Dịch","Thời Gian Giao Dịch","Số Tiền Đã Rút"};
	DefaultTableModel tb = new DefaultTableModel(tbAtm, 0);
	public LayoutGiaoDichKhachHang() {
		addControls();
		addEvent();
		select();
	}

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
		
		JPanel pnMaKh = new JPanel();
		JLabel lblTimMaMay = new JLabel("Số Thẻ:                     ");
		txtMaKh = new JTextField(15);
		pnMaKh.add(lblTimMaMay);
		pnMaKh.add(txtMaKh);
		pnTuyChon.add(pnMaKh);
		
		
		JPanel pnThoiGian = new JPanel();
		pnThoiGian.setLayout(new BoxLayout(pnThoiGian, BoxLayout.Y_AXIS));
		
		JPanel pnTuNgay = new JPanel();
		JLabel lblTuNgay = new JLabel("Từ Ngày:                  ");
//		lblTuNgay.setFont(new Font("Times New Roman", Font.PLAIN,18));
		jdtTuNgay = new JDateChooser();
		jdtTuNgay.setPreferredSize(new Dimension(170, 20));
		pnTuNgay.add(lblTuNgay);
		pnTuNgay.add(jdtTuNgay);
		pnThoiGian.add(pnTuNgay);
		
		
		JPanel pnDenNgay = new JPanel();
		JLabel lblDenNgay = new JLabel("Đến Ngày:                ");
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
//		btnSubmit.addActionListener(TimKiem);

	}
//	MouseAdapter eventChooseRow = new MouseAdapter() {
//		public void mouseClicked(MouseEvent e) {
//			int dong = tbl.getSelectedRow();
//				
//			if(dong>-1) {
//				String mamay = tbl.getValueAt(dong,0).toString();
//				String vitridat = tbl.getValueAt(dong, 1).toString();
//				String sodu = tbl.getValueAt(dong, 2).toString();
//				for(Atm x: arrAtm) {
//					if(mamay.equals(x.getMaMay())) {
//						txtMaMay.setText(x.getMaMay());
//						txtViTriDat.setText(x.getDiaChiDat());
//						txtSoDu.setText(x.getSoDu());
//						String quan = x.getQuan();
//						for(int i = 0; i < cboQuan.getItemCount(); i++) {
//							if(quan.equals(cboQuan.getItemAt(i).toString())) {
//								cboQuan.setSelectedIndex(i);
//							}
//						}
//					}
//				}
//				
//				txtMaMay.setEditable(false);
//			}
//		}
//	};
	
//	ActionListener TimKiem = new ActionListener() {
//		
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			// TODO Auto-generated method stub
//			try {
//			String makh = txtMaKh.getText();
//			Calendar tuNgay = jdtTuNgay.getCalendar();
//			Calendar denNgay = jdtDenNgay.getCalendar();
//			TimTheoMaKh(makh,tuNgay,denNgay);
//			}catch(Exception ex){
//				JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày");
//			}
//		}
//	};
	
	public void select() {
		if(db != null) {
			
			String sql = "select * from giaodichatm inner join khachhang on giaodichatm.so_the = khachhang.so_the";
			try {
				PreparedStatement pstt = (PreparedStatement) db.prepareStatement(sql);
				// khởi tạo resultset
				ResultSet rs = pstt.executeQuery();
				while (rs.next()) {
					String makh  = rs.getString("khachhang.ma_kh");
					String ten = rs.getString("khachhang.ten_kh");
					String mamay = rs.getString("giaodichatm.ma_may");
				    String magd = rs.getString("giaodichatm.ma_gd");
				    String thoigiangd = rs.getString("giaodichatm.thoi_gian");
				    String sotienrut = rs.getString("giaodichatm.tong_tien");
				    String[] rows = {makh,ten,mamay,magd,thoigiangd,sotienrut};
					tb.addRow(rows);
				}
			} catch (SQLException e) {
				System.out.println("Lỗi  " + e.getMessage());

			}
		}
	}
	
//	public ArrayList<KhachHang> TimTheoMaKh(String sothe,Calendar tuNgay,Calendar denNgay) {
//		if(db != null) {
//			tuNgay.add(Calendar.DATE, -1);
//			denNgay.add(Calendar.DATE, 1);
//			Timestamp timeTuNgay = new Timestamp(tuNgay.getTimeInMillis());
//			Timestamp timeDenNgay = new Timestamp(denNgay.getTimeInMillis());
//			tb.setRowCount(0);
//			String sql = "select * from giaodichatm inner join khachhang on giaodichatm.so_the = khachhang.so_the where khachhang.so_the LIKE ? "
//					+" AND (giaodichatm.thoi_gian BETWEEN ? AND ?)";
//			try {
//				PreparedStatement pstt = (PreparedStatement) db.prepareStatement(sql);
//				// khởi tạo resultset
//				pstt.setString(1, "%" + sothe + "%");
//				pstt.setTimestamp(2, timeTuNgay);
//				pstt.setTimestamp(3, timeDenNgay);
//				ResultSet rs = pstt.executeQuery();
//				while (rs.next()) {
//					String sothe = rs.getString("giaodichatm.so_the");
//				    String magd = rs.getString("giaodichatm.ma_gd");
//				    String thoigiangd = rs.getString("giaodichatm.thoi_gian");
//				    String sotienrut = rs.getString("giaodichatm.tong_tien");
//				    String[] rows = {makh,sothe,magd,thoigiangd,sotienrut};
//					tb.addRow(rows);
//				}
//			} catch (SQLException e) {
//				System.out.println("  " + e.getMessage());
//
//			}
//		}
//		return arrKh;
//	}
}
