package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.Statement;

import model.*;

public class QuanLySinhVienUI extends JPanel {
	final static Connection connection = getConnect("localhost", "ffse1703014", "admin", "123456");
	public ArrayList<SinhVien> arrSV = new ArrayList<SinhVien>();
	public ArrayList<Tinh> arrTinh = new ArrayList<Tinh>();
	public ArrayList<Huyen> arrHuyen = new ArrayList<Huyen>();
	public String id, maSV, tenSV, diaChi, tinhTP, xaPhuong, quanHuyen, sdt,email , lop, huyen;
	public JComboBox cbTinh = new JComboBox();
	public JComboBox cbHuyen = new JComboBox();
	public JComboBox cbXa = new JComboBox();
	public JComboBox cbLop = new JComboBox();
	public JPanel pnRight = new JPanel();
	public ImageIcon add = new ImageIcon("icons/add.png");
	public ImageIcon edit = new ImageIcon("icons/edit.png");
	public ImageIcon delete = new ImageIcon("icons/delete.png");
	public ImageIcon cancel = new ImageIcon("icons/cancel.png");
	public JButton btnThem = new JButton("Thêm", add);
	public JButton btnSua = new JButton("Sửa", edit);
	public JButton btnXoa = new JButton("Xóa", delete);
	public JButton btnHuy = new JButton("Hủy", cancel);
	public JTextField txtMaSV = new JTextField(20);
	public JTextField txtTenSV = new JTextField(20);
	public JTextField txtDiaChi = new JTextField(20);
	public JTextField txtSDT = new JTextField(20);
	public JTextField txtEmail = new JTextField(20);
	public DefaultTableModel dm = new DefaultTableModel();
	public JTable tableSV = new JTable(dm) {
		public boolean isCellEditable(int row, int column) {
				return false;
		}
	};
	public QuanLySinhVienUI() {
		addControllers();
		addEvents();
		addTinh();
		addlopHoc();
		getRowTable();
	}
	public void addEvents() {
		btnThem.addActionListener(ThemSV);
		btnSua.addActionListener(SuaSV);
		btnXoa.addActionListener(XoaSV);
		btnHuy.addActionListener(huy);
		cbTinh.addActionListener(cbtinh);
		cbHuyen.addActionListener(cbhuyen);
		tableSV.addMouseListener(getSelect);
	}
	
