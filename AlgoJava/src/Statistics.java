package joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Statistics {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] nums = new int[n];
		for(int i=0;i<n;i++)
		{
			nums[i]=Integer.parseInt(br.readLine());
		}
		int sum=0;
		int[] count = new int[8001];
		for(int i:nums)
		{
			count[i+4000]++;
			sum+=i;
		}
		int mean = (int) Math.round(sum/(double)n);
		int midN = n/2+1;
		int tmp=0;
		int mid=0;
		
		for(int i=0;i<8001;i++)
		{
			if(count[i]>0)
			{
				tmp+=count[i];
			}
			if(tmp>=midN)
			{
				mid=i-4000;
				break;
			}
		}
		int max=0;
		int most=-4001;
		for(int i=0;i<8001;i++)
		{
			if(count[i]>max)
			{
				max=count[i];
				most=i-4000;
			}
		}
		boolean fir = false;
		for(int i=0;i<8001;i++)
		{
			if(!fir&&count[i]==max)
			{
				fir=true;
			}
			else if(fir&&count[i]==max)
			{
				most=i-4000;
				break;
			}
		}
		int f=99999,l=99999;
		fir=true;
		for(int i=0;i<8001;i++)
		{
			if(fir&&count[i]!=0)
			{
				f=i-4000;
				fir=false;
				l=i-4000;
			}
			else if(!fir&&count[i]!=0)
			{
				l=i-4000;
			}
		}
		int ran=l-f;
		sb.append(""+mean+"\n"+mid+"\n"+most+"\n"+ran+"\n");
		System.out.println(sb);
	
	}

}
