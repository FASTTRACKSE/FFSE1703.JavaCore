package atm.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import atm.model.GetDatabase;
import atm.model.GetQuanPhuong;
import atm.model.MyException;

public class LayoutKhachHang extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	GetDatabase conn = new GetDatabase();
	Connection db = (Connection) GetDatabase.getConnect();
	DefaultTableModel dm = new DefaultTableModel();
	final JTable tbl = new JTable();
	JScrollPane sc = new JScrollPane();
	GetQuanPhuong cbItem = new GetQuanPhuong();
	ArrayList<String> arrPhuong = new ArrayList<String>();
	JComboBox<String> cboQuan, cboPhuong;
	JButton btnThem, btnSua, btnXoa, btnHuy;
	JTextField txtMaKh, txtEmail, txtTen, txtDiaChi, txtSoTk, txtSoThe, txtSdt, txtSoDu, txtMaPin;
	private String tbKh[] = { "Mã Khách Hàng", "Email", "Họ và Tên", "Số nhà", "Số tài khoản", "Số thẻ",
			"Số điện thoại", "Số Dư", "Mã Pin", "Quận", "Phường" };
	DefaultTableModel tb = new DefaultTableModel(tbKh, 0);

	public LayoutKhachHang() {
		addControls();
		addEvent();
		select();
	}
	public void addControls() {

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setLayout(new BorderLayout());

		// Danh sách khách hàng
		JPanel pnLon = new JPanel();
		pnLon.setLayout(new BoxLayout(pnLon, BoxLayout.Y_AXIS));

		JPanel pn1 = new JPanel();

		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Danh sách Khách Hàng");
		sc.setBorder(borderTitle);
		tbl.setModel(tb);
		tbl.setPreferredScrollableViewportSize(new Dimension(1160, 300));
		sc.setViewportView(tbl);
		sc.setOpaque(false);
		tbl.setOpaque(true);
		tbl.setFillsViewportHeight(true);
		// tbl.setBackground(Color.WHITE);
		pn1.add(sc, BorderLayout.CENTER);
		// pn1.setLayout(new BorderLayout());
		// pn1.setPreferredSize(new Dimension(0, 350));
		// pn1.add(sc, BorderLayout.CENTER);

		// Panel tìm kiếm
		JPanel pn1Right = new JPanel();

		// JPanel pnImage = new JPanel(){
		// public void paintComponent(Graphics g)
		// {
		// Dimension d = getSize();
		// Image img=this.getToolkit().getImage("image/tpbank2.jpg");
		// g.drawImage(img, 0, 0, d.width, d.height, null);
		//
		// setOpaque( false ); // lam trong suot
		// super.paintComponent(g);
		// }
		// };
		//
		// pnImage.setPreferredSize(new Dimension(100, 150));
		// pn1Right.add(pnImage);

		JPanel pnTim = new JPanel();
		JPanel pnKiem = new JPanel();

		JComboBox<String> cboTimKiem = new JComboBox<String>();
		cboTimKiem.addItem("Tất Cả");
		JLabel lbl = new JLabel("Tìm theo: ");
		cboTimKiem.setPreferredSize(new Dimension(100, 20));
		pnTim.add(lbl);
		pnTim.add(cboTimKiem);
		// pn1Right.setLayout(new BoxLayout(pn1Right, BoxLayout._AXIS));
		pn1Right.setLayout(new BoxLayout(pn1Right, BoxLayout.Y_AXIS));
		// Border border2 = BorderFactory.createLineBorder(Color.RED);
		// TitledBorder borderTitle2 = BorderFactory.createTitledBorder(border2, "Tìm
		// kiếm");
		// pn1Right.setBorder(borderTitle2);
		JTextField txtTimKiem = new JTextField(20);
		JButton btnTimKiem = new JButton("Tìm Kiếm");
		// pnTim.setPreferredSize(new Dimension(200,10));
		// pnKiem.setPreferredSize(new Dimension(255,50));
		// pn1Right.add(pnImage);
		pnTim.add(txtTimKiem);
		pnKiem.add(btnTimKiem);
		pn1Right.add(pnTim);
		pn1Right.add(pnKiem);
		pnLon.add(pn1);
		pnLon.add(pn1Right);

		// pn1Right.setBorder(new CompoundBorder(new EmptyBorder(0,10,0,0),
		// BorderFactory.createTitledBorder(borderTitle2)));

		// JPanel pn2 = new JPanel();

		// nhập thông tin
		JPanel pn3 = new JPanel();
		pn3.setLayout(new BoxLayout(pn3, BoxLayout.Y_AXIS));
		Border border3 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle3 = BorderFactory.createTitledBorder(border3, "Nhập thông tin");
		pn3.setBorder(borderTitle3);

		JPanel pnLeft = new JPanel();
		pnLeft.setLayout(new BoxLayout(pnLeft, BoxLayout.X_AXIS));

		Border border3n = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle3n = BorderFactory.createTitledBorder(border3n);
		pnLeft.setBorder(borderTitle3n);

		JPanel pnLeft1 = new JPanel();
		pnLeft1.setLayout(new BoxLayout(pnLeft1, BoxLayout.Y_AXIS));

		JPanel pnMkh = new JPanel();
		JLabel lblMkh = new JLabel("Mã Khách Hàng:");
		lblMkh.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtMaKh = new JTextField(20);
		pnMkh.add(lblMkh);
		pnMkh.add(txtMaKh);

		JPanel pnEmail = new JPanel();
		JLabel lblEmail = new JLabel("Email:               ");
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtEmail = new JTextField(20);
		pnEmail.add(lblEmail);
		pnEmail.add(txtEmail);

		JPanel pnTen = new JPanel();
		JLabel lblTen = new JLabel("Họ & Tên KH:  ");
		lblTen.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtTen = new JTextField(20);
		pnTen.add(lblTen);
		pnTen.add(txtTen);

		JPanel pnDiaChi = new JPanel();
		JLabel lblDiaChi = new JLabel("Địa Chỉ:            ");
		lblDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtDiaChi = new JTextField(20);
		pnDiaChi.add(lblDiaChi);
		pnDiaChi.add(txtDiaChi);

		JPanel pnMaPin = new JPanel();
		JLabel lblMaPin = new JLabel("Mã Pin:            ");
		lblMaPin.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtMaPin = new JTextField(20);
		pnMaPin.add(lblMaPin);
		pnMaPin.add(txtMaPin);

		pnLeft1.add(pnMkh);
		pnLeft1.add(pnEmail);
		pnLeft1.add(pnTen);
		pnLeft1.add(pnDiaChi);
		pnLeft1.add(pnMaPin);

		JPanel pnLeft2 = new JPanel();
		pnLeft2.setLayout(new BoxLayout(pnLeft2, BoxLayout.Y_AXIS));

		JPanel pnSoTk = new JPanel();
		JLabel lblSoTk = new JLabel("Số TK Ngân Hàng:");
		lblSoTk.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtSoTk = new JTextField(20);
		pnSoTk.add(lblSoTk);
		pnSoTk.add(txtSoTk);

		JPanel pnSoThe = new JPanel();
		JLabel lblSoThe = new JLabel("Số thẻ ATM:         ");
		lblSoThe.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtSoThe = new JTextField(20);
		pnSoThe.add(lblSoThe);
		pnSoThe.add(txtSoThe);

		JPanel pnSdt = new JPanel();
		JLabel lblSdt = new JLabel("Điện thoại:            ");
		lblSdt.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtSdt = new JTextField(20);
		pnSdt.add(lblSdt);
		pnSdt.add(txtSdt);

		JPanel pnSoDu = new JPanel();
		JLabel lblSoDu = new JLabel("Số Dư:                 ");
		lblSoDu.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtSoDu = new JTextField(20);
		pnSoDu.add(lblSoDu);
		pnSoDu.add(txtSoDu);

		// JPanel pnLeft3 = new JPanel();
		// pnLeft3.setLayout(new BoxLayout(pnLeft3, BoxLayout.X_AXIS));

		JPanel pnQuan = new JPanel();
		JLabel lblQuan = new JLabel("        Quận:");
		cboQuan = new JComboBox<String>();
		cboQuan.setPreferredSize(new Dimension(120, 20));
		ArrayList<String> arrquan = new ArrayList<String>();
		cboQuan.addItem("Chọn Quận");
		arrquan = GetQuanPhuong.getQuan();
		for (String x : arrquan) {
			cboQuan.addItem(x);
		}
		pnQuan.add(lblQuan);
		pnQuan.add(cboQuan);

		JPanel pnPhuong = new JPanel();
		JLabel lblPhuong = new JLabel("          Phường: ");
		cboPhuong = new JComboBox<String>();
		cboPhuong.addItem("Chọn Phường");
		cboPhuong.setPreferredSize(new Dimension(150, 20));
		pnPhuong.add(lblPhuong);
		pnPhuong.add(cboPhuong);

		pnLeft2.add(pnSoTk);
		pnLeft2.add(pnSoThe);
		pnLeft2.add(pnSdt);
		pnLeft2.add(pnSoDu);
		pnLeft2.add(pnQuan);
		pnLeft2.add(pnPhuong);

		pnLeft.add(pnLeft1);
		pnLeft.add(pnLeft2);

		JPanel pnRight = new JPanel();
		pnRight.setLayout(new BoxLayout(pnRight, BoxLayout.Y_AXIS));

		Border border3n2 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle3n2 = BorderFactory.createTitledBorder(border3n2);

		JPanel pnThem = new JPanel();
		// ImageIcon icon = new
		// ImageIcon("D:\\FFSE1703.JavaCore\\Assignments\\ThachND\\Duanmayatm\\image\\them.png");
		// icon.setImage(icon.getImage());
		btnThem = new JButton("Thêm", new ImageIcon(
				((new ImageIcon("D:/FFSE1703.JavaCore/Assignments/ThachND/Duanmayatm/image/them.png")).getImage())
						.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
		btnThem.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnThem.setPreferredSize(new Dimension(250, 50));
		pnThem.add(btnThem);
		pnRight.add(pnThem);

		JPanel pnSua = new JPanel();
		btnSua = new JButton("Sửa", new ImageIcon(
				((new ImageIcon("D:/FFSE1703.JavaCore/Assignments/ThachND/Duanmayatm/image/sua.png")).getImage())
						.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
		btnSua.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnSua.setPreferredSize(new Dimension(250, 50));
		pnSua.add(btnSua);
		pnRight.add(pnSua);

		JPanel pnXoa = new JPanel();
		btnXoa = new JButton("Xóa", new ImageIcon(
				((new ImageIcon("D:/FFSE1703.JavaCore/Assignments/ThachND/Duanmayatm/image/xoa.png")).getImage())
						.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
		btnXoa.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnXoa.setPreferredSize(new Dimension(250, 50));
		pnXoa.add(btnXoa);
		pnRight.add(pnXoa);

		JPanel pnHuy = new JPanel();
		btnHuy = new JButton("Hủy", new ImageIcon(
				((new ImageIcon("D:/FFSE1703.JavaCore/Assignments/ThachND/Duanmayatm/image/huy.png")).getImage())
						.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
		btnHuy.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnHuy.setPreferredSize(new Dimension(250, 50));
		pnHuy.add(btnHuy);
		pnRight.add(pnHuy);

		// pn3n2.setBorder(borderTitle3n2);
		// pn3n2.setPreferredSize(new Dimension(350, 0));
		pnRight.setBorder(
				new CompoundBorder(new EmptyBorder(0, 10, 0, 0), BorderFactory.createTitledBorder(borderTitle3n2)));

		// pn3.setPreferredSize(new Dimension(0, 250));
		// pn1Right.setLayout(new BorderLayout());
		pn3.setLayout(new BorderLayout());
		pn3.add(pnLeft, BorderLayout.CENTER);
		pn3.add(pnRight, BorderLayout.LINE_END);

		this.add(pnLon, BorderLayout.PAGE_START);
		// pnMain.add(pn2);
		this.add(pn3, BorderLayout.CENTER);

	}

	public void addEvent() {
		cboQuan.addActionListener(chonPhuong);
		btnThem.addActionListener(Them);
		btnSua.addActionListener(Sua);
		btnXoa.addActionListener(Xoa);
		btnHuy.addActionListener(Huy);
		tbl.addMouseListener(eventChooseRow);
	}

	MouseAdapter eventChooseRow = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int dong = tbl.getSelectedRow();
			if (dong > -1) {
				String makh = tbl.getValueAt(dong, 0).toString();
				String email = tbl.getValueAt(dong, 1).toString();
				String ten = tbl.getValueAt(dong, 2).toString();
				String diachi = tbl.getValueAt(dong, 3).toString();
				String sotk = tbl.getValueAt(dong, 4).toString();
				String sothe = tbl.getValueAt(dong, 5).toString();
				String sdt = tbl.getValueAt(dong, 6).toString();
				String sodu = tbl.getValueAt(dong, 7).toString();
				String mapin = tbl.getValueAt(dong, 8).toString();
				String quan = tbl.getValueAt(dong, 9).toString();
				String phuong = tbl.getValueAt(dong, 10).toString();

				txtMaKh.setText(makh);
				txtEmail.setText(email);
				txtTen.setText(ten);
				txtDiaChi.setText(diachi);
				txtSoTk.setText(sotk);
				txtSoThe.setText(sothe);
				txtSdt.setText(sdt);
				txtSoDu.setText(sodu);
				txtMaPin.setText(mapin);
				cboQuan.setSelectedItem(quan);
				cboPhuong.setSelectedItem(phuong);
				txtMaKh.setEditable(false);
			}
		}
	};

	ActionListener chonPhuong = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			int id = cboQuan.getSelectedIndex();
			if (id == 0) {
				cboPhuong.removeAllItems();
				cboPhuong.addItem("Chọn Phường");
			} else {
				arrPhuong = GetQuanPhuong.getPhuong(id);
				cboPhuong.removeAllItems();
				for (String x : arrPhuong) {
					cboPhuong.addItem(x);
				}
			}

		}
	};
	ActionListener Them = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (cboQuan.getSelectedItem() == null) {
				JOptionPane.showMessageDialog(null, "Bạn chưa chọn thành phố");
			} else if (cboPhuong.getSelectedItem() == null) {
				JOptionPane.showMessageDialog(null, "Bạn chưa chọn quận");
			} else {
				try {
					insert();
				} catch (MyException e1) {
					e1.printStackTrace();
				}
			}
		}
	};

	ActionListener Sua = new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			String makh = txtMaKh.getText();
			String email = txtEmail.getText();
			String ten = txtTen.getText();
			String diachi = txtDiaChi.getText();
			String sotk = txtSoTk.getText();
			String sothe = txtSoThe.getText();
			String sdt = txtSdt.getText();
			String sodu = txtSoDu.getText();
			String mapin = txtMaPin.getText();
			String quan = cboQuan.getSelectedItem().toString();
			String phuong = cboPhuong.getSelectedItem().toString();

			try {
				String sql = "update khachhang set email='" + email + "', ten_kh='" + ten + "', so_nha='" + diachi
						+ "', so_tk='" + sotk + "',so_the='" + sothe + "',sdt='" + sdt + "',so_du='" + sodu
						+ "',ma_pin='" + mapin + "',quan='" + quan + "',phuong='" + phuong + "' where ma_kh='" + makh
						+ "'";
				Statement statement = (Statement) db.createStatement();
				int x = statement.executeUpdate(sql);
				if (x > 0) {
					tb.setRowCount(0);
					JOptionPane.showMessageDialog(null, "Cập nhật thành công");
					select();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			txtMaKh.setText("");
			txtEmail.setText("");
			txtTen.setText("");
			txtDiaChi.setText("");
			txtSoTk.setText("");
			txtSoThe.setText("");
			txtSdt.setText("");
			txtSoDu.setText("");
			txtMaPin.setText("");
			cboQuan.setSelectedIndex(0);
			cboPhuong.setSelectedIndex(0);
			txtMaKh.setEditable(true);
		}
	};

	// <--Phương thức thêm Khách Hàng-->
	public void insert() throws MyException {
		try {

			if (MyException.ChekMaKh(txtMaKh.getText()) && MyException.ChekEmpty(txtMaKh.getText())
					&& MyException.ChekEmpty(txtTen.getText()) && MyException.ChekSo(txtSdt.getText())
					&& MyException.ChekEmpty(txtEmail.getText()) && MyException.ChekEmpty(txtSoTk.getText())) {
				if (db != null) {
					String sql = "INSERT INTO `khachhang` ( `ma_kh`, `ten_kh`, `so_nha`, `phuong`, `quan`, `sdt`, `email`, `so_the`, `so_tk`, `so_du`, `ma_pin`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
					try {

						PreparedStatement pstt = (PreparedStatement) db.prepareStatement(sql);
						// khởi tạo resultset
						pstt.setString(1, txtMaKh.getText());
						pstt.setString(2, txtTen.getText());
						pstt.setString(3, txtDiaChi.getText());
						pstt.setString(4, cboPhuong.getSelectedItem().toString());
						pstt.setString(5, cboQuan.getSelectedItem().toString());
						pstt.setString(6, txtSdt.getText());
						pstt.setString(7, txtEmail.getText());
						pstt.setString(8, txtSoThe.getText());
						pstt.setString(9, txtSoTk.getText());
						pstt.setString(10, txtSoDu.getText());
						pstt.setString(11, txtMaPin.getText());

						int k = pstt.executeUpdate();
						if (k != 0) {
							JOptionPane.showMessageDialog(null, "Thêm thành công");
							String[] row = { txtMaKh.getText(), txtTen.getText(), txtDiaChi.getText(),
									cboPhuong.getSelectedItem().toString(), cboQuan.getSelectedItem().toString(),
									txtSdt.getText(), txtEmail.getText(), txtSoThe.getText(), txtSoTk.getText(),
									txtSoDu.getText(), txtMaPin.getText()};
							tb.addRow(row);
							
							txtMaKh.setText("");
							txtEmail.setText("");
							txtTen.setText("");
							txtDiaChi.setText("");
							txtSoTk.setText("");
							txtSoThe.setText("");
							txtSdt.setText("");
							txtSoDu.setText("");
							txtMaPin.setText("");
							cboQuan.setSelectedItem("");
							cboPhuong.setSelectedItem("");
							
						} else
							JOptionPane.showMessageDialog(null, "Thêm không thành công");
					} catch (SQLException e) {
						System.out.println("loi  " + e.getMessage());
					}
				} else {
					System.out.println("Kết nối MYSQL thất bại");
				}
			}
		} catch (MyException e) {
			System.out.println(e);
		}
	}

	ActionListener Xoa = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (db != null) {
				int myChose = JOptionPane.showConfirmDialog(null, "Bạn Có Muốn Xóa Dữ Liệu Này Không?", "Xóa", JOptionPane.YES_NO_OPTION);
				if(myChose == JOptionPane.YES_OPTION) {
				String sql = "DELETE FROM khachhang WHERE ma_kh=?";
				try {
					PreparedStatement pstt = (PreparedStatement) db.prepareStatement(sql);
					pstt.setString(1, txtMaKh.getText());
					int kt = pstt.executeUpdate();
					if (kt != 0) {
						int j = tbl.getSelectedRow();
						JOptionPane.showMessageDialog(null, "Xóa thành công");
						tb.removeRow(j);
						txtMaKh.setText("");
						txtEmail.setText("");
						txtTen.setText("");
						txtDiaChi.setText("");
						txtSoTk.setText("");
						txtSoThe.setText("");
						txtSdt.setText("");
						txtSoDu.setText("");
						txtMaPin.setText("");
						cboQuan.setSelectedIndex(0);
						cboPhuong.setSelectedIndex(0);
						txtMaKh.setEditable(true);
					} else
						JOptionPane.showMessageDialog(null, "Xóa không thành công");
				} catch (SQLException e1) {
					System.out.println("loi  " + e1.getMessage());
				}
				}
			} else {
				System.out.println("Kết nối MYSQL thất bại");
			}
		}
	};
	

	ActionListener Huy = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			txtMaKh.setText("");
			txtEmail.setText("");
			txtTen.setText("");
			txtDiaChi.setText("");
			txtSoTk.setText("");
			txtSoThe.setText("");
			txtSdt.setText("");
			txtSoDu.setText("");
			txtMaPin.setText("");
			cboQuan.setSelectedIndex(0);
			cboPhuong.setSelectedIndex(0);
			txtMaKh.setEditable(true);
		}
	};

	public void select() {
		if (db != null) {

			String sql = "select * from khachhang";
			try {
				PreparedStatement pstt = (PreparedStatement) db.prepareStatement(sql);
				// khởi tạo resultset
				ResultSet rs = pstt.executeQuery();
				while (rs.next()) {
					String makh = rs.getString("ma_kh");
					String email = rs.getString("email");
					String ten = rs.getString("ten_kh");
					String diachi = rs.getString("so_nha");
					String sotk = rs.getString("so_tk");
					String sothe = rs.getString("so_the");
					String sdt = rs.getString("sdt");
					String sodu = rs.getString("so_du");
					String mapin = rs.getString("ma_pin");
					String quan = rs.getString("quan");
					String phuong = rs.getString("phuong");
					String[] rows = { makh, email, ten, diachi, sotk, sothe, sdt, sodu, mapin, quan, phuong };
					tb.addRow(rows);
				}
			} catch (SQLException e) {
				System.out.println("Lỗi  " + e.getMessage());

			}
		}
	}
}
