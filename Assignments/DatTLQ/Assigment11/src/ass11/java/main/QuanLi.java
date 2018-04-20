package ass11.java.main;
import com.mysql.jdbc.Connection;

import ass11.java.connect.Connect;
import ass11.java.ui.Layout;

public class QuanLi {

	public static void main(String[] args) {
			
		Layout myUI= new Layout("Quản Lí Sinh Viên");
		myUI.showWindow();
		Connection conn= Connect.getConnect("localhost", "Java", "ttien96","zxcv1234");
				if(conn!=null)
				{
				System.out.println("Kết nối MYSQL thành công");
				}
				else
				{
				System.out.println("Kết nối MYSQL thất bại");
				}
	}

}
