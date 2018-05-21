package ffse1703020.qltv.model;

import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

public class MyException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ConnectDB cn = new ConnectDB();
	static Connection conn = (Connection) ConnectDB.getConnect();
	
	public MyException() {
		super();
	}
	public static boolean ChekEmpty(String str) throws MyException {
		if(str.equals("")) {
			JOptionPane.showMessageDialog(null, "Không được để trống!");
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
	public static boolean ChekMSach(String str) throws MyException {
		try {
		String sql = "select ma_sach from sach ";
		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery(sql);
		while (result.next()) {
			if (str.equals(result.getString(1))) {
				JOptionPane.showMessageDialog(null, "Mã sách đã tồn tại!");
				return false;
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return true;
}
	public static boolean ChekMBDoc(String str) throws MyException {
		try {
		String sql = "select ma_ban_doc from ban_doc ";
		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery(sql);
		while (result.next()) {
			if (str.equals(result.getString(1))) {
				JOptionPane.showMessageDialog(null, "Mã thành viên đã tồn tại!");
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
		String sql = "select email from ban_doc ";
		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery(sql);
		while (result.next()) {
			if (str.equals(result.getString(4))) {
				JOptionPane.showMessageDialog(null, "Email  đã tồn tại!");
				return false;
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return true;
}
	public static boolean ChekTraSach(String str) throws MyException {
		try {
		String sql = "select tinh_trang from muon_tra_sach ";
		Statement statement = conn.createStatement();
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