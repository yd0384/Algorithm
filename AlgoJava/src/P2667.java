package joon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class P2667 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> cnt = new ArrayList<Integer>();
		int[][] danji = new int[n][n];
		for(int i=0;i<n;i++){
			String line = sc.next();
			for(int j=0;j<n;j++){
				if(line.charAt(j)=='0'){
					danji[i][j]=0;
				}
				else{
					danji[i][j]=1;
				}
			}
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(danji[i][j]==1){
					int tmp = find(danji,i,j,n);
					if(tmp==0){
						cnt.add(1);
					}
					else{
						cnt.add(tmp);
					}
				}
			}
		}
		System.out.println(cnt.size());
		Collections.sort(cnt);
		for(int i:cnt){
			System.out.println(i);
		}
	}
	static int find(int[][] arr,int x,int y,int n){
		int tmp=0;
		if(x!=0){
			if(arr[x-1][y]==1){
				arr[x-1][y]+=2;
				tmp++;
				tmp=find(arr,x-1,y,n)+tmp;
			}
		}
		if(y!=0){
			if(arr[x][y-1]==1){
				arr[x][y-1]+=2;
				tmp++;
				tmp=find(arr,x,y-1,n)+tmp;
			}
		}
		if(x!=n-1){
			if(arr[x+1][y]==1){
				arr[x+1][y]+=2;
				tmp++;
				tmp=find(arr,x+1,y,n)+tmp;
			}
		}
		if(y!=n-1){
			if(arr[x][y+1]==1){
				arr[x][y+1]+=2;
				tmp++;
				tmp=find(arr,x,y+1,n)+tmp;
			}
		}
		return tmp;
	}

}
