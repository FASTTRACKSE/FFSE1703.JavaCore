package ffse1703013.atm.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseDiaChi {
	final static Connection conn = ConnectDatabase.getConnect("localhost", "FFSE1703013_ATM", "tuan18081999",
			"tuan123");

	public static ArrayList<ComboItem> getQuan() {
		ArrayList<ComboItem> arrDiaChi = new ArrayList<ComboItem>();
		try {
			String sql = "select name, maqh from quan where maqh >= 490 AND maqh <= 497";
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				ComboItem item = new ComboItem();
				item.setName(rs.getString(1));
				item.setId(rs.getInt(2));
				arrDiaChi.add(item);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return arrDiaChi;

	}

	public static ArrayList<ComboItem> getQuanTK() {
		ArrayList<ComboItem> arrDiaChi = new ArrayList<ComboItem>();
		try {
			String sql = "select name, maqh from quan";
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				ComboItem item = new ComboItem();
				item.setName(rs.getString(1));
				item.setId(rs.getInt(2));
				arrDiaChi.add(item);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return arrDiaChi;

	}

	public static ArrayList<ComboItem> getPhuonng(int id) {
		ArrayList<ComboItem> arrDiaChi = new ArrayList<ComboItem>();
		try {
			String sql = "SELECT name,maqh from phuong WHERE maqh = " + id;
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				ComboItem item = new ComboItem();
				item.setName(rs.getString(1));
				item.setId(rs.getInt(2));
				arrDiaChi.add(item);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return arrDiaChi;

	}

}
