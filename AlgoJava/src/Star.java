package joon;

import java.util.Scanner;

public class Star {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		int x=n*2-1;
		char[] picture= new char[n*x];
		for(int i=0;i<n*x;i++){
			picture[i]=' ';
		}
		
		picture=draw1(picture,x,0,0);
		for(int i=n*x-1;i>=0;i--){
			if(i%x==x-1){
				System.out.println();
			}
			System.out.print(picture[i]);
		}
	}	
	public static char[] draw(char[] picture,int x,int xS,int yS){
		for(int i=0;i<5;i++){
			picture[yS*x+xS+i]='*';
		}
		picture[(yS+1)*x+xS+1]='*';
		picture[(yS+1)*x+xS+3]='*';
		picture[(yS+2)*x+xS+2]='*';
		return picture;
	}
	public static char[] draw1(char[] picture,int x,int xS,int yS){
		for(int i=0;i<4;i++){
			picture=draw(picture,x,xS+i*3,yS+i*3);
		}
		for(int i=2;i>=0;i--){
			picture=draw(picture,x,xS+12+3*(2-i),yS+i*3);
		}
		picture=draw(picture,x,xS+6,yS);
		picture=draw(picture,x,xS+12,yS);
		return picture;
	}
	
}