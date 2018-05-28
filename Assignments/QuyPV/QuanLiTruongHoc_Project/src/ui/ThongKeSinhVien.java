package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;

import connector.GetConnect;
import model.PhanMon_Model;
import model.QuanLiDiem_Model;
import model.QuanLiLopHoc_Model;
import model.QuanLiSinhVien_Model;
import model.ThongKeSinhVien_Statement;

public class ThongKeSinhVien extends JPanel {
	public JComboBox cboNamHoc, cboMaLop;
	public DefaultTableModel dm;
	private JTable tbSinhVien;
	private JButton btnThoat;
	private ThongKeSinhVien_Statement thongKeSinhVienStatement = new ThongKeSinhVien_Statement();
	private ArrayList<String> arrNamHoc = new ArrayList<>();
	private ArrayList<QuanLiLopHoc_Model> arrMaLop = new ArrayList<>();
	private ArrayList<PhanMon_Model> arrPhanMon = new ArrayList<>();
	private ArrayList<QuanLiSinhVien_Model> arrThongTinSv = new ArrayList<>();
	private ArrayList<QuanLiDiem_Model> arrDiemSv = new ArrayList<>();
	public ThongKeSinhVien() {
		addControls();
		addEvents();
	}
	
	private void addControls() {
		JPanel boxQuanLiSinhVien = new JPanel();
		boxQuanLiSinhVien.setLayout(new BoxLayout(boxQuanLiSinhVien, BoxLayout.Y_AXIS));
		Font font = new Font("Arial", Font.BOLD, 15);
		Border borderThongKe = BorderFactory.createEtchedBorder();
		TitledBorder borderTitleThongKe = BorderFactory.createTitledBorder(borderThongKe,"Báo cáo sinh viên",TitledBorder.CENTER, 
				TitledBorder.DEFAULT_POSITION);
		borderTitleThongKe.setTitleFont(borderTitleThongKe.getTitleFont().deriveFont(Font.BOLD,20));
		borderTitleThongKe.setTitleColor(Color.BLACK);
		boxQuanLiSinhVien.setBorder(borderTitleThongKe);
		JPanel phanTimKiem = new JPanel();
		phanTimKiem.setLayout(new FlowLayout(FlowLayout.RIGHT));
		phanTimKiem.setPreferredSize(new Dimension(0, 1));
		JLabel namHoc = new JLabel("Năm học:");
		namHoc.setFont(font);
		namHoc.setPreferredSize(new Dimension(90, 70));
		cboNamHoc = new JComboBox<>();
		cboNamHoc.addItem("Chọn năm học");
		cboNamHoc.setPreferredSize(new Dimension(120, 30));
		JLabel maLop = new JLabel("Mã lớp:");
		maLop.setFont(font);
		maLop.setPreferredSize(new Dimension(90, 70));
		cboMaLop = new JComboBox<>();
		cboMaLop.setPreferredSize(new Dimension(120, 30));
		JPanel phanHienThi = new JPanel();
		phanHienThi.setLayout(new BoxLayout(phanHienThi, BoxLayout.Y_AXIS));
		phanHienThi.setPreferredSize(new Dimension(0, 500));
		dm = new DefaultTableModel();
		dm.addColumn("Mã sinh viên");
		dm.addColumn("Họ tên");
//		dm.addColumn("Môn");
//		dm.addColumn("Môn");
//		dm.addColumn("Môn");
//		dm.addColumn("Môn");
//		dm.addColumn("Môn");
		tbSinhVien = new JTable(dm);
		//dm.addRow(new String[] {"FFSE1703", "Lập trình", "2018", "20"});
		JScrollPane sc = new JScrollPane(tbSinhVien);
		JPanel phanNut = new JPanel();
		phanNut.setLayout(new FlowLayout(FlowLayout.RIGHT));
		ImageIcon imgBtnThoat = new ImageIcon(getClass().getResource("/images/btn_thoat.png"));
		btnThoat = new JButton("Thoát", imgBtnThoat);
		btnThoat.setPreferredSize(new Dimension(110, 30));
		
		
		phanTimKiem.add(namHoc);
		phanTimKiem.add(cboNamHoc);
		phanTimKiem.add(Box.createRigidArea(new Dimension(50, 0)));
		phanTimKiem.add(maLop);
		phanTimKiem.add(cboMaLop);
		phanTimKiem.add(Box.createRigidArea(new Dimension(50, 0)));
		
		phanHienThi.add(sc);
		
		phanNut.add(btnThoat);
		phanNut.add(Box.createRigidArea(new Dimension(100, 0)));
		
		boxQuanLiSinhVien.add(phanTimKiem);
		boxQuanLiSinhVien.add(phanHienThi);
		boxQuanLiSinhVien.add(Box.createRigidArea(new Dimension(0, 50)));
		boxQuanLiSinhVien.add(phanNut);
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(boxQuanLiSinhVien);
	}
	
