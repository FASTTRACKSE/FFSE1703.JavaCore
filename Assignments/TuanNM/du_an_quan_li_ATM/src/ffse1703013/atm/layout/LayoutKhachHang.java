package ffse1703013.atm.layout;

import ffse1703013.atm.model.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import ffse1703013.atm.model.ComboItem;
import ffse1703013.atm.model.DatabaseDiaChi;

@SuppressWarnings("serial")
public class LayoutKhachHang extends JPanel {
	private ArrayList<ComboItem> arrPhuong = new ArrayList<>();
	private ArrayList<ComboItem> arrPhuong1 = new ArrayList<>();
	private static ArrayList<KhachHang> arrKH = new ArrayList<KhachHang>();
	private JLabel naneTK;

	@SuppressWarnings("rawtypes")
	private JComboBox cboQuan, cboQuan1, cboPhuong, cboPhuong1, cboTimKiem;
	private JTextField txtMaKH, txtTenKH, txtDiaChi, txtPhone, txtEmail, txtSoThe, txtTK, txtSoDu, txtMaPin;
	private PlaceholderTextField txtTimKiemTen, txtTimKiemMa;
	private JButton buttonThem, buttonSua, buttonXoa, buttonHuy;
	private JButton buttonTimKiemMa;
	private DefaultTableModel model;
	private DatabaseKhachHang connectKH = new DatabaseKhachHang();
	private JTable tblKhachHang;
	private static int stt = 0;

	public LayoutKhachHang() {
		addControl();
		addEvents();
		duLieu();
		selectPhuongTK();
	}

	void duLieu() {

		arrKH = connectKH.selectKhachHang();
		model.setRowCount(0);
		for (KhachHang kh : arrKH) {

			String[] row = { kh.getMaKH(), kh.getTenKH(), kh.getDiaChiNha() + "," + kh.getPhuong() + "," + kh.getQuan(),
					kh.getEmail(), kh.getSoThe() };
			model.addRow(row);
		}
	}

	public void addEvents() {
		cboQuan.addActionListener(chonPhuong);
		cboQuan1.addActionListener(tkTheoQuan);
		buttonThem.addActionListener(themKhachHang);
		buttonHuy.addActionListener(reFfresh);
		tblKhachHang.getSelectionModel().addListSelectionListener(chonHang);
		buttonSua.addActionListener(editKhachHang);
		buttonXoa.addActionListener(xoaKhachHang);
		txtTimKiemTen.getDocument().addDocumentListener(timKiemten);
		txtTimKiemMa.getDocument().addDocumentListener(timKiemMa);
		cboPhuong1.addActionListener(tkTheoPhuong);

	}

	ListSelectionListener chonHang = new ListSelectionListener() {

		@Override
		public void valueChanged(ListSelectionEvent e) {

			int i = tblKhachHang.getSelectedRow();

			if (i >= 0 && !e.getValueIsAdjusting()) {
				String ma = tblKhachHang.getValueAt(i, 0).toString();
				setTextToInput(ma);

				buttonThem.setEnabled(false);

				for (int j = 0; j < arrKH.size(); j++) {
					if (ma.equals(arrKH.get(i).getMaKH())) {
						stt = i;
					}
				}
			}

		}
	};

	@SuppressWarnings("unchecked")
	public void selectPhuong() {
		arrPhuong.clear();
		int itemCount = cboPhuong.getItemCount();

		for (int i = 0; i < itemCount; i++) {
			cboPhuong.removeItemAt(0);
		}
		ComboItem itemD = (ComboItem) cboQuan.getSelectedItem();
		int id = itemD.getId();
		arrPhuong = DatabaseDiaChi.getPhuonng(id);

		for (ComboItem x : arrPhuong) {
			cboPhuong.addItem(x);
		}
	}

