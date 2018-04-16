package fasttrackse.interfacesamples.models;

import fasttrackse.interfacesamples.interfaces.DiemMonHoc;

public abstract class MonHoc implements DiemMonHoc {
	public abstract String mangSach();
	
	public String xepLoaiMonHoc() {
		double diem = tinhDiemMonHoc();
		String temp;
		if (diem < 5) {
			temp = "D";
		} else if (diem < 7) {
			temp = "C";
		} else if (diem < 8.5) {
			temp = "B";
		} else {
			temp = "A";
		}
		return temp;
	}
}