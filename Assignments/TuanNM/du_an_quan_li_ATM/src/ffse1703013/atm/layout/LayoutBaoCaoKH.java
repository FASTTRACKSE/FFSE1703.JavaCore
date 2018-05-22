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

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import ffse1703013.atm.model.ThongKeBaoCao;
import ffse1703013.atm.model.ComboItem;
import ffse1703013.atm.model.DatabaseBaoCaoKH;
import ffse1703013.atm.model.DatabaseDiaChi;

@SuppressWarnings("serial")
public class LayoutBaoCaoKH extends JPanel {
	private ArrayList<ComboItem> phuong = new ArrayList<>();
	private ArrayList<ThongKeBaoCao> arrBC = new ArrayList<ThongKeBaoCao>();
	@SuppressWarnings("rawtypes")
	private JComboBox cboQuan, cboPhuong, cboSapXep;
	private DefaultTableModel model;
	private JTable tblBaoCaoKH;
	private JTextField txtMaKH, txtTenKH, txtSoLan, txtTongTien,txtSoDu;
	private JLabel nameMaKH, nameTenKH, nameSoLan, nameTongTien,nameSoDu;
	private PlaceholderTextField txtTimKiemTen;
	private DatabaseBaoCaoKH connectBC = new DatabaseBaoCaoKH();
	private CardLayout cl;
	private JPanel pnSelect;
	public JButton btnChiTiet;
	private LayoutBaoCaoRutTienKH pnBaoCaoRutTien = new LayoutBaoCaoRutTienKH();
	private JButton btnBaoCaoKH, btnBaoCaoRutTien;

	public LayoutBaoCaoKH() {
		addControll();
		addEvents();
		SelectKhachHang();
	}

	public void addEvents() {
		cboQuan.addActionListener(selectPhuong);
		cboPhuong.addActionListener(chonPhuong);
		tblBaoCaoKH.getSelectionModel().addListSelectionListener(chonHang);
		txtTimKiemTen.getDocument().addDocumentListener(searchTheoMa);
		cboSapXep.addActionListener(sapXep);
		btnChiTiet.addActionListener(xemChiTiet);
	}

