import java.util.Scanner;

public class AlphaCentauri {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		int d[] = new int[T];
		for(int i=0;i<T;i++)
		{
			int x=sc.nextInt();
			int y=sc.nextInt();
			d[i]=y-x;
			
		}
		sc.close();
	}

}
