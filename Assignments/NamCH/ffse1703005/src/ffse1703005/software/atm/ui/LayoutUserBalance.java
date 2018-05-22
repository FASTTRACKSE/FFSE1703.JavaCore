package ffse1703005.software.atm.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class LayoutUserBalance extends JPanel {
	private static final long serialVersionUID = 1L;

	public LayoutUserBalance(String codeATM,int balance) {
		addControlls(codeATM,balance);
		addEvents();
	}

	private void addControlls(String codeATM,int balance) {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.setOpaque(false);
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		pnMain.setPreferredSize(new Dimension(650, 587));
		pnMain.setMaximumSize(pnMain.getPreferredSize() );
		pnMain.setOpaque(false);
		
		JPanel pnTitle = new JPanel();		
		pnTitle.setPreferredSize(new Dimension(650, 200));
		pnTitle.setMaximumSize(pnTitle.getPreferredSize() );
		pnTitle.setOpaque(false);
		JLabel lblBlankTitle = new JLabel("                                                               ");
		pnTitle.add(lblBlankTitle);
		JLabel lblTitle = new JLabel("SỐ DƯ TRONG TÀI KHOẢNG CỦA BẠN");
		Font font=new Font("Arial", Font.BOLD,25);
		lblTitle.setFont(font);
		lblTitle.setForeground(Color.RED	);
		pnTitle.add(lblTitle);		
		JPanel pnNameATM = new JPanel();
		pnNameATM.setPreferredSize(new Dimension(650, 20));
		pnNameATM.setMaximumSize(pnNameATM.getPreferredSize() );
		pnNameATM.setOpaque(false);
		JLabel lblNameATM = new JLabel("Kiểm Tra Tại Máy : "+codeATM);
		lblNameATM.setForeground(Color.BLUE	);
		pnNameATM.add(lblNameATM);
		pnTitle.add(pnNameATM);
		
		JPanel pnWithDrawal = new JPanel();
		pnWithDrawal.setPreferredSize(new Dimension(350, 100));
		pnWithDrawal.setMaximumSize(pnWithDrawal.getPreferredSize() );
		pnWithDrawal.setBackground(Color.WHITE);
		Border titleBorderAction;
		Border blueBorderAction = BorderFactory.createLineBorder(Color.BLACK,3);
		titleBorderAction = BorderFactory.createTitledBorder(blueBorderAction,"",
		        TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
		pnWithDrawal.setBorder(titleBorderAction);
		
		JPanel pnBalance = new JPanel();
		pnBalance.setPreferredSize(new Dimension(350, 50));
		pnBalance.setMaximumSize(pnBalance.getPreferredSize() );
		pnBalance.setOpaque(false);
		
		JLabel lblBalance = new JLabel("Số Tiền Trong Tài Khoảng Của Bạn");
		JTextField txtBalance = new JTextField(20);
//		NumberFormat balanceFormat = NumberFormat.getNumberInstance();
//		txtBalance = new JFormattedTextField(balanceFormat);
		String balanceS = String.format("%,d", (long) balance)+" VNĐ";
		txtBalance.setText(balanceS);
		txtBalance.setEditable(false);
		pnBalance.add(lblBalance);
		pnBalance.add(txtBalance);
				
		JPanel pnBlankBalance = new JPanel();
		pnBlankBalance.setPreferredSize(new Dimension(350, 10));
		pnBlankBalance.setMaximumSize(pnBlankBalance.getPreferredSize() );
		pnBlankBalance.setOpaque(false);
		pnWithDrawal.add(pnBlankBalance);
		pnWithDrawal.add(pnBalance);
		
		pnMain.add(pnTitle);
		pnMain.add(pnWithDrawal);
		this.add(pnMain);
	}

	private void addEvents() {
		
	}
}
