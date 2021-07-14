package joon;

import java.util.Scanner;

public class Sdocu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] str = new String[9];
		int[][] nums = new int[9][9];
		for(int i=0;i<9;i++)
			str[i] = sc.nextLine();
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<9;j++)
			{
				nums[i][j]=Integer.valueOf(str[i].split(" ")[j]);
			}
		}
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<9;j++)
			{
				System.out.print(nums[i][j]+" ");
			}
			
			System.out.println();
		}
	}

}
