package asm10.ui;
import java.util.ArrayList;
import asm10.model.*;
import luufile.luuFile;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import luufile.*;
import asm10.main.*;

public class Layout extends JFrame {
	JTextField txtMa, txtTen,txtTuoi;
	JButton btnThem, btnSua,btnXoa,btnThoat,btnNhap;
	JComboBox cbo;
	DefaultTableModel dm=new DefaultTableModel();
	final JTable tbl=new JTable(dm);
	JScrollPane sc=new JScrollPane(tbl);
	ArrayList <SinhVien> arrSv = new ArrayList<SinhVien>();
	QuanLySv myDb = new QuanLySv();
	Connection conn= myDb.getConnect("localhost", "SinhVien", "huong",
			"12345");
	public Layout(String title) {
		super(title);
		addControl();
		addEvents();
	}
	

	private void addEvents() {
		// TODO Auto-generated method stub
		btnThem.addActionListener(eventThem);
		btnSua.addActionListener(eventSua);
		btnXoa.addActionListener(eventXoa);
		btnThoat.addActionListener(eventThoat);
		btnNhap.addActionListener(eventNhap);
		tbl.addMouseListener(eventChooseRow);
	}
	 MouseAdapter eventChooseRow = new MouseAdapter() {
	    	public void mouseClicked(MouseEvent e) {
	    		txtMa.setEditable(false);
	    		int col = tbl.getSelectedRow();
	    		String ma =  (String) tbl.getValueAt(col, 0);
	    		String ten =  (String) tbl.getValueAt(col, 1);
	    		String tuoi =  (String) tbl.getValueAt(col, 2);
	    		txtMa.setText(ma);
	    		txtTen.setText(ten);
	    		txtTuoi.setText(tuoi);
	    	}
	 };
	ActionListener eventThem = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			// TODO Auto-generated method stub
    		txtMa.setEditable(true);

