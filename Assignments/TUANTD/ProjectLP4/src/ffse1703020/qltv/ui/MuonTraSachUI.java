package ffse1703020.qltv.ui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import javax.swing.BoxLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.toedter.calendar.JDateChooser;

import ffse1703020.qltv.model.ConnectDB;
import ffse1703020.qltv.model.PlaceholderTextField;

public class MuonTraSachUI extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ConnectDB cn = new ConnectDB();
	Connection conn = (Connection) ConnectDB.getConnect();
	private PlaceholderTextField txtFldSearch, txtFldSearchBD, txtFldMaSach;
	private JTextField txtFldTenSach, txtFldLoaiSach, txtMaDG, txtSoLuong;
	private JTable tblSachChuaTra, tblBD;
	private JLabel lblSoLuong;
	private JButton btnSearch, btnSearchBD, btnThem, btnThoat;
	private JDateChooser dayMuon, dayTra;
	@SuppressWarnings("rawtypes")
	private JComboBox cbBxSearch, cbBxSearchBD;
	private DefaultTableModel tblSachChuaTraModel = new DefaultTableModel(
			new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null }, },
			new String[] { "Mã Sách", "Tên sách", "Số Lượng", "Loại Sách" });
	private DefaultTableModel tblBanDoc = new DefaultTableModel(
			new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null }, },
			new String[] { "Mã Bạn Đọc", "Tên", "Số Điện Thoại", "Số Đang Mượn" });

	/**
	 * Create the pnl.
	 */
	// <--------tìm kiếm sách------->
	ActionListener evTimKiem = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			TimKiem();
		}
	};
	//<------tìm kiếm Bạn Đọc------>
	ActionListener evTimKiemBD = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			TimKiemBD();
		}
	};
	//<-----Thêm Vào danh sách mượn------->
	ActionListener evInsert = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			ktDG();
		}
	};

	public MuonTraSachUI() {
		addControls();
		addEvents();
	}

	// <-------hiển thị danh sách sách------>
	MouseAdapter eventselect = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			txtFldMaSach.setEditable(false);
			int i = tblSachChuaTra.getSelectedRow();
			String[] row = new String[4];
			for (int j = 0; j < row.length; j++) {
				row[j] = (String) tblSachChuaTraModel.getValueAt(i, j);
			}
			txtFldMaSach.setText(row[0]);
			txtFldTenSach.setText(row[1]);
			lblSoLuong.setText(row[2]);
			txtFldLoaiSach.setText(row[3]);

		}
	};
	//<--------hiển thị danh sách bạn đọc--------->
	MouseAdapter eventselectBD = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			txtMaDG.setEditable(false);
			int i = tblBD.getSelectedRow();
			String[] row = new String[4];
			for (int j = 0; j < row.length; j++) {
				row[j] = (String) tblBanDoc.getValueAt(i, j);
			}
			txtMaDG.setText(row[0]);
			txtSoLuong.setText(row[3]);

		}
	};

	//<--------- Phương thức cho mượn sách--------->
	public void muonSach() {
		String sqlCommand = "INSERT INTO muon_tra_sach (`ma_ban_doc`, `ma_sach_muon`, `ngay_muon`, `ngay_tra`,`tinh_trang`) VALUE( ?, ?, ?, ?, 'Đang mượn')";
		PreparedStatement pst = null;
		int kiemTra = 0;
		try {
			kiemTra = (int) TimeUnit.MILLISECONDS
					.toDays(Math.abs(dayTra.getCalendar().getTimeInMillis() - dayMuon.getCalendar().getTimeInMillis()));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Chưa Chọn Ngày!");
		}
		if (kiemTra > 3) {
			Calendar tra = Calendar.getInstance();
			tra.add(Calendar.DATE, 3);
			dayTra.setCalendar(tra);
			JOptionPane.showMessageDialog(null, "Hạn Mượn Không Được Quá 3 Ngày!");

		} else {
			try {
				pst = (PreparedStatement) conn.prepareStatement(sqlCommand);
				pst.setString(1, txtMaDG.getText());
				pst.setString(2, txtFldMaSach.getText());
				pst.setString(3, ((JTextField) dayMuon.getDateEditor().getUiComponent()).getText());
				pst.setString(4, ((JTextField) dayTra.getDateEditor().getUiComponent()).getText());
				if (pst.executeUpdate() > 0) {
					JOptionPane.showMessageDialog(null, "Cho Mượn Thành Công!");
				} else {
					JOptionPane.showMessageDialog(null, "Cho Mượn Thất Bại!");
				}
			} catch (SQLException e) {
				System.out.println("error \n" + e.toString());
			}
		}

	}

	//<--------Phương thức Kiểm tra đọc giả--------> 
	private ResultSet ktDG() {
		ResultSet rs = null;
		ResultSet rs1 = null;
		Statement st;
		Statement st1;
		int rsdg = 0;
		int rssach = 0;
		String sqlCommand = "SELECT so_sach_muon FROM ban_doc WHERE ma_ban_doc ='" + txtMaDG.getText() + "'";
		String sqlCommand1 = "SELECT ton_kho FROM sach WHERE ma_sach ='" + txtFldMaSach.getText() + "'";
		int row1 = tblBD.getSelectedRow();
		int row2 = tblSachChuaTra.getSelectedRow();
		try {
			st = (Statement) conn.createStatement();
			rs = st.executeQuery(sqlCommand);
			st1 = (Statement) conn.createStatement();
			rs1 = st1.executeQuery(sqlCommand1);
			rs.next();
			rs1.next();
			rsdg = rs.getInt("so_sach_muon");
			rssach = rs1.getInt("ton_kho");
			if (rsdg >= 3) {
				JOptionPane.showMessageDialog(null, "Mỗi đọc giả chỉ được mượn 3 cuốn", "Add Button",
						JOptionPane.PLAIN_MESSAGE);

			} else if (rssach == 0) {
				JOptionPane.showMessageDialog(null, "Số sách không đủ", "Add Button", JOptionPane.PLAIN_MESSAGE);
			} else {
				muonSach();
				ttDG((String) tblBD.getValueAt(row1, 0));
				ttSach((String) tblSachChuaTra.getValueAt(row2, 0));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Vui Lòng Chọn sách và đọc giả", "Borrow Button",
					JOptionPane.PLAIN_MESSAGE);

		}
		return rs;
	}

	// <-----Tình trạng sách------->
	public void ttSach(String ID_Sach) {
		String sqlCommand = "UPDATE sach SET `ton_kho` = `ton_kho` - 1 WHERE ma_sach = ?";
		PreparedStatement pst = null;
		try {
			pst = (PreparedStatement) conn.prepareStatement(sqlCommand);
			pst.setString(1, ID_Sach);
			if (pst.executeUpdate() > 0) {
				//
			} else {
				JOptionPane.showMessageDialog(null, "Lỗi khi mượn", "Add Button", JOptionPane.PLAIN_MESSAGE);
			}
		} catch (SQLException e) {
			System.out.println("error \n" + e.toString());
		}
	}

	// <-------Tình trạng bạn đọc-------->
	public void ttDG(String ID) {
		String sqlCommand = "UPDATE ban_doc SET `so_sach_muon` = `so_sach_muon` + 1 WHERE ma_ban_doc = ?";
		PreparedStatement pst = null;
		try {
			pst = (PreparedStatement) conn.prepareStatement(sqlCommand);
			pst.setString(1, ID);
			if (pst.executeUpdate() > 0) {
				//
			} else {
				JOptionPane.showMessageDialog(null, "Lỗi khi mượn", "Add Button", JOptionPane.PLAIN_MESSAGE);
			}
		} catch (SQLException e) {
			System.out.println("error \n" + e.toString());
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void addControls() {
		// Search sách
		JPanel pnlSearch = new JPanel();
		FlowLayout fl_pnlSearch = (FlowLayout) pnlSearch.getLayout();
		fl_pnlSearch.setVgap(15);

		cbBxSearch = new JComboBox();
		cbBxSearch.setModel(new DefaultComboBoxModel(new String[] { "Mã sách", "Tên sách" }));
		pnlSearch.add(cbBxSearch);

		txtFldSearch = new PlaceholderTextField();
		txtFldSearch.setPreferredSize(new Dimension(175, 22));
		txtFldSearch.setPlaceholder("e.g. 00001");
		pnlSearch.add(txtFldSearch);

		btnSearch = new JButton("Tìm");
		pnlSearch.add(btnSearch);

		// Search bạn đọc
		JPanel pnlSearchBD = new JPanel();
		FlowLayout fl_pnlSearchBD = (FlowLayout) pnlSearchBD.getLayout();
		fl_pnlSearchBD.setVgap(15);

		cbBxSearchBD = new JComboBox();
		cbBxSearchBD.setModel(new DefaultComboBoxModel(new String[] { "Mã Đọc Giả" }));
		pnlSearchBD.add(cbBxSearchBD);

		txtFldSearchBD = new PlaceholderTextField();
		txtFldSearchBD.setPreferredSize(new Dimension(175, 22));
		txtFldSearchBD.setPlaceholder("e.g. 00001");
		pnlSearchBD.add(txtFldSearchBD);

		btnSearchBD = new JButton("Tìm");
		pnlSearchBD.add(btnSearchBD);

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

		txtFldMaSach = new PlaceholderTextField();
		txtFldMaSach.setPreferredSize(new Dimension(175, 22));
		txtFldMaSach.setPlaceholder("e.g. 00001");
		pnlMaBanDoc.add(txtFldMaSach);

		JPanel pnlTen = new JPanel();
		pnlThongTinBanDocBorder.add(pnlTen);

		JLabel lblTen = new JLabel("Tên Sách: ");
		lblTen.setPreferredSize(new Dimension(90, 20));
		pnlTen.add(lblTen);

		txtFldTenSach = new JTextField();
		txtFldTenSach.setPreferredSize(txtFldMaSach.getPreferredSize());
		txtFldTenSach.setEditable(false);
		pnlTen.add(txtFldTenSach);

		JPanel pnlDienThoai = new JPanel();
		pnlThongTinBanDocBorder.add(pnlDienThoai);

		JLabel lblDienThoai = new JLabel("Loại Sách: ");
		lblDienThoai.setPreferredSize(lblTen.getPreferredSize());
		pnlDienThoai.add(lblDienThoai);

		txtFldLoaiSach = new JTextField();
		txtFldLoaiSach.setPreferredSize(txtFldMaSach.getPreferredSize());
		txtFldLoaiSach.setEditable(false);
		pnlDienThoai.add(txtFldLoaiSach);

		JPanel pnlSachChuaTra = new JPanel();
		pnlThongTinBanDocBorder.add(pnlSachChuaTra);

		JLabel lblSachChuaTra = new JLabel("Số Lượng: ");
		lblSoLuong = new JLabel();
		lblSachChuaTra.setPreferredSize(lblTen.getPreferredSize());
		pnlSachChuaTra.add(lblSachChuaTra);
		pnlSachChuaTra.add(lblSoLuong);
		// table sách
		JLabel textFieldSachChuaTra = new JLabel();
		textFieldSachChuaTra.setPreferredSize(txtFldMaSach.getPreferredSize());

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

		// Thông tin bạn đọc
		JPanel pnlThongTinSach = new JPanel();
		pnlThongTinMuonSach.add(pnlThongTinSach);

		JPanel pnlThongTinSachBorder = new JPanel();
		pnlThongTinSachBorder.setPreferredSize(new Dimension(375, 325));
		pnlThongTinSachBorder.setBorder(
				new TitledBorder(null, "Thông Tin Bạn Đọc", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlThongTinSach.add(pnlThongTinSachBorder);
		pnlThongTinSachBorder.setLayout(new BoxLayout(pnlThongTinSachBorder, BoxLayout.Y_AXIS));

		JLabel lbTS = new JLabel("Mã Bạn Đọc:");
		lbTS.setPreferredSize(new Dimension(80, 20));
		txtMaDG = new JTextField();
		Font fTS = new Font("arial", Font.PLAIN, 12);
		lbTS.setFont(fTS);
		txtMaDG.setColumns(15);

		JLabel lbTS1 = new JLabel("Ngày Mượn:");
		lbTS1.setPreferredSize(new Dimension(80, 20));
		dayMuon = new JDateChooser();
		dayMuon.setCalendar(Calendar.getInstance());
		dayMuon.setDateFormatString("yyyy-MM-dd");

		JLabel lbTS2 = new JLabel("Hạn Trả:");
		lbTS2.setPreferredSize(new Dimension(80, 20));
		dayTra = new JDateChooser();
		dayTra.setDateFormatString("yyyy-MM-dd");

		JLabel lbTS3 = new JLabel("Số Lượng:");
		lbTS3.setPreferredSize(new Dimension(80, 20));
		txtSoLuong = new JTextField();
		Font fTS3 = new Font("arial", Font.PLAIN, 12);
		txtSoLuong.setEnabled(false);
		lbTS3.setFont(fTS3);
		txtSoLuong.setColumns(15);

		// table Bạn Đọc
		JPanel pnlBanDoc = new JPanel();
		pnlThongTinSachBorder.add(pnlBanDoc);

		JLabel textFieldBanDoc = new JLabel();
		textFieldBanDoc.setPreferredSize(txtMaDG.getPreferredSize());

		pnlBanDoc.add(textFieldBanDoc);
		JScrollPane scrollPaneSachChuaTraDetail1 = new JScrollPane();
		scrollPaneSachChuaTraDetail1.setPreferredSize(new Dimension(350, 80));
		pnlBanDoc.add(scrollPaneSachChuaTraDetail1);

		tblBD = new JTable() {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		// Canh giữa cell header table
		JTableHeader tableHeader_2 = tblBD.getTableHeader();
		tableHeader_2.setDefaultRenderer(new HeaderRenderer(tblBD));

		tblBD.setModel(tblBanDoc);
		scrollPaneSachChuaTraDetail1.setViewportView(tblBD);

		TableColumnModel columnModel_2 = tblBD.getColumnModel();
		columnModel_2.getColumn(1).setPreferredWidth(175);
		columnModel_2.getColumn(2).setPreferredWidth(125);

		// căn chỉnh giao diện
		JPanel pnGroup = new JPanel();
		pnlThongTinSachBorder.add(pnGroup);
		GroupLayout accountLayout = new GroupLayout(pnGroup);
		pnGroup.setLayout(accountLayout);
		accountLayout.setAutoCreateGaps(true);
		accountLayout.setAutoCreateContainerGaps(true);

		accountLayout.setHorizontalGroup(accountLayout.createSequentialGroup()
				.addGroup(accountLayout.createParallelGroup().addComponent(lbTS).addComponent(lbTS1).addComponent(lbTS2)
						.addComponent(lbTS3))
				.addGroup(accountLayout.createParallelGroup().addComponent(txtMaDG).addComponent(dayMuon)
						.addComponent(dayTra).addComponent(txtSoLuong)));
		accountLayout.setVerticalGroup(accountLayout.createSequentialGroup()
				.addGroup(accountLayout.createParallelGroup().addComponent(lbTS).addComponent(txtMaDG))
				.addGroup(accountLayout.createParallelGroup().addComponent(lbTS1).addComponent(dayMuon))
				.addGroup(accountLayout.createParallelGroup().addComponent(lbTS2).addComponent(dayTra))
				.addGroup(accountLayout.createParallelGroup().addComponent(lbTS3).addComponent(txtSoLuong)));

		JPanel pnlThongTinSachButton = new JPanel();
		FlowLayout fl_pnlThongTinSachButton = (FlowLayout) pnlThongTinSachButton.getLayout();
		fl_pnlThongTinSachButton.setHgap(25);
		pnlThongTinSachBorder.add(pnlThongTinSachButton);

		btnThem = new JButton("Thêm vào DS mượn");
		btnThem.setEnabled(true);

		btnThoat = new JButton("Quay lại");
		btnThoat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtFldSearch.setText("");
				txtFldSearchBD.setText("");
				// update sách
				txtFldMaSach.setEditable(true);
				txtFldMaSach.setText("");
				txtFldTenSach.setText("");
				txtFldLoaiSach.setText("");
				lblSoLuong.setText("");
				// update bạn đọc
				txtMaDG.setEditable(true);
				txtMaDG.setText("");
				txtSoLuong.setText("");
				// update table
				tblBanDoc.setRowCount(0);
				tblSachChuaTraModel.setRowCount(0);

			}
		});

		pnlThongTinSachButton.add(btnThem);
		pnlThongTinSachButton.add(btnThoat);
		// ADD TO Jpnl
		// this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(pnlSearch);
		this.add(pnlSearchBD);
		this.add(pnlThongTinMuonSach);
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

	//<-------Phương thức tìm kiếm sách------->
	public void TimKiem() {
		if (conn != null) {
			String choose = cbBxSearch.getSelectedItem().toString();
			String search = txtFldSearch.getText();
			String sql = null;
			if (choose.equals("Mã sách")) {
				sql = "SELECT * FROM sach WHERE ma_sach=?";
			} else if (choose.equals("Tên sách")) {
				sql = "SELECT * FROM sach WHERE ten_sach=?";
			}
			try {
				PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
				// khởi tạo resultset
				ptmt.setString(1, search);

				ResultSet rs = ptmt.executeQuery();
				tblSachChuaTraModel.setRowCount(0);
				while (rs.next()) {
					String rows[] = new String[4];
					rows[0] = rs.getString(2);
					rows[1] = rs.getString(3);
					rows[2] = rs.getString(7);
					rows[3] = rs.getString(8);

					tblSachChuaTraModel.addRow(rows);
				}
			} catch (SQLException e) {
				System.out.println("loi  " + e.getMessage());

			}
		} else {
			System.out.println("Kết nối MYSQL thất bại");

		}
	}

	//<-------Phương Thức tìm kiếm bạn đọc--------->
	public void TimKiemBD() {
		if (conn != null) {
			// System.out.print(txtTKS.getText());
			String sql = "SELECT * FROM ban_doc WHERE ma_ban_doc LIKE '%" + txtFldSearchBD.getText()
					+ "%' or ho_ten LIKE '%" + txtFldSearchBD.getText() + "%'";

			try {
				PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
				// khởi tạo resultset

				ResultSet rs = ptmt.executeQuery();
				tblBanDoc.setRowCount(0);
				// mdTableSach.getDataVector().removeAllElements();
				while (rs.next()) {

					String rows[] = new String[4];

					rows[0] = rs.getString(2);
					rows[1] = rs.getString(3);
					rows[2] = rs.getString(4);
					rows[3] = rs.getString(10);

					tblBanDoc.addRow(rows);
				}
			} catch (SQLException e) {
				System.out.println("loi  " + e.getMessage());

			}
		} else {
			System.out.println("Kết nối MYSQL thất bại");

		}
	}

	// sự kiện
	private void addEvents() {
		// tìm sách
		tblSachChuaTra.addMouseListener(eventselect);
		btnSearch.addActionListener(evTimKiem);
		// tìm bạn đọc
		tblBD.addMouseListener(eventselectBD);
		btnSearchBD.addActionListener(evTimKiemBD);
		// xử lý mượn sách
		btnThem.addActionListener(evInsert);
	}

}