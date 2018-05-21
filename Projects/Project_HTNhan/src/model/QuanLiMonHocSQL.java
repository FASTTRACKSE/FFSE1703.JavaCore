package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class QuanLiMonHocSQL {
	final Connection conn = GetConnectDB.getConnect("localhost", "QuanLiTruongHoc", "admin", "admin");
	private ArrayList<QuanLiMonHocModel> arrMonHoc = new ArrayList<>();
	
	
	public ArrayList<QuanLiMonHocModel> selectMonHoc() {
		arrMonHoc.clear();
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("select * from QLMonHoc");
			while (result.next()) {
				String maMH = result.getString("MaMH");
				String tenMH = result.getString("TenMH");
				String tinChiMH = result.getString("TinChiMH");
				String thoiGianMH = result.getString("ThoiGianMH");
				QuanLiMonHocModel item = new QuanLiMonHocModel(maMH,tenMH,tinChiMH,thoiGianMH);
				arrMonHoc.add(item);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return arrMonHoc;
	}
	public void insert(String maMH ,String tenMH,String tinChiMH,String thoiGianMH) {
		try {
			String sql = "insert into QLMonHoc(MaMH,TenMH,TinChiMH,ThoiGianMH) values (?,?,?,?)";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, maMH);
			st.setString(2, tenMH);
			st.setString(3, tinChiMH);
			st.setString(4, thoiGianMH);
			int x = st.executeUpdate();
			if (x > 0) {
				JOptionPane.showMessageDialog(null, "Thêm Thành Công !!");
			} else {
				JOptionPane.showMessageDialog(null, "Thêm Thất Bại");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		arrMonHoc.add(new QuanLiMonHocModel(maMH,tenMH,tinChiMH,thoiGianMH));
	}
	public void update(String maMH ,String tenMH,String tinChiMH,String thoiGianMH) {
		try {
			String sql = "update QLMonHoc set TenMH = ?, TinChiMH = ?,ThoiGianMH = ? where MaMH = ? ";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, tenMH);
			st.setString(2, tinChiMH);
			st.setString(3, thoiGianMH);
			st.setString(4, maMH);
			int x = st.executeUpdate();
			if (x > 0) {
				JOptionPane.showMessageDialog(null, "Sửa Thành Công !!");
			} else {
				JOptionPane.showMessageDialog(null, "Sửa Thất Bại");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		arrMonHoc.add(new QuanLiMonHocModel(maMH,tenMH,tinChiMH,thoiGianMH));
	}
	public void delete(String maMH) {
		try {
			Statement statement = conn.createStatement();
			String sql = "delete from QLMonHoc where MaMH= '" + maMH + "' ";

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

