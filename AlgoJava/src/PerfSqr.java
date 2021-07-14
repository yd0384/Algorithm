package joon;

import java.util.ArrayList;
import java.util.Scanner;

public class PerfSqr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int m=sc.nextInt(),n=sc.nextInt();
		ArrayList<Integer> perf = new ArrayList<Integer>();
		for(int i=1;i<=100;i++)
		{
			perf.add(i*i);
		}
		int cnt=0;
		int sum=0;
		int min=0;
		for(int i:perf)
		{
			if(m<=i&&i<=n)
			{
				sum+=i;
				cnt++;
				if(cnt==1)
				{
					min=i;
				}
			}
		}
		if(cnt==0)
		{
			System.out.println(-1);
		}
		else
			System.out.println(sum+"\n"+min);
	}

}