	ActionListener xemChiTiet = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			cl.show(pnSelect, "2");
			String maKH = txtMaKH.getText();
			pnBaoCaoRutTien.txtMaKhachHang.setText(maKH);
			pnBaoCaoRutTien.duLieu();
			btnBaoCaoKH.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
			btnBaoCaoRutTien.setBorder(BorderFactory.createMatteBorder(4, 1, 0, 1, Color.black));
		}
	};
	DocumentListener searchTheoMa = new DocumentListener() {

		@Override
		public void removeUpdate(DocumentEvent e) {
			model.setRowCount(0);
			search();
		}

		@Override
		public void insertUpdate(DocumentEvent e) {
			model.setRowCount(0);
			search();
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			model.setRowCount(0);
			search();
		}
	};

	public void search() {
		String tenKH1 = txtTimKiemTen.getText();

		if (tenKH1.isEmpty()) {
			model.setRowCount(0);
			arrBC.clear();
			duLieu();
		} else {
			for (ThongKeBaoCao bc : arrBC) {
				if(bc.getTenKH().toUpperCase().indexOf(tenKH1.toUpperCase()) > -1) {
				DecimalFormat formatter = new DecimalFormat("###,###,###");
				String soTien = formatter.format(bc.getTongTien()) + " VNĐ";
				
				int soTienTrongThe = Integer.parseInt(bc.getSoDu());
				String soDu = formatter.format(soTienTrongThe) + " VNĐ";
				String[] row = { bc.getMaKH(), bc.getTenKH(), Integer.toString(bc.getSoLanRut()),
						soTien ,soDu};
				model.addRow(row);
				}
			}
		}

	}

	ActionListener selectPhuong = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			selectPhuong();
			nameMaKH.setForeground(Color.white);
			nameTenKH.setForeground(Color.white);

			nameSoLan.setForeground(Color.white);
			nameTongTien.setForeground(Color.white);
			txtMaKH.setText("");
			txtTenKH.setText("");

			txtSoLan.setText("");
			txtTongTien.setText("");
			txtSoDu.setText("");

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

	ActionListener chonPhuong = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			SelectKhachHang();
		}
	};
	public void SelectKhachHang() {
		try {
			String phuong1 = cboPhuong.getSelectedItem().toString();
			String quan1 = cboQuan.getSelectedItem().toString();
			arrBC.clear();
			arrBC = connectBC.selectKhachHangTheoQuan(quan1, phuong1);
			model.setRowCount(0);
			for (ThongKeBaoCao bc : arrBC) {

				DecimalFormat formatter = new DecimalFormat("###,###,###");
				String soTien = formatter.format(bc.getTongTien()) + " VNĐ";
				int soTienTrongThe = Integer.parseInt(bc.getSoDu());
				String soDu = formatter.format(soTienTrongThe) + " VNĐ";
				String[] row = { bc.getMaKH(), bc.getTenKH(), Integer.toString(bc.getSoLanRut()),
						soTien ,soDu};
				model.addRow(row);
			}
			nameMaKH.setForeground(Color.white);
			nameTenKH.setForeground(Color.white);
			nameSoLan.setForeground(Color.white);
			nameTongTien.setForeground(Color.white);
			txtMaKH.setText("");
			txtTenKH.setText("");
			txtSoLan.setText("");
			txtTongTien.setText("");
			txtSoDu.setText("");
			btnChiTiet.setBackground(Color.WHITE);
			btnChiTiet.setForeground(Color.WHITE);
			btnChiTiet.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE));
			btnChiTiet.setPreferredSize(new Dimension(150, 20));
		} catch (Exception ex) {

		}
	}
	ListSelectionListener chonHang = new ListSelectionListener() {

		@Override
		public void valueChanged(ListSelectionEvent e) {
			try {
				int i = tblBaoCaoKH.getSelectedRow();

				if (i >= 0 && !e.getValueIsAdjusting()) {
					String ma = tblBaoCaoKH.getValueAt(i, 0).toString();
					duaDuLieuVaoInput(ma);

				}
				nameMaKH.setForeground(Color.black);
				nameTenKH.setForeground(Color.black);
				nameSoLan.setForeground(Color.black);
				nameTongTien.setForeground(Color.black);
				nameSoDu.setForeground(Color.black);
				btnChiTiet.setForeground(Color.black);
				btnChiTiet.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

			} catch (Exception ex) {

			}

		}

	};

	private void duaDuLieuVaoInput(String i) {

		for (ThongKeBaoCao gd : arrBC) {
			if (i.equals(gd.getMaKH())) {
				txtMaKH.setText(gd.getMaKH());
				txtTenKH.setText(gd.getTenKH());
				DecimalFormat formatter = new DecimalFormat("###,###,###");
				String soTien = formatter.format(gd.getTongTien()) + " VNĐ";
				int soTienTrongThe = Integer.parseInt(gd.getSoDu());
				String soDu = formatter.format(soTienTrongThe) + " VNĐ";
				txtSoLan.setText(Integer.toString(gd.getSoLanRut()) + " Lần");
				txtTongTien.setText(soTien);
				txtSoDu.setText(soDu);

			}
		}

	}

	public void duLieu() {
		String phuong1 = cboPhuong.getSelectedItem().toString();
		String quan1 = cboQuan.getSelectedItem().toString();
		arrBC.clear();
		arrBC = connectBC.selectKhachHangTheoQuan(quan1, phuong1);
		model.setRowCount(0);
		for (ThongKeBaoCao bc : arrBC) {

			DecimalFormat formatter = new DecimalFormat("###,###,###");
			String soTien = formatter.format(bc.getTongTien()) + " VNĐ";
			int soTienTrongThe = Integer.parseInt(bc.getSoDu());
			String soDu = formatter.format(soTienTrongThe) + " VNĐ";
			String[] row = { bc.getMaKH(), bc.getTenKH(), Integer.toString(bc.getSoLanRut()),
					soTien ,soDu};
			model.addRow(row);
		}
	}

	ActionListener sapXep = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			String sx = cboSapXep.getSelectedItem().toString();
			if (sx == "theo tên khách hàng ") {
				model.setRowCount(0);
				Collections.sort(arrBC, ThongKeBaoCao.sortName);
				for (ThongKeBaoCao bc : arrBC) {
					DecimalFormat formatter = new DecimalFormat("###,###,###");
					String soTien = formatter.format(bc.getTongTien()) + " VNĐ";
					int soTienTrongThe = Integer.parseInt(bc.getSoDu());
					String soDu = formatter.format(soTienTrongThe) + " VNĐ";
					String[] row = { bc.getMaKH(), bc.getTenKH(), Integer.toString(bc.getSoLanRut()),
							soTien ,soDu};
					model.addRow(row);
				}
			} else if (sx == "theo Tổng Tiền rút ") {
				model.setRowCount(0);
				Collections.sort(arrBC, ThongKeBaoCao.sortTongTien);
				for (ThongKeBaoCao bc : arrBC) {
					DecimalFormat formatter = new DecimalFormat("###,###,###");
					String soTien = formatter.format(bc.getTongTien()) + " VNĐ";
					int soTienTrongThe = Integer.parseInt(bc.getSoDu());
					String soDu = formatter.format(soTienTrongThe) + " VNĐ";
					String[] row = { bc.getMaKH(), bc.getTenKH(), Integer.toString(bc.getSoLanRut()),
							soTien ,soDu};
					model.addRow(row);
				}
			}
		}
	};

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void addControll() {

		JPanel pnRutTienKH = new JPanel();
		pnRutTienKH.setOpaque(false);
		pnRutTienKH.setLayout(new BoxLayout(pnRutTienKH, BoxLayout.Y_AXIS));
		// panel chọn địa chỉ
		JPanel pnDiaChi = new JPanel();
		pnDiaChi.setOpaque(false);
		JLabel nameDiaChi = new JLabel("Khách hàng:");
		cboQuan = new JComboBox<>();
		cboQuan.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		cboQuan.setPreferredSize(new Dimension(150, 20));
		ArrayList<ComboItem> quan = new ArrayList<>();
		quan = DatabaseDiaChi.getQuan();
		for (ComboItem x : quan) {
			cboQuan.addItem(x);
		}
		cboPhuong = new JComboBox<>();
		cboPhuong.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		cboPhuong.setPreferredSize(new Dimension(150, 20));
		cboPhuong.addItem("chọn phường");
		pnDiaChi.add(nameDiaChi);
		pnDiaChi.add(cboQuan);
		pnDiaChi.add(cboPhuong);
		// panel thông tin chi tiết

		JPanel pnChiTiet = new JPanel();
		pnChiTiet.setOpaque(false);
		pnChiTiet.setLayout(new BoxLayout(pnChiTiet, BoxLayout.Y_AXIS));
		Border border = BorderFactory.createLineBorder(Color.blue);

		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Thông tin chi tiết", TitledBorder.CENTER,
				TitledBorder.DEFAULT_POSITION);

		pnChiTiet.setBorder(borderTitle);

		JPanel pnMaKH = new JPanel();
		pnMaKH.setBorder(BorderFactory.createMatteBorder(2, 2, 0, 2, Color.decode("#191970")));
		pnMaKH.setBackground(Color.WHITE);
		nameMaKH = new JLabel("Mã khách hàng: ");
		nameMaKH.setForeground(Color.WHITE);
		nameMaKH.setPreferredSize(new Dimension(110, 20));
		txtMaKH = new JTextField(20);
		txtMaKH.setEditable(false);
		txtMaKH.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE));
		txtMaKH.setBackground(Color.WHITE);
		pnMaKH.add(nameMaKH);
		pnMaKH.add(txtMaKH);

		JPanel pnTenKH = new JPanel();
		pnTenKH.setBackground(Color.WHITE);
		nameTenKH = new JLabel("Tên khách hàng: ");
		nameTenKH.setForeground(Color.WHITE);
		nameTenKH.setPreferredSize(new Dimension(110, 20));
		txtTenKH = new JTextField(20);
		txtTenKH.setEditable(false);
		txtTenKH.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE));
		txtTenKH.setBackground(Color.WHITE);
		pnTenKH.add(nameTenKH);
		pnTenKH.add(txtTenKH);

		JPanel pnSoLan = new JPanel();
		pnSoLan.setBackground(Color.WHITE);
		nameSoLan = new JLabel("Số lần rút tiền: ");
		nameSoLan.setForeground(Color.WHITE);
		nameSoLan.setPreferredSize(new Dimension(110, 20));
		txtSoLan = new JTextField(20);
		txtSoLan.setEditable(false);
		txtSoLan.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE));
		txtSoLan.setBackground(Color.WHITE);
		pnSoLan.add(nameSoLan);
		pnSoLan.add(txtSoLan);

		JPanel pnTongTien = new JPanel();
		pnTongTien.setBackground(Color.WHITE);
		nameTongTien = new JLabel("Tổng tiền đã rút: ");
		nameTongTien.setForeground(Color.WHITE);
		nameTongTien.setPreferredSize(new Dimension(110, 20));
		txtTongTien = new JTextField(20);
		txtTongTien.setEditable(false);
		txtTongTien.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE));
		txtTongTien.setBackground(Color.WHITE);
		pnTongTien.add(nameTongTien);
		pnTongTien.add(txtTongTien);
		
		JPanel pnSoDu = new JPanel();
		pnSoDu .setBackground(Color.WHITE);
		nameSoDu  = new JLabel("Số dư: ");
		nameSoDu.setForeground(Color.WHITE);
		nameSoDu.setPreferredSize(new Dimension(110, 20));
		txtSoDu  = new JTextField(20);
		txtSoDu.setEditable(false);
		txtSoDu.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE));
		txtSoDu.setBackground(Color.WHITE);
		pnSoDu.add(nameSoDu);
		pnSoDu.add(txtSoDu);

		JPanel pnBtnChiTiet = new JPanel();
		pnBtnChiTiet.setBorder(BorderFactory.createMatteBorder(0, 2, 2, 2, Color.decode("#191970")));
		pnBtnChiTiet.setBackground(Color.WHITE);
		btnChiTiet = new JButton("Xem chi tiết");
		pnBtnChiTiet.add(btnChiTiet);
		btnChiTiet.setBackground(Color.WHITE);
		btnChiTiet.setForeground(Color.WHITE);
		btnChiTiet.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE));
		

		pnChiTiet.add(pnMaKH);
		pnChiTiet.add(pnTenKH);
		pnChiTiet.add(pnSoLan);
		pnChiTiet.add(pnTongTien);
		pnChiTiet.add(pnSoDu);
		pnChiTiet.add(pnBtnChiTiet);

		// panel tìm kiếm

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
		txtTimKiemTen = new PlaceholderTextField(20);
		txtTimKiemTen.setPlaceholder("nhập tên khách hàng??");
		txtTimKiemTen.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		JButton buttonTimKiemTen = new JButton("Tìm kiếm");
		buttonTimKiemTen.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		pnLeft.setPreferredSize(new Dimension(300, 30));
		pnLeft.add(txtTimKiemTen);
		pnLeft.add(buttonTimKiemTen);

		JPanel pnRight = new JPanel();
		pnRight.setOpaque(false);
		pnRight.setPreferredSize(new Dimension(200, 30));
		JLabel nameSapXep = new JLabel("Sắp xếp: ");
		cboSapXep = new JComboBox();
		cboSapXep.setPreferredSize(new Dimension(160, 20));
		cboSapXep.addItem("theo tên khách hàng ");
		cboSapXep.addItem("theo Tổng Tiền rút ");

		pnRight.add(nameSapXep);
		pnRight.add(cboSapXep);

		pnChoosePQ.add(pnRight);
		pnChoosePQ.add(pnLeft);

		// panel danh sach giao dịch
		JPanel pnTableBaoCaoKH = new JPanel();
		pnTableBaoCaoKH.setOpaque(false);
		Border border111 = BorderFactory.createLineBorder(Color.blue);
		TitledBorder borderTitle111 = BorderFactory.createTitledBorder(border111, "Danh Sách Giao Dịch",
				TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
		pnTableBaoCaoKH.setBorder(borderTitle111);
		model = new DefaultTableModel();
		tblBaoCaoKH = new JTable(model);
		tblBaoCaoKH.setLayout(new BorderLayout());
		model.addColumn("Mã khách hàng");
		model.addColumn("Tên khách hàng");
		model.addColumn("Số lần rút tiền");
		model.addColumn("Tổng tiền rút");
		model.addColumn("Số dư");
		//đưa dữ liêu qua bên phải
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
		tblBaoCaoKH.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
		tblBaoCaoKH.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
		tblBaoCaoKH.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
		
		JScrollPane scroll = new JScrollPane(tblBaoCaoKH);
		scroll.setOpaque(false);
		scroll.getViewport().setOpaque(false);
		scroll.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode("#191970")));
		pnTableBaoCaoKH.setLayout(new BorderLayout());
		pnTableBaoCaoKH.add(scroll, BorderLayout.CENTER);

		// add vào panel chính
		pnRutTienKH.add(pnDiaChi);
		pnRutTienKH.add(pnChiTiet);
		pnRutTienKH.add(pnChoosePQ);
		pnRutTienKH.add(pnTableBaoCaoKH);

		cl = new CardLayout();

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setOpaque(false);
		// pnMain.setLayout(new BorderLayout());
		JPanel pnMenu = new JPanel();
		pnMenu.setOpaque(false);
		pnMenu.setLayout(new BoxLayout(pnMenu, BoxLayout.X_AXIS));
		JPanel pnbutton = new JPanel();
		pnbutton.setOpaque(false);

		btnBaoCaoKH = new JButton("Thống kê khách hàng");
		btnBaoCaoKH.setPreferredSize(new Dimension(150, 25));
		btnBaoCaoKH.setBorder(BorderFactory.createMatteBorder(4, 1, 0, 1, Color.black));
		btnBaoCaoRutTien = new JButton("Thống kê khách hàng rút tiền");
		btnBaoCaoRutTien.setPreferredSize(new Dimension(200, 25));
		btnBaoCaoRutTien.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		pnbutton.add(btnBaoCaoKH);
		pnbutton.add(btnBaoCaoRutTien);
		JPanel pnDemo = new JPanel();
		pnDemo.setOpaque(false);
		pnbutton.setPreferredSize(new Dimension(400, 30));
		pnDemo.setPreferredSize(new Dimension(700, 30));
		pnMenu.add(pnbutton);
		pnMenu.add(pnDemo);

		pnSelect = new JPanel(cl);
		pnSelect.setOpaque(false);

		Border border2 = BorderFactory.createLineBorder(Color.blue);

		TitledBorder borderTitle2 = BorderFactory.createTitledBorder(border2, "Báo cáo khách hàng", TitledBorder.CENTER,
				TitledBorder.DEFAULT_POSITION);
		pnRutTienKH.setBorder(borderTitle2);

		Border border3 = BorderFactory.createLineBorder(Color.blue);

		TitledBorder borderTitle3 = BorderFactory.createTitledBorder(border3, "Báo cáo khách hàng rút tiền",
				TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
		pnBaoCaoRutTien.setBorder(borderTitle3);
		pnSelect.add(pnRutTienKH, "1");
		pnSelect.add(pnBaoCaoRutTien, "2");
		cl.show(pnSelect, "1");
		pnMenu.setPreferredSize(new Dimension(850, 31));
		pnSelect.setPreferredSize(new Dimension(850, 600));
		this.add(pnMenu);
		this.add(pnSelect);

		btnBaoCaoKH.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(pnSelect, "1");
				btnBaoCaoKH.setBorder(BorderFactory.createMatteBorder(4, 1, 0, 1, Color.black));
				btnBaoCaoRutTien.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
			}
		});
		btnBaoCaoRutTien.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(pnSelect, "2");
				btnBaoCaoKH.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
				btnBaoCaoRutTien.setBorder(BorderFactory.createMatteBorder(4, 1, 0, 1, Color.black));
			}
		});
		selectPhuong();
	}

}
