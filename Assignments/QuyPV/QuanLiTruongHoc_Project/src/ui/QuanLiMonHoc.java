package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;

import connector.GetConnect;

public class QuanLiMonHoc extends JPanel {
	//final Connection conn= GetConnect.getConnect("localhost", "Quan_li_truong_hoc", "admin", "123456");
	public QuanLiMonHoc() {
		addControl();
		addEvent();
	}

	private void addControl() {
		JPanel boxQuanLiMonHoc = new JPanel();
		boxQuanLiMonHoc.setLayout(new BoxLayout(boxQuanLiMonHoc, BoxLayout.Y_AXIS));
		Font font = new Font("Arial", Font.BOLD, 15);
		JPanel boxNhap = new JPanel();
		boxNhap.setLayout(new BoxLayout(boxNhap, BoxLayout.X_AXIS));
		Border borderNhap = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitleNhap = BorderFactory.createTitledBorder(borderNhap,"Nhập thông tin môn học",TitledBorder.CENTER, 
				TitledBorder.DEFAULT_POSITION);
		borderTitleNhap.setTitleFont(borderTitleNhap.getTitleFont().deriveFont(Font.ITALIC,20));
		borderTitleNhap.setTitleColor(Color.RED);
		boxNhap.setBorder(borderTitleNhap);
		JPanel khungNhap = new JPanel();
		khungNhap.setLayout(new BoxLayout(khungNhap, BoxLayout.Y_AXIS));
		Border borderKhungNhap = BorderFactory.createEtchedBorder();
		khungNhap.setBorder(borderKhungNhap);
		JPanel hangNhap1 = new JPanel();
		hangNhap1.setLayout(new FlowLayout());
		JLabel maMon = new JLabel("Mã môn:");
		maMon.setFont(font);
		maMon.setPreferredSize(new Dimension(90, 30));
		JTextField textMaMon = new JTextField(20);
		textMaMon.setPreferredSize(new Dimension(90, 30));
		JPanel hangNhap2 = new JPanel();
		hangNhap2.setLayout(new FlowLayout());
		JLabel tenMon = new JLabel("Tên môn:");
		tenMon.setFont(font);
		tenMon.setPreferredSize(new Dimension(90, 30));
		JTextField textTenMon = new JTextField(20);
		textTenMon.setPreferredSize(new Dimension(90, 30));
		JPanel hangNhap3 = new JPanel();
		hangNhap3.setLayout(new FlowLayout());
		JLabel soTinChi = new JLabel("Số tín chỉ:");
		soTinChi.setFont(font);
		soTinChi.setPreferredSize(new Dimension(90, 30));
		JTextField textSoTinChi = new JTextField(20);
		textSoTinChi.setPreferredSize(new Dimension(90, 30));
		JPanel hangNhap4 = new JPanel();
		hangNhap4.setLayout(new FlowLayout());
		JLabel thoiLuong = new JLabel("Thời lượng:");
		thoiLuong.setFont(font);
		thoiLuong.setPreferredSize(new Dimension(90, 30));
		JTextField textThoiLuong = new JTextField(20);
		textThoiLuong.setPreferredSize(new Dimension(90, 30));
		hangNhap1.add(maMon);
		hangNhap1.add(textMaMon);
		hangNhap2.add(tenMon);
		hangNhap2.add(textTenMon);
		hangNhap3.add(soTinChi);
		hangNhap3.add(textSoTinChi);
		hangNhap4.add(thoiLuong);
		hangNhap4.add(textThoiLuong);
		khungNhap.add(hangNhap1);
		khungNhap.add(hangNhap2);
		khungNhap.add(hangNhap3);
		khungNhap.add(hangNhap4);

		JPanel khungNut = new JPanel();
		khungNut.setLayout(new BoxLayout(khungNut, BoxLayout.Y_AXIS));
		Border borderKhungNut = BorderFactory.createEtchedBorder();
		khungNut.setBorder(borderKhungNut);
		JPanel hangNut1 = new JPanel();
		hangNut1.setLayout(new FlowLayout());
		JButton btnThem = new JButton("Thêm");
		btnThem.setPreferredSize(new Dimension(90, 30));
		JPanel hangNut2 = new JPanel();
		hangNut2.setLayout(new FlowLayout());
		JButton btnSua = new JButton("Sửa");
		btnSua.setPreferredSize(new Dimension(90, 30));
		JPanel hangNut3 = new JPanel();
		hangNut3.setLayout(new FlowLayout());
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setPreferredSize(new Dimension(90, 30));
		JPanel hangNut4 = new JPanel();
		hangNut4.setLayout(new FlowLayout());
		JButton btnThoat = new JButton("Thoát");
		btnThoat.setPreferredSize(new Dimension(90, 30));
		hangNut1.add(btnThem);
		hangNut2.add(btnSua);
		hangNut3.add(btnXoa);
		hangNut4.add(btnThoat);
		khungNut.add(hangNut1);
		khungNut.add(hangNut2);
		khungNut.add(hangNut3);
		khungNut.add(hangNut4);
		

		JPanel boxHienThi = new JPanel();
		boxHienThi.setLayout(new BoxLayout(boxHienThi, BoxLayout.Y_AXIS));
		boxHienThi.setPreferredSize(new Dimension(0, 350));
		Border borderHienThi = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitleHienThi = BorderFactory.createTitledBorder(borderHienThi,"Thông tin môn học",TitledBorder.CENTER, 
				TitledBorder.DEFAULT_POSITION);
		borderTitleHienThi.setTitleFont(borderTitleNhap.getTitleFont().deriveFont(Font.ITALIC,20));
		borderTitleHienThi.setTitleColor(Color.RED);
		boxHienThi.setBorder(borderTitleHienThi);
		DefaultTableModel dm = new DefaultTableModel();
		dm.addColumn("Mã môn");
		dm.addColumn("Tên môn");
		dm.addColumn("Số tín chỉ");
		dm.addColumn("Thời lượng");
		JTable tbSinhVien = new JTable(dm);
		dm.addRow(new String[] {"LP1", "Nhập môn lập trình", "2", "48"});
		dm.addRow(new String[] {"LP1", "Nhập môn lập trình", "2", "48"});
		JScrollPane sc = new JScrollPane(tbSinhVien);
		
		
		boxNhap.add(khungNhap);
		boxNhap.add(Box.createRigidArea(new Dimension(10, 0)));
		boxNhap.add(khungNut);
		boxHienThi.add(sc);
		
		boxQuanLiMonHoc.add(boxNhap);
		boxQuanLiMonHoc.add(Box.createRigidArea(new Dimension(0, 5)));
		boxQuanLiMonHoc.add(boxHienThi);

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(boxQuanLiMonHoc);
	}

	private void addEvent() {

	}

}
