 package sv;
import java.io.IOException;
import java.util.*;
public class test {
    String Maso;
    String Hoten;
    float DiemTB;
    String Xeploai;
    int n;
    test()
            {   
                 Maso="PD510";
                 Hoten="";
            }
   
    public test[] k=new test[100];
        
   public String Nhapxau() throws IOException
   {  String xau=""; 
    Scanner sc=new Scanner(System.in);
     try
     {
      xau=sc.nextLine();
                 }catch(Exception e)
     {
      System.out.println("Error!"+e.getMessage());
     }
     return xau;
   }
   public void NhapDS()
   {   
            try{
    System.out.print(" Ma so:=");
    Maso+=Nhapxau();      
                do
                {
                    System.out.print("Ho ten sinh vien:=");
                    Hoten=Nhapxau();
                    if (Hoten.equals("")) System.out.print("Khong the de trong Ho Ten!\n");
                }
                while(Hoten.equals(""));
    System.out.print("Diem TB:=");
    DiemTB=Float.parseFloat(Nhapxau());
    System.out.print("Xep loai:=");
    Xeploai=Nhapxau();
             }catch(IOException e){System.out.println("Lỗi do: \n"+e.getMessage());}
   }
   public void  NhapN()
   {   try{
   System.out.print(" Nhap vao so luong sinh vien:");
    n=Integer.parseInt(Nhapxau());
   for(int i=0;i<n;i++)
   {
    k[i]= new test();
    System.out.println("Nhap vao thong tin cua sinh vien thu:"+(i+1)+" ");
       k[i].NhapDS();
   }
               }catch(Exception e){System.out.println("Lỗi do: \n"+e.getMessage());}

   }
   public void HienThi()
   {   try{
                  System.out.print("\nDanh sach Sinh vien:\n");    
                  for( int i=0;i<n;i++)
     k[i].hienthi();
               }catch(Exception e){System.out.println("Lỗi do: \n"+e.getMessage());}
         }
        public void hienthi()
   {       
    System.out.println("+  "+Maso+"  |  "+Hoten+"  |  "+DiemTB+"  |  "+Xeploai);
    System.out.println("+--------------------------------------------+\n");              
         }
 public void sapxep()
 {      try{
                test tg=new test();

   for(int i=0;i<n-1;i++)
    for(int j=i+1;j<n;j++)                     
   {         
    if (Integer.parseInt(k[i].Maso.trim().substring(5))>=Integer.parseInt(k[j].Maso.trim().substring(5)))
    {
     tg=k[i];
     k[i]=k[j];
     k[j]=tg;
    }
                       
   }
   System.out.println("\n+--------------------------------------------+");
   System.out.println("+------THONG TIN SINH VIEN DA SAP XEP--------+");
                System.out.println("+--------------------------------------------+");
   HienThi();
           }catch(Exception e){System.out.println("Lỗi do: \n"+e.getMessage());}
     
 }
        public void kha()
        {   try{
                int dem=0;
                for(int i=0;i<n;i++) 
                 if (k[i].Xeploai.trim().equalsIgnoreCase("k")|k[i].Xeploai.trim().equalsIgnoreCase("kha")) dem++;
                System.out.println("So sinh vien xep loai kha: "+dem);
               }catch(Exception e){System.out.println("Lỗi do: \n"+e.getMessage());}
        }
        public void tb()
        {   try{
                    int max=0;
                    for(int i=0;i<n;i++)
                    if (k[max].DiemTB<k[i].DiemTB) max=i;
                    System.out.print("Sinh vien co diem TB lon nhat la: \n");k[max].hienthi();
               }catch(Exception e){System.out.println("Lỗi do: "+e.getMessage());}
        }
    public static void main(String[] args) {
       
       int choice;
    try{
       test k=new test();
        while(true)
        {
               
                Scanner sc =new Scanner(System.in);
                System.out.println("\n\t+-------------- QUAN LY SINH VIEN ");
                System.out.print("\t+------------ 1. Nhap Sinh Vien tu dau   ");
                System.out.println("\t+------------ 4. Dem so SV xep loai kha      ");
                System.out.print("\t+------------ 2. Hien thi DSSV                 ");
                System.out.println("\t+------------ 5. In SV co DiemTB cao nhat    ");
                System.out.print("\t+------------ 3. Sap xep theo Masv tang dan");
                System.out.println("\t+------------ 0. Thoat        ");
                System.out.print("\t#Chon:1,2,3,4,5 or 0 :");
                
                choice=sc.nextInt();
                System.out.println("");
                switch(choice)
                {case 1:
                        k.NhapN();
                        break;
                    case 2:
                        k.HienThi();
                        break;
                    case 3:
                        k.sapxep();
                             
                        break;
                    case 4:
                        k.kha();
                        break;
                    case 5:
                        k.tb();
                        break;                        
                     case 0:
                          
                         System.exit(0);
                        break;
                }    
        }
      }catch(Exception e){System.out.println("Lỗi do: \n"+e.getMessage());}
    }
 }
