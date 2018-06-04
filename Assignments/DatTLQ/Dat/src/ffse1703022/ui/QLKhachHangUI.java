package ffse1703022.ui;

import java.awt.BorderLayout;
import java.awt.Color;
<<<<<<< HEAD
=======
import java.awt.Container;
>>>>>>> b149031eb33d3b97feec315adef76423bd77895d
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
<<<<<<< HEAD
import java.sql.ResultSet;
import java.sql.SQLException;
=======
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
>>>>>>> b149031eb33d3b97feec315adef76423bd77895d

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
<<<<<<< HEAD
=======
import javax.swing.JFrame;
>>>>>>> b149031eb33d3b97feec315adef76423bd77895d
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import ffse1703022.model.KhachHang;
import ffse1703022.model.KhachHangModel;

<<<<<<< HEAD
@SuppressWarnings("serial")
public class QLKhachHangUI extends JPanel {
	private JTextField txttenKH, txtHoTen, txtDiaChi, txtSdt, txtEmail, txtMaCT, txtMaKH;
	@SuppressWarnings("rawtypes")
	private JComboBox cboquan, cbophuong, cboQuan, cboPhuong;
	private JButton btnAdd, btnRep, btnDel, btnsearch, btnOk;
=======
public class QLKhachHangUI extends JPanel {
	private JTextField txttenKH, txtHoTen, txtDiaChi, txtSdt, txtEmail, txtMaCT, txtMaKH;
	private JComboBox cboquan, cbophuong, cboQuan, cboPhuong;
	private JButton btnAdd, btnRep, btnDel, btnsearch, btnOk;
	private static ArrayList<KhachHang> arrKhachHang = new ArrayList<>();
>>>>>>> b149031eb33d3b97feec315adef76423bd77895d
	private DefaultTableModel dm;
	private JTable tbl;
	private KhachHangModel khachHangModel = new KhachHangModel();

	public QLKhachHangUI() {
		addControls();
		addEvents();
	}

<<<<<<< HEAD
	@SuppressWarnings({ "unchecked", "rawtypes" })
=======
>>>>>>> b149031eb33d3b97feec315adef76423bd77895d
	public void addControls() {
		JPanel pnFlow = new JPanel();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		pnFlow.setLayout(new FlowLayout());

		JPanel BoxtenKH = new JPanel();
		JPanel Box3 = new JPanel();
		JPanel Boxtable = new JPanel();
		JPanel BoxmaKH = new JPanel();
		JPanel Boxbtn = new JPanel();
		JPanel Boxhoten = new JPanel();
		JPanel Boxdiachi = new JPanel();
		JPanel Boxquan = new JPanel();
		JPanel Boxphuong = new JPanel();
		JPanel Boxsdt = new JPanel();
		JPanel Boxemail = new JPanel();
		JPanel Boxmact = new JPanel();
<<<<<<< HEAD
	
=======
		JPanel Box13 = new JPanel();
>>>>>>> b149031eb33d3b97feec315adef76423bd77895d

		//
		JLabel tenKH = new JLabel("Tên Khách Hàng:");
		txttenKH = new JTextField(20);
		BoxtenKH.add(tenKH);
		BoxtenKH.add(txttenKH);
		//
		JLabel jblQuan = new JLabel("Quận");
		cboquan = new JComboBox();
		cboquan.addItem("Tất Cả");
		JLabel jblPhuong = new JLabel("Phường");
		cbophuong = new JComboBox();
		cbophuong.addItem("Tất cả");
		btnsearch = new JButton("Tìm Kiếm");
		Box3.add(jblQuan);
		Box3.add(cboquan);
		Box3.add(jblPhuong);
		Box3.add(cbophuong);
		Box3.add(btnsearch);

		//
		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Danh sách");
		Boxtable.setBorder(borderTitle);
		dm = new DefaultTableModel();
		dm.addColumn("Mã khách hàng");
		dm.addColumn("Mã công tơ");
		dm.addColumn("Họ tên");
		dm.addColumn("Địa chỉ");
		dm.addColumn("Quận");
		dm.addColumn("Phường");
		dm.addColumn("Điện thoại");
		dm.addColumn("Email");

		tbl = new JTable(dm);

		JScrollPane sc = new JScrollPane(tbl);

		Boxtable.setLayout(new BorderLayout());
		Boxtable.add(sc, BorderLayout.CENTER);
		//
		
		//

		JLabel jlbTen = new JLabel("Họ và tên");
		jlbTen.setPreferredSize(new Dimension(100, 20));
		txtHoTen = new JTextField(20);
		Boxhoten.add(jlbTen);
		Boxhoten.add(txtHoTen);
		//
		JLabel jlbDiaChi = new JLabel("Địa chỉ");
		jlbDiaChi.setPreferredSize(jlbTen.getPreferredSize());

		txtDiaChi = new JTextField(20);
		Boxdiachi.add(jlbDiaChi);
		Boxdiachi.add(txtDiaChi);
		//
		JLabel jlbQuan1 = new JLabel("Quận");
		jlbQuan1.setPreferredSize(jlbTen.getPreferredSize());
		cboQuan = new JComboBox();
		cboQuan.addItem("Chọn quận");
		cboQuan.setPreferredSize(new Dimension(160, 20));
		getQuan();

		Boxquan.add(jlbQuan1);
		Boxquan.add(cboQuan);
		//
		JLabel jblPhuong2 = new JLabel("Phường");
		jblPhuong2.setPreferredSize(jlbTen.getPreferredSize());

		cboPhuong = new JComboBox();
		cboPhuong.addItem("");
		cboPhuong.setPreferredSize(new Dimension(160, 20));

		Boxphuong.add(jblPhuong2);
		Boxphuong.add(cboPhuong);

		//
		JLabel jblSdt = new JLabel("Điện thoại");
		jblSdt.setPreferredSize(jlbTen.getPreferredSize());

		txtSdt = new JTextField(20);
		Boxsdt.add(jblSdt);
		Boxsdt.add(txtSdt);
		//
		JLabel jlbemail = new JLabel("Email");
		jlbemail.setPreferredSize(jlbTen.getPreferredSize());

		txtEmail = new JTextField(20);
		Boxemail.add(jlbemail);
		Boxemail.add(txtEmail);
		//
		JLabel jlbmact = new JLabel("Mã Công Tơ");
		jlbmact.setPreferredSize(jlbTen.getPreferredSize());

		txtMaCT = new JTextField(20);
		Boxmact.add(jlbmact);
		Boxmact.add(txtMaCT);
		//

		btnAdd = new JButton("Thêm");
		btnRep = new JButton("Sửa");
		btnDel = new JButton("Xóa");
		btnOk = new JButton("Tạo");
		Boxbtn.add(btnAdd);
		Boxbtn.add(btnRep);
		Boxbtn.add(btnDel);
		Boxbtn.add(btnOk);

		this.add(BoxtenKH);
		this.add(Box3);
		this.add(Boxtable);
		this.add(BoxmaKH);
		this.add(Boxmact);
		this.add(Boxhoten);
		this.add(Boxdiachi);
		this.add(Boxquan);
		this.add(Boxphuong);
		this.add(Boxsdt);
		this.add(Boxemail);

		this.add(Boxbtn);
	}

