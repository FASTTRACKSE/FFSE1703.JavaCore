package chuong;
import java.util.Scanner;
public class Bangcuuchuong {
	public static void main(String[] args) {
		Scanner myInput = new Scanner(System.in);
		
		System.out.print("nhập vào 1 số : ");
		int so1 = myInput.nextInt();
		
		  for (int i = 1; i < 11; i++ ) {
			  for (int j = 1; j <= so1; j++ ) {
				  int kq=j * i;
				  System.out.printf("%5d x %2d = %2d",j, i,kq );  
		      }
			  System.out.println();	 
			 
	      }
		 
		}
		}