package fasttrack.edu.vn.Project4.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
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

import fasttrack.edu.vn.Project4.model.Connect;
import fasttrack.edu.vn.Project4.model.QuanLyMonHoc;

public class QuanLyMonHocUI extends JPanel{
	private static final long serialVersionUID = 1L;
	private JButton monthem = new JButton("Thêm");
	private JButton monsua = new JButton("Sửa");
	private JButton monxoa = new JButton("Xóa");
	private JButton monnhap = new JButton("nhập");
	
	private ArrayList<QuanLyMonHoc> arrmon = new ArrayList<QuanLyMonHoc>();
	
	private JTextField Ma_MH = new JTextField();
	private JTextField Ten_MH = new JTextField();
	private JTextField tinchi = new JTextField();
	private JTextField time = new JTextField();
	
	private DefaultTableModel dmmon;
	private JTable tablemon;
	private JScrollPane spmon;
	
	public QuanLyMonHocUI() {
		addControls();
		addEvent();
	}
	
	
	public void addControls() {
	
	
	this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

	JPanel pnButtonmh = new JPanel();
	pnButtonmh.setLayout(new FlowLayout());
	pnButtonmh.add(monthem);
	pnButtonmh.add(monsua);
	pnButtonmh.add(monxoa);
	pnButtonmh.add(monnhap);
	this.add(pnButtonmh);

	JPanel monhoc = new JPanel();
	monhoc.setLayout(new BoxLayout(monhoc, BoxLayout.Y_AXIS));

	JPanel pnmonhoc = new JPanel();
	pnmonhoc.setLayout(new FlowLayout());
	JLabel lblmonhoc = new JLabel("Mã Môn Học :");
	Ma_MH = new JTextField(12);
	pnmonhoc.add(lblmonhoc);
	pnmonhoc.add(Ma_MH);
	monhoc.add(pnmonhoc);

	JPanel Tenmh = new JPanel();
	Tenmh.setLayout(new FlowLayout());
	JLabel lblmh = new JLabel("Tên Môn Học :");
	Ten_MH = new JTextField(12);
	Tenmh.add(lblmh);
	Tenmh.add(Ten_MH);
	monhoc.add(Tenmh);

	JPanel monhoc1 = new JPanel();
	monhoc1.setLayout(new BoxLayout(monhoc1, BoxLayout.Y_AXIS));

	JPanel pnsotc = new JPanel();
	pnsotc.setLayout(new FlowLayout());
	JLabel lblsotc = new JLabel("Số Tín Chỉ :  ");
	tinchi = new JTextField(12);
	pnsotc.add(lblsotc);
	pnsotc.add(tinchi);
	monhoc1.add(pnsotc);

	JPanel pntime = new JPanel();
	pntime.setLayout(new FlowLayout());
	JLabel lbltime = new JLabel(" Thời Gian Học :");
	time = new JTextField(12);
	pntime.add(lbltime);
	pntime.add(time);
	monhoc1.add(pntime);

	JPanel nhapmon = new JPanel();
	nhapmon.setLayout(new GridLayout(1, 3));
	Border bormon = BorderFactory.createLineBorder(Color.RED);
	TitledBorder borderTitlemon = BorderFactory.createTitledBorder(bormon, "Thêm Thông Tin");
	nhapmon.setBorder(borderTitlemon);
	nhapmon.add(monhoc);
	nhapmon.add(monhoc1);

	this.add(nhapmon);

	JPanel Table2 = new JPanel();
	Table2.setLayout(new FlowLayout());
	Border bormon2 = BorderFactory.createLineBorder(Color.RED);
	TitledBorder borderTitlemon2 = BorderFactory.createTitledBorder(bormon2, "Danh sách sinh viên");
	Table2.setBorder(borderTitlemon2);

	dmmon = new DefaultTableModel();

	dmmon.addColumn("Mã Môn Học");
	dmmon.addColumn("Tên Môn Học");
	dmmon.addColumn("Số Tín Chỉ ");
	dmmon.addColumn("Thời Gian Học ");
	Connection conn1 = Connect.getConnect("localhost", "Danh", "Danh", "Danh");
	try {
		Statement statement = conn1.createStatement();
		ResultSet result = statement.executeQuery("SELECT * FROM quan_ly_mon_hoc");
		while (result.next()) {
			arrmon.add(new QuanLyMonHoc(result.getString("ma_mon_hoc"), result.getString("ten"),
					result.getString("so_tin_chi"), result.getString("thoi_luong_hoc")));
		}
	} catch (Exception e) {
		e.printStackTrace();
	}

	for (QuanLyMonHoc x : arrmon) {
		String[] row = { x.getMamon(), x.getTenmon(), x.getSotc(), x.getTime() };
		dmmon.addRow(row);
	}
	tablemon = new JTable(dmmon);
	tablemon.setLayout(new BorderLayout());
	spmon = new JScrollPane(tablemon);
	JScrollPane sc2 = new JScrollPane(spmon, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	sc2.setPreferredSize(new Dimension(1170, 500));
	Table2.add(sc2, BorderLayout.CENTER);
	this.add(Table2);

}
	
	

	public void addEvent() {

		// CRUD môn học
		tablemon.addMouseListener(eventTable_MonHoc);
		monthem.addActionListener(eventAdd_MonHoc);
		monxoa.addActionListener(eventDel_MonHoc);
		monsua.addActionListener(eventEdit_MonHoc);
		monnhap.addActionListener(eventReset_MonHoc);
	}

	// CRUD Lớp Học

	MouseAdapter eventTable_MonHoc = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int row = tablemon.getSelectedRow();
			String[] col = new String[4];
			col[0] = (String) tablemon.getValueAt(row, 0);
			col[1] = (String) tablemon.getValueAt(row, 1);
			col[2] = (String) tablemon.getValueAt(row, 2);
			col[3] = (String) tablemon.getValueAt(row, 3);
			monthem.setEnabled(false);
			Ma_MH.setEditable(false);
			Ma_MH.setText(col[0]);
			Ten_MH.setText(col[1]);
			tinchi.setText(col[2]);
			time.setText(col[3]);
		}
	};

	ActionListener eventAdd_MonHoc = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			int i = 0;
			String ma_MonHoc = Ma_MH.getText();
			String ten_MonHoc = Ten_MH.getText();
			String tinchi_MonHoc = tinchi.getText();
			String time_MonHoc = time.getText();

			for (QuanLyMonHoc y : arrmon) {
				if (ma_MonHoc.equals(y.getMamon())) {
					i = 1;
				}
			}
			if (i > 0) {
				JOptionPane.showMessageDialog(null, "Môn Học đã tồn tại!!", null, JOptionPane.WARNING_MESSAGE);
			} else {
				try {
					Connection conn = Connect.getConnect("localhost", "Danh", "Danh", "Danh");
					if (ma_MonHoc.equals("") || ten_MonHoc.equals("") || tinchi_MonHoc.equals("")
							|| time_MonHoc.equals("")) {
						JOptionPane.showMessageDialog(null, "Bạn chưa nhập thông tin");
					} else {
						arrmon.add(new QuanLyMonHoc(ma_MonHoc, ten_MonHoc, tinchi_MonHoc, time_MonHoc));
						dmmon.addRow(new String[] { ma_MonHoc, ten_MonHoc, tinchi_MonHoc, time_MonHoc });

						try {
							String sql = "INSERT INTO Quan_ly_mon_hoc( ma_mon_hoc, ten, so_tin_chi, thoi_luong_hoc) VALUES ('" + ma_MonHoc
									+ "','" + ten_MonHoc + "','" + tinchi_MonHoc + "','" + time_MonHoc + "')";
							Statement statement = conn.createStatement();
							int x = statement.executeUpdate(sql);
							if (x > 0) {
								JOptionPane.showMessageDialog(null, "Đã lưu thông tin");
							}
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Bạn cần nhập thông tin");
				}
			}
			Ma_MH.setText("");
			Ten_MH.setText("");
			tinchi.setText("");
			time.setText("");
		}
	};

	ActionListener eventDel_MonHoc = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String ma_MonHoc = Ma_MH.getText();
			String ten_MonHoc = Ten_MH.getText();
			String tinchi_MonHoc = tinchi.getText();
			String time_MonHoc = time.getText();

			Connection conn = Connect.getConnect("localhost", "Danh", "Danh", "Danh");
			if (ma_MonHoc.equals("") || ten_MonHoc.equals("") || tinchi_MonHoc.equals("") || time_MonHoc.equals("")) {
				JOptionPane.showMessageDialog(null, "Bạn chưa có thông tin cần xóa", null, JOptionPane.WARNING_MESSAGE);
			} else {
				try {
					for (QuanLyMonHoc x : arrmon) {
						if (Ma_MH.getText().equals(x.getMamon())) {
							arrmon.remove(x);
							break;
						}
					}
					String sql = "DELETE FROM Quan_ly_mon_hoc WHERE ma_mon_hoc = '" + Ma_MH.getText() + "'";
					Statement statement = conn.createStatement();
					int x = statement.executeUpdate(sql);
					if (x >= 0) {
						JOptionPane.showMessageDialog(null, "Đã xóa thông tin sinh viên");
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			dmmon.setRowCount(0);
			for (QuanLyMonHoc x : arrmon) {
				String[] row = { x.getMamon(), x.getTenmon(), x.getSotc(), x.getTime() };
				dmmon.addRow(row);
			}

			Ma_MH.setText("");
			Ten_MH.setText("");
			tinchi.setText("");
			time.setText("");
		}

	};

	ActionListener eventEdit_MonHoc = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String ma_MonHoc = Ma_MH.getText();
			String ten_MonHoc = Ten_MH.getText();
			String tinchi_MonHoc = tinchi.getText();
			String time_MonHoc = time.getText();

			Connection conn = Connect.getConnect("localhost", "Danh", "Danh", "Danh");
			if (ma_MonHoc.equals("") || ten_MonHoc.equals("") || tinchi_MonHoc.equals("") || time_MonHoc.equals("")) {
				JOptionPane.showMessageDialog(null, "Bạn chưa có thông tin cần sửa", null, JOptionPane.WARNING_MESSAGE);
			} else {
				try {
					for (QuanLyMonHoc x : arrmon) {
						if (Ma_MH.getText().equals(x.getMamon())) {
							x.setTenmon(Ten_MH.getText());
							x.setSotc(tinchi.getText());
							x.setTime(time.getText());
							break;
						}
					}
					String sql = "UPDATE Quan_ly_mon_hoc SET ten ='" + Ten_MH.getText() + "',so_tin_chi ='" + tinchi.getText()
							+ "',thoi_luong_hoc ='" + time.getText() + "' WHERE ma_mon_hoc = '" + Ma_MH.getText() + "'";
					Statement statement = conn.createStatement();
					int x = statement.executeUpdate(sql);
					if (x >= 0) {
						JOptionPane.showMessageDialog(null, "Đã sửa thông tin sinh viên");
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			dmmon.setRowCount(0);
			for (QuanLyMonHoc x : arrmon) {
				String[] row = { x.getMamon(), x.getTenmon(), x.getSotc(), x.getTime() };
				dmmon.addRow(row);
			}

			Ma_MH.setText("");
			Ten_MH.setText("");
			tinchi.setText("");
			time.setText("");
		}
	};

	ActionListener eventReset_MonHoc = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			monthem.setEnabled(true);
			Ma_MH.setEditable(true);
			Ma_MH.setText("");
			Ten_MH.setText("");
			tinchi.setText("");
			time.setText("");
		}
	};
	// kết thúc CRUD môn học


}