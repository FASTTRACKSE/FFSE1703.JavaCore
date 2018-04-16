package fasttrackse.qlnv.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import fasttrackse.qlnv.model.NhanVien;
import fasttrackse.qlnv.model.PhongBan;

public class QuanLyNhanVienUI extends JFrame {
	
	JComboBox<PhongBan>cboPhongBan;
	JList<NhanVien>listNhanVien;
	JTextField txtMa,txtTen,txtNgayVaoLam,txtNamSinh;
	JButton btnLuu,btnXoa,btnThoat;
	
	ArrayList<PhongBan>dsPhongBan;
	ArrayList<NhanVien>dsNhanVienTheoPhongBan;
	
	SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	
	PhongBan pbSelected=null;
	NhanVien nvSelected=null;
	
	public QuanLyNhanVienUI(String title)
	{
		super(title);
		addControls();
		addEvents();
		fakeData();
	}
	public void addControls()
	{
		Container con=getContentPane();
		JPanel pnMain=new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		con.add(pnMain);
		JPanel pnPhongBan=new JPanel();
		pnPhongBan.setLayout(new FlowLayout());
		pnMain.add(pnPhongBan);
		JLabel lblPhongBan=new JLabel("Chọn phòng ban:");
		cboPhongBan=new JComboBox<PhongBan>();
		cboPhongBan.setPreferredSize(new Dimension(200, 25));
		pnPhongBan.add(lblPhongBan);
		pnPhongBan.add(cboPhongBan);
		
		JPanel pnDanhSachVaChiTiet=new JPanel();
		pnDanhSachVaChiTiet.setLayout(new GridLayout(1, 2));
		pnMain.add(pnDanhSachVaChiTiet);
		JPanel pnDanhSach=new JPanel();
		pnDanhSach.setLayout(new BorderLayout());
		
		Border borderDanhSach=BorderFactory.createLineBorder(Color.BLUE);
		TitledBorder titleBorderDanhSach=new TitledBorder(borderDanhSach,"Danh sách");
		titleBorderDanhSach.setTitleJustification(TitledBorder.CENTER);
		titleBorderDanhSach.setTitleColor(Color.RED);
		pnDanhSach.setBorder(titleBorderDanhSach);
		
		
		listNhanVien=new JList<NhanVien>();
		JScrollPane sc=new JScrollPane(listNhanVien,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnDanhSach.add(sc,BorderLayout.CENTER);
		pnDanhSachVaChiTiet.add(pnDanhSach);
		
		JPanel pnChiTiet=new JPanel();
		pnChiTiet.setLayout(new BoxLayout(pnChiTiet, BoxLayout.Y_AXIS));
		
		
		Border borderChiTiet=BorderFactory.createLineBorder(Color.BLUE);
		TitledBorder titleBorderChiTiet=new TitledBorder(borderChiTiet,"Thông tin chi tiết");
		titleBorderChiTiet.setTitleJustification(TitledBorder.CENTER);
		titleBorderChiTiet.setTitleColor(Color.RED);
		pnChiTiet.setBorder(titleBorderChiTiet);
		
		
		pnDanhSachVaChiTiet.add(pnChiTiet);
		
		JPanel pnMa=new JPanel();
		pnMa.setLayout(new FlowLayout());
		JLabel lblMa=new JLabel("Mã:");
		txtMa=new JTextField(15);
		pnMa.add(lblMa);
		pnMa.add(txtMa);
		pnChiTiet.add(pnMa);
		
		JPanel pnTen=new JPanel();
		pnTen.setLayout(new FlowLayout());
		JLabel lblTen=new JLabel("Tên:");
		txtTen=new JTextField(15);
		pnTen.add(lblTen);
		pnTen.add(txtTen );
		pnChiTiet.add(pnTen);
	
		JPanel pnNgayvao=new JPanel();
		pnNgayvao.setLayout(new FlowLayout());
		JLabel lblNgayVao=new JLabel("Ngày vào:");
		txtNgayVaoLam=new JTextField(15);
		pnNgayvao.add(lblNgayVao);
		pnNgayvao.add(txtNgayVaoLam);
		pnChiTiet.add(pnNgayvao);
		
		JPanel pnNamSinh=new JPanel();
		pnNamSinh.setLayout(new FlowLayout());
		JLabel lblNamSinh=new JLabel("Năm sinh:");
		txtNamSinh=new JTextField(15);
		pnNamSinh.add(lblNamSinh);
		pnNamSinh.add(txtNamSinh);
		pnChiTiet.add(pnNamSinh);
		
		JPanel pnButton=new JPanel();
		
		Border borderButton=BorderFactory.createLineBorder(Color.BLUE);
		TitledBorder titleBorderButton=new TitledBorder(borderButton,"Chọn chức năng");
		titleBorderButton.setTitleJustification(TitledBorder.CENTER);
		titleBorderButton.setTitleColor(Color.RED);
		pnButton.setBorder(titleBorderButton);
		
		
		pnButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
		btnLuu=new JButton("Lưu");
		btnXoa=new JButton("Xóa");
		btnThoat=new JButton("Thoát");
		
		pnButton.add(btnLuu);
		pnButton.add(btnXoa);
		pnButton.add(btnThoat);
		pnMain.add(pnButton);
		
		lblMa.setPreferredSize(lblNamSinh.getPreferredSize());
		lblTen.setPreferredSize(lblNamSinh.getPreferredSize());
		lblNgayVao.setPreferredSize(lblNamSinh.getPreferredSize());
	}
	public void fakeData()
	{
		dsPhongBan=new ArrayList<PhongBan>();
		
		PhongBan phtgv=new PhongBan();
		phtgv.setMaPhong("p1");
		phtgv.setTenPhong("Phòng hợp tác giảng viên");
		
		PhongBan pkd=new PhongBan();
		pkd.setMaPhong("p2");
		pkd.setTenPhong("Phòng Kinh Doanh");
		
		PhongBan pKt=new PhongBan();
		pKt.setMaPhong("p3");
		pKt.setTenPhong("Phòng kế toán");
		
		dsPhongBan.add(phtgv);
		dsPhongBan.add(pkd);
		dsPhongBan.add(pKt);
		
		phtgv.themNhanVien(new NhanVien("NV1", "Nguyễn Thị An",
						new Date(2016-1900, 1, 1), new Date(1990-1900,1, 1)));
		
		phtgv.themNhanVien(new NhanVien("NV2", "Trần văn Bình",
				new Date(2015-1900, 1, 1), new Date(1992-1900,1, 1)));
		
		pkd.themNhanVien(new NhanVien("NV3", "Hồ Thị Giải",
				new Date(2013-1900, 1, 1), new Date(1989-1900,1, 1)));
		pkd.themNhanVien(new NhanVien("NV4", "Trần Đình Thoát",
				new Date(2014-1900, 1, 1), new Date(1988-1900,1, 1)));
		
		for(PhongBan pb : dsPhongBan)
		{
			cboPhongBan.addItem(pb);
		}
	}
	public void addEvents()
	{
		cboPhongBan.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(cboPhongBan.getSelectedIndex()==-1)return;
				
				pbSelected=(PhongBan) cboPhongBan.getSelectedItem();
				listNhanVien.setListData(pbSelected.getNhanViens());
			}
		});
		listNhanVien.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(listNhanVien.getSelectedIndex()==-1)return;
				nvSelected=listNhanVien.getSelectedValue();
				txtMa.setText(nvSelected.getMaNhanVien());
				txtTen.setText(nvSelected.getTenNhanVien());
				
				txtNamSinh.setText(sdf.format(nvSelected.getNamSinh()));
				txtNgayVaoLam.setText(sdf.format(nvSelected.getNgayVaoLamViec()));
			}
		});
		btnLuu.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				xuLyLuu();
			}
		});
		btnXoa.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				xuLyXoa();
			}
		});
		btnThoat.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
	}
	protected void xuLyXoa() {
		if(nvSelected!=null)
		{
			pbSelected.getNhanViens().remove(nvSelected);
			nvSelected=null;
			listNhanVien.setListData(pbSelected.getNhanViens());
		}
	}
	protected void xuLyLuu() {
		try
		{
			NhanVien nv=new NhanVien(
				txtMa.getText(), 
				txtTen.getText(), 
				sdf.parse(txtNgayVaoLam.getText()), 
				sdf.parse(txtNamSinh.getText()));
			if(pbSelected!=null)
			{
				pbSelected.themNhanVien(nv);
				listNhanVien.setListData(pbSelected.getNhanViens());
			}
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, ex.toString());
		}
	}
	public void showWindow()
	{
		this.setSize(550, 350);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
