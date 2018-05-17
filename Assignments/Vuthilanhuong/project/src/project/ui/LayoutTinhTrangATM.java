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
import project.model.MayATM;
import project.model.MayATMDb;
import project.model.MayATMDb;
import project.model.MayATM;

public class LayoutTinhTrangATM  extends JPanel{
	JButton btnHuy, btnXem;
	JTextField txtATM;
	JTextField txtDuong;
	JComboBox cbQuan, cbPhuong;
	DefaultTableModel dm=new DefaultTableModel();
	final JTable tbl=new JTable(dm);
	JScrollPane sc=new JScrollPane(tbl);
	static ConnectDB myDb = new ConnectDB();
	Connection conn = myDb.getConnect("localhost", "ffse1703001", "huong", "12345");
	DiaChiDB diachiDb = new DiaChiDB();
	ArrayList<String> arrDiaChi = new ArrayList<String>();
	MayATMDb ATMDb = new MayATMDb();
	ArrayList<MayATM> arrATM = new ArrayList<MayATM>();
	public LayoutTinhTrangATM() {
		addControll();
		arrATM=ATMDb.hienThiMayATM();
		for(MayATM x:arrATM) {
			String[] row = {x.getMaMay(),x.getTenDuong(),x.getTongTien()};
			dm.addRow(row);
		}
		addEvent();
		}

	

	private void addEvent() {
		// TODO Auto-generated method stub
		cbQuan.addActionListener(eventHienThiPhuong);
		txtATM.getDocument().addDocumentListener(eventTimTheoMa);
		btnHuy.addActionListener(eventHuy);
		btnXem.addActionListener(eventTimTheoDiaChi);
	}
	ActionListener eventHienThiPhuong = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			int key= cbQuan.getSelectedIndex();
			arrDiaChi= diachiDb.hienThiPhuong(key);
			cbPhuong.removeAllItems();
			cbPhuong.addItem("Tất Cả");
			for(String x:arrDiaChi) {
				cbPhuong.addItem(x);
				
			}
		}

	};
	
	ActionListener eventTimTheoDiaChi= new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			ArrayList<MayATM>arrDC= new ArrayList<MayATM>();
			String duong = txtDuong.getText();
			String quan = cbQuan.getSelectedItem().toString();
			int keyQuan= cbQuan.getSelectedIndex();
			String phuong = cbPhuong.getSelectedItem().toString();
			int keyPhuong = cbPhuong.getSelectedIndex();
			
			if(keyQuan==0) {
				quan = "";
				phuong = "";
				arrDC = ATMDb.timTheoDiaChi(quan, phuong, duong);
			}else if (keyPhuong==0) {
				phuong = "";
				arrDC = ATMDb.timTheoDiaChi(quan, phuong, duong);
			}else {
				arrDC = ATMDb.timTheoDiaChi(quan,phuong,duong);
			}
			dm.setRowCount(0);
			for(MayATM x:arrDC) {
				String[] row = {x.getMaMay(),x.getTenDuong(),x.getTongTien()};
				dm.addRow(row);
			}	
			
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
	
	public void searchCode() {
		String maMAy =  txtATM.getText();
		ArrayList<MayATM> arrATM = new ArrayList <MayATM>();
		arrATM = ATMDb.timTheoMa(maMAy);
		dm.setRowCount(0);
		for(MayATM x:arrATM) {
			String[] row = {x.getMaMay(),x.getTenDuong(),x.getTongTien()};
			dm.addRow(row);
		}
	}
	
	ActionListener eventHuy = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			arrATM=ATMDb.hienThiMayATM();
			txtATM.setText("");
			txtDuong.setText("");
			dm.setRowCount(0);
			for(MayATM x:arrATM) {
				String[] row = {x.getMaMay(),x.getTenDuong(),x.getTongTien()};
				dm.addRow(row);
			}
			
		}

	};

	private void addControll() {
		// TODO Auto-generated method stub
		JPanel pnTTrangATM =new JPanel();
		pnTTrangATM.setPreferredSize(new Dimension(1000, 700));
		pnTTrangATM.setLayout(new BoxLayout(pnTTrangATM, BoxLayout.Y_AXIS));
		
		JPanel pnChinh = new JPanel();
		pnChinh.setLayout(new BoxLayout(pnChinh, BoxLayout.X_AXIS));
		JPanel pnVitri= new JPanel();
		Border border5=BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle5=BorderFactory.createTitledBorder(border5, "Vị Trí");
		pnVitri.setBorder(borderTitle5);
		pnVitri.setLayout(new BoxLayout(pnVitri, BoxLayout.Y_AXIS));
		JPanel pnQuan = new JPanel();
		JLabel lblQuan = new JLabel("Chọn quận: ");
		lblQuan.setPreferredSize(new Dimension(90, 20));
		cbQuan = new JComboBox();
		cbQuan.setPreferredSize(new Dimension(165, 20));
		arrDiaChi = diachiDb.hienThiQuan();
		cbQuan.addItem("Tất Cả");
		for(String x: arrDiaChi) {
			cbQuan.addItem(x);
		}
		pnQuan.add(lblQuan);
		pnQuan.add(cbQuan);
		pnVitri.add(pnQuan);
		
		JPanel pnPhuong = new JPanel();
		JLabel lblPhuong = new JLabel("Chọn phường: ");
		lblPhuong.setPreferredSize(new Dimension(90, 20));
		cbPhuong = new JComboBox();
		cbPhuong.addItem("Tất Cả");
		cbPhuong.setPreferredSize(new Dimension(165, 20));
		pnPhuong.add(lblPhuong);
		pnPhuong.add(cbPhuong);
		pnVitri.add(pnPhuong);

		JPanel pnDuong = new JPanel(); 
		JLabel lblDuong = new JLabel("Đường");
		lblDuong.setPreferredSize(new Dimension(90, 20));
		txtDuong = new JTextField(15);
		pnDuong.add(lblDuong);
		pnDuong.add(txtDuong);
		pnVitri.add(pnDuong);
	
		
		JPanel pnATM =new JPanel();
		Border border4=BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle4=BorderFactory.createTitledBorder(border4, "Chọn Máy Theo Mã");
		pnATM.setBorder(borderTitle4);
		pnATM.setLayout(new BoxLayout(pnATM, BoxLayout.Y_AXIS));
		JPanel pnMaMay = new JPanel();
		JLabel lblMaMay= new JLabel("Mã Máy");
		txtATM = new JTextField(15);
		pnMaMay.add(lblMaMay);
		pnMaMay.add(txtATM);
		pnATM.add(pnMaMay);
		
		JPanel pnFlow=new JPanel();
		pnFlow.setLayout(new BoxLayout(pnFlow, BoxLayout.X_AXIS));
		btnXem=new JButton("Xem");
		btnHuy=new JButton("Hủy ");
		pnFlow.add(btnXem);
		pnFlow.add(btnHuy);
		
		
		JPanel pnBang5 = new JPanel();
		Border border3=BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder borderTitle3=BorderFactory.createTitledBorder(border3, "Hiển Thị Thông Tin Khách Hàng");
		pnBang5.setBorder(borderTitle3);
		dm.addColumn("Mã");
		dm.addColumn("Địa Chỉ");
		dm.addColumn("Tổng Tiền");
		pnBang5.setLayout(new BorderLayout());
		pnBang5.add(sc,BorderLayout.CENTER);
		
		pnChinh.add(pnVitri);
		pnChinh.add(pnATM);
		pnTTrangATM.add(pnChinh);
		pnTTrangATM.add(pnFlow);
		pnTTrangATM.add(pnBang5);
		this.add(pnTTrangATM);
	}
}
	