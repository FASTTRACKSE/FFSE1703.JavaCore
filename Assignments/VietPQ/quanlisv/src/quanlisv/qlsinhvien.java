package quanlisv;

public class qlsinhvien {
	private String tensv;
	private String nssv;
	private double LP1;
	private double LP2;
	private double LP3;
	static int tongsv = 0;

	public int getTongsv() {
		return tongsv;
	}

	static void setTongsv() {
		tongsv++;
	}

	public qlsinhvien(String tensv, String nssv, double LP1, double LP2, double LP3) {
		super();
		this.tensv = tensv;
		this.nssv = nssv;
		this.LP1 = LP1;
		this.LP2 = LP2;
		this.LP3 = LP3;

	}

	public String getTensv() {
		return tensv;
	}

	public void setTensv(String tensv) {
		this.tensv = tensv;
	}

	public String getNssv() {
		return nssv;
	}

	public void setNssv(String nssv) {
		this.nssv = nssv;
	}

	public double getLP1() {
		return LP1;
	}

	public void setLP1(double lP1) {
		LP1 = lP1;
	}

	public double getLP2() {
		return LP2;
	}

	public void setLP2(double lP2) {
		LP2 = lP2;
	}

	public double getLP3() {
		return LP3;
	}

	public void setLP3(double lP3) {
		LP3 = lP3;
	}

	public float getDiemtb() {
		return (float) ((getLP1() + getLP2() + getLP3()) / 3);
	}

	public String getXepLoai() {
		if (getDiemtb() <= 4.9) {
			return "Yeu";
		} else if (getDiemtb() >= 5.0 && getDiemtb() <= 6.9) {
			return "Trung Binh";
		} else if (getDiemtb() >= 7 && getDiemtb() <= 8) {
			return "Kha";
		} else {
			return "Gioi";
		}
	}
}