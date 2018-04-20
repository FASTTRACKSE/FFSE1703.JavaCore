package fasttrack.edu.vn.myapp.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class StaffManagementUI extends JFrame {
	
	DefaultTableModel dtm;
	JTable tblSinhVien;
	
	JButton btnThemMoi,btnXoa;
	
	public StaffManagementUI(String title)
	{
		super(title);
		addControls();
		addEvents();
	}
	private void addControls() {
		Container con=getContentPane();
		JPanel pnLeft=new JPanel();
		JPanel pnRight=new JPanel();
		JSplitPane sp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,pnLeft,pnRight);
		con.add(sp);
		
		dtm=new DefaultTableModel();
		dtm.addColumn("Mã");
		dtm.addColumn("Tên");
		dtm.addColumn("Địa chỉ");
		
		//thử đưa một vài dòng vào:
		String row1[]={"SV1","Nguyễn văn Tèo","Hố Nai"};
		dtm.addRow(row1);
		String row2[]={"SV2","Trần Thị Tý","Đầm Dơi"};
		dtm.addRow(row2);
		
		Vector<String>vec3=new Vector<String>();
		vec3.add("sv3");
		vec3.add("Hồ văn Đồ");
		vec3.add("Lạng Sơn");
		dtm.addRow(vec3);
		
		
		tblSinhVien=new JTable(dtm);
		JScrollPane scTable=new JScrollPane(
				tblSinhVien, 
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnLeft.setLayout(new BorderLayout());
		pnLeft.add(scTable,BorderLayout.CENTER);
		pnLeft.setPreferredSize(new Dimension(300, 0));
		
		JPanel pnButton=new JPanel();
		pnButton.setLayout(new FlowLayout());
		btnThemMoi=new JButton("Thêm mới");
		btnXoa=new JButton("Xóa");
		pnButton.add(btnThemMoi);
		pnButton.add(btnXoa);
		pnLeft.add(pnButton,BorderLayout.SOUTH);
	}
	public void addEvents()
	{
		btnThemMoi.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Vector<String>vec=new Vector<String>();
				vec.add("MÃ XYZ");
				vec.add("Tên XYZ");
				vec.add("Địa chỉ XYZ");
				dtm.addRow(vec);
			}
		});
		btnXoa.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row=tblSinhVien.getSelectedRow();
				if(row==-1)return;
				
				dtm.removeRow(row);//xóa dòng đang chọn
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
				// TODO Auto-generated method stub
				int row=tblSinhVien.getSelectedRow();
				if(row==-1)return;
				String ma=tblSinhVien.getValueAt(row, 0)+"";
				String ten=tblSinhVien.getValueAt(row, 1)+"";
				String diaChi=tblSinhVien.getValueAt(row, 2)+"";
				JOptionPane.showMessageDialog(null, 
						"mã="+ma+"\nTên="+ten+"\nĐịa chỉ="+diaChi);
			}
		});
	}
	public void showWindow()
	{
		this.setSize(700, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setState(MAXIMIZED_BOTH);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}

