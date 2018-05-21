
package ffse1703005.software.atm.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import ffse1703005.software.atm.model.MachineATM;
import ffse1703005.software.atm.model.MachineATMDb;
import ffse1703005.software.atm.model.StamentAdress;

public class LayoutReportATM extends JPanel{
	private static final long serialVersionUID = 1L;
	private JButton btnSearchAdress,btnCancelAdress,btnClearInfor,btnUpdate;
	private JTextField txtCodeATM,txtStreets;
	private JTextField txtDetailCodeATM,txtDetailMoneyATM,txtDetailDistricts,txtDetailWards,txtDetailStreets;
	private JComboBox<String> cboDistricts,cboWards;
	private DefaultTableModel list=new DefaultTableModel();
	private final JTable tbl=new JTable(list);	
	private StamentAdress adress = new StamentAdress();
	private ArrayList<String> arrAdress = new ArrayList<String>();
	private ArrayList<MachineATM> arrAtm = new ArrayList<MachineATM>();
	private ArrayList<MachineATM> arrAtmAll = new ArrayList<MachineATM>();
	public LayoutReportATM() {
		addControlls();
		addEvents();
		arrAdress = adress.SeclectDis();
		for(String x:arrAdress) {
			cboDistricts.addItem(x);
		}
		arrAtm = new ArrayList<MachineATM>();
		arrAtmAll = new ArrayList<MachineATM>();		
		arrAtmAll =MachineATMDb.getAtmList();
		updateArrAtm();
		printListAtm();
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
		titleBorderList = BorderFactory.createTitledBorder(blueBorderList,"DANH SÁCH MÁY ATM",
		        TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
		pnList.setBorder(titleBorderList);
		pnList.setPreferredSize(new Dimension(700,260));
		pnList.setMaximumSize(pnList.getPreferredSize() );
		
		list.addColumn("Mã Máy ATM");
		list.addColumn("Đường");
		list.addColumn("Số Dư Trong Máy");
					
		JScrollPane sc=new JScrollPane(tbl);		
		pnList.setLayout(new BorderLayout());
		pnList.add(sc,BorderLayout.CENTER);
		pnCenter.add(pnList);
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
		tbl.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
		
		JPanel pnDetail = new JPanel();
		pnDetail.setLayout(new BoxLayout(pnDetail, BoxLayout.Y_AXIS));
		Border titleBorderDetail;
		Border blueBorderDetail = BorderFactory.createLineBorder(Color.BLACK,2);
		titleBorderDetail = BorderFactory.createTitledBorder(blueBorderDetail,"Chi Tiết Khách Hàng",
		        TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
		pnDetail.setBorder(titleBorderDetail);
		pnDetail.setPreferredSize(new Dimension(700,160));
		pnDetail.setMaximumSize(pnDetail.getPreferredSize() );
		pnCenter.add(pnDetail);
		
		
		JPanel pnAllInfor = new JPanel();
		pnAllInfor.setLayout(new BoxLayout(pnAllInfor, BoxLayout.X_AXIS));
		
		JPanel pnDetailInfor = new JPanel();
		
		JLabel lblDetailCAtm = new JLabel("Mã Máy ATM :");
		txtDetailCodeATM = new JTextField(20);
		txtDetailCodeATM.setEditable(false);
		
		JLabel lblDetailMoAtm = new JLabel("Số Dư Máy ATM :");
		txtDetailMoneyATM = new JTextField(20);
		txtDetailMoneyATM.setEditable(false);
		
		GroupLayout infoDetailLayout = new GroupLayout(pnDetailInfor);
		pnDetailInfor.setLayout(infoDetailLayout);
		infoDetailLayout.setAutoCreateGaps(true);
		infoDetailLayout.setAutoCreateContainerGaps(true);
		
		infoDetailLayout.setHorizontalGroup(infoDetailLayout.createSequentialGroup()
			.addGroup(infoDetailLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
				.addComponent(lblDetailCAtm, 0, 100, Short.MAX_VALUE)
				.addComponent(lblDetailMoAtm)
			)
			.addGroup(infoDetailLayout.createParallelGroup()
				.addComponent(txtDetailCodeATM)
				.addComponent(txtDetailMoneyATM)
			)
		);
		
		infoDetailLayout.setVerticalGroup(infoDetailLayout.createSequentialGroup()
			.addGroup(infoDetailLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				.addComponent(lblDetailCAtm)
				.addComponent(txtDetailCodeATM)
			)			
			.addGroup(infoDetailLayout.createParallelGroup()
					.addComponent(lblDetailMoAtm)
					.addComponent(txtDetailMoneyATM)
				)			
		);
		pnAllInfor.add(pnDetailInfor);
		
		JPanel pnDetailAdress = new JPanel();
		JLabel lblDetailDis = new JLabel("Quận :");
		txtDetailDistricts = new JTextField(20);
		txtDetailDistricts.setEditable(false);
		
		JLabel lblDetailWa = new JLabel("Phường :");
		txtDetailWards = new JTextField(20);
		txtDetailWards.setEditable(false);		
		
		GroupLayout adressDetailLayout = new GroupLayout(pnDetailAdress);
		pnDetailAdress.setLayout(adressDetailLayout);
		adressDetailLayout.setAutoCreateGaps(true);
		adressDetailLayout.setAutoCreateContainerGaps(true);
		
		adressDetailLayout.setHorizontalGroup(adressDetailLayout.createSequentialGroup()
			.addGroup(adressDetailLayout.createParallelGroup()
				.addComponent(lblDetailDis)
				.addComponent(lblDetailWa)
			)
			.addGroup(adressDetailLayout.createParallelGroup()
				.addComponent(txtDetailDistricts)
				.addComponent(txtDetailWards)
			)
		);
		
		adressDetailLayout.setVerticalGroup(adressDetailLayout.createSequentialGroup()
			.addGroup(adressDetailLayout.createParallelGroup()
				.addComponent(lblDetailDis)
				.addComponent(txtDetailDistricts)
			)			
			.addGroup(adressDetailLayout.createParallelGroup()
					.addComponent(lblDetailWa)
					.addComponent(txtDetailWards)
				)			
		);
		pnAllInfor.add(pnDetailAdress);				
		
		JPanel pnStreet = new JPanel();
		JLabel lblDetailSt = new JLabel("Đường :");
		txtDetailStreets = new JTextField(20);
		txtDetailStreets.setEditable(false);
		pnStreet.add(lblDetailSt);
		pnStreet.add(txtDetailStreets);
		
		JPanel pnClear = new JPanel();
		btnClearInfor = new JButton("Clear Thông Tin");
		pnClear.add(btnClearInfor);
		
		pnDetail.add(pnAllInfor);
		pnDetail.add(pnStreet);
		pnDetail.add(pnClear);
		
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
		
		JPanel pnBlank = new JPanel();
		pnBlank.setPreferredSize(new Dimension(340,80));
		pnBlank.setMaximumSize(pnBlank.getPreferredSize() );
		pnBlank.setOpaque(false);
		pnAction.add(pnBlank);
		
		JPanel pnInformation = new JPanel();
		pnInformation.setPreferredSize(new Dimension(340,70));
		pnInformation.setMaximumSize(pnInformation.getPreferredSize() );
		pnInformation.setLayout(new BoxLayout(pnInformation, BoxLayout.Y_AXIS));
		pnInformation.setOpaque(false);
		Border titleBorderInfor;
		Border blueBorderInfor = BorderFactory.createLineBorder(Color.GRAY);
		titleBorderInfor = BorderFactory.createTitledBorder(blueBorderInfor,"Mã Máy ATM",
		        TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
		pnInformation.setBorder(titleBorderInfor);
		pnInformation.setOpaque(false);
		
		JPanel pnCodeATM = new JPanel();
		pnCodeATM.setOpaque(false);
		JLabel lblCodeATM = new JLabel("Mã Máy ATM :");
		txtCodeATM = new JTextField(20);
		pnCodeATM.add(lblCodeATM);
		pnCodeATM.add(txtCodeATM);
		pnInformation.add(pnCodeATM);				
				
		JPanel pnAdress = new JPanel();
		JPanel pnAdressMini = new JPanel();
		pnAdressMini.setOpaque(false);
		pnAdress.setPreferredSize(new Dimension(340,180));
		pnAdress.setMaximumSize(pnAdress.getPreferredSize() );
		pnAdress.setLayout(new BoxLayout(pnAdress, BoxLayout.Y_AXIS));
		pnAdress.setOpaque(false);
		Border titleBorderAdress;
		Border blueBorderAdress = BorderFactory.createLineBorder(Color.GRAY);
		titleBorderAdress = BorderFactory.createTitledBorder(blueBorderAdress,"Vị Trí",
		        TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
		pnAdress.setBorder(titleBorderAdress);
		pnAdress.setOpaque(false);
		

		JLabel lblDistricts = new JLabel("Quận :");
		cboDistricts=new JComboBox<>();
		cboDistricts.addItem("Tất Cả");
		
		JLabel lblWards = new JLabel("Phường :");
		cboWards=new JComboBox<>();
		cboWards.addItem("Tất Cả");
		
		JLabel lblStreets = new JLabel("Tên Đường :");
		txtStreets = new JTextField(20);
		
		JPanel pnSearchAdress = new JPanel();
		pnSearchAdress.setOpaque(false);
		btnSearchAdress = new JButton("Xem");										
		btnCancelAdress = new JButton("Hủy");
		btnUpdate = new JButton("Cập Nhập");
		btnCancelAdress.setEnabled(false);
		pnSearchAdress.add(btnSearchAdress);
		pnSearchAdress.add(btnCancelAdress);
		pnSearchAdress.add(btnUpdate);
		
		GroupLayout adressLayout = new GroupLayout(pnAdressMini);
		pnAdressMini.setLayout(adressLayout);
		adressLayout.setAutoCreateGaps(true);
		adressLayout.setAutoCreateContainerGaps(true);
		
		adressLayout.setHorizontalGroup(adressLayout.createSequentialGroup()
			.addGroup(adressLayout.createParallelGroup()
				.addComponent(lblDistricts)
				.addComponent(lblWards)
				.addComponent(lblStreets)
			)
			.addGroup(adressLayout.createParallelGroup()
				.addComponent(cboDistricts)
				.addComponent(cboWards)
				.addComponent(txtStreets)
			)
		);
		
		adressLayout.setVerticalGroup(adressLayout.createSequentialGroup()
			.addGroup(adressLayout.createParallelGroup()
				.addComponent(lblDistricts)
				.addComponent(cboDistricts)
			)
			.addGroup(adressLayout.createParallelGroup()
					.addComponent(lblWards)
					.addComponent(cboWards)
				)
			.addGroup(adressLayout.createParallelGroup()
					.addComponent(lblStreets)
					.addComponent(txtStreets)
				)
		);
		
		pnAdress.add(pnAdressMini);
		pnAdress.add(pnSearchAdress);
		
		pnAction.add(pnInformation);
		pnAction.add(pnAdress);
		
		pnMain.add(pnAction);
		this.add(pnMain);
		
	}

	private void addEvents() {
		tbl.addMouseListener(eventChooseRow);
		cboDistricts.addActionListener(eventChooseDistricts);
		txtCodeATM.getDocument().addDocumentListener(eventSearchCode);
		txtStreets.getDocument().addDocumentListener(eventSearchStreet);
		btnSearchAdress.addActionListener(eventSearchDistricts);
		btnCancelAdress.addActionListener(eventCancelAdress);
		btnClearInfor.addActionListener(eventClearInfor);
		btnUpdate.addActionListener(eventUpdate);
	}
	
	ActionListener eventUpdate = new ActionListener() {
		public void actionPerformed(ActionEvent e) {			
			arrAtmAll = MachineATMDb.getAtmList();
			updateArrAtm();
			printListAtm();
			String msgXoa ="Cập Nhập Thành Công Dữ Liệu Mới Nhất !!!";
			JOptionPane.showMessageDialog(null, msgXoa, "Cập Nhập Dữ Liệu!!!", JOptionPane.INFORMATION_MESSAGE);
		}
    };
	
	ActionListener eventClearInfor = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			clearInfor();
		}
    };
    
    public void clearInfor() {
    	txtDetailCodeATM.setText("");
		txtDetailStreets.setText("");
		txtDetailMoneyATM.setText("");
		txtDetailDistricts.setText("");
		txtDetailWards.setText("");	
		tbl.clearSelection();
    }
	
	MouseAdapter eventChooseRow = new MouseAdapter() {
    	public void mouseClicked(MouseEvent e) {
    		int col = tbl.getSelectedRow();
    		String[] row = new String[4];	    		
    		row[0] = (String) tbl.getValueAt(col, 0);
    		row[1] = (String) tbl.getValueAt(col, 1);
    		row[2] = (String) tbl.getValueAt(col, 2);
    		txtDetailCodeATM.setText(row[0]);
    		txtDetailStreets.setText(row[1]);
    		txtDetailMoneyATM.setText(row[2]);
			for(int i=0;i<arrAtmAll.size();i++) {
				if(row[0].equals(arrAtmAll.get(i).getCodeATM())) {
					txtDetailDistricts.setText(arrAtmAll.get(i).getNameDistricts());
					txtDetailWards.setText(arrAtmAll.get(i).getNameWards());					
				}
			}			
    	}
    };
	
	ActionListener eventCancelAdress = new ActionListener() {
		public void actionPerformed(ActionEvent e) {			
			txtStreets.setText("");
			txtCodeATM.setText("");
			txtStreets.setEditable(true);
			txtCodeATM.setEditable(true);
			cboDistricts.setEnabled(isEnabled());
			cboWards.setEnabled(isEnabled());
			cboDistricts.setSelectedIndex(0);
			btnCancelAdress.setEnabled(false);
			btnSearchAdress.setEnabled(true);
			clearInfor();
			updateArrAtm();
			printListAtm();
		}
    };
	
	private DocumentListener eventSearchCode = new DocumentListener() {		
		@Override
		public void changedUpdate(DocumentEvent e) {
			searchCode();
		}
		@Override
		public void insertUpdate(DocumentEvent e) {
			searchCode();
		}
		@Override
		public void removeUpdate(DocumentEvent e) {
			String change = txtCodeATM.getText();
			if(change.isEmpty()) {				
				arrAtm = updateArrAtm();
				printListAtm();
			}else {
				searchCode();
			}
		}
	};
	
	private void searchCode() {
		btnCancelAdress.setEnabled(true);
		clearInfor();
		String code = txtCodeATM.getText();
		list.setRowCount(0);
		for(MachineATM x:arrAtmAll) {		
			if(x.getCodeATM().toUpperCase().trim().indexOf(code.toUpperCase().trim()) > -1) {				
				String[] row = {x.getCodeATM(),x.getStreetATM(),String.format("%,d", (long) x.getAmountATM())+" VNĐ"};
				list.addRow(row);			
			}			
		}			
	}	
    
	private DocumentListener eventSearchStreet = new DocumentListener() {		
		@Override
		public void changedUpdate(DocumentEvent e) {
			searchStreets();
		}
		@Override
		public void insertUpdate(DocumentEvent e) {
			searchStreets();
		}
		@Override
		public void removeUpdate(DocumentEvent e) {
			String change = txtStreets.getText();
			if(change.isEmpty()) {
				btnCancelAdress.setEnabled(false);
				arrAtm = updateArrAtm();
				printListAtm();
			}else {
				searchStreets();
			}
		}
	};
	private void searchStreets() {
		btnCancelAdress.setEnabled(true);
		clearInfor();
		String streets = txtStreets.getText();
		list.setRowCount(0);
		for(MachineATM x:arrAtmAll) {		
			if(x.getStreetATM().toUpperCase().trim().indexOf(streets.toUpperCase().trim()) > -1) {				
				String[] row = {x.getCodeATM(),x.getStreetATM(),String.format("%,d", (long) x.getAmountATM())+" VNĐ"};
				list.addRow(row);			
			}			
		}			
	}
	
	ActionListener eventChooseDistricts = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
				int keys = cboDistricts.getSelectedIndex();
				if (keys==0) {
					cboWards.removeAllItems();
					cboWards.addItem("Tất Cả");
					btnCancelAdress.setEnabled(false);
				}else {
					btnCancelAdress.setEnabled(true);
					arrAdress = adress.SeclectWard(keys);
					cboWards.removeAllItems();
					cboWards.addItem("Tất Cả");
					for(String x:arrAdress) {					
						cboWards.addItem(x);
					}
				}	
			}
								
		
    };
	
