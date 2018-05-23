package ffse1703022.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class ThongKeModel {
	private Connection conn;
	private PreparedStatement ps;
	private String sql;

	public ThongKeModel() {
		super();
		try {
			ConnectDB connectDB = new ConnectDB();
			conn = connectDB.getConnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ResultSet getQuan() throws SQLException {
		sql = "SELECT * FROM `Quan`";
		ps = conn.prepareStatement(sql);
		return ps.executeQuery();
	}

	public ResultSet getPhuong(String tenQuan) throws SQLException {
		sql = "SELECT * FROM `Phuong` INNER JOIN Quan WHERE Quan.id=Phuong.county AND Quan.name= '" + tenQuan + "'";
		ps = conn.prepareStatement(sql);
		return ps.executeQuery();
	}
	public ResultSet searchCus( String phuong, String quan) throws SQLException {
		if (quan.equals("Tất Cả")) {
			sql = "SELECT * FROM `KhachHang`";
			ps = conn.prepareStatement(sql);
			
		}  else if(phuong.equals("Tất cả")) {
			sql = "SELECT * FROM `KhachHang` WHERE Quan= ?";
			ps = conn.prepareStatement(sql);			
			ps.setString(1, quan);
			
		}else {
			sql = "SELECT * FROM `KhachHang` WHERE Phuong = ? AND Quan= ?";
			ps = conn.prepareStatement(sql);			
			ps.setString(1, phuong);
			ps.setString(2, quan);
		}
		return ps.executeQuery();
	}
	public ResultSet searchBL(String khachHang, String thoiGian) throws SQLException {
		// khách hàng: 1/ tất cả - "1=1" | theo khu vực - Quan = ? AND Phuong = ? | theo mã - MaKH = ?
		// thời gian : 2/ theo năm - YEAR(ChuKyDate) = ?
		// theo khoảng thời gian - ChuKyDate BETWEEN '....-..-01'AND '....-..-01'
		// theo kì - ChuKy = ?
		sql = "SELECT * FROM `BienLai` INNER JOIN `KhachHang` ON `BienLai`.`MaCT` = `KhachHang`.`MaCT` WHERE " + khachHang + " AND " + thoiGian+ " ORDER BY `BienLai`.`MaCT` ASC, `BienLai`.`ChuKy` DESC";
		System.out.println(sql);
		ps = conn.prepareStatement(sql);			
		return  ps.executeQuery();
	}
}
