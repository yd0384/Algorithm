package joon;

import java.util.Scanner;

public class P11050 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int c = 1;
		if (k!=0){
			for(int i=n;i>n-k;i--){
				c*=i;
			}
			for(int i=k;i>1;i--){
				c/=i;
			}
		}
		System.out.println(c);
	}

}
