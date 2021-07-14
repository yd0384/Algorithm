
import java.util.Scanner;

public class Fac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int rs=1;
		for(int i=1;i<=n;i++)
		{
			rs*=i;
		}
		System.out.println(rs);
	}

}
