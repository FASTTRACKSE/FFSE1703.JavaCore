package namdv.ui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import namdv.main.MyApp;
import namdv.model.BanDocModel;
import namdv.model.CheckLogin;
import namdv.model.ComboItem;
import namdv.model.PlaceholderTextField;
import namdv.model.SachModel;
import namdv.model.XTableColumnModel;

public class ThongKeBaoCao extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PlaceholderTextField txtFldMaThanhVien, txtFldTacGia;
	@SuppressWarnings("rawtypes")
	private JComboBox cbBxNhaXuatBan, cbBxTheLoai, cbBxThanhPho;
	private JTable tblResult;
	private JRadioButton rdbtnThongKeBanDoc, rdbtnThongKeDauSach, rdbtnThongKeMuonTra;
	private JPanel pnlOptionBanDoc, pnlOptionSach, pnlShowBanDoc, pnlShowSach;
	private JButton btnSearchBanDoc, btnSearchSach, btnThoat;
	private JCheckBox chckbxMaBanDoc, chckbxTen, chckbxDiaChi, chckbxPhuong, chckbxQuan, chckbxThanhPho, chckbxEmail,
			chckbxDienThoai, chckbxSoSachDangMuon, chckbxMaSach, chckbxTenSach, chckbxTacGia, chckbxNhaXuatBan,
			chckbxTheLoai, chckbxNamXuatBan, chckbxSoLuongTong, chckbxSoLuongTrongKho;

	private String[] columnNames = { "Mã bạn đọc", "Tên", "Địa chỉ", "Phường", "Quận", "Thành phố", "Email",
			"Điện thoại", "Số sách đang mượn", "Mã sách", "Tên", "Tác giả", "Nhà xuất bản", "Thể loại", "Năm xuất bản",
			"Số lượng tổng", "Số lượng trong kho" };
	private DefaultTableModel tblResultModel = new DefaultTableModel(columnNames, 0);

	private ArrayList<JCheckBox> arrChckbx = new ArrayList<JCheckBox>();
	private XTableColumnModel columnModel = new XTableColumnModel();
	private BanDocModel banDocModel = new BanDocModel();
	private SachModel sachModel = new SachModel();

	/**
	 * Create the frame.
	 */
	public ThongKeBaoCao() {
		addControls();
		addEvents();
	}

	private void addEvents() {
		// TODO Auto-generated method stub
		rdbtnThongKeBanDoc.addActionListener(new ThongKeListener());
		rdbtnThongKeDauSach.addActionListener(new ThongKeListener());
		btnSearchBanDoc.addActionListener(new SearchBanDocListener());
		btnSearchSach.addActionListener(new SearchSachListener());

		txtFldMaThanhVien.addActionListener(new EnterBanDocListener());
		txtFldTacGia.addActionListener(new EnterSachListener());

		for (JCheckBox cb : arrChckbx) {
			cb.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					TableColumn column = columnModel.getColumnByModelIndex(arrChckbx.indexOf(cb));
					boolean visible = columnModel.isColumnVisible(column);
					columnModel.setColumnVisible(column, !visible);
				}
			});
		}

		btnThoat.addActionListener(new ThoatListener());
	}

	@SuppressWarnings({ "rawtypes" })
	private void addControls() {
		// CENTER
		JPanel pnlCenter = new JPanel();
		pnlCenter.setBorder(new EmptyBorder(5, 5, 5, 5));
		pnlCenter.setLayout(new BoxLayout(pnlCenter, BoxLayout.Y_AXIS));

		// Option
		JPanel pnlOption = new JPanel();
		pnlCenter.add(pnlOption);

		JLabel lblBaoCao = new JLabel("Báo cáo: ");
		pnlOption.add(lblBaoCao);

		rdbtnThongKeBanDoc = new JRadioButton("Thống kê bạn đọc");
		pnlOption.add(rdbtnThongKeBanDoc);

		rdbtnThongKeDauSach = new JRadioButton("Thống kê đầu sách");
		pnlOption.add(rdbtnThongKeDauSach);

		rdbtnThongKeMuonTra = new JRadioButton("Thống kê mượn trả");
		//pnlOption.add(rdbtnThongKeMuonTra);

		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnThongKeDauSach);
		bg.add(rdbtnThongKeBanDoc);
		//bg.add(rdbtnThongKeMuonTra);

		// Bạn đọc
		pnlOptionBanDoc = new JPanel();
		pnlOptionBanDoc.setVisible(false);
		pnlOptionBanDoc.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnlCenter.add(pnlOptionBanDoc);
		pnlOptionBanDoc.setLayout(new BoxLayout(pnlOptionBanDoc, BoxLayout.Y_AXIS));

		JPanel pnlSearchBanDoc = new JPanel();
		pnlOptionBanDoc.add(pnlSearchBanDoc);

		JLabel lblThanhPho = new JLabel("Thành phố:");
		pnlSearchBanDoc.add(lblThanhPho);

		cbBxThanhPho = new JComboBox();
		pnlSearchBanDoc.add(cbBxThanhPho);
		getThanhPho();

		JLabel lblMaThanhVien = new JLabel("       Mã thành viên:");
		pnlSearchBanDoc.add(lblMaThanhVien);

		txtFldMaThanhVien = new PlaceholderTextField();
		txtFldMaThanhVien.setPreferredSize(new Dimension(150, 22));
		txtFldMaThanhVien.setPlaceholder("e.g. 00001");
		pnlSearchBanDoc.add(txtFldMaThanhVien);

		btnSearchBanDoc = new JButton("Tìm");
		pnlSearchBanDoc.add(btnSearchBanDoc);

		pnlShowBanDoc = new JPanel();
		pnlOptionBanDoc.add(pnlShowBanDoc);

		chckbxMaBanDoc = new JCheckBox("Mã bạn đọc", true);
		addChkbx(chckbxMaBanDoc, pnlShowBanDoc);

		chckbxTen = new JCheckBox("Tên", true);
		addChkbx(chckbxTen, pnlShowBanDoc);

		chckbxDiaChi = new JCheckBox("Địa chỉ");
		addChkbx(chckbxDiaChi, pnlShowBanDoc);

		chckbxPhuong = new JCheckBox("Phường");
		addChkbx(chckbxPhuong, pnlShowBanDoc);

		chckbxQuan = new JCheckBox("Quận");
		addChkbx(chckbxQuan, pnlShowBanDoc);

		chckbxThanhPho = new JCheckBox("Thành Phố", true);
		addChkbx(chckbxThanhPho, pnlShowBanDoc);

		chckbxEmail = new JCheckBox("Email");
		addChkbx(chckbxEmail, pnlShowBanDoc);

		chckbxDienThoai = new JCheckBox("Điện thoại");
		addChkbx(chckbxDienThoai, pnlShowBanDoc);

		chckbxSoSachDangMuon = new JCheckBox("Số sách đang mượn", true);
		addChkbx(chckbxSoSachDangMuon, pnlShowBanDoc);

		// Sách
		pnlOptionSach = new JPanel();
		pnlOptionSach.setVisible(false);
		pnlOptionSach.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnlCenter.add(pnlOptionSach);
		pnlOptionSach.setLayout(new BoxLayout(pnlOptionSach, BoxLayout.Y_AXIS));

		JPanel pnlSearchSach = new JPanel();
		pnlOptionSach.add(pnlSearchSach);

		JLabel lblNhaXuatBan = new JLabel("Nhà xuất bản:");
		pnlSearchSach.add(lblNhaXuatBan);

		cbBxNhaXuatBan = new JComboBox();
		cbBxNhaXuatBan.setPreferredSize(new Dimension(165, 22));
		pnlSearchSach.add(cbBxNhaXuatBan);

		getNhaXuatBan();

		JLabel lblTheLoai = new JLabel("       Thể loại:");
		pnlSearchSach.add(lblTheLoai);

		cbBxTheLoai = new JComboBox();
		cbBxTheLoai.setPreferredSize(new Dimension(165, 22));
		pnlSearchSach.add(cbBxTheLoai);

		getTheLoai();

		JLabel lblTacGia = new JLabel("       Tác giả:");
		pnlSearchSach.add(lblTacGia);

		txtFldTacGia = new PlaceholderTextField();
		txtFldTacGia.setPreferredSize(new Dimension(150, 22));
		txtFldTacGia.setPlaceholder("e.g. Đặng Văn Nam");
		pnlSearchSach.add(txtFldTacGia);

		btnSearchSach = new JButton("Tìm");
		pnlSearchSach.add(btnSearchSach);

		pnlShowSach = new JPanel();
		pnlOptionSach.add(pnlShowSach);

		chckbxMaSach = new JCheckBox("Mã sách", true);
		addChkbx(chckbxMaSach, pnlShowSach);

		chckbxTenSach = new JCheckBox("Tên", true);
		addChkbx(chckbxTenSach, pnlShowSach);

		chckbxTacGia = new JCheckBox("Tác giả");
		addChkbx(chckbxTacGia, pnlShowSach);

		chckbxNhaXuatBan = new JCheckBox("Nhà xuất bản");
		addChkbx(chckbxNhaXuatBan, pnlShowSach);

		chckbxTheLoai = new JCheckBox("Thể loại");
		addChkbx(chckbxTheLoai, pnlShowSach);

		chckbxNamXuatBan = new JCheckBox("Năm xuất bản");
		addChkbx(chckbxNamXuatBan, pnlShowSach);

		chckbxSoLuongTong = new JCheckBox("Số lượng tổng", true);
		addChkbx(chckbxSoLuongTong, pnlShowSach);

		chckbxSoLuongTrongKho = new JCheckBox("Số lượng trong kho", true);
		addChkbx(chckbxSoLuongTrongKho, pnlShowSach);

		// Mượn trả

		// Search result
		JScrollPane scrollPaneResult = new JScrollPane();
		pnlCenter.add(scrollPaneResult);

		tblResult = new JTable();

		tblResult.setModel(tblResultModel);

		tblResult.setColumnModel(columnModel);
		tblResult.createDefaultColumnsFromModel();

		for (int i = 0; i < 17; i++) {
			TableColumn column = columnModel.getColumnByModelIndex(i);
			columnModel.setColumnVisible(column, false);
		}

		scrollPaneResult.setViewportView(tblResult);

		// FOOTER
		JPanel footer = new JPanel();
		FlowLayout fl_footer = (FlowLayout) footer.getLayout();
		fl_footer.setHgap(15);

		JButton btnXuat = new JButton("Xuất báo cáo");
		footer.add(btnXuat);

		btnThoat = new JButton("Thoát");
		footer.add(btnThoat);

		// ADD TO Jpnl
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(pnlCenter);
		this.add(footer);

	}

	private void addChkbx(JCheckBox jChckbx, JPanel pnl) {
		arrChckbx.add(jChckbx);
		pnl.add(jChckbx);
	}

	private class ThongKeListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			tblResultModel.setRowCount(0);
			setColTable();
		}
	}

	public void setColTable() {
		boolean isBanDoc;
		int indexHide, indexShow, i, j;
		if (rdbtnThongKeBanDoc.isSelected()) {
			isBanDoc = true;
			indexShow = 0;
			indexHide = i = 9;
			j = 17;
		} else {
			isBanDoc = false;
			indexShow = j = 9;
			indexHide = 0;
			i = 17;
		}
		pnlOptionSach.setVisible(!isBanDoc);
		pnlOptionBanDoc.setVisible(isBanDoc);

		for (int k = indexShow; k < i; k++) {
			TableColumn column = columnModel.getColumnByModelIndex(k);
			columnModel.setColumnVisible(column, arrChckbx.get(k).isSelected());
		}

		for (int k = indexHide; k < j; k++) {
			TableColumn column = columnModel.getColumnByModelIndex(k);
			columnModel.setColumnVisible(column, false);
		}
	}

	private class SearchBanDocListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				tblResultModel.setRowCount(0);
				String[] where = { "1", "1" }, value = { "1", "1" };

				String thanhPho = ((ComboItem) cbBxThanhPho.getSelectedItem()).getKey();
				String maThanhVien = txtFldMaThanhVien.getText();

				if (!thanhPho.equals("0")) {
					where[0] = "thanh_pho";
					value[0] = thanhPho;
				}
				if (!maThanhVien.isEmpty()) {
					where[1] = "id";
					value[1] = maThanhVien;
				}

				ResultSet rs = banDocModel.getBanDoc(where, value);
				int row = 0;
				columnModel.setAllColumnsVisible();
				while ((rs != null) && (rs.next())) {
					tblResultModel.addRow(new Object[0]);
					tblResultModel.setValueAt(rs.getString("id"), row, 0);
					tblResultModel.setValueAt(rs.getString("ho_ten"), row, 1);
					tblResultModel.setValueAt(rs.getString("dia_chi"), row, 2);
					tblResultModel.setValueAt(rs.getString("gsovn_xaphuongthitran.name"), row, 3);
					tblResultModel.setValueAt(rs.getString("gsovn_quanhuyen.name"), row, 4);
					tblResultModel.setValueAt(rs.getString("gsovn_tinhthanhpho.name"), row, 5);
					tblResultModel.setValueAt(rs.getString("email"), row, 6);
					tblResultModel.setValueAt(rs.getString("dien_thoai"), row, 7);
					tblResultModel.setValueAt(rs.getString("so_sach_dang_muon"), row, 8);
					row++;
				}
				setColTable();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	private class SearchSachListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				tblResultModel.setRowCount(0);
				String[] where = { "1", "1", "1" }, value = { "1", "1", "1" };

				String nhaXuatBan = ((ComboItem) cbBxNhaXuatBan.getSelectedItem()).getKey();
				String theLoai = ((ComboItem) cbBxTheLoai.getSelectedItem()).getKey();
				String tacGia = txtFldTacGia.getText();

				if (!nhaXuatBan.equals("0")) {
					where[0] = "nha_xuat_ban";
					value[0] = nhaXuatBan;
				}
				if (!theLoai.equals("0")) {
					where[1] = "the_loai";
					value[1] = theLoai;
				}
				if (!tacGia.isEmpty()) {
					where[2] = "tac_gia";
					value[2] = tacGia;
				}

				ResultSet rs = sachModel.getSach(where, value);
				int row = 0;
				columnModel.setAllColumnsVisible();
				while ((rs != null) && (rs.next())) {
					tblResultModel.addRow(new Object[0]);
					tblResultModel.setValueAt(rs.getString("id"), row, 9);
					tblResultModel.setValueAt(rs.getString("ten_sach"), row, 10);
					tblResultModel.setValueAt(rs.getString("tac_gia"), row, 11);
					tblResultModel.setValueAt(rs.getString("ten_nha_xuat_ban"), row, 12);
					tblResultModel.setValueAt(rs.getString("ten_the_loai"), row, 13);
					tblResultModel.setValueAt(rs.getString("nam_xuat_ban"), row, 14);
					tblResultModel.setValueAt(rs.getString("so_luong_tong"), row, 15);
					tblResultModel.setValueAt(rs.getString("so_luong_kho"), row, 16);
					row++;
				}
				setColTable();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	@SuppressWarnings({ "unchecked" })
	private void getThanhPho() {
		try {
			ComboItem item;
			cbBxThanhPho.addItem(new ComboItem("0", "Tất cả"));

			ResultSet rs = banDocModel.getThanhPho();
			while ((rs != null) && (rs.next())) {
				item = new ComboItem(rs.getString("matp"), rs.getString("name"));
				cbBxThanhPho.addItem(item);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@SuppressWarnings({ "unchecked" })
	private void getNhaXuatBan() {
		try {
			ComboItem item;
			cbBxNhaXuatBan.addItem(new ComboItem("0", "Tất cả"));

			ResultSet rs = sachModel.getNhaXuatBan();
			while ((rs != null) && (rs.next())) {
				item = new ComboItem(rs.getString("id"), rs.getString("ten_nha_xuat_ban"));
				cbBxNhaXuatBan.addItem(item);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@SuppressWarnings({ "unchecked" })
	private void getTheLoai() {
		try {
			ComboItem item;
			cbBxTheLoai.addItem(new ComboItem("0", "Tất cả"));

			ResultSet rs = sachModel.getTheLoai();
			while ((rs != null) && (rs.next())) {
				item = new ComboItem(rs.getString("id"), rs.getString("ten_the_loai"));
				cbBxTheLoai.addItem(item);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private class ThoatListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			CheckLogin.setLoggedrole(null);
			MyApp.mainFrame.dispose();
			MyApp.loginFrame = new LoginUI("Đăng nhập hệ thống");
		}
	}

	private class EnterBanDocListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			btnSearchBanDoc.doClick();
			int end = txtFldMaThanhVien.getText().length();
			txtFldMaThanhVien.setCaretPosition(end);
		}
	}

	private class EnterSachListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			btnSearchSach.doClick();
			int end = txtFldTacGia.getText().length();
			txtFldTacGia.setCaretPosition(end);
		}
	}
}