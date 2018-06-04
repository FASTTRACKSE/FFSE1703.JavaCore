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

import project.model.GiaoDichDB;
import project.model.KhachHangGD;

public class LayoutTinhHinhRutTien extends JPanel {

	private static final long serialVersionUID = 1L;
	JDateChooser jdTuNgay, jdDenNgay;
	JTextField txtMaK, txtMaMay;
	@SuppressWarnings("rawtypes")
	JComboBox cbo,cbo1,cbo2, cboDenThang,cboDenNam;
	JButton btnXem, btnSua;
	DefaultTableModel dm=new DefaultTableModel();
	ArrayList<KhachHangGD> arrKHGD = new ArrayList<KhachHangGD>();
	final JTable tbl=new JTable(dm);
	JScrollPane sc=new JScrollPane(tbl);
	public LayoutTinhHinhRutTien() {
		arrKHGD = GiaoDichDB.giaoDichKH();
		
		addControll();
		for(KhachHangGD x:arrKHGD) {
			String tongTien = String.valueOf(x.getTongTien());
			String thoiGian = String.valueOf(x.getThoiGianGD());
			String[] row = {x.getMaK(),x.getTenKhach(),x.getMaATM(),x.getMaGiaoDich(),thoiGian,tongTien};
			dm.addRow(row);
		}
			addEvent();
		}

	private void addEvent() {
	
		// TODO Auto-generated method stub
		btnXem.addActionListener(eventXem);
		btnSua.addActionListener(eventHuy);
	}
	//
	ActionListener eventXem = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				String maKhach = txtMaK.getText();
				String maMay = txtMaMay.getText();
				Date tuNgay = jdTuNgay.getDate();
				Date denNgay = new Date();
				Calendar c = jdDenNgay.getCalendar(); 
				c.add(Calendar.DATE, 1);
				denNgay = c.getTime();
				
				dm.setRowCount(0);
				for(KhachHangGD x: arrKHGD) {
					if(x.getMaK().indexOf(maKhach)>-1&& x.getMaATM().indexOf(maMay)>-1&& 
							x.getThoiGianGD().after(tuNgay)&& x.getThoiGianGD().before(denNgay)  ) {
						String tongTien = String.valueOf(x.getTongTien());
						String thoiGian = String.valueOf(x.getThoiGianGD());
						String[] row = {x.getMaK(),x.getTenKhach(),x.getMaATM(),x.getMaGiaoDich(),thoiGian,tongTien};
						dm.addRow(row);
					}
				}
			}catch (Exception e){
				JOptionPane.showMessageDialog(null, "Chưa chọn ngày!!!");
			}
			
			
		}

	};
	
	ActionListener eventHuy = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			dm.setRowCount(0);
			for(KhachHangGD x:arrKHGD) {
				String tongTien = String.valueOf(x.getTongTien());
				String thoiGian = String.valueOf(x.getThoiGianGD());
				String[] row = {x.getMaK(),x.getTenKhach(),x.getMaATM(),x.getMaGiaoDich(),thoiGian,tongTien};
				dm.addRow(row);
			}
			txtMaK.setText("");
			txtMaMay.setText("");
			jdTuNgay.setCalendar(null);
			jdDenNgay.setCalendar(null);
		}

	};


	private void addControll() {
		
		Border border5=BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle5=BorderFactory.createTitledBorder(border5, "Quản Lý Giao Dịch Khách Hàng");
		this.setBorder(borderTitle5);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel pnChinh =new JPanel();
		Border border=BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle=BorderFactory.createTitledBorder(border, "Thông Tin");
		pnChinh.setBorder(borderTitle);
		pnChinh.setLayout(new BoxLayout(pnChinh, BoxLayout.X_AXIS));
		
		JPanel pnMaC = new JPanel();
		pnMaC.setLayout(new BoxLayout(pnMaC, BoxLayout.Y_AXIS));
		JPanel pnMaK =new JPanel();
		JLabel lblMaK= new JLabel("Mã Khách:");
		lblMaK.setPreferredSize(new Dimension(90, 20));
		 txtMaK = new JTextField(15);
		pnMaK.add(lblMaK);
		pnMaK.add(txtMaK);
		pnMaC.add(pnMaK);
		
		JPanel pnMaMay =new JPanel();
		JLabel lblMaMay= new JLabel("Mã Máy:");
		lblMaMay.setPreferredSize(new Dimension(90, 20));
		 txtMaMay = new JTextField(15);
		pnMaMay.add(lblMaMay);
		pnMaMay.add(txtMaMay);
		pnMaC.add(pnMaMay);
		
		JPanel pnThoiGian =new JPanel();
		pnThoiGian.setLayout(new BoxLayout(pnThoiGian, BoxLayout.X_AXIS));
		
		JPanel pnTuNgay =new JPanel();
		JLabel lblTuNgay= new JLabel("Từ ngày:");
		jdTuNgay = new JDateChooser();
		jdTuNgay.setPreferredSize(new Dimension(100, 20));
		//set định dạng hiển thị trên jdateChooser
		jdTuNgay.setDateFormatString("dd/MM/yyyy");
		//không cho sửa ngày trên jdateChooser
		JTextFieldDateEditor editorTu = (JTextFieldDateEditor) jdTuNgay.getDateEditor();
		editorTu.setEditable(false);
		pnTuNgay.add(lblTuNgay);
		pnTuNgay.add(jdTuNgay);
		pnThoiGian.add(pnTuNgay);
		
		JPanel pnDenNgay =new JPanel();
		JLabel lblDenNgay= new JLabel("Đến Ngày:");
		jdDenNgay = new JDateChooser();
		jdDenNgay.setPreferredSize(new Dimension(100, 20));
		//set định dạng hiển thị trên jdateChooser
		jdDenNgay.setDateFormatString("dd/MM/yyyy");
		//không cho sửa ngày trên jdateChooser
		JTextFieldDateEditor editorden = (JTextFieldDateEditor) jdDenNgay.getDateEditor();
		editorden.setEditable(false);
		pnDenNgay.add(lblDenNgay);
		pnDenNgay.add(jdDenNgay);
		pnThoiGian.add(pnDenNgay);
	
		
		JPanel pnFlow=new JPanel();
		pnFlow.setLayout(new FlowLayout());
		pnFlow.setBackground(Color.PINK);
		 btnXem=new JButton("Xem");
		 btnSua=new JButton("Huỷ");
		pnFlow.add(btnXem);
		pnFlow.add(btnSua);
		
		
		JPanel pnBang6 = new JPanel();
		Border border3=BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder borderTitle3=BorderFactory.createTitledBorder(border3, "Hiển Thị Thông Tin Khách Hàng");
		pnBang6.setBorder(borderTitle3);
		dm.addColumn("Mã khách");
		dm.addColumn("Tên khách");
		dm.addColumn("Mã Máy");
		dm.addColumn("Mã Giao Dịch");
		dm.addColumn("Thời Gian Giao Dịch");
		dm.addColumn("Số Tiền Rút");
		pnBang6.setLayout(new BorderLayout());
		pnBang6.add(sc,BorderLayout.CENTER);

		pnChinh.add(pnMaC);
		pnChinh.add(pnThoiGian);
		this.add(pnChinh);
		this.add(pnFlow);
		this.add(pnBang6);
		
	}
}
