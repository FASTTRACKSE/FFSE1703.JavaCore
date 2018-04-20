package fasttrack.edu.vn.ass11.ui;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.PopupMenu;
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
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import fasttrack.edu.vn.ass11.model.SinhVien;
import fasttrack.edu.vn.ass11.model.*;
import fasttrack.edu.vn.ass11.ui.QuanLiSinhVien;

public class MyQuanLiSinhVien extends JFrame {
	boolean checked;
	private JScrollPane sp;
	JComboBox select;
	 

	private String[] Item = { "ALL","FFSE1701", "FFSE1702", "FFSE1703", "FFSE1704"};
	private DefaultTableModel dm;
	private JTable tbl;
	static JTextField tenSV = new JTextField(), maSV = new JTextField(), tuoiSV = new JTextField();
	static ArrayList<SinhVien> arrSV = new ArrayList<SinhVien>();
	static String[] lop = { "FFSE1701", "FFSE1702", "FFSE1703", "FFSE1704","ALL" };

	private JButton btnthem = new JButton("Thêm");
	private JButton btnsua = new JButton("Sửa");
	private JButton btnxoa = new JButton("Xóa");
	private JButton btnthoat = new JButton("Thoát");
	private JButton btnnhap = new JButton("Nhập");

	public MyQuanLiSinhVien(String tieude) {
		this.setTitle(tieude);
		addControls();
		addEvent();
	}

	public void addControls() {
		Container con = getContentPane();
		JPanel pnMain = new JPanel();

		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		JLabel lbl = new JLabel("Chương Trình Quản Lý Nhân Viên");
		Font font = new Font("Arial", Font.BOLD, 24);
		lbl.setFont(font);
		lbl.setForeground(Color.YELLOW);
		JPanel Title = new JPanel();
		Title.setBackground(Color.PINK);
		Title.setPreferredSize(new Dimension(0, 50));
		Title.add(lbl);
		pnMain.add(Title, BorderLayout.NORTH);

		JPanel pnContent1 = new JPanel();
		JLabel lblContent1 = new JLabel("Chọn Lớp :");
		select = new JComboBox(Item);
		pnContent1.add(lblContent1);
		pnContent1.add(select);
		pnMain.add(pnContent1);

		JPanel nhapma = new JPanel();
		nhapma.setLayout(new FlowLayout());
		JLabel lblmaSv = new JLabel("Mã Sinh Viên :");
		maSV = new JTextField(30);
		nhapma.add(lblmaSv);
		nhapma.add(maSV);
		pnMain.add(nhapma);

		JPanel nhapTen = new JPanel();
		nhapTen.setLayout(new FlowLayout());
		JLabel lblten = new JLabel("Tên Sinh Viên :");
		tenSV = new JTextField(30);
		nhapTen.add(lblten);
		nhapTen.add(tenSV);
		pnMain.add(nhapTen);

		JPanel tuoi = new JPanel();
		tuoi.setLayout(new FlowLayout());
		JLabel lbltuoi = new JLabel("Tuổi Sinh Viên :");
		tuoiSV = new JTextField(30);
		tuoi.add(lbltuoi);
		tuoi.add(tuoiSV);
		pnMain.add(tuoi);

		JPanel button = new JPanel();
		button.setLayout(new FlowLayout());
		button.add(btnthem);
		button.add(btnsua);
		button.add(btnxoa);
		button.add(btnthoat);
		button.add(btnnhap);
		pnMain.add(button);

		JPanel pnTable = new JPanel();
		dm = new DefaultTableModel();
		tbl = new JTable(dm);
		dm.addColumn("Mã");
		dm.addColumn("Tên");
		dm.addColumn("Tuổi");
		dm.addColumn("Lớp");
		
		
		
		
		
		
		

		JPanel pnTable1 = new JPanel();
		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Danh sách");
		pnTable.setBorder(borderTitle);

		
		Connection conn = QuanLiSinhVien.getConnect("localhost", "Danh", "Danh", "Danh");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery
			("SELECT * FROM sinhvien");
			while(result.next())
			{
				arrSV.add(new SinhVien(result.getString("Ma"),result.getString("Ten")
						,result.getString("Tuoi"),result.getString("Lop")));
			}
			} catch (Exception e) {
			e.printStackTrace();
			}
		
		for (SinhVien x : arrSV) {
			String[] row = { x.getMaSV(), x.getTenSV(), x.getTuoiSV(), x.getLopSV() };
			dm.addRow(row);
		}

		tbl = new JTable(dm);
		tbl.setLayout(new BorderLayout());
		sp = new JScrollPane(tbl);
		JScrollPane sc = new JScrollPane(sp, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc.setPreferredSize(new Dimension(450, 180));
		pnTable1.add(sc, BorderLayout.CENTER);
		pnMain.add(pnTable1);

		con.add(pnMain);

	}

	public void addEvent() {

		btnthoat.addActionListener(eventExit);
		btnthem.addActionListener(eventAdd);
		btnsua.addActionListener(eventEdit);
		btnxoa.addActionListener(eventXoa);
		tbl.addMouseListener(eventTable);
		select.addActionListener(eventChooseClass);
	}

