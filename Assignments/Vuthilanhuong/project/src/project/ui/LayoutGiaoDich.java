package project.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import project.model.ATMGD;
import project.model.DiaChiDB;
import project.model.GiaoDichDB;

public class LayoutGiaoDich extends JPanel{

	private static final long serialVersionUID = 1L;
	JDateChooser jdTuNgay, jdDenNgay;
	@SuppressWarnings("rawtypes")
	JComboBox cbQuan, cbPhuong;
	JTextField txtMaMay, txtSoThe, txtTgRut, txtSoTien, txtDuong;
	JButton btnXem,btnHuy;
	DefaultTableModel dm=new DefaultTableModel();
	final JTable tbl=new JTable(dm);
	JScrollPane sc=new JScrollPane(tbl);
	DiaChiDB diachiDb = new DiaChiDB();
	ArrayList<String> arrDiaChi = new ArrayList<String>();
	ArrayList<ATMGD> arrATMGD = new ArrayList<ATMGD>();
	public LayoutGiaoDich() {
		arrATMGD = GiaoDichDB.giaoDichATM();

		addControll();
		for(ATMGD x: arrATMGD ) {
			@SuppressWarnings("unused")
			String thoiGian = String.valueOf(x.getThoiGianGD());
			String tongTien = String.valueOf(x.getTongTien());
			String[] row = {x.getMaATM(),x.getDuong()+" "+x.getPhuong()+" "+x.getQuan(),x.getMaGiaoDich(),x.getThoiGianGD().toString(),tongTien};
			dm.addRow(row);
		}
			addEvent();
		}

