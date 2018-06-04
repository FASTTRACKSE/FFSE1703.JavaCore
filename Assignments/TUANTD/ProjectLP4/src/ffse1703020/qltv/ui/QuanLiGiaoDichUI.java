package ffse1703020.qltv.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import ffse1703020.qltv.model.ConnectDB;
import ffse1703020.qltv.model.PlaceholderTextField;

public class QuanLiGiaoDichUI extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ConnectDB cn = new ConnectDB();
	Connection conn = (Connection) ConnectDB.getConnect();
	private JButton jbThem, jbThoat;
	private PlaceholderTextField txtFldSearch;
	private JButton btnSearch;

	private JComboBox<Object> cbBxSearch;
	JScrollPane spListBDoc = new JScrollPane();
	JTable tbListBDoc = new JTable();
	private String tbBDoc[] = { "Mã Mượn", "Mã Bạn Đọc", "Mã Sách", "Ngày Mượn", "Hạn Trả", "Tình Trạng" };
	DefaultTableModel mdTableBDoc = new DefaultTableModel(tbBDoc, 0);

	// tìm kiếm sách
	ActionListener evTimKiem = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			TimKiem();
		}
	};

	ActionListener tra = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			int row1 = tbListBDoc.getSelectedRow();
			if (row1 < 0) {
				JOptionPane.showMessageDialog(null, "Chọn sách cần trả", "Borrow Button", JOptionPane.PLAIN_MESSAGE);
			} else {
				int dialogButton = JOptionPane.YES_NO_OPTION;
				dialogButton = JOptionPane.showConfirmDialog(null, "Cho đọc giả trả sách???", "WARNING",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (dialogButton == JOptionPane.YES_OPTION) {
					traSach((String) tbListBDoc.getValueAt(row1, 0));
					ttDG((String) tbListBDoc.getValueAt(row1, 1));
					ttSach((String) tbListBDoc.getValueAt(row1, 2));
				}

			}

		}
	};

	public QuanLiGiaoDichUI() {
		controls();
		Display();
		addEvents();

	}

	public void controls() {
		// Search mã giao dịch
		JPanel pnlSearch = new JPanel();
		FlowLayout fl_pnlSearch = (FlowLayout) pnlSearch.getLayout();
		fl_pnlSearch.setVgap(15);

		cbBxSearch = new JComboBox<Object>();
		cbBxSearch.setModel(new DefaultComboBoxModel<Object>(new String[] { "Mã Mượn", "Mã Bạn Đọc" }));
		pnlSearch.add(cbBxSearch);

		txtFldSearch = new PlaceholderTextField();
		txtFldSearch.setPreferredSize(new Dimension(175, 22));
		txtFldSearch.setPlaceholder("e.g. 00001");
		pnlSearch.add(txtFldSearch);

		btnSearch = new JButton("Tìm");
		pnlSearch.add(btnSearch);
		// table giao dịch
		JPanel pnTableKH = new JPanel();

		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTittle1 = BorderFactory.createTitledBorder(border, "Danh Sach");
		spListBDoc.setBorder(borderTittle1);
		tbListBDoc.setModel(mdTableBDoc);
		tbListBDoc.setPreferredScrollableViewportSize(new Dimension(700, 200));
		tbListBDoc.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		spListBDoc.setViewportView(tbListBDoc);
		pnTableKH.add(spListBDoc);
		// footter
		JPanel pnSuKien = new JPanel();

		JPanel pnThem = new JPanel();
		jbThem = new JButton("Trả Sách");
		jbThem.setPreferredSize(new Dimension(100, 20));
		pnThem.add(jbThem);
		jbThem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtFldSearch.setText("");
				mdTableBDoc.setRowCount(0);
				Display();
			}
		});

		JPanel pnThoat = new JPanel();
		jbThoat = new JButton("UPDATE");
		jbThoat.setPreferredSize(new Dimension(100, 20));
		jbThoat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtFldSearch.setText("");
				mdTableBDoc.setRowCount(0);
				Display();
			}
		});
		pnThoat.add(jbThoat);

		pnSuKien.add(pnThem);
		pnSuKien.add(pnThoat);
		// ADD TO Jpnl
		this.add(pnlSearch);
		this.add(pnTableKH);
		this.add(pnSuKien);
	}

	// phần tìm kiếm sách
	public void TimKiem() {
		if (conn != null) {
			String choose = cbBxSearch.getSelectedItem().toString();
			String search = txtFldSearch.getText();
			String sql = null;
			if (choose.equals("Mã Mượn")) {
				sql = "SELECT * FROM muon_tra_sach WHERE ma_muon_tra=?";
			} else if (choose.equals("Mã Bạn Đọc")) {
				sql = "SELECT * FROM muon_tra_sach WHERE ma_ban_doc=?";
			}
			try {
				PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
				// khởi tạo resultset
				ptmt.setString(1, search);

				ResultSet rs = ptmt.executeQuery();
				mdTableBDoc.setRowCount(0);
				while (rs.next()) {
					String rows[] = new String[6];

					rows[0] = rs.getString(1);
					rows[1] = rs.getString(2);
					rows[2] = rs.getString(3);
					rows[3] = rs.getString(4);
					rows[4] = rs.getString(5);
					rows[5] = rs.getString(6);

					mdTableBDoc.addRow(rows);
				}
			} catch (SQLException e) {
				System.out.println("loi  " + e.getMessage());

			}
		} else {
			System.out.println("Kết nối MYSQL thất bại");

		}
	}

	// Lấy data mượn trả
	public void Display() {
		if (conn != null) {

			String sql = "SELECT * FROM muon_tra_sach ORDER BY ma_muon_tra ASC";
			try {
				PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
				// khởi tạo resultset
				ResultSet rs = ptmt.executeQuery();
				while (rs.next()) {
					String rows[] = new String[6];

					rows[0] = rs.getString(1);
					rows[1] = rs.getString(2);
					rows[2] = rs.getString(3);
					rows[3] = rs.getString(4);
					rows[4] = rs.getString(5);
					rows[5] = rs.getString(6);

					mdTableBDoc.addRow(rows);
				}
			} catch (SQLException e) {
				System.out.println("loi  " + e.getMessage());

			}
		} else {
			System.out.println("Kết nối MYSQL thất bại");
		}
	}

	// Trả sách
	public void traSach(String MaGD) {
		String sqlCommand = "UPDATE muon_tra_sach SET tinh_trang = 'Đã trả' WHERE ma_muon_tra = ?";
		PreparedStatement pst = null;
		try {
			pst = (PreparedStatement) conn.prepareStatement(sqlCommand);
			pst.setString(1, MaGD);
			if (pst.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null, "Trả sách thành công", "Borrow Button", JOptionPane.PLAIN_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Lỗi khi trả sách", "Borrow Button", JOptionPane.PLAIN_MESSAGE);
			}
		} catch (SQLException e) {
			System.out.println("error \n" + e.toString());
		}
	}

	// Bạn đọc trả sách
	public void ttDG(String ID) {
		String sqlCommand = "UPDATE ban_doc SET `so_sach_muon` = `so_sach_muon` - 1 WHERE ma_ban_doc = ?";
		PreparedStatement pst = null;
		try {
			pst = (PreparedStatement) conn.prepareStatement(sqlCommand);
			pst.setString(1, ID);
			if (pst.executeUpdate() > 0) {
				//
			} else {
				JOptionPane.showMessageDialog(null, "Lỗi khi trả sách", "Add Button", JOptionPane.PLAIN_MESSAGE);
			}
		} catch (SQLException e) {
			System.out.println("error \n" + e.toString());
		}
	}

	// Sách trả sách
	public void ttSach(String ID) {
		String sqlCommand = "UPDATE sach SET `ton_kho` = `ton_kho` + 1 WHERE ma_sach = ?";
		PreparedStatement pst = null;
		try {
			pst = (PreparedStatement) conn.prepareStatement(sqlCommand);
			pst.setString(1, ID);
			if (pst.executeUpdate() > 0) {
				//
			} else {
				JOptionPane.showMessageDialog(null, "Lỗi khi Trả sách", "Add Button", JOptionPane.PLAIN_MESSAGE);
			}
		} catch (SQLException e) {
			System.out.println("error \n" + e.toString());
		}
	}

	// sự kiện
	private void addEvents() {
		// tìm sách
		btnSearch.addActionListener(evTimKiem);
		jbThem.addActionListener(tra);
	}

}
