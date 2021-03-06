
package ffse1703005.software.atm.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
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
/*tạo class LayoutATMManage kế thừa JPanel*/
public class LayoutATMManage extends JPanel{
	private static final long serialVersionUID = 1L;
	private NumberFormat MoneyATMFormat;
	private JButton btnAddATM,btnEditATM,btnDeleteATM,btnCancelATM;
	private JTextField txtSeacher,txtCodeATM,txtMoneyATM,txtStreets;
	private JComboBox<String> cboDistricts,cboWards;
	private DefaultTableModel list=new DefaultTableModel();
	private final JTable tbl=new JTable(list);
	private MachineATM atm = new MachineATM();
	private StamentAdress adress = new StamentAdress();
	private ArrayList<String> arrAdress = new ArrayList<String>();
	private ArrayList<MachineATM> arrAtm = new ArrayList<MachineATM>();
	private ArrayList<MachineATM> arrAtmAll = new ArrayList<MachineATM>();
	public LayoutATMManage() {
		addControlls();
		addEvents();
		/*Hiển thi Quận Từ phương thức SeclectDis của class StamentAdress*/
		arrAdress = adress.SeclectDis();
		for(String x:arrAdress) {
			cboDistricts.addItem(x);
		}
		
		arrAtmAll = new ArrayList<MachineATM>();
		arrAtmAll = MachineATMDb.getAtmList();
		arrAtm = new ArrayList<MachineATM>();
		updateArrAtm();
		printListAtm();
	}

	private void addControlls() {
		try {
			this.setOpaque(false);		
			
			JPanel pnMain = new JPanel();
			pnMain.setOpaque(false);	
			/*set boxlayout cho pnMail*/
			pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.X_AXIS));
			pnMain.setPreferredSize(new Dimension(1050, 587));
			pnMain.setMaximumSize(pnMain.getPreferredSize() );
			
			JPanel pnCenter = new JPanel();
			pnCenter.setOpaque(false);
			
			JPanel pnSeacher = new JPanel();
			pnSeacher.setOpaque(false);
			pnSeacher.setPreferredSize(new Dimension(700, 35));
			pnSeacher.setMaximumSize(pnSeacher.getPreferredSize() );
			
			JPanel pnSeacherLeft = new JPanel();
			pnSeacherLeft.setOpaque(false);
			pnSeacherLeft.setPreferredSize(new Dimension(350, 35));
			pnSeacherLeft.setMaximumSize(pnSeacherLeft.getPreferredSize() );
			pnSeacher.add(pnSeacherLeft);
			JPanel pnSeacherRight = new JPanel();
			pnSeacherRight.setOpaque(false);
			JLabel lblSeacher=new JLabel("            Tìm Kiếm : ");
			lblSeacher.setOpaque(false);
			pnSeacherRight.add(lblSeacher);
			txtSeacher = new JTextField(20);		
			pnSeacherRight.add(txtSeacher);
			pnSeacher.add(pnSeacherRight);
			
