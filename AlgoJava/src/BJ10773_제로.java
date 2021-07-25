import java.util.Scanner;
import java.util.Stack;
public class BJ10773_제로 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		int x;
		Stack<Integer> st = new Stack<Integer>();
		for(int i=0;i<K;i++) {
			x=sc.nextInt();
			if(x==0)
				st.pop();
			else
				st.push(x);
		}
		int result=0;
		for(int i:st)
			result+=i;
		System.out.println(result);
		sc.close();
	}

}
