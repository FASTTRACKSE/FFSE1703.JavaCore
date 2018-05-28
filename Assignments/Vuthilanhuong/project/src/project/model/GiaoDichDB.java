package project.model;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class GiaoDichDB {
	static ConnectDB myDb = new ConnectDB();
	@SuppressWarnings("static-access")
	static Connection conn = myDb.getConnect("localhost", "ffse1703001", "huong", "12345");
	
	//select từ bảng atm_giaodich, dùng hàm like để tìm kiếm
	public ArrayList<GiaoDich> timTheoDiaChi(String duong,String quan, String phuong){
		ArrayList<GiaoDich> arrKH=new ArrayList<GiaoDich>();
		try {
			String sql ="select * from atm_giaodich where quan LIKE ? AND phuong LIKE ? AND duong LIKE ? ";
			PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
			preparedStatement.setString(1, "%" + quan + "%");
			preparedStatement.setString(2, "%" + phuong + "%");
			preparedStatement.setString(3, "%" + duong + "%");
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next())
			{
				GiaoDich kh = new GiaoDich();
				kh.setMaATM(rs.getString("ma_kh"));
				arrKH.add(kh);
			}
			} catch (Exception e) {
			e.printStackTrace();
			}
		return arrKH;
	}
	//insert từ bảng atm_giaodich trên database để thêm gaio dịch
	public static int themGiaoDich(String soThe, String maMay, String maGD, String TongTien) {
		try {
			String sql = "insert into atm_giaodich (so_the, ma_atm, ma_giaodich,  tong_tien) "
					+ " values (?, ?, ?, ?)";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1, soThe);
			stm.setString(2, maMay);
			stm.setString(3, maGD);
			stm.setString(4, TongTien);
			
			int i = stm.executeUpdate();						
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	//join 2 bảng bằng cột so_the trong bảng atm_khach và atm_giaodich
	public static ArrayList<KhachHangGD> giaoDichKH() {
		ArrayList<KhachHangGD> arrKHGD = new ArrayList<KhachHangGD>();
		try {
			String sql ="select * from atm_giaodich INNER JOIN atm_khach ON atm_giaodich.so_the = atm_khach.so_the  ";
			PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next())
			{
				KhachHangGD kh = new KhachHangGD();
				kh.setTenKhach(rs.getString("atm_khach.ho_ten"));
				kh.setMaK(rs.getString("atm_khach.ma_kh"));
				kh.setMaGiaoDich(rs.getString("atm_giaodich.ma_giaodich"));
				kh.setTheKhachHang(rs.getString("atm_giaodich.so_the"));
				kh.setThoiGianGD(rs.getTimestamp("atm_giaodich.thoi_gian_gd"));
				kh.setTongTien(rs.getDouble("atm_giaodich.tong_tien"));
				kh.setMaATM(rs.getString("atm_giaodich.ma_atm"));
				arrKHGD.add(kh);
			}
			} catch (Exception e) {
			e.printStackTrace();
			}
		return arrKHGD;
	}
	//join 2 bảng bằng cột so_the trong bảng atm_khach và atm_giaodich
	public static ArrayList<ATMGD> giaoDichATM() {
		ArrayList<ATMGD> arrATMGD = new ArrayList<ATMGD>();
		try {
			String sql ="select * from atm_giaodich INNER JOIN atm_atm ON atm_giaodich.ma_atm = atm_atm.ma  ";
			PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next())
			{
				ATMGD ATM = new ATMGD();
				ATM.setQuan(rs.getString("atm_atm.quan"));
				ATM.setPhuong(rs.getString("atm_atm.phuong"));
				ATM.setDuong(rs.getString("atm_atm.duong"));
				ATM.setMaGiaoDich(rs.getString("atm_giaodich.ma_giaodich"));
				ATM.setTheKhachHang(rs.getString("atm_giaodich.so_the"));
				ATM.setThoiGianGD(rs.getTimestamp("atm_giaodich.thoi_gian_gd"));
				ATM.setTongTien(rs.getDouble("atm_giaodich.tong_tien"));
				ATM.setMaATM(rs.getString("atm_giaodich.ma_atm"));
				arrATMGD.add(ATM);
			}
			} catch (Exception e) {
			e.printStackTrace();
			}
		return arrATMGD;
	}
	//select từ bảng atm_khach tìm mã trong cột ma_khach
	public ArrayList<KhachHangGD> timTheoMaKhach(){
		ArrayList<KhachHangGD> arrKHGD=new ArrayList<KhachHangGD>();
		try {
			String sql ="select * from atm_khach where ma_khach LIKE    ";
			PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next())
			{
				KhachHangGD kh = new KhachHangGD();
				kh.setTenKhach(rs.getString("atm_khach.ho_ten"));
				kh.setMaK(rs.getString("atm_khach.ma_kh"));
				kh.setMaGiaoDich(rs.getString("atm_giaodich.ma_giaodich"));
				kh.setTheKhachHang(rs.getString("atm_giaodich.so_the"));
				kh.setThoiGianGD(rs.getTimestamp("atm_giaodich.thoi_gian_gd"));
				kh.setTongTien(rs.getDouble("atm_giaodich.tong_tien"));
				kh.setMaATM(rs.getString("atm_giaodich.ma_atm"));
				arrKHGD.add(kh);
			}
			} catch (Exception e) {
			e.printStackTrace();
			}
		return arrKHGD;
		
	}	
	
}

