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
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
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
import com.mysql.jdbc.Statement;

import atm.model.Atm;
import atm.model.GetDatabase;
import atm.model.GetQuanPhuong;

public class LayoutAtm extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	GetDatabase conn = new GetDatabase();
	Connection db = (Connection) GetDatabase.getConnect();
	DefaultTableModel dm = new DefaultTableModel();
	ArrayList<Atm> arrAtm = new ArrayList<>();
	final JTable tbl = new JTable();
	JScrollPane sc = new JScrollPane();
	GetQuanPhuong cbItem = new GetQuanPhuong();
	ArrayList<String> arrPhuong = new ArrayList<String>();
	JComboBox<String> cboQuan, cboPhuong;
	JButton btnThem, btnSua, btnXoa, btnHuy;
	JTextField txtMaMay, txtViTriDat, txtSoDu;
	private String tbAtm[] = {"Mã máy ATM", "Vị trí đặt máy", "Số dư trong máy"};
	DefaultTableModel tb = new DefaultTableModel(tbAtm, 0);
	public LayoutAtm() {
		addControls();
		addEvent();
		select();
	}
	@SuppressWarnings("unchecked")
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
		
//		Panel tìm kiếm
		JPanel pn1Right = new JPanel();
		
//		JPanel pnImage = new JPanel(){ 
//            public void paintComponent(Graphics g) 
//            { 
//                Dimension d = getSize(); 
//                Image img=this.getToolkit().getImage("image/tpbank2.jpg"); 
//                g.drawImage(img, 0, 0, d.width, d.height, null); 
//
//                setOpaque( false );  // lam trong suot  
//                super.paintComponent(g); 
//            } 
//        };
//
//		pnImage.setPreferredSize(new Dimension(100, 150));
//		pn1Right.add(pnImage);
		
		
		JPanel pnTim = new JPanel();
		JPanel pnKiem = new JPanel();
		
		@SuppressWarnings("rawtypes")
		JComboBox cboTimKiem = new JComboBox();
		cboTimKiem.addItem("Tất Cả");
		JLabel lbl = new JLabel("Tìm theo: ");
		cboTimKiem.setPreferredSize(new Dimension(100, 20));
		pnTim.add(lbl);
		pnTim.add(cboTimKiem);
		//pn1Right.setLayout(new BoxLayout(pn1Right, BoxLayout._AXIS));
		pn1Right.setLayout(new BoxLayout(pn1Right, BoxLayout.Y_AXIS));
//		Border border2 = BorderFactory.createLineBorder(Color.RED);
//		TitledBorder borderTitle2 = BorderFactory.createTitledBorder(border2, "Tìm kiếm");
//		pn1Right.setBorder(borderTitle2);
		JTextField txtTimKiem = new JTextField(20);
		JButton btnTimKiem = new JButton("Tìm Kiếm");
//		pnTim.setPreferredSize(new Dimension(200,10));
//		pnKiem.setPreferredSize(new Dimension(255,50));
//		pn1Right.add(pnImage);
		pnTim.add(txtTimKiem);
		pnKiem.add(btnTimKiem);
		pn1Right.add(pnTim);
		pn1Right.add(pnKiem);
		pnLon.add(pn1);
		pnLon.add(pn1Right);
		
