package ffse20.project_lp4.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;


public class ThongKeUI extends JPanel{
	private static final long serialVersionUID = 1L;

	
	private JComboBox<String> cboNamHocSV = new JComboBox<>();
	private JComboBox<String> cboLopSV = new JComboBox<>();
	private JComboBox<String> cboNamHocLop = new JComboBox<>();
	private DefaultTableModel dmTK,dmTK1;
	private JScrollPane scDiem,scDiem1;
	private JTable tblDiem,tblDiem1;
	
	public ThongKeUI() {
		addControls();
	}
	public void addControls() {

	this.setLayout(new FlowLayout());
	Border border6 = BorderFactory.createLineBorder(Color.RED);
	TitledBorder borderTitle6 = BorderFactory.createTitledBorder(border6, "NHẬP THÔNG TIN");
	this.setBorder(borderTitle6);
	
	
	this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	JPanel Panel1 = new JPanel();
	JLabel lblNamHocSV = new JLabel("Năm Học-Sinh Viên :");
	JPanel namhocSV = new JPanel();
	namhocSV.add(lblNamHocSV);
	namhocSV.add(cboNamHocSV);
	Panel1.add(namhocSV);
	
	JLabel lblLopSV = new JLabel("Mã Lớp-Sinh Viên :");
	JPanel lopSV = new JPanel();
	lopSV.add(lblLopSV);
	lopSV.add(cboLopSV);
	Panel1.add(lopSV);
	

	
	JPanel pnTable5 = new JPanel();

	dmTK = new DefaultTableModel();

	dmTK.addColumn("Mã Lớp");
	dmTK.addColumn("Mã Môn Học");
	dmTK.addColumn("Sinh Viên");
	dmTK.addColumn("Điểm");
	
//	 Connection con3 = Connect.getConnect("localhost", "quanlysinhvien", "quanlysinhvien", "12345");
//	 try {
//	 Statement statement = con3.createStatement();
//	 ResultSet result = statement.executeQuery("SELECT * FROM table_diem");
//	 while (result.next()) {
//	 arrDiem.add(new QuanLyDiemModel(result.getString("maLop"),result.getString("ma_monHoc"),result.getString("tenSV"),result.getString("diem")));
//
//	 }
//	 } catch (Exception e) {
//	 e.printStackTrace();
//	 }
//	
//	 for (QuanLyDiemModel x : arrDiem) {
//	 String[] row = { x.getMaLop(), x.getMaMonHoc(), x.getSinhVien(), x.getDiem()};
//	 dmDiem.addRow(row);
//	 }

	tblDiem = new JTable(dmTK);
	scDiem = new JScrollPane(tblDiem);
	JScrollPane VT5 = new JScrollPane(scDiem, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	VT5.setPreferredSize(new Dimension(1300, 170));
	pnTable5.add(VT5, BorderLayout.CENTER);

	Border border7 = BorderFactory.createLineBorder(Color.RED);
	TitledBorder borderTitle7 = BorderFactory.createTitledBorder(border7, "Danh sách");
	pnTable5.setBorder(borderTitle7);
	Panel1.add(pnTable5);
	this.add(Panel1);
	
	JPanel Panel2 = new JPanel();
	JLabel lblNamHocLp = new JLabel("Năm Học-Lớp :");
	JPanel namhocLp = new JPanel();
	namhocLp.add(lblNamHocLp);
	namhocLp.add(cboNamHocLop);
	Panel2.add(namhocLp);
	
	JPanel pnTable6 = new JPanel();

	dmTK1 = new DefaultTableModel();

	dmTK1.addColumn("Mã Lớp");
	dmTK1.addColumn("Mã Môn Học");
	dmTK1.addColumn("Sinh Viên");
	dmTK1.addColumn("Điểm");
	
//	 Connection con3 = Connect.getConnect("localhost", "quanlysinhvien", "quanlysinhvien", "12345");
//	 try {
//	 Statement statement = con3.createStatement();
//	 ResultSet result = statement.executeQuery("SELECT * FROM table_diem");
//	 while (result.next()) {
//	 arrDiem.add(new QuanLyDiemModel(result.getString("maLop"),result.getString("ma_monHoc"),result.getString("tenSV"),result.getString("diem")));
//
//	 }
//	 } catch (Exception e) {
//	 e.printStackTrace();
//	 }
//	
//	 for (QuanLyDiemModel x : arrDiem) {
//	 String[] row = { x.getMaLop(), x.getMaMonHoc(), x.getSinhVien(), x.getDiem()};
//	 dmDiem.addRow(row);
//	 }

	tblDiem1 = new JTable(dmTK1);
	scDiem1 = new JScrollPane(tblDiem1);
	JScrollPane VT6 = new JScrollPane(scDiem1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	VT6.setPreferredSize(new Dimension(1300, 170));
	pnTable6.add(VT6, BorderLayout.CENTER);

	Border border8 = BorderFactory.createLineBorder(Color.RED);
	TitledBorder borderTitle8 = BorderFactory.createTitledBorder(border8, "Danh sách");
	pnTable6.setBorder(borderTitle8);
	Panel2.add(pnTable6);
	this.add(Panel2);
}
}
