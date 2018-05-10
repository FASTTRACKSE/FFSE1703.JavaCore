package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

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

import model.QuanLiLopHocModel;
import model.QuanLiLopHocSQL;
import model.QuanLiMonHocCuaLopModel;
import model.QuanLiMonHocModel;
import model.QuanLiMonHocSQL;
import model.QuanLiSinhVienModel;
import model.QuanLiSinhVienSQL;

public class QuanLiDiemHocUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String maLop;
	private JTable tbl;
	private JComboBox cbochonLop, cbochonMon;
	private JButton btnNhap, btnThoat;
	private JTextField txttenSv, txtdiemSv;
	private DefaultTableModel dm;
	private QuanLiSinhVienSQL quanLiSinhVienSQL = new QuanLiSinhVienSQL();
	private QuanLiLopHocSQL quanLiLopHocSQL = new QuanLiLopHocSQL();
	private QuanLiMonHocSQL quanLiMonHocSQL = new QuanLiMonHocSQL();
	
	private ArrayList<QuanLiMonHocModel> arrMonHoc = new ArrayList<>();
	private ArrayList<QuanLiLopHocModel> arrMaLop = new ArrayList<>();
	private ArrayList<QuanLiSinhVienModel> arrQlSinhVien = new ArrayList<>();

	public QuanLiDiemHocUI() {
		addControls();
		addEvents();
		table();
	}

	public void addControls() {
		JPanel pnl = new JPanel();
		pnl.setLayout(new BoxLayout(pnl, BoxLayout.X_AXIS));

		JPanel pnlDiemHocInput1 = new JPanel();
		JPanel pnlDiemHocInput2 = new JPanel();
		JPanel pnlDiemHocTable = new JPanel();

		// input
		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Nhập Điểm Môn Học");
		pnlDiemHocInput1.setBorder(borderTitle);
		//
		pnlDiemHocInput1.setLayout(new BoxLayout(pnlDiemHocInput1, BoxLayout.Y_AXIS));
		JPanel chonLop = new JPanel();
		JLabel lblchonLop = new JLabel("Chọn Lớp ");
		cbochonLop = new JComboBox();

		arrMaLop = quanLiLopHocSQL.selectLop();
		for(QuanLiLopHocModel x: arrMaLop) {
			cbochonLop.addItem(x.getMaLop());
		}
		cbochonLop.setPreferredSize(new Dimension(170, 20));
		lblchonLop.setPreferredSize(new Dimension(90, 50));
		chonLop.add(lblchonLop);
		chonLop.add(cbochonLop);
		pnlDiemHocInput1.add(chonLop);

		JPanel chonMon = new JPanel();
		JLabel lblchonMon = new JLabel("Chọn Môn ");
		cbochonMon = new JComboBox();
		arrMonHoc = quanLiMonHocSQL.selectMonHoc();
		for(QuanLiMonHocModel x: arrMonHoc) {
			cbochonMon.addItem(x.getMaMH());
		}
		cbochonMon.setPreferredSize(new Dimension(170, 20));
		lblchonMon.setPreferredSize(new Dimension(90, 50));
		chonMon.add(lblchonMon);
		chonMon.add(cbochonMon);
		pnlDiemHocInput1.add(chonMon);

		JPanel tenSv = new JPanel();
		JLabel lbltenSv = new JLabel("Tên Sinh Viên");
		txttenSv = new JTextField(15);
		lbltenSv.setPreferredSize(new Dimension(90, 20));
		tenSv.add(lbltenSv);
		tenSv.add(txttenSv);
		pnlDiemHocInput1.add(tenSv);
		//
		//
		JPanel diemSv = new JPanel();
		JLabel lbldiemSv = new JLabel("Nhập Điểm");
		txtdiemSv = new JTextField(15);
		lbldiemSv.setPreferredSize(new Dimension(90, 20));
		diemSv.add(lbldiemSv);
		diemSv.add(txtdiemSv);
		pnlDiemHocInput1.add(diemSv);
		//

		JPanel btn = new JPanel();
		btnNhap = new JButton("Nhập");
		btnNhap.setPreferredSize(new Dimension(90, 30));
		btnThoat = new JButton("Thoát");
		btnThoat.setPreferredSize(new Dimension(90, 30));
		btn.add(btnNhap);
		btn.add(btnThoat);
		pnlDiemHocInput1.add(btn);

		// TABLE 1
		Border border1 = BorderFactory.createLineBorder(Color.RED);
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

		pnl.add(pnlDiemHocInput1);
		pnl.add(pnlDiemHocTable);
		pnl.add(pnlDiemHocInput2);
		this.setLayout(new BorderLayout());
		this.add(pnl);
	}

	public void addEvents() {

	}

	public void table() {
		arrQlSinhVien = quanLiSinhVienSQL.selectAll();
		for (QuanLiSinhVienModel x : arrQlSinhVien) {
			String row[] = { x.getMaSv(), x.getHoTenSv(), x.getMaLop() };
			dm.addRow(row);
		}
	}
}
