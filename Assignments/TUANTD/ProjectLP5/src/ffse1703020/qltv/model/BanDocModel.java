package ffse1703020.qltv.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BanDocModel {
	private Connection conn;
	private PreparedStatement ps;
	private String sql;
	private AccountModel accountModel = new AccountModel();

	public BanDocModel() {
		super();
		try {
			conn = (new ConnectDB()).getConnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ResultSet getThanhPho() throws SQLException {
		sql = "SELECT matp, name FROM  `gsovn_tinhthanhpho` ORDER BY name ASC";
		ps = conn.prepareStatement(sql);
		return ps.executeQuery();
	}

	public ResultSet getQuan(String maThanhPho) throws SQLException {
		sql = "SELECT maqh, name FROM `gsovn_quanhuyen` WHERE matp = ? ORDER BY name ASC";
		ps = conn.prepareStatement(sql);
		ps.setString(1, maThanhPho);
		return ps.executeQuery();
	}

	public ResultSet getPhuong(String maQuan) throws SQLException {
		sql = "SELECT xaid, name FROM `gsovn_xaphuongthitran` WHERE maqh = ? ORDER BY name ASC";
		ps = conn.prepareStatement(sql);
		ps.setString(1, maQuan);
		return ps.executeQuery();
	}

	public ResultSet getDataSachChuaTra(String idBanDoc) throws SQLException {
		sql = "SELECT * FROM `muon_tra_sach` INNER JOIN `sach` ON `muon_tra_sach`.`ma_sach_muon` = `sach`.`id` WHERE ma_ban_doc = ? AND ngay_tra IS NULL ORDER BY ma_muon_tra ASC";
		ps = conn.prepareStatement(sql);
		ps.setString(1, idBanDoc);
		return ps.executeQuery();
	}

	public String getAutoId() throws SQLException {
		sql = "SELECT `AUTO_INCREMENT` FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'ffse1703020_qltv' AND TABLE_NAME = 'ban_doc'";
		ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return String.format("%05d", rs.getInt("AUTO_INCREMENT"));
	}

	public ResultSet getBanDoc(String[] where, String[] value) throws SQLException {
		int count = where.length;
		sql = "SELECT * FROM ban_doc INNER JOIN gsovn_tinhthanhpho ON ban_doc.thanh_pho = gsovn_tinhthanhpho.matp "
				+ "INNER JOIN gsovn_quanhuyen ON ban_doc.quan = gsovn_quanhuyen.maqh "
				+ "INNER JOIN gsovn_xaphuongthitran ON ban_doc.phuong = gsovn_xaphuongthitran.xaid WHERE ban_doc.trang_thai = 'active' AND ";
		for (int i = 0; i < count; i++) {
			if (where[i].equals("ho_ten")) {
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

	public int addBanDoc(BanDoc banDoc) throws SQLException {
		CreateAccount acc = new CreateAccount(banDoc.getId(), banDoc.getHoTen());
		accountModel.addAccount(acc);

		sql = "INSERT INTO ban_doc (ho_ten, dia_chi, phuong, quan, thanh_pho, dien_thoai, email) VALUES (?,?,?,?,?,?,?)";
		ps = conn.prepareStatement(sql);
		ps.setString(1, banDoc.getHoTen());
		ps.setString(2, banDoc.getDiaChi());
		ps.setString(3, banDoc.getPhuong());
		ps.setString(4, banDoc.getQuan());
		ps.setString(5, banDoc.getThanhPho());
		ps.setString(6, banDoc.getDienThoai());
		ps.setString(7, banDoc.getEmail());
		return ps.executeUpdate();
	}

	public int editBanDoc(BanDoc banDoc) throws SQLException {
		sql = "UPDATE ban_doc SET ho_ten = ?, dia_chi = ?, phuong = ?, quan = ?, thanh_pho = ?, dien_thoai = ?, email = ? WHERE id = ?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, banDoc.getHoTen());
		ps.setString(2, banDoc.getDiaChi());
		ps.setString(3, banDoc.getPhuong());
		ps.setString(4, banDoc.getQuan());
		ps.setString(5, banDoc.getThanhPho());
		ps.setString(6, banDoc.getDienThoai());
		ps.setString(7, banDoc.getEmail());
		ps.setString(8, banDoc.getId());
		return ps.executeUpdate();
	}

	public int deleteBanDoc(String id) throws SQLException {
		sql = "UPDATE ban_doc SET trang_thai = 'inactive' WHERE id = ? AND so_sach_dang_muon = 0";
		ps = conn.prepareStatement(sql);
		ps.setString(1, id);
		return ps.executeUpdate();
	}

	public int updateSoSachDangMuon(String val, String maBanDoc) throws SQLException {
		sql = "UPDATE ban_doc SET so_sach_muon = so_sach_muon " + val + " WHERE id = ?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, maBanDoc);
		return ps.executeUpdate();
	}
}
