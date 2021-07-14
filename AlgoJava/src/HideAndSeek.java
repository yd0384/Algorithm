
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HideAndSeek {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n=sc.nextInt();
		int k=sc.nextInt();
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(n);
		if(n==k)
		{
			System.out.println(0);
		}
		else if(n>k)
		{
			System.out.println(n-k);
		}
		else
		{	
		int l=0;
		while(n!=k)
		{
			n=q.poll();
			q.offer(n-1);
			q.offer(n+1);
			q.offer(2*n);
		l++;
		}
		int level=0;
		int d=1;
		int cnt=0;
		while(level<l)
		{
			level+=d;
			d*=3;
			cnt++;
		}
		
		System.out.println(cnt-1);
		}
	}
}
