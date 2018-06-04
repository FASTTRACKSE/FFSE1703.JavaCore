package ffse1703022.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
<<<<<<< HEAD

=======
import java.util.ArrayList;
>>>>>>> b149031eb33d3b97feec315adef76423bd77895d

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
<<<<<<< HEAD
=======
import javax.swing.JOptionPane;
>>>>>>> b149031eb33d3b97feec315adef76423bd77895d
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

<<<<<<< HEAD
import ffse1703022.model.ThongKeModel;
=======
import ffse1703022.model.KhachHangModel;
import ffse1703022.model.ThongKeModel;
import ffse1703022.ui.QLKhachHangUI.SelectQuanListener;
>>>>>>> b149031eb33d3b97feec315adef76423bd77895d

@SuppressWarnings("serial")
public class ThongKeBaoCao extends JPanel {
	private JTextField txtMaCT, txtYear;
	@SuppressWarnings("rawtypes")
	private JComboBox cboQuan, cboPhuong, cboTimTG, cboyear, cboTimKH;
	private JButton btnSearch;
	private JRadioButton rdbtnThongKeKH, rdbtnThongKeBL;
	private DefaultTableModel dm;
	private JTable tbl;
	private JMonthChooser monthStart, monthEnd;
	private JYearChooser yearStart, yearEnd;
	private JLabel jblMaKH, jblQuan, jblPhuong, jblKhachHang, jblThoiGian, jblTo;
	private String[] columnKH = { "Mã khách hàng", "Mã công tơ", "Họ tên", "Địa chỉ", "Quận", "Phường", "Điện thoại",
			"Email" };
	private String[] columnBL = { "Mã biên lai", "Mã công tơ", "Ngày nhập", "Chu kỳ nhập", "Chỉ số cũ", "Chỉ số mới	",
			"Số tiền" };
	private ThongKeModel thongKeModel = new ThongKeModel();

	public ThongKeBaoCao() {
		addControls();
		addEvents();
		getQuan();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void addControls() {
		JPanel pnFlow = new JPanel();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		pnFlow.setLayout(new FlowLayout());

<<<<<<< HEAD
	
=======
		JPanel BoxtenKH = new JPanel();
		JPanel BoxQuanPhuong = new JPanel();
>>>>>>> b149031eb33d3b97feec315adef76423bd77895d
		JPanel boxKH = new JPanel();
		JPanel boxTG = new JPanel();
		JPanel boxTable = new JPanel();

		rdbtnThongKeKH = new JRadioButton("Thống kê khách hàng");
		this.add(rdbtnThongKeKH);
		rdbtnThongKeBL = new JRadioButton("Thống kê biên lai");
		this.add(rdbtnThongKeBL);

		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnThongKeKH);
		bg.add(rdbtnThongKeBL);

		//
		jblMaKH = new JLabel("Mã công tơ");
		txtMaCT = new JTextField(20);
		//
		jblQuan = new JLabel("Quận");
		cboQuan = new JComboBox();
		cboQuan.addItem("Tất Cả");
		jblPhuong = new JLabel("Phường");
		cboPhuong = new JComboBox();
		cboPhuong.addItem("Tất cả");

		//
		jblKhachHang = new JLabel("Khách hàng");
		cboTimKH = new JComboBox();
		cboTimKH.addItem("Tất cả");
		cboTimKH.addItem("Theo khu vực");
		cboTimKH.addItem("Theo khách hàng cụ thể");
		//
		jblThoiGian = new JLabel("Thời gian");
		cboTimTG = new JComboBox();
		cboTimTG.addItem("Theo năm");
		cboTimTG.addItem("Theo khoảng thời gian");
		cboTimTG.addItem("Theo kỳ");
		cboyear = new JComboBox();
		cboyear.addItem("");

		txtYear = new JTextField(10);

		monthStart = new JMonthChooser();
		monthStart.setPreferredSize(new Dimension(100, 20));
		yearStart = new JYearChooser();
		yearStart.setPreferredSize(new Dimension(70, 20));
		jblTo = new JLabel(" - ");
		monthEnd = new JMonthChooser();
		monthEnd.setPreferredSize(new Dimension(100, 20));
		yearEnd = new JYearChooser();
		yearEnd.setPreferredSize(new Dimension(70, 20));

		btnSearch = new JButton("Tìm kiếm");
		boxKH.add(jblKhachHang);
		boxKH.add(cboTimKH);

		boxKH.add(jblQuan);
		boxKH.add(cboQuan);
		boxKH.add(jblPhuong);
		boxKH.add(cboPhuong);
		boxKH.add(jblMaKH);
		boxKH.add(txtMaCT);

		boxTG.add(jblThoiGian);
		boxTG.add(cboTimTG);
		boxTG.add(txtYear);
		boxTG.add(monthStart);
		boxTG.add(yearStart);
		boxTG.add(jblTo);
		boxTG.add(monthEnd);
		boxTG.add(yearEnd);

		this.add(boxKH);
		this.add(boxTG);
		this.add(btnSearch);
		//
		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Danh sách");
		boxTable.setBorder(borderTitle);

		tbl = new JTable(dm);

		JScrollPane sc = new JScrollPane(tbl);

		boxTable.setLayout(new BorderLayout());
		boxTable.add(sc, BorderLayout.CENTER);
		this.add(boxTable);

		jblMaKH.setVisible(false);
		jblQuan.setVisible(false);
		jblPhuong.setVisible(false);
		jblKhachHang.setVisible(false);
		jblThoiGian.setVisible(false);
		cboTimKH.setVisible(false);
		cboTimTG.setVisible(false);
		cboQuan.setVisible(false);
		cboPhuong.setVisible(false);
		txtMaCT.setVisible(false);

		txtYear.setVisible(false);
		monthStart.setVisible(false);
		yearStart.setVisible(false);
		jblTo.setVisible(false);
		monthEnd.setVisible(false);
		yearEnd.setVisible(false);
	}

