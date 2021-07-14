package joon;

import java.util.Scanner;

public class P2293 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		int[] coin=new int[n];
		for(int i=0;i<n;i++){
			coin[i]=sc.nextInt();
		}
		int[] dp=new int[k+1];
		for(int i=0;i<n;i++){
			if(coin[i]>k){
				continue;
			}
			dp[coin[i]]+=1;
			for(int j=coin[i];j<=k;j++){
				dp[j]=dp[j]+dp[j-coin[i]];
			}
		}
		System.out.println(dp[k]);
	}

}
