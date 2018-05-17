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
import fasttrackse.edu.vn.project4.model.LopHoc;

public class QuanLyLopHocUI extends JPanel{
	
	private static final long serialVersionUID = 1L;







	public QuanLyLopHocUI() {
	addControl();
	
	addEvent();
}


	
		private JTextField malop = new JTextField(15);
		private JTextField tenlop = new JTextField(15);
		private JTextField namhoc = new JTextField(15);

		
		private ArrayList<LopHoc> arrLH = new ArrayList<LopHoc>();
		

		int stt = 0;
		
		DefaultTableModel dm_lophoc;
		
		JTable tbl_lophoc;
		
	
		CardLayout cardlayout;
		
	
		
		
		private JPanel pnCenter2 = new JPanel();
		

		
		
		@SuppressWarnings("unused")
		private JPanel pnBorder2 = new JPanel();
		

		
		private JButton btnThemlop = new JButton("Thêm");
		private JButton btnSualop = new JButton("Sửa");
		private JButton btnXoalop = new JButton("Xoá");
		private JButton btnNhaplop = new JButton("Reset");

		
		

	


		public void addControl() {

		

			

					// quản lý lớp học

			this.setLayout(new BorderLayout());
			JLabel lbllop = new JLabel("Chương Trình Quản Lý Lớp Học");
			Font fontlop = new Font("Arial", Font.BOLD, 24);
			lbllop.setFont(fontlop);

			JPanel pnNorth2 = new JPanel();
			pnNorth2.setBackground(Color.blue);
			pnNorth2.add(lbllop);
			pnCenter2.add(pnNorth2, BorderLayout.NORTH);

			JPanel pnSouth2 = new JPanel();
			pnSouth2.setBackground(Color.blue);
			this.add(pnSouth2, BorderLayout.SOUTH);

			pnCenter2.setLayout(new BoxLayout(pnCenter2, BoxLayout.Y_AXIS));

			JPanel pnbutton2 = new JPanel();
			pnbutton2.setLayout(new FlowLayout());
			pnbutton2.add(btnThemlop);
			pnbutton2.add(btnSualop);
			pnbutton2.add(btnXoalop);
			pnbutton2.add(btnNhaplop);
			pnCenter2.add(pnbutton2);

			JPanel pnCombo2 = new JPanel();
			pnCombo2.setLayout(new FlowLayout());

			JPanel pnnhap2 = new JPanel();
			pnnhap2.setLayout(new FlowLayout());

			JPanel pnLeft2 = new JPanel();
			pnLeft2.setLayout(new BoxLayout(pnLeft2, BoxLayout.X_AXIS));
			JLabel lbl1lop = new JLabel("Mã Lớp Học :");
			pnLeft2.add(lbl1lop);
			pnLeft2.add(malop);

			JLabel lbl5lop = new JLabel("Tên Lớp Học :");
			pnLeft2.add(lbl5lop);
			pnLeft2.add(tenlop);
			pnnhap2.add(pnLeft2);

			JLabel lbl6lop = new JLabel("Năm Học :");
			pnLeft2.add(lbl6lop);
			pnLeft2.add(namhoc);
			pnnhap2.add(pnLeft2);

			pnCenter2.add(pnnhap2);

			pnCenter2.setBackground(Color.white);
			this.add(pnCenter2, BorderLayout.CENTER);
			//getContentPane().add(pnBorder2);

			JPanel pnTable2 = new JPanel();
			dm_lophoc = new DefaultTableModel();

			dm_lophoc.addColumn("Mã Lớp Học");
			dm_lophoc.addColumn("Tên Lớp");
			dm_lophoc.addColumn("Năm Học");
			

			try {
				Connection conn = Connect.getConnect("localhost", "project4", "viettu", "12345");
				Statement statement = conn.createStatement();
				ResultSet result = statement.executeQuery("SELECT * FROM Quan_ly_lop_hoc");
				while (result.next()) {
					arrLH.add(
							new LopHoc(result.getString("ma_lop"), result.getString("mo_ta"), result.getString("nam_hoc")));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			for (LopHoc x : arrLH) {
				String[] row = { x.getMalop(), x.getTenlop(), x.getNamhoc() };
				dm_lophoc.addRow(row);
			}
			tbl_lophoc = new JTable(dm_lophoc);
			JScrollPane sc2 = new JScrollPane(tbl_lophoc);
			JScrollPane VT2 = new JScrollPane(sc2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
					JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			VT2.setPreferredSize(new Dimension(1170, 520));
			pnTable2.add(VT2, BorderLayout.CENTER);
			

			Border border2 = BorderFactory.createLineBorder(Color.blue);
			TitledBorder borderTitle2 = BorderFactory.createTitledBorder(border2, "Danh sách lớp học");
			pnTable2.setBorder(borderTitle2);
			pnCenter2.add(pnTable2);

		}

		public void addEvent() {
			
			
		
			// lớp học
			tbl_lophoc.addMouseListener(eventTable_lophoc);
			btnThemlop.addActionListener(Add);
			btnSualop.addActionListener(eventEdit);
			btnXoalop.addActionListener(Del);
			btnNhaplop.addActionListener(Reset_LH);
		
			
			
		}
		
		// mouseclick lop hoc
		MouseAdapter eventTable_lophoc = new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int col = tbl_lophoc.getSelectedRow();
				String[] row = new String[3];
				row[0] = (String) tbl_lophoc.getValueAt(col, 0);
				row[1] = (String) tbl_lophoc.getValueAt(col, 1);
				row[2] = (String) tbl_lophoc.getValueAt(col, 2);
				malop.setText(row[0]);
				tenlop.setText(row[1]);
				namhoc.setText(row[2]);
				for (int i = 0; i < arrLH.size(); i++) {
					if (row[0].equals(arrLH.get(i).getMalop())) {
						stt = i;
					}
				}
			}
		};

		// them lop hoc

		ActionListener Add = new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				String ma = malop.getText();
				String ten = tenlop.getText();
				String nam = namhoc.getText();
				try {
					if (ma.equals("") || ten.equals("") || nam.equals("")) {
						JOptionPane.showMessageDialog(null, "Bạn chưa nhập thông tin cho sinh viên");
					} else {
						arrLH.add(new LopHoc(ma, ten, nam));
						dm_lophoc.addRow(new String[] { ma, ten, nam });
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				;

				Connection conn = Connect.getConnect("localhost", "project4", "viettu", "12345");
				try {

					String sql = "INSERT INTO Quan_ly_lop_hoc( ma_lop, mo_ta, nam_hoc) VALUES ('" + ma + "','" + ten + "','"
							+ nam + "')";
					Statement statement = (Statement) conn.createStatement();
					int x = statement.executeUpdate(sql);
					if (x > 0) {
						JOptionPane.showMessageDialog(null, "Đã lưu thông tin sinh viên");
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				malop.setText("");
				tenlop.setText("");
				namhoc.setText("");

			}
		};

		// sua lop hoc

		ActionListener eventEdit = new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				for (LopHoc x : arrLH) {
					if (malop.getText().equals(x.getMalop())) {
						x.setTenlop(tenlop.getText());
						x.setNamhoc(namhoc.getText());

						break;
					}
				}
				Connection conn = Connect.getConnect("localhost", "project4", "viettu", "12345");
				try {
					String sql = "UPDATE Quan_ly_lop_hoc SET mo_ta ='" + tenlop.getText() + "',nam_hoc ='"
							+ namhoc.getText() + "' WHERE ma_lop = '" + malop.getText() + "'";
					Statement statement = (Statement) conn.createStatement();
					int x = statement.executeUpdate(sql);
					if (x >= 0) {
						JOptionPane.showMessageDialog(null, "Đã sửa thông tin sinh viên");
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				dm_lophoc.setRowCount(0);
				for (LopHoc x : arrLH) {
					String[] row = { x.getMalop(), x.getTenlop(), x.getNamhoc() };
					dm_lophoc.addRow(row);
				}

			}

		};
		// xoa lop học
		ActionListener Del = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				for (LopHoc x : arrLH) {
					if (malop.getText().equals(x.getMalop())) {
						arrLH.remove(x);
						break;
					}
				}
				Connection conn = Connect.getConnect("localhost", "project4", "viettu", "12345");
				try {
					String sql = "DELETE FROM quan_ly_lop_hoc WHERE ma_lop = '" + malop.getText() + "'";
					Statement statement = conn.createStatement();
					int x = statement.executeUpdate(sql);
					if (x >= 0) {
						JOptionPane.showMessageDialog(null, "Đã xóa thông tin sinh viên");
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				dm_lophoc.setRowCount(0);
				for (LopHoc x : arrLH) {
					String[] row = { x.getMalop(), x.getTenlop(), x.getNamhoc() };
					dm_lophoc.addRow(row);
				}

			}

		};

		// reset lớp học
		ActionListener Reset_LH = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				malop.setText("");
				tenlop.setText("");
				namhoc.setText("");
			}

		};

		}
