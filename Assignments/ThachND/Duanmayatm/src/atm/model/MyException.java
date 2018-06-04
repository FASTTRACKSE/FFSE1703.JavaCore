package atm.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

public class MyException extends Exception {
	private static final long serialVersionUID = 1L;
	GetDatabase conn = new GetDatabase();
	static Connection db = (Connection) GetDatabase.getConnect();
	
	public MyException() {
		super();
	}
	public static boolean ChekEmpty(String str) throws MyException {
		if(str.equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập thông tin!");
			return false;
		}
		return true;
		
	}
	public static boolean ChekSo(String str) throws MyException {
		if(str.equals("")) {
			JOptionPane.showMessageDialog(null, "Không được để trống!");
			return false;
		}else {
			try {
				Integer.parseInt(str);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập số!");
				return false;
			}
			}
		int so = Integer.parseInt(str);
		if(so <0) {
			JOptionPane.showMessageDialog(null, "Không được số âm!");
			return false;
		}
		return true;
			
		
	}
	public static boolean ChekMaKh(String str) throws MyException {
		try {
		String sql = "select ma_kh from khachhang ";
		Statement statement = (Statement) db.createStatement();
		ResultSet result = statement.executeQuery(sql);
		while (result.next()) {
			if (str.equals(result.getString(1))) {
				JOptionPane.showMessageDialog(null, "Mã khách hàng đã tồn tại!");
				return false;
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return true;
}
	public static boolean ChekMaMay(String str) throws MyException {
		try {
		String sql = "select ma_may from atm ";
		Statement statement = (Statement) db.createStatement();
		ResultSet result = statement.executeQuery(sql);
		while (result.next()) {
			if (str.equals(result.getString(1))) {
				JOptionPane.showMessageDialog(null, "Mã máy đã tồn tại!");
				return false;
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return true;
}
	public static boolean ChekEmail(String str) throws MyException {
		try {
			Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
					Pattern.CASE_INSENSITIVE);
			Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(str);
			if (!matcher.find()) {
				JOptionPane.showMessageDialog(null, "Nhập Email không đúng định dạng!");
				return false;
			} else{
			String sql = "select email from khachhang ";
			Statement statement = (Statement) db.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				if (str.equals(result.getString(1))) {
					JOptionPane.showMessageDialog(null, "Email  đã tồn tại!");
					return false;
				}
			}
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	public static boolean ChekMaGd(String str) throws MyException {
		try {
		String sql = "select ma_gd from giaodichatm ";
		Statement statement = (Statement) db.createStatement();
		ResultSet result = statement.executeQuery(sql);
		while (result.next()) {
			if (str.equals(result.getString(5))) {
				JOptionPane.showMessageDialog(null, "Đã trả!");
				return false;
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
		return true;
		
	}
}
