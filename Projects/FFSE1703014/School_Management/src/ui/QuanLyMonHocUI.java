package ui;
import model.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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

public class QuanLyMonHocUI extends JPanel {
	final static Connection connection = getConnect("localhost", "ffse1703014", "admin", "123456");
	public String maMH, tenMH, tinChi, thoiLuong;
	public ArrayList<MonHoc> arrMH = new ArrayList<MonHoc>();
	public JTextField txtMaMH = new JTextField(20);
	public JTextField txtTenMH = new JTextField(20);
	public JTextField txtTinChi = new JTextField(20);
	public JTextField txtThoiLuong = new JTextField(20);
	public ImageIcon add = new ImageIcon("icons/add.png");
	public ImageIcon edit = new ImageIcon("icons/edit.png");
	public ImageIcon delete = new ImageIcon("icons/delete.png");
	public ImageIcon cancel = new ImageIcon("icons/cancel.png");
	public JButton btnThem = new JButton("Thêm", add);
	public JButton btnSua = new JButton("Sửa", edit);
	public JButton btnXoa = new JButton("Xóa", delete);
	public JButton btnHuy = new JButton("Hủy", cancel);
	public DefaultTableModel dm = new DefaultTableModel();
	public JTable tableMH = new JTable(dm) {
		public boolean isCellEditable(int row, int column) {
				return false;
		}
	};
	
	public QuanLyMonHocUI() {
		addControllers();
		addEvents();
		getMH();
		
	}

	private void addControllers() {
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		pnMain.setPreferredSize(new Dimension(800,500));
		JPanel pnCRUD = new JPanel();
		pnCRUD.setLayout(new BorderLayout());
		JPanel pnInput = new JPanel();
		pnInput.setLayout(new GridLayout(2, 2 , 100 , 10));
		JPanel pnButton = new JPanel();
		pnButton.setLayout(new FlowLayout());
		JPanel pnTable = new JPanel();
		pnTable.setLayout(new BorderLayout());
		
		JPanel pnMaMH = new JPanel();
		pnMaMH.setLayout(new GridLayout(1, 2 , -100 ,-100));
		JPanel pnTenMH = new JPanel();
		pnTenMH.setLayout(new GridLayout(1, 2 , -100 ,-100));
		JPanel pnTinChi = new JPanel();
		pnTinChi.setLayout(new GridLayout(1, 2 , -100 ,-100));
		JPanel pnThoiLuong = new JPanel();
		pnThoiLuong.setLayout(new GridLayout(1, 2 , -100 ,-100));
		
		
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder tilleBorder = BorderFactory.createTitledBorder(border, "Danh sách môn học");
		dm.addColumn("Mã môn học");
		dm.addColumn("Tên môn học");
		dm.addColumn("Số tín chỉ");
		dm.addColumn("Thời lượng học");
		JScrollPane sc = new JScrollPane(tableMH);
		pnTable.setBorder(tilleBorder);
		pnTable.add(sc, BorderLayout.CENTER);
		
		JLabel labelMaMH = new JLabel("Mã môn học: ");
		JLabel labelTenMH = new JLabel("Tên môn học: ");
		JLabel labelTinChi = new JLabel("Số tín chỉ: ");
		JLabel labelThoiLuong = new JLabel("Thời lượng học: ");
		
		pnMaMH.add(labelMaMH);
		pnMaMH.add(txtMaMH);
		
		pnTenMH.add(labelTenMH);
		pnTenMH.add(txtTenMH);
		
		pnTinChi.add(labelTinChi);
		pnTinChi.add(txtTinChi);
		
		pnThoiLuong.add(labelThoiLuong);
		pnThoiLuong.add(txtThoiLuong);
		
		pnInput.add(pnMaMH);
		pnInput.add(pnTenMH);
		pnInput.add(pnTinChi);
		pnInput.add(pnThoiLuong);
		
		pnButton.add(btnThem);
		pnButton.add(btnSua);
		pnButton.add(btnXoa);
		pnButton.add(btnHuy);
		
		pnCRUD.add(pnInput, BorderLayout.NORTH);
		pnCRUD.add(pnButton, BorderLayout.SOUTH);
		
		pnMain.add(pnCRUD);
		pnMain.add(pnTable);
		
		reset();
		
		this.add(pnMain);
		
		
	}

