package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.GetConnectDB;
import model.QuanLiSinhVienModel;

public class QuanLiSinhVienUI extends JPanel {
	private String name;
	private JComboBox cboThanhPho,cboQuan,cboPhuong;
	private JButton btnThem,btnSua,btnXoa,btnThoat;
	private static ArrayList<QuanLiSinhVienModel> arrQlSinhVien = new ArrayList<>();
	private static ArrayList<String> arrProvince = new ArrayList<>();
	private static ArrayList<String> arrDistrict = new ArrayList<>();
	final Connection conn = GetConnectDB.getConnect("localhost", "QuanLiTruongHoc", "admin", "admin");
	private DefaultTableModel dm;
	public QuanLiSinhVienUI() {
		addControls();
		addEvent();
	}

	public void addControls() {
		JPanel pnl = new JPanel();
		pnl.setLayout(new BoxLayout(pnl, BoxLayout.X_AXIS));
		JPanel pnlSinhVienInput = new JPanel();
		JPanel pnlSinhVienTable = new JPanel();

		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Nhập Thông Tin Sinh Viên");
		pnlSinhVienInput.setBorder(borderTitle);

		pnlSinhVienInput.setLayout(new BoxLayout(pnlSinhVienInput, BoxLayout.Y_AXIS));
		// Mã Sinh Viên
		JPanel maSv = new JPanel();
		JLabel lblMaSv = new JLabel("Nhập Mã Sinh Viên ");
		lblMaSv.setPreferredSize(new Dimension(150, 30));
		JTextField txtMaSv = new JTextField(15);
		maSv.add(lblMaSv);
		maSv.add(txtMaSv);
		pnlSinhVienInput.add(maSv);
		// Tên Sinh Viên
		JPanel tenSv = new JPanel();
		JLabel lblTenSv = new JLabel("Nhập tên Sinh Viên ");
		lblTenSv.setPreferredSize(new Dimension(150, 30));
		JTextField txtTenSv = new JTextField(15);
		tenSv.add(lblTenSv);
		tenSv.add(txtTenSv);
		pnlSinhVienInput.add(tenSv);
		// Địa Chỉ
		JPanel diaChi = new JPanel();
		JLabel lbldiaChi = new JLabel("Nhập Địa Chỉ Nhà ");
		lbldiaChi.setPreferredSize(new Dimension(150, 30));
		JTextField txtdiaChi = new JTextField(15);
		diaChi.add(lbldiaChi);
		diaChi.add(txtdiaChi);
		pnlSinhVienInput.add(diaChi);
		//
		JPanel dienThoai = new JPanel();
		JLabel lbldienThoai = new JLabel("Nhập Số Điện Thoại ");
		lbldienThoai.setPreferredSize(new Dimension(150, 30));
		JTextField txtdienThoai = new JTextField(15);
		dienThoai.add(lbldienThoai);
		dienThoai.add(txtdienThoai);
		pnlSinhVienInput.add(dienThoai);
		//
		JPanel email = new JPanel();
		JLabel lblemail = new JLabel("Nhập Số Email ");
		lblemail.setPreferredSize(new Dimension(150, 30));
		JTextField txtemail = new JTextField(15);
		email.add(lblemail);
		email.add(txtemail);
		pnlSinhVienInput.add(email);
		//
		JPanel thanhPho = new JPanel();
		JLabel lblThanhPho = new JLabel("Chọn Thành Phố ");
		selectProvince();
		cboThanhPho = new JComboBox();
		for(String x : arrProvince) {
			cboThanhPho.addItem(x);
		}
		cboThanhPho.setPreferredSize(new Dimension(170, 20));
		lblThanhPho.setPreferredSize(new Dimension(150, 50));
		thanhPho.add(lblThanhPho);
		thanhPho.add(cboThanhPho);
		pnlSinhVienInput.add(thanhPho);
		//
		JPanel quan = new JPanel();
		JLabel lblQuan = new JLabel("Chọn Quận ");
		cboQuan = new JComboBox();
		cboQuan.addItem("itemmmmmmmmmmm");
		cboQuan.setPreferredSize(new Dimension(170, 20));
		lblQuan.setPreferredSize(new Dimension(150, 50));
		quan.add(lblQuan);
		quan.add(cboQuan);
		pnlSinhVienInput.add(quan);
		//
		JPanel phuong = new JPanel();
		JLabel lblPhuong = new JLabel("Chọn Phường ");
		cboPhuong = new JComboBox();
		cboPhuong.addItem("itemmmmmmmmmmm");
		cboPhuong.setPreferredSize(new Dimension(170, 20));
		lblPhuong.setPreferredSize(new Dimension(150, 50));
		phuong.add(lblPhuong);
		phuong.add(cboPhuong);
		pnlSinhVienInput.add(phuong);
		//
		JPanel maLop = new JPanel();
		JLabel lblmaLop = new JLabel("Chọn Lớp ");
		JComboBox cbomaLop = new JComboBox();
		cbomaLop.addItem("itemmmmmmmmmmm");
		cbomaLop.setPreferredSize(new Dimension(170, 20));
		lblmaLop.setPreferredSize(new Dimension(150, 50));
		maLop.add(lblmaLop);
		maLop.add(cbomaLop);
		pnlSinhVienInput.add(maLop);
		//
		// button
		JPanel btn = new JPanel();
		btnThem = new JButton("Thêm");
		btnThem.setPreferredSize(new Dimension(70, 30));
		btn.add(btnThem);
		btnSua = new JButton("Sửa");
		btnSua.setPreferredSize(new Dimension(70, 30));
		btn.add(btnSua);
		btnXoa = new JButton("Xóa");
		btnXoa.setPreferredSize(new Dimension(70, 30));
		btn.add(btnXoa);
		btnThoat = new JButton("Thoát");
		btnThoat.setPreferredSize(new Dimension(70, 30));
		btn.add(btnThoat);
		pnlSinhVienInput.add(btn);

		// TABLE

		Border border1 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle1 = BorderFactory.createTitledBorder(border1, "Danh Sách Sinh Viên");
		pnlSinhVienTable.setBorder(borderTitle1);

		pnlSinhVienTable.setLayout(new BoxLayout(pnlSinhVienTable, BoxLayout.Y_AXIS));
		DefaultTableModel dm = new DefaultTableModel();
		dm.addColumn("Mã Sinh Viên");
		dm.addColumn("Họ Tên Sinh Viên");
		dm.addColumn("Địa chỉ nhà");
		dm.addColumn("Phường");
		dm.addColumn("Quận");
		dm.addColumn("Tỉnh/ Thành phố");
		dm.addColumn("Điện thoại");
		dm.addColumn("Email");
		JTable tbl = new JTable(dm);
		selectAll();
		for (int i = 0; i < arrQlSinhVien.size(); i++) {
			String row[] = { arrQlSinhVien.get(i).getMaSv(), arrQlSinhVien.get(i).getHoTenSv(),
					arrQlSinhVien.get(i).getDiaChiSv(), arrQlSinhVien.get(i).getXa(), arrQlSinhVien.get(i).getHuyen(),
					arrQlSinhVien.get(i).getTinh(), arrQlSinhVien.get(i).getDienThoaiSv(),
					arrQlSinhVien.get(i).getEmail() };
			dm.addRow(row);

		}
		// setColum
		TableColumnModel columnModel = tbl.getColumnModel();
		columnModel.getColumn(1).setPreferredWidth(110);
		tbl.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		//
		JScrollPane sc = new JScrollPane(tbl);
		pnlSinhVienTable.setLayout(new BorderLayout());
		pnlSinhVienTable.add(sc);

		//
		pnl.add(pnlSinhVienInput);
		pnl.add(pnlSinhVienTable);
		//
		this.setLayout(new BorderLayout());
		this.add(pnl);

	}

	public void addEvent() {
		btnThoat.addActionListener(eventThoat);

	}
	 
	
	
	ActionListener eventCbo = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	};
	
	
	ActionListener eventThoat = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
			
		}
	};
	ActionListener eventThem = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	};
	public void selectAll() {
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("select * from QLSinhVien");
			while (result.next()) {
				String maSv = result.getString("MaSv");
				String tenSv = result.getString("HoTenSv");
				String diaChiSv = result.getString("DiaChiSv");
				String xa = result.getString("Xa");
				String huyen = result.getString("Huyen");
				String tinh = result.getString("Tinh");
				String dienThoaiSv = result.getString("DienThoaiSv");
				String email = result.getString("Email");
				String maLop = result.getString("Malop");
				// System.out.println(maSv1);
				arrQlSinhVien.add(new QuanLiSinhVienModel(maSv, tenSv, diaChiSv, xa, huyen, tinh, dienThoaiSv, email, maLop));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public void selectProvince() {
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("select name from province");
			while (result.next()) {
				String name = result.getString("name");
				arrProvince.add(name);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	public void selectDistrict() {
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("select name from province inner join district on province.provinceid = district.provinceid ");
			while (result.next()) {
				String name = result.getString("name");
				arrDistrict.add(name);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
