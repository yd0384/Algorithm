package joon;

import java.util.Scanner;

public class Sosu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		boolean[] sosu = new boolean[10001];
		sosu[1]=true;
		for(int i=2;i<10001;i++){
			for(int j=2;i*j<10001;j++){
				sosu[i*j]=true;
			}
		}
		int ans[][]= new int[n][2];
		for(int i=0;i<n;i++){
			int a=sc.nextInt();
			for(int j=a/2;j>0;j--){
				if(!sosu[j]&&!sosu[a-j]){
					ans[i][0]=j;
					ans[i][1]=a-j;
					break;
				}
			}
		}
		for(int[] a:ans){
			System.out.println(a[0]+" "+a[1]);
		}
	}

}
