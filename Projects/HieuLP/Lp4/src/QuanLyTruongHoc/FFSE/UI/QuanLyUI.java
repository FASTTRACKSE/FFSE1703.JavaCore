package QuanLyTruongHoc.FFSE.UI;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import QuanLyTruongHoc.FFSE.Model.*;

public class QuanLyUI extends JFrame {
	
	private DefaultTableModel dm,dm1;
	private JTable table,table1;
	private JScrollPane sc,sc1;
	private JScrollPane sp,sp1;
	private JTextField maLop = new JTextField(), namHoc = new JTextField(), moTa = new JTextField();// môn học
	private JTextField maSV = new JTextField(), hoTen = new JTextField(), DiaChi = new JTextField(),
					   Emaill = new JTextField(), DT = new JTextField();
	private JButton ThongTinSV;
	private JButton qlLophoc;
	private JPanel pnSouthTong,pnSouthTong1,center,sinhvien,pnSouthcon1,pnSouthcon11,pnSouthcon2,pnSouthcon22;
	private ArrayList<QuanLyModelLopHoc> arrMH = new ArrayList<QuanLyModelLopHoc>();
	private JComboBox select;
	private JComboBox tp = new JComboBox();
	private JComboBox quan = new JComboBox();
	private JComboBox phuong = new JComboBox();
	// private static final Component pnTitle = null;
	private Button Them = new Button("Thêm");
	private Button Sua = new Button("Sửa");
	private Button Xoa = new Button("Xóa");
//	private String[] lop = { "Tất Cả", "FFSE1701", "FFSE1702", "FFSE1703", "FFSE1704" };

	public QuanLyUI(String tieude) {
		super(tieude);
		addControls();
		addEvent();
	}

	public void addControls() {
		Container con = getContentPane();
		JPanel cardlayout = new JPanel(new CardLayout());

		// TieuDe
		JPanel pnTitle = new JPanel();
		pnTitle.add(new JLabel(new ImageIcon("image/3.png")));
		pnTitle.setBackground(new Color(255, 255, 255));
		pnTitle.setMaximumSize(new Dimension(1700, 70));
		JPanel pnBorder = new JPanel();
		pnBorder.setLayout(new BorderLayout());
		JPanel pnNorth = new JPanel();
		pnNorth.add(pnTitle);
		pnBorder.add(pnNorth, BorderLayout.NORTH);
		pnNorth.setLayout(new BoxLayout(pnNorth, BoxLayout.Y_AXIS));
		

		// Icon Button
		JPanel pnWest = new JPanel();
		pnWest.setLayout(new BoxLayout(pnWest, BoxLayout.Y_AXIS));

		JPanel pnQuanLyLopHoc = new JPanel();
		ImageIcon iconView = new ImageIcon("image/qlLophoc.png");
		Image getIconView = iconView.getImage();
		Image newIconView = getIconView.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newIconView);
		qlLophoc = new JButton("QUẢN LÝ LỚP HỌC     ", newIcon);
		pnQuanLyLopHoc.add(qlLophoc);

		JPanel pnThongTinSV = new JPanel();
		ImageIcon iconView1 = new ImageIcon("image/thongtinsv.jpg");
		Image getIconView1 = iconView1.getImage();
		Image newIconView1 = getIconView1.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon1 = new ImageIcon(newIconView1);
		ThongTinSV = new JButton("THÔNG TIN SINH VIÊN ", newIcon1);
		pnThongTinSV.add(ThongTinSV);

		JPanel pnQuanlymonhoc = new JPanel();
		ImageIcon iconView2 = new ImageIcon("image/monhoc.jpg");
		Image getIconView2 = iconView2.getImage();
		Image newIconView2 = getIconView2.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon2 = new ImageIcon(newIconView2);
		JButton quanlymonhoc = new JButton("QUẢN LÝ MÔN HỌC     ", newIcon2);
		pnQuanlymonhoc.add(quanlymonhoc);

		JPanel pnNhapdiem = new JPanel();
		ImageIcon iconView3 = new ImageIcon("image/nhapdiem.jpg");
		Image getIconView3 = iconView3.getImage();
		Image newIconView3 = getIconView3.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon3 = new ImageIcon(newIconView3);
		JButton nhapdiem = new JButton("NHẬP ĐIỂM SINH VIÊN", newIcon3);
		pnNhapdiem.add(nhapdiem);

