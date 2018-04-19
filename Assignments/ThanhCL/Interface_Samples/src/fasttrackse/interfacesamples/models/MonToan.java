package fasttrackse.interfacesamples.models;

public class MonToan extends MonHoc {
	private double diemToanGiaiTich;
	private double diemToanCaoCap;

	public double getDiemToanGiaiTich() {
		return diemToanGiaiTich;
	}

	public void setDiemToanGiaiTich(double diemToanGiaiTich) {
		this.diemToanGiaiTich = diemToanGiaiTich;
	}

	public double getDiemToanCaoCap() {
		return diemToanCaoCap;
	}

	public void setDiemToanCaoCap(double diemToanCaoCap) {
		this.diemToanCaoCap = diemToanCaoCap;
	}

	public MonToan() {
		//
	}

	public MonToan(double diemToanGiaiTich, double diemToanCaoCap) {
		this.diemToanGiaiTich = diemToanGiaiTich;
		this.diemToanCaoCap = diemToanCaoCap;
	}

	@Override
	public String mangSach() {
		return "Môn Toán";
	}

	@Override
	public double tinhDiemMonHoc() {
		return (this.diemToanCaoCap + this.diemToanGiaiTich) / 2;
	}
}