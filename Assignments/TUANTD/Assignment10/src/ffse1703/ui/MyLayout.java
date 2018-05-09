package ffse1703.ui;

import ffse1703.io.*;
import ffse1703.model.*;
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


import java.util.ArrayList;
public class MyLayout extends JFrame {
	
	private JTextField txtMaSv,txtTenSv,txtTuoiSv;
	private JButton btnAdd,btnEdit,btnDelete,btnExit,btnSubmit;
	String[] items = {"Táº¥t cáº£","FFSE1701", "FFSE1702", "FFSE1703", "FFSE1704"};
	JComboBox<String> cbbClass = new JComboBox<>(items);
	String[] col = {"MÃ£ Sinh ViÃªn","TÃªn Sinh ViÃªn","Tuá»•i Sinh ViÃªn","Lá»›p"};
    DefaultTableModel list = new DefaultTableModel(col, 0);
	public static ArrayList<SinhVien> arrSv=new ArrayList<SinhVien>();
	String chooseClass="Táº¥t cáº£";
	final JTable tbl=new JTable(list);		
	JScrollPane sc=new JScrollPane(tbl);
	int stt=0;
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
		
		JLabel lbltitle=new JLabel("ChÆ°Æ¡ng TrÃ¬nh Quáº£n LÃ½ Sinh ViÃªn");
		Font font=new Font("Arial", Font.BOLD,20);
		lbltitle.setFont(font);
		JPanel pnMainTitle=new JPanel();
		pnMainTitle.add(lbltitle);
		pnMain.add(pnMainTitle);
		
		JPanel pnMainContent1=new JPanel();
		pnMainContent1.setLayout(new FlowLayout());
		JLabel lblContent1=new JLabel("Chá»�n Lá»›p:       ");		
		pnMainContent1.add(lblContent1);
		
		add(cbbClass);
		pnMainContent1.add(cbbClass);
		pnMain.add(pnMainContent1);
		
		JPanel pnMainContent2=new JPanel();
		pnMainContent2.setLayout(new FlowLayout());
		JLabel lblContent2=new JLabel("MÃ£ Sinh ViÃªn:    ");		
		pnMainContent2.add(lblContent2);
		txtMaSv = new JTextField(25);
		pnMainContent2.add(txtMaSv);
		pnMain.add(pnMainContent2);
		
		JPanel pnMainContent3=new JPanel();
		pnMainContent3.setLayout(new FlowLayout());
		JLabel lblContent3=new JLabel("TÃªn Sinh ViÃªn:   ");		
		pnMainContent3.add(lblContent3);
		txtTenSv = new JTextField(25);
		pnMainContent3.add(txtTenSv);
		pnMain.add(pnMainContent3);
		
		JPanel pnMainContent4=new JPanel();
		pnMainContent4.setLayout(new FlowLayout());
		JLabel lblContent4=new JLabel("Tuá»•i Sinh ViÃªn:  ");		
		pnMainContent4.add(lblContent4);
		txtTuoiSv = new JTextField(25);
		pnMainContent4.add(txtTuoiSv);
		pnMain.add(pnMainContent4);
		
