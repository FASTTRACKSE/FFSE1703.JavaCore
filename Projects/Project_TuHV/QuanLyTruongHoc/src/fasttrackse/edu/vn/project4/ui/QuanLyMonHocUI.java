package fasttrackse.edu.vn.project4.ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import fasttrackse.edu.vn.project4.model.Connect;
import fasttrackse.edu.vn.project4.model.MonHoc;

public class QuanLyMonHocUI extends JPanel {
	public QuanLyMonHocUI() {
		addControls();
		addEvent();
	}

	private static final long serialVersionUID = 1L;
	// mon
	@SuppressWarnings("unused")
	private JTextField malophoc = new JTextField(15);
	private JTextField mamonhoc = new JTextField(15);
	private JTextField tenmonhoc = new JTextField(15);
	private JTextField soTC = new JTextField(15);
	private JTextField thoiluong = new JTextField(15);

	private ArrayList<MonHoc> arrMH = new ArrayList<MonHoc>();

	int stt = 0;

	DefaultTableModel dm_monhoc;

	JTable tbl_monhoc;

	CardLayout cardlayout;

	private JPanel pnCenter3 = new JPanel();

	@SuppressWarnings("unused")
	private JPanel pnBorder3 = new JPanel();

	private JButton btnThemmon = new JButton("Thêm");
	private JButton btnSuamon = new JButton("Sửa");
	private JButton btnXoamon = new JButton("Xoá");
	private JButton btnNhapmon = new JButton("Reset");

