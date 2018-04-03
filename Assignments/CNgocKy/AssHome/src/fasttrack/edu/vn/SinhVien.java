package fasttrack.edu.vn;

import java.util.Scanner;

public class SinhVien {
	private String hoTen;
	private String ngaySinh;
	private Double lp1, lp2, dTB;
    public static int soluong = 0;
    public static Scanner myScanner = new Scanner(System.in);




	public SinhVien(String hoTen, String ngaySinh, Double lp1, Double lp2, Double dTB) {
		super();
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.lp1 = lp1;
		this.lp2 = lp2;
		this.dTB = dTB;
	}
	public SinhVien() {
		// TODO Auto-generated constructor stub
	}
	public void Input() {
		myScanner.nextLine();
		System.out.print("Nhập tên Sinh Viên :");
		this.hoTen = myScanner.nextLine();

		System.out.print("Nhập ngày sinh của Sinh Viên :");
		this.ngaySinh = myScanner.nextLine();

		System.out.print("Nhập điểm môn LP1 :");
		this.lp1 = myScanner.nextDouble();

		System.out.print("Nhập điểm môn LP2 :");
		this.lp2 = myScanner.nextDouble();

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

	public Double getLp1() {
		return lp1;
	}

	public void setLp1(Double lp1) {
		this.lp1 = lp1;
	}

	public Double getLp2() {
		return lp2;
	}

	public void setLp2(Double lp2) {
		this.lp2 = lp2;
	}

	public Double getdTB() {
		return ((getLp1()+getLp2()) / 2.0);
	}
	public String getXepLoai() {		 
    	if(getdTB()<=4.9) {
    		return "Yếu";}
    	else if(getdTB()>=5.0 ) {
    		return "Trung Bình";}
    	else if(getdTB() <= 7.0) {
    		return "Khá";}
    	else {
    		return "Giỏi";
    	}
	}






	}

