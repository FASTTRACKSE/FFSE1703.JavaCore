package namdv.ui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import namdv.model.BanDocModel;
import namdv.model.MuonTraSach;
import namdv.model.MuonTraSachModel;
import namdv.model.MyException;
import namdv.model.PlaceholderTextField;
import namdv.model.SachModel;

public class MuonTraSachUI extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PlaceholderTextField txtFldSearch, txtFldMaBanDoc;
	private JTextField txtFldMaTen, txtFldThanhPho, txtFldEmail, txtFldDienThoai;
	private JTable tblSachChuaTra, tblSearchSachResult, tblSachSeMuon;
	private JButton btnSearch, btnThem, btnXoa, btnMuon, btnTra;
	@SuppressWarnings("rawtypes")
	private JComboBox cbBxSearch;
	private ArrayList<String> arrSachChuaTra = new ArrayList<String>();
	private ArrayList<String> arrSachSeMuon = new ArrayList<String>();

	private DefaultTableModel tblSachChuaTraModel = new DefaultTableModel(
			new Object[][] { { null, null, null }, { null, null, null }, { null, null, null }, },
			new String[] { "Mã mượn", "Tên sách", "Ngày mượn" });
	private DefaultTableModel tblSearchSachResultModel = new DefaultTableModel(new Object[][] {},
			new String[] { "Mã sách", "Tên sách", "Tác giả", "Số lượng" });
	private DefaultTableModel tblSachSeMuonModel = new DefaultTableModel(new Object[][] {},
			new String[] { "Mã sách", "Tên sách", "Tác giả" });

	private BanDocModel banDocModel = new BanDocModel();
	private SachModel sachModel = new SachModel();
	private MuonTraSachModel muonTraSachModel = new MuonTraSachModel();
	private MyException myEx = new MyException();

	/**
	 * Create the pnl.
	 */
	public MuonTraSachUI() {
		addControls();
		addEvents();
	}

	private void addEvents() {
		txtFldSearch.addActionListener(new EnterListener());
		txtFldMaBanDoc.getDocument().addDocumentListener(new GetThongTinBanDoc());

		btnSearch.addActionListener(new SearchListener());
		btnThem.addActionListener(new ThemListener());
		btnXoa.addActionListener(new XoaListener());
		btnMuon.addActionListener(new MuonListener());
		btnTra.addActionListener(new TraListener());

		cbBxSearch.addActionListener(new SelectSearchListener());

		tblSachChuaTra.addMouseListener(new ClickTableTraSach());
		tblSearchSachResult.addMouseListener(new ClickTableResult());
		tblSachSeMuon.addMouseListener(new ClickTableDsMuon());
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void addControls() {
		// Search
		JPanel pnlSearch = new JPanel();
		FlowLayout fl_pnlSearch = (FlowLayout) pnlSearch.getLayout();
		fl_pnlSearch.setVgap(15);

		cbBxSearch = new JComboBox();
		cbBxSearch.setModel(new DefaultComboBoxModel(new String[] { "Mã sách", "Tên sách", "Tác giả" }));
		pnlSearch.add(cbBxSearch);

		txtFldSearch = new PlaceholderTextField();
		txtFldSearch.setPreferredSize(new Dimension(175, 22));
		txtFldSearch.setPlaceholder("e.g. 00001");
		pnlSearch.add(txtFldSearch);

		btnSearch = new JButton("Tìm");
		pnlSearch.add(btnSearch);

		// Thông tin mượn sách
		JPanel pnlThongTinMuonSach = new JPanel();
		pnlThongTinMuonSach.setLayout(new BoxLayout(pnlThongTinMuonSach, BoxLayout.X_AXIS));

		// Thông tin bạn đọc
		JPanel pnlThongTinBanDoc = new JPanel();
		pnlThongTinMuonSach.add(pnlThongTinBanDoc);

		JPanel pnlThongTinBanDocBorder = new JPanel();
		pnlThongTinBanDocBorder.setPreferredSize(new Dimension(375, 325));
		pnlThongTinBanDocBorder.setBorder(
				new TitledBorder(null, "Thông tin bạn đọc", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlThongTinBanDoc.add(pnlThongTinBanDocBorder);
		pnlThongTinBanDocBorder.setLayout(new BoxLayout(pnlThongTinBanDocBorder, BoxLayout.Y_AXIS));

		JPanel pnlMaBanDoc = new JPanel();
		pnlThongTinBanDocBorder.add(pnlMaBanDoc);

		JLabel lblMaBanDoc = new JLabel("Mã bạn đọc: ");
		lblMaBanDoc.setPreferredSize(new Dimension(90, 20));
		pnlMaBanDoc.add(lblMaBanDoc);

		txtFldMaBanDoc = new PlaceholderTextField();
		txtFldMaBanDoc.setPreferredSize(new Dimension(175, 22));
		txtFldMaBanDoc.setPlaceholder("e.g. 00001");
		pnlMaBanDoc.add(txtFldMaBanDoc);

		JPanel pnlTen = new JPanel();
		pnlThongTinBanDocBorder.add(pnlTen);

		JLabel lblTen = new JLabel("Tên: ");
		lblTen.setPreferredSize(new Dimension(90, 20));
		pnlTen.add(lblTen);

		txtFldMaTen = new JTextField();
		txtFldMaTen.setPreferredSize(txtFldMaBanDoc.getPreferredSize());
		txtFldMaTen.setEditable(false);
		pnlTen.add(txtFldMaTen);

		JPanel pnlThanhPho = new JPanel();
		pnlThongTinBanDocBorder.add(pnlThanhPho);

		JLabel lblThanhPho = new JLabel("Thành phố: ");
		lblThanhPho.setPreferredSize(lblTen.getPreferredSize());
		pnlThanhPho.add(lblThanhPho);

		txtFldThanhPho = new JTextField();
		txtFldThanhPho.setPreferredSize(txtFldMaBanDoc.getPreferredSize());
		txtFldThanhPho.setEditable(false);
		pnlThanhPho.add(txtFldThanhPho);

		JPanel pnlEmail = new JPanel();
		pnlThongTinBanDocBorder.add(pnlEmail);

		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setPreferredSize(lblTen.getPreferredSize());
		pnlEmail.add(lblEmail);

		txtFldEmail = new JTextField();
		txtFldEmail.setPreferredSize(txtFldMaBanDoc.getPreferredSize());
		txtFldEmail.setEditable(false);
		pnlEmail.add(txtFldEmail);

		JPanel pnlDienThoai = new JPanel();
		pnlThongTinBanDocBorder.add(pnlDienThoai);

		JLabel lblDienThoai = new JLabel("Điện thoại: ");
		lblDienThoai.setPreferredSize(lblTen.getPreferredSize());
		pnlDienThoai.add(lblDienThoai);

		txtFldDienThoai = new JTextField();
		txtFldDienThoai.setPreferredSize(txtFldMaBanDoc.getPreferredSize());
		txtFldDienThoai.setEditable(false);
		pnlDienThoai.add(txtFldDienThoai);

		JPanel pnlSachChuaTra = new JPanel();
		pnlThongTinBanDocBorder.add(pnlSachChuaTra);

		JLabel lblSachChuaTra = new JLabel("Sách chưa trả: ");
		lblSachChuaTra.setPreferredSize(lblTen.getPreferredSize());
		pnlSachChuaTra.add(lblSachChuaTra);

		JLabel textFieldSachChuaTra = new JLabel();
		textFieldSachChuaTra.setPreferredSize(txtFldMaBanDoc.getPreferredSize());

		pnlSachChuaTra.add(textFieldSachChuaTra);

		JPanel pnlSachChuaTraDetail = new JPanel();
		pnlThongTinBanDocBorder.add(pnlSachChuaTraDetail);

		JScrollPane scrollPaneSachChuaTraDetail = new JScrollPane();
		scrollPaneSachChuaTraDetail.setPreferredSize(new Dimension(350, 80));
		pnlSachChuaTraDetail.add(scrollPaneSachChuaTraDetail);

		tblSachChuaTra = new JTable() {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};

		// tableResult.setAutoCreateRowSorter(true);
		// Canh giữa cell header table
		JTableHeader tableHeader_1 = tblSachChuaTra.getTableHeader();
		tableHeader_1.setDefaultRenderer(new HeaderRenderer(tblSachChuaTra));

		tblSachChuaTra.setModel(tblSachChuaTraModel);
		scrollPaneSachChuaTraDetail.setViewportView(tblSachChuaTra);

		TableColumnModel columnModel_1 = tblSachChuaTra.getColumnModel();
		columnModel_1.getColumn(1).setPreferredWidth(175);
		columnModel_1.getColumn(2).setPreferredWidth(125);

		// Thông tin sách
		JPanel pnlThongTinSach = new JPanel();
		pnlThongTinMuonSach.add(pnlThongTinSach);

		JPanel pnlThongTinSachBorder = new JPanel();
		pnlThongTinSachBorder.setPreferredSize(new Dimension(375, 325));
		pnlThongTinSachBorder.setBorder(
				new TitledBorder(null, "Thông tin sách", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlThongTinSach.add(pnlThongTinSachBorder);
		pnlThongTinSachBorder.setLayout(new BoxLayout(pnlThongTinSachBorder, BoxLayout.Y_AXIS));

		JPanel pnlSearchSachResult = new JPanel();
		pnlThongTinSachBorder.add(pnlSearchSachResult);

		JScrollPane scrollPaneSearchSachResult = new JScrollPane();
		pnlSearchSachResult.add(scrollPaneSearchSachResult);
		scrollPaneSearchSachResult.setPreferredSize(new Dimension(350, 150));

		tblSearchSachResult = new JTable() {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		// tableResult.setAutoCreateRowSorter(true);
		// Canh giữa cell header table
		JTableHeader tableHeader_2 = tblSearchSachResult.getTableHeader();
		tableHeader_2.setDefaultRenderer(new HeaderRenderer(tblSearchSachResult));
		tblSearchSachResult.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		tblSearchSachResult.setModel(tblSearchSachResultModel);
		scrollPaneSearchSachResult.setViewportView(tblSearchSachResult);

		TableColumnModel columnModel_2 = tblSearchSachResult.getColumnModel();
		columnModel_2.getColumn(0).setPreferredWidth(75);
		columnModel_2.getColumn(1).setPreferredWidth(175);

		JPanel pnlThongTinSachButton = new JPanel();
		FlowLayout fl_pnlThongTinSachButton = (FlowLayout) pnlThongTinSachButton.getLayout();
		fl_pnlThongTinSachButton.setHgap(25);
		pnlThongTinSachBorder.add(pnlThongTinSachButton);

		btnThem = new JButton("Thêm vào DS mượn");
		btnThem.setEnabled(false);
		pnlThongTinSachButton.add(btnThem);

		btnXoa = new JButton("Xóa khỏi DS mượn");
		btnXoa.setEnabled(false);
		pnlThongTinSachButton.add(btnXoa);

		JPanel pnlSachSeMuon = new JPanel();
		pnlThongTinSachBorder.add(pnlSachSeMuon);

		JScrollPane scrollPaneSachSeMuon = new JScrollPane();
		pnlSachSeMuon.add(scrollPaneSachSeMuon);
		scrollPaneSachSeMuon.setPreferredSize(new Dimension(350, 80));

		tblSachSeMuon = new JTable() {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		// tableResult.setAutoCreateRowSorter(true);
		// Canh giữa cell header table
		JTableHeader tableHeader_3 = tblSachSeMuon.getTableHeader();
		tableHeader_3.setDefaultRenderer(new HeaderRenderer(tblSachSeMuon));
		tblSachSeMuon.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		tblSachSeMuon.setModel(tblSachSeMuonModel);
		scrollPaneSachSeMuon.setViewportView(tblSachSeMuon);

		TableColumnModel columnModel_3 = tblSachSeMuon.getColumnModel();
		columnModel_3.getColumn(0).setPreferredWidth(75);
		columnModel_3.getColumn(1).setPreferredWidth(175);

		// FOOTER
		JPanel pnlFooter = new JPanel();
		pnlFooter.setLayout(new BoxLayout(pnlFooter, BoxLayout.X_AXIS));

		JPanel pnlTraButton = new JPanel();
		pnlFooter.add(pnlTraButton);

		btnTra = new JButton("Trả sách");
		btnTra.setEnabled(false);
		pnlTraButton.add(btnTra);

		JPanel pnlMuonButton = new JPanel();
		pnlFooter.add(pnlMuonButton);

		btnMuon = new JButton("Mượn sách");
		btnMuon.setEnabled(false);
		pnlMuonButton.add(btnMuon);

		// ADD TO Jpnl
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(pnlSearch);
		this.add(pnlThongTinMuonSach);
		this.add(pnlFooter);
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

	private void setText(String hoTen, String thanhPho, String email, String dienThoai) {
		txtFldMaTen.setText(hoTen);
		txtFldThanhPho.setText(thanhPho);
		txtFldEmail.setText(email);
		txtFldDienThoai.setText(dienThoai);
	}

	private class GetThongTinBanDoc implements DocumentListener {
		@Override
		public void changedUpdate(DocumentEvent e) {
			getThongTinBanDoc();
		}

		@Override
		public void insertUpdate(DocumentEvent e) {
			getThongTinBanDoc();
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			getThongTinBanDoc();
		}

		public void getThongTinBanDoc() {
			try {
				String[] where = { "id" };
				String[] value = { txtFldMaBanDoc.getText() };
				ResultSet rs;
				int row = 0;
				tblSachChuaTraModel.setRowCount(0);
				tblSachSeMuonModel.setRowCount(0);
				btnXoa.setEnabled(false);
				btnMuon.setEnabled(false);
				btnTra.setEnabled(false);
				setText(null, null, null, null);

				rs = banDocModel.getBanDoc(where, value);
				// Load data to textfield
				if ((rs != null) && (rs.next())) {
					setText(rs.getString("ho_ten"), rs.getString("gsovn_tinhthanhpho.name"), rs.getString("email"),
							rs.getString("dien_thoai"));
					// Load data to table
					rs = banDocModel.getDataSachChuaTra(value[0]);
					arrSachChuaTra.clear();
					arrSachSeMuon.clear();
					while ((rs != null) && (rs.next())) {
						tblSachChuaTraModel.addRow(new Object[0]);
						arrSachChuaTra.add(rs.getString("ma_sach_muon"));
						tblSachChuaTraModel.setValueAt(rs.getString("ma_muon_tra"), row, 0);
						tblSachChuaTraModel.setValueAt(rs.getString("ten_sach"), row, 1);
						tblSachChuaTraModel.setValueAt(rs.getString("ngay_muon").replace(".0", ""), row, 2);
						row++;
					}
				}
				if (row < 3) {
					btnMuon.setEnabled(true);
					while (row < 3) {
						// tblSachChuaTraModel.addRow(new Object[0]);
						tblSachSeMuonModel.addRow(new Object[0]);
						row++;
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private class SearchListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				// reset table
				btnThem.setEnabled(false);
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
					tblSearchSachResultModel.setRowCount(0);
					int row = 0;
					while ((rs != null) && (rs.next())) {
						tblSearchSachResultModel.addRow(new Object[0]);
						tblSearchSachResultModel.setValueAt(rs.getString("sach.id"), row, 0);
						tblSearchSachResultModel.setValueAt(rs.getString("ten_sach"), row, 1);
						tblSearchSachResultModel.setValueAt(rs.getString("tac_gia"), row, 2);
						tblSearchSachResultModel.setValueAt(rs.getString("so_luong_kho"), row, 3);
						row++;
					}
				}
			} catch (SQLException | MyException ex) {
				ex.printStackTrace();
			}
		}
	}

	private class ClickTableResult extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			btnThem.setEnabled(true);
		}
	}

	private class ThemListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int index = tblSearchSachResult.getSelectedRow();
			int numRowTableDsMuon = tblSachSeMuon.getRowCount();
			int sizeArrSachSeMuon = arrSachSeMuon.size();
			String soLuongKho = tblSearchSachResultModel.getValueAt(index, 3).toString();
			String maSachMuon = tblSearchSachResultModel.getValueAt(index, 0).toString();

			if (txtFldMaTen.getText().length() == 0) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập mã bạn đọc!");
			} else if (numRowTableDsMuon == sizeArrSachSeMuon) {
				JOptionPane.showMessageDialog(null, "Bạn đọc chỉ được mượn tối đa 3 cuốn sách!");
			} else if (soLuongKho.equals("0")) {
				JOptionPane.showMessageDialog(null, "Sách không có sẵn trong kho!");
			} else if (arrSachChuaTra.contains(maSachMuon)) {
				JOptionPane.showMessageDialog(null, "Bạn đọc đã mượn sách này!");
			} else if (arrSachSeMuon.contains(maSachMuon)) {
				JOptionPane.showMessageDialog(null, "Sách đã có trong danh sách mượn!");
			} else {
				arrSachSeMuon.add(maSachMuon);
				String tenSachMuon = tblSearchSachResultModel.getValueAt(index, 1).toString();
				String tacGiaMuon = tblSearchSachResultModel.getValueAt(index, 2).toString();

				tblSachSeMuonModel.setValueAt(maSachMuon, sizeArrSachSeMuon, 0);
				tblSachSeMuonModel.setValueAt(tenSachMuon, sizeArrSachSeMuon, 1);
				tblSachSeMuonModel.setValueAt(tacGiaMuon, sizeArrSachSeMuon, 2);
			}
		}
	}

	private class ClickTableDsMuon extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			btnXoa.setEnabled(true);
		}
	}

	private class XoaListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int index = tblSachSeMuon.getSelectedRow();
			String maSachRemove = tblSachSeMuonModel.getValueAt(index, 0).toString();
			tblSachSeMuonModel.removeRow(index);
			tblSachSeMuonModel.addRow(new Object[0]);
			btnXoa.setEnabled(false);
			arrSachSeMuon.remove(maSachRemove);
		}
	}

	private class MuonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				if (arrSachSeMuon.size() <= 0) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn sách mượn!");
				} else {
					String maMuonTra = muonTraSachModel.getAutoId();
					String maBanDoc = txtFldMaBanDoc.getText();
					for (String maSachMuon : arrSachSeMuon) {
						MuonTraSach muonSach = new MuonTraSach(maMuonTra, maBanDoc, maSachMuon);
						muonTraSachModel.muonSach(muonSach);
					}
					txtFldMaBanDoc.setText(null);
					btnSearch.doClick();
					JOptionPane.showMessageDialog(null, "Mượn sách thành công!");
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	private class ClickTableTraSach extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			btnTra.setEnabled(true);
		}
	}

	private class TraListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				String maBanDoc = txtFldMaBanDoc.getText();

				int[] selection = tblSachChuaTra.getSelectedRows();
				for (int i : selection) {
					MuonTraSach traSach = new MuonTraSach(null, maBanDoc, arrSachChuaTra.get(i));
					muonTraSachModel.traSach(traSach);
				}
				txtFldMaBanDoc.setText(null);
				btnSearch.doClick();
				JOptionPane.showMessageDialog(null, "Trả sách thành công!");
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
}