package project.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class LayoutTinhHinhRutTien extends JPanel {
	JTextField txtMaK, txtMaMay;
	JComboBox cbo,cbo1,cbo2, cboDenThang,cboDenNam;
	JButton btnSua, btnXoa;
	DefaultTableModel dm=new DefaultTableModel();
	final JTable tbl=new JTable(dm);
	JScrollPane sc=new JScrollPane(tbl);
	public LayoutTinhHinhRutTien() {
		addControll();
			addEvent();
		}

	private void addEvent() {
		// TODO Auto-generated method stub
		
	}

	private void addControll() {
		// TODO Auto-generated method stub
		JPanel pnThRutTien =new JPanel();
		pnThRutTien.setPreferredSize(new Dimension(1000, 700));
		pnThRutTien.setLayout(new BoxLayout(pnThRutTien, BoxLayout.Y_AXIS));
		
		JPanel pnChinh =new JPanel();
		Border border5=BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle5=BorderFactory.createTitledBorder(border5, "Thông Tin");
		pnChinh.setBorder(borderTitle5);
		pnChinh.setLayout(new BoxLayout(pnChinh, BoxLayout.X_AXIS));
		
		JPanel pnMaC = new JPanel();
		pnMaC.setLayout(new BoxLayout(pnMaC, BoxLayout.Y_AXIS));
		JPanel pnMaK =new JPanel();
		JLabel lblMaK= new JLabel("Mã Khách:");
		lblMaK.setPreferredSize(new Dimension(90, 20));
		 txtMaK = new JTextField(15);
		pnMaK.add(lblMaK);
		pnMaK.add(txtMaK);
		pnMaC.add(pnMaK);
		
		JPanel pnMaMay =new JPanel();
		JLabel lblMaMay= new JLabel("Mã Máy:");
		lblMaMay.setPreferredSize(new Dimension(90, 20));
		 txtMaMay = new JTextField(15);
		pnMaMay.add(lblMaMay);
		pnMaMay.add(txtMaMay);
		pnMaC.add(pnMaMay);
		
		JPanel pnThoiGian =new JPanel();
		pnThoiGian.setLayout(new BoxLayout(pnThoiGian, BoxLayout.Y_AXIS));
		
		JPanel pnTG = new JPanel();
		pnTG.setLayout(new BoxLayout(pnTG, BoxLayout.X_AXIS));
		
		JPanel pnTuNgay =new JPanel();
		JLabel lblTuNgay= new JLabel("Từ ngày:");
		 cbo=new JComboBox();
		cbo.addItem("Xuất sắc");
		cbo.addItem("Giỏi");
		cbo.addItem("Khá");
		cbo.addItem("Trung bình");
		pnTuNgay.add(lblTuNgay);
		pnTuNgay.add(cbo);
		pnTG.add(pnTuNgay);
		
		JPanel pnThang =new JPanel();
		JLabel lblThang= new JLabel("Tháng:");
		 cbo2=new JComboBox();
		cbo2.addItem("Xuất sắc");
		cbo2.addItem("Giỏi");
		cbo2.addItem("Khá");
		cbo2.addItem("Trung bình");

		pnThang.add(lblThang);
		pnThang.add(cbo2);
		pnTG.add(pnThang);
		
		JPanel pnNam =new JPanel();
		JLabel lblNam= new JLabel("Năm:");
		JComboBox cbo3=new JComboBox();
		cbo3.addItem("Xuất sắc");
		cbo3.addItem("Giỏi");
		cbo3.addItem("Khá");
		cbo3.addItem("Trung bình");

		pnNam.add(lblNam);
		pnNam.add(cbo3);
		pnTG.add(pnNam);
		pnThoiGian.add(pnTG);
		
		JPanel pnDenTg=new JPanel();
		pnDenTg.setLayout(new BoxLayout(pnDenTg, BoxLayout.X_AXIS));
		
		JPanel pnDenNgay =new JPanel();
		JLabel lblDenNgay= new JLabel("Đến Ngày:");
		 cbo1=new JComboBox();
		cbo1.addItem("Xuất sắc");
		cbo1.addItem("Giỏi");
		cbo1.addItem("Khá");
		cbo1.addItem("Trung bình");
		add(cbo1);
		pnDenNgay.add(lblDenNgay);
		pnDenNgay.add(cbo1);
		pnDenTg.add(pnDenNgay);
		
		
		JPanel pnDenThang =new JPanel();
		JLabel lblDenThang= new JLabel("Đến Ngày:");
		 cboDenThang=new JComboBox();
		cboDenThang.addItem("Xuất sắc");
		cboDenThang.addItem("Giỏi");
		cboDenThang.addItem("Khá");
		cboDenThang.addItem("Trung bình");
		add(cboDenThang);
		pnDenThang.add(lblDenThang);
		pnDenThang.add(cboDenThang);
		pnDenTg.add(pnDenThang);
		pnThoiGian.add(pnDenTg);
		
		JPanel pnDenNam =new JPanel();
		JLabel lblDenNam= new JLabel("Đến Ngày:");
		 cboDenNam=new JComboBox();
		cboDenNam.addItem("Xuất sắc");
		cboDenNam.addItem("Giỏi");
		cboDenNam.addItem("Khá");
		cboDenNam.addItem("Trung bình");
		pnDenNam.add(lblDenNam);
		pnDenNam.add(cboDenNam);
		pnDenTg.add(pnDenNam);
		
		JPanel pnFlow=new JPanel();
		pnFlow.setLayout(new FlowLayout());
		pnFlow.setBackground(Color.PINK);
		 btnSua=new JButton("Xem");
		 btnXoa=new JButton("Sửa");
		pnFlow.add(btnSua);
		pnFlow.add(btnXoa);
		
		
		JPanel pnBang6 = new JPanel();
		Border border3=BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder borderTitle3=BorderFactory.createTitledBorder(border3, "Hiển Thị Thông Tin Khách Hàng");
		pnBang6.setBorder(borderTitle3);
		dm.addColumn("Mã");
		dm.addColumn("Tên");
		dm.addColumn("Mã Máy");
		dm.addColumn("Địa Chỉ");
		dm.addColumn("Tổng Tiền");
		pnBang6.setLayout(new BorderLayout());
		pnBang6.add(sc,BorderLayout.CENTER);

		pnChinh.add(pnMaC);
		pnChinh.add(pnThoiGian);
		pnThRutTien.add(pnChinh);
		pnThRutTien.add(pnFlow);
		pnThRutTien.add(pnBang6);
		
		this.add(pnThRutTien);
	}
}
