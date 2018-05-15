package ffse20.project_lp4.ui;

import java.awt.BorderLayout;
import ffse20.project_lp4.connect.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import ffse20.project_lp4.model.*;
import com.mysql.jdbc.Connection;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;

public class MonHoc_LopUI extends JPanel {
	private static final long serialVersionUID = 1L;

	private JButton btnThemMHLop = new JButton("Thêm");
	private JButton btnXoaMHLop = new JButton("Xóa");

	private DefaultTableModel dmMHLop;

	private JScrollPane scMHLop;
	private JTable tblMHLop;

	private JComboBox<String> maLopcomnoBoxMHocLop = new JComboBox<>();

	private JComboBox<String> monHoccomnoBoxMHLop = new JComboBox<>();


	private ArrayList<QuanLyMonHocLopModel> arrMHLop = new ArrayList<QuanLyMonHocLopModel>();

	public MonHoc_LopUI() {
		addControls();
		addEvents();
		maLopcomnoBoxMHocLop();
		moHoccomnoBoxMHLop();

	}

	public void addControls() {

		this.setLayout(new FlowLayout());


		Border border8 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle8 = BorderFactory.createTitledBorder(border8, "NHẬP THÔNG TIN");
		this.setBorder(borderTitle8);

		JLabel lblMaLop6 = new JLabel("Mã Lớp :");
		JPanel chonlop6 = new JPanel();
		chonlop6.add(lblMaLop6);
		chonlop6.add(maLopcomnoBoxMHocLop);
		this.add(chonlop6);

		JLabel lblNhapMhoc6 = new JLabel("Mã Môn Học :");
		JPanel chonMhoc6 = new JPanel();
		chonMhoc6.add(lblNhapMhoc6);
		chonMhoc6.add(monHoccomnoBoxMHLop);
		this.add(chonMhoc6);

		JPanel chucNang6 = new JPanel();
		chucNang6.setLayout(new FlowLayout());
		chucNang6.add(btnThemMHLop);
		chucNang6.add(btnXoaMHLop);
		this.add(chucNang6);

		JPanel pnTable6 = new JPanel();

		dmMHLop = new DefaultTableModel();

		dmMHLop.addColumn("Mã Lớp");
		dmMHLop.addColumn("Mã Môn Học");

		Connection con4 = Connect.getConnect("localhost", "quanlysinhvien", "quanlysinhvien", "12345");
		try {
			Statement statement = con4.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM table_monhoc_lop");
			while (result.next()) {
				arrMHLop.add(new QuanLyMonHocLopModel(result.getString("maLop"), result.getString("maMonHoc")));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (QuanLyMonHocLopModel x : arrMHLop) {
			String[] row = { x.getMaLop(), x.getMaMonHoc() };
			dmMHLop.addRow(row);
		}

		tblMHLop = new JTable(dmMHLop);
		scMHLop = new JScrollPane(tblMHLop);
		JScrollPane VT6 = new JScrollPane(scMHLop, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		VT6.setPreferredSize(new Dimension(1000, 410));
		pnTable6.add(VT6, BorderLayout.CENTER);


		Border border9 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle9 = BorderFactory.createTitledBorder(border9, "Danh sách");
		pnTable6.setBorder(borderTitle9);
		this.add(pnTable6);


	}
	public void maLopcomnoBoxMHocLop() {
		Connection conn = Connect.getConnect("localhost", "quanlysinhvien", "quanlysinhvien", "12345");
		try {

			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM tabel_lop");
			while (result.next()) {
				maLopcomnoBoxMHocLop.addItem(new String(result.getString("MaLop")));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void moHoccomnoBoxMHLop() {
		Connection conn = Connect.getConnect("localhost", "quanlysinhvien", "quanlysinhvien", "12345");
		try {

			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM table_monhoc");
			while (result.next()) {
				monHoccomnoBoxMHLop.addItem(new String(result.getString("ma_monHoc")));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	public void addEvents() {
		btnThemMHLop.addActionListener(eventAddMHLop);
		btnXoaMHLop.addActionListener(eventDelMHLop);
		
		tblMHLop.addMouseListener(eventTableMHLop);

	}
	
	MouseAdapter eventTableMHLop = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int row = tblMHLop.getSelectedRow();
			String[] col = new String[4];
			col[0] = (String) tblMHLop.getValueAt(row, 0);
			col[1] = (String) tblMHLop.getValueAt(row, 1);

			
			maLopcomnoBoxMHocLop.setSelectedItem(col[0]);
			monHoccomnoBoxMHLop.setSelectedItem(col[1]);


		}
	};
	
	ActionListener eventAddMHLop = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String maLp = (String) maLopcomnoBoxMHocLop.getSelectedItem();
			String maMH = (String) monHoccomnoBoxMHLop.getSelectedItem();




			try {

					dmMHLop.addRow(new String[] { maLp, maMH});
					Connection conn = Connect.getConnect("localhost", "quanlysinhvien", "quanlysinhvien", "12345");
					try {
						String sql = "INSERT INTO table_monhoc_lop(maLop, maMonHoc) VALUES('"
								+ maLp + "','" + maMH + "')";
						Statement statement = conn.createStatement();
						int x = statement.executeUpdate(sql);
						if (x > 0) {
							JOptionPane.showMessageDialog(null, "Đã lưu thông tin điểm");
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Bạn cần nhập thông tin");
			}
		}
	};
	
	ActionListener eventDelMHLop = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			for (QuanLyMonHocLopModel x : arrMHLop) {
				if (maLopcomnoBoxMHocLop.getSelectedItem().equals(x.getMaLop()) && monHoccomnoBoxMHLop.getSelectedItem().equals(x.getMaMonHoc())) {
					arrMHLop.remove(x);
					break;
				}
			}
			Connection conn = Connect.getConnect("localhost", "quanlysinhvien", "quanlysinhvien", "12345");
			try {
				String sql = "DELETE FROM table_monhoc_lop WHERE maLop = '" + maLopcomnoBoxMHocLop.getSelectedItem() + "'AND maMonHoc='"+ monHoccomnoBoxMHLop.getSelectedItem() +"'";
				Statement statement = conn.createStatement();
				int x = statement.executeUpdate(sql);
				if (x >= 0) {
					JOptionPane.showMessageDialog(null, "Đã xóa thông tin sinh viên");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			dmMHLop.setRowCount(0);
			for (QuanLyMonHocLopModel x : arrMHLop) {
				String[] row = { x.getMaLop(), x.getMaMonHoc() };
				dmMHLop.addRow(row);
			}
		}

	};

}
