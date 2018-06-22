package ffse1703013.atm.layout;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.BorderFactory;
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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import ffse1703013.atm.model.ATM;
import ffse1703013.atm.model.ComboItem;
import ffse1703013.atm.model.DatabaseBaoCaoATM;
import ffse1703013.atm.model.DatabaseDiaChi;

@SuppressWarnings("serial")
public class LayoutBaoCaoATM extends JPanel {
	ArrayList<ATM> arrTK = new ArrayList<ATM>();
	private ArrayList<ComboItem> arrPhuong = new ArrayList<>();
	private ArrayList<String> arrDuongPho = new ArrayList<>();
	private ArrayList<String> arrMaATM = new ArrayList<>();
	DatabaseBaoCaoATM connectBaoCaoATM = new DatabaseBaoCaoATM();
	DefaultTableModel model;
	JTextField txtMaMay, txtDiaChi, txtTongTien, txtSoTien, txtTimKiemMa;
	JLabel nameMaMay, nameDiaChi, nameTongTien, nameSoTien;
	JTable tblDanhSachMayATM;
	@SuppressWarnings("rawtypes")
	JComboBox cboSapXep;
	@SuppressWarnings("rawtypes")
	JComboBox cboPhuong, cboQuan, cboDuongPho, cboMayATM;
	JButton btnChiTiet;
	CardLayout cl;
	JPanel pnSelect;
	JButton btnBaoCaoATM, btnBaoCaoRutTien;
	LayoutBaoCaoRutTienATM pnRutTienATM = new LayoutBaoCaoRutTienATM();

	public LayoutBaoCaoATM() {
		addControl();
		addEvent();
		selectDanhSach();
	}

	public void addEvent() {
		cboQuan.addActionListener(selectPhuong);
		cboPhuong.addActionListener(selectDuongPho);
		cboDuongPho.addActionListener(selectMayATM);
		cboMayATM.addActionListener(selectDanhSachATM);
		tblDanhSachMayATM.getSelectionModel().addListSelectionListener(chonHang);
		btnChiTiet.addActionListener(xemChiTiet);
		cboSapXep.addActionListener(sapXep);

	}