	public void addControls() {

		// quản lý môn học

		this.setLayout(new BorderLayout());
		JLabel lblmon = new JLabel("Chương Trình Quản Lý Môn Học");
		Font fontmon = new Font("Arial", Font.BOLD, 24);
		lblmon.setFont(fontmon);

		JPanel pnNorth3 = new JPanel();
		pnNorth3.setBackground(Color.blue);
		pnNorth3.add(lblmon);
		pnCenter3.add(pnNorth3, BorderLayout.NORTH);

		JPanel pnSouth3 = new JPanel();
		pnSouth3.setBackground(Color.blue);
		this.add(pnSouth3, BorderLayout.SOUTH);

		pnCenter3.setLayout(new BoxLayout(pnCenter3, BoxLayout.Y_AXIS));

		JPanel pnbutton3 = new JPanel();
		pnbutton3.setLayout(new FlowLayout());
		pnbutton3.add(btnThemmon);
		pnbutton3.add(btnSuamon);
		pnbutton3.add(btnXoamon);
		pnbutton3.add(btnNhapmon);
		pnCenter3.add(pnbutton3);

		JPanel pnCombo3 = new JPanel();
		pnCombo3.setLayout(new FlowLayout());

		JPanel pnnhap3 = new JPanel();
		pnnhap3.setLayout(new FlowLayout());
		JPanel pnLeft3 = new JPanel();
		pnLeft3.setLayout(new BoxLayout(pnLeft3, BoxLayout.X_AXIS));

		JLabel lbl5mon = new JLabel("  Mã Môn Học :");
		pnLeft3.add(lbl5mon);
		pnLeft3.add(mamonhoc);
		pnnhap3.add(pnLeft3);

		JPanel pnnhapp = new JPanel();
		pnnhapp.setLayout(new FlowLayout());
		JPanel pnGiua3 = new JPanel();
		pnGiua3.setLayout(new BoxLayout(pnGiua3, BoxLayout.X_AXIS));
		JLabel lbl6mon = new JLabel("Tên Môn Học :");
		pnGiua3.add(lbl6mon);
		pnGiua3.add(tenmonhoc);

		JLabel lbl4mon = new JLabel("             Số Tín Chỉ:");
		pnGiua3.add(lbl4mon);
		pnGiua3.add(soTC);
		pnnhapp.add(pnGiua3);

		JLabel lbl7mon = new JLabel("Thời Lượng Học :");
		pnGiua3.add(lbl7mon);
		pnGiua3.add(thoiluong);
		pnnhapp.add(pnGiua3);

		pnCenter3.add(pnnhap3);
		pnCenter3.add(pnnhapp);
		pnCenter3.setBackground(Color.white);
		this.add(pnCenter3, BorderLayout.CENTER);
		// getContentPane().add(pnBorder3);

		JPanel pnTable3 = new JPanel();
		dm_monhoc = new DefaultTableModel();

		dm_monhoc.addColumn("Mã Môn Học");
		dm_monhoc.addColumn("Tên Môn Học");
		dm_monhoc.addColumn("Số Tín Chỉ");
		dm_monhoc.addColumn("Thời Lượng Học");
		try {
			Connection conn = Connect.getConnect("localhost", "project4", "viettu", "12345");
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM quan_ly_mon_hoc");
			while (result.next()) {
				arrMH.add(new MonHoc(result.getString("ma_mon_hoc"), result.getString("ten"),
						result.getString("so_tin_chi"), result.getString("thoi_luong_hoc")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (MonHoc x : arrMH) {
			String[] row = { x.getMaMH(), x.getTenMH(), x.getSoTC(), x.getThoiluonghoc() };
			dm_monhoc.addRow(row);
		}

		tbl_monhoc = new JTable(dm_monhoc);
		JScrollPane sc3 = new JScrollPane(tbl_monhoc);

		sc3.setPreferredSize(new Dimension(1170, 520));
		pnTable3.add(sc3, BorderLayout.CENTER);
		pnCenter3.add(pnTable3);

		Border border3 = BorderFactory.createLineBorder(Color.blue);
		TitledBorder borderTitle3 = BorderFactory.createTitledBorder(border3, "Danh sách môn học");
		pnTable3.setBorder(borderTitle3);
	}

	public void addEvent() {

		// môn học
		tbl_monhoc.addMouseListener(eventTable_monhoc);
		btnThemmon.addActionListener(Add_MH);
		btnXoamon.addActionListener(Del_MH);
		btnSuamon.addActionListener(Edit_MH);
		btnNhapmon.addActionListener(Reset_MH);

	}

	// mouseclick môn học
	MouseAdapter eventTable_monhoc = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int col = tbl_monhoc.getSelectedRow();
			String[] row = new String[4];
			row[0] = (String) tbl_monhoc.getValueAt(col, 0);
			row[1] = (String) tbl_monhoc.getValueAt(col, 1);
			row[2] = (String) tbl_monhoc.getValueAt(col, 2);
			row[3] = (String) tbl_monhoc.getValueAt(col, 3);

			mamonhoc.setText(row[0]);
			tenmonhoc.setText(row[1]);
			soTC.setText(row[2]);
			thoiluong.setText(row[3]);
			for (int i = 0; i < arrMH.size(); i++) {
				if (row[0].equals(arrMH.get(i).getMaMH())) {
					stt = i;
				}
			}
		}
	};

	// thêm môn học
	ActionListener Add_MH = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			boolean kt = false;

			String ma_MonHoc = mamonhoc.getText();
			String ten_MonHoc = tenmonhoc.getText();
			String tinchi_MonHoc = soTC.getText();
			String time_MonHoc = thoiluong.getText();
			for (MonHoc x : arrMH) {

				if (ma_MonHoc.equals(x.getMaMH()) || ten_MonHoc.equals(x.getTenMH())) {
					kt = true;
					break;
				}
			}

			try {
				if (mamonhoc.getText().isEmpty() || tenmonhoc.getText().isEmpty() || soTC.getText().isEmpty()
						|| thoiluong.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "XIN HÃY NHẬP ĐẦY ĐỦ THÔNG TIN!", null,
							JOptionPane.WARNING_MESSAGE);
				} else if (kt) {
					JOptionPane.showMessageDialog(null, "MÔN HỌC ĐÃ TỒN TẠI RỒI!", null, JOptionPane.WARNING_MESSAGE);

				} else {
					arrMH.add(new MonHoc(ma_MonHoc, ten_MonHoc, tinchi_MonHoc, time_MonHoc));
					dm_monhoc.addRow(new String[] { ma_MonHoc, ten_MonHoc, tinchi_MonHoc, time_MonHoc });
					Connection conn = Connect.getConnect("localhost", "project4", "viettu", "12345");
					try {
						String sql = "INSERT INTO quan_ly_mon_hoc( ma_mon_hoc, ten, so_tin_chi, thoi_luong_hoc) VALUES ('"
								+ ma_MonHoc + "','" + ten_MonHoc + "','" + tinchi_MonHoc + "','" + time_MonHoc + "')";
						Statement statement = conn.createStatement();
						int x = statement.executeUpdate(sql);
						if (x > 0) {
							JOptionPane.showMessageDialog(null, "Đã lưu thông tin sinh viên");
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Bạn cần nhập thông tin sinh viên");
			}

			mamonhoc.setText("");
			tenmonhoc.setText("");
			soTC.setText("");
			thoiluong.setText("");
		}
	};

	// xóa môn học
	ActionListener Del_MH = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			int kt = 0;
			for (MonHoc x : arrMH) {
				if (mamonhoc.getText().equals(x.getMaMH())) {
					kt = 2;
					arrMH.remove(x);
					break;
				}
			}
			if (mamonhoc.getText().isEmpty() || tenmonhoc.getText().isEmpty() || soTC.getText().isEmpty()
					|| thoiluong.getText().isEmpty()) {

				JOptionPane.showMessageDialog(null, "XIN HÃY NHẬP ĐẦY ĐỦ THÔNG TIN!", null,
						JOptionPane.WARNING_MESSAGE);
			} else if (kt < 1) {
				JOptionPane.showMessageDialog(null, "THÔNG TIN MÔN HỌC CHƯA XÓA ĐƯỢC", null,
						JOptionPane.WARNING_MESSAGE);
			} else {
				Connection conn = Connect.getConnect("localhost", "project4", "viettu", "12345");
				try {
					String sql = "DELETE FROM quan_ly_mon_hoc WHERE ma_mon_hoc = '" + mamonhoc.getText() + "'";
					Statement statement = conn.createStatement();
					int x = statement.executeUpdate(sql);
					if (x >= 0) {
						JOptionPane.showMessageDialog(null, "Đã xóa thông tin sinh viên");
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				dm_monhoc.setRowCount(0);
				for (MonHoc x : arrMH) {
					String[] row = { x.getMaMH(), x.getTenMH(), x.getSoTC(), x.getThoiluonghoc() };
					dm_monhoc.addRow(row);
				}
			}
		}

	};

	// sửa môn học
	ActionListener Edit_MH = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			int ktTonTai = 0;
			int kt = 0;
			@SuppressWarnings("unused")
			String tenMonHoc = tenmonhoc.getText();
			@SuppressWarnings("unused")
			String thoiLuongHoc = thoiluong.getText();
			@SuppressWarnings("unused")
			Integer tinChi1 = Integer.valueOf(soTC.getText());

			for (int i = 0; i < arrMH.size(); i++) {
				if (mamonhoc.getText().equals(arrMH.get(i).getMaMH())) {
					ktTonTai = 1;
				}
			}
			for (MonHoc x : arrMH) {
				if (mamonhoc.getText().equals(x.getMaMH())) {
					x.setTenMH(tenmonhoc.getText());
					x.setSoTC(soTC.getText());
					x.setThoiluonghoc(thoiluong.getText());
					kt = 2;
					break;
				}
			}
			try {
				if (mamonhoc.getText().isEmpty() || tenmonhoc.getText().isEmpty() || soTC.getText().isEmpty()
						|| thoiluong.getText().isEmpty()) {

					JOptionPane.showMessageDialog(null, "XIN HÃY NHẬP ĐẦY ĐỦ THÔNG TIN!", null,
							JOptionPane.WARNING_MESSAGE);
				} else if (ktTonTai < 1) {
					JOptionPane.showMessageDialog(null, "MÃ MÔN HỌC KHÔNG ĐƯỢC SỮA,HÃY THÊM MỚI", null,
							JOptionPane.WARNING_MESSAGE);
				} else if (kt == 2) {
					JOptionPane.showMessageDialog(null, "HÃY SỮA THÔNG TIN", null, JOptionPane.WARNING_MESSAGE);
				} else {
					Connection conn = Connect.getConnect("localhost", "project4", "viettu", "12345");
					try {
						String sql = "UPDATE quan_ly_mon_hoc SET ten ='" + tenmonhoc.getText() + "',so_tin_chi ='"
								+ soTC.getText() + "',thoi_luong_hoc ='" + thoiluong.getText()
								+ "' WHERE ma_mon_hoc = '" + mamonhoc.getText() + "'";
						Statement statement = conn.createStatement();
						int x = statement.executeUpdate(sql);
						if (x >= 0) {
							JOptionPane.showMessageDialog(null, "Đã sửa thông tin sinh viên");
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				dm_monhoc.setRowCount(0);
				for (MonHoc x : arrMH) {
					String[] row = { x.getMaMH(), x.getTenMH(), x.getSoTC(), x.getThoiluonghoc() };
					dm_monhoc.addRow(row);
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "BẠN CẦN NHẬP THÔNG TIN SINH VIÊN");
			}

		}
	};

	ActionListener Reset_MH = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			mamonhoc.setText("");
			tenmonhoc.setText("");
			soTC.setText("");
			thoiluong.setText("");
		}
	};

}
