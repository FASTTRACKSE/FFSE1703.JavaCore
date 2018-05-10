package ffse1703020.qltv.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SachModel {
	private Connection conn;
	private PreparedStatement ps;
	private String sql;

	public SachModel() {
		super();
		try {
			conn = (new ConnectDB()).getConnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ResultSet getNhaXuatBan() throws SQLException {
		sql = "SELECT * FROM  `nha_xuat_ban` ORDER BY ten_nha_xuat_ban ASC";
		ps = conn.prepareStatement(sql);
		return ps.executeQuery();
	}

	public ResultSet getTheLoai() throws SQLException {
		sql = "SELECT * FROM  `the_loai` ORDER BY ten_the_loai ASC";
		ps = conn.prepareStatement(sql);
		return ps.executeQuery();
	}

	public String getAutoId() throws SQLException {
		sql = "SELECT `AUTO_INCREMENT` FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'ffse1703020_qltv' AND TABLE_NAME = 'sach'";
		ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return String.format("%05d", rs.getInt("AUTO_INCREMENT"));
	}

	public ResultSet getSach(String[] where, String[] value) throws SQLException {
		int count = where.length;
		sql = "SELECT * FROM sach INNER JOIN nha_xuat_ban ON sach.nha_xuat_ban = nha_xuat_ban.id INNER JOIN the_loai ON sach.the_loai = the_loai.id WHERE ";
		for (int i = 0; i < count; i++) {
			if (where[i].equals("ten_sach") || where[i].equals("tac_gia")) {
				sql += where[i] + " LIKE '%" + value[i] + "%'";
			} else {
				sql += where[i] + " = '" + value[i] + "'";
			}
			if (i < count - 1) {
				sql += " AND ";
			}
		}
		ps = conn.prepareStatement(sql);
		return ps.executeQuery();
	}

	public int addSach(Sach sach) throws SQLException {
		sql = "INSERT INTO sach (ten_sach, tac_gia, nha_xuat_ban, the_loai, nam_xuat_ban, so_luong_tong, so_luong_ton_kho) VALUES (?,?,?,?,?,?,?)";
		ps = conn.prepareStatement(sql);
		ps.setString(1, sach.getTen());
		ps.setString(2, sach.getTacGia());
		ps.setString(3, sach.getNhaXuatBan());
		ps.setString(4, sach.getTheLoaiSach());
		ps.setString(5, sach.getNamXuanBan());
		ps.setInt(6, sach.getSoLuongTong());
		ps.setInt(7, sach.getSoLuongKho());
		return ps.executeUpdate();
	}

	public int editSach(Sach sach) throws SQLException {
		sql = "UPDATE sach SET ten_sach = ?, tac_gia = ?, nha_xuat_ban = ?, the_loai = ?, nam_xuat_ban = ?, so_luong_tong = ?, so_luong_ton_kho = ? WHERE id = ?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, sach.getTen());
		ps.setString(2, sach.getTacGia());
		ps.setString(3, sach.getNhaXuatBan());
		ps.setString(4, sach.getTheLoaiSach());
		ps.setString(5, sach.getNamXuanBan());
		ps.setInt(6, sach.getSoLuongTong());
		ps.setInt(7, sach.getSoLuongKho());
		ps.setString(8, sach.getId());
		return ps.executeUpdate();
	}

	public int deleteSach(String id) throws SQLException {
		sql = "UPDATE sach SET trang_thai = 'inactive' WHERE id = ? AND so_luong_tong = so_luong_ton_kho";
		ps = conn.prepareStatement(sql);
		ps.setString(1, id);
		return ps.executeUpdate();
	}

	public int updateSoLuongKho(String val, String maSachMuon) throws SQLException {
		sql = "UPDATE sach SET so_luong_ton_kho = so_luong_ton_kho " + val + " WHERE id = ?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, maSachMuon);
		return ps.executeUpdate();
	}

	public boolean isExistSach(String tenSach, String tacgia) throws SQLException {
		sql = "SELECT * FROM sach WHERE ten_sach = ? AND tac_gia = ?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, tenSach);
		ps.setString(2, tacgia);
		ResultSet rs = ps.executeQuery();
		while ((rs != null) && (rs.next())) {
			return true;
		}
		return false;
	}
}
