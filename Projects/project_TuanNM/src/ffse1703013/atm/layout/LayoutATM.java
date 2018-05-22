package ffse1703013.atm.layout;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import ffse1703013.atm.model.ATM;
import ffse1703013.atm.model.ComboItem;
import ffse1703013.atm.model.DatabaseATM;
import ffse1703013.atm.model.DatabaseDiaChi;

@SuppressWarnings("serial")
public class LayoutATM extends JPanel {
	private DatabaseATM connectATM = new DatabaseATM();
	private ArrayList<ComboItem> phuong = new ArrayList<>();
	private ArrayList<ComboItem> phuong1 = new ArrayList<>();
	private ArrayList<ATM> arrATM = new ArrayList<ATM>();
	@SuppressWarnings("rawtypes")
	private JComboBox cboQuan, cboPhuong1, cboPhuong, cboQuan1;
	private JTextField txtMaMay, txtDuongPho, txtTongTien;
	private PlaceholderTextField txtTimKiemMa;
	private DefaultTableModel model;
	JTable tblATM;
	private JButton buttonThem, buttonSua, buttonXoa, buttonHuy;
	private int stt = 0;

	LayoutATM() {
		addControl();
		addEvents();
	}

	public void addEvents() {
		cboQuan.addActionListener(chonPhuong);
		cboQuan1.addActionListener(tkTheoQuan);
		cboPhuong1.addActionListener(tkTheoPhuong);
		buttonThem.addActionListener(themMayATM);
		tblATM.getSelectionModel().addListSelectionListener(chonHang);
		buttonSua.addActionListener(chinhSuaATM);
		buttonXoa.addActionListener(xoaATM);
		buttonHuy.addActionListener(reFfresh);
		txtTimKiemMa.getDocument().addDocumentListener(timKiemMa);
	}

