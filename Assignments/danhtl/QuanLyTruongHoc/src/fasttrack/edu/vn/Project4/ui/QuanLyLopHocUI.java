package fasttrack.edu.vn.Project4.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
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

import fasttrack.edu.vn.Project4.model.Connect;
import fasttrack.edu.vn.Project4.model.LopHoc;
import fasttrack.edu.vn.Project4.model.QuanLyDiem;
import fasttrack.edu.vn.Project4.model.SinhVien;

public class QuanLyLopHocUI extends JPanel{
	private static final long serialVersionUID = 1L;

	public QuanLyLopHocUI() {
		addControls();
		addEvent();
	}
	private JTextField malop = new JTextField();
	private JTextField mota = new JTextField();
	private JTextField Namhoc = new JTextField();

	static ArrayList<SinhVien> arrSV = new ArrayList<SinhVien>();
	private ArrayList<LopHoc> arrlop = new ArrayList<LopHoc>();
	static ArrayList<QuanLyDiem> arrdiem = new ArrayList<QuanLyDiem>();

	JComboBox<String> LOP = new JComboBox<>();
	
	JComboBox<String> cbo = new JComboBox<>();
	
	JComboBox<String> lopmoncualop = new JComboBox<>();
	
	JComboBox<String> monmoncualop = new JComboBox<>();
	private JButton lopthem = new JButton("Thêm");
	private JButton lopsua = new JButton("Sửa");
	private JButton lopxoa = new JButton("Xóa");
	private JButton lopnhap = new JButton("nhập");

	private DefaultTableModel dmlop;
	private JTable tablelop;
	private JScrollPane splop;

