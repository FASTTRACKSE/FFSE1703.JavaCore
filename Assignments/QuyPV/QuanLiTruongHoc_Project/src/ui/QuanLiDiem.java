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

public class QuanLiDiem extends JPanel {
	//final Connection conn= GetConnect.getConnect("localhost", "Quan_li_truong_hoc", "admin", "123456");
	public QuanLiDiem() {
		addControls();
		addEvents();
	}
	
	private void addControls() {
		JPanel boxQuanLiDiem = new JPanel();
		boxQuanLiDiem.setLayout(new BoxLayout(boxQuanLiDiem, BoxLayout.Y_AXIS));
		Font font = new Font("Arial", Font.BOLD, 15);
		JPanel boxChonSinhVien = new JPanel();
		boxChonSinhVien.setLayout(new BoxLayout(boxChonSinhVien, BoxLayout.Y_AXIS));
		Border borderChonSinhVien = BorderFactory.createLineBorder(Color.RED);
		boxChonSinhVien.setBorder(borderChonSinhVien);
		JPanel phanTimKiem = new JPanel();
		phanTimKiem.setLayout(new FlowLayout());
		JLabel maLop = new JLabel("Mã Lớp:");
		maLop.setFont(font);
		JComboBox cboMaLop = new JComboBox<>();
		cboMaLop.setPreferredSize(new Dimension(120, 30));
		cboMaLop.addItem("Mã lớp");
		JLabel maMon = new JLabel("Mã môn:");
		maMon.setFont(font);
		JComboBox cboMaMon = new  JComboBox<>();
		cboMaMon.setPreferredSize(new Dimension(120, 30));
		cboMaMon.addItem("Mã môn");
		phanTimKiem.add(maLop);
		phanTimKiem.add(cboMaLop);
		phanTimKiem.add(Box.createRigidArea(new Dimension(50, 0)));
		phanTimKiem.add(maMon);
		phanTimKiem.add(cboMaMon);
		JPanel phanHienThi = new JPanel();
		phanHienThi.setLayout(new BoxLayout(phanHienThi, BoxLayout.Y_AXIS));
		DefaultTableModel dmDanhSach = new DefaultTableModel();
		dmDanhSach.addColumn("Mã Sinh Viên");
		dmDanhSach.addColumn("Tên Sinh Viên");
		dmDanhSach.addColumn("Mã Lớp");
		JTable tbDanhSach = new JTable(dmDanhSach);
		dmDanhSach.addRow(new String[] {"FFSE1703010", "Phạm Văn Quý", "FFSE1703"});
		JScrollPane scĐanhSach = new JScrollPane(tbDanhSach);
		phanHienThi.add(scĐanhSach);
		JPanel boxNhapDiem = new JPanel();
		boxNhapDiem.setLayout(new BoxLayout(boxNhapDiem, BoxLayout.Y_AXIS));
		boxNhapDiem.setPreferredSize(new Dimension(0, 350));
		Border borderNhapDiem = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitleNhapDiem = BorderFactory.createTitledBorder(borderNhapDiem,"Nhập điểm",TitledBorder.CENTER, 
				TitledBorder.DEFAULT_POSITION);
		borderTitleNhapDiem.setTitleFont(borderTitleNhapDiem.getTitleFont().deriveFont(Font.ITALIC,20));
		borderTitleNhapDiem.setTitleColor(Color.RED);
		boxNhapDiem.setBorder(borderTitleNhapDiem);
		JPanel hangMaSV = new JPanel();
		hangMaSV.setLayout(new FlowLayout());
		JLabel lbMaSV = new JLabel("Mã sinh Viên:");
		lbMaSV.setFont(font);
		lbMaSV.setPreferredSize(new Dimension(110, 30));
		JTextField textMaSV = new JTextField();
		textMaSV.setPreferredSize(new Dimension(150, 30));
		textMaSV.setEditable(false);
		JPanel hangMaMon = new JPanel();
		hangMaMon.setLayout(new FlowLayout());
		JLabel lbMaMon = new JLabel("Mã môn:");
		lbMaMon.setFont(font);
		lbMaMon.setPreferredSize(new Dimension(110, 30));
		JTextField textMaMon = new JTextField();
		textMaMon.setPreferredSize(new Dimension(150, 30));
		textMaMon.setEditable(false);
		JPanel hangDiem = new JPanel();
		hangDiem.setLayout(new FlowLayout());
		JLabel lbDiem = new JLabel("Điểm:");
		lbDiem.setFont(font);
		lbDiem.setPreferredSize(new Dimension(110, 30));
		JTextField textDiem = new JTextField();
		textDiem.setPreferredSize(new Dimension(150, 30));
		JPanel hangNut = new JPanel();
		JButton btnLuu = new JButton("Lưu");
		JButton btnHuy = new JButton("Hủy");
		hangMaSV.add(lbMaSV);
		hangMaSV.add(textMaSV);
		hangMaMon.add(lbMaMon);
		hangMaMon.add(textMaMon);
		hangDiem.add(lbDiem);
		hangDiem.add(textDiem);
		hangNut.add(btnLuu);
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
		
	}
}
