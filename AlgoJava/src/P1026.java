package joon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Comparator;

public class P1026 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int rs=0;
		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		for(int i=0;i<n;i++){
			a.add(sc.nextInt());
		}
		for(int i=0;i<n;i++){
			b.add(sc.nextInt());
		}
		Collections.sort(a);
		Collections.sort(b);
		for(int i=0;i<n;i++){
			rs+=a.get(i)*b.get(n-i-1);
		}
		System.out.println(rs);
	}
}
