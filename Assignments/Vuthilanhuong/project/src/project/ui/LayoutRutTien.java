package project.ui;


import java.awt.CardLayout;
import java.awt.Color;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;


import project.model.GiaoDichDB;
import project.model.KhachHang;
import project.model.KhachHangDB;
import project.model.MayATM;
import project.model.MayATMDb;

public class LayoutRutTien extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel pnHienThi;
	CardLayout cl;
	JTextField txtMa, txtMatKhau;
	JButton btnDN, btnGD, btnDX;
	JTextField txtGD;
	@SuppressWarnings("rawtypes")
	JComboBox cbo;
	JButton btnNhap;
	ArrayList<MayATM> arrATM = new ArrayList<MayATM>();
	ArrayList<KhachHang> arrKH = new ArrayList<KhachHang>();
	String soThe,maMay;
public LayoutRutTien() {
	addControl();
	addEvent();
}

private void addEvent() {
	btnDN.addActionListener(eventDangNhap);
	btnGD.addActionListener(eventNhapSoTien);
	btnDX.addActionListener(eventDangXuat);
}
ActionListener eventDangNhap = new ActionListener() {
// kiểm traddawngnhaapj, nhập thành công thì goi cardlayout k thì báo lỗi
	@Override
	public void actionPerformed(ActionEvent e) {
		soThe="";
		String ma = txtMa.getText();
		String matKhau = txtMatKhau.getText();
		int indexMaMay = cbo.getSelectedIndex();
		if(ma.isEmpty() || matKhau.isEmpty() || indexMaMay==0){
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đủ thông tin");
		}
		else if(LoginGD()){
			soThe=ma;
			maMay=cbo.getSelectedItem().toString();
			cl.show(pnHienThi, "2");
			txtMa.setEditable(false);
			txtMatKhau.setEditable(false);
			btnDN.setEnabled(false);
			cbo.setEnabled(!isEnabled());
		}
		else {
			JOptionPane.showMessageDialog(null, "Số thẻ hoặc mật khẩu không đúng");
		} 
	}
};
//gọi cardLayout pnHienThi 1
ActionListener eventDangXuat = new ActionListener() {

	@Override
	public void actionPerformed(ActionEvent e) {
		cl.show(pnHienThi, "1");
		txtMa.setEditable(true);
		txtMatKhau.setEditable(true);
		btnDN.setEnabled(true);
		cbo.setEnabled(isEnabled());
		txtMa.setText("");
		txtMatKhau.setText("");
		cbo.setSelectedIndex(0);
	}
};
//kiểm tra thông tin
public boolean LoginGD() {
	if(KhachHangDB.checkLoginGD(txtMa.getText(), txtMatKhau.getText())) {
		return true;
	}
	else {
	return false;
	
}
}

