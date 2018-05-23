package ffse1703013.atm.layout;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import ffse1703013.atm.model.ThongKeBaoCao;
import ffse1703013.atm.model.ComboItem;
import ffse1703013.atm.model.DatabaseBaoCaoKH;
import ffse1703013.atm.model.DatabaseKhachHang;
import ffse1703013.atm.model.KhachHang;

public class LayoutBaoCaoRutTienKH extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final int ArrayList = 0;
	@SuppressWarnings("unused")
	private ArrayList<ComboItem> phuong = new ArrayList<>();
	private ArrayList<ThongKeBaoCao> arrBC = new ArrayList<ThongKeBaoCao>();
	@SuppressWarnings({ "unused", "rawtypes" })
	private JComboBox cboQuan, cboPhuong, cboSapXep;
	private DefaultTableModel model;
	private JTable tblBaoCaoKH;
	protected JTextField txtMaKhachHang;
	private DatabaseBaoCaoKH connectBC = new DatabaseBaoCaoKH();
	private JButton btnSubmitThang, btnSubmidKhoangTG, btnSubmitHuyThang, btnSubmitHuyKhoangTG;
	@SuppressWarnings("rawtypes")
	private JComboBox cboThang, cboNam;
	private JDateChooser dateStart, dateEnd;


	public LayoutBaoCaoRutTienKH() {
		addControll();
		addEvents();

	}

	public void addEvents() {
		txtMaKhachHang.addActionListener(selectKhachHang);
		btnSubmitThang.addActionListener(selectKhachHangTheoThang);
		btnSubmidKhoangTG.addActionListener(selectKhachHangTheoKhoangTG);
		btnSubmitHuyThang.addActionListener(huyKhoangTG);
		btnSubmitHuyKhoangTG.addActionListener(huyKhoangTG);
		cboSapXep.addActionListener(sapXep);
	}

	ActionListener sapXep = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			String sx = cboSapXep.getSelectedItem().toString();
			if (sx == "theo thời gian rút ") {
				model.setRowCount(0);
				Collections.sort(arrBC, ThongKeBaoCao.sortThoiGian);
				for (ThongKeBaoCao bc : arrBC) {

					DecimalFormat formatter = new DecimalFormat("###,###,###");
					SimpleDateFormat dfNew = new SimpleDateFormat("HH:mm a ,EEEEE ,dd/MM/yyyy ",
							new Locale("vi", "VN"));
					SimpleDateFormat dfOld = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String soTien = formatter.format(Integer.parseInt(bc.getSoTien())) + " VNĐ";
					String thoiGian = "";
					try {
						thoiGian = dfNew.format(dfOld.parse(bc.getThoiGian()));
					} catch (ParseException ex) {
						ex.printStackTrace();
					}
					String[] row = { bc.getMaGD(), bc.getMaMay(), thoiGian, soTien };
					model.addRow(row);
				}
			} else if (sx == "theo số Tiền rút ") {
				model.setRowCount(0);
				Collections.sort(arrBC, ThongKeBaoCao.sortSoTien);
				for (ThongKeBaoCao bc : arrBC) {

					DecimalFormat formatter = new DecimalFormat("###,###,###");
					SimpleDateFormat dfNew = new SimpleDateFormat("HH:mm a ,EEEEE ,dd/MM/yyyy ",
							new Locale("vi", "VN"));
					SimpleDateFormat dfOld = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String soTien = formatter.format(Integer.parseInt(bc.getSoTien())) + " VNĐ";
					String thoiGian = "";
					try {
						thoiGian = dfNew.format(dfOld.parse(bc.getThoiGian()));
					} catch (ParseException ex) {
						ex.printStackTrace();
					}
					String[] row = { bc.getMaGD(), bc.getMaMay(), thoiGian, soTien };
					model.addRow(row);
				}
			}
		}
	};
	ActionListener huyKhoangTG = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			duLieu();
		}
	};
	ActionListener selectKhachHangTheoKhoangTG = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				String pattent = "yyyy-MM-dd";
				Date start = dateStart.getDate();
				Date end = dateEnd.getDate();
				SimpleDateFormat dateFormat = new SimpleDateFormat(pattent);
				String batDau = dateFormat.format(start);
				String ketThuc = dateFormat.format(end);
				String maKH = txtMaKhachHang.getText();
				int soNgay = connectBC.tinhKhoangTG(batDau, ketThuc);

				if (maKH.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Bạn chưa nhập mã Khách hàng");
				} else {
					if (batDau.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày bắt đầu");
					} else if (ketThuc.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày Kết thúc");
					} else if (soNgay < 0) {
						JOptionPane.showMessageDialog(null, "Ngày bắt đầu không nhỏ hơn ngày kết thúc");
					} else if (soNgay > 90) {
						JOptionPane.showMessageDialog(null, "Khoảng thời gian không quá 90 ngày");
					} else {
						arrBC.clear();
						model.setRowCount(0);
						arrBC = connectBC.selectKhachHangTheoKhoangTG(maKH, batDau, ketThuc);
						if (arrBC.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Không có giao dịch nào trong Khoảng thời gian này");

						} else {
							for (ThongKeBaoCao bc : arrBC) {

								DecimalFormat formatter = new DecimalFormat("###,###,###");
								SimpleDateFormat dfNew = new SimpleDateFormat("HH:mm a ,EEEEE ,dd/MM/yyyy ",
										new Locale("vi", "VN"));
								SimpleDateFormat dfOld = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
								String soTien = formatter.format(Integer.parseInt(bc.getSoTien())) + " VNĐ";
								String thoiGian = "";
								try {
									thoiGian = dfNew.format(dfOld.parse(bc.getThoiGian()));
								} catch (ParseException ex) {
									ex.printStackTrace();
								}
								String[] row = { bc.getMaGD(), bc.getMaMay(), thoiGian, soTien };
								model.addRow(row);
							}
						}

					}
				}
			} catch (Exception ex) {

			}
		}
	};
	ActionListener selectKhachHangTheoThang = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			String thang = cboThang.getSelectedItem().toString();
			String nam = cboNam.getSelectedItem().toString();
			String thangNam = nam + "-" + thang;
			String maKH = txtMaKhachHang.getText();
			if (maKH.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Bạn chưa nhập mã Khách hàng");
			} else {
				model.setRowCount(0);
				arrBC.clear();
				arrBC = connectBC.selectKhachHangTheoThang(thangNam, maKH);
				if (arrBC.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Không có giao dịch nào trong Khoảng thời gian này");

				} else {
					for (ThongKeBaoCao bc : arrBC) {

						DecimalFormat formatter = new DecimalFormat("###,###,###");
						SimpleDateFormat dfNew = new SimpleDateFormat("HH:mm a ,EEEEE ,dd/MM/yyyy ",
								new Locale("vi", "VN"));
						SimpleDateFormat dfOld = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						String soTien = formatter.format(Integer.parseInt(bc.getSoTien())) + " VNĐ";
						String thoiGian = "";
						try {
							thoiGian = dfNew.format(dfOld.parse(bc.getThoiGian()));
						} catch (ParseException ex) {
							ex.printStackTrace();
						}
						String[] row = { bc.getMaGD(), bc.getMaMay(), thoiGian, soTien };
						model.addRow(row);
					}
				}
			}
		}
	};

	public void duLieu() {
		String maKH2 = txtMaKhachHang.getText();
		model.setRowCount(0);
		arrBC.clear();
		if (maKH2.isEmpty()) {

		} else {
			arrBC = connectBC.selectKhachHang(maKH2);
			if (arrBC.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Khách hàng không có giao dịch nào!!");
			} else {
				for (ThongKeBaoCao bc : arrBC) {

					DecimalFormat formatter = new DecimalFormat("###,###,###");
					SimpleDateFormat dfNew = new SimpleDateFormat("HH:mm a ,EEEEE ,dd/MM/yyyy ",
							new Locale("vi", "VN"));
					SimpleDateFormat dfOld = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String soTien = formatter.format(Integer.parseInt(bc.getSoTien())) + " VNĐ";
					String thoiGian = "";
					try {
						thoiGian = dfNew.format(dfOld.parse(bc.getThoiGian()));
					} catch (ParseException e) {
						e.printStackTrace();
					}
					String[] row = { bc.getMaGD(), bc.getMaMay(), thoiGian, soTien };
					model.addRow(row);
				}
			}
		}
	}

	ActionListener selectKhachHang = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			int kt = 0;
			String maKH1 = txtMaKhachHang.getText();
			ArrayList<KhachHang> arrKH = new ArrayList<>();
			DatabaseKhachHang connectKH = new DatabaseKhachHang();
			arrKH = connectKH.selectKhachHang();
			for (KhachHang x : arrKH) {
				if (maKH1.equals(x.getMaKH())) {
					kt = 1;
				}
			}
			model.setRowCount(0);
			arrBC.clear();
			arrBC = connectBC.selectKhachHang(maKH1);
			if (kt == 0) {
				JOptionPane.showMessageDialog(null, "Mã khách Hàng Không tồn tại!!");
			} else if (arrBC.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Khách hàng Chưa có giao dich nào!!");
			} else {
				for (ThongKeBaoCao bc : arrBC) {

					DecimalFormat formatter = new DecimalFormat("###,###,###");
					SimpleDateFormat dfNew = new SimpleDateFormat("HH:mm a ,EEEEE ,dd/MM/yyyy ",
							new Locale("vi", "VN"));
					SimpleDateFormat dfOld = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String soTien = formatter.format(Integer.parseInt(bc.getSoTien())) + " VNĐ";
					String thoiGian = "";
					try {
						thoiGian = dfNew.format(dfOld.parse(bc.getThoiGian()));
					} catch (ParseException ex) {
						ex.printStackTrace();
					}
					String[] row = { bc.getMaGD(), bc.getMaMay(), thoiGian, soTien };
					model.addRow(row);
				}
			}
		}
	};

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void addControll() {

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setOpaque(false);
		// panel chọn địa chỉ
		JPanel pnDiaChi = new JPanel();
		pnDiaChi.setOpaque(false);
		JLabel nameMaKH = new JLabel("Mã Khách hàng:");
		txtMaKhachHang = new JTextField(20);
		txtMaKhachHang.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		pnDiaChi.add(nameMaKH);
		pnDiaChi.add(txtMaKhachHang);

		JPanel pnChiTiet = new JPanel();
		pnChiTiet.setOpaque(false);
		pnChiTiet.setLayout(new BoxLayout(pnChiTiet, BoxLayout.Y_AXIS));
		Border border = BorderFactory.createLineBorder(Color.blue);
		@SuppressWarnings("unused")
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Thông tin chi tiết", TitledBorder.CENTER,
				TitledBorder.DEFAULT_POSITION);

		// panel tìm kiếm

		JPanel pnThoiGian = new JPanel();
		pnThoiGian.setOpaque(false);
		@SuppressWarnings("unused")
		Border border1 = BorderFactory.createLineBorder(Color.blue);
		TitledBorder borderTitle1 = BorderFactory.createTitledBorder(border, "Thống kê theo thời gian",
				TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
		pnThoiGian.setBorder(borderTitle1);
		// PANEL CHỌN kiểu thời gian

		JPanel pnRadio = new JPanel();
		pnRadio.setOpaque(false);
		pnRadio.setOpaque(false);
		pnRadio.setLayout(new BoxLayout(pnRadio, BoxLayout.Y_AXIS));
		JRadioButton r1 = new JRadioButton("1 Tháng/năm");
		r1.setOpaque(false);
		r1.setPreferredSize(new Dimension(200, 20));
		r1.setSelected(true);
		r1.setBounds(50, 100, 70, 30);
		JRadioButton r2 = new JRadioButton("Khảng thời gian");
		r2.setPreferredSize(new Dimension(200, 20));
		r2.setOpaque(false);
		r2.setBounds(50, 150, 70, 30);

		ButtonGroup bg = new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		pnRadio.add(r1);
		pnRadio.add(r2);

		// panel nhập ngày
		CardLayout clThoiGian = new CardLayout();
		JPanel pnInput = new JPanel(clThoiGian);
		pnInput.setOpaque(false);
		// kiểu tháng năm
		String[] itemThang = new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" };
		String[] itemNam = new String[] { "2015", "2016", "2017", "2018" };
		@SuppressWarnings("unused")
		String[] bookTitles = new String[] { "Effective Java", "Head First Java", "Thinking in Java",
				"Java for Dummies" };
		JPanel pnThang = new JPanel();
		pnThang.setOpaque(false);
		JLabel nameThang = new JLabel(" Tháng :");
		cboThang = new JComboBox<>(itemThang);
		cboThang.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		cboThang.setPreferredSize(new Dimension(60, 20));
		JLabel nameNam = new JLabel("    Năm: ");
		cboNam = new JComboBox<>(itemNam);
		cboNam.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		cboNam.setPreferredSize(new Dimension(80, 20));
		btnSubmitThang = new JButton("Submit");
		btnSubmitThang.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		btnSubmitHuyThang = new JButton("Hủy");
		btnSubmitHuyThang.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		pnThang.add(nameThang);
		pnThang.add(cboThang);
		pnThang.add(nameNam);
		pnThang.add(cboNam);
		pnThang.add(btnSubmitThang);
		pnThang.add(btnSubmitHuyThang);

		// kiểu khoảng thời gian
		// ngày bắt đầu
		JLabel nameDateStart = new JLabel("Từ ngày: ");
		dateStart = new JDateChooser();
		dateStart.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		dateStart.setDateFormatString("dd-MM-yyyy");
		JTextFieldDateEditor editStart = (JTextFieldDateEditor) dateStart.getDateEditor();
		editStart.setEditable(false);
		dateStart.setPreferredSize(new Dimension(100, 20));

		JLabel nameDateEnd = new JLabel("Đến ngày: ");
		dateEnd = new JDateChooser();
		dateEnd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		dateEnd.setDateFormatString("dd-MM-yyyy");
		JTextFieldDateEditor editEnd = (JTextFieldDateEditor) dateEnd.getDateEditor();
		editEnd.setEditable(false);
		dateEnd.setPreferredSize(new Dimension(100, 20));
		btnSubmidKhoangTG = new JButton("Submit");
		btnSubmidKhoangTG.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		btnSubmitHuyKhoangTG = new JButton("Hủy");
		btnSubmitHuyKhoangTG.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));

		JPanel pnKhoangTG = new JPanel();
		pnKhoangTG.setOpaque(false);
		pnKhoangTG.add(nameDateStart);
		pnKhoangTG.add(dateStart);
		pnKhoangTG.add(nameDateEnd);
		pnKhoangTG.add(dateEnd);
		pnKhoangTG.add(btnSubmidKhoangTG);
		pnKhoangTG.add(btnSubmitHuyKhoangTG);

		// thêm vào cardLayout
		pnInput.add(pnThang, "1");
		pnInput.add(pnKhoangTG, "2");
		clThoiGian.show(pnInput, "1");

		r1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				clThoiGian.show(pnInput, "1");
			}
		});
		r2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				clThoiGian.show(pnInput, "2");
			}
		});

		pnThoiGian.add(pnRadio);
		pnThoiGian.add(pnInput);

		// panel sắp xếp
		JPanel pnSapxep = new JPanel();
		pnSapxep.setOpaque(false);
		pnSapxep.setLayout(new BoxLayout(pnSapxep, BoxLayout.X_AXIS));
		pnSapxep.setPreferredSize(new Dimension(850, 30));

		JPanel pnLeft = new JPanel();
		pnLeft.setOpaque(false);
		pnLeft.setPreferredSize(new Dimension(500, 30));
		JPanel pnRight = new JPanel();

		pnRight.setOpaque(false);
		pnRight.setPreferredSize(new Dimension(200, 30));
		JLabel nameSapXep = new JLabel("Sắp xếp: ");
		cboSapXep = new JComboBox();
		cboSapXep.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		cboSapXep.setPreferredSize(new Dimension(160, 20));
		cboSapXep.addItem("theo thời gian rút ");
		cboSapXep.addItem("theo số Tiền rút ");

		pnRight.add(nameSapXep);
		pnRight.add(cboSapXep);

		pnSapxep.add(pnLeft);
		pnSapxep.add(pnRight);

		// panel danh sach giao dịch
		JPanel pnTableBaoCaoKH = new JPanel();
		pnTableBaoCaoKH.setOpaque(false);
		Border border11 = BorderFactory.createLineBorder(Color.blue);
		TitledBorder borderTitle11 = BorderFactory.createTitledBorder(border11, "Danh Sách Giao Dịch");
		pnTableBaoCaoKH.setBorder(borderTitle11);
		model = new DefaultTableModel();
		tblBaoCaoKH = new JTable(model);
		tblBaoCaoKH.setLayout(new BorderLayout());
		model.addColumn("Mã Giao Dịch");
		model.addColumn("Mã máy ATM");
		model.addColumn("Thời gian");
		model.addColumn("Số tiền");

		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
		tblBaoCaoKH.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
		tblBaoCaoKH.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);

		// duLieu();
		JScrollPane scroll = new JScrollPane(tblBaoCaoKH);
		scroll.setOpaque(false);
		scroll.getViewport().setOpaque(false);
		pnTableBaoCaoKH.setLayout(new BorderLayout());
		pnTableBaoCaoKH.add(scroll, BorderLayout.CENTER);

		// add vào panel chính
		this.add(pnDiaChi);

		this.add(pnThoiGian);
		this.add(pnSapxep);
		this.add(pnTableBaoCaoKH);

	}

}