//		pn1Right.setBorder(new CompoundBorder(new EmptyBorder(0,10,0,0), BorderFactory.createTitledBorder(borderTitle2)));
		
		JPanel pn3 = new JPanel();
		pn3.setLayout(new BoxLayout(pn3, BoxLayout.Y_AXIS));
		Border border3 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle3 = BorderFactory.createTitledBorder(border3, "Nhập thông tin");
		pn3.setBorder(borderTitle3);
		
		JPanel pnLeft = new JPanel();
		pnLeft.setLayout(new BoxLayout(pnLeft, BoxLayout.X_AXIS));
		
		Border border3n = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle3n = BorderFactory.createTitledBorder(border3n);
		pnLeft.setBorder(borderTitle3n);
		
		
		
		JPanel pnLeft2 = new JPanel();
		pnLeft2.setLayout(new BoxLayout(pnLeft2, BoxLayout.Y_AXIS));
		
		JPanel pnMaMay = new JPanel();
		JLabel lblMaMay = new JLabel("    Mã máy ATM:           ");
		lblMaMay.setFont(new Font("Times New Roman", Font.PLAIN,18));
		txtMaMay = new JTextField(20);
		pnMaMay.add(lblMaMay);
		pnMaMay.add(txtMaMay);
		
		JPanel pnViTriDat = new JPanel();
		JLabel lblViTriDat = new JLabel("   Vị trí đặt máy:             ");
		lblViTriDat.setFont(new Font("Times New Roman", Font.PLAIN,18));
		txtViTriDat = new JTextField(20);
		pnViTriDat.add(lblViTriDat);
		pnViTriDat.add(txtViTriDat);
		
		JPanel pnSoDu = new JPanel();
		JLabel lblSoDu = new JLabel(" Tổng tiền trong máy:      ");
		lblSoDu.setFont(new Font("Times New Roman", Font.PLAIN,18));
		txtSoDu = new JTextField(20);
		pnSoDu.add(lblSoDu);
		pnSoDu.add(txtSoDu);
		
		
		JPanel pnQuan = new JPanel();
		JLabel lblQuan = new JLabel("        Quận:");
		cboQuan = new JComboBox<String>();
		cboQuan.setPreferredSize(new Dimension(120, 20));
		ArrayList<String> arrquan = new ArrayList<String>();
		cboQuan.addItem("Chọn Quận");
		arrquan = GetQuanPhuong.getQuan();
				for(String x : arrquan) {
				cboQuan.addItem(x);	
				}
		pnQuan.add(lblQuan);
		pnQuan.add(cboQuan);
		
		JPanel pnPhuong = new JPanel();
		JLabel lblPhuong = new JLabel("          Phường: ");
		cboPhuong = new JComboBox<String>();
		cboPhuong.addItem("Chọn Phường");
		cboPhuong.setPreferredSize(new Dimension(150, 20));
		pnPhuong.add(lblPhuong);
		pnPhuong.add(cboPhuong);
		
		pnLeft2.add(pnMaMay);
		pnLeft2.add(pnViTriDat);
		pnLeft2.add(pnSoDu);
		pnLeft2.add(pnQuan);
		pnLeft2.add(pnPhuong);
		
		pnLeft.add(pnLeft2);
		
		JPanel pnRight = new JPanel();
		pnRight.setLayout(new BoxLayout(pnRight, BoxLayout.Y_AXIS));
		
		Border border3n2 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle3n2 = BorderFactory.createTitledBorder(border3n2);
		
		JPanel pnThem = new JPanel();
		btnThem = new JButton("Thêm", new ImageIcon(((new ImageIcon("D:/FFSE1703.JavaCore/Assignments/ThachND/Duanmayatm/image/them.png")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
		
		btnThem.setFont(new Font("Times New Roman", Font.PLAIN,20));
		btnThem.setPreferredSize(new Dimension(250,50));
		pnThem.add(btnThem);
		pnRight.add(pnThem);
		
		
		JPanel pnSua = new JPanel();
		btnSua = new JButton("Sửa", new ImageIcon(((new ImageIcon("D:/FFSE1703.JavaCore/Assignments/ThachND/Duanmayatm/image/sua.png")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
		btnSua.setFont(new Font("Times New Roman", Font.PLAIN,20));
		btnSua.setPreferredSize(new Dimension(250,50));
		pnSua.add(btnSua);
		pnRight.add(pnSua);
		
		JPanel pnXoa = new JPanel();
		btnXoa = new JButton("Xóa", new ImageIcon(((new ImageIcon("D:/FFSE1703.JavaCore/Assignments/ThachND/Duanmayatm/image/xoa.png")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
		btnXoa.setFont(new Font("Times New Roman", Font.PLAIN,20));
		btnXoa.setPreferredSize(new Dimension(250,50));
		pnXoa.add(btnXoa);
		pnRight.add(pnXoa);
		
		JPanel pnHuy = new JPanel();
		btnHuy = new JButton("Hủy", new ImageIcon(((new ImageIcon("D:/FFSE1703.JavaCore/Assignments/ThachND/Duanmayatm/image/huy.png")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
		btnHuy.setFont(new Font("Times New Roman", Font.PLAIN,20));
		btnHuy.setPreferredSize(new Dimension(250,50));
		pnHuy.add(btnHuy);
		pnRight.add(pnHuy);
		
		
//		pn3n2.setBorder(borderTitle3n2);
//		pn3n2.setPreferredSize(new Dimension(350, 0));
		pnRight.setBorder(new CompoundBorder(new EmptyBorder(0,10,0,0), BorderFactory.createTitledBorder(borderTitle3n2)));

//		pn3.setPreferredSize(new Dimension(0, 250));
//		pn1Right.setLayout(new BorderLayout());
		pn3.setLayout(new BorderLayout());
		pn3.add(pnLeft, BorderLayout.CENTER);
		pn3.add(pnRight, BorderLayout.LINE_END);
		
		this.add(pnLon, BorderLayout.PAGE_START);
		this.add(pn3,BorderLayout.CENTER);
		
	}
	public void addEvent() {
		cboQuan.addActionListener(chonPhuong);
		btnThem.addActionListener(Them);
		btnSua.addActionListener(Sua);
		btnXoa.addActionListener(Xoa);
		btnHuy.addActionListener(Huy);
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
	
	ActionListener Them = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String mamay = txtMaMay.getText();
			String vitridat = txtViTriDat.getText();
			String sodu = txtSoDu.getText();
			String quan = cboQuan.getSelectedItem().toString();
			String phuong = cboPhuong.getSelectedItem().toString();
			try {
				String sql="insert into atm(ma_may,dia_chi_dat,phuong,quan,so_du) values( '"+mamay+"','"+vitridat+"','"+phuong+"','"+quan+"','"+sodu+"')";
				Statement statement=(Statement) db.createStatement();
				int x = statement.executeUpdate(sql);
				if(x>0)
				{
					JOptionPane.showMessageDialog(null, "Thêm thành công");
					}
				}
				catch(Exception ex){
					ex.printStackTrace();
					}
				String[] rows = {mamay,vitridat,sodu};
				tb.addRow(rows);
				 txtMaMay.setText("");
				 txtViTriDat.setText("");
				 txtSoDu.setText("");
				 cboQuan.setSelectedIndex(0);
				 cboPhuong.setSelectedIndex(0);
		}
	};
	
	ActionListener Sua = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			// TODO Auto-generated method stub
			String mamay = txtMaMay.getText();
			String vitridat = txtViTriDat.getText();
			String sodu = txtSoDu.getText();
			String quan = cboQuan.getSelectedItem().toString();
			String phuong = cboPhuong.getSelectedItem().toString();
				try
				{
					String sql="update atm set dia_chi_dat='"+vitridat+"', so_du='"+sodu+"', quan='"+quan+"',phuong='"+phuong+"' where ma_may='"+mamay+"'";
					Statement statement = (Statement) db.createStatement();
					int x=statement.executeUpdate(sql);
					if(x>0)
					{
						tb.setRowCount(0);
						JOptionPane.showMessageDialog(null, "Cập nhật thành công");
						select();
						}
					}
				catch(Exception ex){
					ex.printStackTrace();
			}
				 txtMaMay.setText("");
				 txtViTriDat.setText("");
				 txtSoDu.setText("");
				 cboQuan.setSelectedIndex(0);
				 cboPhuong.setSelectedIndex(0);
				 txtMaMay.setEditable(true);
		}
	};
	
	ActionListener Xoa = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String mamay = txtMaMay.getText();
			try
			{
				String sql="delete from atm where ma_may='"+mamay+"'";
				Statement statement=(Statement) db.createStatement();
				int x=statement.executeUpdate(sql);
				if(x>0)
				{
					tb.setRowCount(0);
					select();
					JOptionPane.showMessageDialog(null, "Xóa thành công");
					}
				}
			catch(Exception ex){
				ex.printStackTrace();
				}
			 txtMaMay.setText("");
			 txtViTriDat.setText("");
			 txtSoDu.setText("");
			 cboQuan.setSelectedIndex(0);
			 cboPhuong.setSelectedIndex(0);
			 txtMaMay.setEditable(true);
		}
		
	};
	
	ActionListener Huy = new ActionListener() {
		
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
}
