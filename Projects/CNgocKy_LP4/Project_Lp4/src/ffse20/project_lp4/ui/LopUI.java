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
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import ffse20.project_lp4.model.*;
import com.mysql.jdbc.Connection;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;


public class LopUI extends JPanel {
	private static final long serialVersionUID = 1L;

	private JButton btnThemlp = new JButton("Thêm");
	private JButton btnSualp = new JButton("Sửa");
	private JButton btnXoalp = new JButton("Xóa");
	private JButton btnNhaplp = new JButton("Nhập");

	private JLabel txtlop1 = new JLabel("Nhập Mã Lớp: ");


	private DefaultTableModel  dmLhoc;
	private JTextField maLop1 = new JTextField(), tenLop1 = new JTextField(), namHoc1 = new JTextField();// LopHoc


	/////// quanlylophoc////////
	private JLabel lblNhapTenLop = new JLabel("Tên Lớp:");
	private JLabel lblNhapNamHoc = new JLabel("Năm Học:");
	private JScrollPane sclopHoc;
	private JTable tblLopHoc;

	private ArrayList<QuanLyLopHocModel> arrLH = new ArrayList<QuanLyLopHocModel>();

	
	public LopUI() {
		addControls();
		addEvents();

	}

	public void addControls() {


		this.setLayout(new FlowLayout());


		
		Border border1 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle1 = BorderFactory.createTitledBorder(border1, "NHẬP THÔNG TIN");
		this.setBorder(borderTitle1);

		JPanel chonlop1 = new JPanel();
		chonlop1.add(txtlop1);
		maLop1 = new JTextField(12);
		chonlop1.add(maLop1);
		this.add(chonlop1);

		JPanel nhapTenlop2 = new JPanel();
		tenLop1 = new JTextField(12);
		nhapTenlop2.add(lblNhapTenLop);
		nhapTenlop2.add(tenLop1);
		this.add(nhapTenlop2);

		JPanel nhapNamhoc = new JPanel();
		nhapNamhoc.setLayout(new FlowLayout());
		namHoc1 = new JTextField(12);
		nhapNamhoc.add(lblNhapNamHoc);
		nhapNamhoc.add(namHoc1);
		this.add(nhapNamhoc);

		JPanel chucNang1 = new JPanel();
		chucNang1.setLayout(new FlowLayout());
		chucNang1.add(btnThemlp);
		chucNang1.add(btnSualp);
		chucNang1.add(btnXoalp);
		chucNang1.add(btnNhaplp);
		this.add(chucNang1);

		JPanel pnTable1 = new JPanel();

		dmLhoc = new DefaultTableModel();

		dmLhoc.addColumn("Mã Lớp");
		dmLhoc.addColumn("Tên Lớp");
		dmLhoc.addColumn("Năm Học");

		Connection conn2 = Connect.getConnect("localhost", "quanlysinhvien", "quanlysinhvien", "12345");
		try {
			Statement statement = conn2.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM tabel_lop");
			while (result.next()) {
				arrLH.add(new QuanLyLopHocModel(result.getString("maLop"), result.getString("tenLop"),
						result.getString("namHoc")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (QuanLyLopHocModel x : arrLH) {
			String[] row = { x.getMaLop(), x.getTenLop(), x.getNamHoc() };
			dmLhoc.addRow(row);
		}

		tblLopHoc = new JTable(dmLhoc);
		sclopHoc = new JScrollPane(tblLopHoc);
		JScrollPane VT1 = new JScrollPane(sclopHoc, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		VT1.setPreferredSize(new Dimension(1300, 410));
		pnTable1.add(VT1, BorderLayout.CENTER);

		Border border3 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle3 = BorderFactory.createTitledBorder(border3, "Danh sách");
		pnTable1.setBorder(borderTitle3);
		this.add(pnTable1);

	}




	public void addEvents() {
		tblLopHoc.addMouseListener(eventTableLop);
		btnThemlp.addActionListener(eventAdd);
		btnXoalp.addActionListener(eventDel);
		btnSualp.addActionListener(eventEdit);
		btnNhaplp.addActionListener(eventReset_Lop);





}

	/////////////////
	/////////////////// envent-QuanLyLop////////////////////
	//////////////////

	MouseAdapter eventTableLop = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int row = tblLopHoc.getSelectedRow();
			String[] col = new String[3];
			col[0] = (String) tblLopHoc.getValueAt(row, 0);
			col[1] = (String) tblLopHoc.getValueAt(row, 1);
			col[2] = (String) tblLopHoc.getValueAt(row, 2);
			maLop1.setEditable(false);
			maLop1.setText(col[0]);
			tenLop1.setText(col[1]);
			namHoc1.setText(col[2]);

		}
	};

	ActionListener eventAdd = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int i = 0;
			String malop = maLop1.getText();
			String tenlp = tenLop1.getText();
			String nam = namHoc1.getText();
			for (QuanLyLopHocModel y : arrLH) {
				if (malop.equals(y.getMaLop())) {
					i = 1;
			}
			}
			if(i>0) {
				JOptionPane.showMessageDialog(null, "Trùng mã lớp");
			}else {
			try {
				if (malop.equals("") || tenlp.equals("") || nam.equals("")) {
					JOptionPane.showMessageDialog(null, "Bạn chưa nhập thông tin");
				} else {


							arrLH.add(new QuanLyLopHocModel(malop, tenlp, nam));
							dmLhoc.addRow(new String[] { malop, tenlp, nam });
							Connection conn = Connect.getConnect("localhost", "quanlysinhvien", "quanlysinhvien",
									"12345");
							try {
								String sqlLop = "INSERT INTO tabel_lop(maLop,tenLop,namHoc) VALUES (" + "'" + malop
										+ "','" + tenlp + "','" + nam + "')";

								Statement statement = conn.createStatement();
								int x = statement.executeUpdate(sqlLop);
								if (x > 0) {
									JOptionPane.showMessageDialog(null, "Đã lưu thông tin lớp");
								}
							} catch (Exception ex) {
								ex.printStackTrace();
							}
						}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Bạn cần nhập thông tin lớp");
			}
		}
		}
	};

	ActionListener eventDel = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			for (QuanLyLopHocModel x : arrLH) {
				if (maLop1.getText().equals(x.getMaLop())) {
					arrLH.remove(x);
					break;
				}
			}
			Connection conn = Connect.getConnect("localhost", "quanlysinhvien", "quanlysinhvien", "12345");
			try {
				String sql = "DELETE FROM tabel_lop WHERE maLop = '" + maLop1.getText() + "'";
				Statement statement = conn.createStatement();
				int x = statement.executeUpdate(sql);
				if (x >= 0) {
					JOptionPane.showMessageDialog(null, "Đã xóa thông tin môn học");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			dmLhoc.setRowCount(0);
			for (QuanLyLopHocModel x : arrLH) {
				String[] row = { x.getMaLop(), x.getTenLop(), x.getNamHoc() };
				dmLhoc.addRow(row);
			}
		}

	};

	ActionListener eventEdit = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			for (QuanLyLopHocModel x : arrLH) {
				if (maLop1.getText().equals(x.getMaLop())) {
					x.setTenLop(tenLop1.getText());
					x.setNamHoc(namHoc1.getText());
					break;
				}
			}
			Connection conn = Connect.getConnect("localhost", "quanlysinhvien", "quanlysinhvien", "12345");
			try {
				String sql = "UPDATE tabel_lop SET namHoc ='" + namHoc1.getText() + "',tenLop='" + tenLop1.getText()
						+ "'  WHERE maLop = '" + maLop1.getText() + "'";
				Statement statement = conn.createStatement();
				int x = statement.executeUpdate(sql);
				if (x >= 0) {
					JOptionPane.showMessageDialog(null, "Đã sửa thông tin môn học");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			dmLhoc.setRowCount(0);
			for (QuanLyLopHocModel x : arrLH) {
				String[] row = { x.getMaLop(), x.getTenLop(), x.getNamHoc() };
				dmLhoc.addRow(row);
			}

		}

	};
	ActionListener eventReset_Lop = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			maLop1.setEditable(true);
			maLop1.setText("");
			tenLop1.setText("");
			namHoc1.setText("");

		}
	};

}

