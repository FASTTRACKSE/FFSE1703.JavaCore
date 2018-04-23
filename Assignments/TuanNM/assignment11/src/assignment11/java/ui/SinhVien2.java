package assignment11.java.ui;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Desktop.Action;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.StatementEvent;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Statement;

import assignment11.java.connect.Connect;
import assignment11.java.connect.ConnectDb;
import assignment11.java.model.SinhVien;

public class SinhVien2 extends JFrame {
	

	private JTextField nameSV, maSV, ageSV;
	private JButton creat, edit, delete, exit, refresh;
	private JComboBox classSV;
	public static ArrayList<SinhVien> arrSv = new ArrayList<SinhVien>();
	DefaultTableModel modle;
	JTable table;
	int stt = 0;
	String lop = "All";
	ConnectDb connectDB = new ConnectDb();
	

	public SinhVien2(String tieude) {
		super(tieude);
		addControls();
		addEvents();
		

	}

	public void addControls() {
		Container con = getContentPane();
		JPanel pnBox = new JPanel();
		pnBox.setLayout(new BoxLayout(pnBox, BoxLayout.Y_AXIS));
		// Jpanel box 1
		JPanel pnBox1 = new JPanel();
		JLabel name1 = new JLabel("Chương trình Quản lí sinh viên");
		Font font1 = new Font("Arial", Font.BOLD | Font.ITALIC, 25);
		name1.setFont(font1);
		pnBox1.add(name1);

		// Jpanel box 2
		JPanel pnBox2 = new JPanel();
		classSV = new JComboBox();
		classSV.addItem("All");
		classSV.addItem("FFSE1701");
		classSV.addItem("FFSE1702");
		classSV.addItem("FFSE1703");
		classSV.addItem("FFSE1704");
		pnBox2.add(classSV);
		// jpanel box 3
		JPanel pnBox3 = new JPanel();
		JLabel name2 = new JLabel("Mã Sinh Viên: ");
		maSV = new JTextField(20);
		pnBox3.add(name2);
		pnBox3.add(maSV);
		// jpanel box 4
		JPanel pnBox4 = new JPanel();
		JLabel name3 = new JLabel("Tên Sinh Viên: ");
		name3.setPreferredSize(name2.getPreferredSize());
		nameSV = new JTextField(20);
		pnBox4.add(name3);
		pnBox4.add(nameSV);
		// jpanel box 5
		JPanel pnBox5 = new JPanel();
		JLabel name4 = new JLabel("Tuổi: ");
		name4.setPreferredSize(name2.getPreferredSize());
		ageSV = new JTextField(20);
		pnBox5.add(name4);
		pnBox5.add(ageSV);
		// jpanel box 6
		JPanel pnBox6 = new JPanel();
		creat = new JButton("Creat");
		edit = new JButton("Edit");
		delete = new JButton("Delete");
		exit = new JButton("Exit");
		refresh = new JButton("refresh");
		pnBox6.add(creat);
		pnBox6.add(edit);
		pnBox6.add(delete);
		pnBox6.add(exit);
		pnBox6.add(refresh);
		// jpanel box 7 tạo table
		JPanel pnBox7 = new JPanel();
		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Danh sách");
		pnBox7.setBorder(borderTitle);
		modle = new DefaultTableModel();
		table = new JTable(modle);
		
		pnBox7.setLayout(new BorderLayout());

		modle.addColumn("Mã số");
		modle.addColumn("Tên Sinh Viên");
		modle.addColumn("Tuổi");
		modle.addColumn("Lớp");

		JScrollPane scroll = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pnBox7.add(scroll, BorderLayout.CENTER);

		// thêm jPanel
		pnBox.add(pnBox1);
		pnBox.add(pnBox2);
		pnBox.add(pnBox3);
		pnBox.add(pnBox4);
		pnBox.add(pnBox5);
		pnBox.add(pnBox6);
		pnBox.add(pnBox7);
		con.add(pnBox);

	}

	public void addEvents() {
		classSV.addActionListener(chonLop);
		creat.addActionListener(themSinhVien);
		edit.addActionListener(chinhSuaSinhVien);
		table.addMouseListener(chonHang);
		delete.addActionListener(xoaSinhVien);
		exit.addActionListener(eventExit);
		refresh.addActionListener(lamMoi);
	}

