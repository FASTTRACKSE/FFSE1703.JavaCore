package Assignment_11.ui;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.gjt.mm.mysql.Driver;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Vector;
//import Assignment_11.sql.*;
import Assignment_11.model.*;

public class QuanLySVLayout extends JFrame {
	public JButton btn1 = new JButton("Them");
	public JButton btn2 = new JButton("Sua");
	public JButton btn3 = new JButton("Xoa");
	public JButton btn4 = new JButton("Thoat");
	public JButton btn5 = new JButton("Nhap");
	public JTextField textTenSV = new JTextField(20);
	public JTextField textTuoiSV = new JTextField(20);
	public JTextField textMaSV = new JTextField(20);
	public DefaultTableModel dm = new DefaultTableModel();
	public JTable tableSV = new JTable(dm) {
		public boolean isCellEditable(int row, int column) {
			if (column == 0)
				return false;
			return true;
		}
	};
	private String[] lop = { "All","FFSE1701", "FFSE1702", "FFSE1703", "FFSE1704" };
	public ArrayList<SinhVien> arrSV = new ArrayList<SinhVien>();
	public SinhVien sv;
	public int row, column;
	public String lopSV, maSV, tenSV, tuoiSV, text;
	public JComboBox cb = new JComboBox(lop);
	final static Connection conn = getConnect("localhost", "ffse1703014", "admin", "123456");

	public QuanLySVLayout(String tille) {
		super(tille);
		addControls();
		addEvents();
	}

	private void addControls() {
		Container con = getContentPane();
		JPanel pnMainLayout = new JPanel();
		pnMainLayout.setLayout(new BoxLayout(pnMainLayout, BoxLayout.Y_AXIS));

		JPanel pnTitle = new JPanel();
		JLabel title = new JLabel("Chuong trinh quan ly sinh vien");
		Font font = new Font("Arial", Font.BOLD, 20);
		title.setFont(font);
		title.setForeground(Color.BLACK);
		pnTitle.add(title);

		JPanel pnOption = new JPanel();
		JLabel labelOption = new JLabel("Chon lop: ");
		pnOption.add(labelOption);
		pnOption.add(cb);

		JPanel pnTenSV = new JPanel();
		JLabel labelTenSV = new JLabel("Ten sinh vien:");
		pnTenSV.add(labelTenSV);
		pnTenSV.add(textTenSV);

		JPanel pnTuoiSV = new JPanel();
		JLabel labelTuoiSV = new JLabel("Tuoi sinh vien:");
		pnTuoiSV.add(labelTuoiSV);
		pnTuoiSV.add(textTuoiSV);

		JPanel pnMaSV = new JPanel();
		JLabel labelMaSV = new JLabel("Ma sinh vien:");
		pnMaSV.add(labelMaSV);
		pnMaSV.add(textMaSV);

		JPanel pnAction = new JPanel();
		pnAction.add(btn1);
		pnAction.add(btn2);
		pnAction.add(btn3);
		pnAction.add(btn4);
		pnAction.add(btn5);

		JPanel pnTable = new JPanel();
		pnTable.setLayout(new BorderLayout());
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder tilleBorder = BorderFactory.createTitledBorder(border, "Danh sach sinh vien");
		dm.addColumn("Ma");
		dm.addColumn("Ten");
		dm.addColumn("Tuoi");
		dm.addColumn("Lop");
		JScrollPane sc = new JScrollPane(tableSV);
		pnTable.setBorder(tilleBorder);
		pnTable.add(sc, BorderLayout.CENTER);

		pnMainLayout.add(pnTitle);
		pnMainLayout.add(pnOption);
		pnMainLayout.add(pnMaSV);
		pnMainLayout.add(pnTenSV);
		pnMainLayout.add(pnTuoiSV);
		pnMainLayout.add(pnAction);
		pnMainLayout.add(pnTable);

		con.add(pnMainLayout);

	}

	private void addEvents() {
		cb.addActionListener(showSV);
		btn1.addActionListener(nhapSV);
		btn2.addActionListener(suaSV);
		btn3.addActionListener(xoaSV);
		btn4.addActionListener(exit);
		// btn5.addActionListener(nhapFile);
	}

