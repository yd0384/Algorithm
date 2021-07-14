package joon;

import java.util.Scanner;

public class P11399 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int[] p = new int[n];
		int[] sortedP=new int[n];
		for(int i=0;i<n;++i){
			p[i]=sc.nextInt();
		}
		int min=1001,mi=0;
		for(int i=0;i<n;++i){
			min=1001;
			for(int j=0;j<n;++j){
				if(p[j]<min){
					min=p[j];
					mi=j;
				}
			}
			sortedP[i]=min;
			p[mi]=1001;
		}
		int sum=0,accusum=0;
		for(int i:sortedP){
			accusum+=i;
			sum+=accusum;
		}
		System.out.println(sum);
		
	}

}
