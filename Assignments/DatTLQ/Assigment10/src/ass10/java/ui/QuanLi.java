package ass10.java.ui;

import java.awt.Container;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ass10.java.model.SinhVien;

public class QuanLi extends JFrame {
	private JTextField txtName, txtDate, txtMaSV;
	private JComboBox cbo;
	private JButton btnadd, btnrep, btndel, btnexit;
	private static ArrayList<SinhVien> arrSinhVien = new ArrayList<>();

	public QuanLi() {
		super();
	}

	public QuanLi(String title) {
		super(title);
		addControls();
		addEvent();
	}

	public void addControls() {

		Container con = getContentPane();
		JPanel pnBox = new JPanel();
		JPanel pnFlow = new JPanel();
		pnBox.setLayout(new BoxLayout(pnBox, BoxLayout.Y_AXIS));
		pnFlow.setLayout(new FlowLayout());

		JPanel Box1 = new JPanel();
		JPanel Box2 = new JPanel();
		JPanel Box3 = new JPanel();
		JPanel Box4 = new JPanel();
		JPanel Box5 = new JPanel();
		JPanel Box6 = new JPanel();
		JPanel Box7 = new JPanel();
		JPanel Box8 = new JPanel();

		JLabel jblTen1 = new JLabel("Chương trình quản lí sinh viên");
		Box1.add(jblTen1);
		//
		JComboBox cbo = new JComboBox();
		cbo.addItem("FFSE1701");
		cbo.addItem("FFSE1702");
		cbo.addItem("FFSE1703");
		cbo.addItem("FFSE1704");
		JLabel jblTen2 = new JLabel("Chọn lớp:");

		Box2.add(jblTen2);
		Box2.add(cbo);

		JLabel jblTen3 = new JLabel("Mã Sinh Viên:");
		JTextField txtMaSV = new JTextField(20);
		Box3.add(jblTen3);
		Box3.add(txtMaSV);

		JLabel jblTen4 = new JLabel("Tên Sinh Viên:");
		JTextField txtName = new JTextField(20);

		Box4.add(jblTen4);
		Box4.add(txtName);

		JLabel jblTen5 = new JLabel("Tuổi:");
		jblTen5.setPreferredSize(jblTen4.getPreferredSize());
		JTextField txtDate = new JTextField(20);
		Box5.add(jblTen5);
		Box5.add(txtDate);

		JButton btnadd = new JButton("Thêm");
		JButton btnrep = new JButton("Sửa");

		JButton btndel = new JButton("Xóa");
		JButton btnout = new JButton("Thoát");
		Box6.add(btnadd);
		Box6.add(btnrep);
		Box6.add(btndel);
		Box6.add(btnout);


		//
		pnBox.add(Box1);
		pnBox.add(Box2);
		pnBox.add(Box3);
		pnBox.add(Box4);
		pnBox.add(Box5);
		pnBox.add(Box6);
		//
		con.add(pnBox);

	}

	public void showWindow() {
		this.setSize(600, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void addEvent() {

	}
}