	MouseAdapter eventTable = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int row = tbl.getSelectedRow();
			String[] col = new String[3];
			col[0] = (String) tbl.getValueAt(row, 0);
			col[1] = (String) tbl.getValueAt(row, 1);
			col[2] = (String) tbl.getValueAt(row, 2);
			maSV.setText(col[0]);
			tenSV.setText(col[1]);
			tuoiSV.setText(col[2]);
		}
	};

	ActionListener eventChooseClass = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String chonLop = (String) select.getSelectedItem();
			dm.setRowCount(0);
			if (chonLop == "ALL") {
				SinhVien[] temp = new SinhVien[arrSV.size()];
				for (int i = 0; i < arrSV.size() - 1; i++) {
					for (int j = i + 1; j < arrSV.size(); j++) {
						if (arrSV.get(i).getTenSV().compareTo(arrSV.get(j).getTenSV()) > 0) {
							temp[i] = arrSV.get(j);
							arrSV.set(j, arrSV.get(i));
							arrSV.set(i, temp[i]);
						}
					}
				}
				for (SinhVien x : arrSV) {
					String[] row = { x.getMaSV(), x.getTenSV(), x.getTuoiSV(), x.getLopSV() };
					dm.addRow(row);
				}
			} else {
				for (SinhVien x : arrSV) {
					if (chonLop.equals(x.getLopSV())) {
						String[] row = { x.getMaSV(), x.getTenSV(), x.getTuoiSV(), x.getLopSV() };
						dm.addRow(row);
					}
				}
			}
			maSV.setText("");
			tenSV.setText("");
			tuoiSV.setText("");
		}

	};

	ActionListener eventExit = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);

		}

	};

	ActionListener eventAdd = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String chonLop = (String) select.getSelectedItem();
			String ma = chonLop + maSV.getText();
			String ten = tenSV.getText();
			String tuoi = tuoiSV.getText();

			maSV.setText("");
			tenSV.setText("");
			tuoiSV.setText("");
			Connection conn = QuanLiSinhVien.getConnect("localhost", "Danh", "Danh", "Danh");
			try
			{
			String sql="INSERT INTO sinhvien(Ma,Ten,Tuoi,Lop) VALUES ("
			+ "'" + ma + "','"+ten+"','"
			+tuoi+ "','"+chonLop+"'"+")";
			Statement statement =conn.createStatement();
			int x=statement.executeUpdate(sql);
			if(x>0)
			{
			JOptionPane.showMessageDialog(null, "Đã lưu thông tin sinh viên");
			}
			}
			catch(Exception ex){
			ex.printStackTrace();
			}
			arrSV.add(new SinhVien(ma, ten, tuoi, chonLop));
			dm.addRow(new String[] { ma, ten, tuoi, chonLop });
		}
	};

	ActionListener eventXoa = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			for (SinhVien x : arrSV) {
				if (maSV.getText().equals(x.getMaSV())) {
					arrSV.remove(x);
					break;
				}
			}
			Connection conn = QuanLiSinhVien.getConnect("localhost", "Danh", "Danh", "Danh");
			try
			{
			String sql = "DELETE FROM sinhvien WHERE Ma = '" + maSV.getText()+"'";
			Statement statement = conn.createStatement();
			int x = statement.executeUpdate(sql);
			if(x>=0)
			{
			JOptionPane.showMessageDialog(null, "Đã xóa thông tin sinh viên");
			}
			}
			catch(Exception ex){
			ex.printStackTrace();
			}
			dm.setRowCount(0);
			for (SinhVien x : arrSV) {
				String[] row = { x.getMaSV(), x.getTenSV(), x.getTuoiSV(), x.getLopSV() };
				dm.addRow(row);
			}
		}

	};

	ActionListener eventEdit = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			for (SinhVien x : arrSV) {
				if (maSV.getText().equals(x.getMaSV())) {
					x.setTenSV(tenSV.getText());
					x.setTuoiSV(tuoiSV.getText());
					break;
				}
			}
			Connection conn = QuanLiSinhVien.getConnect("localhost", "Danh", "Danh", "Danh");
			try
			{
			String sql = "UPDATE sinhvien SET Ten ='"+tenSV.getText()+"',Tuoi ='"+ tuoiSV.getText()+"' WHERE Ma = '" + maSV.getText()+"'";
			Statement statement =conn.createStatement();
			int x = statement.executeUpdate(sql);
			if(x>=0)
			{
			JOptionPane.showMessageDialog(null, "Đã sửa thông tin sinh viên");
			}
			}
			catch(Exception ex){
			ex.printStackTrace();
			}
			dm.setRowCount(0);
			for (SinhVien x : arrSV) {
				String[] row = { x.getMaSV(), x.getTenSV(), x.getTuoiSV(), x.getLopSV() };
				dm.addRow(row);
			}

		}

	};

	


	public void showWindow() {
		this.setSize(500, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}


}