	ActionListener showSV = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (cb.getSelectedItem().toString() == "All") {
				showArray();
			} else {
				getArray();
			}
		}
	};
	ActionListener nhapSV = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String lopSV = (String) cb.getSelectedItem();
			maSV = textMaSV.getText();
			tenSV = textTenSV.getText();
			tuoiSV = textTuoiSV.getText();
			if (maSV.isEmpty() || tenSV.isEmpty() || tuoiSV.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Xin hay nhap day du thong tin!");
			} else {
				try {
					Statement statement = (Statement) conn.createStatement();
					ResultSet result = statement.executeQuery(
							"select * from sinhvien where MaSV ='" + maSV + "'");
					if (result.next() == true) {
						JOptionPane.showMessageDialog(null, "Thông tin sinh viên đã tồn tại!");
					} else {
						try {
							String sql = "insert into sinhvien value(null,'" + lopSV + "','" + maSV + "','" + tenSV + "','"
									+ tuoiSV + "')";
							Statement statements = (Statement) conn.createStatement();
							int y = statements.executeUpdate(sql);
							if (y > 0) {
								arrSV.add(new SinhVien (lopSV,maSV,tenSV,tuoiSV));
								textMaSV.setText("");
								textTenSV.setText("");
								textTuoiSV.setText("");
								JOptionPane.showMessageDialog(null, "Nhap thong tin sinh vien thanh cong!");
							}
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			getArray();
		}
	};
	ActionListener suaSV = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			row = tableSV.getSelectedRow();
			maSV = (String) dm.getValueAt(row, 0);
			tenSV = (String) dm.getValueAt(row, 1);
			tuoiSV = (String) dm.getValueAt(row, 2);
			lopSV = (String) dm.getValueAt(row, 3);
			try {
				String sql = "update sinhvien set TenSV='" + tenSV + "',TuoiSV=" + tuoiSV + ",LopSV='" + lopSV
						+ "' where MaSV='" + maSV + "'";
				Statement statement = (Statement) conn.createStatement();
				int x = statement.executeUpdate(sql);
				if (x > 0) {
					JOptionPane.showMessageDialog(null, "Sua thong tin sinh vien thanh cong!");
				} else {
					JOptionPane.showMessageDialog(null, "Sua thong tin sinh vien that bai!");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			getArray();
		}
	};
	ActionListener xoaSV = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			row = tableSV.getSelectedRow();
			try {
				String sql = "delete from sinhvien where MaSV='" + dm.getValueAt(row, 0) + "'";
				Statement statement = (Statement) conn.createStatement();
				int x = statement.executeUpdate(sql);
				if (x > 0) {
					JOptionPane.showMessageDialog(null, "Xoa sinh vien thanh cong");
				} else {
					JOptionPane.showMessageDialog(null, "Xoa sinh vien that bai");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			getArray();
		}
	};
	ActionListener exit = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			int mess = JOptionPane.showConfirmDialog(null, "Ban muon thoat?", "Thoat", JOptionPane.YES_NO_OPTION);
			if (mess == JOptionPane.YES_OPTION) {
				System.exit(0);
			} else {
			}
		}
	};

	public static Connection getConnect(String strServer, String strDatabase, String strUser, String strPwd) {
		Connection conn = null;
		String strConnect = "jdbc:mysql://" + strServer + "/" + strDatabase;
		Properties pro = new Properties();
		pro.put("user", strUser);
		pro.put("password", strPwd);
		try {
			com.mysql.jdbc.Driver driver = new Driver();
			conn = (Connection) driver.connect(strConnect, pro);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return conn;
	}
	public void getArray() {
		String lopSV = (String) cb.getSelectedItem();
		if (arrSV.isEmpty()) {
			
		} else {
			arrSV.removeAll(arrSV);
		}
		try {
			Statement statement = (Statement) conn.createStatement();
			ResultSet result = statement.executeQuery("select * from sinhvien where LopSV = '" + lopSV + "'");
			while (result.next()) {
				arrSV.add(new SinhVien (result.getString("LopSV"),result.getString("MaSV"), result.getString("TenSV"),
						result.getString("TuoiSV")));
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		dm.setRowCount(0);
		for (SinhVien x : arrSV) {
			String[] row = {x.getMaSV(),x.getTenSV(),x.getTuoiSV(),x.getLopSV()};
			dm.addRow(row);
		}
	}
	public void showArray() {
		if (arrSV.isEmpty()) {
			
		} else {
			arrSV.removeAll(arrSV);
		}
		try {
			Statement statement = (Statement) conn.createStatement();
			ResultSet result = statement.executeQuery("select * from sinhvien");
			while (result.next()) {
				arrSV.add(new SinhVien (result.getString("LopSV"),result.getString("MaSV"), result.getString("TenSV"),
						result.getString("TuoiSV")));
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		dm.setRowCount(0);
		for (SinhVien x : arrSV) {
			String[] row = {x.getMaSV(),x.getTenSV(),x.getTuoiSV(),x.getLopSV()};
			dm.addRow(row);
		}
	}
	public void showWindow() {
		this.setSize(500, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
