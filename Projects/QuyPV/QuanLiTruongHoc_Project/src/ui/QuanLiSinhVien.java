package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.management.ThreadMXBean;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
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
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;

import connector.GetConnect;
import model.Phuong;
import model.QuanHuyen;
import model.QuanLiLopHoc_Model;
import model.QuanLiSinhVien_Model;
import model.TinhThanh;

public class QuanLiSinhVien extends JPanel {
	// final Connection conn= GetConnect.getConnect("localhost",
	// "Quan_li_truong_hoc", "phamquy481", "a0163763123");
	private ArrayList<TinhThanh> arrTinhThanh = new ArrayList<>();
	private ArrayList<QuanHuyen> arrQuanHuyen = new ArrayList<>();
	private ArrayList<Phuong> arrPhuong = new ArrayList<>();
	private ArrayList<QuanLiLopHoc_Model> arrLop = new ArrayList<>();
	private ArrayList<QuanLiSinhVien_Model> arrSinhVien = new ArrayList<>();
	private ArrayList<QuanLiSinhVien_Model> arrSinhVienWhere = new ArrayList<>();
	private JComboBox<Object> cboTinhThanh, cboQuanHuyen, cboPhuong, cboMaLop;
	private JTextField textMaSv, textHoTen, textDiaChi, textDienthoai, textEmail;
	private JButton btnThem, btnSua, btnXoa, btnThoat;
	private String provinceId, districtId, nameTinhThanh, nameQuanHuyen, namePhuong, nameLop;
	private QuanLiSinhVien_Model quanLiSinhVienModel = new QuanLiSinhVien_Model();
	private TinhThanh tinhThanhModel = new TinhThanh();
	private QuanHuyen quanHuyenModel = new QuanHuyen();
	private Phuong phuongModel = new Phuong();
	private QuanLiLopHoc_Model quanLiLopHocModel = new QuanLiLopHoc_Model();
	private DefaultTableModel dm;

	public QuanLiSinhVien() {
		addControl();
		addEvent();
	}

