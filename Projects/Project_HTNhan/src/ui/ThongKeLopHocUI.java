package ui;

import java.awt.BorderLayout;
import java.awt.Color;

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

public class ThongKeLopHocUI extends JPanel {
	public ThongKeLopHocUI() {
		addControls();
	}

	public void addControls() {
		JPanel pnl = new JPanel();
		pnl.setLayout(new BoxLayout(pnl, BoxLayout.Y_AXIS));
		JPanel pnlThongKeLopCbo = new JPanel();
		JPanel pnlThongKeLopTable = new JPanel();

		pnlThongKeLopCbo.setLayout(new BoxLayout(pnlThongKeLopCbo, BoxLayout.X_AXIS));
		JPanel cbo = new JPanel();
		JLabel lblChonNam = new JLabel("Chọn Năm");
		JComboBox cboChonNam = new JComboBox();
		cboChonNam.addItem("itemmmmm");
		cbo.add(lblChonNam);
		cbo.add(cboChonNam);
		pnlThongKeLopCbo.add(cbo);

		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Thống Kê Lóp Học");
		pnlThongKeLopTable.setBorder(borderTitle);

		DefaultTableModel dm = new DefaultTableModel();
		dm.addColumn("Mã Lớp");
		dm.addColumn("Tên Lớp");
		dm.addColumn("Tổng Sô Sinh Viên");

		JTable tbl = new JTable(dm);
		dm.addRow(new String[] { "112", "Ngô văn Bắp", "21" });
		dm.addRow(new String[] { "113", "Nguyễn Thị Tý", "18" });
		dm.addRow(new String[] { "114", "Trần Văn Tèo", "22" });
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
}
