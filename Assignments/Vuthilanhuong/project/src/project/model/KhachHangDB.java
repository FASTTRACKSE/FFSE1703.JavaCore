package project.model;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class KhachHangDB {
	static ConnectDB myDb = new ConnectDB();
	@SuppressWarnings("static-access")
	static Connection conn = myDb.getConnect("localhost", "ffse1703001", "huong", "12345");
	
	//hiển thị thông tin khách hàng
	public static ArrayList<KhachHang> hienThiKH(){
		ArrayList<KhachHang> arrKH=new ArrayList<KhachHang>();
		try {
			
			Statement statement=(Statement) conn.createStatement();
			ResultSet rs=statement.executeQuery
			("select * from atm_khach");
			while(rs.next())
			{
				KhachHang kh = new KhachHang();
				kh.setMaKhach(rs.getString("ma_kh"));
				kh.setTenKhach(rs.getString("ho_ten"));
				kh.setDiaChiN(rs.getString("duong"));
				kh.setChonQuan(rs.getString("quan"));
				kh.setChonPhuong(rs.getString("phuong"));
				kh.setSoDT(rs.getString("sdt"));
				kh.setEmailK(rs.getString("email"));
				kh.setSoThe(rs.getString("so_the"));
				kh.setSoTien(rs.getString("so_tien"));
								
				arrKH.add(kh);
			}
			} catch (Exception e) {
			e.printStackTrace();
			}
		return arrKH;
		
	}
	//thêm khách hàng
	public static int themKhachHang(KhachHang kh) {
		try {
			String sql = "insert into atm_khach (ma_kh, ho_ten, quan, phuong,"
					+ "duong, sdt, email, so_the, so_tien) "
					+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1, kh.getMaKhach());
			stm.setString(2, kh.getTenKhach());
			stm.setString(3, kh.getChonQuan());
			stm.setString(4, kh.getChonPhuong());
			stm.setString(5, kh.getDiaChiN());
			stm.setString(6, kh.getSoDT());
			stm.setString(7, kh.getEmailK());
			stm.setString(8, kh.getSoThe());
			stm.setString(9, kh.getSoTien());
			int i = stm.executeUpdate();						
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	//sửa thông tin khách hàng
	public static int suaKhachHang(KhachHang kh) {
		try {
			String sql = "update atm_khach set ho_ten = ?, quan = ?, phuong = ?, "
					+ "duong = ?, sdt = ?, email = ?, " + "so_the = ? ,so_tien = ? where ma_kh = ?";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1, kh.getTenKhach());
			stm.setString(2, kh.getChonQuan());
			stm.setString(3, kh.getChonPhuong());
			stm.setString(4, kh.getDiaChiN());
			stm.setString(5, kh.getSoDT());
			stm.setString(6, kh.getEmailK());
			stm.setString(7, kh.getSoThe());
			stm.setString(8, kh.getSoTien());
			stm.setString(9, kh.getMaKhach());

			return stm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	//xoá khách hàng
	public static int xoaKhachHang(String maK) {
		try {
			String sql = "DELETE FROM atm_khach WHERE ma_kh = ?";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1, maK);

			return stm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	//tìm khách hàng theo địa chỉ
	public ArrayList<KhachHang> timTheoDiaChi(String duong,String quan, String phuong){
		ArrayList<KhachHang> arrKH=new ArrayList<KhachHang>();
		try {
			String sql ="select * from atm_khach where duong LIKE ? AND quan LIKE ? AND phuong LIKE ? ";
			PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
			preparedStatement.setString(1, "%" + duong + "%");
			preparedStatement.setString(2, "%" + quan + "%");
			preparedStatement.setString(3, "%" + phuong + "%");
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next())
			{
				KhachHang kh = new KhachHang();
				kh.setMaKhach(rs.getString("ma_kh"));
				kh.setTenKhach(rs.getString("ho_ten"));
				kh.setDiaChiN(rs.getString("duong"));
				kh.setChonQuan(rs.getString("quan"));
				kh.setChonPhuong(rs.getString("phuong"));
				kh.setSoDT(rs.getString("sdt"));
				kh.setEmailK(rs.getString("email"));
				kh.setSoThe(rs.getString("so_the"));
				kh.setSoTien(rs.getString("so_tien"));
				arrKH.add(kh);
			}
			} catch (Exception e) {
			e.printStackTrace();
			}
		return arrKH;
		
	}
	//tìm khách hang theo mã
	public ArrayList<KhachHang> timTheoMa(String ma){
		ArrayList<KhachHang> arrKH=new ArrayList<KhachHang>();
		try {
			String sql ="select * from atm_khach where ma_kh LIKE ? ";
			PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
			preparedStatement.setString(1, "%" + ma + "%");
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next())
			{
				KhachHang kh = new KhachHang();
				kh.setMaKhach(rs.getString("ma_kh"));
				kh.setTenKhach(rs.getString("ho_ten"));
				kh.setDiaChiN(rs.getString("duong"));
				kh.setChonQuan(rs.getString("quan"));
				kh.setChonPhuong(rs.getString("phuong"));
				kh.setSoDT(rs.getString("sdt"));
				kh.setEmailK(rs.getString("email"));
				kh.setSoThe(rs.getString("so_the"));
				kh.setSoTien(rs.getString("so_tien"));
				arrKH.add(kh);
			}
			} catch (Exception e) {
			e.printStackTrace();
			}
		return arrKH;
		
	}	
	//tìm khách hàng theo tên
	public ArrayList<KhachHang> timTheoTen(String ten){
		ArrayList<KhachHang> arrKH=new ArrayList<KhachHang>();
		try {
			String sql ="select * from atm_khach where ho_ten LIKE ? ";
			PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
			preparedStatement.setString(1, "%" + ten + "%");
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next())
			{
				KhachHang kh = new KhachHang();
				kh.setMaKhach(rs.getString("ma_kh"));
				kh.setTenKhach(rs.getString("ho_ten"));
				kh.setDiaChiN(rs.getString("duong"));
				kh.setChonQuan(rs.getString("quan"));
				kh.setChonPhuong(rs.getString("phuong"));
				kh.setSoDT(rs.getString("sdt"));
				kh.setEmailK(rs.getString("email"));
				kh.setSoThe(rs.getString("so_the"));
				kh.setSoTien(rs.getString("so_tien"));
				arrKH.add(kh);
			}
			} catch (Exception e) {
			e.printStackTrace();
			}
		return arrKH;
		
	}	
	//kiểm tra đăng nhập
	public static boolean checkLoginGD(String so_the, String mat_khau) {
		try {
			String sql = "select * from atm_khach where so_the = ? and mat_khau = ?";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1, so_the);
			stm.setString(2, mat_khau);
			ResultSet result = stm.executeQuery();
			if (!result.next()) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static int rutTien(int soDu,String soThe) {
		try {
			String sql = "update atm_khach set so_tien = ? where so_the = ?";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setInt(1, soDu);
			stm.setString(2, soThe);

			return stm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
}
