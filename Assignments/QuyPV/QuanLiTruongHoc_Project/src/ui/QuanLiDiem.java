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
import model.QuanLiDiem_Model;
import model.QuanLiDiem_Statement;
import model.QuanLiLopHoc_Model;
import model.QuanLiLopHoc_Statement;
import model.QuanLiSinhVien_Model;
import model.QuanLiSinhVien_Statement;

public class QuanLiDiem extends JPanel {
	public JComboBox cboMaLop, cboMaMon;
	private DefaultTableModel dmDanhSach;
	private JTextField textMaMon, textMaSv, textDiem;
	private JButton btnNhap, btnSua, btnXoa, btnHuy;
	private QuanLiSinhVien_Statement quanLiSinhVienStament = new QuanLiSinhVien_Statement();
	private QuanLiLopHoc_Statement quanLiLopHocStatement = new QuanLiLopHoc_Statement();
	private PhanMon_Statement phanMonStatement = new PhanMon_Statement();
	private QuanLiDiem_Statement quanLiDiemStatement = new QuanLiDiem_Statement();
	private ArrayList<QuanLiSinhVien_Model> arrSinhVien = new ArrayList<>();
	private ArrayList<QuanLiLopHoc_Model> arrLop = new ArrayList<>();
	private ArrayList<PhanMon_Model> arrPhanMon = new ArrayList<>();
	private ArrayList<QuanLiDiem_Model> arrQuanLiDiem = new ArrayList<>();
	public QuanLiDiem() {
		addControls();
		addEvents();
		//cboMaLop.setSelectedIndex(1);;
	}
	
