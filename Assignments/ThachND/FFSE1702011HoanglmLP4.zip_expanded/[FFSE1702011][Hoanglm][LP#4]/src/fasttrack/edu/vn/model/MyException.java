package fasttrack.edu.vn.model;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import java.util.*;
import java.sql.*;
import com.mysql.*;

import fasttrack.edu.vn.connection.ConnectSql;

import java.io.*;
public class MyException extends Exception {
	static Connection conn = ConnectSql.getConnect("localhost", "ffse1702011", "ffse1702011", "123456");
	public MyException() {
		super();
	}
	
	//Check User Code
	public boolean chkUserCode(String str) throws MyException {
		try {
			String sql = "select User_Code from ffse1702011_user_information";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while(result.next()) {
				if(str.equals(result.getString(1))) {
					JOptionPane.showMessageDialog(null, "Mã khách hàng đã tồn tại!");
					return false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	//Check Meter Code
		public boolean chkMeterCode(String str) throws MyException {
			try {
				String sql = "select Meter_Code from ffse1702011_user_information";
				Statement statement = conn.createStatement();
				ResultSet result = statement.executeQuery(sql);
				while(result.next()) {
					if(str.equals(result.getString(1))) {
						JOptionPane.showMessageDialog(null, "Mã công tơ đã tồn tại!");
						return false;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		}
	
	//Check Empty
	
	public boolean chkEmpty(String str) throws MyException {
		if(str.equals("")) {
			JOptionPane.showMessageDialog(null, "Không được để trống!");
			return false;
		}
		return true;
	}
	
	//Check Phone
	
	public boolean chkPhone(String str) throws MyException {
		if(str.equals("")) {
			JOptionPane.showMessageDialog(null, "Không được để trống!");
			return false;
		} else {
			try {
				Integer.parseInt(str);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập số!");
				return false;
			}
		}
		return true;
	}
	
	//Check Email
	
	public boolean chkEmail(String str) throws MyException {
		String EMAIL_PATTERN = 
		        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(str);
        if(!matcher.matches()) {
        		JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng định dạng!");
        		return false;
        }
        return true;
	}
	
	//Check Find Meter Code
		public boolean chkFindMeterCode(String str) throws MyException {
			try {
				String sql = "select Meter_Code from ffse1702011_user_information where Meter_Code = '"+str+"'";
				Statement statement = conn.createStatement();
				ResultSet result = statement.executeQuery(sql);
				while(result.next()) {
					return true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Mã công tơ không tồn tại!");
			return false;
		}
		
	//Check Find User Code
		public boolean chkFindUserCode(String str) throws MyException {
			try {
				String sql = "select User_Code from ffse1702011_user_information where User_Code = '"+str+"'";
				Statement statement = conn.createStatement();
				ResultSet result = statement.executeQuery(sql);
				while(result.next()) {
					return true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Mã khách hàng không tồn tại!");
			return false;
		}
		
	//Check Meter Number
	
	public boolean chkMeterNumber(String str) throws MyException {
		if(str.equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng không để trống!");
			return false;
		} else {
			try {
				Integer.parseInt(str);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập số!");
				return false;
			}
		}
		int intStr = Integer.parseInt(str);
		if(intStr < 0){
			JOptionPane.showMessageDialog(null, "Không được nhập số âm!");
			return false;
			
		} 
		return true;
	}
	
	//Check Cycle
	
	public boolean chkCycle(String month, String year, String meterCode) throws MyException {
		try {
			String sqlCount = "select COUNT(ID) from ffse1702011_bill_information where Meter_Code = '"+meterCode+"'";
			Statement stmCount = conn.createStatement();
			ResultSet rsCount = stmCount.executeQuery(sqlCount);
			while(rsCount.next()) {
				if(rsCount.getString(1).equals("0")) {
					return true;
				} else if(month.equals("1")) {
					int lastYear = Integer.parseInt(year) - 1;
					try {
						String sql = "select * from ffse1702011_bill_information where Meter_Code = '"+meterCode+"' and Cycle_Month = '"+12+"' and Cycle_Year = '"+lastYear+"'";
						Statement stm = conn.createStatement();
						ResultSet rs = stm.executeQuery(sql);
						while(rs.next()) {
							return true;
						}
					} catch (Exception e2) {
						e2.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "Kiểm tra lại chu kì");
					return false;
				} else {
					try {
						int intMonth = Integer.parseInt(month) - 1;
						String sql = "select Meter_Code from ffse1702011_bill_information where Meter_Code = '"+meterCode+"' and Cycle_Month = '"+intMonth+"' and Cycle_Year = '"+year+"'";
						Statement statement = conn.createStatement();
						ResultSet result = statement.executeQuery(sql);
						while(result.next()) {
							return true;
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "Kiểm tra lại chu kì");
					return false;
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return true;
	}
	
	//Check Same Cycle
	public boolean chkSameCycle(String month, String year, String meterCode) throws MyException {
		try {
			String sql = "select Meter_Code from ffse1702011_bill_information where Meter_Code = '"+meterCode+"' and Cycle_Month = '"+month+"' and Cycle_Year = '"+year+"'";
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				JOptionPane.showMessageDialog(null, "Kiểm tra lại chu kì");
				return false;
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return true;
	}
	
}
