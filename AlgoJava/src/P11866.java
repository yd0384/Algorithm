

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P11866 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		Queue<Integer> q = new LinkedList<Integer>();
		String st = "<";
		for(int i=1;i<=n;i++){
			q.offer(i);
		}
		for(int i=1;!q.isEmpty();i++){
			if(i==m){
				st+=q.poll()+", ";
				i=0;
			}
			else{
				q.offer(q.poll());
			}
		}
		int l=st.length();
		st = st.substring(0, l-2);
		st+=">";
		System.out.println(st);
	}

}
