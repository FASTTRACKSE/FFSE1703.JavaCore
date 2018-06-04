package ffse1703022.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
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
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

import com.toedter.calendar.JTextFieldDateEditor;

import ffse1703022.model.BienLai;
import ffse1703022.model.BienLaiModel;

public class NhapBLUI extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtMaCT, txtMaCTKH,  txtChiSoMoi;
	private JTextFieldDateEditor txtDate;
	@SuppressWarnings({ "rawtypes", "unused" })
	private JComboBox cboThang, cboNam;
	private JButton btnAdd, btnRep, btnDel, btnSearch,btnOk;
	private DefaultTableModel dm;
	private JTable tbl;
	private BienLaiModel bienLaiModel = new BienLaiModel();
	private JMonthChooser monthChoose;
	private JYearChooser yearChoose;

	public NhapBLUI() {
		addControls();
		addEvents();
		
	}

	public void addControls() {
		JPanel pnFlow = new JPanel();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		pnFlow.setLayout(new FlowLayout());

		JPanel boxMaCT = new JPanel();
		JPanel boxMaCTKH = new JPanel();
		JPanel Boxdate = new JPanel();
		JPanel Boxtable = new JPanel();
		JPanel Boxbtn = new JPanel();
		JPanel Boxyear = new JPanel();
		JPanel BoxchiSo = new JPanel();
		//
		JLabel jblMaCT = new JLabel("Mã công tơ");
		txtMaCT = new JTextField(20);
		btnSearch = new JButton("Tìm kiếm");
		boxMaCT.add(jblMaCT);
		boxMaCT.add(txtMaCT);
		boxMaCT.add(btnSearch);
		this.add(boxMaCT);
		//
		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Danh sách");
		Boxtable.setBorder(borderTitle);
		dm = new DefaultTableModel();
		dm.addColumn("Mã biên lai");
		dm.addColumn("Mã công tơ");
		dm.addColumn("Ngày nhập");
		dm.addColumn("Chu kì nhập");
		dm.addColumn("Chỉ số công tơ");
		dm.addColumn("Chỉ số công tơ mới");
		dm.addColumn("Số tiền");

		tbl = new JTable(dm);

		JScrollPane sc = new JScrollPane(tbl);

		Boxtable.setLayout(new BorderLayout());
		Boxtable.add(sc, BorderLayout.CENTER);
		this.add(Boxtable);
		//
		JLabel jblMaCTKH = new JLabel("Mã Công Tơ");
		jblMaCTKH.setPreferredSize(new Dimension(100, 20));

		txtMaCTKH = new JTextField(20);
		boxMaCTKH.add(jblMaCTKH);
		boxMaCTKH.add(txtMaCTKH);
		this.add(boxMaCTKH);
		//
		JLabel jbldate = new JLabel("Ngày nhập");
		jbldate.setPreferredSize(jblMaCTKH.getPreferredSize());

		JDateChooser dateChoose = new JDateChooser();
		dateChoose.setDateFormatString("yyyy-MM-dd");
		txtDate = (JTextFieldDateEditor) dateChoose.getDateEditor();
		dateChoose.setPreferredSize(new Dimension(170, 20));

		Boxdate.add(jbldate);
		Boxdate.add(dateChoose);
		this.add(Boxdate);
		//
		JLabel jblYear = new JLabel("Chu kì");
		jblYear.setPreferredSize(jblMaCTKH.getPreferredSize());

		monthChoose = new JMonthChooser();
		monthChoose.setPreferredSize(new Dimension(100, 20));

		yearChoose = new JYearChooser();
		yearChoose.setPreferredSize(new Dimension(70, 20));

		Boxyear.add(jblYear);

		Boxyear.add(monthChoose);
		Boxyear.add(yearChoose);
		this.add(Boxyear);

		//
		JLabel jblchiso = new JLabel("Chỉ số công tơ");
		jblchiso.setPreferredSize(jblMaCTKH.getPreferredSize());

		txtChiSoMoi = new JTextField(20);
		BoxchiSo.add(jblchiso);
		BoxchiSo.add(txtChiSoMoi);
		this.add(BoxchiSo);
		//
		btnAdd = new JButton("Thêm");
		btnRep = new JButton("Sửa");
		btnDel = new JButton("Xóa");
		btnOk = new JButton("Tạo");

		Boxbtn.add(btnAdd);
		Boxbtn.add(btnRep);
		Boxbtn.add(btnDel);
		Boxbtn.add(btnOk);

		this.add(Boxbtn);
	}

	public void addEvents() {
		btnSearch.addActionListener(new SearchBL());
		btnAdd.addActionListener(new AddBL());
		tbl.addMouseListener(new ClickBL());
		btnRep.addActionListener(new EditBL());
		btnDel.addActionListener(new DelBL());
		btnOk.addActionListener(new NewBL());
	}
	

	public class SearchBL implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				dm.setRowCount(0);
				ResultSet rs;
				String maCT=txtMaCT.getText();
				rs= bienLaiModel.searchBL(maCT);
				while(rs.next()) {
					String[] row = { rs.getString("ID"), rs.getString("MaCT"), rs.getString("Date"),
							rs.getString("ChuKy"), rs.getString("ChiSo"), rs.getString("ChiSoMoi"),
							rs.getString("SoTien")};
					dm.addRow(row);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public class AddBL implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				// .... get dữ liệu từ form
				String maCT =txtMaCTKH.getText() ;
				String ngay= txtDate.getText();
				int thang = monthChoose.getMonth() + 1;
				int nam = yearChoose.getYear();
				float chiSoCu = bienLaiModel.getChiSoCu(maCT, thang, nam);
				String chuKy = thang + "/" + nam;
				if(maCT.equals("")|| ngay.equals("")||txtChiSoMoi.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!!");
				} else if (Float.parseFloat(txtChiSoMoi.getText())<chiSoCu) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập chỉ số mới lớn hơn chỉ số cũ!!");

				}else if(chiSoCu==-1) {
					JOptionPane.showMessageDialog(null, "Biên lai tháng " + (thang -1)+ "/"+nam+" chưa tồn tại!!!");
				}else if(bienLaiModel.getBL(maCT, chuKy)==1){
					JOptionPane.showMessageDialog(null, "Biên lai tháng " + (thang)+ "/"+nam+" đã tồn tại!!!");

				}else {
					float chiSoMoi= Float.parseFloat(txtChiSoMoi.getText());
					
					System.out.println(chuKy);
					int tienDien=calcAmount(chiSoMoi-chiSoCu);
					BienLai bienlai=new BienLai(maCT,ngay,chuKy,chiSoCu,chiSoMoi,tienDien);
				
					bienLaiModel.addBL(bienlai);
					JOptionPane.showMessageDialog(null, "Thêm thành công!!");
					btnSearch.doClick();
					btnOk.doClick();
				}
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	int calcAmount(float meterNumber) throws SQLException {
		int rate[] = { 0, 1549, 1600, 1858, 2340, 2615, 2701 };
		int step[] = { 0, 50, 50, 100, 100, 100 };
		int i = 1;
		int subtotal, total = 0;
		while (meterNumber > 0) {
			if (i < 6) {
				meterNumber = meterNumber - step[i];
				if (meterNumber > 0) {
					subtotal = step[i] * rate[i];
					total += subtotal;
				} else {
					subtotal = (int) ((meterNumber + step[i]) * rate[i]);
					total += subtotal;
				}
				i++;
			} else {
				subtotal = (int) (meterNumber * rate[i]);
				total += subtotal;
				break;
			}
		}
		return total;
	}
	public class ClickBL extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			try {
				int row = tbl.getSelectedRow();
				if(row ==0 ) {
					txtChiSoMoi.setEditable(true);
				}else {
					txtChiSoMoi.setEditable(false);

				}
				txtMaCTKH.setEditable(false);
				monthChoose.setEnabled(false);
				yearChoose.setEnabled(false);
				txtMaCTKH.setText(tbl.getValueAt(row, 1).toString());
				txtDate.setText(tbl.getValueAt(row, 2).toString());
				String chuKy= tbl.getValueAt(row, 3).toString();
				String[] arr = chuKy.split("/");
				monthChoose.setMonth(Integer.parseInt(arr[0])-1);
				yearChoose.setYear(Integer.parseInt(arr[1]));
				txtChiSoMoi.setText(tbl.getValueAt(row, 5).toString());
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	public class EditBL implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				
				String maCT =txtMaCTKH.getText() ;
				String ngay= txtDate.getText();
				int thang = monthChoose.getMonth() + 1;
				int nam = yearChoose.getYear();
				float chiSoCu = Float.parseFloat(tbl.getValueAt(tbl.getSelectedRow(), 4).toString());
				float chiSoMoi= Float.parseFloat(txtChiSoMoi.getText());
				String chuKy = thang + "/" + nam;
				System.out.println(chuKy);
				int tienDien=calcAmount(chiSoMoi-chiSoCu);
				BienLai bienlai=new BienLai(maCT,ngay,chuKy,chiSoCu,chiSoMoi,tienDien);
				
				bienLaiModel.editBL(bienlai);
				JOptionPane.showMessageDialog(null, "Sửa thành công!!");
				btnSearch.doClick();

			}catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	public class DelBL implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				int mess = JOptionPane.showConfirmDialog(null, "Bạn muốn xóa?", "Thoát", JOptionPane.YES_NO_OPTION);
				

				if(mess== JOptionPane.YES_OPTION) {
					String maCT= txtMaCTKH.getText();
					int thang = monthChoose.getMonth() + 1;
					int nam = yearChoose.getYear();
					String chuKy = thang + "/" + nam;
					int rs;
					rs=bienLaiModel.delBL(maCT,chuKy);		
					if(rs>0) {
						JOptionPane.showMessageDialog(null, "Xóa thành công!!");
						btnSearch.doClick();
					}else {
						JOptionPane.showMessageDialog(null, "Xóa thất bại!!");

					}
				
				}
			}catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	public class NewBL implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				txtMaCTKH.setEditable(true);
				monthChoose.setEnabled(true);
				yearChoose.setEnabled(true);
				
				txtMaCTKH.setText("");
				txtDate.setText("");
				monthChoose.setMonth(0);
				yearChoose.setYear(2018);
				txtChiSoMoi.setText("");
			}catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
