package ffse1703020.qltv.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SachModel {
	private Connection conn;
	private PreparedStatement ps;
	private String sql;

	public static ArrayList<String> getListtheloai() {
		Connection conn = (Connection) ConnectDB.getConnect();
		String sql = "select * from the_loai";
		ArrayList<String> arr = new ArrayList<>();
		try {
			PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();

			while (rs.next()) {
				arr.add(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr;

	}

	public static ArrayList<String> getListnxb() {
		Connection conn = (Connection) ConnectDB.getConnect();
		String sql = "select * from nha_xuat_ban";
		ArrayList<String> array = new ArrayList<>();
		try {
			PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();

			while (rs.next()) {
				array.add(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return array;
	}

	public int updateSoLuongKho(String val, String maSachMuon) throws SQLException {
		sql = "UPDATE sach SET so_luong_tong = so_luong_tong " + val + " WHERE id = ?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, maSachMuon);
		return ps.executeUpdate();
	}
}