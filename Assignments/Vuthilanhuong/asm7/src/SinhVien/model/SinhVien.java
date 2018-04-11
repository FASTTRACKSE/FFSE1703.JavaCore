package SinhVien.model;
import java.util.Comparator;
import java.io.Serializable;
	public class SinhVien implements Serializable{
		
		private String hoTen;
		private String nSinh;
		private Double diemLp1;
		private Double diemLp2;
	public SinhVien() {
		}
	public SinhVien(String hoTen, String nSinh, Double diemLp1, Double diemLp2) {
		this.hoTen = hoTen;
		this.nSinh = nSinh;
		this.diemLp1 = diemLp1;
		this.diemLp2 = diemLp2;
	}
	
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getnSinh() {
		return nSinh;
	}
	public void setnSinh(String nSinh) {
		this.nSinh = nSinh;
	}
	public Double getDiemLp1() {
		return diemLp1;
	}
	public void setDiemLp1(Double diemLp1) {
		this.diemLp1 = diemLp1;
	}
	public Double getDiemLp2() {
		return diemLp2;
	}
	public void setDiemLp2(Double diemLp2) {
		this.diemLp2 = diemLp2;
	}
	public double getDiemTb() {
		return(diemLp1 + diemLp2)/2;
	}
	
	public static Comparator<SinhVien> comparediem=new Comparator<SinhVien>() {
		//so sánh
		public int compare(SinhVien sv1, SinhVien sv2) {
			if(sv1.getDiemTb()>sv2.getDiemTb()) {
				return 1;
			}
			else {
				if (sv1.getDiemTb()==sv2.getDiemTb()) {
					return 0;
				}
				else {
					return -1;
				}
			}
		}
	};
	public static Comparator<SinhVien> compareten = new Comparator<SinhVien>() {
		public int compare(SinhVien sv1, SinhVien sv2) {
			return sv1.hoTen.compareTo(sv2.hoTen);
		}
	};
	
	}
	