	// tạo danh sách chọn phường
	ActionListener chonPhuong = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			selectPhuong();
		}
	};

	@SuppressWarnings("unchecked")
	public void selectPhuong() {
		phuong.clear();
		int itemCount = cboPhuong.getItemCount();

		for (int i = 0; i < itemCount; i++) {
			cboPhuong.removeItemAt(0);
		}
		ComboItem itemD = (ComboItem) cboQuan.getSelectedItem();
		int id = itemD.getId();
		phuong = DatabaseDiaChi.getPhuonng(id);

		for (ComboItem x : phuong) {
			cboPhuong.addItem(x);

		}
	}

	// tìm kiếm theo quận
	ActionListener tkTheoQuan = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String tenQuan = cboQuan1.getSelectedItem().toString();
			selectPhuongTK();

			// tim kiem theo quận
			if (tenQuan.equals("Tất cả")) {
				model.setRowCount(0);
				arrATM.clear();
				duLieu();
			} else {
				model.setRowCount(0);
				for (ATM atm : arrATM) {
					if (tenQuan.equals(atm.getQuan())) {
						DecimalFormat formatter = new DecimalFormat("###,###,###");
						String soTien = formatter.format(Integer.parseInt(atm.getTongTien())) + " VNĐ";
						String[] row = { atm.getMaATM(),
								atm.getDuongPho() + "," + atm.getPhuong() + "," + atm.getQuan(), soTien };
						model.addRow(row);
					}

				}
			}
		}

	};

	@SuppressWarnings("unchecked")
	public void selectPhuongTK() {

		phuong1.clear();
		int itemCount = cboPhuong1.getItemCount();

		for (int i = 0; i < itemCount; i++) {
			cboPhuong1.removeItemAt(0);
		}
		ComboItem itemD = (ComboItem) cboQuan1.getSelectedItem();
		int id = itemD.getId();
		phuong1 = DatabaseDiaChi.getPhuonng(id);
		for (ComboItem x : phuong1) {
			cboPhuong1.addItem(x);
		}
	}

	ListSelectionListener chonHang = new ListSelectionListener() {

		@Override
		public void valueChanged(ListSelectionEvent e) {

			int i = tblATM.getSelectedRow();

			if (i >= 0 && !e.getValueIsAdjusting()) {
				String ma = tblATM.getValueAt(i, 0).toString();
				setTextToInput(ma);

				buttonThem.setEnabled(false);

				for (int j = 0; j < arrATM.size(); j++) {
					if (ma.equals(arrATM.get(i).getMaATM())) {
						stt = i;
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
				if (phuong.equals("Tất cả")) {
					model.setRowCount(0);
					arrATM.clear();
					duLieu();
				} else {
					model.setRowCount(0);
					for (ATM atm : arrATM) {
						if (phuong.equals(atm.getPhuong())) {
							DecimalFormat formatter = new DecimalFormat("###,###,###");
							String soTien = formatter.format(Integer.parseInt(atm.getTongTien())) + " VNĐ";
							String[] row = { atm.getMaATM(),
									atm.getDuongPho() + "," + atm.getPhuong() + "," + atm.getQuan(), soTien };
							model.addRow(row);
						}

					}
				}
			} catch (Exception ex) {

			}
		}
	};

	private void setTextToInput(String i) {

		for (ATM atm : arrATM) {
			if (i.equals(atm.getMaATM())) {
				txtMaMay.setText(atm.getMaATM());
				txtDuongPho.setText(atm.getDuongPho());
				txtTongTien.setText(atm.getTongTien());

				/* Các trường không được sửa set enable false */
				txtMaMay.setEditable(false);
				buttonThem.setFocusable(false);
				buttonSua.setEnabled(true);
				buttonXoa.setEnabled(true);
				/* Quận */
				String quan = atm.getQuan();
				for (int j = 0; j < cboQuan.getItemCount(); j++) {
					if (quan.equals(cboQuan.getItemAt(j).toString())) {
						cboQuan.setSelectedIndex(j);
					}
				}
				/* Phường */
				String phuong = atm.getPhuong();
				for (int j = 0; j < cboPhuong.getItemCount(); j++) {
					if (phuong.equals(cboPhuong.getItemAt(j).toString())) {
						cboPhuong.setSelectedIndex(j);
					}
				}

			}
		}

	}

	ActionListener themMayATM = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			try {
				int ktTonTai = 0;
				int ktNhapTien =0 ;
				int soTien = 0;
				String maATM = txtMaMay.getText();
				String duongPho = txtDuongPho.getText();
				String tongTien = txtTongTien.getText();
				String quan = cboQuan.getSelectedItem().toString();
				String phuong = cboPhuong.getSelectedItem().toString();
				for (int i = 0; i < arrATM.size(); i++) {
					if (maATM.equals(arrATM.get(i).getMaATM())) {
						ktTonTai = 1;
					}
				}
				try {
					soTien = Integer.parseInt(tongTien);
				} catch (Exception ex) {
					ktNhapTien = 1 ;
				}
				
					if (maATM.isEmpty() || duongPho.isEmpty() || tongTien.isEmpty()) {
						String msg = "Vui lòng nhập đầy đủ thông tin";
						JOptionPane.showMessageDialog(null, msg, "Lỗi Nhập Thiếu", JOptionPane.INFORMATION_MESSAGE);

					} else if (ktTonTai > 0) {
						String msg = "Mã máy ATM đã tồn tạ !!";
						JOptionPane.showMessageDialog(null, msg, "Lỗi nhập", JOptionPane.INFORMATION_MESSAGE);

					} else if (ktNhapTien > 0) {
						// throw new NullPointerException();
						String msg = "Số tiền không được nhập kí tự !!";
						JOptionPane.showMessageDialog(null, msg, "Lỗi nhập", JOptionPane.INFORMATION_MESSAGE);
					}else if (soTien > 1000000000) {
						// throw new NullPointerException();
						String msg = "Trong Máy ATM không quá  1,000,000,000 đ !!";
						JOptionPane.showMessageDialog(null, msg, "Lỗi nhập", JOptionPane.INFORMATION_MESSAGE);
					}else if (soTien < 1000000) {
						// throw new NullPointerException();
						String msg = "Trong Máy ATM ít nhất 1,000,000 đ !!";
						JOptionPane.showMessageDialog(null, msg, "Lỗi nhập", JOptionPane.INFORMATION_MESSAGE);
					} else {
						connectATM.insertATM(maATM, duongPho, phuong, quan, tongTien);
						arrATM.clear();
						duLieu();
						txtMaMay.setText("");
						txtDuongPho.setText("");
						txtTongTien.setText("");

					}

				
			} catch (Exception ex) {

			}

		}

	};
	ActionListener chinhSuaATM = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			int ktNhapTien =0 ;
			int soTien = 0;
			String maATM = txtMaMay.getText();
			String duongPho = txtDuongPho.getText();
			String tongTien = txtTongTien.getText();
			String quan = cboQuan.getSelectedItem().toString();
			String phuong = cboPhuong.getSelectedItem().toString();
			
			//kiểm tra số tiền không được nhập số
			try {
				soTien = Integer.parseInt(tongTien);
			} catch (Exception ex) {
				ktNhapTien = 1 ;
			}

			try {

				if (maATM.isEmpty() || duongPho.isEmpty() || tongTien.isEmpty()) {
					String msg = "Vui lòng nhập đầy đủ thông tin";
					JOptionPane.showMessageDialog(null, msg, "Lỗi Nhập Thiếu", JOptionPane.INFORMATION_MESSAGE);

				}else if (ktNhapTien > 0) {
					// throw new NullPointerException();
					String msg = "Số tiền không được nhập kí tự !!";
					JOptionPane.showMessageDialog(null, msg, "Lỗi nhập", JOptionPane.INFORMATION_MESSAGE);
				}else if (soTien < 1000000) {
					// throw new NullPointerException();
					String msg = "Trong Máy ATM ít nhất 1,000,000 đ !!";
					JOptionPane.showMessageDialog(null, msg, "Lỗi nhập", JOptionPane.INFORMATION_MESSAGE);
				} else {
					// model.setRowCount(0);

					arrATM.get(stt).setMaATM(maATM);
					arrATM.get(stt).setDuongPho(duongPho);
					arrATM.get(stt).setPhuong(phuong);
					arrATM.get(stt).setQuan(quan);
					arrATM.get(stt).setTongTien(tongTien);

					connectATM.updateATM(maATM, duongPho, phuong, quan, tongTien);

					model.setRowCount(0);
					arrATM.clear();

					duLieu();

				}

			} catch (Exception es) {
				String msg = "Chưa chọn khách hàng cần sửa ";
				JOptionPane.showMessageDialog(null, msg, "Sửa Thành Công", JOptionPane.INFORMATION_MESSAGE);
			}
			txtMaMay.setText("");
			txtDuongPho.setText("");
			txtTongTien.setText("");

		}
	};
	ActionListener xoaATM = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				String maATM = txtMaMay.getText();
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn muốn xóa máy ATM?", "LOGUOT", dialogButton);
				if (dialogResult == JOptionPane.YES_OPTION) {
					arrATM.remove(stt);
					connectATM.deleteATM(maATM);
					txtMaMay.requestFocus();
					model.setRowCount(0);
					arrATM.clear();
					duLieu();
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Không còn sinh viên nào");
			}
		}
	};
	ActionListener reFfresh = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			txtMaMay.setText("");
			txtDuongPho.setText("");
			txtTongTien.setText("");
			txtMaMay.setEditable(true);
			buttonThem.setEnabled(true);
			buttonSua.setEnabled(false);
			buttonXoa.setEnabled(false);
		}
	};
	private DocumentListener timKiemMa = new DocumentListener() {

		@Override
		public void changedUpdate(DocumentEvent e) {
			model.setRowCount(0);
			searchTheoMa();
		}

		@Override
		public void insertUpdate(DocumentEvent e) {
			model.setRowCount(0);
			searchTheoMa();
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			model.setRowCount(0);
			searchTheoMa();
		}
	};

	public void searchTheoMa() {
		String maATM1 = txtTimKiemMa.getText();
		//arrATM = connectATM.searchATMTheoMa(maATM1);

		if (maATM1.isEmpty()) {
			model.setRowCount(0);
			arrATM.clear();
			duLieu();
		} else {
			for (ATM atm : arrATM) {
				if(atm.getMaATM().toUpperCase().indexOf(maATM1.toUpperCase()) > -1) {
				DecimalFormat formatter = new DecimalFormat("###,###,###");
				String soTien = formatter.format(Integer.parseInt(atm.getTongTien())) + " VNĐ";
				String[] row = { atm.getMaATM(),
						atm.getDuongPho() + "," + atm.getPhuong() + "," + atm.getQuan(), soTien };
				model.addRow(row);
				}
			}
		}

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void addControl() {

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setOpaque(false);

		// panel dữ liệu nhập
		JPanel pnBody = new JPanel();
		pnBody.setOpaque(false);
		pnBody.setPreferredSize(new Dimension(850, 200));

		pnBody.setLayout(new BoxLayout(pnBody, BoxLayout.Y_AXIS));
		JPanel pnMaMay = new JPanel();
		pnMaMay.setOpaque(false);
		JLabel nameMaMay = new JLabel("Mã máy ATM :");
		nameMaMay.setPreferredSize(new Dimension(120, 20));
		txtMaMay = new JTextField(20);
		txtMaMay.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		pnMaMay.add(nameMaMay);
		pnMaMay.add(txtMaMay);

		JPanel pnDuongPho = new JPanel();
		pnDuongPho.setOpaque(false);
		JLabel nameDuongPho = new JLabel("Đường phố đặt:");
		nameDuongPho.setPreferredSize(new Dimension(120, 20));
		txtDuongPho = new JTextField(20);
		txtDuongPho.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		pnDuongPho.add(nameDuongPho);
		pnDuongPho.add(txtDuongPho);

		JPanel pnQuanHuyen = new JPanel();
		pnQuanHuyen.setOpaque(false);
		pnQuanHuyen.setLayout(new BoxLayout(pnQuanHuyen, BoxLayout.X_AXIS));
		JPanel pnQuan = new JPanel();
		pnQuan.setOpaque(false);
		JLabel naneQuan = new JLabel("Quận :");
		cboQuan = new JComboBox();
		cboQuan.setPreferredSize(new Dimension(120, 20));
		ArrayList<ComboItem> quan = new ArrayList<>();
		quan = DatabaseDiaChi.getQuan();
		for (ComboItem x : quan) {
			cboQuan.addItem(x);
		}

		pnQuan.add(naneQuan);
		pnQuan.add(cboQuan);
		JPanel demo = new JPanel();
		demo.setOpaque(false);
		demo.setPreferredSize(new Dimension(150, 20));

		JPanel pnPhuong = new JPanel();
		pnPhuong.setOpaque(false);
		JLabel nanePhuong = new JLabel("Phường:");
		cboPhuong = new JComboBox();
		cboPhuong.setPreferredSize(new Dimension(160, 20));
		cboPhuong.addItem("chọn phường");

		pnPhuong.add(nanePhuong);
		pnPhuong.add(cboPhuong);
		JPanel demo2 = new JPanel();
		demo2.setOpaque(false);
		demo2.setPreferredSize(new Dimension(150, 20));

		pnQuanHuyen.add(demo);
		pnQuanHuyen.add(pnQuan);
		pnQuanHuyen.add(pnPhuong);
		pnQuanHuyen.add(demo2);

		// pnQuanHuyen.add(pnQuan,BorderLayout.CENTER);

		JPanel pnTongTien = new JPanel();
		pnTongTien.setOpaque(false);
		JLabel nameTongTien = new JLabel("Tổng tiền trong máy");
		nameTongTien.setPreferredSize(new Dimension(120, 20));
		txtTongTien = new JTextField(20);
		txtTongTien.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		pnTongTien.add(nameTongTien);
		pnTongTien.add(txtTongTien);

		pnBody.add(pnMaMay);
		pnBody.add(pnDuongPho);
		pnBody.add(pnQuanHuyen);
		pnBody.add(pnTongTien);

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

		// panel chọn hiện thị
		JPanel pnChoosePQ = new JPanel();
		Border border11 = BorderFactory.createLineBorder(Color.decode("#191970"));
		TitledBorder borderTitle11 = BorderFactory.createTitledBorder(border11, "Tìm kiếm", TitledBorder.CENTER,
				TitledBorder.DEFAULT_POSITION);
		pnChoosePQ.setBorder(borderTitle11);
		pnChoosePQ.setOpaque(false);
		pnChoosePQ.setLayout(new BoxLayout(pnChoosePQ, BoxLayout.X_AXIS));
		pnChoosePQ.setPreferredSize(new Dimension(850, 50));
		JPanel pnLeft = new JPanel();
		pnLeft.setOpaque(false);
		txtTimKiemMa = new PlaceholderTextField(20);
		txtTimKiemMa.setPlaceholder("Nhập mã máy ATM ??");
		txtTimKiemMa.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		JButton buttonTimKiemTen = new JButton("Tìm kiếm");
		buttonTimKiemTen.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		pnLeft.setPreferredSize(new Dimension(300, 30));
		pnLeft.add(txtTimKiemMa);
		pnLeft.add(buttonTimKiemTen);

		JPanel pnRight = new JPanel();
		pnRight.setOpaque(false);
		pnRight.setPreferredSize(new Dimension(200, 20));
		cboPhuong1 = new JComboBox();
		cboPhuong1.setPreferredSize(new Dimension(160, 20));

		cboQuan1 = new JComboBox();
		cboQuan1.setPreferredSize(new Dimension(120, 20));
		ArrayList<ComboItem> quan2 = new ArrayList<>();
		quan2 = DatabaseDiaChi.getQuanTK();
		for (ComboItem x : quan2) {
			cboQuan1.addItem(x);
		}
		pnRight.add(cboQuan1);
		pnRight.add(cboPhuong1);

		pnChoosePQ.add(pnRight);
		pnChoosePQ.add(pnLeft);

		//
		// panel danh sach khach hàng
		JPanel pnTableKhachHang = new JPanel();
		pnTableKhachHang.setOpaque(false);

		TitledBorder borderTitle111 = BorderFactory.createTitledBorder(border11, "Danh Sách máy ATM",
				TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
		pnTableKhachHang.setBorder(borderTitle111);
		model = new DefaultTableModel();
		tblATM = new JTable(model);
		tblATM.setLayout(new BorderLayout());
		model.addColumn("Mã máy ATM");
		model.addColumn("Địa chỉ");
		model.addColumn("Tổng tiền trong máy");
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
		tblATM.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
		tblATM.getColumnModel().getColumn(1).setPreferredWidth(250);

		JScrollPane scroll = new JScrollPane(tblATM);
		scroll.setOpaque(false);
		scroll.getViewport().setOpaque(false);
		scroll.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode("#191970")));
		pnTableKhachHang.setLayout(new BorderLayout());
		pnTableKhachHang.add(scroll, BorderLayout.CENTER);
		duLieu();
		// pnTableKhachHang.add(pnDanhSach);

		// this.add(pnHeader);
		this.add(pnBody);
		this.add(pnButton);
		// this.add(pnTimKiem);
		this.add(pnChoosePQ);
		this.add(pnTableKhachHang);
		selectPhuongTK();
		selectPhuong();

	}

	void duLieu() {

		arrATM = connectATM.selectATM();
		model.setRowCount(0);
		for (ATM atm : arrATM) {

			DecimalFormat formatter = new DecimalFormat("###,###,###");
			String soTien = formatter.format(Integer.parseInt(atm.getTongTien())) + " VNĐ";
			String[] row = { atm.getMaATM(),
					atm.getDuongPho() + "," + atm.getPhuong() + "," + atm.getQuan(), soTien };
			model.addRow(row);
		}
	}

}
