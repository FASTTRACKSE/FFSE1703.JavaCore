
package ffse1703005.software.atm.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import ffse1703005.software.atm.model.ATMTransaction;
import ffse1703005.software.atm.model.StamentAdress;
import ffse1703005.software.atm.model.TransactionsDb;

public class LayoutTransactionATM extends JPanel{
	private static final long serialVersionUID = 1L;
	private JDateChooser  jdcFromDay,jdcToDay;
	private JComboBox<String> cboDistricts,cboWards;
	private JButton btnSearch,btnCancel;
	private JTextField txtCodeATM,txtStreets;
	private DefaultTableModel list=new DefaultTableModel();
	private final JTable tbl=new JTable(list);		
	private ArrayList<ATMTransaction> arrAtmTss = new ArrayList<>();
	private ArrayList<ATMTransaction> arrAtmAllTss = new ArrayList<>();
	private StamentAdress adress = new StamentAdress();
	private ArrayList<String> arrAdress = new ArrayList<String>();
	public LayoutTransactionATM() {
		addControlls();
		arrAdress = adress.SeclectDis();
		for(String x:arrAdress) {
			cboDistricts.addItem(x);
		}
		addEvents();
		arrAtmAllTss = TransactionsDb.getAtmTransactionList();
		updateArrAtmTss();
		printListAtmTss();
	}

