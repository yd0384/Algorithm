package joon;

import java.util.Scanner;

public class P10804 {

	public static int[] reverse(int[] cards, int[] range){
		if(range[0]==range[1]){
			return cards;
		}
		int[] ret = cards.clone();
		int k=0;
		for(int i=range[0]-1;i<range[1];++i,++k){
			ret[i]=cards[range[1]-1-k];
		}
		return ret;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new  Scanner(System.in);
		int[] cards = new int[20];
		for(int i=1;i<=20;++i){
			cards[i-1]=i;
		}
		for(int i=0;i<10;++i){
			int[] range = {sc.nextInt(),sc.nextInt()};
			cards=reverse(cards, range);
		}
		String ans="";
		for(int i:cards){
			ans+=String.valueOf(i)+" ";
		}
		System.out.print(ans.substring(0,ans.length()-1));
	}

}
