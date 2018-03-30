package ffse1703.OOP3.model;

public class QuanLy extends NhanVien{
	private Double luongTrachNhiem;

	
	public QuanLy() {
		
	}
	public QuanLy(Double luongTrachNhiem) {
		super();
		this.luongTrachNhiem = luongTrachNhiem;
	}
	public void setLuongTn(Double luongtn) {
		this.luongTrachNhiem = luongtn;
	}
	public Double getLuongTn() {
		return this.luongTrachNhiem;
	}
	@Override
	
	public Double getThueThuNhap() {

			  if( (this.luong +this.luongTrachNhiem) < 5000000) {
				  return 0.0;
			  }else {
				  return ((this.luong +this.luongTrachNhiem) - 5000000)*0.1;
			  }
		  
	}
	
}



