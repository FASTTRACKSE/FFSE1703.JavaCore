package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import model.QuanLiLopHocModel;
import model.ThongKeLopHocSQL;

public class ThongKeLopHocUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("rawtypes")
	public JComboBox cboChonNam;
	private DefaultTableModel dm;
	private JTable tbl;
	private ThongKeLopHocSQL thongKeLopHocSQL = new ThongKeLopHocSQL();
	private ArrayList<String> arrNamHoc = new ArrayList<>();
	private ArrayList<QuanLiLopHocModel> arrThongKeSinhVien = new ArrayList<>();
	public ThongKeLopHocUI() {
		addControls();
		addEvents();
		cboNam();
	}

	@SuppressWarnings("rawtypes")
	public void addControls() {
		JPanel pnl = new JPanel();
		pnl.setLayout(new BoxLayout(pnl, BoxLayout.Y_AXIS));
		JPanel pnlThongKeLopCbo = new JPanel();
		JPanel pnlThongKeLopTable = new JPanel();

		pnlThongKeLopCbo.setLayout(new BoxLayout(pnlThongKeLopCbo, BoxLayout.X_AXIS));
		JPanel cbo = new JPanel();
		JLabel lblChonNam = new JLabel("Chọn Năm");
		cboChonNam = new JComboBox();

		cbo.add(lblChonNam);
		cbo.add(cboChonNam);
		pnlThongKeLopCbo.add(cbo);

		Border border = BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Thống Kê Lóp Học");
		pnlThongKeLopTable.setBorder(borderTitle);

		dm = new DefaultTableModel();
		dm.addColumn("Mã Lớp");
		dm.addColumn("Tên Lớp");
		dm.addColumn("Tổng Sô Sinh Viên");

		tbl = new JTable(dm);
		arrThongKeSinhVien = thongKeLopHocSQL.thongkeLop();
		for (QuanLiLopHocModel x : arrThongKeSinhVien) {
			String row[] = { x.getMaLop(), x.getTenLop(), thongKeLopHocSQL.countSvLop(x.getMaLop()) };
			dm.addRow(row);
		}
		// setColum
		TableColumnModel columnModel = tbl.getColumnModel();
		columnModel.getColumn(1).setPreferredWidth(110);
		tbl.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		//
		JScrollPane sc = new JScrollPane(tbl);
		pnlThongKeLopTable.setLayout(new BorderLayout());
		pnlThongKeLopTable.add(sc);

		pnl.add(pnlThongKeLopCbo);
		pnl.add(pnlThongKeLopTable);
		this.setLayout(new BorderLayout());
		this.add(pnl);
	}

	public void addEvents() {
		cboChonNam.addActionListener(eventChonNam);
	}

	ActionListener eventChonNam = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			arrThongKeSinhVien = thongKeLopHocSQL.thongkeLop();
			Object cboNam = cboChonNam.getSelectedItem();
			if (cboNam != null && !cboNam.toString().equals("Chọn Năm")) {
				String chonNam = cboChonNam.getSelectedItem().toString();
				dm.setRowCount(0);
				if (chonNam == ("Chọn Năm")) {
					for (QuanLiLopHocModel x : arrThongKeSinhVien) {
						String row[] = { x.getMaLop(), x.getTenLop(), thongKeLopHocSQL.countSvLop(x.getMaLop()) };
						dm.addRow(row);
					}
				} else {
					for (QuanLiLopHocModel x : arrThongKeSinhVien) {
						if (chonNam.equals(x.getNamHoc())) {
							String row[] = { x.getMaLop(), x.getTenLop(), thongKeLopHocSQL.countSvLop(x.getMaLop()) };
							dm.addRow(row);
						}
					}
				}
			}
		}
	};
	@SuppressWarnings("unchecked")
	public void cboNam() {
		cboChonNam.removeAllItems();
		cboChonNam.addItem("Chọn Năm");
		arrNamHoc = thongKeLopHocSQL.selectNam();
		for (String x : arrNamHoc) {
			cboChonNam.addItem(x);
		}
	}
}
