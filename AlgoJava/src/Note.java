package joon;

import java.util.Scanner;

public class Note {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] note=new int [8];
		for(int i=0;i<8;i++){
			note[i]=sc.nextInt();
		}
		boolean[] check=new boolean[8];
		for(int i=0;i<8;i++){
		check[i]=false;	
		}
		for(int i=0;i<8;i++){
			if(note[i]==i+1){
				check[i]=true;
			}
			else{
				check[i]=false;
			}
		}
		int c=0;
		for(int i=0;i<8;i++){
			if(check[i]){
				c++;
			}
		}
		if(c==8){
			System.out.println("ascending");
			return;
		}
		for(int i=0;i<8;i++){
			if(note[i]==8-i){
				check[i]=true;
			}
			else{
				check[i]=false;
			}
		}
		c=0;
		for(int i=0;i<8;i++){
			if(check[i]){
				c++;
			}
		}
		if(c==8){
			System.out.println("descending");
			return;
		}
		System.out.println("mixed");
	}

}
