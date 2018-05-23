package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TexturePaint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;

import connector.GetConnect;
import model.QuanLiMonHoc_Model;
import model.QuanLiMonHoc_Statement;

public class QuanLiMonHoc extends JPanel {
	private JButton btnThem, btnSua, btnXoa, btnTaoMoi;
	private JTextField textMaMon, textTenMon, textSoTinChi, textThoiLuong; 
	private DefaultTableModel dm;
	private ArrayList<QuanLiMonHoc_Model> arrMonHoc = new ArrayList<>();
	private QuanLiMonHoc_Statement quanLiMonHocStatement = new QuanLiMonHoc_Statement();
	public QuanLiMonHoc() {
		addControl();
		addEvent();
	}

	private void addControl() {
		JPanel boxQuanLiMonHoc = new JPanel();
		boxQuanLiMonHoc.setLayout(new BoxLayout(boxQuanLiMonHoc, BoxLayout.Y_AXIS));
		Font font = new Font("Arial", Font.BOLD, 15);
		JPanel boxNhap = new JPanel();
		boxNhap.setLayout(new BoxLayout(boxNhap, BoxLayout.X_AXIS));
		Border borderNhap = BorderFactory.createEtchedBorder();
		TitledBorder borderTitleNhap = BorderFactory.createTitledBorder(borderNhap,"Nhập thông tin môn học",TitledBorder.CENTER, 
				TitledBorder.DEFAULT_POSITION);
		borderTitleNhap.setTitleFont(borderTitleNhap.getTitleFont().deriveFont(Font.BOLD,20));
		borderTitleNhap.setTitleColor(Color.BLACK);
		boxNhap.setBorder(borderTitleNhap);
		JPanel khungNhap = new JPanel();
		khungNhap.setLayout(new BoxLayout(khungNhap, BoxLayout.Y_AXIS));
		Border borderKhungNhap = BorderFactory.createEtchedBorder();
		khungNhap.setBorder(borderKhungNhap);
		JPanel hangNhap1 = new JPanel();
		hangNhap1.setLayout(new FlowLayout());
		JLabel maMon = new JLabel("Mã môn:");
		maMon.setFont(font);
		maMon.setPreferredSize(new Dimension(90, 30));
		textMaMon = new JTextField(20);
		textMaMon.setPreferredSize(new Dimension(90, 30));
		JPanel hangNhap2 = new JPanel();
		hangNhap2.setLayout(new FlowLayout());
		JLabel tenMon = new JLabel("Tên môn:");
		tenMon.setFont(font);
		tenMon.setPreferredSize(new Dimension(90, 30));
		textTenMon = new JTextField(20);
		textTenMon.setPreferredSize(new Dimension(90, 30));
		JPanel hangNhap3 = new JPanel();
		hangNhap3.setLayout(new FlowLayout());
		JLabel soTinChi = new JLabel("Số tín chỉ:");
		soTinChi.setFont(font);
		soTinChi.setPreferredSize(new Dimension(90, 30));
		textSoTinChi = new JTextField(20);
		textSoTinChi.setPreferredSize(new Dimension(90, 30));
		JPanel hangNhap4 = new JPanel();
		hangNhap4.setLayout(new FlowLayout());
		JLabel thoiLuong = new JLabel("Thời lượng:");
		thoiLuong.setFont(font);
		thoiLuong.setPreferredSize(new Dimension(90, 30));
		textThoiLuong = new JTextField(20);
		textThoiLuong.setText("Đơn vị giờ");
		textThoiLuong.setForeground(new Color(190, 190, 190));
		textThoiLuong.setPreferredSize(new Dimension(90, 30));
		textThoiLuong.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				String taiKhoan = textThoiLuong.getText();
				
				if(taiKhoan.equals("") || taiKhoan.equalsIgnoreCase("Đơn vị giờ")) {
					//textMatKhau.setEchoChar('*');
					textThoiLuong.setText("Đơn vị giờ");
					textThoiLuong.setForeground(new Color(190, 190, 190));
				}
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				String taiKhoan = textThoiLuong.getText();
				
				if(taiKhoan.equals("Đơn vị giờ")) {
					textThoiLuong.setText("");
					textThoiLuong.setForeground(new Color(0, 0, 0));
				}
				
			}
		});
		hangNhap1.add(maMon);
		hangNhap1.add(textMaMon);
		hangNhap2.add(tenMon);
		hangNhap2.add(textTenMon);
		hangNhap3.add(soTinChi);
		hangNhap3.add(textSoTinChi);
		hangNhap4.add(thoiLuong);
		hangNhap4.add(textThoiLuong);
		khungNhap.add(hangNhap1);
		khungNhap.add(hangNhap2);
		khungNhap.add(hangNhap3);
		khungNhap.add(hangNhap4);

		JPanel khungNut = new JPanel();
		khungNut.setLayout(new BoxLayout(khungNut, BoxLayout.Y_AXIS));
		Border borderKhungNut = BorderFactory.createEtchedBorder();
		khungNut.setBorder(borderKhungNut);
		JPanel hangNut1 = new JPanel();
		hangNut1.setLayout(new FlowLayout());
		ImageIcon imgBtnThem = new ImageIcon(getClass().getResource("/images/btn_them.png"));
	    btnThem = new JButton("Thêm", imgBtnThem);
		btnThem.setPreferredSize(new Dimension(110, 30));
		JPanel hangNut2 = new JPanel();
		hangNut2.setLayout(new FlowLayout());
		ImageIcon imgBtnSua = new ImageIcon(getClass().getResource("/images/btn_sua.png"));
		btnSua = new JButton("Sửa", imgBtnSua);
		btnSua.setEnabled(false);
		btnSua.setPreferredSize(new Dimension(110, 30));
		JPanel hangNut3 = new JPanel();
		hangNut3.setLayout(new FlowLayout());
		ImageIcon imgBtnXoa = new ImageIcon(getClass().getResource("/images/btn_xoa.png"));
		btnXoa = new JButton("Xóa", imgBtnXoa);
		btnXoa.setEnabled(false);
		btnXoa.setPreferredSize(new Dimension(110, 30));
		JPanel hangNut4 = new JPanel();
		hangNut4.setLayout(new FlowLayout());
		ImageIcon imgBtnHuy = new ImageIcon(getClass().getResource("/images/btn_huy.png"));
		btnTaoMoi = new JButton("Hủy", imgBtnHuy);
		btnTaoMoi.setPreferredSize(new Dimension(110, 30));
		hangNut1.add(btnThem);
		hangNut2.add(btnSua);
		hangNut3.add(btnXoa);
		hangNut4.add(btnTaoMoi);
		khungNut.add(hangNut1);
		khungNut.add(hangNut2);
		khungNut.add(hangNut3);
		khungNut.add(hangNut4);
		
		JPanel boxHienThi = new JPanel();
		boxHienThi.setLayout(new BoxLayout(boxHienThi, BoxLayout.Y_AXIS));
		boxHienThi.setPreferredSize(new Dimension(0, 350));
		Border borderHienThi = BorderFactory.createEtchedBorder();
		TitledBorder borderTitleHienThi = BorderFactory.createTitledBorder(borderHienThi,"Thông tin môn học",TitledBorder.CENTER, 
				TitledBorder.DEFAULT_POSITION);
		borderTitleHienThi.setTitleFont(borderTitleNhap.getTitleFont().deriveFont(Font.BOLD,20));
		borderTitleHienThi.setTitleColor(Color.BLACK);
		boxHienThi.setBorder(borderTitleHienThi);
		dm = new DefaultTableModel();
		dm.addColumn("Mã môn");
		dm.addColumn("Tên môn");
		dm.addColumn("Số tín chỉ");
		dm.addColumn("Thời lượng");
		JTable tbSinhVien = new JTable(dm);
		sellectAllMonHoc();
		in();
		JScrollPane sc = new JScrollPane(tbSinhVien);
		tbSinhVien.addMouseListener(new MouseAdapter() {
	
			@Override
			public void mouseClicked(MouseEvent e) {
				textMaMon.setEditable(false);
				int row = tbSinhVien.getSelectedRow();
				String value = tbSinhVien.getValueAt(row, 0).toString();
				
				for(QuanLiMonHoc_Model x : arrMonHoc) {
					textThoiLuong.setForeground(new Color(0, 0, 0));
					if(value.equals(x.getMaMon())) {
						textMaMon.setText(x.getMaMon());
						textTenMon.setText(x.getTenMon());
						textSoTinChi.setText(x.getSoTinChi());
						int endSubtring = x.getThoiLuong().length() - 4;
						textThoiLuong.setText(x.getThoiLuong().substring(0, endSubtring));
						btnSua.setEnabled(true);
						btnXoa.setEnabled(true);
						btnThem.setEnabled(false);
					}
				}
				
			}
		});
		
		boxNhap.add(khungNhap);
		boxNhap.add(Box.createRigidArea(new Dimension(10, 0)));
		boxNhap.add(khungNut);
		boxHienThi.add(sc);
		
		boxQuanLiMonHoc.add(boxNhap);
		boxQuanLiMonHoc.add(Box.createRigidArea(new Dimension(0, 5)));
		boxQuanLiMonHoc.add(boxHienThi);

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(boxQuanLiMonHoc);
	}

	private void addEvent() {
		btnThem.addActionListener(btnThemEvents);
		btnSua.addActionListener(btnSuaEvents);
		btnXoa.addActionListener(btnXoaEvents);
		btnTaoMoi.addActionListener(btnTaoMoiEvents);
	}
	
	ActionListener btnThemEvents = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
			String maMon = textMaMon.getText().toUpperCase();
			String tenMon = textTenMon.getText();
			String soTinChi = textSoTinChi.getText();
			String thoiLuong = textThoiLuong.getText();
			
			String kt = "Không trùng";
			int soChi = Integer.parseInt(soTinChi);
			int thoiLuongHoc = Integer.parseInt(thoiLuong);
			if(maMon.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập mã môn");
			} else if(tenMon.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập tên môn");
			} else if(soTinChi.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập số tín chỉ");
			} else if(thoiLuong.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập thời lượng học");
			} else if(soChi < 0) {
				JOptionPane.showMessageDialog(null, "Số tín chỉ không hợp lệ");
			} else if(thoiLuongHoc < 0) {
				JOptionPane.showMessageDialog(null, "Thời lượng học không hợp lệ");
			}
			else {
				for(QuanLiMonHoc_Model x : arrMonHoc) {
					if(maMon.equals(x.getMaMon())) {
						kt = "Trùng";
					}
				}
				if(kt == "Trùng") {
					JOptionPane.showMessageDialog(null, "Trùng mã môn vui lòng nhập lại ");
				}else {
					quanLiMonHocStatement.insertMonHoc(maMon, tenMon, soTinChi, thoiLuong);
					sellectAllMonHoc();
					String row[] = {maMon, tenMon, soTinChi, thoiLuong +" giờ"};
					dm.addRow(row);
					taoMoi();
				}
			}
			
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Số tín chỉ và thời lượng phải nhập đúng dạng");
			} 
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	};
	
	ActionListener btnSuaEvents = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
			String maMon = textMaMon.getText();
			String tenMon = textTenMon.getText();
			String soTinChi = textSoTinChi.getText();
			String thoiLuong = textThoiLuong.getText();
			int soChi = Integer.parseInt(soTinChi);
			int thoiLuongHoc = Integer.parseInt(thoiLuong);
			if(maMon.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn môn cần xóa");
			} else if(tenMon.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập tên môn");
			} else if(soTinChi.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập số tín chỉ");
			} else if(thoiLuong.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập thời lượng");
			} else if(soChi < 0) {
				JOptionPane.showMessageDialog(null, "Số tín chỉ không hợp lệ");
			}else if(thoiLuongHoc < 0) {
				JOptionPane.showMessageDialog(null, "Thời lượng học không hợp lệ");
			}
			else {
			
				quanLiMonHocStatement.updateMonHoc(maMon, tenMon, soTinChi, thoiLuong);
				sellectAllMonHoc();
				dm.setRowCount(0);
				in();
				System.out.println(arrMonHoc.toString());
				
				taoMoi();
			}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Số tín chỉ và thời lượng phải nhập đúng dạng");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	};
	
	ActionListener btnXoaEvents = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
			String maMon = textMaMon.getText();
			
			if(maMon.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn môn cần xóa");
			} 
			else {
				int chose = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa không", "Xóa", JOptionPane.YES_NO_OPTION);
				if(chose == JOptionPane.YES_OPTION) {
					quanLiMonHocStatement.deleteMonHoc(maMon);
					sellectAllMonHoc();
					dm.setRowCount(0);
					in();
					taoMoi();
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
			taoMoi();
		}
	};
	
	public void sellectAllMonHoc() {
		arrMonHoc = quanLiMonHocStatement.sellectMonHoc();
	}
	
	public void in() {
		for(QuanLiMonHoc_Model x : arrMonHoc) {
			String row[] = {x.getMaMon(), x.getTenMon(), x.getSoTinChi(), x.getThoiLuong()};
			dm.addRow(row);
		}
	}
	
	public void taoMoi() {
		textMaMon.setEditable(true);
		textMaMon.setText("");
		textTenMon.setText("");
		textSoTinChi.setText("");
		textThoiLuong.setText("Đơn vị giờ");
		textThoiLuong.setForeground(new Color(190, 190, 190));
		btnSua.setEnabled(false);
		btnXoa.setEnabled(false);
		btnThem.setEnabled(true);
	}

}