	// tạo danh sách chọn phường
	ActionListener chonPhuong = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			selectPhuong();
		}
	};

	@SuppressWarnings("unchecked")
	public void selectPhuongTK() {
		try {
			String quan = cboQuan1.getSelectedItem().toString();
			arrPhuong1.clear();
			int itemCount = cboPhuong1.getItemCount();

			for (int i = 0; i < itemCount; i++) {
				cboPhuong1.removeItemAt(0);
			}
			ComboItem itemD = (ComboItem) cboQuan1.getSelectedItem();
			int id = itemD.getId();
			arrPhuong1 = DatabaseDiaChi.getPhuonng(id);

			for (ComboItem x : arrPhuong1) {
				cboPhuong1.addItem(x);
			}
			if (quan.equals("Tất cả")) {
				model.setRowCount(0);
				arrKH.clear();
				duLieu();
			}
		} catch (Exception ex) {

		}
	}

	ActionListener tkTheoQuan = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String tenQuan = cboQuan1.getSelectedItem().toString();

			// đưa dữ liệu vào combobox phường tìm kiếm
			selectPhuongTK();
			// tìm kiếm theo quận
			model.setRowCount(0);
			if (tenQuan.equals("Tất cả")) {
				arrKH.clear();
				duLieu();
			} else {
				for (KhachHang kh : arrKH) {
					if (tenQuan.equals(kh.getQuan())) {
						String[] row = { kh.getMaKH(), kh.getTenKH(),
								kh.getDiaChiNha() + "," + kh.getPhuong() + "," + kh.getQuan(), kh.getEmail(),
								kh.getSoThe() };
						model.addRow(row);
					}

				}
			}
		}
	};
	ActionListener tkTheoPhuong = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				String phuong = cboPhuong1.getSelectedItem().toString();
				model.setRowCount(0);
				for (KhachHang kh : arrKH) {
					if (phuong.equals(kh.getPhuong())) {
						String[] row = { kh.getMaKH(), kh.getTenKH(),
								kh.getDiaChiNha() + "," + kh.getPhuong() + "," + kh.getQuan(), kh.getEmail(),
								kh.getSoThe() };
						model.addRow(row);
					}

				}
			} catch (Exception ex) {

			}
		}
	};

	ActionListener reFfresh = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			txtMaKH.setText("");
			txtTenKH.setText("");
			txtDiaChi.setText("");
			txtPhone.setText("");
			txtEmail.setText("");
			txtSoThe.setText("");
			txtTK.setText("");
			txtSoDu.setText("");
			txtMaPin.setText("");

			txtSoThe.setEditable(true);
			txtMaKH.setEditable(true);
			txtTK.setEditable(true);
			buttonThem.setEnabled(true);
			buttonSua.setEnabled(false);
			buttonXoa.setEnabled(false);
		}
	};
	ActionListener themKhachHang = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			try {
				int ktTonTaiMa = 0;
				int ktTonTaiSoThe = 0;
				@SuppressWarnings("unused")
				int ktTonTaiSoTk = 0;
				int ktSoThe = 0;
				int ktSoTK = 0;
				int ktSoTien = 0;
				String maKH = txtMaKH.getText();
				String tenKH = txtTenKH.getText();
				String diaChiNha = txtDiaChi.getText();
				String quan = cboQuan.getSelectedItem().toString();
				String phuong = cboPhuong.getSelectedItem().toString();
				String dienThoai = txtPhone.getText();
				String email = txtEmail.getText();
				String soThe = txtSoThe.getText();
				String soTK = txtTK.getText();
				String soDu = txtSoDu.getText();
				String maPin = txtMaPin.getText();

				// bắt lôi cho các ô input
				int countMa = maKH.length();
				int countSoThe = soThe.length();
				int countSoTk = soTK.length();
				int countSoDu = 0;
				if (!soDu.isEmpty()) {
					countSoDu = Integer.parseInt(soDu);
				}
				// kiểm tra tồn tai mã ,số the ,số tk
				for (int i = 0; i < arrKH.size(); i++) {
					if (maKH.equals(arrKH.get(i).getMaKH())) {
						ktTonTaiMa = 1;
					}
					if (soThe.equals(arrKH.get(i).getSoThe())) {
						ktTonTaiSoThe = 1;
					}
					if (soTK.equals(arrKH.get(i).getSoTK())) {
						ktTonTaiSoTk = 1;
					}
				}
				// kiểm tra ko đc nhập số cho số thẻ
				try {
					@SuppressWarnings("unused")
					Double soTheATM = Double.parseDouble(soThe);
				} catch (Exception ex) {
					ktSoThe = 1;
				}
				// kiểm tra ko đc nhập số cho số tài khoản
				try {
					@SuppressWarnings("unused")
					double soTKATM = Double.parseDouble(soTK);
				} catch (Exception ex) {
					ktSoTK = 1;
				}
				// kiểm tra ko đc nhập số cho số tiền
				try {
					@SuppressWarnings("unused")
					int soTienATM = Integer.parseInt(soDu);
				} catch (Exception ex) {
					ktSoTien = 1;
				}

				try {
					if (tenKH.isEmpty() || maKH.isEmpty() || diaChiNha.isEmpty() || dienThoai.isEmpty()
							|| email.isEmpty() || soThe.isEmpty() || soTK.isEmpty() || soDu.isEmpty()
							|| maPin.isEmpty()) {
						String msg = "Vui lòng nhập đầy đủ thông tin";
						JOptionPane.showMessageDialog(null, msg, "Lỗi Nhập Thiếu", JOptionPane.INFORMATION_MESSAGE);
					} else if (countMa != 6) {
						String msg = " Mã Khách Hàng Phải 6 kí tự!!";
						JOptionPane.showMessageDialog(null, msg, "Lỗi nhập", JOptionPane.INFORMATION_MESSAGE);
					} else if (!(Pattern.matches("^\\+?[0-9. ()-]{10,12}$", dienThoai))) {
						JOptionPane.showMessageDialog(null, "Số điện thoại không đúng");
					} else if (countSoThe != 12) {
						String msg = " Số thẻ 12 số!!";
						JOptionPane.showMessageDialog(null, msg, "Lỗi nhập", JOptionPane.INFORMATION_MESSAGE);
					} else if (ktSoThe > 0) {
						String msg = " Số thẻ không được nhập kí tự";
						JOptionPane.showMessageDialog(null, msg, "Lỗi nhập", JOptionPane.INFORMATION_MESSAGE);
					} else if (countSoTk != 14) {
						String msg = " Số tài khoản 14 số!!";
						JOptionPane.showMessageDialog(null, msg, "Lỗi nhập", JOptionPane.INFORMATION_MESSAGE);

					} else if (ktSoTK > 0) {
						String msg = " Số tài khoản không được nhập kí tự";
						JOptionPane.showMessageDialog(null, msg, "Lỗi nhập", JOptionPane.INFORMATION_MESSAGE);
					} else if (ktSoTien > 0) {
						String msg = " Số tiền không được nhập kí tự";
						JOptionPane.showMessageDialog(null, msg, "Lỗi nhập", JOptionPane.INFORMATION_MESSAGE);
					} else if (countSoDu < 10000) {
						String msg = " Số dư ít nhất 10.000đ";
						JOptionPane.showMessageDialog(null, msg, "Lỗi nhập", JOptionPane.INFORMATION_MESSAGE);
					} else if (!(Pattern.matches("^[a-zA-Z0-9]+[@]{1}+[a-zA-Z0-9]+[.]{1}+[a-zA-Z0-9]+$", email))) {
						String msg = " Địa chỉ emai ko hợp lệ!!";
						JOptionPane.showMessageDialog(null, msg, "Lỗi nhập", JOptionPane.INFORMATION_MESSAGE);
					} else if (ktTonTaiMa > 0) {
						String msg = " Mã Khách Hàng đã tồn tạ !!";
						JOptionPane.showMessageDialog(null, msg, "Lỗi nhập", JOptionPane.INFORMATION_MESSAGE);

					} else if (ktTonTaiSoThe > 0) {
						String msg = "Số thẻ ATM đã tồn tạ !!";
						JOptionPane.showMessageDialog(null, msg, "Lỗi nhập", JOptionPane.INFORMATION_MESSAGE);

					} else if (ktTonTaiMa > 0) {
						String msg = "Số Tài khaonr ngân hàng đã tồn tạ !!";
						JOptionPane.showMessageDialog(null, msg, "Lỗi nhập", JOptionPane.INFORMATION_MESSAGE);

					} else {
						connectKH.insertKhachHang(maKH, tenKH, diaChiNha, phuong, quan, dienThoai, email, soThe, soTK,
								soDu, maPin);
						arrKH.add(new KhachHang(maKH, tenKH, diaChiNha, phuong, quan, dienThoai, email, soThe, soTK,
								soDu, maPin));

						for (int i = (arrKH.size() - 1); i < arrKH.size(); i++) {

							String[] row = { arrKH.get(i).getMaKH(), arrKH.get(i).getTenKH(),
									arrKH.get(i).getDiaChiNha() + "," + arrKH.get(i).getPhuong() + ","
											+ arrKH.get(i).getQuan(),
									arrKH.get(i).getEmail(), arrKH.get(i).getSoThe(), };
							model.addRow(row);
						}

						txtMaKH.setText("");
						txtTenKH.setText("");
						txtDiaChi.setText("");
						txtPhone.setText("");
						txtEmail.setText("");
						txtSoThe.setText("");
						txtTK.setText("");
						txtSoDu.setText("");
						txtMaPin.setText("");
					}

				} catch (Exception ex) {
					String msg = "Khách Hàng đã tồn tạ !!";
					JOptionPane.showMessageDialog(null, msg, "Lỗi nhập", JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (Exception ex) {

			}

		}

	};
	ActionListener editKhachHang = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				int ktSoThe = 0;
				int ktSoTK = 0;
				int ktSoTien = 0;

				String maKH = txtMaKH.getText();
				String tenKH = txtTenKH.getText();
				String diaChiNha = txtDiaChi.getText();
				String quan = cboQuan.getSelectedItem().toString();
				String phuong = cboPhuong.getSelectedItem().toString();
				String dienThoai = txtPhone.getText();
				String email = txtEmail.getText();
				String soThe = txtSoThe.getText();
				String soTK = txtTK.getText();
				String soDu = txtSoDu.getText();
				String maPin = txtMaPin.getText();
				// bắt lôi cho các ô input
				int countMa = maKH.length();
				int countSoThe = soThe.length();
				int countSoTk = soTK.length();
				int countSoDu = 0;

				// kiểm tra ko đc nhập số cho số tài khoản
				try {
					@SuppressWarnings("unused")
					double soTKATM = Double.parseDouble(soTK.trim());
				} catch (Exception ex) {
					ktSoTK = 1;
				}
				// kiểm tra ko đc nhập số cho số thẻ
				try {
					@SuppressWarnings("unused")
					Double soTheATM = Double.parseDouble(soThe.trim());
				} catch (Exception ex) {
					ktSoThe = 1;
				}

				// kiểm tra ko đc nhập số cho số tiền
				try {
					if (!soDu.isEmpty()) {
						countSoDu = Integer.parseInt(soDu);
					}
				} catch (Exception ex) {
					ktSoTien = 1;
				}

				try {
					if (maKH.isEmpty()) {
						String msg = "Bạn chưa chọn khách hàng";
						JOptionPane.showMessageDialog(null, msg, "Lỗi Nhập Thiếu", JOptionPane.INFORMATION_MESSAGE);

					} else if (tenKH.isEmpty() || diaChiNha.isEmpty() || dienThoai.isEmpty() || email.isEmpty()
							|| soThe.isEmpty() || soTK.isEmpty() || soDu.isEmpty() || maPin.isEmpty()) {
						String msg = "Vui lòng nhập đầy đủ thông tin";
						JOptionPane.showMessageDialog(null, msg, "Lỗi Nhập Thiếu", JOptionPane.INFORMATION_MESSAGE);

					} else if (countMa != 6) {
						String msg = " Mã Khách Hàng Phải 6 kí tự!!";
						JOptionPane.showMessageDialog(null, msg, "Lỗi nhập", JOptionPane.INFORMATION_MESSAGE);
					} else if (!(Pattern.matches("^\\+?[0-9. ()-]{10,12}$", dienThoai))) {
						JOptionPane.showMessageDialog(null, "Số điện thoại không đúng");
					} else if (countSoThe != 12) {
						String msg = " Số thẻ 12 số!!";
						JOptionPane.showMessageDialog(null, msg, "Lỗi nhập", JOptionPane.INFORMATION_MESSAGE);
					} else if (ktSoThe > 0) {
						String msg = " Số thẻ không được nhập kí tự";
						JOptionPane.showMessageDialog(null, msg, "Lỗi nhập", JOptionPane.INFORMATION_MESSAGE);
					} else if (countSoTk != 14) {
						String msg = " Số tài khoản 14 số!!";
						JOptionPane.showMessageDialog(null, msg, "Lỗi nhập", JOptionPane.INFORMATION_MESSAGE);

					} else if (ktSoTK > 0) {
						String msg = " Số tài khoản không được nhập kí tự";
						JOptionPane.showMessageDialog(null, msg, "Lỗi nhập", JOptionPane.INFORMATION_MESSAGE);
					} else if (ktSoTien > 0) {
						String msg = " Số tiền không được nhập kí tự";
						JOptionPane.showMessageDialog(null, msg, "Lỗi nhập", JOptionPane.INFORMATION_MESSAGE);
					} else if (countSoDu < 10000) {
						String msg = " Số dư ít nhất 10.000đ";
						JOptionPane.showMessageDialog(null, msg, "Lỗi nhập", JOptionPane.INFORMATION_MESSAGE);
					} else if (!(Pattern.matches("^[a-zA-Z0-9]+[@]{1}+[a-zA-Z0-9]+[.]{1}+[a-zA-Z0-9]+$", email))) {
						String msg = " Địa chỉ emai ko hợp lệ!!";
						JOptionPane.showMessageDialog(null, msg, "Lỗi nhập", JOptionPane.INFORMATION_MESSAGE);
					} else {
						// model.setRowCount(0);

						arrKH.get(stt).setMaKH(maKH);
						arrKH.get(stt).setTenKH(tenKH);
						arrKH.get(stt).setDiaChiNha(diaChiNha);
						arrKH.get(stt).setPhuong(phuong);
						arrKH.get(stt).setQuan(quan);
						arrKH.get(stt).setDienThoai(dienThoai);
						arrKH.get(stt).setEmail(email);
						arrKH.get(stt).setSoThe(soThe);
						arrKH.get(stt).setSoTK(soTK);
						connectKH.updateKhachHang(tenKH, diaChiNha, phuong, quan, dienThoai, email, soTK, maKH, soDu,
								maPin);

						model.setRowCount(0);
						arrKH.clear();

						duLieu();
						txtMaKH.setText("");
						txtTenKH.setText("");
						txtDiaChi.setText("");
						txtPhone.setText("");
						txtEmail.setText("");
						txtSoThe.setText("");
						txtTK.setText("");
						txtSoDu.setText("");
						txtMaPin.setText("");

					}

				} catch (Exception es) {
					String msg = "Chưa chọn khách hàng cần sửa ";
					JOptionPane.showMessageDialog(null, msg, "Sửa Thành Công", JOptionPane.INFORMATION_MESSAGE);
				}

			} catch (Exception ex) {

			}
		}
	};
	private DocumentListener timKiemten = new DocumentListener() {

		@Override
		public void changedUpdate(DocumentEvent e) {
			model.setRowCount(0);
			searchTheoTen();
		}

		@Override
		public void insertUpdate(DocumentEvent e) {
			model.setRowCount(0);
			searchTheoTen();
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			model.setRowCount(0);
			searchTheoTen();
		}
	};

	public void searchTheoTen() {
		String tenKH1 = txtTimKiemTen.getText();

		if (tenKH1.isEmpty()) {
			model.setRowCount(0);
			arrKH.clear();
			duLieu();
		} else {
			for (KhachHang kh : arrKH) {
				if (kh.getTenKH().toUpperCase().indexOf(tenKH1.toUpperCase()) > -1) {
					String[] row = { kh.getMaKH(), kh.getTenKH(),
							kh.getDiaChiNha() + "," + kh.getPhuong() + "," + kh.getQuan(), kh.getEmail(),
							kh.getSoThe() };
					model.addRow(row);
				}
			}
		}

	}

	private DocumentListener timKiemMa = new DocumentListener() {

		@Override
		public void changedUpdate(DocumentEvent e) {
			model.setRowCount(0);
			// arrKH.clear();
			searchTheoMa();
		}

		@Override
		public void insertUpdate(DocumentEvent e) {
			model.setRowCount(0);
			// arrKH.clear();
			searchTheoMa();
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			model.setRowCount(0);
			// arrKH.clear();
			searchTheoMa();
		}
	};

	public void searchTheoMa() {
		String maKH1 = txtTimKiemMa.getText();
		// arrKH = connectKH.searchKHTheoMa(maKH1);

		if (maKH1.isEmpty()) {
			model.setRowCount(0);
			arrKH.clear();
			duLieu();
		} else {
			for (KhachHang kh : arrKH) {

				if (kh.getMaKH().toUpperCase().indexOf(maKH1.toUpperCase()) > -1) {
					String[] row = { kh.getMaKH(), kh.getTenKH(),
							kh.getDiaChiNha() + "," + kh.getPhuong() + "," + kh.getQuan(), kh.getEmail(),
							kh.getSoThe() };
					model.addRow(row);
				}
			}
		}

	}

	ActionListener xoaKhachHang = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				String maKH = txtMaKH.getText();
				if (maKH.isEmpty()) {
					JOptionPane.showMessageDialog(null, "chưa chọn khách hàng", "Message",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					int dialogButton = JOptionPane.YES_NO_OPTION;
					int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn muốn xóa khách hàng?", "Message",
							dialogButton);
					if (dialogResult == JOptionPane.YES_OPTION) {
						arrKH.remove(stt);
						connectKH.deleteSinhVien(maKH);
						txtMaKH.requestFocus();
						model.setRowCount(0);
						arrKH.clear();
						duLieu();
						txtMaKH.setText("");
						txtTenKH.setText("");
						txtDiaChi.setText("");
						txtPhone.setText("");
						txtEmail.setText("");
						txtSoThe.setText("");
						txtTK.setText("");
						txtSoDu.setText("");
						txtMaPin.setText("");
					}
				}
			} catch (Exception ex) {

			}

		}
	};

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void addControl() {

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setOpaque(false);
		JPanel pnHeader = new JPanel();
		pnHeader.setOpaque(false);
		JLabel nameTieuDe = new JLabel("Quản lí Khách hàng");
		pnHeader.add(nameTieuDe);

		JPanel pnBody1 = new JPanel();
		pnBody1.setOpaque(false);
		pnBody1.setPreferredSize(new Dimension(850, 200));
		pnBody1.setLayout(new BoxLayout(pnBody1, BoxLayout.X_AXIS));
		JPanel pnInputLeft = new JPanel();
		pnInputLeft.setOpaque(false);
		pnInputLeft.setLayout(new BoxLayout(pnInputLeft, BoxLayout.Y_AXIS));

		JPanel pnMaKhachHang = new JPanel();
		pnMaKhachHang.setOpaque(false);
		JLabel naneMaKH = new JLabel("Mã khách hàng :");
		txtMaKH = new JTextField(20);
		txtMaKH.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		pnMaKhachHang.add(naneMaKH);
		pnMaKhachHang.add(txtMaKH);

		JPanel pnTenKhachHang = new JPanel();
		pnTenKhachHang.setOpaque(false);
		JLabel nanetenKH = new JLabel("Tên khách hàng :");
		txtTenKH = new JTextField(20);
		txtTenKH.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		pnTenKhachHang.add(nanetenKH);
		pnTenKhachHang.add(txtTenKH);

		JPanel pnDiaChi = new JPanel();
		pnDiaChi.setOpaque(false);
		JLabel naneDiaChi = new JLabel("Địa chỉ nhà :");
		naneDiaChi.setPreferredSize(nanetenKH.getPreferredSize());
		txtDiaChi = new JTextField(20);
		txtDiaChi.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		pnDiaChi.add(naneDiaChi);
		pnDiaChi.add(txtDiaChi);

		JPanel pnQuanHuyen = new JPanel();
		pnQuanHuyen.setOpaque(false);
		pnQuanHuyen.setLayout(new BoxLayout(pnQuanHuyen, BoxLayout.X_AXIS));
		JPanel pnQuan = new JPanel();
		pnQuan.setOpaque(false);
		JLabel naneQuan = new JLabel("Quận :");
		cboQuan = new JComboBox();
		cboQuan.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		cboQuan.setPreferredSize(new Dimension(120, 20));
		ArrayList<ComboItem> quan = new ArrayList<>();
		quan = DatabaseDiaChi.getQuan();
		for (ComboItem x : quan) {
			cboQuan.addItem(x);
		}
		pnQuan.add(naneQuan);
		pnQuan.add(cboQuan);

		JPanel pnPhuong = new JPanel();
		pnPhuong.setOpaque(false);
		@SuppressWarnings("unused")
		JLabel nanePhuong = new JLabel("Phường:");
		cboPhuong = new JComboBox();
		cboPhuong.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		selectPhuong();
		cboPhuong.setPreferredSize(new Dimension(160, 20));
		cboPhuong.addItem("Chọn Phường");

		pnPhuong.add(cboPhuong);

		pnQuanHuyen.add(pnQuan);
		pnQuanHuyen.add(pnPhuong);

		JPanel pnInputRight = new JPanel();
		pnInputRight.setOpaque(false);
		pnInputRight.setLayout(new BoxLayout(pnInputRight, BoxLayout.Y_AXIS));

		JPanel pnPhone = new JPanel();
		pnPhone.setOpaque(false);
		JLabel nanePhone = new JLabel("Điện thoại :");
		nanePhone.setPreferredSize(nanetenKH.getPreferredSize());
		txtPhone = new JTextField(20);
		txtPhone.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		pnPhone.add(nanePhone);
		pnPhone.add(txtPhone);

		JPanel pnEmail = new JPanel();
		pnEmail.setOpaque(false);
		JLabel naneEmail = new JLabel("Email :");
		naneEmail.setPreferredSize(nanetenKH.getPreferredSize());
		txtEmail = new JTextField(20);
		txtEmail.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		pnEmail.add(naneEmail);
		pnEmail.add(txtEmail);

		JPanel pnSoThe = new JPanel();
		pnSoThe.setOpaque(false);
		JLabel naneSoThe = new JLabel("Số thẻ ATM :");
		naneSoThe.setPreferredSize(nanetenKH.getPreferredSize());
		txtSoThe = new JTextField(20);
		txtSoThe.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		pnSoThe.add(naneSoThe);
		pnSoThe.add(txtSoThe);

		JPanel pnTK = new JPanel();
		pnTK.setOpaque(false);
		naneTK = new JLabel("Số TK ngân hàng :");
		txtTK = new JTextField(20);
		txtTK.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		pnTK.add(naneTK);
		pnTK.add(txtTK);

		JPanel pnSoDu = new JPanel();
		pnSoDu.setOpaque(false);
		JLabel naneSoDu = new JLabel("Số dư :");
		naneSoDu.setPreferredSize(nanetenKH.getPreferredSize());
		txtSoDu = new JTextField(20);
		txtSoDu.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		pnSoDu.add(naneSoDu);
		pnSoDu.add(txtSoDu);

		JPanel pnMaPin = new JPanel();
		pnMaPin.setOpaque(false);
		JLabel naneMaPin = new JLabel("Ma pin :");
		naneMaPin.setPreferredSize(nanetenKH.getPreferredSize());
		txtMaPin = new JTextField(20);
		txtMaPin.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		pnMaPin.add(naneMaPin);
		pnMaPin.add(txtMaPin);

		// thêm vào các panel chính
		pnInputLeft.add(pnMaKhachHang);
		pnInputLeft.add(pnTenKhachHang);
		pnInputLeft.add(pnDiaChi);
		pnInputLeft.add(pnQuanHuyen);
		pnInputLeft.add(pnPhone);

		pnInputRight.add(pnEmail);
		pnInputRight.add(pnSoThe);
		pnInputRight.add(pnTK);
		pnInputRight.add(pnSoDu);
		pnInputRight.add(pnMaPin);

		pnBody1.add(pnInputLeft);
		pnBody1.add(pnInputRight);

		// panel buttons
		JPanel pnButton = new JPanel();
		pnButton.setOpaque(false);
		pnButton.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.black));
		ImageIcon iconThem = new ImageIcon(
				"D:\\FFSE1703.JavaCore\\Assignments\\TuanNM\\du_an_quan_li_ATM\\src\\ffse1703013\\atm\\images\\them.png");
		buttonThem = new JButton("Thêm", iconThem);
		buttonThem.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode("#191970")));
		buttonThem.setPreferredSize(new Dimension(120, 30));
		ImageIcon iconSua = new ImageIcon(
				"D:\\FFSE1703.JavaCore\\Assignments\\TuanNM\\du_an_quan_li_ATM\\src\\ffse1703013\\atm\\images\\sua.png");
		buttonSua = new JButton("Sửa", iconSua);
		buttonSua.setPreferredSize(new Dimension(120, 30));
		buttonSua.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode("#191970")));
		ImageIcon iconXoa = new ImageIcon(
				"D:\\FFSE1703.JavaCore\\Assignments\\TuanNM\\du_an_quan_li_ATM\\src\\ffse1703013\\atm\\images\\xoa.png");
		buttonXoa = new JButton("Xóa", iconXoa);
		buttonXoa.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode("#191970")));
		buttonXoa.setPreferredSize(new Dimension(120, 30));
		ImageIcon iconHuy = new ImageIcon(
				"D:\\FFSE1703.JavaCore\\Assignments\\TuanNM\\du_an_quan_li_ATM\\src\\ffse1703013\\atm\\images\\huy.png");
		buttonHuy = new JButton("Hủy", iconHuy);
		buttonHuy.setPreferredSize(new Dimension(120, 30));
		buttonHuy.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode("#191970")));
		// mới vào không cho sủa hoặc xóa
		buttonSua.setEnabled(false);
		buttonXoa.setEnabled(false);

		pnButton.add(buttonThem);
		pnButton.add(buttonSua);
		pnButton.add(buttonXoa);
		pnButton.add(buttonHuy);

		/// panel Tìm kiếm

		JPanel pnTimKiem = new JPanel();
		pnTimKiem.setOpaque(false);
		Border border = BorderFactory.createLineBorder(Color.blue);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Tìm kiếm");
		pnTimKiem.setBorder(borderTitle);
		// khai báo cardlayout

		// panel chọn kiểu tìm kiếm
		JPanel pnChooseTK = new JPanel();
		pnChooseTK.setOpaque(false);
		cboTimKiem = new JComboBox();
		cboTimKiem.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		cboTimKiem.addItem("Theo Tên khách hàng");
		cboTimKiem.addItem("Theo Mã Khách hàng");
		pnChooseTK.add(cboTimKiem);
		// panel đã chọn kiểu tìm kiếm
		JPanel pnChoosed = new JPanel();
		pnChoosed.setOpaque(false);
		CardLayout tkCardLayout = new CardLayout();
		pnChoosed.setLayout(tkCardLayout);

		// panel Tìm kiếm theo tên
		JPanel pnTKTheoTen = new JPanel();
		pnTKTheoTen.setOpaque(false);
		txtTimKiemTen = new PlaceholderTextField(20);
		txtTimKiemTen.setPlaceholder("Nhập tên khách hàng??");
		txtTimKiemTen.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		// ImageIcon iconSearch = new
		// ImageIcon("D:\\FFSE1703.JavaCore\\Assignments\\TuanNM\\du_an_quan_li_ATM\\src\\ffse1703013\\atm\\images\\timKiem.png");
		JButton buttonTimKiemTen = new JButton("Tìm kiếm");
		buttonTimKiemTen.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		// buttonTimKiemTen.setPreferredSize(new Dimension(120, 30));
		pnTKTheoTen.add(txtTimKiemTen);
		pnTKTheoTen.add(buttonTimKiemTen);

		// panel Tìm kiếm theo mã
		JPanel pnTKTheoMa = new JPanel();
		pnTKTheoMa.setOpaque(false);
		pnTKTheoMa.setOpaque(false);
		txtTimKiemMa = new PlaceholderTextField(20);
		txtTimKiemMa.setPlaceholder("Nhập mã khách hàng??");
		txtTimKiemMa.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		buttonTimKiemMa = new JButton("Tìm kiếm");
		buttonTimKiemMa.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		pnTKTheoMa.add(txtTimKiemMa);
		pnTKTheoMa.add(buttonTimKiemMa);

		pnChoosed.add(pnTKTheoTen, "12");
		pnChoosed.add(pnTKTheoMa, "2");

		tkCardLayout.show(pnChoosed, "12");
		cboTimKiem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String chooseTK = cboTimKiem.getSelectedItem().toString();

				if (chooseTK == "Theo Tên khách hàng") {
					tkCardLayout.show(pnChoosed, "12");
				} else if (chooseTK == "Theo Mã Khách hàng") {
					tkCardLayout.show(pnChoosed, "2");
				}
			}
		});

		pnTimKiem.add(pnChooseTK);
		pnTimKiem.add(pnChoosed);

		// panel chọn hiện thị
		JPanel pnChoosePQ = new JPanel();
		pnChoosePQ.setOpaque(false);
		pnChoosePQ.setLayout(new BoxLayout(pnChoosePQ, BoxLayout.X_AXIS));
		pnChoosePQ.setPreferredSize(new Dimension(850, 30));
		JPanel pnLeft = new JPanel();
		pnLeft.setOpaque(false);
		pnLeft.setPreferredSize(new Dimension(300, 30));
		JPanel pnRight = new JPanel();
		pnRight.setOpaque(false);
		pnRight.setPreferredSize(new Dimension(200, 20));
		cboPhuong1 = new JComboBox();
		cboPhuong1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		cboPhuong1.addItem("Chọn Phường");
		selectPhuongTK();
		cboPhuong1.setPreferredSize(new Dimension(160, 20));
		cboQuan1 = new JComboBox();
		cboQuan1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		cboQuan1.setPreferredSize(new Dimension(120, 20));
		ArrayList<ComboItem> arrQuan = new ArrayList<>();
		arrQuan = DatabaseDiaChi.getQuanTK();
		for (ComboItem x : arrQuan) {
			cboQuan1.addItem(x);
		}
		pnRight.add(cboQuan1);
		pnRight.add(cboPhuong1);

		pnChoosePQ.add(pnLeft);
		pnChoosePQ.add(pnRight);

		//
		// panel danh sach khach hàng
		JPanel pnTableKhachHang = new JPanel();
		pnTableKhachHang.setOpaque(false);
		Border border1 = BorderFactory.createLineBorder(Color.BLUE);
		TitledBorder borderTitle1 = BorderFactory.createTitledBorder(border1, "Danh Sách Khách hàng",
				TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
		pnTableKhachHang.setBorder(borderTitle1);
		model = new DefaultTableModel();
		tblKhachHang = new JTable(model);
		tblKhachHang.setOpaque(false);
		tblKhachHang.setLayout(new BorderLayout());
		model.addColumn("Mã Khách hàng");
		model.addColumn("Tên Khách hàng");
		model.addColumn("Địa chỉ");
		model.addColumn("Email");
		model.addColumn("Số thẻ ATM");
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
		tblKhachHang.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
		tblKhachHang.getColumnModel().getColumn(0).setPreferredWidth(40);
		tblKhachHang.getColumnModel().getColumn(1).setPreferredWidth(70);
		tblKhachHang.getColumnModel().getColumn(2).setPreferredWidth(250);
		tblKhachHang.getColumnModel().getColumn(3).setPreferredWidth(150);
		tblKhachHang.getColumnModel().getColumn(4).setPreferredWidth(80);

		JScrollPane scroll = new JScrollPane(tblKhachHang);
		scroll.setOpaque(false);
		scroll.getViewport().setOpaque(false);
		scroll.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode("#191970")));

		pnTableKhachHang.setLayout(new BorderLayout());
		pnTableKhachHang.add(scroll, BorderLayout.CENTER);
		duLieu();
		// pnTableKhachHang.add(pnDanhSach);

		// pnMain.add(pnHeader);
		this.add(pnBody1);
		this.add(pnButton);
		this.add(pnTimKiem);
		this.add(pnChoosePQ);
		this.add(pnTableKhachHang);

	}

	// đưa vào thẻ input
	private void setTextToInput(String i) {

		for (KhachHang kh : arrKH) {
			if (i.equals(kh.getMaKH())) {
				txtMaKH.setText(kh.getMaKH());
				txtTenKH.setText(kh.getTenKH());
				txtDiaChi.setText(kh.getDiaChiNha());
				txtPhone.setText(kh.getDienThoai());
				txtEmail.setText(kh.getEmail());
				txtSoThe.setText(kh.getSoThe());
				txtTK.setText(kh.getSoTK());
				txtSoDu.setText(kh.getSoDu());
				txtMaPin.setText(kh.getMaPin());

				/* Các trường không được sửa set enable false */
				txtMaKH.setEditable(false);
				txtSoThe.setEditable(false);
				txtTK.setEditable(false);
				buttonThem.setFocusable(false);
				buttonSua.setEnabled(true);
				buttonXoa.setEnabled(true);
				/* Quận */
				String quan = kh.getQuan();
				for (int j = 0; j < cboQuan.getItemCount(); j++) {
					if (quan.equals(cboQuan.getItemAt(j).toString())) {
						cboQuan.setSelectedIndex(j);
					}
				}
				/* Phường */
				String phuong = kh.getPhuong();
				for (int j = 0; j < cboPhuong.getItemCount(); j++) {
					if (phuong.equals(cboPhuong.getItemAt(j).toString())) {
						cboPhuong.setSelectedIndex(j);
					}
				}

			}
		}

	}

}
