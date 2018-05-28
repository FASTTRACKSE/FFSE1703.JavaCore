package ffse1703005.software.atm.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class MachineATMDb {
	static ConnectDB myDB = new ConnectDB();
	private static Connection conn= myDB.getConnect("localhost", "ffse1703005", "hainam", "123456");
	/*Thêm dữ liệu vào bảng atm_atm lên database*/
	public static int addAtm(MachineATM atm) {
		try {
			String sql = "insert into atm_atm (code, code_districts, code_wards,"
					+ "streets, amount) "
					+ " values (?, ?, ?, ?, ?)";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1, atm.getCodeATM());
			stm.setInt(2, atm.getDistrictATM());
			stm.setInt(3, atm.getWardATM());
			stm.setString(4, atm.getStreetATM());
			stm.setInt(5, atm.getAmountATM());
			int i = stm.executeUpdate();						
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	/*Truy suất dữ liệu của bảng atm_atm từ database vào ArrayList theo kiểu đối tượng MachineATM*/
	public static ArrayList<MachineATM> getAtmList() {
		ArrayList<MachineATM> arrAtm = new ArrayList<>();
		try {
			String sql = "SELECT * " + 
					"FROM atm_atm INNER JOIN atm_wards " + 
					"ON atm_atm.code_wards = atm_wards.code_wards " + 
					"inner join atm_districts ON atm_wards.code_districts = atm_districts.code_districts ORDER by atm_atm.id_atm DESC ";
			Statement stm = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				MachineATM atm = new MachineATM();
				atm.setCodeATM(rs.getString("atm_atm.code"));
				atm.setDistrictATM(rs.getInt("atm_atm.code_districts"));
				atm.setWardATM(rs.getInt("atm_atm.code_wards"));
				atm.setStreetATM(rs.getString("atm_atm.streets"));
				atm.setAmountATM(rs.getInt("atm_atm.amount"));	
				atm.setNameDistricts(rs.getString("atm_districts.name"));	
				atm.setNameWards(rs.getString("atm_wards.name"));
				arrAtm.add(atm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrAtm;
	}
	/*Sửa dữ liệu của bảng atm_atm từ database */
	public static int editAtm(MachineATM atm) {
		try {
			String sql = "update atm_atm set  "
					+ "code_districts = ?, code_wards = ?, streets = ?, " + "amount = ? where code = ?";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setInt(1, atm.getDistrictATM());
			stm.setInt(2, atm.getWardATM());
			stm.setString(3, atm.getStreetATM());
			stm.setInt(4, atm.getAmountATM());
			stm.setString(5, atm.getCodeATM());
			return stm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	/*Xóa dữ liệu của bảng atm_atm từ database */
	public static int delAtm(String code) {
		try {
			String sql = "delete from atm_atm where code = ?";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1, code);
			int i = stm.executeUpdate();						
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	/*Truy suất dữ liệu của bảng atm_atm từ database vào ArrayList điều kiện theo cột streets
	 * theo kiểu đối tượng MachineATM*/
	public static ArrayList<MachineATM> searchStreets(String streets) {
		ArrayList<MachineATM> arrAtm = new ArrayList<MachineATM>();
		try {
			String sql = "SELECT * FROM atm_atm WHERE streets LIKE ? ORDER BY id_atm DESC";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1, "%" + streets + "%");
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				MachineATM atm = new MachineATM();
				atm.setCodeATM(rs.getString("code"));
				atm.setDistrictATM(rs.getInt("code_districts"));
				atm.setWardATM(rs.getInt("code_wards"));
				atm.setStreetATM(rs.getString("streets"));
				atm.setAmountATM(rs.getInt("amount"));	
				arrAtm.add(atm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrAtm;
	}
	/*Truy suất dữ liệu của bảng atm_atm từ database vào ArrayList điều kiện theo cột code
	 * theo kiểu đối tượng MachineATM*/
	public static ArrayList<MachineATM> searchCode(String code) {
		ArrayList<MachineATM> arrAtm = new ArrayList<MachineATM>();
		try {
			String sql = "SELECT * FROM atm_atm WHERE code LIKE ? ORDER BY id_atm DESC";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1, "%" + code + "%");
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				MachineATM atm = new MachineATM();
				atm.setCodeATM(rs.getString("code"));
				atm.setDistrictATM(rs.getInt("code_districts"));
				atm.setWardATM(rs.getInt("code_wards"));
				atm.setStreetATM(rs.getString("streets"));
				atm.setAmountATM(rs.getInt("amount"));	
				arrAtm.add(atm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrAtm;
	}
	/*Truy suất dữ liệu của bảng atm_atm từ database vào ArrayList điều kiện theo cột distrist và cột wards
	 * theo kiểu đối tượng MachineATM*/
	public static ArrayList<MachineATM> searchAdrees(int distrist,int wards) {
		ArrayList<MachineATM> arrAtm = new ArrayList<MachineATM>();
		if(wards == 0) {
			try {				
				String sql = "SELECT * FROM atm_atm WHERE code_districts = ? ORDER BY id_atm DESC";
				PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
				stm.setInt(1, distrist );
				ResultSet rs = stm.executeQuery();
				while (rs.next()) {
					MachineATM atm = new MachineATM();
					atm.setCodeATM(rs.getString("code"));
					atm.setDistrictATM(rs.getInt("code_districts"));
					atm.setWardATM(rs.getInt("code_wards"));
					atm.setStreetATM(rs.getString("streets"));
					atm.setAmountATM(rs.getInt("amount"));
					arrAtm.add(atm);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return arrAtm;
		}else {
			try {				
				String sql = "SELECT * FROM atm_atm WHERE code_districts = ? AND code_wards = ? ORDER BY id_atm DESC ";
				PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
				stm.setInt(1, distrist );
				stm.setInt(2, wards );
				ResultSet rs = stm.executeQuery();
				while (rs.next()) {
					MachineATM atm = new MachineATM();
					atm.setCodeATM(rs.getString("code"));
					atm.setDistrictATM(rs.getInt("code_districts"));
					atm.setWardATM(rs.getInt("code_wards"));
					atm.setStreetATM(rs.getString("streets"));
					atm.setAmountATM(rs.getInt("amount"));
					arrAtm.add(atm);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return arrAtm;
		}		
	}
	/*Truy suất dữ liệu của bảng atm_atm từ database vào ArrayList theo kiểu String*/
	public ArrayList<String> SeclectCodeATM() {
		ArrayList<String> arrCodeATM=new ArrayList<String>();
		try {
			
			Statement statement=conn.createStatement();
			ResultSet result=statement.executeQuery
			("select * from atm_atm");
			while(result.next())
			{
				
				arrCodeATM.add(result.getString("code"));
			}
			} catch (Exception e) {
			e.printStackTrace();
			}
		return arrCodeATM;
	}
	/*Sửa dữ liệu của bảng atm_atm từ database khi thực hiện lệnh rút tiền*/
	public static int editMoney(int money,String code) {
		try {
			String sql = "update atm_atm set amount = ? where code = ?";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setInt(1, money);
			stm.setString(2, code);
			return stm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
}
