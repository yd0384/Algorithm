package joon;

import java.util.Scanner;

public class Tiling1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int rs=0;
		int[] dp = new int[1001];
		dp[1]=1;
		dp[2]=2;
		for(int i=3;i<=1000;i++)
		{
			dp[i]=(dp[i-1]+dp[i-2])%10007;
		}
		System.out.println(dp[n]);
	}
}
