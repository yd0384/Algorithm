package joon;

import java.util.Scanner;

public class Distributed {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		int[][] ans=new int[t][3];
		for(int i=0;i<t;i++){
			ans[i][0]=sc.nextInt();
			ans[i][1]=sc.nextInt();
		}
		for(int i=0;i<t;i++){
			ans[i][0]%=10;
			if(ans[i][0]==0){
				ans[i][0]=10;
			}
		}
		for(int i=0;i<t;i++){
			switch(ans[i][0]){
				case 1:ans[i][2]=1;
				break;
				case 2:
					switch(ans[i][1]%4){
					case 0:
						ans[i][2]=6;
						break;
					case 1:
						ans[i][2]=2;
						break;
					case 2:
						ans[i][2]=4;
						break;
					case 3:
						ans[i][2]=8;
						break;
					}
					break;
				case 3:
					switch(ans[i][1]%4){
					case 0:
						ans[i][2]=1;
						break;
					case 1:
						ans[i][2]=3;
						break;
					case 2:
						ans[i][2]=9;
						break;
					case 3:
						ans[i][2]=7;
						break;
					}
					break;
				case 4:
					switch(ans[i][1]%2){
					case 0:
						ans[i][2]=6;
						break;
					case 1:
						ans[i][2]=4;
						break;
					}
					break;
				case 5:
					switch(ans[i][1]%2){
					case 0:
						ans[i][2]=10;
						break;
					case 1:
						ans[i][2]=5;
						break;
					}
					break;
				case 6:
					ans[i][2]=6;
					break;
				case 7:
					switch(ans[i][1]%4){
					case 0:
						ans[i][2]=1;
						break;
					case 1:
						ans[i][2]=7;
						break;
					case 2:
						ans[i][2]=9;
						break;
					case 3:
						ans[i][2]=3;
						break;
					}
					break;
				case 8:
					switch(ans[i][1]%4){
					case 0:
						ans[i][2]=6;
						break;
					case 1:
						ans[i][2]=8;
						break;
					case 2:
						ans[i][2]=4;
						break;
					case 3:
						ans[i][2]=2;
						break;
					}
					break;
				case 9:
					switch(ans[i][1]%2){
					case 0:
						ans[i][2]=1;
						break;
					case 1:
						ans[i][2]=9;
						break;
					}
					break;
				case 10:
					ans[i][2]=10;
					break;
				
			}
		}
		for(int i=0;i<t;i++){
			System.out.println(ans[i][2]);
		}
	}

}
