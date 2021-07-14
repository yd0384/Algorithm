package joon;

import java.util.Scanner;

public class Rgb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] costs=new int[n][3];
		for(int i=0;i<n;i++){
			for(int j=0;j<3;j++){
				costs[i][j]=sc.nextInt();
			}
		}
		for(int i=1;i<n;i++){
			costs[i][0]+=Math.min(costs[i-1][1],costs[i-1][2]);
			costs[i][1]+=Math.min(costs[i-1][0],costs[i-1][2]);
			costs[i][2]+=Math.min(costs[i-1][0],costs[i-1][1]);
		}
		System.out.println(Math.min(costs[n-1][0],Math.min(costs[n-1][1], costs[n-1][2])));
	}

}
