package namdv.ui;

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
import namdv.model.CheckLogin;
import namdv.model.ComboItem;
import namdv.model.MyException;
import namdv.model.PlaceholderTextField;
import namdv.model.Sach;
import namdv.model.SachModel;

public class SachUI extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PlaceholderTextField txtFldSearch, txtFldTenSach, txtFldTacGia, txtFldNamXuatBan, txtFldSLTong;
	private JTable tblResult;
	private JTextField txtFldMaSach, txtFldSLHienCo;
	private JButton btnSearch, btnThem, btnSua, btnXoa, btnThoat;
	@SuppressWarnings("rawtypes")
	private JComboBox cbBxSearch, cbBxNhaXuatBan, cbBxTheLoai;
	private DefaultTableModel tblResultModel = new DefaultTableModel(
			new String[] { "Mã sách", "Tên sách", "Tác giả", "Số lượng tổng", "Số lượng hiện có" }, 0);
	private SachModel sachModel = new SachModel();
	private MyException myEx = new MyException();

	/**
	 * Create the frame.
	 */
	public SachUI() {
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

		cbBxSearch.addActionListener(new SelectSearchListener());

		tblResult.addMouseListener(new ClickTblResult());
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void addControls() {
		// CENTER
		JPanel pnlCenter = new JPanel();
		pnlCenter.setBorder(new EmptyBorder(5, 5, 5, 5));
		pnlCenter.setLayout(new BoxLayout(pnlCenter, BoxLayout.Y_AXIS));

		// Search
		JPanel pnlSearch = new JPanel();
		FlowLayout fl_pnlSearch = (FlowLayout) pnlSearch.getLayout();
		fl_pnlSearch.setHgap(10);
		pnlSearch.setPreferredSize(new Dimension(10, 75));
		pnlCenter.add(pnlSearch);

		cbBxSearch = new JComboBox();
		cbBxSearch.setModel(new DefaultComboBoxModel(new String[] { "Mã sách", "Tên sách", "Tác giả" }));
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
		JTableHeader tableHeader = tblResult.getTableHeader();
		tableHeader.setDefaultRenderer(new HeaderRenderer(tblResult));
		tblResult.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		tblResult.setModel(tblResultModel);
		scrollPaneResult.setViewportView(tblResult);

		TableColumnModel columnModel = tblResult.getColumnModel();
		columnModel.getColumn(1).setPreferredWidth(250);
		columnModel.getColumn(2).setPreferredWidth(125);

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

		// Thông tin sách
		JPanel pnlThongTinSach = new JPanel();
		pnlThongTinSach.setBorder(
				new TitledBorder(null, "Thông tin sách", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlCenter.add(pnlThongTinSach);
		pnlThongTinSach.setLayout(new BoxLayout(pnlThongTinSach, BoxLayout.Y_AXIS));

		// pnl 1
		JPanel pnlSub_1 = new JPanel();
		pnlThongTinSach.add(pnlSub_1);
		pnlSub_1.setLayout(new BoxLayout(pnlSub_1, BoxLayout.X_AXIS));

		JPanel pnlMaSach = new JPanel();
		pnlSub_1.add(pnlMaSach);

		JLabel lblMaSach = new JLabel("Mã sách: ");
		lblMaSach.setPreferredSize(new Dimension(80, 22));
		pnlMaSach.add(lblMaSach);

		txtFldMaSach = new JTextField();
		txtFldMaSach.setPreferredSize(new Dimension(175, 22));
		pnlMaSach.add(txtFldMaSach);
		txtFldMaSach.setEditable(false);
		try {
			txtFldMaSach.setText(sachModel.getAutoId());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		JPanel pnlTheLoai = new JPanel();
		pnlSub_1.add(pnlTheLoai);

		JLabel lblTheLoai = new JLabel("Thể loại: ");
		lblTheLoai.setPreferredSize(lblMaSach.getPreferredSize());
		pnlTheLoai.add(lblTheLoai);

		cbBxTheLoai = new JComboBox();
		cbBxTheLoai.setPreferredSize(txtFldMaSach.getPreferredSize());
		pnlTheLoai.add(cbBxTheLoai);

		getTheLoai();

		// pnl 2
		JPanel pnlSub_2 = new JPanel();
		pnlThongTinSach.add(pnlSub_2);
		pnlSub_2.setLayout(new BoxLayout(pnlSub_2, BoxLayout.X_AXIS));

		JPanel pnlTenSach = new JPanel();
		pnlSub_2.add(pnlTenSach);

		JLabel lblTenSach = new JLabel("Tên sách: ");
		lblTenSach.setPreferredSize(lblMaSach.getPreferredSize());
		pnlTenSach.add(lblTenSach);

		txtFldTenSach = new PlaceholderTextField();
		txtFldTenSach.setPreferredSize(txtFldMaSach.getPreferredSize());
		txtFldTenSach.setPlaceholder("e.g. Nhà giả kim");
		pnlTenSach.add(txtFldTenSach);

		JPanel pnlNhaXuatBan = new JPanel();
		pnlSub_2.add(pnlNhaXuatBan);

		JLabel lblNhaXuatBan = new JLabel("Nhà xuất bản: ");
		lblNhaXuatBan.setPreferredSize(lblMaSach.getPreferredSize());
		pnlNhaXuatBan.add(lblNhaXuatBan);

		cbBxNhaXuatBan = new JComboBox();
		cbBxNhaXuatBan.setPreferredSize(txtFldMaSach.getPreferredSize());
		pnlNhaXuatBan.add(cbBxNhaXuatBan);

		getNhaXuatBan();

		// pnl 3
		JPanel pnlSub_3 = new JPanel();
		pnlThongTinSach.add(pnlSub_3);
		pnlSub_3.setLayout(new BoxLayout(pnlSub_3, BoxLayout.X_AXIS));

		JPanel pnlTacGia = new JPanel();
		pnlSub_3.add(pnlTacGia);

		JLabel lblTacGia = new JLabel("Tác giả: ");
		lblTacGia.setPreferredSize(lblMaSach.getPreferredSize());
		pnlTacGia.add(lblTacGia);

		txtFldTacGia = new PlaceholderTextField();
		txtFldTacGia.setPreferredSize(txtFldMaSach.getPreferredSize());
		txtFldTacGia.setPlaceholder("e.g. Đặng Văn Nam");
		pnlTacGia.add(txtFldTacGia);

		JPanel pnlSLTong = new JPanel();
		pnlSub_3.add(pnlSLTong);

		JLabel lblSLTong = new JLabel("SL tổng: ");
		lblSLTong.setPreferredSize(lblMaSach.getPreferredSize());
		pnlSLTong.add(lblSLTong);

		txtFldSLTong = new PlaceholderTextField();
		txtFldSLTong.setPreferredSize(txtFldMaSach.getPreferredSize());
		txtFldSLTong.setPlaceholder("e.g. 12");
		pnlSLTong.add(txtFldSLTong);

		// pnl 4
		JPanel pnlSub_4 = new JPanel();
		pnlThongTinSach.add(pnlSub_4);
		pnlSub_4.setLayout(new BoxLayout(pnlSub_4, BoxLayout.X_AXIS));

		JPanel pnlNamXuatBan = new JPanel();
		pnlSub_4.add(pnlNamXuatBan);

		JLabel lblNamXuatBan = new JLabel("Năm xuất bản: ");
		lblNamXuatBan.setPreferredSize(lblMaSach.getPreferredSize());
		pnlNamXuatBan.add(lblNamXuatBan);

		txtFldNamXuatBan = new PlaceholderTextField();
		txtFldNamXuatBan.setPreferredSize(txtFldMaSach.getPreferredSize());
		txtFldNamXuatBan.setPlaceholder("e.g. 2018");
		pnlNamXuatBan.add(txtFldNamXuatBan);

		JPanel pnlSLHienCo = new JPanel();
		pnlSub_4.add(pnlSLHienCo);

		JLabel lblSLHienCo = new JLabel("SL hiện có: ");
		lblSLHienCo.setPreferredSize(lblMaSach.getPreferredSize());
		pnlSLHienCo.add(lblSLHienCo);

		txtFldSLHienCo = new JTextField();
		txtFldSLHienCo.setPreferredSize(txtFldMaSach.getPreferredSize());
		txtFldSLHienCo.setEditable(false);
		pnlSLHienCo.add(txtFldSLHienCo);

		JPanel pnl_1 = new JPanel();
		pnlThongTinSach.add(pnl_1);

		// FOOTER
		JPanel footer = new JPanel();
		btnThoat = new JButton("Thoát");
		footer.add(btnThoat);

		// ADD TO Jpnl
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(pnlCenter);
		this.add(footer);
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
			String rs = cbBxSearch.getSelectedItem().toString();
			if (rs.equals("Mã sách")) {
				txtFldSearch.setPlaceholder("e.g. 00001");
			} else if (rs.equals("Tên sách")) {
				txtFldSearch.setPlaceholder("e.g. Nhà giả kim");
			} else {
				txtFldSearch.setPlaceholder("e.g. Đặng Văn Nam");
			}
		}
	}

	private void removeErr() {
		// remove error textfield
		myEx.reset(txtFldSearch);
		myEx.reset(txtFldTenSach);
		myEx.reset(txtFldTacGia);
		myEx.reset(txtFldNamXuatBan);
		myEx.reset(cbBxTheLoai);
		myEx.reset(cbBxNhaXuatBan);
		myEx.reset(txtFldSLTong);
	}

	private void setText(String maSach, String tenSach, String tacGia, String namXuatBan, String theLoai,
			String nhaXuatBan, String slTong, String slHienCo) {

		if (maSach == null) {
			try {
				txtFldMaSach.setText(sachModel.getAutoId());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			txtFldMaSach.setText(maSach);
		}
		txtFldTenSach.setText(tenSach);
		txtFldTacGia.setText(tacGia);
		txtFldNamXuatBan.setText(namXuatBan);

		ComboItem item;

		if (theLoai == null) {
			cbBxTheLoai.setSelectedIndex(0);
		} else {
			for (int i = 1; i < cbBxTheLoai.getItemCount(); i++) {
				item = (ComboItem) cbBxTheLoai.getItemAt(i);
				if (item.getKey().equals(theLoai)) {
					cbBxTheLoai.setSelectedIndex(i);
					break;
				}
			}
		}

		if (nhaXuatBan == null) {
			cbBxNhaXuatBan.setSelectedIndex(0);
		} else {
			for (int i = 1; i < cbBxNhaXuatBan.getItemCount(); i++) {
				item = (ComboItem) cbBxNhaXuatBan.getItemAt(i);
				if (item.getKey().equals(nhaXuatBan)) {
					cbBxNhaXuatBan.setSelectedIndex(i);
					break;
				}
			}
		}

		txtFldSLTong.setText(slTong);
		txtFldSLHienCo.setText(slHienCo);
	}

	private class SearchListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				// reset table
				String[] where = { null };
				int search = cbBxSearch.getSelectedIndex();
				boolean check = false;

				if (search == 0) {
					where[0] = "sach.id";
					check = myEx.checkNumber(txtFldSearch);
				}
				if (search == 1) {
					where[0] = "ten_sach";
					check = myEx.checkEmpty(txtFldSearch);
				}
				if (search == 2) {
					where[0] = "tac_gia";
					check = myEx.checkEmpty(txtFldSearch);
				}
				if (check) {
					String[] value = { txtFldSearch.getText() };
					ResultSet rs = sachModel.getSach(where, value);
					tblResultModel.setRowCount(0);
					int row = 0;
					while ((rs != null) && (rs.next())) {
						tblResultModel.addRow(new Object[0]);
						tblResultModel.setValueAt(rs.getString("sach.id"), row, 0);
						tblResultModel.setValueAt(rs.getString("ten_sach"), row, 1);
						tblResultModel.setValueAt(rs.getString("tac_gia"), row, 2);
						tblResultModel.setValueAt(rs.getString("so_luong_tong"), row, 3);
						tblResultModel.setValueAt(rs.getString("so_luong_kho"), row, 4);
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
			try {
				// Load data to txtFld + combobox
				if (!CheckLogin.getLoggedrole().equals("bandoc")) {
					btnSua.setEnabled(true);
					btnXoa.setEnabled(true);
				}
				int row = tblResult.getSelectedRow();
				String[] where = { "sach.id" };
				String[] value = { tblResultModel.getValueAt(row, 0).toString() };
				ResultSet rs = sachModel.getSach(where, value);
				rs.next();
				setText(rs.getString("sach.id"), rs.getString("ten_sach"), rs.getString("tac_gia"),
						rs.getString("nam_xuat_ban"), rs.getString("the_loai.id"), rs.getString("nha_xuat_ban.id"),
						rs.getString("so_luong_tong"), rs.getString("so_luong_kho"));
				removeErr();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	private Sach GetDataInput() throws MyException {
		boolean checkTenSach = myEx.checkTenSach(txtFldTenSach, txtFldTacGia);
		boolean checkTacGia = myEx.checkEmpty(txtFldTacGia);
		boolean checkNamXuatBan = myEx.checkNumber(txtFldNamXuatBan);
		boolean checkTheLoai = myEx.checkCmbBx(cbBxTheLoai);
		boolean checkNhaXuatBan = myEx.checkCmbBx(cbBxNhaXuatBan);
		boolean checkSlTong = myEx.checkNumber(txtFldSLTong);

		int row = tblResult.getSelectedRow();
		if (row != -1) {
			String tenSachCu = tblResultModel.getValueAt(row, 1).toString();
			if (txtFldTenSach.getText().equals(tenSachCu)) {
				checkTenSach = true;
				myEx.reset(txtFldTenSach);
			}
		}

		if (checkTenSach && checkTacGia && checkNamXuatBan && checkTheLoai && checkNhaXuatBan && checkSlTong) {
			String maSach = txtFldMaSach.getText();
			String tenSach = txtFldTenSach.getText();
			String tacGia = txtFldTacGia.getText();
			String namXuatBan = txtFldNamXuatBan.getText();
			String theLoai = ((ComboItem) cbBxTheLoai.getSelectedItem()).getKey();
			String nhaXuatBan = ((ComboItem) cbBxNhaXuatBan.getSelectedItem()).getKey();
			int slTong = Integer.parseInt(txtFldSLTong.getText());
			int slHienCo;
			if (btnSua.isEnabled()) {
				slHienCo = Integer.parseInt(txtFldSLTong.getText())
						- Integer.parseInt(tblResultModel.getValueAt(row, 3).toString())
						+ Integer.parseInt(tblResultModel.getValueAt(row, 4).toString());
			} else {
				slHienCo = slTong;
			}
			Sach sach = new Sach(maSach, tenSach, tacGia, namXuatBan, theLoai, nhaXuatBan, slTong, slHienCo);
			return sach;
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
				} else {
					Sach sach = GetDataInput();
					if (sach != null && sachModel.addSach(sach) > 0) {
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
				Sach sach = GetDataInput();
				if (sach != null && sachModel.editSach(sach) > 0) {
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
						if (sachModel.deleteSach(id) > 0) {
							tblResultModel.removeRow(row);
							btnThem.doClick();
							JOptionPane.showMessageDialog(null, "Xóa thành công!");
						} else {
							JOptionPane.showMessageDialog(null, "Xóa thất bại, có bạn đọc đang mượn sách này!");
						}
					}
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	@SuppressWarnings({ "unchecked" })
	private void getNhaXuatBan() {
		try {
			ComboItem item;
			cbBxNhaXuatBan.addItem(null);

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
			cbBxTheLoai.addItem(null);

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

	private void getRole() {
		if (CheckLogin.getLoggedrole().equals("bandoc")) {
			btnThem.setEnabled(false);
			txtFldMaSach.setText("");
			txtFldTenSach.setEditable(false);
			txtFldTacGia.setEditable(false);
			txtFldNamXuatBan.setEditable(false);
			txtFldSLTong.setEditable(false);
			cbBxTheLoai.setEnabled(false);
			cbBxNhaXuatBan.setEnabled(false);
		}
	}
}