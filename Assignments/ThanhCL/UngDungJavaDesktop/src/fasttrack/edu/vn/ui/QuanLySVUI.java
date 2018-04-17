package fasttrack.edu.vn.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

public class QuanLySVUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelInput;
	private JTextField MaSV, TenSV, TuoiSV;
	private JComboBox cboLop;
	private JButton btnAdd, btnEdit, btnDel, btnExit, btnImport, btnExport;
	private JScrollPane scrollPane;
	private JTable table;
	private String[] columnNames = new String[] { "Mã", "Tên", "Tuổi" };
	private Object[][] data = null;
	private DefaultTableModel model = new DefaultTableModel(data, columnNames);

	public void showWindow() {
		this.setSize(450, 390);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public QuanLySVUI(String tieude) {
		super(tieude);
		addControls();
		addEvents();
	}

	public void addControls() {
		Container con = getContentPane();
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(0, 0));

		JLabel header = new JLabel("Chương trình quản lí sinh viên");
		header.setPreferredSize(new Dimension(100, 30));
		header.setFont(new Font("Tahoma", Font.BOLD, 12));
		header.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel panelCenter = new JPanel();
		panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));

		panelInput = new JPanel();
		panelInput.setLayout(new BoxLayout(panelInput, BoxLayout.Y_AXIS));

		panel.add(header, BorderLayout.NORTH);
		panel.add(panelCenter, BorderLayout.CENTER);

		addInput();
		addButton();
		panelCenter.add(panelInput);

		addTable();
		panelCenter.add(scrollPane);

		con.add(panel);
	}

	public void addEvents() {
		btnAdd.addActionListener(new AddListener());
		btnEdit.addActionListener(new EditListener());
		btnDel.addActionListener(new DelListener());
		btnExit.addActionListener(new ExitListener());
		btnImport.addActionListener(new ImportListener());
		btnExport.addActionListener(new ExportListener());

		table.addMouseListener(new MouseClickRow());
	}

	private void addInput() {
		JPanel panelInput_ChonLop = new JPanel();
		JLabel lblChonLop = new JLabel("Chọn lớp:");
		lblChonLop.setPreferredSize(new Dimension(80, 20));
		cboLop = new JComboBox();
		cboLop.addItem("FFSE1701");
		cboLop.addItem("FFSE1702");
		cboLop.addItem("FFSE1703");
		cboLop.addItem("FFSE1704");
		cboLop.setPreferredSize(new Dimension(120, 30));

		panelInput_ChonLop.add(lblChonLop);
		panelInput_ChonLop.add(cboLop);

		JPanel panelInput_MaSV = new JPanel();
		JLabel lblMaSV = new JLabel("Mã sinh viên:");
		lblMaSV.setPreferredSize(new Dimension(120, 20));
		MaSV = new JTextField();
		MaSV.setColumns(20);

		panelInput_MaSV.add(lblMaSV);
		panelInput_MaSV.add(MaSV);

		JPanel panelInput_TenSV = new JPanel();
		JLabel lblTenSV = new JLabel("Tên sinh viên:");
		lblTenSV.setPreferredSize(new Dimension(120, 20));
		TenSV = new JTextField();
		TenSV.setColumns(20);

		panelInput_TenSV.add(lblTenSV);
		panelInput_TenSV.add(TenSV);

		JPanel panelInput_TuoiSV = new JPanel();
		JLabel lblTuoiSV = new JLabel("Tuổi:");
		lblTuoiSV.setPreferredSize(new Dimension(120, 20));
		TuoiSV = new JTextField();
		TuoiSV.setColumns(20);

		panelInput_TuoiSV.add(lblTuoiSV);
		panelInput_TuoiSV.add(TuoiSV);

		panelInput.add(panelInput_ChonLop);
		panelInput.add(panelInput_MaSV);
		panelInput.add(panelInput_TenSV);
		panelInput.add(panelInput_TuoiSV);
	}

	private void addButton() {
		JPanel panelButton = new JPanel();

		btnAdd = new JButton("Thêm");
		btnEdit = new JButton("Sửa");
		btnDel = new JButton("Xóa");
		btnExit = new JButton("Thoát");
		btnImport = new JButton("Nhập");
		btnExport = new JButton("Xuất");

		panelButton.add(btnAdd);
		panelButton.add(btnEdit);
		panelButton.add(btnDel);
		panelButton.add(btnExit);
		panelButton.add(btnImport);
		panelButton.add(btnExport);

		panelInput.add(panelButton);
	}

	@SuppressWarnings("serial")
	private void addTable() {
		scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder(new LineBorder(new Color(255, 0, 0)), "Danh sách", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));

		table = new JTable() {
			public boolean getScrollableTracksViewportWidth() {
				return getPreferredSize().width < getParent().getWidth();
			}
		};
		JTableHeader tableHeader = table.getTableHeader();
		// Canh giữa cell header table
		tableHeader.setDefaultRenderer(new HeaderRenderer(table));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBorder(new LineBorder(Color.LIGHT_GRAY));
		table.setModel(model);
		scrollPane.setViewportView(table);
	}

	private static class HeaderRenderer implements TableCellRenderer {
		DefaultTableCellRenderer renderer;

		public HeaderRenderer(JTable table) {
			renderer = (DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer();
			renderer.setHorizontalAlignment(JLabel.CENTER);
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int col) {
			return renderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
		}
	}

	private void setText(String maSV, String tenSV, String tuoiSV) {
		MaSV.setText(maSV);
		TenSV.setText(tenSV);
		TuoiSV.setText(tuoiSV);
	}

	private class AddListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			cboLop.showPopup();
		}
	}

	private class MouseClickRow extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			int row = table.getSelectedRow();
			String maSV = model.getValueAt(row, 0).toString();
			String tenSV = model.getValueAt(row, 1).toString();
			String tuoiSV = model.getValueAt(row, 2).toString();
			MaSV.setText(maSV);
			TenSV.setText(tenSV);
			TuoiSV.setText(tuoiSV);
		}
	}

	private class EditListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String maSV = MaSV.getText();
			String tenSV = TenSV.getText();
			String tuoiSV = TuoiSV.getText();
			int row = table.getSelectedRow();
			if (row != -1) {
				if (maSV.length() == 0 | tenSV.length() == 0 | tuoiSV.length() == 0) {
					maSV = model.getValueAt(row, 0).toString();
					tenSV = model.getValueAt(row, 1).toString();
					tuoiSV = model.getValueAt(row, 2).toString();
					setText(maSV, tenSV, tuoiSV);
				} else {
					model.setValueAt(maSV, row, 0);
					model.setValueAt(tenSV, row, 1);
					model.setValueAt(tuoiSV, row, 2);
					setText("", "", "");
				}
			}
		}
	}

	private class DelListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int row = table.getSelectedRow();
			if (row != -1) {
				model.removeRow(row);
				setText("", "", "");
			}
		}
	}

	private class ExitListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}

	private class ExportListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser fc = new JFileChooser();
			int i = fc.showSaveDialog((Component) e.getSource());
			if (i == JFileChooser.APPROVE_OPTION) {
				File f = fc.getSelectedFile();
				String filepath = f.getPath();
				try {
					BufferedWriter bw = new BufferedWriter(new FileWriter(filepath));
					for (int k = 0; k < table.getRowCount(); k++) {
						for (int j = 0; j < table.getColumnCount(); j++) {
							bw.write(table.getValueAt(k, j).toString() + ",");
						}
						bw.newLine();
					}
					bw.flush();
					bw.close();
				} catch (IOException ex) {
					System.err.println(ex);
				}
			}
		}
	}

	private class ImportListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser fc = new JFileChooser();
			int i = fc.showOpenDialog((Component) e.getSource());
			if (i == JFileChooser.APPROVE_OPTION) {
				File f = fc.getSelectedFile();
				String filepath = f.getPath();
				try {
					BufferedReader br = new BufferedReader(new FileReader(filepath));

					Object[] lines = br.lines().toArray();

					for (int j = 0; j < lines.length; j++) {
						String[] row = lines[j].toString().split(",");
						model.addRow(row);
					}
					br.close();

				} catch (FileNotFoundException ex) {
					System.err.println(ex);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
}