	private void addEvents() {
		btnThem.addActionListener(themMH);
		btnSua.addActionListener(suaMH);
		btnXoa.addActionListener(xoaMH);
		btnHuy.addActionListener(huy);
		tableMH.addMouseListener(getSelect);
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
	ActionListener themMH = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			maMH = txtMaMH.getText();
			tenMH = txtTenMH.getText();
			tinChi = txtTinChi.getText();
			thoiLuong = txtThoiLuong.getText();
			if (maMH.isEmpty() || tenMH.isEmpty() || tinChi.isEmpty() || thoiLuong.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!");
			} else {
				try {
					Statement statement =  connection.createStatement();
					ResultSet result = statement.executeQuery(
							"select * from monhoc where MaMH ='" + maMH + "' and status = ''");
					if (result.next() == true) {
						JOptionPane.showMessageDialog(null, "Môn học đã tồn tại!");
					} else {
						try {
							Statement statement2 =  connection.createStatement();
							ResultSet result2 = statement2.executeQuery(
									"select * from monhoc where MaMH ='" + maMH + "' and status ='deleted'");
							if (result2.next()) {
								try {
									String sql = "update monhoc set  TenMH ='" + tenMH + "',TinChi ='" + tinChi + "',ThoiLuongHoc ='"+ thoiLuong + "', status = '' where MaMH ='" + maMH + "'";
									Statement statements = (Statement) connection.createStatement();
									int y = statements.executeUpdate(sql);
									if (y > 0) {
										reset();
										JOptionPane.showMessageDialog(null, "Thêm môn học thành công!");
									} else {
										JOptionPane.showMessageDialog(null, "Thêm môn học thất bại!");
									}	
								} catch (Exception e2) {
									e2.printStackTrace();
								}
								try {
									String sql = "update monhoctheolop set status = '' where MaMH ='" + maMH + "'";
									Statement statements = (Statement) connection.createStatement();
									int y = statements.executeUpdate(sql);
									if (y > 0) {
										reset();
										JOptionPane.showMessageDialog(null, "Thêm môn học thành công!");
									} else {
										JOptionPane.showMessageDialog(null, "Thêm môn học thất bại!");
									}
								} catch (Exception e2) {
									e2.printStackTrace();
								}
							} else {
								try {
									String sql = "insert into monhoc value(null,'" + maMH + "','" + tenMH + "','" + tinChi + "','"+ thoiLuong + "', null)";
									Statement statements = (Statement) connection.createStatement();
									int y = statements.executeUpdate(sql);
									if (y > 0) {
										reset();
										JOptionPane.showMessageDialog(null, "Thêm môn học thành công!");
									} else {
										JOptionPane.showMessageDialog(null, "Thêm môn học thất bại!");
									}
								} catch (Exception ex) {
									ex.printStackTrace();
								}
							}
						} catch (Exception e2) {
							e2.printStackTrace();
						}
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			getMH();
		}
	};
	ActionListener suaMH = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			maMH = txtMaMH.getText();
			tenMH = txtTenMH.getText();
			tinChi = txtTinChi.getText();
			thoiLuong = txtThoiLuong.getText();
			try {
				String sql = "update monhoc set TenMH ='" + tenMH + "',TinChi ='" + tinChi + "',ThoiLuongHoc ='"+ thoiLuong + "' where MaMH ='" + maMH + "'";
				Statement statements = (Statement) connection.createStatement();
				int y = statements.executeUpdate(sql);
				if (y > 0) {
					reset();
					JOptionPane.showMessageDialog(null, "Cập nhật môn học thành công!");
				} else {
					JOptionPane.showMessageDialog(null, "Cập nhật môn học thất bại!");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			getMH();
		}
	};
	ActionListener xoaMH = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			int row = tableMH.getSelectedRow();
			maMH = dm.getValueAt(row, 0).toString();
			if (row<0) {
			} else {
				int kt = JOptionPane.showConfirmDialog(null, "Bạn có thực sự muốn xóa môn học này?", "Xóa môn học", JOptionPane.YES_NO_OPTION);
				if (kt == JOptionPane.YES_OPTION) {
					try {
						String sql = "update monhoc set status = 'deleted' where MaMH ='" + maMH + "'";
						Statement statements = (Statement) connection.createStatement();
						int y = statements.executeUpdate(sql);
						if (y > 0) {
							try {
								String sql2 = "delete from diemsinhvien where MaMH='" + maMH + "'";
								Statement statement2 = (Statement) connection.createStatement();
								int x = statement2.executeUpdate(sql2);
								if (x > 0) {
								}
							} catch (Exception ex) {
								ex.printStackTrace();
							}
							try {
								String sql2 = "update monhoctheolop set status = 'deleted' where MaMH ='" + maMH + "'";
								Statement statement2 = (Statement) connection.createStatement();
								int x = statement2.executeUpdate(sql2);
								if (x > 0) {
								}
							} catch (Exception ex) {
								ex.printStackTrace();
							}
							reset();
							JOptionPane.showMessageDialog(null, "Xóa môn học thành công!");
						} else {
							JOptionPane.showMessageDialog(null, "Xóa môn học thất bại!");
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
			getMH();
		}
	};
	ActionListener huy = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			reset();
		}
	};
	MouseListener getSelect = new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			txtMaMH.setEditable(true);
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
			int row = tableMH.getSelectedRow();
			txtMaMH.setText(dm.getValueAt(row, 0).toString());
			txtTenMH.setText(dm.getValueAt(row, 1).toString());
			txtTinChi.setText(dm.getValueAt(row, 2).toString());
			txtThoiLuong.setText(dm.getValueAt(row, 3).toString());
			disableEnable();
		}
	};

	public void getMH() {
		dm.setRowCount(0);
		arrMH.removeAll(arrMH);
		try {
			Statement statement =  connection.createStatement();
			ResultSet result = statement.executeQuery("select * from monhoc where status ='' order by MaMH ASC");
			while (result.next()) {
				arrMH.add(new MonHoc(result.getString("MaMH"), result.getString("TenMH"), result.getString("TinChi"), result.getString("ThoiLuongHoc")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (MonHoc x : arrMH) {
			dm.addRow(new String[] {x.getMaSub(),x.getTenSub(),x.getTinChi(), x.getThoiLuong()});
		}
	}
	public void disableEnable() {
		txtMaMH.setEnabled(false);
		btnThem.setEnabled(false);
		btnSua.setEnabled(true);
		btnXoa.setEnabled(true);
		btnHuy.setEnabled(true);
	}
	public void reset() {
		txtMaMH.setEnabled(true);
		btnThem.setEnabled(true);
		btnSua.setEnabled(false);
		btnXoa.setEnabled(false);
		btnHuy.setEnabled(false);
		txtMaMH.setText("");
		txtTenMH.setText("");
		txtTinChi.setText("");
		txtThoiLuong.setText("");
	}
}