ActionListener eventNhapSoTien = new ActionListener() {

	@Override
	public void actionPerformed(ActionEvent e) {
	
		String soTien = txtGD.getText();
		
		if(soTien.isEmpty() ){
			JOptionPane.showMessageDialog(null, "Vui lòng nhập số tiền");
		}else {
			int tien = Integer.parseInt(soTien);
			arrKH=KhachHangDB.hienThiKH();
			String soDu="";
			for(KhachHang x:arrKH) {
				if(soThe.equals(x.getSoThe())) {
					 soDu = x.getSoTien();
				}
			}
			int du = Integer.parseInt(soDu);
			int soTienConLai =du - tien;
			int kiemTra =KhachHangDB.rutTien( soTienConLai, soThe);
			if(kiemTra>-1) {
				String soDuATM ="";
				for(MayATM x:arrATM) {
					if(maMay.equals(x.getMaMay())) {
						soDuATM = x.getTongTien();
					}
				}
				int duATM = Integer.parseInt(soDuATM);
				int soTienConLaiATM =duATM - tien;	
				int kiemTraATM= MayATMDb.rutTienMayATM(soTienConLaiATM, maMay);
				if(kiemTraATM>-1) {
					 int ngayHienTai = (int) new Date().getTime();
					String maGD= "MGD"+String.valueOf(ngayHienTai);
					int kiemTraGD = GiaoDichDB.themGiaoDich(soThe, maMay, maGD, soTien);
					if(kiemTraGD>-1) {
						txtGD.setText("");
						JOptionPane.showMessageDialog(null, "Rút Tiền Thành công");
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "Rút Tiền Thát Bại");
				}
				
			}
			
		}
	}
};
@SuppressWarnings({ "rawtypes", "unchecked" })
private void addControl() {
	JPanel pnRutTien = new JPanel();
	pnRutTien.setLayout(new BoxLayout(pnRutTien, BoxLayout.Y_AXIS));
	
	JPanel pnMa_Pass = new JPanel();
	pnMa_Pass.setLayout(new BoxLayout(pnMa_Pass, BoxLayout.Y_AXIS));
	
	JPanel pnMa = new JPanel();
	JLabel lblMa = new JLabel("Số thẻ");
	lblMa.setPreferredSize(new Dimension(90, 20));
	 txtMa = new JTextField(15);
	pnMa.add(lblMa);
	pnMa.add(txtMa);
	
	JPanel pnMatKhau = new JPanel();
	JLabel lblMatKhau = new JLabel("Mật khẩu ");
	lblMatKhau.setPreferredSize(new Dimension(90, 20));
	  txtMatKhau = new JTextField(15);
	pnMatKhau.add(lblMatKhau);
	pnMatKhau.add(txtMatKhau);
	
	JPanel pnFlowDN = new JPanel();
	 btnDN=new JButton("Đăng nhập");
	pnFlowDN.add(btnDN);
	
	JPanel pnChuaDN = new JPanel(); 
	JLabel lblChuaDN = new JLabel("Chưa đăng nhập ");
	pnChuaDN.setPreferredSize(new Dimension(500, 500));
	Border borderChuaDN=BorderFactory.createLineBorder(Color.BLACK);
	TitledBorder borderTitleChuaDN=BorderFactory.createTitledBorder(borderChuaDN, "");
	pnChuaDN.setBorder(borderTitleChuaDN);
	pnChuaDN.add(lblChuaDN);
	
	JPanel pnGD = new JPanel();
	JLabel lblSotienRut = new JLabel("Số tiền rút ");
	 txtGD = new JTextField(15);
	 btnGD=new JButton("Rút tiền");
	 btnDX=new JButton("Đăng xuất");
	pnGD.setPreferredSize(new Dimension(500, 500));
	Border borderGD=BorderFactory.createLineBorder(Color.BLACK);
	TitledBorder borderTitleGD=BorderFactory.createTitledBorder(borderGD, "");
	pnGD.setBorder(borderTitleGD);
	pnGD.add(lblSotienRut);
	pnGD.add(txtGD);
	pnGD.add(btnGD);
	pnGD.add(btnDX);
	
	
	JPanel pnCbo = new JPanel();
	JLabel lblCbo = new JLabel("Vị trí ");
	lblCbo.setPreferredSize(new Dimension(90, 20));
	btnNhap = new JButton();
	cbo=new JComboBox();
	cbo.addItem("Chọn Máy ATM");
	arrATM = MayATMDb.hienThiViTriMay();
	for(MayATM x:arrATM) {
		cbo.addItem(x.getMaMay());
	}
	pnCbo.add(lblCbo);
	pnCbo.add(cbo);
	
	
	 cl = new CardLayout();
	 pnHienThi = new JPanel(cl);
	pnHienThi.setPreferredSize(new Dimension(500, 500));
	pnHienThi.add(pnChuaDN, "1");
	pnHienThi.add(pnGD, "2");
	cl.show(pnHienThi, "1");
	
	
	pnMa_Pass.add(pnMa);
	pnMa_Pass.add(pnMatKhau);
	pnMa_Pass.add(pnCbo);
	pnRutTien.add(pnMa_Pass);
	pnRutTien.add(pnFlowDN);
	pnRutTien.add(pnHienThi);
	this.add(pnRutTien);
}

@Override
public void actionPerformed(ActionEvent arg0) {
	
}
	
	
}
