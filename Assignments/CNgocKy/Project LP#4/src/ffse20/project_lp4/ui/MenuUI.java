package ffse20.project_lp4.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class MenuUI extends JFrame {

	public MenuUI(String title) {
		super(title);
		addControls();
		// addEvents();
	}

	public void addControls() {
		this.setResizable(false);
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		JPanel pnTitle = new JPanel();

		pnTitle.add(new JLabel(new ImageIcon("image/ffse.png")));

		pnTitle.setBackground(new Color(255, 255, 255));
		
		pnTitle.setMaximumSize(new Dimension(1200, 70));

		JPanel pnGroup1 = new JPanel();
		pnGroup1.setLayout(new BoxLayout(pnGroup1, BoxLayout.X_AXIS));
		JPanel pnAction = new JPanel();
		ImageIcon iconView = new ImageIcon("image/");
		Image getIconView = iconView.getImage();
		Image newIconView = getIconView.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newIconView);
		JButton btnQlkh = new JButton("QUẢN LÝ LỚP HỌC", newIcon);
		btnQlkh.setFocusPainted(false);
		pnAction.add(btnQlkh);
		pnGroup1.add(pnAction);

		JPanel pnGroup = new JPanel();
		pnGroup.setLayout(new BoxLayout(pnGroup, BoxLayout.X_AXIS));
		JPanel pnAction1 = new JPanel();
		ImageIcon iconView1 = new ImageIcon("image/");
		Image getIconView1 = iconView1.getImage();
		Image newIconView1 = getIconView1.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon1 = new ImageIcon(newIconView1);
		JButton btnQlbl = new JButton("QUẢN LÝ SINH VIÊN           ", newIcon1);
		pnAction1.add(btnQlbl);
		pnGroup.add(pnAction1);

		JPanel pnGroup2 = new JPanel();
		pnGroup2.setLayout(new BoxLayout(pnGroup2, BoxLayout.X_AXIS));

		JPanel pnAction2 = new JPanel();
		ImageIcon iconView2 = new ImageIcon("image/khach.png");
		Image getIconView2 = iconView2.getImage();
		Image newIconView2 = getIconView2.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon2 = new ImageIcon(newIconView2);
		JButton btnBckh = new JButton("QUẢN LÝ MÔN HỌC", newIcon2);
		pnAction2.add(btnBckh);
		pnGroup2.add(pnAction2);

		JPanel pnGroup3 = new JPanel();
		pnGroup3.setLayout(new BoxLayout(pnGroup3, BoxLayout.X_AXIS));
		JPanel pnAction3 = new JPanel();
		ImageIcon iconView3 = new ImageIcon("image/hoa1.png");
		Image getIconView3 = iconView3.getImage();
		Image newIconView3 = getIconView3.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon3 = new ImageIcon(newIconView3);
		JButton btnBctd = new JButton("QUẢNG LÝ ĐIỂM", newIcon3);
		pnAction3.add(btnBctd);

		pnGroup3.add(pnAction3);

		// JPanel pnAction4 = new JPanel();
		// ImageIcon iconView4 = new ImageIcon("image/logout.png");
		// Image getIconView4 = iconView4.getImage();
		// Image newIconView4 = getIconView4.getScaledInstance(40, 40,
		// java.awt.Image.SCALE_SMOOTH);
		// ImageIcon newIcon4 = new ImageIcon(newIconView4);
		// JButton btnLogout = new JButton(newIcon4);
		// btnLogout.setContentAreaFilled(false);
		// btnLogout.setBorderPainted(false);
		// pnAction4.add(btnLogout);
		//

		pnMain.add(Box.createRigidArea(new Dimension(30, 20)));
		pnMain.add(pnTitle);
		//pnMain.add(Box.createRigidArea(new Dimension(30, 30)));

		pnMain.add(pnGroup1);
		pnMain.add(pnGroup2);
		pnMain.add(pnGroup);
		pnMain.add(pnAction3);
		con.add(pnMain);
	}

	public void showWindow() {
		this.setSize(1200, 750);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
