package Fasttrack.edu.vn.test;

public class quanly extends nhanvien{
	private int luong_trachnhiem=0;
	public quanly() {
		super();
	}
	public quanly(int maso_nhanvien,String ten_nhanvien,int namsinh_nhanvien,int luong_nhanvien,int luong_trachnhiem) { 
		super(maso_nhanvien,ten_nhanvien,namsinh_nhanvien,luong_nhanvien);
	}
	public int luong_trach_nhiem() {
		this.luong_trachnhiem=luong_trachnhiem;
		return this.luong_trachnhiem;
	}

}