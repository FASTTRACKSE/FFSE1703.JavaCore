package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class QuanLiSinhVienModel {
	final Connection conn = GetConnectDB.getConnect("localhost", "QuanLiTruongHoc", "admin", "admin");
	private String maSv, hoTenSv, diaChiSv, xa, huyen, tinh, dienThoaiSv, email, maLop;
	private static ArrayList<QuanLiSinhVienModel> arrQlSinhVien = new ArrayList<>();

	public QuanLiSinhVienModel() {
		// TODO Auto-generated constructor stub
	}

	public QuanLiSinhVienModel(String maSv, String hoTenSv, String diaChiSv, String xa, String huyen, String tinh,
			String dienThoaiSv, String email, String maLop) {
		this.maSv = maSv;
		this.hoTenSv = hoTenSv;
		this.diaChiSv = diaChiSv;
		this.xa = xa;
		this.huyen = huyen;
		this.tinh = tinh;
		this.dienThoaiSv = dienThoaiSv;
		this.email = email;
		this.maLop = maLop;
	}

	public String getMaSv() {
		return maSv;
	}

	public void setMaSv(String maSv) {
		this.maSv = maSv;
	}

	public String getHoTenSv() {
		return hoTenSv;
	}

	public void setHoTenSv(String hoTenSv) {
		this.hoTenSv = hoTenSv;
	}

	public String getDiaChiSv() {
		return diaChiSv;
	}

	public void setDiaChiSv(String diaChiSv) {
		this.diaChiSv = diaChiSv;
	}

	public String getXa() {
		return xa;
	}

	public void setXa(String xa) {
		this.xa = xa;
	}

	public String getHuyen() {
		return huyen;
	}

	public void setHuyen(String huyen) {
		this.huyen = huyen;
	}

	public String getTinh() {
		return tinh;
	}

	public void setTinh(String tinh) {
		this.tinh = tinh;
	}

	public String getDienThoaiSv() {
		return dienThoaiSv;
	}

	public void setDienThoaiSv(String dienThoaiSv) {
		this.dienThoaiSv = dienThoaiSv;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMaLop() {
		return maLop;
	}

	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}

	public ArrayList<QuanLiSinhVienModel> selectAll() {
		arrQlSinhVien.clear();
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("select * from QLSinhVien");
			while (result.next()) {
				String maSv = result.getString("MaSv");
				String tenSv = result.getString("HoTenSv");
				String diaChiSv = result.getString("DiaChiSv");
				String xa = result.getString("Xa");
				String huyen = result.getString("Huyen");
				String tinh = result.getString("Tinh");
				String dienThoaiSv = result.getString("DienThoaiSv");
				String email = result.getString("Email");
				String maLop = result.getString("Malop");

				arrQlSinhVien.add(
						new QuanLiSinhVienModel(maSv, tenSv, diaChiSv, xa, huyen, tinh, dienThoaiSv, email, maLop));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return arrQlSinhVien;
	}

	public void insert(String maSv, String hoTenSv, String diaChiSv, String xa, String huyen, String tinh,
			String dienThoaiSv, String email, String maLop) {
		try {
			Statement statement = conn.createStatement();
			String sql = "insert into QLSinhVien values('" + 0 + "','" + maSv + "','" + hoTenSv + "'," + diaChiSv + ",'"
					+ xa + "','" + huyen + "','" + tinh + "','" + dienThoaiSv + "','" + email + "','" + maLop + "')";

			int x = statement.executeUpdate(sql);
			if (x > 0) {
				JOptionPane.showMessageDialog(null, "Thêm Thành Công !!");
			} else {
				JOptionPane.showMessageDialog(null, "Thêm Thất Bại");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		arrQlSinhVien.add(new QuanLiSinhVienModel(maSv, hoTenSv, diaChiSv, xa, huyen, tinh, dienThoaiSv, email, maLop));
	}

	public void update(String maSv, String hoTenSv, String diaChiSv, String xa, String huyen, String tinh,
			String dienThoaiSv, String email, String maLop) {
		try {
			Statement statement = conn.createStatement();
			String sql = "update QLSinhVien set HoTenSv='" + hoTenSv + "',DiaChiSv='" + diaChiSv + "',Xa='" + xa
					+ "',Huyen='" + huyen + "',Tinh='" + tinh + "',DiaChiSv='" + diaChiSv + "',DienThoaiSv='"
					+ dienThoaiSv + "',Email='" + email + "',MaLop='" + maLop + "' where MaSv='" + maSv + "'";

			int x = statement.executeUpdate(sql);
			if (x > 0) {
				JOptionPane.showMessageDialog(null, "Sửa Thành Công !!");
			} else {
				JOptionPane.showMessageDialog(null, "Sửa Thất Bại");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		arrQlSinhVien.add(new QuanLiSinhVienModel(maSv, hoTenSv, diaChiSv, xa, huyen, tinh, dienThoaiSv, email, maLop));
	}
	public void delete(String maSv) {
		try {
			Statement statement = conn.createStatement();
			String sql = "delete from QLSinhVien where MaSv= '"+maSv+"' ";

			int x = statement.executeUpdate(sql);
			if (x > 0) {
				JOptionPane.showMessageDialog(null, "Xóa Thành Công !!");
			} else {
				JOptionPane.showMessageDialog(null, "Xóa Thất Bại");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
