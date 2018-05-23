package ffse1703013.atm.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import java.sql.Statement;

public class DatabaseGiaoDich {
	final static Connection conn = ConnectDatabase.getConnect("localhost", "FFSE1703013_ATM", "tuan18081999",
			"tuan123");

	public ArrayList<KhachHang> getThongTinKhachHang(String soThe1) {
		ArrayList<KhachHang> arrTT = new ArrayList<>();
		try {

			Statement statement = (Statement) conn.createStatement();
			ResultSet rs = statement.executeQuery("select * from KhachHang where soThe = '" + soThe1 + "'");
			while (rs.next()) {
				String maKH = rs.getString("makh");
				String tenKH = rs.getString("tenKH");
				String diaChiNha = rs.getString("diaChiNha");
				String phuong = rs.getString("phuong");
				String quan = rs.getString("quan");
				String dienThoai = rs.getString("dienThoai");
				String email = rs.getString("email");
				String soThe = rs.getString("soThe");
				String soTK = rs.getString("soTK");
				String soDu = rs.getString("soDu");
				String maPin = rs.getString("maPin");
				arrTT.add(new KhachHang(maKH, tenKH, diaChiNha, phuong, quan, dienThoai, email, soThe, soTK, soDu,
						maPin));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrTT;

	}

	public int tongTien(String maATM) {
		int tongTienTrongMay = 0;
		try {
			String sql = "SELECT tongTien from ATM where maATM = '" + maATM + "'";
			Statement statement = (Statement) conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {

				String tongTien = rs.getString("tongTien");
				tongTienTrongMay = Integer.parseInt(tongTien);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tongTienTrongMay;
	}

	public void capNhatRutTienATM(String maATM, String tongTien) {
		try {

			String sql = "UPDATE `ATM` SET `tongTien`='" + tongTien + "' WHERE `maATM`='" + maATM + "' ";
			Statement statement = (Statement) conn.createStatement();

			@SuppressWarnings("unused")
			int x = statement.executeUpdate(sql);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void capNhatRutTienKH(String soThe, String tongTien) {
		try {

			String sql = "UPDATE `khachhang` SET `soDu`='" + tongTien + "' WHERE `soThe`='" + soThe + "' ";
			Statement statement = (Statement) conn.createStatement();

			@SuppressWarnings("unused")
			int x = statement.executeUpdate(sql);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void doiMaPin(String soThe, String maPin) {
		try {

			String sql = "UPDATE `khachhang` SET `maPin`='" + maPin + "' WHERE `soThe`='" + soThe + "' ";
			System.out.println(sql);
			Statement statement = (Statement) conn.createStatement();

			@SuppressWarnings("unused")
			int x = statement.executeUpdate(sql);
			if (x > 0) {
				JOptionPane.showMessageDialog(null, "Đổi mã pin thành công");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void insertGiaoDich(String maGD, String soThe, String soTien, String maMay) {
		try {
			String sql = "INSERT INTO `giaodich`(`maGD`, `soTheATM`, `soTien`, `maMay`) VALUES " + "('" + maGD + "','"
					+ soThe + "','" + soTien + "','" + maMay + "')";
			Statement statement = (Statement) conn.createStatement();
			int x = statement.executeUpdate(sql);
			if (x > 0) {
				JOptionPane.showMessageDialog(null, "Giao dịch thành công");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