	public void addEvents() {
		rdbtnThongKeKH.addActionListener(new ThongKeKHListener());
		rdbtnThongKeBL.addActionListener(new ThongKeBLListener());
		cboTimKH.addActionListener(new TimKHListener());
		cboTimTG.addActionListener(new TimTGListener());
		cboQuan.addActionListener(new SelectQuanListener());
		btnSearch.addActionListener(new SearchCus());
		// btnSearch.addActionListener(new SearchBL());
	}

	private class ThongKeKHListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			dm = new DefaultTableModel(columnKH, 0);
			tbl.setModel(dm);
			jblQuan.setVisible(true);
			jblPhuong.setVisible(true);
			cboQuan.setVisible(true);
			cboPhuong.setVisible(true);

			jblMaKH.setVisible(false);
			jblKhachHang.setVisible(false);
			jblThoiGian.setVisible(false);
			cboTimKH.setVisible(false);
			cboTimTG.setVisible(false);
			txtMaCT.setVisible(false);

			txtYear.setVisible(false);
			monthStart.setVisible(false);
			yearStart.setVisible(false);
			jblTo.setVisible(false);
			monthEnd.setVisible(false);
			yearEnd.setVisible(false);
		}
	}

	private class ThongKeBLListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			dm = new DefaultTableModel(columnBL, 0);
			tbl.setModel(dm);
			jblKhachHang.setVisible(true);
			jblThoiGian.setVisible(true);
			cboTimKH.setVisible(true);
			cboTimTG.setVisible(true);

			jblMaKH.setVisible(false);
			jblQuan.setVisible(false);
			jblPhuong.setVisible(false);
			cboQuan.setVisible(false);
			cboPhuong.setVisible(false);
			txtMaCT.setVisible(false);

			txtYear.setVisible(true);
			monthStart.setVisible(false);
			yearStart.setVisible(false);
			jblTo.setVisible(false);
			monthEnd.setVisible(false);
			yearEnd.setVisible(false);
		}
	}

	private class TimKHListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int select = cboTimKH.getSelectedIndex();
			if (select == 0) {
				jblMaKH.setVisible(false);
				jblQuan.setVisible(false);
				jblPhuong.setVisible(false);
				cboQuan.setVisible(false);
				cboPhuong.setVisible(false);
				txtMaCT.setVisible(false);
			} else if (select == 1) {
				jblMaKH.setVisible(false);
				jblQuan.setVisible(true);
				jblPhuong.setVisible(true);
				cboQuan.setVisible(true);
				cboPhuong.setVisible(true);
				txtMaCT.setVisible(false);
			} else if (select == 2) {
				jblMaKH.setVisible(true);
				jblQuan.setVisible(false);
				jblPhuong.setVisible(false);
				cboQuan.setVisible(false);
				cboPhuong.setVisible(false);
				txtMaCT.setVisible(true);
			}
		}
	}

	private class TimTGListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int select = cboTimTG.getSelectedIndex();
			if (select == 0) {
				txtYear.setVisible(true);
				monthStart.setVisible(false);
				yearStart.setVisible(false);
				jblTo.setVisible(false);
				monthEnd.setVisible(false);
				yearEnd.setVisible(false);
			} else if (select == 1) {
				txtYear.setVisible(false);
				monthStart.setVisible(true);
				yearStart.setVisible(true);
				jblTo.setVisible(true);
				monthEnd.setVisible(true);
				yearEnd.setVisible(true);
			} else if (select == 2) {
				txtYear.setVisible(false);
				monthStart.setVisible(true);
				yearStart.setVisible(true);
				jblTo.setVisible(false);
				monthEnd.setVisible(false);
				yearEnd.setVisible(false);
			}
		}
	}

