package ffse1703005.software.atm.model;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
public class UserAdminDb {
	static ConnectDB myDB = new ConnectDB();
	private static Connection conn= myDB.getConnect("localhost", "ffse1703005", "hainam", "123456");
	/*Kiểm tra đăng nhập admin khi login vào UI LayoutAdmin*/
	public static String checkUser(String username,String password) {
		String user = null;
		try {
			String sql = "SELECT * FROM atm_user WHERE username = ? AND password = ? ";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1,  username);
			stm.setString(2,  password);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				user =rs.getString("username");				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;		
	}
	/*Truy suất dữ liệu của bảng atm_user từ database vào ArrayList theo đối tượng UserAdmin*/
	public static ArrayList<UserAdmin> getUser(String username,String password) {
		ArrayList<UserAdmin> arrUser = new ArrayList<UserAdmin>();
		try {
			String sql = "SELECT * FROM atm_user WHERE username = ? AND password = ? ";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1, username);
			stm.setString(2, password);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				UserAdmin user = new UserAdmin();
				user.setUsername(rs.getString("username"));
				user.setCode(rs.getString("code"));
				user.setPassword(rs.getString("password"));
				user.setFullname(rs.getString("fullname"));
				user.setPosition(rs.getString("position"));
				user.setAgency(rs.getString("agency"));							
				arrUser.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrUser;
	}	
	/*Truy suất dữ liệu của bảng atm_user từ database 
	 * theo điều kiện cột username
	 *  vào ArrayList theo đối tượng UserAdmin*/
	public static ArrayList<UserAdmin> getUserList(String username) {
		ArrayList<UserAdmin> arrUser = new ArrayList<UserAdmin>();
		try {
			String sql = "SELECT * FROM atm_user WHERE username = ? ";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1, username);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				UserAdmin user = new UserAdmin();
				user.setUsername(rs.getString("username"));
				user.setCode(rs.getString("code"));
				user.setPassword(rs.getString("password"));
				user.setFullname(rs.getString("fullname"));
				user.setPosition(rs.getString("position"));
				user.setAgency(rs.getString("agency"));							
				arrUser.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrUser;
	}
	/*Sửa dữ liệu của bảng atm_user từ database khi thực hiện lênh changePass*/
	public static int changePass(String username,String pass) {
		try {
			String sql = "update atm_user set password = ? where username = ?";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1, pass);
			stm.setString(2, username);		
			return stm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
}
