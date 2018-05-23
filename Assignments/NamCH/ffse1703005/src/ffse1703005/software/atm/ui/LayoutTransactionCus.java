
package ffse1703005.software.atm.ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

import ffse1703005.software.atm.model.CusTransaction;
import ffse1703005.software.atm.model.StamentAdress;
import ffse1703005.software.atm.model.TransactionsDb;
/*tạo class LayoutTransactionATM kế thừa JPanel*/
public class LayoutTransactionCus extends JPanel{
	private static final long serialVersionUID = 1L;
	private JPanel pnAllChoosDay;
	private CardLayout layout;
	private JRadioButton rdoMonth,rdoDay;
	private JComboBox<String> cboDistricts,cboWards;
	private JDateChooser  jdcFromDay,jdcToDay ;
	private JMonthChooser jmcMonth;
	private JYearChooser  jycYear;
	private JButton btnSearch,btnCancel,btnSearchMonth,btnCancelMonth,btnClearList,btnUpdate,btnUpdateMonth;
	private JTextField txtCodeCus,txtStreets,txtDetailRecharge,txtWithdrawal;
	private DefaultTableModel list=new DefaultTableModel();
	private final JTable tbl=new JTable(list);
	private ArrayList<String> arrAdress = new ArrayList<String>();
	private StamentAdress adress = new StamentAdress();
	private ArrayList<CusTransaction> arrCusTss = new ArrayList<>();
	private ArrayList<CusTransaction> arrAllCusTss = new ArrayList<>();
	public LayoutTransactionCus() {
		addControlls();
		/*Lấy giá trị quận truyền vào combobox từ phương thức SeclectDis của class StamentAdress*/
		arrAdress = adress.SeclectDis();
		for(String x:arrAdress) {
			cboDistricts.addItem(x);
		}
		addEvents();
		arrAllCusTss = TransactionsDb.getCusTransactionList();
		arrCusTss=updateArrCusTss();		
	}

	private void addControlls() {
		try {
			this.setOpaque(false);				
			JPanel pnMain = new JPanel();
			pnMain.setOpaque(false);	
			/*set BoxLayout cho pnMain*/
			pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.X_AXIS));
			pnMain.setPreferredSize(new Dimension(1050, 587));
			pnMain.setMaximumSize(pnMain.getPreferredSize() );
			
			JPanel pnCenter = new JPanel();
			pnCenter.setOpaque(false);		
			/*set BoxLayout cho pnCenter*/
			pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
			pnCenter.setPreferredSize(new Dimension(700, 587));
			pnCenter.setMaximumSize(pnCenter.getPreferredSize() );
			
			JPanel pnSeacher = new JPanel();
			pnSeacher.setOpaque(false);
			pnSeacher.setPreferredSize(new Dimension(700, 35));
			pnSeacher.setMaximumSize(pnSeacher.getPreferredSize() );
			pnCenter.add(pnSeacher);
			
