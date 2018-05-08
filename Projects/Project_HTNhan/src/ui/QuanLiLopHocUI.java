package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
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
import javax.swing.table.TableColumnModel;

public class QuanLiLopHocUI extends JPanel {
	public QuanLiLopHocUI() {
		addControls();
	}

	public void addControls() {
		JPanel pnl = new JPanel();
		pnl.setLayout(new BoxLayout(pnl, BoxLayout.X_AXIS));
		//
		JPanel pnlLopHocInput = new JPanel();
		JPanel pnlLopHocTable = new JPanel();
		JPanel pnlLopHocTable1 = new JPanel();
		// INPUT
		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Nhập Thông Tin Lớp Học");
		pnlLopHocInput.setBorder(borderTitle);

		pnlLopHocInput.setLayout(new BoxLayout(pnlLopHocInput, BoxLayout.Y_AXIS));
		JPanel maLop = new JPanel();
		JLabel lblmaLop = new JLabel("Mã Lớp Học");
		lblmaLop.setPreferredSize(new Dimension(80, 30));
		JTextField txtmaLop = new JTextField(15);
		maLop.add(lblmaLop);
		maLop.add(txtmaLop);
		pnlLopHocInput.add(maLop);
		//
		JPanel tenLop = new JPanel();
		JLabel lbltenLop = new JLabel("Tên Lớp Học");
		lbltenLop.setPreferredSize(new Dimension(80, 30));
		JTextField txttenLop = new JTextField(15);
		tenLop.add(lbltenLop);
		tenLop.add(txttenLop);
		pnlLopHocInput.add(tenLop);
		//
		JPanel namHoc = new JPanel();
		JLabel lblnamHoc = new JLabel("Năm Học");
		lblnamHoc.setPreferredSize(new Dimension(80, 30));
		JTextField txtnamHoc = new JTextField(15);
		namHoc.add(lblnamHoc);
		namHoc.add(txtnamHoc);
		pnlLopHocInput.add(namHoc);

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
		pnlLopHocInput.add(btn);

		// TABLE
		Border border1 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle1 = BorderFactory.createTitledBorder(border1, "Danh Sách Lớp Học");
		pnlLopHocTable.setBorder(borderTitle1);
		
		DefaultTableModel dm = new DefaultTableModel();
		dm.addColumn("Mã Lớp");
		dm.addColumn("Tên Lớp");
		dm.addColumn("Năm Học");

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
		pnlLopHocTable.setLayout(new BorderLayout());
		pnlLopHocTable.add(sc);
		
		
		
		//Chọn môn cho lớp
		Border border2 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle2 = BorderFactory.createTitledBorder(border2, "Chọn Môn Cho Lớp");
		pnlLopHocTable1.setBorder(borderTitle2);
		pnlLopHocTable1.setLayout(new BoxLayout(pnlLopHocTable1, BoxLayout.Y_AXIS));
		
		JPanel chonMon = new JPanel();
		JLabel lblchonMon = new JLabel("Chọn Môn");
		JComboBox cboChonMon = new JComboBox();
		cboChonMon.addItem("Chọn Môn");
		JButton themMon = new JButton("Thêm Môn");
		JButton xoaMon = new JButton("Xóa Môn");
		chonMon.add(lblchonMon);
		chonMon.add(cboChonMon);
		chonMon.add(themMon);
		chonMon.add(xoaMon);
		pnlLopHocTable1.add(chonMon);
		//
		//
		DefaultTableModel dm1 = new DefaultTableModel();
		dm1.addColumn("Mã Môn");
		dm1.addColumn("Tên Môn");

		JTable tbl1 = new JTable(dm1);
		dm1.addRow(new String[] { "FFSE1703", "LP4" });
		dm1.addRow(new String[] { "FFSE1703", "LP3"});
		dm1.addRow(new String[] { "FFSE1703", "LP2"});
		// setColum
		TableColumnModel columnModel1 = tbl1.getColumnModel();
		columnModel1.getColumn(1).setPreferredWidth(110);
		tbl1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		JScrollPane sc1 = new JScrollPane(tbl1);
		//pnlLopHocTable1.setLayout(new BorderLayout());
		pnlLopHocTable1.add(sc1);
		//
		
		
		

		pnl.add(pnlLopHocInput);
		pnl.add(pnlLopHocTable1);
		pnl.add(pnlLopHocTable);

		this.setLayout(new BorderLayout());
		this.add(pnl);
		//
	}
}
