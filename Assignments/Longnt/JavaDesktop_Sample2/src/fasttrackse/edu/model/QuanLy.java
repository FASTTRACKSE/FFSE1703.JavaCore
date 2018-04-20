package fasttrackse.edu.model;
import java.awt.event.MouseListener;
import fasttrackse.edu.main.*;
import java.awt.BorderLayout;
import fasttrackse.edu.connect.DBConnection;
import fasttrackse.edu.io.TextFile;
import java.awt.Button;
import java.sql.Statement;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.Font;
import fasttrackse.edu.modelsv.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;
import fasttrackse.edu.modelsv.*;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
public class QuanLy extends JFrame {
	Connection conn= DBConnection.ketnoi("localhost", "ffse1703", "thanhlong123",
			"123456"); 
	private JTextField maSinhVien,tenSinhVien,tuoiSinhVien;
	private JButton Nhap,Them,Sua,Xoa,Thoat,Chon;
    String[] col = {"Mã Sinh Viên","Tên Sinh Viên","Tuổi Sinh Viên","Lớp"};
    String[] items = {"All","FFSE1701", "FFSE1702", "FFSE1703", "FFSE1704"};
    public static ArrayList<SinhVien> arr = new ArrayList<SinhVien>();
	JComboBox<String> comb = new JComboBox<>(items);
	String lopHoc = "All";
    private DefaultTableModel dm = new DefaultTableModel();
	final JTable tab = new JTable(dm);
	JScrollPane sc = new JScrollPane(tab);
	int stt = 0;
	
    
	public QuanLy(String tieude)
	{
		this.setTitle(tieude);
		addControls();
	    addEvents();
	    DBConnection kn = new  DBConnection();
	    
	}
	public void addControls()
	{
		Container con = getContentPane();
		JPanel pan = new JPanel();
		pan.setLayout(new BoxLayout(pan, BoxLayout.Y_AXIS));

		JPanel pan1 = new JPanel();
		JLabel lab1 = new JLabel("Chương Trình Quản Lý Sinh Viên");
		Font fontTitle = new Font("arial", Font.BOLD, 30);
		lab1.setFont(fontTitle);
		pan1.add(lab1);
		pan.add(pan1);

		JPanel pan2=new JPanel();
		pan2.setLayout(new FlowLayout());
		JLabel lab2=new JLabel("Chọn Lớp:       ");		
		pan2.add(lab2);
		add(comb);
		pan2.add(comb);
		pan.add(pan2);

		JPanel pan3 = new JPanel();
		JLabel lab3 = new JLabel("Nhập Mã Sinh Viên:");
		maSinhVien = new JTextField(20);
		pan3.add(lab3);
		pan3.add(maSinhVien);
		pan.add(pan3);

		JPanel pan4 = new JPanel();
		JLabel lab4 = new JLabel("Nhập tên sinh viên:");
		tenSinhVien = new JTextField(20);
		pan4.add(lab4);
		pan4.add(tenSinhVien);
		pan.add(pan4);
		
		
		JPanel pan5 = new JPanel();
		JLabel lab5 = new JLabel("Nhập Tuổi Sinh Viên:");
		tuoiSinhVien = new JTextField(20);
		pan5.add(lab5);
		pan5.add(tuoiSinhVien);
		pan.add(pan5);
		
		JPanel pnTable = new JPanel();
		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Danh sách");
	    dm.addColumn("Mã");
	    dm.addColumn("Tên");
	    dm.addColumn("Tuổi");
	    dm.addColumn("Lớp");
		pnTable.setLayout(new BorderLayout());
		pnTable.setBorder(borderTitle);
		pnTable.add(sc);
		pan.add(pnTable);

		JPanel pnAction = new JPanel();
		pnAction.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 30));

		Them = new JButton("Thêm");
		Sua = new JButton("Sửa");
		Xoa = new JButton("Xóa");
		Thoat = new JButton("Thoát");
		Nhap = new JButton("Nhập");
