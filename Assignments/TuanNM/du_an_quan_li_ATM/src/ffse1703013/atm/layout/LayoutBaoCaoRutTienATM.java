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
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import ffse1703013.atm.model.ATM;
import ffse1703013.atm.model.ComboItem;
import ffse1703013.atm.model.DatabaseBaoCaoATM;
import ffse1703013.atm.model.DatabaseDiaChi;
import ffse1703013.atm.model.GiaoDich;

public class LayoutBaoCaoRutTienATM extends JPanel {
	private static final long serialVersionUID = 1L;
	ArrayList<ATM> arrTK = new ArrayList<ATM>();
	ArrayList<GiaoDich> arrBC = new ArrayList<GiaoDich>();
	private ArrayList<ComboItem> arrPhuong = new ArrayList<>();
	private ArrayList<String> arrDuongPho = new ArrayList<>();
	private ArrayList<String> arrMaATM = new ArrayList<>();
	private DatabaseBaoCaoATM connectBaoCaoATM = new DatabaseBaoCaoATM();
	private DefaultTableModel model;
	private JTable tblDanhSachMayATM;
	@SuppressWarnings("rawtypes")
	private JComboBox cboSapXep;
	@SuppressWarnings("rawtypes")
	protected JComboBox cboPhuong, cboQuan, cboDuongPho, cboMayATM;
	private JButton btnSubmitThang, btnSubmidKhoangTG;
	@SuppressWarnings("rawtypes")
	private JComboBox cboThang, cboNam;
	private JDateChooser dateStart, dateEnd;
	private JButton btnHuyThang, btnHuyKhoangTG;

	public LayoutBaoCaoRutTienATM() {
		addControl();
		addEvent();
		selectDanhSach();
	}

	public void addEvent() {
		cboQuan.addActionListener(selectPhuong);
		cboPhuong.addActionListener(selectDuongPho);
		cboDuongPho.addActionListener(selectMayATM);
		cboMayATM.addActionListener(selectDanhSachATM);
		btnSubmitThang.addActionListener(selectATMTheoThang);
		btnSubmidKhoangTG.addActionListener(selectKhachHangTheoKhoangTG);
		btnHuyThang.addActionListener(huyKhoangTG);
		btnHuyKhoangTG.addActionListener(huyKhoangTG);
		cboSapXep.addActionListener(sapXep);
	}