	private void addControl() {
		JPanel boxQuanLiHocSinh = new JPanel();
		Font font = new Font("Arial", Font.BOLD, 15);
		boxQuanLiHocSinh.setLayout(new BoxLayout(boxQuanLiHocSinh, BoxLayout.Y_AXIS));

		/* PHẦN NHẬP THÔNG TIN SINH VIÊN */
		JPanel boxNhap = new JPanel();
		boxNhap.setLayout(new BoxLayout(boxNhap, BoxLayout.Y_AXIS));
		boxNhap.setPreferredSize(new Dimension(0, 300));
		Border borderNhap = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitleNhap = BorderFactory.createTitledBorder(borderNhap, "Nhập thông tin",
				TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
		borderTitleNhap.setTitleFont(borderTitleNhap.getTitleFont().deriveFont(Font.ITALIC, 20));
		borderTitleNhap.setTitleColor(Color.RED);
		boxNhap.setBorder(borderTitleNhap);
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
		arrTinhThanh = tinhThanhModel.selectAll();
		
		cboTinhThanh = new JComboBox();
		cboTinhThanh.setPreferredSize(new Dimension(120, 30));
		cboTinhThanh.addItem(new TinhThanh(null, "Chọn Tỉnh"));
		//cboTinhThanh.setPrototypeDisplayValue("---Ch?n---");
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
		arrLop.clear();
		arrLop = quanLiLopHocModel.sellectAllLop();
		cboMaLop = new JComboBox<>();
		cboMaLop.setPreferredSize(new Dimension(120, 30));
		// cboMaLop.setPrototypeDisplayValue("---Chọn---");
		cboMaLop.addItem("Chọn Lớp");
		for (QuanLiLopHoc_Model x : arrLop) {
			cboMaLop.addItem(x.getMaLop());
		}
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
		btnThem = new JButton("Thêm");
		btnSua = new JButton("Sửa");
		btnXoa = new JButton("Xóa");
		btnThoat = new JButton("Thoát");
		hang4.add(btnThem);
		hang4.add(btnSua);
		hang4.add(btnXoa);
		hang4.add(btnThoat);

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
		tbSinhVien.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tbSinhVien.getSelectedRow();
				String value = tbSinhVien.getValueAt(row, 0).toString();
				textMaSv.setEnabled(false);
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
				} catch(Exception x) {
					
				}
				
			}
		});
		JScrollPane sc = new JScrollPane(tbSinhVien);
		hienThi.add(sc);
		Border borderHienThi = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitleHienThi = BorderFactory.createTitledBorder(borderHienThi, "Danh sách sinh viên",
				TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
		borderTitleHienThi.setTitleFont(borderTitleHienThi.getTitleFont().deriveFont(Font.ITALIC, 20));
		borderTitleHienThi.setTitleColor(Color.RED);
		boxHienThi.setBorder(borderTitleHienThi);

		boxNhap.add(hang1);
		boxNhap.add(Box.createRigidArea(new Dimension(0, 5)));
		boxNhap.add(hang2);
		boxNhap.add(Box.createRigidArea(new Dimension(0, 5)));
		boxNhap.add(hang3);
		boxNhap.add(Box.createRigidArea(new Dimension(0, 5)));
		boxNhap.add(hang4);

		// boxHienThi.add(timKiem);
		boxHienThi.add(hienThi);

		boxQuanLiHocSinh.add(boxNhap);
		boxQuanLiHocSinh.add(Box.createRigidArea(new Dimension(0, 5)));
		boxQuanLiHocSinh.add(boxHienThi);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(boxQuanLiHocSinh);
	}

	private void addEvent() {
		cboTinhThanh.addActionListener(cboTinhThanhEvents);
		cboQuanHuyen.addActionListener(cboQuanHuyenEvents);
		cboMaLop.addActionListener(cboMaLopEvents);
		btnThem.addActionListener(btnThemEvents);
	}

	ActionListener btnThemEvents = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			selectAllSinhVien();
			System.out.println(arrSinhVien.toString());
	
			try {
				String maSv = textMaSv.getText();
				String hoten = textHoTen.getText();
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
				} else if (hoten.equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng Nhập mã Họ tên ");
				} else if (diaChi.equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng Nhập mã Địa chỉ ");
				} else if (dienThoai.equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng Nhập mã Điện thoại ");
				} else if (email.equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng Nhập mã Email ");
				} else {
						for(QuanLiSinhVien_Model x : arrSinhVien) {
							if(maSv.equals(x.getMaSV())) {
								kt = "Trùng";
							}
						}
								
						if(kt == "Trùng") {
							JOptionPane.showMessageDialog(null, "Trùng mã sinh viên vui lòng nhập lại");
						}
						else {
							quanLiSinhVienModel.insert(maSv, hoten, diaChi, phuong, quanHuyen, tinhThanh, dienThoai, email,
									maLop);
							selectAllSinhVien();
							String row[] = { maSv, hoten, diaChi, phuong , quanHuyen, tinhThanh,  dienThoai, email, maLop };
							dm.addRow(row);
							textMaSv.setText("");
							textHoTen.setText("");
							textDiaChi.setText("");
							cboTinhThanh.setSelectedIndex(0);
							cboQuanHuyen.setSelectedIndex(0);
							cboPhuong.setSelectedIndex(0);
							textDienthoai.setText("");
							textEmail.setText("");
						}
					
				}
			} catch (Exception ex) {
				System.out.println(ex);
			}

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
				
				 
				arrQuanHuyen = quanHuyenModel.selectQuanHuyen(provinceId);
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
			arrPhuong = phuongModel.selectPhuong(districtId);;
			cboPhuong.addItem("Chọn Phuờng");
			for(Phuong x : arrPhuong) {
				cboPhuong.addItem(x);
			}
		}
	};

	ActionListener cboMaLopEvents = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			selectAllSinhVien();
			dm.setRowCount(0);
			String chose = cboMaLop.getSelectedItem().toString();
			for (QuanLiSinhVien_Model x : arrSinhVien) {
				if (chose.equals(x.getMaLop())) {
					String row[] = { x.getMaSV(), x.getHoTen(), x.getDiaChi(), x.getPhuong(), x.getQuanHuyen(),
							x.getTinhThanh(), x.getDienThoai(), x.getEmail(), x.getMaLop() };
					dm.addRow(row);
				}
			}

		}
	};
	
	public void selectAllSinhVien() {
		arrSinhVien = quanLiSinhVienModel.selectAllSv();
	}
	
	// select quận huyện dựa vào Tỉnh thành
	// private void selectQuanHuyen() {
	//
	// try {
	// quanHuyenModel.selectQuanHuyen(provinceId);
	// arrQuanHuyen = quanHuyenModel.getArrayList();
	//
	// } catch (Exception ex) {
	// ex.printStackTrace();
	// }
	// }

	// private void selectPhuong() {
	// arrPhuong.clear();
	// try {
	// String sql = "select * from Phuong where districtid = '"+districtId+"'";
	// Statement statement=conn.createStatement();
	// ResultSet result=statement.executeQuery(sql);
	// while(result.next())
	// {
	// namePhuong = result.getString("name");
	// arrPhuong.add(namePhuong);
	// //System.out.println(nameQuanHuyen);
	// }
	// } catch (Exception ex) {
	// ex.printStackTrace();
	// }
	//
	// }

}
