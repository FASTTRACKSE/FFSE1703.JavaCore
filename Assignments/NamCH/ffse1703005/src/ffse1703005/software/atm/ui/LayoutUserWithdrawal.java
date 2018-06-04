package ffse1703005.software.atm.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
/*tạo class LayoutUserWithdrawal kế thừa JPanel*/
public class LayoutUserWithdrawal extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField txtMoney;
	private JButton btnSubmit,btnCancel;
	
	public JTextField getTxtMoney() {
		return txtMoney;
	}

	public JButton getBtnSubmit() {
		return btnSubmit;
	}

	public LayoutUserWithdrawal(String codeATM) {
		addControlls(codeATM);
		addEvents();
	}
	
	private void addControlls(String codeATM) {
		try {
			/*set Boxlayout cho class*/
			this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			this.setOpaque(false);
			JPanel pnMain = new JPanel();
			/*set Boxlayout cho pnMain*/
			pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
			pnMain.setPreferredSize(new Dimension(650, 587));
			pnMain.setMaximumSize(pnMain.getPreferredSize() );
			pnMain.setOpaque(false);
			
			JPanel pnTitle = new JPanel();
			pnTitle.setPreferredSize(new Dimension(650, 180));
			pnTitle.setMaximumSize(pnTitle.getPreferredSize() );
			pnTitle.setOpaque(false);
			JLabel lblTitle = new JLabel("HỆ THỐNG RÚT TIỀN TP_BANK");
			Font font=new Font("Arial", Font.BOLD,25);
			lblTitle.setFont(font);
			lblTitle.setForeground(Color.RED	);
			pnTitle.add(lblTitle);
			JLabel lblReport = new JLabel("Lưu ý trong máy chỉ còn tiền mệnh giá 10.000 VNĐ,20.000 VNĐ,50.000VNĐ");
			JLabel lblReport1 = new JLabel("100.000 VNĐ,200.000 VNĐ,500.000 VNĐ");
			JPanel pnNameATM = new JPanel();
			pnNameATM.setPreferredSize(new Dimension(650, 20));
			pnNameATM.setMaximumSize(pnNameATM.getPreferredSize() );
			pnNameATM.setOpaque(false);
			JLabel lblNameATM = new JLabel("Đang Rút Tại Máy : "+codeATM);
			lblNameATM.setForeground(Color.BLUE	);
			pnNameATM.add(lblNameATM);
			pnTitle.add(lblReport);
			pnTitle.add(lblReport1);
			pnTitle.add(pnNameATM);
			
			JPanel pnWithDrawal = new JPanel();
			pnWithDrawal.setPreferredSize(new Dimension(350, 150));
			pnWithDrawal.setMaximumSize(pnWithDrawal.getPreferredSize() );
			pnWithDrawal.setBackground(Color.WHITE);
			/*set Border cho pnWithDrawal*/
			Border titleBorderAction;
			Border blueBorderAction = BorderFactory.createLineBorder(Color.BLACK,3);
			titleBorderAction = BorderFactory.createTitledBorder(blueBorderAction,"",
			        TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
			pnWithDrawal.setBorder(titleBorderAction);
			
			JPanel pnMoney = new JPanel();
			pnMoney.setPreferredSize(new Dimension(350, 50));
			pnMoney.setMaximumSize(pnMoney.getPreferredSize() );
			pnMoney.setOpaque(false);
			
			JLabel lblMoney = new JLabel("Nhập Số Tiền Muốn Rút");
			txtMoney = new JTextField(20);
			pnMoney.add(lblMoney);
			pnMoney.add(txtMoney);
			
			JPanel pnNote = new JPanel();
			pnNote.setPreferredSize(new Dimension(350, 40));
			pnNote.setMaximumSize(pnNote.getPreferredSize() );
			pnNote.setOpaque(false);
			JLabel lblNote1 = new JLabel("Rút Tối Đa 3 Lần Mỗi Ngày");
			JLabel lblNote2 = new JLabel("Mỗi Lần Rút Không Quá 5.000.000 VNĐ");
			lblNote1.setFont(new Font("Courier New", Font.ITALIC, 12));
			lblNote1.setForeground(Color.DARK_GRAY);
			lblNote2.setFont(new Font("Courier New", Font.ITALIC, 12));
			lblNote2.setForeground(Color.DARK_GRAY);
			pnNote.add(lblNote1);
			pnNote.add(lblNote2);
			
			JPanel pnSubmit = new JPanel();
			pnSubmit.setPreferredSize(new Dimension(650, 50));
			pnSubmit.setMaximumSize(pnSubmit.getPreferredSize() );
			pnSubmit.setOpaque(false);
			btnSubmit = new JButton("Rút Tiền");
			btnCancel = new JButton("Hủy");
			pnSubmit.add(btnSubmit);
			pnSubmit.add(btnCancel);
			
			pnWithDrawal.add(pnMoney);
			pnWithDrawal.add(pnNote);
			pnWithDrawal.add(pnSubmit);
			
			pnMain.add(pnTitle);
			pnMain.add(pnWithDrawal);
			this.add(pnMain);
		}catch (Exception e) {
			
		}		
	}

	private void addEvents() {
		btnCancel.addActionListener(eventCancel);
	}
	/*set các giá trị về trống*/
	ActionListener eventCancel = new ActionListener() {		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			txtMoney.setText("");
		}
		
	};
}
