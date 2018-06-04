package atm.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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

import atm.model.Atm;
import atm.model.GetDatabase;
import atm.model.GetQuanPhuong;

public class LayoutTinhTrangMay extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	JButton btnThem, btnSua, btnXoa, btnHuy, btnTimKiem, btnSubmit;
	JTextField txtMaMay, txtViTriDat, txtSoDu;
	private String tbAtm[] = {"Mã máy ATM", "Vị trí đặt máy", "Số dư trong máy"};
	DefaultTableModel tb = new DefaultTableModel(tbAtm, 0);
	public LayoutTinhTrangMay() {
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
		tbl.setPreferredScrollableViewportSize(new Dimension(1160, 350));
		sc.setViewportView(tbl);
		sc.setOpaque( false );
		tbl.setOpaque(true);
		tbl.setFillsViewportHeight(true);
//		tbl.setBackground(Color.WHITE);
		pn1.add(sc, BorderLayout.CENTER);
//		pn1.setLayout(new BorderLayout());
//		pn1.setPreferredSize(new Dimension(0, 350));
//		pn1.add(sc, BorderLayout.CENTER);
		
//		Panel tìm kiếm
		JPanel pn1Right = new JPanel();
		
		pn1Right.setLayout(new BoxLayout(pn1Right, BoxLayout.X_AXIS));
		Border border2 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle2 = BorderFactory.createTitledBorder(border2, "Tùy chọn");
//		pn1Right.setBorder(borderTitle2);
		
		JPanel pnTimMaMay = new JPanel();
		cboTimMaMay = new JComboBox<String>();
		cboTimMaMay.addItem("Tất Cả");
		arrAtm = selectArr();
		for(Atm x:arrAtm) {
			cboTimMaMay.addItem(x.getMaMay());
		}
		JLabel lblTimMaMay = new JLabel("Mã Máy ATM: ");
		cboTimMaMay.setPreferredSize(new Dimension(160, 20));
		pnTimMaMay.add(lblTimMaMay);
		pnTimMaMay.add(cboTimMaMay);
		pn1Right.add(pnTimMaMay);
		
		JPanel pnDiaChi = new JPanel();
		JLabel lblDiaChi = new JLabel("Địa chỉ:");
		JTextField txtDiaChi = new JTextField(15);
		pnDiaChi.add(lblDiaChi);
		pnDiaChi.add(txtDiaChi);
		pn1Right.add(pnDiaChi);
		
		JPanel pnQuan = new JPanel();
		JLabel lblQuan = new JLabel("        Quận:");
		cboQuan = new JComboBox<String>();
		cboQuan.addItem("Chọn Quận");
		cboQuan.setPreferredSize(new Dimension(120, 20));
		ArrayList<String> arrquan = new ArrayList<String>();
		arrquan = GetQuanPhuong.getQuan();
				for(String x : arrquan) {
				cboQuan.addItem(x);	
				}
		pnQuan.add(lblQuan);
		pnQuan.add(cboQuan);
		pn1Right.add(pnQuan);
		
		JPanel pnPhuong = new JPanel();
		JLabel lblPhuong = new JLabel("          Phường: ");
		cboPhuong = new JComboBox();
		cboPhuong.addItem("Tất Cả");
		cboPhuong.setPreferredSize(new Dimension(160, 20));
		pnPhuong.add(lblPhuong);
		pnPhuong.add(cboPhuong);
		pn1Right.add(pnPhuong);
		
		JPanel pnTimKiem = new JPanel();
		btnTimKiem = new JButton("Submit");
		pnTimKiem.add(btnTimKiem);
		pn1Right.add(pnTimKiem);
		
		//In thông tin
		pnLon.add(pn1);
		pnLon.add(pn1Right);
		
		pn1Right.setBorder(new CompoundBorder(new EmptyBorder(0,10,0,0), BorderFactory.createTitledBorder(borderTitle2)));
		
		JPanel pn3 = new JPanel();
		pn3.setLayout(new BoxLayout(pn3, BoxLayout.Y_AXIS));
		Border border3 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle3 = BorderFactory.createTitledBorder(border3, "In thông tin");
		pn3.setBorder(borderTitle3);
		
		JPanel pnLeft = new JPanel();
		pnLeft.setLayout(new BoxLayout(pnLeft, BoxLayout.X_AXIS));
		
		Border border3n = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle3n = BorderFactory.createTitledBorder(border3n);
		pnLeft.setBorder(borderTitle3n);
		
		
		
		JPanel pnLeft2 = new JPanel();
		pnLeft2.setLayout(new BoxLayout(pnLeft2, BoxLayout.Y_AXIS));
		
		JPanel pnMaMay = new JPanel();
		JLabel lblMaMay = new JLabel("Mã máy ATM:                   ");
//		lblMaMay.setFont(new Font("Times New Roman", Font.PLAIN,18));
		txtMaMay = new JTextField(20);
		pnMaMay.add(lblMaMay);
		pnMaMay.add(txtMaMay);
		
		JPanel pnViTriDat = new JPanel();
		JLabel lblViTriDat = new JLabel("Vị trí đặt máy:                   ");
//		lblViTriDat.setFont(new Font("Times New Roman", Font.PLAIN,18));
		txtViTriDat = new JTextField(20);
		pnViTriDat.add(lblViTriDat);
		pnViTriDat.add(txtViTriDat);
		
		JPanel pnSoDu = new JPanel();
		JLabel lblSoDu = new JLabel(" Tổng tiền trong máy:      ");
//		lblSoDu.setFont(new Font("Times New Roman", Font.PLAIN,18));
		txtSoDu = new JTextField(20);
		pnSoDu.add(lblSoDu);
		pnSoDu.add(txtSoDu);
		
		JPanel pnXoatt = new JPanel();
		btnSubmit = new JButton("Xóa thông tin");
		
		pnLeft2.add(pnMaMay);
		pnLeft2.add(pnViTriDat);
		pnLeft2.add(pnSoDu);
		
		pnLeft2.add(pnXoatt);
		pnXoatt.add(btnSubmit);
		
		pn3.add(pnLeft);
//		pnLeft.add(pnLeft1);
		pnLeft.add(pnLeft2);
		
		this.add(pnLon, BorderLayout.PAGE_START);
//		pnMain.add(pn2);
		this.add(pn3,BorderLayout.CENTER);
		
	}
	public void addEvent() {
		cboQuan.addActionListener(chonPhuong);
		btnSubmit.addActionListener(Xoatt);
		btnTimKiem.addActionListener(TimKiem);
		tbl.addMouseListener(eventChooseRow);
	}
	MouseAdapter eventChooseRow = new MouseAdapter() {
	public void mouseClicked(MouseEvent e) {
		int dong = tbl.getSelectedRow();
			
		if(dong>-1) {
			String mamay = tbl.getValueAt(dong,0).toString();
			for(Atm x: arrAtm) {
				if(mamay.equals(x.getMaMay())) {
					txtMaMay.setText(x.getMaMay());
					txtViTriDat.setText(x.getDiaChiDat());
					txtSoDu.setText(x.getSoDu());
					cboQuan.setSelectedItem(x.getQuan());
					cboPhuong.setSelectedItem(x.getPhuong());
				}
			}
			
			txtMaMay.setEditable(false);
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

	ActionListener TimKiem = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String mamay = cboTimMaMay.getSelectedItem().toString();
			String vitridat = txtViTriDat.getText();
			String quan = cboQuan.getSelectedItem().toString();
			String phuong = cboPhuong.getSelectedItem().toString();			
			TimTheoDiaChi(mamay,vitridat,quan,phuong);
		}
	};

	ActionListener Xoatt = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			 txtMaMay.setText("");
			 txtViTriDat.setText("");
			 txtSoDu.setText("");
			 cboQuan.setSelectedIndex(0);
			 cboPhuong.setSelectedIndex(0);
			 txtMaMay.setEditable(true);
		}
	};

	public void select() {
		arrAtm.clear();
		if(db != null) {
	
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
					String[] rows = {mamay,vitridat,sodu};
					tb.addRow(rows);
					arrAtm.add(new Atm(mamay, vitridat, sodu, quan, phuong));
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
	
	public ArrayList<Atm> TimTheoDiaChi(String mamay, String vitridat,String quan,String phuong) {
		if(db != null) {
			tb.setRowCount(0);
			String sql = "select * from atm WHERE ma_may LIKE ? AND dia_chi_dat LIKE ? AND quan LIKE ? AND phuong LIKE ?";
			try {
				PreparedStatement pstt = (PreparedStatement) db.prepareStatement(sql);
				// khởi tạo resultset
				pstt.setString(1,"%"+mamay+"%");
				pstt.setString(2,"%"+vitridat+"%");
				pstt.setString(3,"%"+quan+"%");
				pstt.setString(4,"%"+phuong+"%");
				ResultSet rs = pstt.executeQuery();
				while (rs.next()) {
					String maMay  = rs.getString("ma_may");
					String viTriDat = rs.getString("dia_chi_dat");
				    String sodu = rs.getString("so_du");
				    String quanDb = rs.getString("quan");
				    String phuongDb = rs.getString("phuong");
					arrAtm.add(new Atm(maMay, viTriDat, sodu, quanDb, phuongDb));
					String[] rows = {maMay,viTriDat,sodu};
					tb.addRow(rows);
				}
			} catch (SQLException e) {
				System.out.println("Lỗi  " + e.getMessage());

			}
		}
		return arrAtm;
	}
}
