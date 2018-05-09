package ffse1703020.qltv.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class AccountModel {
	private Connection conn;
	private PreparedStatement ps;
	private String sql;

	public AccountModel() {
		super();
		try {
			conn = ConnectDB.getConnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int addAccount(CreateAccount acc) throws SQLException {
		sql = "INSERT INTO account (username, password, role, ma_ban_doc) VALUES (?,?,'bandoc',?)";
		ps = (PreparedStatement) conn.prepareStatement(sql);
		ps.setString(1, acc.getUsername());
		ps.setString(2, acc.getPassword());
		ps.setString(3, String.format("%05d", acc.getId()));
		return ps.executeUpdate();
	}

	@SuppressWarnings("resource")
	public boolean checkLogin(String username, String password) throws SQLException {
		sql = "SELECT role, ma_ban_doc FROM account WHERE username = ? AND password = ?";
		ps = (PreparedStatement) conn.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		while ((rs != null) && (rs.next())) {
			if (rs.getString("role").equals("bandoc")) {
				String maBanDoc = rs.getString("ma_ban_doc");
				// check bạn đọc active
				sql = "SELECT id FROM ban_doc WHERE id = ? AND trang_thai = 'active'";
				ps = (PreparedStatement) conn.prepareStatement(sql);
				ps.setString(1, maBanDoc);
				rs = ps.executeQuery();
				while ((rs != null) && (rs.next())) {
					CheckLogin.setLoggedrole("bandoc");
					CheckLogin.setMaBanDoc(maBanDoc);
					return true;
				}
			} else {
				CheckLogin.setLoggedrole("admin");
				return true;
			}
		}
		return false;
	}
}