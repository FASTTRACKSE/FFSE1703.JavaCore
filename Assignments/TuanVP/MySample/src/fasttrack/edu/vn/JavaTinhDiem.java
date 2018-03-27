package fasttrack.edu.vn;

import java.io.*;

import java.lang.RuntimeException;

public class JavaTinhDiem {
    private String HoTen;
    //private String NgaySinh;
    //danh sach bang diem mon hoc cua hoc sinh
    private Diem []BangDiem;


    public JavaTinhDiem()throws Exception {
        nhapThongTin();
        XuatThongTin();
    }

    public void nhapThongTin() throws Exception{
        System.out.print("Ho Ten: ");
        BufferedReader _nhap=new BufferedReader(new InputStreamReader(System.in));
        HoTen=_nhap.readLine();
        //System.out.print("Ngay Sinh: ");
        //NgaySinh=_nhap.readLine();
        System.out.print("So Luong Mon Hoc: "); //Số lượng môn học phải nằm ở lớp Điểm chứ không thể ở đây
        int n= Integer.parseInt(_nhap.readLine());
        BangDiem= new Diem[n];
        //nhap diem cua tung mon hoc
        for(int i=0;i<n;++i){
            BangDiem[i]=new Diem();
            BangDiem[i].nhapDiem();
            System.out.println("");
        }
    }

    public void XuatThongTin(){
        System.out.println("Ho Ten: "+HoTen);
        //System.out.println("Ngay Sinh: "+NgaySinh);
        System.out.println("STT    Mon          Diem HK1     Diem HK2     Diem TB");
        for (int i = 0; i<BangDiem.length; i++){
            BangDiem[i].xuatDiem(i+1);
        };
        System.out.printf("Diem Trung Binh: %2.2f\n",DiemTBCaNam());
        System.out.println("Xep Loai: "+XepLoai());
    }

    public String XepLoai(){
        double DiemTBCaNam=0;
        if(DiemTBCaNam<5.0)
        return"yếu";
        else if(DiemTBCaNam>=5.0 && DiemTBCaNam<6.5)
        return"tb";
        else if(DiemTBCaNam>=6.5 &&DiemTBCaNam<7.5)
        return"khá";
        else if(DiemTBCaNam>=7.5 && DiemTBCaNam<8.5)
        return"xuất sắc";
        return null;
        }

    public double DiemTBCaNam(){
        double tong=0;
        for (int i = 0; i<BangDiem.length; i++){
            tong+=BangDiem[i].DiemTrungBinh();
        };
        return tong/BangDiem.length;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws Exception {
        JavaTinhDiem temp= new JavaTinhDiem();
    }
}
//Xay Dung Class Diem De quang ly bang diem cua tung hoc sinh
class Diem{
    private String TenMon;
    private double DiemHK1;
    private double DiemHK2;

    public Diem(String _ten, double _DiemHK1,double _DiemHK2){
        TenMon=_ten;
        DiemHK1=_DiemHK1;
        DiemHK2=_DiemHK2;
    }
    public Diem(){

    }

    public void nhapDiem() throws Exception{
        System.out.print("\tTen Mon: ");
        BufferedReader _nhap=new BufferedReader(new InputStreamReader(System.in));
        TenMon=_nhap.readLine();
        System.out.print("Diem Hoc Ki 1: ");
        DiemHK1=Double.parseDouble(_nhap.readLine());
        System.out.print("Diem Hoc Ki 2: ");
        DiemHK2=Double.parseDouble(_nhap.readLine());

    }
    public void xuatDiem(int i){
        //in theo dang Stt tenMon DiemHK1 DiemHK2 DiemTB
        System.out.printf("%3d    %-12s %-12.2f %-12.2f %2.2f \n",i,TenMon,DiemHK1,DiemHK2,DiemTrungBinh());
        //System.out.println(i+"    "+TenMon+"         "+DiemHK1+"         "+DiemHK2+"    "+DiemTrungBinh());
    }

    public double DiemTrungBinh(){
        return (DiemHK1+DiemHK2*2)/3;
    }
}
