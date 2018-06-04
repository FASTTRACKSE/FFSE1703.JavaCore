package atm.ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import atm.model.Atm;
import atm.model.GetDatabase;
import atm.model.KhachHang;

public class LayoutRutTien extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	GetDatabase conn = new GetDatabase();
	Connection db = (Connection) GetDatabase.getConnect();
	JTextField txtSoThe, txtSoTienRut;
	JPasswordField  txtMaPin;
	JButton btnSubmit, btnRutTien, btnDangXuat;
	CardLayout cl ;
	JPanel pnRt;
	String soThe;
	JComboBox<String> cboMaMay;
	ArrayList<Atm> arrAtm = new ArrayList<Atm>();
	public LayoutRutTien() {
		addControls();
		addEvent();
	}
	public void addControls() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		
		JPanel pnLon = new JPanel();
		
		JPanel pnRong = new JPanel();
		
		JPanel pnRong1 = new JPanel();
	
		JPanel pnLogin = new JPanel();
		pnLogin.setLayout(new BoxLayout(pnLogin, BoxLayout.Y_AXIS));
		
		
		JPanel pnSoThe = new JPanel();
		JLabel lblSoThe = new JLabel("Số Thẻ:");
		lblSoThe.setFont(new Font("Times New Roman", Font.PLAIN,18));
		txtSoThe = new JTextField(20);
		pnSoThe.add(lblSoThe);
		pnSoThe.add(txtSoThe);
		pnLogin.add(pnSoThe);
		
		JPanel pnMaPin = new JPanel();
		JLabel lblMaPin = new JLabel("Mã Pin:");
		lblMaPin.setFont(new Font("Times New Roman", Font.PLAIN,18));
		txtMaPin = new JPasswordField(20);
		pnMaPin.add(lblMaPin);
		pnMaPin.add(txtMaPin);
		pnLogin.add(pnMaPin);
		
		
		
		
		JPanel pnSubmit = new JPanel();
		btnSubmit = new JButton("Đăng nhập");
		pnSubmit.add(btnSubmit);
		pnLogin.add(pnSubmit);

			
		pnLogin.setPreferredSize(new Dimension(1100, 150));
		pnRong1.setPreferredSize(new Dimension(1100, 250));
		pnLon.add(pnRong1);
		pnLon.add(pnLogin);
		pnLon.add(pnRong);
		

		
		JPanel pnInput1 = new JPanel();

		JPanel pnInput2 = new JPanel();
		
		JPanel pnInput3 = new JPanel();
	
		JPanel pnLogin2 = new JPanel();
		pnLogin.setLayout(new BoxLayout(pnLogin, BoxLayout.Y_AXIS));

		JPanel pnCboMaMay = new JPanel();
		cboMaMay = new JComboBox<>();
		JLabel lblMaMay = new JLabel("Chọn Mã Máy:");
		cboMaMay.setPreferredSize(new Dimension(120, 20));
		lblMaMay.setFont(new Font("Times New Roman", Font.PLAIN,18));
		pnCboMaMay.add(lblMaMay);
		cboMaMay.addItem("Chọn Máy");
		arrAtm = selectArr();
		for(Atm x:arrAtm) {
			cboMaMay.addItem(x.getMaMay());
		}
		pnCboMaMay.add(cboMaMay);
		pnLogin2.add(pnCboMaMay);
		
		JPanel pnSoTienRut = new JPanel();
		JLabel lblSoTienRut = new JLabel("Số tiền rút:");
		lblSoTienRut.setFont(new Font("Times New Roman", Font.PLAIN,18));
		txtSoTienRut = new JTextField(20);
		pnSoTienRut.add(lblSoTienRut);
		pnSoTienRut.add(txtSoTienRut);
		pnLogin2.add(pnSoTienRut);
		
		
		JPanel pnRutTien= new JPanel();
		btnRutTien = new JButton("Rút tiền");
		pnRutTien.add(btnRutTien);
		pnLogin2.add(pnRutTien);
		
		JPanel pnDangXuat = new JPanel();
		btnDangXuat = new JButton("Đăng xuất");
		pnDangXuat.add(btnDangXuat);
		pnLogin2.add(pnDangXuat);
		
