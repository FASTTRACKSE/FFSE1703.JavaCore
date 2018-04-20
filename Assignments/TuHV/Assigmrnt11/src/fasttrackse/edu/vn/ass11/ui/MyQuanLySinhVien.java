package fasttrackse.edu.vn.ass11.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Statement;

import fasttrackse.edu.vn.ass11.model.*;
import fasttrackse.edu.vn.ass11.ui.*;

import javax.swing.JButton;
import javax.swing.JComboBox;

public class MyQuanLySinhVien extends JFrame {

	private static final ActionListener Edit = null;
	private JTextField txtMaSV = new JTextField(15);
	private JTextField txtTenSV = new JTextField(15);
	private JTextField txtTuoi = new JTextField(15);
	private String[] Item = { "FFSE1701", "FFSE1702", "FFSE1703", "FFSE1704", "All" };
	private ArrayList<SinhVien> arrSV = new ArrayList<SinhVien>();
	DefaultTableModel dm;
	private JComboBox classSV;
	JTable tbl;
	JComboBox cbo;
	 final Connection conn = QuanLySinhVienslq.getConnect("localhost", "sinhviendb", "tu", "123456");
	int stt = 0;
	String lop = "All";
	private JButton btnThem = new JButton("Thêm");
	private JButton btnSua = new JButton("Sửa");
	private JButton btnXoa = new JButton("Xoá");
	private JButton btnThoat = new JButton("Thoát");
	private JButton btnNhap = new JButton("Nhập");

	protected JComboBox select;

	public MyQuanLySinhVien(String tieude) {
		super(tieude);
		addConTrols();
		addEvent();
	}