	private void addControls() {
		JPanel boxQuanLiDiem = new JPanel();
		boxQuanLiDiem.setLayout(new BoxLayout(boxQuanLiDiem, BoxLayout.Y_AXIS));
		Font font = new Font("Arial", Font.BOLD, 15);
		JPanel boxChonSinhVien = new JPanel();
		boxChonSinhVien.setLayout(new BoxLayout(boxChonSinhVien, BoxLayout.Y_AXIS));
		Border borderChonSinhVien = BorderFactory.createEtchedBorder();
		TitledBorder borderTitleChonSinhVien = BorderFactory.createTitledBorder(borderChonSinhVien,"Danh sách sinh viên",TitledBorder.CENTER, 
				TitledBorder.DEFAULT_POSITION);
		borderTitleChonSinhVien.setTitleFont(borderTitleChonSinhVien.getTitleFont().deriveFont(Font.BOLD,20));
		borderTitleChonSinhVien.setTitleColor(Color.BLACK);
		boxChonSinhVien.setBorder(borderTitleChonSinhVien);
		JPanel phanTimKiem = new JPanel();
		phanTimKiem.setLayout(new FlowLayout());
		JLabel maLop = new JLabel("Mã Lớp:");
		maLop.setFont(font);
		
		cboMaLop = new JComboBox<>();
		cboMaLop.setPreferredSize(new Dimension(120, 30));
		cboMaLop.addItem("Mã lớp");
		
		JLabel maMon = new JLabel("Mã môn:");
		maMon.setFont(font);
		cboMaMon = new  JComboBox<>();
		cboMaMon.setPreferredSize(new Dimension(120, 30));
		cboMaMon.addItem("Mã môn");
		phanTimKiem.add(maLop);
		phanTimKiem.add(cboMaLop);
		phanTimKiem.add(Box.createRigidArea(new Dimension(50, 0)));
		phanTimKiem.add(maMon);
		phanTimKiem.add(cboMaMon);
		JPanel phanHienThi = new JPanel();
		phanHienThi.setLayout(new BoxLayout(phanHienThi, BoxLayout.Y_AXIS));
		dmDanhSach = new DefaultTableModel();
		dmDanhSach.addColumn("Mã Sinh Viên");
		dmDanhSach.addColumn("Tên Sinh Viên");
		dmDanhSach.addColumn("Mã Lớp");
		JTable tbDanhSach = new JTable(dmDanhSach);
		JScrollPane scĐanhSach = new JScrollPane(tbDanhSach);
		tbDanhSach.addMouseListener(new MouseAdapter() {
		
			@Override
			public void mouseClicked(MouseEvent e) {
				sellectAllQuanLiDiem();
				btnSua.setEnabled(true);
				btnNhap.setEnabled(false);
				int row = tbDanhSach.getSelectedRow();
				String maSv = tbDanhSach.getValueAt(row, 0).toString();
				String maMon = textMaMon.getText();
				textMaSv.setText(maSv);
				for(QuanLiDiem_Model x : arrQuanLiDiem) {
					if(maSv.equals(x.getMaSv()) && maMon.equals(x.getMaMon())) {
						textDiem.setText(x.getDiem());
					}
				}
			}
		});
		phanHienThi.add(scĐanhSach);
		JPanel boxNhapDiem = new JPanel();
		boxNhapDiem.setLayout(new BoxLayout(boxNhapDiem, BoxLayout.Y_AXIS));
		boxNhapDiem.setPreferredSize(new Dimension(0, 350));
		Border borderNhapDiem = BorderFactory.createEtchedBorder();
		TitledBorder borderTitleNhapDiem = BorderFactory.createTitledBorder(borderNhapDiem,"Nhập điểm",TitledBorder.CENTER, 
				TitledBorder.DEFAULT_POSITION);
		borderTitleNhapDiem.setTitleFont(borderTitleNhapDiem.getTitleFont().deriveFont(Font.BOLD,20));
		borderTitleNhapDiem.setTitleColor(Color.BLACK);
		boxNhapDiem.setBorder(borderTitleNhapDiem);
		JPanel hangMaSV = new JPanel();
		hangMaSV.setLayout(new FlowLayout());
		JLabel lbMaSV = new JLabel("Mã sinh Viên:");
		lbMaSV.setFont(font);
		lbMaSV.setPreferredSize(new Dimension(110, 30));
		textMaSv = new JTextField();
		textMaSv.setPreferredSize(new Dimension(150, 30));
		textMaSv.setEditable(false);
		JPanel hangMaMon = new JPanel();
		hangMaMon.setLayout(new FlowLayout());
		JLabel lbMaMon = new JLabel("Mã môn:");
		lbMaMon.setFont(font);
		lbMaMon.setPreferredSize(new Dimension(110, 30));
		textMaMon = new JTextField();
		textMaMon.setPreferredSize(new Dimension(150, 30));
		textMaMon.setEditable(false);
		JPanel hangDiem = new JPanel();
		hangDiem.setLayout(new FlowLayout());
		JLabel lbDiem = new JLabel("Điểm:");
		lbDiem.setFont(font);
		lbDiem.setPreferredSize(new Dimension(110, 30));
		textDiem = new JTextField();
		textDiem.setPreferredSize(new Dimension(150, 30));
		JPanel hangNut = new JPanel();
		ImageIcon imgBtnNhap = new ImageIcon(getClass().getResource("/images/btn_nhapdiem.png"));
		btnNhap = new JButton("Nhập", imgBtnNhap);
		btnNhap.setPreferredSize(new Dimension(110, 30));
		ImageIcon imgBtnSua = new ImageIcon(getClass().getResource("/images/btn_sua.png"));
		btnSua = new JButton("Sửa", imgBtnSua);
		btnSua.setEnabled(false);
		btnSua.setPreferredSize(new Dimension(110, 30));
		ImageIcon imgBtnHuy = new ImageIcon(getClass().getResource("/images/btn_huy.png"));
		btnHuy = new JButton("Hủy", imgBtnHuy);
		btnHuy.setPreferredSize(new Dimension(110, 30));
		hangMaSV.add(lbMaSV);
		hangMaSV.add(textMaSv);
		hangMaMon.add(lbMaMon);
		hangMaMon.add(textMaMon);
		hangDiem.add(lbDiem);
		hangDiem.add(textDiem);
		hangNut.add(btnNhap);
		hangNut.add(Box.createRigidArea(new Dimension(20, 0)));
		hangNut.add(btnSua);
		hangNut.add(Box.createRigidArea(new Dimension(20, 0)));
		hangNut.add(btnHuy);
		
		
		boxChonSinhVien.add(Box.createRigidArea(new Dimension(0, 10)));
		boxChonSinhVien.add(phanTimKiem);
		boxChonSinhVien.add(Box.createRigidArea(new Dimension(0, 5)));
		boxChonSinhVien.add(phanHienThi);
		boxChonSinhVien.add(Box.createRigidArea(new Dimension(0, 10)));
		
		boxNhapDiem.add(hangMaSV);
		boxNhapDiem.add(hangMaMon);
		boxNhapDiem.add(hangDiem);
		boxNhapDiem.add(hangNut);
		
		boxQuanLiDiem.add(boxChonSinhVien);
		boxQuanLiDiem.add(Box.createRigidArea(new Dimension(0, 10)));
		boxQuanLiDiem.add(boxNhapDiem);
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(boxQuanLiDiem);
	}
	
