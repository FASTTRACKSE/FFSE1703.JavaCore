package namdv.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import namdv.model.CheckLogin;

public class QuanLyThuVienUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTabbedPane tabbedPaneContent;
	private JLabel lblHeader;
	private JPanel header;
	private double rate = 0;

	public void showWindow() {
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		// set size tab
		double wid = (tabbedPaneContent.getSize().width) / (tabbedPaneContent.getTabCount() + rate + 0.685);
		for (int i = 0; i < tabbedPaneContent.getTabCount(); i++) {
			String name = tabbedPaneContent.getTitleAt(i);
			tabbedPaneContent.setTitleAt(i, "<html><div style='width: " + wid
					+ "px; height: 20px; font-size: 10px; text-align: center'><p style='vertical-align: middle; margin-top: 4px'>"
					+ name + "</p></div></html>");
		}
	}

	/**
	 * Create the frame.
	 */
	public QuanLyThuVienUI(String tieude) {
		super(tieude);
		addControls();
		addEvents();

		showWindow();
	}

	private void addControls() {
		Container con = getContentPane();

		// HEADER
		header = new JPanel();
		header.setPreferredSize(new Dimension(200, 45));

		lblHeader = new JLabel("Quản lý thư viện");
		header.add(lblHeader);
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setFont(new Font("Tahoma", Font.BOLD, 15));

		con.add(header, BorderLayout.NORTH);

		// CENTER
		tabbedPaneContent = new JTabbedPane(JTabbedPane.TOP);

		BanDocUI banDocUI = new BanDocUI();
		//tabbedPaneContent.addTab("Quản lý bạn đọc", banDocUI);

		SachUI sachUI = new SachUI();
		//tabbedPaneContent.addTab("Quản lý sách", sachUI);

		if (CheckLogin.getLoggedrole().equals("admin")) {
			rate = 0.825;

			MuonTraSachUI muonTraSachUI = new MuonTraSachUI();
			//tabbedPaneContent.addTab("Mượn trả sách", muonTraSachUI);

			ThongKeBaoCao thongKeBaoCao = new ThongKeBaoCao();
			//tabbedPaneContent.addTab("Thống kê báo cáo", thongKeBaoCao);
		}

		con.add(tabbedPaneContent, BorderLayout.CENTER);
	}

	private void addEvents() {
		tabbedPaneContent.addChangeListener(new SelectedTab());
	}

	private class SelectedTab implements ChangeListener {
		@Override
		public void stateChanged(ChangeEvent e) {
			int choose = tabbedPaneContent.getSelectedIndex();
			switch (choose) {
			case 0:
				lblHeader.setText("Quản lí bạn đọc");
				break;
			case 1:
				lblHeader.setText("Quản lý sách");
				break;
			case 2:
				lblHeader.setText("Quản lí mượn trả sách");
				break;
			case 3:
				lblHeader.setText("Thống kê báo cáo");
				break;
			}
		}
	}
}