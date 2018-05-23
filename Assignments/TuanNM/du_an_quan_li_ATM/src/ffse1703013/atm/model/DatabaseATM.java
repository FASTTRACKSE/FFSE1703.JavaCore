package ffse1703013.atm.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

public class DatabaseATM {
	final Connection conn = ConnectDatabase.getConnect("localhost", "FFSE1703013_ATM", "tuan18081999", "tuan123");
	ArrayList<ATM> arrATM = new ArrayList<ATM>();

	public ArrayList<ATM> selectATM() {
		try {

			Statement statement = (Statement) conn.createStatement();
			ResultSet rs = statement.executeQuery("select * from ATM");
			while (rs.next()) {
				String maATM = rs.getString("maATM");
				String duong = rs.getString("duongPho");
				String phuong = rs.getString("phuong");
				String quan = rs.getString("quan");
				String tongTien = rs.getString("tongTien");

				arrATM.add(new ATM(maATM, duong, phuong, quan, tongTien));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrATM;

	}

	public ArrayList<ATM> searchATMTheoMa(String maATM1) {
		try {

			Statement statement = (Statement) conn.createStatement();
			ResultSet rs = statement.executeQuery("select * from ATM where maATM LIKE '%" + maATM1 + "%'");
			while (rs.next()) {
				String maATM = rs.getString("maATM");
				String duong = rs.getString("duongPho");
				String phuong = rs.getString("phuong");
				String quan = rs.getString("quan");
				String tongTien = rs.getString("tongTien");

				arrATM.add(new ATM(maATM, duong, phuong, quan, tongTien));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrATM;

	}

	public void insertATM(String maATM, String duongPho, String phuong, String quan, String tongTien) {
		try {
			String sql = "insert into ATM values('" + 0 + "','" + maATM + "','" + duongPho + "','" + phuong + "','"
					+ quan + "','" + tongTien + "')";
			Statement statement = (Statement) conn.createStatement();
			int x = statement.executeUpdate(sql);
			if (x > 0) {
				JOptionPane.showMessageDialog(null, "Lưu thành công");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void updateATM(String maATM, String duongPho, String phuong, String quan, String tongTien) {
		try {

			String sql = "UPDATE `ATM` SET `duongPho`='" + duongPho + "',`phuong`='" + phuong + "',`quan`='" + quan
					+ "',`tongTien`='" + tongTien + "' WHERE `maATM`='" + maATM + "' ";
			Statement statement = (Statement) conn.createStatement();

			int x = statement.executeUpdate(sql);
			if (x > 0) {
				JOptionPane.showMessageDialog(null, "Cập nhật thành công");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void deleteATM(String maATM) {
		try {
			String sql = "DELETE from ATM WHERE maATM='" + maATM + "'";
			Statement statement = (Statement) conn.createStatement();
			int x = statement.executeUpdate(sql);
			if (x > 0) {
				JOptionPane.showMessageDialog(null, "Xóa thành công ");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
