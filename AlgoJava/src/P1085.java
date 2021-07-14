
import java.util.Scanner;

public class P1085 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x=sc.nextInt(),y=sc.nextInt(),w=sc.nextInt(),h=sc.nextInt();
		System.out.println(Math.min(Math.min(x, w-x),Math.min(y, h-y)));
	}

}
