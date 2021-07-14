package joon;

import java.util.Scanner;

public class Binary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		int[] n = new int[T];
		String[] rs = new String[T];
		for(int i=0;i<T;i++)
		{
			n[i]=sc.nextInt();
		}
		for(int i=0;i<T;i++)
		{
			rs[i]="";
			String s = "";
			while(n[i]!=0)
			{
				s+=Integer.toString(n[i]%2);
				n[i]/=2;
			}
			for(int j=0;j<s.length();j++)
			{
				if(s.charAt(j)=='1')
				{
					rs[i]+=j+" ";
				}
			}
		}
		for(String r:rs)
		{
			System.out.println(r.trim());
		}
		
	}

}