			JPanel pnList = new JPanel();
			/*set Border cho pnList*/
			Border titleBorderList;
			Border blueBorderList = BorderFactory.createLineBorder(Color.BLACK,2);
			titleBorderList = BorderFactory.createTitledBorder(blueBorderList,"DANH SÁCH GIAO DỊCH",
			        TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
			pnList.setBorder(titleBorderList);
			pnList.setPreferredSize(new Dimension(700,350));
			pnList.setMaximumSize(pnList.getPreferredSize() );
			
			list.addColumn("Mã Khách Hàng");
			list.addColumn("Họ Và Tên");
			list.addColumn("Mã Máy ATM");
			list.addColumn("Mã Giao Dịch");
			list.addColumn("Thời Gian Giao Dịch");
			list.addColumn("Số Tiền");
			list.addColumn("Tình Trạng");
			
			JScrollPane sc=new JScrollPane(tbl);		
			pnList.setLayout(new BorderLayout());
			pnList.add(sc,BorderLayout.CENTER);
			pnCenter.add(pnList);
			
			JPanel pnSumAll = new JPanel();
			/*set BoxLayout cho pnSumAll*/
			pnSumAll.setLayout(new BoxLayout(pnSumAll, BoxLayout.X_AXIS));
			/*set Border cho pnSumAll*/
			Border titleBorderSum;
			Border blueBorderSum = BorderFactory.createLineBorder(Color.BLACK,2);
			titleBorderSum = BorderFactory.createTitledBorder(blueBorderSum,"",
			        TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
			pnSumAll.setBorder(titleBorderSum);
			pnSumAll.setPreferredSize(new Dimension(700,50));
			pnSumAll.setMaximumSize(pnSumAll.getPreferredSize() );
			pnSumAll.setBackground(Color.white);
			JPanel pnRecharge = new JPanel();
			JLabel lblDetailRecharge = new JLabel("Tổng tiền Đã Nạp :");
			txtDetailRecharge = new JTextField(20);
			txtDetailRecharge.setEditable(false);
			
			pnRecharge.add(lblDetailRecharge);
			pnRecharge.add(txtDetailRecharge);
			
			JPanel pnWithdrawal = new JPanel();
			JLabel lblWithdrawal = new JLabel("Tổng tiền Đã Rút :");
			txtWithdrawal = new JTextField(20);
			txtWithdrawal.setEditable(false);
			
			pnWithdrawal.add(lblWithdrawal);
			pnWithdrawal.add(txtWithdrawal);
			
			pnSumAll.add(pnRecharge);
			pnSumAll.add(pnWithdrawal);
			
			pnCenter.add(pnSumAll);
			/*Cảnh chỉnh value cột nằm bên phải của table*/
			DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
			rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
			tbl.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
			tbl.getColumnModel().getColumn(1).setPreferredWidth(105);
			tbl.getColumnModel().getColumn(6).setPreferredWidth(40);
			JPanel pnClearList = new JPanel();
			pnClearList.setOpaque(false);
			btnClearList = new JButton("Xóa Danh Sách");
			btnClearList.setEnabled(false);
			pnClearList.add(btnClearList);
			pnCenter.add(pnClearList);
			pnMain.add(pnCenter);
			
			JPanel pnAction = new JPanel();
			
			pnAction.setPreferredSize(new Dimension(350, 587));
			pnAction.setMaximumSize(pnAction.getPreferredSize() );
			/*set Border cho pnAction*/
			Border titleBorderAction;
			Border blueBorderAction = BorderFactory.createLineBorder(Color.BLACK,3);
			titleBorderAction = BorderFactory.createTitledBorder(blueBorderAction,"TÌM KIẾM THEO",
			        TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
			pnAction.setBorder(titleBorderAction);
			pnAction.setOpaque(false);
			
			JPanel pnBlank = new JPanel();
			pnBlank.setPreferredSize(new Dimension(340,40));
			pnBlank.setMaximumSize(pnBlank.getPreferredSize() );		
			pnBlank.setOpaque(false);
			
			JPanel pnInformation = new JPanel();
			pnInformation.setPreferredSize(new Dimension(340,330));
			pnInformation.setMaximumSize(pnInformation.getPreferredSize() );
			/*set BoxLayout cho pnInformation*/
			pnInformation.setLayout(new BoxLayout(pnInformation, BoxLayout.Y_AXIS));
			pnInformation.setOpaque(false);
			/*set Border cho pnInformation*/
			Border titleBorderInfor;
			Border blueBorderInfor = BorderFactory.createLineBorder(Color.GRAY);
			titleBorderInfor = BorderFactory.createTitledBorder(blueBorderInfor,"Giao Dịch Khách Hàng",
			        TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
			pnInformation.setBorder(titleBorderInfor);
			pnInformation.setOpaque(false);
			
			JPanel pnInforMini = new JPanel();
			pnInforMini.setOpaque(false);
			

			JLabel lblCodeCus = new JLabel("Mã Khách Hàng :");
			txtCodeCus = new JTextField(20);									
			
			JLabel lblDistricts = new JLabel("Quận :");
			cboDistricts=new JComboBox<>();
			cboDistricts.addItem("Tất Cả");
			
			JLabel lblWards = new JLabel("Phường :");
			cboWards=new JComboBox<>();
			cboWards.addItem("Tất Cả");
			
			JLabel lblStreets = new JLabel("Tên Đường :");
			txtStreets = new JTextField(20);
						
			/*Group layout để canh chỉnh lề cho các Jlabel và JtextField*/
			GroupLayout inforLayout = new GroupLayout(pnInforMini);
			pnInforMini.setLayout(inforLayout);
			inforLayout.setAutoCreateGaps(true);
			inforLayout.setAutoCreateContainerGaps(true);
			
			inforLayout.setHorizontalGroup(inforLayout.createSequentialGroup()
				.addGroup(inforLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
					.addComponent(lblCodeCus, 0, 100, Short.MAX_VALUE)
					.addComponent(lblDistricts)
					.addComponent(lblWards)
					.addComponent(lblStreets)				
				)
				.addGroup(inforLayout.createParallelGroup()
					.addComponent(txtCodeCus)
					.addComponent(cboDistricts)
					.addComponent(cboWards)
					.addComponent(txtStreets)
				)
			);
			
			inforLayout.setVerticalGroup(inforLayout.createSequentialGroup()
				.addGroup(inforLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(lblCodeCus)
					.addComponent(txtCodeCus)
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
			);							
			pnAllChoosDay = new JPanel();
			layout = new CardLayout();
			pnAllChoosDay.setLayout(layout);
			pnAllChoosDay.setOpaque(false);
			
			JPanel pnChooserDay = new JPanel();		
			/*set BoxLayout cho pnChooserDay*/
			pnChooserDay.setLayout(new BoxLayout(pnChooserDay, BoxLayout.Y_AXIS));
			pnChooserDay.setOpaque(false);
			
			JPanel pnSizeDay = new JPanel();
			pnSizeDay.setPreferredSize(new Dimension(340,110));
			pnSizeDay.setMaximumSize(pnSizeDay.getPreferredSize() );
			pnSizeDay.setOpaque(false);
			pnChooserDay.add(pnSizeDay);					
			
			JPanel pnDay = new JPanel();
			pnDay.setPreferredSize(new Dimension(340,70));
			pnDay.setMaximumSize(pnDay.getPreferredSize() );
			pnDay.setOpaque(false);
			pnSizeDay.add(pnDay);
			
			JPanel pnNote = new JPanel();
			pnNote.setOpaque(false);
			JLabel lblNote = new JLabel("Lưu ý:chỉ Được tìm trong khoảng 90 ngày");
			lblNote.setFont(new Font("Courier New", Font.ITALIC, 11));
			lblNote.setForeground(Color.DARK_GRAY);
			pnNote.add(lblNote);
			pnSizeDay.add(pnNote);
			
			JLabel lblFromDay = new JLabel("Từ Ngày :");
			jdcFromDay = new JDateChooser();		
			
			JLabel lblToDay = new JLabel("Đến Ngày :");
			jdcToDay = new JDateChooser();
			/*Group layout để canh chỉnh lề cho các Jlabel và JtextField*/
			GroupLayout dayLayout = new GroupLayout(pnDay);
			pnDay.setLayout(dayLayout);
			dayLayout.setAutoCreateGaps(true);
			dayLayout.setAutoCreateContainerGaps(true);
			
			dayLayout.setHorizontalGroup(dayLayout.createSequentialGroup()
				.addGroup(dayLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
					.addComponent(lblFromDay, 0, 105, Short.MAX_VALUE)
					.addComponent(lblToDay)					
				)
				.addGroup(dayLayout.createParallelGroup()
					.addComponent(jdcFromDay)
					.addComponent(jdcToDay)
				)
			);
			
			dayLayout.setVerticalGroup(dayLayout.createSequentialGroup()
				.addGroup(dayLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(lblFromDay)
					.addComponent(jdcFromDay)
				)
				.addGroup(dayLayout.createParallelGroup()
						.addComponent(lblToDay)
						.addComponent(jdcToDay)
					)						
			);	
			
			JPanel pnSearch = new JPanel();
			pnSearch.setOpaque(false);
			btnUpdate = new JButton("Cập Nhập Dữ Liệu");
			btnSearch = new JButton("Xem");										
			btnCancel = new JButton("Hủy");
			pnSearch.add(btnSearch);
			pnSearch.add(btnCancel);
			pnSearch.add(btnUpdate);
			pnChooserDay.add(pnSearch);
			
			JPanel pnChoose=new JPanel();
			pnChoose.setOpaque(false);
			rdoDay=new JRadioButton("Theo Khoảng Thời Gian"); 
			rdoDay.setOpaque(false);
			rdoMonth=new JRadioButton("Theo Tháng");
			rdoMonth.setOpaque(false);
			rdoDay.setBounds(50,100,70,30);  
			rdoMonth.setBounds(50,150,70,30);
			ButtonGroup bgSelect = new ButtonGroup();
			bgSelect.add(rdoDay);
			bgSelect.add(rdoMonth);
			rdoDay.setSelected(true);
			pnChoose.add(rdoDay);
			pnChoose.add(rdoMonth);
			
			
			
			JPanel pnChooserMonth = new JPanel();
			/*set Boxlayout cho pnChooserMonth*/
			pnChooserMonth.setLayout(new BoxLayout(pnChooserMonth, BoxLayout.Y_AXIS));
			pnChooserMonth.setOpaque(false);
			
			JPanel pnSizeMonth = new JPanel();
			pnSizeMonth.setPreferredSize(new Dimension(340,110));
			pnSizeMonth.setMaximumSize(pnSizeMonth.getPreferredSize() );
			pnSizeMonth.setOpaque(false);
			pnChooserMonth.add(pnSizeMonth);
			
			JPanel pnMonth = new JPanel();
			pnMonth.setPreferredSize(new Dimension(340,70));
			pnMonth.setMaximumSize(pnMonth.getPreferredSize() );
			pnMonth.setOpaque(false);
			pnSizeMonth.add(pnMonth);
			
			JLabel lblMonth = new JLabel("Tháng :");
			jmcMonth = new JMonthChooser();		
			
			JLabel lblYear = new JLabel("Năm :");
			jycYear = new JYearChooser ();		
			/*Group layout để canh chỉnh lề cho các Jlabel và JtextField*/
			GroupLayout monthLayout = new GroupLayout(pnMonth);
			pnMonth.setLayout(monthLayout);
			monthLayout.setAutoCreateGaps(true);
			monthLayout.setAutoCreateContainerGaps(true);
			
			monthLayout.setHorizontalGroup(monthLayout.createSequentialGroup()
				.addGroup(monthLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
					.addComponent(lblMonth, 0, 105, Short.MAX_VALUE)
					.addComponent(lblYear)					
				)
				.addGroup(monthLayout.createParallelGroup()
					.addComponent(jmcMonth)
					.addComponent(jycYear)
				)
			);
			
			monthLayout.setVerticalGroup(monthLayout.createSequentialGroup()
				.addGroup(monthLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(lblMonth)
					.addComponent(jmcMonth)
				)
				.addGroup(monthLayout.createParallelGroup()
						.addComponent(lblYear)
						.addComponent(jycYear)
					)						
			);	
			
			JPanel pnSearchMonth = new JPanel();
			pnSearchMonth.setOpaque(false);
			btnSearchMonth = new JButton("Xem");										
			btnCancelMonth = new JButton("Hủy");
			btnUpdateMonth = new JButton("Cập Nhập Dữ Liệu");
			pnSearchMonth.add(btnSearchMonth);
			pnSearchMonth.add(btnCancelMonth);
			pnSearchMonth.add(btnUpdateMonth);
			pnChooserMonth.add(pnSearchMonth);
			
			
			pnAllChoosDay.add(pnChooserDay,"1");
			pnAllChoosDay.add(pnChooserMonth,"2");
			
			pnInformation.add(pnInforMini);
			
			pnInformation.add(pnAllChoosDay);
			pnInformation.add(pnChoose);
			
			pnAction.add(pnBlank);
			pnAction.add(pnInformation);
			
			pnMain.add(pnAction);
			this.add(pnMain);			
		}catch (Exception e) {
			
		}
		
	}

	private void addEvents() {
		tbl.addMouseListener(eventChooseRow);
		btnSearch.addActionListener(eventSearch);
		btnCancel.addActionListener(eventCancel);
		btnSearchMonth.addActionListener(eventSearchMonth);
		btnCancelMonth.addActionListener(eventCancelMonth);
		cboDistricts.addActionListener(eventChooseDistricts);
		rdoDay.addActionListener(chooseDay);
		rdoMonth.addActionListener(chooseDay);
		btnClearList.addActionListener(eventClearList);
		btnUpdate.addActionListener(eventUpdate);
		btnUpdateMonth.addActionListener(eventUpdate);
	}
	/*Cập nhập dữ liệu cho ArrayList*/
	private ActionListener eventUpdate = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			arrAllCusTss = TransactionsDb.getCusTransactionList();
			arrCusTss=updateArrCusTss();	
			String msgXoa ="Cập Nhập Thành Công Dữ Liệu Mới Nhất !!!";
			JOptionPane.showMessageDialog(null, msgXoa, "Cập Nhập Dữ Liệu!!!", JOptionPane.INFORMATION_MESSAGE);
		}
	};
	/*Đưa các giá trị về trống*/
	private ActionListener eventClearList = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			list.setRowCount(0);	
			txtDetailRecharge.setText("");
			txtWithdrawal.setText("");
			btnClearList.setEnabled(false);
		}
	};
	/*sự kiện chọn ngày gọi cardlayout cho radioButton*/
	private ActionListener chooseDay = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (rdoDay.isSelected()) {
				layout.show(pnAllChoosDay,"1");
			} else {
				layout.show(pnAllChoosDay,"2");
			}
		}
	};
	/*Tìm kiếm theo ngày*/
	ActionListener eventSearch = new ActionListener() {
		public void actionPerformed(ActionEvent e) {	
			try {				
				btnClearList.setEnabled(true);
				String codeTss = txtCodeCus.getText();
				String streetTss =txtStreets.getText();
				Calendar dayFrom=null,dayTo=null;
				long dayF = 0,dayT=0;
				int checkDay=0;
				try {
					/*validate cho tìm kiếm*/
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
				String districts = cboDistricts.getSelectedItem().toString();
				String wards = cboWards.getSelectedItem().toString();
				
				if(dayFrom==null&&dayTo==null) {					
					dayTo = Calendar.getInstance();
					dayFrom = Calendar.getInstance();
					dayFrom.add(Calendar.DATE, -90);
					jdcFromDay.setCalendar(dayFrom);					
					jdcToDay.setCalendar(dayTo);
					
					searchTss(districts,wards,codeTss,streetTss,dayFrom,dayTo);
				}else if(dayFrom==null){
					dayTo = jdcToDay.getCalendar();
					dayFrom = jdcToDay.getCalendar();
					dayFrom.add(Calendar.DATE, -90);
					jdcFromDay.setCalendar(dayFrom);
					searchTss(districts,wards,codeTss,streetTss,dayFrom,dayTo);
				}else if(dayTo==null){
					dayFrom = jdcFromDay.getCalendar();
					dayTo = Calendar.getInstance();
					
					jdcToDay.setCalendar(dayTo);
					
					
					searchTss(districts,wards,codeTss,streetTss,dayFrom,dayTo);
				}else {
					
					if((dayT-dayF)<0) {
						String msgXoa ="Ngày Kết Thúc Phải Lớn Hơn\nNgày Bắt Đầu";
						JOptionPane.showMessageDialog(null, msgXoa, "Lỗi Thời Gian!!!", JOptionPane.INFORMATION_MESSAGE);
					}else if(checkDay>90){
						String msgXoa ="khoảng thời gian không quá 90 ngày";
						JOptionPane.showMessageDialog(null, msgXoa, "Lỗi Thời Gian!!!", JOptionPane.INFORMATION_MESSAGE);
					}else{
						
						searchTss(districts,wards,codeTss,streetTss,dayFrom,dayTo);
					}
				}
				
			}catch (Exception e1) {
				String msgXoa ="Chưa Chọn Ngày !!!";
				JOptionPane.showMessageDialog(null, msgXoa, "Lỗi Nhập!!!", JOptionPane.INFORMATION_MESSAGE);
			}													
		}
    };
    /*Tìm kiếm theo Tháng*/
    ActionListener eventSearchMonth = new ActionListener() {
		public void actionPerformed(ActionEvent e) {	
			btnClearList.setEnabled(true);
			try {				
				String codeTss = txtCodeCus.getText();
				String streetTss =txtStreets.getText();																							
				String districts = cboDistricts.getSelectedItem().toString();
				String wards = cboWards.getSelectedItem().toString();
				int month = jmcMonth.getMonth();
				int year = jycYear.getValue();
				int nowMonth =Calendar.getInstance().get(Calendar.MONTH);
				int nowYear =Calendar.getInstance().get(Calendar.YEAR);								
				if(year>nowYear) {
					year=nowYear;
					month=nowMonth;
					jmcMonth.setMonth(nowMonth);
					jycYear.setYear(nowYear);
					searchTssMonth( districts, wards, codeTss, streetTss,month,year);
				}else if(month>nowMonth){
					month=nowMonth;
					jmcMonth.setMonth(nowMonth);
					searchTssMonth( districts, wards, codeTss, streetTss,month,year);
				}else {
					searchTssMonth( districts, wards, codeTss, streetTss,month,year);
				}
								
			}catch (Exception e1) {
				String msgXoa ="Chưa Chọn Ngày !!!";
				JOptionPane.showMessageDialog(null, msgXoa, "Lỗi Nhập!!!", JOptionPane.INFORMATION_MESSAGE);
			}													
		}
    };
    /*Tìm kiếm theo các giá trị đưa ra*/
    public void searchTss(String districts,String wards,String codeTss,String streetTss,Calendar dayFrom,Calendar dayTo) {
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
    	if(districts.equals("Tất Cả")) {
			districts="";
			wards="";
			getListSearch(codeTss,streetTss,districts, wards, dayFrom, dayTo);
		}else {
			if(wards.equals("Tất Cả")) {
				wards="";
				getListSearch(codeTss,streetTss,districts, wards, dayFrom, dayTo);
			}else {
				getListSearch(codeTss,streetTss,districts, wards, dayFrom, dayTo);
			}
		}	
    	getListSearch(codeTss,streetTss,districts, wards, dayFrom, dayTo);
    	
    }
    /*Duyệt ArrayList theo các giá trị cần tìm*/
    public void getListSearch(String codeTss,String streetTss,String districts,String wards, Calendar dayFrom,Calendar dayTo){
    	list.setRowCount(0);
    	dayFrom.set(dayFrom.get(Calendar.YEAR), dayFrom.get(Calendar.MONTH), dayFrom.get(Calendar.DATE), 0, 0);
    	dayTo.set(dayTo.get(Calendar.YEAR), dayTo.get(Calendar.MONTH), dayTo.get(Calendar.DATE), 23, 59);
    	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date date = new Date();
		int moneyRecharge=0;int moneyWithdrawal=0;
    	for(CusTransaction tss:arrCusTss) {
    		Timestamp ts = tss.getTimeTransaction();
			date.setTime(ts.getTime());
			String time = dateFormat.format(date);
			Calendar calendar2 = Calendar.getInstance();
		    calendar2.setTime(ts);
		    
    		if(tss.getCodeCus().indexOf(codeTss)>-1&&tss.getStreets().indexOf(streetTss)>-1&&
    				tss.getDistricts().indexOf(districts)>-1&&tss.getWards().indexOf(wards)>-1&&
    				calendar2.getTime().after(dayFrom.getTime()) && calendar2.getTime().before(dayTo.getTime())) {    			
    			String[] row = {tss.getCodeCus(), tss.getFullnameCus(), tss.getCodeATM(),tss.getCodeTransaction(),time,String.format("%,d", (long) tss.getPayTransaction())+" VNĐ",tss.getStatus()};
    			list.addRow(row);
    			if(tss.getStatus().indexOf("Rút Tiền")>-1) {				
    				moneyWithdrawal=tss.getPayTransaction()+moneyWithdrawal;
    			}
    			if(tss.getStatus().indexOf("Nạp Tiền")>-1) {				
    				moneyRecharge=tss.getPayTransaction()+moneyRecharge;
    			}
    		}
    	}
    			
		txtDetailRecharge.setText(String.format("%,d", (long) moneyRecharge)+" VNĐ");
		txtWithdrawal.setText(String.format("%,d", (long) moneyWithdrawal)+" VNĐ");
    }
    /*Duyệt ArrayList theo các giá trị cần tìm*/
    public void searchTssMonth(String districts,String wards,String codeTss,String streetTss, int month, int year ) {
    	String monthDate = String.valueOf(month+1);
		String yearDate = String.valueOf(year);
		String resuiltChoose;
		if((month+1)>=10) {
			resuiltChoose = yearDate+"-"+monthDate;
		}else {
			resuiltChoose = yearDate+"-0"+monthDate;
		}
    	if(districts.equals("Tất Cả")) {
			districts="";
			wards="";
			getListSearchMonth( codeTss, streetTss, districts, wards, resuiltChoose);
		}else {
			if(wards.equals("Tất Cả")) {
				wards="";
				getListSearchMonth( codeTss, streetTss, districts, wards, resuiltChoose);
			}else {
				getListSearchMonth( codeTss, streetTss, districts, wards, resuiltChoose);
			}
		}	
    	getListSearchMonth( codeTss, streetTss, districts, wards, resuiltChoose);
    	
    }
    /*Duyệt ArrayList theo các giá trị cần tìm*/
    public void getListSearchMonth(String codeTss,String streetTss,String districts,String wards,String resuiltChoose){
    	list.setRowCount(0);
    	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    	DateFormat dateFormatChoose = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date = new Date();
		Date dateChoose = new Date();
		int moneyRecharge=0;int moneyWithdrawal=0;
    	for(CusTransaction tss:arrCusTss) {
    		Timestamp ts = tss.getTimeTransaction();
			date.setTime(ts.getTime());
			String time = dateFormat.format(date);
			Calendar calendar2 = Calendar.getInstance();
		    calendar2.setTime(ts);
		    dateChoose.setTime(tss.getTimeTransaction().getTime());
			String timeChoose = dateFormatChoose.format(dateChoose);
    		if(tss.getCodeCus().indexOf(codeTss)>-1&&tss.getStreets().indexOf(streetTss)>-1&&
    				tss.getDistricts().indexOf(districts)>-1&&tss.getWards().indexOf(wards)>-1&&
    				timeChoose.indexOf(resuiltChoose)>-1) {    			
    			String[] row = {tss.getCodeCus(), tss.getFullnameCus(), tss.getCodeATM(),tss.getCodeTransaction(),time,String.format("%,d", (long) tss.getPayTransaction())+" VNĐ",tss.getStatus()};
    			list.addRow(row);
    			if(tss.getStatus().indexOf("Rút Tiền")>-1) {				
    				moneyWithdrawal=tss.getPayTransaction()+moneyWithdrawal;
    			}
    			if(tss.getStatus().indexOf("Nạp Tiền")>-1) {				
    				moneyRecharge=tss.getPayTransaction()+moneyRecharge;
    			}
    		}
    	}
    	txtDetailRecharge.setText(String.format("%,d", (long) moneyRecharge)+" VNĐ");
		txtWithdrawal.setText(String.format("%,d", (long) moneyWithdrawal)+" VNĐ");
    }
    /*Sự kiện khi click vào các dòng trong table*/
    MouseAdapter eventChooseRow = new MouseAdapter() {
    	public void mouseClicked(MouseEvent e) {
    		/*Lấy index số dòng khi click*/
    		int col = tbl.getSelectedRow();
    		String[] row = new String[5];	    		
    		row[0] = (String) tbl.getValueAt(col, 0);    		
    		txtCodeCus.setText(row[0]);    	
    		/*duyệt mảng ArrayList để lấy các giá trị đưa vào Ô textfield*/
			for(int i=0;i<arrCusTss.size();i++) {
				if(row[0].equals(arrCusTss.get(i).getCodeCus())) {
					txtStreets.setText(arrCusTss.get(i).getStreets());
					cboDistricts.setSelectedItem(arrCusTss.get(i).getDistricts());
					cboWards.setSelectedItem(arrCusTss.get(i).getWards());					
				}
			}
    	}
    };
    /*Sự kiện chọn quận khi combobox thay đổi*/
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
    /*Đưa các giá trị về trống*/
    ActionListener eventCancel = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			txtCodeCus.setText("");
			txtStreets.setText("");
			jdcFromDay.setCalendar(null);
			jdcToDay.setCalendar(null);
			cboDistricts.setSelectedIndex(0);
			cboWards.setSelectedIndex(0);
		}
    };
    /*Đưa các giá trị về trống*/
    ActionListener eventCancelMonth = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			txtCodeCus.setText("");
			txtStreets.setText("");
			int nowMonth =Calendar.getInstance().get(Calendar.MONTH);
			int nowYear =Calendar.getInstance().get(Calendar.YEAR);	
			jmcMonth.setMonth(nowMonth);
			jycYear.setYear(nowYear);
			cboDistricts.setSelectedIndex(0);
			cboWards.setSelectedIndex(0);
		}
    };
	/*Cập nhập ArrayList*/
	private ArrayList<CusTransaction> updateArrCusTss() {
    	return arrCusTss=arrAllCusTss;
    }        
	
}
