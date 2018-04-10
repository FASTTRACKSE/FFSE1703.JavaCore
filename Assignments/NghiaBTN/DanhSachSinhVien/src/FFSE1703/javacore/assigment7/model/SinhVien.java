package FFSE1703.javacore.assigment7.model;
import java.util.Comparator;
public class SinhVien {
	private String HoTen;
	private String NgaySinh;
	private float DiemLp1;
	private float DiemLp2;
	public SinhVien() {
		
	}
	public SinhVien(String HoTen,String NgaySinh,float DiemLp1,float DiemLp2) {		
		this.HoTen=HoTen;
		this.NgaySinh=NgaySinh;
		this.DiemLp1=DiemLp1;
		this.DiemLp2=DiemLp2;		
	}
	public String getHoTen() {
		return HoTen;
	}
	public void setHoTen(String HoTen) {
		this.HoTen=HoTen;
	}
	public String getNgaySinh() {
		return NgaySinh;
	}
	public void setNgaySinh(String NgaySinh) {
		this.NgaySinh=NgaySinh;
	}
	public float getDiemLp1() {
		return DiemLp1;
	}
	public void setDiemLp1(float DiemLp1) {
		this.DiemLp1=DiemLp1;		
	}
	public float getDiemLp2() {
		return DiemLp2;
	}
	public void setDiemLp2(float DiemLp2) {
		this.DiemLp2=DiemLp2;
	}
	public float getDiemTB() {
		return ((getDiemLp1() + getDiemLp2())/2);
	}
	public String getXepLoai() {		 
    	if(getDiemTB()<=4.9) {
    		return "Yếu";}
    	else if(getDiemTB()>=5.0 && getDiemTB()<=6.9) {
    		return "Trung Bình";}
    	else if(getDiemTB()>=7 && getDiemTB()<=8.4) {
    		return "Khá";    	
    	}
    	else {
    		return "Giỏi";
    	}
    }
	public String toString() {
		return "  "+HoTen +"\t   "+NgaySinh+"\t \t"+DiemLp1+"\t \t"+DiemLp2+"\t \t"+getDiemTB()+"\t \t"+getXepLoai();
		
	}
	public static Comparator<SinhVien> compare = new Comparator<SinhVien>() {
        public int compare(SinhVien sv1, SinhVien sv2) {
            if (sv1.getDiemTB() > sv2.getDiemTB()) {
                return 1;
            } else {
                if (sv1.getDiemTB() == sv2.getDiemTB()) {
                    return 0;
                } else {
                    return -1;
                }
            }
        }
	};
	public static Comparator<SinhVien> compareName = new Comparator<SinhVien>() {
		 
		  @Override
		  public int compare(SinhVien sv1, SinhVien sv2) {		  
		    return sv1.HoTen.compareTo(sv2.HoTen);		   
		  }
		 };
  
}


