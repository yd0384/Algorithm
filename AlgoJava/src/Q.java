
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Queue<Integer> q = new LinkedList<Integer>();
		String[] strs = new String[n];
		sc.nextLine();
		for(int i=0;i<n;i++)
		{
			strs[i]=sc.nextLine();
		}
		for(String i:strs)
		{
			switch(i.split(" ")[0])
			{
			case "push":
				q.offer(Integer.valueOf(i.split(" ")[1]));
				break;
			case "pop":
				if(q.isEmpty())
				{
					System.out.println(-1);
				}
				else
				{
					System.out.println(q.poll());	
				}
				break;
			case "size":
				System.out.println(q.size());
				break;
			case "empty":
				System.out.println((q.isEmpty())?1:0);
				break;
			case "front":
				if(q.isEmpty())
				{
					System.out.println(-1);
				}
				else
				{
					System.out.println(q.element());
				}
				break;
			case "back":
				if(q.isEmpty())
				{
					System.out.println(-1);
				}
				else
				{
					int rs = 0;
					for(int j:q)
					{
						rs=j;
					}
					System.out.println(rs);
				}
				break;
			}
			
			
		}
	}

}
