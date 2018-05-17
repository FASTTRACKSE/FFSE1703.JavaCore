
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

public class MonHocUI extends JPanel {
	private static final long serialVersionUID = 1L;


	private JButton btnThemMon = new JButton("Thêm");
	private JButton btnSuaMon = new JButton("Sửa");
	private JButton btnXoaMon = new JButton("Xóa");
	private JButton btnNhapMon = new JButton("Nhập");
	private DefaultTableModel dmMhoc;
	private JScrollPane scMonHoc;
	private JTable tblMonHoc;



	private JTextField maMhoc = new JTextField(), tenMhoc = new JTextField(), soTinChi = new JTextField(),
			gioHoc = new JTextField();// monHoc

	private ArrayList<QuanLyMonHocModel> arrMH = new ArrayList<QuanLyMonHocModel>();

	
	public MonHocUI() {
		addControls();
		addEvents();

	}

	public void addControls() {

		this.setLayout(new FlowLayout());

		Border border4 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle4 = BorderFactory.createTitledBorder(border4, "NHẬP THÔNG TIN");
		this.setBorder(borderTitle4);


		JPanel nhapMaMhoc4 = new JPanel();
		maMhoc = new JTextField(12);
		JLabel lblNhapMaMhoc4 = new JLabel("Mã Môn Học :");
		nhapMaMhoc4.add(lblNhapMaMhoc4);
		nhapMaMhoc4.add(maMhoc);
		this.add(nhapMaMhoc4);

		JPanel nhapTenMhoc4 = new JPanel();
		nhapTenMhoc4.setLayout(new FlowLayout());
		tenMhoc = new JTextField(12);
		JLabel lblnhapTenMhoc4 = new JLabel("Tên Môn Học:");
		nhapTenMhoc4.add(lblnhapTenMhoc4);
		nhapTenMhoc4.add(tenMhoc);
		this.add(nhapTenMhoc4);

		JPanel nhapSoTC4 = new JPanel();
		nhapSoTC4.setLayout(new FlowLayout());
		soTinChi = new JTextField(12);
		JLabel lblnhapSoTinChi4 = new JLabel("Số tín chỉ:");
		nhapSoTC4.add(lblnhapSoTinChi4);
		nhapSoTC4.add(soTinChi);
		this.add(nhapSoTC4);

		JPanel nhapGioHoc4 = new JPanel();
		nhapGioHoc4.setLayout(new FlowLayout());
		gioHoc = new JTextField(12);
		JLabel lblsoGioHoc4 = new JLabel("Giờ học:");
		nhapGioHoc4.add(lblsoGioHoc4);
		nhapGioHoc4.add(gioHoc);
		this.add(nhapGioHoc4);

		JPanel chucNang4 = new JPanel();
		chucNang4.setLayout(new FlowLayout());
		chucNang4.add(btnThemMon);
		chucNang4.add(btnSuaMon);
		chucNang4.add(btnXoaMon);
		chucNang4.add(btnNhapMon);
		

		this.add(chucNang4);

		JPanel pnTable2 = new JPanel();

		dmMhoc = new DefaultTableModel();


		dmMhoc.addColumn("Mã Môn Học");
		dmMhoc.addColumn("Tên Môn Học");
		dmMhoc.addColumn("Số Tín Chỉ");
		dmMhoc.addColumn("Giờ Học");

		 Connection con2 = Connect.getConnect("localhost", "quanlysinhvien", "quanlysinhvien", "12345");
		 try {
		 Statement statement = con2.createStatement();
		 ResultSet result = statement.executeQuery("SELECT * FROM table_monhoc");
		 while (result.next()) {
		 arrMH.add(new QuanLyMonHocModel(result.getString("ma_monhoc"),result.getString("ten_monhoc"),result.getString("soTinChi"),result.getString("gioHoc")));

		 }
		 } catch (Exception e) {
		 e.printStackTrace();
		 }
		
		 for (QuanLyMonHocModel x : arrMH) {
		 String[] row = { x.getMaMonHoc(), x.getTenMonHoc(), x.getSoTinChi(), x.getGioHoc()};
		 dmMhoc.addRow(row);
		 }

		tblMonHoc = new JTable(dmMhoc);
		scMonHoc = new JScrollPane(tblMonHoc);
		JScrollPane VT2 = new JScrollPane(scMonHoc, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		VT2.setPreferredSize(new Dimension(1300, 370));
		pnTable2.add(VT2, BorderLayout.CENTER);


		Border border5 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle5 = BorderFactory.createTitledBorder(border5, "Danh sách");
		pnTable2.setBorder(borderTitle5);
		this.add(pnTable2);


	}

	public void addEvents() {

		tblMonHoc.addMouseListener(eventTableMH);
		btnThemMon.addActionListener(eventAddMonHoc);	
		btnSuaMon.addActionListener(eventEditMonHoc);
		btnNhapMon.addActionListener(eventReset_MonHoc);
		btnXoaMon.addActionListener(eventDelMonHoc);
		

}


	MouseAdapter eventTableMH = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int row = tblMonHoc.getSelectedRow();
			String[] col = new String[9];
			col[0] = (String) tblMonHoc.getValueAt(row, 0);
			col[1] = (String) tblMonHoc.getValueAt(row, 1);
			col[2] = (String) tblMonHoc.getValueAt(row, 2);
			col[3] = (String) tblMonHoc.getValueAt(row, 3);



			maMhoc.setEditable(false);
			maMhoc.setText(col[0]);
			tenMhoc.setText(col[1]);
			soTinChi.setText(col[2]);
			gioHoc.setText(col[3]);


		}
	};
	
	ActionListener eventAddMonHoc = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String maMH = maMhoc.getText();
			String tenMH = tenMhoc.getText();
			String tinchi = soTinChi.getText();
			String giohoc = gioHoc.getText();
			int i =0;
			for (QuanLyMonHocModel y : arrMH) {
				if (maMH.equals(y.getMaMonHoc())) {
					i = 1;
			}
			}
			if(i>0) {
				JOptionPane.showMessageDialog(null, "Trùng mã môn học");
			}else {

			try {
				if (maMH.equals("") || tenMH.equals("") || tinchi.equals("") || giohoc.equals("")) {
					JOptionPane.showMessageDialog(null, "Bạn chưa nhập thông tin");
				} else {
					arrMH.add(new QuanLyMonHocModel( maMH, tenMH, tinchi, giohoc));
					dmMhoc.addRow(new String[] {  maMH, tenMH, tinchi, giohoc});
					Connection conn = Connect.getConnect("localhost", "quanlysinhvien", "quanlysinhvien", "12345");
					try {
						String sql = "INSERT INTO table_monhoc(ma_monHoc, ten_monHoc , soTinChi, gioHoc) VALUES('"
								+ maMH + "','" + tenMH + "','" + tinchi + "','"
								+ giohoc + "')";
						Statement statement = conn.createStatement();
						int x = statement.executeUpdate(sql);
						if (x > 0) {
							JOptionPane.showMessageDialog(null, "Đã lưu thông tin môn học");
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Bạn cần nhập thông tin sinh viên");
			}
			}
		}
	};
	ActionListener eventEditMonHoc = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			for (QuanLyMonHocModel x : arrMH) {
				if ((maMhoc.getText()).equals(x.getMaMonHoc())) {
					x.setMaMonHoc(maMhoc.getText());
					x.setTenMonHoc( tenMhoc.getText());
					x.setSoTinChi( soTinChi.getText());
					x.setGioHoc(gioHoc.getText());
					break;
				}
			}
			Connection conn = Connect.getConnect("localhost", "quanlysinhvien", "quanlysinhvien", "12345");
			try {
				String sql = "UPDATE table_monhoc SET ma_monHoc='" + maMhoc.getText() + "',ten_monHoc='" + tenMhoc.getText()
						 + "',soTinChi='" + soTinChi.getText()
						+ "',gioHoc='" + gioHoc.getText() + "' WHERE ma_monHoc = '" + maMhoc.getText() +"'";
				Statement statement = conn.createStatement();
				int x = statement.executeUpdate(sql);
				if (x >= 0) {
					JOptionPane.showMessageDialog(null, "Đã sửa thông tin môn học");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			dmMhoc.setRowCount(0);
			for (QuanLyMonHocModel x : arrMH) {
				String[] row = { x.getMaMonHoc(), x.getTenMonHoc(), x.getSoTinChi(), x.getGioHoc() };
				dmMhoc.addRow(row);
			}

		}

	};
	ActionListener eventDelMonHoc = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			for (QuanLyMonHocModel x : arrMH) {
				if (maMhoc.getText().equals(x.getMaMonHoc())) {
					arrMH.remove(x);
					break;
				}
			}
			Connection conn = Connect.getConnect("localhost", "quanlysinhvien", "quanlysinhvien", "12345");
			try {
				String sql = "DELETE FROM table_monhoc WHERE ma_monhoc = '" + maMhoc.getText() + "'";
				Statement statement = conn.createStatement();
				int x = statement.executeUpdate(sql);
				if (x >= 0) {
					JOptionPane.showMessageDialog(null, "Đã xóa thông tin sinh viên");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			dmMhoc.setRowCount(0);
			for (QuanLyMonHocModel x : arrMH) {
				String[] row = { x.getMaMonHoc(), x.getTenMonHoc(), x.getSoTinChi(), x.getGioHoc() };
				dmMhoc.addRow(row);
			}
		}

	};
	
	ActionListener eventReset_MonHoc = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			maMhoc.setEditable(true);
			maMhoc.setText("");
			tenMhoc.setText("");
			soTinChi.setText("");
			gioHoc.setText("");


		}
	};
	
}

