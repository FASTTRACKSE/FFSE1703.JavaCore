package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;

import connector.GetConnect;

public class QuanLiLopHoc extends JPanel {
	//final Connection conn= GetConnect.getConnect("localhost", "Quan_li_truong_hoc", "admin", "123456");
	public QuanLiLopHoc(){
		addControl();
		addEvent();
	}
	
	private void addControl() {
		JPanel boxQuanliLopHoc = new JPanel();
		boxQuanliLopHoc.setLayout(new BoxLayout(boxQuanliLopHoc, BoxLayout.Y_AXIS));
		Font font = new Font("Arial", Font.BOLD, 15);
		JPanel boxNhap =new JPanel();
		boxNhap.setLayout(new BoxLayout(boxNhap, BoxLayout.Y_AXIS));
		Border borderNhap = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitleNhap = BorderFactory.createTitledBorder(borderNhap,"Nhập thông tin lớp học",TitledBorder.CENTER, 
				TitledBorder.DEFAULT_POSITION);
		borderTitleNhap.setTitleFont(borderTitleNhap.getTitleFont().deriveFont(Font.ITALIC,20));
		borderTitleNhap.setTitleColor(Color.RED);
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
		JTextField textMaLop = new JTextField();
		textMaLop.setPreferredSize(new Dimension(120, 30));
		JPanel hangNhap2 = new JPanel();
		hangNhap2.setLayout(new FlowLayout());
		JLabel tenLop = new JLabel("Tên lớp:");
		tenLop.setFont(font);
		tenLop.setPreferredSize(new Dimension(90, 70));
		JTextField textTenLop = new JTextField();
		textTenLop.setPreferredSize(new Dimension(120, 30));
		JPanel hangNhap3 = new JPanel();
		hangNhap3.setLayout(new FlowLayout());
		JLabel namHoc = new JLabel("Năm học:");
		namHoc.setFont(font);
		namHoc.setPreferredSize(new Dimension(90, 70));
		JTextField textNamHoc = new JTextField();
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
		JComboBox cboChonMon = new JComboBox();
		cboChonMon.addItem("Chọn mã môn");
		cboChonMon.setPreferredSize(new Dimension(120, 30));
		JButton btnThemMon = new JButton("Thêm môn");
		themMon.add(chonMon);
		themMon.add(cboChonMon);
		themMon.add(btnThemMon);
		DefaultTableModel dm = new DefaultTableModel();
		dm.addColumn("Mã lớp");
		dm.addColumn("Mã môn");
		JTable tbPhanMon = new JTable(dm);
		dm.addRow(new String[] {"FFSE1703", "LP4"});
		JScrollPane sc = new JScrollPane(tbPhanMon);
		JPanel xoaMon = new  JPanel();
		xoaMon.setLayout(new FlowLayout());
		JButton btnXoaMon = new JButton("Xóa Môn");
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
		JButton btnThem = new JButton("Thêm");
		JButton btnSua = new JButton("Sửa");
		JButton btnXoa = new JButton("Xóa");
		JButton btnThoat = new JButton("Thoát");
		phanNut.add(btnThem);
		phanNut.add(btnSua);
		phanNut.add(btnXoa);
		phanNut.add(btnThoat);
		
		JPanel boxHienThi = new JPanel();
		boxHienThi.setLayout(new BoxLayout(boxHienThi, BoxLayout.Y_AXIS));
		boxHienThi.setPreferredSize(new Dimension(0, 350));
		DefaultTableModel dmLop = new DefaultTableModel();
		dmLop.addColumn("Mã lớp");
		dmLop.addColumn("Tên lớp");
		dmLop.addColumn("Năm học");
		JTable tbLop = new JTable(dmLop);
		dmLop.addRow(new String[] {"FFSE1703", "Lập trình", "2017"});
		JScrollPane scLop = new JScrollPane(tbLop);
		Border borderHienThi = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitleHienThi = BorderFactory.createTitledBorder(borderHienThi,"Thông tin lớp học",TitledBorder.CENTER, 
				TitledBorder.DEFAULT_POSITION);
		borderTitleHienThi.setTitleFont(borderTitleHienThi.getTitleFont().deriveFont(Font.ITALIC,20));
		borderTitleHienThi.setTitleColor(Color.RED);
		
		
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
		
	}
}
