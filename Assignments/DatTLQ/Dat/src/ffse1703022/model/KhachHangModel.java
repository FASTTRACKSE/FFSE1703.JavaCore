package ffse1703022.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class KhachHangModel {
	private Connection conn;
	private PreparedStatement ps;
	private String sql;

	public KhachHangModel() {
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

	public ResultSet searchCus(String ten, String phuong, String quan) throws SQLException {
		if (quan.equals("Tất Cả")) {
			sql = "SELECT * FROM `KhachHang` WHERE TenKH LIKE ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + ten);
		} else if (phuong.equals("Tất cả")) {
			sql = "SELECT * FROM `KhachHang` WHERE TenKH LIKE ? AND Quan= ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + ten);
			ps.setString(2, quan);
		} else {
			sql = "SELECT * FROM `KhachHang` WHERE TenKH LIKE ? AND Phuong = ? AND Quan= ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + ten);
			ps.setString(2, phuong);
			ps.setString(3, quan);
		}
		return ps.executeQuery();
	}

	public int addCus(KhachHang khachhang) throws SQLException {
		sql = "INSERT INTO KhachHang( MaCT, TenKH, DiaChi, Quan, Phuong, Phone, Email) VALUES (?,?,?,?,?,?,?)";
		ps = conn.prepareStatement(sql);
		
		ps.setString(1, khachhang.getMaCT());
		ps.setString(2, khachhang.getTenKh());
		ps.setString(3, khachhang.getDiaChi());
		ps.setString(4, khachhang.getQuan());
		ps.setString(5, khachhang.getPhuong());
		ps.setString(6, khachhang.getDienThoai());
		ps.setString(7, khachhang.getEmail());

		return ps.executeUpdate();

	}

	public int repCus(KhachHang khachhang) throws SQLException {
		sql = "UPDATE KhachHang SET TenKH=?,DiaChi=?,Quan=?,Phuong=?,Phone=?,Email=? WHERE MaCT=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, khachhang.getTenKh());
		ps.setString(2, khachhang.getDiaChi());
		ps.setString(3, khachhang.getQuan());
		ps.setString(4, khachhang.getPhuong());
		ps.setString(5, khachhang.getDienThoai());
		ps.setString(6, khachhang.getEmail());
		ps.setString(7, khachhang.getMaCT());

		return ps.executeUpdate();
	}
	public int delCus(String maKH)throws SQLException {
		sql="DELETE FROM KhachHang WHERE MaKH=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, maKH);

		return ps.executeUpdate();

	}
	public ResultSet getMeterIdList() {
		try {
			sql = "select MaCT from KhachHang";
			ps = conn.prepareStatement(sql);

			ResultSet result = ps.executeQuery();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
