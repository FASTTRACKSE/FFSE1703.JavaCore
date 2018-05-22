package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.fabric.xmlrpc.base.Array;
import com.mysql.jdbc.Driver;

import model.*;
public class QuanLyDiemSinhVienUI extends JPanel {
	final static Connection connection = getConnect("localhost", "ffse1703014", "admin", "123456");
	public String maLH, maMH, maSV, diem;
	public ArrayList<SinhVien> arrSV = new ArrayList<SinhVien>();
	public ArrayList<LopHoc> arrLH = new ArrayList<LopHoc>();
	public ArrayList<MonHocTheoLop> arrMHL = new ArrayList<MonHocTheoLop>();
	public ArrayList<DiemSinhVIen> arrDiem = new ArrayList<DiemSinhVIen>();
	public JComboBox CbLop = new JComboBox();
	public JComboBox CbMon = new JComboBox();
	public ImageIcon add = new ImageIcon("icons/add.png");
	public ImageIcon edit = new ImageIcon("icons/edit.png");
	public ImageIcon delete = new ImageIcon("icons/delete.png");
	public ImageIcon cancel = new ImageIcon("icons/cancel.png");
	public JButton btnThem = new JButton("Thêm", add);
	public JButton btnSua = new JButton("Sửa", edit);
	public JButton btnXoa = new JButton("Xóa", delete);
	public JButton btnHuy = new JButton("Hủy", cancel);
	public JTextField txtDiem = new JTextField();
	public DefaultTableModel dmSV = new DefaultTableModel();
	public DefaultTableModel dmDiem = new DefaultTableModel();
	public JTable tableSV = new JTable(dmSV) {
		public boolean isCellEditable(int row, int column) {
				return false;
		}
	};
	public JTable tableDiem = new JTable(dmDiem) {
		public boolean isCellEditable(int row, int column) {
				return false;
		}
	};
	public QuanLyDiemSinhVienUI() {
		addControllers();
		addEvents();
		getLopHoc();
		
	}
	private void addControllers() {
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BorderLayout());
		pnMain.setPreferredSize(new Dimension(800,500));
		
		JPanel pnSinhVien = new JPanel();
		pnSinhVien.setLayout(new BorderLayout());
		pnSinhVien.setPreferredSize(new Dimension(800, 250));
		
		JPanel pnDiemMon = new JPanel();
		pnDiemMon.setLayout(new BorderLayout());
		
		JPanel pnCbLopHoc = new JPanel();
		pnCbLopHoc.setLayout(new GridLayout(1, 2, 50, 50));
		
		JPanel pnTableSV = new JPanel();
		pnTableSV.setLayout(new BorderLayout());
		
		JPanel pnCRUD = new JPanel();
		pnCRUD.setLayout(new GridLayout(1, 3, 10, 10));
		pnCRUD.setPreferredSize(new Dimension(800, 30));
		
		JPanel pnCbMonHoc = new JPanel();
		pnCbMonHoc.setLayout(new GridLayout(1, 2, -80, -80));
		CbMon.addItem("Chọn môn học");
		
		JPanel pnInput = new JPanel();
		pnInput.setLayout(new GridLayout(1, 2, 10, 10));
		
		JPanel pnDiem = new JPanel();
		pnDiem.setLayout(new GridLayout(1, 2, -80, -80));
		
		JPanel pnButton = new JPanel();
		pnButton.setLayout(new GridLayout(1, 4, 5, 5));
		
		JPanel pnTableDiem = new JPanel();
		pnTableDiem.setLayout(new BorderLayout());
		
		JLabel labelLop = new JLabel("Lớp: ");
		JLabel labelMon = new JLabel("Môn: ");
		JLabel labelDiem = new JLabel("Điểm: ");
		
		Border border1 = BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder tilleBorder1 = BorderFactory.createTitledBorder(border1, "Danh sách sinh viên");
		dmSV.addColumn("Mã sinh viên");
		dmSV.addColumn("Tên sinh viên");
		JScrollPane sc1 = new JScrollPane(tableSV);
		pnTableSV.setBorder(tilleBorder1);
		pnTableSV.add(sc1, BorderLayout.CENTER);
		
		Border border2 = BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder tilleBorder2 = BorderFactory.createTitledBorder(border2, "Danh sách điểm môn học");
		dmDiem.addColumn("Mã môn học");
		dmDiem.addColumn("Điểm môn học");
		JScrollPane sc2 = new JScrollPane(tableDiem);
		pnTableDiem.setBorder(tilleBorder2);
		pnTableDiem.add(sc2, BorderLayout.CENTER);
		
		pnCbLopHoc.add(labelLop);
		pnCbLopHoc.add(CbLop);
		
		pnCbMonHoc.add(labelMon);
		pnCbMonHoc.add(CbMon);
		
		pnDiem.add(labelDiem);
		pnDiem.add(txtDiem);
		
		pnButton.add(btnThem);
		pnButton.add(btnSua);
		pnButton.add(btnXoa);
		pnButton.add(btnHuy);
		
		pnInput.add(pnCbMonHoc);
		pnInput.add(pnDiem);
		
