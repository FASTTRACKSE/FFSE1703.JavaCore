package FFSE1703004.main;

import java.awt.HeadlessException;
import java.sql.SQLException;

import FFSE1703004.ui.DanhMuc;
import FFSE1703004.ui.KhachHang;
//import FFSE1703004.ui.Login;

//import FFSE1703004.ui.Login;
public class MainIdea {

	public static void main(String[] args) throws HeadlessException, SQLException {
		DanhMuc venue = new DanhMuc("QUẢN LÝ TIỀN ĐIỆN");
		venue.showWindow();

	}

}
