package fasttrackse.edu.vn.project4.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class MyQuanLyDiemUI extends JFrame {
	private JTextField maMH = new JTextField(15);
	private JTextField diem = new JTextField(15);
	private JTextField maSV = new JTextField(15);
	private JTextField tenMH = new JTextField(15);

	DefaultTableModel dm;
	JTable tbl;
	private JButton btnThem = new JButton("Thêm");
	private JButton btnSua = new JButton("Sửa");
	private JButton btnXoa = new JButton("Xoá");
	private Button btn1 = new Button("QUẢN LÝ SINH VIÊN");
	private Button btn2 = new Button("QUẢN LÝ ĐIỂM");
	private Button btn3 = new Button("QUẢN LÝ LỚP HỌC");
	private Button btn4 = new Button("QUẢN LÝ MÔN HỌC");
	private Button btn5 = new Button("THỐNG KÊ BÁO CÁO");

	public MyQuanLyDiemUI(String tieude) {
		this.setTitle(tieude);
		addControls();

		addEvent();
	}

	public void addControls() {
		Container con = getContentPane();

		JPanel pnBorder = new JPanel();
		pnBorder.setLayout(new BorderLayout());
		JLabel lbl = new JLabel("Chương Trình Quản Lý Điểm");
		Font font = new Font("Arial", Font.BOLD, 24);
		lbl.setFont(font);

		JPanel pnNorth = new JPanel();
		pnNorth.setBackground(Color.blue);
		pnNorth.add(lbl);
		pnBorder.add(pnNorth, BorderLayout.NORTH);

		JPanel pnSouth = new JPanel();
		pnSouth.setBackground(Color.blue);
		pnBorder.add(pnSouth, BorderLayout.SOUTH);

		JPanel pnWest = new JPanel();
		pnWest.setLayout(new BoxLayout(pnWest, BoxLayout.Y_AXIS));
		pnWest.add(btn1);
		pnWest.add(btn2);
		pnWest.add(btn3);
		pnWest.add(btn4);
		pnWest.add(btn5);
		pnBorder.add(pnWest, BorderLayout.WEST);

		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));

		JPanel pnbutton = new JPanel();
		pnbutton.setLayout(new FlowLayout());
		pnbutton.add(btnThem);
		pnbutton.add(btnSua);
		pnbutton.add(btnXoa);
		pnCenter.add(pnbutton);

		JPanel pnCombo = new JPanel();
		pnCombo.setLayout(new FlowLayout());

		JPanel pnnhap = new JPanel();
		pnnhap.setLayout(new FlowLayout());
		JPanel pnLeft = new JPanel();
		pnLeft.setLayout(new BoxLayout(pnLeft, BoxLayout.Y_AXIS));
		JLabel lbl1 = new JLabel("Nhập Mã Môn Học :");
		pnLeft.add(lbl1);
		pnLeft.add(maMH);

		JLabel lbl5 = new JLabel("Nhập Mã Sinh Viên :");
		pnLeft.add(lbl5);
		pnLeft.add(maSV);
		pnnhap.add(pnLeft);

		JPanel pnGiua = new JPanel();
		pnGiua.setLayout(new BoxLayout(pnGiua, BoxLayout.Y_AXIS));
		JLabel lbl6 = new JLabel("Nhập Tuổi Sinh Viên :");
		pnGiua.add(lbl6);
		pnGiua.add(tenMH);

		JLabel lbl4 = new JLabel("Nhập Địa Chỉ :");
		pnGiua.add(lbl4);
		pnGiua.add(diem);
		pnnhap.add(pnGiua);

		pnCenter.add(pnnhap);

		pnCenter.setBackground(Color.white);
		pnBorder.add(pnCenter, BorderLayout.CENTER);
		getContentPane().add(pnBorder);

		JPanel pnTable = new JPanel();
		dm = new DefaultTableModel();
		tbl = new JTable(dm);
		dm.addColumn("Mã Môn Học");
		dm.addColumn("Mã Sinh Viên");
		dm.addColumn("Điểm");
		dm.addColumn("Tên Môn Học");

		JScrollPane sc = new JScrollPane(tbl);
		JScrollPane VT = new JScrollPane(sc, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		VT.setPreferredSize(new Dimension(1170, 520));
		pnTable.add(VT, BorderLayout.CENTER);
		pnCenter.add(pnTable);

		Border border = BorderFactory.createLineBorder(Color.blue);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Danh sách sinh viên");
		pnTable.setBorder(borderTitle);

		con.add(pnBorder);

	}

	public void addEvent() {

	}

	public void showWindow() {
		this.setSize(1350, 700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
