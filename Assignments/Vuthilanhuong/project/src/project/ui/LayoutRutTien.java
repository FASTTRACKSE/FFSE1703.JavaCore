package project.ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import com.sun.xml.internal.ws.api.server.Container;

public class LayoutRutTien extends JPanel implements ActionListener{
public LayoutRutTien() {
	addControl();
	addEvent();
}

private void addEvent() {
	// TODO Auto-generated method stub
	
	
}

private void addControl() {
	// TODO Auto-generated method stub
	JPanel pnRutTien = new JPanel();
	pnRutTien.setLayout(new BoxLayout(pnRutTien, BoxLayout.Y_AXIS));
	
	JPanel pnMa_Pass = new JPanel();
	pnMa_Pass.setLayout(new BoxLayout(pnMa_Pass, BoxLayout.Y_AXIS));
	
	JPanel pnMa = new JPanel();
	JLabel lblMa = new JLabel("Số thẻ");
	lblMa.setPreferredSize(new Dimension(90, 20));
	JTextField txtMa = new JTextField(15);
	pnMa.add(lblMa);
	pnMa.add(txtMa);
	
	JPanel pnMatKhau = new JPanel();
	JLabel lblMatKhau = new JLabel("Mật khẩu ");
	lblMatKhau.setPreferredSize(new Dimension(90, 20));
	JTextField txtMatKhau = new JTextField(15);
	pnMatKhau.add(lblMatKhau);
	pnMatKhau.add(txtMatKhau);
	
	JPanel pnFlowDN = new JPanel();
	JButton btnDN=new JButton("Đăng nhập");
	pnFlowDN.add(btnDN);
	
	JPanel pnChuaDN = new JPanel(); 
	JLabel lblChuaDN = new JLabel("Chưa đăng nhập ");
	pnChuaDN.setPreferredSize(new Dimension(500, 500));
	Border borderChuaDN=BorderFactory.createLineBorder(Color.BLACK);
	TitledBorder borderTitleChuaDN=BorderFactory.createTitledBorder(borderChuaDN, "");
	pnChuaDN.setBorder(borderTitleChuaDN);
	pnChuaDN.add(lblChuaDN);
	
	pnMa_Pass.add(pnMa);
	pnMa_Pass.add(pnMatKhau);
	pnRutTien.add(pnMa_Pass);
	pnRutTien.add(pnFlowDN);
	pnRutTien.add(pnChuaDN);
	this.add(pnRutTien);
}

@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	
}
	
	
}
