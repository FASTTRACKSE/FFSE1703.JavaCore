package ffse1703005.software.atm.model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class TransactionsDb {
	static ConnectDB myDB = new ConnectDB();
	private static Connection conn= myDB.getConnect("localhost", "ffse1703005", "hainam", "123456");
	public static int addTransactions(String code_customer,String code_atm,String code_transactions,int amount) {
		try {
			String sql = "insert into atm_transactions (code_customer, code_atm, code_transactions,"
					+ "amount) "
					+ " values (?, ?, ?, ?)";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1, code_customer);
			stm.setString(2, code_atm);
			stm.setString(3, code_transactions);
			stm.setInt(4, amount);		
			int i = stm.executeUpdate();						
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public static ArrayList<CusTransaction> getCusTransactionList() {
		ArrayList<CusTransaction> arrTssCus = new ArrayList<CusTransaction>();
		try {
			String sql = "SELECT * " + 
					"FROM atm_customer INNER JOIN atm_transactions " + 
					"ON atm_customer.code = atm_transactions.code_customer " + 
					"inner join atm_wards ON atm_customer.code_wards = atm_wards.code_wards " + 
					"inner join atm_districts ON atm_wards.code_districts = atm_districts.code_districts ORDER by atm_transactions.id_transactions DESC";
			Statement stm = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				CusTransaction cusTss = new CusTransaction();
				cusTss.setCodeCus(rs.getString("atm_customer.code"));
				cusTss.setFullnameCus(rs.getString("atm_customer.fullname"));
				cusTss.setCodeATM(rs.getString("atm_transactions.code_atm"));
				cusTss.setCodeTransaction(rs.getString("atm_transactions.code_transactions"));
				cusTss.setTimeTransaction(rs.getTimestamp("atm_transactions.time_transactions"));
				cusTss.setPayTransaction(rs.getInt("atm_transactions.amount"));
				cusTss.setDistricts(rs.getString("atm_districts.name"));
				cusTss.setWards(rs.getString("atm_wards.name"));
				cusTss.setStreets(rs.getString("atm_customer.streets"));
				arrTssCus.add(cusTss);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrTssCus;
	}
	
	public static ArrayList<CusTransaction> getCusTransactionSearch(String code,String streets,String districts,String wards,Calendar cldFrom,Calendar cldTo) {
		System.out.println(wards);
		ArrayList<CusTransaction> arrTssCus = new ArrayList<CusTransaction>();		
		Date sqlDateFrom = new Date(cldFrom.getTimeInMillis());
		Date sqlDateTo = new Date(cldTo.getTimeInMillis());
		String sql = "SELECT * "
				+ "FROM atm_customer INNER JOIN atm_transactions " 
				+ "ON atm_customer.code = atm_transactions.code_customer "
				+"inner join atm_wards ON atm_customer.code_wards = atm_wards.code_wards  "
				+"inner join atm_districts ON atm_wards.code_districts = atm_districts.code_districts "
				+ "WHERE atm_customer.code LIKE ? ESCAPE '!' AND atm_customer.streets LIKE ? ESCAPE '!' AND atm_districts.name LIKE ? ESCAPE '!' AND atm_wards.name LIKE ? ESCAPE '!' " 
				+ "AND (atm_transactions.time_transactions BETWEEN ? AND ? ) ORDER by atm_transactions.id_transactions DESC";
		try {			
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1, "%" + code + "%");
			stm.setString(2, "%" + streets + "%");
			stm.setString(3, "%" + districts + "%");
			stm.setString(4, "%" + wards + "%");
			stm.setDate(5, sqlDateFrom);
			stm.setDate(6, sqlDateTo);
			ResultSet rs = stm.executeQuery();			
			while (rs.next()) {
				CusTransaction cusTss = new CusTransaction();
				cusTss.setCodeCus(rs.getString("atm_customer.code"));
				cusTss.setFullnameCus(rs.getString("atm_customer.fullname"));
				cusTss.setCodeATM(rs.getString("atm_transactions.code_atm"));
				cusTss.setCodeTransaction(rs.getString("atm_transactions.code_transactions"));
				cusTss.setTimeTransaction(rs.getTimestamp("atm_transactions.time_transactions"));
				cusTss.setPayTransaction(rs.getInt("atm_transactions.amount"));
				arrTssCus.add(cusTss);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrTssCus;
	}
	
	public static ArrayList<CusTransaction> getCusTransactionSearchMonth(String code,String streets,String districts,String wards,String monthChoose) {
		System.out.println(wards);
		ArrayList<CusTransaction> arrTssCus = new ArrayList<CusTransaction>();
		String sql = "SELECT * "
				+ "FROM atm_customer INNER JOIN atm_transactions " 
				+ "ON atm_customer.code = atm_transactions.code_customer "
				+"inner join atm_wards ON atm_customer.code_wards = atm_wards.code_wards  "
				+"inner join atm_districts ON atm_wards.code_districts = atm_districts.code_districts "
				+ "WHERE atm_customer.code LIKE ? ESCAPE '!' AND atm_customer.streets LIKE ? ESCAPE '!' AND atm_districts.name LIKE ? ESCAPE '!' AND atm_wards.name LIKE ? ESCAPE '!' " 
				+ "AND atm_transactions.time_transactions LIKE ? ESCAPE '!' ORDER by atm_transactions.id_transactions DESC";
		try {			
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1, "%" + code + "%");
			stm.setString(2, "%" + streets + "%");
			stm.setString(3, "%" + districts + "%");
			stm.setString(4, "%" + wards + "%");
			stm.setString(5, "%" + monthChoose + "%");
			ResultSet rs = stm.executeQuery();			
			while (rs.next()) {
				CusTransaction cusTss = new CusTransaction();
				cusTss.setCodeCus(rs.getString("atm_customer.code"));
				cusTss.setFullnameCus(rs.getString("atm_customer.fullname"));
				cusTss.setCodeATM(rs.getString("atm_transactions.code_atm"));
				cusTss.setCodeTransaction(rs.getString("atm_transactions.code_transactions"));
				cusTss.setTimeTransaction(rs.getTimestamp("atm_transactions.time_transactions"));
				cusTss.setPayTransaction(rs.getInt("atm_transactions.amount"));
				arrTssCus.add(cusTss);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrTssCus;
	}
	
	public static ArrayList<ATMTransaction> getAtmTransactionList() {
		ArrayList<ATMTransaction> arrTssAtm = new ArrayList<ATMTransaction>();
		try {
			String sql = "SELECT * " + 
					"FROM atm_atm INNER JOIN atm_transactions " + 
					"ON atm_atm.code = atm_transactions.code_atm " + 
					"inner join atm_wards ON atm_atm.code_wards = atm_wards.code_wards " + 
					"inner join atm_districts ON atm_wards.code_districts = atm_districts.code_districts ORDER by atm_transactions.id_transactions DESC";
			Statement stm = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				ATMTransaction atmTss = new ATMTransaction();
				atmTss.setCodeCus(rs.getString("atm_transactions.code_customer"));
				atmTss.setAdressATM(rs.getString("atm_atm.streets"));
				atmTss.setCodeATM(rs.getString("atm_atm.code"));
				atmTss.setCodeTransaction(rs.getString("atm_transactions.code_transactions"));
				atmTss.setTimeTransaction(rs.getTimestamp("atm_transactions.time_transactions"));
				atmTss.setPayTransaction(rs.getInt("atm_transactions.amount"));
				atmTss.setDistricts(rs.getString("atm_districts.name"));
				atmTss.setWards(rs.getString("atm_wards.name"));
				atmTss.setStreets(rs.getString("atm_atm.streets"));
				arrTssAtm.add(atmTss);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrTssAtm;
	}
	
	public static ArrayList<ATMTransaction> getAtmTransactionSearch(String code,String streets,String districts,String wards,Calendar cldFrom,Calendar cldTo) {
		System.out.println(wards);
		ArrayList<ATMTransaction> arrTssAtm = new ArrayList<ATMTransaction>();
		cldTo.add(Calendar.DAY_OF_MONTH, 1); 
		Date sqlDateFrom = new Date(cldFrom.getTimeInMillis());
		Date sqlDateTo = new Date(cldTo.getTimeInMillis());
		String sql = "SELECT * "
				+ "FROM atm_atm INNER JOIN atm_transactions " 
				+ "ON atm_atm.code = atm_transactions.code_atm "
				+"inner join atm_wards ON atm_atm.code_wards = atm_wards.code_wards  "
				+"inner join atm_districts ON atm_wards.code_districts = atm_districts.code_districts "
				+ "WHERE atm_atm.code LIKE ? ESCAPE '!' AND atm_atm.streets LIKE ? ESCAPE '!' AND atm_districts.name LIKE ? ESCAPE '!' AND atm_wards.name LIKE ? ESCAPE '!' " 
				+ "AND (atm_transactions.time_transactions BETWEEN ? AND ? ) ORDER by atm_transactions.id_transactions DESC";
		try {			
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1, "%" + code + "%");
			stm.setString(2, "%" + streets + "%");
			stm.setString(3, "%" + districts + "%");
			stm.setString(4, "%" + wards + "%");
			stm.setDate(5, sqlDateFrom);
			stm.setDate(6, sqlDateTo);
			ResultSet rs = stm.executeQuery();			
			while (rs.next()) {
				ATMTransaction atmTss = new ATMTransaction();
				atmTss.setCodeCus(rs.getString("atm_transactions.code_customer"));
				atmTss.setAdressATM(rs.getString("atm_atm.streets"));
				atmTss.setCodeATM(rs.getString("atm_atm.code"));
				atmTss.setCodeTransaction(rs.getString("atm_transactions.code_transactions"));
				atmTss.setTimeTransaction(rs.getTimestamp("atm_transactions.time_transactions"));
				atmTss.setPayTransaction(rs.getInt("atm_transactions.amount"));
				arrTssAtm.add(atmTss);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrTssAtm;
	}
	
	public static ArrayList<ATMTransaction> getAtmTransactionSearchMonth(String code,String streets,String districts,String wards,String monthChoose) {
		System.out.println(wards);
		ArrayList<ATMTransaction> arrTssAtm = new ArrayList<ATMTransaction>();
		String sql = "SELECT * "
				+ "FROM atm_atm INNER JOIN atm_transactions " 
				+ "ON atm_atm.code = atm_transactions.code_atm "
				+"inner join atm_wards ON atm_atm.code_wards = atm_wards.code_wards  "
				+"inner join atm_districts ON atm_wards.code_districts = atm_districts.code_districts "
				+ "WHERE atm_atm.code LIKE ? ESCAPE '!' AND atm_atm.streets LIKE ? ESCAPE '!' AND atm_districts.name LIKE ? ESCAPE '!' AND atm_wards.name LIKE ? ESCAPE '!' " 
				+ "AND atm_transactions.time_transactions LIKE ? ESCAPE '!' ORDER by atm_transactions.id_transactions DESC";
		try {			
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1, "%" + code + "%");
			stm.setString(2, "%" + streets + "%");
			stm.setString(3, "%" + districts + "%");
			stm.setString(4, "%" + wards + "%");
			stm.setString(5, "%" + monthChoose + "%");
			ResultSet rs = stm.executeQuery();			
			while (rs.next()) {
				ATMTransaction atmTss = new ATMTransaction();
				atmTss.setCodeCus(rs.getString("atm_transactions.code_customer"));
				atmTss.setAdressATM(rs.getString("atm_atm.streets"));
				atmTss.setCodeATM(rs.getString("atm_atm.code"));
				atmTss.setCodeTransaction(rs.getString("atm_transactions.code_transactions"));
				atmTss.setTimeTransaction(rs.getTimestamp("atm_transactions.time_transactions"));
				atmTss.setPayTransaction(rs.getInt("atm_transactions.amount"));
				arrTssAtm.add(atmTss);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrTssAtm;
	}
	
}
