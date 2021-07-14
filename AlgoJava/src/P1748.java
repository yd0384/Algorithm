package joon;

import java.util.Scanner;

public class P1748 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum=0;
		int a=1;
		double b=10.0;
		for(int i=1;i<=n;i++){
			if(i/b==1){
				a++;
				b*=10;
			}
			sum+=a;
		}
		System.out.println(sum);
	}

}
