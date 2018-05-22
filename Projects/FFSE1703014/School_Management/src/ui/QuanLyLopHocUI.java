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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.BorderFactory;
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

import model.LopHoc;
import model.MonHoc;
import model.MonHocTheoLop;

public class QuanLyLopHocUI extends JPanel {
	final static Connection connection = getConnect("localhost", "ffse1703014", "admin", "123456");
	public String maLop, tenLop, namHoc, maMH, tenMH;
	public ArrayList<LopHoc> arrLH = new ArrayList<LopHoc>();
	public ArrayList<MonHoc> arrMH = new ArrayList<MonHoc>();
	public ArrayList<MonHocTheoLop> arrMHL = new ArrayList<MonHocTheoLop>();
	public JTextField txtMaLH = new JTextField();
	public JTextField txtTenLH = new JTextField();
	public JTextField txtNamHoc = new JTextField();
	public ImageIcon add = new ImageIcon("icons/add.png");
	public ImageIcon edit = new ImageIcon("icons/edit.png");
	public ImageIcon delete = new ImageIcon("icons/delete.png");
	public ImageIcon cancel = new ImageIcon("icons/cancel.png");
	public JButton btnThem = new JButton("Thêm", add);
	public JButton btnSua = new JButton("Sửa", edit);
	public JButton btnXoa = new JButton("Xóa", delete);
	public JButton btnHuy = new JButton("Hủy", cancel);
	public JButton btnThemMH = new JButton("Thêm môn học", add);
	public JButton btnXoaMH = new JButton("Xóa môn học", delete);
	public JComboBox cbMonHoc = new JComboBox();
	public DefaultTableModel dmLH = new DefaultTableModel();
	public DefaultTableModel dmMH = new DefaultTableModel();
	public JTable tableLH = new JTable(dmLH) {
		public boolean isCellEditable(int row, int column) {
				return false;
		}
	};
	public JTable tableMH = new JTable(dmMH) {
		public boolean isCellEditable(int row, int column) {
				return false;
		}
	};
	
	public QuanLyLopHocUI() {
		addController();
		addEvents();
		getLopHoc();
		getMonHoc();
	}

	private void addController() {
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BorderLayout());
		pnMain.setPreferredSize(new Dimension(800,500));
		JPanel pnLopHoc = new JPanel();
		pnLopHoc.setLayout(new BorderLayout());
		JPanel pnMonHoc = new JPanel();
		pnMonHoc.setLayout(new BorderLayout());
		pnMonHoc.setPreferredSize(new Dimension(800, 250));
		JPanel pnCRUD = new JPanel();
		pnCRUD.setLayout(new BorderLayout());
		JPanel pnInput = new JPanel();
		pnInput.setLayout(new GridLayout(1, 2 , 10 , 10));
		JPanel pnButton = new JPanel();
		pnButton.setLayout(new FlowLayout());
		JPanel pnTableLH = new JPanel();
		pnTableLH.setLayout(new BorderLayout());
		JPanel pnTableMH = new JPanel();
		pnTableMH.setLayout(new BorderLayout());
		
		JPanel pnMaLH = new JPanel();
		pnMaLH.setLayout(new GridLayout(1, 2 , -50 ,-50));
		JPanel pnTenLH = new JPanel();
		pnTenLH.setLayout(new GridLayout(1, 2 , -50 ,-50));
		JPanel pnNamHoc = new JPanel();
		pnNamHoc.setLayout(new GridLayout(1, 2 , -50 ,-50));
		
		JPanel pnThemMH = new JPanel();
		pnThemMH.setLayout(new GridLayout(1, 2, 50, 50));
		JPanel pnCbMH = new JPanel();
		pnCbMH.setLayout(new GridLayout(1, 2 , -250 ,-250));
		JPanel pnButtonMH = new JPanel();
		pnButtonMH.setLayout(new GridLayout(1, 2 , 50 ,50));
		
		JLabel labelMaLH = new JLabel("Mã lớp học: ");
		JLabel labelTenLH = new JLabel("Tên lớp học: ");
		JLabel labelNamHoc = new JLabel("Năm học: ");
		JLabel labelMonHoc = new JLabel("Môn học: ");
		
