package joon;

import java.util.Scanner;
public class Zigzag {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		int i=1,j=1;
		int n=1;
		boolean flag=true;
		while(n!=X)
		{
			if(i==1&&j==1)
			{
				j++;
			}
			else if(flag)
			{
				if(j==1)
				{
					i++;
					flag=false;
				}
				else
				{
					i++;
					j--;
				}
			}
			else if(!flag)
			{
				if(i==1)
				{
					j++;
					flag=true;
				}
				else
				{
					i--;
					j++;
				}
			}
			n++;
			
		}
		System.out.println(i+"/"+j);
	}

}
