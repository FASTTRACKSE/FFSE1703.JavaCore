package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ThongKeLopHocSQL {
	final Connection conn = GetConnectDB.getConnect("localhost", "QuanLiTruongHoc", "admin", "admin");
	private ArrayList<String> arrNamHoc = new ArrayList<>();
	private ArrayList<QuanLiLopHocModel> arrThongKeLopHoc = new ArrayList<>();
	String diemSv;

	public ArrayList<String> selectNam() {
		arrNamHoc.clear();
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("select DISTINCT NamHoc from QLLopHoc ");
			while (result.next()) {
				String namHoc = result.getString("NamHoc");
				arrNamHoc.add(namHoc);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return arrNamHoc;
	}

	public ArrayList<QuanLiLopHocModel> thongkeLop() {
		arrThongKeLopHoc.clear();
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("select MaLop,TenLop,NamHoc from QLLopHoc ");
			while (result.next()) {
				String maLop = result.getString("MaLop");
				String tenLop = result.getString("TenLop");
				String namHoc = result.getString("NamHoc");
				QuanLiLopHocModel item = new QuanLiLopHocModel(maLop, tenLop, namHoc);
				arrThongKeLopHoc.add(item);

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return arrThongKeLopHoc;
	}

	public String countSvLop(String maLop) {
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement
					.executeQuery("SELECT COUNT(*) FROM `QLSinhVien` WHERE MaLop = '" + maLop + "'");
			result.next();
			return result.getString("COUNT(*)");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public String diemSv(String maSv, String maMon) {
		try {
			Statement statement = conn.createStatement();
			String sql = "SELECT DiemMH FROM QLDiem WHERE MaSv = '" + maSv + "'and MaMH ='" + maMon + "'";
			ResultSet result = statement.executeQuery(sql);
			String diem = null;
			while (result.next()) {
				diem = result.getString("DiemMH");
				return diem;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