		pnCRUD.add(pnInput);
		pnCRUD.add(pnButton);
		
		pnSinhVien.add(pnCbLopHoc, BorderLayout.NORTH);
		pnSinhVien.add(pnTableSV, BorderLayout.CENTER);
		
		pnDiemMon.add(pnCRUD, BorderLayout.NORTH);
		pnDiemMon.add(pnTableDiem, BorderLayout.CENTER);
		
		pnMain.add(pnSinhVien, BorderLayout.NORTH);
		pnMain.add(pnDiemMon, BorderLayout.CENTER);
		
		this.add(pnMain);
		
		reset();
	}
	private void addEvents() {
		btnThem.addActionListener(ThemDiemSV);
		btnSua.addActionListener(SuaDiemSV);
		btnXoa.addActionListener(XoaDiemSV);
		btnHuy.addActionListener(huy);
		CbLop.addActionListener(getSV);
		tableSV.addMouseListener(getSelectSV);
		tableDiem.addMouseListener(getSelectDiemSV);
	}
	MouseListener getSelectSV = new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			dmDiem.setRowCount(0);
			arrDiem.removeAll(arrDiem);
			int row = tableSV.getSelectedRow();
			maSV = dmSV.getValueAt(row, 0).toString();
			try {
				Statement statement =  connection.createStatement();
				ResultSet result = statement.executeQuery("SELECT * FROM diemsinhvien  WHERE MaSV = '"+ maSV +"' order by MaMH ASC");
				while (result.next()) {
					arrDiem.add(new DiemSinhVIen(result.getString("MaMH"), result.getString("Diem")));
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			for (DiemSinhVIen x : arrDiem) {
				dmDiem.addRow(new String[] {x.maMH,x.diemMH});
			}
			reset();
			getMonHoc();
		}
	};
	MouseListener getSelectDiemSV = new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			int row = tableDiem.getSelectedRow();
			CbMon.setSelectedItem(dmDiem.getValueAt(row, 0).toString());
			txtDiem.setText(dmDiem.getValueAt(row, 1).toString());
			disableEnable();
		}
	};
	ActionListener ThemDiemSV = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			int row = tableSV.getSelectedRow();
			if (row == -1) {
			} else {
				maSV = dmSV.getValueAt(row, 0).toString();
				maMH = CbMon.getSelectedItem().toString();
				diem = txtDiem.getText();
				int diemMH = Integer.parseInt(diem);
				if (maMH == "Chọn môn học" && txtDiem.getText() == null) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn môn học!");
				} else {
					if (diemMH < 0 || diemMH >10 || diem.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Vui lòng nhập lại!");
					} else {
						try {
							Statement statement =  connection.createStatement();
							ResultSet result = statement.executeQuery(
									"select * from diemsinhvien where MaSV ='" + maSV + "' and MaMH = '"+ maMH +"'");
							if (result.next() == true) {
								
							} else {
								try {
									String sql = "insert into diemsinhvien value(null,'" + maSV + "','" + maMH + "','"+ diem +"')";
									Statement statements = (Statement) connection.createStatement();
									int y = statements.executeUpdate(sql);
									if (y > 0) {
										reset();
										JOptionPane.showMessageDialog(null, "Nhập điểm môn học thành công!");
									} else {
										JOptionPane.showMessageDialog(null, "Nhập điểm môn học học thất bại!");
									}
								} catch (Exception ex) {
									ex.printStackTrace();
								}
							}
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				}
				getDiemSV();
			}
		}
	};
	ActionListener SuaDiemSV = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			int row = tableSV.getSelectedRow();
			if (row == -1) {
			} else {
				maSV = dmSV.getValueAt(row, 0).toString();
				diem = txtDiem.getText();
				maMH = CbMon.getSelectedItem().toString();
				int diemMH = Integer.parseInt(diem);
				
				if (diemMH < 0 || diemMH > 10) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập lại!");
				} else {
					try {
						String sql = "update diemsinhvien set Diem ='" + diem + "' where MaSV ='" + maSV + "' and MaMH = '"+ maMH +"'";
						Statement statements = (Statement) connection.createStatement();
						int y = statements.executeUpdate(sql);
						if (y > 0) {
							reset();
							JOptionPane.showMessageDialog(null, "Cập nhật điểm thành công!");
						} else {
							JOptionPane.showMessageDialog(null, "Cập nhật điểm thất bại!");
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				getDiemSV();
			}
		}
	};
	ActionListener XoaDiemSV = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int row1 = tableSV.getSelectedRow();
			if (row1 < 0) {
			} else {
				maSV = dmSV.getValueAt(row1, 0).toString();
				int row2 = tableDiem.getSelectedRow();
				maMH = dmDiem.getValueAt(row2, 0).toString();
				if (row2<0) {	
				} else {
					int kt = JOptionPane.showConfirmDialog(null, "Bạn có thực sự muốn xóa điểm môn học này?", "Xóa lớp học", JOptionPane.YES_NO_OPTION);
					if (kt == JOptionPane.YES_OPTION) {
						try {
							String sql = "delete from diemsinhvien where MaSV='" + maSV + "' and MaMH = '"+maMH+"'";
							Statement statement = (Statement) connection.createStatement();
							int x = statement.executeUpdate(sql);
							if (x > 0) {
								reset();
								JOptionPane.showMessageDialog(null, "Xóa điểm môn học thành công!");
							} else {
								JOptionPane.showMessageDialog(null, "Xóa điểm thất bại!");
							}
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
				}
				getDiemSV();
			}
		}
	};
	ActionListener huy = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			reset();
		}
	};
	ActionListener getSV = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			dmSV.setRowCount(0);
			arrSV.removeAll(arrSV);
			maLH = CbLop.getSelectedItem().toString();
			if (maLH.equals("Chọn lớp học")) {
				try {
					Statement statement = (Statement) connection.createStatement();
					ResultSet result = statement.executeQuery("select * from sinhvien order by MaSV ASC");
					while (result.next()) {
						arrSV.add(new SinhVien (result.getString("MaSV"),result.getString("TenSV"), result.getString("DiaChi"),result.getString("XaPhuong"),result.getString("QuanHuyen"),result.getString("TinhTP"),result.getString("Phone"),result.getString("Email"),result.getString("LopHoc")));
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				for (SinhVien x : arrSV) {
					dmSV.addRow(new String[] {x.getMaSV(),x.getTenSV()});
				}
			} else {
				try {
					Statement statement = (Statement) connection.createStatement();
					ResultSet result = statement.executeQuery("select * from sinhvien where LopHoc = '"+ maLH +"' order by MaSV ASC");
					while (result.next()) {
						arrSV.add(new SinhVien (result.getString("MaSV"),result.getString("TenSV"), result.getString("DiaChi"),result.getString("XaPhuong"),result.getString("QuanHuyen"),result.getString("TinhTP"),result.getString("Phone"),result.getString("Email"),result.getString("LopHoc")));
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				for (SinhVien x : arrSV) {
					dmSV.addRow(new String[] {x.getMaSV(),x.getTenSV()});
				}
			}
		}
	};
	
	public void getLopHoc() {
		CbLop.removeAllItems();
		CbLop.addItem("Chọn lớp học");
		try {
			Statement statement =  connection.createStatement();
			ResultSet result = statement.executeQuery("select * from lophoc order by MaLop ASC");
			while (result.next()) {
				arrLH.add(new LopHoc(result.getString("MaLop"), result.getString("TenLop"), result.getString("NamHoc")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (LopHoc x : arrLH) {
			CbLop.addItem(x.maLop);
		}

	}
	public void getMonHoc() {
		int row = tableSV.getSelectedRow();
		maSV = dmSV.getValueAt(row, 0).toString();
		arrMHL.removeAll(arrMHL);
		CbMon.removeAllItems();
		CbMon.addItem("Chọn môn học");
		for (SinhVien x : arrSV) {
			if (x.getMaSV().equals(maSV)) {
				maLH = x.getLop();
			}
		}
		try {
			Statement statement =  connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT monhoctheolop.MaLH, monhoctheolop.MaMH, monhoc.TenMH FROM monhoctheolop INNER JOIN monhoc ON monhoctheolop.MaMH = monhoc.MaMH WHERE MaLH = '"+ maLH +"' order by MaMH ASC");
			while (result.next()) {
				arrMHL.add(new MonHocTheoLop(result.getString("MaMH"), result.getString("TenMH")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (MonHocTheoLop x : arrMHL) {
			CbMon.addItem(x.maMH);
		}
	}
	public void getDiemSV() {
		arrDiem.removeAll(arrDiem);
		dmDiem.setRowCount(0);
		int row = tableSV.getSelectedRow();
		maSV = dmSV.getValueAt(row, 0).toString();
		try {
			Statement statement = (Statement) connection.createStatement();
			ResultSet result = statement.executeQuery("select * from diemsinhvien where MaSV = '"+ maSV +"' order by MaMH ASC");
			while (result.next()) {
				arrDiem.add(new DiemSinhVIen(result.getString("MaMH"), result.getString("Diem")));
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		for (DiemSinhVIen x : arrDiem) {
			dmDiem.addRow(new String[] {x.maMH,x.diemMH});
		}
	}
	public void reset() {
		CbMon.setSelectedItem("Chọn môn học");
		CbMon.setEnabled(true);
		txtDiem.setText("");
		btnThem.setEnabled(true);
		btnSua.setEnabled(false);
		btnXoa.setEnabled(false);
		btnHuy.setEnabled(false);
	}
	public void disableEnable() {
		CbMon.setEnabled(false);
		btnThem.setEnabled(false);
		btnSua.setEnabled(true);
		btnXoa.setEnabled(true);
		btnHuy.setEnabled(true);
	}
	public static Connection getConnect(String strServer, String strDatabase, String strUser, String strPwd) {
		Connection conn = null;
		String strConnect = "jdbc:mysql://" + strServer + "/" + strDatabase+"?useUnicode=true&characterEncoding=UTF-8";
		Properties pro = new Properties();
		pro.put("user", strUser);
		pro.put("password", strPwd);
		try {
			Driver driver = new Driver();
			conn = driver.connect(strConnect, pro);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return conn;
	}
}
