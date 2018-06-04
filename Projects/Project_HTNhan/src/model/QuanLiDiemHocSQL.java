package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class QuanLiDiemHocSQL {
	final Connection conn = GetConnectDB.getConnect("localhost", "QuanLiTruongHoc", "admin", "admin");
	private ArrayList<QuanLiDiemHocModel> arrDiemHoc = new ArrayList<>();
	private ArrayList<QuanLiDiemHocModel> arrDiem = new ArrayList<>();

	public ArrayList<QuanLiDiemHocModel> selectDiem() {
		arrDiemHoc.clear();
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("select * from QLDiem");
			while (result.next()) {
				String maSv = result.getString("MaSv");
				String maMH = result.getString("MaMH");
				String diemMH = result.getString("DiemMH");
				QuanLiDiemHocModel item = new QuanLiDiemHocModel(maSv, maMH, diemMH);
				arrDiemHoc.add(item);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return arrDiemHoc;
	}
	public ArrayList<QuanLiDiemHocModel> diem(String maSv) {
		arrDiem.clear();
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("select DiemMH from QLDiem where MaSv = '" + maSv + "'");
			while (result.next()) {

				String diemMH = result.getString("DiemMH");
				QuanLiDiemHocModel item = new QuanLiDiemHocModel(diemMH);
				arrDiem.add(item);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return arrDiem;
	}

	public void insert(String maSv, String maMH, String diemMH) {
		try {
			String sql = "insert into QLDiem(MaSv,MaMH,DiemMH) values (?,?,?)";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, maSv);
			st.setString(2, maMH);
			st.setString(3, diemMH);
			int x = st.executeUpdate();
			if (x > 0) {
				JOptionPane.showMessageDialog(null, "Thêm Thành Công !!");
			} else {
				JOptionPane.showMessageDialog(null, "Thêm Thất Bại");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		arrDiemHoc.add(new QuanLiDiemHocModel(maSv, maMH, diemMH));
	}
	public void update(String maSv, String maMH, String diemMH) {
		try {
			String sql = "update QLDiem set MaSv = ? , DiemMH = ? where MaMH = ? ";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, maSv);
			st.setString(2, diemMH);
			st.setString(3, maMH);
			int x = st.executeUpdate();
			if (x > 0) {
				JOptionPane.showMessageDialog(null, "Sửa Thành Công !!");
			} else {
				JOptionPane.showMessageDialog(null, "Sửa Thất Bại");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		arrDiemHoc.add(new QuanLiDiemHocModel(maSv, maMH, diemMH));
	}
}
