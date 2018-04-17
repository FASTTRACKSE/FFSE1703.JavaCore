package fasttrack.edu.vn.ui;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MayTinhCuaToiUI extends JFrame {
	JTextField txtSoA, txtSoB;
	JButton btnCong, btnTru, btnThoat;
	JTextField txtKetqua;

	ActionListener eventCong = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			congHaiSo();
		}
	};

	ActionListener eventTru = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			truHaiSo();
		}
	};

	public void congHaiSo() {
		txtKetqua.setText("Cong day a?");
	}

	public void truHaiSo() {
		txtKetqua.setText("Tru day a?");
	}

	public MayTinhCuaToiUI(String tieude) {
		super(tieude);

		addControls();

		addEvents();
	}

	public void addControls() {
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		JPanel pnTitle = new JPanel();
		JLabel lblTitle = new JLabel("May Tinh Cua Toi");
		Font fontTitle = new Font("Arial", Font.BOLD, 20);
		lblTitle.setFont(fontTitle);

		pnTitle.add(lblTitle);

		JPanel pnInput1 = new JPanel();
		JLabel lblTitle1 = new JLabel("Nhập số a:");
		JTextField txtHeSoA = new JTextField(15);
		pnInput1.add(lblTitle1);
		pnInput1.add(txtHeSoA);

		JPanel pnInput2 = new JPanel();
		JLabel lblTitle2 = new JLabel("Nhập số b:");
		JTextField txtHeSoB = new JTextField(15);
		pnInput2.add(lblTitle2);
		pnInput2.add(txtHeSoB);

		JPanel pnAction = new JPanel();
		btnCong = new JButton("Cong");
		btnTru = new JButton("Tru");
		btnThoat = new JButton("Thoat");
		pnAction.add(btnCong);
		pnAction.add(btnTru);
		pnAction.add(btnThoat);

		JPanel pnResult = new JPanel();
		JLabel lblTitleResult = new JLabel("Ket qua: ");
		txtKetqua = new JTextField(15);
		pnResult.add(lblTitleResult);
		pnResult.add(txtKetqua);

		pnMain.add(pnTitle);
		pnMain.add(pnInput1);
		pnMain.add(pnInput2);
		pnMain.add(pnAction);
		pnMain.add(pnResult);

		con.add(pnMain);

	}

	public void addEvents() {
		btnCong.addActionListener(eventCong);
		btnTru.addActionListener(eventTru);
		
		btnThoat.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

	}

	public void showWindow() {
		this.setSize(600, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

}
