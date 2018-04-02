package ffse1703.javacore.qltiendien.model;

import java.util.ArrayList;
import java.util.Scanner;

public class BienLai extends KhachHang {

	private Double chiSoCu;
	private Double chiSoMoi;
	private int thang, nam, tieuThu;

	public BienLai() {

	}

	public BienLai(String maKhachHang, String tenKhachHang, String soNha, String maCongTo, Double chiSoCu,
			Double chiSoMoi, int thang, int nam) {
		super(maKhachHang, tenKhachHang, soNha, maCongTo);
		this.chiSoCu = chiSoCu;
		this.chiSoMoi = chiSoMoi;
		this.thang = thang;
		this.nam = nam;
	}

	public int getThang() {
		return thang;
	}

	public void setThang(int thang) {
		this.thang = thang;
	}

	public int getNam() {
		return nam;
	}

	public void setNam(int nam) {
		this.nam = nam;
	}

	public Double getChiSoCu() {
		return chiSoCu;
	}

	public void setChiSoCu(Double chiSoCu) {
		this.chiSoCu = chiSoCu;
	}

	public Double getChiSoMoi() {
		return chiSoMoi;
	}

	public void setChiSoMoi(Double chiSoMoi) {
		this.chiSoMoi = chiSoMoi;
	}

	public Double getTienDien() {
		if (tieuThu <= 100)

			return (chiSoMoi - chiSoCu) * 1000;

		else

		{

			if (tieuThu <= 150)

				return (chiSoMoi - chiSoCu) * 1200;

			else

			{

				if (tieuThu <= 200)

					return (chiSoMoi - chiSoCu) * 2000;

				else

				{

					if (tieuThu >= 201)

						return (chiSoMoi - chiSoCu) * 2500;

				}
			}
		}
		return (chiSoMoi - chiSoCu) * 3000;
	}
}