package joon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FindingMin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n =  sc.nextInt();
		int l = sc.nextInt();
		int[] num=new int[n+1];
		for(int i=1;i<n+1;i++)
		{
			num[i]=sc.nextInt();
		}
		int[] mins = new int[n];
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=1;i<=n;i++)
		{
			if(i-l+1<=1)
			{
				q.offer(num[i]);
			}
			else
			{
				q.offer(num[i]);
				q.poll();
			}
			int min = 5000001;
			for(int j:q)
			{
				if(min>j)
					min=j;
			}
			mins[i-1]=min;
		}
		for(int d:mins)
		{
			System.out.print(d+" ");
		}
	}

}
