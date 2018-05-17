package ffse1703005.software.atm.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import ffse1703005.software.atm.model.CusTransaction;
import ffse1703005.software.atm.model.TransactionsDb;

public class LayoutUserHistory extends JPanel{
	private static final long serialVersionUID = 1L;
	private String codeCus;
	private JDateChooser jdcFromDay,jdcToDay ;
	private JButton btnSearch,btnCancel,btnClearList,btnUpdate;
	private DefaultTableModel list =new DefaultTableModel();;
	private final JTable tbl=new JTable(list);
	private ArrayList<CusTransaction> arrCusTss = new ArrayList<CusTransaction>();
	public LayoutUserHistory(String codeCus,String codeATM) {
		this.codeCus=codeCus;
		arrCusTss = TransactionsDb.getSearchCusList(codeCus);
		addControlls(codeATM);
		addEvents();
	}

	private void addControlls(String codeATM) {
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
		JLabel lblNameATM = new JLabel("Kiểm Tra Tại Máy : "+codeATM);
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
		jdcFromDay = new JDateChooser();
		pnFromDay.add(lblFromDay);
		pnFromDay.add(jdcFromDay);
		pnSearch.add(pnFromDay);
		
		JPanel pnToDay = new JPanel();
		pnToDay.setOpaque(false);
		JLabel lblToDay= new JLabel("Từ Ngày");
		jdcToDay = new JDateChooser();
		pnToDay.add(lblToDay);
		pnToDay.add(jdcToDay);
		pnSearch.add(pnToDay);
		
		JPanel pnAction = new JPanel();
		pnAction.setOpaque(false);
		btnSearch = new JButton("Xem");
		btnCancel = new JButton("Hủy");
		btnUpdate = new JButton("Cập Nhập");
		pnAction.add(btnSearch);
		pnAction.add(btnCancel);
		pnAction.add(btnUpdate);
		pnSearch.add(pnAction);
		
		JPanel pnAllList = new JPanel();
		pnAllList.setOpaque(false);
		
		JPanel pnList = new JPanel();
		pnList.setPreferredSize(new Dimension(650, 250));
		pnList.setMaximumSize(pnList.getPreferredSize() );
		pnList.setBackground(Color.WHITE);
		Border titleBorderActionList;
		Border blueBorderActionList = BorderFactory.createLineBorder(Color.BLACK,0);
		titleBorderActionList = BorderFactory.createTitledBorder(blueBorderActionList,"",
		        TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
		pnList.setBorder(titleBorderActionList);
		list.addColumn("Mã Giao Dịch");
		list.addColumn("Thời Gian Giao Dịch");
		list.addColumn("Số Tiền");
		list.addColumn("Tình Trạng");
		tbl.setOpaque(true);
		tbl.setFillsViewportHeight(true);
		tbl.setBackground(Color.WHITE);
		JScrollPane sc=new JScrollPane(tbl);		
		pnList.setLayout(new BorderLayout());
		pnList.add(sc,BorderLayout.CENTER);
		
		pnAllList.add(pnList);
		
		JPanel pnClearList = new JPanel();
		pnClearList.setOpaque(true);
		btnClearList = new JButton("Xóa Danh Sách");
		btnClearList.setEnabled(false);
		pnClearList.add(btnClearList);
		pnAllList.add(pnClearList);
		
		pnMain.add(pnTitle);
		pnMain.add(pnSearch);
		pnMain.add(pnAllList);
		this.add(pnMain);
	}

	private void addEvents() {
		btnSearch.addActionListener(eventSearch);
		btnCancel.addActionListener(eventCancel);
		btnUpdate.addActionListener(eventUpdate);
		btnClearList.addActionListener(eventClearList);
	}
	
	 ActionListener eventUpdate = new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				arrCusTss = TransactionsDb.getSearchCusList(codeCus);
				String msgXoa ="Cập Nhập Thành Công Dữ Liệu Mới Nhất !!!";
				JOptionPane.showMessageDialog(null, msgXoa, "Cập Nhập Dữ Liệu!!!", JOptionPane.INFORMATION_MESSAGE);
			}
	    };
	    
	    ActionListener eventClearList = new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				list.setRowCount(0);
				btnClearList.setEnabled(false);
			}
	    };
	
	ActionListener eventSearch = new ActionListener() {
		public void actionPerformed(ActionEvent e) {	
			try {				
				Calendar dayFrom=null,dayTo=null;
				long dayF = 0,dayT=0;
				int checkDay=0;
				try {
					dayFrom = jdcFromDay.getCalendar();
					dayTo = jdcToDay.getCalendar();	
					Calendar checkFrom = Calendar.getInstance();
					Calendar checkTo = Calendar.getInstance();
					if(checkTo.getTimeInMillis()<dayTo.getTimeInMillis()&&checkFrom.getTimeInMillis()<dayFrom.getTimeInMillis()) {
			    		dayTo = Calendar.getInstance();
			    		dayFrom = Calendar.getInstance();
			    		jdcFromDay.setCalendar(checkFrom);
			    		jdcToDay.setCalendar(checkTo);
			    	}else if(checkFrom.getTimeInMillis()<dayFrom.getTimeInMillis()) {
			    		dayFrom = Calendar.getInstance();
			    		jdcFromDay.setCalendar(checkFrom);    		
			    	}else if(checkTo.getTimeInMillis()<dayTo.getTimeInMillis()) {
			    		dayTo = Calendar.getInstance();
			    		jdcToDay.setCalendar(checkTo);
			        }
					dayF =dayFrom.getTimeInMillis();
					dayT =dayTo.getTimeInMillis();
					checkDay=(int) TimeUnit.MILLISECONDS.toDays(Math.abs(dayT - dayF));
				}catch (Exception e1) {
					
				}					
				
				if(dayFrom==null&&dayTo==null) {					
					dayTo = Calendar.getInstance();
					dayFrom = Calendar.getInstance();
					dayFrom.add(Calendar.DATE, -30);
					jdcFromDay.setCalendar(dayFrom);
					jdcToDay.setCalendar(dayTo);
					searchTss(dayFrom,dayTo);
				}else if(dayFrom==null){
					dayTo = jdcToDay.getCalendar();
					dayFrom = jdcToDay.getCalendar();
					dayFrom.add(Calendar.DATE, -30);
					jdcFromDay.setCalendar(dayFrom);
					searchTss(dayFrom,dayTo);
				}else if(dayTo==null){
					dayFrom = jdcFromDay.getCalendar();
					dayTo = Calendar.getInstance();
					jdcToDay.setCalendar(dayTo);
					
					searchTss(dayFrom,dayTo);
				}else {
					
					if((dayT-dayF)<0) {
						String msgXoa ="Ngày Kết Thúc Phải Lớn Hơn\nNgày Bắt Đầu";
						JOptionPane.showMessageDialog(null, msgXoa, "Lỗi Thời Gian!!!", JOptionPane.INFORMATION_MESSAGE);
					}else if(checkDay>30){
						String msgXoa ="khoảng thời gian không quá 30 ngày";
						JOptionPane.showMessageDialog(null, msgXoa, "Lỗi Thời Gian!!!", JOptionPane.INFORMATION_MESSAGE);
					}else{
						
						searchTss(dayFrom,dayTo);
					}
				}
				
			}catch (Exception e1) {
				String msgXoa ="Chưa Chọn Ngày !!!";
				JOptionPane.showMessageDialog(null, msgXoa, "Lỗi Nhập!!!", JOptionPane.INFORMATION_MESSAGE);
			}													
		}
    };
    
    public void searchTss(Calendar dayFrom,Calendar dayTo) {
    	Calendar checkFrom = Calendar.getInstance();
		Calendar checkTo = Calendar.getInstance();
		if(checkTo.getTimeInMillis()<dayTo.getTimeInMillis()&&checkFrom.getTimeInMillis()<dayFrom.getTimeInMillis()) {
    		dayTo = Calendar.getInstance();
    		dayFrom = Calendar.getInstance();
    		jdcFromDay.setCalendar(checkFrom);
    		jdcToDay.setCalendar(checkTo);
    	}else if(checkFrom.getTimeInMillis()<dayFrom.getTimeInMillis()) {
    		dayFrom = Calendar.getInstance();
    		jdcFromDay.setCalendar(checkFrom);    		
    	}else if(checkTo.getTimeInMillis()<dayTo.getTimeInMillis()) {
    		dayTo = Calendar.getInstance();
    		jdcToDay.setCalendar(checkTo);
        } 
		
		getListSearch(dayFrom,dayTo);
					
    	
    	
    }
    
    public void getListSearch(Calendar dayFrom,Calendar dayTo){
    	btnClearList.setEnabled(false);
    	list.setRowCount(0);
    	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date date = new Date();
		dayFrom.set(dayFrom.get(Calendar.YEAR), dayFrom.get(Calendar.MONTH), dayFrom.get(Calendar.DATE), 0, 0);
		dayTo.set(dayTo.get(Calendar.YEAR), dayTo.get(Calendar.MONTH), dayTo.get(Calendar.DATE), 23, 59);
		for(CusTransaction tss:arrCusTss) {
    		Timestamp ts = tss.getTimeTransaction();
			date.setTime(ts.getTime());
			String time = dateFormat.format(date);
			Calendar calendar2 = Calendar.getInstance();
		    calendar2.setTime(ts);			
    		if(calendar2.getTime().after(dayFrom.getTime()) && calendar2.getTime().before(dayTo.getTime())) {    			
    			String[] row = {tss.getCodeTransaction(),time,String.format("%,d", (long) tss.getPayTransaction())+" VNĐ",tss.getStatus()};
    			list.addRow(row);
    			btnClearList.setEnabled(true);
    		}
    	}    	
    }
    
    ActionListener eventCancel = new ActionListener() {
		public void actionPerformed(ActionEvent e) {			
			jdcFromDay.setCalendar(null);
			jdcToDay.setCalendar(null);
		}
    };
}
