
import java.util.Scanner;

public class P10800 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] balls = new int[N][2];
		int[][] cache = new int[2001][N+1];
		int[] sums = new int[2001];
		int sum=0;
		for(int n=0;n<N;++n){
			int[] input = {sc.nextInt(), sc.nextInt()};
			balls[n]=input;
		}
		for(int i=1;i<=2000;++i)
		{
			sum=0;
			for(int j=0;j<N;++j)
			{
				if(balls[j][1]==i){
					cache[i][balls[j][0]]+=i;
					sum+=i;
				}
			}
			sums[i]=sum;
		}
		for(int i=0;i<N;++i)
		{
			sum=0;
			for(int j=1;j<balls[i][1];++j)
			{
				sum+=sums[j]-cache[j][balls[i][0]];
			}
			System.out.println(sum);
		}
	}

}
