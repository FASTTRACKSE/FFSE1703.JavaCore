package ffse1703020.qltv.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import ffse1703020.qltv.model.ConnectDB;
import ffse1703020.qltv.model.SachModel;

public class ThongKeBaoCaoUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ConnectDB cn = new ConnectDB();
	Connection conn = (Connection) ConnectDB.getConnect();
	private JComboBox<Object> comboBoxBDoc, comboBoxNXB, comboBoxTheLoai;
	private JTextField txtTKBD, txttonKho, txttongKho;
	private JButton jbTKBD, jbTKSach, jbThoat;
	// tabel Ban doc
	JScrollPane scrollPaneBD = new JScrollPane();
	JTable tbListBD = new JTable();
	private String tbBD[] = { "Mã TV", "Tên", "Thành Phố", "Số Sách Mượn" };
	DefaultTableModel mdTableBD = new DefaultTableModel(tbBD, 0);
	// table sach
	JScrollPane scrollPaneSach = new JScrollPane();
	JTable tbListSach = new JTable();
	private String tbSach[] = { "Mã Sách", "Tên Sách", "Tác Giả", "Sách Tồn Kho", "Tổng Sách" };
	DefaultTableModel mdTableSach = new DefaultTableModel(tbSach, 0);

	ActionListener evTimKiem = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			TimKiemBDoc();
		}
	};
	ActionListener evTimKiemSach = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			TimKiemSach();
		}

	};

	public ThongKeBaoCaoUI() {
		controls();
		KhoSach();
		events();
		comboboxThanhPho();
		comboboxNXB();
		comboboxTheLoai();

	}

	// layout thống kê báo cáo
	private void controls() {
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		// Main 2
		JPanel pnMain1 = new JPanel();
		pnMain1.setLayout(new BoxLayout(pnMain1, BoxLayout.Y_AXIS));
		JPanel pnTittle = new JPanel();
		JLabel lbTittle = new JLabel("Báo Cáo Danh Sách Bạn Đọc");
		Font fTittle = new Font("arial", Font.BOLD, 20);
		lbTittle.setFont(fTittle);
		pnTittle.add(lbTittle);

		JPanel pnTimKiemBD = new JPanel();
		JLabel lbBD = new JLabel("Thành Phố:");
		lbBD.setFont(new Font("Arial", Font.PLAIN, 15));
		comboBoxBDoc = new JComboBox<Object>();
		comboBoxBDoc.setPreferredSize(new Dimension(150, 20));
		comboBoxBDoc.setFont(new Font("Arial", Font.PLAIN, 12));
		comboBoxBDoc.setToolTipText("");
		pnTimKiemBD.add(lbBD);
		pnTimKiemBD.add(comboBoxBDoc);

		txtTKBD = new JTextField();
		txtTKBD.setColumns(15);
		Font fTk = new Font("arial", Font.PLAIN, 15);
		txtTKBD.setFont(fTk);
		jbTKBD = new JButton("Tìm kiếm");
		jbTKBD.setPreferredSize(new Dimension(100, 20));
		pnTimKiemBD.add(txtTKBD);
		pnTimKiemBD.add(jbTKBD);

		JPanel pnTableBD = new JPanel();
		pnTableBD.setLayout(new BoxLayout(pnTableBD, BoxLayout.Y_AXIS));

		scrollPaneBD.setPreferredSize(new Dimension(400, 153));
		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTittle = BorderFactory.createTitledBorder(border, "Danh Sách Bạn Đọc");
		scrollPaneBD.setBorder(borderTittle);
		tbListBD.setModel(mdTableBD);
		scrollPaneBD.setViewportView(tbListBD);
		pnTableBD.add(scrollPaneBD);

		pnMain1.add(pnTittle);
		pnMain1.add(pnTimKiemBD);
		pnMain1.add(pnTableBD);

		// Main 2
		JPanel pnMain2 = new JPanel();
		pnMain2.setLayout(new BoxLayout(pnMain2, BoxLayout.Y_AXIS));
		JPanel pnTittle1 = new JPanel();
		JLabel lbTittle1 = new JLabel("Báo cáo Sách");
		Font fTittle1 = new Font("arial", Font.BOLD, 20);
		lbTittle1.setFont(fTittle1);
		pnTittle1.add(lbTittle1);

		JPanel pnTimKiemSach = new JPanel();
		JLabel lbSach = new JLabel("Nhà Xuất Bản:");
		lbSach.setFont(new Font("Arial", Font.PLAIN, 15));
		comboBoxNXB = new JComboBox<Object>();
		comboBoxNXB.setPreferredSize(new Dimension(110, 20));
		ArrayList<String> array = SachModel.getListnxb();
		comboBoxNXB = new JComboBox<Object>(array.toArray());
		comboBoxNXB.setFont(new Font("Arial", Font.PLAIN, 12));
		comboBoxNXB.setToolTipText("");
		pnTimKiemSach.add(lbSach);
		pnTimKiemSach.add(comboBoxNXB);

		JLabel lbSach1 = new JLabel("Thể Loại:");
		lbSach1.setFont(new Font("Arial", Font.PLAIN, 15));
		comboBoxTheLoai = new JComboBox<Object>();
		comboBoxTheLoai.setPreferredSize(new Dimension(110, 20));
		ArrayList<String> arr = SachModel.getListtheloai();
		comboBoxTheLoai = new JComboBox<Object>(arr.toArray());
		comboBoxTheLoai.setFont(new Font("Arial", Font.PLAIN, 12));
		comboBoxTheLoai.setToolTipText("");
		pnTimKiemSach.add(lbSach1);
		pnTimKiemSach.add(comboBoxTheLoai);

		jbTKSach = new JButton("Tìm kiếm");
		jbTKSach.setPreferredSize(new Dimension(100, 20));
		pnTimKiemSach.add(jbTKSach);

		JPanel pnKho = new JPanel();
		JLabel lbkho = new JLabel("Sách Tồn Kho:");
		lbkho.setFont(new Font("Arial", Font.PLAIN, 15));
		txttonKho = new JTextField();
		txttonKho.setColumns(9);
		txttonKho.setEditable(false);
		Font fkho = new Font("arial", Font.PLAIN, 15);
		txttonKho.setFont(fkho);

		JLabel lbkho1 = new JLabel("Tổng Sách:");
		lbkho1.setFont(new Font("Arial", Font.PLAIN, 15));
		txttongKho = new JTextField();
		txttongKho.setColumns(20);
		txttongKho.setEditable(false);
		Font fkho1 = new Font("arial", Font.PLAIN, 15);
		txttongKho.setFont(fkho1);
		pnKho.add(lbkho);
		pnKho.add(txttonKho);
		pnKho.add(lbkho1);
		pnKho.add(txttongKho);

		JPanel pnTableSach = new JPanel();
		pnTableSach.setLayout(new BoxLayout(pnTableSach, BoxLayout.Y_AXIS));

		scrollPaneSach.setPreferredSize(new Dimension(400, 153));
		Border border1 = BorderFactory.createLineBorder(Color.BLUE);
		TitledBorder borderTittle1 = BorderFactory.createTitledBorder(border1, "Danh Sách Bạn Đọc");
		scrollPaneSach.setBorder(borderTittle1);
		tbListSach.setModel(mdTableSach);
		scrollPaneSach.setViewportView(tbListSach);
		pnTableSach.add(scrollPaneSach);

		pnMain2.add(pnTittle1);
		pnMain2.add(pnTimKiemSach);
		pnMain2.add(pnKho);
		pnMain2.add(pnTableSach);

		JPanel pnThoat = new JPanel();
		jbThoat = new JButton("Quay lại");
		jbThoat.setPreferredSize(new Dimension(140, 45));
		ImageIcon back = new ImageIcon(
				new ImageIcon("icons/Undo.png").getImage().getScaledInstance(25, 30, Image.SCALE_SMOOTH));
		JLabel lblIconBack = new JLabel(back);
		jbThoat.add(lblIconBack);
		jbThoat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mdTableBD.setRowCount(0);
				mdTableSach.setRowCount(0);
				txtTKBD.setText("");
				KhoSach();
			}
		});
		pnThoat.add(jbThoat);

		pnMain.add(pnMain1);
		pnMain.add(pnMain2);
		pnMain.add(pnThoat);

		this.add(pnMain);

	}

	public void events() {
		jbTKBD.addActionListener(evTimKiem);
		jbTKSach.addActionListener(evTimKiemSach);
	}

	// tìm kiếm bạn đọc
	public void TimKiemBDoc() {
		if (conn != null) {
			// System.out.print(txtTKS.getText());
			String sql = "SELECT * FROM Ban_Doc WHERE thanh_pho LIKE '%" + comboBoxBDoc.getSelectedItem().toString()
					+ "%' and ma_ban_doc LIKE '%" + txtTKBD.getText() + "%'";

			String sql1 = "SELECT * FROM Ban_Doc WHERE ma_ban_doc LIKE '%" + txtTKBD.getText() + "%'";

			try {
				if (comboBoxBDoc.getSelectedItem().toString().equals("Tất Cả")) {
					PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql1);
					// khởi tạo resultset

					ResultSet rs = ptmt.executeQuery();
					mdTableBD.setRowCount(0);
					// mdTableSach.getDataVector().removeAllElements();
					while (rs.next()) {
						String rows[] = new String[4];

						rows[0] = rs.getString(2);
						rows[1] = rs.getString(3);
						rows[2] = rs.getString(7);
						rows[3] = rs.getString(10);

						mdTableBD.addRow(rows);
					}
				} else {
					PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
					// khởi tạo resultset

					ResultSet rs = ptmt.executeQuery();
					mdTableBD.setRowCount(0);
					// mdTableSach.getDataVector().removeAllElements();
					while (rs.next()) {
						String rows[] = new String[4];

						rows[0] = rs.getString(2);
						rows[1] = rs.getString(3);
						rows[2] = rs.getString(7);
						rows[3] = rs.getString(10);

						mdTableBD.addRow(rows);
					}
				}
			} catch (SQLException e) {
				System.out.println("loi  " + e.getMessage());
			}
		} else {
			System.out.println("Kết nối MYSQL thất bại");
		}
	}

	// select thành phố
	public void comboboxThanhPho() {
		if (conn != null) {
			String sql = "select * from gsovn_tinhthanhpho";
			try {
				PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
				// khởi tạo resultset
				ResultSet rs = ptmt.executeQuery();
				comboBoxBDoc.addItem("Tất Cả");
				while (rs.next()) {
					String tpho = rs.getString("name");
					comboBoxBDoc.addItem(tpho);
				}
			} catch (SQLException e) {
				System.out.println("loi  " + e.getMessage());
			}
		} else {
			System.out.println("Kết nối MYSQL thất bại");
		}
	}

	// tìm kiếm sách
	public void TimKiemSach() {
		if (conn != null) {
			String sql = "SELECT * FROM sach WHERE nha_xuat_ban LIKE '%" + comboBoxNXB.getSelectedItem().toString()
					+ "%' and the_loai LIKE '%" + comboBoxTheLoai.getSelectedItem().toString() + "%'";

			try {
				PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
				// khởi tạo resultset
				ResultSet rs = ptmt.executeQuery();
				mdTableSach.setRowCount(0);
				while (rs.next()) {
					String rows[] = new String[5];

					rows[0] = rs.getString(2);
					rows[1] = rs.getString(3);
					rows[2] = rs.getString(4);
					rows[3] = rs.getString(9);
					rows[4] = rs.getString(7);

					mdTableSach.addRow(rows);
				}
			} catch (SQLException e) {
				System.out.println("loi  " + e.getMessage());
			}
		} else {
			System.out.println("Kết nối MYSQL thất bại");
		}
	}

	// select nhà xuất bản
	public void comboboxNXB() {
		if (conn != null) {
			String sql = "select distinct nha_xuat_ban from sach";
			try {
				PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
				// khởi tạo resultset
				ResultSet rs = ptmt.executeQuery();
				comboBoxNXB.addItem("Tất Cả");
				while (rs.next()) {
					String nxb = rs.getString("nha_xuat_ban");
					comboBoxNXB.addItem(nxb);
				}
			} catch (SQLException e) {
				System.out.println("loi  " + e.getMessage());
			}
		} else {
			System.out.println("Kết nối MYSQL thất bại");
		}
	}

	// select thể loại
	public void comboboxTheLoai() {
		if (conn != null) {
			String sql = "select * from the_loai";
			try {
				PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
				// khởi tạo resultset
				ResultSet rs = ptmt.executeQuery();
				while (rs.next()) {
					String tl = rs.getString("ten_the_loai");
					comboBoxTheLoai.addItem(tl);
				}
			} catch (SQLException e) {
				System.out.println("loi  " + e.getMessage());
			}
		} else {
			System.out.println("Kết nối MYSQL thất bại");
		}
	}

	// kho sách
	public void KhoSach() {
		if (conn != null) {
			String sql = "SELECT SUM(so_luong_tong), SUM(ton_kho) FROM sach";
			try {
				PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
				ResultSet rs = ptmt.executeQuery();
				while (rs.next()) {
					txttongKho.setText(rs.getString(1));
					txttonKho.setText(rs.getString(2));
				}
			} catch (SQLException e) {
				System.out.println("loi  " + e.getMessage());
			}
		} else {
			System.out.println("Kết nối thất bại");
		}
	}
}