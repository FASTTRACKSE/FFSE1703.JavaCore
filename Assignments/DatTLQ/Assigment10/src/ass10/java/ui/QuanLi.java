package ass10.java.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import ass10.java.model.SinhVien;

import ass10.java.io.*;

public class QuanLi extends JFrame {
	private JTextField txtName, txtDate, txtMaSV;
	private JComboBox cbo;
	private JButton btnadd, btnrep, btndel, btnexit, btnok;
	private static ArrayList<SinhVien> arrSinhVien = new ArrayList<>();
	private DefaultTableModel dm;
	private JTable tbl;
	int stt = 0;

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
		cbo = new JComboBox();
		cbo.addItem("All");
		cbo.addItem("FFSE1701");
		cbo.addItem("FFSE1702");
		cbo.addItem("FFSE1703");
		cbo.addItem("FFSE1704");
		JLabel jblTen2 = new JLabel("Chọn lớp:");

		Box2.add(jblTen2);
		Box2.add(cbo);

		JLabel jblTen3 = new JLabel("Mã Sinh Viên:");
		txtMaSV = new JTextField(20);
		Box3.add(jblTen3);
		Box3.add(txtMaSV);

		JLabel jblTen4 = new JLabel("Tên Sinh Viên:");
		txtName = new JTextField(20);

		Box4.add(jblTen4);
		Box4.add(txtName);

		JLabel jblTen5 = new JLabel("Tuổi:");
		jblTen5.setPreferredSize(jblTen4.getPreferredSize());
		txtDate = new JTextField(20);
		Box5.add(jblTen5);
		Box5.add(txtDate);

		btnadd = new JButton("Thêm");
		btnrep = new JButton("Sửa");

		btndel = new JButton("Xóa");
		btnexit = new JButton("Thoát");
		btnok = new JButton("Nhập");
		Box6.add(btnadd);
		Box6.add(btnrep);
		Box6.add(btndel);
		Box6.add(btnexit);
		Box6.add(btnok);
		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Danh sách");
		Box7.setBorder(borderTitle);
		dm = new DefaultTableModel();
		dm.addColumn("Mã");
		dm.addColumn("Tên");
		dm.addColumn("Tuổi");
		dm.addColumn("Lớp");
		tbl = new JTable(dm);

		JScrollPane sc = new JScrollPane(tbl);

		Box7.setLayout(new BorderLayout());
		Box7.add(sc, BorderLayout.CENTER);