		Border border1 = BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder tilleBorder1 = BorderFactory.createTitledBorder(border1, "Danh sách lớp học");
		dmLH.addColumn("Mã lớp học");
		dmLH.addColumn("Tên lớp học");
		dmLH.addColumn("Năm học");
		JScrollPane sc1 = new JScrollPane(tableLH);
		pnTableLH.setBorder(tilleBorder1);
		pnTableLH.add(sc1, BorderLayout.CENTER);
		
		Border border2 = BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder tilleBorder2 = BorderFactory.createTitledBorder(border2, "Danh sách môn học");
		dmMH.addColumn("Mã môn học");
		dmMH.addColumn("Tên môn học");
		JScrollPane sc2 = new JScrollPane(tableMH);
		pnTableMH.setBorder(tilleBorder2);
		pnTableMH.add(sc2, BorderLayout.CENTER);
		
		pnMaLH.add(labelMaLH);
		pnMaLH.add(txtMaLH);
		
		pnTenLH.add(labelTenLH);
		pnTenLH.add(txtTenLH);

		pnNamHoc.add(labelNamHoc);
		pnNamHoc.add(txtNamHoc);
		
		pnInput.add(pnMaLH);
		pnInput.add(pnTenLH);
		pnInput.add(pnNamHoc);
		
		pnButton.add(btnThem);
		pnButton.add(btnSua);
		pnButton.add(btnXoa);
		pnButton.add(btnHuy);
		
		pnCRUD.add(pnInput, BorderLayout.CENTER);
		pnCRUD.add(pnButton, BorderLayout.SOUTH);
		
		pnLopHoc.add(pnCRUD, BorderLayout.NORTH);
		pnLopHoc.add(pnTableLH, BorderLayout.CENTER);
		
		pnCbMH.add(labelMonHoc);
		pnCbMH.add(cbMonHoc);
		
		pnButtonMH.add(btnThemMH);
		pnButtonMH.add(btnXoaMH);	
		
		pnThemMH.add(pnCbMH);
		pnThemMH.add(pnButtonMH);
		
		pnMonHoc.add(pnThemMH, BorderLayout.NORTH);
		pnMonHoc.add(pnTableMH, BorderLayout.CENTER);
		
		pnMain.add(pnLopHoc, BorderLayout.CENTER);
		pnMain.add(pnMonHoc, BorderLayout.SOUTH);
		
		this.add(pnMain);
		
