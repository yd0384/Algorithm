
import java.util.Scanner;

public class CuttingLan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		int N = sc.nextInt();
		int[] len = new int[K];
		for(int i=0;i<K;i++)
		{
			len[i]=sc.nextInt();
		}
		int min = len[0];
		for(int i:len)
		{
			if(i<min)
				min=i;
		}
		
	}

}
