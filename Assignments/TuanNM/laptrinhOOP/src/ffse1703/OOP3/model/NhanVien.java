package ffse1703.OOP3.model;

public class NhanVien {
  private int maSoNv;
  private String tenNv;
  private String namSinh;
  protected Double luong;
  public NhanVien() {
	  
  }
  public NhanVien(int maso,String ten,String namsinh,Double luong) {
	  this.maSoNv = maso;
	  this.tenNv = ten;
	  this.namSinh = namsinh;
	  this.luong = luong;
  }
  public void setMaSoNv(int maso) {
	  this.maSoNv = maso;
  }
  public int getMaSoNv() {
	  return this.maSoNv;
  }

  public void setTenNv(String ten) {
	  this.tenNv = ten;
  }
  public String getTenNv() {
	  return this.tenNv;
  }
  public void setNamSinh(String namsinh) {
	  this.namSinh = namsinh;
  }
  public String getNamSinh() {
	  return this.namSinh;
  }
  public void setLuong(Double luong) {
	  this.luong = luong;
  }
  public Double getLuong() {
	  return this.luong;
  }
  public Double getThueThuNhap() {
	  if( this.luong < 5000000) {
		  return 0.0;
	  }else {
		  return (this.luong - 5000000)*0.1;
	  }
  }
}
