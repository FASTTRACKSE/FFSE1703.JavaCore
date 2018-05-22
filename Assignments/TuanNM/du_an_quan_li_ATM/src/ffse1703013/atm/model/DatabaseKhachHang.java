package ffse1703013.atm.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

public class DatabaseKhachHang {
	final Connection conn = ConnectDatabase.getConnect("localhost", "FFSE1703013_ATM", "tuan18081999", "tuan123");
	ArrayList<KhachHang> arrKH = new ArrayList<KhachHang>();

	public ArrayList<KhachHang> selectKhachHang() {
		try {

			Statement statement = (Statement) conn.createStatement();
			ResultSet rs = statement.executeQuery("select * from KhachHang");
			while (rs.next()) {
				String maKH = rs.getString("makh");
				String tenKH = rs.getString("tenKH");
				String diaChiNha = rs.getString("diaChiNha");
				String phuong = rs.getString("phuong");
				String quan = rs.getString("quan");
				String dienThoai = rs.getString("dienThoai");
				String email = rs.getString("email");
				String soThe = rs.getString("soThe");
				String soTK = rs.getString("soTK");
				String soDu = rs.getString("soDu");
				String maPin = rs.getString("maPin");
				arrKH.add(new KhachHang(maKH, tenKH, diaChiNha, phuong, quan, dienThoai, email, soThe, soTK, soDu,
						maPin));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrKH;

	}

	public ArrayList<KhachHang> searchKHTheoTen(String tenKH1) {
		try {

			Statement statement = (Statement) conn.createStatement();
			ResultSet rs = statement.executeQuery("select * from KhachHang where tenKH LIKE '%" + tenKH1 + "%'");
			while (rs.next()) {
				String maKH = rs.getString("makh");
				String tenKH = rs.getString("tenKH");
				String diaChiNha = rs.getString("diaChiNha");
				String phuong = rs.getString("phuong");
				String quan = rs.getString("quan");
				String dienThoai = rs.getString("dienThoai");
				String email = rs.getString("email");
				String soThe = rs.getString("soThe");
				String soTK = rs.getString("soTK");
				String soDu = rs.getString("soDu");
				String maPin = rs.getString("maPin");
				arrKH.add(new KhachHang(maKH, tenKH, diaChiNha, phuong, quan, dienThoai, email, soThe, soTK, soDu,
						maPin));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrKH;

	}

	public ArrayList<KhachHang> searchKHTheoMa(String maKH1) {
		try {

			Statement statement = (Statement) conn.createStatement();
			ResultSet rs = statement.executeQuery("select * from KhachHang where maKH LIKE '%" + maKH1 + "%'");
			while (rs.next()) {
				String maKH = rs.getString("makh");
				String tenKH = rs.getString("tenKH");
				String diaChiNha = rs.getString("diaChiNha");
				String phuong = rs.getString("phuong");
				String quan = rs.getString("quan");
				String dienThoai = rs.getString("dienThoai");
				String email = rs.getString("email");
				String soThe = rs.getString("soThe");
				String soTK = rs.getString("soTK");
				String soDu = rs.getString("soDu");
				String maPin = rs.getString("maPin");
				arrKH.add(new KhachHang(maKH, tenKH, diaChiNha, phuong, quan, dienThoai, email, soThe, soTK, soDu,
						maPin));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrKH;

	}

	public void insertKhachHang(String maKH, String tenKH, String diaChiNha, String phuong, String quan,
			String dienThoai, String email, String soThe, String soTK, String soDu, String maPin) {
		try {
			String sql = "insert into khachhang values('" + 0 + "','" + maKH + "','" + tenKH + "','" + diaChiNha + "','"
					+ phuong + "'," + "'" + quan + "','" + dienThoai + "','" + email + "','" + soThe + "','" + soTK
					+ "','" + maPin + "','" + soDu + "')";
			Statement statement = (Statement) conn.createStatement();
			int x = statement.executeUpdate(sql);
			if (x > 0) {
				JOptionPane.showMessageDialog(null, "Lưu thành công");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void updateKhachHang(String tenKH, String diaChiNha, String phuong, String quan, String dienThoai,
			String email, String soTK, String maKH, String soDu, String maPin) {
		try {

			String sql = "UPDATE `khachhang` SET `tenKH`='" + tenKH + "',`diaChiNha`='" + diaChiNha + "',"
					+ "`phuong`='" + phuong + "',`quan`='" + quan + "',`dienThoai`='" + dienThoai + "',`email`='"
					+ email + "'," + "`soTK`='" + soTK + "',`soDu`='" + soDu + "',`maPin`='" + maPin
					+ "' WHERE `maKH`='" + maKH + "' ";

			Statement statement = (Statement) conn.createStatement();

			int x = statement.executeUpdate(sql);
			if (x > 0) {
				JOptionPane.showMessageDialog(null, "Cập nhật thành công ");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void deleteSinhVien(String maKH) {
		try {
			String sql = "DELETE from khachhang WHERE maKH='" + maKH + "'";
			Statement statement = (Statement) conn.createStatement();
			int x = statement.executeUpdate(sql);
			if (x > 0) {
				JOptionPane.showMessageDialog(null, "Xóa thành công");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