//		JPanel pnRutTien= new JPanel();
//		btnRutTien= new JButton("Rút tiền");
//		pnSubmit1.add(btnSubmit1);
//		pnLogin2.add(pnSubmit1);
//		pnBorder.add(pnLogin);
			
		pnLogin.setPreferredSize(new Dimension(1100, 150));
		pnRong1.setPreferredSize(new Dimension(1100, 250));
		pnInput1.add(pnInput2);
		pnInput1.add(pnLogin2);
		pnInput1.add(pnInput3);
		
		cl = new CardLayout();
		pnRt = new JPanel(cl); 
		pnRt.add(pnLon,"1");
		pnRt.add(pnInput1,"2");
		
		cl.show(pnRt, "1");
		
		this.add(pnRt, BorderLayout.PAGE_END);
	}
	public void addEvent() {
		btnSubmit.addActionListener(SubmitDangNhap);
		btnRutTien.addActionListener(RutTien);
		btnDangXuat.addActionListener(DangXuat);
		
	}
	
	ActionListener SubmitDangNhap = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			soThe = txtSoThe.getText();
			String maPin = txtMaPin.getText();
			if(soThe.isEmpty()|| maPin.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Nhập đầy đủ thông tin");
			}else if( checkLoginGD(soThe,maPin)) {
				cl.show(pnRt, "2");
			}else {
				JOptionPane.showMessageDialog(null, "Số thẻ hoặc mã pin không đúng");
			}
		}
	};
	
	ActionListener RutTien = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String rutTien = txtSoTienRut.getText();
			String maMay = cboMaMay.getSelectedItem().toString();
			Date day = new Date();
			
			int maGd = (int) day.getTime();
//			String maGD = 
			try
			{
				
			String sql="insert into giaodichatm(ma_gd,so_the,tong_tien,ma_may) values('"+Math.abs(maGd)+"', '"+soThe+"','"+rutTien+"','"+maMay+"')";
			Statement statement=(Statement) db.createStatement();
			int x = statement.executeUpdate(sql);
			if(x>0)
			{
				JOptionPane.showMessageDialog(null, "Giao dịch thành công");
				ArrayList<KhachHang> arrKh = new ArrayList<KhachHang>();
				arrKh = TimTheoSoThe(soThe);
				int soDu = Integer.parseInt(arrKh.get(0).getSoDu())-Integer.parseInt(rutTien);
				updateTien(soDu);
				arrAtm = selectArr();
				int soDuAtm = Integer.parseInt(arrAtm.get(0).getSoDu())-Integer.parseInt(rutTien);
				updateTienAtm(soDuAtm, maMay);
				}
			}
			catch(Exception ex){
				ex.printStackTrace();
				}
			txtSoTienRut.setText("");
			cboMaMay.setSelectedIndex(0);
		}
	};
	
	ActionListener DangXuat = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			cl.show(pnRt, "1");
			txtSoThe.setText("");
			txtMaPin.setText("");
			soThe="";
		}
		
	};
	
	
	
	public boolean checkLoginGD(String soThe, String maPin) {
		try {
			String sql = "select * from khachhang where so_the = ? and ma_pin = ?";
			PreparedStatement pstt = (PreparedStatement) db.prepareStatement(sql);
			pstt.setString(1, soThe);
			pstt.setString(2, maPin);
			ResultSet result = pstt.executeQuery();
			if (!result.next()) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
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
	
	public ArrayList<KhachHang> TimTheoSoThe(String soThe) {
		ArrayList<KhachHang> arrKh = new ArrayList<>();
		if(db != null) {
			String sql = "select * from khachhang WHERE so_the LIKE ?";
			try {
				PreparedStatement pstt = (PreparedStatement) db.prepareStatement(sql);
				// khởi tạo resultset
				pstt.setString(1,"%"+ soThe +"%");
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
				    arrKh.add(new KhachHang(makh,ten,diachi,quan1,phuong1,sdt,email,sothe,sotk,sodu));
				}
			} catch (SQLException e) {
				System.out.println("Lỗi  " + e.getMessage());

			}
		}
		return arrKh;
	}
	public void updateTien(int soDu) {
		try
		{
			String sql="update khachhang set so_du='"+soDu+"' where so_the='"+soThe+"'";
			Statement statement = (Statement) db.createStatement();
			int x=statement.executeUpdate(sql);
			if(x>0)
			{
				}
			}
		catch(Exception ex){
			ex.printStackTrace();
	}
	}
	
	public void updateTienAtm(int soDu,String maMay) {
		try
		{
			String sql="update atm set so_du='"+soDu+"' where ma_may='"+maMay+"'";
			Statement statement = (Statement) db.createStatement();
			int x=statement.executeUpdate(sql);
			if(x>0)
			{
				}
			}
		catch(Exception ex){
			ex.printStackTrace();
	}
	}
	
}
