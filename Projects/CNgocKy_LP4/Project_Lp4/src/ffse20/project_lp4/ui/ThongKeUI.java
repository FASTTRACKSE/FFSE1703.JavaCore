package ffse20.project_lp4.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
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
	private DefaultTableModel dmTK;
	private JScrollPane scDiem;
	private JTable tblDiem;
	
	public ThongKeUI() {
		addControls();
	}
	public void addControls() {

	this.setLayout(new FlowLayout());
	Border border6 = BorderFactory.createLineBorder(Color.RED);
	TitledBorder borderTitle6 = BorderFactory.createTitledBorder(border6, "NHẬP THÔNG TIN");
	this.setBorder(borderTitle6);
	
	JLabel lblNamHocSV = new JLabel("Năm Học-Sinh Viên :");
	JPanel namhocSV = new JPanel();
	namhocSV.add(lblNamHocSV);
	namhocSV.add(cboNamHocSV);
	this.add(namhocSV);
	
	JLabel lblLopSV = new JLabel("Mã Lớp-Sinh Viên :");
	JPanel lopSV = new JPanel();
	lopSV.add(lblLopSV);
	lopSV.add(cboLopSV);
	this.add(lopSV);
	
	

	JLabel lblNamHocLp = new JLabel("Năm Học-Lớp :");
	JPanel namhocLp = new JPanel();
	namhocLp.add(lblNamHocLp);
	namhocLp.add(cboNamHocLop);
	this.add(namhocLp);
	
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
	VT5.setPreferredSize(new Dimension(1300, 410));
	pnTable5.add(VT5, BorderLayout.CENTER);

	Border border7 = BorderFactory.createLineBorder(Color.RED);
	TitledBorder borderTitle7 = BorderFactory.createTitledBorder(border7, "Danh sách");
	pnTable5.setBorder(borderTitle7);
	this.add(pnTable5);
}
}
