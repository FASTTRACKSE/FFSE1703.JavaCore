package ffse1703020.qltv.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import ffse1703020.qltv.model.ConnectDB;
import ffse1703020.qltv.model.MyException;
import ffse1703020.qltv.model.Phuong;
import ffse1703020.qltv.model.Quan;
import ffse1703020.qltv.model.ThanhPho;

public class BanDocUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ConnectDB cn = new ConnectDB();
	Connection conn = (Connection) ConnectDB.getConnect(); // <--Kết nối database-->
	private JButton jbThem, jbSua, jbXoa, jbThoat, jbTKBDoc;
	private JTextField txtTKBDoc, txtMTV, txtDC, txtHTen, txtSDT, txtEmail;
	private JComboBox<Object> comboBoxTinh, comboBoxQuan, comboBoxPhuong;
	JScrollPane spListBDoc = new JScrollPane();
	JTable tbListBDoc = new JTable();
	private String tbBDoc[] = { "Mã TV", "Tên", "Email", "Điện thoại", "Địa chỉ nhà", "Thành phố", "Quận", "Phường",
			"Số sách mượn" };
	DefaultTableModel mdTableBDoc = new DefaultTableModel(tbBDoc, 0);

	// <--Sửa Thông tin bạn đọc-->
	ActionListener evUpdate = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			try {
				update();// <---
			} catch (MyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	};
	// <--Thêm bạn đọc-->
	ActionListener evInsert = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			// TODO Auto-generated method stub
			if (comboBoxTinh.getSelectedItem() == null) {
				JOptionPane.showMessageDialog(null, "Bạn chưa chọn thành phố");
			} else if (comboBoxQuan.getSelectedItem() == null) {
				JOptionPane.showMessageDialog(null, "Bạn chưa chọn quận");
			} else if (comboBoxPhuong.getSelectedItem() == null) {
				JOptionPane.showMessageDialog(null, "Bạn chưa chọn phường");
			} else {
				try {
					insert();
				} catch (MyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	};
	// <--Xóa Thông tin bạn đọc-->
	ActionListener evDelete = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			delete();

		}

	};
	// <--tìm kiếm bạn đọc-->
	ActionListener evTimKiem = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

			TimKiem();
		}

	};
	// <--in thông tin bạn đọc vào bảng-->
	MouseAdapter eventselect = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			txtMTV.setEditable(false);
			int i = tbListBDoc.getSelectedRow();
			String[] row = new String[8];
			for (int j = 0; j < row.length; j++) {
				row[j] = (String) tbListBDoc.getValueAt(i, j);
			}
			txtMTV.setText(row[0]);
			txtHTen.setText(row[1]);
			txtSDT.setText(row[2]);
			txtEmail.setText(row[3]);
			txtDC.setText(row[4]);
			comboBoxTinh.setSelectedItem(row[5]);
			comboBoxQuan.setSelectedItem(row[6]);
			comboBoxPhuong.setSelectedItem(row[7]);

		}
	};

	public BanDocUI() {
		controls();
		Display();
		addEvents();

	}

	public void controls() {

		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		JPanel pnTimKiemBDoc = new JPanel();

		txtTKBDoc = new JTextField();
		txtTKBDoc.setColumns(20);
		Font fTk = new Font("arial", Font.PLAIN, 15);
		txtTKBDoc.setFont(fTk);
		jbTKBDoc = new JButton("Tìm kiếm");
		jbTKBDoc.setPreferredSize(new Dimension(90, 20));
		pnTimKiemBDoc.add(txtTKBDoc);
		pnTimKiemBDoc.add(jbTKBDoc);

		JPanel pnThongTin = new JPanel();
		pnThongTin.setLayout(new BoxLayout(pnThongTin, BoxLayout.Y_AXIS));
		Border borderthongtin = BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder borderTittle = BorderFactory.createTitledBorder(borderthongtin, "Thông Tin Bạn Đọc");
		pnThongTin.setBorder(borderTittle);

		JPanel pnBDoc = new JPanel();

		JLabel lbMTV = new JLabel("Mã thành viên");
		lbMTV.setPreferredSize(new Dimension(90, 20));
		txtMTV = new JTextField();
		Font fMTV = new Font("arial", Font.PLAIN, 12);
		lbMTV.setFont(fMTV);
		txtMTV.setColumns(15);

		JLabel lbDC = new JLabel("Địa chỉ nhà");
		lbDC.setPreferredSize(new Dimension(90, 20));
		txtDC = new JTextField();
		txtDC.setPreferredSize(new Dimension(170, 20));
		Font fDC = new Font("arial", Font.PLAIN, 12);
		lbDC.setFont(fDC);
		//
		pnBDoc.add(lbMTV);
		pnBDoc.add(txtMTV);
		pnBDoc.add(lbDC);
		pnBDoc.add(txtDC);

		JPanel pnBDoc1 = new JPanel();

		JLabel lbHTen = new JLabel("Họ tên");
		lbHTen.setPreferredSize(new Dimension(90, 20));
		txtHTen = new JTextField();
		Font fHTen = new Font("arial", Font.PLAIN, 12);
		lbHTen.setFont(fHTen);
		txtHTen.setColumns(15);

		JLabel lbTinh = new JLabel("Tỉnh");
		lbTinh.setPreferredSize(new Dimension(90, 20));
		lbTinh.setFont(new Font("Arial", Font.PLAIN, 12));

		ArrayList<String> arr = ThanhPho.getList();
		comboBoxTinh = new JComboBox<Object>(arr.toArray());
		comboBoxTinh.setPreferredSize(new Dimension(170, 20));
		comboBoxTinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String tinh = comboBoxTinh.getSelectedItem().toString();
				ArrayList<String> arr = Quan.getList(tinh);
				comboBoxQuan.setModel(new DefaultComboBoxModel<>(arr.toArray()));
			}
		});

		comboBoxTinh.setFont(new Font("Arial", Font.PLAIN, 12));
		comboBoxTinh.setToolTipText("");
		pnBDoc1.add(lbHTen);
		pnBDoc1.add(txtHTen);
		pnBDoc1.add(lbTinh);
		pnBDoc1.add(comboBoxTinh);

		JPanel pnBDoc2 = new JPanel();

		JLabel lbSDT = new JLabel("Số điện thoại");
		lbSDT.setPreferredSize(new Dimension(90, 20));
		txtSDT = new JTextField();
		Font fSDT = new Font("arial", Font.PLAIN, 12);
		lbSDT.setFont(fSDT);
		txtSDT.setColumns(15);

		JLabel lbQuan = new JLabel("Quận");
		lbQuan.setPreferredSize(new Dimension(90, 20));
		lbQuan.setFont(new Font("Arial", Font.PLAIN, 12));
		comboBoxQuan = new JComboBox<Object>();
		comboBoxQuan.setPreferredSize(new Dimension(170, 20));
		comboBoxQuan.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String quan = comboBoxQuan.getSelectedItem().toString();
				ArrayList<String> arr = Phuong.getList(quan);
				comboBoxPhuong.setModel(new DefaultComboBoxModel<>(arr.toArray()));
			}
		});
		comboBoxQuan.setFont(new Font("Arial", Font.PLAIN, 12));
		comboBoxQuan.setToolTipText("");

		pnBDoc2.add(lbSDT);
		pnBDoc2.add(txtSDT);
		pnBDoc2.add(lbQuan);
		pnBDoc2.add(comboBoxQuan);

		JPanel pnBDoc3 = new JPanel();

		JLabel lbEmail = new JLabel("Email");
		lbEmail.setPreferredSize(new Dimension(90, 20));
		txtEmail = new JTextField();
		Font fEmail = new Font("arial", Font.PLAIN, 12);
		lbEmail.setFont(fEmail);
		txtEmail.setColumns(15);

		JLabel lbPhuong = new JLabel("Phường");
		lbPhuong.setPreferredSize(new Dimension(90, 20));
		lbPhuong.setFont(new Font("Arial", Font.PLAIN, 12));
		comboBoxPhuong = new JComboBox<Object>();
		comboBoxPhuong.setPreferredSize(new Dimension(170, 20));
		comboBoxPhuong.setFont(new Font("Arial", Font.PLAIN, 12));
		comboBoxPhuong.setToolTipText("");

		pnBDoc3.add(lbEmail);
		pnBDoc3.add(txtEmail);
		pnBDoc3.add(lbPhuong);
		pnBDoc3.add(comboBoxPhuong);

		JPanel pnSuKien = new JPanel();

		JPanel pnThem = new JPanel();
		jbThem = new JButton("Thêm");
		jbThem.setPreferredSize(new Dimension(140, 45));
		ImageIcon insert = new ImageIcon(
				new ImageIcon("icons/insert.png").getImage().getScaledInstance(40, 45, Image.SCALE_SMOOTH));
		JLabel lblIconInsert = new JLabel(insert);
		jbThem.add(lblIconInsert);
		pnThem.add(jbThem);

		JPanel pnSua = new JPanel();
		jbSua = new JButton("Sửa");
		jbSua.setPreferredSize(new Dimension(140, 45));
		ImageIcon edit = new ImageIcon(
				new ImageIcon("icons/t.png").getImage().getScaledInstance(40, 45, Image.SCALE_SMOOTH));
		JLabel lblIconEdit = new JLabel(edit);
		jbSua.add(lblIconEdit);
		pnSua.add(jbSua);

		JPanel pnXoa = new JPanel();
		jbXoa = new JButton("Xóa");
		jbXoa.setPreferredSize(new Dimension(140, 45));
		ImageIcon delete = new ImageIcon(
				new ImageIcon("icons/delete.png").getImage().getScaledInstance(40, 45, Image.SCALE_SMOOTH));
		JLabel lblIconDelete = new JLabel(delete);
		jbXoa.add(lblIconDelete);
		pnXoa.add(jbXoa);

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
				txtMTV.setEditable(true);
				txtMTV.setText("");
				txtHTen.setText("");
				txtSDT.setText("");
				txtEmail.setText("");
				txtDC.setText("");
				comboBoxTinh.setSelectedItem("");
				comboBoxQuan.setSelectedItem("");
				comboBoxPhuong.setSelectedItem("");
				txtTKBDoc.setText("");
				mdTableBDoc.setRowCount(0);
				Display();

			}
		});
		pnThoat.add(jbThoat);

		pnSuKien.add(pnThem);
		pnSuKien.add(pnSua);
		pnSuKien.add(pnXoa);
		pnSuKien.add(pnThoat);

		JPanel pnTableKH = new JPanel();

		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTittle1 = BorderFactory.createTitledBorder(border, "Danh Sách");
		spListBDoc.setBorder(borderTittle1);
		tbListBDoc.setModel(mdTableBDoc);
		tbListBDoc.setPreferredScrollableViewportSize(new Dimension(700, 200));
		tbListBDoc.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		spListBDoc.setViewportView(tbListBDoc);
		pnTableKH.add(spListBDoc);

		DefaultTableCellRenderer righttable = new DefaultTableCellRenderer();
		righttable.setHorizontalAlignment(JLabel.RIGHT);
		tbListBDoc.getColumnModel().getColumn(8).setCellRenderer(righttable);

		pnMain.add(pnTimKiemBDoc);
		pnThongTin.add(pnBDoc);
		pnThongTin.add(pnBDoc1);
		pnThongTin.add(pnBDoc2);
		pnThongTin.add(pnBDoc3);
		pnThongTin.add(pnSuKien);
		pnMain.add(pnThongTin);
		pnMain.add(pnTableKH);

		this.add(pnMain);
	}

	// <--Phương Thức tìm kiếm bạn đọc-->
	public void TimKiem() {
		if (conn != null) {
			// System.out.print(txtTKS.getText());
			String sql = "SELECT * FROM ban_doc WHERE ma_ban_doc LIKE '%" + txtTKBDoc.getText() + "%' or ho_ten LIKE '%"
					+ txtTKBDoc.getText() + "%'";

			try {
				PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
				// khởi tạo resultset

				ResultSet rs = ptmt.executeQuery();
				mdTableBDoc.setRowCount(0);
				// mdTableSach.getDataVector().removeAllElements();
				while (rs.next()) {

					String rows[] = new String[9];

					rows[0] = rs.getString(2);
					rows[1] = rs.getString(3);
					rows[2] = rs.getString(4);
					rows[3] = rs.getString(5);
					rows[4] = rs.getString(6);
					rows[5] = rs.getString(7);
					rows[6] = rs.getString(8);
					rows[7] = rs.getString(9);
					rows[8] = rs.getString(10);

					mdTableBDoc.addRow(rows);
				}
			} catch (SQLException e) {
				System.out.println("loi  " + e.getMessage());

			}
		} else {
			System.out.println("Kết nối MYSQL thất bại");

		}
	}

	// <--Phương thức thêm bạn đọc-->
	public void insert() throws MyException {
		try {

			if (MyException.ChekMBDoc(txtMTV.getText()) && MyException.ChekEmpty(txtMTV.getText())
					&& MyException.ChekEmpty(txtHTen.getText()) && MyException.ChekSo(txtSDT.getText())
					&& MyException.ChekEmpty(txtEmail.getText()) && MyException.ChekEmpty(txtDC.getText())) {
				if (conn != null) {
					String sql = "INSERT INTO `ban_doc`( `ma_ban_doc`, `ho_ten`, `dien_thoai`, `email`, `dia_chi`, `thanh_pho`, `quan`, `phuong`, `so_sach_muon`, `pass`) VALUES (?,?,?,?,?,?,?,?,?,?)";
					try {

						PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
						// khởi tạo resultset
						ptmt.setString(1, txtMTV.getText());
						ptmt.setString(2, txtHTen.getText());
						ptmt.setString(3, txtSDT.getText());
						ptmt.setString(4, txtEmail.getText());
						ptmt.setString(5, txtDC.getText());
						ptmt.setString(6, comboBoxTinh.getSelectedItem().toString());
						ptmt.setString(7, comboBoxQuan.getSelectedItem().toString());
						ptmt.setString(8, comboBoxPhuong.getSelectedItem().toString());
						ptmt.setString(9, "0");
						ptmt.setString(10, "123123");
						int k = ptmt.executeUpdate();
						if (k != 0) {
							JOptionPane.showMessageDialog(null, "Thêm thành công");
							String[] row = { txtMTV.getText(), txtHTen.getText(), txtSDT.getText(), txtEmail.getText(),
									txtDC.getText(), comboBoxTinh.getSelectedItem().toString(),
									comboBoxQuan.getSelectedItem().toString(),
									comboBoxPhuong.getSelectedItem().toString() };
							mdTableBDoc.addRow(row);

							txtMTV.setText("");
							txtHTen.setText("");
							txtSDT.setText("");
							txtEmail.setText("");
							txtDC.setText("");
							comboBoxTinh.setSelectedItem("");
							comboBoxQuan.setSelectedItem("");
							comboBoxPhuong.setSelectedItem("");

						} else
							JOptionPane.showMessageDialog(null, "Thêm không thành công");
					} catch (SQLException e) {
						System.out.println("loi  " + e.getMessage());
					}
				} else {
					System.out.println("Kết nối MYSQL thất bại");
				}
			}
		} catch (MyException e) {
			System.out.println(e);
		}
	}

	// <------Phương thức sửa thông tin bạn đọc----->
	public void update() throws MyException {
		try {

			if (MyException.ChekEmpty(txtHTen.getText()) && MyException.ChekSo(txtSDT.getText())
					&& MyException.ChekEmail(txtEmail.getText()) && MyException.ChekEmpty(txtDC.getText())) {
				if (conn != null) {
					String sql = "UPDATE `ban_doc` SET `ho_ten`=?,`dien_thoai`=?,`email`=?,`dia_chi`=?,`thanh_pho`=? ,`quan`=?,`phuong`=? WHERE `ma_ban_doc` = ?";
					try {
						PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
						// khởi tạo resultset
						ptmt.setString(1, txtHTen.getText());
						ptmt.setString(2, txtSDT.getText());
						ptmt.setString(3, txtEmail.getText());
						ptmt.setString(4, txtDC.getText());
						ptmt.setString(5, (String) comboBoxTinh.getSelectedItem());
						ptmt.setString(6, comboBoxQuan.getSelectedItem().toString());
						ptmt.setString(7, comboBoxPhuong.getSelectedItem().toString());
						ptmt.setString(8, txtMTV.getText());

						int t = tbListBDoc.getSelectedRow();
						String[] row = { txtMTV.getText(), txtHTen.getText(), txtSDT.getText(), txtEmail.getText(),
								txtDC.getText(), comboBoxTinh.getSelectedItem().toString(),
								comboBoxQuan.getSelectedItem().toString(),
								comboBoxPhuong.getSelectedItem().toString() };
						for (int j = 0; j < 8; j++) {
							tbListBDoc.setValueAt(row[j], t, j);
						}
						int k = ptmt.executeUpdate();
						if (k != 0) {
							JOptionPane.showMessageDialog(null, "Sửa thành công");
							txtMTV.setText("");
							txtHTen.setText("");
							txtSDT.setText("");
							txtEmail.setText("");
							txtDC.setText("");
							comboBoxTinh.setSelectedItem("");
							comboBoxQuan.setSelectedItem("");
							comboBoxPhuong.setSelectedItem("");
						} else
							JOptionPane.showMessageDialog(null, "Sửa không thành công");
					} catch (SQLException e) {
						System.out.println("loi  " + e.getMessage());

					}
				} else {
					System.out.println("Kết nối MYSQL thất bại");
				}
			}
		} catch (MyException e) {
			System.out.println(e);
		}
	}

	// <--Phương thức xóa bạn đọc-->
	public void delete() {
		if (conn != null) {
			int myChose = JOptionPane.showConfirmDialog(null, "Bạn Có Muốn Xóa Dữ Liệu Này Không?", "Xóa",
					JOptionPane.YES_NO_OPTION);
			if (myChose == JOptionPane.YES_OPTION) {
				String sql = "DELETE FROM `ban_doc` WHERE ma_ban_doc=?";
				try {
					PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
					ptmt.setString(1, txtMTV.getText());
					int kt = ptmt.executeUpdate();
					if (kt != 0) {
						int j = tbListBDoc.getSelectedRow();
						JOptionPane.showMessageDialog(null, "Xóa thành công");
						mdTableBDoc.removeRow(j);
						txtMTV.setText("");
						txtHTen.setText("");
						txtSDT.setText("");
						txtEmail.setText("");
					} else
						JOptionPane.showMessageDialog(null, "Xóa không thành công");
				} catch (SQLException e) {
					System.out.println("loi  " + e.getMessage());
				}
			}
		} else {
			System.out.println("Kết nối MYSQL thất bại");
		}
	}

	PreparedStatement ptmt = null;

	public void Display() {
		if (conn != null) {

			String sql = "select * from ban_doc";
			try {
				PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
				// khởi tạo resultset
				ResultSet rs = ptmt.executeQuery();
				while (rs.next()) {
					String rows[] = new String[9];

					rows[0] = rs.getString(2);
					rows[1] = rs.getString(3);
					rows[2] = rs.getString(4);
					rows[3] = rs.getString(5);
					rows[4] = rs.getString(6);
					rows[5] = rs.getString(7);
					rows[6] = rs.getString(8);
					rows[7] = rs.getString(9);
					rows[8] = rs.getString(10);

					mdTableBDoc.addRow(rows);
				}
			} catch (SQLException e) {
				System.out.println("loi  " + e.getMessage());

			}
		} else {
			System.out.println("Kết nối MYSQL thất bại");
		}
	}

	public void addEvents() {
		tbListBDoc.addMouseListener(eventselect);
		jbSua.addActionListener(evUpdate);
		jbThem.addActionListener(evInsert);
		jbXoa.addActionListener(evDelete);
		jbTKBDoc.addActionListener(evTimKiem);

	}

}