package ui;
import model.*;
import io.*;

import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

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

import io.SerializeFile;

public class QuanLiSinhVien_UI extends JFrame {
	private JComboBox cbo;
	private JButton btnThem, btnSua, btnXoa, btnThoat;
	private JTextField textMSV, textTSV, textT;
	private ArrayList<SinhVien> arr = new ArrayList<>();
	private DefaultTableModel dm;
	private JTable tbl1;
	public QuanLiSinhVien_UI() {
		super();
	}
	
	public QuanLiSinhVien_UI(String title) {
		super(title);
		addControls();
		addEvents();
		docFile();
	}
	
	public void addControls() {
		Container con = getContentPane();
		JPanel boxMain = new JPanel();
		boxMain.setLayout(new BoxLayout(boxMain, BoxLayout.Y_AXIS));
		
		JPanel box1 = new JPanel();
		JLabel title = new JLabel("Chương trình quản lí sinh viên");
		Font fontTit = new Font("Arial", Font.BOLD, 20);
		title.setFont(fontTit);
		box1.add(title);
		
		// font chữ cho label
		Font font = new Font("Arial", Font.BOLD, 15);
		
		
		JPanel box2 = new JPanel();
		JLabel chonLop = new JLabel("Chọn lớp: ");
		chonLop.setFont(font);
		cbo = new JComboBox();
		cbo.addItem("FFSE1701");
		cbo.addItem("FFSE1702");
		cbo.addItem("FFSE1703");
		cbo.addItem("FFSE1704");
		box2.add(chonLop);
		box2.add(cbo);
		
		JPanel box3 = new JPanel();
		JLabel maSV = new JLabel("Mã sinh viên: ");
		maSV.setPreferredSize(new Dimension(120,120));
		maSV.setFont(font);
		textMSV = new JTextField(25);
		box3.add(maSV);
		box3.add(textMSV);
		
		JPanel box4 = new JPanel();
		JLabel tenSv = new JLabel("Tên sinh viên: ");
		tenSv.setPreferredSize(new Dimension(120,120));
		tenSv.setFont(font);
		textTSV = new JTextField(25);
		box4.add(tenSv);
		box4.add(textTSV);
		
		JPanel box5 = new JPanel();
		JLabel tuoi = new JLabel("Tuổi:");
		tuoi.setPreferredSize(new Dimension(120,120));
		tuoi.setFont(font);
		textT = new JTextField(25);
		box5.add(tuoi);
		box5.add(textT);
		
		JPanel box6 = new JPanel();
		btnThem = new JButton("Thêm");
		btnSua = new JButton("Sửa");
		btnXoa = new JButton("Xóa");
		btnThoat = new JButton("Thoát");
		
		box6.add(btnThem);
		box6.add(btnSua);
		box6.add(btnXoa);
		box6.add(btnThoat);
		
		
		
		JPanel pnTable = new JPanel();
		JPanel box7 = new JPanel();
		dm = new DefaultTableModel();
		dm.addColumn("Mã");
		dm.addColumn("Tên");
		dm.addColumn("Tuổi");
		dm.addColumn("Lớp");
		tbl1 = new JTable(dm);
		
		//dm.addRow(...);
		tbl1.addMouseListener(new MouseListener() {
			

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
//				int row = tbl1.getSelectedRow();
//				int col = tbl1.getSelectedColumn();
				textMSV.setEditable(false);
				for(int row = tbl1.getSelectedRow() ; row <=tbl1.getSelectedRow(); row++) {
					for(int col = 0; col < tbl1.getColumnCount(); col++) {
						String value = (String)tbl1.getValueAt(row, col);
						if(col == 0) {
							textMSV.setText(value);
						}
						if(col == 1) {
							textTSV.setText(value);
						}
						if(col == 2) {
							textT.setText(value);
						}
						if(col == (tbl1.getColumnCount() - 1)) {
							cbo.setSelectedItem(value);
						}
						
					}
				}
				
			}
		});
		
		
		