    ActionListener eventSearchDistricts = new ActionListener() {
		public void actionPerformed(ActionEvent e) {	
			clearInfor();
				int keyDistricts = cboDistricts.getSelectedIndex();
				if(keyDistricts==0) {
					arrAtm = updateArrAtm();
					printListAtm();
					btnCancelAdress.setEnabled(false);
				}else {
					btnCancelAdress.setEnabled(true);
					int keyW = cboWards.getSelectedIndex();
					if(keyW==0) {
						searchStreetsWards(keyDistricts);
						
					}else {
						String wards = (String) cboWards.getSelectedItem();
						int keyWards = adress.SeclectIdWards(wards);
						searchStreets( keyDistricts, keyWards)	;				
					}
				}											
		}
    };
    
    private void searchStreets(int keyDistricts,int keyWards) {
		btnCancelAdress.setEnabled(true);
		clearInfor();
		list.setRowCount(0);
		for(MachineATM x:arrAtmAll) {		
			if(x.getDistrictATM()==keyDistricts && x.getWardATM()==keyWards ) {				
				String[] row = {x.getCodeATM(),x.getStreetATM(),String.format("%,d", (long) x.getAmountATM())+" VNĐ"};
				list.addRow(row);			
			}			
		}			
	}
    
    private void searchStreetsWards(int keyDistricts) {
		btnCancelAdress.setEnabled(true);
		clearInfor();
		list.setRowCount(0);
		for(MachineATM x:arrAtmAll) {		
			if(x.getDistrictATM()==keyDistricts ) {				
				String[] row = {x.getCodeATM(),x.getStreetATM(),String.format("%,d", (long) x.getAmountATM())+" VNĐ"};
				list.addRow(row);			
			}			
		}			
	}
    
    private ArrayList<MachineATM> updateArrAtm() {    	
    	return arrAtm = arrAtmAll;
    }
    
    private void printListAtm() {
    	list.setRowCount(0);
    	for (MachineATM atm : arrAtm) {    		
			String[] row = {atm.getCodeATM(),atm.getStreetATM(),String.format("%,d", (long) atm.getAmountATM())+" VNĐ"};
			list.addRow(row);
		}
    }
	
	
}
