package FFSE1703004.ui;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
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

import FFSE1703004.model.DBConnection;


public class BienLai extends JPanel {
	JTextField txtSearch1, txtMeterID, txtDateAdded, txtMeterIndex;
	JButton btnSearch1, btnAdd, btnEdit, btnDel;
	JTable jt = new JTable(new DefaultTableModel(
			new Object[] { "Mã biên lai", "Mã Công tơ", "Ngày nhập", "Chu kì nhập", "Chỉ số công tơ", "Số tiền" }, 0));


	public BienLai() {
		// TODO Auto-generated constructor stub
		addControls();
	}

	public void addControls() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		Border border=
				BorderFactory.createLineBorder(Color.RED);
				TitledBorder borderTitle=
				BorderFactory.createTitledBorder(
				border);
				this.setBorder(borderTitle);
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		JPanel pnTitle = new JPanel();
		JLabel lblTitle = new JLabel("Quản lí biên lai");
		Font fontTitle = new Font("arial", Font.BOLD, 20);
		lblTitle.setFont(fontTitle);
		pnTitle.add(lblTitle);

		JPanel pn1 = new JPanel();
		JLabel lblSearch1 = new JLabel("Mã công tơ");
		txtSearch1 = new JTextField(15);
		btnSearch1 = new JButton("Tìm kiếm");
		pn1.add(lblSearch1);
		pn1.add(txtSearch1);
		pn1.add(btnSearch1);

		JPanel pn3 = new JPanel();
		btnAdd = new JButton("Thêm");
		btnEdit = new JButton("Sửa");
		btnDel = new JButton("Xóa");
		pn3.add(btnAdd);
		pn3.add(btnEdit);
		pn3.add(btnDel);

		JScrollPane pn4 = new JScrollPane(jt);

		JPanel pn5 = new JPanel();
		JLabel lblMeterID = new JLabel("Mã công tơ");
		lblMeterID.setPreferredSize(new Dimension(90, 15));
		txtMeterID = new JTextField(15);
		txtMeterID.setPreferredSize(new Dimension(90, 20));
		// txtMeterID.setEditable(false);
		pn5.add(lblMeterID);
		pn5.add(txtMeterID);

		JPanel pn6 = new JPanel();
		JLabel lblDateAdded = new JLabel("Ngày nhập");
		lblDateAdded.setPreferredSize(new Dimension(90, 15));
		txtDateAdded = new JTextField(15);
		txtDateAdded.setEditable(false);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();

		txtDateAdded.setText(dateFormat.format(date));
		pn6.add(lblDateAdded);
		pn6.add(txtDateAdded);

		JPanel pn7 = new JPanel();
		JLabel lblMonth = new JLabel("Chu kì nhập");
		lblMonth.setPreferredSize(new Dimension(100, 15));
		pn7.add(lblMonth);
		

		JPanel pn9 = new JPanel();
		JLabel lblMeterIndex = new JLabel("Chỉ số công tơ");
		lblMeterIndex.setPreferredSize(new Dimension(90, 15));
		txtMeterIndex = new JTextField(15);
		pn9.add(lblMeterIndex);
		pn9.add(txtMeterIndex);

		pnMain.add(pnTitle);
		pnMain.add(pn1);
		pnMain.add(pn4);
		pnMain.add(pn3);
		pnMain.add(pn5);
		pnMain.add(pn6);
		pnMain.add(pn7);
		pnMain.add(pn9);

		this.add(pnMain);
	}

}
