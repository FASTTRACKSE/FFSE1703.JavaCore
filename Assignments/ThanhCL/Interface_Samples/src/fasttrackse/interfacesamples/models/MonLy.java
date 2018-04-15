package fasttrackse.interfacesamples.models;

public class MonLy extends MonHoc {
	private double diemBaiTapLy;
	private double diemThucHanhLy;
	private double diemThiLy;
	
	public double getDiemBaiTapLy() {
		return diemBaiTapLy;
	}

	public void setDiemBaiTapLy(double diemBaiTapLy) {
		this.diemBaiTapLy = diemBaiTapLy;
	}

	public double getDiemThucHanhLy() {
		return diemThucHanhLy;
	}

	public void setDiemThucHanhLy(double diemThucHanhLy) {
		this.diemThucHanhLy = diemThucHanhLy;
	}

	public double getDiemThiLy() {
		return diemThiLy;
	}

	public void setDiemThiLy(double diemThiLy) {
		this.diemThiLy = diemThiLy;
	}

	public MonLy() {
		//
	}

	public MonLy(double diemBaiTapLy, double diemThucHanhLy, double diemThiLy) {
		this.diemBaiTapLy = diemBaiTapLy;
		this.diemThucHanhLy = diemThucHanhLy;
		this.diemThiLy = diemThiLy;
	}

	@Override
	public String mangSach() {
		return "Môn Lý";
	}

	@Override
	public double tinhDiemMonHoc() {
		return (this.diemBaiTapLy + this.diemThucHanhLy + this.diemThiLy) / 3;
	}

}