	private void addEvent() {
		cbQuan.addActionListener(eventHienThiPhuong);
		btnXem.addActionListener(eventInGiaoDich);
		btnHuy.addActionListener(eventHuy);
	}
	ActionListener eventHienThiPhuong = new ActionListener() {
		//event hiển thị phường
		@SuppressWarnings("unchecked")
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int key= cbQuan.getSelectedIndex();
			arrDiaChi= diachiDb.hienThiPhuong(key);
			cbPhuong.removeAllItems();
			cbPhuong.addItem("Tất cả");
			for(String x:arrDiaChi) {
				cbPhuong.addItem(x);
				
			}
		}

	};
	//set các ô JTextF về trống và in ra
	ActionListener eventHuy = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			dm.setRowCount(0);
			for(ATMGD x: arrATMGD ) {
				@SuppressWarnings("unused")
				String thoiGian = String.valueOf(x.getThoiGianGD());
				String tongTien = String.valueOf(x.getTongTien());
				String[] row = {x.getMaATM(),x.getDuong()+" "+x.getPhuong()+" "+x.getQuan(),x.getMaGiaoDich(),x.getThoiGianGD().toString(),tongTien};
				dm.addRow(row);
			}
			txtSoThe.setText("");
			txtDuong.setText("");
			txtMaMay.setText("");
			jdTuNgay.setCalendar(null);
			jdDenNgay.setCalendar(null);
		}

	};
	//event hiển thị các thông tin của khách
	ActionListener eventInGiaoDich = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				String maMay = txtMaMay.getText();
				String duong = txtDuong.getText();
				String quan = cbQuan.getSelectedItem().toString();
				int Quan= cbQuan.getSelectedIndex();
				String phuong = cbQuan.getSelectedItem().toString();
				int Phuong = cbPhuong.getSelectedIndex();
				
				Date tuNgay = jdTuNgay.getDate();
				Date denNgay = new Date();
				Calendar c = jdDenNgay.getCalendar(); 
				c.add(Calendar.DATE, 1);
				denNgay = c.getTime();
				
				if(Quan==0) {
					quan="";
					phuong="";
					timKiem( quan,  phuong,  duong,  maMay,  tuNgay,  denNgay);
				}
				else if (Phuong==0) {
				phuong = "";
				timKiem( quan,  phuong,  duong,  maMay,  tuNgay,  denNgay);
				}
				else {
					timKiem( quan,  phuong,  duong,  maMay,  tuNgay,  denNgay);
				}
			
			}catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày");
			}
			
		}
	};
	
	//event  tìm kiếm máy atm
	public void timKiem(String quan, String phuong, String duong, String maMay, Date tuNgay, Date denNgay) {
		dm.setRowCount(0);
		for(ATMGD x:arrATMGD) {
			if(x.getQuan().indexOf(quan)>-1 && x.getPhuong().indexOf(phuong)>-1 && x.getDuong().indexOf(duong)>-1 && x.getMaATM().indexOf(maMay)>-1 
					&& x.getThoiGianGD().after(tuNgay)&& x.getThoiGianGD().before(denNgay) ) {
				String tongTien = String.valueOf(x.getTongTien());
				String thoiGian = String.valueOf(x.getThoiGianGD());
				String[] row = {x.getMaATM(),x.getDuong()+" "+x.getPhuong()+ " "+ x.getQuan(),x.getMaGiaoDich(),thoiGian,tongTien};
				dm.addRow(row);
			}
		}
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void addControll() {
		
		Border border5=BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle5=BorderFactory.createTitledBorder(border5, "Quản Lý Giao Dịch ATM");
		this.setBorder(borderTitle5);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel pnQuanLy =new JPanel();
		pnQuanLy.setLayout(new BoxLayout(pnQuanLy, BoxLayout.X_AXIS));
		
		JPanel pnMa_The = new JPanel();
		pnMa_The.setLayout(new BoxLayout(pnMa_The, BoxLayout.Y_AXIS));
		
		JPanel pnQuan = new JPanel();
		JLabel lblQuan = new JLabel("Chọn quận: ");
		lblQuan.setPreferredSize(new Dimension(90, 20));
		cbQuan = new JComboBox();
		cbQuan.setPreferredSize(new Dimension(165, 20));
		arrDiaChi = diachiDb.hienThiQuan();
		cbQuan.addItem("Tất cả");
		for(String x: arrDiaChi) {
			cbQuan.addItem(x);
		}
		
		pnQuan.add(lblQuan);
		pnQuan.add(cbQuan);
		pnMa_The.add(pnQuan);

		JPanel pnPhuong = new JPanel();
		JLabel lblPhuong = new JLabel("Chọn phường: ");
		lblPhuong.setPreferredSize(new Dimension(90, 20));
		cbPhuong = new JComboBox();
		cbPhuong.addItem("Tất Cả");
		cbPhuong.setPreferredSize(new Dimension(165, 20));
		
		pnPhuong.add(lblPhuong);
		pnPhuong.add(cbPhuong);
		pnMa_The.add(pnPhuong);
		
		JPanel pnDuong = new JPanel(); 
		JLabel lblDuong = new JLabel("Đường");
		lblDuong.setPreferredSize(new Dimension(90, 20));
		txtDuong = new JTextField(20);
		pnDuong.add(lblDuong);
		pnDuong.add(txtDuong);
		pnMa_The.add(pnDuong);
		
		JPanel pnTgRut_SoTien = new JPanel();
		pnTgRut_SoTien.setLayout(new BoxLayout(pnTgRut_SoTien, BoxLayout.Y_AXIS));
		
		JPanel pnMaMay = new JPanel();
		JLabel lblMaMay = new JLabel("Mã máy: ");
		lblMaMay.setPreferredSize(new Dimension(90, 20));
		 txtMaMay = new JTextField(15);
		pnMaMay.add(lblMaMay);
		pnMaMay.add(txtMaMay);
		pnTgRut_SoTien.add(pnMaMay);
		
		JPanel pnNgay = new JPanel();
		pnNgay.setLayout(new FlowLayout());
		
		JPanel pnTuNgay =new JPanel();
		JLabel lblTuNgay= new JLabel("Từ ngày:");
		//dùng jdateChooser để tạo giao diện chọn ngày
		jdTuNgay = new JDateChooser();
		jdTuNgay.setPreferredSize(new Dimension(100, 20));
		//set định dạng hiển thị trên jdateChooser
		jdTuNgay.setDateFormatString("dd/MM/yyyy");
		//không cho sửa ngày trên jdateChooser
		JTextFieldDateEditor editorTu = (JTextFieldDateEditor) jdTuNgay.getDateEditor();
		editorTu.setEditable(false);
		
		pnTuNgay.add(lblTuNgay);
		pnTuNgay.add(jdTuNgay);
		pnNgay.add(pnTuNgay);
		
		JPanel pndenNgay =new JPanel();
		JLabel lblThang= new JLabel("Đến Ngày:");
		//dùng jdateChooser để tạo giao diện chọn ngày
		jdDenNgay = new JDateChooser();
		jdDenNgay.setPreferredSize(new Dimension(100, 20));
		//set định dạng hiển thị trên jdateChooser
		jdDenNgay.setDateFormatString("dd/MM/yyyy");
		//không cho sửa ngày trên jdateChooser
		JTextFieldDateEditor editorDen = (JTextFieldDateEditor) jdDenNgay.getDateEditor();
		editorDen.setEditable(false);
		//jdDenNgay = new JDateChooser();

		pndenNgay.add(lblThang);
		pndenNgay.add(jdDenNgay);
		pnNgay.add(pndenNgay);
		
		pnTgRut_SoTien.add(pnNgay);
		
		JPanel pnFlow3=new JPanel();
		pnFlow3.setLayout(new FlowLayout());
		pnFlow3.setBackground(Color.PINK);
		btnXem=new JButton("Xem");
		btnHuy=new JButton("Hủy");
		pnFlow3.add(btnXem);pnFlow3.add(btnHuy);
		
		
		JPanel pnBang3 = new JPanel();
		Border border7=BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder borderTitle6=BorderFactory.createTitledBorder(border7, "Hiển Thị Thông Tin Máy");
		pnBang3.setBorder(borderTitle6);
		dm.addColumn("Mã Máy ATM");
		dm.addColumn("Vị trí máy");
		dm.addColumn("Mã Giao Dich");
		dm.addColumn("Thời Gian Giao Dịch");
		dm.addColumn("Số Tiền Rút");
		pnBang3.setLayout(new BorderLayout());
		pnBang3.add(sc,BorderLayout.CENTER);
		
		pnQuanLy.add(pnMa_The);
		pnQuanLy.add(pnTgRut_SoTien);
		this.add(pnQuanLy);
		this.add(pnFlow3);
		this.add(pnBang3);
	}
}
