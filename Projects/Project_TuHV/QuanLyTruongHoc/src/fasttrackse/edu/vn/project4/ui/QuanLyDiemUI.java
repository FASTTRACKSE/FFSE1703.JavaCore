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
import javax.swing.JComboBox;
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
import fasttrackse.edu.vn.project4.model.Diem;

public class QuanLyDiemUI extends JPanel {

	private static final long serialVersionUID = 1L;

	public QuanLyDiemUI() {
		addControl();
		addEvent();

	}

	// diem
	@SuppressWarnings("rawtypes")
	JComboBox maLopHoc = new JComboBox();
	@SuppressWarnings("rawtypes")
	JComboBox maMonHoc = new JComboBox();
	@SuppressWarnings("rawtypes")
	JComboBox maSV = new JComboBox();
	private JTextField diem = new JTextField(15);

	private ArrayList<Diem> arrDiem = new ArrayList<Diem>();

	int stt = 0;
	DefaultTableModel dm_diem;

	JTable tbl_diem;

	CardLayout cardlayout;

	private JPanel pnCenter1 = new JPanel();

	private JButton btnSuadiem = new JButton("Sửa");

	@SuppressWarnings("unused")

	public void addControl() {

		// quản lý điểm

		this.setLayout(new BorderLayout());
		JLabel lbldiem = new JLabel("Chương Trình Quản Lý Điểm");
		Font fontdiem = new Font("Arial", Font.BOLD, 24);
		lbldiem.setFont(fontdiem);

		JPanel pnNorth1 = new JPanel();
		pnNorth1.setBackground(Color.blue);
		pnNorth1.add(lbldiem);
		pnCenter1.add(pnNorth1, BorderLayout.NORTH);

		JPanel pnSouth1 = new JPanel();
		pnSouth1.setBackground(Color.blue);
		this.add(pnSouth1, BorderLayout.SOUTH);

		pnCenter1.setLayout(new BoxLayout(pnCenter1, BoxLayout.Y_AXIS));

		JPanel pnbutton1 = new JPanel();
		pnbutton1.setLayout(new FlowLayout());

		// pnbutton1.add(btnThemdiem);
		// pnbutton1.add(btnSuadiem);
		pnCenter1.add(pnbutton1);

		JPanel pnCombo1 = new JPanel();
		pnCombo1.setLayout(new FlowLayout());

		JLabel lblContentdiem2 = new JLabel("Mã Lớp Học : ");

		pnCombo1.add(lblContentdiem2);
		pnCombo1.add(maLopHoc);
		/* Load danh sach lop hoc */
		loadLH();

		JLabel lblContentdiem3 = new JLabel("Mã Môn Học : ");

		pnCombo1.add(lblContentdiem3);
		pnCombo1.add(maMonHoc);

		JLabel lblContentdiem4 = new JLabel("Mã Sinh Viên : ");

		pnCombo1.add(lblContentdiem4);
		pnCombo1.add(maSV);
		pnCenter1.add(pnCombo1);

		JLabel lbl6diem = new JLabel("Điểm :");
		pnCombo1.add(lbl6diem);
		pnCombo1.add(diem);

		pnbutton1.add(btnSuadiem);
		pnCombo1.add(btnSuadiem);

		pnCenter1.setBackground(Color.white);
		this.add(pnCenter1, BorderLayout.CENTER);
		// getContentPane().add(this);

		JPanel pnTable1 = new JPanel();
		dm_diem = new DefaultTableModel();

		dm_diem.addColumn("Mã Lớp Học");
		dm_diem.addColumn("Mã Môn Học");
		dm_diem.addColumn("Mã Sinh Viên");
		dm_diem.addColumn("Điểm");
		Connection conn = Connect.getConnect("localhost", "project4", "viettu", "12345");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM Quan_ly_diem");
			while (result.next()) {
				arrDiem.add(new Diem(result.getString("ma_mon_hoc"), result.getString("ma_sinh_vien"),
						result.getString("diem"), result.getString("ma_lop_hoc")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (Diem x : arrDiem) {
			String[] row = { x.getMalophoc(), x.getMaMH(), x.getMaSV(), x.getDiem() };
			dm_diem.addRow(row);
		}

		tbl_diem = new JTable(dm_diem);
		JScrollPane sc1 = new JScrollPane(tbl_diem);

		sc1.setPreferredSize(new Dimension(1170, 520));
		pnTable1.add(sc1, BorderLayout.CENTER);
		pnCenter1.add(pnTable1);

		Border border1 = BorderFactory.createLineBorder(Color.blue);
		TitledBorder borderTitle1 = BorderFactory.createTitledBorder(border1, "Danh sách điểm sinh viên");
		pnTable1.setBorder(borderTitle1);

	}

	public void addEvent() {
		// chọn mã MH, tên MH..
		maLopHoc.addActionListener(eventChooseLop);
		maMonHoc.addActionListener(eventChooseMonHoc);
		tbl_diem.addMouseListener(eventTable_NhapDiem);
		btnSuadiem.addActionListener(eventEdit_NhapDiem);
	}

	@SuppressWarnings("unchecked")
	public void loadLH() {
		Connection conn = Connect.getConnect("localhost", "project4", "viettu", "12345");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM Quan_ly_lop_hoc");
			while (result.next()) {
				maLopHoc.addItem(new String(result.getString("ma_lop")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// nhap diem
	MouseAdapter eventTable_NhapDiem = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int row = tbl_diem.getSelectedRow();
			String[] col = new String[4];
			col[0] = (String) tbl_diem.getValueAt(row, 0);
			col[1] = (String) tbl_diem.getValueAt(row, 1);
			col[2] = (String) tbl_diem.getValueAt(row, 2);
			col[3] = (String) tbl_diem.getValueAt(row, 3);
			maLopHoc.setSelectedItem(col[0]);
			maMonHoc.setSelectedItem(col[1]);
			maSV.setSelectedItem(col[2]);
			diem.setText(col[3]);
		}
	};

	ActionListener eventEdit_NhapDiem = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			int KT = 0;
			try {
				Double.parseDouble(diem.getText());
			} catch (NumberFormatException ex) {
				KT = 1;
			}

			Connection conn = Connect.getConnect("localhost", "project4", "viettu", "12345");
			if (KT == 1) {
				JOptionPane.showMessageDialog(null, "Bạn nhập sai điểm sinh viên vui lòng nhập lại!!", null,
						JOptionPane.WARNING_MESSAGE);
			} else if ((Double.parseDouble(diem.getText())) > 10 || (Double.parseDouble(diem.getText())) < 0) {
				JOptionPane.showMessageDialog(null, "Nhập sai điểm sinh viên vui lòng nhập lại!!", null,
						JOptionPane.WARNING_MESSAGE);
			} else {

				for (Diem x : arrDiem) {
					if (((String) maSV.getSelectedItem()).equals(x.getMaSV())
							&& ((String) maMonHoc.getSelectedItem()).equals(x.getMaMH())) {
						x.setMalophoc((String) maLopHoc.getSelectedItem());
						x.setDiem(diem.getText());
						break;
					}
				}

				try {
					String sql = "UPDATE quan_ly_diem SET diem ='" + diem.getText() + "',ma_lop_hoc ='"
							+ ((String) maLopHoc.getSelectedItem()) + "' WHERE ma_mon_hoc = '"
							+ ((String) maMonHoc.getSelectedItem()) + "' AND ma_sinh_vien ='"
							+ ((String) maSV.getSelectedItem()) + "'";
					Statement statement = conn.createStatement();
					int x = statement.executeUpdate(sql);
					if (x >= 0) {
						JOptionPane.showMessageDialog(null, "Đã sửa thông tin sinh viên");
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			dm_diem.setRowCount(0);

			for (Diem x : arrDiem) {
				String[] row = { x.getMalophoc(), x.getMaMH(), x.getMaSV(), x.getDiem() };
				dm_diem.addRow(row);
			}
			diem.setText("");
		}
	};

	ActionListener eventChooseLop = new ActionListener() {

		@SuppressWarnings("unchecked")
		@Override
		public void actionPerformed(ActionEvent arg0) {

			String chonLop = (String) maLopHoc.getSelectedItem();
			System.out.println(chonLop);
			dm_diem.setRowCount(0);

			for (Diem x : arrDiem) {
				if (chonLop.equals(x.getMalophoc())) {
					String[] row = { x.getMalophoc(), x.getMaMH(), x.getMaSV(), x.getDiem() };
					dm_diem.addRow(row);
				}
			}
			maMonHoc.removeAllItems();
			maMonHoc.addItem("Chọn môn");
			Connection conn = Connect.getConnect("localhost", "project4", "viettu", "12345");
			try {
				Statement statement = conn.createStatement();
				ResultSet result = statement
						.executeQuery("SELECT * FROM quan_ly_mon_hoc_cho_lop WHERE ma_lop ='" + chonLop + "'");
				while (result.next()) {
					maMonHoc.addItem(new String(result.getString("ma_mon_hoc")));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	};
	// kết thúc Chọn lớp -> mã môn học -> sinh viên

	// chọn lớp và môn cho table Nhập điểm

	ActionListener eventChooseMonHoc = new ActionListener() {

		@SuppressWarnings("unchecked")
		@Override
		public void actionPerformed(ActionEvent arg0) {

			int i = maMonHoc.getSelectedIndex();
			if (i >= 0) {
				String chonLop = (String) maLopHoc.getSelectedItem();
				String chonMH = (String) maMonHoc.getSelectedItem();
				dm_diem.setRowCount(0);
				maSV.removeAllItems();
				maSV.addItem("Chọn Sinh Viên");
				Connection conn = Connect.getConnect("localhost", "project4", "viettu", "12345");
				try {
					Statement statement = conn.createStatement();
					ResultSet result = statement.executeQuery("SELECT * FROM quan_ly_diem WHERE ma_lop_hoc ='" + chonLop
							+ "'AND ma_mon_hoc = '" + chonMH + "'");
					while (result.next()) {
						maSV.addItem(new String(result.getString("ma_sinh_vien")));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (chonMH.equals("Chọn môn")) {
					for (Diem x : arrDiem) {
						if (chonLop.equals(x.getMalophoc())) {
							String[] row = { x.getMalophoc(), x.getMaMH(), x.getMaSV(), x.getDiem() };
							dm_diem.addRow(row);
						}
					}
				} else {
					for (Diem x : arrDiem) {
						if (chonLop.equals(x.getMalophoc()) && chonMH.equals(x.getMaMH())) {
							String[] row = { x.getMalophoc(), x.getMaMH(), x.getMaSV(), x.getDiem() };
							dm_diem.addRow(row);
						}
					}
				}
			}
		}
	};
}
