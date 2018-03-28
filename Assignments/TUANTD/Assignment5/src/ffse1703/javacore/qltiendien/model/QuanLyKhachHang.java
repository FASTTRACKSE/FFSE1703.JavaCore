package ffse1703.javacore.qltiendien.model;
import java.util.ArrayList;
import java.util.Scanner;
public class QuanLyKhachHang {
	public static void main(String[] args) {
        int n;
        BienLai bienLai;
        Scanner scanner = new Scanner(System.in);
        ArrayList<BienLai> arrBienLai = new ArrayList<>();
         
        System.out.print("Nhập số hộ gia đình: ");
        n = scanner.nextInt();
         
        for (int i = 0; i < n; i++) {
            bienLai = new BienLai();
            System.out.println("Nhập thông tin biên lai của hộ gia đình thứ " + (i + 1) + ": ");
            bienLai.nhapBienLai();
            arrBienLai.add(bienLai);
        }
        System.out.println("<<=================???================>>");
        System.out.println("Thông tin biên lai của các hộ gia đình: ");
        System.out.println("<<====================================>>");
        for (int i = 0; i < arrBienLai.size(); i++) {
            System.out.println("Thông tin biên lai hộ gia đình thứ " + (i + 1) + ": ");
            arrBienLai.get(i).hienThiBienLai();
        }
    }
}