		JPanel pnMainContent5=new JPanel();
		pnMainContent5.setLayout(new FlowLayout());	
		btnAdd =new JButton("ThÃªm");
		btnEdit =new JButton("Sá»­a");
		btnDelete =new JButton("XÃ³a");
		btnExit =new JButton("ThoÃ¡t");
		btnSubmit =new JButton("Nháº­p");
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
				border, "Danh sÃ¡ch");

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
			File file = new File("D:/FFSE1703.JavaCore/Assignments/NamCH/Assignment_List/dulieusinhvien.txt");	    
		    if(file.exists()) {
		    	ArrayList<SinhVien> arrSvFile = SerializeFileFactory.readFile("dulieusinhvien.txt");
		  		arrSv=arrSvFile;
		    }
			chooseClass =(String) cbbClass.getSelectedItem();
			list.setRowCount(0);
			if(chooseClass=="Táº¥t cáº£") {
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
			txtMaSv.setText("");
			txtTenSv.setText("");
			txtTuoiSv.setText("");
		}
    };
	ActionListener eventAdd = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			txtMaSv.setText("");
			txtTenSv.setText("");
			txtTuoiSv.setText("");
			txtMaSv.requestFocus();
		}		
	};
	 MouseAdapter eventChooseRow = new MouseAdapter() {
	    	public void mouseClicked(MouseEvent e) {
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
							String msg = "KhÃ´ng Ä‘Æ°á»£c Ä‘á»ƒ trá»‘ng cÃ¡c dÃ²ng "+maSv;
							JOptionPane.showMessageDialog(null, msg, "Lá»—i Nháº­p ThÃ´ng tin", JOptionPane.INFORMATION_MESSAGE);
							
							}else if(tuoi>=18 && tuoi<=35){
								String msg = "Nháº­p tuá»•i tá»« 18 Ä‘áº¿n 35 "+maSv;
								JOptionPane.showMessageDialog(null, msg, "Lá»—i Nháº­p ThÃ´ng tin", JOptionPane.INFORMATION_MESSAGE);
							}else {
							arrSv.get(stt).setMaSv(maSv);
							arrSv.get(stt).setTenSv(tenSv);
							arrSv.get(stt).setTuoiSv(tuoiSv);
							boolean checked= SerializeFileFactory.saveFile(arrSv, "dulieusinhvien.txt");
							if (checked == true) {
								String msg = "Ä�Ã£ Sá»­a ThÃ nh cÃ´ng Sinh viÃªn "+tenSv;
								JOptionPane.showMessageDialog(null, msg, "Sá»­a ThÃ nh CÃ´ng", JOptionPane.INFORMATION_MESSAGE);
							} else {
								System.out.println("LÆ°u tháº¥t báº¡i");
							}
							int col = tbl.getSelectedRow();
							txtMaSv.setText("");
							txtTenSv.setText("");
							txtTuoiSv.setText("");
							txtMaSv.requestFocus();
							chooseClass =(String) cbbClass.getSelectedItem();;
							list.setRowCount(0);
								if(chooseClass=="Táº¥t cáº£") {
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
						String msg = "ChÆ°a chá»�n dÃ²ng cáº§n thay Ä‘á»•i ";
						JOptionPane.showMessageDialog(null, msg, "Sá»­a ThÃ nh CÃ´ng", JOptionPane.INFORMATION_MESSAGE);
					}
				}catch(Exception e2) {
				String msg = "Pháº£i Nháº­p sá»‘ cho Tuá»•i "+maSv;
				JOptionPane.showMessageDialog(null, msg, "Lá»—i Nháº­p ThÃ´ng tin", JOptionPane.INFORMATION_MESSAGE);					
				}
				
			
			
					
				}
	};
	ActionListener eventDelete = new ActionListener() {
		public void actionPerformed(ActionEvent e) {						
			String maSv = txtMaSv.getText();
			String tenSv = txtTenSv.getText();
			String tuoiSv = txtTuoiSv.getText();
			arrSv.remove(stt);			
			boolean checked= SerializeFileFactory.saveFile(arrSv, "dulieusinhvien.txt");
			if (checked == true) {
				String msg = "Ä�Ã£ XÃ³a ThÃ nh cÃ´ng Sinh viÃªn "+tenSv;
				JOptionPane.showMessageDialog(null, msg, "XÃ³a ThÃ nh CÃ´ng", JOptionPane.INFORMATION_MESSAGE);
			} else {
				System.out.println("XÃ³a tháº¥t báº¡i");
			}
			int col = tbl.getSelectedRow();
			txtMaSv.setText("");
			txtTenSv.setText("");
			txtTuoiSv.setText("");
			txtMaSv.requestFocus();
			chooseClass =(String) cbbClass.getSelectedItem();;
			list.setRowCount(0);
			if(chooseClass=="Táº¥t cáº£") {
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
					}else if(lopSv=="Táº¥t cáº£"){
						throw new NullPointerException();
					}else if(so>=0){
						String msg = "Ä�Ã£ tá»“n táº¡i sinh viÃªn cÃ³ mÃ£ lÃ  "+maSv;
						JOptionPane.showMessageDialog(null, msg, "LÆ°u ThÃ nh CÃ´ng", JOptionPane.INFORMATION_MESSAGE);
					}else {
						String[] row = {maSv,tenSv, tuoiSv,lopSv};
						list.addRow(row);
						arrSv.add(new SinhVien(maSv,tenSv,tuoiSv,lopSv));
						boolean checked= SerializeFileFactory.saveFile(arrSv, "dulieusinhvien.txt");
						if (checked == true) {
							String msg = "Ä�Ã£ lÆ°u thÃ nh cÃ´ng Sinh viÃªn "+tenSv;
							JOptionPane.showMessageDialog(null, msg, "LÆ°u ThÃ nh CÃ´ng", JOptionPane.INFORMATION_MESSAGE);
						} else {
							System.out.println("LÆ°u tháº¥t báº¡i");
						}
						txtMaSv.setText("");
						txtTenSv.setText("");
						txtTuoiSv.setText("");
					}
				}catch(NullPointerException e) {
					String msg = "ChÆ°a chá»�n Lá»›p\n Vui LÃ²ng Nháº­p Láº¡i "+tenSv;
					JOptionPane.showMessageDialog(null, msg, "Lá»—i Nháº­p Thiáº¿u", JOptionPane.INFORMATION_MESSAGE);
				}catch(Exception e) {
					String msg = "ChÆ°a nháº­p Ä‘á»§ cÃ¡c dÃ²ng\n Vui LÃ²ng Nháº­p Láº¡i "+tenSv;
					JOptionPane.showMessageDialog(null, msg, "Lá»—i Nháº­p Thiáº¿u", JOptionPane.INFORMATION_MESSAGE);
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
	}
}