		JPanel pnThongke = new JPanel();
		ImageIcon iconView4 = new ImageIcon("image/thongke.jpg");
		Image getIconView4 = iconView4.getImage();
		Image newIconView4 = getIconView4.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon4 = new ImageIcon(newIconView4);
		JButton thongke = new JButton("THỐNG KÊ                       ", newIcon4);
		pnThongke.add(thongke);

		pnWest.add(pnQuanLyLopHoc, BorderLayout.SOUTH);
		pnWest.add(pnThongTinSV, BorderLayout.SOUTH);
		pnWest.add(pnQuanlymonhoc, BorderLayout.SOUTH);
		pnWest.add(pnNhapdiem, BorderLayout.SOUTH);
		pnWest.add(pnThongke, BorderLayout.SOUTH);
		pnBorder.add(pnWest, BorderLayout.WEST);

		// Table lớp học
		center = new JPanel();
		center.setLayout(new BorderLayout());
		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Danh sách");
		center.setBorder(borderTitle);
		pnBorder.add(center);

		dm = new DefaultTableModel();

		dm.addColumn("Mã lớp");
		dm.addColumn("Mô tả");
		dm.addColumn("Năm học");

		Connection conn = Connect.getConnect("localhost", "admin", "admin1", "12345");
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM table_lop");
			while (result.next()) {
				arrMH.add(new QuanLyModelLopHoc(result.getString("MaLop"), result.getString("MoTa"),
						result.getString("NamHoc")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (QuanLyModelLopHoc x : arrMH) {
			String[] row = { x.getMaLop(), x.getMoTa(), x.getNamHoc() };
			dm.addRow(row);
		}

		table = new JTable(dm);
		table.setLayout(new BorderLayout());
		sp = new JScrollPane(table);
		sc = new JScrollPane(sp, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc.setPreferredSize(new Dimension(470, 180));
		center.add(sc);
		pnBorder.add(center);

		// NhapThongtin
		pnSouthTong = new JPanel();
		Border nhapthongtin = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle3 = BorderFactory.createTitledBorder(nhapthongtin, "NHẬP THÔNG TIN");
		pnSouthTong.setBorder(borderTitle3);
		pnSouthTong.setLayout(new FlowLayout());

		//
		pnSouthcon1 = new JPanel();
		Border border2 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle2 = BorderFactory.createTitledBorder(border2);
		pnSouthcon1.setBorder(borderTitle2);
		pnSouthcon1.setLayout(new FlowLayout());

		JPanel pnLeft = new JPanel();
		pnLeft.setLayout(new BoxLayout(pnLeft, BoxLayout.Y_AXIS));

		JPanel nhapmaLop = new JPanel();
		nhapmaLop.setLayout(new FlowLayout());
		JLabel lblNhapmaLop = new JLabel("Mã lớp:");
		maLop = new JTextField(20);
		nhapmaLop.add(lblNhapmaLop);
		nhapmaLop.add(maLop);
		pnLeft.add(nhapmaLop);;

		JPanel nhapNamhoc = new JPanel();
		nhapNamhoc.setLayout(new FlowLayout());
		JLabel lblNhapNamhoc = new JLabel("Năm học:");
		namHoc = new JTextField(20);
		nhapNamhoc.add(lblNhapNamhoc);
		nhapNamhoc.add(namHoc);
		pnLeft.add(nhapNamhoc);

		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));

		JPanel nhapMota = new JPanel();
		nhapMota.setLayout(new FlowLayout());
		JLabel lblNhapMota = new JLabel("Mô tả      :");
		moTa = new JTextField(20);
		nhapMota.add(lblNhapMota);
		nhapMota.add(moTa);
		pnCenter.add(nhapMota);
	
		

		pnSouthcon2 = new JPanel();
		Border border4 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle4 = BorderFactory.createTitledBorder(border4);
		pnSouthcon2.setBorder(borderTitle4);
		pnSouthcon2.setLayout(new FlowLayout());
		JPanel chucnang = new JPanel();
		chucnang.setLayout(new BoxLayout(chucnang, BoxLayout.X_AXIS));
		
		pnSouthcon2.setPreferredSize(new Dimension(200,100));
		pnSouthcon2.add(Them);
		pnSouthcon2.add(Sua);
		pnSouthcon2.add(Xoa);

		pnSouthcon1.add(pnLeft);
		pnSouthcon1.add(pnCenter);
		pnSouthcon2.add(chucnang);
		pnSouthTong.add(pnSouthcon1);
		pnSouthTong.add(pnSouthcon2);
		center.add(pnSouthTong, BorderLayout.SOUTH);

		
		//Sinh viên
		sinhvien = new JPanel();
		sinhvien.setLayout(new BorderLayout());
		Border borderSV = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitleSV = BorderFactory.createTitledBorder(borderSV, "Danh sách");
		sinhvien.setBorder(borderTitleSV);
		pnBorder.add(sinhvien);

		dm1 = new DefaultTableModel();

		dm1.addColumn("Mã SV");
		dm1.addColumn("Họ và tên");
		dm1.addColumn("Mã lớp");
		dm1.addColumn("Địa chỉ");
		dm1.addColumn("Phường");
		dm1.addColumn("Quận");
		dm1.addColumn("Thành phố");
		dm1.addColumn("Email");
		dm1.addColumn("Điện thoại");

		

		table1 = new JTable(dm1);
		table1.setLayout(new BorderLayout());
		sp1 = new JScrollPane(table1);
		sc1 = new JScrollPane(sp1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc1.setPreferredSize(new Dimension(470, 180));
		sinhvien.add(sc1);
		pnBorder.add(sinhvien);

		// NhapThongtin
		pnSouthTong1 = new JPanel();
		Border nhapthongtinSV = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle3SV = BorderFactory.createTitledBorder(nhapthongtinSV, "NHẬP THÔNG TIN SV");
		pnSouthTong1.setBorder(borderTitle3SV);
		pnSouthTong1.setLayout(new FlowLayout());

		//
		pnSouthcon11 = new JPanel();
		Border border2SV = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle2SV = BorderFactory.createTitledBorder(border2SV);
		pnSouthcon11.setBorder(borderTitle2SV);
		pnSouthcon11.setLayout(new FlowLayout());

		JPanel pnLeft1 = new JPanel();
		pnLeft1.setLayout(new BoxLayout(pnLeft1, BoxLayout.Y_AXIS));

		JPanel nhapMaSV = new JPanel();
		JLabel lblNhapMaSV = new JLabel("Mã SV:");
		maSV = new JTextField(20);
		nhapMaSV.add(lblNhapMaSV);
		nhapMaSV.add(maSV);
		pnLeft1.add(nhapMaSV);

		JPanel nhapHoten = new JPanel();
		nhapHoten.setLayout(new FlowLayout());
		JLabel lblHoTenSV = new JLabel("Họ và tên:");
		hoTen = new JTextField(20);
		nhapHoten.add(lblHoTenSV);
		nhapHoten.add(hoTen);
		pnLeft1.add(nhapHoten);
		
		JPanel nhapEmail = new JPanel();
		nhapEmail.setLayout(new FlowLayout());
		JLabel lblnhapEmail = new JLabel("Emaill:");
		Emaill = new JTextField(20);
		nhapEmail.add(lblnhapEmail);
		nhapEmail.add(Emaill);
		pnLeft1.add(nhapEmail);
		
		JPanel nhapSDT = new JPanel();
		nhapSDT.setLayout(new FlowLayout());
		JLabel lblnhapSDT = new JLabel("Số điện thoại:");
		DT = new JTextField(20);
		nhapSDT.add(lblnhapSDT);
		nhapSDT.add(DT);
		pnLeft1.add(nhapSDT);

		JPanel pnCenter1 = new JPanel();
		pnCenter1.setLayout(new BoxLayout(pnCenter1, BoxLayout.Y_AXIS));

		JPanel nhapDiaChiSV = new JPanel();
		nhapDiaChiSV.setLayout(new FlowLayout());
		JLabel lblNhapDiachiSV = new JLabel("Mã lớp     :");
		DiaChi = new JTextField(20);
		nhapDiaChiSV.add(lblNhapDiachiSV);
		nhapDiaChiSV.add(DiaChi);
		pnCenter1.add(nhapDiaChiSV);
	
		JPanel chontinh = new JPanel();
		chontinh.setLayout(new FlowLayout());
		JLabel txttinh = new JLabel("Thành phố:  ");
		chontinh.add(txttinh);
		chontinh.add(tp);
		pnCenter1.add(chontinh);

		JPanel chonhuyen = new JPanel();
		chonhuyen.setLayout(new FlowLayout());
		JLabel txthuyen = new JLabel("Quận/Huyện:");
		chonhuyen.add(txthuyen);
		chonhuyen.add(quan);
		pnCenter1.add(chonhuyen);

		JPanel chonquan = new JPanel();
		chonquan.setLayout(new FlowLayout());
		JLabel txtquan = new JLabel("Phường/Xã: ");
		chonquan.add(txtquan);
		chonquan.add(phuong);
		pnCenter1.add(chonquan);

		pnSouthcon11.add(pnLeft1);
		pnSouthcon11.add(pnCenter1);
		pnSouthTong1.add(pnSouthcon11);
		sinhvien.add(pnSouthTong1, BorderLayout.SOUTH);
		
		
		
		pnBorder.add(sinhvien);
		pnBorder.add(center);
		cardlayout.add(center);
		cardlayout.add(sinhvien);
		con.add(pnBorder);
		pnBorder.add(cardlayout);
		getContentPane().add(pnBorder);
		setVisible(true);

	}

	public void addEvent() {
		table.addMouseListener(eventTable);
		Them.addActionListener(eventAdd);
		Xoa.addActionListener(eventDel);
		Sua.addActionListener(eventEdit);
		
		qlLophoc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				sinhvien.setVisible(false);
				center.setVisible(true);
				//pnSouthTong.setVisible(true);
				
			}
		});
		
