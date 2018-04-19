package fasttrack.edu.vn.ui;
import fasttrack.edu.vn.model.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class QuanlisinhvienUI extends JFrame {

	private JTextField txtMaSV = new JTextField(15);
	private JTextField txtTenSV = new JTextField(15);
	private JTextField txtTuoiSV = new JTextField(15);
	private JButton btnThem = new JButton("Thêm");
	private JButton btnSua = new JButton("Sửa");
	private JButton btnXoa = new JButton("Xóa");
	private JButton btnThoat = new JButton("Thoát");
	private JButton btnNhap = new JButton("Nhập");
	JScrollPane sp;
	DefaultTableModel dm;
	JTable table;
	JComboBox select;
	String[] arr = { "FFSE1701", "FFSE1702", "FFSE1703", "FFSE1704" };

	public QuanlisinhvienUI(String title) {
		super(title);
		addControls();
		addEvents();
	}

	public void addControls() {
		Container con = getContentPane();
		JPanel main = new JPanel();

		main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

		JLabel lbl = new JLabel("Chương Trình Quản Lí Sinh Viên");
		lbl.setForeground(Color.BLUE);
		Font font = new Font("Arial", Font.BOLD, 20);
		lbl.setFont(font);
		JPanel pnMainTitle = new JPanel();
		pnMainTitle.add(lbl);
		main.add(pnMainTitle);

		JPanel chonlop = new JPanel();
		JLabel txtlop = new JLabel("Chọn lớp: ");
		select = new JComboBox(arr);
		chonlop.add(txtlop);
		chonlop.add(select);
		main.add(chonlop);

		JPanel pnMainContent1 = new JPanel();
		pnMainContent1.setLayout(new FlowLayout());
		JLabel lblContent1 = new JLabel(" Mã Sinh viên:  ");
		pnMainContent1.add(lblContent1);
		pnMainContent1.add(txtMaSV);
		main.add(pnMainContent1);

		JPanel pnMainContent2 = new JPanel();
		pnMainContent2.setLayout(new FlowLayout());
		JLabel lblContent2 = new JLabel("Tên Sinh Viên: ");
		pnMainContent2.add(lblContent2);
		pnMainContent2.add(txtTenSV);
		main.add(pnMainContent2);

		JPanel pnMainContent3 = new JPanel();
		pnMainContent3.setLayout(new FlowLayout());
		JLabel lblContent3 = new JLabel("        Tuổi:          ");
		pnMainContent3.add(lblContent3);
		pnMainContent3.add(txtTuoiSV);
		main.add(pnMainContent3);

		JPanel pnMainContent4 = new JPanel();
		pnMainContent4.setLayout(new FlowLayout());
		pnMainContent4.add(btnThem);
		pnMainContent4.add(btnSua);
		pnMainContent4.add(btnXoa);
		pnMainContent4.add(btnThoat);
		pnMainContent4.add(btnNhap);
		main.add(pnMainContent4);

		JPanel center = new JPanel();
		Border border = BorderFactory.createLineBorder(Color.BLUE);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Danh sách");
		dm = new DefaultTableModel();

		dm.addColumn("Mã");
		dm.addColumn("Tên");
		dm.addColumn("Tuổi");

		dm.addRow(new String[] {});
		dm.addRow(new String[] {});
		dm.addRow(new String[] {});

		table = new JTable(dm);
		sp = new JScrollPane(table);
		table.setLayout(new BorderLayout());
		center.setBorder(borderTitle);
		center.add(sp, BorderLayout.CENTER);
		main.add(center);

		con.add(main);

	}

	public void addEvents() {
		table.addMouseListener(eventTable);
		select.addActionListener(eventChooseClass);
		btnThoat.addActionListener(evThoat);
		btnThem.addActionListener(evThem);
		btnXoa.addActionListener(evXoa);
	}
		MouseListener eventTable = new MouseListener() {

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				for (int i = table.getSelectedRow(); i <= table.getSelectedRow(); i++) {
					for (int y = 0; y < table.getColumnCount(); y++) {
						String value = (String) table.getValueAt(i, y);
						if (y == 0) {
							maSV.setText(value);
						}
						if (y == 1) {
							tenSV.setText(value);
						}
						if (y == 2) {
							tuoiSV.setText(value);
						}
						if (y == (table.getColumnCount() - 1)) {
							select.setSelectedItem(value);
						}

					}
				}

			}
		};
		
				
	
	public void showWindow() {
		this.setSize(500, 350);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
