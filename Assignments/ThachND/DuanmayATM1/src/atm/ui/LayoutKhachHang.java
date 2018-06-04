package atm.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.StyleConstants.FontConstants;

public class LayoutKhachHang extends JFrame {
	DefaultTableModel dm = new DefaultTableModel();
	final JTable tbl = new JTable(dm);
	JScrollPane sc = new JScrollPane(tbl);

	public LayoutKhachHang() {
		addControls();
		
	}

	private void addControls() {
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setLayout(new BorderLayout());

		JPanel pn1 = new JPanel();
		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Danh sÃ¡ch KhÃ¡ch HÃ ng");
		pn1.setBorder(borderTitle);
		dm.addColumn("MÃ£ KhÃ¡ch HÃ ng");
		dm.addColumn("TÃªn KhÃ¡ch HÃ ng");
		dm.addColumn("Tuá»•i KhÃ¡ch HÃ ng");
		dm.addColumn("Lá»›p Sinh ViÃªn");
		dm.addColumn("Lá»›p Sinh ViÃªn");
		dm.addColumn("Lá»›p Sinh ViÃªn");

		pn1.setPreferredSize(new Dimension(0, 50));
		pn1.setLayout(new BorderLayout());
		pn1.add(sc, BorderLayout.CENTER);

		JPanel pn2 = new JPanel();
		

		JPanel pn3 = new JPanel();
		pn3.setLayout(new BoxLayout(pn3, BoxLayout.Y_AXIS));
		Border border3 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle3 = BorderFactory.createTitledBorder(border3, "Nháº­p thÃ´ng tin");
		pn3.setBorder(borderTitle3);

		JPanel pnLeft = new JPanel();
		pnLeft.setLayout(new BoxLayout(pnLeft, BoxLayout.X_AXIS));
		
		Border border3n = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle3n = BorderFactory.createTitledBorder(border3n);
		pnLeft.setBorder(borderTitle3n);
		
		JPanel pnLeft1 = new JPanel();
		pnLeft1.setLayout(new BoxLayout(pnLeft1, BoxLayout.Y_AXIS));
		
		JPanel pnMkh = new JPanel();	
		JLabel lblMkh = new JLabel("MÃ£ KhÃ¡ch HÃ ng:");
		lblMkh.setFont(new Font("Times New Roman", Font.PLAIN,18));
		JTextField txtMaKh = new JTextField(15);
		pnMkh.add(lblMkh);
		pnMkh.add(txtMaKh);
		
		JPanel pnMkh1 = new JPanel();	
		JLabel lblMkh1 = new JLabel("Email:               ");
		lblMkh1.setFont(new Font("Times New Roman", Font.PLAIN,18));
		JTextField txtMaKh1 = new JTextField(15);
		pnMkh1.add(lblMkh1);
		pnMkh1.add(txtMaKh1);
		
		JPanel pnMkh2 = new JPanel();	
		JLabel lblMkh2 = new JLabel("Há»� & TÃªn KH:  ");
		lblMkh2.setFont(new Font("Times New Roman", Font.PLAIN,18));
		JTextField txtMaKh2 = new JTextField(15);
		pnMkh2.add(lblMkh2);
		pnMkh2.add(txtMaKh2);
		
		JPanel pnMkh3 = new JPanel();	
		JLabel lblMkh3 = new JLabel("Ä�á»‹a Chá»‰:            ");
		lblMkh3.setFont(new Font("Times New Roman", Font.PLAIN,18));
		JTextField txtMaKh3 = new JTextField(15);
		pnMkh3.add(lblMkh3);
		pnMkh3.add(txtMaKh3);
		
		pnLeft1.add(pnMkh);
		pnLeft1.add(pnMkh1);
		pnLeft1.add(pnMkh2);
		pnLeft1.add(pnMkh3);
		
		JPanel pnLeft2 = new JPanel();
		pnLeft2.setLayout(new BoxLayout(pnLeft2, BoxLayout.Y_AXIS));
		
		JPanel pnSoTk1 = new JPanel();
		JLabel lblSoTk1 = new JLabel("Sá»‘ TK NgÃ¢n HÃ ng:");
		lblSoTk1.setFont(new Font("Times New Roman", Font.PLAIN,18));
		JTextField txtSoTk1 = new JTextField(15);
		pnSoTk1.add(lblSoTk1);
		pnSoTk1.add(txtSoTk1);
		
		JPanel pnSoTk2 = new JPanel();
		JLabel lblSoTk2 = new JLabel("Sá»‘ tháº» ATM:         ");
		lblSoTk2.setFont(new Font("Times New Roman", Font.PLAIN,18));
		JTextField txtSoTk2 = new JTextField(15);
		pnSoTk2.add(lblSoTk2);
		pnSoTk2.add(txtSoTk2);
		
		JPanel pnSoTk3 = new JPanel();
		JLabel lblSoTk3 = new JLabel("Ä�iá»‡n thoáº¡i:            ");
		lblSoTk3.setFont(new Font("Times New Roman", Font.PLAIN,18));
		JTextField txtSoTk3 = new JTextField(15);
		pnSoTk3.add(lblSoTk3);
		pnSoTk3.add(txtSoTk3);
		
//		JPanel pnLeft3 = new JPanel();
//		pnLeft3.setLayout(new BoxLayout(pnLeft3, BoxLayout.X_AXIS));
		
		JPanel pnSoTk4 = new JPanel();
		JLabel lblQuan = new JLabel("        Quáº­n:");
		JComboBox cbo1 = new JComboBox();
		cbo1.addItem("Quáº­n Háº£i ChÃ¢u");
		cbo1.addItem("Quáº­n Thanh KhÃª");
		cbo1.addItem("Quáº­n SÆ¡n TrÃ ");
		cbo1.addItem("Quáº­n NgÅ© HÃ nh SÆ¡n");
		cbo1.addItem("Quáº­n LiÃªn Chiá»ƒu");
		cbo1.addItem("Quáº­n Cáº©m Lá»‡");
		cbo1.addItem("Huyá»‡n HÃ²a Vang");
		pnSoTk4.add(lblQuan);
		pnSoTk4.add(cbo1);
		
		JPanel pnSoTk5 = new JPanel();
		JLabel lblPhuong = new JLabel("PhÆ°á»�ng: ");
		JComboBox cbo2 = new JComboBox();
		cbo2.addItem("PhÆ°á»�ng BÃ¬nh Thuáº­n");
		cbo2.addItem("Quáº­n Thanh KhÃª");
		cbo2.addItem("Quáº­n SÆ¡n TrÃ ");
		cbo2.addItem("Quáº­n NgÅ© HÃ nh SÆ¡n");
		cbo2.addItem("Quáº­n LiÃªn Chiá»ƒu");
		cbo2.addItem("Quáº­n Cáº©m Lá»‡");
		pnSoTk5.add(lblPhuong);
		pnSoTk5.add(cbo2);
		
		pnLeft2.add(pnSoTk1);
		pnLeft2.add(pnSoTk2);
		pnLeft2.add(pnSoTk3);
		pnLeft2.add(pnSoTk4);
		pnLeft2.add(pnSoTk5);
		
		
		pnLeft.add(pnLeft1);
		pnLeft.add(pnLeft2);
		
		
		JPanel pnRight = new JPanel();
		pnRight.setLayout(new BoxLayout(pnRight, BoxLayout.Y_AXIS));
		
		Border border3n2 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle3n2 = BorderFactory.createTitledBorder(border3n2);
		
		JPanel pnThem = new JPanel();
//		ImageIcon icon = new ImageIcon("D:\\FFSE1703.JavaCore\\Assignments\\ThachND\\Duanmayatm\\image\\them.png");
//		icon.setImage(icon.getImage());
		JButton btnThem = new JButton("ThÃªm", new ImageIcon(((new ImageIcon("D:/FFSE1703.JavaCore/Assignments/ThachND/Duanmayatm/image/them.png")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
		
		btnThem.setFont(new Font("Times New Roman", Font.PLAIN,20));
		btnThem.setPreferredSize(new Dimension(250,50));
		pnThem.add(btnThem);
		pnRight.add(pnThem);
		
		
		JPanel pnSua = new JPanel();
		JButton btnSua = new JButton("Sá»­a", new ImageIcon(((new ImageIcon("D:/FFSE1703.JavaCore/Assignments/ThachND/Duanmayatm/image/sua.png")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
		btnSua.setFont(new Font("Times New Roman", Font.PLAIN,20));
		btnSua.setPreferredSize(new Dimension(250,50));
		pnSua.add(btnSua);
		pnRight.add(pnSua);
		
		JPanel pnXoa = new JPanel();
		JButton btnXoa = new JButton("XÃ³a", new ImageIcon(((new ImageIcon("D:/FFSE1703.JavaCore/Assignments/ThachND/Duanmayatm/image/xoa.png")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
		btnXoa.setFont(new Font("Times New Roman", Font.PLAIN,20));
		btnXoa.setPreferredSize(new Dimension(250,50));
		pnXoa.add(btnXoa);
		pnRight.add(pnXoa);
		
		JPanel pnHuy = new JPanel();
		JButton btnHuy = new JButton("Há»§y", new ImageIcon(((new ImageIcon("D:/FFSE1703.JavaCore/Assignments/ThachND/Duanmayatm/image/huy.png")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
		btnHuy.setFont(new Font("Times New Roman", Font.PLAIN,20));
		btnHuy.setPreferredSize(new Dimension(250,50));
		pnHuy.add(btnHuy);
		pnRight.add(pnHuy);
		
		
//		pn3n2.setBorder(borderTitle3n2);
//		pn3n2.setPreferredSize(new Dimension(350, 0));
		pnRight.setBorder(new CompoundBorder(new EmptyBorder(0,10,0,0), BorderFactory.createTitledBorder(borderTitle3n2)));

		pn3.setPreferredSize(new Dimension(0, 50));
		pn3.setLayout(new BorderLayout());
		pn3.add(pnLeft);
		pn3.add(pnRight, BorderLayout.LINE_END);

		// pn3.add(sc,BorderLayout.CENTER);

		this.add(pn1);
		this.add(pn2);
		this.add(pn3);
		this.setLayout(new BorderLayout());
		
	}
	public void showWindow() {
		this.setSize(1000,700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	
}
