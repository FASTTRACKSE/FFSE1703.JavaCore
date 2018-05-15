package ffse1703005.software.atm.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

public class LayoutUserHistory extends JPanel{
	private static final long serialVersionUID = 1L;

	public LayoutUserHistory() {
		addControlls();
		addEvents();
	}

	private void addControlls() {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.setOpaque(false);
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		pnMain.setPreferredSize(new Dimension(650, 587));
		pnMain.setMaximumSize(pnMain.getPreferredSize() );
		pnMain.setOpaque(false);
		
		JPanel pnTitle = new JPanel();		
		pnTitle.setPreferredSize(new Dimension(650, 80));
		pnTitle.setMaximumSize(pnTitle.getPreferredSize() );
		pnTitle.setOpaque(false);
		JLabel lblTitle = new JLabel("LỊCH SỬ GIAO DỊCH CỦA BẠN");
		Font font=new Font("Arial", Font.BOLD,25);
		lblTitle.setFont(font);
		lblTitle.setForeground(Color.RED	);
		pnTitle.add(lblTitle);		
		JPanel pnNameATM = new JPanel();
		pnNameATM.setPreferredSize(new Dimension(650, 20));
		pnNameATM.setMaximumSize(pnNameATM.getPreferredSize() );
		pnNameATM.setOpaque(false);
		JLabel lblNameATM = new JLabel("Kiểm Tra Tại Máy : ");
		lblNameATM.setForeground(Color.BLUE	);
		pnNameATM.add(lblNameATM);
		pnTitle.add(pnNameATM);						
		
		JPanel pnSearch = new JPanel();
		pnSearch.setPreferredSize(new Dimension(650, 50));
		pnSearch.setMaximumSize(pnSearch.getPreferredSize() );
		pnSearch.setBackground(Color.WHITE);
		Border titleBorderAction;
		Border blueBorderAction = BorderFactory.createLineBorder(Color.BLACK,3);
		titleBorderAction = BorderFactory.createTitledBorder(blueBorderAction,"",
		        TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
		pnSearch.setBorder(titleBorderAction);
		
		JPanel pnFromDay = new JPanel();
		pnFromDay.setOpaque(false);
		JLabel lblFromDay= new JLabel("Từ Ngày");
		JDateChooser jdcFrom = new JDateChooser();
		pnFromDay.add(lblFromDay);
		pnFromDay.add(jdcFrom);
		pnSearch.add(pnFromDay);
		
		JPanel pnToDay = new JPanel();
		pnToDay.setOpaque(false);
		JLabel lblToDay= new JLabel("Từ Ngày");
		JDateChooser jdcTo = new JDateChooser();
		pnToDay.add(lblToDay);
		pnToDay.add(jdcTo);
		pnSearch.add(pnToDay);
		
		JPanel pnAction = new JPanel();
		pnAction.setOpaque(false);
		JButton btnSearch = new JButton("Xem");
		JButton btnCancel = new JButton("Hủy");
		pnAction.add(btnSearch);
		pnAction.add(btnCancel);
		pnSearch.add(pnAction);
		
		JPanel pnList = new JPanel();
		pnList.setPreferredSize(new Dimension(650, 430));
		pnList.setMaximumSize(pnList.getPreferredSize() );
		pnList.setBackground(Color.WHITE);
		Border titleBorderActionList;
		Border blueBorderActionList = BorderFactory.createLineBorder(Color.BLACK,0);
		titleBorderActionList = BorderFactory.createTitledBorder(blueBorderActionList,"",
		        TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
		pnList.setBorder(titleBorderActionList);
		
		
		pnMain.add(pnTitle);
		pnMain.add(pnSearch);
		pnMain.add(pnList);
		this.add(pnMain);
	}

	private void addEvents() {
		
	}
}
