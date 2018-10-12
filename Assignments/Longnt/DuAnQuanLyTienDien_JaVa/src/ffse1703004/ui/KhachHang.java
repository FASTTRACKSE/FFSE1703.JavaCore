package ffse1703004.ui;
import java.awt.HeadlessException;
import java.awt.Image;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import ffse1703004.model.DBConnection;
import ffse1703004.model.KhachHangMD;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
public class KhachHang extends JPanel {
	
	private static final long serialVersionUID = 1L;
	static DBConnection DBConnection = new DBConnection();
	static Connection conn= ffse1703004.model.DBConnection.ketnoi("localhost", "ffse1703004_java", "thanhlong123",
			"123456");
	private JTextField txtMaKH,txtTenKH,txtDiaChi,txtSDT,txtEmail;
	private static JTextField txtMCT;
	private JTextField txtTimKiem;
	private JButton btnSearch1,butThem,butSua,butXoa,butTroVe;
	public static ArrayList<KhachHangMD> arr = new ArrayList<KhachHangMD>();
	private DefaultTableModel model = new DefaultTableModel(new Object[] { "Mã khách hàng", "Mã công tơ","Họ tên", "Địa chỉ", "Phường","Quận",
			"Điện thoại", "Email" }, 0);
	private JComboBox<Object> cbBxQuan1, cbBxPhuong1;
//	private JTextField txtFldId;
		final JTable table = new JTable(model);
		JScrollPane sc = new JScrollPane(table);
		int stt = 0;
		public KhachHang() throws HeadlessException, SQLException {
			addControls();
			addEvents();
			Display();
		}
		