	ActionListener sapXep = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			String sx = cboSapXep.getSelectedItem().toString();
			if (sx == "theo thời gian rút ") {
				model.setRowCount(0);
				Collections.sort(arrBC, GiaoDich.sortThoiGian);
				for (GiaoDich bc : arrBC) {
					DecimalFormat formatter = new DecimalFormat("###,###,###");
					String soTien = formatter.format(Integer.parseInt(bc.getSoTien())) + " VNĐ";
					SimpleDateFormat dfNew = new SimpleDateFormat("HH:mm a ,EEEEE ,dd/MM/yyyy ",
							new Locale("vi", "VN"));
					SimpleDateFormat dfOld = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String thoiGian = "";
					try {
						thoiGian = dfNew.format(dfOld.parse(bc.getThoiGian()));
					} catch (ParseException ex) {
						ex.printStackTrace();
					}

					String[] row = { bc.getMaGD(), bc.getSoThe(), thoiGian, soTien };
					model.addRow(row);
				}
			} else if (sx == "theo số Tiền rút ") {
				model.setRowCount(0);
				Collections.sort(arrBC, GiaoDich.sortSoTien);
				for (GiaoDich bc : arrBC) {
					DecimalFormat formatter = new DecimalFormat("###,###,###");
					String soTien = formatter.format(Integer.parseInt(bc.getSoTien())) + " VNĐ";
					SimpleDateFormat dfNew = new SimpleDateFormat("HH:mm a ,EEEEE ,dd/MM/yyyy ",
							new Locale("vi", "VN"));
					SimpleDateFormat dfOld = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String thoiGian = "";
					try {
						thoiGian = dfNew.format(dfOld.parse(bc.getThoiGian()));
					} catch (ParseException ex) {
						ex.printStackTrace();
					}

					String[] row = { bc.getMaGD(), bc.getSoThe(), thoiGian, soTien };
					model.addRow(row);
				}
			}
		}
	};

	ActionListener huyKhoangTG = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			selectDanhSach();
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
				String maMay = cboMayATM.getSelectedItem().toString();
				int soNgay = connectBaoCaoATM.tinhKhoangTG(batDau, ketThuc);

				if (maMay.equals("Không có máy nào")) {
					JOptionPane.showMessageDialog(null, "Bạn chưa chọn máy ATM");
				} else {
					if (batDau.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày bắt đầu");
					} else if (ketThuc.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày Kết thúc");
					} else if (soNgay < 0) {
						JOptionPane.showMessageDialog(null, "Ngày bắt đầu ko nhỏ hơn ngày kết thúc");
					} else if (soNgay > 30) {
						JOptionPane.showMessageDialog(null, "Khoảng thời gian không quá 30 ngày");
					} else {
						arrBC.clear();
						model.setRowCount(0);
						arrBC = connectBaoCaoATM.selectATMTheoKhoangTG(maMay, batDau, ketThuc);
						if (arrBC.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Không có giao dịch nào trong Khoảng thời gian này");

						} else {
							for (GiaoDich bc : arrBC) {
								DecimalFormat formatter = new DecimalFormat("###,###,###");
								String soTien = formatter.format(Integer.parseInt(bc.getSoTien())) + " VNĐ";
								SimpleDateFormat dfNew = new SimpleDateFormat("HH:mm a ,EEEEE ,dd/MM/yyyy ",
										new Locale("vi", "VN"));
								SimpleDateFormat dfOld = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
								String thoiGian = "";
								try {
									thoiGian = dfNew.format(dfOld.parse(bc.getThoiGian()));
								} catch (ParseException ex) {
									ex.printStackTrace();
								}
								String[] row = { bc.getMaGD(), bc.getSoThe(), thoiGian, soTien };
								model.addRow(row);
							}
						}

					}
				}
			} catch (Exception ex) {

			}
		}
	};
	ActionListener selectATMTheoThang = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			String thang = cboThang.getSelectedItem().toString();
			String nam = cboNam.getSelectedItem().toString();
			String thangNam = nam + "-" + thang;
			String maMay = cboMayATM.getSelectedItem().toString();
			if (maMay.equals("Không có máy nào")) {
				JOptionPane.showMessageDialog(null, "Bạn chưa chọn máy ATM");
			} else {
				model.setRowCount(0);
				arrBC.clear();
				arrBC = connectBaoCaoATM.selectATMTheoThang(thangNam, maMay);
				if (arrBC.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Không có giao dịch nào trong Khoảng thời gian này");
				} else {
					for (GiaoDich bc : arrBC) {
						DecimalFormat formatter = new DecimalFormat("###,###,###");
						String soTien = formatter.format(Integer.parseInt(bc.getSoTien())) + " VNĐ";
						SimpleDateFormat dfNew = new SimpleDateFormat("HH:mm a ,EEEEE ,dd/MM/yyyy ",
								new Locale("vi", "VN"));
						SimpleDateFormat dfOld = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						String thoiGian = "";
						try {
							thoiGian = dfNew.format(dfOld.parse(bc.getThoiGian()));
						} catch (ParseException ex) {
							ex.printStackTrace();
						}

						String[] row = { bc.getMaGD(), bc.getSoThe(), thoiGian, soTien };
						model.addRow(row);
					}
				}
			}
		}
	};
	ActionListener selectDanhSachATM = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			selectDanhSach();
		}
	};

	public void selectDanhSach() {
		try {
			String duong = cboDuongPho.getSelectedItem().toString();
			@SuppressWarnings("unused")
			String phuong = cboPhuong.getSelectedItem().toString();
			String maMay = cboMayATM.getSelectedItem().toString();

			if (duong.equals("Chưa đặt máy tại đây") && maMay.equals("Không có máy nào")) {

				arrTK.clear();
				model.setRowCount(0);
			} else {

				arrTK.clear();
				model.setRowCount(0);
				arrBC = connectBaoCaoATM.selectDanhSachRutTienKH(maMay);

				for (GiaoDich bc : arrBC) {

					DecimalFormat formatter = new DecimalFormat("###,###,###");
					String soTien = formatter.format(Integer.parseInt(bc.getSoTien())) + " VNĐ";
					SimpleDateFormat dfNew = new SimpleDateFormat("HH:mm a ,EEEEE ,dd/MM/yyyy ",
							new Locale("vi", "VN"));
					SimpleDateFormat dfOld = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String thoiGian = "";
					try {
						thoiGian = dfNew.format(dfOld.parse(bc.getThoiGian()));
					} catch (ParseException ex) {
						ex.printStackTrace();
					}

					String[] row = { bc.getMaGD(), bc.getSoThe(), thoiGian, soTien };
					model.addRow(row);
				}

			}
		} catch (Exception ex) {

		}
	}

	ActionListener selectMayATM = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			selectMaMay();
		}
	};
	ActionListener selectDuongPho = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			selectDuongPho();
		}
	};
	ActionListener selectPhuong = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			selectPhuong();
		}
	};

	@SuppressWarnings("unchecked")
	public void selectPhuong() {
		try {
			arrPhuong.clear();
			int itemCount = cboPhuong.getItemCount();

			for (int i = 0; i < itemCount; i++) {
				cboPhuong.removeItemAt(0);
			}
			ComboItem itemD = (ComboItem) cboQuan.getSelectedItem();
			int id = itemD.getId();
			arrPhuong = DatabaseDiaChi.getPhuonng(id);

			for (ComboItem x : arrPhuong) {
				cboPhuong.addItem(x);
			}
		} catch (Exception ex) {

		}
	}

	@SuppressWarnings("unchecked")
	public void selectDuongPho() {
		try {
			arrDuongPho.clear();
			int itemCount = cboDuongPho.getItemCount();

			for (int i = 0; i < itemCount; i++) {
				cboDuongPho.removeItemAt(0);
			}
			ComboItem itemD = (ComboItem) cboPhuong.getSelectedItem();
			String namePhuong = itemD.getName();
			arrDuongPho = DatabaseBaoCaoATM.getDuongPho(namePhuong);
			if (arrDuongPho.isEmpty()) {
				cboDuongPho.addItem("Chưa đặt máy tại đây");
			} else {

				for (String x : arrDuongPho) {
					cboDuongPho.addItem(x);
				}
			}
		} catch (Exception ex) {

		}
	}

	@SuppressWarnings("unchecked")
	public void selectMaMay() {

		try {
			arrMaATM.clear();
			int itemCount = cboMayATM.getItemCount();

			for (int i = 0; i < itemCount; i++) {
				cboMayATM.removeItemAt(0);
			}
			String duongPho = cboDuongPho.getSelectedItem().toString();
			if (duongPho.equals("Chưa đặt máy tại đây")) {
				cboMayATM.addItem("Không có máy nào");
			} else {

				String name = cboDuongPho.getSelectedItem().toString();
				arrMaATM = DatabaseBaoCaoATM.getMaMay(name);
				if (arrMaATM.isEmpty()) {
					cboMayATM.addItem("Không có máy nào");
				} else {

					for (String x : arrMaATM) {

						cboMayATM.addItem(x);
					}
				}
			}
		} catch (Exception ex) {

		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void addControl() {

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setOpaque(false);
		// panel chọn combobox
		JPanel pnKhuVuc = new JPanel();
		pnKhuVuc.setOpaque(false);
		Border borderKV = BorderFactory.createLineBorder(Color.blue);

		TitledBorder borderTitleKV = BorderFactory.createTitledBorder(borderKV, "Khu vực", TitledBorder.CENTER,
				TitledBorder.DEFAULT_POSITION);
		pnKhuVuc.setBorder(borderTitleKV);
		JLabel nameQuan = new JLabel("Quận: ");
		nameQuan.setPreferredSize(new Dimension(40, 20));
		cboQuan = new JComboBox<>();
		cboQuan.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		cboQuan.setPreferredSize(new Dimension(120, 20));
		@SuppressWarnings("unused")
		ArrayList<ComboItem> arrQuan = new ArrayList<>();
		ArrayList<ComboItem> quan = new ArrayList<>();
		quan = DatabaseDiaChi.getQuan();
		for (ComboItem x : quan) {
			cboQuan.addItem(x);
		}
		JLabel namePhuong = new JLabel("Phường: ");
		namePhuong.setPreferredSize(new Dimension(60, 20));
		cboPhuong = new JComboBox<>();
		cboPhuong.setPreferredSize(new Dimension(140, 20));
		cboPhuong.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));

		JLabel nameDuongPho = new JLabel("Đường phố: ");
		nameDuongPho.setPreferredSize(new Dimension(80, 20));
		cboDuongPho = new JComboBox<>();
		cboDuongPho.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		cboDuongPho.setPreferredSize(new Dimension(140, 20));

		JLabel nameMayATM = new JLabel("Máy ATM: ");
		nameMayATM.setPreferredSize(new Dimension(60, 20));
		cboMayATM = new JComboBox<>();
		cboMayATM.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		cboMayATM.setPreferredSize(new Dimension(140, 20));

		pnKhuVuc.add(nameQuan);
		pnKhuVuc.add(cboQuan);
		pnKhuVuc.add(namePhuong);
		pnKhuVuc.add(cboPhuong);
		pnKhuVuc.add(nameDuongPho);
		pnKhuVuc.add(cboDuongPho);
		pnKhuVuc.add(nameMayATM);
		pnKhuVuc.add(cboMayATM);

		// PANEL CHỌN kiểu thời gian
		JPanel pnThoiGian = new JPanel();
		pnThoiGian.setOpaque(false);
		Border border1 = BorderFactory.createLineBorder(Color.blue);
		TitledBorder borderTitle1 = BorderFactory.createTitledBorder(border1, "Thống kê theo thời gian",
				TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
		pnThoiGian.setBorder(borderTitle1);
		JPanel pnRadio = new JPanel();
		pnRadio.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.blue));
		pnRadio.setOpaque(false);
		pnRadio.setLayout(new BoxLayout(pnRadio, BoxLayout.Y_AXIS));
		JRadioButton r1 = new JRadioButton("1 Tháng/năm");
		r1.setPreferredSize(new Dimension(200, 20));
		r1.setSelected(true);
		r1.setOpaque(false);
		r1.setBounds(50, 100, 70, 30);
		JRadioButton r2 = new JRadioButton("Khảng thời gian");
		r2.setPreferredSize(new Dimension(200, 20));
		r2.setBounds(50, 150, 70, 30);
		r2.setOpaque(false);

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
		btnHuyThang = new JButton("hủy");
		btnHuyThang.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));

		pnThang.add(nameThang);
		pnThang.add(cboThang);
		pnThang.add(nameNam);
		pnThang.add(cboNam);
		pnThang.add(btnSubmitThang);
		pnThang.add(btnHuyThang);

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
		btnHuyKhoangTG = new JButton("huy");
		btnHuyKhoangTG.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		JPanel pnKhoangTG = new JPanel();
		pnKhoangTG.setOpaque(false);

		pnKhoangTG.add(nameDateStart);
		pnKhoangTG.add(dateStart);
		pnKhoangTG.add(nameDateEnd);
		pnKhoangTG.add(dateEnd);
		pnKhoangTG.add(btnSubmidKhoangTG);
		pnKhoangTG.add(btnHuyKhoangTG);

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
		JPanel pnTableGiaoDich = new JPanel();
		pnTableGiaoDich.setOpaque(false);
		Border border11 = BorderFactory.createLineBorder(Color.blue);
		TitledBorder borderTitle11 = BorderFactory.createTitledBorder(border11, "Danh Sách Giao Dịch",
				TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
		pnTableGiaoDich.setBorder(borderTitle11);
		model = new DefaultTableModel();
		tblDanhSachMayATM = new JTable(model);
		tblDanhSachMayATM.setLayout(new BorderLayout());
		model.addColumn("Mã Giao Dịch");
		model.addColumn("Số thẻ ");
		model.addColumn("Thời gian");
		model.addColumn("Số tiền rút");

		// đưa dữ liệu qua bên phải
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
		tblDanhSachMayATM.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
		tblDanhSachMayATM.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);

		JScrollPane scroll = new JScrollPane(tblDanhSachMayATM);
		scroll.setOpaque(false);
		scroll.getViewport().setOpaque(false);
		scroll.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode("#191970")));
		pnTableGiaoDich.setLayout(new BorderLayout());
		pnTableGiaoDich.add(scroll, BorderLayout.CENTER);

		this.add(pnKhuVuc);
		this.add(pnThoiGian);
		this.add(pnSapxep);
		this.add(pnTableGiaoDich);

		selectPhuong();
		selectDuongPho();
		selectMaMay();

	}

}
