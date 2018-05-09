package ffse1703020.qltv.model;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;

public class MyException extends Exception {
	private static final long serialVersionUID = 3036003619876834868L;
	private SachModel sachModel = new SachModel();
	private BanDocModel banDocModel = new BanDocModel();
	private String error;

	public MyException() {

	}

	public MyException(String error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return this.error;
	}

	public boolean checkEmpty(PlaceholderTextField txtFld) throws MyException {
		String s = getText(txtFld);
		if (s == null) {
			return false;
		}
		reset(txtFld);
		return true;
	}

	public boolean checkNumber(PlaceholderTextField txtFld) throws MyException {
		String s = getText(txtFld);
		if (s == null) {
			return false;
		}
		try {
			Integer.parseInt(s);
		} catch (Exception e) {
			txtFld.setBorder(BorderFactory.createLineBorder(Color.RED));
			txtFld.setToolTipText("Vui lòng nhập đúng định dạng số!");
			return false;
		}
		reset(txtFld);
		return true;
	}

	public boolean checkDienThoai(PlaceholderTextField txtFld) throws MyException {
		String s = getText(txtFld);
		if (s == null) {
			return false;
		}
		try {
			Integer.parseInt(s.replaceAll("\\s", ""));
			if (s.length() < 10 || s.length() > 11) {
				txtFld.setBorder(BorderFactory.createLineBorder(Color.RED));
				txtFld.setToolTipText("Vui lòng nhập số điện thoại hợp lệ!");
				return false;
			}
			String[] where = { "dien_thoai" };
			String[] value = { s };
			ResultSet rs = banDocModel.getBanDoc(where, value);
			while ((rs != null) && (rs.next())) {
				txtFld.setBorder(BorderFactory.createLineBorder(Color.RED));
				txtFld.setToolTipText("Số điện thoại đã tồn tại!");
				return false;
			}
		} catch (Exception e) {
			txtFld.setBorder(BorderFactory.createLineBorder(Color.RED));
			txtFld.setToolTipText("Vui lòng nhập số điện thoại hợp lệ!");
			return false;
		}
		reset(txtFld);
		return true;
	}

	@SuppressWarnings("rawtypes")
	public boolean checkCmbBx(JComboBox cmbBx) throws MyException {
		int i = cmbBx.getSelectedIndex();
		if (i == -1) {
			cmbBx.setBorder(BorderFactory.createLineBorder(Color.RED));
			cmbBx.setToolTipText("Vui lòng chọn dữ liệu!");
			return false;
		}
		reset(cmbBx);
		return true;
	}

	private Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

	public boolean checkEmail(PlaceholderTextField txtFld) throws MyException {
		String s = getText(txtFld);
		if (s == null) {
			return false;
		}
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(s);
		if (!matcher.find()) {
			txtFld.setBorder(BorderFactory.createLineBorder(Color.RED));
			txtFld.setToolTipText("Vui lòng đúng định dạng email!");
			return false;
		}
		String[] where = { "email" };
		String[] value = { s };
		try {
			ResultSet rs = banDocModel.getBanDoc(where, value);
			while ((rs != null) && (rs.next())) {
				txtFld.setBorder(BorderFactory.createLineBorder(Color.RED));
				txtFld.setToolTipText("Email đã tồn tại!");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		reset(txtFld);
		return true;
	}

	public boolean checkTenSach(PlaceholderTextField txtFldTenSach, PlaceholderTextField txtFldTacGia)
			throws MyException {
		String s = getText(txtFldTenSach);
		if (s == null) {
			return false;
		}
		try {
			if (sachModel.isExistSach(s, txtFldTacGia.getText())) {
				txtFldTenSach.setBorder(BorderFactory.createLineBorder(Color.RED));
				txtFldTenSach.setToolTipText("Sách đã tồn tại trong kho!");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		reset(txtFldTenSach);
		return true;
	}

	private String getText(PlaceholderTextField txtFld) {
		String s = txtFld.getText();
		if (s.isEmpty()) {
			txtFld.setBorder(BorderFactory.createLineBorder(Color.RED));
			txtFld.setToolTipText("Vui lòng nhập dữ liệu!");
			return null;
		}
		return s;
	}

	public void reset(PlaceholderTextField txtFld) {
		txtFld.setBorder(null);
		txtFld.updateUI();
		txtFld.setToolTipText(null);
	}

	@SuppressWarnings("rawtypes")
	public void reset(JComboBox cmbBx) {
		cmbBx.setBorder(null);
		cmbBx.updateUI();
		cmbBx.setToolTipText(null);
	}
}