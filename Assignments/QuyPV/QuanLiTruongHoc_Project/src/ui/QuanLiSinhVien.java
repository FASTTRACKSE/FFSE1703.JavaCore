package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.management.ThreadMXBean;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;

import connector.GetConnect;
import model.Phuong;
import model.Phuong_Statement;
import model.QuanHuyen;
import model.QuanHuyen_Statement;
import model.QuanLiDiem_Statement;
import model.QuanLiLopHoc_Model;
import model.QuanLiLopHoc_Statement;
import model.QuanLiSinhVien_Model;
import model.QuanLiSinhVien_Statement;
import model.TinhThanh;
import model.TinhThanh_Statement;

public class QuanLiSinhVien extends JPanel {
	private ArrayList<TinhThanh> arrTinhThanh = new ArrayList<>();
	private ArrayList<QuanHuyen> arrQuanHuyen = new ArrayList<>();
	private ArrayList<Phuong> arrPhuong = new ArrayList<>();
	private ArrayList<QuanLiLopHoc_Model> arrLop = new ArrayList<>();
	private ArrayList<QuanLiSinhVien_Model> arrSinhVien = new ArrayList<>();
	public JComboBox<Object> cboTinhThanh, cboQuanHuyen, cboPhuong, cboMaLop;
	private JTextField textMaSv, textHoTen, textDiaChi, textDienthoai, textEmail, textTimKiem;
	private JButton btnThem, btnSua, btnXoa, btnTaoMoi, btnTimKiem;
	private String provinceId, districtId, nameTinhThanh, nameQuanHuyen, namePhuong, nameLop;
	private QuanLiSinhVien_Model quanLiSinhVienModel = new QuanLiSinhVien_Model();
	private TinhThanh tinhThanhModel = new TinhThanh();
	private QuanHuyen quanHuyenModel = new QuanHuyen();
	private Phuong phuongModel = new Phuong();
	private TinhThanh_Statement tinhThanhStatement = new TinhThanh_Statement();
	private QuanHuyen_Statement quanHuyenStatement = new QuanHuyen_Statement();
	private Phuong_Statement phuongStatement = new Phuong_Statement();
	private QuanLiLopHoc_Statement quanLiLopStatement = new QuanLiLopHoc_Statement();
	private QuanLiSinhVien_Statement quanLiSinhVienStatement = new QuanLiSinhVien_Statement();
	private QuanLiLopHoc_Model quanLiLopHocModel = new QuanLiLopHoc_Model();
	private QuanLiDiem_Statement quanLiDiemStatement = new QuanLiDiem_Statement();
	private DefaultTableModel dm;

	public QuanLiSinhVien() {
		addControl();
		addEvent();
		inToanBo();
	}