	ActionListener cbtinh = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			addHuyen();
		}
	};
	ActionListener cbhuyen = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			addXa();
		}
	};
	MouseListener getSelect = new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			txtMaSV.setEditable(true);
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			int row = tableSV.getSelectedRow();
			txtMaSV.setText(dm.getValueAt(row, 0).toString());
			txtTenSV.setText(dm.getValueAt(row, 1).toString());
			txtDiaChi.setText(dm.getValueAt(row, 2).toString());
			txtSDT.setText(dm.getValueAt(row, 6).toString());
			txtEmail.setText(dm.getValueAt(row, 7).toString());
			cbTinh.setSelectedItem(dm.getValueAt(row, 5).toString());
			cbHuyen.setSelectedItem(dm.getValueAt(row, 4).toString());
			cbXa.setSelectedItem(dm.getValueAt(row, 3).toString());
			cbLop.setSelectedItem(dm.getValueAt(row, 8).toString());
			disableEnable();
		}
	};
	ActionListener getSelectSV = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
		}
	}; 
	
	public void addTinh() {
		try {
			Statement statement = (Statement) connection.createStatement();
			ResultSet result = statement.executeQuery("select * from province order by name ASC");
			while (result.next()) {
				arrTinh.add(new Tinh(result.getString("id"),result.getString("name")));
				cbTinh.addItem(result.getString("name"));
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	public void addlopHoc() {
		cbLop.removeAllItems();
		cbLop.addItem("Chọn lớp");
		try {
			Statement statement = (Statement) connection.createStatement();
			ResultSet result = statement.executeQuery("select * from lophoc order by MaLop ASC");
			while (result.next()) {
				cbLop.addItem(result.getString("MaLop"));
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	public void addHuyen() {
		cbHuyen.removeAllItems();
		cbHuyen.addItem("Chọn quận/huyện");
		String tinh = cbTinh.getSelectedItem().toString();
		for (Tinh x : arrTinh) {
			if (x.getName().equals(tinh)) {
				id = x.getId();
			}
		}
		try {
			Statement statement = (Statement) connection.createStatement();
			ResultSet result = statement.executeQuery("select * from district where provinceid ='"+ id +"' order by name ASC");
			while (result.next()) {
				arrHuyen.add(new Huyen(result.getString("id"),result.getString("name")));
				cbHuyen.addItem(result.getString("name"));
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	public void addXa() {
		cbXa.removeAllItems();
		cbXa.addItem("Chọn xã/phường");
		if (cbHuyen.getItemCount() > 0) {
			huyen = cbHuyen.getSelectedItem().toString();
		}
		for (Huyen x : arrHuyen) {
			if (x.getName().equals(huyen)) {
				id = x.getId();
			}
		}
		try {
			Statement statement = (Statement) connection.createStatement();
			ResultSet result = statement.executeQuery("select * from ward where districtid ='"+ id +"' order by name ASC");
			while (result.next()) {
				cbXa.addItem(result.getString("name"));
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	ActionListener ThemSV = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			maSV = txtMaSV.getText();
			tenSV = txtTenSV.getText();
			diaChi = txtDiaChi.getText();
			tinhTP = cbTinh.getSelectedItem().toString();
			quanHuyen = cbHuyen.getSelectedItem().toString();
			xaPhuong = cbXa.getSelectedItem().toString();
			sdt = txtSDT.getText();
			email = txtEmail.getText();
			lop = cbLop.getSelectedItem().toString();
			if (maSV.isEmpty() || tenSV.isEmpty() || diaChi.isEmpty() || tinhTP == "Chọn tỉnh/thành phố" || quanHuyen == "Chọn quận/huyện" || xaPhuong == "Chọn xã/phường" || sdt.isEmpty() || email.isEmpty() || lop == "Chon lop") {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!");
			} else {
				try {
					Statement statement =  connection.createStatement();
					ResultSet result = statement.executeQuery(
							"select * from sinhvien where MaSV ='" + maSV + "'");
					if (result.next() == true) {
						JOptionPane.showMessageDialog(null, "Thông tin sinh viên đã tồn tại!");
					} else {
						try {
							String sql = "insert into sinhvien value(null,'" + maSV + "','" + tenSV + "','" + diaChi + "','"+ xaPhuong + "','"+quanHuyen+ "','"+tinhTP+ "','"+sdt+ "','"+email+ "','"+lop+ "')";
							Statement statements = (Statement) connection.createStatement();
							int y = statements.executeUpdate(sql);
							if (y > 0) {
								reset();
								JOptionPane.showMessageDialog(null, "Thêm thông tin sinh viên thành công!");
							} else {
								JOptionPane.showMessageDialog(null, "Thêm thông tin sinh viên thất bại!");
							}
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			getRowTable();
		}
	};
	ActionListener SuaSV = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			maSV = txtMaSV.getText();
			tenSV = txtTenSV.getText();
			diaChi = txtDiaChi.getText();
			tinhTP = cbTinh.getSelectedItem().toString();
			quanHuyen = cbHuyen.getSelectedItem().toString();
			xaPhuong = cbXa.getSelectedItem().toString();
			sdt = txtSDT.getText();
			email = txtEmail.getText();
			lop = cbLop.getSelectedItem().toString();
			try {
				String sql = "update sinhvien set TenSV ='" + tenSV + "',DiaChi ='" + diaChi + "',XaPhuong ='"+ xaPhuong + "',QuanHuyen ='"+quanHuyen+ "',TinhTP ='"+tinhTP+ "',Phone ='"+sdt+ "',Email ='"+email+ "',LopHoc ='"+lop+ "' where MaSV ='" + maSV + "'";
				Statement statements = (Statement) connection.createStatement();
				int y = statements.executeUpdate(sql);
				if (y > 0) {
					reset();
					JOptionPane.showMessageDialog(null, "Cập nhật thông tin sinh viên thành công!");
				} else {
					JOptionPane.showMessageDialog(null, "Cập nhật thông tin sinh viên thất bại!");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			getRowTable();
		}
	};
	ActionListener XoaSV = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			int row = tableSV.getSelectedRow();
			if (row<0) { 
			} else {
				int kt = JOptionPane.showConfirmDialog(null, "Bạn có thực sự muốn xóa sinh viên này?", "Xóa sinh viên", JOptionPane.YES_NO_OPTION);
				if (kt == JOptionPane.YES_OPTION) {
					try {
						String sql = "delete from sinhvien where MaSV='" + dm.getValueAt(row, 0) + "'";
						Statement statement = (Statement) connection.createStatement();
						int x = statement.executeUpdate(sql);
						if (x > 0) {
							reset();
							JOptionPane.showMessageDialog(null, "Xóa sinh viên thành công!");
						} else {
							JOptionPane.showMessageDialog(null, "Xóa sinh viên thất bại!");
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
			getRowTable();
		}
	};
	ActionListener huy = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			reset();
		}
	};
	public  void addControllers() {
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		pnMain.setPreferredSize(new Dimension(800,500));
		JPanel pnCRUD = new JPanel();
		pnCRUD.setLayout(new BorderLayout());
		JPanel pnInput = new JPanel();
		pnInput.setLayout(new GridLayout(3, 3 , 10,10));
		JPanel pnButton = new JPanel();
		pnButton.setLayout(new FlowLayout());
		JPanel pnTable = new JPanel();
		pnTable.setLayout(new BorderLayout());
		
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder tilleBorder = BorderFactory.createTitledBorder(border, "Danh sách sinh viên");
		dm.addColumn("Mã");
		dm.addColumn("Tên");
		dm.addColumn("Địa chỉ");
		dm.addColumn("Xã/Phường");
		dm.addColumn("Quận/Huyện");
		dm.addColumn("Tỉnh/Thành phố");
		dm.addColumn("Số điện thoại");
		dm.addColumn("Email");
		dm.addColumn("Lớp");
		JScrollPane sc = new JScrollPane(tableSV);
		pnTable.setBorder(tilleBorder);
		pnTable.add(sc, BorderLayout.CENTER);
		
		JPanel pnMaSV = new JPanel();
		pnMaSV.setLayout(new GridLayout(1, 2));
		JPanel pnTenSV = new JPanel();
		pnTenSV.setLayout(new GridLayout(1, 2));
		JPanel pnDiaChi = new JPanel();
		pnDiaChi.setLayout(new GridLayout(1, 2));
		JPanel pnTinh = new JPanel();
		pnTinh.setLayout(new GridLayout(1, 2));
		JPanel pnHuyen = new JPanel();
		pnHuyen.setLayout(new GridLayout(1, 2));
		JPanel pnXa = new JPanel();
		pnXa.setLayout(new GridLayout(1, 2));
		JPanel pnSDT = new JPanel();
		pnSDT.setLayout(new GridLayout(1, 2));
		JPanel pnEmail = new JPanel();
		pnEmail.setLayout(new GridLayout(1, 2));
		JPanel pnLop = new JPanel();
		pnLop.setLayout(new GridLayout(1, 2));
		
		JLabel labelMaSV = new JLabel("Mã sinh viên: ");
		JLabel labelTenSV = new JLabel("Tên sinh viên: ");
		JLabel labelDiaChi = new JLabel("Địa chỉ: ");
		JLabel labelTinh = new JLabel("Tỉnh/Thành phố: ");
		JLabel labelHuyen = new JLabel("Quận/Huyện: ");
		JLabel labelXa = new JLabel("Xã/Phường: ");
		JLabel labelSDT = new JLabel("Số điện thoại: ");
		JLabel labelEmail = new JLabel("Email: ");
		JLabel labelLop = new JLabel("Lớp: ");
		
		pnMaSV.add(labelMaSV);
		pnMaSV.add(txtMaSV);
		
		pnTenSV.add(labelTenSV);
		pnTenSV.add(txtTenSV);
		
		pnDiaChi.add(labelDiaChi);
		pnDiaChi.add(txtDiaChi);
		
		pnTinh.add(labelTinh);
		pnTinh.add(cbTinh);
		cbTinh.addItem("Chọn tỉnh/thành phố");
		
		pnHuyen.add(labelHuyen);
		pnHuyen.add(cbHuyen);
		cbHuyen.addItem("Chọn quận/huyện");
		
		pnXa.add(labelXa);
		pnXa.add(cbXa);
		cbXa.addItem("Chọn xã/phường");
		
		pnSDT.add(labelSDT);
		pnSDT.add(txtSDT);
		
		pnEmail.add(labelEmail);
		pnEmail.add(txtEmail);
		
		pnLop.add(labelLop);
		pnLop.add(cbLop);
		
		pnInput.add(pnMaSV);
		pnInput.add(pnTenSV);
		pnInput.add(pnDiaChi);
		pnInput.add(pnTinh);
		pnInput.add(pnHuyen);
		pnInput.add(pnXa);
		pnInput.add(pnSDT);
		pnInput.add(pnEmail);
		pnInput.add(pnLop);
		
		pnButton.add(btnThem);
		pnButton.add(btnSua);
		pnButton.add(btnXoa);
		pnButton.add(btnHuy);
		
		pnCRUD.add(pnInput, BorderLayout.NORTH);
		pnCRUD.add(pnButton, BorderLayout.SOUTH);
		pnMain.add(pnCRUD);
		pnMain.add(pnTable);
		this.add(pnMain);
		
		reset();
	}
	public void getRowTable() {
		dm.setRowCount(0);
		arrSV.removeAll(arrSV);
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
			dm.addRow(new String[] {x.getMaSV(),x.getTenSV(),x.getDiaChi(),x.getPhuong(),x.getQuan(),x.getTinhTP(),x.getDienThoai(),x.getEmail(),x.getLop()});
		}
	}
	public void reset() {
		txtMaSV.setEnabled(true);
		btnSua.setEnabled(false);
		btnXoa.setEnabled(false);
		btnHuy.setEnabled(false);
		btnThem.setEnabled(true);
		txtMaSV.setText("");
		txtTenSV.setText("");
		txtDiaChi.setText("");
		cbTinh.setSelectedItem("Chọn tỉnh/thành phố");
		cbHuyen.setSelectedItem("Chọn quận/huyện");
		cbXa.setSelectedItem("Chọn xã/phường");
		txtSDT.setText("");
		txtEmail.setText("");
		cbLop.setSelectedItem("Chọn lớp");
	}
	public void disableEnable() {
		txtMaSV.setEnabled(false);
		btnSua.setEnabled(true);
		btnXoa.setEnabled(true);
		btnHuy.setEnabled(true);
		btnThem.setEnabled(false);
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
