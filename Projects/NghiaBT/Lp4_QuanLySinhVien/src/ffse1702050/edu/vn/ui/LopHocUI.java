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
public class LopHocUI extends JPanel {
	

	private static final long serialVersionUID = 1L;
	private JPanel  pnLophoc, pnLophocbutton;
	private DefaultTableModel dm_lophoc;
	private JTable table_lophoc;
	private JScrollPane sc_lophoc;
	private JScrollPane sp_lophoc;
	private JTextField maLop = new JTextField(),
					   namHoc = new JTextField(),
					   moTa = new JTextField();
	private ArrayList<LophocModel> arrLop = new ArrayList<LophocModel>();
	private JComboBox<String> maLopcomnoBox = new JComboBox<>();
	private Button ThemLop = new Button("Thêm");
	private Button SuaLop = new Button("Sửa");
	private Button XoaLop = new Button("Xóa");
	public LopHocUI() {
		addControls();
		addEvent();
	}
	public void addControls() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setLayout(new BorderLayout());
		Border border = BorderFactory.createLineBorder(Color.BLUE);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Danh sách");
		this.setBorder(borderTitle);
		dm_lophoc = new DefaultTableModel();
		dm_lophoc.addColumn("Mã lớp");
		dm_lophoc.addColumn("Mô tả");
		dm_lophoc.addColumn("Năm học");
		Connection conn = ConnectData.getConnect("localhost", "Lp4", "Lp4", "12345");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM lp4_class");
			while (result.next()) {
				arrLop.add(new LophocModel(result.getString("MaLop"), result.getString("MoTa"),
						result.getString("NamHoc")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (LophocModel x : arrLop) {
			String[] row = { x.getMaLop(), x.getMoTa(), x.getNamHoc() };
			dm_lophoc.addRow(row);
		}
		table_lophoc = new JTable(dm_lophoc);
		table_lophoc.setLayout(new BorderLayout());
		sp_lophoc = new JScrollPane(table_lophoc);
		sc_lophoc = new JScrollPane(sp_lophoc, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc_lophoc.setPreferredSize(new Dimension(470, 180));
		this.add(sc_lophoc);

		pnLophoc = new JPanel();
//		Border nhapthongtin = BorderFactory.createLineBorder(Color.RED);
		pnLophoc.setLayout(new FlowLayout());
		pnLophoc = new JPanel();
		Border border2 = BorderFactory.createLineBorder(Color.BLUE);
		TitledBorder borderTitle2 = BorderFactory.createTitledBorder(border2);
		pnLophoc.setBorder(borderTitle2);
		pnLophoc.setLayout(new FlowLayout());

		JPanel pnLeft = new JPanel();
		pnLeft.setLayout(new BoxLayout(pnLeft, BoxLayout.Y_AXIS));

		JPanel nhapmaLop = new JPanel();
		nhapmaLop.setLayout(new FlowLayout());
		JLabel lblNhapmaLop = new JLabel("Mã lớp:");
		maLop = new JTextField(20);
		nhapmaLop.add(lblNhapmaLop);
		nhapmaLop.add(maLop);
		pnLeft.add(nhapmaLop);
		;

		JPanel nhapNamhoc = new JPanel();
		nhapNamhoc.setLayout(new FlowLayout());
		JLabel lblNhapNamhoc = new JLabel("Năm học:");
		namHoc = new JTextField(20);
		nhapNamhoc.add(lblNhapNamhoc);
		nhapNamhoc.add(namHoc);
		pnLeft.add(nhapNamhoc);

		JPanel nhapMota = new JPanel();
		nhapMota.setLayout(new FlowLayout());
		JLabel lblNhapMota = new JLabel("Mô tả      :");
		moTa = new JTextField(20);
		nhapMota.add(lblNhapMota);
		nhapMota.add(moTa);
		pnLeft.add(nhapMota);

		pnLophocbutton = new JPanel();
		//Border border4 = BorderFactory.createLineBorder(Color.BLUE);
		//TitledBorder borderTitle4 = BorderFactory.createTitledBorder(border4);
		//pnLophocbutton.setBorder(borderTitle4);
		pnLophocbutton.setLayout(new FlowLayout());
		JPanel chucnang = new JPanel();
		chucnang.setLayout(new BoxLayout(chucnang, BoxLayout.X_AXIS));
		pnLophocbutton.setPreferredSize(new Dimension(200, 100));
		pnLophocbutton.add(ThemLop);
		pnLophocbutton.add(SuaLop);
		pnLophocbutton.add(XoaLop);

		pnLophoc.add(pnLeft);
		pnLophocbutton.add(chucnang);
		pnLophoc.add(pnLophocbutton);
		this.add(pnLophoc, BorderLayout.SOUTH);

	}

	public void maLopcomnoBox() {
		Connection conn = ConnectData.getConnect("localhost", "Lp4", "Lp4", "12345");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM lp4_class");
			while (result.next()) {
				maLopcomnoBox.addItem(new String(result.getString("MaLop")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void addEvent() {

		table_lophoc.addMouseListener(eventTable_lophoc);
		ThemLop.addActionListener(eventAdd_lop);
		XoaLop.addActionListener(eventDel_lop);
		SuaLop.addActionListener(eventEdit_lop);

	}

	MouseAdapter eventTable_lophoc = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int row = table_lophoc.getSelectedRow();
			String[] col = new String[3];
			col[0] = (String) table_lophoc.getValueAt(row, 0);
			col[1] = (String) table_lophoc.getValueAt(row, 1);
			col[2] = (String) table_lophoc.getValueAt(row, 2);
			maLop.setText(col[0]);
			moTa.setText(col[1]);
			namHoc.setText(col[2]);
		}
	};

	ActionListener eventAdd_lop = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			String lop = maLop.getText();
			String mota = moTa.getText();
			String nam = namHoc.getText();
			
				if (lop.isEmpty() || mota.isEmpty() || nam.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Bạn chưa nhập thông tin");
				}
				else {
				arrLop.add(new LophocModel(lop, mota, nam));
				dm_lophoc.addRow(new String[] { lop, mota, nam });
				Connection conn = ConnectData.getConnect("localhost", "Lp4", "Lp4", "12345");
				try {
					String sql = "INSERT INTO lp4_class (maLop,moTa,namHoc) VALUES (" + "'" + lop + "','" + mota + "','"
							+ nam + "')";
					Statement statement = conn.createStatement();
					int x = statement.executeUpdate(sql);
					if (x > 0) {
						JOptionPane.showMessageDialog(null, "Đã lưu thông tin sinh viên");
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				}
			dm_lophoc.setRowCount(0);
			for (LophocModel x : arrLop) {
				String[] row = { x.getMaLop(), x.getMoTa(), x.getNamHoc() };
				dm_lophoc.addRow(row);
			}

			maLop.setText("");
			moTa.setText("");
			namHoc.setText("");
			}
	};

	ActionListener eventDel_lop = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			for (LophocModel x : arrLop) {
				if (maLop.getText().equals(x.getMaLop())) {
					arrLop.remove(x);
					break;
				}
			}
			Connection conn = ConnectData.getConnect("localhost", "Lp4", "Lp4", "12345");
			try {
				String sql = "DELETE FROM lp4_class WHERE maLop = '" + maLop.getText() + "'";
				Statement statement = conn.createStatement();
				int x = statement.executeUpdate(sql);
				if (x >= 0) {
					JOptionPane.showMessageDialog(null, "Đã sửa thông tin môn học");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			dm_lophoc.setRowCount(0);
			for (LophocModel x : arrLop) {
				String[] row = { x.getMaLop(), x.getMoTa(), x.getNamHoc() };
				dm_lophoc.addRow(row);
			}
		}

	};

	ActionListener eventEdit_lop = new ActionListener() {

		public void actionPerformed(ActionEvent arg0) {
			
			for (LophocModel x : arrLop) {
				if (maLop.getText().equals(x.getMaLop())) {
					x.setMoTa(moTa.getText());
					x.setNamHoc(namHoc.getText());
					break;
				}
			}
			Connection conn = ConnectData.getConnect("localhost", "Lp4", "Lp4", "12345");
			try {
				String sql = "UPDATE lp4_class SET NamHoc ='" + namHoc.getText() + "',MoTa ='" + moTa.getText()
						+ "' WHERE MaLop = '" + maLop.getText() + "'";
				Statement statement = conn.createStatement();
				int x = statement.executeUpdate(sql);
				if (x >= 0) {
					JOptionPane.showMessageDialog(null, "Đã sửa thông tin môn học");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			dm_lophoc.setRowCount(0);
			for (LophocModel x : arrLop) {
				String[] row = { x.getMaLop(), x.getMoTa(), x.getNamHoc() };
				dm_lophoc.addRow(row);
			}

		}

	};
}