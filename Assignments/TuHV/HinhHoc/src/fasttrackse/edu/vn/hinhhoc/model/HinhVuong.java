package fasttrackse.edu.vn.hinhhoc.model;
import fasttrackse.edu.vn.hinhhoc.main.*;
public class HinhVuong extends HinhHoc{
	private int CanhA;
	public HinhVuong() {
		
	}
	public HinhVuong(int CanhA) {
		this.CanhA = CanhA;
	}
	
	public double getChuVi() {
		return (4*CanhA);
		
	}
	
	public double getDienTich() {
		
		return (CanhA*CanhA);
		
	}
	public int getCanhA() {
		return CanhA;
	}
	public void setCanhA(int canhA) {
		CanhA = canhA;
	}
	

}