<<<<<<< HEAD
	@SuppressWarnings("unchecked")
=======
>>>>>>> b149031eb33d3b97feec315adef76423bd77895d
	private void getQuan() {
		ResultSet rs;
		try {
			rs = thongKeModel.getQuan();
			while ((rs != null) && rs.next()) {
				cboQuan.addItem(rs.getString("name"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private class SelectQuanListener implements ActionListener {
<<<<<<< HEAD
		@SuppressWarnings("unchecked")
=======
>>>>>>> b149031eb33d3b97feec315adef76423bd77895d
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				cboPhuong.removeAllItems();
				cboPhuong.addItem("Tất cả");
				ResultSet rs;
				String tenQuan = cboQuan.getSelectedItem().toString();
				rs = thongKeModel.getPhuong(tenQuan);
				while (rs.next()) {
					cboPhuong.addItem(rs.getString("Phuong.name"));

				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}

	private class SearchCus implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				ResultSet rs;
				dm.setRowCount(0);
				
				if (rdbtnThongKeKH.isSelected()) {
					System.out.println("thống kê khách hàng");
					String quan = cboQuan.getSelectedItem().toString();
					String phuong = cboPhuong.getSelectedItem().toString();

					rs = thongKeModel.searchCus(phuong, quan);
					while (rs.next()) {
						// System.out.println(rs.getString("TenKH"));
						String[] row = { rs.getString("MaKH"), rs.getString("MaCT"), rs.getString("TenKH"),
								rs.getString("DiaChi"), rs.getString("Quan"), rs.getString("Phuong"),
								rs.getString("Phone"), rs.getString("Email"), };
						dm.addRow(row);
					}

				} else if (rdbtnThongKeBL.isSelected()) {
					System.out.println("thống kê biên lai");
					int iKH = cboTimKH.getSelectedIndex();
					int iTG = cboTimTG.getSelectedIndex();
					String khachHang = null;
					String thoiGian = null;
					if (iKH == 0) {
						khachHang = "1";
					} else if (iKH == 1) {
						if (cboQuan.getSelectedItem().equals("Tất Cả")) {
							khachHang = "1";
						} else if (cboPhuong.getSelectedItem().equals("Tất cả")) {
							khachHang = "Quan = '" + cboQuan.getSelectedItem().toString() + "'";
						} else {
							khachHang = "Quan = '" + cboQuan.getSelectedItem().toString() + "' AND Phuong = '"
									+ cboPhuong.getSelectedItem().toString() + "'";
						}
					} else if (iKH == 2) {
						khachHang = "`BienLai`.MaCT = '" + txtMaCT.getText() + "'";
					}

					if (iTG == 0) {
						thoiGian = "YEAR(ChuKyDate) = " + txtYear.getText();
					} else if (iTG == 1) {
						thoiGian = "ChuKyDate BETWEEN '" + yearStart.getYear() + "-" + (monthStart.getMonth()+1)
								+ "-01'AND '" + yearEnd.getYear() + "-" + (monthEnd.getMonth()+1) + "-01'";
					} else if (iTG == 2) {
						thoiGian = "ChuKy = '" + (monthStart.getMonth()+1) + "/" + yearStart.getYear() + "'";
					}

					rs=thongKeModel.searchBL(khachHang, thoiGian);
					while(rs.next()) {
						String[] row = { rs.getString("ID"), rs.getString("MaCT"), rs.getString("Date"),
								rs.getString("ChuKy"), rs.getString("ChiSo"), rs.getString("ChiSoMoi"),
								rs.getString("SoTien")};
						dm.addRow(row);
					}

				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

}
