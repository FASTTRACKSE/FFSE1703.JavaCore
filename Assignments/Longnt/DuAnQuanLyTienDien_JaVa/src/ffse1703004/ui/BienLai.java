package ffse1703004.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

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
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

import ffse1703004.model.DBConnection;
import ffse1703004.model.MyException;

public class BienLai extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static DBConnection DBConnection = new DBConnection();
	static Connection conn = ffse1703004.model.DBConnection.ketnoi("localhost", "ffse1703004_java", "root",
			"");
	JTextField txtSearch, txtMeterID, txtDateAdded, txtMeterIndex;
	private JButton btnSearch, butThem, butSua, butXoa, butTroVe;
	private DefaultTableModel model = new DefaultTableModel(
			new Object[] { "Mã biên lai", "Mã Công tơ", "Chỉ số công tơ", "Ngày nhập", "Chu kì nhập", "Số tiền" }, 0);
	final JTable table = new JTable(model);
	JScrollPane sc = new JScrollPane(table);
	JComboBox<?> cbBxmonth, cbBxyear;
	JMonthChooser jmc;
	JYearChooser jyc;

	public BienLai() throws HeadlessException, SQLException {
		Display();
		addControls();
		addevent();
	}

	public void addControls() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border);
		this.setBorder(borderTitle);
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		JPanel pnTitle = new JPanel();
		JLabel lblTitle = new JLabel("Quản lí biên lai");
		Font fontTitle = new Font("arial", Font.BOLD, 20);
		lblTitle.setFont(fontTitle);
		pnTitle.add(lblTitle);

		JPanel pn1 = new JPanel();
		JLabel lblSearch1 = new JLabel("Mã công tơ");
		txtSearch = new JTextField(20);
		btnSearch = new JButton("Tìm kiếm");
		pn1.add(lblSearch1);
		pn1.add(txtSearch);
		pn1.add(btnSearch);

		JPanel pn3 = new JPanel();
		butThem = new JButton("Thêm");
		butThem.setPreferredSize(new Dimension(140, 50));
		ImageIcon insert = new ImageIcon(
				new ImageIcon("icons/insert.png").getImage().getScaledInstance(40, 45, Image.SCALE_SMOOTH));
		JLabel lblIconInsert = new JLabel(insert);
		butThem.add(lblIconInsert);
		butSua = new JButton("Sửa");
		butSua.setPreferredSize(new Dimension(140, 50));
		ImageIcon update = new ImageIcon(
				new ImageIcon("icons/t.png").getImage().getScaledInstance(40, 45, Image.SCALE_SMOOTH));
		JLabel lblIconUpdate = new JLabel(update);
		butSua.add(lblIconUpdate);
		butXoa = new JButton("Xóa");
		butXoa.setPreferredSize(new Dimension(140, 50));
		ImageIcon delete = new ImageIcon(
				new ImageIcon("icons/delete.png").getImage().getScaledInstance(40, 45, Image.SCALE_SMOOTH));
		JLabel lblIconDelete = new JLabel(delete);
		butXoa.add(lblIconDelete);

		butTroVe = new JButton("Trở về");
		butTroVe.setPreferredSize(new Dimension(140, 50));
		ImageIcon back = new ImageIcon(
				new ImageIcon("icons/Undo.png").getImage().getScaledInstance(30, 45, Image.SCALE_SMOOTH));
		JLabel lblIconBack = new JLabel(back);
		butTroVe.add(lblIconBack);
		butTroVe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);
				Display();
			}
		});

		pn3.add(butThem);
		pn3.add(butSua);
		pn3.add(butXoa);
		pn3.add(butTroVe);

		JScrollPane sc = new JScrollPane(table);

		JPanel pn5 = new JPanel();
		JLabel lblMeterID = new JLabel("Mã công tơ");
		lblMeterID.setPreferredSize(new Dimension(90, 15));
		txtMeterID = new JTextField(15);
		pn5.add(lblMeterID);
		pn5.add(txtMeterID);

		JPanel pn6 = new JPanel();
		JLabel lblDateAdded = new JLabel("Ngày nhập");
		lblDateAdded.setPreferredSize(new Dimension(90, 15));
		txtDateAdded = new JTextField(15);
		txtDateAdded.setEditable(false);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();

		txtDateAdded.setText(dateFormat.format(date));
		pn6.add(lblDateAdded);
		pn6.add(txtDateAdded);

		JPanel pn7 = new JPanel();
		JLabel lblMonth = new JLabel("Chu kì nhập");
		lblMonth.setPreferredSize(new Dimension(90, 15));

		jmc = new JMonthChooser();
		jyc = new JYearChooser();
		pn7.add(lblMonth);
		pn7.add(jmc);
		pn7.add(jyc);

		JPanel pn9 = new JPanel();
		JLabel lblMeterIndex = new JLabel("Chỉ số công tơ");
		lblMeterIndex.setPreferredSize(new Dimension(90, 15));
		txtMeterIndex = new JTextField(15);
		pn9.add(lblMeterIndex);
		pn9.add(txtMeterIndex);

		pnMain.add(pnTitle);
		pnMain.add(pn1);
		pnMain.add(sc);
		pnMain.add(pn3);
		pnMain.add(pn5);
		pnMain.add(pn6);
		pnMain.add(pn7);
		pnMain.add(pn9);

		this.add(pnMain);
	}

	void addevent() {
		table.addMouseListener(eventDataToTextField);
		butThem.addActionListener(eventThem);
		butSua.addActionListener(eventSua);
		butXoa.addActionListener(eventXoa);
		btnSearch.addActionListener(eventAddDataToTable);

	}

	public void Display() {
		if (conn != null) {

			String sql = "select * from BienLai";
			try {
				PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
				ResultSet rs = ptmt.executeQuery();
				while (rs.next()) {
					String rows[] = new String[6];

					rows[0] = rs.getString(1);
					rows[1] = rs.getString(2);
					rows[2] = rs.getString(3);
					rows[3] = rs.getString(4);
					rows[4] = rs.getString(5);
					rows[5] = rs.getString(6);
					model.addRow(rows);
				}
			} catch (SQLException e) {
				System.out.println("lỗi" + e.getMessage());

			}
		} else {
			System.out.println("Kết nối MYSQL thất bại");
		}
	}

	ActionListener eventAddDataToTable = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			ResultSet invoiceList = ffse1703004.model.DBConnection.getInvoice(txtSearch.getText());
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);

			try {
				addDataToTable(invoiceList, model);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		}
	};

	ActionListener eventThem = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (txtMeterID.getText().equals("") || txtMeterIndex.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Hãy nhập đầy đủ thông tin");
			} else {
				String mact = txtMeterID.getText();
				String ngaynhap = txtDateAdded.getText();
				int month = jmc.getMonth() + 1;
				int year = jyc.getYear();

				String cycle = year + "/" + month;
				DateFormat df = new SimpleDateFormat("yyyy/MM");
				Date cycleday;

				try {
					cycleday = df.parse(cycle);

				} catch (Exception e1) {
					cycleday = new Date();
					e1.printStackTrace();
				}

				try {
					MyException.checkInt(txtMeterIndex.getText());
					int recentMeterIndex = Integer.parseInt(txtMeterIndex.getText());
					int meterNumber = 0;
					Locale locale = new Locale("vi", "VN");
					NumberFormat formatter = DecimalFormat.getCurrencyInstance(locale);
					formatter.setRoundingMode(RoundingMode.HALF_UP);
					int lastestMeterIndex = 0;
					ResultSet lastestInvoice = ffse1703004.model.DBConnection.getLastMeterIndex(mact);

					try {

						while (lastestInvoice.next()) {
							lastestMeterIndex = lastestInvoice.getInt(1);
						}
						if (recentMeterIndex < lastestMeterIndex) {
							JOptionPane.showMessageDialog(null,
									"Chỉ số mới phải lớn hơn hoặc bằng chỉ số cũ, vui lòng nhập lại");
						} else if (txtMeterID.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Mã công tơ không được để trống");
						} else {
							meterNumber = recentMeterIndex - lastestMeterIndex;
							int thanhtien = heSoQuyDoi(meterNumber);

							if (ffse1703004.model.DBConnection.addInvoice(mact, ngaynhap, cycleday, recentMeterIndex,
									thanhtien)) {
								JOptionPane.showMessageDialog(null, "Thêm thành công");
								String sql = "select * from BienLai";
								model.setRowCount(0);
								try {
									PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
									ResultSet rs = ptmt.executeQuery();
									while (rs.next()) {
										String rows[] = new String[6];
										rows[0] = rs.getString(1);
										rows[1] = rs.getString(2);
										rows[2] = rs.getString(3);
										rows[3] = rs.getString(4);
										rows[4] = rs.getString(5);
										rows[5] = rs.getString(6);
										model.addRow(rows);
									}
								} catch (SQLException e1) {
									System.out.println("Lỗi" + e1.getMessage());

								}

							}
						} 
					} catch (SQLException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Thêm thất bại");
					}
				} catch (MyException e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		}
	};

	void getDataToTextField() {
		int row = table.getSelectedRow();
		String month = (String) table.getValueAt(row, 4);
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = formatter.parse(month);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		txtMeterID.setEditable(false);
		txtDateAdded.setEditable(true);
		txtMeterID.setText((String) table.getValueAt(row, 1));
		txtDateAdded.setText((String) table.getValueAt(row, 3));
		jmc.setMonth(cal.get(Calendar.MONTH));
		jyc.setYear(cal.get(Calendar.YEAR));
		txtMeterIndex.setText((String) table.getValueAt(row, 2));
	}

	MouseListener eventDataToTextField = new MouseAdapter() {
		public void mouseClicked(MouseEvent arg0) {
			getDataToTextField();
		}
	};

	ActionListener eventSua = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (table.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn dòng muốn sửa");
			} else {
				String meterID = (String) table.getValueAt(table.getSelectedRow(), 1);
				if (txtMeterIndex.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
				} else if (!meterID.equals(txtMeterID.getText())) {
					JOptionPane.showMessageDialog(null, "Không cho phép thay đổi mã công tơ, vui lòng nhập lại");
				} else {
					try {
						editInvoice();
						int row = table.getSelectedRow();
						int col = table.getSelectedColumn();
						table.changeSelection(row, col, false, false);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}

		}
	};

	void editInvoice() throws SQLException {
		int invoiceID = Integer.parseInt((String) table.getValueAt(table.getSelectedRow(), 0));
		String meterID = (String) table.getValueAt(table.getSelectedRow(), 1);
		ResultSet preMeterIndexResultSet = ffse1703004.model.DBConnection.getPreMeterIndexForEdit(meterID, invoiceID);
		int preMeterIndex = 0;
		while (preMeterIndexResultSet.next()) {
			preMeterIndex = preMeterIndexResultSet.getInt(1);
		}
		int month = jmc.getMonth() + 1;
		int year = jyc.getYear();
		String cycle = year + "/" + month;
		DateFormat df = new SimpleDateFormat("yyyy/MM");
		Date cycleDate;
		try {
			cycleDate = df.parse(cycle);
		} catch (ParseException e1) {
			cycleDate = new Date();
			e1.printStackTrace();
		}

		int inputMeterIndex = Integer.parseInt(txtMeterIndex.getText());
		int inputMetterId = Integer.parseInt(txtMeterID.getText());
		int meterNumber = inputMeterIndex - preMeterIndex;
		int amount = heSoQuyDoi(meterNumber);

		int lastInvoiceID = 0;
		ResultSet invoiceIdList = ffse1703004.model.DBConnection.getLastInvoiceID(meterID);
		while (invoiceIdList.next()) {
			lastInvoiceID = invoiceIdList.getInt(1);
		}

		int nextMeterIndex = 0;
		ResultSet nextMeterIndexResultSet = ffse1703004.model.DBConnection.getNextMeterIndexForEdit(meterID, invoiceID,
				lastInvoiceID);
		while (nextMeterIndexResultSet.next()) {
			nextMeterIndex = nextMeterIndexResultSet.getInt(1);
		}
		if (inputMetterId == lastInvoiceID && inputMeterIndex >= nextMeterIndex) {
			if (ffse1703004.model.DBConnection.editInvoice(cycleDate, txtMeterIndex.getText(), amount, invoiceID)) {
				JOptionPane.showMessageDialog(null, "Sửa thành công");
				model.setRowCount(0);
				try {
					String sql1 = "SELECT * FROM BienLai";
					PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql1);
					ResultSet rs = ptmt.executeQuery();
					while (rs.next()) {
						String rows[] = new String[6];
						rows[0] = rs.getString(1);
						rows[1] = rs.getString(2);
						rows[2] = rs.getString(3);
						rows[3] = rs.getString(4);
						rows[4] = rs.getString(5);
						rows[5] = rs.getString(6);
						model.addRow(rows);
					}
				} catch (SQLException e1) {
					System.out.println("Lỗi" + e1.getMessage());

				}
			} else {
				JOptionPane.showMessageDialog(null, "Sửa thất bại");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Sửa thất bại");
		}

	}

	void addDataToTable(ResultSet customerList, DefaultTableModel model) throws SQLException {
		Object[] row = new Object[6];
		while (customerList.next()) {
			for (int i = 1; i <= 6; ++i) {
				row[i - 1] = customerList.getString(i); // Or even rs.getObject()
			}
			model.addRow(row);
		}

	}

	int heSoQuyDoi(int meterNumber) throws SQLException {
		int rate[] = { 0, 1549, 1600, 1858, 2340, 2615, 2701 };
		int step[] = { 0, 50, 50, 100, 100, 100 };
		int i = 1;
		int subtotal, total = 0;

		while (meterNumber > 0) {
			if (i < 6) {
				meterNumber = meterNumber - step[i];
				if (meterNumber > 0) {
					subtotal = step[i] * rate[i];
					total += subtotal;
				} else {
					subtotal = (meterNumber + step[i]) * rate[i];
					total += subtotal;
				}
				i++;

			} else {
				subtotal = meterNumber * rate[i];
				total += subtotal;
				break;
			}
		}

		return total;
	}

	ActionListener eventXoa = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			xoaBienLai();
		}
	};

	public void xoaBienLai() {
		if (conn != null) {
			int myChose = JOptionPane.showConfirmDialog(null, "Bạn cóm muốn xóa dữ liệu này không?", "Xóa",
					JOptionPane.YES_NO_OPTION);
			if (myChose == JOptionPane.YES_OPTION) {
				String sql = "DELETE FROM BienLai WHERE mact=?";
				try {
					PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
					ptmt.setString(1, txtMeterID.getText());
					int kt = ptmt.executeUpdate();
					if (kt != 0) {
						int j = table.getSelectedRow();
						JOptionPane.showMessageDialog(null, "Xóa thành công");
						model.removeRow(j);
						txtMeterID.setText("");
						txtMeterIndex.setText("");
					} else
						JOptionPane.showMessageDialog(null, "Xóa không thành công");
				} catch (SQLException e) {
					System.out.println("Lỗi " + e.getMessage());
				}
			} else {
				JOptionPane.showMessageDialog(null, "Xóa không thành công");
			}
		} else {
			System.out.println("Kết nối MYSQL thất bại");
		}
	}

	PreparedStatement ptmt = null;

}