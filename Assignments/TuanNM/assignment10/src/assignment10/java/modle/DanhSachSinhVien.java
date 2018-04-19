package assignment10.java.modle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

 public class DanhSachSinhVien implements ActionListener{
	private ArrayList<ModleSinhVien> dsSinhVien;
	public DanhSachSinhVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public boolean creatSV(ModleSinhVien sv) {
		if(!dsSinhVien.contains(sv)) {
			return dsSinhVien.add(sv);
		}else {
			return false;
		}
	}
	public ArrayList<ModleSinhVien> getDsSinhVien() {
		return dsSinhVien;
	}
	public int totalSV() {
		return dsSinhVien.size();
	}
	public boolean xoaSV(int index) {
		if(index >0 && index <dsSinhVien.size()-1 ) {
			dsSinhVien.remove(index);
			return true;
		}else {
			return false;
		}
	}
	public boolean editSV(String maSV,String nameSV,String age,String lop) {
		ModleSinhVien sv = new ModleSinhVien(maSV,nameSV,age,lop);
		if(!dsSinhVien.contains(sv)) {
			sv.setMaSV(maSV);
			sv.setNameSv(nameSV);
			sv.setAge(age);
			return true;
		}else {
			return false;
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
 
 
}
