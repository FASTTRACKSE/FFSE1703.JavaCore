package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

import model.QuanLiDiemHocModel;
import model.QuanLiDiemHocSQL;
import model.QuanLiLopHocModel;
import model.QuanLiLopHocSQL;
import model.QuanLiMonHocCuaLopModel;
import model.QuanLiSinhVienModel;
import model.QuanLiSinhVienSQL;

public class QuanLiDiemHocUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String maLop, maSv, diemMH, maMH;
	private JTable tbl;
	@SuppressWarnings("rawtypes")
	public JComboBox cbochonLop, cbochonMon;
	private JButton btnNhap, btnSua;
	private JTextField txttenSv, txtdiemSv, txtmaSv;
	private DefaultTableModel dm;
	private QuanLiSinhVienSQL quanLiSinhVienSQL = new QuanLiSinhVienSQL();
	private QuanLiLopHocSQL quanLiLopHocSQL = new QuanLiLopHocSQL();
	private QuanLiDiemHocSQL quanLiDiemHocSQL = new QuanLiDiemHocSQL();

	private ArrayList<QuanLiDiemHocModel> arrDiemHoc = new ArrayList<>();
	private ArrayList<QuanLiLopHocModel> arrMaLop = new ArrayList<>();
	private ArrayList<QuanLiMonHocCuaLopModel> arrMonvaLop = new ArrayList<>();
	private ArrayList<QuanLiSinhVienModel> arrQlSinhVien = new ArrayList<>();

	public QuanLiDiemHocUI() {
		addControls();
		addEvents();
		table();
		cboLop();

	}

	@SuppressWarnings("rawtypes")
	public void addControls() {
		JPanel pnl = new JPanel();
		pnl.setLayout(new BoxLayout(pnl, BoxLayout.X_AXIS));

		JPanel pnlDiemHocInput1 = new JPanel();
		JPanel pnlDiemHocInput2 = new JPanel();
		JPanel pnlDiemHocTable = new JPanel();

		// input
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Nhập Điểm Môn Học");
		pnlDiemHocInput1.setBorder(borderTitle);
		//
		pnlDiemHocInput1.setLayout(new BoxLayout(pnlDiemHocInput1, BoxLayout.Y_AXIS));
		JPanel chonLop = new JPanel();
		JLabel lblchonLop = new JLabel("Chọn Lớp ");
		cbochonLop = new JComboBox();

		cbochonLop.setPreferredSize(new Dimension(170, 20));
		lblchonLop.setPreferredSize(new Dimension(90, 50));
		chonLop.add(lblchonLop);
		chonLop.add(cbochonLop);
		pnlDiemHocInput1.add(chonLop);

		JPanel maSv = new JPanel();
		JLabel lblmaSv = new JLabel("Mã Sinh Viên");
		txtmaSv = new JTextField(20);
		lblmaSv.setPreferredSize(new Dimension(90, 20));
		maSv.add(lblmaSv);
		maSv.add(txtmaSv);
		pnlDiemHocInput1.add(maSv);

		JPanel tenSv = new JPanel();
		JLabel lbltenSv = new JLabel("Tên Sinh Viên");
		txttenSv = new JTextField(20);
		lbltenSv.setPreferredSize(new Dimension(90, 20));
		tenSv.add(lbltenSv);
		tenSv.add(txttenSv);
		pnlDiemHocInput1.add(tenSv);
		//
		JPanel chonMon = new JPanel();
		JLabel lblchonMon = new JLabel("Chọn Môn ");
		cbochonMon = new JComboBox();

		cbochonMon.setPreferredSize(new Dimension(170, 20));
		lblchonMon.setPreferredSize(new Dimension(90, 50));
		chonMon.add(lblchonMon);
		chonMon.add(cbochonMon);
		pnlDiemHocInput1.add(chonMon);
		//
		JPanel diemSv = new JPanel();
		JLabel lbldiemSv = new JLabel("Nhập Điểm");
		txtdiemSv = new JTextField(20);
		lbldiemSv.setPreferredSize(new Dimension(90, 20));
		diemSv.add(lbldiemSv);
		diemSv.add(txtdiemSv);
		pnlDiemHocInput1.add(diemSv);
		//

		JPanel btn = new JPanel();
		btnNhap = new JButton("Nhập");
		btnNhap.setBackground(Color.GRAY);
		btnNhap.setPreferredSize(new Dimension(90, 30));
		btnSua = new JButton("Sửa");
		btnSua.setBackground(Color.GRAY);
		btnSua.setPreferredSize(new Dimension(90, 30));

		btn.add(btnNhap);
		btn.add(btnSua);

		pnlDiemHocInput1.add(btn);

		// TABLE 1
		Border border1 = BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder borderTitle1 = BorderFactory.createTitledBorder(border1, "Chọn Sinh Viên Để Nhập");
		pnlDiemHocTable.setBorder(borderTitle1);

		dm = new DefaultTableModel();
		dm.addColumn("Mã Sinh Viên");
		dm.addColumn("Tên Sinh Viên");
		dm.addColumn("Lớp");

		tbl = new JTable(dm);

		// setColum
		TableColumnModel columnModel = tbl.getColumnModel();
		columnModel.getColumn(1).setPreferredWidth(110);
		tbl.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		//
		JScrollPane sc = new JScrollPane(tbl);
		pnlDiemHocTable.setLayout(new BorderLayout());
		pnlDiemHocTable.add(sc);
		tbl.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					//
					//
					txtmaSv.setEditable(false);
					txttenSv.setEditable(false);
					int row = tbl.getSelectedRow();
					String value = tbl.getValueAt(row, 0).toString();
					for (QuanLiSinhVienModel x : arrQlSinhVien) {
						if (value.equals(x.getMaSv())) {
							cbochonLop.setSelectedItem(x.getMaLop());
							txtmaSv.setText(x.getMaSv());
							txttenSv.setText(x.getHoTenSv());
							txtdiemSv.setText("");
						}
					}
				} catch (Exception ex) {

				}
			}
		});

		pnl.add(pnlDiemHocInput1);
		pnl.add(pnlDiemHocTable);
		pnl.add(pnlDiemHocInput2);
		this.setLayout(new BorderLayout());
		this.add(pnl);
	}

	public void addEvents() {
		cbochonLop.addActionListener(eventCboMaLop);
		btnNhap.addActionListener(eventThem);
		btnSua.addActionListener(eventSua);
		cbochonMon.addActionListener(eventcboMon);
	}

	ActionListener eventCboMaLop = new ActionListener() {

		@SuppressWarnings("unchecked")
		@Override
		public void actionPerformed(ActionEvent e) {

			dm.setRowCount(0);
			table();
			cbochonMon.removeAllItems();
			maLop = cbochonLop.getSelectedItem().toString();
			arrMonvaLop = quanLiLopHocSQL.selectMonHocCuaLop(maLop);
			cbochonMon.addItem("Chọn Môn");
			for (QuanLiMonHocCuaLopModel x : arrMonvaLop) {
				cbochonMon.addItem(x.getMaMh());
			}
		}
	};
	ActionListener eventcboMon = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (cbochonMon.getSelectedIndex() != -1) {
				arrDiemHoc = quanLiDiemHocSQL.selectDiem();
				String cboMH = cbochonMon.getSelectedItem().toString();
				String maSv = txtmaSv.getText();
				for (QuanLiDiemHocModel x : arrDiemHoc) {
					if (cboMH.equals(x.getMaMH()) && maSv.equals(x.getMaSv())) {
						txtdiemSv.setText(x.getDiemMH());
						break;
					} else {
						txtdiemSv.setText("");
					}
				}
			}
		}
	};
	ActionListener eventThem = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (cbochonLop.getSelectedItem().toString().equals("Chọn Lớp")) {
				JOptionPane.showMessageDialog(null, "Bạn Phải Chọn Lớp !!!");
			} else if (txtmaSv.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Bạn Phải Nhập Mã Sinh Viên !!!");
			} else if (txttenSv.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Bạn Phải Nhập Tên Sinh Viên!!!");
			} else if (cbochonMon.getSelectedItem().toString().equals("Chọn Môn")) {
				JOptionPane.showMessageDialog(null, "Bạn Phải Chọn Môn !!!");
			} else if (txtdiemSv.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Bạn Phải Nhập Điểm!!!");
			} else {
				int ktDiem = 0;
				maSv = txtmaSv.getText();
				maMH = cbochonMon.getSelectedItem().toString();
				diemMH = txtdiemSv.getText();
				arrDiemHoc = quanLiDiemHocSQL.selectDiem();
				for (QuanLiDiemHocModel x : arrDiemHoc) {
					if (maSv.equals(x.getMaSv()) && maMH.equals(x.getMaMH())) {
						ktDiem = 1;
					}
				}
				if (ktDiem > 0) {
					JOptionPane.showMessageDialog(null, "Điểm Môn Này đã Nhập rồi !!");
				} else {
					quanLiDiemHocSQL.insert(maSv, maMH, diemMH);
					txtdiemSv.setText("");
				}
			}
		}
	};
	ActionListener eventSua = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (txtmaSv.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Vui Lòng Chọn Sinh Viên Cần Sửa !!!");
			} else {

				maSv = txtmaSv.getText();
				maMH = cbochonMon.getSelectedItem().toString();
				diemMH = txtdiemSv.getText();
				quanLiDiemHocSQL.update(maSv, maMH, diemMH);
			}
		}
	};

	public void table() {
		arrQlSinhVien = quanLiSinhVienSQL.selectAll();
		Object maLop = cbochonLop.getSelectedItem();
		if (maLop != null && !maLop.toString().equals("Chọn Lớp")) {
			String comBox = cbochonLop.getSelectedItem().toString();
			if (comBox == "Chọn Lớp") {
				txttenSv.setText("");
				txtmaSv.setText("");
				for (QuanLiSinhVienModel x : arrQlSinhVien) {
					String row[] = { x.getMaSv(), x.getHoTenSv(), x.getMaLop() };
					dm.addRow(row);
				}
			} else {
				for (QuanLiSinhVienModel x : arrQlSinhVien) {
					if (comBox.equals(x.getMaLop())) {
						String row[] = { x.getMaSv(), x.getHoTenSv(), x.getMaLop() };
						dm.addRow(row);
					}
				}

			}
		}

	}

	@SuppressWarnings("unchecked")
	public void cboLop() {
		cbochonLop.removeAllItems();
		cbochonLop.addItem("Chọn Lớp");
		arrMaLop = quanLiLopHocSQL.selectLop();
		for (QuanLiLopHocModel x : arrMaLop) {
			cbochonLop.addItem(x.getMaLop());
		}
	}

}