		//
		pnBox.add(Box1);
		pnBox.add(Box2);
		pnBox.add(Box3);
		pnBox.add(Box4);
		pnBox.add(Box5);
		pnBox.add(Box6);
		pnBox.add(Box7);
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
		cbo.addActionListener(chonLop);
		btnok.addActionListener(ok);
		btnadd.addActionListener(them);
		tbl.addMouseListener(chonHang);
		btnrep.addActionListener(sua);
		btndel.addActionListener(xoa);
		btnexit.addActionListener(thoat);

	}

	ActionListener ok = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String stuma = txtMaSV.getText();
			String stuname = txtName.getText();
			String studate = txtDate.getText();
			String lop = cbo.getSelectedItem().toString();
			int kt = 0;
			for (SinhVien x : arrSinhVien) {
				if (stuma.equals(x.gettxtMaSV())) {
					kt = 1;
				}
			}
			try {
				if (stuma.isEmpty() || stuname.isEmpty() || studate.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ!!");
				} else if (kt > 0) {
					JOptionPane.showMessageDialog(null, "Sinh viên đã tồn tại!!");

				} else if (lop == "All") {
					JOptionPane.showMessageDialog(null, "Bạn phải chọn lớp!!");
				} else {
					arrSinhVien.add(new SinhVien(stuma, stuname, studate, lop));
					boolean kt1 = SerializeFileFactory.luuFile(arrSinhVien, "dulieu2.txt");
					if (kt1 == true) {
						System.out.println("Đã lưu file thành công");
					} else {
						System.out.println("Lưu file thất bại");
					}
					for (int i = (arrSinhVien.size() - 1); i < arrSinhVien.size(); i++) {
						String[] row = { arrSinhVien.get(i).gettxtMaSV(), arrSinhVien.get(i).gettxtName(),
								arrSinhVien.get(i).gettxtDate(), arrSinhVien.get(i).gettxtLop() };
						dm.addRow(row);
					}

				}
			} catch (Exception ex) {

			}
		}

	};
	ActionListener them = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			cbo.showPopup();
			txtMaSV.setEditable(true);
			txtMaSV.setText("");
			txtDate.setText("");
			txtName.setText("");
		}
	};
	MouseAdapter chonHang = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int col = tbl.getSelectedRow();
			String[] row = new String[3];
			row[0] = tbl.getValueAt(col, 0).toString();
			row[1] = tbl.getValueAt(col, 1).toString();
			row[2] = tbl.getValueAt(col, 2).toString();
			txtMaSV.setEditable(false);
			txtMaSV.setText(row[0]);
			txtName.setText(row[1]);
			txtDate.setText(row[2]);
			for (int i = 0; i < arrSinhVien.size(); i++) {
				if (row[0].equals(arrSinhVien.get(i).gettxtMaSV())) {
					stt = i;
				}
			}

		}
	};
	ActionListener sua = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String stuma = txtMaSV.getText();
			String stuname = txtName.getText();
			String studate = txtDate.getText();
			String lop = cbo.getSelectedItem().toString();
			try {
				if (stuma.isEmpty() && stuname.isEmpty() && studate.isEmpty()) {
					throw new Exception();
				} else if (stuma.isEmpty() || stuname.isEmpty() || studate.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Bạn phải nhập vào");
				} else {
					arrSinhVien.get(stt).settxtMaSV(stuma);
					arrSinhVien.get(stt).settxtName(stuname);
					arrSinhVien.get(stt).settxtDate(studate);
					boolean kt1 = SerializeFileFactory.luuFile(arrSinhVien, "dulieu2.txt");
					if (kt1 == true) {
						System.out.println("Đã lưu file thành công");
						JOptionPane.showMessageDialog(null, "Bạn đã sửa thành công");
					} else {
						System.out.println("Lưu file thất bại");
					}
					dm.setRowCount(0);
					if (lop == "All") {
						for (SinhVien x : arrSinhVien) {
							String[] row = { x.gettxtMaSV(), x.gettxtName(), x.gettxtDate(), x.gettxtLop() };
							dm.addRow(row);

						}
					} else {
						for (SinhVien x : arrSinhVien) {
							if (lop.equals(x.gettxtLop())) {
								String[] row = { x.gettxtMaSV(), x.gettxtName(), x.gettxtDate(), x.gettxtLop() };
								dm.addRow(row);
							}
						}
					}

				}
			} catch (Exception ex) {

			}
		}
	};
	ActionListener chonLop = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			File file = new File("D:/FFSE1703.JavaCore/Assignments/DatTLQ/Assigment10/dulieu2.txt");
			if (file.exists()) {
				ArrayList<SinhVien> sv = SerializeFileFactory.docFile("dulieu2.txt");
				arrSinhVien = sv;
			}
			txtMaSV.setText("");
			txtDate.setText("");
			txtName.setText("");
			String lop = cbo.getSelectedItem().toString();
			dm.setRowCount(0);
			if (lop == "All") {
				for (SinhVien x : arrSinhVien) {
					String[] row = { x.gettxtMaSV(), x.gettxtName(), x.gettxtDate(), x.gettxtLop() };
					dm.addRow(row);

				}
			} else {
				for (SinhVien x : arrSinhVien) {
					if (lop.equals(x.gettxtLop())) {
						String[] row = { x.gettxtMaSV(), x.gettxtName(), x.gettxtDate(), x.gettxtLop() };
						dm.addRow(row);
					}
				}
			}
		}

	};
	
	ActionListener xoa= new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int row=tbl.getSelectedRow();
			String stuma = (String) dm.getValueAt(row, 0);
			for(SinhVien x:arrSinhVien) {
				if(stuma.equals(x.gettxtMaSV())) {
					arrSinhVien.remove(x);
					break;
				}
			}
			boolean kt1 = SerializeFileFactory.luuFile(arrSinhVien, "dulieu2.txt");
			if (kt1 == true) {
				System.out.println("Đã lưu file thành công");
				JOptionPane.showMessageDialog(null, "Bạn đã xóa thành công");
			} else {
				System.out.println("Lưu file thất bại");
			}
			dm.removeRow(row);
		}
	};
	ActionListener thoat=new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int mess=JOptionPane.showConfirmDialog(null, "Bạn muốn thoát?", "Thoát", JOptionPane.YES_NO_OPTION);
			if(mess==JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
	};
}
