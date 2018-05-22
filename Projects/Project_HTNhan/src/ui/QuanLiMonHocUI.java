package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


import model.QuanLiMonHocModel;
import model.QuanLiMonHocSQL;


public class QuanLiMonHocUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String maMH, tenMH, tinChiMH, thoiGianMH;
	private JTextField txtmaMh, txttenMh, txttinchiMh, txtthoigianMh;
	private JButton btnThem, btnSua, btnXoa, btnThemMoi;
	private DefaultTableModel dm;
	private JTable tbl;
	private ArrayList<QuanLiMonHocModel> arrMonHoc = new ArrayList<>();
	private QuanLiMonHocSQL quanLiMonHocSQL = new QuanLiMonHocSQL();

	public QuanLiMonHocUI() {
		addControls();
		addEvents();
		table();
	}

	public void addControls() {
		JPanel pnl = new JPanel();
		pnl.setLayout(new BoxLayout(pnl, BoxLayout.X_AXIS));
		//
		JPanel pnlMonHocInput = new JPanel();
		JPanel pnlMonHocTable = new JPanel();
		// INPUT
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Nhập Thông Tin Môn Học");
		pnlMonHocInput.setBorder(borderTitle);
		//
		pnlMonHocInput.setLayout(new BoxLayout(pnlMonHocInput, BoxLayout.Y_AXIS));
		JPanel maMh = new JPanel();
		JLabel lblmaMh = new JLabel("Mã Môn Học");
		lblmaMh.setPreferredSize(new Dimension(120, 30));
		txtmaMh = new JTextField(15);
		maMh.add(lblmaMh);
		maMh.add(txtmaMh);
		pnlMonHocInput.add(maMh);
		//
		JPanel tenMh = new JPanel();
		JLabel lbltenMh = new JLabel("Tên Môn Học");
		lbltenMh.setPreferredSize(new Dimension(120, 30));
		txttenMh = new JTextField(15);
		tenMh.add(lbltenMh);
		tenMh.add(txttenMh);
		pnlMonHocInput.add(tenMh);

		JPanel tinchiMh = new JPanel();
		JLabel lbltinchiMh = new JLabel("Tín Chỉ Học");
		lbltinchiMh.setPreferredSize(new Dimension(120, 30));
		txttinchiMh = new JTextField(15);
		tinchiMh.add(lbltinchiMh);
		tinchiMh.add(txttinchiMh);
		pnlMonHocInput.add(tinchiMh);
		//
		JPanel thoigianMh = new JPanel();
		JLabel lblthoigianMh = new JLabel("Thời Gian Môn Học");
		lblthoigianMh.setPreferredSize(new Dimension(120, 30));
		txtthoigianMh = new JTextField(15);
		thoigianMh.add(lblthoigianMh);
		thoigianMh.add(txtthoigianMh);
		pnlMonHocInput.add(thoigianMh);
		// button
		JPanel btn = new JPanel();
		btnThem = new JButton("Thêm");
		btnThem.setPreferredSize(new Dimension(70, 30));
		btn.add(btnThem);
		btnSua = new JButton("Sửa");
		btnSua.setPreferredSize(new Dimension(70, 30));
		btn.add(btnSua);
		btnXoa = new JButton("Xóa");
		btnXoa.setPreferredSize(new Dimension(70, 30));
		btn.add(btnXoa);
		btnThemMoi = new JButton("Thêm Mới");
		btnThemMoi.setPreferredSize(new Dimension(95, 30));
		btn.add(btnThemMoi);
		pnlMonHocInput.add(btn);
		// TABLE

		Border border1 = BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder borderTitle1 = BorderFactory.createTitledBorder(border1, "Danh Sách Môn Học");
		pnlMonHocTable.setBorder(borderTitle1);

		pnlMonHocTable.setLayout(new BoxLayout(pnlMonHocTable, BoxLayout.Y_AXIS));
		dm = new DefaultTableModel();
		dm.addColumn("Mã Môn Học");
		dm.addColumn("Tên Môn Học");
		dm.addColumn("Số Tín Chỉ");
		dm.addColumn("Thời Gian");

		tbl = new JTable(dm);

		// setColum
		TableColumnModel columnModel = tbl.getColumnModel();
		columnModel.getColumn(1).setPreferredWidth(110);
		tbl.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		//
		JScrollPane sc = new JScrollPane(tbl);
		pnlMonHocTable.setLayout(new BorderLayout());
		pnlMonHocTable.add(sc);

		pnl.add(pnlMonHocInput);
		pnl.add(pnlMonHocTable);

		this.setLayout(new BorderLayout());
		this.add(pnl);

		tbl.addMouseListener(new MouseListener() {

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					//
					//
					txtmaMh.setEditable(false);
					int row = tbl.getSelectedRow();
					String value = tbl.getValueAt(row, 0).toString();
					for (QuanLiMonHocModel x : arrMonHoc) {
						if (value.equals(x.getMaMH())) {
							txtmaMh.setText(x.getMaMH());
							txttenMh.setText(x.getTenMH());
							txtthoigianMh.setText(x.getThoiGianMH());
							txttinchiMh.setText(x.getTinChiMH());
						}
					}
				} catch (Exception ex) {

				}
			}
		});
	}

	public void addEvents() {
		btnThem.addActionListener(eventThem);
		btnThemMoi.addActionListener(eventThemMoi);

		btnSua.addActionListener(eventSua);
		btnXoa.addActionListener(eventXoa);
	}

	ActionListener eventThem = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				String maMH = txtmaMh.getText();
				String tenMH = txttenMh.getText();
				String thoigianMH = txtthoigianMh.getText();
				String tinchiMH = txttinchiMh.getText();
				@SuppressWarnings("unused")
				int thoigian = Integer.parseInt(thoigianMH);
				@SuppressWarnings("unused")
				int tinchi = Integer.parseInt(tinchiMH);
				if (maMH.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Bạn Phải Nhập Mã Môn Học !!!");
				} else if (tenMH.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Bạn Phải Nhập Tên Môn Học !!!");
				} else if (thoigianMH.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Bạn Phải Nhập Thời Gian Môn Học!!!");
				} else if (tinchiMH.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Bạn Phải Nhập Số Tín Chỉ Môn Học!!!");
				} else {
					int ktMaMH = 0;
					maMH = txtmaMh.getText();
					tenMH = txttenMh.getText();
					tinChiMH = txttinchiMh.getText();
					thoiGianMH = txtthoigianMh.getText();

					for (QuanLiMonHocModel x : arrMonHoc) {
						if (maMH.equals(x.getMaMH())) {
							ktMaMH = 1;
						}
					}
					if (ktMaMH > 0) {
						JOptionPane.showMessageDialog(null, "Môn Đã Tồn Tại !!");
					} else {
						quanLiMonHocSQL.insert(maMH, tenMH, tinChiMH, thoiGianMH);
						dm.setRowCount(0);
						for (QuanLiMonHocModel x : arrMonHoc) {
							String row[] = { x.getMaMH(), x.getTenMH(), x.getThoiGianMH(), x.getTinChiMH() };
							dm.addRow(row);
						}
					}
					txtmaMh.setText("");
					txttenMh.setText("");
					txtthoigianMh.setText("");
					txttinchiMh.setText("");
				}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Tín Chỉ Và Thời Gian Bạn phải nhập số");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	};
	ActionListener eventThemMoi = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			txtmaMh.setEditable(true);
			txtmaMh.setText("");
			txttenMh.setText("");
			txtthoigianMh.setText("");
			txttinchiMh.setText("");

		}
	};
	ActionListener eventSua = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (txtmaMh.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn Môn Học cần sửa!");
			} else {
				maMH = txtmaMh.getText();
				tenMH = txttenMh.getText();
				tinChiMH = txttinchiMh.getText();
				thoiGianMH = txtthoigianMh.getText();
				//
				quanLiMonHocSQL.update(maMH, tenMH, tinChiMH, thoiGianMH);
				//
				dm.setRowCount(0);
				table();
				//
				txtmaMh.setEditable(true);
				txtmaMh.setText("");
				txttenMh.setText("");
				txtthoigianMh.setText("");
				txttinchiMh.setText("");
			}
		}
	};
	ActionListener eventXoa = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (txtmaMh.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn Môn Học cần Xóa!");
			} else {
				int ret = JOptionPane.showConfirmDialog(null, "Bạn có muốn Xóa?", "Xóa Sinh Viên",
						JOptionPane.YES_NO_OPTION);
				if (ret == JOptionPane.YES_OPTION) {
					maMH = txtmaMh.getText();
					quanLiMonHocSQL.delete(maMH);
					dm.setRowCount(0);
					table();
					//
					txtmaMh.setEditable(true);
					txtmaMh.setText("");
					txttenMh.setText("");
					txtthoigianMh.setText("");
					txttinchiMh.setText("");
				}
			}

		}
	};

	public void table() {
		arrMonHoc = quanLiMonHocSQL.selectMonHoc();
		for (QuanLiMonHocModel x : arrMonHoc) {
			String row[] = { x.getMaMH(), x.getTenMH(), x.getThoiGianMH(), x.getTinChiMH() };
			dm.addRow(row);
		}
	}
}
