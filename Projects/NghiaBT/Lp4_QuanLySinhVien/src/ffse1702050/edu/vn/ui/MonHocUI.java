package ffse1702050.edu.vn.ui;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import ffse1702050.edu.vn.model.*;
import ffse1702050.edu.vn.connectData.*;
public class MonHocUI extends JPanel {
	private static final long serialVersionUID = 1L;
	private JPanel  pnMonhoc, pnMonhocbutton; 
	private DefaultTableModel dm_monhoc;
	private JTable table_monhoc;
	private JScrollPane sp_monhoc;
	private JTextField maMonhoc = new JTextField(), Ten = new JTextField(), soTinhChi = new JTextField(),
			Thoiluonghoc = new JTextField();
	private ArrayList<MonHoc> arrMH = new ArrayList<MonHoc>();
	private Button ThemMon = new Button("Thêm");
	private Button SuaMon = new Button("Sửa");
	private Button XoaMon = new Button("Xóa");

	public MonHocUI() {
		addControls();
		addEvent();
	}

	public void addControls() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setLayout(new BorderLayout());
		Border bordermonhoc = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitlemonhoc = BorderFactory.createTitledBorder(bordermonhoc, "Danh sách");
		this.setBorder(borderTitlemonhoc);
		dm_monhoc = new DefaultTableModel();
		dm_monhoc.addColumn("Mã môn học");
		dm_monhoc.addColumn("Tên môn học");
		dm_monhoc.addColumn("Số tính chỉ");
		dm_monhoc.addColumn("Thời lượng học");
		Connection conn = ConnectData.getConnect("localhost", "Lp4", "Lp4", "12345");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM lp4_monhoc");
			while (result.next()) {
				arrMH.add(new MonHoc(result.getString("MaMH"), result.getString("Ten"),
						result.getString("SoTinhChi"), result.getString("ThoiLuongHoc")));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (MonHoc x : arrMH) {
			String[] row = { x.getMaMH(), x.getTen(), x.getSoTinhChi(), x.getThoiLuongHoc() };
			dm_monhoc.addRow(row);
		}

		table_monhoc = new JTable(dm_monhoc);
		table_monhoc.setLayout(new BorderLayout());
		sp_monhoc = new JScrollPane(table_monhoc);
		sp_monhoc = new JScrollPane(table_monhoc, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp_monhoc.setPreferredSize(new Dimension(470, 180));
		this.add(sp_monhoc);

		pnMonhoc = new JPanel();
		Border border2monhoc = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle2monhoc = BorderFactory.createTitledBorder(border2monhoc);
		pnMonhoc.setBorder(borderTitle2monhoc);
		pnMonhoc.setLayout(new FlowLayout());

		JPanel pnLeftmonhoc = new JPanel();
		pnLeftmonhoc.setLayout(new BoxLayout(pnLeftmonhoc, BoxLayout.Y_AXIS));

		JPanel nhapmaMonhoc = new JPanel();
		JLabel lblNhapmaMonhoc = new JLabel("Mã môn học:");
		maMonhoc = new JTextField(20);
		nhapmaMonhoc.add(lblNhapmaMonhoc);
		nhapmaMonhoc.add(maMonhoc);
		pnLeftmonhoc.add(nhapmaMonhoc);

		JPanel nhaptenMonhoc = new JPanel();
		JLabel lblNhaptenMonhoc = new JLabel("Tên môn học:");
		Ten = new JTextField(20);
		nhaptenMonhoc.add(lblNhaptenMonhoc);
		nhaptenMonhoc.add(Ten);
		pnLeftmonhoc.add(nhaptenMonhoc);

		JPanel nhapSotinhchi = new JPanel();
		JLabel lblSotinhchi = new JLabel("Số tính chỉ:");
		soTinhChi = new JTextField(20);
		nhapSotinhchi.add(lblSotinhchi);
		nhapSotinhchi.add(soTinhChi);
		pnLeftmonhoc.add(nhapSotinhchi);

		JPanel nhapThoiluonghoc = new JPanel();
		JLabel lblNhapthoiluonghoc = new JLabel("Thời lượng học:");
		Thoiluonghoc = new JTextField(20);
		nhapThoiluonghoc.add(lblNhapthoiluonghoc);
		nhapThoiluonghoc.add(Thoiluonghoc);
		pnLeftmonhoc.add(nhapThoiluonghoc);

		pnMonhocbutton = new JPanel();
		Border border4monhoc = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle4monhoc = BorderFactory.createTitledBorder(border4monhoc);
		pnMonhocbutton.setBorder(borderTitle4monhoc);
		pnMonhocbutton.setLayout(new FlowLayout());
		JPanel chucnangmonhoc = new JPanel();
		chucnangmonhoc.setLayout(new BoxLayout(chucnangmonhoc, BoxLayout.X_AXIS));
		pnMonhocbutton.setPreferredSize(new Dimension(200, 100));
		pnMonhocbutton.add(ThemMon);
		pnMonhocbutton.add(SuaMon);
		pnMonhocbutton.add(XoaMon);

		pnMonhocbutton.add(chucnangmonhoc);
		pnMonhoc.add(pnLeftmonhoc);
		pnMonhoc.add(pnMonhocbutton);
		this.add(pnMonhoc, BorderLayout.SOUTH);
	}

	public void addEvent() {

		table_monhoc.addMouseListener(eventTable_Monhoc);
		ThemMon.addActionListener(eventAdd_Mon);
		XoaMon.addActionListener(eventDel_Mon);
		SuaMon.addActionListener(eventEdit_Mon);

	}

	MouseAdapter eventTable_Monhoc = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int row = table_monhoc.getSelectedRow();
			String[] col = new String[4];
			col[0] = (String) table_monhoc.getValueAt(row, 0);
			col[1] = (String) table_monhoc.getValueAt(row, 1);
			col[2] = (String) table_monhoc.getValueAt(row, 2);
			col[3] = (String) table_monhoc.getValueAt(row, 3);
			maMonhoc.setText(col[0]);
			Ten.setText(col[1]);
			soTinhChi.setText(col[2]);
			Thoiluonghoc.setText(col[3]);

		}
	};

	ActionListener eventAdd_Mon = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String ma_MonHoc = maMonhoc.getText();
			String ten_MonHoc = Ten.getText();
			String tinchi_MonHoc = soTinhChi.getText();
			String time_MonHoc = Thoiluonghoc.getText();

			try {
				if (ma_MonHoc.equals("") || ten_MonHoc.equals("") || tinchi_MonHoc.equals("")
						|| time_MonHoc.equals("")) {
					JOptionPane.showMessageDialog(null, "Bạn chưa nhập thông tin");
				} else {
					arrMH.add(new MonHoc(ma_MonHoc, ten_MonHoc, tinchi_MonHoc, time_MonHoc));
					dm_monhoc.addRow(new String[] { ma_MonHoc, ten_MonHoc, tinchi_MonHoc, time_MonHoc });
					Connection conn = ConnectData.getConnect("localhost", "Lp4", "Lp4", "12345");
					try {
						String sql = "INSERT INTO lp4_monhoc( MaMH, Ten , SoTinhChi, ThoiLuongHoc) VALUES ('"
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

			maMonhoc.setText("");
			Ten.setText("");
			soTinhChi.setText("");
			Thoiluonghoc.setText("");
		}
	};

	ActionListener eventDel_Mon = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			for (MonHoc x : arrMH) {
				if ((maMonhoc.getText()).equals(x.getMaMH())) {
					arrMH.remove(x);
					break;
				}
			}
			Connection conn = ConnectData.getConnect("localhost", "Lp4", "Lp4", "12345");
			try {
				String sql = "DELETE FROM lp4_monhoc WHERE MaMH = '" + maMonhoc.getText() + "'";
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
				String[] row = { x.getMaMH(), x.getTen(), x.getSoTinhChi(), x.getThoiLuongHoc() };
				dm_monhoc.addRow(row);
			}

		}

	};

	ActionListener eventEdit_Mon = new ActionListener() {

		public void actionPerformed(ActionEvent arg0) {
			for (MonHoc x : arrMH) {
				if (maMonhoc.getText().equals(x.getMaMH())) {
					x.setTen(Ten.getText());
					x.setSoTinhChi(soTinhChi.getText());
					x.setThoiLuongHoc(Thoiluonghoc.getText());
					break;
				}
			}
			Connection conn = ConnectData.getConnect("localhost", "Lp4", "Lp4", "12345");
			try {
				String sql = "UPDATE lp4_monhoc SET Ten ='" + Ten.getText() + "',SoTinhChi ='" + soTinhChi.getText()
						+ "',ThoiLuongHoc ='" + Thoiluonghoc.getText() + "' WHERE MaMH = '" + maMonhoc.getText() + "'";
				Statement statement = conn.createStatement();
				int x = statement.executeUpdate(sql);
				if (x >= 0) {
					JOptionPane.showMessageDialog(null, "Đã sửa thông tin sinh viên");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			dm_monhoc.setRowCount(0);
			for (MonHoc x : arrMH) {
				String[] row = { x.getMaMH(), x.getTen(), x.getSoTinhChi(), x.getThoiLuongHoc() };
				dm_monhoc.addRow(row);
			}
		}
	};

}