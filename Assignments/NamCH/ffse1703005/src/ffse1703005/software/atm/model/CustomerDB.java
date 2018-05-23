package ffse1703005.software.atm.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class CustomerDB {
	static ConnectDB myDB = new ConnectDB();
	private static Connection conn= myDB.getConnect("localhost", "ffse1703005", "hainam", "123456");
	/*Thêm dữ liệu vào bảng atm_customer lên database*/
	public static int addCustomer(Customer ctm) {
		try {
			String sql = "insert into atm_customer (code, fullname, code_districts, code_wards,"
					+ "streets, phone, email, cardnumber, pin, amount) "
					+ " values (?, ?, ?, ?, ?, ?, ?, ?, 123456, ?)";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1, ctm.getCodeCus());
			stm.setString(2, ctm.getFullnameCus());
			stm.setInt(3, ctm.getDistrictCus());
			stm.setInt(4, ctm.getWardCus());
			stm.setString(5, ctm.getStreetCus());
			stm.setString(6, ctm.getPhoneCus());
			stm.setString(7, ctm.getEmailCus());
			stm.setString(8, ctm.getCardnumberCus());
			stm.setInt(9, ctm.getAmountCus());
			int i = stm.executeUpdate();						
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	/*truy suất dữ liệu từ bảng atm_customer từ database vào ArrayList
	có kiểu của đối tượng Customer*/
	public static ArrayList<Customer> getCustomersList() {
		ArrayList<Customer> arrCtm = new ArrayList<>();
		try {
			String sql = "SELECT * " + 
					"FROM atm_customer INNER JOIN atm_wards " + 
					"ON atm_customer.code_wards = atm_wards.code_wards " + 
					"inner join atm_districts ON atm_wards.code_districts = atm_districts.code_districts ORDER by atm_customer.id_cus DESC "; 
			Statement stm = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				Customer ctm = new Customer();
				ctm.setCodeCus(rs.getString("atm_customer.code"));
				ctm.setFullnameCus(rs.getString("atm_customer.fullname"));
				ctm.setDistrictCus(rs.getInt("atm_customer.code_districts"));
				ctm.setWardCus(rs.getInt("atm_customer.code_wards"));
				ctm.setStreetCus(rs.getString("atm_customer.streets"));
				ctm.setPhoneCus(rs.getString("atm_customer.phone"));
				ctm.setEmailCus(rs.getString("atm_customer.email"));
				ctm.setCardnumberCus(rs.getString("atm_customer.cardnumber"));
				ctm.setPin(rs.getString("atm_customer.pin"));
				ctm.setAmountCus(rs.getInt("atm_customer.amount"));	
				ctm.setNameDistricts(rs.getString("atm_districts.name"));
				ctm.setNameWards(rs.getString("atm_wards.name"));	
				arrCtm.add(ctm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrCtm;
	}
	/*sửa dữ liệu của bảng atm_customer từ database */
	public static int editCustomer(Customer ctm) {
		try {
			String sql = "update atm_customer set fullname = ?, phone = ?, email = ?, "
					+ "code_districts = ?, code_wards = ?, streets = ?, " + "amount = ? where code = ?";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1, ctm.getFullnameCus());
			stm.setString(2, ctm.getPhoneCus());
			stm.setString(3, ctm.getEmailCus());
			stm.setInt(4, ctm.getDistrictCus());
			stm.setInt(5, ctm.getWardCus());
			stm.setString(6, ctm.getStreetCus());
			stm.setInt(7, ctm.getAmountCus());
			stm.setString(8, ctm.getCodeCus());
			return stm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	/*Xóa suất dữ liệu của bảng atm_customer từ database */
	public static int delCustomer(String code) {
		try {
			String sql = "delete from atm_customer where code = ?";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1, code);
			int i = stm.executeUpdate();						
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	/*truy suất dữ liệu từ bảng atm_customer từ database vào ArrayList có điều kiện theo cột name
	có kiểu của đối tượng Customer*/
	public static ArrayList<Customer> searchName(String name) {
		ArrayList<Customer> arrCtm = new ArrayList<Customer>();
		try {
			String sql = "SELECT * FROM atm_customer WHERE fullname LIKE ? ORDER BY id_cus DESC ";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1, "%" + name + "%");
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Customer ctm = new Customer();
				ctm.setCodeCus(rs.getString("code"));
				ctm.setFullnameCus(rs.getString("fullname"));
				ctm.setDistrictCus(rs.getInt("code_districts"));
				ctm.setWardCus(rs.getInt("code_wards"));
				ctm.setStreetCus(rs.getString("streets"));
				ctm.setPhoneCus(rs.getString("phone"));
				ctm.setEmailCus(rs.getString("email"));
				ctm.setCardnumberCus(rs.getString("cardnumber"));
				ctm.setPin(rs.getString("pin"));
				ctm.setAmountCus(rs.getInt("amount"));
				arrCtm.add(ctm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrCtm;
	}
	/*truy suất dữ liệu từ bảng atm_customer từ database vào ArrayList có điều kiện theo cột phone
	có kiểu của đối tượng Customer*/
	public static ArrayList<Customer> searchPhone(String phone) {
		ArrayList<Customer> arrCtm = new ArrayList<Customer>();
		try {
			String sql = "SELECT * FROM atm_customer WHERE phone LIKE ?  ORDER BY id_cus DESC";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1, "%" + phone + "%");
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Customer ctm = new Customer();
				ctm.setCodeCus(rs.getString("code"));
				ctm.setFullnameCus(rs.getString("fullname"));
				ctm.setDistrictCus(rs.getInt("code_districts"));
				ctm.setWardCus(rs.getInt("code_wards"));
				ctm.setStreetCus(rs.getString("streets"));
				ctm.setPhoneCus(rs.getString("phone"));
				ctm.setEmailCus(rs.getString("email"));
				ctm.setCardnumberCus(rs.getString("cardnumber"));
				ctm.setPin(rs.getString("pin"));
				ctm.setAmountCus(rs.getInt("amount"));
				arrCtm.add(ctm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrCtm;		
	}
	/*truy suất dữ liệu từ bảng atm_customer từ database vào ArrayList có điều kiện theo cột email
	có kiểu của đối tượng Customer*/
	public static ArrayList<Customer> searchEmail(String email) {
		ArrayList<Customer> arrCtm = new ArrayList<Customer>();
		try {
			String sql = "SELECT * FROM atm_customer WHERE email LIKE ?  ORDER BY id_cus DESC";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1, "%" + email + "%");
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Customer ctm = new Customer();
				ctm.setCodeCus(rs.getString("code"));
				ctm.setFullnameCus(rs.getString("fullname"));
				ctm.setDistrictCus(rs.getInt("code_districts"));
				ctm.setWardCus(rs.getInt("code_wards"));
				ctm.setStreetCus(rs.getString("streets"));
				ctm.setPhoneCus(rs.getString("phone"));
				ctm.setEmailCus(rs.getString("email"));
				ctm.setCardnumberCus(rs.getString("cardnumber"));
				ctm.setPin(rs.getString("pin"));
				ctm.setAmountCus(rs.getInt("amount"));
				arrCtm.add(ctm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrCtm;
	}
	/*truy suất dữ liệu từ bảng atm_customer từ database vào ArrayList có điều kiện theo cột code
	có kiểu của đối tượng Customer*/
	public static ArrayList<Customer> searchCode(String code) {
		ArrayList<Customer> arrCtm = new ArrayList<Customer>();
		try {
			String sql = "SELECT * FROM atm_customer WHERE code LIKE ? ORDER BY id_cus DESC";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1, "%" + code + "%");
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Customer ctm = new Customer();
				ctm.setCodeCus(rs.getString("code"));
				ctm.setFullnameCus(rs.getString("fullname"));
				ctm.setDistrictCus(rs.getInt("code_districts"));
				ctm.setWardCus(rs.getInt("code_wards"));
				ctm.setStreetCus(rs.getString("streets"));
				ctm.setPhoneCus(rs.getString("phone"));
				ctm.setEmailCus(rs.getString("email"));
				ctm.setCardnumberCus(rs.getString("cardnumber"));
				ctm.setPin(rs.getString("pin"));
				ctm.setAmountCus(rs.getInt("amount"));
				arrCtm.add(ctm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrCtm;
	}
	/*truy suất dữ liệu từ bảng atm_customer từ database vào ArrayList có điều kiện theo cột streets
	có kiểu của đối tượng Customer*/
	public static ArrayList<Customer> searchStreets(String streets) {
		ArrayList<Customer> arrCtm = new ArrayList<Customer>();
		try {
			String sql = "SELECT * FROM atm_customer WHERE streets LIKE ? ORDER BY id_cus DESC";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1, "%" + streets + "%");
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Customer ctm = new Customer();
				ctm.setCodeCus(rs.getString("code"));
				ctm.setFullnameCus(rs.getString("fullname"));
				ctm.setDistrictCus(rs.getInt("code_districts"));
				ctm.setWardCus(rs.getInt("code_wards"));
				ctm.setStreetCus(rs.getString("streets"));
				ctm.setPhoneCus(rs.getString("phone"));
				ctm.setEmailCus(rs.getString("email"));
				ctm.setCardnumberCus(rs.getString("cardnumber"));
				ctm.setPin(rs.getString("pin"));
				ctm.setAmountCus(rs.getInt("amount"));
				arrCtm.add(ctm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrCtm;
	}
	/*truy suất dữ liệu từ bảng atm_customer từ database vào ArrayList có điều kiện theo cột cardnumber
	có kiểu của đối tượng Customer*/
	public static ArrayList<Customer> searchCardNumber(String cardNumber) {
		ArrayList<Customer> arrCtm = new ArrayList<Customer>();
		try {
			String sql = "SELECT * FROM atm_customer WHERE cardNumber = ? ";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1, cardNumber);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Customer ctm = new Customer();
				ctm.setCodeCus(rs.getString("code"));
				ctm.setFullnameCus(rs.getString("fullname"));
				ctm.setDistrictCus(rs.getInt("code_districts"));
				ctm.setWardCus(rs.getInt("code_wards"));
				ctm.setStreetCus(rs.getString("streets"));
				ctm.setPhoneCus(rs.getString("phone"));
				ctm.setEmailCus(rs.getString("email"));
				ctm.setCardnumberCus(rs.getString("cardnumber"));
				ctm.setPin(rs.getString("pin"));
				ctm.setAmountCus(rs.getInt("amount"));
				arrCtm.add(ctm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrCtm;
	}
	/*truy suất dữ liệu từ bảng atm_customer từ database vào ArrayList có điều kiện theo cột district 
	 * và wards
	có kiểu của đối tượng Customer*/
	public static ArrayList<Customer> searchAdrees(int distrist,int wards) {
		ArrayList<Customer> arrCtm = new ArrayList<Customer>();
		if(wards == 0) {
			try {				
				String sql = "SELECT * FROM atm_customer WHERE code_districts = ? ORDER BY id_cus DESC";
				PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
				stm.setInt(1, distrist );
				ResultSet rs = stm.executeQuery();
				while (rs.next()) {
					Customer ctm = new Customer();
					ctm.setCodeCus(rs.getString("code"));
					ctm.setFullnameCus(rs.getString("fullname"));
					ctm.setDistrictCus(rs.getInt("code_districts"));
					ctm.setWardCus(rs.getInt("code_wards"));
					ctm.setStreetCus(rs.getString("streets"));
					ctm.setPhoneCus(rs.getString("phone"));
					ctm.setEmailCus(rs.getString("email"));
					ctm.setCardnumberCus(rs.getString("cardnumber"));
					ctm.setPin(rs.getString("pin"));
					ctm.setAmountCus(rs.getInt("amount"));
					arrCtm.add(ctm);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return arrCtm;
		}else {
			try {				
				String sql = "SELECT * FROM atm_customer WHERE code_districts = ? AND code_wards = ? ORDER BY id_cus DESC ";
				PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
				stm.setInt(1, distrist );
				stm.setInt(2, wards );
				ResultSet rs = stm.executeQuery();
				while (rs.next()) {
					Customer ctm = new Customer();
					ctm.setCodeCus(rs.getString("code"));
					ctm.setFullnameCus(rs.getString("fullname"));
					ctm.setDistrictCus(rs.getInt("code_districts"));
					ctm.setWardCus(rs.getInt("code_wards"));
					ctm.setStreetCus(rs.getString("streets"));
					ctm.setPhoneCus(rs.getString("phone"));
					ctm.setEmailCus(rs.getString("email"));
					ctm.setCardnumberCus(rs.getString("cardnumber"));
					ctm.setPin(rs.getString("pin"));
					ctm.setAmountCus(rs.getInt("amount"));
					arrCtm.add(ctm);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return arrCtm;
		}		
	}
	/*phương thức kiểm tra đăng nhập khi login vào demo Rút tiền của khách hàng*/
	public static String checkCustomer(String cardnumber,String password) {
		String codeCtm = null;
		try {
			String sql = "SELECT * FROM atm_customer WHERE cardnumber = ? AND pin = ? ";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1,  cardnumber);
			stm.setString(2,  password);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				codeCtm =rs.getString("cardnumber");				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return codeCtm;
		
	}
	/*Sửa dữ liệu sau khi thực hiện lệnh rút tiền thành công.*/
	public static int editMoney(int money,String code) {
		try {
			String sql = "update atm_customer set amount = ? where code = ?";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setInt(1, money);
			stm.setString(2, code);
			return stm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	/*Sửa dữ liệu sau khi thực hiện lệnh thay đổi mật khẩu thành công.*/
	public static int changePass(String code,String pass) {
		try {
			String sql = "update atm_customer set pin = ? where code = ?";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1, pass);
			stm.setString(2, code);		
			return stm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
}