	private void addControl() {
		try {
		JPanel boxQuanLiHocSinh = new JPanel();
		Font font = new Font("Arial", Font.BOLD, 15);
		boxQuanLiHocSinh.setLayout(new BoxLayout(boxQuanLiHocSinh, BoxLayout.Y_AXIS));

		/* PHẦN NHẬP THÔNG TIN SINH VIÊN */
		JPanel boxNhap = new JPanel();
		boxNhap.setLayout(new BoxLayout(boxNhap, BoxLayout.Y_AXIS));
		boxNhap.setPreferredSize(new Dimension(0, 300));
		Border borderNhap = BorderFactory.createEtchedBorder();
		TitledBorder borderTitleNhap = BorderFactory.createTitledBorder(borderNhap, "Nhập thông tin",
				TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
		borderTitleNhap.setTitleFont(borderTitleNhap.getTitleFont().deriveFont(Font.BOLD, 20));
		borderTitleNhap.setTitleColor(Color.BLACK);
		boxNhap.setBorder(borderTitleNhap);
//		Border borderNhap = BorderFactory.createLineBorder(Color.RED);
//		TitledBorder borderTitleNhap = BorderFactory.createTitledBorder(borderNhap, "Nhập thông tin",
//				TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
//		borderTitleNhap.setTitleFont(borderTitleNhap.getTitleFont().deriveFont(Font.ITALIC, 20));
//		borderTitleNhap.setTitleColor(Color.RED);
//		boxNhap.setBorder(borderTitleNhap);
		JPanel hangTieuDe = new JPanel();
		hangTieuDe.setLayout(new FlowLayout());
		JLabel lbNhapThongTinSv = new JLabel("Nhập Thông tin");
		lbNhapThongTinSv.setFont(new Font("Arial", Font.BOLD, 35));
		lbNhapThongTinSv.setForeground(Color.RED);
		hangTieuDe.add(lbNhapThongTinSv);
		JPanel hang1 = new JPanel();
		hang1.setLayout(new FlowLayout());
		JLabel maSv = new JLabel("Mã sinh viên:");
		maSv.setPreferredSize(new Dimension(100, 30));
		maSv.setFont(font);
		textMaSv = new JTextField();
		textMaSv.setPreferredSize(new Dimension(120, 30));
		JLabel hoTen = new JLabel("Họ tên:");
		hoTen.setPreferredSize(new Dimension(100, 30));
		hoTen.setFont(font);
		textHoTen = new JTextField();
		textHoTen.setPreferredSize(new Dimension(120, 30));
		JLabel diaChi = new JLabel("Địa chỉ:");
		diaChi.setPreferredSize(new Dimension(100, 30));
		diaChi.setFont(font);
		textDiaChi = new JTextField();
		textDiaChi.setPreferredSize(new Dimension(120, 30));
		hang1.add(maSv);
		hang1.add(textMaSv);
		hang1.add(Box.createRigidArea(new Dimension(30, 0)));
		hang1.add(hoTen);
		hang1.add(textHoTen);
		hang1.add(Box.createRigidArea(new Dimension(30, 0)));
		hang1.add(diaChi);
		hang1.add(textDiaChi);
		JPanel hang2 = new JPanel();
		hang2.setLayout(new FlowLayout());
		JLabel tinhThanh = new JLabel("Tỉnh thành:");
		tinhThanh.setPreferredSize(new Dimension(100, 30));
		tinhThanh.setFont(font);
		arrTinhThanh = tinhThanhStatement.selectAll();
		cboTinhThanh = new JComboBox();
		cboTinhThanh.setPreferredSize(new Dimension(120, 30));
		cboTinhThanh.addItem(new TinhThanh(null, "Chọn Tỉnh"));
		//cboTinhThanh.setPrototypeDisplayValue("---Chọn---");
		for(TinhThanh x : arrTinhThanh) {
			cboTinhThanh.addItem(x);
		}
		JLabel quanHuyen = new JLabel("Quận huyện:");
		quanHuyen.setPreferredSize(new Dimension(100, 30));
		quanHuyen.setFont(font);
		cboQuanHuyen = new JComboBox();
		cboQuanHuyen.addItem(new QuanHuyen("Chọn Quận", null));
		cboQuanHuyen.setPreferredSize(new Dimension(120, 30));
		// cboQuanHuyen.setPrototypeDisplayValue("---Chọn---");

		JLabel phuong = new JLabel("Phường:");
		phuong.setPreferredSize(new Dimension(100, 30));
		phuong.setFont(font);
		cboPhuong = new JComboBox();
		cboPhuong.addItem(new Phuong("Chọn Phường"));
		cboPhuong.setPreferredSize(new Dimension(120, 30));
		// cboPhuong.setPrototypeDisplayValue("---Chọn---");
		hang2.add(tinhThanh);
		hang2.add(cboTinhThanh);
		hang2.add(Box.createRigidArea(new Dimension(30, 0)));
		hang2.add(quanHuyen);
		hang2.add(cboQuanHuyen);
		hang2.add(Box.createRigidArea(new Dimension(30, 0)));
		hang2.add(phuong);
		hang2.add(cboPhuong);
		JPanel hang3 = new JPanel();
		hang3.setLayout(new FlowLayout());
		JLabel dienThoai = new JLabel("Điện thoại:");
		dienThoai.setPreferredSize(new Dimension(100, 30));
		dienThoai.setFont(font);
		textDienthoai = new JTextField();
		textDienthoai.setPreferredSize(new Dimension(120, 30));
		JLabel email = new JLabel("Email:");
		email.setPreferredSize(new Dimension(100, 30));
		email.setFont(font);
		textEmail = new JTextField();
		textEmail.setPreferredSize(new Dimension(120, 30));
		JLabel maLop = new JLabel("Mã lớp:");
		maLop.setPreferredSize(new Dimension(100, 30));
		maLop.setFont(font);
		
		cboMaLop = new JComboBox<>();
		cboMaLop.setPreferredSize(new Dimension(120, 30));
		// cboMaLop.setPrototypeDisplayValue("---Chọn---");
		addItemMaLop();
		hang3.add(dienThoai);
		hang3.add(textDienthoai);
		hang3.add(Box.createRigidArea(new Dimension(30, 0)));
		hang3.add(email);
		hang3.add(textEmail);
		hang3.add(Box.createRigidArea(new Dimension(30, 0)));
		hang3.add(maLop);
		hang3.add(cboMaLop);
		JPanel hang4 = new JPanel();
		hang4.setLayout(new FlowLayout());
		ImageIcon imgBtnThem = new ImageIcon(getClass().getResource("/images/btn_them.png"));
		btnThem = new JButton("Thêm", imgBtnThem);
		btnThem.setPreferredSize(new Dimension(110, 30));
		ImageIcon imgBtnSua = new ImageIcon(getClass().getResource("/images/btn_sua.png"));
		btnSua = new JButton("Sửa", imgBtnSua);
		btnSua.setEnabled(false);
		btnSua.setPreferredSize(new Dimension(110, 30));
		ImageIcon imgBtnXoa = new ImageIcon(getClass().getResource("/images/btn_xoa.png"));
		btnXoa = new JButton("Xóa", imgBtnXoa);
		btnXoa.setEnabled(false);
		btnXoa.setPreferredSize(new Dimension(110, 30));
		ImageIcon imgBtnTaoMoi = new ImageIcon(getClass().getResource("/images/btn_huy.png"));
		btnTaoMoi = new JButton("Hủy", imgBtnTaoMoi);
		btnTaoMoi.setPreferredSize(new Dimension(110, 30));
		hang4.add(btnThem);
		hang4.add(btnSua);
		hang4.add(btnXoa);
		hang4.add(btnTaoMoi);

		/* PHẦN HIỂN THỊ DANH SÁCH SINH VIÊN */
		JPanel boxHienThi = new JPanel();
		boxHienThi.setLayout(new BoxLayout(boxHienThi, BoxLayout.Y_AXIS));
		// JPanel timKiem = new JPanel();
		// timKiem.setLayout(new FlowLayout(FlowLayout.RIGHT));
		// JLabel namHoc = new JLabel("Năm Học:");
		// namHoc.setFont(font);
		// JComboBox cboNamHoc = new JComboBox<>();
		// cboNamHoc.setPrototypeDisplayValue("---Chọn---");
		// cboNamHoc.addItem("---Chọn---");
		// JLabel lop = new JLabel("Lớp:");
		// lop.setFont(font);
		// JComboBox cboLop = new JComboBox<>();
		// cboLop.setPrototypeDisplayValue("---Chọn---");
		// cboLop.addItem("---Chọn---");
		// timKiem.add(namHoc);
		// timKiem.add(cboNamHoc);
		// timKiem.add(lop);
		// timKiem.add(cboLop);
		JPanel timKiem = new JPanel();
		timKiem.setLayout(new FlowLayout(FlowLayout.RIGHT));
		textTimKiem = new JTextField();
		textTimKiem.setPreferredSize(new Dimension(180, 35));
		textTimKiem.setText("Tên hoặc mã sinh viên");
		textTimKiem.setForeground(new Color(190, 190, 190));
		textTimKiem.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				String timkiem = textTimKiem.getText();
				
				if(timkiem.equals("") || timkiem.equalsIgnoreCase("Tên hoặc mã sinh viên")) {
					//textMatKhau.setEchoChar('*');
					textTimKiem.setText("Tên hoặc mã sinh viên");
					textTimKiem.setForeground(new Color(190, 190, 190));
				}
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				String timkiem = textTimKiem.getText();
				
				if(timkiem.equals("Tên hoặc mã sinh viên")) {
					textTimKiem.setText("");
					textTimKiem.setForeground(new Color(0, 0, 0));
				}
				
			}
		});
		ImageIcon imgBtnTimKiem = new ImageIcon(getClass().getResource("/images/btn_search.png"));
		btnTimKiem = new JButton(imgBtnTimKiem);
		btnTimKiem.setPreferredSize(new Dimension(40, 35));
		timKiem.add(textTimKiem);
		timKiem.add(btnTimKiem);
		JPanel hienThi = new JPanel();
		hienThi.setLayout(new BorderLayout());
		dm = new DefaultTableModel();
		dm.addColumn("Mã SV");
		dm.addColumn("Họ tên");
		dm.addColumn("Địa chỉ");
		dm.addColumn("Phường");
		dm.addColumn("Quận huyện");
		dm.addColumn("Tỉnh thành");
		dm.addColumn("Điện thoại");
		dm.addColumn("Email");
		dm.addColumn("Mã lớp");
		JTable tbSinhVien = new JTable(dm);
	
