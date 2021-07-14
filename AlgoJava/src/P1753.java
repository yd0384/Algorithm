

import java.util.ArrayList;
import java.util.Scanner;

public class P1753 {
	static int E;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int V=sc.nextInt();
		E=sc.nextInt();
		int K=sc.nextInt();
		int[][] way=new int[E][3];
		for(int i=0;i<E;++i){
			way[i][0]=sc.nextInt();
			way[i][1]=sc.nextInt();
			way[i][2]=sc.nextInt();
		}
		
			
	}
	public static int finding(int[][] way,int start,int end){
		int ret=0;
		for(int i=0;i<E;++i){
			if(way[i][0]==start){
				
			}
		}
		return ret;
	}
}
