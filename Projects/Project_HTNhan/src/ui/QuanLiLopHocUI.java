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
import javax.swing.JComboBox;
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

import model.QuanLiLopHocModel;
import model.QuanLiLopHocSQL;
import model.QuanLiMonHocCuaLopModel;
import model.QuanLiMonHocModel;
import model.QuanLiMonHocSQL;

public class QuanLiLopHocUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("rawtypes")
	public JComboBox cboChonMon;
	private JButton btnThemMoi,btnThem, btnSua, btnXoa, btnThemMon, btnXoaMon;
	private String maLop, tenLop, namHoc, monHoc;
	private JTextField txtmaLop, txttenLop, txtnamHoc;
	private DefaultTableModel dm, dm1;
	private JTable tblLopHoc, tblMonCuaLop;
	private ArrayList<QuanLiLopHocModel> arrLopHoc = new ArrayList<>();
	private ArrayList<QuanLiMonHocModel> arrMonHoc = new ArrayList<>();
	private ArrayList<QuanLiMonHocCuaLopModel> arrMonHocCuaLop = new ArrayList<>();
	private QuanLiLopHocSQL quanLiLopHocSQL = new QuanLiLopHocSQL();
	private QuanLiMonHocSQL quanLiMonHocSQL = new QuanLiMonHocSQL();

	public QuanLiLopHocUI() {
		addControls();
		addEvents();
		tableLop();
		cboMon();

	}

	@SuppressWarnings("rawtypes")
	public void addControls() {
		JPanel pnl = new JPanel();
		pnl.setLayout(new BoxLayout(pnl, BoxLayout.X_AXIS));
		//
		JPanel pnlLopHocInput = new JPanel();
		JPanel pnlLopHocTable = new JPanel();
		JPanel pnlLopHocTable1 = new JPanel();
		// INPUT
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Nhập Thông Tin Lớp Học");
		pnlLopHocInput.setBorder(borderTitle);

		pnlLopHocInput.setLayout(new BoxLayout(pnlLopHocInput, BoxLayout.Y_AXIS));
		JPanel maLop = new JPanel();
		JLabel lblmaLop = new JLabel("Mã Lớp Học");
		lblmaLop.setPreferredSize(new Dimension(80, 30));
		txtmaLop = new JTextField(15);
		maLop.add(lblmaLop);
		maLop.add(txtmaLop);
		pnlLopHocInput.add(maLop);
		//
		JPanel tenLop = new JPanel();
		JLabel lbltenLop = new JLabel("Tên Lớp Học");
		lbltenLop.setPreferredSize(new Dimension(80, 30));
		txttenLop = new JTextField(15);
		tenLop.add(lbltenLop);
		tenLop.add(txttenLop);
		pnlLopHocInput.add(tenLop);
		//
		JPanel namHoc = new JPanel();
		JLabel lblnamHoc = new JLabel("Năm Học");
		lblnamHoc.setPreferredSize(new Dimension(80, 30));
		txtnamHoc = new JTextField(15);
		namHoc.add(lblnamHoc);
		namHoc.add(txtnamHoc);
		pnlLopHocInput.add(namHoc);

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
		btnThemMoi.setPreferredSize(new Dimension(220, 30));
		btn.add(btnThemMoi);
		pnlLopHocInput.add(btn);

		// TABLE
		Border border1 = BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder borderTitle1 = BorderFactory.createTitledBorder(border1, "Danh Sách Lớp Học");
		pnlLopHocTable.setBorder(borderTitle1);

		dm = new DefaultTableModel();
		dm.addColumn("Mã Lớp");
		dm.addColumn("Tên Lớp");
		dm.addColumn("Năm Học");

		tblLopHoc = new JTable(dm);

		// setColum
		TableColumnModel columnModel = tblLopHoc.getColumnModel();
		columnModel.getColumn(1).setPreferredWidth(110);
		tblLopHoc.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		//
		JScrollPane sc = new JScrollPane(tblLopHoc);
		pnlLopHocTable.setLayout(new BorderLayout());
		pnlLopHocTable.add(sc);

		tblLopHoc.addMouseListener(new MouseListener() {

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
					txtmaLop.setEditable(false);
					int row = tblLopHoc.getSelectedRow();
					String value = tblLopHoc.getValueAt(row, 0).toString();
					for (QuanLiLopHocModel x : arrLopHoc) {
						if (value.equals(x.getMaLop())) {
							txtmaLop.setText(x.getMaLop());
							tableMonCuaLop(x.getMaLop());
							txttenLop.setText(x.getTenLop());
							txtnamHoc.setText(x.getNamHoc());
						}
					}

				} catch (Exception ex) {

				}
			}
		});

		// Chọn môn cho lớp
		Border border2 = BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder borderTitle2 = BorderFactory.createTitledBorder(border2, "Chọn Môn Cho Lớp");
		pnlLopHocTable1.setBorder(borderTitle2);
		pnlLopHocTable1.setLayout(new BoxLayout(pnlLopHocTable1, BoxLayout.Y_AXIS));

		JPanel chonMon = new JPanel();
		JLabel lblchonMon = new JLabel("Chọn Môn");
		cboChonMon = new JComboBox();

		btnThemMon = new JButton("Thêm Môn");
		btnXoaMon = new JButton("Xóa Môn");
		chonMon.add(lblchonMon);
		chonMon.add(cboChonMon);
		chonMon.add(btnThemMon);
		chonMon.add(btnXoaMon);
		pnlLopHocTable1.add(chonMon);
		//
		//
		dm1 = new DefaultTableModel();
		dm1.addColumn("Mã Môn");

		tblMonCuaLop = new JTable(dm1);
		tblMonCuaLop.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		JScrollPane sc1 = new JScrollPane(tblMonCuaLop);
		// pnlLopHocTable1.setLayout(new BorderLayout());
		pnlLopHocTable1.add(sc1);
		//

		pnl.add(pnlLopHocInput);
		pnl.add(pnlLopHocTable1);
		pnl.add(pnlLopHocTable);

		this.setLayout(new BorderLayout());
		this.add(pnl);
		//
	}

	public void addEvents() {
		btnThem.addActionListener(eventThem);
		btnSua.addActionListener(eventSua);
		btnXoa.addActionListener(eventXoa);
		btnThemMoi.addActionListener(eventThemMoi);
		btnThemMon.addActionListener(eventThemMon);
		btnXoaMon.addActionListener(eventXoaMon);
	}

	ActionListener eventThem = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (txtmaLop.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Bạn Phải Nhập Mã Lớp Học !!!");
			} else if (txttenLop.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Bạn Phải Nhập Tên Lớp Học !!!");
			} else if (txtnamHoc.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Bạn Phải Nhập Năm Học!!!");
			} else {
				int ktMaLop = 0;
				maLop = txtmaLop.getText();
				tenLop = txttenLop.getText();
				namHoc = txtnamHoc.getText();

				for (QuanLiLopHocModel x : arrLopHoc) {
					if (maLop.equals(x.getMaLop())) {
						ktMaLop = 1;
					}
				}
				if (ktMaLop > 0) {
					JOptionPane.showMessageDialog(null, "Lớp Đã Tồn Tại !!");
				} else {
					quanLiLopHocSQL.insert(maLop, tenLop, namHoc);
					dm.setRowCount(0);
					for (QuanLiLopHocModel x : arrLopHoc) {
						String row[] = { x.getMaLop(), x.getTenLop(), x.getNamHoc() };
						dm.addRow(row);
					}
				}
				txtmaLop.setText("");
				txttenLop.setText("");
				txtnamHoc.setText("");
			}
		}
	};
	ActionListener eventSua = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (txtmaLop.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn Môn Học cần sửa!");
			} else {
				maLop = txtmaLop.getText();
				tenLop = txttenLop.getText();
				namHoc = txtnamHoc.getText();
				//
				quanLiLopHocSQL.update(maLop, tenLop, namHoc);
				//
				dm.setRowCount(0);
				tableLop();
				//
				txtmaLop.setEditable(true);
				txtmaLop.setText("");
				txttenLop.setText("");
				txtnamHoc.setText("");
			}
		}
	};
	ActionListener eventXoa = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (txtmaLop.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn Lớp Học cần Xóa!");
			} else {
				int ret = JOptionPane.showConfirmDialog(null, "Bạn có muốn Xóa?", "Xóa Lớp Học",
						JOptionPane.YES_NO_OPTION);
				if (ret == JOptionPane.YES_OPTION) {
					maLop = txtmaLop.getText();
					quanLiLopHocSQL.delete(maLop);
					dm.setRowCount(0);
					tableLop();
					//
					txtmaLop.setEditable(true);
					txtmaLop.setText("");
					txttenLop.setText("");
					txtnamHoc.setText("");
					dm1.setRowCount(0);
				}
			}

		}
	};
	ActionListener eventThemMoi = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			txtmaLop.setEditable(true);
			txtmaLop.setText("");
			txttenLop.setText("");
			txtnamHoc.setText("");
		}
	};
	ActionListener eventThemMon = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			maLop = txtmaLop.getText();
			monHoc = cboChonMon.getSelectedItem().toString();
			if (maLop.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Chưa Chọn Lớp !!!");
			} else if (monHoc.equals("Chọn Môn")) {
				JOptionPane.showMessageDialog(null, "Chưa Chọn Môn !!!");
			} else {
				int ktMon = 0;
				for (QuanLiMonHocCuaLopModel x : arrMonHocCuaLop) {
					if (maLop.equals(x.getMalop()) && monHoc.equals(x.getMaMh())) {
						ktMon = 1;
					}
				}
				if (ktMon > 0) {
					JOptionPane.showMessageDialog(null, "Môn Học Đã Tồn Tại !!");
				} else {
					quanLiLopHocSQL.insertMonHocCuaLop(maLop, monHoc);
					tableMonCuaLop(maLop);
				}
			}
		}
	};
	ActionListener eventXoaMon = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			int row = tblMonCuaLop.getSelectedRow();
			if (row != -1) {
				String maMon = tblMonCuaLop.getValueAt(row, 0).toString();
				String maLop = txtmaLop.getText();
				quanLiLopHocSQL.deleteMonHocCuaLop(maLop, maMon);
				tableMonCuaLop(maLop);
			}else {
				JOptionPane.showMessageDialog(null, "Chưa Chọn Môn");
			}

		}
	};

	public void tableLop() {
		arrLopHoc = quanLiLopHocSQL.selectLop();
		for (QuanLiLopHocModel x : arrLopHoc) {
			String row[] = { x.getMaLop(), x.getTenLop(), x.getNamHoc() };
			dm.addRow(row);
		}
	}

	public void tableMonCuaLop(String maLop) {

		dm1.setRowCount(0);
		arrMonHocCuaLop = quanLiLopHocSQL.selectMonHocCuaLop(maLop);
		for (QuanLiMonHocCuaLopModel x : arrMonHocCuaLop) {
			String row[] = { x.getMaMh()};
			dm1.addRow(row);
		}
	}
	@SuppressWarnings("unchecked")
	public void cboMon() {
		cboChonMon.removeAllItems();
		cboChonMon.addItem("Chọn Môn");
		arrMonHoc = quanLiMonHocSQL.selectMonHoc();
		for (QuanLiMonHocModel x : arrMonHoc) {
			cboChonMon.addItem(x.getMaMH());
		}
	}
}
