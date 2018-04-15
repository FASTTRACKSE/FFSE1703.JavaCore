package topica.edu.vn.ui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import topica.edu.vn.model.LopHoc;
import topica.edu.vn.service.LopHocService;

public class LopUI extends JDialog {
	
	JTextField txtMaLop,txtTenLop;
	JButton btnLuu,btnThoat;
	
	public LopUI(String title)
	{
		this.setTitle(title);
		addControls();
		addEvents();
	}

	private void addEvents() {
		btnThoat.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		btnLuu.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				xuLyLuuLop();
			}
		});
	}

	protected void xuLyLuuLop() {
		try
		{
			LopHoc lop=new LopHoc();
			lop.setMaLop(txtMaLop.getText());
			lop.setTenLop(txtTenLop.getText());
			LopHocService lopService=new LopHocService();
			int x=lopService.luuLopMoi(lop);
			if(x>0)
			{
				JOptionPane.showMessageDialog(null, "Thêm lớp thành công");
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

	private void addControls() {
		Container con=getContentPane();
		con.setLayout(new BoxLayout(con, BoxLayout.Y_AXIS));
		JPanel pnTitle=new JPanel();
		JLabel lblTitle=new JLabel("Nhập mới thông tin lớp:");
		pnTitle.add(lblTitle);
		con.add(pnTitle);
		
		JPanel pnMaLop=new JPanel();
		JLabel lblMaLop=new JLabel("Mã lớp:");
		txtMaLop=new JTextField(15);
		pnMaLop.add(lblMaLop);
		pnMaLop.add(txtMaLop);
		con.add(pnMaLop);
		
		JPanel pnTenLop=new JPanel();
		JLabel lblTenLop=new JLabel("Tên lớp:");
		txtTenLop=new JTextField(15);
		pnTenLop.add(lblTenLop);
		pnTenLop.add(txtTenLop);
		con.add(pnTenLop);
		
		JPanel pnButton=new JPanel();
		btnLuu=new JButton("Lưu");
		btnThoat=new JButton("Thoát");
		pnButton.add(btnLuu);
		pnButton.add(btnThoat);
		con.add(pnButton);
		
	}
	public void showWindow()
	{
		this.setSize(400, 200);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setModal(true);
		this.setVisible(true);
	}
}
