package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class QuanLiLopHocSQL {
	final Connection conn = GetConnectDB.getConnect("localhost", "QuanLiTruongHoc", "admin", "admin");
	private ArrayList<QuanLiLopHocModel> arrMaLop = new ArrayList<>();
	private ArrayList<QuanLiMonHocCuaLopModel> arrMonCuaLop = new ArrayList<>();
	
	public ArrayList<QuanLiLopHocModel> selectLop() {
		arrMaLop.clear();
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("select * from QLLopHoc");
			while (result.next()) {
				String maLop = result.getString("MaLop");
				String tenLop = result.getString("TenLop");
				String namHoc = result.getString("NamHoc");
				QuanLiLopHocModel item = new QuanLiLopHocModel(maLop,tenLop,namHoc);
				arrMaLop.add(item);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return arrMaLop;
	}
	public ArrayList<QuanLiMonHocCuaLopModel> selectMonHocCuaLop(String maLop) {
		arrMonCuaLop.clear();
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("select * from QLMonHocCuaLop where MaLop = '" + maLop + "'" );
			while (result.next()) {
				String maMon = result.getString("MaMH");
				QuanLiMonHocCuaLopModel item = new QuanLiMonHocCuaLopModel(maLop,maMon);
				arrMonCuaLop.add(item);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return arrMonCuaLop;
	}
	public void insert(String maLop,String tenLop,String namHoc) {
		try {
			String sql = "insert into QLLopHoc(MaLop,TenLop,NamHoc) values (?,?,?)";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, maLop);
			st.setString(2, tenLop);
			st.setString(3, namHoc);
			int x = st.executeUpdate();
			if (x > 0) {
				JOptionPane.showMessageDialog(null, "Thêm Thành Công !!");
			} else {
				JOptionPane.showMessageDialog(null, "Thêm Thất Bại");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		arrMaLop.add(new QuanLiLopHocModel(maLop,tenLop,namHoc));
	}
	public void update(String maLop,String tenLop,String namHoc) {
		try {
			String sql = "update QLLopHoc set TenLop = ?, NamHoc = ? where MaLop = ? ";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, tenLop);
			st.setString(2, namHoc);
			st.setString(3, maLop);
			int x = st.executeUpdate();
			if (x > 0) {
				JOptionPane.showMessageDialog(null, "Sửa Thành Công !!");
			} else {
				JOptionPane.showMessageDialog(null, "Sửa Thất Bại");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		arrMaLop.add(new QuanLiLopHocModel(maLop,tenLop,namHoc));
	}
	public void delete(String maLop) {
		try {
			Statement statement = conn.createStatement();
			String sql = "delete from QLLopHoc where MaLop= '" + maLop + "' ";

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
	public void insertMonHocCuaLop(String maLop,String maMon) {
		try {
			String sql = "insert into QLMonHocCuaLop(MaLop,MaMH) values (?,?)";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, maLop);
			st.setString(2, maMon);
			int x = st.executeUpdate();
			if (x > 0) {
				JOptionPane.showMessageDialog(null, "Thêm Môn Thành Công !!");
			} else {
				JOptionPane.showMessageDialog(null, "Thêm Môn Thất Bại");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		arrMonCuaLop.add(new QuanLiMonHocCuaLopModel(maLop,maMon));
	}
	public void deleteMonHocCuaLop(String maLop,String maMh) {
		try {
			Statement statement = conn.createStatement();
			String sql = "delete from QLMonHocCuaLop where MaLop= '" + maLop + "' and MaMH= '" + maMh + "' ";

			int x = statement.executeUpdate(sql);
			if (x > 0) {
				JOptionPane.showMessageDialog(null, "Xóa Môn Thành Công !!");
			} else {
				JOptionPane.showMessageDialog(null, "Xóa Môn Thất Bại");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}

