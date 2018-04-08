package Fasttrack.edu.vn.model;

public class SinhVien {
	public int maSv;
	public String tenSv;
	public int ngaysinhSv;
	public int diemLP1;
	public int diemLP2;
	public int diemTB;

	public SinhVien() {
		
	}

	public SinhVien(int maSv,String tenSv,int ngaysinhSv,int diemLP1,int diemLP2,int diemTB) {
		this.maSv=maSv;
		this.tenSv=tenSv;
		this.ngaysinhSv=ngaysinhSv;
		this.diemLP1=diemLP1;
		this.diemLP2=diemLP2;
		this.diemTB=diemTB;
	}

	public int getMaSv() {
		return maSv;
	}

	public void setMaSv(int maSv) {
		this.maSv = maSv;
	}

	public String getTenSv() {
		return tenSv;
	}

	public void setTenSv(String tenSv) {
		this.tenSv = tenSv;
	}

	public int getNgaysinhSv() {
		return ngaysinhSv;
	}

	public void setNgaysinhSv(int ngaysinhSv) {
		this.ngaysinhSv = ngaysinhSv;
	}

	public int getDiemLP1() {
		return diemLP1;
	}

	public void setDiemLP1(int diemLP1) {
		this.diemLP1 = diemLP1;
	}

	public int getDiemLP2() {
		return diemLP2;
	}

	public void setDiemLP2(int diemLP2) {
		this.diemLP2 = diemLP2;
	}

	public int getDiemTB() {
		return diemTB;
	}
	public void tinhDiemTB(int diemLP1,int diemLP2) {
		diemTB=(diemLP1+diemLP2)/2;
	}
	public void setDiemTB(int diemTB) {
		this.diemTB = diemTB;
	}
}