	public void addEvents() {
		cboQuan.addActionListener(new SelectQuanListener());
		cboquan.addActionListener(new SelectQuan1Listener());
		btnsearch.addActionListener(new SearchCustomer());
		btnAdd.addActionListener(new AddCustomer());
		tbl.addMouseListener(new ClickCustomer());
		btnRep.addActionListener(new ReplaceCustomer());
		btnOk.addActionListener(new NewCustomer());
		btnDel.addActionListener(new DeleteCustomer());

	}

<<<<<<< HEAD
	@SuppressWarnings("unchecked")
=======
>>>>>>> b149031eb33d3b97feec315adef76423bd77895d
	private void getQuan() {
		ResultSet rs;
		try {
			rs = khachHangModel.getQuan();
			while ((rs != null) && rs.next()) {
				cboquan.addItem(rs.getString("name"));
				cboQuan.addItem(rs.getString("name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public class SelectQuanListener implements ActionListener {
<<<<<<< HEAD
		@SuppressWarnings("unchecked")
=======
>>>>>>> b149031eb33d3b97feec315adef76423bd77895d
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				cboPhuong.removeAllItems();
				ResultSet rs;
				String tenQuan = cboQuan.getSelectedItem().toString();
				System.out.println(tenQuan);
				rs = khachHangModel.getPhuong(tenQuan);
				while (rs.next()) {
					cboPhuong.addItem(rs.getString("Phuong.name"));

				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}

	private class SelectQuan1Listener implements ActionListener {
<<<<<<< HEAD
		@SuppressWarnings("unchecked")
=======
>>>>>>> b149031eb33d3b97feec315adef76423bd77895d
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				cbophuong.removeAllItems();
				ResultSet rs;
				String tenQuan = cboquan.getSelectedItem().toString();
				System.out.println(tenQuan);
				rs = khachHangModel.getPhuong(tenQuan);
				cbophuong.addItem("Tất cả");
				while (rs.next()) {
					cbophuong.addItem(rs.getString("phuong.name"));

				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}

	private class SearchCustomer implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				dm.setRowCount(0);
				ResultSet rs;
				String ten = txttenKH.getText();
				String quan = cboquan.getSelectedItem().toString();
				String phuong = cbophuong.getSelectedItem().toString();
				if (ten.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ!!");
				} else {
					rs = khachHangModel.searchCus(ten, phuong, quan);
					while (rs.next()) {
						System.out.println(rs.getString("TenKH"));
						String[] row = { rs.getString("MaKH"), rs.getString("MaCT"), rs.getString("TenKH"),
								rs.getString("DiaChi"), rs.getString("Quan"), rs.getString("Phuong"),
								rs.getString("Phone"), rs.getString("Email"), };
						dm.addRow(row);
					}
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public class AddCustomer implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				
				if (txtMaCT.getText().equals("") || txtHoTen.getText().equals("")|| txtDiaChi.getText().equals("") || cboQuan.getSelectedIndex() < 0
						|| cboPhuong.getSelectedIndex() < 0 || txtSdt.getText().equals("") || txtEmail.getText().equals("")
						) {
					JOptionPane.showMessageDialog(null, "Hãy nhập đầy đủ thông tin");
				} else if (!checkRegexPhoneNumber(txtSdt.getText())) {
					JOptionPane.showMessageDialog(null, "Số điện thoại không đúng định dạng, vui lòng nhập lại");
				} else if (!checkRegexEmail(txtEmail.getText())) {
					JOptionPane.showMessageDialog(null, "Email không đúng định dạng, vui lòng nhập lại");
				} else if (checkDuplicateMeterID(txtMaCT.getText())) {
					JOptionPane.showMessageDialog(null, "Mã công tơ đã bị trùng, vui lòng nhập lại");
				} else {
<<<<<<< HEAD
					
=======
					int rs;
>>>>>>> b149031eb33d3b97feec315adef76423bd77895d
					String maKH = null;
					String hoTen = txtHoTen.getText();
					String diaChi = txtDiaChi.getText();
					String quan = cboQuan.getSelectedItem().toString();
					String phuong = cboPhuong.getSelectedItem().toString();
					String sdt = txtSdt.getText();
					String email = txtEmail.getText();
					String maCT = txtMaCT.getText();
					KhachHang kh = new KhachHang(maKH, maCT, hoTen, diaChi, quan, phuong, sdt, email);
<<<<<<< HEAD
					 khachHangModel.addCus(kh);
=======
					rs = khachHangModel.addCus(kh);
>>>>>>> b149031eb33d3b97feec315adef76423bd77895d

					JOptionPane.showMessageDialog(null, "Thêm thành công!!");
				}
				
				
								// btnsearch.doClick();

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public class ClickCustomer extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			try {
				int col = tbl.getSelectedRow();
				
				txtMaCT.setEditable(false);
				
				txtMaCT.setText(tbl.getValueAt(col, 1).toString());
				txtHoTen.setText(tbl.getValueAt(col, 2).toString());
				txtDiaChi.setText(tbl.getValueAt(col, 3).toString());
				cboQuan.setSelectedItem(tbl.getValueAt(col, 4).toString());
				cboPhuong.setSelectedItem(tbl.getValueAt(col, 5).toString());
				txtSdt.setText(tbl.getValueAt(col, 6).toString());
				txtEmail.setText(tbl.getValueAt(col, 7).toString());

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public class ReplaceCustomer implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
<<<<<<< HEAD
				
=======
				int rs;
>>>>>>> b149031eb33d3b97feec315adef76423bd77895d
				String maKH = null;
				String maCT = txtMaCT.getText();
				String hoTen = txtHoTen.getText();
				String diaChi = txtDiaChi.getText();
				String quan = cboQuan.getSelectedItem().toString();
				String phuong = cboPhuong.getSelectedItem().toString();
				String sdt = txtSdt.getText();
				String email = txtEmail.getText();
				

<<<<<<< HEAD
				 khachHangModel.repCus(new KhachHang(maKH, maCT, hoTen, diaChi, quan, phuong, sdt, email));
=======
				rs = khachHangModel.repCus(new KhachHang(maKH, maCT, hoTen, diaChi, quan, phuong, sdt, email));
>>>>>>> b149031eb33d3b97feec315adef76423bd77895d

				JOptionPane.showMessageDialog(null, "Sửa thành công!!");
				btnsearch.doClick();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public class NewCustomer implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				txtMaKH.setEditable(true);
				txtMaCT.setEditable(true);

				txtMaKH.setText("");
				txtMaCT.setText("");
				txtHoTen.setText("");
				txtDiaChi.setText("");
				txtSdt.setText("");
				txtEmail.setText("");
				cboQuan.setSelectedIndex(0);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public class DeleteCustomer implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				int mess = JOptionPane.showConfirmDialog(null, "Bạn muốn xóa?", "Thoát", JOptionPane.YES_NO_OPTION);
				

				if(mess== JOptionPane.YES_OPTION) {
					String maKH= txtMaKH.getText();
					int rs;
					rs=khachHangModel.delCus(maKH);		
					if(rs>0) {
						JOptionPane.showMessageDialog(null, "Xóa thành công!!");
						btnsearch.doClick();
					}else {
						JOptionPane.showMessageDialog(null, "Xóa thất bại!!");

					}
				
				}
				
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}
	public  boolean checkDuplicateMeterID(String meterID) throws SQLException {
		ResultSet meterIdList = khachHangModel.getMeterIdList();
		while (meterIdList.next()) {
<<<<<<< HEAD
			if (meterID.equals(meterIdList.getString("MaCT"))) {
=======
			if (meterID.equals(meterIdList.getString("meterID"))) {
>>>>>>> b149031eb33d3b97feec315adef76423bd77895d
				return true;
			}
		}
		return false;
	}

	public  boolean checkRegexEmail(String email) {
		String regex = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		return email.matches(regex);
	}

	public boolean checkRegexPhoneNumber(String phoneNumber) {
		String regex = "(\\+84|0)\\d{9,10}";
		return phoneNumber.matches(regex);
	}
}