		JScrollPane sc = new JScrollPane(tbl1);
		box7.setLayout(new BoxLayout(box7, BoxLayout.Y_AXIS));
		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border,"Danh sách");
		borderTitle.setTitleFont(borderTitle.getTitleFont().deriveFont(Font.BOLD,15));
		pnTable.setBorder(borderTitle);
		pnTable.setLayout(new BorderLayout());
		pnTable.add(sc);
		box7.add(pnTable);

		
		boxMain.add(box1);
		boxMain.add(box2);
		boxMain.add(box3);
		boxMain.add(box4);
		boxMain.add(box5);
		boxMain.add(box6);
		boxMain.add(box7);
		
		con.add(boxMain);
	}
	
	// tạo event 
	public void addEvents() {
		btnThem.addActionListener(eventThem);
		btnThoat.addActionListener(eventThoat);
		btnSua.addActionListener(eventSua);
		btnXoa.addActionListener(eventXoa);
		cbo.addActionListener(chonLop);
	}
	
	ActionListener chonLop = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			dm.setRowCount(0);
			String chose = cbo.getSelectedItem().toString();
			for(SinhVien x: arr) {
				if(chose.equals(x.getLop())) {
					String row[] = {x.getMaSV(), x.getTen(), x.getTuoi(), x.getLop()};
					dm.addRow(row);
				}
			}
			
			
		}
	};
	
	// event nút thêm
	ActionListener eventThem = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			if(textMSV.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Bạn chưa nhập Mã Sinh Viên");
			} 
			if(textTSV.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Bạn chưa nhập Tên Sinh Viên");
			}
			if(textT.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Bạn chưa nhập Tuổi Sinh Viên");
			} else {
				nhap();
				textMSV.setText("");
				textTSV.setText("");
				textT.setText("");
			}
		}
	};
	
	//event nút sửa
	ActionListener eventSua = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			textMSV.setEditable(true);
			
			if(textMSV.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn sinh viên cần sửa!");
			} 
			else {
				sua();
				textMSV.setText("");
				textTSV.setText("");
				textT.setText("");
				JOptionPane.showMessageDialog(null, "Sửa sinh viên thành công!");
			}
		}
		
	};
	
	// event nút xóa
	ActionListener eventXoa = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			textMSV.setEditable(true);
			
			if(textMSV.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn sinh viên cần xóa!");
			} else {
				xoa();
				textMSV.setText("");
				textTSV.setText("");
				textT.setText("");
				JOptionPane.showMessageDialog(null, "Xóa tên sinh viên thành công!");
			}
		}
	};
	
	// event nút thoát
	ActionListener eventThoat = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);			
		}
	};
	
	
	/*---------------------------------------Function----------------------------------------------*/
	
	
	public void nhap() {
	
		String lop = cbo.getSelectedItem().toString();
				
		String maSV = textMSV.getText();
	
		String ten = textTSV.getText();

		String tuoi = textT.getText();

		String kt = "Không";
		
		for(int i = 0; i < arr.size(); i++) {
			if(textMSV.getText().equals(arr.get(i).getMaSV()) && cbo.getSelectedItem().toString().equals(arr.get(i).getLop())) {
				kt = "Trùng";
			}
		}
		if(kt == "Trùng") {
			JOptionPane.showMessageDialog(null, "Trùng mã sinh viên!");
		}
		else {
			arr.add(new SinhVien(maSV, ten, tuoi, lop));
			for(int i = (arr.size() - 1);i < arr.size(); i++) {
				String row[] = {arr.get(i).getMaSV(), arr.get(i).getTen(), arr.get(i).getTuoi(), arr.get(i).getLop()};
				dm.addRow(row);
				JOptionPane.showMessageDialog(null, "Thêm Sinh viên thành công!");
				luuFile();
			}
		}
		
	
	}
	
	public void sua() {
		for(SinhVien x : arr) {
			if(textMSV.getText().equals(x.getMaSV()) && cbo.getSelectedItem().toString().equals(x.getLop())){
					x.setTen(textTSV.getText());
					x.setTuoi(textT.getText());
					x.setLop(cbo.getSelectedItem().toString());
					
					//sửa xong lưu vào file
					luuFile();
				}
				
			}
			
		    dm.setRowCount(0);
			for(int i = 0;i < arr.size(); i++) {
				if(arr.get(i).getLop().equals(cbo.getSelectedItem().toString())) {
					String row[] = {arr.get(i).getMaSV(), arr.get(i).getTen(), arr.get(i).getTuoi(), arr.get(i).getLop()};
					dm.addRow(row);
				}
				
			}
	}
	
	public void xoa() {
		for(SinhVien x : arr) {
			if(textMSV.getText().equals(x.getMaSV()) && cbo.getSelectedItem().toString().equals(x.getLop())) {
				arr.remove(x);
				luuFile();
				break;
			}
		}
		dm.setRowCount(0);
		for(int i = 0;i < arr.size(); i++) {
			if(arr.get(i).getLop().equals(cbo.getSelectedItem().toString())) {
				String row[] = {arr.get(i).getMaSV(), arr.get(i).getTen(), arr.get(i).getTuoi(), arr.get(i).getLop()};
				dm.addRow(row);
			}
		}
	}
	
	public void luuFile() {
		boolean kt = SerializeFile.luuFile(arr, "sinhvien.txt");
		
	}
	
	public void docFile() {
		
		//File file = new File("D:/FFSE1703.JavaCore/Assignments/QuyPV/OOPSinhVien_Arrlist_TryCatch/sinhvien.txt");
	
				ArrayList<SinhVien> arrFile = SerializeFile.docFile("sinhvien.txt");
				arr = arrFile;
				dm.setRowCount(0);
				
				for(int i = 0;i < arr.size(); i++) {
					if(arr.get(i).getLop().equals(cbo.getSelectedItem().toString())) {
					String row[] = {arr.get(i).getMaSV(), arr.get(i).getTen(), arr.get(i).getTuoi(), arr.get(i).getLop()};
					dm.addRow(row);
					}
				}
	
	}
	
	public void showWindown() {
		this.setSize(700,600);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
	}
}
