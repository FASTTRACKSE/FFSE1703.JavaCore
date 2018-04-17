package ass10.java.model;

import java.util.Scanner;
import java.io.Serializable;

public class SinhVien implements Serializable {
	public String txtName;
	public String txtDate;
	public String txtMaSV;
	public String txtLop;

	public SinhVien(String txtName, String txtDate, String txtMaSV, String txtLop) {
		this.txtName = txtName;
		this.txtDate = txtDate;
		this.txtMaSV = txtMaSV;
		this.txtLop = txtLop;

	}

	public String gettxtName() {
		return txtName;
	}

	public void settxtName(String txtName) {
		this.txtName = txtName;
	}

	public String gettxtDate() {
		return txtDate;
	}

	public void settxtDate(String txtDate) {
		this.txtDate = txtDate;
	}

	public String gettxtMaSV() {
		return txtMaSV;
	}

	public void settxtMaSV(String txtMaSV) {
		this.txtMaSV = txtMaSV;
	}

	public String gettxtLop() {
		return txtLop;
	}

	public void settxtLop(String txtLop) {
		this.txtLop = txtLop;
	}

}
