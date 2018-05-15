package ffse1703005.software.atm.main;

import ffse1703005.software.atm.ui.MainLayout;
import ffse1703005.software.atm.model.*;
public class ManageATM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub			
		MainLayout myUI = new MainLayout("TP Bank - Vì Chúng Tôi Hiểu Bạn.");
		myUI.showWindow();
		ConnectDB conn=new ConnectDB();		
		if(conn.getConnect("localhost", "ffse1703005", "hainam", "123456")!=null)
		{
		System.out.println("Kết nối MYSQL thành công");
		}
		else
		{
		System.out.println("Kết nối MYSQL thất bại");
		}
	}

}
