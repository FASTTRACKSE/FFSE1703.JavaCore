package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
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

import com.mysql.jdbc.Connection;

import connector.GetConnect;
import model.PhanMon_Model;
import model.PhanMon_Statement;
import model.QuanLiLopHoc_Model;
import model.QuanLiLopHoc_Statement;
import model.QuanLiMonHoc_Model;
import model.QuanLiMonHoc_Statement;

public class QuanLiLopHoc extends JPanel {
	private JTextField textMaLop, textTenLop, textNamHoc;
	private JButton btnThemMon, btnXoaMon, btnThem, btnSua, btnXoa, btnTaoMoi;
	private DefaultTableModel dmLop, dm;
	private QuanLiMonHoc_Statement quanLiMonHocStatement = new QuanLiMonHoc_Statement();
	private QuanLiLopHoc_Statement quanLiLopHocStatement = new QuanLiLopHoc_Statement();
	private PhanMon_Statement phanMonStatement = new PhanMon_Statement();
	public JComboBox cboChonMon;
	private JTable tbPhanMon;
	private ArrayList<QuanLiMonHoc_Model> arrMon = new ArrayList<>();
	private ArrayList<QuanLiLopHoc_Model> arrLop = new ArrayList<>();
	private ArrayList<QuanLiMonHoc_Model> arrPhanMon = new ArrayList<>();
	private ArrayList<String> arrMaMonThem = new ArrayList<>();
	private ArrayList<String> arrMaMonXoa = new ArrayList<>();
	private ArrayList<String> arrMaMonDaThem = new ArrayList<>();
	public QuanLiLopHoc(){
		addControl();
		addEvent();
		inLop();
	}

	private void addControl() {
		JPanel boxQuanliLopHoc = new JPanel();
		boxQuanliLopHoc.setLayout(new BoxLayout(boxQuanliLopHoc, BoxLayout.Y_AXIS));
		Font font = new Font("Arial", Font.BOLD, 15);
		JPanel boxNhap =new JPanel();
		boxNhap.setLayout(new BoxLayout(boxNhap, BoxLayout.Y_AXIS));
		Border borderNhap = BorderFactory.createEtchedBorder();
		TitledBorder borderTitleNhap = BorderFactory.createTitledBorder(borderNhap,"Nhập thông tin lớp học",TitledBorder.CENTER, 
				TitledBorder.DEFAULT_POSITION);
		borderTitleNhap.setTitleFont(borderTitleNhap.getTitleFont().deriveFont(Font.BOLD,20));
		borderTitleNhap.setTitleColor(Color.BLACK);
		boxNhap.setBorder(borderTitleNhap);
		JPanel phanNhap = new JPanel();
		phanNhap.setLayout(new BoxLayout(phanNhap, BoxLayout.X_AXIS));
		JPanel khungNhapLop = new JPanel();
		khungNhapLop.setLayout(new BoxLayout(khungNhapLop, BoxLayout.Y_AXIS));
		Border borderKhungNhapLop = BorderFactory.createEtchedBorder();
		khungNhapLop.setBorder(borderKhungNhapLop);
		JPanel hangNhap1 = new JPanel();
		hangNhap1.setLayout(new FlowLayout());
		JLabel maLop = new JLabel("Mã Lớp:");
		maLop.setFont(font);
		maLop.setPreferredSize(new Dimension(90, 70));
		textMaLop = new JTextField();
		textMaLop.setPreferredSize(new Dimension(120, 30));
		JPanel hangNhap2 = new JPanel();
		hangNhap2.setLayout(new FlowLayout());
		JLabel tenLop = new JLabel("Tên lớp:");
		tenLop.setFont(font);
		tenLop.setPreferredSize(new Dimension(90, 70));
		textTenLop = new JTextField();
		textTenLop.setPreferredSize(new Dimension(120, 30));
		JPanel hangNhap3 = new JPanel();
		hangNhap3.setLayout(new FlowLayout());
		JLabel namHoc = new JLabel("Năm học:");
		namHoc.setFont(font);
		namHoc.setPreferredSize(new Dimension(90, 70));
		textNamHoc = new JTextField();
		textNamHoc.setPreferredSize(new Dimension(120, 30));
		hangNhap1.add(maLop);
		hangNhap1.add(textMaLop);
		hangNhap2.add(tenLop);
		hangNhap2.add(textTenLop);
		hangNhap3.add(namHoc);
		hangNhap3.add(textNamHoc);
		khungNhapLop.add(hangNhap1);
		khungNhapLop.add(hangNhap2);
		khungNhapLop.add(hangNhap3);
		JPanel khungNhapMon = new JPanel();
		khungNhapMon.setLayout(new BoxLayout(khungNhapMon, BoxLayout.Y_AXIS));
		khungNhapMon.setPreferredSize(new Dimension(300, 0));
		Border borderKhungNhapMon = BorderFactory.createEtchedBorder();
		khungNhapMon.setBorder(borderKhungNhapMon);
		JPanel themMon = new JPanel();
		themMon.setLayout(new FlowLayout());
		
		JLabel chonMon =new JLabel("Chọn môn:");
		cboChonMon = new JComboBox();
		cboChonMon.addItem("Chọn mã môn");
		
		cboChonMon.setPreferredSize(new Dimension(120, 30));
		btnThemMon = new JButton("Thêm môn");
		themMon.add(chonMon);
		themMon.add(cboChonMon);
		themMon.add(btnThemMon);
		dm = new DefaultTableModel();
		dm.addColumn("Tên môn");
		dm.addColumn("Mã môn");
		tbPhanMon = new JTable(dm);
		JScrollPane sc = new JScrollPane(tbPhanMon);
		tbPhanMon.addMouseListener(new MouseAdapter() {
		
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tbPhanMon.getSelectedRow();
				String value = tbPhanMon.getValueAt(row, 1).toString();
				cboChonMon.setSelectedItem(value);
				
			}
		});
		JPanel xoaMon = new  JPanel();
		xoaMon.setLayout(new FlowLayout());
		btnXoaMon = new JButton("Xóa Môn");
		xoaMon.add(btnXoaMon);
		khungNhapMon.add(themMon);
		khungNhapMon.add(Box.createRigidArea(new Dimension(0, 10)));
		khungNhapMon.add(sc);
		khungNhapMon.add(Box.createRigidArea(new Dimension(0, 5)));
		khungNhapMon.add(xoaMon);
		
