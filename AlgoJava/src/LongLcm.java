package joon;

import java.util.ArrayList;
import java.util.Scanner;

public class LongLcm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long m=0;
		ArrayList<Long> Lcm=new ArrayList<Long>();
			long a=sc.nextLong();
			long b=sc.nextLong();
			m=a*b;
			ArrayList<Long> d=new ArrayList<Long>();
			for(long j=a;j<=m;j+=a){
				if(j%a==0){
					d.add(j);
				}
			}
			for(long x:d){
				if(x%b==0){
					Lcm.add(x);
					break;
				}
			}
		for(long x:Lcm){
			System.out.println(x);
		}
	}

}
