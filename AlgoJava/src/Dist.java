package joon;

import java.util.Scanner;

public class Dist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		int[] a=new int[t];
		int[] b=new int[t];
		for(int i=0;i<t;i++){
			a[i]=sc.nextInt();
			b[i]=sc.nextInt();
		}
		int[] n=new int[t];
		int s=0;
		for(int i=0;i<t;i++){
			s=a[i];
			for(int j=1;j<b[i];j++){
				s=(s%10*a[i])%10;
			}
			n[i]=s%10;
		}
		for(int i=0;i<t;i++){
			if(n[i]==0){
				System.out.println(10);
			}
			else
			System.out.println(n[i]);
		}
	}
}
