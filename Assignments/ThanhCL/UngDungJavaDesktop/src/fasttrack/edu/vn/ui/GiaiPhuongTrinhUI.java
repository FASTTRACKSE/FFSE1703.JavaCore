package fasttrack.edu.vn.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GiaiPhuongTrinhUI extends JFrame {
	JTextField txtHeSoa = new JTextField(), txtHeSob = new JTextField();
	JButton btnGiai, btnThoat, btnHelp;
	JTextField txtKetqua;

	ActionListener eventNhanButtonCalc = new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			xuLyGiaiPhuongTrinh();
		}
	};

	ActionListener eventNhanButtonExit = new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			thoatChuongTrinh();
		}
	};

	public void thoatChuongTrinh() {
		System.exit(0);
	}

	public GiaiPhuongTrinhUI(String title) {
		super(title);
		addControls();
		addEvents();
	}

	protected void xuLyGiaiPhuongTrinh() {
		String hsa = txtHeSoa.getText();// lấy giá trị từ JTextField
		String hsb = txtHeSob.getText();
		double a = Double.parseDouble(hsa);
		double b = Double.parseDouble(hsb);
		if (a == 0 && b == 0) {
			// gán giá trị lên JTextField
			txtKetqua.setText("Vô số nghiệm");
		} else if (a == 0 && b != 0) {
			txtKetqua.setText("Vô nghiệm");
		} else {
			double x = -b / a;
			txtKetqua.setText("Có 1 nghiệm x=" + x);
		}
	}

	public void addEvents() {
		btnThoat.addActionListener(eventNhanButtonExit);
		btnGiai.addActionListener(eventNhanButtonCalc);
	}

	public void addControls() {
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		con.add(pnMain);

		JPanel pnTitle = new JPanel();
		pnTitle.setLayout(new FlowLayout());
		JLabel lblTieuDe = new JLabel("Giải phương trình bậc 1");
		pnTitle.add(lblTieuDe);
		pnMain.add(pnTitle);
		lblTieuDe.setForeground(Color.BLUE);
		Font fontTieuDe = new Font("arial", Font.BOLD, 20);
		lblTieuDe.setFont(fontTieuDe);
		pnTitle.setBackground(Color.RED);

		JPanel pnHeSoa = new JPanel();
		pnHeSoa.setLayout(new FlowLayout());
		JLabel lblHeSoa = new JLabel("Hệ số a:");
		txtHeSoa = new JTextField(15);
		pnHeSoa.add(lblHeSoa);
		pnHeSoa.add(txtHeSoa);
		pnMain.add(pnHeSoa);

		JPanel pnHeSob = new JPanel();
		pnHeSob.setLayout(new FlowLayout());
		JLabel lblHeSob = new JLabel("Hệ số b:");
		txtHeSob = new JTextField(15);
		pnHeSob.add(lblHeSob);
		pnHeSob.add(txtHeSob);
		pnMain.add(pnHeSob);

		JPanel pnButton = new JPanel();
		pnButton.setLayout(new FlowLayout());
		btnGiai = new JButton("Calc");
		btnThoat = new JButton("Exit");

		btnHelp = new JButton("Help");

		pnButton.add(btnGiai);
		pnButton.add(btnThoat);
		pnButton.add(btnHelp);
		pnMain.add(pnButton);

		JPanel pnKetQua = new JPanel();
		pnKetQua.setLayout(new FlowLayout());
		JLabel lblKetQua = new JLabel("Kết quả :");
		txtKetqua = new JTextField(15);
		pnKetQua.add(lblKetQua);
		pnKetQua.add(txtKetqua);
		pnMain.add(pnKetQua);
	}

	class HelpEvent implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "Bài toán giải phương trình kinh điển");
		}

	}

	public void showWindow() {
		this.setSize(400, 250);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}