
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
import javax.swing.JComboBox;

public class DiemUI extends JPanel {
	private static final long serialVersionUID = 1L;

	private JButton btnThemDiem = new JButton("Thêm");
	private JButton btnSuaDiem = new JButton("Sửa");
	private JButton btnNhapDiem = new JButton("Nhập");

	private DefaultTableModel dmDiem;

	////////////////////////
	private JTextField nhapDiem;

	private JScrollPane scDiem;
	private JTable tblDiem;

	private JComboBox<String> maLopcomnoBoxDiem = new JComboBox<>();
	private JComboBox<String> monHoccomnoBoxDiem = new JComboBox<>();


	
	private JComboBox<String> maSV5 = new JComboBox<>();



	private ArrayList<QuanLyDiemModel> arrDiem = new ArrayList<QuanLyDiemModel>();

	
	public DiemUI() {
		addControls();
		addEvents();
		maLopcomnoBoxDiem();
		moHoccomnoBoxDiem();


	}

	public void addControls() {

		this.setLayout(new FlowLayout());

		Border border6 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle6 = BorderFactory.createTitledBorder(border6, "NHẬP THÔNG TIN");
		this.setBorder(borderTitle6);

		JLabel lblNhapLop5 = new JLabel("Mã Lớp :");
		JPanel chonlop5 = new JPanel();
		chonlop5.add(lblNhapLop5);
		chonlop5.add(maLopcomnoBoxDiem);
		this.add(chonlop5);
		
		JLabel lblNhapMhoc5 = new JLabel("Môn Học :");
		JPanel chonMhoc5 = new JPanel();
		chonMhoc5.add(lblNhapMhoc5);
		chonMhoc5.add(monHoccomnoBoxDiem);
		this.add(chonMhoc5);

		JLabel lblNhapSV5 = new JLabel("Sinh Viên :");
		JPanel chonSV5 = new JPanel();
		chonSV5.add(lblNhapSV5);
		chonSV5.add(maSV5);
		this.add(chonSV5);



		JPanel nhapDiem5 = new JPanel();
		nhapDiem = new JTextField(12);
		JLabel lblNhapDiem5 = new JLabel("Điểm :");
		nhapDiem5.add(lblNhapDiem5);
		nhapDiem5.add(nhapDiem);
		this.add(nhapDiem5);

		JPanel chucNang5 = new JPanel();
		chucNang5.setLayout(new FlowLayout());
		chucNang5.add(btnThemDiem);
		chucNang5.add(btnSuaDiem);
		chucNang5.add(btnNhapDiem);
		this.add(chucNang5);

		JPanel pnTable5 = new JPanel();

		dmDiem = new DefaultTableModel();

		dmDiem.addColumn("Mã Lớp");
		dmDiem.addColumn("Mã Môn Học");
		dmDiem.addColumn("Sinh Viên");
		dmDiem.addColumn("Điểm");
		
		 Connection con3 = Connect.getConnect("localhost", "quanlysinhvien", "quanlysinhvien", "12345");
		 try {
		 Statement statement = con3.createStatement();
		 ResultSet result = statement.executeQuery("SELECT * FROM table_diem");
		 while (result.next()) {
		 arrDiem.add(new QuanLyDiemModel(result.getString("maLop"),result.getString("ma_monHoc"),result.getString("tenSV"),result.getString("diem")));

		 }
		 } catch (Exception e) {
		 e.printStackTrace();
		 }
		
		 for (QuanLyDiemModel x : arrDiem) {
		 String[] row = { x.getMaLop(), x.getMaMonHoc(), x.getSinhVien(), x.getDiem()};
		 dmDiem.addRow(row);
		 }

		tblDiem = new JTable(dmDiem);
		scDiem = new JScrollPane(tblDiem);
		JScrollPane VT5 = new JScrollPane(scDiem, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		VT5.setPreferredSize(new Dimension(1300, 410));
		pnTable5.add(VT5, BorderLayout.CENTER);

		Border border7 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle7 = BorderFactory.createTitledBorder(border7, "Danh sách");
		pnTable5.setBorder(borderTitle7);
		this.add(pnTable5);


	}



	
	public void maLopcomnoBoxDiem() {
		Connection conn = Connect.getConnect("localhost", "quanlysinhvien", "quanlysinhvien", "12345");
		try {

			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM tabel_lop");
			while (result.next()) {
				maLopcomnoBoxDiem.addItem(new String(result.getString("MaLop")));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void moHoccomnoBoxDiem() {
		Connection conn = Connect.getConnect("localhost", "quanlysinhvien", "quanlysinhvien", "12345");
		try {

			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM table_monhoc");
			while (result.next()) {
				monHoccomnoBoxDiem.addItem(new String(result.getString("ma_monHoc")));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void addEvents() {

		tblDiem.addMouseListener(eventTableDiem);
		

		
		btnThemDiem.addActionListener(eventAddDiem);
		btnSuaDiem.addActionListener(eventEditDiem);

		maLopcomnoBoxDiem.addActionListener(eventChooseSVien);


}
	
	
	
	ActionListener eventChooseSVien= new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			maSV5.removeAllItems();

			String chonSV = (String) maLopcomnoBoxDiem.getSelectedItem();
			Connection conn = Connect.getConnect("localhost", "quanlysinhvien", "quanlysinhvien", "12345");
			try {
				Statement statement = conn.createStatement();
				ResultSet result = statement.executeQuery(
						"SELECT tabel_sinhvien.tenSV FROM tabel_sinhvien INNER JOIN tabel_lop WHERE tabel_lop.maLop=tabel_sinhvien.maLop AND tabel_lop.maLop ='"
								+ chonSV + "'");
				while (result.next()) {
					maSV5.addItem(result.getString("tabel_sinhvien.tenSV"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	};

	
	/////////////////////////
	////////////////EVENT-QUANLYDIEM//////////////
	/////////////////////////
	
	MouseAdapter eventTableDiem = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int row = tblDiem.getSelectedRow();
			String[] col = new String[4];
			col[0] = (String) tblDiem.getValueAt(row, 0);
			col[1] = (String) tblDiem.getValueAt(row, 1);
			col[2] = (String) tblDiem.getValueAt(row, 2);
			col[3] = (String) tblDiem.getValueAt(row, 3);
			
			maLopcomnoBoxDiem.setSelectedItem(col[0]);
			monHoccomnoBoxDiem.setSelectedItem(col[1]);
			maSV5.setSelectedItem(col[2]);
			nhapDiem.setText(col[3]);

		}
	};
	
	ActionListener eventAddDiem = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String maLp = (String) maLopcomnoBoxDiem.getSelectedItem();
			String maMH = (String) monHoccomnoBoxDiem.getSelectedItem();
			String sinhVien = (String) maSV5.getSelectedItem();
			String diem = nhapDiem.getText();



			try {
				if (diem.equals("")) {
					JOptionPane.showMessageDialog(null, "Bạn chưa nhập thông tin");
				} else {
				dmDiem.addRow(new String[] { maLp, maMH, sinhVien, diem});
					Connection conn = Connect.getConnect("localhost", "quanlysinhvien", "quanlysinhvien", "12345");
					try {
						String sql = "INSERT INTO table_diem(ma_monHoc, tenSV,diem, maLop) VALUES('"
								+ maMH + "','" + sinhVien + "','" + diem + "','" + maLp + "')";
						Statement statement = conn.createStatement();
						int x = statement.executeUpdate(sql);
						if (x > 0) {
							JOptionPane.showMessageDialog(null, "Đã lưu thông tin điểm");
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Bạn cần nhập thông tin");
			}
		}
	};
	
	ActionListener eventEditDiem = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			for (QuanLyDiemModel x : arrDiem) {
				if ((maLopcomnoBoxDiem.getSelectedItem()).equals(x.getMaLop())) {
					x.setMaLop((String) maLopcomnoBoxDiem.getSelectedItem());
					x.setMaMonHoc((String)monHoccomnoBoxDiem.getSelectedItem());
					x.setSinhVien((String) maSV5.getSelectedItem());
					x.setDiem( nhapDiem.getText());
					break;
				}
			}
			Connection conn = Connect.getConnect("localhost", "quanlysinhvien", "quanlysinhvien", "12345");
			try {
				String sql = "UPDATE table_diem SET ma_monHoc='" + monHoccomnoBoxDiem.getSelectedItem() + "',tenSV='" + maSV5.getSelectedItem()
						+ "',diem='" + nhapDiem.getText() + "',maLop='" + maLopcomnoBoxDiem.getSelectedItem()+ "' WHERE ma_monHoc = '" + monHoccomnoBoxDiem.getSelectedItem() +"'  AND  tenSV ='" + maSV5.getSelectedItem() + "'";
				System.out.print(sql);
				Statement statement = conn.createStatement();
				int x = statement.executeUpdate(sql);
				if (x >= 0) {
					JOptionPane.showMessageDialog(null, "Đã sửa thông tin môn học");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			dmDiem.setRowCount(0);
			for (QuanLyDiemModel x : arrDiem) {
				String[] row = { x.getMaLop(), x.getMaMonHoc(), x.getSinhVien(), x.getDiem() };
				dmDiem.addRow(row);
			}

		}

	};

}