	public void addConTrols() {
		Container con = getContentPane();
		JPanel pnBorderLayout = new JPanel();

		pnBorderLayout.setLayout(new BoxLayout(pnBorderLayout, BoxLayout.Y_AXIS));
		JLabel lbl = new JLabel("Chương Trình Quản Lý Sinh Viên");
		lbl.setForeground(Color.BLACK);
		Font font = new Font("Arial", Font.BOLD, 20);
		lbl.setFont(font);
		JPanel pnTitle = new JPanel();
		pnTitle.add(lbl);
		pnBorderLayout.add(pnTitle);

		JPanel pnContent6 = new JPanel();
		cbo = new JComboBox(Item);
		JLabel lblContent6 = new JLabel("Chọn Lớp : ");

		pnContent6.add(lblContent6);
		pnContent6.add(cbo);
		pnBorderLayout.add(pnContent6);

		JPanel pnContent1 = new JPanel();
		pnContent1.setLayout(new FlowLayout());
		JLabel lblContent1 = new JLabel("Mã Sinh Viên : ");
		txtMaSV = new JTextField(30);
		pnContent1.add(lblContent1);
		pnContent1.add(txtMaSV);
		pnBorderLayout.add(pnContent1);

		JPanel pnContent2 = new JPanel();
		pnContent2.setLayout(new FlowLayout());
		JLabel lblContent2 = new JLabel("Tên Sinh Viên :");
		txtTenSV = new JTextField(30);
		pnContent2.add(lblContent2);
		pnContent2.add(txtTenSV);
		pnBorderLayout.add(pnContent2);

		JPanel pnContent5 = new JPanel();
		pnContent5.setLayout(new FlowLayout());
		JLabel lblContent5 = new JLabel("Tuổi :                 ");
		txtTuoi = new JTextField(30);
		pnContent5.add(lblContent5);
		pnContent5.add(txtTuoi);
		pnBorderLayout.add(pnContent5);

		JPanel pnContent3 = new JPanel();
		pnContent3.setLayout(new FlowLayout());
		pnContent3.add(btnThem);
		pnContent3.add(btnSua);
		pnContent3.add(btnXoa);
		pnContent3.add(btnThoat);
		pnContent3.add(btnNhap);
		pnBorderLayout.add(pnContent3);

		JPanel pnTable = new JPanel();
		dm = new DefaultTableModel();
		tbl = new JTable(dm);
		dm.addColumn("Mã");
		dm.addColumn("Tên");
		dm.addColumn("Tuổi");
		dm.addColumn("Lớp");

		
		try {
			Statement statement = (Statement) conn.createStatement();
			ResultSet result = ((java.sql.Statement) statement).executeQuery("SELECT * FROM danhsachsv");
			while (result.next()) {
				arrSV.add(new SinhVien(result.getString("code"), result.getString("name"), result.getString("age"), result.getString("class")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (SinhVien x : arrSV) {

			dm.addRow(new String[] { x.getSVma(), x.getSVten(), x.getSVtuoi() });
			tbl = new JTable(dm);
		}

		JScrollPane sc = new JScrollPane(tbl);
		JScrollPane VT = new JScrollPane(sc, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		VT.setPreferredSize(new Dimension(470, 100));
		pnTable.add(VT, BorderLayout.CENTER);
		pnBorderLayout.add(pnTable);

		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Danh sách");
		pnTable.setBorder(borderTitle);

		con.add(pnBorderLayout);
	}

	public void addEvent() {
		tbl.addMouseListener(eventTable);
		cbo.addActionListener(eventChooseClass);
		btnThoat.addActionListener(Exit);
		btnThem.addActionListener(Add);
		btnXoa.addActionListener(Del);
		btnSua.addActionListener(eventEdit);

	}

	MouseAdapter eventTable = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int col = tbl.getSelectedRow();
			String[] row = new String[3];
			row[0] = (String) tbl.getValueAt(col, 0);
			row[1] = (String) tbl.getValueAt(col, 1);
			row[2] = (String) tbl.getValueAt(col, 2);
			txtMaSV.setText(row[0]);
			txtTenSV.setText(row[1]);
			txtTuoi.setText(row[2]);
			for (int i = 0; i < arrSV.size(); i++) {
				if (row[0].equals(arrSV.get(i).getSVma())) {
					stt = i;
				}
			}
		}
	};

	ActionListener eventChooseClass = new ActionListener() {

		public void actionPerformed(ActionEvent arg0) {

			
			try {
				arrSV.clear();
			
				Statement statement = (Statement) conn.createStatement();
				ResultSet rs = statement.executeQuery("select * from danhsachsv");
				while (rs.next()) {
					String id = rs.getString("code");
					String name = rs.getString("name");
					String age = rs.getString("age");
					String class1 = rs.getString("class");
					arrSV.add(new SinhVien(id, name, age, class1));

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			String lop = cbo.getSelectedItem().toString();
			dm.setRowCount(0);
			if (lop == "All") {
				for (SinhVien sv : arrSV) {
					String[] row = { sv.getSVma(), sv.getSVten(), sv.getSVtuoi(), sv.getSVlop() };
					dm.addRow(row);
				}
			} else {
				for (SinhVien sv : arrSV) {
					if (lop.equals(sv.getSVlop())) {
						String[] row = { sv.getSVma(), sv.getSVten(), sv.getSVtuoi(), sv.getSVlop() };
						dm.addRow(row);
					}
				}
			}
			txtMaSV.setText("");
			txtTenSV.setText("");
			txtTuoi.setText("");
		}

	};

	ActionListener Exit = new ActionListener() {

		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);

		}
	};

	ActionListener Add = new ActionListener() {

		public void actionPerformed(ActionEvent arg0) {
			String chonLop = (String) cbo.getSelectedItem();
			String ma = chonLop + txtMaSV.getText();
			String ten = txtTenSV.getText();
			String tuoi = txtTuoi.getText();
			
			
			try {
				String sql = "INSERT INTO danhsachsv(code,name,age,class) VALUES ('"  + ma + "','" + ten + "','"
						+ tuoi + "','" + chonLop + "'" + ")";
				Statement statement = (Statement) conn.createStatement();
				int x = statement.executeUpdate(sql);
				if (x > 0) {
					JOptionPane.showMessageDialog(null, "Đã lưu thông tin sinh viên");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			txtMaSV.setText("");
			txtTenSV.setText("");
			txtTuoi.setText("");
			arrSV.add(new SinhVien(ma, ten, tuoi, chonLop));
			dm.addRow(new String[] { ma, ten, tuoi, chonLop });

		}
	};

	ActionListener Del = new ActionListener() {

		public void actionPerformed(ActionEvent arg0) {
			try {
			
			arrSV.remove(stt);
			dm.setRowCount(0);

		
			try {
				String sql = "DELETE FROM danhsachsv WHERE code = '" + txtMaSV.getText() + "'";
				Statement statement = (Statement) conn.createStatement();
				int x = statement.executeUpdate(sql);
				if (x >= 0) {
					JOptionPane.showMessageDialog(null, "Đã xóa thông tin sinh viên");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
				String lop = cbo.getSelectedItem().toString();
				dm.setRowCount(0);
				if (lop == "All") {
					for (SinhVien sv : arrSV) {
						String[] row = { sv.getSVma(), sv.getSVten(), sv.getSVtuoi(), sv.getSVlop() };
						dm.addRow(row);
					}
				} else {
					for (SinhVien sv : arrSV) {
						if (lop.equals(sv.getSVlop())) {
							String[] row = { sv.getSVma(), sv.getSVten(), sv.getSVtuoi(), sv.getSVlop() };
							dm.addRow(row);
						}
					}
				}
			}
			}catch(Exception e) {
				
			}
		}
	};

	ActionListener eventEdit = new ActionListener() {

		public void actionPerformed(ActionEvent arg0) {

			for (SinhVien x : arrSV) {
				if (txtMaSV.getText().equals(x.getSVma())) {
					x.setSVten(txtTenSV.getText());
					x.setSVtuoi(txtTuoi.getText());

					break;
				}
			}
			
			try {
				String sql = "UPDATE danhsachsv SET name ='" + txtTenSV.getText() + "',age ='" + txtTuoi.getText()
						+ "' WHERE code = '" + txtMaSV.getText() + "'";
				Statement statement = (Statement) conn.createStatement();
				int x = statement.executeUpdate(sql);
				if (x >= 0) {
					JOptionPane.showMessageDialog(null, "Đã sửa thông tin sinh viên");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			dm.setRowCount(0);
			for (SinhVien x : arrSV) {
				String[] row = { x.getSVma(), x.getSVten(), x.getSVtuoi(), x.getSVlop() };
				dm.addRow(row);
			}

		}

	};

	public void showWindow() {
		this.setSize(500, 440);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