		public void addControls() throws SQLException {
			this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			Border border=
					BorderFactory.createLineBorder(Color.RED);
					TitledBorder borderTitle=
					BorderFactory.createTitledBorder(
					border);
					this.setBorder(borderTitle);
			JPanel pnMain = new JPanel();
			pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
			

			JPanel pnTitle = new JPanel();
			JLabel lblTitle = new JLabel("Quản lí khách hàng");
			Font fontTitle = new Font("arial", Font.BOLD, 20);
			lblTitle.setFont(fontTitle);
			pnTitle.add(lblTitle);
			
			JPanel pn2 = new JPanel();
			
			JLabel lb1 = new JLabel("Tên khách hàng");
			txtTimKiem = new JTextField(15);
			pn2.add(lb1);
			pn2.add(txtTimKiem);
			
			btnSearch1 = new JButton("Tìm kiếm");
			btnSearch1.setPreferredSize(new Dimension(90,20));
			pn2.add(btnSearch1);

			
			JPanel pn3 = new JPanel();
			butThem = new JButton("Thêm");
			butThem.setPreferredSize(new Dimension(140,50));
			ImageIcon insert = new ImageIcon(
					new ImageIcon("icons/insert.png").getImage().getScaledInstance(40, 45, Image.SCALE_SMOOTH));
			JLabel lblIconInsert = new JLabel(insert);
		    butThem.add(lblIconInsert);
			butSua = new JButton("Sửa");
			butSua.setPreferredSize(new Dimension(140,50));
			ImageIcon update = new ImageIcon(
					new ImageIcon("icons/t.png").getImage().getScaledInstance(40, 45, Image.SCALE_SMOOTH));
			JLabel lblIconUpdate = new JLabel(update);
			butSua.add(lblIconUpdate);
			butXoa = new JButton("Xóa");
			butXoa.setPreferredSize(new Dimension(140,50));
			ImageIcon delete = new ImageIcon(
					new ImageIcon("icons/delete.png").getImage().getScaledInstance(40, 45, Image.SCALE_SMOOTH));
			JLabel lblIconDelete= new JLabel(delete);
			butXoa.add(lblIconDelete);
			
			butTroVe = new JButton("Trở về");
			butTroVe.setPreferredSize(new Dimension(140,50));
			ImageIcon back = new ImageIcon(
					new ImageIcon("icons/Undo.png").getImage().getScaledInstance(30, 45, Image.SCALE_SMOOTH));
			JLabel lblIconBack= new JLabel(back);
			butTroVe.add(lblIconBack);
			butTroVe.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					txtMaKH.setEditable(true);
					txtMCT.setEditable(true);
					txtMaKH.setText("");
					txtMCT.setText("");
					txtTenKH.setText("");
					txtDiaChi.setText("");
					cbBxPhuong1.setSelectedItem("");
					cbBxQuan1.setSelectedItem("");
					txtSDT.setText("");
					txtEmail.setText("");
					 model.setRowCount(0);
					 Display();
				
				}
			});
			
			pn3.add(butThem);
			pn3.add(butSua); 
			pn3.add(butXoa);
			pn3.add(butTroVe);

			JScrollPane pn4 = new JScrollPane(table);

			JPanel pn5 = new JPanel();
			pn5.setLayout(new BoxLayout(pn5, BoxLayout.X_AXIS));
			
			JPanel pn5a = new JPanel();
			pn5a.setLayout(new BoxLayout(pn5a, BoxLayout.Y_AXIS));
			
			JPanel pnm = new JPanel();
			JLabel lblm = new JLabel("Mã khách hàng");
			lblm.setPreferredSize(new Dimension(90, 15));
			txtMaKH = new JTextField(15);
			pnm.add(lblm);
			pnm.add(txtMaKH);
			
			JPanel pnMeterID = new JPanel();
			JLabel lblMeterID = new JLabel("Mã công tơ");
			lblMeterID.setPreferredSize(new Dimension(90, 15));
			txtMCT = new JTextField(15);
			pnMeterID.add(lblMeterID);
			pnMeterID.add(txtMCT);
			
			JPanel pnCounty = new JPanel();
			JLabel county = new JLabel("Quận");
			county.setPreferredSize(new Dimension(90, 20));
			cbBxQuan1 = new JComboBox<Object>();
			cbBxQuan1.setPreferredSize(new Dimension(170, 20));
			pnCounty.add(county);
			pnCounty.add(cbBxQuan1);
			

			JPanel pnWard = new JPanel();
			JLabel lblWard2 = new JLabel("Phường");
			lblWard2.setPreferredSize(new Dimension(90, 20));
			cbBxPhuong1 = new JComboBox<Object>();
			cbBxPhuong1.setPreferredSize(new Dimension(170, 20));
			pnWard.add(lblWard2);
			pnWard.add(cbBxPhuong1);
			
			pn5a.add(pnm);
			pn5a.add(pnMeterID);
			pn5a.add(pnCounty);
			pn5a.add(pnWard);
			
			JPanel pn5b = new JPanel();
			pn5b.setLayout(new BoxLayout(pn5b, BoxLayout.Y_AXIS));
			
			JPanel pnName = new JPanel();
			JLabel lblName = new JLabel("Họ tên");
			lblName.setPreferredSize(new Dimension(90, 15));
			txtTenKH = new JTextField(15);
			pnName.add(lblName);
			pnName.add(txtTenKH);

			JPanel pnAddress = new JPanel();
			JLabel lblAddress = new JLabel("Địa chỉ");
			lblAddress.setPreferredSize(new Dimension(90, 15));
			txtDiaChi = new JTextField(15);
			pnAddress.add(lblAddress);
			pnAddress.add(txtDiaChi);

			JPanel pnPhone = new JPanel();
			JLabel lblPhone = new JLabel("Điện thoại");
			lblPhone.setPreferredSize(new Dimension(90, 15));
			txtSDT = new JTextField(15);
			pnPhone.add(lblPhone);
			pnPhone.add(txtSDT);
			
			JPanel pnEmail = new JPanel();
			JLabel lblEmail = new JLabel("Email");
			lblEmail.setPreferredSize(new Dimension(90, 15));
			txtEmail = new JTextField(15);
			pnEmail.add(lblEmail);
			pnEmail.add(txtEmail);
			
			pn5b.add(pnName);
			pn5b.add(pnAddress);
			pn5b.add(pnPhone);
			pn5b.add(pnEmail);

			pn5.add(pn5a);
			pn5.add(pn5b);

			pnMain.add(pnTitle);
			pnMain.add(pn2);
			pnMain.add(pn4);
			pnMain.add(pn3);
			pnMain.add(pn5);		
			this.add(pnMain);
			cbBxQuan1.addItem("Chọn quận");
			addComboBoxCounty(ffse1703004.model.DBConnection.getQuan(), cbBxQuan1);
		}

		ActionListener eventQuan1 = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cbBxPhuong1.removeAllItems();
				int idquan = cbBxQuan1.getSelectedIndex() ;
				try {
					addComboBoxWard(ffse1703004.model.DBConnection.getPhuong(idquan), cbBxPhuong1);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		};
		
		ActionListener eventTimKiem = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				timKiem();
			}
		};
		
		public void timKiem() {
			if (conn != null) {
				String sql = "SELECT * FROM KhachHang WHERE makh LIKE '%" + txtTimKiem.getText() + "%' or tenkh LIKE '"+ txtTimKiem.getText() +"'";
				try {
					if(txtTimKiem.getText().isEmpty()) {
						Display();
					} else {
					PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
					// khởi tạo resultset

					ResultSet rs = ptmt.executeQuery();
					model.setRowCount(0);
					// mdTableSach.getDataVector().removeAllElements();
					while (rs.next()) {
						String rows[] = new String[8];

						rows[0] = rs.getString(2);
						rows[1] = rs.getString(3);
						rows[2] = rs.getString(4);
						rows[3] = rs.getString(5);
						rows[4] = rs.getString(6);
						rows[5] = rs.getString(7);
						rows[6] = rs.getString(8);
						rows[7] = rs.getString(9);
						model.addRow(rows);
					}}
				} catch (SQLException e) {
					System.out.println("Lỗi " + e.getMessage());
				}
			} else {
				System.out.println("Kết nối MYSQL thất bại");
			}
		}
		
		
		public void Display() {
			if (conn != null) {

				String sql = "select * from KhachHang";
				try {
					PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
					// khởi tạo resultset
					ResultSet rs = ptmt.executeQuery();
					while (rs.next()) {
						String rows[] = new String[8];

						rows[0] = rs.getString(2);
						rows[1] = rs.getString(3);
						rows[2] = rs.getString(4);
						rows[3] = rs.getString(5);
						rows[4] = rs.getString(6);
						rows[5] = rs.getString(7);
						rows[6] = rs.getString(8);
						rows[7] = rs.getString(9);
						model.addRow(rows);
					}
				} catch (SQLException e) {
					System.out.println("Lỗi" + e.getMessage());

				}
			} else {
				System.out.println("Kết nối MYSQL thất bại");
			}
		}

		 void getDataToTextField(int row) {
			 	txtMaKH.setEditable(false);
			 	txtMCT.setEditable(false);
				txtMaKH.setText((String) table.getValueAt(row, 0));
				txtMCT.setText((String) table.getValueAt(row, 1));
				txtTenKH.setText((String) table.getValueAt(row, 2));
				txtDiaChi.setText((String) table.getValueAt(row, 3));
				txtEmail.setText((String) table.getValueAt(row, 7));
				txtSDT.setText((String) table.getValueAt(row, 6));
				cbBxQuan1.setSelectedItem(table.getValueAt(row, 5));
				cbBxPhuong1.setSelectedItem(table.getValueAt(row, 4));
			}
	
		 ListSelectionListener eventDataToTextField = new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent e) {
					int row = table.getSelectedRow();
					if (row != -1 && !e.getValueIsAdjusting()) {
						getDataToTextField(row);
					}
				}
			};
		
		ActionListener eventThem = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					if (txtMaKH.getText().equals("") || txtMCT.getText().equals("") || cbBxQuan1.getSelectedIndex() < 0
							|| cbBxPhuong1.getSelectedIndex() < 0 || txtDiaChi.getText().equals("") || txtEmail.getText().equals("")
							|| txtSDT.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Hãy nhập đầy đủ thông tin");
					} else if (!checkPhoneNumber(txtSDT.getText())) {
						JOptionPane.showMessageDialog(null, "Số điện thoại không đúng định dạng, vui lòng nhập lại");
					} else if (!checkEmail(txtEmail.getText())) {
						JOptionPane.showMessageDialog(null, "Email không đúng định dạng, vui lòng nhập lại");
					} else if (checkMCT(txtMCT.getText())) {
						JOptionPane.showMessageDialog(null, "Mã công tơ đã bị trùng, vui lòng nhập lại");
					} else {
						if (conn != null) {
							String sql = "INSERT INTO KhachHang(makh,mact,tenkh,diachi,idphuong,idquan,dienthoai,email) VALUES (?,?,?,?,?,?,?,?)";
							try {
								PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
								ptmt.setString(1, txtMaKH.getText());
								ptmt.setString(2, txtMCT.getText());
								ptmt.setString(3, txtTenKH.getText());
								ptmt.setString(4, txtDiaChi.getText());
								ptmt.setString(5, cbBxPhuong1.getSelectedItem().toString());
								ptmt.setString(6, cbBxQuan1.getSelectedItem().toString());
								ptmt.setString(7, txtSDT.getText());
								ptmt.setString(8, txtEmail.getText());
								int k = ptmt.executeUpdate();
								if (k != 0) {
									JOptionPane.showMessageDialog(null, "Thêm thành công");
									String[] row = {  txtMaKH.getText(), txtMCT.getText(), txtTenKH.getText(),txtDiaChi.getText(),
											cbBxPhuong1.getSelectedItem().toString(),cbBxQuan1.getSelectedItem().toString(),
											txtSDT.getText(),txtEmail.getText() };
									model.addRow(row);}
								else {
								JOptionPane.showMessageDialog(null, "Thêm thất bại");
								}
								txtMaKH.setText("");
								txtMCT.setText("");
								txtTenKH.setText("");
								txtDiaChi.setText("");
								cbBxPhuong1.setSelectedItem("");
								cbBxQuan1.setSelectedItem("");
								txtSDT.setText("");
								txtEmail.setText("");
							} catch(Exception e1) {
								e1.getStackTrace();
							}
						} else {
							System.out.println("Kết nối MYSQL thất bại");
						}
					}
					//
				} catch (SQLException e1) {
				
					e1.printStackTrace();
				}
			}
		};
				
		public void update() throws SQLException {
			try {

				if  (txtMaKH.getText().equals("") || txtMCT.getText().equals("") || cbBxQuan1.getSelectedIndex() < 0
						|| cbBxPhuong1.getSelectedIndex() < 0 || txtDiaChi.getText().equals("") ||  txtSDT.getText().equals("")||txtEmail.getText().equals("")
						) {
					JOptionPane.showMessageDialog(null, "Hãy nhập đầy đủ thông tin");
				} else if (!checkPhoneNumber(txtSDT.getText())) {
					JOptionPane.showMessageDialog(null, "Số điện thoại không đúng định dạng, vui lòng nhập lại");
				} else if (!checkEmail(txtEmail.getText())) {
					JOptionPane.showMessageDialog(null, "Email không đúng định dạng, vui lòng nhập lại");
				} else {
					if (conn != null) {
						try {
						String sql = "update KhachHang set tenkh = ?, diachi = ?, idquan = ?, idphuong = ?, dienthoai = ?, email = ? where makh = ?";
							PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
							ptmt.setString(1, txtTenKH.getText());
							ptmt.setString(2, txtDiaChi.getText());
							ptmt.setString(3, cbBxPhuong1.getSelectedItem().toString());
							ptmt.setString(4, cbBxQuan1.getSelectedItem().toString());
							ptmt.setString(5, txtSDT.getText());
							ptmt.setString(6, txtEmail.getText());
							ptmt.setString(7, txtMaKH.getText());
							int t = table.getSelectedRow();
							String[] row = {  txtMaKH.getText(), txtMCT.getText(), txtTenKH.getText(),txtDiaChi.getText(),
									cbBxPhuong1.getSelectedItem().toString(),cbBxQuan1.getSelectedItem().toString(),
									txtSDT.getText(),txtEmail.getText() };
							for (int j = 0; j < 7; j++) {
								table.setValueAt(row[j], t, j);
							}
							int k = ptmt.executeUpdate();
							if (k != 0) {
								JOptionPane.showMessageDialog(null, "Sửa thành công");
								txtMaKH.setText("");
								txtMCT.setText("");
								txtTenKH.setText("");
								txtDiaChi.setText("");
								cbBxPhuong1.setSelectedItem("");
								cbBxQuan1.setSelectedItem("");
								txtSDT.setText("");
								txtEmail.setText("");
							} else {
								JOptionPane.showMessageDialog(null, "Sửa thất bại");
						}
						}catch (SQLException e) {
							System.out.println("Lỗi" + e.getMessage());

						}
					} else {
						System.out.println("Kết nối MYSQL thất bại");
					}
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		public void delete() {
			if (conn != null) {
				int myChose = JOptionPane.showConfirmDialog(null, "Bạn cóm muốn xóa dữ liệu này không?", "Xóa", JOptionPane.YES_NO_OPTION);
				if(myChose == JOptionPane.YES_OPTION) {
				String sql = "DELETE FROM KhachHang WHERE makh=?";
				try {
					PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
					ptmt.setString(1, txtMaKH.getText());
					int kt = ptmt.executeUpdate();
					if (kt != 0) {
						int j = table.getSelectedRow();
						JOptionPane.showMessageDialog(null, "Xóa thành công");
						model.removeRow(j);
						txtMaKH.setText("");
						txtMCT.setText("");
						txtTenKH.setText("");
						txtDiaChi.setText("");
						cbBxPhuong1.setSelectedItem("");
						cbBxQuan1.setSelectedItem("");
						txtSDT.setText("");
						txtEmail.setText("");
					} else
						JOptionPane.showMessageDialog(null, "Xóa không thành công");
				} catch (SQLException e) {
					System.out.println("Lỗi " + e.getMessage());
				}
				}
			} else {
				System.out.println("Kết nối MYSQL thất bại");
			}
		}
		PreparedStatement ptmt = null;
		
		
		
		ActionListener eventSua = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					update();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		};
		
		ActionListener eventXoa = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				delete();

			}

		};
		
			public static boolean checkEmail(String email) {
				String regex = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
				return email.matches(regex);
			}

			public static boolean checkPhoneNumber(String phoneNumber) {
				String regex = "(\\+84|0)\\d{9,10}";
				return phoneNumber.matches(regex);
			}
			
			public static boolean checkMCT(String mact) throws SQLException {
				ResultSet meterIdList = ffse1703004.model.DBConnection.getMeterIdList();
				while (meterIdList.next()) {
					if (mact.equals(meterIdList.getString("mact"))) {
						return true;
					}
				}
				return false;
			}
				
	private	void addComboBoxCounty(ResultSet county, JComboBox<Object> cb) throws SQLException {
			while (county.next()) {
				cb.addItem(county.getObject("tenquan"));
			}
		}

	private	void addComboBoxWard(ResultSet wardList, JComboBox<Object> cb) throws SQLException {
			while (wardList.next()) {
				cb.addItem(wardList.getObject("tenphuong"));
			}
		}
	public void addEvents() {
		table.getSelectionModel().addListSelectionListener(eventDataToTextField);
		cbBxQuan1.addActionListener(eventQuan1);
		butThem.addActionListener(eventThem);
		butSua.addActionListener(eventSua);
		butXoa.addActionListener(eventXoa);
		btnSearch1.addActionListener(eventTimKiem);
		
	}	
}
	
