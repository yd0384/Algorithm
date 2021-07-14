package joon;

import java.util.ArrayList;
import java.util.Scanner;

public class Kakao2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		int[] arr = new int[n];
		ArrayList<Double> sds = new ArrayList<Double>();
		for(int i=0;i<n;i++)
		{
			arr[i]=sc.nextInt();
		}
		for(int i=k;i<=n;i++)
		{
			for(int j=0;j<=n-i;j++){
				ArrayList<Integer> tmp = new ArrayList<Integer>();
				for(int x=j;x<j+i;x++)
				{
					tmp.add(arr[x]);
				}
				sds.add(sd(tmp));
			}
		}
		double min = sds.get(0);
		for(double i:sds)
		{
			if(i<min)
				min=i;
		}
		System.out.println(min);
	}
	static double sd(ArrayList<Integer> arr)
	{
		double rs=0;
		double m=0;
		for(int i:arr)
		{
			m+=i;
		}
		m/=arr.size();
		for(int i:arr)
		{
			rs+=(i-m)*(i-m);
		}
		rs/=arr.size();
		return Math.sqrt(rs);
	}
}
