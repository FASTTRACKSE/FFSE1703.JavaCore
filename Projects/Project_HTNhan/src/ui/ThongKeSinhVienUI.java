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

public class ThongKeSinhVienUI extends JPanel {
	public ThongKeSinhVienUI() {
		addControls();
	}
	public void addControls() {
		JPanel pnl = new JPanel();
		pnl.setLayout(new BoxLayout(pnl, BoxLayout.Y_AXIS));
		JPanel pnlThongKeSvCbo = new JPanel();
		JPanel pnlThongKeSvTable = new JPanel();
		
		pnlThongKeSvCbo.setLayout(new BoxLayout(pnlThongKeSvCbo, BoxLayout.X_AXIS));
		JPanel cbo = new JPanel();
		JLabel lblChonNam = new JLabel("Chọn Năm");
		JComboBox cboChonNam = new JComboBox();
		cboChonNam.addItem("itemmmmm");
		JLabel lblChonLop = new JLabel("Chọn Lớp");
		JComboBox cboChonLop = new JComboBox();
		cboChonLop.addItem("itemmmmm");
		cbo.add(lblChonNam);
		cbo.add(cboChonNam);
		cbo.add(lblChonLop);
		cbo.add(cboChonLop);
		pnlThongKeSvCbo.add(cbo);
		
		
		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border ,"Thống Kê Sinh Viên");
		pnlThongKeSvTable.setBorder(borderTitle);
		
		DefaultTableModel dm = new DefaultTableModel();
		dm.addColumn("Mã Sinh Viên");
		dm.addColumn("Tên Sinh Viên");
		dm.addColumn("Điểm TB");
		dm.addColumn("Xếp Loại");

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
		pnlThongKeSvTable.setLayout(new BorderLayout());
		pnlThongKeSvTable.add(sc);
		
		
		
		
		
		
		pnl.add(pnlThongKeSvCbo);
		pnl.add(pnlThongKeSvTable);
		this.setLayout(new BorderLayout());
		this.add(pnl);
	}
}
