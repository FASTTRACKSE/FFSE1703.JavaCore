package MyApp;

import java.util.ArrayList;

public class MyApp {
	public static void main(String[] args) {
		ArrayList<Integer> myInt = new ArrayList<Integer>();
		myInt.add(1);
		myInt.add(2);
		myInt.add(3);
		myInt.add(4);
		myInt.add(5);
		
		String[] hs1 = {"Cao Le Thanh"};
		
		System.out.println(hs1[0]);
		System.out.println(myInt.toString());
		
		System.out.println("Process Update Info");
		updateInfo(hs1, myInt);
		
		System.out.println(hs1[0]);
		System.out.println(myInt.toString());
	}

	public static void updateInfo(String[] hocSinh, ArrayList<Integer> theInt) {
		hocSinh[0] = "Nguyen Van A";
		theInt.set(0, 10);		
	}

}


