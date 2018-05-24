package project.model;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class MayATMDb {
	static ConnectDB myDb = new ConnectDB();
	@SuppressWarnings("static-access")
	static Connection conn = myDb.getConnect("localhost", "ffse1703001", "huong", "12345");
	
	//hiển thị thông tin máy atm
	public ArrayList<MayATM> hienThiMayATM(){
		ArrayList<MayATM> arrATM=new ArrayList<MayATM>();
		try {
			
			Statement statement=(Statement) conn.createStatement();
			ResultSet rs=statement.executeQuery
			("select * from atm_atm");
			while(rs.next())
			{
				MayATM ATM = new MayATM();
				ATM.setMaMay(rs.getString("ma"));
				ATM.setTenQuan(rs.getString("quan"));
				ATM.setTenPhuong(rs.getString("phuong"));
				ATM.setTenDuong(rs.getString("duong"));
				ATM.setTongTien(rs.getString("tong_tien"));
				
				
				arrATM.add(ATM);
			}
			} catch (Exception e) {
			e.printStackTrace();
			}
		return arrATM;
		
	}
	//hiển thị vị trí máy atm
	public static ArrayList<MayATM> hienThiViTriMay(){
		ArrayList<MayATM> arrATM=new ArrayList<MayATM>();
		try {
			
			Statement statement=(Statement) conn.createStatement();
			ResultSet rs=statement.executeQuery
			("select * from atm_atm");
			while(rs.next())
			{
				MayATM ATM = new MayATM();
				ATM.setMaMay(rs.getString("ma"));
				ATM.setTenQuan(rs.getString("quan"));
				ATM.setTenPhuong(rs.getString("phuong"));
				ATM.setTenDuong(rs.getString("duong"));
				ATM.setTongTien(rs.getString("tong_tien"));
				arrATM.add(ATM);
			}
			} catch (Exception e) {
			e.printStackTrace();
			}
		return arrATM;
		
	}
	//thêm máy atm
	public static int themMayATM(MayATM ATM) {
		try {
			String sql = "insert into atm_atm (ma, quan, phuong, duong, tong_tien) "
					+ " values (?, ?, ?, ?,?)";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1, ATM.getMaMay());
		
			stm.setString(2, ATM.getTenQuan());
			
			stm.setString(3, ATM.getTenPhuong());
			stm.setString(4, ATM.getTenDuong());
			stm.setString(5, ATM.getTongTien());
			int i = stm.executeUpdate();						
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	//sửa máy atm
	public static int suaMayATM(MayATM ATM) {
		try {
			String sql = "update atm_atm set quan = ?, phuong = ?, "
					+ "duong = ?, tong_tien = ? where ma = ?";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1, ATM.getTenQuan());
			stm.setString(2, ATM.getTenPhuong());
			stm.setString(3, ATM.getTenDuong());
			stm.setString(4, ATM.getTongTien());
			stm.setString(5, ATM.getMaMay());


			return stm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	//xoá máy atm
	public static int xoaMayATM(String mayATM) {
		try {
			String sql = "DELETE FROM atm_atm WHERE ma = ?";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1, mayATM);

			return stm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	//tìm theo mã máy atm
	public ArrayList<MayATM> timTheoMa( String maMay){
		ArrayList<MayATM> arrATM=new ArrayList<MayATM>();
		try {
			String sql ="select * from atm_atm where ma LIKE ?  ";
			PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
			preparedStatement.setString(1, "%" + maMay + "%");
			
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next())
			{
				MayATM ATM = new MayATM();
				ATM.setMaMay(rs.getString("ma"));
				ATM.setTenDuong(rs.getString("duong"));
				ATM.setTongTien(rs.getString("tong_tien"));
				arrATM.add(ATM);
			}
			} catch (Exception e) {
			e.printStackTrace();
			}
		return arrATM;
		
	}
	//tìm theo địa chỉ máy atm
	public ArrayList<MayATM> timTheoDiaChi(String quan,String phuong, String duong){
		ArrayList<MayATM> arrTimKiemDC=new ArrayList<MayATM>();
		try {
			String sql ="select * from atm_atm where quan LIKE ? AND phuong LIKE ? AND duong LIKE ? ";
			PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
			preparedStatement.setString(1, "%" + quan + "%");
			preparedStatement.setString(2, "%" + phuong + "%");
			preparedStatement.setString(3, "%" + duong + "%");
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next())
			{
				MayATM timKiemDC = new MayATM();
				timKiemDC.setMaMay(rs.getString("ma"));
				timKiemDC.setTongTien(rs.getString("tong_tien"));
				timKiemDC.setTenQuan(rs.getString("quan"));
				timKiemDC.setTenPhuong(rs.getString("phuong"));
				timKiemDC.setTenDuong(rs.getString("duong"));
				arrTimKiemDC.add(timKiemDC);
			}
			} catch (Exception e) {
			e.printStackTrace();
			}
		return arrTimKiemDC;
		
	}
	
	public static int rutTienMayATM(int soDu,String maMay) {
		try {
			String sql = "update atm_atm set tong_tien = ? where ma = ?";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setInt(1, soDu);
			stm.setString(2, maMay);
			


			return stm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
}
