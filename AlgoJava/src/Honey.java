

import java.util.Scanner;

public class Honey {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int k=1;
		int n=1;
		for(n=1;k<N;n++)
		{
			k+=n*6;
		}
		System.out.println(n);
	}

}
