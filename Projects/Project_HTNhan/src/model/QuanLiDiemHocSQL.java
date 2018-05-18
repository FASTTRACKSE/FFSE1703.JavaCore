package model;

import java.sql.Connection;
import java.util.ArrayList;

public class QuanLiDiemHocSQL {
	final Connection conn = GetConnectDB.getConnect("localhost", "QuanLiTruongHoc", "admin", "admin");
	private ArrayList<QuanLiDiemHocModel> arrDiemHoc = new ArrayList<>();
	
}
