package ffse1703022.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class BienLaiModel {
	private Connection conn;
	private PreparedStatement ps;
	private String sql;

	public BienLaiModel() {
		super();
		try {
			ConnectDB connectDB = new ConnectDB();
			conn = connectDB.getConnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public float getChiSoCu(String maCT, int thang, int nam) {
		try {
			// nếu ko tồn tại biên lai => khách hàng mới => chỉ số cũ = 0
			sql = "SELECT COUNT(*) FROM `BienLai` WHERE MaCT = ?";
			System.out.println(maCT);
			ps = conn.prepareStatement(sql);
			ps.setString(1, maCT);
			ResultSet rs = ps.executeQuery();
			int dem;
			rs.next();
			dem = rs.getInt("COUNT(*)");
			System.out.println(dem);
			if (dem == 0) {
				System.out.println("khách hàng mới");
				return 0;
			} else {
				// nếu tồn tại biên lai => get chỉ số mới where mã CT = ... AND tháng = (tháng
				// trước) AND năm = năm trước
				System.out.println("khách hàng cũ");
				String chuKy;
				if (thang == 1) {
					chuKy = 12 + "/" + (nam - 1);
				} else {
					chuKy = (thang - 1) + "/" + nam;
				}
				sql = "SELECT * FROM `BienLai` WHERE MaCT=? AND ChuKy=?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, maCT);
				ps.setString(2, chuKy);
				rs = ps.executeQuery();	
				rs.next();
				float chiSoCu = rs.getFloat("ChiSoMoi");
				return chiSoCu;
			}
		} catch (SQLException e) {
			return -1;
		}
	}

	public int addBL(BienLai bienlai) throws SQLException {
		sql = "INSERT INTO `BienLai`(MaCT,Date, ChuKy, ChuKyDate, ChiSo, ChiSoMoi,SoTien) VALUES (?,?,?,?,?,?,?)";
		ps = conn.prepareStatement(sql);
		ps.setString(1, bienlai.getMaCT());
		ps.setString(2, bienlai.getNgayNhap());
		ps.setString(3, bienlai.getChuKy());

		String chuKy = bienlai.getChuKy();
		String[] arr = chuKy.split("/");

		String chuKyDate = arr[1] + "-" + arr[0] + "-" + "01";
		ps.setString(4, chuKyDate);
		ps.setFloat(5, bienlai.getChiSoCu());
		ps.setFloat(6, bienlai.getChiSoMoi());
		ps.setFloat(7, bienlai.getTienDien());

		return ps.executeUpdate();
	}

	public ResultSet searchBL(String maCT) throws SQLException {
		sql = "SELECT * FROM `BienLai` WHERE MaCT=? ORDER BY ChuKy DESC";
		ps = conn.prepareStatement(sql);
		ps.setString(1, maCT);
		return ps.executeQuery();
	}

	public int editBL(BienLai bienlai) throws SQLException {
		sql = "UPDATE BienLai SET Date=?,ChiSoMoi=?,SoTien=? WHERE MaCT=? AND ChuKy=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, bienlai.getNgayNhap());
		ps.setFloat(2, bienlai.getChiSoMoi());
		ps.setFloat(3, bienlai.getTienDien());
		ps.setString(4, bienlai.getMaCT());
		ps.setString(5, bienlai.getChuKy());

		System.out.println(bienlai.getNgayNhap());
		System.out.println(bienlai.getChiSoMoi());
		System.out.println(bienlai.getMaCT());
		System.out.println(bienlai.getChuKy());

		return ps.executeUpdate();

	}

	public int delBL(String maCT, String chuKy) throws SQLException {
		sql = "DELETE FROM BienLai WHERE MaCT=? AND ChuKy=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, maCT);
		ps.setString(2, chuKy);
		return ps.executeUpdate();
	}
	
	public int getBL(String maCT, String chuKy) {
		try {
			sql = "select Count(*) from BienLai Where MaCT=? And ChuKy=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, maCT);
			ps.setString(2,chuKy);
			ResultSet result = ps.executeQuery();
			result.next();
			return result.getInt("Count(*)");
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