		phanNhap.add(khungNhapLop);
		phanNhap.add(Box.createRigidArea(new Dimension(20,0)));
		phanNhap.add(khungNhapMon);
		JPanel phanNut = new JPanel();
		phanNut.setLayout(new FlowLayout());
		ImageIcon imgBtnThem = new ImageIcon(getClass().getResource("/images/btn_them.png"));
		btnThem = new JButton("Thêm", imgBtnThem);
		btnThem.setPreferredSize(new Dimension(110, 30));
		ImageIcon imgBtnSua = new ImageIcon(getClass().getResource("/images/btn_sua.png"));
		btnSua = new JButton("Sửa", imgBtnSua);
		btnSua.setEnabled(false);
		btnSua.setPreferredSize(new Dimension(110, 30));
		ImageIcon imgBtnXoa = new ImageIcon(getClass().getResource("/images/btn_xoa.png"));
		btnXoa = new JButton("Xóa", imgBtnXoa);
		btnXoa.setEnabled(false);
		btnXoa.setPreferredSize(new Dimension(110, 30));
		ImageIcon imgBtnHuy = new ImageIcon(getClass().getResource("/images/btn_huy.png"));
		btnTaoMoi = new JButton("Hủy", imgBtnHuy);
		btnTaoMoi.setPreferredSize(new Dimension(110, 30));
		phanNut.add(btnThem);
		phanNut.add(btnSua);
		phanNut.add(btnXoa);
		phanNut.add(btnTaoMoi);
		
		JPanel boxHienThi = new JPanel();
		boxHienThi.setLayout(new BoxLayout(boxHienThi, BoxLayout.Y_AXIS));
		boxHienThi.setPreferredSize(new Dimension(0, 350));
		dmLop = new DefaultTableModel();
		dmLop.addColumn("Mã lớp");
		dmLop.addColumn("Tên lớp");
		dmLop.addColumn("Năm học");
		JTable tbLop = new JTable(dmLop);
		JScrollPane scLop = new JScrollPane(tbLop);
		tbLop.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				arrMaMonDaThem.clear();
				textMaLop.setEditable(false);
				btnSua.setEnabled(true);
				btnXoa.setEnabled(true);
				btnThem.setEnabled(false);
				int row = tbLop.getSelectedRow();
				String value = tbLop.getValueAt(row, 0).toString();
				
