package ffse1703004.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import org.gjt.mm.mysql.Driver;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Statement;

public class DBConnection {
	static Connection conn = ketnoi("localhost", "ffse1703004_java", "root", "");
	ArrayList<KhachHangMD> arr = new ArrayList<KhachHangMD>();

	public static void main(String[] args) {
		if (conn != null) {
			System.out.println("Kết nối MYSQL thành công");
		}

		else {
			System.out.println("Kết nối MYSQL thất bại");
		}

	}

	public static Connection ketnoi(String strServer, String strDatabase, String strUser, String strPwd) {
		Connection conn = null;
		String strConnect = "jdbc:mysql://" + strServer + "/" + strDatabase
				+ "?useUnicode=true&characterEncoding=utf-8";

		Properties pro = new Properties();
		pro.put("user", strUser);
		pro.put("password", strPwd);
		try {
			com.mysql.jdbc.Driver driver = new Driver();
			conn = (Connection) driver.connect(strConnect, pro);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return conn;
	}

	public static boolean checkLogin(String username, String password) {
		try {
			String sql = "select * from Users where username = ? and password = ?";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1, username);
			stm.setString(2, password);
			ResultSet result = stm.executeQuery();
			if (!result.next()) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean checkConnection() {
		if (conn != null) {
			return true;
		} else {
			return false;
		}
	}

	public static ResultSet getQuan() {
		try {
			String sql = "select tenquan from Quan";
			Statement statement = (Statement) conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static ResultSet getPhuong(int idquan) {
		try {
			String sql = "select tenphuong from Phuong where idquan = ?";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setInt(1, idquan);
			ResultSet result = stm.executeQuery();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static ResultSet getMeterIdList() {
		try {
			String sql = "select mact from KhachHang";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);

			ResultSet result = stm.executeQuery();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static ResultSet getInvoice(String meterID) {
		try {
			String sql = "SELECT * from BienLai  where mact = ?";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1, meterID);
			ResultSet result = stm.executeQuery();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static boolean addInvoice(String mact, String ngaynhap, Date chuki, int chisoct, int thanhtien) {
		try {
			String sql = "insert into BienLai ( mact, ngaynhap, chuki, chisoct, thanhtien) values ( ?, ?, ?, ?, ? )";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			java.sql.Date sqlDate = new java.sql.Date(chuki.getTime());
			stm.setString(1, mact);
			stm.setString(2, ngaynhap);
			stm.setDate(3, sqlDate);
			stm.setInt(4, chisoct);
			stm.setInt(5, thanhtien);
			int x = stm.executeUpdate();
			if (x > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean editInvoice(Date cycle, String meterIndex, int amount, int invoiceID) {
		try {
			String sql = "update BienLai set chuki = ?, chisoct = ?, thanhtien = ? where id=?";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);

			java.sql.Date sqlDate = new java.sql.Date(cycle.getTime());

			stm.setDate(1, sqlDate);
			stm.setString(2, meterIndex);
			stm.setInt(3, amount);
			stm.setInt(4, invoiceID);

			int x = stm.executeUpdate();
			if (x > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static ResultSet getPreMeterIndexForEdit(String meterID, int invoiceID) {
		try {
			String sql = "SELECT max(chisoct) from BienLai where mact = ? AND (id BETWEEN 1 AND ?)";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1, meterID);
			stm.setInt(2, invoiceID - 1);
			ResultSet result = stm.executeQuery();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static ResultSet getLastMeterIndex(String meterID) {
		try {
			String sql = "SELECT chisoct from BienLai where chisoct = ?";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1, meterID);
			ResultSet result = stm.executeQuery();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static ResultSet getNextMeterIndexForEdit(String meterID, int invoiceID, int lastInvoiceID) {
		try {
			String sql = "SELECT min(chisoct) from BienLai where mact = ? AND (id BETWEEN ? AND ?)";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1, meterID);
			stm.setInt(2, invoiceID + 1);
			stm.setInt(3, lastInvoiceID);
			ResultSet result = stm.executeQuery();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static ResultSet getLastInvoiceID(String meterID) {
		try {
			String sql = "SELECT max(id) from BienLai where mact = ?";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1, meterID);
			ResultSet result = stm.executeQuery();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static ResultSet getMeterId() {
		try {
			String sql = "select mact from BienLai";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);

			ResultSet result = stm.executeQuery();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static boolean delInvoice(String invoiceID) {
		try {
			String sql = "delete from BienLai where id=?";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);

			stm.setString(1, invoiceID);

			int x = stm.executeUpdate();
			if (x > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static ResultSet getDataBySearch1(String customerName, String countyName, String wardName, String cycle) {
		try {
			String sql = "SELECT BienLai.id, BienLai.mact, KhachHang.mact,KhachHang.tenkh, KhachHang.diachi,"
					+ " KhachHang.idphuong, KhachHang.idquan, KhachHang.dienthoai, KhachHang.email, "
					+ "BienLai.chuki,BienLai.thanhtien,Phuong.tenphuong, Quan.tenquan "
					+ " FROM (((KhachHang INNER JOIN Quan ON KhachHang.idquan = Quan.tenquan)"
					+ "INNER JOIN Phuong ON KhachHang.idphuong = Phuong.tenphuong)"
					+ " INNER JOIN BienLai ON KhachHang.mact = BienLai.mact)"
					+ " where KhachHang.tenkh like ? and Quan.tenquan like ? and Phuong.tenphuong like ? and BienLai.chuki like ?";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1, "%" + customerName + "%");
			stm.setString(2, "%" + countyName + "%");
			stm.setString(3, "%" + wardName + "%");
			stm.setString(4, "%" + cycle + "%");
			ResultSet result = stm.executeQuery();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	public static ResultSet getDataBySearch2(String customerName, String countyName, String wardName, Date cycleStart,
			Date cycleEnd) {
		try {
			String sql = " SELECT BienLai.id, BienLai.mact, KhachHang.mact,KhachHang.tenkh, KhachHang.diachi,"
					+ "KhachHang.idphuong, KhachHang.idquan, KhachHang.dienthoai, KhachHang.email,  "
					+ " BienLai.chuki,BienLai.thanhtien,Phuong.tenphuong, Quan.tenquan "
					+ "  FROM (((KhachHang INNER JOIN Quan ON KhachHang.idquan = Quan.tenquan) "
					+ " INNER JOIN Phuong ON KhachHang.idphuong = Phuong.tenphuong) "
					+ " INNER JOIN BienLai ON KhachHang.mact = BienLai.mact)"
					+ " where KhachHang.tenkh like ? and Quan.tenquan like ? and Phuong.tenphuong like ? and (BienLai.chuki  BETWEEN ? and ?)";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			java.sql.Date sqlCycleStart = new java.sql.Date(cycleStart.getTime());
			java.sql.Date sqlCycleEnd = new java.sql.Date(cycleEnd.getTime());

			stm.setString(1, "%" + customerName + "%");
			stm.setString(2, "%" + countyName + "%");
			stm.setString(3, "%" + wardName + "%");
			stm.setDate(4,  sqlCycleStart );
			stm.setDate(5,  sqlCycleEnd );
			ResultSet result = stm.executeQuery();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ResultSet getDataBySearch3(String customerName, String countyName, String wardName, Date cycle) {
		try {
			String sql = "SELECT BienLai.id, BienLai.mact, KhachHang.mact,KhachHang.tenkh, KhachHang.diachi,"
					+ " KhachHang.idphuong, KhachHang.idquan, KhachHang.dienthoai, KhachHang.email, "
					+ "BienLai.chuki, BienLai.thanhtien, Phuong.tenphuong, Quan.tenquan "
					+ " FROM (((KhachHang INNER JOIN Quan ON KhachHang.idquan = Quan.tenquan)"
					+ "INNER JOIN Phuong ON KhachHang.idphuong = Phuong.tenphuong)"
					+ " INNER JOIN BienLai ON KhachHang.mact = BienLai.mact)"
					+ " where KhachHang.tenkh like ? and Quan.tenquan like ? and Phuong.tenphuong like ? and BienLai.chuki like ?";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			java.sql.Date sqlcycle = new java.sql.Date(cycle.getTime());
			stm.setString(1, "%" + customerName + "%");
			stm.setString(2, "%" + countyName + "%");
			stm.setString(3, "%" + wardName + "%");
			stm.setString(4, "%" + sqlcycle + "%");
			ResultSet result = stm.executeQuery();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}