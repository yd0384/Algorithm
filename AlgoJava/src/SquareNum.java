package joon;

import java.util.ArrayList;
import java.util.Scanner;

public class SquareNum 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int n,m;
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		int max=0;
		ArrayList<Integer> maxG=new ArrayList<Integer>();
		int[][] grid = new int[n][m];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				grid[i][j]=sc.nextInt();
				if(grid[i][j]>max)
				{
					max=grid[i][j];	
				}
			}
		}
		
	}

}
