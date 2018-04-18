package fasttrackse.edu.vn.quanlisinhvien;


import java.util.Scanner;

public class SinhVien {

	private String SVten;
	private String SVma;
	private String SVtuoi;
	private String SVlop;
	
	public SinhVien() {
		
	}
	public SinhVien(String SVma, String SVten, String SVtuoi, String SVlop) {
		this.SVma = SVma;
		this.SVten = SVten;
		this.SVtuoi = SVtuoi;
		this.SVlop = SVlop;
	}


	public String getSVten() {
		return SVten;
	}


	public void setSVten(String sVten) {
		SVten = sVten;
	}


	public String getSVma() {
		return SVma;
	}


	public void setSVma(String sVma) {
		SVma = sVma;
	}


	public String getSVtuoi() {
		return SVtuoi;
	}


	public void setSVtuoi(String sVtuoi) {
		SVtuoi = sVtuoi;
	}


	public String getSVlop() {
		return SVlop;
	}


	public void setSVlop(String sVlop) {
		SVlop = sVlop;
	}
	

}
