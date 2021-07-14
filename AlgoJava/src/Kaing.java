
import java.util.Scanner;

public class Kaing 
{
	static int gcd(int a, int b)
	{
		int c;
		while(b!=0)
		{
			c=a;
			a=b;
			b=c%a;
		}
		return a;
	}
	static int lcm(int a, int b)
	{
		int c = (a>=b)?gcd(a,b):gcd(b,a);
		return c*(a/c)*(b/c);
	}
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] res = new int[T];
		for(int i=0;i<T;i++)
		{
			int m=sc.nextInt();
			int n=sc.nextInt();
			int x=sc.nextInt();
			int y=sc.nextInt();
			int yp;
			int ans = x;
			boolean flag=false;
			while(ans<=lcm(m,n))
			{
				
				yp=(ans%n==0)?n:ans%n;
				if(yp==y)
				{
					res[i]=ans;
					flag=true;
					break;
				}
				ans+=m;
			}
			if(!flag)
			{
				res[i]=-1;
			}
		}
		for(int i:res)
		{
			System.out.println(i);
		}
	}
}