				for(QuanLiLopHoc_Model x : arrLop) {
					if(value.equals(x.getMaLop())) {
						textMaLop.setText(x.getMaLop());
						textTenLop.setText(x.getTenLop());
						textNamHoc.setText(x.getNamHoc());
					}
				}
		
				
				arrPhanMon = phanMonStatement.sellecPhanMon(value);
				dm.setRowCount(0);
				for(QuanLiMonHoc_Model x : arrPhanMon) {
					String rowPhanMon[] = {x.getTenMon(), x.getMaMon()};
					dm.addRow(rowPhanMon);
				}
				arrMaMonThem.clear();
				for(row = 0; row < tbPhanMon.getRowCount(); row++) {
					String val = tbPhanMon.getValueAt(row, 1).toString();
					arrMaMonDaThem.add(val);
				}
				
					
			}
		});
		Border borderHienThi = BorderFactory.createEtchedBorder();
		TitledBorder borderTitleHienThi = BorderFactory.createTitledBorder(borderHienThi,"Thông tin lớp học",TitledBorder.CENTER, 
				TitledBorder.DEFAULT_POSITION);
		borderTitleHienThi.setTitleFont(borderTitleHienThi.getTitleFont().deriveFont(Font.BOLD,20));
		borderTitleHienThi.setTitleColor(Color.BLACK);
		
		
		boxNhap.add(phanNhap);
		boxNhap.add(Box.createRigidArea(new Dimension(0, 20)));
		boxNhap.add(phanNut);
		
		boxHienThi.setBorder(borderTitleHienThi);
		boxHienThi.add(scLop);
		
		boxQuanliLopHoc.add(boxNhap);
		boxQuanliLopHoc.add(Box.createRigidArea(new Dimension(0,10)));
		boxQuanliLopHoc.add(boxHienThi);
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(boxQuanliLopHoc);
	}
	
	private void addEvent() {
		btnThem.addActionListener(btnThemEvents);
		btnSua.addActionListener(btnSuaEvents);
		btnXoa.addActionListener(btnXoaEvents);
		btnTaoMoi.addActionListener(btnTaoMoiEvents);
		
		btnThemMon.addActionListener(btnThemMonEvents);
		btnXoaMon.addActionListener(btnXoaMonEvents);
	}
	
	ActionListener btnThemEvents = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
			String maLop = textMaLop.getText().toUpperCase();
			String tenLop = textTenLop.getText();
			String namHoc = textNamHoc.getText();
			int nam = Integer.parseInt(namHoc);
			int soMon = arrMaMonThem.size();
			String kt = "Không trùng";
			if(maLop.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập mã lớp");
			} else if(tenLop.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập tên lớp");
			} else if(namHoc.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập năm học");
			} else if(soMon == 0) {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn môn học cho lớp");
			}
			else {
				for(QuanLiLopHoc_Model x : arrLop) {
					if(maLop.equals(x.getMaLop())) {
						kt = "Trùng";
					}
				}
				
				if(kt == "Không trùng") {
					quanLiLopHocStatement.insertLopHoc(maLop, tenLop, namHoc);
					//String maLopHoc = textMaLop.getText();
					//String maMon = cboChonMon.getSelectedItem().toString();
					for(String x : arrMaMonThem) {
						phanMonStatement.insertPhanMon(maLop, x);
					}
					
					dmLop.setRowCount(0);
					inLop();
					taoMoi();
				}
				else {
					JOptionPane.showMessageDialog(null, "Trùng mã lớp vui lòng nhập lại");
				}
				
			}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Năm học phải nhập đúng dạng");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
		}
	};
	
	ActionListener btnSuaEvents = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
