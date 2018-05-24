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
/*tạo class LayoutCustomer kế thừa JPanel*/
public class LayoutCustomer extends JPanel {	
	private static final long serialVersionUID = 1L;
	private LayoutCustomerManage layoutCusManage;
	private LayoutReportCus layoutCusReport;
	private LayoutTransactionCus layoutCusTransaction;
	private LayoutRechargeCus layoutCusRecharge;
	public LayoutCustomer() {
		addControlls();
		addEvents();
	}

	private void addControlls() {
		try {
			this.setOpaque(false);
			
			JPanel pnMail =new JPanel();
			pnMail.setOpaque(false);
			/*set BoxLayout cho pnMail*/
			pnMail.setLayout(new BoxLayout(pnMail, BoxLayout.Y_AXIS));
			pnMail.setPreferredSize(new Dimension(1050, 587));
			pnMail.setMaximumSize(pnMail.getPreferredSize() );
			
			JPanel pnHeader=new JPanel();
			/*set BoxLayout cho pnHeader*/
			pnHeader.setLayout(new BoxLayout(pnHeader, BoxLayout.X_AXIS));
			pnHeader.setPreferredSize(new Dimension(1050, 45));
			pnHeader.setMaximumSize(pnHeader.getPreferredSize() );
			
			JPanel pntitle=new JPanel();
			pntitle.setPreferredSize(new Dimension(550, 45));
			pntitle.setMaximumSize(pntitle.getPreferredSize() );
			
			pnHeader.add(pntitle);
			JPanel pnLogo=new JPanel(){ 
				/*set Background image cho pnHeader*/
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
	        pnLogo.setPreferredSize(new Dimension(300, 45));
	        pnLogo.setMaximumSize(pnLogo.getPreferredSize() );
	        pnHeader.add(pnLogo);
	        
	        JPanel pnBlank=new JPanel();
	        pnBlank.setPreferredSize(new Dimension(100, 45));
	        pnBlank.setMaximumSize(pnBlank.getPreferredSize() );
	        pnHeader.add(pnBlank);
	        
			pnMail.add(pnHeader);
			
			JTabbedPane myTabled=new JTabbedPane();
			myTabled.setOpaque(false);
			
			JPanel pnTabCustomer=new JPanel(){ 
				/*set Background image cho pnTabCustomer*/
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
			pnTabCustomer.setOpaque(false);
			layoutCusManage = new LayoutCustomerManage();
			/*pnTabCustomer add layoutCusManage của class LayoutCusManage*/
			pnTabCustomer.add(layoutCusManage);
			
			JPanel pnTabReport=new JPanel(){ 
				/*set Background image cho pnTabReport*/
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
			pnTabReport.setOpaque(false);
			layoutCusReport = new LayoutReportCus();
			/*pnTabReport add layoutCusReport của class LayoutCusReport*/
			pnTabReport.add(layoutCusReport);
			
			
			JPanel pnTabMoney=new JPanel(){ 
				private static final long serialVersionUID = 1L;
				/*set Background image cho pnTabMoney*/
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
			layoutCusTransaction = new LayoutTransactionCus();
			/*pnTabMoney add layoutCusTransaction của class LayoutCusTransaction*/
			pnTabMoney.add(layoutCusTransaction);
			
			JPanel pnRecharge=new JPanel(){ 
				private static final long serialVersionUID = 1L;
				/*set Background image cho pnRecharge*/
				public void paintComponent(Graphics g) 
	            { 
	                Dimension d = getSize(); 
	                Image img=this.getToolkit().getImage("src/ffse1703005/software/atm/images/money.png"); 
	                g.drawImage(img, 0, 0, d.width, d.height, null); 

	                setOpaque( false );  // lam trong suot  
	                super.paintComponent(g); 
	            } 
	        };
	        pnRecharge.setOpaque(false);
	        layoutCusRecharge = new LayoutRechargeCus();
	        /*pnRecharge add layoutCusRecharge của class LayoutCusRecharge*/
			pnRecharge.add(layoutCusRecharge);
			
			/*myTabled Add JTabbedPane*/
			myTabled.add(pnTabCustomer,"Quản Lý Khách Hàng");
			myTabled.add(pnTabReport,"Thống Kê Khách Hàng");
			myTabled.add(pnRecharge,"Nạp Tiền Cho Khách Hàng");
			myTabled.add(pnTabMoney,"Giao Dịch Của Khách Hàng");
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
