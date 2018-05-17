package Assignment_list.assignment10.ui;

import Assignment_list.assignment10.model.*;
import java.util.ArrayList;
import java.io.File;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.util.ArrayList;

public class MyLayout extends JFrame {
	
	private JTextField txtMaSv,txtTenSv,txtTuoiSv;
	private JButton btnAdd,btnEdit,btnDelete,btnExit,btnSubmit;
	String[] items = {"Tất Cả","FFSE1701", "FFSE1702", "FFSE1703", "FFSE1704"};
	JComboBox<String> cbbClass = new JComboBox<>(items);
	String[] col = {"Mã Sinh Viên","Tên Sinh Viên","Tuổi Sinh Viên","Lớp"};
    DefaultTableModel list = new DefaultTableModel(col, 0);
	public static ArrayList<SinhVien> arrSv=new ArrayList<SinhVien>();
	String chooseClass="Tất Cả";
	final JTable tbl=new JTable(list);		
	JScrollPane sc=new JScrollPane(tbl);
	int stt=0;
	StatementDb connectDb=new StatementDb();
	
	public MyLayout(String title)
	{
		super(title);
		addControls();
		addEvents();
	}

	private void addControls() {
		// TODO Auto-generated method stub
		Container con=getContentPane();
		JPanel pnMain=new JPanel();
		
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		
		JLabel lbltitle=new JLabel("Chương trình quản lý sinh viên");
		Font font=new Font("Arial", Font.BOLD,20);
		lbltitle.setFont(font);
		JPanel pnMainTitle=new JPanel();
		pnMainTitle.add(lbltitle);
		pnMain.add(pnMainTitle);
		
		JPanel pnMainContent1=new JPanel();
		pnMainContent1.setLayout(new FlowLayout());
		JLabel lblContent1=new JLabel("Chọn Lớp:       ");		
		pnMainContent1.add(lblContent1);
		
		add(cbbClass);
		pnMainContent1.add(cbbClass);
		pnMain.add(pnMainContent1);
		
		JPanel pnMainContent2=new JPanel();
		pnMainContent2.setLayout(new FlowLayout());
		JLabel lblContent2=new JLabel("Mã Sinh Viên:    ");		
		pnMainContent2.add(lblContent2);
		txtMaSv = new JTextField(25);
		pnMainContent2.add(txtMaSv);
		pnMain.add(pnMainContent2);
		
		JPanel pnMainContent3=new JPanel();
		pnMainContent3.setLayout(new FlowLayout());
		JLabel lblContent3=new JLabel("Tên Sinh Viên:   ");		
		pnMainContent3.add(lblContent3);
		txtTenSv = new JTextField(25);
		pnMainContent3.add(txtTenSv);
		pnMain.add(pnMainContent3);
		
		JPanel pnMainContent4=new JPanel();
		pnMainContent4.setLayout(new FlowLayout());
		JLabel lblContent4=new JLabel("Tuổi Sinh Viên:  ");		
		pnMainContent4.add(lblContent4);
		txtTuoiSv = new JTextField(25);
		pnMainContent4.add(txtTuoiSv);
		pnMain.add(pnMainContent4);
		
		JPanel pnMainContent5=new JPanel();
		pnMainContent5.setLayout(new FlowLayout());	
		btnAdd =new JButton("Thêm");
		btnEdit =new JButton("Sửa");
		btnDelete =new JButton("Xóa");
		btnExit =new JButton("Thoát");
		btnSubmit =new JButton("Nhập");
		pnMainContent5.add(btnAdd);
		pnMainContent5.add(btnEdit);
		pnMainContent5.add(btnDelete);
		pnMainContent5.add(btnExit);
		pnMainContent5.add(btnSubmit);
		pnMain.add(pnMainContent5);
		
		JPanel pnMainContent6=new JPanel();
		Border border=
				BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle=
				BorderFactory.createTitledBorder(
				border, "Danh Sách");

		pnMainContent6.setBorder(borderTitle);
		
		
		pnMainContent6.setLayout(new BorderLayout());
		pnMainContent6.add(sc,BorderLayout.CENTER);
		
		pnMain.add(pnMainContent6);
		
		
		
		con.add(pnMain);
				
	}

