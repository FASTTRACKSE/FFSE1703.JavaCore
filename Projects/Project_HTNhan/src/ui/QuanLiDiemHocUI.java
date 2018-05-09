package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
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

public class QuanLiDiemHocUI extends JPanel {
	public QuanLiDiemHocUI () {
		addControls();
	}
	public void addControls() {
		JPanel pnl = new JPanel();
		pnl.setLayout(new BoxLayout(pnl, BoxLayout.X_AXIS));
		
		JPanel pnlDiemHocInput1 = new JPanel();
		JPanel pnlDiemHocInput2 = new JPanel();
		JPanel pnlDiemHocTable = new JPanel();

		
		//input
		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border ,"Nhập Điểm Môn Học");
		pnlDiemHocInput1.setBorder(borderTitle);
		//
		pnlDiemHocInput1.setLayout(new BoxLayout(pnlDiemHocInput1, BoxLayout.Y_AXIS));
		JPanel chonLop = new JPanel();
		JLabel lblchonLop = new JLabel("Chọn Lớp ");
		JComboBox cbochonLop = new JComboBox();
		cbochonLop.addItem("itemmmmmmmmmmm");
		cbochonLop.setPreferredSize(new Dimension(170, 20));
		lblchonLop.setPreferredSize(new Dimension(90, 50));
		chonLop.add(lblchonLop);
		chonLop.add(cbochonLop);
		pnlDiemHocInput1.add(chonLop);
		
		JPanel chonMon = new JPanel();
		JLabel lblchonMon = new JLabel("Chọn Môn ");
		JComboBox cbochonMon = new JComboBox();
		cbochonMon.addItem("itemmmmmmmmmmm");
		cbochonMon.setPreferredSize(new Dimension(170, 20));
		lblchonMon.setPreferredSize(new Dimension(90, 50));
		chonMon.add(lblchonMon);
		chonMon.add(cbochonMon);
		pnlDiemHocInput1.add(chonMon);
		
		JPanel tenSv = new JPanel();
		JLabel lbltenSv = new JLabel("Tên Sinh Viên");
		JTextField txttenSv = new JTextField(15);
		lbltenSv.setPreferredSize(new Dimension(90, 20));
		tenSv.add(lbltenSv);
		tenSv.add(txttenSv);
		pnlDiemHocInput1.add(tenSv);
		//
		//
		JPanel diemSv = new JPanel();
		JLabel lbldiemSv = new JLabel("Nhập Điểm");
		JTextField txtdiemSv = new JTextField(15);
		lbldiemSv.setPreferredSize(new Dimension(90, 20));
		diemSv.add(lbldiemSv);
		diemSv.add(txtdiemSv);
		pnlDiemHocInput1.add(diemSv);
		//
		
		
		
		JPanel btn = new JPanel();
		JButton btnNhap = new JButton("Nhập");
		btnNhap.setPreferredSize(new Dimension(90, 30));
		JButton btnThoat = new JButton("Thoát");
		btnThoat.setPreferredSize(new Dimension(90, 30));
		btn.add(btnNhap);
		btn.add(btnThoat);
		pnlDiemHocInput1.add(btn);
		
		//TABLE 1
		Border border1 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle1 = BorderFactory.createTitledBorder(border1 ,"Chọn Sinh Viên Để Nhập");
		pnlDiemHocTable.setBorder(borderTitle1);
		
		DefaultTableModel dm1 = new DefaultTableModel();
		dm1.addColumn("Mã Sinh Viên");
		dm1.addColumn("Tên Sinh Viên");
		dm1.addColumn("Lớp");

		JTable tbl = new JTable(dm1);
		dm1.addRow(new String[] { "112", "Ngô văn Bắp", "21" });
		dm1.addRow(new String[] { "113", "Nguyễn Thị Tý", "18" });
		dm1.addRow(new String[] { "114", "Trần Văn Tèo", "22" });
		// setColum
		TableColumnModel columnModel = tbl.getColumnModel();
		columnModel.getColumn(1).setPreferredWidth(110);
		tbl.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		//
		JScrollPane sc = new JScrollPane(tbl);
		pnlDiemHocTable.setLayout(new BorderLayout());
		pnlDiemHocTable.add(sc);
		
		
		//Sinh Vien Nhap Diem
//		Border border2 = BorderFactory.createLineBorder(Color.RED);
//		TitledBorder borderTitle2 = BorderFactory.createTitledBorder(border2 ,"Sinh Viên Cần Nhập");
//		pnlDiemHocInput2.setBorder(borderTitle2);
//		//
//		pnlDiemHocInput2.setLayout(new BoxLayout(pnlDiemHocInput2, BoxLayout.Y_AXIS));
		
		
		
		
		
		pnl.add(pnlDiemHocInput1);
		pnl.add(pnlDiemHocTable);
		pnl.add(pnlDiemHocInput2);
		this.setLayout(new BorderLayout());
		this.add(pnl);
	}
}
