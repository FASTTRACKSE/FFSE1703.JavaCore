package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class QuanLiMonHocUI extends JPanel {
	public QuanLiMonHocUI() {
		addControls();

	}

	public void addControls() {
		JPanel pnl = new JPanel();
		pnl.setLayout(new BoxLayout(pnl, BoxLayout.X_AXIS));
		//
		JPanel pnlMonHocInput = new JPanel();
		JPanel pnlMonHocTable = new JPanel();
		// INPUT
		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Nhập Thông Tin Môn Học");
		pnlMonHocInput.setBorder(borderTitle);
		//
		pnlMonHocInput.setLayout(new BoxLayout(pnlMonHocInput, BoxLayout.Y_AXIS));
		JPanel maMh = new JPanel();
		JLabel lblmaMh = new JLabel("Mã Môn Học");
		lblmaMh.setPreferredSize(new Dimension(120, 30));
		JTextField txtmaMh = new JTextField(15);
		maMh.add(lblmaMh);
		maMh.add(txtmaMh);
		pnlMonHocInput.add(maMh);
		//
		JPanel tenMh = new JPanel();
		JLabel lbltenMh = new JLabel("Tên Môn Học");
		lbltenMh.setPreferredSize(new Dimension(120, 30));
		JTextField txttenMh = new JTextField(15);
		tenMh.add(lbltenMh);
		tenMh.add(txttenMh);
		pnlMonHocInput.add(tenMh);

		JPanel tinchiMh = new JPanel();
		JLabel lbltinchiMh = new JLabel("Tín Chỉ Học");
		lbltinchiMh.setPreferredSize(new Dimension(120, 30));
		JTextField txttinchiMh = new JTextField(15);
		tinchiMh.add(lbltinchiMh);
		tinchiMh.add(txttinchiMh);
		pnlMonHocInput.add(tinchiMh);
		//
		JPanel thoigianMh = new JPanel();
		JLabel lblthoigianMh = new JLabel("Thời Gian Môn Học");
		lblthoigianMh.setPreferredSize(new Dimension(120, 30));
		JTextField txtthoigianMh = new JTextField(15);
		thoigianMh.add(lblthoigianMh);
		thoigianMh.add(txtthoigianMh);
		pnlMonHocInput.add(thoigianMh);
		// button
		JPanel btn = new JPanel();
		JButton btnThem = new JButton("Thêm");
		btnThem.setPreferredSize(new Dimension(70, 30));
		btn.add(btnThem);
		JButton btnSua = new JButton("Sửa");
		btnSua.setPreferredSize(new Dimension(70, 30));
		btn.add(btnSua);
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setPreferredSize(new Dimension(70, 30));
		btn.add(btnXoa);
		JButton btnThoat = new JButton("Thoát");
		btnThoat.setPreferredSize(new Dimension(70, 30));
		btn.add(btnThoat);
		pnlMonHocInput.add(btn);
		// TABLE

		Border border1 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle1 = BorderFactory.createTitledBorder(border1, "Danh Sách Môn Học");
		pnlMonHocTable.setBorder(borderTitle1);
		
		pnlMonHocTable.setLayout(new BoxLayout(pnlMonHocTable, BoxLayout.Y_AXIS));
		DefaultTableModel dm = new DefaultTableModel();
		dm.addColumn("Mã Môn Học");
		dm.addColumn("Tên Môn Học");
		dm.addColumn("Số Tín Chỉ");
		dm.addColumn("Thời Gian");

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
		pnlMonHocTable.setLayout(new BorderLayout());
		pnlMonHocTable.add(sc);

		pnl.add(pnlMonHocInput);
		pnl.add(pnlMonHocTable);

		this.setLayout(new BorderLayout());
		this.add(pnl);
		;
	}
}
