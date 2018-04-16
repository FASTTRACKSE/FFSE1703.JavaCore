package fasttrackse.assignment4.model;

import java.util.Comparator;

public class SinhVien {
	static long tongSinhVien;

	public static long getTongSinhVien() {
		return tongSinhVien;
	}

	public static void setTongSinhVien(long tongSinhVien) {
		SinhVien.tongSinhVien = tongSinhVien;
	}

	private String hoTen;
	private String ngaySinh;
	private float diemLp1;
	private float diemLp2;
	
	public SinhVien() {
		themSinhVien();
	}
	
	static private void themSinhVien() {
		tongSinhVien += 1;
	}

	public SinhVien(String hoten, String ngaySinh, float diemLp1, float diemLp2) {
		themSinhVien();
		this.hoTen = hoten;
		this.ngaySinh = ngaySinh;
		this.diemLp1 = diemLp1;
		this.diemLp2 = diemLp2;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public float getDiemLp1() {
		return diemLp1;
	}

	public void setDiemLp1(float diemLp1) {
		this.diemLp1 = diemLp1;
	}

	public float getDiemLp2() {
		return diemLp2;
	}

	public void setDiemLp2(float diemLp2) {
		this.diemLp2 = diemLp2;
	}

	public float getDiemTB() {
		return ((getDiemLp1() + getDiemLp2()) / 2);
	}

	public String getXepLoai() {
		if (getDiemTB() <= 4.9) {
			return "Yếu";
		} else if (getDiemTB() <= 6.9) {
			return "Trung Bình";
		} else if (getDiemTB() <= 8.4) {
			return "Khá";
		} else {
			return "Giỏi";
		}
	}

    /*Comparator for sorting the list by Student Name*/
    public static Comparator<SinhVien> SVNameComparator = new Comparator<SinhVien>() {

	public int compare(SinhVien s1, SinhVien s2) {
	   String StudentName1 = s1.getHoTen().toUpperCase();
	   String StudentName2 = s2.getHoTen().toUpperCase();

	   //ascending order
	   return StudentName1.compareTo(StudentName2);

	   //descending order
	   //return StudentName2.compareTo(StudentName1);
    }};

    /*Comparator for sorting the list by roll no*/
    public static Comparator<SinhVien> SVDTBComparator = new Comparator<SinhVien>() {

	public int compare(SinhVien s1, SinhVien s2) {

	   float fDTB1 = s1.getDiemTB();
	   float fDTB2 = s2.getDiemTB();

	   /*For ascending order*/
	   if ((fDTB2 - fDTB1) > 0)
		   return 1;
	   else if ((fDTB2 - fDTB1) < 0)
		   return -1;
	   else
		   return 0;

	   /*For descending order*/
	   //fDTB1-fDTB2;
   }};
    @Override
    public String toString() {
        return "[ Name=" + hoTen + ", ns=" + ngaySinh + ", dtb=" + getDiemTB() + ", loai=" + getXepLoai() + "]";
    }

}
