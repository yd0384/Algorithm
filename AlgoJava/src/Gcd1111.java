package joon;

import java.util.Scanner;

public class Gcd1111 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		long a=sc.nextLong();
		long b=sc.nextLong();
		long m=(a>b)?a:b;
		long n=(a<b)?a:b;
		if(m%n==0){
			for(long i=0;i<n;i++){
				System.out.print(1);
			}
		}else{
			System.out.println(1);
	
		}
	}

}
