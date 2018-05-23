package namdv.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class TraSachUI extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldSearch;
	private JTextField textFieldMaGiaoDich;
	private JTextField textFieldNgayMuon;
	private JTextField textFieldMaThanhVien;
	private JTable tableMuonSachResult;
	private JTable tableMaSachChuaTraDetail;
	private JTextField textFieldMaSachChuaTra;
	private JButton btnThoat;

	/**
	 * Create the panel.
	 */
	public TraSachUI() {
		addControls();
		addEvents();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void addControls() {
		// Search
		JPanel panelSearch = new JPanel();
		FlowLayout fl_panelSearch = (FlowLayout) panelSearch.getLayout();
		fl_panelSearch.setVgap(15);

		JComboBox cbBoxSearch = new JComboBox();
		cbBoxSearch.setModel(new DefaultComboBoxModel(new String[] { "Mã mượn", "Mã bạn đọc" }));
		panelSearch.add(cbBoxSearch);

		textFieldSearch = new JTextField(20);
		panelSearch.add(textFieldSearch);

		JButton btnTraSachSearch = new JButton("Tìm");
		panelSearch.add(btnTraSachSearch);

		// Thông tin trả sách
		JPanel panelThongTinTraSach = new JPanel();
		panelThongTinTraSach.setLayout(new BoxLayout(panelThongTinTraSach, BoxLayout.X_AXIS));

		// Chi tiết biên mượn
		JPanel panelChiTietBienMuon = new JPanel();
		panelThongTinTraSach.add(panelChiTietBienMuon);

		JPanel panelChiTietBienMuonBorder = new JPanel();
		panelChiTietBienMuonBorder.setPreferredSize(new Dimension(375, 325));
		panelChiTietBienMuonBorder.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Chi tiết biên mượn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelChiTietBienMuon.add(panelChiTietBienMuonBorder);
		panelChiTietBienMuonBorder.setLayout(new BoxLayout(panelChiTietBienMuonBorder, BoxLayout.Y_AXIS));

		JPanel panelMaGiaoDich = new JPanel();
		panelChiTietBienMuonBorder.add(panelMaGiaoDich);

		JLabel lblMaGiaoDich = new JLabel("Mã giao dịch: ");
		lblMaGiaoDich.setPreferredSize(new Dimension(90, 20));
		panelMaGiaoDich.add(lblMaGiaoDich);

		textFieldMaGiaoDich = new JTextField(20);
		textFieldMaGiaoDich.setEditable(false);
		panelMaGiaoDich.add(textFieldMaGiaoDich);

		JPanel panelNgayMuon = new JPanel();
		panelChiTietBienMuonBorder.add(panelNgayMuon);

		JLabel lblNgayMuon = new JLabel("Ngày mượn: ");
		lblNgayMuon.setPreferredSize(lblMaGiaoDich.getPreferredSize());
		panelNgayMuon.add(lblNgayMuon);

		textFieldNgayMuon = new JTextField(20);
		textFieldNgayMuon.setEditable(false);
		panelNgayMuon.add(textFieldNgayMuon);

		JPanel panelMaThanhVien = new JPanel();
		panelChiTietBienMuonBorder.add(panelMaThanhVien);

		JLabel lblMaThanhVien = new JLabel("Mã thành viên: ");
		lblMaThanhVien.setPreferredSize(lblMaGiaoDich.getPreferredSize());
		panelMaThanhVien.add(lblMaThanhVien);

		textFieldMaThanhVien = new JTextField(20);
		textFieldMaThanhVien.setEditable(false);
		panelMaThanhVien.add(textFieldMaThanhVien);

		JPanel panelMaSachMuon = new JPanel();
		panelChiTietBienMuonBorder.add(panelMaSachMuon);

		JLabel lblMaSachMuon = new JLabel("Mã sách mượn: ");
		lblMaSachMuon.setPreferredSize(lblMaGiaoDich.getPreferredSize());
		panelMaSachMuon.add(lblMaSachMuon);

		JTextPane textPaneMaSachMuon = new JTextPane();
		textPaneMaSachMuon.setBackground(SystemColor.menu);
		textPaneMaSachMuon.setEditable(false);
		textPaneMaSachMuon.setBorder(new LineBorder(SystemColor.activeCaptionBorder));
		textPaneMaSachMuon.setPreferredSize(new Dimension(165, 50));
		panelMaSachMuon.add(textPaneMaSachMuon);

		JPanel panelMaSachChuaTra = new JPanel();
		panelChiTietBienMuonBorder.add(panelMaSachChuaTra);
		panelMaSachChuaTra.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblMaSachChuaTra = new JLabel("Sách chưa trả: ");
		lblMaSachChuaTra.setPreferredSize(lblMaGiaoDich.getPreferredSize());
		panelMaSachChuaTra.add(lblMaSachChuaTra);

		textFieldMaSachChuaTra = new JTextField(20);
		textFieldMaSachChuaTra.setVisible(false);
		panelMaSachChuaTra.add(textFieldMaSachChuaTra);

		JPanel panelMaSachChuaTraDetail = new JPanel();
		panelChiTietBienMuonBorder.add(panelMaSachChuaTraDetail);

		JScrollPane scrollPaneMaSachChuaTraDetail = new JScrollPane();
		panelMaSachChuaTraDetail.add(scrollPaneMaSachChuaTraDetail);
		scrollPaneMaSachChuaTraDetail.setPreferredSize(new Dimension(350, 80));

		tableMaSachChuaTraDetail = new JTable();
		tableMaSachChuaTraDetail.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null }, { null, null, null }, { null, null, null }, },
				new String[] { "Mã sách", "Tên sách", "Tác giả" }));
		scrollPaneMaSachChuaTraDetail.setViewportView(tableMaSachChuaTraDetail);

		// Danh sách biên mượn
		JPanel panelDanhSachBienMuon = new JPanel();
		panelThongTinTraSach.add(panelDanhSachBienMuon);

		JPanel panelDanhSachBienMuonBorder = new JPanel();
		panelDanhSachBienMuonBorder.setPreferredSize(new Dimension(375, 325));
		panelDanhSachBienMuonBorder.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Danh sách biên mượn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelDanhSachBienMuon.add(panelDanhSachBienMuonBorder);

		JScrollPane scrollPaneMuonSachResult = new JScrollPane();
		scrollPaneMuonSachResult.setPreferredSize(new Dimension(350, 285));
		panelDanhSachBienMuonBorder.add(scrollPaneMuonSachResult);

		tableMuonSachResult = new JTable();
		tableMuonSachResult.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Mã giao dịch", "Ngày mượn", "Mã thành viên" }));
		scrollPaneMuonSachResult.setViewportView(tableMuonSachResult);

		// FOOTER
		JPanel panelTraSachFooter = new JPanel();
		panelTraSachFooter.setLayout(new BoxLayout(panelTraSachFooter, BoxLayout.X_AXIS));

		JPanel panelTraSachButton = new JPanel();
		panelTraSachFooter.add(panelTraSachButton);

		JButton btnTraSach = new JButton("Trả sách");
		panelTraSachButton.add(btnTraSach);

		JPanel panelThoat = new JPanel();
		panelTraSachFooter.add(panelThoat);

		btnThoat = new JButton("Thoát");
		panelThoat.add(btnThoat);

		// ADD TO JPANEL
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(panelSearch);
		this.add(panelThongTinTraSach);
		this.add(panelTraSachFooter);
	}

	private void addEvents() {
		btnThoat.addActionListener(new ThoatListener());
	}

	private class ThoatListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
}