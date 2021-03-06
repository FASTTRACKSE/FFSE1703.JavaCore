package ffse1703005.software.atm.ui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
/*tạo class LayoutATM kế thừa JPanel*/
public class LayoutATM extends JPanel {
	private static final long serialVersionUID = 1L;
	private LayoutATMManage layoutManageATM;
	private LayoutReportATM layoutATMReport;
	private LayoutTransactionATM layoutATMTransaction;
	public LayoutATM() {
		addControlls();
		addEvents();
	}
	/*tạo phương thức  addControlls */
	private void addControlls() {
		try {
			this.setOpaque(false);
			
			JPanel pnMail =new JPanel();
			pnMail.setOpaque(false);
			/*set boxlayout cho pnMail*/
			pnMail.setLayout(new BoxLayout(pnMail, BoxLayout.Y_AXIS));
			pnMail.setPreferredSize(new Dimension(1050, 587));
			pnMail.setMaximumSize(pnMail.getPreferredSize() );
			
			JPanel pnHeader=new JPanel();
			/*set boxlayout cho pnHeader*/
			pnHeader.setLayout(new BoxLayout(pnHeader, BoxLayout.X_AXIS));
			pnHeader.setPreferredSize(new Dimension(1050, 40));
			pnHeader.setMaximumSize(pnHeader.getPreferredSize() );
			
			JPanel pntitle=new JPanel();
			pntitle.setPreferredSize(new Dimension(550, 40));
			pntitle.setMaximumSize(pntitle.getPreferredSize() );
			
			pnHeader.add(pntitle);
			JPanel pnLogo=new JPanel(){ 
				/*set background image  cho pnLogo*/
				private static final long serialVersionUID = 1L;

				public void paintComponent(Graphics g) 
	            { 
	                Dimension d = getSize(); 
	                Image img=this.getToolkit().getImage("src/ffse1703005/software/atm/images/logo.png"); 
	                g.drawImage(img, 0, 0, d.width, d.height, null); 

	                setOpaque( false );  // lam trong suot  
	                super.paintComponent(g); 
	            } 
	        };
	        pnLogo.setPreferredSize(new Dimension(300, 40));
	        pnLogo.setMaximumSize(pnLogo.getPreferredSize() );
	        pnHeader.add(pnLogo);
	        
	        JPanel pnBlank=new JPanel();
	        pnBlank.setPreferredSize(new Dimension(100, 40));
	        pnBlank.setMaximumSize(pnBlank.getPreferredSize() );
	        pnHeader.add(pnBlank);
	        
			pnMail.add(pnHeader);
			
			JTabbedPane myTabled=new JTabbedPane();
			myTabled.setOpaque(false);
			
			JPanel pnTabATM=new JPanel(){ 
				/*set background image  cho pnTabATM*/
				private static final long serialVersionUID = 1L;
				public void paintComponent(Graphics g) 
	            { 
	                Dimension d = getSize(); 
	                Image img=this.getToolkit().getImage("src/ffse1703005/software/atm/images/money.png"); 
	                g.drawImage(img, 0, 0, d.width, d.height, null); 

	                setOpaque( false );  // lam trong suot  
	                super.paintComponent(g); 
	            } 
	        };        
	        pnTabATM.setOpaque(false);
	        layoutManageATM = new LayoutATMManage();
	        /*pnTabATM add layoutManageATM từ class LayoutManageATM*/
	        pnTabATM.add(layoutManageATM);
			
			JPanel pnTabReport=new JPanel(){ 
				private static final long serialVersionUID = 1L;
				/*set background image  cho pnTabReport*/
				public void paintComponent(Graphics g) 
	            { 
	                Dimension d = getSize(); 
	                Image img=this.getToolkit().getImage("src/ffse1703005/software/atm/images/money.png"); 
	                g.drawImage(img, 0, 0, d.width, d.height, null); 

	                setOpaque( false );  // lam trong suot  
	                super.paintComponent(g); 
	            } 
	        };
			pnTabReport.setOpaque(false);		
			layoutATMReport = new LayoutReportATM();
			/*pnTabATM add layoutATMReport từ class LayoutATMReport*/
			pnTabReport.add(layoutATMReport);
			
			JPanel pnTabMoney=new JPanel(){ 
				private static final long serialVersionUID = 1L;
				/*set background image  cho pnTabMoney*/
				public void paintComponent(Graphics g) 
	            { 
	                Dimension d = getSize(); 
	                Image img=this.getToolkit().getImage("src/ffse1703005/software/atm/images/money.png"); 
	                g.drawImage(img, 0, 0, d.width, d.height, null); 

	                setOpaque( false );  // lam trong suot  
	                super.paintComponent(g); 
	            } 
	        };
			pnTabMoney.setOpaque(false);
			layoutATMTransaction = new LayoutTransactionATM();
			/*pnTabATM add layoutATMTransaction từ class LayoutATMTransaction*/
			pnTabMoney.add(layoutATMTransaction);
			
			myTabled.add(pnTabATM,"Quản Lý Máy ATM");
			myTabled.add(pnTabReport,"Thống Kê Máy ATM");
			myTabled.add(pnTabMoney,"Giao Dịch Của Máy ATM");
			pnMail.add(myTabled);
			
			this.add(pnMail);
		}catch (Exception e) {
			
		}
		
	}
	
	protected JLabel getLabel(String title, String icon) {
        JLabel label = new JLabel(title);
        try {
            label.setIcon(new ImageIcon(ImageIO.read(getClass().getResource(icon))));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return label;
    }
	
	private void addEvents() {
		
	}

	
}
