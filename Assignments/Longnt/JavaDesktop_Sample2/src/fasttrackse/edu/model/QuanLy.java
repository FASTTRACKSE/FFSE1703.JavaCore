package fasttrackse.edu.model;
import fasttrackse.edu.main.*;
import java.awt.BorderLayout;
import fasttrackse.edu.io.*;
import java.awt.Button;
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
import java.io.File;
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
	private JTextField maSinhVien,tenSinhVien,tuoiSinhVien;
	private JButton Nhap,Them,Sua,Xoa,Thoat;
    String[] col = {"Mã Sinh Viên","Tên Sinh Viên","Tuổi Sinh Viên","Lớp"};
    String[] items = {"All","FFSE1701", "FFSE1702", "FFSE1703", "FFSE1704"};
    public static ArrayList<SinhVien> arraySinhVien = new ArrayList<SinhVien>();
	JComboBox<String> Class = new JComboBox<>(items);
	String cClass = "All choose";
    private DefaultTableModel dm = new DefaultTableModel();
	final JTable tab = new JTable(dm);
	JScrollPane sc = new JScrollPane(tab);
	int stt = 0;
    
	public QuanLy(String tieude)
	{
		this.setTitle(tieude);
		addControls();
	    addEvents();
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
		add(Class);
		pan2.add(Class);
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
			Nhap.addActionListener(eventNhap);
			Class.addActionListener(eventClass);
			
	}
		
		ActionListener eventClass = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file = new File("D:/java_core/FFSE1703.JavaCore/Assignments/Longnt/fasstrackse/dulieu2.txt");
				if (file.exists()) {
					ArrayList<SinhVien> arrSvFile = TextFile.readFile("dulieu2.txt");
					arraySinhVien = arrSvFile;
				}
				cClass = (String) Class.getSelectedItem();
				dm.setRowCount(0);
				if ( cClass == "All choose") {
					for (SinhVien sv : arraySinhVien) {
						String[] row = { sv.getMaSinhVien(), sv.getTenSinhVien(), sv.getTuoiSinhVien(), sv.getLop() };
						dm.addRow(row);
				}
				} else {
					for (SinhVien sv : arraySinhVien) {
					if (cClass.equals(sv.getLop())) {
							String[] row = { sv.getMaSinhVien(), sv.getTenSinhVien(), sv.getTuoiSinhVien(), sv.getLop() };
							dm.addRow(row);
				}
				}
				}
				maSinhVien.setText("");
				tenSinhVien.setText("");
				tuoiSinhVien.setText("");
			}
		};
	
		ActionListener eventNhap = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String maSV=maSinhVien.getText();
				String tenSV=tenSinhVien.getText();
				String tuoiSV=tuoiSinhVien.getText();
				String lop = (String) Class.getSelectedItem();
				if(maSV.isEmpty()) {
					String msg = "Chưa nhập mã sinh viên";
					JOptionPane.showMessageDialog(null, msg, "Lỗi Chưa Nhập", JOptionPane.INFORMATION_MESSAGE);
				} else { 
			      try { 
					Float.parseFloat(maSV);		           
		        } 
			      catch (Exception ex) { 
		        	String msg = "mã sinh viên phải là số";
					JOptionPane.showMessageDialog(null, msg, " Sai Định Dạng", JOptionPane.INFORMATION_MESSAGE); 
		        }
				
			    }
				if(tenSV.isEmpty()) {
					String msg = "Chưa nhập tên sinh viên";
					JOptionPane.showMessageDialog(null, msg, "Lỗi Chưa Nhập", JOptionPane.INFORMATION_MESSAGE);
				} else { 
			      try { 
					Float.parseFloat(tenSV);		           
		        } 
			      catch (Exception ex) { 
		        	String msg = "tên sinh viên phải là chữ";
					JOptionPane.showMessageDialog(null, msg, " Sai Định Dạng", JOptionPane.INFORMATION_MESSAGE); 
		        }
				}
				if(tuoiSV.isEmpty()) {
					String msg = "Chưa nhập tuổi sinh viên";
					JOptionPane.showMessageDialog(null, msg, "Lỗi Chưa Nhập", JOptionPane.INFORMATION_MESSAGE);
				} else { 
			      try { 
					Float.parseFloat(tuoiSV);		           
		        } 
			      catch (Exception ex) { 
		        	String msg = "tuổi sinh viên phải là số";
					JOptionPane.showMessageDialog(null, msg, " Sai Định Dạng", JOptionPane.INFORMATION_MESSAGE); 
		        }
			    }
				
				String[] row = {maSV,tenSV,tuoiSV,lop };
				dm.addRow(row);
				arraySinhVien.add(new SinhVien());
			     }
				};
				
