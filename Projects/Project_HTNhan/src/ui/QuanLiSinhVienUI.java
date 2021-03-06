package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
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
import javax.swing.table.TableColumnModel;

import model.DistrictModel;
import model.DistrictSQL;
import model.ProvinceModel;
import model.QuanLiLopHocModel;
import model.QuanLiLopHocSQL;
import model.QuanLiSinhVienModel;
import model.QuanLiSinhVienSQL;
import model.ProvinceSQL;
import model.WardModel;
import model.WardSQL;

public class QuanLiSinhVienUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtMaSv, txtTenSv, txtdiaChi, txtdienThoai, txtemail;
	private String provinceId, districtId;
	@SuppressWarnings("rawtypes")
	public JComboBox cboThanhPho, cboQuan, cboPhuong, cbomaLop;
	private JButton btnThemMoi, btnThem, btnSua, btnXoa;
	private ArrayList<QuanLiSinhVienModel> arrQlSinhVien = new ArrayList<>();
	private ArrayList<ProvinceModel> arrProvince = new ArrayList<>();
	private ArrayList<DistrictModel> arrDistrict = new ArrayList<>();
	private ArrayList<WardModel> arrWard = new ArrayList<>();
	private ArrayList <QuanLiLopHocModel> arrMaLop = new ArrayList<>();
	private DefaultTableModel dm;
	private String maSv, tenSv, diachiSv, sodienthoaiSv, emailSv, thanhPho, quan, phuong, malopSv;
	private JTable tbl;
	private QuanLiSinhVienSQL quanLiSinhVienSQL = new QuanLiSinhVienSQL();
	private QuanLiLopHocSQL quanLiLopHocSQL = new QuanLiLopHocSQL();
	private ProvinceSQL provinceSQL = new ProvinceSQL();
	private DistrictSQL districtSQL = new DistrictSQL();
	private WardSQL wardSQL = new WardSQL();

	public QuanLiSinhVienUI() {
		addControls();
		addEvent();
		comboBox();
		cboLop();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void addControls() {
		JPanel pnl = new JPanel();
		pnl.setLayout(new BoxLayout(pnl, BoxLayout.X_AXIS));
		JPanel pnlSinhVienInput = new JPanel();
		JPanel pnlSinhVienTable = new JPanel();

		Border border = BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Nhập Thông Tin Sinh Viên");
		pnlSinhVienInput.setBorder(borderTitle);

		pnlSinhVienInput.setLayout(new BoxLayout(pnlSinhVienInput, BoxLayout.Y_AXIS));
		// Mã Sinh Viên
		JPanel maSv = new JPanel();
		JLabel lblMaSv = new JLabel("Nhập Mã Sinh Viên ");
		lblMaSv.setPreferredSize(new Dimension(150, 30));
		txtMaSv = new JTextField(20);
		maSv.add(lblMaSv);
		maSv.add(txtMaSv);
		pnlSinhVienInput.add(maSv);
		// Tên Sinh Viên
		JPanel tenSv = new JPanel();
		JLabel lblTenSv = new JLabel("Nhập tên Sinh Viên ");
		lblTenSv.setPreferredSize(new Dimension(150, 30));
		txtTenSv = new JTextField(20);
		tenSv.add(lblTenSv);
		tenSv.add(txtTenSv);
		pnlSinhVienInput.add(tenSv);
		// Địa Chỉ
		JPanel diaChi = new JPanel();
		JLabel lbldiaChi = new JLabel("Nhập Địa Chỉ Nhà ");
		lbldiaChi.setPreferredSize(new Dimension(150, 30));
		txtdiaChi = new JTextField(20);
		diaChi.add(lbldiaChi);
		diaChi.add(txtdiaChi);
		pnlSinhVienInput.add(diaChi);
		//
		JPanel dienThoai = new JPanel();
		JLabel lbldienThoai = new JLabel("Nhập Số Điện Thoại ");
		lbldienThoai.setPreferredSize(new Dimension(150, 30));
		txtdienThoai = new JTextField(20);
		dienThoai.add(lbldienThoai);
		dienThoai.add(txtdienThoai);
		pnlSinhVienInput.add(dienThoai);
		//
		JPanel email = new JPanel();
		JLabel lblemail = new JLabel("Nhập Số Email ");
		lblemail.setPreferredSize(new Dimension(150, 30));
		txtemail = new JTextField(20);
		email.add(lblemail);
		email.add(txtemail);
		pnlSinhVienInput.add(email);
		//
		JPanel thanhPho = new JPanel();
		JLabel lblThanhPho = new JLabel("Chọn Thành Phố ");
		cboThanhPho = new JComboBox();
		cboThanhPho.setPreferredSize(new Dimension(170, 20));
		cboThanhPho.addItem(new ProvinceModel(null, "Chọn Tỉnh/Thành Phố"));
		provinceSQL.selectProvince();
		arrProvince = provinceSQL.selectProvince();
		for (ProvinceModel x : arrProvince) {
			cboThanhPho.addItem(x);
		}
		lblThanhPho.setPreferredSize(new Dimension(150, 50));
		thanhPho.add(lblThanhPho);
		thanhPho.add(cboThanhPho);
		pnlSinhVienInput.add(thanhPho);
		//
		JPanel quan = new JPanel();
		JLabel lblQuan = new JLabel("Chọn Quận ");
		cboQuan = new JComboBox();
		cboQuan.addItem("Chọn Quận/Huyện");
		cboQuan.setPreferredSize(new Dimension(170, 20));
		lblQuan.setPreferredSize(new Dimension(150, 50));
		quan.add(lblQuan);
		quan.add(cboQuan);
		pnlSinhVienInput.add(quan);
		//
		JPanel phuong = new JPanel();
		JLabel lblPhuong = new JLabel("Chọn Phường ");
		cboPhuong = new JComboBox();
		cboPhuong.addItem("Chọn Phường/Xã");
		cboPhuong.setPreferredSize(new Dimension(170, 20));
		lblPhuong.setPreferredSize(new Dimension(150, 50));
		phuong.add(lblPhuong);
		phuong.add(cboPhuong);
		pnlSinhVienInput.add(phuong);
		//
		JPanel maLop = new JPanel();
		JLabel lblmaLop = new JLabel("Chọn Lớp ");
		cbomaLop = new JComboBox();

		
		cbomaLop.setPreferredSize(new Dimension(170, 20));
		lblmaLop.setPreferredSize(new Dimension(150, 50));
		maLop.add(lblmaLop);
		maLop.add(cbomaLop);
		pnlSinhVienInput.add(maLop);
		//
		// button
		JPanel btn = new JPanel();

		btnThem = new JButton("Thêm");
		btnThem.setBackground(Color.GRAY);
		btnThem.setPreferredSize(new Dimension(70, 30));
		btn.add(btnThem);
		btnSua = new JButton("Sửa");
		btnSua.setBackground(Color.GRAY);
		btnSua.setPreferredSize(new Dimension(70, 30));
		btn.add(btnSua);
		btnXoa = new JButton("Xóa");
		btnXoa.setBackground(Color.GRAY);
		btnXoa.setPreferredSize(new Dimension(70, 30));
		btn.add(btnXoa);
		btnThemMoi = new JButton("Hủy");
		btnThemMoi.setBackground(Color.GRAY);
		btnThemMoi.setPreferredSize(new Dimension(95, 30));
		btn.add(btnThemMoi);
		pnlSinhVienInput.add(btn);

		// TABLE

		Border border1 = BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder borderTitle1 = BorderFactory.createTitledBorder(border1, "Danh Sách Sinh Viên");
		pnlSinhVienTable.setBorder(borderTitle1);

		pnlSinhVienTable.setLayout(new BoxLayout(pnlSinhVienTable, BoxLayout.Y_AXIS));
		dm = new DefaultTableModel();
		dm.addColumn("Mã Sinh Viên");
		dm.addColumn("Họ Tên Sinh Viên");
		dm.addColumn("Địa chỉ nhà");
		dm.addColumn("Phường");
		dm.addColumn("Quận");
		dm.addColumn("Tỉnh/ Thành phố");
		dm.addColumn("Điện thoại");
		dm.addColumn("Email");
		tbl = new JTable(dm);

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

		tbl.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					//
					//
					txtMaSv.setEditable(false);
					btnThem.setEnabled(false);
					int row = tbl.getSelectedRow();
					String value = tbl.getValueAt(row, 0).toString();
					for (QuanLiSinhVienModel x : arrQlSinhVien) {
						if (value.equals(x.getMaSv())) {
							txtMaSv.setText(x.getMaSv());
							txtTenSv.setText(x.getHoTenSv());
							txtdiaChi.setText(x.getDiaChiSv());
							txtdienThoai.setText(x.getDienThoaiSv());
							txtemail.setText(x.getEmail());
							cbomaLop.setSelectedItem(x.getMaLop());
							String tinh = x.getTinh();
							String huyen = x.getHuyen();
							String xa = x.getXa();
							for (ProvinceModel y : arrProvince) {
								if (tinh.equals(y.getName())) {
									cboThanhPho.setSelectedItem(y);
								}
							}
							for (DistrictModel y : arrDistrict) {
								if (huyen.equals(y.getName())) {
									cboQuan.setSelectedItem(y);
								}
							}
							for (WardModel y : arrWard) {
								if (xa.equals(y.getName())) {
									cboPhuong.setSelectedItem(y);
								}
							}
						}
					}
				} catch (Exception ex) {

				}
			}
		});

	}

	public void addEvent() {
		cboThanhPho.addActionListener(eventCboThanhPho);
		cboQuan.addActionListener(eventCboQuan);
		btnThemMoi.addActionListener(eventThemMoi);
		btnThem.addActionListener(eventThem);
		btnSua.addActionListener(eventSua);
		btnXoa.addActionListener(eventXoa);
		cbomaLop.addActionListener(eventCboMaLop);
	}

	ActionListener eventCboThanhPho = new ActionListener() {

		@SuppressWarnings("unchecked")
		@Override
		public void actionPerformed(ActionEvent e) {
			try {

				// lấy tên và id tỉnh/tp của combobox
				ProvinceModel item = (ProvinceModel) cboThanhPho.getSelectedItem();
				provinceId = item.getProvinceid();
				arrDistrict = districtSQL.selectDistrict(provinceId);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
			cboQuan.removeAllItems();
			cboQuan.addItem(new DistrictModel(null, "Chọn Quận/Huyện"));
			for (DistrictModel x : arrDistrict) {
				cboQuan.addItem(x);
			}
		}
	};

	ActionListener eventCboQuan = new ActionListener() {

		@SuppressWarnings("unchecked")
		@Override
		public void actionPerformed(ActionEvent e) {
			cboPhuong.removeAllItems();
			cboQuan.addItem(new DistrictModel(null, "Chọn Quận/Huyện"));
			for (DistrictModel x : arrDistrict) {
				cboQuan.addItem(x);
			}
			try {
				// lấy tên và id Quận/Huyện của combobox
				DistrictModel item =  (DistrictModel) cboQuan.getSelectedItem();
				districtId = item.getDistrictid();
				arrWard = wardSQL.selectWard(districtId);
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			cboPhuong.addItem("Chọn Phường/Xã");
			for (WardModel x : arrWard) {
				cboPhuong.addItem(x);
			}
		}
	};

	ActionListener eventThemMoi = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			txtMaSv.setEditable(true);
			txtMaSv.setText("");
			txtTenSv.setText("");
			txtdiaChi.setText("");
			txtdienThoai.setText("");
			txtemail.setText("");
			cboThanhPho.setSelectedIndex(0);
			cbomaLop.setSelectedItem("");
			btnThem.setEnabled(true);
		}
	};
	ActionListener eventThem = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (txtMaSv.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Bạn Phải Nhập Mã Sinh Viên !!!");
			} else if (txtTenSv.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Bạn Phải Nhập Tên Sinh Viên !!!");
			} else if (txtdiaChi.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Bạn Phải Nhập Địa Chỉ Sinh Viên !!!");
			} else if (txtdienThoai.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Bạn Phải Nhập SDT Sinh Viên !!!");
			} else if (!(Pattern.matches("^\\+?[0-9. ()-]{10,25}$", txtdienThoai.getText()))) {
				JOptionPane.showMessageDialog(null, "Bạn Phải Nhập Đúng Định Dạng SDT");
			} else if (txtemail.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Bạn Phải Nhập Email Sinh Viên !!!");
			} else if (!(Pattern.matches("^[a-zA-Z0-9]+[@]{1}+[a-zA-Z0-9]+[.]{1}+[a-zA-Z0-9]+$", txtemail.getText()))) {
				JOptionPane.showMessageDialog(null, "Bạn Phải Nhập Đúng Định Dạng Email");
			} else if (cboThanhPho.getSelectedItem().toString().equals("Chọn Tỉnh/Thành Phố")) {
				JOptionPane.showMessageDialog(null, "Bạn Phải Chọn Tỉnh/Thành Phố !!!");
			} else if (cboQuan.getSelectedItem().toString().equals("Chọn Quận/Huyện")) {
				JOptionPane.showMessageDialog(null, "Bạn Phải Chọn Quận/Huyện !!!");
			} else if (cboPhuong.getSelectedItem().toString().equals("Chọn Phường/Xã")) {
				JOptionPane.showMessageDialog(null, "Bạn Phải Chọn Phường/Xã !!!");
			} else if (cbomaLop.getSelectedItem().toString().equals("")) {
				JOptionPane.showMessageDialog(null, "Bạn Phải Chọn Lớp !!!");
			} else {
				if (them()) {
					txtMaSv.setText("");
					txtTenSv.setText("");
					txtdiaChi.setText("");
					txtdienThoai.setText("");
					txtemail.setText("");
					cboThanhPho.setSelectedIndex(0);
					cbomaLop.setSelectedItem("");
				}
			}

		}
	};
	ActionListener eventSua = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (txtMaSv.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn sinh viên cần sửa!");
			} else {
				sua();
				txtMaSv.setEditable(true);
				txtMaSv.setText("");
				txtTenSv.setText("");
				txtdiaChi.setText("");
				txtdienThoai.setText("");
				txtemail.setText("");
				cboThanhPho.setSelectedIndex(0);
				cbomaLop.setSelectedItem("");
			}
		}
	};
	ActionListener eventCboMaLop = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			dm.setRowCount(0);
			comboBox();
		}
	};
	ActionListener eventXoa = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (txtMaSv.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn sinh viên cần Xóa!");
			} else {
				int ret = JOptionPane.showConfirmDialog(null, "Bạn có muốn Xóa?", "Xóa Sinh Viên",
						JOptionPane.YES_NO_OPTION);
				if (ret == JOptionPane.YES_OPTION) {
					xoa();
					txtMaSv.setEditable(true);
					txtMaSv.setText("");
					txtTenSv.setText("");
					txtdiaChi.setText("");
					txtdienThoai.setText("");
					txtemail.setText("");
					cboThanhPho.setSelectedIndex(0);
					cbomaLop.setSelectedItem("");
				}

			}
		}
	};

	public boolean them() {
		int ktMaSv = 0;
		maSv = txtMaSv.getText();
		tenSv = txtTenSv.getText();
		diachiSv = txtdiaChi.getText();
		sodienthoaiSv = txtdienThoai.getText();
		emailSv = txtemail.getText();
		thanhPho = cboThanhPho.getSelectedItem().toString();
		quan = cboQuan.getSelectedItem().toString();
		phuong = cboPhuong.getSelectedItem().toString();
		malopSv = cbomaLop.getSelectedItem().toString();
		// kiểm tra mã sinh viên tồn tại hay k
		for (QuanLiSinhVienModel x : arrQlSinhVien) {
			if (maSv.equals(x.getMaSv())) {
				ktMaSv = 1;
			}
		}
		if (ktMaSv > 0) {
			JOptionPane.showMessageDialog(null, "Sinh Viên Đã Tồn Tại !!");
			return false;
		} else {
			quanLiSinhVienSQL.insert(maSv, tenSv, diachiSv, phuong, quan, thanhPho, sodienthoaiSv, emailSv, malopSv);

			//
			dm.setRowCount(0);
			for (QuanLiSinhVienModel x : arrQlSinhVien) {
				String row[] = { x.getMaSv(), x.getHoTenSv(), x.getDiaChiSv(), x.getXa(), x.getHuyen(), x.getTinh(),
						x.getDienThoaiSv(), x.getEmail(), x.getMaLop() };
				dm.addRow(row);
			}
		}
		return true;
	}

	public void sua() {
		maSv = txtMaSv.getText();
		tenSv = txtTenSv.getText();
		diachiSv = txtdiaChi.getText();
		sodienthoaiSv = txtdienThoai.getText();
		emailSv = txtemail.getText();
		thanhPho = cboThanhPho.getSelectedItem().toString();
		quan = cboQuan.getSelectedItem().toString();
		phuong = cboPhuong.getSelectedItem().toString();
		malopSv = cbomaLop.getSelectedItem().toString();
		//
		quanLiSinhVienSQL.update(maSv, tenSv, diachiSv, phuong, quan, thanhPho, sodienthoaiSv, emailSv, malopSv);
		//
		dm.setRowCount(0);
		for (QuanLiSinhVienModel x : arrQlSinhVien) {
			String row[] = { x.getMaSv(), x.getHoTenSv(), x.getDiaChiSv(), x.getXa(), x.getHuyen(), x.getTinh(),
					x.getDienThoaiSv(), x.getEmail(), x.getMaLop() };
			dm.addRow(row);
		}
	}

	public void xoa() {
		maSv = txtMaSv.getText();
		quanLiSinhVienSQL.delete(maSv);
		dm.setRowCount(0);
		for (QuanLiSinhVienModel x : arrQlSinhVien) {
			String row[] = { x.getMaSv(), x.getHoTenSv(), x.getDiaChiSv(), x.getXa(), x.getHuyen(), x.getTinh(),
					x.getDienThoaiSv(), x.getEmail(), x.getMaLop() };
			dm.addRow(row);
		}
	}

	public void comboBox() {
		arrQlSinhVien = quanLiSinhVienSQL.selectAll();
		Object maLop = cbomaLop.getSelectedItem();
		if(maLop !=null) {
			String comBox = cbomaLop.getSelectedItem().toString();
			if (comBox == "") {
				for (QuanLiSinhVienModel x : arrQlSinhVien) {
					String row[] = { x.getMaSv(), x.getHoTenSv(), x.getDiaChiSv(), x.getXa(), x.getHuyen(), x.getTinh(),
							x.getDienThoaiSv(), x.getEmail(), x.getMaLop() };
					dm.addRow(row);
				}
			} else {
				for (QuanLiSinhVienModel x : arrQlSinhVien) {
					if (comBox.equals(x.getMaLop())) {
						String row[] = { x.getMaSv(), x.getHoTenSv(), x.getDiaChiSv(), x.getXa(), x.getHuyen(), x.getTinh(),
								x.getDienThoaiSv(), x.getEmail(), x.getMaLop() };
						dm.addRow(row);
					}
				}

			}
		}
	}
	@SuppressWarnings("unchecked")
	public void cboLop() {
		cbomaLop.removeAllItems();
		cbomaLop.addItem("");
		quanLiLopHocSQL.selectLop();
		arrMaLop = quanLiLopHocSQL.selectLop();
		for (QuanLiLopHocModel x : arrMaLop) {
			cbomaLop.addItem(x.getMaLop());
		}
	}

}
