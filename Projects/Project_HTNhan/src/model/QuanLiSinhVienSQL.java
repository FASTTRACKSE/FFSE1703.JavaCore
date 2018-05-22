package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import java.sql.PreparedStatement;

public class QuanLiSinhVienSQL {
	final Connection conn = GetConnectDB.getConnect("localhost", "QuanLiTruongHoc", "admin", "admin");
	private ArrayList<QuanLiSinhVienModel> arrQlSinhVien = new ArrayList<>();
	private ArrayList<QuanLiSinhVienModel> arrMalop = new ArrayList<>();

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
	public ArrayList<QuanLiSinhVienModel> selectMalop(String maLop) {
		arrMalop.clear();
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("select * from QLSinhVien where Malop = '"+maLop+"'");
			while (result.next()) {
				String maSv = result.getString("MaSv");
				String tenSv = result.getString("HoTenSv");
				String diaChiSv = result.getString("DiaChiSv");
				String xa = result.getString("Xa");
				String huyen = result.getString("Huyen");
				String tinh = result.getString("Tinh");
				String dienThoaiSv = result.getString("DienThoaiSv");
				String email = result.getString("Email");
				String ma = result.getString("Malop");

				arrMalop.add(
						new QuanLiSinhVienModel(maSv, tenSv, diaChiSv, xa, huyen, tinh, dienThoaiSv, email, ma));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return arrMalop;
	}
	public void insert(String maSv, String hoTenSv, String diaChiSv, String xa, String huyen, String tinh,
			String dienThoaiSv, String email, String maLop) {
		try {
			String sql = "insert into QLSinhVien(MaSv, HoTenSv,DiaChiSv,Xa,Huyen,Tinh,DienThoaiSv,Email,MaLop) values (?,?,?,?,?,?,?,?,?)";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, maSv);
			st.setString(2, hoTenSv);
			st.setString(3, diaChiSv);
			st.setString(4, xa);
			st.setString(5, huyen);
			st.setString(6, tinh);
			st.setString(7, dienThoaiSv);
			st.setString(8, email);
			st.setString(9, maLop);
			int x = st.executeUpdate();
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
			String sql = "update QLSinhVien set HoTenSv = ?, DiaChiSv = ?, Xa = ?,Huyen = ?,Tinh = ?,DienThoaiSv = ?,Email = ?,MaLop = ? where MaSv = ? ";
			PreparedStatement stm =  conn.prepareStatement(sql);
			stm.setString(1,hoTenSv);
			stm.setString(2,diaChiSv);
			stm.setString(3,xa);
			stm.setString(4,huyen);
			stm.setString(5,tinh);
			stm.setString(6,dienThoaiSv);
			stm.setString(7,email);
			stm.setString(8,maLop);
			stm.setString(9,maSv);
			int x = stm.executeUpdate();

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
			String sql = "delete from QLSinhVien where MaSv= '" + maSv + "' ";
			String sql1 = "delete from QLDiem where MaSv= '" + maSv +"'";
			statement.executeUpdate(sql1);
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
