package project.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import project.model.DiaChiDB;
import project.model.MayATM;
import project.model.MayATMDb;

@SuppressWarnings("serial")
public class LayoutATM extends JPanel{
	@SuppressWarnings("rawtypes")
	JComboBox cbQuan, cbPhuong;
	JTextField txtMaMay,txtDuong, txtTongTien;
	JButton btnThem,btnSua, btnXoa, btnHuy;
	DefaultTableModel dm=new DefaultTableModel();
	final JTable tbl=new JTable(dm);
	JScrollPane sc=new JScrollPane(tbl);
	DiaChiDB diachiDb = new DiaChiDB();
	ArrayList<String> arrDiaChi = new ArrayList<String>();
	MayATMDb atmDB = new MayATMDb();
	ArrayList<MayATM> arrATM = new ArrayList<MayATM>();
	public LayoutATM() {
	addControll();
	arrATM = atmDB.hienThiMayATM();
	for(MayATM x:arrATM) {
		String[] row = {x.getMaMay(),x.getTenDuong(),x.getTongTien()};
		dm.addRow(row);
	}
		addEvent();
	}
	private void addEvent() {
		// TODO Auto-generated method stub
		cbQuan.addActionListener(eventHienThiPhuong);
		btnThem.addActionListener(eventThem);
		btnSua.addActionListener(eventSua);
		btnXoa.addActionListener(eventXoa);
		btnHuy.addActionListener(eventHuy);
		tbl.addMouseListener(eventChooseRow);
		
	}
	 MouseAdapter eventChooseRow = new MouseAdapter() {
		 
	    	public void mouseClicked(MouseEvent e) {
	    		btnSua.setEnabled(true);
				btnXoa.setEnabled(true);
				btnThem.setEnabled(false);
	    		/*Lấy dòng được chọn trong table*/
	    		int col = tbl.getSelectedRow();
	    		
	    		String ma =  (String) tbl.getValueAt(col, 0);
	    		String viTri = (String) tbl.getValueAt(col,1);
	    		String tongTien = (String) tbl.getValueAt(col,2);
	    		
	    		
	    		/*Nếu đã chọn dòng trên table thì col sẽ lớn hơn giá trị mặc định là -1*/ 
	    		if(col>-1) {
	    			/*Duyệt mảng từ arraylist để đặt giá trị vào ô quận phường*/
	    			for(MayATM x:arrATM) {
		    			if(ma.equals(x.getMaMay())) {
		    				cbQuan.setSelectedItem(x.getTenQuan());
		    				cbPhuong.setSelectedItem(x.getTenPhuong());
		    			}
		    		}
	    			/*đặt giá trị cho các ô textfield*/
	    			txtMaMay.setText(ma);
	    			txtMaMay.setEditable(false);
	    			
	    			txtDuong.setText(viTri);
	    			txtTongTien.setText(tongTien);
	    		}
	    		
	    		
	    	}
	 };
	//event thêm dữ liệu vào bảng
	ActionListener eventThem = new ActionListener() {

		@SuppressWarnings("static-access")
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				String maMay = txtMaMay.getText();
				String tenDuong= txtDuong.getText();
				String tongTien = txtTongTien.getText();
				String quan = (String) cbQuan.getSelectedItem();
				int keyQuan = cbQuan.getSelectedIndex();
				String phuong = (String) cbPhuong.getSelectedItem();
				if(maMay.isEmpty()||tenDuong.isEmpty()||tongTien.isEmpty()||keyQuan==0) {
					JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin");
				}else {
					MayATM mayATM = new MayATM();
					mayATM.add(quan,phuong,tenDuong,maMay,tongTien);
					atmDB.themMayATM(mayATM);
					String[] row = {maMay,tenDuong,tongTien};
					dm.addRow(row);
					txtMaMay.setText("");
					txtDuong.setText("");
					txtTongTien.setText("");
					cbQuan.setSelectedIndex(0);
					
				}
				
			}catch(Exception x) {
				JOptionPane.showMessageDialog(null, "Nhập sai thông tin");
			}
			
		}

	};
	//event hiển thị phường trong ô comboBox
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
	//event sửa dữ liệu trong bảng atm_atm trong database
	ActionListener eventSua = new ActionListener() {

		@SuppressWarnings("static-access")
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				String maMay = txtMaMay.getText();
				String tenDuong= txtDuong.getText();
				String tongTien = txtTongTien.getText();
				String quan = (String) cbQuan.getSelectedItem();
				int keyQuan = cbQuan.getSelectedIndex();
				String phuong = (String) cbPhuong.getSelectedItem();
				if(maMay.isEmpty()||tenDuong.isEmpty()||tongTien.isEmpty()||keyQuan==0) {
					JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin");
				}else {
					MayATM mayATM = new MayATM();
					mayATM.add(quan,phuong,tenDuong,maMay,tongTien);
					atmDB.suaMayATM(mayATM);
					dm.setRowCount(0);
					arrATM = atmDB.hienThiMayATM();
					for(MayATM x:arrATM) {
						String[] row = {x.getMaMay(),x.getTenDuong(),x.getTongTien()};
						dm.addRow(row);
					}
					txtMaMay.setText("");
					
					txtDuong.setText("");
					txtTongTien.setText("");
					cbQuan.setSelectedIndex(0);
					txtMaMay.setEditable(true);
					btnSua.setEnabled(false);
					btnXoa.setEnabled(false);
					btnThem.setEnabled(true);
				}
				
			}catch(Exception X) {
				JOptionPane.showMessageDialog(null, "Nhập sai thông tin");
			}
			
		}

	};
	ActionListener eventXoa = new ActionListener() {

		@SuppressWarnings("static-access")
		@Override
		public void actionPerformed(ActionEvent e) {
			String mayATM = txtMaMay.getText();
			atmDB.xoaMayATM(mayATM);
			int row;
			row = tbl.getSelectedRow();
			if(row>-1) {
				dm.removeRow(row);
				
			}
			//set ô input về trống
			txtMaMay.setText("");
			txtDuong.setText("");
			txtTongTien.setText("");
			cbQuan.setSelectedIndex(0);
			txtMaMay.setEditable(true);
			btnSua.setEnabled(false);
			btnXoa.setEnabled(false);
			btnThem.setEnabled(true);
		}
	};
	
	//sự kiện đưa các ô JTextF về trống và in ra bảng
	ActionListener eventHuy = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			btnSua.setEnabled(false);
			btnXoa.setEnabled(false);
			btnThem.setEnabled(true);
			arrATM=atmDB.hienThiMayATM();
			txtMaMay.setText("");
			txtMaMay.setEditable(true);
			txtDuong.setText("");
			txtTongTien.setText("");
			cbQuan.setSelectedIndex(0);
			dm.setRowCount(0);
			for(MayATM x:arrATM) {
				String[] row = {x.getMaMay(),x.getTenDuong(),x.getTongTien()};
				dm.addRow(row);
			}
			
		}

	};
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void addControll() {
		
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		Border border5=BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle5=BorderFactory.createTitledBorder(border5, "Quản Lý ATM");
		this.setBorder(borderTitle5);
		
		//JPanel quản lý atm
		JPanel pnQuanLyChinh = new JPanel();
		pnQuanLyChinh.setLayout(new BoxLayout(pnQuanLyChinh, BoxLayout.X_AXIS));
		
		JPanel pnQuanLy1 = new JPanel();
		pnQuanLy1.setLayout(new BoxLayout(pnQuanLy1, BoxLayout.Y_AXIS));
		//JPanel mã atm
		JPanel pnMaMay = new JPanel(); 
		JLabel lblMaMay = new JLabel("Mã máy ATM: ");
		lblMaMay.setPreferredSize(new Dimension(90, 20));
		txtMaMay = new JTextField(20);
		pnMaMay.add(lblMaMay);
		pnMaMay.add(txtMaMay);
		pnQuanLy1.add(pnMaMay);
		//JPanel Quận
		JPanel pnQuan = new JPanel();
		JLabel lblQuan = new JLabel("Chọn quận: ");
		lblQuan.setPreferredSize(new Dimension(90, 20));
		cbQuan = new JComboBox();
		cbQuan.setPreferredSize(new Dimension(165, 20));
		cbQuan.addItem("Chọn Quận");
		//gọi hàm hienThiQuan trong class DiaChiDB để có giá trị gán vào arraylist
		arrDiaChi = diachiDb.hienThiQuan();
		//in giá trị từ arraylist
		for(String x: arrDiaChi) {
			cbQuan.addItem(x);
		}
		pnQuan.add(lblQuan);
		pnQuan.add(cbQuan);
		pnQuanLy1.add(pnQuan);
		//JPanel phường
		JPanel pnPhuong = new JPanel();
		JLabel lblPhuong = new JLabel("Chọn phường: ");
		lblPhuong.setPreferredSize(new Dimension(90, 20));
		cbPhuong = new JComboBox();
		cbPhuong.setPreferredSize(new Dimension(165, 20));
		
		pnPhuong.add(lblPhuong);
		pnPhuong.add(cbPhuong);
		pnQuanLy1.add(pnPhuong);
		//JPanel Đường
		JPanel pnDuong = new JPanel(); 
		JLabel lblDuong = new JLabel("Đường");
		lblDuong.setPreferredSize(new Dimension(90, 20));
		txtDuong = new JTextField(20);
		pnDuong.add(lblDuong);
		pnDuong.add(txtDuong);
		pnQuanLy1.add(pnDuong);
		
		//JPanel chứa tổng tiền
		JPanel pnQuanLy2 = new JPanel();
		pnQuanLy2.setLayout(new BoxLayout(pnQuanLy2, BoxLayout.Y_AXIS));
		JPanel pnTongTien = new JPanel();
		Border border4=BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle4=BorderFactory.createTitledBorder(
		border4, "Tổng tiền");
		pnTongTien.setBorder(borderTitle4);
		txtTongTien = new JTextField(15);
		pnTongTien.add(txtTongTien);
		pnQuanLy2.add(pnTongTien);
		
		//JPanel chứa các JButton
		JPanel pnQuanLy3 = new JPanel();
		pnQuanLy3.setLayout(new BoxLayout(pnQuanLy3, BoxLayout.X_AXIS));
		JPanel pnFlow1=new JPanel();
		pnFlow1.setLayout(new FlowLayout());
		pnFlow1.setBackground(Color.PINK);
		 btnThem=new JButton("Thêm");
		 btnSua=new JButton("Sửa");
		 btnXoa=new JButton("Xóa");
		 btnHuy=new JButton("Hủy");
		 btnSua.setEnabled(true);
			btnXoa.setEnabled(false);
			btnSua.setEnabled(false);
		pnFlow1.add(btnThem);pnFlow1.add(btnSua);
		pnFlow1.add(btnXoa);pnFlow1.add(btnHuy);
		pnQuanLy3.add(pnFlow1);
		
		
		pnQuanLyChinh.add(pnQuanLy1);
		pnQuanLyChinh.add(pnQuanLy2);
		this.add(pnQuanLyChinh);
		this.add(pnQuanLy3);
		//this.add(this);
		
		//JPanel hiển thị bảng
		JPanel pnBang2 = new JPanel();
		Border border6=BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder borderTitle6=BorderFactory.createTitledBorder(border6, "Hiển Thị Thông Tin Máy");
		pnBang2.setBorder(borderTitle6);
		dm.addColumn("Mã Máy ATM");
		dm.addColumn("Vị trí máy");
		dm.addColumn("Tổng tiền");
		pnBang2.setLayout(new BorderLayout());
		pnBang2.add(sc,BorderLayout.CENTER);
		
		this.add(pnBang2);
		
		}

}

