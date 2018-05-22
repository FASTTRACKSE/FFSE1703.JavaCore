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
import model.QuanLiDiemHocModel;
import model.QuanLiDiemHocSQL;
import model.QuanLiLopHocModel;
import model.QuanLiLopHocSQL;
import model.QuanLiMonHocCuaLopModel;
import model.QuanLiSinhVienModel;
import model.QuanLiSinhVienSQL;
import model.ThongKeLopHocSQL;

public class ThongKeSinhVienUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("rawtypes")
	public JComboBox cboChonNam, cboChonLop;
	private DefaultTableModel dm;
	private JTable tbl;
	private QuanLiSinhVienSQL quanLiSinhVienSQL = new QuanLiSinhVienSQL();
	private ThongKeLopHocSQL thongKeLopHocSQL = new ThongKeLopHocSQL();
	private QuanLiLopHocSQL quanLiLopHocSQL = new QuanLiLopHocSQL();
	private QuanLiDiemHocSQL quanLiDiemHocSQL = new QuanLiDiemHocSQL();

	private ArrayList<QuanLiDiemHocModel> arrDiem = new ArrayList<>();
	private ArrayList<QuanLiLopHocModel> arrLop = new ArrayList<>();
	private ArrayList<String> arrNamHoc = new ArrayList<>();
	private ArrayList<QuanLiSinhVienModel> arrSinhVien = new ArrayList<>();
	private ArrayList<QuanLiMonHocCuaLopModel> arrMon = new ArrayList<>();

	public ThongKeSinhVienUI() {
		addControls();
		addEvents();
		cboNam();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void addControls() {
		JPanel pnl = new JPanel();
		pnl.setLayout(new BoxLayout(pnl, BoxLayout.Y_AXIS));
		JPanel pnlThongKeSvCbo = new JPanel();
		JPanel pnlThongKeSvTable = new JPanel();

		pnlThongKeSvCbo.setLayout(new BoxLayout(pnlThongKeSvCbo, BoxLayout.X_AXIS));
		JPanel cbo = new JPanel();
		JLabel lblChonNam = new JLabel("Chọn Năm");
		cboChonNam = new JComboBox();

		JLabel lblChonLop = new JLabel("Chọn Lớp");
		cboChonLop = new JComboBox();
		cboChonLop.addItem("Chọn Lớp");
		cbo.add(lblChonNam);
		cbo.add(cboChonNam);
		cbo.add(lblChonLop);
		cbo.add(cboChonLop);
		pnlThongKeSvCbo.add(cbo);

		Border border = BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Thống Kê Sinh Viên");
		pnlThongKeSvTable.setBorder(borderTitle);

		dm = new DefaultTableModel();

		tbl = new JTable(dm);

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

	public void addEvents() {
		cboChonNam.addActionListener(eventCboNam);
		cboChonLop.addActionListener(eventCboLop);
	}

	ActionListener eventCboNam = new ActionListener() {

		@SuppressWarnings("unchecked")
		@Override
		public void actionPerformed(ActionEvent e) {
			dm.setRowCount(0);
			Object cboNam = cboChonNam.getSelectedItem();
			if (cboNam != null && !cboNam.toString().equals("Chọn Năm")) {
				String chonNam = cboChonNam.getSelectedItem().toString();
				arrLop = quanLiLopHocSQL.selectLop();
				cboChonLop.removeAllItems();
				cboChonLop.addItem("Chọn Lớp");

				for (QuanLiLopHocModel x : arrLop) {
					if (chonNam.equals(x.getNamHoc())) {
						cboChonLop.addItem(x);
					}
				}
			}

		}
	};
	ActionListener eventCboLop = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			Object cboLop = cboChonLop.getSelectedItem();
			double tong = 0;
			if (cboLop != null && !cboLop.toString().equals("Chọn Lớp")) {
				String maLop = cboChonLop.getSelectedItem().toString();
				dm.setRowCount(0);
				arrSinhVien = quanLiSinhVienSQL.selectMalop(maLop);
				arrMon = quanLiLopHocSQL.selectMonHocCuaLop(maLop);
				dm.setColumnCount(0);
				dm.addColumn("Mã Sinh Viên");
				dm.addColumn("Tên Sinh Viên");
				for (QuanLiMonHocCuaLopModel x : arrMon) {
					dm.addColumn(x.getMaMh());
				}
				dm.addColumn("Điểm TB");
				dm.addColumn("Xếp Loại");

				for (QuanLiSinhVienModel x : arrSinhVien) {
					tong = 0;

					arrDiem = quanLiDiemHocSQL.diem(x.getMaSv());
					for (int i = 0; i < arrDiem.size(); i++) {
						double diemSv = Integer.parseInt(arrDiem.get(i).getDiemMH());
						tong += diemSv;
					}
					String diemTb = String.valueOf(tong / arrMon.size());
					String maSv = x.getMaSv();
					String row[] = new String[20];
					row[0] = x.getMaSv();
					row[1] = x.getHoTenSv();
					for (int i = 0; i < arrMon.size(); i++) {
						row[i + 2] = thongKeLopHocSQL.diemSv(maSv, arrMon.get(i).getMaMh());
					}
					row[arrMon.size() + 2] = diemTb;

					String xepLoai;
					double tb = Double.parseDouble(diemTb);
					if (arrDiem.size() != arrMon.size()) {
						xepLoai = null;
						row[arrMon.size() + 2] = null;
					} else if (tb >= 8.5) {
						xepLoai = "Giỏi";
					} else if (tb < 8.5 && tb >= 5) {
						xepLoai = "Khá";
					} else if (tb < 5 && tb >= 3.5) {
						xepLoai = "Trung Bình";
					} else {
						xepLoai = " Yếu ";
					}
					row[arrMon.size() + 3] = xepLoai;
					dm.addRow(row);
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
