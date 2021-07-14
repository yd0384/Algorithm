package joon;

import java.util.Scanner;
import java.math.BigInteger;
public class P9461 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigInteger[] dp=new BigInteger[101];
		dp[1]=dp[2]=dp[3]=new BigInteger("1");
		for(int i=4;i<=100;i++){
			dp[i]=dp[i-2].add(dp[i-3]);
		}
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		String ans="";
		for(int i=0;i<t;i++){
			int n = sc.nextInt();
			ans+=dp[n]+"\n";
		}
		System.out.println(ans);
		
	}

}
