package ffse1703005.software.atm.ui;

import java.awt.Dimension; 
import java.awt.Graphics; 
import java.awt.Image; 

import javax.swing.JButton; 
import javax.swing.JFrame; 
import javax.swing.JPanel; 


public class BackgroundDemo extends JFrame{  
	private static final long serialVersionUID = 1L;
    public BackgroundDemo(String name){ 
        super(name);     
        setSize(600, 400); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        //setLayout(new FlowLayout(FlowLayout.CENTER)); 
         
        JPanel panel = new JPanel(){             
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) 
            { 
                Dimension d = getSize(); 
                Image img=this.getToolkit().getImage("bg.jpg"); 
                g.drawImage(img, 0, 0, d.width, d.height, null); 

                setOpaque( false );   /*lam trong suot*/  
                super.paintComponent(g); 
            } 
        }; 
         
        JButton b1= new JButton("hello1"); 
        JButton b2= new JButton("hello2"); 
        panel.add(b1); 
        panel.add(b2); 
        add(panel); 
        setVisible(true);
    } 
    public static void main(String []acon){ 
        new BackgroundDemo("Demo Background"); 
    }
    
}