//	
				ActionListener eventThem = new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						maSinhVien.setText("");
						tenSinhVien.setText("");
						tuoiSinhVien.setText("");
						maSinhVien.requestFocus();
					}		
				};
		
		
		ActionListener eventSua = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					String maSv = maSinhVien.getText();
					String tenSv = tenSinhVien.getText();
					String tuoiSv = tuoiSinhVien.getText();
					String lopSv = (String) Class.getSelectedItem();
					
					
					try {
							Integer.parseInt(tuoiSv);				
						try {
							int tuoi=Integer.parseInt(tuoiSv);
							int so=-1;
							for(int i=0;i<arraySinhVien.size();i++) {
								if(lopSv.equals(arraySinhVien.get(i).getLop())) {
									so=i;
								}
							}
							if(maSv.isEmpty()&&tenSv.isEmpty()&&tuoiSv.isEmpty()) {		
								throw new Exception();
							}else if(maSv.isEmpty()||tenSv.isEmpty()||tuoiSv.isEmpty()){
								String msg = "Không được để trống các dòng "+maSv;
								JOptionPane.showMessageDialog(null, msg, "Lỗi Nhập Thông tin", JOptionPane.INFORMATION_MESSAGE);
								
								}else if(tuoi>=18 && tuoi<=35){
									String msg = "Nhập tuổi từ 18 đến 35 "+maSv;
									JOptionPane.showMessageDialog(null, msg, "Lỗi Nhập Thông tin", JOptionPane.INFORMATION_MESSAGE);
								}else {
									arraySinhVien.get(stt).setMaSinhVien(maSv);
									arraySinhVien.get(stt).setTenSinhVien(tenSv);
									arraySinhVien.get(stt).setTuoiSinhVien(tuoiSv);
								boolean checked= TextFile.saveFile(arraySinhVien, "dulieusinhvien.txt");
								if (checked == true) {
									String msg = "Đã Sửa Thành công Sinh viên "+tenSv;
									JOptionPane.showMessageDialog(null, msg, "Sửa Thành Công", JOptionPane.INFORMATION_MESSAGE);
								} else {
									System.out.println("Lưu thất bại");
								}
								int col = tab.getSelectedRow();
								maSinhVien.setText("");
								tenSinhVien.setText("");
								tuoiSinhVien.setText("");
								maSinhVien.requestFocus();
								cClass =(String) Class.getSelectedItem();;
								dm.setRowCount(0);
									if(cClass=="Tất cả") {
										for (SinhVien sv : arraySinhVien) {
											String[] row = {sv.getMaSinhVien(), sv.getTenSinhVien(), sv.getTuoiSinhVien(),sv.getLop()};
											dm.addRow(row);
										}
									}else {
										for (SinhVien sv : arraySinhVien) {
											if(Class.equals(sv.getLop())) {
												String[] row = {sv.getMaSinhVien(), sv.getTenSinhVien(), sv.getTuoiSinhVien(),sv.getLop()};
												dm.addRow(row);
											}					
										}
									}						
							}
						}catch(Exception e2) {
							String msg = "Chưa chọn dòng cần thay đổi ";
							JOptionPane.showMessageDialog(null, msg, "Sửa Thành Công", JOptionPane.INFORMATION_MESSAGE);
						}
					}catch(Exception e2) {
					String msg = "Phải Nhập số cho Tuổi "+maSv;
					JOptionPane.showMessageDialog(null, msg, "Lỗi Nhập Thông tin", JOptionPane.INFORMATION_MESSAGE);					
					}
					
				
				
						
					}
		};
		ActionListener eventXoa = new ActionListener() {
			public void actionPerformed(ActionEvent e) {						
				String maSv = maSinhVien.getText();
				String tenSv = tenSinhVien.getText();
				String tuoiSv = tuoiSinhVien.getText();
				arraySinhVien.remove(stt);			
				boolean checked= TextFile.saveFile(arraySinhVien, "dulieu2.txt");
				if (checked == true) {
					String msg = "Đã Xóa Thành công Sinh viên "+tenSv;
					JOptionPane.showMessageDialog(null, msg, "Xóa Thành Công", JOptionPane.INFORMATION_MESSAGE);
				} else {
					System.out.println("Xóa thất bại");
				}
				int col = tab.getSelectedRow();
				maSinhVien.setText("");
				tenSinhVien.setText("");
				tuoiSinhVien.setText("");
				maSinhVien.requestFocus();
				cClass =(String) Class.getSelectedItem();;
				dm.setRowCount(0);
				if(cClass=="Tất cả") {
					for (SinhVien sv : arraySinhVien) {
						String[] row = {sv.getMaSinhVien(), sv.getTenSinhVien(), sv.getTuoiSinhVien(),sv.getLop()};
						dm.addRow(row);
					}
				}else {
					for (SinhVien sv : arraySinhVien) {
						String[] row = {sv.getMaSinhVien(), sv.getTenSinhVien(), sv.getTuoiSinhVien(),sv.getLop()};
						dm.addRow(row);
					}				
					}
				}
		};
		ActionListener eventThoat = new ActionListener() {
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
