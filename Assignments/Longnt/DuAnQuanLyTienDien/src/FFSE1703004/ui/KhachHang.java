package FFSE1703004.ui;
import java.awt.HeadlessException;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import FFSE1703004.model.DBConnection;

import java.awt.event.MouseListener;
import java.awt.BorderLayout;
import java.awt.Button;
import java.sql.Statement;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class KhachHang extends JPanel {
	Connection conn= DBConnection.ketnoi("localhost", "ffse1703", "thanhlong123",
			"123456"); 
	private JTextField txtMaKH,txtTenKH,txtDiaChi,txtSDT,txtEmail,txtMCT,txtTimKiem;
	private JButton butTimKiem,butThem,butSua,butXoa;
	JTable ta = new JTable(new DefaultTableModel(new Object[] { "Mã khách hàng", "Họ tên", "Địa chỉ", "Quận", "Phường",
			"Điện thoại", "Email", "Mã công tơ" }, 0));
	JComboBox cb1, cb2, cb3, cb4;
		public static ArrayList<KhachHang> array = new ArrayList<KhachHang>();
		private DefaultTableModel dm = new DefaultTableModel();
		final JTable tab = new JTable(dm);
		JScrollPane sc = new JScrollPane(tab);
		int stt = 0;
		
		public KhachHang() throws HeadlessException, SQLException {
			
			addControls();
			addEvents();
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
			JLabel lblTitle = new JLabel("Quản lí khách hàng");
			Font fontTitle = new Font("arial", Font.BOLD, 20);
			lblTitle.setFont(fontTitle);
			pnTitle.add(lblTitle);

			JPanel pn1 = new JPanel();
			JLabel lb1 = new JLabel("Tên khách hàng");
			txtTimKiem = new JTextField(15);
			pn1.add(lb1);
			pn1.add(txtTimKiem);

			JPanel pn2 = new JPanel();
			JLabel lbquan = new JLabel("Quận");
			String Quan[] = {};
			cb1 = new JComboBox(Quan);
			cb1.setPreferredSize(new Dimension(115, 20));
			JLabel lbphuong = new JLabel("Phường");
			String Phuong[] = {};
			cb2 = new JComboBox(Phuong);
			cb2.setPreferredSize(new Dimension(115, 20));
			butTimKiem = new JButton("Tìm kiếm");
			pn2.add(lbquan);
			pn2.add(cb1);
			pn2.add(lbphuong);
			pn2.add(cb2);
			pn2.add(butTimKiem);

			JPanel pn3 = new JPanel();
			butThem = new JButton("Thêm");
			butSua = new JButton("Sửa");
			butXoa = new JButton("Xóa");
			pn3.add(butThem);
			pn3.add(butSua);
			pn3.add(butXoa);

			JScrollPane pn4 = new JScrollPane(ta);

			JPanel pn5 = new JPanel();
			pn5.setLayout(new BoxLayout(pn5, BoxLayout.Y_AXIS));
			JPanel pnName = new JPanel();
			JLabel lblName = new JLabel("Họ tên");
			lblName.setPreferredSize(new Dimension(90, 15));
			txtTenKH = new JTextField(15);
			pnName.add(lblName);
			pnName.add(txtTenKH);

			JPanel pnAddress = new JPanel();
			JLabel lblAddress = new JLabel("Địa chỉ");
			lblAddress.setPreferredSize(new Dimension(90, 15));
			txtDiaChi = new JTextField(15);
			pnAddress.add(lblAddress);
			pnAddress.add(txtDiaChi);

			JPanel pnCounty = new JPanel();
			JLabel lblCounty2 = new JLabel("Quận");
			lblCounty2.setPreferredSize(new Dimension(90, 15));
			cb3 = new JComboBox(Quan);
			cb3.setPreferredSize(new Dimension(170, 20));
			pnCounty.add(lblCounty2);
			pnCounty.add(cb3);

			JPanel pnWard = new JPanel();
			JLabel lblWard2 = new JLabel("Phường");
			lblWard2.setPreferredSize(new Dimension(90, 15));
			cb4 = new JComboBox(Phuong);
			cb4.setPreferredSize(new Dimension(170, 20));
			pnWard.add(lblWard2);
			pnWard.add(cb4);

			JPanel pnPhone = new JPanel();
			JLabel lblPhone = new JLabel("Điện thoại");
			lblPhone.setPreferredSize(new Dimension(90, 15));
			txtSDT = new JTextField(15);
			pnPhone.add(lblPhone);
			pnPhone.add(txtSDT);

			JPanel pnEmail = new JPanel();
			JLabel lblEmail = new JLabel("Email");
			lblEmail.setPreferredSize(new Dimension(90, 15));
			txtEmail = new JTextField(15);
			pnEmail.add(lblEmail);
			pnEmail.add(txtEmail);

			JPanel pnMeterID = new JPanel();
			JLabel lblMeterID = new JLabel("Mã công tơ");
			lblMeterID.setPreferredSize(new Dimension(90, 15));
			txtMCT = new JTextField(15);
			pnMeterID.add(lblMeterID);
			pnMeterID.add(txtMCT);

			pn5.add(pnName);
			pn5.add(pnAddress);
			pn5.add(pnCounty);
			pn5.add(pnWard);
			pn5.add(pnPhone);
			pn5.add(pnEmail);
			pn5.add(pnMeterID);

			pnMain.add(pnTitle);
			pnMain.add(pn1);
			pnMain.add(pn2);
			pnMain.add(pn4);
			pnMain.add(pn3);
			pnMain.add(pn5);

			
			this.add(pnMain);
						
		}
		private void addEvents() {
			
			
		}
}
	