//				for(String x : arrMaMonXoa) {
//					System.out.println(x);
//				}
//				System.out.println("a");
			String maLop = textMaLop.getText();
			String tenLop = textTenLop.getText();
			String namHoc = textNamHoc.getText();
			int nam = Integer.parseInt(namHoc);
			String maMon = cboChonMon.getSelectedItem().toString();
			if(maLop.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn lớp cần sửa");
			} else if(tenLop.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập tên lớp");
			} else if(namHoc.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập năm học");
			}
			else {
				quanLiLopHocStatement.updateLopHoc(maLop, tenLop, namHoc);
				

				for(String x : arrMaMonThem) {
					phanMonStatement.insertPhanMon(maLop, x);
				}
				
				for(String x : arrMaMonXoa) {
					phanMonStatement.deletePhanMon(maLop, x);
				}
				
				dmLop.setRowCount(0);
				inLop();
				taoMoi();
			}
			
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Năm học phải nhập đúng dạng");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
		}
	};
	
	ActionListener btnXoaEvents = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
			String maLop = textMaLop.getText();
			int soLuong = quanLiLopHocStatement.demSoSinhVien(maLop);
			int choose = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa không", "Xóa", JOptionPane.YES_NO_OPTION);
			if(choose == JOptionPane.YES_OPTION) {
				if(soLuong > 0) {
					JOptionPane.showMessageDialog(null, "Không được xóa lớp còn tồn tại sinh viên");
				}else {
					if(maLop.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Vui lòng chọn lớp cần xóa");
					} else {
						quanLiLopHocStatement.deleteLopHoc(maLop);
						phanMonStatement.deleteLopPhanMon(maLop);
						dmLop.setRowCount(0);
						inLop();
						taoMoi();
					}
				
				}
			}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	};
	
	ActionListener btnTaoMoiEvents = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			textMaLop.setEditable(true);
			textMaLop.setText("");
			textTenLop.setText("");
			textNamHoc.setText("");
			dm.setRowCount(0);
			arrMaMonThem.clear();
			arrMaMonXoa.clear();
			arrMaMonDaThem.clear();
			btnSua.setEnabled(false);
			btnXoa.setEnabled(false);
			btnThem.setEnabled(true);
		}
	};
	
	
	
	ActionListener btnThemMonEvents = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
			sellectAllMon();
			String maLopHoc = textMaLop.getText();
			String maMon = cboChonMon.getSelectedItem().toString();
			String ktmon = "Không trùng";
			cboChonMon.setSelectedIndex(0);
			if(!maMon.equals("Chọn mã môn")) {
				for(String x : arrMaMonThem) {
					if(maMon.equals(x)) {
						ktmon = "Trùng mã";
					}
				}
				
				for(String x : arrMaMonDaThem) {
					if(maMon.equals(x)) {
						ktmon = "Trùng mã";
					}
				}
			
				if(ktmon == "Trùng mã") {
					JOptionPane.showMessageDialog(null, "Môn học đã tồn tại");
				} else {
					arrMaMonThem.add(maMon);
					for(QuanLiMonHoc_Model x : arrMon) {
						if(maMon.equals(x.getMaMon())) {
							String rowPhanMon[] = {x.getTenMon(), x.getMaMon()};
							dm.addRow(rowPhanMon);
						}
					}
				}
				
			} else {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn môn cần thêm");
			}
		
			} catch (Exception ex) {
		
			}
		}
	};
	
	ActionListener btnXoaMonEvents = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
			
			String maMon = cboChonMon.getSelectedItem().toString();
			String maLop = textMaLop.getText();
			String kt = "";
			cboChonMon.setSelectedIndex(0);
			if(maMon.equals("Chọn mã môn")) {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn môn cần xóa");
			} else {
//				for(QuanLiLopHoc_Model x : arrLop) {
//					if(textMaLop.getText().toUpperCase().equals(x.getMaLop())) {
//						kt = "Trùng mã lớp";
//					}
//				}
						arrMaMonXoa.add(maMon);
						int row = tbPhanMon.getSelectedRow(); 
						dm.removeRow(row);
						String value = cboChonMon.getSelectedItem().toString();
						for(String x : arrMaMonThem) {
							if(x.equals(value)) {
								arrMaMonThem.remove(x);
								break;
							}
							
						}
						
						for(String x : arrMaMonDaThem) {
							if(x.equals(value)) {
								arrMaMonDaThem.remove(x);
								break;
							}	
						}
						
			}
			for(String x : arrMaMonThem) {
				System.out.println(x);
			}
			System.out.println("-------------");
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		}
	};
	
	private void sellsectAllLop() {
		arrLop = quanLiLopHocStatement.sellectAllLop();
	}
	
	private void sellectAllMon() {
		arrMon = quanLiMonHocStatement.sellectMonHoc();
	}
	
	
	public void addItemMonHoc() {
		cboChonMon.removeAllItems();
		cboChonMon.addItem("Chọn mã môn");
		sellectAllMon();
		for(QuanLiMonHoc_Model x : arrMon) {
			cboChonMon.addItem(x.getMaMon());
		}
	}
	
	private void inLop() {
		sellsectAllLop();
		for(QuanLiLopHoc_Model x : arrLop) {
			String row[] = { x.getMaLop(), x.getTenLop(), x.getNamHoc()};
			dmLop.addRow(row);
		}
	}
	
	private void taoMoi() {
		textMaLop.setEditable(true);
		textMaLop.setText("");
		textTenLop.setText("");
		textNamHoc.setText("");
		dm.setRowCount(0);
		arrMaMonThem.clear();
		arrMaMonXoa.clear();
		arrMaMonDaThem.clear();
	}
}
