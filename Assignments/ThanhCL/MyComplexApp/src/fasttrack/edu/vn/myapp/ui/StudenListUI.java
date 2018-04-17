package fasttrack.edu.vn.myapp.ui;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class StudenListUI extends JFrame {
	JTextField txtID, txtName, txtAge;
	JButton btnAdd, btnEdit, btnDel, btnExit;
	JTable table;

	public StudenListUI(String title) {
		super(title);
		addControls();
		addEvents();
	}

	public void addControls() {
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		JPanel pnTitle = new JPanel();
		JLabel lblTitle = new JLabel("Chương trình Quản lí sinh viên");
		Font fontTitle = new Font("arial", Font.BOLD, 20);
		lblTitle.setFont(fontTitle);
		pnTitle.add(lblTitle);

		JPanel pnInput1 = new JPanel();
		JLabel lblTitle1 = new JLabel("Mã sinh viên");
		txtID = new JTextField(15);
		pnInput1.add(lblTitle1);
		pnInput1.add(txtID);

		JPanel pnInput2 = new JPanel();
		JLabel lblTitle2 = new JLabel("Tên sinh viên");
		txtName = new JTextField(15);
		pnInput2.add(lblTitle2);
		pnInput2.add(txtName);

		JPanel pnInput3 = new JPanel();
		JLabel lblTitle3 = new JLabel("Tuổi");
		txtAge = new JTextField(15);
		pnInput3.add(lblTitle3);
		pnInput3.add(txtAge);
		
		lblTitle1.setPreferredSize(lblTitle2.getPreferredSize());
		lblTitle3.setPreferredSize(lblTitle2.getPreferredSize());
		

		JPanel pnAction = new JPanel();
		btnAdd = new JButton("Thêm");
		btnEdit = new JButton("Sửa");
		btnDel = new JButton("Xóa");
		btnExit = new JButton("Thoát");
		pnAction.add(btnAdd);
		pnAction.add(btnEdit);
		pnAction.add(btnDel);
		pnAction.add(btnExit);

		JScrollPane scrollPane = new JScrollPane();
		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Mã", "Tên", "Tuổi" }));
		scrollPane.setViewportView(table);

		pnMain.add(pnTitle);
		pnMain.add(pnInput1);
		pnMain.add(pnInput2);
		pnMain.add(pnInput3);
		pnMain.add(pnAction);
		pnMain.add(scrollPane);

		con.add(pnMain);
	}

	ActionListener eventAdd = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			add();
		}
	};

	public void add() {
		String iD = txtID.getText();
		String name = txtName.getText();
		String age = txtAge.getText();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addRow(new Object[] { iD, name, age });

		txtID.setText("");
		txtName.setText("");
		txtAge.setText("");
	}

	ActionListener eventDel = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			del();
		}
	};

	public void del() {
		int row = table.getSelectedRow();
		int modelRow = table.convertRowIndexToModel(row);
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.removeRow(modelRow);
		
		txtID.setText("");
		txtName.setText("");
		txtAge.setText("");
	}

	MouseListener eventGetRow = new MouseAdapter() {
		public void mouseClicked(MouseEvent arg0) {
			getRow();
		}
	};

	public void getRow() {
		JTextField jTextField[] = new JTextField[]{txtID, txtName, txtAge};
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int numberOfColumn = table.getColumnCount();
		int indexOfSelectedRow = table.getSelectedRow();
		for (int i = 0; i < numberOfColumn; i++) {
			String value = (model.getValueAt(indexOfSelectedRow, i)).toString();
			jTextField[i].setText(value);
		}
	}
	
	ActionListener eventEdit = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			edit();
		}
	};
	
	public void edit() {
		JTextField jTextField[] = new JTextField[]{txtID, txtName, txtAge};
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int numberOfColumn = table.getColumnCount();
		int indexOfSelectedRow = table.getSelectedRow();
		for (int i = 0; i < numberOfColumn; i++) {
			String value = jTextField[i].getText();
			model.setValueAt(value, indexOfSelectedRow, i);
		}
	}

	public void addEvents() {
		btnAdd.addActionListener(eventAdd);
		btnDel.addActionListener(eventDel);
		btnEdit.addActionListener(eventEdit);
		table.addMouseListener(eventGetRow);
		btnExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
	}

	public void showWindow() {
		this.setSize(600, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}