	private void addEvents() {
		cboNamHoc.addActionListener(cboNamHocEvents);
		cboMaLop.addActionListener(cboMaLopEvents);
		btnThoat.addActionListener(btnThoatEvents);
	}
	
	
	ActionListener cboNamHocEvents = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			sellectAllLop();
			dm.setRowCount(0);
			Object nH = cboNamHoc.getSelectedItem();
			if(nH != null && !nH.equals("Chọn năm học")) {
				String namHoc = cboNamHoc.getSelectedItem().toString();
				cboMaLop.removeAllItems();
				cboMaLop.addItem("Chọn Mã lớp");
				for(QuanLiLopHoc_Model x : arrMaLop) {
					if(namHoc.equals(x.getNamHoc())) {
						cboMaLop.addItem(x.getMaLop());
					}
				}
			}
	
		}
	};
	
	
	ActionListener cboMaLopEvents = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Object ml = cboMaLop.getSelectedItem();
			double tong = 0 ;
			String xepLoai;
			if(ml != null && !ml.toString().equals("Chọn Mã lớp")) {
				String maLop = cboMaLop.getSelectedItem().toString();
				
				arrPhanMon = thongKeSinhVienStatement.sellectPhanMon(maLop);
				arrThongTinSv = thongKeSinhVienStatement.sellectThongTinSv(maLop);
				dm.setColumnCount(0);
				dm.addColumn("Mã sinh viên");
				dm.addColumn("Họ tên");
				
				for(PhanMon_Model x : arrPhanMon) {
					dm.addColumn(x.getMaMon());
				}
				dm.addColumn("Điểm TB");
				dm.addColumn("Xếp loại");
				dm.setRowCount(0);
				for(QuanLiSinhVien_Model x : arrThongTinSv) {
					String maSv = x.getMaSV();
					// lấy điểm từng sinh viên
					arrDiemSv = thongKeSinhVienStatement.sellectDiemSv(x.getMaSV());
					for(QuanLiDiem_Model y : arrDiemSv) {
						double diem = Double.parseDouble(y.getDiem());
						tong += diem; 
					}
					String Tb = String.valueOf(tong / arrPhanMon.size());
					double soDiemTb = Double.parseDouble(Tb);
					tong = 0;
					if(arrPhanMon.size() != arrDiemSv.size()) {
						xepLoai = null;
						Tb = null;
					} else if(soDiemTb >= 8) {
						xepLoai = "Giỏi";
					} else if(soDiemTb >= 6.5 && soDiemTb < 8) {
						xepLoai = "Khá";
					} else if(soDiemTb >= 5 && soDiemTb < 6.5) {
						xepLoai = "Trung bình";
					} else {
						xepLoai = "Yếu";
					}
					
					String row[] = new String[20];
					row[0] = x.getMaSV();
					row[1] = x.getHoTen();
					System.out.println(arrDiemSv.size());
					row[arrPhanMon.size() + 2] = Tb;
					row[arrPhanMon.size() + 3] = xepLoai;
					for (int i = 0; i < arrPhanMon.size(); i++) {
						row[i+2] = thongKeSinhVienStatement.diemSv(maSv, arrPhanMon.get(i).getMaMon());
					}
					dm.addRow(row);

				}
				
				
			}
		}
	};
	
	ActionListener btnThoatEvents = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			int chose = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa không?", "Xóa", JOptionPane.YES_NO_OPTION);
			if(chose == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
	};
	
	
	private void sellectAllLop() {
		arrMaLop = thongKeSinhVienStatement.sellectAllLop();
	}
	
	public void addItemNamHoc() {
		cboNamHoc.removeAllItems();
		cboNamHoc.addItem("Chọn năm học");
		arrNamHoc = thongKeSinhVienStatement.sellectNamHoc();
		cboMaLop.addItem("Chọn Mã lớp");
		for(String x : arrNamHoc) {
			cboNamHoc.addItem(x);;
		}
	}
	
}
