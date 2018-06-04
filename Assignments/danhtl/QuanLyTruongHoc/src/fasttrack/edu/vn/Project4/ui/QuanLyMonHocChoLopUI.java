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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import fasttrack.edu.vn.Project4.model.Connect;
import fasttrack.edu.vn.Project4.model.QuanLyMonLop;

public class QuanLyMonHocChoLopUI extends JPanel {
	
	private static final long serialVersionUID = 1L;




 ArrayList<QuanLyMonLop> arrmoncualop = new ArrayList<QuanLyMonLop>();
	

	
	
	JComboBox<String> lopmoncualop = new JComboBox<>();
	JComboBox<String> monmoncualop = new JComboBox<>();

	

	private JButton themmoncualop = new JButton("Thêm");
	private JButton suamoncualop = new JButton("Sửa");
	private JButton xoamoncualop = new JButton("Xóa");

	

	
	private DefaultTableModel dmmonlop;
	private JTable tablemonlop;
	private JScrollPane spmonlop;
	
	public QuanLyMonHocChoLopUI() {
		
		addControls();
        addEvent();
        lop();
        monhoc();
	}

	public void addControls() {
		


		// môn của lớp
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel pnlopcuamon = new JPanel();
		pnlopcuamon.setLayout(new FlowLayout());
		JLabel lbllopcuamon = new JLabel(" Chọn Lớp   :");
		
		pnlopcuamon.add(lbllopcuamon);
		pnlopcuamon.add(lopmoncualop);

		JPanel pnmoncualop = new JPanel();
		pnmoncualop.setLayout(new FlowLayout());
		JLabel lblmoncualop = new JLabel("Chọn Môn Học :");
		pnmoncualop.add(lblmoncualop);
		pnmoncualop.add(monmoncualop);
		

		JPanel pnButtonmoncualop = new JPanel();
		pnButtonmoncualop.setLayout(new FlowLayout());
		pnButtonmoncualop.add(themmoncualop);
		pnButtonmoncualop.add(suamoncualop);
		pnButtonmoncualop.add(xoamoncualop);

		JPanel nhapmonlop = new JPanel();
		nhapmonlop.setLayout(new GridLayout(1, 3));
		Border borlopcuamon = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitlelopcuamon = BorderFactory.createTitledBorder(borlopcuamon, "Thêm Thông Tin");
		nhapmonlop.setBorder(borderTitlelopcuamon);
		nhapmonlop.add(pnlopcuamon);
		nhapmonlop.add(pnmoncualop);
		nhapmonlop.add(pnButtonmoncualop);
		this.add(nhapmonlop);

		JPanel nhapmonlop1 = new JPanel();
		nhapmonlop1.setLayout(new FlowLayout());
		Border bormonlop = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitlemonlop = BorderFactory.createTitledBorder(bormonlop, "Danh sách sinh viên");
		nhapmonlop1.setBorder(borderTitlemonlop);

		dmmonlop = new DefaultTableModel();

		dmmonlop.addColumn("Mã Lớp");
		dmmonlop.addColumn("Mã Môn Học");
		dmmonlop.addColumn("Tên Môn Học  ");
		Connection connml = Connect.getConnect("localhost", "Danh", "Danh", "Danh");
		try {
			Statement statement = connml.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM mon_hoc_lop");
			while (result.next()) {
				arrmoncualop.add(new QuanLyMonLop(result.getString("ten_lop"), result.getString("ma_MH"),
						result.getString("Ten_mon")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (QuanLyMonLop x : arrmoncualop) {
			String[] row = { x.getMalop1(), x.getMamon(), x.getTenmon() };
			dmmonlop.addRow(row);
		}

		tablemonlop = new JTable(dmmonlop);
		tablemonlop.setLayout(new BorderLayout());
		spmonlop = new JScrollPane(tablemonlop);
		JScrollPane sc4 = new JScrollPane(spmonlop, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc4.setPreferredSize(new Dimension(1170, 500));
		nhapmonlop1.add(sc4, BorderLayout.CENTER);
		this.add(nhapmonlop1);	
		
	}
	public void lop() {
		lopmoncualop.addItem("Tất cả");
		Connection conn = Connect.getConnect("localhost", "Danh", "Danh", "Danh");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM quan_ly_lop_hoc");
			while (result.next()) {
				lopmoncualop.addItem(new String(result.getString("ma_lop")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void monhoc() {
		Connection conn = Connect.getConnect("localhost", "Danh", "Danh", "Danh");
		try {
			monmoncualop.addItem("Chọn môn");
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM Quan_ly_mon_hoc");
			while (result.next()) {
				monmoncualop.addItem(new String(result.getString("ma_mon_hoc")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// lấy xong giá trị của JComboBox

	public void addEvent() {

		// CRUD môn học cho từng lớp học
		tablemonlop.addMouseListener(eventTable_MonHocLop);
		themmoncualop.addActionListener(eventAdd_MonHocLop);
		xoamoncualop.addActionListener(eventDel_MonHocLop);
		lopmoncualop.addActionListener(eventChooseLop);
	}

	// CRUD môn học cho lớp học

	MouseAdapter eventTable_MonHocLop = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int row = tablemonlop.getSelectedRow();
			String[] col = new String[3];
			col[0] = (String) tablemonlop.getValueAt(row, 0);
			col[1] = (String) tablemonlop.getValueAt(row, 1);
			col[2] = (String) tablemonlop.getValueAt(row, 2);
			lopmoncualop.setSelectedItem(col[0]);
			monmoncualop.setSelectedItem(col[1]);

		}
	};

	ActionListener eventAdd_MonHocLop = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			int i = 0;
			String chonLop = (String) lopmoncualop.getSelectedItem();
			String chonMH = (String) monmoncualop.getSelectedItem();
			try {
				Connection conn = Connect.getConnect("localhost", "Danh", "Danh", "Danh");
				for (QuanLyMonLop y : arrmoncualop) {
					if (chonLop.equals(y.getMalop1()) && chonMH.equals(y.getMamon())) {
						i = 1;
					}
				}
				if (i > 0) {
					JOptionPane.showMessageDialog(null, "Môn học đã tồn tại!", null, JOptionPane.WARNING_MESSAGE);
				} else {
					Statement statement = conn.createStatement();
					ResultSet result = statement
							.executeQuery("SELECT * FROM Quan_ly_mon_hoc WHERE ma_mon_hoc ='" + chonMH + "'");
					result.next();
					arrmoncualop.add(new QuanLyMonLop(chonLop, result.getString("ma_mon_hoc"),
							result.getString("ten")));

					String[] row = { chonLop, result.getString("ma_mon_hoc"), result.getString("ten") };
					dmmonlop.addRow(row);

					String sql = "INSERT INTO mon_hoc_lop( ma_MH, ten_mon, ten_lop) VALUES ('"
							+ result.getString("ma_mon_hoc") + "','" + result.getString("ten") + "','" + chonLop + "')";
					int x = statement.executeUpdate(sql);
					if (x > 0) {
						JOptionPane.showMessageDialog(null, "Đã lưu thông tin");
					}
				}

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Bạn cần nhập thông tin");
			}
			dmmonlop.setRowCount(0);
			for (QuanLyMonLop x : arrmoncualop) {
				if (chonLop.equals(x.getMalop1())) {
					String[] row = { x.getMalop1(), x.getMamon(), x.getTenmon() };
					dmmonlop.addRow(row);
				}
			}
		}
	};

	ActionListener eventDel_MonHocLop = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String chonLop = (String) lopmoncualop.getSelectedItem();
			String chonMH = (String) monmoncualop.getSelectedItem();
			for (QuanLyMonLop x : arrmoncualop) {
				if (chonMH.equals(x.getMamon()) && chonLop.equals(x.getMalop1())) {
					arrmoncualop.remove(x);
					break;
				}
			}
			Connection conn = Connect.getConnect("localhost", "Danh", "Danh", "Danh");
			try {
				String sql = "DELETE FROM mon_hoc_lop WHERE MaMH = '" + chonMH + "' AND TenLop ='" + chonLop + "'";
				Statement statement = conn.createStatement();
				int x = statement.executeUpdate(sql);
				if (x >= 0) {
					JOptionPane.showMessageDialog(null, "Đã xóa thông tin sinh viên");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			dmmonlop.setRowCount(0);
			for (QuanLyMonLop x : arrmoncualop) {
				if (chonLop.equals(x.getMalop1())) {
					String[] row = { x.getMalop1(), x.getMamon(), x.getTenmon() };
					dmmonlop.addRow(row);
				}
			}
		}

	};
	// kết thúc CRUD chọn môn học cho lớp

	// Chọn lớp học cho button
	ActionListener eventChooseLop = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String chonLop = (String) lopmoncualop.getSelectedItem();
			dmmonlop.setRowCount(0);
			for (QuanLyMonLop x : arrmoncualop) {
				if (chonLop.equals(x.getMalop1())) {
					String[] row = { x.getMalop1(), x.getMamon(), x.getTenmon()};
					dmmonlop.addRow(row);
				}
			}
		}
	};

}

