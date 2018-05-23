package ffse1703013.atm.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseBaoCaoATM {
	final static Connection conn = ConnectDatabase.getConnect("localhost", "FFSE1703013_ATM", "tuan18081999",
			"tuan123");
	ArrayList<ThongKeBaoCao> arrBaoCaoATM = new ArrayList<ThongKeBaoCao>();
	ArrayList<GiaoDich> arrBaoCao = new ArrayList<GiaoDich>();

	public static ArrayList<String> getDuongPho(String phuong) {
		ArrayList<String> arrDuongPho = new ArrayList<String>();
		try {
			String sql = "select DISTINCT duongPho from ATM where phuong = '" + phuong + "'";

			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {

				String item = rs.getString(1);

				arrDuongPho.add(item);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return arrDuongPho;

	}

	public static ArrayList<String> getMaMay(String duong) {
		ArrayList<String> arrDuongPho = new ArrayList<String>();
		try {
			String sql = "select maATM from ATM where duongPho = '" + duong + "'";
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {

				String item = rs.getString(1);

				arrDuongPho.add(item);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return arrDuongPho;

	}

	public ArrayList<ATM> selectMayATM(String maATM, String duong, String phuong1) {

		ArrayList<ATM> arrDanhSachATM = new ArrayList<>();
		try {
			String sql = "SELECT * from ATM where duongPho = '" + duong + "' AND phuong = '" + phuong1 + "'";
			Statement statement = (Statement) conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maMay = rs.getString("maATM");
				String duongPho = rs.getString("duongPho");
				String phuong = rs.getString("phuong");
				String quan = rs.getString("quan");
				String tongTien = rs.getString("tongTien");
				arrDanhSachATM.add(new ATM(maMay, duongPho, phuong, quan, tongTien));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrDanhSachATM;
	}

	public ArrayList<GiaoDich> selectDanhSachRutTienKH(String maMay1) {
		ArrayList<GiaoDich> arrBaoCao = new ArrayList<GiaoDich>();

		try {
			String sql = "SELECT * FROM giaodich where maMay = '" + maMay1 + "'";

			Statement statement = (Statement) conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maGD = rs.getString("maGD");
				String soThe = rs.getString("soTheATM");
				String thoiGian = rs.getString("ngayRut");
				String soTien = rs.getString("soTien");
				String maMay = rs.getString("maMay");
				arrBaoCao.add(new GiaoDich(maGD, soThe, thoiGian, soTien, maMay));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrBaoCao;

	}

	public ArrayList<GiaoDich> selectATMTheoThang(String thang, String maMay1) {

		try {
			String sql = "SELECT * FROM giaodich where ngayRut LIKE '%" + thang + "%' AND maMay = '" + maMay1 + "'";
			Statement statement = (Statement) conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maGD = rs.getString("maGD");
				String soThe = rs.getString("soTheATM");
				String thoiGian = rs.getString("ngayRut");
				String soTien = rs.getString("soTien");
				String maMay = rs.getString("maMay");
				arrBaoCao.add(new GiaoDich(maGD, soThe, thoiGian, soTien, maMay));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrBaoCao;
	}

	public int tinhKhoangTG(String start, String end) {
		int totalDate = 0;
		try {
			String sql = "SELECT DATEDIFF('" + end + "', '" + start + "')";

			Statement statement = (Statement) conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				totalDate = rs.getInt(1);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return totalDate;

	}

	public ArrayList<GiaoDich> selectATMTheoKhoangTG(String maMay1, String start, String end) {
		try {
			String sql = "SELECT *" + "FROM giaodich where ngayRut BETWEEN '" + start + "' AND '" + end
					+ "' AND maMay = '" + maMay1 + "' ";
			Statement statement = (Statement) conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maGD = rs.getString("maGD");
				String soThe = rs.getString("soTheATM");
				String thoiGian = rs.getString("ngayRut");
				String soTien = rs.getString("soTien");
				String maMay = rs.getString("maMay");
				arrBaoCao.add(new GiaoDich(maGD, soThe, thoiGian, soTien, maMay));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrBaoCao;

	}
}
