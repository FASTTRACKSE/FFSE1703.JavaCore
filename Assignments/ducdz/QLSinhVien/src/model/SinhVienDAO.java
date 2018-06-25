package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import model.ConnectDB;

public class SinhVienDAO {
    static Connection conn ;
    protected static void connect() throws SQLException {
        if (conn == null || conn.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            conn = ConnectDB.getConnect("localhost","java_web_asm","root","");
        }
    }
    public static List<SinhVien> getRecord(int start, int total) throws SQLException{
    	List<SinhVien> listsv = new ArrayList<>();
    	start = start - 1;
    	connect();
    	Statement ps = (Statement) conn.createStatement();
    	ResultSet rs = ps.executeQuery("select * from `sinh_vien` order by `id` asc limit "+start+","+total+" ");
    	while(rs.next()) {
			SinhVien sv = new SinhVien(rs.getString("id"),rs.getString("ten_sv"),rs.getString("ngay_sinh"),rs.getString("que_quan")
					,rs.getString("gioi_tinh"),rs.getString("lop"),rs.getString("photo"));
			listsv.add(sv);
    	}
    	conn.close();
    	ps.close();
		return listsv;
    }
    public static int soTrang () throws SQLException {
    	int soTrang = 0;
    	connect();
    	Statement stm = (Statement) conn.createStatement();
    	String sql = "select count(id) from sinh_vien";
    	ResultSet rs = stm.executeQuery(sql);
    	while(rs.next()) {
    		soTrang = rs.getInt("count(id)");
    	}
		return soTrang;
    }
	public static List<SinhVien> listAllSV() {
		List<SinhVien> listSV = new ArrayList<>();
		try {
			connect();
			Statement stm = (Statement) conn.createStatement();
			String sql = "Select * from sinh_vien limit "+0+", "+5+"";
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				SinhVien sv = new SinhVien(rs.getString("id"),rs.getString("ten_sv"),rs.getString("ngay_sinh"),
						rs.getString("que_quan"),rs.getString("gioi_tinh"),rs.getString("lop"),rs.getString("photo"));
				listSV.add(sv);
			}
			rs.close();
			stm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listSV;
	}
	public static boolean insertSV(SinhVien sv) throws SQLException {
		conn = ConnectDB.getConnect("localhost","java_web_asm","root","");
		String sql = "insert into sinh_vien (id,ten_sv,ngay_sinh,que_quan,gioi_tinh,lop,photo) values(?,?,?,?,?,?,?)";
		PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
		ps.setString(1, sv.getId());
		ps.setString(2, sv.getTensv());
		ps.setString(3, sv.getNgaysinh());
		ps.setString(4, sv.getQuequan());
		ps.setString(5, sv.getGioitinh());
		ps.setString(6, sv.getLop());
		ps.setString(7, sv.getPhoto());
		boolean rowInserted = ps.executeUpdate()>0;
		ps.close();
		conn.close();
		return rowInserted;
		}
	public static boolean deleteSV(SinhVien sv) throws SQLException{
		connect();
		String sql ="delete from sinh_vien where id = ?";
		PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
		ps.setString(1, sv.getId());
		boolean rowDeleted = ps.executeUpdate()>0;
		ps.close();
		conn.close();
		return rowDeleted;
	}
	
	public static boolean updateSV(SinhVien sv) throws SQLException{
		connect();
		String sql="update sinh_vien set ten_sv=?, ngay_sinh=?, que_quan=?, gioi_tinh=?, lop=?, photo=? where id=?";
		PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
		ps.setString(1, sv.getTensv());
		ps.setString(2, sv.getNgaysinh());
		ps.setString(3, sv.getQuequan());
		ps.setString(4, sv.getGioitinh());
		ps.setString(5, sv.getLop());
		ps.setString(7, sv.getId());
		ps.setString(6, sv.getPhoto());
		boolean rowUpdated = ps.executeUpdate()>0;
		ps.close();
		conn.close();
		return rowUpdated;
	}
	public static SinhVien getSV(String id) throws SQLException {
		// TODO Auto-generated method stub
		SinhVien sv = null;
		String sql = "select * from sinh_vien where `id` = "+id+"";
		connect();
		PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			String masv = rs.getString("id");
			String ten = rs.getString("ten_sv");
			String ngaysinh = rs.getString("ngay_sinh");
			String quequan = rs.getString("que_quan");
			String gioitinh = rs.getString("gioi_tinh");
			String lop = rs.getString("lop");
			String photo = rs.getString("photo");
			sv = new SinhVien(masv,ten,ngaysinh,quequan,gioitinh,lop,photo);
		}
		rs.close();
		conn.close();
		return sv;
	}
}