tab.addMouseListener(new MouseListener() {
			

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {

				maSinhVien.setEditable(false);
				for(int row = tab.getSelectedRow() ; row <=tab.getSelectedRow(); row++) {
					for(int col = 0; col < tab.getColumnCount(); col++) {
						String value = (String)tab.getValueAt(row, col);
						if(col == 0) {
							maSinhVien.setText(value);
						}
						if(col == 1) {
							tenSinhVien.setText(value);
						}
						if(col == 2) {
							tuoiSinhVien.setText(value);
						}
						if(col == (tab.getColumnCount() - 1)) {
							comb.setSelectedItem(value);
						}
						
					}
				}
				
			}
		});

		pnAction.add(Them);
		pnAction.add(Sua);
		pnAction.add(Xoa);
		pnAction.add(Thoat);
		pnAction.add(Nhap);
		pan.add(pnAction);

		con.add(pan);

	}
	
		public void addEvents() {
			Them.addActionListener(eventThem);
			Sua.addActionListener(eventSua);
			Xoa.addActionListener(eventXoa);
			Thoat.addActionListener(eventThoat);
			comb.addActionListener(eventClass);		
	} 
		
		public void sellectAll() {
			arr.clear();
			try {
				Statement statement=conn.createStatement();
				ResultSet result=statement.executeQuery("select * from sinhvien");
				while(result.next())
				{
					String maSV = result.getString("masv");
					String ten = result.getString("tensv");
					String tuoi = result.getString("tuoisv");
					String lop = result.getString("lop");
					arr.add(new SinhVien(maSV, ten, tuoi, lop));
				}
				} catch (Exception e) {
				e.printStackTrace();
				}
		}
		
		public void nhap() {
			
			
			String lop = comb.getSelectedItem().toString();
					
			String masv = maSinhVien.getText();
		
			String tensv = tenSinhVien.getText();

			String tuoisv = tuoiSinhVien.getText();
			
			
			
			String kt = "Không trùng";
			
			for(int i = 0; i < arr.size(); i++) {
				if(maSinhVien.getText().equals(arr.get(i).getMaSinhVien()) && comb.getSelectedItem().toString().equals(arr.get(i).getLopHoc())) {
					kt = "Trùng";
				}
			}
			if(kt == "Trùng") {
				JOptionPane.showMessageDialog(null, "Trùng mã sinh viên!");
			}
			else {
				try {
					String sql = "insert into sinhvien values('"+masv+"', '"+tensv+"', '"+tuoisv+"', '"+lop+"')";
					Statement statement = (Statement) conn.createStatement();
					int x=statement.executeUpdate(sql);
					if(x>0) {
						sellectAll();
						String row[] = {masv, tensv, tuoisv, lop};
						dm.addRow(row);
						JOptionPane.showMessageDialog(null, "Thêm Sinh viên thành công!");
							// sau khi thêm sẽ reset về rỗng
						maSinhVien.setText("");
						tenSinhVien.setText("");
						tuoiSinhVien.setText("");
		
						//System.out.println(arr.toString());
		
					}
				}
					catch(Exception ex){
					ex.printStackTrace();
				}
				
			}
			
		
		}
		public void sua() {
			
			try
			{
			String sql="update sinhvien set tensv='" + tenSinhVien.getText() + "', tuoisv='"+tuoiSinhVien.getText()+"' where masv='" + maSinhVien.getText() +"'";
			Statement statement=(Statement) conn.createStatement();
			int y=statement.executeUpdate(sql);
			if(y>0)
			{
				JOptionPane.showMessageDialog(null, "Sửa sinh viên thành công!");
			}
			}
			catch(Exception ex)
			{
			ex.printStackTrace();
			}
				sellectAll();
				//sửa xong lưu vào file
				maSinhVien.setText("");
				tenSinhVien.setText("");
				tuoiSinhVien.setText("");

	    dm.setRowCount(0);
		for(int i = 0;i < arr.size(); i++) {
			if(arr.get(i).getLopHoc().equals(comb.getSelectedItem().toString())) {
				String row[] = {arr.get(i).getMaSinhVien(), arr.get(i).getTenSinhVien(), arr.get(i).getTuoiSinhVien(), arr.get(i).getLopHoc()};
				dm.addRow(row);
			}
			
		}
}
		public void xoa() {
			
			try
			{
			String sql="delete from sinhvien where maSV='" + maSinhVien.getText() + "' and lop='" + comb.getSelectedItem().toString() + "'";
			Statement statement=conn.createStatement();
			int x=statement.executeUpdate(sql);
			if(x>0)
			{
			JOptionPane.showMessageDialog(null, "Xóa thành công!");
			}
			}
			catch(Exception ex)
			{
			ex.printStackTrace();
			}
			
			sellectAll();
			dm.setRowCount(0);
			for(int i = 0;i < arr.size(); i++) {
				if(arr.get(i).getLopHoc().equals(comb.getSelectedItem().toString())) {
					String row[] = {arr.get(i).getMaSinhVien(), arr.get(i).getTenSinhVien(), arr.get(i).getTuoiSinhVien(), arr.get(i).getLopHoc()};
					dm.addRow(row);
				}
			}
		}
		ActionListener eventClass = new ActionListener() {
			
			// event combobox
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dm.setRowCount(0);

				sellectAll();
				String chose = comb.getSelectedItem().toString();
				for(SinhVien x: arr) {
					if(chose.equals(x.getLopHoc())) {
						String row[] = {x.getMaSinhVien(), x.getTenSinhVien(), x.getTuoiSinhVien(), x.getLopHoc()};
						dm.addRow(row);
					}
				}
						
			}
		};
		ActionListener eventThem = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				if(maSinhVien.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Bạn chưa nhập Mã Sinh Viên");
				} 
				if(tenSinhVien.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Bạn chưa nhập Tên Sinh Viên");
				}
				if(tuoiSinhVien.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Bạn chưa nhập Tuổi Sinh Viên");
				} else {
					nhap();
				}
			}
		};
		ActionListener eventSua = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				maSinhVien.setEditable(true);
				
				if(maSinhVien.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn sinh viên cần sửa!");
				} 
				else {
					sua();
				}
			}
			
		};
		ActionListener eventXoa = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				maSinhVien.setEditable(true);
				
				if(maSinhVien.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn sinh viên cần xóa!");
				} else {
					xoa();
				}
			}
		};
		ActionListener eventThoat = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);			
			}
		};
	public void showWindow(){
		this.setSize(600, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
