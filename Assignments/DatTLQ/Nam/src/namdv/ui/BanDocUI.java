package namdv.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import namdv.main.MyApp;
import namdv.model.BanDoc;
import namdv.model.BanDocModel;
import namdv.model.CheckLogin;
import namdv.model.ComboItem;
import namdv.model.MyException;
import namdv.model.PlaceholderTextField;

public class BanDocUI extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private PlaceholderTextField txtFldSearch, txtFldHoTen, txtFldEmail, txtFldDienThoai, txtFldDiaChi;
	private JTable tblResult;
	private JTextField txtFldId;
	private JTable tblThongTinSachMuon;
	private JButton btnSearch, btnSua, btnXoa, btnThem, btnThoat;
	private boolean clickTblResult = true;
	@SuppressWarnings("rawtypes")
	private JComboBox cbBxSearch, cbBxThanhPho, cbBxQuan, cbBxPhuong;

	private DefaultTableModel tblResultModel = new DefaultTableModel(
			new String[] { "ID", "Tên", "Thành phố", "Email", "Điện thoại", "Số sách đang mượn" }, 0);
	private DefaultTableModel tblThongTinSachMuonModel = new DefaultTableModel(
			new Object[][] { { null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
					{ null, null, null, null, null, null, null }, },
			new String[] { "Mã mượn", "Tên sách mượn", "Tác giả", "Ngày mượn" });
	private BanDocModel banDocModel = new BanDocModel();
	private MyException myEx = new MyException();

	/**
	 * Create the pnl.
	 */
	public BanDocUI() {
		addControls();
		addEvents();

		getRole();
	}

	private void addEvents() {
		txtFldSearch.addActionListener(new EnterListener());
		btnSearch.addActionListener(new SearchListener());
		btnThem.addActionListener(new ThemListener());
		btnSua.addActionListener(new SuaListener());
		btnXoa.addActionListener(new XoaListener());
		btnThoat.addActionListener(new ThoatListener());

		tblResult.addMouseListener(new ClickTblResult());

		cbBxSearch.addActionListener(new SelectSearchListener());
		cbBxThanhPho.addActionListener(new SelectThanhPhoListener());
		cbBxQuan.addActionListener(new SelectQuanListener());
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void addControls() {
		// CENTER
		JPanel pnlCenter = new JPanel();
		pnlCenter.setBorder(new EmptyBorder(5, 5, 5, 5));
		pnlCenter.setLayout(new BoxLayout(pnlCenter, BoxLayout.Y_AXIS));

		// Search
		JPanel pnlSearch = new JPanel();
		pnlSearch.setPreferredSize(new Dimension(10, 75));
		pnlCenter.add(pnlSearch);

		cbBxSearch = new JComboBox();
		cbBxSearch.setModel(new DefaultComboBoxModel(new String[] { "ID", "Tên" }));
		pnlSearch.add(cbBxSearch);

		txtFldSearch = new PlaceholderTextField();
		txtFldSearch.setPreferredSize(new Dimension(175, 22));
		txtFldSearch.setPlaceholder("e.g. 00001");
		pnlSearch.add(txtFldSearch);

		btnSearch = new JButton("Tìm");
		pnlSearch.add(btnSearch);

		JScrollPane scrollPaneResult = new JScrollPane();
		pnlCenter.add(scrollPaneResult);

		tblResult = new JTable() {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		// tblResult.setAutoCreateRowSorter(true);
		// Canh giữa cell header table
		JTableHeader tableHeader_1 = tblResult.getTableHeader();
		tableHeader_1.setDefaultRenderer(new HeaderRenderer(tblResult));
		tblResult.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		tblResult.setModel(tblResultModel);
		scrollPaneResult.setViewportView(tblResult);

		TableColumnModel columnModel_1 = tblResult.getColumnModel();
		columnModel_1.getColumn(3).setPreferredWidth(150);

		JPanel pnl = new JPanel();
		pnlCenter.add(pnl);

		JPanel pnlButton = new JPanel();
		FlowLayout fl_pnlButton = (FlowLayout) pnlButton.getLayout();
		fl_pnlButton.setHgap(30);
		pnlButton.setPreferredSize(new Dimension(10, 75));
		pnlCenter.add(pnlButton);

		btnThem = new JButton("Thêm");
		pnlButton.add(btnThem);

		btnSua = new JButton("Sửa");
		btnSua.setEnabled(false);
		pnlButton.add(btnSua);

		btnXoa = new JButton("Xóa");
		btnXoa.setEnabled(false);
		pnlButton.add(btnXoa);

		// Thông tin bạn đọc
		JPanel pnlThongTinBanDoc = new JPanel();
		pnlThongTinBanDoc.setBorder(
				new TitledBorder(null, "Thông tin bạn đọc", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlCenter.add(pnlThongTinBanDoc);
		pnlThongTinBanDoc.setLayout(new BoxLayout(pnlThongTinBanDoc, BoxLayout.Y_AXIS));

		// pnl 1
		JPanel pnlSub_1 = new JPanel();
		pnlThongTinBanDoc.add(pnlSub_1);
		pnlSub_1.setLayout(new BoxLayout(pnlSub_1, BoxLayout.X_AXIS));

		JPanel pnlId = new JPanel();
		pnlSub_1.add(pnlId);

		JLabel lblId = new JLabel("ID: ");
		lblId.setPreferredSize(new Dimension(80, 22));
		pnlId.add(lblId);

		txtFldId = new JTextField();
		txtFldId.setPreferredSize(new Dimension(175, 22));
		txtFldId.setEditable(false);
		pnlId.add(txtFldId);

		// set auto new id
		try {
			txtFldId.setText(banDocModel.getAutoId());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		JPanel pnlDiaChi = new JPanel();
		pnlSub_1.add(pnlDiaChi);

		JLabel lblDiaChi = new JLabel("Địa chỉ: ");
		pnlDiaChi.add(lblDiaChi);
		lblDiaChi.setPreferredSize(lblId.getPreferredSize());

		txtFldDiaChi = new PlaceholderTextField();
		txtFldDiaChi.setPreferredSize(txtFldId.getPreferredSize());
		txtFldDiaChi.setPlaceholder("e.g. 121 Bạch Đằng");
		pnlDiaChi.add(txtFldDiaChi);

		// pnl 2
		JPanel pnlSub_2 = new JPanel();
		pnlThongTinBanDoc.add(pnlSub_2);
		pnlSub_2.setLayout(new BoxLayout(pnlSub_2, BoxLayout.X_AXIS));

		JPanel pnlTen = new JPanel();
		pnlSub_2.add(pnlTen);

		JLabel lblTen = new JLabel("Tên: ");
		lblTen.setPreferredSize(lblId.getPreferredSize());
		pnlTen.add(lblTen);

		txtFldHoTen = new PlaceholderTextField();
		txtFldHoTen.setPreferredSize(txtFldId.getPreferredSize());
		txtFldHoTen.setPlaceholder("e.g. Đặng Văn Nam");
		pnlTen.add(txtFldHoTen);

		JPanel pnlThanhPho = new JPanel();
		pnlSub_2.add(pnlThanhPho);

		JLabel lblThanhPho = new JLabel("Thành phố: ");
		lblThanhPho.setPreferredSize(lblId.getPreferredSize());
		pnlThanhPho.add(lblThanhPho);

		cbBxThanhPho = new JComboBox();
		cbBxThanhPho.setPreferredSize(txtFldId.getPreferredSize());
		pnlThanhPho.add(cbBxThanhPho);
		getThanhPho();

		// pnl 3
		JPanel pnlSub_3 = new JPanel();
		pnlThongTinBanDoc.add(pnlSub_3);
		pnlSub_3.setLayout(new BoxLayout(pnlSub_3, BoxLayout.X_AXIS));

		JPanel pnlEmail = new JPanel();
		pnlSub_3.add(pnlEmail);

		JLabel lblEmail = new JLabel("Email: ");
		pnlEmail.add(lblEmail);
		lblEmail.setPreferredSize(lblId.getPreferredSize());

		txtFldEmail = new PlaceholderTextField();
		txtFldEmail.setPreferredSize(txtFldId.getPreferredSize());
		txtFldEmail.setPlaceholder("e.g. dangvannam98@gmail.com");
		pnlEmail.add(txtFldEmail);

		JPanel pnlQuan = new JPanel();
		pnlSub_3.add(pnlQuan);

		JLabel lblQuan = new JLabel("Quận: ");
		pnlQuan.add(lblQuan);
		lblQuan.setPreferredSize(lblId.getPreferredSize());

		cbBxQuan = new JComboBox();
		cbBxQuan.setPreferredSize(txtFldId.getPreferredSize());
		cbBxQuan.setEnabled(false);
		pnlQuan.add(cbBxQuan);

		// pnl 4
		JPanel pnlSub_4 = new JPanel();
		pnlThongTinBanDoc.add(pnlSub_4);
		pnlSub_4.setLayout(new BoxLayout(pnlSub_4, BoxLayout.X_AXIS));

		JPanel pnlDienThoai = new JPanel();
		pnlSub_4.add(pnlDienThoai);

		JLabel lblDienThoai = new JLabel("Điện thoại: ");
		pnlDienThoai.add(lblDienThoai);
		lblDienThoai.setPreferredSize(lblId.getPreferredSize());

		txtFldDienThoai = new PlaceholderTextField();
		txtFldDienThoai.setPreferredSize(txtFldId.getPreferredSize());
		txtFldDienThoai.setPlaceholder("e.g. 01266676809");
		pnlDienThoai.add(txtFldDienThoai);

		JPanel pnlPhuong = new JPanel();
		pnlSub_4.add(pnlPhuong);

		JLabel lblPhuong = new JLabel("Phường: ");
		pnlPhuong.add(lblPhuong);
		lblPhuong.setPreferredSize(lblId.getPreferredSize());

		cbBxPhuong = new JComboBox();
		cbBxPhuong.setPreferredSize(txtFldId.getPreferredSize());
		cbBxPhuong.setEnabled(false);
		pnlPhuong.add(cbBxPhuong);

		// pnl 5
		JPanel pnlSub_5 = new JPanel();
		pnlThongTinBanDoc.add(pnlSub_5);

		// Thông tin sách mượn
		JLabel lblThongTinSachMuon = new JLabel("Thông tin sách mượn");
		pnlSub_5.add(lblThongTinSachMuon);

		JScrollPane scrollPaneThongTinSachMuon = new JScrollPane();
		pnlThongTinBanDoc.add(scrollPaneThongTinSachMuon);

		tblThongTinSachMuon = new JTable() {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			};

			/*@Override
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component component = super.prepareRenderer(renderer, row, column);
				int rendererWidth = component.getPreferredSize().width;
				TableColumn tableColumn = getColumnModel().getColumn(column);
				tableColumn.setPreferredWidth(
						Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
				return component;
			}*/
		};
		// tblResult.setAutoCreateRowSorter(true);
		// Canh giữa cell header table
		JTableHeader tableHeader_2 = tblThongTinSachMuon.getTableHeader();
		tableHeader_2.setDefaultRenderer(new HeaderRenderer(tblThongTinSachMuon));

		tblThongTinSachMuon.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblThongTinSachMuon.setModel(tblThongTinSachMuonModel);

		// tblThongTinSachMuon.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		// ColumnsAutoSizer.sizeColumnsToFit(tblThongTinSachMuon);

		TableColumnModel columnModel_2 = tblThongTinSachMuon.getColumnModel();
		columnModel_2.getColumn(1).setPreferredWidth(200);

		scrollPaneThongTinSachMuon.setViewportView(tblThongTinSachMuon);

		// FOOTER
		JPanel footer = new JPanel();
		btnThoat = new JButton("Thoát");
		footer.add(btnThoat);

		// ADD TO Jpnl
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(pnlCenter, BorderLayout.CENTER);
		this.add(footer, BorderLayout.SOUTH);
	}

	private static class HeaderRenderer implements TableCellRenderer {
		DefaultTableCellRenderer renderer;

		public HeaderRenderer(JTable table) {
			renderer = (DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer();
			renderer.setHorizontalAlignment(JLabel.CENTER);
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int col) {
			return renderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
		}
	}

	private class EnterListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			btnSearch.doClick();
			int end = txtFldSearch.getText().length();
			txtFldSearch.setCaretPosition(end);
		}
	}

	private class SelectSearchListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (cbBxSearch.getSelectedItem().equals("ID")) {
				txtFldSearch.setPlaceholder("e.g. 00001");
			} else {
				txtFldSearch.setPlaceholder("e.g. Đặng Văn Nam");
			}
		}
	}

	private void removeErr() {
		// remove error textfield
		myEx.reset(txtFldSearch);
		myEx.reset(txtFldHoTen);
		myEx.reset(txtFldEmail);
		myEx.reset(txtFldDienThoai);
		myEx.reset(txtFldDiaChi);
		myEx.reset(cbBxThanhPho);
		myEx.reset(cbBxQuan);
		myEx.reset(cbBxPhuong);
	}

	private void setText(String id, String hoTen, String thanhPho, String quan, String phuong, String diaChi,
			String email, String dienThoai) {
		if (id == null) {
			try {
				txtFldId.setText(banDocModel.getAutoId());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			txtFldId.setText(id);
		}
		txtFldHoTen.setText(hoTen);
		ComboItem item;

		if (thanhPho == null) {
			cbBxThanhPho.setSelectedIndex(0);
		} else {
			for (int i = 1; i < cbBxThanhPho.getItemCount(); i++) {
				item = (ComboItem) cbBxThanhPho.getItemAt(i);
				if (item.getKey().equals(thanhPho)) {
					cbBxThanhPho.setSelectedIndex(i);
					break;
				}
			}

			for (int i = 1; i < cbBxQuan.getItemCount(); i++) {
				item = (ComboItem) cbBxQuan.getItemAt(i);
				if (item.getKey().equals(quan)) {
					cbBxQuan.setSelectedIndex(i);
					break;
				}
			}

			for (int i = 1; i < cbBxPhuong.getItemCount(); i++) {
				item = (ComboItem) cbBxPhuong.getItemAt(i);
				if (item.getKey().equals(phuong)) {
					cbBxPhuong.setSelectedIndex(i);
					break;
				}
			}
		}

		txtFldDiaChi.setText(diaChi);
		txtFldEmail.setText(email);
		txtFldDienThoai.setText(dienThoai);
	}

	private class SearchListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				String[] where = { null };
				int search = cbBxSearch.getSelectedIndex();
				boolean check = false;

				if (search == 0) {
					where[0] = "id";
					check = myEx.checkNumber(txtFldSearch);
				}
				if (search == 1) {
					where[0] = "ho_ten";
					check = myEx.checkEmpty(txtFldSearch);
				}
				if (check) {
					String[] value = { txtFldSearch.getText() };
					ResultSet rs = banDocModel.getBanDoc(where, value);
					// reset table
					tblResultModel.setRowCount(0);
					// insert new row
					int row = 0;
					while ((rs != null) && (rs.next())) {
						tblResultModel.addRow(new Object[0]);
						tblResultModel.setValueAt(rs.getString("id"), row, 0);
						tblResultModel.setValueAt(rs.getString("ho_ten"), row, 1);
						tblResultModel.setValueAt(rs.getString("gsovn_tinhthanhpho.name"), row, 2);
						tblResultModel.setValueAt(rs.getString("email"), row, 3);
						tblResultModel.setValueAt(rs.getString("dien_thoai"), row, 4);
						tblResultModel.setValueAt(rs.getString("so_sach_dang_muon"), row, 5);
						row++;
					}
				}
			} catch (SQLException | MyException ex) {
				ex.printStackTrace();
			}
		}
	}

	private class ClickTblResult extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			if (clickTblResult) {
				// Load data to JTextField + combobox
				btnSua.setEnabled(true);
				btnXoa.setEnabled(true);
				int row = tblResult.getSelectedRow();
				setDataByClick(row);
			}
		}
	}

	private void setDataByClick(int row) {
		try {
			// Load data to JTextField + combobox
			String[] where = { "id" };
			String[] value = { tblResultModel.getValueAt(row, 0).toString() };
			ResultSet rs = banDocModel.getBanDoc(where, value);
			rs.next();
			setText(rs.getString("id"), rs.getString("ho_ten"), rs.getString("thanh_pho"), rs.getString("quan"),
					rs.getString("phuong"), rs.getString("dia_chi"), rs.getString("email"), rs.getString("dien_thoai"));
			removeErr();
			// Load data sách mượn to table
			tblThongTinSachMuonModel.setRowCount(0);
			rs = banDocModel.getDataSachChuaTra(value[0]);
			row = 0;
			while ((rs != null) && (rs.next())) {
				tblThongTinSachMuonModel.addRow(new Object[0]);
				tblThongTinSachMuonModel.setValueAt(rs.getString("ma_muon_tra"), row, 0);
				tblThongTinSachMuonModel.setValueAt(rs.getString("ten_sach"), row, 1);
				tblThongTinSachMuonModel.setValueAt(rs.getString("tac_gia"), row, 2);
				tblThongTinSachMuonModel.setValueAt(rs.getString("ngay_muon").replace(".0", ""), row, 3);
				row++;
			}
			while (row < 3) {
				tblThongTinSachMuonModel.addRow(new Object[0]);
				row++;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	private BanDoc getDataInput() throws MyException {
		boolean checkHoTen = myEx.checkEmpty(txtFldHoTen);
		boolean checkThanhPho = myEx.checkCmbBx(cbBxThanhPho);
		boolean checkQuan = myEx.checkCmbBx(cbBxQuan);
		boolean checkPhuong = myEx.checkCmbBx(cbBxPhuong);
		boolean checkDiaChi = myEx.checkEmpty(txtFldDiaChi);
		boolean checkEmail = myEx.checkEmail(txtFldEmail);
		boolean checkDienThoai = myEx.checkDienThoai(txtFldDienThoai);

		int row = tblResult.getSelectedRow();
		if (row != -1) {
			String emailCu = tblResultModel.getValueAt(row, 3).toString();
			if (txtFldEmail.getText().equals(emailCu)) {
				checkEmail = true;
				myEx.reset(txtFldEmail);
			}
			String dienThoaiCu = tblResultModel.getValueAt(row, 4).toString();
			if (txtFldDienThoai.getText().equals(dienThoaiCu)) {
				checkDienThoai = true;
				myEx.reset(txtFldDienThoai);
			}
		}

		if (checkHoTen && checkDiaChi && checkThanhPho && checkQuan && checkPhuong && checkEmail && checkDienThoai) {
			String id = txtFldId.getText();
			String hoTen = txtFldHoTen.getText();
			String thanhPho = ((ComboItem) cbBxThanhPho.getSelectedItem()).getKey();
			String quan = ((ComboItem) cbBxQuan.getSelectedItem()).getKey();
			String phuong = ((ComboItem) cbBxPhuong.getSelectedItem()).getKey();
			String diaChi = txtFldDiaChi.getText();
			String email = txtFldEmail.getText();
			String dienThoai = txtFldDienThoai.getText().replaceAll("\\s", "");

			BanDoc banDoc = new BanDoc(id, hoTen, thanhPho, quan, phuong, diaChi, email, dienThoai);
			return banDoc;
		}
		return null;
	}

	private class ThemListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				if (btnSua.isEnabled()) {
					// Nếu đang select row on table => đang sửa => reset
					btnSua.setEnabled(false);
					btnXoa.setEnabled(false);
					tblResult.getSelectionModel().clearSelection();
					setText(null, null, null, null, null, null, null, null);
					removeErr();
					tblThongTinSachMuonModel.setRowCount(0);
				} else {
					BanDoc banDoc = getDataInput();
					if (banDoc != null && banDocModel.addBanDoc(banDoc) > 0) {
						setText(null, null, null, null, null, null, null, null);
						btnSearch.doClick();
						myEx.reset(txtFldSearch);
						JOptionPane.showMessageDialog(null, "Thêm thành công!");
					}
				}
			} catch (SQLException | MyException ex) {
				ex.printStackTrace();
			}
		}
	}

	private class SuaListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				BanDoc banDoc = getDataInput();
				if (banDoc != null && banDocModel.editBanDoc(banDoc) > 0) {
					btnSearch.doClick();
					btnThem.doClick();
					JOptionPane.showMessageDialog(null, "Sửa thành công!");
				}
			} catch (MyException | HeadlessException | SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	private class XoaListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				int row = tblResult.getSelectedRow();
				String id = tblResultModel.getValueAt(row, 0).toString();
				if (row != -1) {
					int reply = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa dữ liệu này không?",
							"Confirm to Delete?", JOptionPane.YES_NO_OPTION);
					if (reply == JOptionPane.YES_OPTION) {
						if (banDocModel.deleteBanDoc(id) > 0) {
							tblResultModel.removeRow(row);
							btnThem.doClick();
							JOptionPane.showMessageDialog(null, "Xóa thành công!");
						} else {
							JOptionPane.showMessageDialog(null, "Xóa thất bại, bạn đọc chưa trả hết sách mượn!");
						}
					}
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	@SuppressWarnings({ "unchecked" })
	private void getThanhPho() {
		try {
			ComboItem item;
			cbBxThanhPho.addItem(null);

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
	private class SelectThanhPhoListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				cbBxQuan.removeAllItems();

				ComboItem item;
				Object tp = cbBxThanhPho.getSelectedItem();

				if (tp != null) {
					String matp = ((ComboItem) tp).getKey();

					cbBxQuan.setEnabled(true);
					cbBxQuan.addItem(null);

					ResultSet rs = banDocModel.getQuan(matp);
					while ((rs != null) && (rs.next())) {
						item = new ComboItem(rs.getString("maqh"), rs.getString("name"));
						cbBxQuan.addItem(item);
					}
				} else {
					cbBxQuan.setEnabled(false);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}

	@SuppressWarnings({ "unchecked" })
	private class SelectQuanListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				cbBxPhuong.removeAllItems();

				ComboItem item;
				Object qh = cbBxQuan.getSelectedItem();
				if (qh != null) {
					String maqh = ((ComboItem) qh).getKey();

					cbBxPhuong.setEnabled(true);
					cbBxPhuong.addItem(null);

					ResultSet rs = banDocModel.getPhuong(maqh);
					while ((rs != null) && (rs.next())) {
						item = new ComboItem(rs.getString("xaid"), rs.getString("name"));
						cbBxPhuong.addItem(item);
					}
				} else {
					cbBxPhuong.setEnabled(false);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
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

	private void getRole() {
		if (CheckLogin.getLoggedrole().equals("bandoc")) {
			cbBxSearch.setEnabled(false);
			txtFldSearch.setText(CheckLogin.getMaBanDoc());
			txtFldSearch.setEditable(false);
			btnSearch.doClick();
			btnSearch.setEnabled(false);
			btnThem.setEnabled(false);
			setDataByClick(0);
			txtFldHoTen.setEditable(false);
			txtFldEmail.setEditable(false);
			txtFldDienThoai.setEditable(false);
			txtFldDiaChi.setEditable(false);
			cbBxThanhPho.setEnabled(false);
			cbBxQuan.setEnabled(false);
			cbBxPhuong.setEnabled(false);
			tblResult.setRowSelectionAllowed(false);
			tblThongTinSachMuon.setRowSelectionAllowed(false);
			clickTblResult = false;
		}
	}
}
