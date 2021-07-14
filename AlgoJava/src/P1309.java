package joon;

import java.util.Scanner;

public class P1309 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int i0=1,i1=1,i2=1;
		int ret=i0+i1+i2;
		for(int i=1;i<n;i++){
			i0*=3;
			i1*=2;
			i2*=2;
			ret=(i0+i1+i2)%9901;
		}
		System.out.println(ret);
	}
	
}
