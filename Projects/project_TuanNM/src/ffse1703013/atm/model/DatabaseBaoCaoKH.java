package ffse1703013.atm.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

public class DatabaseBaoCaoKH {
	final Connection conn = ConnectDatabase.getConnect("localhost", "FFSE1703013_ATM", "tuan18081999", "tuan123");
	ArrayList<ThongKeBaoCao> arrBaoCaoKH = new ArrayList<ThongKeBaoCao>();
	DatabaseKhachHang connectKH = new DatabaseKhachHang();
	ArrayList<KhachHang> arrKH = new ArrayList<KhachHang>();

	public ArrayList<ThongKeBaoCao> selectKhachHangTheoQuan(String quan1, String phuong1) {
		try {
			String sql = "SELECT kh.maKH,kh.tenKH,kh.diaChiNha,kh.phuong,kh.quan,kh.soThe,kh.soTK,count(gd.soTien),sum(gd.soTien),kh.soDu "
					+ "FROM khachhang kh " + "INNER JOIN giaodich gd ON kh.soThe = gd.soTheATM where phuong = '"
					+ phuong1 + "'" + " GROUP BY kh.tenKH ORDER BY kh.maKH";
			Statement statement = (Statement) conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maKH = rs.getString("makh");
				String tenKH = rs.getString("tenKH");
				String diaChiNha = rs.getString("diaChiNha");
				String phuong = rs.getString("phuong");
				String quan = rs.getString("quan");
				String soThe = rs.getString("soThe");
				String soTK = rs.getString("soTK");
				String soLan = rs.getString("count(gd.soTien)");
				int soLanRut = Integer.parseInt(soLan);
				String tongTien1 = rs.getString("sum(gd.soTien)");
				int tongTien = Integer.parseInt(tongTien1);
				String soDu = rs.getString("kh.soDu");
				if (soLanRut > 0 && tongTien > 0) {
					arrBaoCaoKH.add(new ThongKeBaoCao(maKH, tenKH, diaChiNha, phuong, quan, soThe, soTK, soLanRut,
							tongTien, soDu));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrBaoCaoKH;

	}

	public ArrayList<ThongKeBaoCao> searchTheoMaKH(String tenKH1, String phuong1, String quan1) {
		try {

			Statement statement = (Statement) conn.createStatement();
			ResultSet rs = statement.executeQuery(
					"SELECT kh.maKH,kh.tenKH,kh.diaChiNha,kh.phuong,kh.quan,kh.soThe,kh.soTK,count(gd.soTien),sum(gd.soTien) "
							+ "FROM khachhang kh "
							+ "INNER JOIN giaodich gd ON kh.soThe = gd.soTheATM where tenKH LIKE '%" + tenKH1
							+ "%' AND phuong = '" + phuong1 + "' AND quan='" + quan1 + "' ");
			while (rs.next()) {
				try {
					String maKH = rs.getString("makh");
					String tenKH = rs.getString("tenKH");
					String diaChiNha = rs.getString("diaChiNha");
					String phuong = rs.getString("phuong");
					String quan = rs.getString("quan");
					String soThe = rs.getString("soThe");
					String soTK = rs.getString("soTK");
					String soLan = rs.getString("count(gd.soTien)");
					int soLanRut = Integer.parseInt(soLan);
					String tongTien1 = rs.getString("sum(gd.soTien)");
					int tongTien = Integer.parseInt(tongTien1);
					String soDu = rs.getString("kh.soDu");
					if (soLanRut > 0 && tongTien > 0) {
						arrBaoCaoKH.add(new ThongKeBaoCao(maKH, tenKH, diaChiNha, phuong, quan, soThe, soTK, soLanRut,
								tongTien, soDu));
					}
				} catch (Exception ex) {

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrBaoCaoKH;

	}

	public ArrayList<ThongKeBaoCao> selectKhachHang(String maKH1) {
		try {
			String sql = "SELECT *" + "FROM khachhang kh "
					+ "INNER JOIN giaodich gd ON kh.soThe = gd.soTheATM where maKH = '" + maKH1 + "' ";

			Statement statement = (Statement) conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maKH = rs.getString("makh");
				String maGD = rs.getString("maGD");
				String soThe = rs.getString("soThe");
				String thoiGian = rs.getString("ngayRut");
				String soTien = rs.getString("soTien");
				String maMay = rs.getString("maMay");
				arrBaoCaoKH.add(new ThongKeBaoCao(maKH, maGD, soThe, thoiGian, soTien, maMay));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrBaoCaoKH;

	}

	public ArrayList<ThongKeBaoCao> selectKhachHangTheoThang(String thang, String maKH1) {
		try {
			String sql = "SELECT *" + "FROM khachhang kh "
					+ "INNER JOIN giaodich gd ON kh.soThe = gd.soTheATM where ngayRut LIKE '%" + thang
					+ "%' AND maKH = '" + maKH1 + "'";

			Statement statement = (Statement) conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maKH = rs.getString("makh");
				String maGD = rs.getString("maGD");
				String soThe = rs.getString("soThe");
				String thoiGian = rs.getString("ngayRut");
				String soTien = rs.getString("soTien");
				String maMay = rs.getString("maMay");
				arrBaoCaoKH.add(new ThongKeBaoCao(maKH, maGD, soThe, thoiGian, soTien, maMay));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrBaoCaoKH;

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

	public ArrayList<ThongKeBaoCao> selectKhachHangTheoKhoangTG(String maKH1, String start, String end) {
		try {
			String sql = "SELECT *" + "FROM khachhang kh " + "INNER JOIN giaodich gd ON kh.soThe = gd.soTheATM "
					+ "where ngayRut BETWEEN '" + start + "' AND '" + end + "' AND maKH = '" + maKH1 + "' ";

			Statement statement = (Statement) conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maKH = rs.getString("makh");
				String maGD = rs.getString("maGD");
				String soThe = rs.getString("soThe");
				String thoiGian = rs.getString("ngayRut");
				String soTien = rs.getString("soTien");
				String maMay = rs.getString("maMay");
				arrBaoCaoKH.add(new ThongKeBaoCao(maKH, maGD, soThe, thoiGian, soTien, maMay));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrBaoCaoKH;

	}

}
