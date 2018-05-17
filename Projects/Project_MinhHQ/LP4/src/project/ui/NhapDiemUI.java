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

public class NhapDiemUI extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField DiemSV = new JTextField();

	private ArrayList<Diem> arrDiem = new ArrayList<Diem>();

	private JButton suaND = new JButton("Sửa");

	private JComboBox<String> selectNhapDiem = new JComboBox<>();
	private JComboBox<String> selectMaMH = new JComboBox<>();
	private JComboBox<String> selectMaSV = new JComboBox<>();

	private DefaultTableModel dm_NhapDiem;
	private JTable table_NhapDiem;
	private JScrollPane sp_NhapDiem;

	public NhapDiemUI() {
		lop(selectNhapDiem);
		monhoc(selectMaMH);
		sinhvien();
		addControls();
		addEvent();
	}

	public void addControls() {
		// Nhập điểm cho sinh viên

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel pnLeft_NhapDiem = new JPanel();

		JPanel chonlop_NhapDiem = new JPanel();
		chonlop_NhapDiem.setLayout(new FlowLayout());
		JLabel txtlop_NhapDiem = new JLabel("Mã lớp học: ");
		chonlop_NhapDiem.add(txtlop_NhapDiem);
		chonlop_NhapDiem.add(selectNhapDiem);
		pnLeft_NhapDiem.add(chonlop_NhapDiem);

		JPanel chon_NhapDiem = new JPanel();
		chon_NhapDiem.setLayout(new FlowLayout());
		JLabel txt_NhapDiem = new JLabel("Mã môn học: ");
		chon_NhapDiem.add(txt_NhapDiem);
		chon_NhapDiem.add(selectMaMH);
		pnLeft_NhapDiem.add(chon_NhapDiem);

		JPanel pnLop_NhapDiem = new JPanel();
		pnLop_NhapDiem.setLayout(new FlowLayout());
		JLabel txtLop_NhapDiem = new JLabel("Mã sinh viên: ");
		pnLop_NhapDiem.add(txtLop_NhapDiem);
		pnLop_NhapDiem.add(selectMaSV);
		pnLeft_NhapDiem.add(pnLop_NhapDiem);

		JPanel nhapDiem = new JPanel();
		nhapDiem.setLayout(new FlowLayout());
		JLabel lblNhapDiem = new JLabel("Điểm :");
		DiemSV = new JTextField(20);
		nhapDiem.add(lblNhapDiem);
		nhapDiem.add(DiemSV);
		pnLeft_NhapDiem.add(nhapDiem);
		pnLeft_NhapDiem.add(suaND);

		JPanel pn_NhapDiem = new JPanel();
		pn_NhapDiem.setLayout(new FlowLayout());

		pn_NhapDiem.add(pnLeft_NhapDiem);
		this.add(pn_NhapDiem);

		JPanel Table_NhapDiem = new JPanel();
		Table_NhapDiem.setLayout(new BorderLayout());
		Border border_NhapDiem = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle_NhapDiem = BorderFactory.createTitledBorder(border_NhapDiem,
				"Danh sách điểm sinh viên");
		Table_NhapDiem.setBorder(borderTitle_NhapDiem);

		dm_NhapDiem = new DefaultTableModel();

		dm_NhapDiem.addColumn("Mã lớp");
		dm_NhapDiem.addColumn("Mã sinh viên");
		dm_NhapDiem.addColumn("Mã môn học");
		dm_NhapDiem.addColumn("Điểm");

		Connection conn = Connect.getConnect("localhost", "minhad", "minhad", "minh");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM diem");
			while (result.next()) {
				arrDiem.add(new Diem(result.getString("MaLop"), result.getString("MaSV"), result.getString("MaMH"),
						result.getString("Diem")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (Diem x : arrDiem) {
			String[] row = { x.getLop(), x.getMaSV(), x.getMaMH(), x.getDiem() };
			dm_NhapDiem.addRow(row);
		}

		table_NhapDiem = new JTable(dm_NhapDiem);
		table_NhapDiem.setLayout(new BorderLayout());
		sp_NhapDiem = new JScrollPane(table_NhapDiem);
		JScrollPane sc_NhapDiem = new JScrollPane(sp_NhapDiem, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc_NhapDiem.setPreferredSize(new Dimension(470, 180));
		Table_NhapDiem.add(sc_NhapDiem, BorderLayout.CENTER);
		this.add(Table_NhapDiem);
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

	public void monhoc(JComboBox<String> x) {
		Connection conn = Connect.getConnect("localhost", "minhad", "minhad", "minh");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM table_monhoc");
			while (result.next()) {
				x.addItem(new String(result.getString("MaMH")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sinhvien() {
		Connection conn = Connect.getConnect("localhost", "minhad", "minhad", "minh");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM sinhvien");
			while (result.next()) {
				selectMaSV.addItem(new String(result.getString("MaSV")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// lấy xong giá trị của JComboBox

	public void addEvent() {
		table_NhapDiem.addMouseListener(eventTable_NhapDiem);
		suaND.addActionListener(eventEdit_NhapDiem);
		selectNhapDiem.addActionListener(eventChooseLop);
	}

	// Chọn lớp -> mã môn học -> sinh viên
	ActionListener eventChooseLop = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String chonLop = (String) selectNhapDiem.getSelectedItem();
			selectMaMH.removeAllItems();
			Connection conn = Connect.getConnect("localhost", "minhad", "minhad", "minh");
			try {
				Statement statement = conn.createStatement();
				ResultSet result = statement.executeQuery(
						"SELECT * FROM monhoc WHERE TenLop ='"
								+ chonLop + "'");
				while (result.next()) {
					selectMaMH.addItem(new String(result.getString("MaMH")));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			selectMaSV.removeAllItems();
			try {
				Statement statement = conn.createStatement();
				ResultSet result = statement.executeQuery(
						"SELECT * FROM sinhvien WHERE MaLop ='"
								+ chonLop + "'");
				while (result.next()) {
					selectMaSV.addItem(new String(result.getString("MaSV")));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	};
	// kết thúc Chọn lớp -> mã môn học -> sinh viên
	
	// CRUD nhập điểm

	MouseAdapter eventTable_NhapDiem = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int row = table_NhapDiem.getSelectedRow();
			String[] col = new String[4];
			col[0] = (String) table_NhapDiem.getValueAt(row, 0);
			col[1] = (String) table_NhapDiem.getValueAt(row, 1);
			col[2] = (String) table_NhapDiem.getValueAt(row, 2);
			col[3] = (String) table_NhapDiem.getValueAt(row, 3);
			selectNhapDiem.setSelectedItem(col[0]);
			selectMaMH.setSelectedItem(col[1]);
			selectMaSV.setSelectedItem(col[2]);
			DiemSV.setText(col[3]);
		}
	};


	ActionListener eventEdit_NhapDiem = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			for (Diem x : arrDiem) {
				if (selectMaSV.getSelectedItem().equals(x.getMaSV()) && selectMaMH.getSelectedItem().equals(x.getMaMH())) {
					x.setLop((String)selectNhapDiem.getSelectedItem());
					x.setDiem(DiemSV.getText());
					break;
				}
			}
			Connection conn = Connect.getConnect("localhost", "minhad", "minhad", "minh");
			try {
				String sql = "UPDATE diem SET Diem ='" + DiemSV.getText() + "',MaLop ='" + selectNhapDiem.getSelectedItem() 
						+ "' WHERE MaMH = '" + selectMaMH.getSelectedItem() + "' AND MaSV ='"+selectMaSV.getSelectedItem()+"'";
				Statement statement = conn.createStatement();
				int x = statement.executeUpdate(sql);
				if (x >= 0) {
					JOptionPane.showMessageDialog(null, "Đã sửa thông tin sinh viên");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			dm_NhapDiem.setRowCount(0);
			for (Diem x : arrDiem) {
				String[] row = { x.getLop(), x.getMaSV(), x.getMaMH(), x.getDiem() };
				dm_NhapDiem.addRow(row);
			}
			DiemSV.setText("");
		}
	};

}
