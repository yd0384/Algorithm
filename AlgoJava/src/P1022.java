package joon;

import java.util.Scanner;

public class P1022 {
	public static void main(String[] args){
		
		int i=5000;
		int j=5000;
		int n=1;
		int x=1;
		char dir='r';
		Scanner sc = new Scanner(System.in);
		int r1=sc.nextInt();
		int c1=sc.nextInt();
		int r2=sc.nextInt();
		int c2=sc.nextInt();
		int[][] arr=new int[r2-r1+1][c2-c1+1];
		int maxlen=0;
		while(true){
			if(i>10000||j>10000||i<0||j<0)
			{
				break;
			}
			switch(dir){
			case 'r':
				for(int a=0;(a<x)&&!(i>10000||j>10000||i<0||j<0);a++,n++,j++){
					if(r1+5000<=i && r2+5000>=i && c1+5000<=j && c2+5000>=j)
					arr[i-r1-5000][j-c1-5000]=n;
				}
				dir=chD(dir);
				break;
			case 'u':
				for(int a=0;(a<x)&&!(i>10000||j>10000||i<0||j<0);a++,n++,i--){
					if(r1+5000<=i && r2+5000>=i && c1+5000<=j && c2+5000>=j)
					arr[i-r1-5000][j-c1-5000]=n;
				}
				x++;
				dir=chD(dir);
				break;
			case 'l':
				for(int a=0;(a<x)&&!(i>10000||j>10000||i<0||j<0);a++,n++,j--){
					if(r1+5000<=i && r2+5000>=i && c1+5000<=j && c2+5000>=j)
					arr[i-r1-5000][j-c1-5000]=n;
				}
				dir=chD(dir);
				break;
			case 'd':
				for(int a=0;(a<x)&&!(i>10000||j>10000||i<0||j<0);a++,n++,i++){
					if(r1+5000<=i && r2+5000>=i && c1+5000<=j && c2+5000>=j)
					arr[i-r1-5000][j-c1-5000]=n;
				}
				x++;
				dir=chD(dir);
				break;
			}
			
		}
		
		for(int r=0;r<=r2-r1;r++){
			for(int c=0;c<=c2-c1;c++){
				maxlen=Math.max(Integer.toString(arr[r][c]).length(),maxlen);
			}
		}
		String format = "%"+Integer.toString(maxlen)+"d ";
		for(int r=0;r<=r2-r1;r++){
			for(int c=0;c<=c2-c1;c++){
				System.out.printf(format,arr[r][c]);
			}
			System.out.println();
		}
	}
	static char chD(char dir){
		switch(dir){
		case 'r':
			return 'u';
		case 'u':
			return 'l';
		case 'l':
			return 'd';
		case 'd':
			return 'r';
		}
		return ' ';
	}
	
}
