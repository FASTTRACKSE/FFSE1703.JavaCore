package ffse1703020.qltv.ui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import ffse1703020.qltv.main.MyApp;
import ffse1703020.qltv.model.BanDocModel;
import ffse1703020.qltv.model.CheckLogin;
import ffse1703020.qltv.model.ComboItem;
import ffse1703020.qltv.model.MuonTraSachModel;
import ffse1703020.qltv.model.PlaceholderTextField;
import ffse1703020.qltv.model.SachModel;
import ffse1703020.qltv.model.XTableColumnModel;

public class ThongKeBaoCao extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PlaceholderTextField txtFldMaThanhVien, txtFldTacGia, txtFldId;
	@SuppressWarnings("rawtypes")
	private JComboBox cbBxNhaXuatBan, cbBxTheLoai, cbBxThanhPho, cbBxId, cbBxMuonTra, cbBxTinhTrang;
	private JTable tblResult;
	private JRadioButton rdbtnThongKeBanDoc, rdbtnThongKeDauSach, rdbtnThongKeMuonTra;
	private JPanel pnlOptionBanDoc, pnlOptionSach, pnlOptionMuonTra, pnlShowBanDoc, pnlShowSach, pnlShowMuonTra;
	private JButton btnSearchBanDoc, btnSearchSach, btnSearchMuonTra, btnExport, btnThoat;
	private JCheckBox chckbxMaBanDoc, chckbxTen, chckbxDiaChi, chckbxPhuong, chckbxQuan, chckbxThanhPho, chckbxEmail,
			chckbxDienThoai, chckbxSoSachDangMuon;
	private JCheckBox chckbxMaSach, chckbxTenSach, chckbxTacGia, chckbxNhaXuatBan, chckbxTheLoai, chckbxNamXuatBan,
			chckbxSoLuongTong, chckbxSoLuongTrongKho;
	private JCheckBox chckbxMaMuonTra_0, chckbxMaBanDoc_0, chckbxTenBanDoc_0, chckbxMaSach_0, chckbxTenSach_0,
			chckbxNgayMuon_0, chckbxNgayTra_0;
	private JTextFieldDateEditor txtFldFrom, txtFldTo;

	private String[] columnNames = { "Mã bạn đọc", "Tên", "Địa chỉ", "Phường", "Quận", "Thành phố", "Email",
			"Điện thoại", "Số sách đang mượn", "Mã sách", "Tên", "Tác giả", "Nhà xuất bản", "Thể loại", "Năm xuất bản",
			"Số lượng tổng", "Số lượng trong kho", "Mã mượn trả", "Mã bạn đọc", "Tên bạn đọc", "Mã sách", "Tên sách",
			"Ngày mượn", "Ngày trả" };
	private DefaultTableModel tblResultModel = new DefaultTableModel(columnNames, 0);

	private ArrayList<JCheckBox> arrChckbx = new ArrayList<JCheckBox>();
	private XTableColumnModel columnModel = new XTableColumnModel();
	private BanDocModel banDocModel = new BanDocModel();
	private SachModel sachModel = new SachModel();
	private MuonTraSachModel muonTraSachModel = new MuonTraSachModel();

	/**
	 * Create the frame.
	 */
	public ThongKeBaoCao() {
		addControls();
		addEvents();
	}

	private void addEvents() {
		rdbtnThongKeBanDoc.addActionListener(new ThongKeListener());
		rdbtnThongKeDauSach.addActionListener(new ThongKeListener());
		rdbtnThongKeMuonTra.addActionListener(new ThongKeListener());

		btnSearchBanDoc.addActionListener(new SearchBanDocListener());
		btnSearchSach.addActionListener(new SearchSachListener());
     	btnSearchMuonTra.addActionListener(new SearchMuonTraListener());
		btnExport.addActionListener(new ExportListener());
		btnThoat.addActionListener(new ThoatListener());

		cbBxMuonTra.addActionListener(new SelectCbBxMuonTraListener());

		txtFldMaThanhVien.addActionListener(new EnterBanDocListener());
		txtFldTacGia.addActionListener(new EnterSachListener());
		txtFldId.addActionListener(new EnterMuonTraListener());

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
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
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
		pnlOption.add(rdbtnThongKeMuonTra);

		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnThongKeBanDoc);
		bg.add(rdbtnThongKeDauSach);
		bg.add(rdbtnThongKeMuonTra);

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
		cbBxNhaXuatBan.setPreferredSize(new Dimension(150, 22));
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
		pnlOptionMuonTra = new JPanel();
		pnlOptionMuonTra.setVisible(false);
		pnlOptionMuonTra.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnlCenter.add(pnlOptionMuonTra);
		pnlOptionMuonTra.setLayout(new BoxLayout(pnlOptionMuonTra, BoxLayout.Y_AXIS));

		JPanel pnlSearchMuonTra = new JPanel();
		pnlOptionMuonTra.add(pnlSearchMuonTra);

		cbBxId = new JComboBox();
		cbBxId.setModel(new DefaultComboBoxModel(new String[] { "Mã bạn đọc", "Mã sách" }));
		// cbBxId.setPreferredSize(new Dimension(165, 22));
		pnlSearchMuonTra.add(cbBxId);

		txtFldId = new PlaceholderTextField(12);
		txtFldId.setPlaceholder("e.g. 00001");
		JLabel lbl_0 = new JLabel("     ");
		pnlSearchMuonTra.add(txtFldId);
		pnlSearchMuonTra.add(lbl_0);

		cbBxMuonTra = new JComboBox();
		cbBxMuonTra.setModel(new DefaultComboBoxModel(new String[] { "Mượn sách", "Trả sách" }));
		pnlSearchMuonTra.add(cbBxMuonTra);

		JLabel lblFrom = new JLabel("  Từ:");
		JDateChooser dateFrom = new JDateChooser() {
			
			@Override
			public void setDateFormatString(String string) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public JTextFieldDateEditor getDateEditor() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		dateFrom.setDateFormatString("yyyy-MM-dd");
		txtFldFrom = (JTextFieldDateEditor) dateFrom.getDateEditor();
		txtFldFrom.setEditable(false);
		pnlSearchMuonTra.add(lblFrom);
		pnlSearchMuonTra.add((Component) dateFrom);

		JLabel lblTo = new JLabel("đến");
		JDateChooser dateTo = new JDateChooser() {
			
			@Override
			public void setDateFormatString(String string) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public JTextFieldDateEditor getDateEditor() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		dateTo.setDateFormatString("yyyy-MM-dd");
		txtFldTo = (JTextFieldDateEditor) dateTo.getDateEditor();
		txtFldTo.setEditable(false);

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		txtFldTo.setText(dateFormat.format(new Date()));

		pnlSearchMuonTra.add(lblTo);
		pnlSearchMuonTra.add((Component) dateTo);

		JLabel lblTinhTrang = new JLabel("     Tình trạng:");
		pnlSearchMuonTra.add(lblTinhTrang);

		cbBxTinhTrang = new JComboBox();
		cbBxTinhTrang.setModel(new DefaultComboBoxModel(new String[] { "Tất cả", "Chưa trả", "Đã trả" }));
		pnlSearchMuonTra.add(cbBxTinhTrang);
		JLabel lbl_1 = new JLabel("     ");
		pnlSearchMuonTra.add(lbl_1);

		btnSearchMuonTra = new JButton("Tìm");
		pnlSearchMuonTra.add(btnSearchMuonTra);

		pnlShowMuonTra = new JPanel();
		pnlOptionMuonTra.add(pnlShowMuonTra);

		chckbxMaMuonTra_0 = new JCheckBox("Mã mượn trả", true);
		addChkbx(chckbxMaMuonTra_0, pnlShowMuonTra);

		chckbxMaBanDoc_0 = new JCheckBox("Mã bạn đọc");
		addChkbx(chckbxMaBanDoc_0, pnlShowMuonTra);

		chckbxTenBanDoc_0 = new JCheckBox("Tên bạn đọc", true);
		addChkbx(chckbxTenBanDoc_0, pnlShowMuonTra);

		chckbxMaSach_0 = new JCheckBox("Mã sách");
		addChkbx(chckbxMaSach_0, pnlShowMuonTra);

		chckbxTenSach_0 = new JCheckBox("Tên sách", true);
		addChkbx(chckbxTenSach_0, pnlShowMuonTra);

		chckbxNgayMuon_0 = new JCheckBox("Ngày mượn", true);
		addChkbx(chckbxNgayMuon_0, pnlShowMuonTra);

		chckbxNgayTra_0 = new JCheckBox("Ngày trả", true);
		addChkbx(chckbxNgayTra_0, pnlShowMuonTra);

		// Search result
		JScrollPane scrollPaneResult = new JScrollPane();
		pnlCenter.add(scrollPaneResult);

		tblResult = new JTable();
		tblResult.setModel(tblResultModel);
		tblResult.setColumnModel(columnModel);
		tblResult.createDefaultColumnsFromModel();

		// Lúc khởi tạo, ko chọn gì cả => table trống
		for (int i = 0; i < 24; i++) {
			TableColumn column = columnModel.getColumnByModelIndex(i);
			columnModel.setColumnVisible(column, false);
		}

		scrollPaneResult.setViewportView(tblResult);

		// FOOTER
		JPanel footer = new JPanel();
		FlowLayout fl_footer = (FlowLayout) footer.getLayout();
		fl_footer.setHgap(15);

		btnExport = new JButton("Xuất báo cáo");
		footer.add(btnExport);

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
			setVisibleCol();
		}
	}

	private void setVisibleCol() {
		boolean isBanDoc = rdbtnThongKeBanDoc.isSelected();
		boolean isSach = rdbtnThongKeDauSach.isSelected();
		boolean isMuonTra = rdbtnThongKeMuonTra.isSelected();
		int iStart, iEnd;
		if (isBanDoc) {
			iStart = 0;
			iEnd = 9;
		} else if (isSach) {
			iStart = 9;
			iEnd = 17;
		} else {
			iStart = 17;
			iEnd = 24;
		}
		pnlOptionSach.setVisible(isSach);
		pnlOptionBanDoc.setVisible(isBanDoc);
		pnlOptionMuonTra.setVisible(isMuonTra);

		for (int i = 0; i < 24; i++) {
			TableColumn column = columnModel.getColumnByModelIndex(i);
			if (i >= iStart && i < iEnd) {
				columnModel.setColumnVisible(column, arrChckbx.get(i).isSelected());
			} else {
				columnModel.setColumnVisible(column, false);
			}
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
				setVisibleCol();
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
				setVisibleCol();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	private class SearchMuonTraListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				tblResultModel.setRowCount(0);
				String[] where = { "1", "1", "1" }, value = { "1", "1", "1" };

				int kId = cbBxId.getSelectedIndex();
				String vId = txtFldId.getText();
				int kMuonTra = cbBxMuonTra.getSelectedIndex();
				String dateFrom = txtFldFrom.getText1();
				String dateTo = txtFldTo.getText1();
				int getDate = Integer.parseInt(dateTo.substring(8)) + 1;
				dateTo = dateTo.substring(0, 8) + String.format("%02d", getDate);
				String vMuonTra = " BETWEEN '" + dateFrom + "' AND '" + dateTo + "'";
				int kTinhTrang = cbBxTinhTrang.getSelectedIndex();

				if (!vId.isEmpty()) {
					if (kId == 0) {
						where[0] = "ma_ban_doc";
					} else {
						where[0] = "ma_sach_muon";
					}
					value[0] = " = " + vId;
				}
				if (kMuonTra == 0) {
					where[1] = "ngay_muon";
				} else {
					where[1] = "ngay_tra";
				}
				value[1] = vMuonTra;

				if (kTinhTrang == 1) {
					where[2] = "ngay_tra";
					value[2] = " IS NULL ";
				} else if (kTinhTrang == 2) {
					where[2] = "ngay_tra";
					value[2] = " IS NOT NULL ";
				}
				ResultSet rs = muonTraSachModel.getMuonTraSach(where, value);
				int row = 0;
				columnModel.setAllColumnsVisible();
				while ((rs != null) && (rs.next())) {
					tblResultModel.addRow(new Object[0]);
					tblResultModel.setValueAt(rs.getString("ma_muon_tra"), row, 17);
					tblResultModel.setValueAt(rs.getString("ma_ban_doc"), row, 18);
					tblResultModel.setValueAt(rs.getString("ho_ten"), row, 19);
					tblResultModel.setValueAt(rs.getString("ma_sach_muon"), row, 20);
					tblResultModel.setValueAt(rs.getString("ten_sach"), row, 21);
					tblResultModel.setValueAt(rs.getString("ngay_muon"), row, 22);
					tblResultModel.setValueAt(rs.getString("ngay_tra"), row, 23);
					row++;
				}
				setVisibleCol();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	@SuppressWarnings("unchecked")
	private class SelectCbBxMuonTraListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (cbBxMuonTra.getSelectedIndex() == 1) {
				cbBxTinhTrang.removeAllItems();
				cbBxTinhTrang.addItem("Tất cả    ");
			} else {
				cbBxTinhTrang.removeAllItems();
				cbBxTinhTrang.addItem("Tất cả");
				cbBxTinhTrang.addItem("Chưa trả");
				cbBxTinhTrang.addItem("Đã trả");
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

	private class EnterMuonTraListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			btnSearchMuonTra.doClick();
			int end = txtFldId.getText().length();
			txtFldId.setCaretPosition(end);
		}
	}

	private class ThoatListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			CheckLogin.setLoggedrole(null);
			MyApp.mainFrame.dispose();
			MyApp.loginFrame = new LoginUi("Đăng nhập hệ thống");
		}

	}

	private class ExportListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JFileChooser fc = new JFileChooser();
			int k = fc.showSaveDialog((Component) e.getSource());
			if (k == JFileChooser.APPROVE_OPTION) {
				File f = fc.getSelectedFile();
				String filepath = f.getPath();
				try {
					BufferedWriter bw = new BufferedWriter(new FileWriter(filepath));
					for (int i = 0; i < tblResult.getColumnCount(); i++) {
						bw.write(tblResult.getColumnName(i) + "\t");
					}
					bw.write("\n");

					for (int i = 0; i < tblResult.getRowCount(); i++) {
						for (int j = 0; j < tblResult.getColumnCount(); j++) {
							bw.write(tblResult.getValueAt(i, j).toString() + "\t");
						}
						bw.newLine();
					}
					bw.flush();
					bw.close();
					JOptionPane.showMessageDialog(null, "Xuất file thành công!");
				} catch (IOException ex) {
					System.err.println(ex);
				}
			}
		}
	}
}