		ThongTinSV.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				center.setVisible(false);
				//pnSouthTong.setVisible(false);
				sinhvien.setVisible(true);
				
			}
		});

	}

	MouseAdapter eventTable = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int row = table.getSelectedRow();
			String[] col = new String[3];
			col[0] = (String) table.getValueAt(row, 0);
			col[1] = (String) table.getValueAt(row, 1);
			col[2] = (String) table.getValueAt(row, 2);
			maLop.setText(col[0]);
			moTa.setText(col[1]);
			namHoc.setText(col[2]);
		}
	};

	ActionListener eventAdd = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			String lop =   maLop.getText();
			String mota = moTa.getText();
			String nam = namHoc.getText();

			try {
					arrMH.add(new QuanLyModelLopHoc(lop, mota, nam ));
					dm.addRow(new String[] { lop, mota, nam });
					Connection conn = Connect.getConnect("localhost", "admin", "admin1", "12345");
					try {
						String sql = "INSERT INTO table_lop(maLop,moTa,namHoc) VALUES (" + "'" + lop + "','"
								+ mota + "','" + nam + "')";
						Statement statement = conn.createStatement();
						int x = statement.executeUpdate(sql);
						if (x > 0) {
							JOptionPane.showMessageDialog(null, "Đã lưu thông tin sinh viên");
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			 catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Bạn cần nhập thông tin sinh viên");
			}

			maLop.setText("");
			moTa.setText("");
			namHoc.setText("");

		}
	};
	
	ActionListener eventDel = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			for (QuanLyModelLopHoc x : arrMH) {
				if (maLop.getText().equals(x.getMaLop())) {
					arrMH.remove(x);
					break;
				}
			}
			Connection conn = Connect.getConnect("localhost", "admin", "admin1", "12345");
			try
			{
			String sql = "DELETE FROM table_lop WHERE maLop = '" + maLop.getText()+"'";
			Statement statement = conn.createStatement();
			int x = statement.executeUpdate(sql);
			if(x>=0)
			{
			JOptionPane.showMessageDialog(null, "Đã sửa thông tin môn học");
			}
			}
			catch(Exception ex){
			ex.printStackTrace();
			}
			dm.setRowCount(0);
			for (QuanLyModelLopHoc x : arrMH) {
				String[] row = { x.getMaLop(), x.getMoTa(), x.getNamHoc()};
				dm.addRow(row);
			}
		}

	};
	
	ActionListener eventEdit = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			for (QuanLyModelLopHoc x : arrMH) {
				if (maLop.getText().equals(x.getMaLop())) {
					x.setMoTa(moTa.getText());
					x.setNamHoc(namHoc.getText());
					break;
				}
			}
			Connection conn = Connect.getConnect("localhost", "admin", "admin1", "12345");
			try
			{
			String sql = "UPDATE table_lop SET NamHoc ='"+namHoc.getText()+"',MoTa ='"+ moTa.getText()+"' WHERE MaLop = '" + maLop.getText()+"'";
			Statement statement =conn.createStatement();
			int x = statement.executeUpdate(sql);
			if(x>=0)
			{
			JOptionPane.showMessageDialog(null, "Đã sửa thông tin môn học");
			}
			}
			catch(Exception ex){
			ex.printStackTrace();
			}
			dm.setRowCount(0);
			for (QuanLyModelLopHoc x : arrMH) {
				String[] row = { x.getMaLop(), x.getMoTa(), x.getNamHoc() };
				dm.addRow(row);
			}

		}

	};

	
	public void showWindow() {
		this.setSize(1000, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}