	private void addControlls() {
		this.setOpaque(false);		
		
		JPanel pnMain = new JPanel();
		pnMain.setOpaque(false);	
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.X_AXIS));
		pnMain.setPreferredSize(new Dimension(1050, 587));
		pnMain.setMaximumSize(pnMain.getPreferredSize() );
		
		JPanel pnCenter = new JPanel();
		pnCenter.setOpaque(false);		
		
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
		pnCenter.setPreferredSize(new Dimension(700, 587));
		pnCenter.setMaximumSize(pnCenter.getPreferredSize() );
		
		JPanel pnSeacher = new JPanel();
		pnSeacher.setOpaque(false);
		pnSeacher.setPreferredSize(new Dimension(700, 35));
		pnSeacher.setMaximumSize(pnSeacher.getPreferredSize() );
		pnCenter.add(pnSeacher);
		
		JPanel pnList = new JPanel();
		Border titleBorderList;
		Border blueBorderList = BorderFactory.createLineBorder(Color.BLACK,2);
		titleBorderList = BorderFactory.createTitledBorder(blueBorderList,"DANH SÁCH GIAO DỊCH",
		        TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
		pnList.setBorder(titleBorderList);
		pnList.setPreferredSize(new Dimension(700,400));
		pnList.setMaximumSize(pnList.getPreferredSize() );
		
		list.addColumn("Mã Máy ATM");
		list.addColumn("Vị Trí");
		list.addColumn("Mã Khách Hàng");
		list.addColumn("Mã Giao Dịch");
		list.addColumn("Thời Gian Giao Dịch");
		list.addColumn("Số tiền Đã Rút");
				
		JScrollPane sc=new JScrollPane(tbl);		
		pnList.setLayout(new BorderLayout());
		pnList.add(sc,BorderLayout.CENTER);
		pnCenter.add(pnList);
		
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
		tbl.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
		
		pnMain.add(pnCenter);
		
		JPanel pnAction = new JPanel();
		
		pnAction.setPreferredSize(new Dimension(350, 587));
		pnAction.setMaximumSize(pnAction.getPreferredSize() );
		Border titleBorderAction;
		Border blueBorderAction = BorderFactory.createLineBorder(Color.BLACK,3);
		titleBorderAction = BorderFactory.createTitledBorder(blueBorderAction,"TÌM KIẾM THEO",
		        TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
		pnAction.setBorder(titleBorderAction);
		pnAction.setOpaque(false);
		
		
		JPanel pnInformation = new JPanel();
		pnInformation.setPreferredSize(new Dimension(340,270));
		pnInformation.setMaximumSize(pnInformation.getPreferredSize() );
		pnInformation.setLayout(new BoxLayout(pnInformation, BoxLayout.Y_AXIS));
		pnInformation.setOpaque(false);
		Border titleBorderInfor;
		Border blueBorderInfor = BorderFactory.createLineBorder(Color.GRAY);
		titleBorderInfor = BorderFactory.createTitledBorder(blueBorderInfor,"Mã Máy ATM",
		        TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
		pnInformation.setBorder(titleBorderInfor);
		pnInformation.setOpaque(false);
		
		JPanel pnInforMini = new JPanel();
		pnInforMini.setOpaque(false);
		

		JLabel lblCodeATM = new JLabel("Mã Máy ATM :");
		txtCodeATM = new JTextField(20);									
		
		JLabel lblDistricts = new JLabel("Quận :");
		cboDistricts=new JComboBox<>();
		cboDistricts.addItem("Tất Cả");
		
		JLabel lblWards = new JLabel("Phường :");
		cboWards=new JComboBox<>();
		cboWards.addItem("Tất Cả");
		
		JLabel lblStreets = new JLabel("Tên Đường :");
		txtStreets = new JTextField(20);
		
		JLabel lblFromDay = new JLabel("Từ Ngày :");
		jdcFromDay = new JDateChooser();		
		
		JLabel lblToDay = new JLabel("Đến Ngày :");
		jdcToDay = new JDateChooser();
		
		GroupLayout inforLayout = new GroupLayout(pnInforMini);
		pnInforMini.setLayout(inforLayout);
		inforLayout.setAutoCreateGaps(true);
		inforLayout.setAutoCreateContainerGaps(true);
		
		inforLayout.setHorizontalGroup(inforLayout.createSequentialGroup()
			.addGroup(inforLayout.createParallelGroup()
				.addComponent(lblCodeATM)
				.addComponent(lblDistricts)
				.addComponent(lblWards)
				.addComponent(lblStreets)
				.addComponent(lblFromDay)
				.addComponent(lblToDay)
			)
			.addGroup(inforLayout.createParallelGroup()
				.addComponent(txtCodeATM)
				.addComponent(cboDistricts)
				.addComponent(cboWards)
				.addComponent(txtStreets)
				.addComponent(jdcFromDay)
				.addComponent(jdcToDay)
			)
		);
		
		inforLayout.setVerticalGroup(inforLayout.createSequentialGroup()
			.addGroup(inforLayout.createParallelGroup()
				.addComponent(lblCodeATM)
				.addComponent(txtCodeATM)
			)
			.addGroup(inforLayout.createParallelGroup()
					.addComponent(lblDistricts)
					.addComponent(cboDistricts)
				)
			.addGroup(inforLayout.createParallelGroup()
					.addComponent(lblWards)
					.addComponent(cboWards)
				)
			.addGroup(inforLayout.createParallelGroup()
					.addComponent(lblStreets)
					.addComponent(txtStreets)
				)
			.addGroup(inforLayout.createParallelGroup()
					.addComponent(lblFromDay)
					.addComponent(jdcFromDay)
				)
			.addGroup(inforLayout.createParallelGroup()
					.addComponent(lblToDay)
					.addComponent(jdcToDay)
				)
		);							
		
		
		JPanel pnSearch = new JPanel();
		pnSearch.setOpaque(false);
		btnSearch = new JButton("Xem");										
		btnCancel = new JButton("Hủy");
		pnSearch.add(btnSearch);
		pnSearch.add(btnCancel);
		
		pnInformation.add(pnInforMini);
		pnInformation.add(pnSearch);
		
		JPanel pnBlank = new JPanel();
		pnBlank.setOpaque(false);
		pnBlank.setPreferredSize(new Dimension(340,80));
		pnBlank.setMaximumSize(pnBlank.getPreferredSize() );
		pnAction.add(pnBlank);
		
		pnAction.add(pnInformation);
		
		pnMain.add(pnAction);
		this.add(pnMain);
		
	}

	private void addEvents() {
		cboDistricts.addActionListener(eventChooseDistricts);
		tbl.addMouseListener(eventChooseRow);
		btnSearch.addActionListener(eventSearch);
		btnCancel.addActionListener(eventCancel);
	}
	
	MouseAdapter eventChooseRow = new MouseAdapter() {
    	public void mouseClicked(MouseEvent e) {
    		int col = tbl.getSelectedRow();
    		String[] row = new String[1];	    		
    		row[0] = (String) tbl.getValueAt(col, 0);  
    		txtCodeATM.setText(row[0]);    		    		
			for(int i=0;i<arrAtmTss.size();i++) {
				if(row[0].equals(arrAtmTss.get(i).getCodeATM())) {
					txtStreets.setText(arrAtmTss.get(i).getStreets());
					cboDistricts.setSelectedItem(arrAtmTss.get(i).getDistricts());
					cboWards.setSelectedItem(arrAtmTss.get(i).getWards());					
				}
			}
    	}
    };
    
    ActionListener eventSearch = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				String codeTss = txtCodeATM.getText();
				String streetTss =txtStreets.getText();			
				Calendar dayFrom = jdcFromDay.getCalendar();
				Calendar dayTo = jdcToDay.getCalendar();
				String districts = cboDistricts.getSelectedItem().toString();
				String wards = cboWards.getSelectedItem().toString();
				long dayF =dayFrom.getTimeInMillis();
				long dayT =dayTo.getTimeInMillis();
				int checkDay=(int) TimeUnit.MILLISECONDS.toDays(Math.abs(dayT - dayF));
				ArrayList<ATMTransaction> arrAtmTss = new ArrayList<>();
				if((dayT-dayF)<0) {
					String msgXoa ="Ngày Kết Thúc Phải Lớn Hơn\nNgày Bắt Đầu";
					JOptionPane.showMessageDialog(null, msgXoa, "Lỗi Thời Gian!!!", JOptionPane.INFORMATION_MESSAGE);
				}else if(checkDay>30){
					String msgXoa ="khoảng thời gian không quá 30 ngày";
					JOptionPane.showMessageDialog(null, msgXoa, "Lỗi Thời Gian!!!", JOptionPane.INFORMATION_MESSAGE);
				}else{
					if(districts.equals("Tất Cả")) {
						districts="";
						wards="";
						arrAtmTss = TransactionsDb.getAtmTransactionSearch(codeTss, streetTss, districts, wards, dayFrom, dayTo);
					}else {
						if(wards.equals("Tất Cả")) {
							wards="";
							arrAtmTss = TransactionsDb.getAtmTransactionSearch(codeTss, streetTss, districts, wards, dayFrom, dayTo);
						}else {
							arrAtmTss = TransactionsDb.getAtmTransactionSearch(codeTss, streetTss, districts, wards, dayFrom, dayTo);
						}
					}	
					list.setRowCount(0);
			    	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
					Date date = new Date();
					for (ATMTransaction tss : arrAtmTss) { 
			    		Timestamp ts = tss.getTimeTransaction();
						date.setTime(ts.getTime());
						String time = dateFormat.format(date);
						String[] row = {tss.getCodeCus(), tss.getAdressATM(), tss.getCodeATM(),tss.getCodeTransaction(),time,String.format("%,d", (long) tss.getPayTransaction())+" VNĐ"};
						list.addRow(row);
					}
				}	
			}catch (Exception e1) {
				String msgXoa ="Chưa Chọn Ngày !!!";
				JOptionPane.showMessageDialog(null, msgXoa, "Lỗi Nhập!!!", JOptionPane.INFORMATION_MESSAGE);
			}
					
		}
    };
    
    ActionListener eventCancel = new ActionListener() {
		public void actionPerformed(ActionEvent e) {			
			printListAtmTss();
			txtCodeATM.setText("");
			txtStreets.setText("");
			jdcFromDay.setCalendar(null);
			jdcToDay.setCalendar(null);
			cboDistricts.setSelectedIndex(0);
			cboWards.setSelectedIndex(0);
		}
    };
	
	ActionListener eventChooseDistricts = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
				int keys = cboDistricts.getSelectedIndex();
				if (keys==0) {
					cboWards.removeAllItems();
					cboWards.addItem("Tất Cả");
				}else {
					arrAdress = adress.SeclectWard(keys);
					cboWards.removeAllItems();
					cboWards.addItem("Tất Cả");
					for(String x:arrAdress) {					
						cboWards.addItem(x);
					}
				}	
			}
								
		
    };
	
	private ArrayList<ATMTransaction> updateArrAtmTss() {
    	return arrAtmTss = arrAtmAllTss;
    }
    
    private void printListAtmTss() {
    	list.setRowCount(0);
    	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date date = new Date();
    	for (ATMTransaction tss : arrAtmTss) { 
    		Timestamp ts = tss.getTimeTransaction();
			date.setTime(ts.getTime());
			String time = dateFormat.format(date);
			String[] row = {tss.getCodeATM(), tss.getAdressATM(), tss.getCodeCus(),tss.getCodeTransaction(),time,String.format("%,d", (long) tss.getPayTransaction())+" VNĐ"};
			list.addRow(row);
		}
    }
}
