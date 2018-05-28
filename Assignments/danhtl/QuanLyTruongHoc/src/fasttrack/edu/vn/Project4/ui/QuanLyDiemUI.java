package fasttrack.edu.vn.Project4.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
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

import fasttrack.edu.vn.Project4.model.Connect;
import fasttrack.edu.vn.Project4.model.QuanLyDiem;

public class QuanLyDiemUI extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private JButton diemsua = new JButton("Sửa");
	
	private DefaultTableModel dmdiem;
	private JScrollPane spdiem;
	private JTable tablediem;
	 ArrayList<QuanLyDiem> arrdiem = new ArrayList<QuanLyDiem>();

JComboBox<String> lopdiem = new JComboBox<>();
	
	JComboBox<String> madiem = new JComboBox<>();
	
	JComboBox<String> diemmon = new JComboBox<>();
	private JTextField sodiem = new JTextField();
	
	public QuanLyDiemUI() {
		lop();
		monhoc();
		addControls();
		addEvent();
		
	}
	
	public void addControls() {
		// ĐIỂM

				this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

				JPanel pnButtondiem = new JPanel();
				pnButtondiem.setLayout(new FlowLayout());
				
				pnButtondiem.add(diemsua);
				
				this.add(pnButtondiem);

				JPanel diem = new JPanel();
				diem.setLayout(new BoxLayout(diem, BoxLayout.X_AXIS));

				JPanel pnlopdiem = new JPanel();
				pnlopdiem.setLayout(new FlowLayout());
				JLabel lbldiem = new JLabel(" Mã Lớp  :");
				pnlopdiem.add(lbldiem);
				pnlopdiem.add(lopdiem);
				diem.add(pnlopdiem);
				
				JPanel pnmadiem = new JPanel();
				pnmadiem.setLayout(new FlowLayout());
				JLabel lblmadiem = new JLabel("Mã Sinh Viên :");
				pnmadiem.add(lblmadiem);
				pnmadiem.add(madiem);
				diem.add(pnmadiem);

				JPanel pnmamhdiem = new JPanel();
				pnmamhdiem.setLayout(new FlowLayout());
				JLabel lblmhdiem = new JLabel("Môn học :");
				pnmamhdiem.add(lblmhdiem);
				pnmamhdiem.add(diemmon);
				diem.add(pnmamhdiem);

				

				JPanel pndiem = new JPanel();
				pndiem.setLayout(new FlowLayout());
				JLabel lbldiemsv = new JLabel("Số Điểm :");
				sodiem = new JTextField(12);
				pndiem.add(lbldiemsv);
				pndiem.add(sodiem);
				diem.add(pndiem);

				JPanel nhapdiem = new JPanel();
				nhapdiem.setLayout(new GridLayout(1, 3));
				Border bordiem = BorderFactory.createLineBorder(Color.RED);
				TitledBorder borderTitlediem = BorderFactory.createTitledBorder(bordiem, "Thêm Thông Tin");
				nhapdiem.setBorder(borderTitlediem);
				nhapdiem.add(diem);

				this.add(nhapdiem);

				JPanel Table3 = new JPanel();
				Table3.setLayout(new FlowLayout());
				Border bordiem1 = BorderFactory.createLineBorder(Color.RED);
				TitledBorder borderTitlediem1 = BorderFactory.createTitledBorder(bordiem1, "Danh sách sinh viên");
				Table3.setBorder(borderTitlediem1);

				dmdiem = new DefaultTableModel();

				dmdiem.addColumn("Mã Lớp");
				dmdiem.addColumn("Mã Sinh Viên");
				dmdiem.addColumn("Môn học  ");
				dmdiem.addColumn("Điểm");
				
				dmdiem.addColumn("Thời Gian Học ");
				Connection conn = Connect.getConnect("localhost", "Danh", "Danh", "Danh");
				try {
					Statement statement = conn.createStatement();
					ResultSet result = statement.executeQuery("SELECT * FROM quan_ly_diem");
					while (result.next()) {
						arrdiem.add(new QuanLyDiem(result.getString("Lop"), result.getString("ma_mon_hoc"),
								result.getString("ma_sinh_vien"), result.getString("diem")));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

				for (QuanLyDiem x : arrdiem) {
					String[] row = { x.getLop(), x.getMaSV(), x.getMaMon(), x.getDiem() };
					dmdiem.addRow(row);
				}

				tablediem = new JTable(dmdiem);
				tablediem.setLayout(new BorderLayout());
				spdiem = new JScrollPane(tablediem);
				JScrollPane sc3 = new JScrollPane(spdiem, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
						JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
				sc3.setPreferredSize(new Dimension(1170, 500));
				Table3.add(sc3, BorderLayout.CENTER);
				this.add(Table3);
	}
	
	// Lấy giá trị tĩnh cho các JComboBox

		public void lop() {
			lopdiem.addItem("Tất cả");
			Connection conn = Connect.getConnect("localhost", "Danh", "Danh", "Danh");
			try {
				Statement statement = conn.createStatement();
				ResultSet result = statement.executeQuery("SELECT * FROM quan_ly_lop_hoc");
				while (result.next()) {
					lopdiem.addItem(new String(result.getString("ma_lop")));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void monhoc() {
			Connection conn = Connect.getConnect("localhost", "Danh", "Danh", "Danh");
			try {
				diemmon.addItem("Chọn môn");
				Statement statement = conn.createStatement();
				ResultSet result = statement.executeQuery("SELECT * FROM Quan_ly_mon_hoc");
				while (result.next()) {
					diemmon.addItem(new String(result.getString("ma_mon_hoc")));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// lấy xong giá trị của JComboBox

	
	public void addEvent() {
		tablediem.addMouseListener(eventTable_NhapDiem);
		diemsua.addActionListener(eventEdit_NhapDiem);
		lopdiem.addActionListener(eventChooseLop);
		diemmon.addActionListener(eventChooseMonHoc);
		madiem.addActionListener(eventChooseSV);
	}

	// Chọn lớp -> mã môn học -> sinh viên
	ActionListener eventChooseLop = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String chonLop = (String) lopdiem.getSelectedItem();

			dmdiem.setRowCount(0);

			for (QuanLyDiem x : arrdiem) {
				if (chonLop.equals(x.getLop())) {
					String[] row = { x.getLop(), x.getMaSV(), x.getMaMon(), x.getDiem() };
					dmdiem.addRow(row);
				}
			}

			madiem.removeAllItems();
			madiem.addItem("Chọn sinh viên");
			Connection conn = Connect.getConnect("localhost", "Danh", "Danh", "Danh");
			
			try {
				Statement statement = conn.createStatement();
				ResultSet result = statement.executeQuery(
						"SELECT DISTINCT ma_sinh_vien FROM Quan_ly_diem WHERE lop ='" + chonLop + "'");
				while (result.next()) {
					madiem.addItem(new String(result.getString("ma_sinh_vien")));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	};

	ActionListener eventChooseSV = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			int i = madiem.getSelectedIndex();
			if (i >= 0) {
				String chonLop = (String) lopdiem.getSelectedItem();
				String chonSV = (String) madiem.getSelectedItem();
				
				diemmon.removeAllItems();
				diemmon.addItem("Chọn môn");
				Connection conn = Connect.getConnect("localhost", "Danh", "Danh", "Danh");
				try {
					Statement statement = conn.createStatement();
					ResultSet result = statement.executeQuery(
							"SELECT  ma_mon_hoc FROM Quan_ly_diem WHERE Lop ='" + chonLop + "' AND ma_sinh_vien ='"+ chonSV +"'");
					while (result.next()) {
						diemmon.addItem(new String(result.getString("ma_mon_hoc")));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (i == 0) {
					dmdiem.setRowCount(0);
					for (QuanLyDiem x : arrdiem) {
						if (lopdiem.getSelectedItem().equals("Tất cả")) {
							String[] row = { x.getLop(), x.getMaSV(), x.getMaMon(), x.getDiem() };
							dmdiem.addRow(row);
						} else if (lopdiem.getSelectedItem().equals(x.getLop())) {
							String[] row = { x.getLop(), x.getMaSV(), x.getMaMon(), x.getDiem() };
							dmdiem.addRow(row);
						}
					}
				} else {
					dmdiem.setRowCount(0);
					for (QuanLyDiem x : arrdiem) {
						if (lopdiem.getSelectedItem().equals(x.getLop())
							&& chonSV.equals(x.getMaSV())) {
							String[] row = { x.getLop(), x.getMaSV(), x.getMaMon(), x.getDiem() };
							dmdiem.addRow(row);
						}
					}
				}
			}
		}
	};
	
	ActionListener eventChooseMonHoc = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			int i = diemmon.getSelectedIndex();
			if (i >= 0) {
				String chonLop = (String) lopdiem.getSelectedItem();
				String chonMH = (String) diemmon.getSelectedItem();
				String chonSV = (String) madiem.getSelectedItem();
				
				if (chonMH.equals("Chọn môn")) {
					dmdiem.setRowCount(0);
					for (QuanLyDiem x : arrdiem) {
						if (chonLop.equals("Tất cả") && chonSV.equals("Chọn sinh viên")) {
							String[] row = { x.getLop(), x.getMaSV(), x.getMaMon(), x.getDiem() };
							dmdiem.addRow(row);

						} else if (chonLop.equals(x.getLop()) && chonSV.equals(x.getMaSV())) {
							String[] row = { x.getLop(), x.getMaSV(), x.getMaMon(), x.getDiem() };
							dmdiem.addRow(row);

						}
					}
				} else {
					dmdiem.setRowCount(0);
					for (QuanLyDiem x : arrdiem) {
						if (chonLop.equals(x.getLop()) && chonSV.equals(x.getMaSV()) && chonMH.equals(x.getMaMon())) {
							String[] row = { x.getLop(), x.getMaSV(), x.getMaMon(), x.getDiem() };
							dmdiem.addRow(row);
						}
					}
				}
			}
		}
	};

	
	// kết thúc Chọn lớp -> mã môn học -> sinh viên

	// CRUD nhập điểm

	MouseAdapter eventTable_NhapDiem = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int row = tablediem.getSelectedRow();
			String[] col = new String[4];
			col[0] = (String) tablediem.getValueAt(row, 0);
			col[1] = (String) tablediem.getValueAt(row, 1);
			col[2] = (String) tablediem.getValueAt(row, 2);
			col[3] = (String) tablediem.getValueAt(row, 3);
			lopdiem.setSelectedItem(col[0]);
			madiem.setSelectedItem(col[1]);
			diemmon.setSelectedItem(col[2]);
			sodiem.setText(col[3]);
		}
	};

	ActionListener eventEdit_NhapDiem = new ActionListener() {
  
		@Override
		public void actionPerformed(ActionEvent arg0) {
			for (QuanLyDiem x : arrdiem) {
				if (madiem.getSelectedItem().equals(x.getMaSV())
						&& diemmon.getSelectedItem().equals(x.getMaMon())) {
					x.setLop((String) lopdiem.getSelectedItem());
					x.setDiem(sodiem.getText());
					break;
				}
			}
			Connection conn = Connect.getConnect("localhost", "Danh", "Danh", "Danh");
			try {
				String sql = "UPDATE Quan_ly_diem SET diem ='" + sodiem.getText() + "',Lop ='"
						+ lopdiem.getSelectedItem() + "' WHERE ma_mon_hoc = '" + diemmon.getSelectedItem()
						+ "' AND ma_sinh_vien ='" + madiem.getSelectedItem() + "'";
				Statement statement = conn.createStatement();
				int x = statement.executeUpdate(sql);
				if (x >= 0) {
					JOptionPane.showMessageDialog(null, "Đã sửa thông tin sinh viên");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			dmdiem.setRowCount(0);
			for (QuanLyDiem x : arrdiem) {
				if (lopdiem.getSelectedItem().equals(x.getLop())
						&& diemmon.getSelectedItem().equals(x.getMaMon())
						&& madiem.getSelectedItem().equals(x.getMaSV())) {
					String[] row = { x.getLop(), x.getMaSV(), x.getMaMon(), x.getDiem() };
					dmdiem.addRow(row);
				}
			}
			sodiem.setText("");
		}
	};

	 }

