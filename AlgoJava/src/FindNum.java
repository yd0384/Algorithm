package joon;

import java.util.ArrayList;
import java.util.Scanner;

public class FindNum 
{

	public static void main(String[] args) 
	{	
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arrN = new int[n];
		for(int i=0;i<n;i++)
		{
			arrN[i]=sc.nextInt();
		}
		int m = sc.nextInt();
		int[] arrM = new int[m];
		for(int i=0;i<m;i++)
		{
			arrM[i]=sc.nextInt();
		}
		for(int i=0;i<n;i++)
		{
			int min=arrN[0];
			for(int j=i+1;j<n;j++)
			{
				if(arrN[j]<min)
				{
					min = arrN[j];
				}
			}
		
		}
	}
	
	
	
}