	public void addControls() {
		// lớp

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel pnButtonlop = new JPanel();
		pnButtonlop.setLayout(new FlowLayout());
		pnButtonlop.add(lopthem);
		pnButtonlop.add(lopsua);
		pnButtonlop.add(lopxoa);
		pnButtonlop.add(lopnhap);
		this.add(pnButtonlop);

		JPanel ttlop = new JPanel();

		ttlop.setLayout(new BoxLayout(ttlop, BoxLayout.X_AXIS));

		JPanel pnmalop = new JPanel();
		pnmalop.setLayout(new FlowLayout());
		JLabel lbllop = new JLabel("  Mã Lớp :   ");
		malop = new JTextField(12);
		pnmalop.add(lbllop);
		pnmalop.add(malop);
		ttlop.add(pnmalop);

		JPanel pnmota = new JPanel();
		pnmota.setLayout(new FlowLayout());
		JLabel lbltenlop = new JLabel(" Mô Tả  :     ");
		mota = new JTextField(12);
		pnmota.add(lbltenlop);
		pnmota.add(mota);
		ttlop.add(pnmota);

		JPanel pnnamhoc = new JPanel();
		pnnamhoc.setLayout(new FlowLayout());
		JLabel lblnamhoc = new JLabel("Năm Học :");
		Namhoc = new JTextField(12);
		pnnamhoc.add(lblnamhoc);
		pnnamhoc.add(Namhoc);
		ttlop.add(pnnamhoc);

		JPanel nhaplop = new JPanel();
		nhaplop.setLayout(new FlowLayout());
		Border borderlop = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitlelop = BorderFactory.createTitledBorder(borderlop, "Thêm Thông Tin");
		nhaplop.setBorder(borderTitlelop);
		nhaplop.add(ttlop);

		this.add(nhaplop);

		JPanel Table1 = new JPanel();
		Table1.setLayout(new FlowLayout());
		Border borderlop1 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitlelop1 = BorderFactory.createTitledBorder(borderlop1, "Danh sách sinh viên");
		Table1.setBorder(borderTitlelop1);

		dmlop = new DefaultTableModel();

		dmlop.addColumn("Mã Lớp");
		dmlop.addColumn("Mô Tả");
		dmlop.addColumn("Năm Học");
		Connection conn = Connect.getConnect("localhost", "Danh", "Danh", "Danh");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM quan_ly_lop_hoc");
			while (result.next()) {
				arrlop.add(
						new LopHoc(result.getString("ma_lop"), result.getString("mo_ta"), result.getString("nam_hoc")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (LopHoc x : arrlop) {
			String[] row = { x.getMalop(), x.getTenlop(), x.getNamhoc() };
			dmlop.addRow(row);
		}

		tablelop = new JTable(dmlop);
		tablelop.setLayout(new BorderLayout());
		splop = new JScrollPane(tablelop);
		JScrollPane sc1 = new JScrollPane(splop, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc1.setPreferredSize(new Dimension(1170, 500));
		Table1.add(sc1, BorderLayout.CENTER);
		this.add(Table1);
	}
	
	public void addEvent() {

		// CRUD lớp học
		tablelop.addMouseListener(eventTablelop);
		lopthem.addActionListener(eventAdd_LopHoc);
		lopxoa.addActionListener(eventDel_LopHoc);
		lopsua.addActionListener(eventEdit_LopHoc);
		lopnhap.addActionListener(eventReset_LopHoc);
//		namhoc.addActionListener();

	}

	
	MouseAdapter eventTablelop = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int row = tablelop.getSelectedRow();
			String[] col = new String[3];
			col[0] = (String) tablelop.getValueAt(row, 0);
			col[1] = (String) tablelop.getValueAt(row, 1);
			col[2] = (String) tablelop.getValueAt(row, 2);
			lopthem.setEnabled(false);
			malop.setEditable(false);
			malop.setText(col[0]);
			mota.setText(col[1]);
			Namhoc.setText(col[2]);
		}
	};

	ActionListener eventAdd_LopHoc = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			int i = 0;
			String ma_LopHoc = malop.getText();
			String mota_LopHoc = mota.getText();
			String nam_LopHoc = Namhoc.getText();

			for (LopHoc y : arrlop) {
				if (ma_LopHoc.equals(y.getMalop())) {
					i = 1;
				}
			}
			if (i > 0) {
				JOptionPane.showMessageDialog(null, "Lớp Học đã tồn tại!!", null, JOptionPane.WARNING_MESSAGE);
			} else {

				try {
					Connection conn = Connect.getConnect("localhost", "Danh", "Danh", "Danh");
					if (ma_LopHoc.equals("") || mota_LopHoc.equals("") || nam_LopHoc.equals("")) {
						JOptionPane.showMessageDialog(null, "Bạn chưa nhập thông tin");
					} else {

						arrlop.add(new LopHoc(ma_LopHoc, mota_LopHoc, nam_LopHoc));
						dmlop.addRow(new String[] { ma_LopHoc, mota_LopHoc, nam_LopHoc });
						try {
							String sql = "INSERT INTO quan_ly_lop_hoc(ma_lop,mo_ta,nam_hoc) VALUES (" + "'" + ma_LopHoc + "','"
									+ mota_LopHoc + "','" + nam_LopHoc + "'" + ")";
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
			malop.setText("");
			mota.setText("");
			Namhoc.setText("");

		}
	};

	ActionListener eventDel_LopHoc = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String ma_LopHoc = malop.getText();
			String mota_LopHoc = mota.getText();
			String nam_LopHoc = Namhoc.getText();
			Connection conn = Connect.getConnect("localhost", "Danh", "Danh", "Danh");
			if (ma_LopHoc.equals("") || mota_LopHoc.equals("") || nam_LopHoc.equals("")) {
				JOptionPane.showMessageDialog(null, "Bạn chưa có thông tin cần xóa", null, JOptionPane.WARNING_MESSAGE);
			} else {
				try {
					for (LopHoc x : arrlop) {
						if (malop.getText().equals(x.getMalop())) {
							arrlop.remove(x);
							break;
						}
					}
					String sql = "DELETE FROM quan_ly_lop_hoc WHERE ma_lop = '" + malop.getText() + "'";
					Statement statement = conn.createStatement();
					int x = statement.executeUpdate(sql);
					if (x >= 0) {
						JOptionPane.showMessageDialog(null, "Đã xóa thông tin sinh viên");
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			dmlop.setRowCount(0);
			for (LopHoc x : arrlop) {
				String[] row = { x.getMalop(), x.getTenlop(), x.getNamhoc()};
				
				dmlop.addRow(row);
			}

			malop.setText("");
			mota.setText("");
			Namhoc.setText("");
		}

	};

	ActionListener eventEdit_LopHoc = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String ma_LopHoc = malop.getText();
			String mota_LopHoc = mota.getText();
			String nam_LopHoc = Namhoc.getText();
			Connection conn = Connect.getConnect("localhost", "Danh", "Danh", "Danh");
			if (ma_LopHoc.equals("") || mota_LopHoc.equals("") || nam_LopHoc.equals("")) {
				JOptionPane.showMessageDialog(null, "Bạn chưa có thông tin cần sửa", null, JOptionPane.WARNING_MESSAGE);
			} else {
				try {
					for (LopHoc x : arrlop) {
						if (malop.getText().equals(x.getMalop())) {
						
							x.setTenlop(mota_LopHoc);
							x.setNamhoc(nam_LopHoc);
							break;
						}
					}
					String sql = "UPDATE lophoc SET TenLop ='" + mota_LopHoc + "',NamHoc ='" + nam_LopHoc
							+ "' WHERE MaLop = '" + ma_LopHoc + "'";
					Statement statement = conn.createStatement();
					int x = statement.executeUpdate(sql);
					if (x >= 0) {
						JOptionPane.showMessageDialog(null, "Đã sửa thông tin sinh viên");
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			dmlop.setRowCount(0);
			for (LopHoc x : arrlop) {
				String[] row = { x.getMalop(), x.getTenlop(), x.getNamhoc() };
				dmlop.addRow(row);
			}

			malop.setText("");
			mota.setText("");
			Namhoc.setText("");
		}

	};

	ActionListener eventReset_LopHoc = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			lopthem.setEnabled(true);
			malop.setEditable(true);
			malop.setText("");
			mota.setText("");
			Namhoc.setText("");
		}

	};
	// kết thúc CRUD lớp học

}


