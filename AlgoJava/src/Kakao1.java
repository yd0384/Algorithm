package joon;

import java.util.Scanner;

public class Kakao1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		int[] rs = new int[t];
		for(int i=0;i<t;i++)
		{
			rs[i]=prize2017(sc.nextInt())+prize2018(sc.nextInt());
		}
		for(int i:rs)
		{
			System.out.println(i);
		}
	}
	static int prize2017(int ranking)
	{
		int order = 1;
		int prize=0;
		if(ranking==0)
		{
			return 0;
		}
		if(ranking<=1)
		{
			order =1;
		}
		else if (ranking<=3)
			order =2;
		else if(ranking<=6)
			order=3;
		else if(ranking<=10)
			order=4;
		else if(ranking<=15)
			order=5;
		else if(ranking<=21)
			order=6;
		else
			order= 7;
		switch(order)
		{
		case 1: 
			prize = 5000000;
			break;
		
		case 2: 
			prize = 3000000;
			break;
		case 3:
			prize = 2000000;
			break;
		case 4:
			prize = 500000;
			break;
		case 5:
			prize = 300000;
			break;
		case 6:
			prize = 100000;
			break;
		default:
			prize =0;
			break;
		}
		return prize;
		
	}
	static int prize2018(int ranking)
	{
		int prize=0;
		if (ranking == 0)
			return 0;
		else if(ranking<=1)
		{
			prize = 5120000;
		}
		else if (ranking<=3)
			prize=2560000;
		else if(ranking<=7)
			prize=1280000;
		else if(ranking<=15)
			prize=640000;
		else if(ranking<=31)
			prize=320000;
		return prize;
	}

}
