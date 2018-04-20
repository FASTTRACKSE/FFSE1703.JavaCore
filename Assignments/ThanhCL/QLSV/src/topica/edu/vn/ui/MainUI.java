package topica.edu.vn.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;

import topica.edu.vn.model.LopHoc;
import topica.edu.vn.model.SinhVien;
import topica.edu.vn.service.LopHocService;
import topica.edu.vn.service.SinhVienService;

public class MainUI extends JFrame {
	
	DefaultTableModel dtmSinhVien;
	JTable tblSinhVien;
	
	DefaultMutableTreeNode root;
	JTree treeLop;
	
	JTextField txtMa,txtTen,txtTuoi;
	
	JButton btnThemMoi,btnLuu,btnXoa;
	
	JMenuItem mnuNew,mnuEdit,mnuXoa;
	JPopupMenu popup;
	
	ArrayList<LopHoc> dsLopHoc;
	LopHocService lopService;
	LopHoc selectedLop;
	
	SinhVienService svService;
	ArrayList<SinhVien>dsSinhVien;
	SinhVien selectedSV;
	
	public MainUI(String title)
	{
		super(title);
		addControls();
		addEvents();
		
		hienThiToanBoLopHocLenCay();
	}
	private void hienThiToanBoLopHocLenCay() {
		if(lopService==null)
			lopService=new LopHocService();
		dsLopHoc=lopService.layToanBoLop();
		root.removeAllChildren();
		for(LopHoc lop: dsLopHoc)
		{
			DefaultMutableTreeNode nodeLop=new DefaultMutableTreeNode(lop);
			root.add(nodeLop);
		}
		treeLop.expandRow(0);
	}
	private void addEvents() {
		btnXoa.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				xuLyXoaSinhVien();
			}
		});
		mnuNew.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				LopUI ui=new LopUI("Thêm 1 lớp mới");
				ui.showWindow();
				hienThiToanBoLopHocLenCay();
				treeLop.updateUI();
			}
		});
		
		treeLop.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {
				if(e.isPopupTrigger())
				{
					 int row = treeLop.getClosestRowForLocation(e.getX(), e.getY());
				        treeLop.setSelectionRow(row);
				        
					popup.show(e.getComponent(), e.getX(), e.getY());
				}
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
				DefaultMutableTreeNode nodeSelected= (DefaultMutableTreeNode) treeLop.getLastSelectedPathComponent();
				if(nodeSelected==null)return;
				if(nodeSelected.getLevel()==0)return;
				if(svService==null)
					svService=new SinhVienService();
				selectedLop=(LopHoc) nodeSelected.getUserObject();
				if(selectedLop!=null)
					dsSinhVien=svService.layToanBoSinhVienTheoMaLop(selectedLop.getMaLop());
				hienThiSinhVienLenTable();
			}
		});
		tblSinhVien.addMouseListener(new MouseListener() {
			
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
				int row=tblSinhVien.getSelectedRow();
				if(row==-1)return;
				selectedSV=dsSinhVien.get(row);
				txtMa.setText(selectedSV.getMa());
				txtTen.setText(selectedSV.getTen());
				txtTuoi.setText(selectedSV.getTuoi()+"");
			}
		});
	}
	protected void xuLyXoaSinhVien() {
		if(selectedSV==null)return;
		int ret=JOptionPane.showConfirmDialog(null,
				"Thím muốn xóa sinh viên này hả?",
				"Hỏi xóa",JOptionPane.YES_NO_OPTION);
		if(ret==JOptionPane.YES_OPTION)
		{
			if(svService==null)
				svService=new SinhVienService();
			if(svService.xoaSinhVien(selectedSV)>0)
			{
				if(selectedLop!=null)
					dsSinhVien=svService.layToanBoSinhVienTheoMaLop(selectedLop.getMaLop());
				hienThiSinhVienLenTable();
			}
		}
	}
	protected void hienThiSinhVienLenTable() {
		dtmSinhVien.setRowCount(0);
		for(SinhVien sv: dsSinhVien)
		{
			Vector<Object>vec=new Vector<Object>();
			vec.add(sv.getMa());
			vec.add(sv.getTen());
			vec.add(sv.getTuoi());
			dtmSinhVien.addRow(vec);
		}
	}
	private void addControls() {
		Container con=getContentPane();
		con.setLayout(new BorderLayout());
		JPanel pnLeft=new JPanel();
		pnLeft.setPreferredSize(new Dimension(300, 0));
		JPanel pnRight=new JPanel();
		JSplitPane sp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pnLeft,pnRight);
		con.add(sp,BorderLayout.CENTER);
		
		pnLeft.setLayout(new BorderLayout());
		root=new DefaultMutableTreeNode("Danh sách lớp");
		treeLop=new JTree(root);
		JScrollPane scTree=new JScrollPane(treeLop,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnLeft.add(scTree,BorderLayout.CENTER);
		
		pnRight.setLayout(new BorderLayout());
		JPanel pnTopOfRight=new JPanel();
		pnTopOfRight.setLayout(new BorderLayout());
		pnTopOfRight.setPreferredSize(new Dimension(0, 500));
		JPanel pnBottomOfRight=new JPanel();
		JSplitPane spSinhVien=new JSplitPane(JSplitPane.VERTICAL_SPLIT, pnTopOfRight,pnBottomOfRight);
		pnRight.add(spSinhVien,BorderLayout.CENTER);
		
		dtmSinhVien=new DefaultTableModel();
		dtmSinhVien.addColumn("Mã sinh viên");
		dtmSinhVien.addColumn("Tên sinh viên");
		dtmSinhVien.addColumn("Tuổi sinh viên");
		tblSinhVien=new JTable(dtmSinhVien); 
		JScrollPane scTable=new JScrollPane(tblSinhVien,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
		pnTopOfRight.add(scTable,BorderLayout.CENTER);
		
		pnBottomOfRight.setLayout(new BoxLayout(pnBottomOfRight, BoxLayout.Y_AXIS));
		
		JPanel pnMa=new JPanel();
		pnMa.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblMa=new JLabel("Mã sinh viên:");
		txtMa=new JTextField(30);
		pnMa.add(lblMa);
		pnMa.add(txtMa );
		pnBottomOfRight.add(pnMa);
		
		JPanel pnTen=new JPanel();
		pnTen.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblTen=new JLabel("Tên sinh viên:");
		txtTen=new JTextField(30);
		pnTen.add(lblTen);
		pnTen.add(txtTen );
		pnBottomOfRight.add(pnTen);
		
		JPanel pnTuoi=new JPanel();
		pnTuoi.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblTuoi=new JLabel("Tuổi sinh viên:");
		txtTuoi=new JTextField(30);
		pnTuoi.add(lblTuoi);
		pnTuoi.add(txtTuoi);
		pnBottomOfRight.add(pnTuoi);
		
		JPanel pnButton=new JPanel();
		pnButton.setLayout(new FlowLayout(FlowLayout.LEFT));
		btnThemMoi=new JButton("Thêm mới"); 
		btnLuu=new  JButton("Lưu");
		btnXoa=new JButton("Xóa");
		pnButton.add(btnThemMoi);
		pnButton.add(btnLuu);
		pnButton.add(btnXoa);
		pnBottomOfRight.add(pnButton);
		lblMa.setPreferredSize(lblTuoi.getPreferredSize());
		lblTen.setPreferredSize(lblTuoi.getPreferredSize());
		
		btnLuu.setIcon(new ImageIcon("images/save.png") );
		btnThemMoi.setIcon(new ImageIcon("images/new.png"));
		btnXoa.setIcon(new ImageIcon("images/remove.png"));
		setupMenu();
	}
	private void setupMenu() {
		mnuNew=new JMenuItem("Thêm lớp mới");
		mnuNew.setIcon(new ImageIcon("images/add_lop.png"));
		mnuEdit=new JMenuItem("Sửa lớp này");
		mnuEdit.setIcon(new ImageIcon("images/edit_lop.png"));
		mnuXoa=new JMenuItem("Xóa lớp này");
		mnuXoa.setIcon(new ImageIcon("images/remove_lop.png"));
		popup=new JPopupMenu();
		popup.add(mnuNew);
		popup.add(mnuEdit);
		popup.addSeparator();
		popup.add(mnuXoa);
	}
	public void showWindow()
	{
		this.setSize(800, 800);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