	private void addEvents() {
		// TODO Auto-generated method stub
		
		tbl.addMouseListener(eventChooseRow);
		btnAdd.addActionListener(eventAdd);
		btnSubmit.addActionListener(eventSubmit);
		cbbClass.addActionListener(eventChooseClass);
		btnEdit.addActionListener(eventEdit);
		btnExit.addActionListener(eventExit);
		btnDelete.addActionListener(eventDelete);
	}
	
	ActionListener eventChooseClass = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
//			File file = new File("D:/FFSE1703.JavaCore/Assignments/NamCH/Assignment_List/dulieusinhvien.txt");	    
//		    if(file.exists()) {
//		    	ArrayList<SinhVien> arrSvFile = SerializeFileFactory.readFile("dulieusinhvien.txt");
//		  		arrSv=arrSvFile;
//		    }
			
			chooseClass =(String) cbbClass.getSelectedItem();
			ArrayList<SinhVien> arrSvFile = new ArrayList<SinhVien>();
			arrSv.clear();
			arrSvFile=connectDb.SeclectDb();
			arrSv=arrSvFile;
			list.setRowCount(0);
			if(chooseClass=="Tất Cả") {
				for (SinhVien sv : arrSv) {
					String[] row = {sv.getMaSv(), sv.getTenSv(), sv.getTuoiSv(),sv.getLopSv()};
					list.addRow(row);
				}
			}else {
				for (SinhVien sv : arrSv) {
					if(chooseClass.equals(sv.getLopSv())) {
						String[] row = {sv.getMaSv(), sv.getTenSv(), sv.getTuoiSv(),sv.getLopSv()};
						list.addRow(row);
					}					
				}
			}			
		}
    };
	ActionListener eventAdd = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			txtMaSv.setText("");
			txtTenSv.setText("");
			txtTuoiSv.setText("");
			txtMaSv.requestFocus();
			cbbClass.showPopup();
			txtMaSv.setEditable(true);
		}		
	};
	 MouseAdapter eventChooseRow = new MouseAdapter() {
	    	public void mouseClicked(MouseEvent e) {
	    		txtMaSv.setEditable(false);
	    		int col = tbl.getSelectedRow();
	    		String[] row = new String[3];	    		
	    		row[0] = (String) tbl.getValueAt(col, 0);
	    		row[1] = (String) tbl.getValueAt(col, 1);
	    		row[2] = (String) tbl.getValueAt(col, 2);
	    		txtMaSv.setText(row[0]);
	    		txtTenSv.setText(row[1]);
	    		txtTuoiSv.setText(row[2]);
				for(int i=0;i<arrSv.size();i++) {
					if(row[0].equals(arrSv.get(i).getMaSv())) {
						stt=i;						
					}
				}
	    	}
	    };
	ActionListener eventEdit = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
				String maSv = txtMaSv.getText();
				String tenSv = txtTenSv.getText();
				String tuoiSv = txtTuoiSv.getText();
				String lopSv = (String) cbbClass.getSelectedItem();
				
				
				try {
						Integer.parseInt(tuoiSv);				
					try {
						int tuoi=Integer.parseInt(tuoiSv);
						int so=-1;
						for(int i=0;i<arrSv.size();i++) {
							if(lopSv.equals(arrSv.get(i).getLopSv())) {
								so=i;
							}
						}
						if(maSv.isEmpty()&&tenSv.isEmpty()&&tuoiSv.isEmpty()) {		
							throw new Exception();
						}else if(maSv.isEmpty()||tenSv.isEmpty()||tuoiSv.isEmpty()){
							String msg = "Không được để trống các dòng"+maSv;
							JOptionPane.showMessageDialog(null, msg, "Lỗi Nhập Thông Tin", JOptionPane.INFORMATION_MESSAGE);
							
							}else {
							arrSv.get(stt).setMaSv(maSv);
							arrSv.get(stt).setTenSv(tenSv);
							arrSv.get(stt).setTuoiSv(tuoiSv);
							connectDb.editDb(maSv,tenSv,tuoiSv);							
							int col = tbl.getSelectedRow();
							txtMaSv.setText("");
							txtTenSv.setText("");
							txtTuoiSv.setText("");
							txtMaSv.requestFocus();
							chooseClass =(String) cbbClass.getSelectedItem();;
							list.setRowCount(0);
								if(chooseClass=="Tất Cả") {
									for (SinhVien sv : arrSv) {
										String[] row = {sv.getMaSv(), sv.getTenSv(), sv.getTuoiSv(),sv.getLopSv()};
										list.addRow(row);
									}
								}else {
									for (SinhVien sv : arrSv) {
										if(chooseClass.equals(sv.getLopSv())) {
											String[] row = {sv.getMaSv(), sv.getTenSv(), sv.getTuoiSv(),sv.getLopSv()};
											list.addRow(row);
										}					
									}
								}						
						}
					}catch(Exception e2) {
						String msg = "Chưa chọn dòng";
						JOptionPane.showMessageDialog(null, msg, "Lỗi", JOptionPane.INFORMATION_MESSAGE);
					}
				}catch(Exception e2) {
				String msg = "Nhập đúng định dạng"+maSv;
				JOptionPane.showMessageDialog(null, msg, "Lỗi Nhập Thông Tin", JOptionPane.INFORMATION_MESSAGE);					
				}
				
			
			
					
				}
	};
	ActionListener eventDelete = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			String maSv = txtMaSv.getText();
			String tenSv = txtTenSv.getText();
			String tuoiSv = txtTuoiSv.getText();
			arrSv.remove(stt);
			connectDb.deleteDb(maSv);			
			int col = tbl.getSelectedRow();
			txtMaSv.setText("");
			txtTenSv.setText("");
			txtTuoiSv.setText("");
			txtMaSv.requestFocus();
			chooseClass =(String) cbbClass.getSelectedItem();;
			list.setRowCount(0);
			if(chooseClass=="Tất Cả") {
				for (SinhVien sv : arrSv) {
					String[] row = {sv.getMaSv(), sv.getTenSv(), sv.getTuoiSv(),sv.getLopSv()};
					list.addRow(row);
				}
			}else {
				for (SinhVien sv : arrSv) {
					if(chooseClass.equals(sv.getLopSv())) {
						String[] row = {sv.getMaSv(), sv.getTenSv(), sv.getTuoiSv(),sv.getLopSv()};
						list.addRow(row);
					}					
				}
			}
		}
	};
	ActionListener eventSubmit = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				String maSv = txtMaSv.getText();
				String tenSv = txtTenSv.getText();
				String tuoiSv = txtTuoiSv.getText();
				String lopSv = (String) cbbClass.getSelectedItem();
				int so=-1;
				for(int i=0;i<arrSv.size();i++) {
					if(maSv.equals(arrSv.get(i).getMaSv())) {
						so=i;
					}
				}
				try {
					if(maSv.isEmpty()||tenSv.isEmpty()||tuoiSv.isEmpty()) {		
						throw new Exception();
					}else if(lopSv=="Tất Cả"){
						throw new NullPointerException();
					}else if(so>=0){
						String msg = "Đã Thêm Sinh Viên "+maSv;
						JOptionPane.showMessageDialog(null, msg, "Lưu Thành Công", JOptionPane.INFORMATION_MESSAGE);
					}else {
						String[] row = {maSv,tenSv, tuoiSv,lopSv};
						list.addRow(row);
						arrSv.add(new SinhVien(maSv,tenSv,tuoiSv,lopSv));
						connectDb.insertDb(maSv,tenSv,tuoiSv,lopSv);
						txtMaSv.setText("");
						txtTenSv.setText("");
						txtTuoiSv.setText("");
					}
				}catch(NullPointerException e) {
					String msg = "Chưa Chọn Lớp"+tenSv;
					JOptionPane.showMessageDialog(null, msg, "Lỗi Nhập Thông Tin", JOptionPane.INFORMATION_MESSAGE);
				}catch(Exception e) {
					String msg = "Chưa Nhập Đúng Định Dạng"+tenSv;
					JOptionPane.showMessageDialog(null, msg, "Lỗi Nhập Thông Tin", JOptionPane.INFORMATION_MESSAGE);
				}			
			}catch(Exception e) {				
			}						
		}		
	};
	ActionListener eventExit = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	};
	public void showWindow() {
		this.setSize(565, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		cbbClass.setSelectedIndex(0);					
	}
}
