package ffse1703020.qltv.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MuonTraSachModel {
	private Connection conn;
	private PreparedStatement ps;
	private String sql;

	private BanDocModel banDocModel = new BanDocModel();
	private SachModel sachModel = new SachModel();

	public MuonTraSachModel() {
		super();
		try {
			conn = (new ConnectDB()).getConnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getAutoId() throws SQLException {
		sql = "SELECT MAX(ma_muon_tra) FROM muon_tra_sach";
		ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return String.format("%07d", rs.getInt("MAX(ma_muon_tra)") + 1);
	}

	public ResultSet getMuonTraSach(String[] where, String[] value) throws SQLException {
		int count = where.length;
		sql = "SELECT * FROM muon_tra_sach INNER JOIN ban_doc ON muon_tra_sach.ma_ban_doc = ban_doc.id "
				+ "INNER JOIN sach ON muon_tra_sach.ma_sach_muon = sach.id "
				+ "WHERE ban_doc.trang_thai = 'active' AND ";
		for (int i = 0; i < count; i++) {
			sql += where[i] + value[i];
			if (i < count - 1) {
				sql += " AND ";
			}
		}
		ps = conn.prepareStatement(sql);
		return ps.executeQuery();
	}

	public boolean muonSach(MuonTraSach muonSach) throws SQLException {
		String maBanDoc = muonSach.getMaBanDoc();
		String maSachMuon = muonSach.getMaSachMuon();

		sql = "INSERT INTO muon_tra_sach (ma_muon_tra, ma_ban_doc, ma_sach_muon) VALUES (?,?,?)";
		ps = conn.prepareStatement(sql);
		ps.setString(1, muonSach.getMaMuonTra());
		ps.setString(2, maBanDoc);
		ps.setString(3, maSachMuon);
		if (ps.executeUpdate() < 0) {
			return false;
		}

		sachModel.updateSoLuongKho("-1", maSachMuon);
		banDocModel.updateSoSachDangMuon("+1", maBanDoc);
		return true;
	}

	public boolean traSach(MuonTraSach traSach) throws SQLException {
		String maBanDoc = traSach.getMaBanDoc();
		String maSachMuon = traSach.getMaSachMuon();

		sql = "UPDATE muon_tra_sach SET ngay_tra = CURRENT_TIMESTAMP WHERE ma_ban_doc = ? AND ma_sach_muon = ? AND ngay_tra IS NULL";
		ps = conn.prepareStatement(sql);
		ps.setString(1, traSach.getMaBanDoc());
		ps.setString(2, maSachMuon);
		if (ps.executeUpdate() < 0) {
			return false;
		}

		sachModel.updateSoLuongKho("+1", maSachMuon);
		banDocModel.updateSoSachDangMuon("-1", maBanDoc);
		return true;
	}
}