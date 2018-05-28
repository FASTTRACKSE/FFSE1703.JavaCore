package fasttrackse.edu.vn.project4.ui;

import java.awt.BorderLayout;
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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import fasttrackse.edu.vn.project4.model.*;

import fasttrackse.edu.vn.project4.model.Connect;

public class QuanLyMonHocTungMonUI extends JPanel {

	public QuanLyMonHocTungMonUI() {
		monhoc();
		lop();
		addControls();
		addEvent();
	}

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	JComboBox maLopHocMon = new JComboBox();
	@SuppressWarnings("rawtypes")
	JComboBox monHoc = new JComboBox();

	private ArrayList<MonCuaTungLop> arrMHL = new ArrayList<MonCuaTungLop>();

	int stt = 0;

	DefaultTableModel dm_monhoc_lop;

	JTable tbl_monhoc_lop;

	private JButton btnThem = new JButton("Thêm");
	private JButton btnXoa = new JButton("Xóa");

	private JPanel pnCenter5 = new JPanel();

	@SuppressWarnings("unused")
	private JPanel pnBorder5 = new JPanel();

	public void addControls() {

		// quản lý môn học cho từng lớp
		this.setLayout(new BorderLayout());
		JLabel lbllop_mon = new JLabel("Chương Trình Quản Lý Môn Học Cho Từng Lớp");
		Font fontlop_mon = new Font("Arial", Font.BOLD, 24);
		lbllop_mon.setFont(fontlop_mon);

		JPanel pnNorth5 = new JPanel();
		pnNorth5.setBackground(Color.blue);
		pnNorth5.add(lbllop_mon);
		pnCenter5.add(pnNorth5, BorderLayout.NORTH);

		JPanel pnSouth5 = new JPanel();
		pnSouth5.setBackground(Color.blue);
		this.add(pnSouth5, BorderLayout.SOUTH);

		pnCenter5.setLayout(new BoxLayout(pnCenter5, BoxLayout.Y_AXIS));

		JPanel pnbutton5 = new JPanel();
		pnbutton5.setLayout(new FlowLayout());

		pnbutton5.add(btnThem);

		pnbutton5.add(btnXoa);
		pnCenter5.add(pnbutton5);

		JPanel pnCombo6 = new JPanel();
		pnCombo6.setLayout(new FlowLayout());

		JLabel lblContentmon = new JLabel("Mã Lớp Học : ");

		pnCombo6.add(lblContentmon);
		pnCombo6.add(maLopHocMon);

		pnCenter5.add(pnCombo6);
		JLabel lblContentmonhoc = new JLabel("Mã Môn Học : ");

		pnCombo6.add(lblContentmonhoc);
		pnCombo6.add(monHoc);

		pnCenter5.add(pnCombo6);

		pnCenter5.setBackground(Color.white);
		this.add(pnCenter5, BorderLayout.CENTER);
		// getContentPane().add(pnBorder5);

		JPanel pnTable5 = new JPanel();
		dm_monhoc_lop = new DefaultTableModel();

		dm_monhoc_lop.addColumn("Mã Lớp Học");
		dm_monhoc_lop.addColumn(" Mã Môn Học");
		dm_monhoc_lop.addColumn("Tên Môn Học");

		try {
			Connection conn = Connect.getConnect("localhost", "project4", "viettu", "12345");
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM Quan_ly_mon_hoc_cho_lop");
			while (result.next()) {
				arrMHL.add(new MonCuaTungLop(result.getString("ma_lop"), result.getString("ma_mon_hoc"),
						result.getString("ten")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (MonCuaTungLop x : arrMHL) {
			@SuppressWarnings("unused")
			String[] row = { x.getMalop(), x.getMaMH(), x.getTen() };
			dm_monhoc_lop.addRow(row);
		}
		tbl_monhoc_lop = new JTable(dm_monhoc_lop);
		JScrollPane sc5 = new JScrollPane(tbl_monhoc_lop);

		sc5.setPreferredSize(new Dimension(1170, 520));
		pnTable5.add(sc5, BorderLayout.CENTER);
		pnCenter5.add(pnTable5);

		Border border5 = BorderFactory.createLineBorder(Color.blue);
		TitledBorder borderTitle5 = BorderFactory.createTitledBorder(border5, "Danh sách lớp học");
		pnTable5.setBorder(borderTitle5);

	}

	@SuppressWarnings("unchecked")
	public void lop() {
		Connection conn = Connect.getConnect("localhost", "project4", "viettu", "12345");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM quan_ly_lop_hoc");
			while (result.next()) {
				maLopHocMon.addItem(new String(result.getString("ma_lop")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public void monhoc() {
		Connection conn = Connect.getConnect("localhost", "project4", "viettu", "12345");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM quan_ly_mon_hoc");
			while (result.next()) {
				monHoc.addItem(new String(result.getString("ma_mon_hoc")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addEvent() {

		tbl_monhoc_lop.addMouseListener(eventTable_lophoc);
		btnThem.addActionListener(eventAdd_lop);
		btnXoa.addActionListener(eventDel_lop);

	}

	MouseAdapter eventTable_lophoc = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int row = tbl_monhoc_lop.getSelectedRow();
			String[] col = new String[2];
			col[0] = (String) tbl_monhoc_lop.getValueAt(row, 0);
			col[1] = (String) tbl_monhoc_lop.getValueAt(row, 1);
			maLopHocMon.setSelectedItem(col[0]);
			monHoc.setSelectedItem(col[1]);

		}
	};

	ActionListener eventAdd_lop = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			String chonMa = (String) maLopHocMon.getSelectedItem();
			String chonMon = (String) monHoc.getSelectedItem();

			try {
				Connection conn = Connect.getConnect("localhost", "project4", "viettu", "12345");
				Statement statement = conn.createStatement();
				ResultSet result = statement.executeQuery(
						"SELECT Quan_ly_lop_hoc.ma_lop,Quan_ly_mon_hoc.ma_mon_hoc,Quan_ly_mon_hoc.ten FROM Quan_ly_lop_hoc INNER JOIN Quan_ly_mon_hoc WHERE ma_lop= '"
								+ chonMa + "' AND Quan_ly_mon_hoc.ma_mon_hoc='" + chonMon + "'");

				// while (result.next()) {
				result.next();
				arrMHL.add(new MonCuaTungLop(result.getString("ma_lop"), result.getString("ma_mon_hoc"),
						result.getString("ten")));
				dm_monhoc_lop.addRow(new String[] { result.getString("ma_lop"), result.getString("ma_mon_hoc"),
						result.getString("ten") });
				String sql = "INSERT INTO Quan_ly_mon_hoc_cho_lop (ma_lop, ma_mon_hoc,ten) VALUES (" + "'"
						+ result.getString("ma_lop") + "','" + result.getString("ma_mon_hoc") + "','"
						+ result.getString("ten") + "')";
				statement.executeUpdate(sql);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
			dm_monhoc_lop.setRowCount(0);
			for (MonCuaTungLop x : arrMHL) {
				String[] row = { x.getMalop(), x.getMaMH(), x.getTen() };
				dm_monhoc_lop.addRow(row);
			}

		}
	};

	ActionListener eventDel_lop = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			for (MonCuaTungLop x : arrMHL) {
				if (((String) maLopHocMon.getSelectedItem()).equals(x.getMalop())) {
					if (((String) monHoc.getSelectedItem()).equals(x.getMaMH())) {
						arrMHL.remove(x);
					}
					break;
				}
			}
			Connection conn = Connect.getConnect("localhost", "project4", "viettu", "12345");
			try {
				String sql = "DELETE FROM Quan_ly_mon_hoc_cho_lop WHERE ma_lop = '"
						+ (String) maLopHocMon.getSelectedItem() + "' AND ma_mon_hoc ='"
						+ (String) maLopHocMon.getSelectedItem() + "'";
				Statement statement = conn.createStatement();
				int x = statement.executeUpdate(sql);
				if (x >= 0) {
					JOptionPane.showMessageDialog(null, "Xóa thông tin môn học");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			dm_monhoc_lop.setRowCount(0);
			for (MonCuaTungLop x : arrMHL) {
				String[] row = { x.getMalop(), x.getMaMH(), x.getTen() };
				dm_monhoc_lop.addRow(row);
			}
		}

	};

}