			txtMa.setText("");
			txtTen.setText("");
			txtTuoi.setText("");
		}
		
	};	
	ActionListener eventSua= new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				dm.setRowCount(0);
				// TODO Auto-generated method stub
				String ma = txtMa.getText();
				String ten = txtTen.getText();
				String tuoi = txtTuoi.getText();
				if(ma.isEmpty()||ten.isEmpty()||tuoi.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Chưa chọn dòng",
			                  "Lỗi", JOptionPane.WARNING_MESSAGE);
				}
				else {
					
					try
					{
					String sql="update danhsachsv set ten='"+ten+"',tuoi='"+tuoi+"' where ma='"+ma+"' ";
					Statement statement=(Statement) conn.createStatement();
					int x=statement.executeUpdate(sql);
					if(x>0)
					{
					JOptionPane.showMessageDialog(null, "Cập nhật OK");
					}
					}
					catch(Exception ex)
					{
					ex.printStackTrace();
					}
					try {
						ArrayList<SinhVien> arrDb=new ArrayList<SinhVien>();
						Statement statement=(Statement) conn.createStatement();
						ResultSet result=statement.executeQuery
						("select * from danhsachsv");
						while(result.next())
						{
						arrDb.add(new SinhVien(result.getString("ma"),result.getString("ten"),result.getString("tuoi"),result.getString("lop")));
						}
						arrSv.clear();
						dm.setRowCount(0);
						arrSv=arrDb;
						} catch (Exception ex) {
						ex.printStackTrace();
						}
					
					for(SinhVien x : arrSv) {
						dm.addRow(new String[]{x.getMaSv(), x.getTenSv(), x.getTuoiSv(), x.getLopSv()});
					}
					
				}
				
				}
		catch(Exception X) {
			JOptionPane.showMessageDialog(null, "Nhập sai định dạng",
	                  "Lỗi", JOptionPane.WARNING_MESSAGE);
		}
		}
	};		
	ActionListener eventXoa = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			int row;
			row = tbl.getSelectedRow();
			dm.removeRow(row);
			String ma=txtMa.getText();
			try
			{
			String sql="delete from danhsachsv where ma='"+ma+"'";
			Statement statement=(Statement) conn.createStatement();
			int x=statement.executeUpdate(sql);
			if(x>0)
			{
			JOptionPane.showMessageDialog(null,
			"Xóa OK");
			}
			}
			catch(Exception ex)
			{
			ex.printStackTrace();
			}
			try {
				ArrayList<SinhVien> arrDb=new ArrayList<SinhVien>();
				Statement statement=(Statement) conn.createStatement();
				ResultSet result=statement.executeQuery
				("select * from danhsachsv");
				while(result.next())
				{
				arrDb.add(new SinhVien(result.getString("ma"),result.getString("ten"),result.getString("tuoi"),result.getString("lop")));
				}
				arrSv.clear();
				dm.setRowCount(0);
				arrSv=arrDb;
				} catch (Exception ex) {
				ex.printStackTrace();
				}
			
			for(SinhVien x : arrSv) {
				dm.addRow(new String[]{x.getMaSv(), x.getTenSv(), x.getTuoiSv(), x.getLopSv()});
			}
		
		}
		
	};		
	ActionListener eventThoat = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.exit(0);
		}
		
	};		
	ActionListener eventNhap = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				ArrayList<SinhVien> arrDb=new ArrayList<SinhVien>();
				Statement statement=(Statement) conn.createStatement();
				ResultSet result=statement.executeQuery
				("select * from danhsachsv");
				while(result.next())
				{
				arrDb.add(new SinhVien(result.getString("ma"),result.getString("ten"),result.getString("tuoi"),result.getString("lop")));
				}
				arrSv.clear();
				dm.setRowCount(0);
				arrSv=arrDb;
				} catch (Exception ex) {
				ex.printStackTrace();
				}
			
			for(SinhVien x : arrSv) {
				dm.addRow(new String[]{x.getMaSv(), x.getTenSv(), x.getTuoiSv(), x.getLopSv()});
			}
			// TODO Auto-generated method stub
			try {
				String ma = txtMa.getText();
				String ten = txtTen.getText();
				String tuoi = txtTuoi.getText();
				String lop = cbo.getSelectedItem().toString();
				if (ma.isEmpty()||ten.isEmpty()||tuoi.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Chưa nhập",
			                  "Lỗi", JOptionPane.WARNING_MESSAGE);
				}else {
					arrSv.add(new SinhVien(ma,ten,tuoi,lop));
					dm.addRow(new String[]{ma, ten, tuoi,lop});
					txtMa.setText("");
					txtTen.setText("");
					txtTuoi.setText("");
					try
					{
						String sql="insert into danhsachsv(ma,ten,tuoi,lop) values("+ "'" + ma + "','"+ten+"','"+tuoi+ "','"+lop+"'"+")";
						Statement statement=(Statement) conn.createStatement();
						int x=statement.executeUpdate(sql);
					if(x>0)
					{
					JOptionPane.showMessageDialog(null, "Lưu OK");
					}
					}
					catch(Exception ex){
					ex.printStackTrace();
					}
					
				}
				
				
			}catch(Exception X) {
				JOptionPane.showMessageDialog(null, "Nhập sai định dạng",
		                  "Lỗi", JOptionPane.WARNING_MESSAGE);
			}
			
			
		}
		
	};		
		
	

	private void addControl() {
		// TODO Auto-generated method stub
		Container con=getContentPane();
		JPanel pnChinh=new JPanel();
		
		pnChinh.setLayout(new BoxLayout(pnChinh, BoxLayout.Y_AXIS));
		
		
		JPanel pnChinh1 = new JPanel();
		JLabel lbl=new JLabel("Chương trình quản lý sinh siên");
		Font font=new Font("Arial", Font.BOLD,20);
		lbl.setFont(font);
		pnChinh1.add(lbl);
		
		JPanel pnChinh2 = new JPanel();
		JLabel lbl2 = new JLabel("Chọn lớp: ");
		cbo=new JComboBox();
		cbo.addItem("FFSE1701");
		cbo.addItem("FFSE1702");
		cbo.addItem("FFSE1703");
		cbo.addItem("FFSE1704 ");
		pnChinh2.add(lbl2);
		pnChinh2.add(cbo);
		
		
		JPanel pnChinh3 = new JPanel();
		JLabel lbl3 = new JLabel("Mã sinh viên: ");
		txtMa = new JTextField(15);
		pnChinh3.add(lbl3);
		pnChinh3.add(txtMa);
		
		
		JPanel pnChinh4 = new JPanel();
		JLabel lbl4 = new JLabel("Tên sinh viên: ");
		txtTen = new JTextField(15);
		pnChinh4.add(lbl4);
		pnChinh4.add(txtTen);
		
		JPanel pnChinh5 = new JPanel();
		JLabel lbl5 = new JLabel("Tuổi sinh viên: ");
		pnChinh5.add(lbl5);
		txtTuoi = new JTextField(15);
		pnChinh5.add(txtTuoi);
		
		JPanel pnChinh6 = new JPanel();
		pnChinh6.setLayout(new FlowLayout());
		btnThem = new JButton("Thêm");
		btnSua = new JButton("Sửa");
		btnXoa = new JButton("Xóa");
		btnThoat = new JButton("Thoát");
		btnNhap = new JButton("Nhập");
		pnChinh6.add(btnThem);
		pnChinh6.add(btnSua);
		pnChinh6.add(btnXoa);
		pnChinh6.add(btnThoat);
		pnChinh6.add(btnNhap);
		
		
		JPanel pnChinh7 = new JPanel();
		Border border=BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle=BorderFactory.createTitledBorder(border, "Danh sách");
		pnChinh7.setBorder(borderTitle);
		dm.addColumn("Mã");
		dm.addColumn("Tên");
		dm.addColumn("Tuổi");
		dm.addColumn("Lớp");
		pnChinh7.setLayout(new BorderLayout());
		pnChinh7.add(sc,BorderLayout.CENTER);
		
		pnChinh.add(pnChinh1);pnChinh.add(pnChinh2);pnChinh.add(pnChinh3);
		pnChinh.add(pnChinh4);pnChinh.add(pnChinh5);pnChinh.add(pnChinh6);
		pnChinh.add(pnChinh7);
		con.add(pnChinh);
	}
	public void showWindow()
	{
		this.setSize(600, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		try {
			ArrayList<SinhVien> arrDb=new ArrayList<SinhVien>();
			Statement statement=(Statement) conn.createStatement();
			ResultSet result=statement.executeQuery
			("select * from danhsachsv");
			while(result.next())
			{
			arrDb.add(new SinhVien(result.getString("ma"),result.getString("ten"),result.getString("tuoi"),result.getString("lop")));
			}
			arrSv.clear();
			dm.setRowCount(0);
			arrSv=arrDb;
			} catch (Exception ex) {
			ex.printStackTrace();
			}
		
		for(SinhVien x : arrSv) {
			dm.addRow(new String[]{x.getMaSv(), x.getTenSv(), x.getTuoiSv(), x.getLopSv()});
		}
	}
	
	
}