	ActionListener lamMoi = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			maSV.setText("");
			nameSV.setText("");
			ageSV.setText("");
			maSV.setEditable(true);
			classSV.showPopup();
			
			
			
		}
	};

	ActionListener chonLop = new ActionListener() {
		public void actionPerformed(ActionEvent ev) {
			
			arrSv.clear();
			arrSv= connectDB.selectSinhVien();
			
			lop = classSV.getSelectedItem().toString();
			modle.setRowCount(0);

			if (lop == "All") {
				for (SinhVien sv : arrSv) {

					String[] row = { sv.getMaSV(), sv.getNameSV(), sv.getAge(), sv.getLopSV() };
					modle.addRow(row);
				}
			} else {
				for (SinhVien sv : arrSv) {
					if (lop.equals(sv.getLopSV())) {
						String[] row = { sv.getMaSV(), sv.getNameSV(), sv.getAge(), sv.getLopSV() };
						modle.addRow(row);
					}
				}
			}
			maSV.setText("");
			nameSV.setText("");
			ageSV.setText("");

		}
	};

	ActionListener themSinhVien = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			try {
				int ktTonTai = 0;
				String lop = classSV.getSelectedItem().toString();
				String tenSV = nameSV.getText();
				String maSinhVien = maSV.getText();
				String tuoi = ageSV.getText();
				for (int i = 0; i < arrSv.size(); i++) {
					if (maSinhVien.equals(arrSv.get(i).getMaSV())) {
						ktTonTai = 1;
					}
				}
				try {
					if (tenSV.isEmpty() || maSinhVien.isEmpty() || tuoi.isEmpty()) {
						throw new Exception();
						
					} else if (ktTonTai > 0) {
						String msg = "Sinh viên " + arrSv.get(ktTonTai).getMaSV() + " đã tồn tạ !!";
						JOptionPane.showMessageDialog(null, msg, "Lỗi nhập", JOptionPane.INFORMATION_MESSAGE);
					} else if (lop == "All") {
						// throw new NullPointerException();
						String msg = "Vui lòng chọn lớp!!";
						JOptionPane.showMessageDialog(null, msg, "Lỗi nhập", JOptionPane.INFORMATION_MESSAGE);
					} else {
						connectDB.insertSinhVien(maSinhVien, tenSV, tuoi, lop);
						arrSv.add(new SinhVien(maSinhVien, tenSV, tuoi, lop));

						for (int i = (arrSv.size() - 1); i < arrSv.size(); i++) {

							String[] row = { arrSv.get(i).getMaSV(), arrSv.get(i).getNameSV(), arrSv.get(i).getAge(),
									arrSv.get(i).getLopSV() };
							modle.addRow(row);
						}
					
						maSV.setText("");
						nameSV.setText("");
						ageSV.setText("");
					}

				} catch (Exception ex) {
					String msg = "Vui lòng nhập đầy đủ thông tin";
					JOptionPane.showMessageDialog(null, msg, "Lỗi Nhập Thiếu", JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (Exception ex) {
			}

		}

	};

	ActionListener chinhSuaSinhVien = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String maSv = maSV.getText();
			String tenSv = nameSV.getText();
			String tuoiSv = ageSV.getText();
			String lop = classSV.getSelectedItem().toString();

			try {
				Integer.parseInt(tuoiSv);
				try {

					if (maSv.isEmpty() && tenSv.isEmpty() && tuoiSv.isEmpty()) {
						throw new Exception();
					} else if (maSv.isEmpty() || tenSv.isEmpty() || tuoiSv.isEmpty()) {
						String msg = "Không được để trống các dòng " + maSv;
						JOptionPane.showMessageDialog(null, msg, "Lỗi Nhập Thông tin", JOptionPane.INFORMATION_MESSAGE);

					} else {
						
						
						arrSv.get(stt).setMaSV(maSv);
						arrSv.get(stt).setNameSv(tenSv);
						arrSv.get(stt).setAge(tuoiSv);
						connectDB.updateSinhVien(maSv, tenSv, tuoiSv);

						maSV.setText("");
						nameSV.setText("");
						ageSV.setText("");
						maSV.requestFocus();
						lop = classSV.getSelectedItem().toString();

						modle.setRowCount(0);
						if (lop == "All") {
							for (SinhVien sv : arrSv) {
								String[] row = { sv.getMaSV(), sv.getNameSV(), sv.getAge(), sv.getLopSV() };
								modle.addRow(row);
							}
						} else {
							for (SinhVien sv : arrSv) {
								if (lop.equals(sv.getLopSV())) {
									String[] row = { sv.getMaSV(), sv.getNameSV(), sv.getAge(), sv.getLopSV() };
									modle.addRow(row);
								}
							}
					}
					}
				} catch (Exception e2) {
					String msg = "Chưa chọn dòng cần thay đổi ";
					JOptionPane.showMessageDialog(null, msg, "Sửa Thành Công", JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (Exception e2) {
			}
		}
	};

	ActionListener eventExit = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	};
	MouseAdapter chonHang = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int col = table.getSelectedRow();
			String[] row = new String[3];
			row[0] =  table.getValueAt(col, 0).toString();
			row[1] = table.getValueAt(col, 1).toString();
			row[2] = table.getValueAt(col, 2).toString();
			maSV.setEditable(false);
			maSV.setText(row[0]);
			nameSV.setText(row[1]);
			ageSV.setText(row[2]);
			for (int i = 0; i < arrSv.size(); i++) {
				if (row[0].equals(arrSv.get(i).getMaSV())) {
					stt = i;
				}
			}
		}
	};
	ActionListener xoaSinhVien = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				String maSv = maSV.getText();
				String tenSv = nameSV.getText();
				String tuoiSv = ageSV.getText();
				arrSv.remove(stt);
				connectDB.deleteSinhVien(maSv);
				
				maSV.requestFocus();
				lop = classSV.getSelectedItem().toString();
				modle.setRowCount(0);
				maSV.setText("");
				nameSV.setText("");
				ageSV.setText("");
				if (lop == "All") {
					for (SinhVien sv : arrSv) {
						String[] row = { sv.getMaSV(), sv.getNameSV(), sv.getAge(), sv.getLopSV() };
						modle.addRow(row);
					}
				} else {
					for (SinhVien sv : arrSv) {
						if (lop.equals(sv.getLopSV())) {
							String[] row = { sv.getMaSV(), sv.getNameSV(), sv.getAge(), sv.getLopSV() };
							modle.addRow(row);
						}
					}
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Không còn sinh viên nào");
			}

		}
	};

	public void showWindow() {
		this.setSize(600, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