	ActionListener sapXep = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			String sx = cboSapXep.getSelectedItem().toString();
			if (sx == "theo mã máy ") {
				model.setRowCount(0);
				Collections.sort(arrTK, ATM.sortMaMay);
				for (ATM bc : arrTK) {
					DecimalFormat formatter = new DecimalFormat("###,###,###");
					String soTien = formatter.format(Integer.parseInt(bc.getTongTien())) + " VNĐ";
					String[] row = { bc.getMaATM(), bc.getDuongPho() + "," + bc.getPhuong() + "," + bc.getQuan(),
							soTien };
					model.addRow(row);

				}
			} else if (sx == "theo tổng tiền ") {
				model.setRowCount(0);
				Collections.sort(arrTK, ATM.sortSoTien);
				for (ATM bc : arrTK) {
					DecimalFormat formatter = new DecimalFormat("###,###,###");
					String soTien = formatter.format(Integer.parseInt(bc.getTongTien())) + " VNĐ";
					String[] row = { bc.getMaATM(), bc.getDuongPho() + "," + bc.getPhuong() + "," + bc.getQuan(),
							soTien };
					model.addRow(row);

				}
			}
		}
	};

	ActionListener xemChiTiet = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				cl.show(pnSelect, "2");
				String ma = txtMaMay.getText();
				for (ATM x : arrTK) {
					if (ma.equals(x.getMaATM())) {
						String quan = x.getQuan();
						for (int j = 0; j < cboQuan.getItemCount(); j++) {
							if (quan.equals(cboQuan.getItemAt(j).toString())) {
								pnRutTienATM.cboQuan.setSelectedIndex(j);
							}
						}
						/* Phường */
						String phuong = x.getPhuong();
						for (int j = 0; j < cboPhuong.getItemCount(); j++) {
							if (phuong.equals(cboPhuong.getItemAt(j).toString())) {
								pnRutTienATM.cboPhuong.setSelectedIndex(j);
							}
						}
						pnRutTienATM.cboDuongPho.setSelectedItem(x.getDuongPho());
						pnRutTienATM.cboMayATM.setSelectedItem(x.getMaATM());
						btnBaoCaoATM.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
						btnBaoCaoRutTien.setBorder(BorderFactory.createMatteBorder(4, 1, 0, 1, Color.black));

					}

				}

			} catch (Exception ex) {

			}
		}
	};

	ListSelectionListener chonHang = new ListSelectionListener() {

		@Override
		public void valueChanged(ListSelectionEvent e) {

			int i = tblDanhSachMayATM.getSelectedRow();

			if (i >= 0 && !e.getValueIsAdjusting()) {
				String ma = tblDanhSachMayATM.getValueAt(i, 0).toString();
				duaDuLieuVaoInput(ma);
			}
			nameMaMay.setForeground(Color.black);
			nameDiaChi.setForeground(Color.black);
			nameTongTien.setForeground(Color.black);
			btnChiTiet.setForeground(Color.black);
			btnChiTiet.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

		}
	};

	private void duaDuLieuVaoInput(String i) {

		for (ATM gd : arrTK) {
			if (i.equals(gd.getMaATM())) {
				txtMaMay.setText(gd.getMaATM());
				txtDiaChi.setText(gd.getDuongPho() + "," + gd.getPhuong() + "," + gd.getQuan());
				txtTongTien.setText(gd.getTongTien() + " VNĐ");
			}
		}

	}

	ActionListener selectDanhSachATM = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			selectDanhSach();
			nameMaMay.setForeground(Color.white);
			nameDiaChi.setForeground(Color.white);
			nameTongTien.setForeground(Color.white);
			txtMaMay.setText("");
			txtDiaChi.setText("");
			txtTongTien.setText("");
			btnChiTiet.setForeground(Color.WHITE);
			btnChiTiet.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.BLACK));
		}
	};

	public void selectDanhSach() {
		try {
			String duong = cboDuongPho.getSelectedItem().toString();
			String phuong = cboPhuong.getSelectedItem().toString();
			String maMay = cboMayATM.getSelectedItem().toString();

			if (duong.equals("Chưa đặt máy tại đây") && maMay.equals("Không có máy nào")) {

				arrTK.clear();
				model.setRowCount(0);
			} else {

				arrTK.clear();
				model.setRowCount(0);
				arrTK = connectBaoCaoATM.selectMayATM(maMay, duong, phuong);
				if (maMay.equals("Tất cả")) {
					for (ATM bc : arrTK) {
						DecimalFormat formatter = new DecimalFormat("###,###,###");
						String soTien = formatter.format(Integer.parseInt(bc.getTongTien())) + " VNĐ";
						String[] row = { bc.getMaATM(), bc.getDuongPho() + "," + bc.getPhuong() + "," + bc.getQuan(),
								soTien };
						model.addRow(row);
					}
				} else {
					for (ATM bc : arrTK) {
						if (maMay.equals(bc.getMaATM())) {
							DecimalFormat formatter = new DecimalFormat("###,###,###");
							String soTien = formatter.format(Integer.parseInt(bc.getTongTien())) + " VNĐ";
							String[] row = { bc.getMaATM(),
									bc.getDuongPho() + "," + bc.getPhuong() + "," + bc.getQuan(), soTien };
							model.addRow(row);
						}

					}
				}
			}
		} catch (Exception ex) {

		}
	}

	ActionListener selectMayATM = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			selectMaMay();
			nameMaMay.setForeground(Color.white);
			nameDiaChi.setForeground(Color.white);
			nameTongTien.setForeground(Color.white);
			txtMaMay.setText("");
			txtDiaChi.setText("");
			txtTongTien.setText("");
			btnChiTiet.setForeground(Color.WHITE);
			btnChiTiet.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.BLACK));
		}
	};
	ActionListener selectDuongPho = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			selectDuongPho();
			nameMaMay.setForeground(Color.white);
			nameDiaChi.setForeground(Color.white);
			nameTongTien.setForeground(Color.white);
			txtMaMay.setText("");
			txtDiaChi.setText("");
			txtTongTien.setText("");
			btnChiTiet.setForeground(Color.WHITE);
			btnChiTiet.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.BLACK));
		}
	};
	ActionListener selectPhuong = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			selectPhuong();
			nameMaMay.setForeground(Color.white);
			nameDiaChi.setForeground(Color.white);
			nameTongTien.setForeground(Color.white);
			txtMaMay.setText("");
			txtDiaChi.setText("");
			txtTongTien.setText("");
			btnChiTiet.setForeground(Color.WHITE);
			btnChiTiet.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.BLACK));
		}
	};

	@SuppressWarnings("unchecked")
	public void selectPhuong() {
		try {
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
		} catch (Exception ex) {

		}
	}

	@SuppressWarnings("unchecked")
	public void selectDuongPho() {
		try {
			arrDuongPho.clear();
			int itemCount = cboDuongPho.getItemCount();

			for (int i = 0; i < itemCount; i++) {
				cboDuongPho.removeItemAt(0);
			}
			ComboItem itemD = (ComboItem) cboPhuong.getSelectedItem();
			String namePhuong = itemD.getName();
			arrDuongPho = DatabaseBaoCaoATM.getDuongPho(namePhuong);
			if (arrDuongPho.isEmpty()) {
				cboDuongPho.addItem("Chưa đặt máy tại đây");
			} else {

				for (String x : arrDuongPho) {
					cboDuongPho.addItem(x);
				}
			}
		} catch (Exception ex) {

		}
	}

	@SuppressWarnings("unchecked")
	public void selectMaMay() {
		try {
			arrMaATM.clear();
			int itemCount = cboMayATM.getItemCount();

			for (int i = 0; i < itemCount; i++) {
				cboMayATM.removeItemAt(0);
			}
			String duongPho = cboDuongPho.getSelectedItem().toString();
			if (duongPho.equals("Chưa đặt máy tại đây")) {
				cboMayATM.addItem("Không có máy nào");
			} else {

				String name = cboDuongPho.getSelectedItem().toString();
				arrMaATM = DatabaseBaoCaoATM.getMaMay(name);
				if (arrMaATM.isEmpty()) {
					cboMayATM.addItem("Không có máy nào");
				} else {
					cboMayATM.addItem("Tất cả");
					for (String x : arrMaATM) {

						cboMayATM.addItem(x);
					}
				}
			}
		} catch (Exception ex) {

		}
	}

	@SuppressWarnings({ "unused", "unchecked", "rawtypes" })
	public void addControl() {

		JPanel pnBaoCaoATM = new JPanel();
		pnBaoCaoATM.setOpaque(false);
		pnBaoCaoATM.setLayout(new BoxLayout(pnBaoCaoATM, BoxLayout.Y_AXIS));
		// panel chọn combobox
		JPanel pnKhuVuc = new JPanel();
		pnKhuVuc.setOpaque(false);
		Border borderKV = BorderFactory.createLineBorder(Color.RED);

		TitledBorder borderTitleKV = BorderFactory.createTitledBorder(borderKV, "Khu vực", TitledBorder.CENTER,
				TitledBorder.DEFAULT_POSITION);
		pnKhuVuc.setBorder(borderTitleKV);
		JLabel nameQuan = new JLabel("Quận: ");

		cboQuan = new JComboBox<>();
		cboQuan.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		cboQuan.setPreferredSize(new Dimension(120, 20));
		ArrayList<ComboItem> arrQuan = new ArrayList<>();
		ArrayList<ComboItem> quan = new ArrayList<>();
		quan = DatabaseDiaChi.getQuan();
		for (ComboItem x : quan) {
			cboQuan.addItem(x);
		}
		JLabel namePhuong = new JLabel("Phường: ");
		cboPhuong = new JComboBox<>();
		cboPhuong.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		cboPhuong.setPreferredSize(new Dimension(150, 20));

		JLabel nameDuongPho = new JLabel("Đường phố: ");
		cboDuongPho = new JComboBox<>();
		cboDuongPho.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		cboDuongPho.setPreferredSize(new Dimension(140, 20));

		JLabel nameMayATM = new JLabel("Máy ATM: ");
		cboMayATM = new JComboBox<>();
		cboMayATM.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		cboMayATM.setPreferredSize(new Dimension(130, 20));

		pnKhuVuc.add(nameQuan);
		pnKhuVuc.add(cboQuan);
		pnKhuVuc.add(namePhuong);
		pnKhuVuc.add(cboPhuong);
		pnKhuVuc.add(nameDuongPho);
		pnKhuVuc.add(cboDuongPho);
		pnKhuVuc.add(nameMayATM);
		pnKhuVuc.add(cboMayATM);
		// panel mã máy

		// thông tin chi tiết

		JPanel pnThongtin = new JPanel();
		pnThongtin.setOpaque(false);
		pnThongtin.setLayout(new BoxLayout(pnThongtin, BoxLayout.Y_AXIS));

		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Thông tin chi tiết", TitledBorder.CENTER,
				TitledBorder.DEFAULT_POSITION);
		pnThongtin.setBorder(borderTitle);

		JPanel pnMaKH = new JPanel();
		pnMaKH.setBorder(BorderFactory.createMatteBorder(2, 2, 0, 2, Color.decode("#191970")));
		pnMaKH.setBackground(Color.WHITE);
		nameMaMay = new JLabel("Mã máy ATM: ");
		nameMaMay.setForeground(Color.WHITE);
		nameMaMay.setPreferredSize(new Dimension(120, 20));
		txtMaMay = new JTextField(25);
		txtMaMay.setEditable(false);
		txtMaMay.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE));
		txtMaMay.setBackground(Color.WHITE);
		pnMaKH.add(nameMaMay);
		pnMaKH.add(txtMaMay);

		JPanel pnSoThe = new JPanel();
		pnSoThe.setBackground(Color.WHITE);
		nameDiaChi = new JLabel("Địa chỉ: ");
		nameDiaChi.setForeground(Color.WHITE);
		nameDiaChi.setPreferredSize(new Dimension(120, 20));
		txtDiaChi = new JTextField(25);
		txtDiaChi.setEditable(false);
		txtDiaChi.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE));
		txtDiaChi.setBackground(Color.WHITE);
		pnSoThe.add(nameDiaChi);
		pnSoThe.add(txtDiaChi);

		JPanel pnTime = new JPanel();
		pnTime.setBackground(Color.WHITE);
		nameTongTien = new JLabel("Tổng tiền trong máy: ");
		nameTongTien.setForeground(Color.WHITE);
		nameTongTien.setPreferredSize(new Dimension(120, 20));
		txtTongTien = new JTextField(25);
		txtTongTien.setEditable(false);
		txtTongTien.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE));
		txtTongTien.setBackground(Color.WHITE);
		pnTime.add(nameTongTien);
		pnTime.add(txtTongTien);

		JPanel pnBtnChiTiet = new JPanel();
		pnBtnChiTiet.setBorder(BorderFactory.createMatteBorder(0, 2, 2, 2, Color.decode("#191970")));
		pnBtnChiTiet.setBackground(Color.WHITE);
		btnChiTiet = new JButton("Xem chi tiết");
		btnChiTiet.setForeground(Color.WHITE);
		btnChiTiet.setPreferredSize(new Dimension(150, 20));
		btnChiTiet.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE));
		btnChiTiet.setBackground(Color.WHITE);
		pnBtnChiTiet.add(btnChiTiet);

		pnThongtin.add(pnMaKH);
		pnThongtin.add(pnSoThe);
		pnThongtin.add(pnTime);
		pnThongtin.add(pnBtnChiTiet);

		// panel sắp xếp
		JPanel pnSapxep = new JPanel();
		pnSapxep.setOpaque(false);
		pnSapxep.setLayout(new BoxLayout(pnSapxep, BoxLayout.X_AXIS));
		pnSapxep.setPreferredSize(new Dimension(850, 30));
		JPanel pnLeft = new JPanel();
		pnLeft.setOpaque(false);
		pnLeft.setPreferredSize(new Dimension(500, 30));
		JPanel pnRight = new JPanel();
		pnRight.setOpaque(false);
		pnRight.setPreferredSize(new Dimension(200, 30));
		JLabel nameSapXep = new JLabel("Sắp xếp: ");
		cboSapXep = new JComboBox();
		cboSapXep.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		cboSapXep.setPreferredSize(new Dimension(160, 20));
		cboSapXep.addItem("theo mã máy ");
		cboSapXep.addItem("theo tổng tiền ");

		pnRight.add(nameSapXep);
		pnRight.add(cboSapXep);

		pnSapxep.add(pnLeft);
		pnSapxep.add(pnRight);

		// panel danh sach giao dịch
		JPanel pnTableGiaoDich = new JPanel();
		pnTableGiaoDich.setOpaque(false);
		Border border11 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle11 = BorderFactory.createTitledBorder(border11, "Danh Sách Giao Dịch");
		pnTableGiaoDich.setBorder(borderTitle11);
		model = new DefaultTableModel();
		tblDanhSachMayATM = new JTable(model);
		tblDanhSachMayATM.setLayout(new BorderLayout());
		model.addColumn("Mã Máy ATM");
		model.addColumn("Địa chỉ");
		model.addColumn("tổng tiền trong máy");
		// đưa dữ liệu qua bên phải
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
		tblDanhSachMayATM.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);

		JScrollPane scroll = new JScrollPane(tblDanhSachMayATM);
		scroll.setOpaque(false);
		scroll.getViewport().setOpaque(false);
		scroll.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode("#191970")));
		pnTableGiaoDich.setLayout(new BorderLayout());
		pnTableGiaoDich.add(scroll, BorderLayout.CENTER);

		pnBaoCaoATM.add(pnKhuVuc);
		pnBaoCaoATM.add(pnThongtin);
		pnBaoCaoATM.add(pnSapxep);
		pnBaoCaoATM.add(pnTableGiaoDich);

		selectPhuong();
		selectDuongPho();
		selectMaMay();
		selectDanhSach();
		// them vào cardlayout

		cl = new CardLayout();

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setOpaque(false);
		// pnMain.setLayout(new BorderLayout());
		JPanel pnMenu = new JPanel();
		pnMenu.setOpaque(false);
		pnMenu.setLayout(new BoxLayout(pnMenu, BoxLayout.X_AXIS));
		JPanel pnbutton = new JPanel();
		pnbutton.setOpaque(false);
		btnBaoCaoATM = new JButton("Tình hình máy ATM");
		btnBaoCaoATM.setBorder(BorderFactory.createMatteBorder(4, 1, 0, 1, Color.black));
		btnBaoCaoATM.setPreferredSize(new Dimension(150, 25));
		btnBaoCaoRutTien = new JButton("Thống kê rút tiền");
		btnBaoCaoRutTien.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		btnBaoCaoRutTien.setPreferredSize(new Dimension(150, 25));
		pnbutton.add(btnBaoCaoATM);
		pnbutton.add(btnBaoCaoRutTien);
		JPanel pnDemo = new JPanel();
		pnDemo.setOpaque(false);
		pnbutton.setPreferredSize(new Dimension(400, 30));
		pnDemo.setPreferredSize(new Dimension(700, 30));
		pnMenu.add(pnbutton);
		pnMenu.add(pnDemo);

		pnSelect = new JPanel(cl);
		pnSelect.setOpaque(false);

		Border border2 = BorderFactory.createLineBorder(Color.RED);

		TitledBorder borderTitle2 = BorderFactory.createTitledBorder(border2, "Báo cáo khách hàng", TitledBorder.CENTER,
				TitledBorder.DEFAULT_POSITION);
		pnBaoCaoATM.setBorder(borderTitle2);

		Border border3 = BorderFactory.createLineBorder(Color.RED);

		TitledBorder borderTitle3 = BorderFactory.createTitledBorder(border3, "Báo cáo khách hàng rút tiền",
				TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);

		// pnRutTienATM.setBorder(borderTitle3);
		pnSelect.add(pnBaoCaoATM, "1");
		pnSelect.add(pnRutTienATM, "2");
		cl.show(pnSelect, "1");
		pnMenu.setPreferredSize(new Dimension(850, 31));
		pnSelect.setPreferredSize(new Dimension(850, 600));
		this.add(pnMenu);
		this.add(pnSelect);

		// bat su kien chọn jpanel
		btnBaoCaoATM.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(pnSelect, "1");
				btnBaoCaoATM.setBorder(BorderFactory.createMatteBorder(4, 1, 0, 1, Color.black));
				btnBaoCaoRutTien.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
				selectDanhSach();
				selectMaMay();
			}
		});
		btnBaoCaoRutTien.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(pnSelect, "2");
				btnBaoCaoATM.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
				btnBaoCaoRutTien.setBorder(BorderFactory.createMatteBorder(4, 1, 0, 1, Color.black));
				pnRutTienATM.selectDanhSach();
				pnRutTienATM.selectMaMay();
			}
		});

	}

}