		tbSinhVien.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent  e) {
				int row = tbSinhVien.getSelectedRow();
				String value = tbSinhVien.getValueAt(row, 0).toString();
				textMaSv.setEditable(false);
				btnSua.setEnabled(true);
				btnXoa.setEnabled(true);
				btnThem.setEnabled(false);
				//System.out.println(value);
				//arrSinhVienWhere = quanLiSinhVienModel.selectWhere(value);
				try {
				for(QuanLiSinhVien_Model x : arrSinhVien) {
					if(value.equals(x.getMaSV())) {
					textMaSv.setText(x.getMaSV());
					textHoTen.setText(x.getHoTen());
					textDiaChi.setText(x.getDiaChi());
					String tinh = x.getTinhThanh();
					String quan = x.getQuanHuyen();
					String phuong = x.getPhuong();
					for(int i = 0; i < arrTinhThanh.size(); i++) {
						if(tinh.equals(arrTinhThanh.get(i).getName())) {
							cboTinhThanh.setSelectedItem(arrTinhThanh.get(i));
						}
					}
					for(int i = 0; i < arrQuanHuyen.size(); i++) {
						if(quan.equals(arrQuanHuyen.get(i).getName())) {
							cboQuanHuyen.setSelectedItem(arrQuanHuyen.get(i));
						}
					}
					for(int i = 0; i < arrPhuong.size(); i++) {
						if(phuong.equals(arrPhuong.get(i).getName())) {
							cboPhuong.setSelectedItem(arrPhuong.get(i));
						}
					}
					textDienthoai.setText(x.getDienThoai());
					textEmail.setText(x.getEmail());
					cboMaLop.setSelectedItem(x.getMaLop());
					}
				}
				} catch(Exception ex) {
					ex.printStackTrace();
				}
				
			}
		});
		JScrollPane sc = new JScrollPane(tbSinhVien);
		hienThi.add(sc);
		Border borderHienThi = BorderFactory.createEtchedBorder();
		TitledBorder borderTitleHienThi = BorderFactory.createTitledBorder(borderHienThi, "Danh sách sinh viên",
				TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
		borderTitleHienThi.setTitleFont(borderTitleHienThi.getTitleFont().deriveFont(Font.BOLD, 20));
		borderTitleHienThi.setTitleColor(Color.BLACK);
		boxHienThi.setBorder(borderTitleHienThi);

		boxNhap.add(hang1);
		boxNhap.add(Box.createRigidArea(new Dimension(0, 5)));
		boxNhap.add(hang2);
		boxNhap.add(Box.createRigidArea(new Dimension(0, 5)));
		boxNhap.add(hang3);
		boxNhap.add(Box.createRigidArea(new Dimension(0, 5)));
		boxNhap.add(hang4);

		// boxHienThi.add(timKiem);
		boxHienThi.add(timKiem);
		boxHienThi.add(hienThi);
		
		boxQuanLiHocSinh.add(Box.createRigidArea(new Dimension(0, 10)));
		boxQuanLiHocSinh.add(boxNhap);
		boxQuanLiHocSinh.add(Box.createRigidArea(new Dimension(0, 5)));
		boxQuanLiHocSinh.add(boxHienThi);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(boxQuanLiHocSinh);
	}catch (Exception e) {
	
	}
	}

	private void addEvent() {
		cboTinhThanh.addActionListener(cboTinhThanhEvents);
		cboQuanHuyen.addActionListener(cboQuanHuyenEvents);
		btnTimKiem.addActionListener(btnTimKiemEvents);
		cboMaLop.addActionListener(cboMaLopEvents);
		btnThem.addActionListener(btnThemEvents);
		btnSua.addActionListener(btnSuaEvents);
		btnXoa.addActionListener(btnXoaEvents);
		btnTaoMoi.addActionListener(btnTaoMoiEvents);
	}

	ActionListener btnThemEvents = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(arrSinhVien.toString());
	
			try {
				String maSv = textMaSv.getText().toUpperCase();
				String hoTen = textHoTen.getText();
				String diaChi = textDiaChi.getText();
				String tinhThanh = cboTinhThanh.getSelectedItem().toString();
				String quanHuyen = cboQuanHuyen.getSelectedItem().toString();
				String phuong = cboPhuong.getSelectedItem().toString();
				String dienThoai = textDienthoai.getText();
				String email = textEmail.getText();
				String maLop = cboMaLop.getSelectedItem().toString();
				
				String kt = "Không trùng";

				if (maLop.equals("Chọn Lớp")) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn Mã lớp");
				} else if (tinhThanh.equals("Chọn Tỉnh")) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn Tỉnh/Thành ");
				} else if (quanHuyen.equals("Chọn Quận")) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn Quận/Huyện ");
				} else if (phuong.equals("Chọn Phường")) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn Phường ");
				} else if (maSv.equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng Nhập mã Sinh viên ");
				} else if (hoTen.equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng Nhập mã Họ tên ");
				} else if (diaChi.equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng Nhập mã Địa chỉ ");
				} else if (dienThoai.equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng Nhập mã Điện thoại ");
				} else if (email.equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng Nhập mã Email ");
				}else if(!(Pattern.matches("^[a-zA-Z0-9]+[@]{1}+[a-zA-Z0-9]+[.]{1}+[a-zA-Z0-9]+$", textEmail.getText()))){
					JOptionPane.showMessageDialog(null, "Email nhập chưa đúng dạng. Vui lòng nhập lại");
				}else if(!(Pattern.matches("^\\+?[0-9. ()-]{10,25}$", textDienthoai.getText()))){
					JOptionPane.showMessageDialog(null, "Số điện thoại phải nhập đúng dạng");
				}
				else {
						for(QuanLiSinhVien_Model x : arrSinhVien) {
							if(maSv.equals(x.getMaSV())) {
								kt = "Trùng";
							}
						}
								
						if(kt == "Trùng") {
							JOptionPane.showMessageDialog(null, "Trùng mã sinh viên vui lòng nhập lại");
						}
						else {
							quanLiSinhVienStatement.insert(maSv, hoTen, diaChi, phuong, quanHuyen, tinhThanh, dienThoai, email,
									maLop);
							selectAllSinhVien();
							String row[] = { maSv, hoTen, diaChi, phuong , quanHuyen, tinhThanh,  dienThoai, email, maLop };
							dm.addRow(row);
							textMaSv.setText("");
							textHoTen.setText("");
							textDiaChi.setText("");
							cboTinhThanh.setSelectedIndex(0);
							cboQuanHuyen.setSelectedIndex(0);
							cboPhuong.setSelectedIndex(0);
							textDienthoai.setText("");
							textEmail.setText("");
							System.out.println(arrSinhVien.toString());
						}
					
				}
			} 
			catch (Exception ex) {
				System.out.println(ex);
			}

		}
	};
	
	
	ActionListener btnSuaEvents = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				textMaSv.setEditable(true);
				String maSv = textMaSv.getText();
				String hoTen = textHoTen.getText();
				String diaChi = textDiaChi.getText();
				String tinhThanh = cboTinhThanh.getSelectedItem().toString();
				String quanHuyen = cboQuanHuyen.getSelectedItem().toString();
				String phuong = cboPhuong.getSelectedItem().toString();
				String dienThoai = textDienthoai.getText();
				String email = textEmail.getText();
				String maLop = cboMaLop.getSelectedItem().toString();
			
				if (maSv.equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn sinh viên cần sửa ");
				} else if (tinhThanh.equals("Chọn Tỉnh")) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn Tỉnh/Thành ");
				} else if (quanHuyen.equals("Chọn Quận")) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn Quận/Huyện ");
				} else if (phuong.equals("Chọn Phường")) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn Phường ");
				} else if (maLop.equals("Chọn Lớp")) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn Mã lớp");
				} else if (hoTen.equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng Nhập mã Họ tên ");
				} else if (diaChi.equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng Nhập mã Địa chỉ ");
				} else if (dienThoai.equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng Nhập mã Điện thoại ");
				} else if (email.equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng Nhập mã Email ");
				}else if(!(Pattern.matches("^[a-zA-Z0-9]+[@]{1}+[a-zA-Z0-9]+[.]{1}+[a-zA-Z0-9]+$", textEmail.getText()))){
					JOptionPane.showMessageDialog(null, "Email nhập chưa đúng dạng. Vui lòng nhập lại");
				}else if(!(Pattern.matches("^\\+?[0-9. ()-]{10,25}$", textDienthoai.getText()))){
					JOptionPane.showMessageDialog(null, "Số điện thoại phải nhập đúng dạng");
				} else {
						quanLiSinhVienStatement.updateSv(maSv, hoTen, diaChi, phuong, quanHuyen, tinhThanh, dienThoai, email, maLop);
						selectAllSinhVien();
						String row[] = { maSv, hoTen, diaChi, phuong , quanHuyen, tinhThanh,  dienThoai, email, maLop };
						dm.addRow(row);
						textMaSv.setText("");
						textHoTen.setText("");
						textDiaChi.setText("");
						cboTinhThanh.setSelectedIndex(0);
						cboQuanHuyen.setSelectedIndex(0);
						cboPhuong.setSelectedIndex(0);
						textDienthoai.setText("");
						textEmail.setText("");
						
						inSinhVienCbo();
				}
			} catch (Exception ex) {
				System.out.println(ex);
			}
			
		}
	};
	
	ActionListener btnXoaEvents = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
			String maSv = textMaSv.getText();
			if(textMaSv.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn sinh viên cần xóa");
			}else {
				int chose = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa không?", "Xóa", JOptionPane.YES_NO_OPTION);
				if(chose == JOptionPane.YES_OPTION) {
				
					quanLiSinhVienStatement.deleteSv(maSv);
					quanLiDiemStatement.deleteDiem(maSv);
					textMaSv.setText("");
					textMaSv.setEditable(true);
					textHoTen.setText("");
					textDiaChi.setText("");
					cboTinhThanh.setSelectedIndex(0);
					textDienthoai.setText("");
					textEmail.setText("");
					//cboMaLop.setSelectedIndex(0);
					for(QuanLiSinhVien_Model x : arrSinhVien) {
						if(maSv.equals(x.getMaSV())) {
							arrSinhVien.remove(x);
							System.out.println(arrSinhVien.toString());
							// xóa xong nhảy ra khỏi vòng lặp
							break;
						}
					}
					// in danh sách sinh viên xuống table
					inSinhVienCbo();
				}
				
			}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
		}
	};
	
	ActionListener btnTaoMoiEvents = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			textMaSv.setText("");
			textMaSv.setEditable(true);
			textHoTen.setText("");
			textDiaChi.setText("");
			cboTinhThanh.setSelectedIndex(0);
			textDienthoai.setText("");
			textEmail.setText("");
			cboMaLop.setSelectedIndex(0);
			btnSua.setEnabled(false);
			btnXoa.setEnabled(false);
			btnThem.setEnabled(true);
			
		}
	};

	/*----------------- PHẦN TỈNH/THÀNH QUẬN/HUYỆN PHƯỜNG --------------------------------*/

	ActionListener cboTinhThanhEvents = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				TinhThanh item = (TinhThanh) cboTinhThanh.getSelectedItem();
				 provinceId = item.getProvinceId();
				//System.out.println(provinceId);
				
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				
				 
				arrQuanHuyen = quanHuyenStatement.selectQuanHuyen(provinceId);
				cboQuanHuyen.removeAllItems();
				cboQuanHuyen.addItem(new QuanHuyen("Chọn Quận", null));
				for(QuanHuyen x : arrQuanHuyen) {
					cboQuanHuyen.addItem(x);
				}
		}
	};

	ActionListener cboQuanHuyenEvents = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			cboPhuong.removeAllItems();
			cboQuanHuyen.addItem(new QuanHuyen("Chọn Quận", null));
			for(QuanHuyen x : arrQuanHuyen) {
				cboQuanHuyen.addItem(x);
			}
			try {
				QuanHuyen item = (QuanHuyen) cboQuanHuyen.getSelectedItem();
				districtId = item.getDistricId();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			arrPhuong = phuongStatement.selectPhuong(districtId);;
			cboPhuong.addItem("Chọn Phường");
			for(Phuong x : arrPhuong) {
				cboPhuong.addItem(x);
			}
		}
	};
	
	ActionListener btnTimKiemEvents = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			selectAllSinhVien();
			dm.setRowCount(0);
			String timKiem = textTimKiem.getText().toUpperCase();
			if(timKiem.equals("Tên hoặc mã sinh viên") || timKiem.equals("")) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập thông tin tìm kiếm");
			} else {
				for (QuanLiSinhVien_Model x : arrSinhVien) {
					if (x.getHoTen().toUpperCase().indexOf(timKiem) > -1 || x.getMaSV().toUpperCase().indexOf(timKiem) > -1) {
						String row[] = { x.getMaSV(), x.getHoTen(), x.getDiaChi(), x.getPhuong(), x.getQuanHuyen(),
								x.getTinhThanh(), x.getDienThoai(), x.getEmail(), x.getMaLop() };
						dm.addRow(row);
					} 
				}
			}
	
		}
	};

	ActionListener cboMaLopEvents = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// in danh sách sinh viên xuống table
			inSinhVienCbo();

		}
	};
	
	public void selectAllSinhVien() {
		arrSinhVien = quanLiSinhVienStatement.selectAllSv();
		
	}
	
	public void inSinhVienCbo() {
		dm.setRowCount(0);
		Object mL = cboMaLop.getSelectedItem();
		if(mL != null && !mL.toString().equals("Chọn Lớp")) {
			String chose = cboMaLop.getSelectedItem().toString();
			for (QuanLiSinhVien_Model x : arrSinhVien) {
				if (chose.equals(x.getMaLop())) {
					String row[] = { x.getMaSV(), x.getHoTen(), x.getDiaChi(), x.getPhuong(), x.getQuanHuyen(),
							x.getTinhThanh(), x.getDienThoai(), x.getEmail(), x.getMaLop() };
					dm.addRow(row);
				} 
			}
		}
		
	}
	
	public void inToanBo() {
		selectAllSinhVien();
		for(QuanLiSinhVien_Model x: arrSinhVien) {
			String row[] = { x.getMaSV(), x.getHoTen(), x.getDiaChi(), x.getPhuong(), x.getQuanHuyen(),
					x.getTinhThanh(), x.getDienThoai(), x.getEmail(), x.getMaLop() };
			dm.addRow(row);
		}
	}
	
	public void addItemMaLop() {
		cboMaLop.removeAllItems();
		cboMaLop.addItem("Chọn Lớp");
		arrLop = quanLiLopStatement.sellectAllLop();
		for (QuanLiLopHoc_Model x : arrLop) {
			cboMaLop.addItem(x.getMaLop());
		}
	}
	
	

}
