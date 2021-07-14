
import java.util.Scanner;

public class Apart 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int kmax=14,nmax=14;
		int[][] apt = new int[15][15];
		for(int i=1;i<=14;i++)
		{
			apt[0][i]=i;
		}
		for(int a=1;a<=kmax;a++)
		{
			for(int b=1;b<=nmax;b++)
			{
				if(b==1)
				{
					apt[a][1]=1;
				}
				else
				{
					apt[a][b]=apt[a][b-1]+apt[a-1][b];
				}
			}
		}
		int t = sc.nextInt();
		int[] ans = new int[t];
		for(int i=0;i<t;i++)
		{
			int n=sc.nextInt();
			int k=sc.nextInt();
			ans[i]=apt[n][k];
		}
		for(int i:ans)
		{
			System.out.println(i);
		}
	}
}
