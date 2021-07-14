

import java.util.Scanner;

public class RoomAssign {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int start[] = new int[n];
		int end[] = new int[n];
		for(int i=0;i<n;i++)
		{
			start[i]=sc.nextInt();
			end[i]=sc.nextInt();
		}
	}

}