		resetButton();
	}

	private void addEvents() {
		tableLH.addMouseListener(getSelectLH);
		btnThem.addActionListener(themLH);
		btnSua.addActionListener(suaLH);
		btnXoa.addActionListener(xoaLH);
		btnHuy.addActionListener(huy);
		btnThemMH.addActionListener(themMH);
		btnXoaMH.addActionListener(xoaMH);
	}
	MouseListener getSelectLH = new MouseListener() {
		
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
			int row = tableLH.getSelectedRow();
			txtMaLH.setText(dmLH.getValueAt(row, 0).toString());
			txtTenLH.setText(dmLH.getValueAt(row, 1).toString());
			txtNamHoc.setText(dmLH.getValueAt(row, 2).toString());
			disableButton();
			getMonHocLop();
		}
	};
	ActionListener themLH = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			maLop = txtMaLH.getText();
			tenLop = txtTenLH.getText();
			namHoc = txtNamHoc.getText();
			if (maLop.isEmpty() || tenLop.isEmpty() || namHoc.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!");
			} else {
				try {
					Statement statement =  connection.createStatement();
					ResultSet result = statement.executeQuery(
							"select * from lophoc where MaLop ='" + maLop + "' and status =''");
					if (result.next() == true) {
						JOptionPane.showMessageDialog(null, "Lớp học đã tồn tại!");
					} else {
						try {
							Statement statement2 =  connection.createStatement();
							ResultSet result2 = statement2.executeQuery(
									"select * from lophoc where MaLop ='" + maLop + "' and status ='deleted'");
							if (result2.next()) {
								try {
									String sql = "update lophoc set TenLop ='" + tenLop + "', NamHoc ='" + namHoc + "', status ='' where MaLop ='" + maLop + "'";
									Statement statements = (Statement) connection.createStatement();
									int y = statements.executeUpdate(sql);
									if (y > 0) {
										resetButton();
										JOptionPane.showMessageDialog(null, "Thêm lớp học thành công!");
									} else {
										JOptionPane.showMessageDialog(null, "Thêm lớp học thất bại!");
									}
								} catch (Exception e2) {
									e2.printStackTrace();
								}
							} else {
								try {
									String sql = "insert into lophoc value(null,'" + maLop + "','" + tenLop + "','" + namHoc + "')";
									Statement statements = (Statement) connection.createStatement();
									int y = statements.executeUpdate(sql);
									if (y > 0) {
										resetButton();
										JOptionPane.showMessageDialog(null, "Thêm lớp học thành công!");
									} else {
										JOptionPane.showMessageDialog(null, "Thêm lớp học thất bại!");
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
			getLopHoc();
		}
	};
	ActionListener suaLH = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			maLop = txtMaLH.getText();
			tenLop = txtTenLH.getText();
			namHoc = txtNamHoc.getText();
			try {
				String sql = "update lophoc set TenLop ='" + tenLop + "',NamHoc ='" + namHoc + "' where MaLop ='" + maLop + "'";
				Statement statements = (Statement) connection.createStatement();
				int y = statements.executeUpdate(sql);
				if (y > 0) {
					resetButton();
					JOptionPane.showMessageDialog(null, "Cập nhật lớp học thành công!");
				} else {
					JOptionPane.showMessageDialog(null, "Cập nhật lớp học thất bại!");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			getLopHoc();
		}
	};
	ActionListener xoaLH = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			int row = tableLH.getSelectedRow();
			if (row<0) {	
			} else {
				int kt = JOptionPane.showConfirmDialog(null, "Bạn có thực sự muốn xóa lớp học này?", "Xóa lớp học", JOptionPane.YES_NO_OPTION);
				if (kt == JOptionPane.YES_OPTION) {
					try {
						String sql = "update lophoc set status ='deleted' where MaLop ='" + maLop + "'";
						Statement statements = (Statement) connection.createStatement();
						int y = statements.executeUpdate(sql);
						if (y > 0) {
							resetButton();
							JOptionPane.showMessageDialog(null, "Xóa lớp học thành công!");
						} else {
							JOptionPane.showMessageDialog(null, "Xóa lớp học thất bại!");
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
			getLopHoc();
		}
	};
	ActionListener huy = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			resetButton();
		}
	};
	ActionListener themMH = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			maLop = txtMaLH.getText();
			if (maLop == null) {	
			} else {
				tenMH = cbMonHoc.getSelectedItem().toString();
				if (tenMH == "Chọn môn học") {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn môn học!");
				} else {
					for (MonHoc x : arrMH) {
						if (x.getTenSub().equals(tenMH)) {
							maMH = x.getMaSub();
						}
					}
					try {
						Statement statement =  connection.createStatement();
						ResultSet result = statement.executeQuery(
								"select * from monhoctheolop where MaLH ='" + maLop + "' and MaMH = '"+ maMH +"' and status =''");
						if (result.next() == true) {
							JOptionPane.showMessageDialog(null, "Môn học đã tồn tại trong lớp học này!");
						} else {
							try {
								Statement statement2 =  connection.createStatement();
								ResultSet result2 = statement.executeQuery(
										"select * from monhoctheolop where MaLH ='" + maLop + "' and MaMH = '"+ maMH +"' and status ='deleted'");
								if (result2.next() == true) {
									try {
										String sql = "update monhoctheolop set status = '' where MaLH ='" + maLop + "' and MaMH = '"+ maMH +"'";
										Statement statements = (Statement) connection.createStatement();
										int x = statements.executeUpdate(sql);
										if (x > 0) {
											cbMonHoc.setSelectedItem("Chọn môn học");
											JOptionPane.showMessageDialog(null, "Thêm môn học thành công!");
										} else {
											try {
												String sql2 = "insert into monhoctheolop value(null,'" + maLop + "','" + maMH + "')";
												Statement statement3 = (Statement) connection.createStatement();
												int y = statement3.executeUpdate(sql2);
												if (y > 0) {
													cbMonHoc.setSelectedItem("Chọn môn học");
													JOptionPane.showMessageDialog(null, "Thêm môn học thành công!");
												} else {
													JOptionPane.showMessageDialog(null, "Thêm môn học học thất bại!");
												}
											} catch (Exception ex) {
												ex.printStackTrace();
											}
										}
									} catch (Exception ex) {
										ex.printStackTrace();
									}
								}
							} catch (Exception e2) {
								// TODO: handle exception
							}
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				getMonHocLop();
			}
		}
	};
	ActionListener xoaMH = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			int row = tableMH.getSelectedRow();
			maLop = txtMaLH.getText();
			if (row<0) {	
			} else {
				int kt = JOptionPane.showConfirmDialog(null, "Bạn có thực sự muốn xóa môn học này?", "Xóa môn học", JOptionPane.YES_NO_OPTION);
				if (kt == JOptionPane.YES_OPTION) {
					try {
						String sql = "delete from monhoctheolop where MaLH='" + maLop + "' and MaMH = '"+ dmMH.getValueAt(row, 0) +"'";
						Statement statement = (Statement) connection.createStatement();
						int x = statement.executeUpdate(sql);
						if (x > 0) {
							JOptionPane.showMessageDialog(null, "Xóa môn học thành công!");
						} else {
							JOptionPane.showMessageDialog(null, "Xóa môn học thất bại!");
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
			getMonHocLop();
		}
	};
	public void getLopHoc() {
		dmLH.setRowCount(0);
		arrLH.removeAll(arrLH);
		try {
			Statement statement =  connection.createStatement();
			ResultSet result = statement.executeQuery("select * from lophoc where status ='' order by MaLop ASC");
			while (result.next()) {
				arrLH.add(new LopHoc(result.getString("MaLop"), result.getString("TenLop"), result.getString("NamHoc")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (LopHoc x : arrLH) {
			dmLH.addRow(new String[] {x.maLop,x.moTa,x.namHoc});
		}
	}
	public void getMonHocLop() {
		maLop = txtMaLH.getText();
		dmMH.setRowCount(0);
		arrMHL.removeAll(arrMHL);
		try {
			Statement statement =  connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT monhoctheolop.MaLH, monhoctheolop.MaMH, monhoc.TenMH, monhoctheolop.status FROM monhoctheolop INNER JOIN monhoc ON monhoctheolop.MaMH = monhoc.MaMH WHERE MaLH = '"+ maLop +"' and monhoctheolop.status = '' order by MaMH ASC");
			while (result.next()) {
				arrMHL.add(new MonHocTheoLop(result.getString("MaMH"), result.getString("TenMH")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (MonHocTheoLop x : arrMHL) {
			dmMH.addRow(new String[] {x.maMH,x.tenMH});
		}
	}
	public void getMonHoc() {
		try {
			Statement statement =  connection.createStatement();
			ResultSet result = statement.executeQuery("select * from monhoc where status = '' order by MaMH ASC");
			while (result.next()) {
				arrMH.add(new MonHoc(result.getString("MaMH"), result.getString("TenMH"), result.getString("TinChi"), result.getString("ThoiLuongHoc")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		cbMonHoc.removeAllItems();
		cbMonHoc.addItem("Chọn môn học");
		for (MonHoc x : arrMH) {
			cbMonHoc.addItem(x.tenSub);
		}
	}
	public void disableButton() {
		txtMaLH.setEnabled(false);
		btnSua.setEnabled(true);
		btnXoa.setEnabled(true);
		btnHuy.setEnabled(true);
		btnThem.setEnabled(false);
	}
	public void resetButton() {
		txtMaLH.setEnabled(true);
		txtMaLH.setText("");
		txtTenLH.setText("");
		txtNamHoc.setText("");
		btnSua.setEnabled(false);
		btnXoa.setEnabled(false);
		btnHuy.setEnabled(false);
		btnThem.setEnabled(true);
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