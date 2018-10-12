package ffse1703004.ui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;
import ffse1703004.model.DBConnection;
import ffse1703004.model.KhachHangMD;

public class ThongKe extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static DBConnection DBConnection = new DBConnection();
	static Connection conn = ffse1703004.model.DBConnection.ketnoi("localhost", "ffse1703004_java", "thanhlong123",
			"123456");
	ArrayList<KhachHangMD> arrKH = new ArrayList<>();
	private JButton btnSearch, btnSearch1, btnBack;
	private JComboBox<Object> cbBxQuan, cbBxQuan1, cbBxPhuong, cbBxPhuong1;
	private JTextField txtTimKiem;
	@SuppressWarnings("rawtypes")
	JComboBox cb, cb1, cb2;
	JPanel pnSL;
	JMonthChooser jmcStart, jmcEnd, jmcPn3;
	JYearChooser jycPn1, jycStart, jycEnd, jycPn3;
	JTextField txtSearch;
	JButton btnSearch2, btnSearch3, btnSearch4;
	private DefaultTableModel model = new DefaultTableModel(new Object[] { "Mã khách hàng", "Mã công tơ", "Họ tên",
			"Địa chỉ", "Phường", "Quận", "Điện thoại", "Email" }, 0);
	private DefaultTableModel model1 = new DefaultTableModel(new Object[] { "Mã biên lai", "Mã khách hàng",
			"Mã công tơ", "Tên khách hàng", "Địa chỉ",  "Phường","Quận", "Điện thoại", "Email", "Chu kì", "Số tiền" },
			0);
	final JTable table = new JTable(model);
	final JTable table1 = new JTable(model1);

	// JScrollPane sc = new JScrollPane(table);
	public ThongKe() throws HeadlessException, SQLException {
		addControls();
		addEvents();
		Display();
		DisplayTK();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void addControls() throws SQLException {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border);
		this.setBorder(borderTitle);
		JTabbedPane tablePane = new JTabbedPane();
		// Thống kê danh sách khách hàng
		JPanel pan = new JPanel();
		pan.setLayout(new BoxLayout(pan, BoxLayout.Y_AXIS));
		JPanel pn2 = new JPanel();
		pn2.setLayout(new BoxLayout(pn2, BoxLayout.Y_AXIS));

		JPanel pn21 = new JPanel();
		JLabel lb1 = new JLabel("Tên khách hàng");
		txtTimKiem = new JTextField(15);
		btnSearch = new JButton("Tim Kiếm");
		pn21.add(lb1);
		pn21.add(txtTimKiem);
		pn21.add(btnSearch);

		JPanel pn22 = new JPanel();
		JLabel lblCounty = new JLabel("Quận");
		String Quan[] = {};
		cbBxQuan = new JComboBox<Object>(Quan);
		cbBxQuan.setPreferredSize(new Dimension(90, 20));

		JLabel ao = new JLabel("");
		ao.setPreferredSize(new Dimension(50, 20));

		JLabel lblWard = new JLabel("Phường");
		String Phuong[] = {};
		cbBxPhuong = new JComboBox<Object>(Phuong);
		cbBxPhuong.addItem("Chọn phường");
		cbBxPhuong.setPreferredSize(new Dimension(90, 20));

		btnSearch1 = new JButton("Tìm kiếm");
		btnSearch1.setPreferredSize(new Dimension(90, 20));
		pn22.add(lblCounty);
		pn22.add(cbBxQuan);
		pn22.add(ao);
		pn22.add(lblWard);
		pn22.add(cbBxPhuong);
		pn22.add(btnSearch1);

		JPanel pn23 = new JPanel();
		btnBack = new JButton("Tất cả");
		btnBack.setPreferredSize(new Dimension(90, 20));
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Display();
			}
		});
		pn23.add(btnBack);
		pn2.add(pn23);
		pn2.add(pn21);
		pn2.add(pn22);
		JScrollPane pnTable = new JScrollPane(table);
		Border bor = BorderFactory.createLineBorder(Color.RED);
		TitledBorder bortitle = BorderFactory.createTitledBorder(bor, "Danh sách");
		pnTable.setBorder(bortitle);
		pan.add(pn2);
		pan.add(pnTable);
		tablePane.add(pan, "Báo Cáo Danh Sách Khách Hàng");
		
		// Thống kê bào cáo tình hienh tiêu thụ điện
		JPanel panTK = new JPanel();
		panTK.setLayout(new BoxLayout(panTK, BoxLayout.Y_AXIS));

		JPanel pnTKH = new JPanel();
		JLabel lblSearch = new JLabel("Tên khách hàng");
		txtSearch = new JTextField();
		txtSearch.setPreferredSize(new Dimension(115, 20));
		pnTKH.add(lblSearch);
		pnTKH.add(txtSearch);
		panTK.add(pnTKH);

		JPanel pnTKH1 = new JPanel();
		JLabel lblCounty2 = new JLabel("Quận");
		String County[] = {};
		cb1 = new JComboBox<Object>(County);
		cb1.setPreferredSize(new Dimension(115, 20));
		JLabel lblWard2 = new JLabel("Phường");
		String Ward[] = {};
		cb2 = new JComboBox<Object>(Ward);
		cb2.setPreferredSize(new Dimension(115, 20));
		pnTKH1.add(lblCounty2);
		pnTKH1.add(cb1);
		pnTKH1.add(lblWard2);
		pnTKH1.add(cb2);
		panTK.add(pnTKH1);
		
		JPanel panCombo = new JPanel();
		
		String comboBoxItems[] = { "Theo năm", "Theo khoảng thời gian", "Theo kì" };
		 cb = new JComboBox(comboBoxItems);
		 panCombo.add(cb);
		 
		 pnSL = new JPanel(new CardLayout());
			JPanel pnYear = new JPanel();
			jycPn1 = new JYearChooser();
			btnSearch2 = new JButton("Tìm kiếm");
			pnYear.add(jycPn1);
			pnYear.add(btnSearch2);
			JPanel pnInterval = new JPanel();
			jmcStart = new JMonthChooser();
			jycStart = new JYearChooser();
			jmcEnd = new JMonthChooser();
			jycEnd = new JYearChooser();
			JLabel lblStart = new JLabel("Bắt đầu");
			JLabel lblEnd = new JLabel("Kết thúc");
			btnSearch3 = new JButton("Tìm kiếm");
			pnInterval.add(lblStart);
			pnInterval.add(jmcStart);
			pnInterval.add(jycStart);
			pnInterval.add(lblEnd);
			pnInterval.add(jmcEnd);
			pnInterval.add(jycEnd);
			pnInterval.add(btnSearch3);
			JPanel pnTerm = new JPanel();
			jmcPn3 = new JMonthChooser();
			jycPn3 = new JYearChooser();
			btnSearch4 = new JButton("Tìm kiếm");
			pnTerm.add(jmcPn3);
			pnTerm.add(jycPn3);
			pnTerm.add(btnSearch4);
			pnSL.add(pnYear, "0");
			pnSL.add(pnInterval, "1");
			pnSL.add(pnTerm, "2");
			panCombo.add(pnSL);
		
		JScrollPane pnTable1 = new JScrollPane(table1);
		Border bor1 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder bortitle1 = BorderFactory.createTitledBorder(bor1, "Danh sách");
		pnTable1.setBorder(bortitle1);
		panTK.add(panCombo);
		panTK.add(pnTable1);
		tablePane.add(panTK, "Báo Cáo Tình Hình Tiêu Thụ Điện");

		cbBxQuan.addItem("Chọn quận");
		addComboBoxCounty(ffse1703004.model.DBConnection.getQuan(), cbBxQuan);

		Object str = "Tất cả";
		cb1.addItem(str);
		cb2.addItem(str);
		addComboBoxCounty(ffse1703004.model.DBConnection.getQuan(), cb1);
		this.add(tablePane);
	}

	public void addEvents() {
		// tìm khiếm khách hàng
		btnSearch1.addActionListener(eventTimKiemQuan);
		btnSearch.addActionListener(eventTimKiem);
		cbBxQuan.addActionListener(eventQuan);
		// tìm kiếm khách hàng kèm biên lai
		cb.addActionListener(eventChangeCB);
		cb1.addActionListener(eventChangeCounty);
		btnSearch2.addActionListener(eventAddDataToTable1);
		btnSearch3.addActionListener(eventAddDataToTable2);
		btnSearch4.addActionListener(eventAddDataToTable3);
	}


	
	ActionListener eventQuan = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			cbBxPhuong.removeAllItems();
			cbBxPhuong.addItem("Chọn phường");
			int idquan = cbBxQuan.getSelectedIndex();
			try {
				addComboBoxWard(ffse1703004.model.DBConnection.getPhuong(idquan), cbBxPhuong);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	};

	void addComboBoxWard(ResultSet wardList, JComboBox<Object> cb) throws SQLException {
		while (wardList.next()) {
			cb.addItem(wardList.getObject("tenphuong"));
		}
	}

	void addComboBoxCounty(ResultSet county, JComboBox<Object> cb) throws SQLException {
		while (county.next()) {
			cb.addItem(county.getObject("tenquan"));
		}
	}

	public void Display() {
		if (conn != null) {

			String sql = "select * from KhachHang";
			try {
				PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
				// khởi tạo resultset
				model.setRowCount(0);
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
	
	
	ActionListener eventTimKiem = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			timKiem();
		}
	};

	public void timKiem() {
		if (conn != null) {
			String sql = "SELECT * FROM KhachHang WHERE makh LIKE '%" + txtTimKiem.getText() + "%' or tenkh LIKE '"
					+ txtTimKiem.getText() + "'";
			try {
				if (txtTimKiem.getText().isEmpty()) {
					Display();
				} else {
					PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
					// khởi tạo resultset
					ResultSet rs = ptmt.executeQuery();
					model.setRowCount(0);
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
				}
			} catch (SQLException e) {
				System.out.println("Lỗi " + e.getMessage());
			}
		} else {
			System.out.println("Kết nối MYSQL thất bại");
		}
	}

	ActionListener eventTimKiemQuan = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				timKiemQuan();
			} catch (SQLException x) {
				// TODO Auto-generated catch block
				x.printStackTrace();
			}

		}
	};

	public void timKiemQuan() throws SQLException {
		if (conn != null) {
			String sql = "SELECT * FROM KhachHang WHERE idquan = '" + cbBxQuan.getSelectedItem().toString()
					+ "' AND idphuong = '" + cbBxPhuong.getSelectedItem().toString() + "'";
			String sql1 = "SELECT * FROM KhachHang WHERE idquan = '" + cbBxQuan.getSelectedItem().toString() + "'";
			try {
				if (cbBxPhuong.getSelectedItem().toString().equals("Chọn phường")) {
					PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql1);
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
					}
				} else {

					PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
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
					}
				}
			} catch (SQLException e) {
				System.out.println("Lỗi " + e.getMessage());
			}
		} else {
			System.out.println("Kết nối MYSQL thất bại");
		}
	}
	
	ActionListener eventChangeCB = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			CardLayout cl = (CardLayout) (pnSL.getLayout());
			cl.show(pnSL, Integer.toString(cb.getSelectedIndex()));
		}
	};
	
	ActionListener eventChangeCounty = new ActionListener() {

		@SuppressWarnings({ "static-access", "unchecked" })
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			cb2.removeAllItems();
			int countyID = cb1.getSelectedIndex();
			Object str = "Tất cả";
			cb2.addItem(str);
			try {
				addComboBoxWard(DBConnection.getPhuong(countyID), cb2);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	};
	
	public void DisplayTK() {
		if (conn != null) {

			String sql = "SELECT  BienLai.id, KhachHang.id, KhachHang.mact , KhachHang.tenkh, KhachHang.diachi, KhachHang.idphuong, KhachHang.idquan, KhachHang.dienthoai, KhachHang.email,"
					+ "   BienLai.chuki, BienLai.thanhtien"
					+ " FROM KhachHang, BienLai WHERE  KhachHang.mact = BienLai.mact  ";
					
			try {
				PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
				// khởi tạo resultset
				model1.setRowCount(0);
				ResultSet rs = ptmt.executeQuery();
				while (rs.next()) {

					String rows[] = new String[11];

					rows[0] = rs.getString(1);
					rows[1] = rs.getString(2);
					rows[2] = rs.getString(3);
					rows[3] = rs.getString(4);
					rows[4] = rs.getString(5);
					rows[5] = rs.getString(6);
					rows[6] = rs.getString(7);
					rows[7] = rs.getString(8);
					rows[8] = rs.getString(9);
					rows[9] = rs.getString(10);
					rows[10] = rs.getString(11);
					model1.addRow(rows);

				}
			} catch (SQLException e) {
				System.out.println("Lỗi" + e.getMessage());

			}
		} else {
			System.out.println("Kết nối MYSQL thất bại");
		}
	}
	
	ActionListener eventAddDataToTable1 = new ActionListener() {

		@SuppressWarnings("static-access")
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String customerName = txtSearch.getText();
			String countyName = (String) cb1.getSelectedItem();
			String wardName = (String) cb2.getSelectedItem();
			String cycle = Integer.toString(jycPn1.getYear());

			if (countyName.equals("Tất cả")) {
				countyName = "";
			}
			if(wardName.equals("Tất cả")) {
				wardName="";
			}

			ResultSet data = DBConnection.getDataBySearch1(customerName, countyName, wardName, cycle);

			DefaultTableModel model1 = (DefaultTableModel) table1.getModel();
			model1.setRowCount(0);
			try {
				addDataToTable(data, model1);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	};
	
	ActionListener eventAddDataToTable2 = new ActionListener() {

		@SuppressWarnings("static-access")
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String customerName = txtSearch.getText();
			String countyName = (String) cb1.getSelectedItem();
			String wardName = (String) cb2.getSelectedItem();
			
			int monthStart = jmcStart.getMonth() + 1;
			int monthEnd = jmcEnd.getMonth() + 1;

			String cycleStart = jycStart.getYear() + "/" + monthStart;
			String cycleEnd = jycEnd.getYear() + "/" + monthEnd;

			DateFormat df = new SimpleDateFormat("yyyy/MM");

			Date cycleStartDate = null;
			Date cycleEndDate = null;
			try {
				cycleStartDate = df.parse(cycleStart);
				cycleEndDate = df.parse(cycleEnd);
			} catch (ParseException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			if (countyName.equals("Tất cả")) {
				countyName = "";
			}
			if(wardName.equals("Tất cả")) {
				wardName="";
			}

			ResultSet data = DBConnection.getDataBySearch2(customerName, countyName, wardName, cycleStartDate, cycleEndDate);
			DefaultTableModel model1 = (DefaultTableModel) table1.getModel();
			model1.setRowCount(0);
			try {
				addDataToTable(data , model1) ;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	};
	
ActionListener eventAddDataToTable3 = new ActionListener() {
		
		@SuppressWarnings("static-access")
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String customerName = txtSearch.getText();
			String countyName = (String) cb1.getSelectedItem();
			String wardName = (String) cb2.getSelectedItem();
			
			int month = jmcPn3.getMonth() + 1;

			String cycle = jycPn3.getYear() + "/" + month;

			DateFormat df = new SimpleDateFormat("yyyy/MM");

			Date cycleDate = null;
			try {
				cycleDate = df.parse(cycle);
			} catch (ParseException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			if (countyName.equals("Tất cả")) {
				countyName = "";
			}
			if(wardName.equals("Tất cả")) {
				wardName="";
			}

			ResultSet data = DBConnection.getDataBySearch3(customerName, countyName, wardName, cycleDate);

			DefaultTableModel model1 = (DefaultTableModel) table1.getModel();
			model1.setRowCount(0);
			try {
				addDataToTable(data, model1);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	};

	    
	    void addDataToTable(ResultSet customerList, DefaultTableModel model1) throws SQLException {
		Object[] row = new Object[11];
		while (customerList.next()) {
			for (int i = 1; i <= 11; ++i) {
				row[i - 1] = customerList.getString(i); // Or even rs.getObject()
			}
			model1.addRow(row);
		}

	}
		

}
