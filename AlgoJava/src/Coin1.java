package joon;

import java.util.ArrayList;
import java.util.Scanner;

public class Coin1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		ArrayList<Integer> coins=new ArrayList<Integer>();
		for(int i=0;i<n;i++){
			coins.add(sc.nextInt());
		}
	}
}