			pnCenter.add(pnSeacher);
			/*set boxlayout cho pnCenter*/
			pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
			pnCenter.setPreferredSize(new Dimension(700, 587));
			pnCenter.setMaximumSize(pnCenter.getPreferredSize() );
			JPanel pnList = new JPanel();
			/*set Border cho pnCenter*/
			Border titleBorderList;
			Border blueBorderList = BorderFactory.createLineBorder(Color.BLACK,2);
			titleBorderList = BorderFactory.createTitledBorder(blueBorderList,"DANH SÁCH MÁY ATM",
			        TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
			pnList.setBorder(titleBorderList);
			pnList.setPreferredSize(new Dimension(700, 400));
			pnList.setMaximumSize(pnList.getPreferredSize() );
			/*Add column cho table*/
			list.addColumn("Mã Máy ATM");
			list.addColumn("Đường");
			list.addColumn("Số Dư Trong Máy");						
			JScrollPane sc=new JScrollPane(tbl);		
			pnList.setLayout(new BorderLayout());
			pnList.add(sc,BorderLayout.CENTER);
			pnCenter.add(pnList);
			/*Canh chỉnh các value các cột sang bên phải*/
			DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
			rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
			tbl.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
			pnMain.add(pnCenter);
			
			JPanel pnAction = new JPanel();
			
			pnAction.setPreferredSize(new Dimension(350, 587));
			pnAction.setMaximumSize(pnAction.getPreferredSize() );
			/*set Border cho pnAction*/
			Border titleBorderAction;
			Border blueBorderAction = BorderFactory.createLineBorder(Color.BLACK,3);
			titleBorderAction = BorderFactory.createTitledBorder(blueBorderAction,"",
			        TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
			pnAction.setBorder(titleBorderAction);
			pnAction.setOpaque(false);
			
			JPanel pnBlank = new JPanel();
			pnBlank.setOpaque(false);
			pnBlank.setPreferredSize(new Dimension(340,100));
			pnBlank.setMaximumSize(pnBlank.getPreferredSize() );
			
			JPanel pnInformation = new JPanel();
			pnInformation.setPreferredSize(new Dimension(340,90));
			pnInformation.setMaximumSize(pnInformation.getPreferredSize() );
			/*set BoxLayout cho pnInformation*/
			pnInformation.setLayout(new BoxLayout(pnInformation, BoxLayout.Y_AXIS));
			pnInformation.setOpaque(false);
			/*set Border cho pnInformation*/
			Border titleBorderInfor;
			Border blueBorderInfor = BorderFactory.createLineBorder(Color.GRAY);
			titleBorderInfor = BorderFactory.createTitledBorder(blueBorderInfor,"Thông tin Máy ATM",
			        TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
			pnInformation.setBorder(titleBorderInfor);
			pnInformation.setOpaque(false);
			
			JLabel lblCodeATM = new JLabel("Mã Máy ATM :");
			txtCodeATM = new JTextField(20);		
			
			JLabel lblMoneyATM = new JLabel("Số Dư Máy ATM :");
			/*format cho số dư máy ATM */
			MoneyATMFormat = NumberFormat.getNumberInstance();
			txtMoneyATM = new JFormattedTextField(MoneyATMFormat);
			/*Group layout để canh chỉnh lề cho các Jlabel và JtextField*/
			GroupLayout infolayout = new GroupLayout(pnInformation);
			pnInformation.setLayout(infolayout);
			infolayout.setAutoCreateGaps(true);
			infolayout.setAutoCreateContainerGaps(true);
			
			infolayout.setHorizontalGroup(infolayout.createSequentialGroup()
				.addGroup(infolayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
					.addComponent(lblCodeATM, 0, 100, Short.MAX_VALUE)
					.addComponent(lblMoneyATM)
				)
				.addGroup(infolayout.createParallelGroup()
					.addComponent(txtCodeATM)
					.addComponent(txtMoneyATM)
				)
			);
			
			infolayout.setVerticalGroup(infolayout.createSequentialGroup()
				.addGroup(infolayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(lblCodeATM)
					.addComponent(txtCodeATM)
				)			
				.addGroup(infolayout.createParallelGroup()
						.addComponent(lblMoneyATM)
						.addComponent(txtMoneyATM)
					)
			);
			
			JPanel pnAdress = new JPanel();
			pnAdress.setPreferredSize(new Dimension(340,120));
			pnAdress.setMaximumSize(pnAdress.getPreferredSize() );
			/*set Boxlayout cho pnAdress*/
			pnAdress.setLayout(new BoxLayout(pnAdress, BoxLayout.Y_AXIS));
			pnAdress.setOpaque(false);
			/*set Border cho pnAdress*/
			Border titleBorderAdress;
			Border blueBorderAdress = BorderFactory.createLineBorder(Color.GRAY);
			titleBorderAdress = BorderFactory.createTitledBorder(blueBorderAdress,"Địa Chỉ",
			        TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
			pnAdress.setBorder(titleBorderAdress);
			pnAdress.setOpaque(false);
			

			JLabel lblDistricts = new JLabel("Quận :");
			cboDistricts=new JComboBox<>();
			cboDistricts.addItem("Chon Quận");
			
			JLabel lblWards = new JLabel("Phường :");
			cboWards=new JComboBox<>();
			cboWards.addItem("Chọn Phường");
			
			JLabel lblStreets = new JLabel("Tên Đường :");
			txtStreets = new JTextField(20);
			/*Group layout để canh chỉnh lề cho các Jlabel và JtextField*/
			GroupLayout adressLayout = new GroupLayout(pnAdress);
			pnAdress.setLayout(adressLayout);
			adressLayout.setAutoCreateGaps(true);
			adressLayout.setAutoCreateContainerGaps(true);
			
			adressLayout.setHorizontalGroup(adressLayout.createSequentialGroup()
				.addGroup(adressLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
					.addComponent(lblDistricts, 0, 100, Short.MAX_VALUE)
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
				.addGroup(adressLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
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
			
			JPanel pnMethod = new JPanel();
			pnMethod.setOpaque(false);
			btnAddATM = new JButton("Thêm");
			btnEditATM = new JButton("Sửa");
			btnDeleteATM = new JButton("Xóa");
			btnCancelATM = new JButton("Hủy");
			btnEditATM.setEnabled(false);
			btnDeleteATM.setEnabled(false);
			pnMethod.add(btnAddATM);
			pnMethod.add(btnEditATM);
			pnMethod.add(btnDeleteATM);
			pnMethod.add(btnCancelATM);
			
			pnAction.add(pnBlank);
			pnAction.add(pnInformation);
			pnAction.add(pnAdress);
			pnAction.add(pnMethod);
			
			pnMain.add(pnAction);
			this.add(pnMain);
		}catch (Exception e) {
			
		}
		
		
	}

	private void addEvents() {
		tbl.addMouseListener(eventChooseRow);
		cboDistricts.addActionListener(eventChooseDistricts);
		btnAddATM.addActionListener(eventAddATM);
		btnEditATM.addActionListener(eventEditATM);
		btnDeleteATM.addActionListener(eventDeleteATM);
		btnCancelATM.addActionListener(eventCancelATM);
		txtSeacher.getDocument().addDocumentListener(eventSearch);
	}
	/*Sự kiện khi click vào các dòng trong table*/
	MouseAdapter eventChooseRow = new MouseAdapter() {
    	public void mouseClicked(MouseEvent e) {
    		txtCodeATM.setEditable(false);
    		/*Lấy index số dòng khi click*/
    		int col = tbl.getSelectedRow();
    		String[] row = new String[5];	    		
    		row[0] = (String) tbl.getValueAt(col, 0);
    		row[1] = (String) tbl.getValueAt(col, 1);
    		txtCodeATM.setText(row[0]);
    		txtStreets.setText(row[1]);
    		/*duyệt mảng ArrayList để lấy các giá trị đưa vào Ô textfield*/
			for(int i=0;i<arrAtm.size();i++) {
				if(row[0].equals(arrAtm.get(i).getCodeATM())) {
					((JFormattedTextField) txtMoneyATM).setValue(new Double(arrAtm.get(i).getAmountATM()));
					cboDistricts.setSelectedIndex(arrAtm.get(i).getDistrictATM());
					String nameWards = adress.SeclectStringWards(arrAtm.get(i).getWardATM());
					cboWards.setSelectedItem(nameWards);					
				}
			}
			btnAddATM.setEnabled(false);
			btnEditATM.setEnabled(true);
			btnDeleteATM.setEnabled(true);
    	}
    };
	/*Sự kiện khi Button Hủy thay đổi sẽ gọi phương thức resetAll*/
	ActionListener eventCancelATM = new ActionListener() {
		public void actionPerformed(ActionEvent e) {			
			resetAll();	
		}
    };
    /*Sự kiện lấy giá trị từ textfield và combobox đưa vào database*/
    ActionListener eventAddATM = new ActionListener() {
		public void actionPerformed(ActionEvent e) {			
			atm = getValueIntput();	
			/*Lấy các giá trị từ phương thức getValueIntput*/
			if(atm==null) {
				
			}else {
				/*kiểm tra đã thêm dữ liệu thành công chưa từ phương thức addAtm của class MachineATMDb*/
				int check =MachineATMDb.addAtm(atm);
				if (check>-1) {
					System.out.println("Thành công");
				}	
				/*cập Nhập lại ArrayList rồi in ra table*/
				arrAtmAll = MachineATMDb.getAtmList();
				updateArrAtm();
				printListAtm();
				resetAll();
			}
			
		}
    };
    /*Sự kiện Sửa các giá trị rồi đưa lên database*/
    ActionListener eventEditATM = new ActionListener() {
		public void actionPerformed(ActionEvent e) {	
			/*Lấy các giá trị từ phương thức getValueIntput*/
			atm = getValueIntput();			
			if(atm==null) {
				
			}else {
				String street = txtStreets.getText();
				String code = txtCodeATM.getText();
				
				int keyDistricts = cboDistricts.getSelectedIndex();
				String wards = (String) cboWards.getSelectedItem();
				int keyWards = adress.SeclectIdWards(wards);
				int balance = ((Number) ((JFormattedTextField) txtMoneyATM).getValue()).intValue();
				for(MachineATM x:arrAtmAll) {
					/*validate khi sữa*/
					if(code.equals(x.getCodeATM())) {
						if(
						keyDistricts==x.getDistrictATM()
						&&keyWards==x.getWardATM()
						&&street.equals(x.getStreetATM())
						&&balance==x.getAmountATM()) {
							String msg = "Chưa Dòng Nào Được Sửa \n ";
							JOptionPane.showMessageDialog(null, msg, "Sửa Máy ATM!!!", JOptionPane.INFORMATION_MESSAGE);
						}else {
							/*kiểm tra đã sửa dữ liệu thành công chưa từ phương thức editAtm của class MachineATMDb*/
							int check =MachineATMDb.editAtm(atm);
							if (check>-1) {
								String msg = "Sửa Thành Công Máy : "+"\nMã Máy"+txtCodeATM.getText()
											+"\nQuận : "+cboDistricts.getSelectedItem()
											+"\nPhường : "+cboWards.getSelectedItem()
											+"\nĐường : "+txtStreets.getText();
								JOptionPane.showMessageDialog(null, msg, "Sữa máy ATM!!!", JOptionPane.INFORMATION_MESSAGE);
//								
							}
						}
					}
					/*cập Nhập lại ArrayList rồi in ra table*/
					arrAtmAll = MachineATMDb.getAtmList();		
					updateArrAtm();
					printListAtm();
					resetAll();
				}
				
			}
			
		}
    };
    /*Sự kiện Xóa các giá trị trong database*/
    ActionListener eventDeleteATM = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String msg = "Xóa Bạn Có Muốn Xóa Máy ATM : "+"\nMã Máy"+txtCodeATM.getText()
			+"\nQuận : "+cboDistricts.getSelectedItem()
			+"\nPhường : "+cboWards.getSelectedItem()
			+"\nĐường : "+txtStreets.getText();
			int i = JOptionPane.showConfirmDialog(null, msg, "Xóa Máy ATM!!!", JOptionPane.YES_NO_OPTION);			
			if (i == JOptionPane.YES_OPTION) {
				String code = txtCodeATM.getText();
				/*kiểm tra đã sửa dữ liệu thành công chưa từ phương thức delAtm của class MachineATMDb*/
				int check =MachineATMDb.delAtm(code);
				if(check>-1) {
					String msgXoa = "Xóa Thành Công Máy ATM \n"+"Mã Máy : "+txtCodeATM.getText()
					+"\nQuận : "+cboDistricts.getSelectedItem()
					+"\nPhường : "+cboWards.getSelectedItem()
					+"\nĐường : "+txtStreets.getText();
					JOptionPane.showMessageDialog(null, msgXoa, "Xóa Máy ATM!!!", JOptionPane.INFORMATION_MESSAGE);
					arrAtmAll = MachineATMDb.getAtmList();
					updateArrAtm();
					printListAtm();
					resetAll();
				}
			}
			
		}
    };
	/*Sự kiện khi chọn quận sẽ in vào combobox Phường*/
	ActionListener eventChooseDistricts = new ActionListener() {
		public void actionPerformed(ActionEvent e) {			
			int keys = cboDistricts.getSelectedIndex();
			if (keys==0) {
				cboWards.removeAllItems();
				cboWards.addItem("Chọn Phường");
			}else {
				arrAdress = adress.SeclectWard(keys);
				cboWards.removeAllItems();
				for(String x:arrAdress) {
					cboWards.addItem(x);
				}
			}						
		}
    };
    /*Sự kiện khi tìm kiếm sẽ gọi phương thức searcher*/
    private DocumentListener eventSearch = new DocumentListener() {		
		@Override
		public void changedUpdate(DocumentEvent e) {
			searcher();
		}
		@Override
		public void insertUpdate(DocumentEvent e) {
			searcher();
		}
		@Override
		public void removeUpdate(DocumentEvent e) {
			searcher();
		}
	};
    /*Tìm kiếm tên đường theo ArrayList*/
	private void searcher() {
		String streets = txtSeacher.getText();
		list.setRowCount(0);
		/*Duyệt mảng */
		for(MachineATM x:arrAtmAll) {		
			if(x.getStreetATM().toUpperCase().trim().indexOf(streets.toUpperCase().trim()) > -1) {				
				String[] row = {x.getCodeATM(),x.getStreetATM(),String.format("%,d", (long) x.getAmountATM())+" VNĐ"};
				list.addRow(row);			
			}			
		}
	}
    /*Cập nhập ArrayList*/
    private ArrayList<MachineATM> updateArrAtm() {    	
    	return arrAtm = arrAtmAll;
    }
    /*phương thức in vào các dòng trong bảng từ Arraylist*/
    private void printListAtm() {
    	list.setRowCount(0);
    	for (MachineATM atm : arrAtm) {    		
			String[] row = {atm.getCodeATM(),atm.getStreetATM(),String.format("%,d", (long) atm.getAmountATM())+" VNĐ"};
			list.addRow(row);
		}
    }
    /*Phương thức lấy giá trị của các ô TextField và combobox*/
    private MachineATM getValueIntput() {
    	atm = new MachineATM();
		String street = txtStreets.getText();
		String code = txtCodeATM.getText();
		
		int keyDistricts = cboDistricts.getSelectedIndex();
		String wards = (String) cboWards.getSelectedItem();
		int keyWards = adress.SeclectIdWards(wards);
		
		/*Validate các giá trị lấy về*/
		if(street.isEmpty()&&code.isEmpty()&& keyDistricts==0 && txtMoneyATM.getText().isEmpty()) {
			String msg = "Chưa Nhập!!!\nThông Tin Của Máy ATM";
			JOptionPane.showMessageDialog(null, msg, "Lỗi Chưa Nhập!!!", JOptionPane.INFORMATION_MESSAGE);
			return atm=null;
		}else if(code.isEmpty()||txtMoneyATM.getText().isEmpty()){
			txtCodeATM.requestFocus();
			String msg = "Phải Điền Đầy Đủ!!!\nPhần Thông Tin Máy ATM";
			JOptionPane.showMessageDialog(null, msg, "Lỗi Chưa Nhập!!!", JOptionPane.INFORMATION_MESSAGE);
			return atm=null;
		}else if(street.isEmpty()|| keyDistricts==0){
			cboDistricts.showPopup();
			String msg = "Phải Điền Đầy Đủ!!!\nPhần Địa Chỉ";
			JOptionPane.showMessageDialog(null, msg, "Lỗi Chưa Nhập!!!", JOptionPane.INFORMATION_MESSAGE);
			return atm=null;
		}else {
			int balance = ((Number) ((JFormattedTextField) txtMoneyATM).getValue()).intValue();
			atm.add(code,keyDistricts,keyWards,street,balance);
			return atm;
		}
		
    }
    /*phương thức reset về trống cho các ô textfield và combobox*/
    private void resetAll() {
    	txtCodeATM.setText("");
    	txtCodeATM.setEditable(true);
    	txtMoneyATM.setText("");
    	cboDistricts.setSelectedIndex(0);
    	txtStreets.setText("");
    	txtSeacher.setText("");
    	btnAddATM.setEnabled(true);
    	btnEditATM.setEnabled(false);
		btnDeleteATM.setEnabled(false);
		tbl.clearSelection();
		
    }
}
