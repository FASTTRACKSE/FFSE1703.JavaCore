package project.ui;

import project.connect.Connect;
import project.model.*;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
public class MonHocLopUI extends JPanel{

	private static final long serialVersionUID = 1L;
	private JTextField maMHLop = new JTextField();

	private ArrayList<MonHocLop> arrLopMH = new ArrayList<MonHocLop>();

	private JButton themMonHocLop = new JButton("Thêm");
	private JButton xoaMonHocLop = new JButton("Xóa");

	private JComboBox<String> selectMonHoc = new JComboBox<>();
	
	private DefaultTableModel dm_MonHoc_lop;
	private JTable table_MonHoc_lop;
	private JScrollPane sp_MonHoc_lop;
	
	CardLayout cardlayout = new CardLayout();
	JPanel ttSV = new JPanel();

	public MonHocLopUI() {
		lop(selectMonHoc);
		addControls();
		addEvent();
	}

	public void addControls() {
		// Quản lý môn học theo lớp

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel pnMH_lopMonHoc = new JPanel();
		pnMH_lopMonHoc.setLayout(new FlowLayout());

		JPanel nhapMaLop = new JPanel();
		nhapMaLop.setLayout(new FlowLayout());
		JLabel lblchonLop = new JLabel("Mã lớp học:");
		nhapMaLop.add(lblchonLop);
		nhapMaLop.add(selectMonHoc);
		pnMH_lopMonHoc.add(nhapMaLop);

		JPanel nhapMaMHLop = new JPanel();
		nhapMaMHLop.setLayout(new FlowLayout());
		JLabel lblNhapMaMHLop = new JLabel("Mã môn học:");
		maMHLop = new JTextField(12);
		nhapMaMHLop.add(lblNhapMaMHLop);
		nhapMaMHLop.add(maMHLop);
		pnMH_lopMonHoc.add(nhapMaMHLop);

		pnMH_lopMonHoc.add(themMonHocLop);
		pnMH_lopMonHoc.add(xoaMonHocLop);

		this.add(pnMH_lopMonHoc);

		JPanel Table_lopMonHoc = new JPanel();
		Table_lopMonHoc.setLayout(new BorderLayout());
		Border border_lopMonHoc = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle_lopMonHoc = BorderFactory.createTitledBorder(border_lopMonHoc, "Danh sách môn học");
		Table_lopMonHoc.setBorder(borderTitle_lopMonHoc);

		dm_MonHoc_lop = new DefaultTableModel();

		dm_MonHoc_lop.addColumn("Mã lớp học");
		dm_MonHoc_lop.addColumn("Mã môn học");
		dm_MonHoc_lop.addColumn("Tên môn học");
		dm_MonHoc_lop.addColumn("Tín chỉ");
		dm_MonHoc_lop.addColumn("Thời gian học");
		Connection conn = Connect.getConnect("localhost", "minhad", "minhad", "minh");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM monhoc");
			while (result.next()) {
				arrLopMH.add(new MonHocLop(result.getString("MaMH"), result.getString("Ten"),
						result.getString("TenLop"), result.getString("SoTC"), result.getString("thoigian")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (MonHocLop x : arrLopMH) {
			String[] row = { x.getTenLop(), x.getMaMH(), x.getTenMH(), x.getSoTC(), x.getThoigian() };
			dm_MonHoc_lop.addRow(row);
		}

		table_MonHoc_lop = new JTable(dm_MonHoc_lop);
		table_MonHoc_lop.setLayout(new BorderLayout());
		sp_MonHoc_lop = new JScrollPane(table_MonHoc_lop);
		JScrollPane sc_lopMonHoc = new JScrollPane(sp_MonHoc_lop, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc_lopMonHoc.setPreferredSize(new Dimension(470, 180));
		Table_lopMonHoc.add(sc_lopMonHoc, BorderLayout.CENTER);
		this.add(Table_lopMonHoc);
	}

	// Lấy giá trị tĩnh cho các JComboBox

	public void lop(JComboBox<String> x) {
		Connection conn = Connect.getConnect("localhost", "minhad", "minhad", "minh");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM lophoc");
			while (result.next()) {
				x.addItem(new String(result.getString("MaLop")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// lấy xong giá trị của JComboBox

	public void addEvent() {

		
		// CRUD môn học cho từng lớp học
		 table_MonHoc_lop.addMouseListener(eventTable_MonHocLop);
		 themMonHocLop.addActionListener(eventAdd_MonHocLop);
		 xoaMonHocLop.addActionListener(eventDel_MonHocLop);
	}

	
	
	// CRUD môn học cho lớp học

	MouseAdapter eventTable_MonHocLop = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int row = table_MonHoc_lop.getSelectedRow();
			String[] col = new String[5];
			col[0] = (String) table_MonHoc_lop.getValueAt(row, 0);
			col[1] = (String) table_MonHoc_lop.getValueAt(row, 1);
			col[2] = (String) table_MonHoc_lop.getValueAt(row, 2);
			col[3] = (String) table_MonHoc_lop.getValueAt(row, 3);
			col[4] = (String) table_MonHoc_lop.getValueAt(row, 4);
			maMHLop.setText(col[1]);
			
		}
	};

	ActionListener eventAdd_MonHocLop = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				Connection conn = Connect.getConnect("localhost", "minhad", "minhad", "minh");
							try {
								String sql = "INSERT INTO table_monhoc( maMH, tenMH, STC, ThoiGian) VALUES ('')";
								Statement statement = conn.createStatement();
								int x = statement.executeUpdate(sql);
								if (x > 0) {
									JOptionPane.showMessageDialog(null, "Đã lưu thông tin");
								}
							} catch (Exception ex) {
								ex.printStackTrace();
							} 
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Bạn cần nhập thông tin");
			}

		}
	};

	ActionListener eventDel_MonHocLop = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
//			for (MonHoc x : arrMH) {
//				if (MaMH.getText().equals(x.getMaMH())) {
//					arrMH.remove(x);
//					break;
//				}
//			}
			Connection conn = Connect.getConnect("localhost", "minhad", "minhad", "minh");
			try {
				String sql = "DELETE FROM table_monhoc WHERE MaMH = ''";
				Statement statement = conn.createStatement();
				int x = statement.executeUpdate(sql);
				if (x >= 0) {
					JOptionPane.showMessageDialog(null, "Đã xóa thông tin sinh viên");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
//			dm_MonHoc.setRowCount(0);
//			for (MonHoc x : arrMH) {
//				String[] row = { x.getMaMH(), x.getTenMH(), x.getTinChi(), x.getTime() };
//				dm_MonHoc.addRow(row);
//			}

		}

	};	
//kết thúc CRUD chọn môn học cho lớp
}
