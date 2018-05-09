package ffse1703020.qltv.ui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;


import ffse1703020.qltv.model.PlaceholderTextField;

public class MuonTraSachUI extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PlaceholderTextField txtFldSearch, txtFldMaBanDoc;
	private JTextField txtFldMaTen, txtFldDienThoai,txtMaDG, txtNgayMuon,txtHanTra,txtSoLuong;
	private JTable tblSachChuaTra, tblSachSeMuon;
	private JButton btnSearch, btnThem, btnXoa, btnMuon, btnTra;
	@SuppressWarnings("rawtypes")
	private JComboBox cbBxSearch;
	private DefaultTableModel tblSachChuaTraModel = new DefaultTableModel(
			new Object[][] { { null, null, null, null }, { null, null, null, null }, {  null, null, null, null }, },
			new String[] { "Mã Sách", "Tên sách","Loại Sách","Số Lượng"});
	private DefaultTableModel tblSearchSachResultModel = new DefaultTableModel(new Object[][] {},
			new String[] { "Mã sách", "Tên sách", "Tác giả", "Số lượng" });
	private DefaultTableModel tblSachSeMuonModel = new DefaultTableModel(new Object[][] {},
			new String[] { "Mã Bạn Đọc", "Ngày Mượn", "Hạn Trả", "Số Lượng" });


	/**
	 * Create the pnl.
	 */
	public MuonTraSachUI() {
		addControls();
		addEvents();
	}

	private void addEvents() {
	
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
				new TitledBorder(null, "Thông Tin Sách", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlThongTinBanDoc.add(pnlThongTinBanDocBorder);
		pnlThongTinBanDocBorder.setLayout(new BoxLayout(pnlThongTinBanDocBorder, BoxLayout.Y_AXIS));

		JPanel pnlMaBanDoc = new JPanel();
		pnlThongTinBanDocBorder.add(pnlMaBanDoc);

		JLabel lblMaBanDoc = new JLabel("Mã Sách: ");
		lblMaBanDoc.setPreferredSize(new Dimension(90, 20));
		pnlMaBanDoc.add(lblMaBanDoc);

		txtFldMaBanDoc = new PlaceholderTextField();
		txtFldMaBanDoc.setPreferredSize(new Dimension(175, 22));
		txtFldMaBanDoc.setPlaceholder("e.g. 00001");
		pnlMaBanDoc.add(txtFldMaBanDoc);

		JPanel pnlTen = new JPanel();
		pnlThongTinBanDocBorder.add(pnlTen);

		JLabel lblTen = new JLabel("Tên Sách: ");
		lblTen.setPreferredSize(new Dimension(90, 20));
		pnlTen.add(lblTen);

		txtFldMaTen = new JTextField();
		txtFldMaTen.setPreferredSize(txtFldMaBanDoc.getPreferredSize());
		txtFldMaTen.setEditable(false);
		pnlTen.add(txtFldMaTen);

		JPanel pnlDienThoai = new JPanel();
		pnlThongTinBanDocBorder.add(pnlDienThoai);

		JLabel lblDienThoai = new JLabel("Loại Sách: ");
		lblDienThoai.setPreferredSize(lblTen.getPreferredSize());
		pnlDienThoai.add(lblDienThoai);

		txtFldDienThoai = new JTextField();
		txtFldDienThoai.setPreferredSize(txtFldMaBanDoc.getPreferredSize());
		txtFldDienThoai.setEditable(false);
		pnlDienThoai.add(txtFldDienThoai);

		JPanel pnlSachChuaTra = new JPanel();
		pnlThongTinBanDocBorder.add(pnlSachChuaTra);

		JLabel lblSachChuaTra = new JLabel("Số Lượng: ");
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
				new TitledBorder(null, "Thông Tin Mượn Sách", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlThongTinSach.add(pnlThongTinSachBorder);
		pnlThongTinSachBorder.setLayout(new BoxLayout(pnlThongTinSachBorder, BoxLayout.Y_AXIS));

		JPanel pnSach1 = new JPanel();
		pnlThongTinSachBorder.add(pnSach1);
		JLabel lbTS = new JLabel("Mã Bạn Đọc:");
		lbTS.setPreferredSize(new Dimension(80, 20));
		txtMaDG = new JTextField();
		Font fTS = new Font("arial", Font.PLAIN, 12);
		lbTS.setFont(fTS);
		txtMaDG.setColumns(15);
		pnSach1.add(lbTS);
		pnSach1.add(txtMaDG);
		
		JPanel pnSach2 = new JPanel();
		pnlThongTinSachBorder.add(pnSach2);
		JLabel lbTS1 = new JLabel("Ngày Mượn:");
		lbTS1.setPreferredSize(new Dimension(80, 20));
		txtNgayMuon = new JTextField();
		Font fTS1 = new Font("arial", Font.PLAIN, 12);
		lbTS1.setFont(fTS1);
		txtNgayMuon.setColumns(15);
		pnSach2.add(lbTS1);
		pnSach2.add(txtNgayMuon);
		
		JPanel pnSach3 = new JPanel();
		pnlThongTinSachBorder.add(pnSach3);
		JLabel lbTS2 = new JLabel("Hạn Trả:");
		lbTS2.setPreferredSize(new Dimension(80, 20));
		txtHanTra = new JTextField();
		Font fTS2 = new Font("arial", Font.PLAIN, 12);
		lbTS2.setFont(fTS2);
		txtHanTra.setColumns(15);
		pnSach3.add(lbTS2);
		pnSach3.add(txtHanTra);
		
		JPanel pnSach4 = new JPanel();
		pnlThongTinSachBorder.add(pnSach4);
		JLabel lbTS3 = new JLabel("Số Lượng:");
		lbTS3.setPreferredSize(new Dimension(80, 20));
		txtSoLuong = new JTextField();
		Font fTS3 = new Font("arial", Font.PLAIN, 12);
		lbTS3.setFont(fTS3);
		txtSoLuong.setColumns(15);
		pnSach4.add(lbTS3);
		pnSach4.add(txtSoLuong);
		
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
		columnModel_3.getColumn(0).setPreferredWidth(80);
		columnModel_3.getColumn(1).setPreferredWidth(180);

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
	
}