	private void addEvents() {
		cboMaLop.addActionListener(cboMaLopEvents);
		cboMaMon.addActionListener(cboMaMonEvents);repaint();
		btnNhap.addActionListener(btnNhapEvents);
		btnSua.addActionListener(btnSuaEvents);
		btnHuy.addActionListener(btnHuyEvents);
		
	}
	
	ActionListener cboMaLopEvents = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Object mL = cboMaLop.getSelectedItem();
			if(mL != null && !mL.toString().equals("Mã lớp")) {
				dmDanhSach.setRowCount(0);
				sellectAllSinhvien();
				String maLop = cboMaLop.getSelectedItem().toString();
				 for(QuanLiSinhVien_Model x : arrSinhVien) {
					 if(maLop.equals(x.getMaLop())) {
						 String row[] = {x.getMaSV(), x.getHoTen(), x.getMaLop()};
						 dmDanhSach.addRow(row);
					 }
				 }
				 arrPhanMon = quanLiDiemStatement.sellectPhanMon(maLop);
				 cboMaMon.removeAllItems();
				 cboMaMon.addItem("Mã môn");
				 for(PhanMon_Model x : arrPhanMon) {
					 cboMaMon.addItem(x.getMaMon());
				 } 
				 taoMoi();
			}
			
		}
	};
	
	ActionListener cboMaMonEvents = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Object mM = cboMaMon.getSelectedItem();
			// chống nullPointer exception
			if(mM != null && !mM.toString().equals("Mã môn")) {
				String maMon = cboMaMon.getSelectedItem().toString();
				if(!maMon.equals("Mã môn")) {
					textMaMon.setText(maMon);
				}
				
				textMaSv.setText("");
				textDiem.setText("");
			}

		}
	};
	
	ActionListener btnNhapEvents = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
			sellectAllQuanLiDiem();
			String maSv = textMaSv.getText();
			String maMon = textMaMon.getText();
			String diem = textDiem.getText();
			int check = Integer.parseInt(diem);
			String kt = "Không trùng";
			if(maSv.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn sinh viên");
			} else if(maMon.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn mã môn");
			} else if(check > 10) {
				JOptionPane.showMessageDialog(null, "Số  điểm nhập vào không hợp lệ. Vui lòng nhập lại");
			}
			else {
				for(QuanLiDiem_Model x : arrQuanLiDiem) {
					if(maSv.equals(x.getMaSv()) && maMon.equals(x.getMaMon())) {
						kt = "Trùng";
					}
				}
				if(kt == "Trùng") {
					JOptionPane.showMessageDialog(null, "Điểm và môn học đã tồn tại");
				}else if(check > 10) {
					JOptionPane.showMessageDialog(null, "Số  điểm nhập vào không hợp lệ. Vui lòng nhập lại");
				} 
				else {
					quanLiDiemStatement.insertDiem(maSv, maMon, diem);
				}
			}
			}catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null,	"Phải nhập điểm đúng dạng");
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
	
		}
	};
	
	ActionListener btnSuaEvents = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
			sellectAllQuanLiDiem();
			String maSv = textMaSv.getText();
			String maMon = textMaMon.getText();
			String diem = textDiem.getText();
			int check = Integer.parseInt(diem);
			if(diem.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập điểm");
			} else if(check > 10) {
				JOptionPane.showMessageDialog(null, "Số  điểm nhập vào không hợp lệ. Vui lòng nhập lại");
			}
			else {
				quanLiDiemStatement.updateDiem(maSv, maMon ,diem);
			}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null,	"Phải nhập điểm đúng dạng");
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
			
		}
	};
	
	ActionListener btnHuyEvents = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			taoMoi();
		}
	};
	
	private void sellectAllSinhvien() {
		arrSinhVien = quanLiSinhVienStament.selectAllSv();
	}
	
	private void sellectAllLop() {
		arrLop = quanLiLopHocStatement.sellectAllLop();
	}
	
	private void sellectAllQuanLiDiem() {
		arrQuanLiDiem = quanLiDiemStatement.sellectAllDiem();
	}
	
	public void addItemMaLop() {
		cboMaLop.removeAllItems();
		cboMaLop.addItem("Mã lớp");
		sellectAllLop();
		for(QuanLiLopHoc_Model x : arrLop) {
			cboMaLop.addItem(x.getMaLop());
		}
	}
	
	private void taoMoi() {
		textMaSv.setText("");
		textMaMon.setText("");
		textDiem.setText("");
		btnSua.setEnabled(false);
		btnNhap.setEnabled(true);
	}

}
